package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tool.DAO;

/*
 * TestDAOクラス
 *
 * TESTテーブルへアクセスするDAOクラス
 *
 * 主な処理：
 * ・点数更新
 */
public class TestDAO extends DAO {

    /*
     * 学生の点数を更新
     */
    public void updatePoint(
            String studentNo,
            String subjectCd,
            int point)
            throws Exception {

        // DB接続
        Connection con = getConnection();

        // 点数更新SQL
        String sql =
            "UPDATE TEST " +
            "SET POINT = ? " +
            "WHERE STUDENT_NO = ? " +
            "AND SUBJECT_CD = ?";

        PreparedStatement st =
                con.prepareStatement(sql);

        // SQLへ値を設定
        st.setInt(1, point);
        st.setString(2, studentNo);
        st.setString(3, subjectCd);

        // UPDATE実行
        st.executeUpdate();

        // 接続終了
        st.close();
        con.close();
    }
}