package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentScoreList;
import tool.DAO;

/*
 * StudentScoreListDAOクラス
 *
 * 学生別成績一覧を取得するDAOクラス
 *
 * STUDENT
 * TEST
 * SUBJECT
 * テーブルを結合して使用する
 */
public class StudentScoreListDAO extends DAO {

    /*
     * 学生番号から成績一覧を取得
     */
    public List<StudentScoreList> filter(String studentNo)
            throws Exception {

        // 成績一覧保存用List
        List<StudentScoreList> list =
                new ArrayList<>();

        // DB接続
        Connection con = getConnection();

        // 学生別成績一覧取得SQL
        String sql =
            "SELECT " +
            "  s.NO, " +
            "  s.NAME, " +
            "  sub.NAME AS SUBJECT_NAME, " +
            "  t.POINT " +
            "FROM STUDENT s " +

            // TESTテーブル結合
            "INNER JOIN TEST t " +
            "ON s.NO = t.STUDENT_NO " +

            // SUBJECTテーブル結合
            "INNER JOIN SUBJECT sub " +
            "  ON t.SUBJECT_CD = sub.CD " +
            "  AND t.SCHOOL_CD = sub.SCHOOL_CD " +

            // 学生番号検索
            "WHERE s.NO = ?";

        PreparedStatement st =
                con.prepareStatement(sql);

        // ?へ学生番号を設定
        st.setString(1, studentNo);

        // SQL実行
        ResultSet rs = st.executeQuery();

        // 検索結果を1件ずつ取得
        while (rs.next()) {

            // Bean生成
            StudentScoreList bean =
                    new StudentScoreList();

            // DBデータをBeanへ設定
            bean.setStudentNo(
                    rs.getString("NO"));

            bean.setStudentName(
                    rs.getString("NAME"));

            bean.setSubjectName(
                    rs.getString("SUBJECT_NAME"));

            bean.setPoint(
                    rs.getInt("POINT"));

            // Listへ追加
            list.add(bean);
        }

        // 接続終了
        st.close();
        con.close();

        return list;
    }
}