package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;
 
public class TestDao extends Dao {
 
	private String baseSql = "select * from test where school_cd=? ";
 
	/**

	 * getメソッド 学生・科目・回数を指定してテスト情報を1件取得する

	 *

	 * @param student:Student

	 * @param subject:Subject

	 * @param school:School

	 * @param no:int

	 * @return テストクラスのインスタンス 存在しない場合はnull

	 * @throws Exception

	 */

	public Test get(Student student, Subject subject, School school, int no) throws Exception {
 
		// テストインスタンスを初期化

		Test test = new Test();
 
		// コネクションを確立

		Connection connection = getConnection();
 
		// プリペアードステートメント

		PreparedStatement statement = null;
 
		try {
 
			// プリペアードステートメントにSQL文をセット

			statement = connection.prepareStatement(

				baseSql + "and student_no=? and subject_cd=? and no=?"

			);
 
			// 値をバインド

			statement.setString(1, school.getCd());

			statement.setString(2, student.getNo());

			statement.setString(3, subject.getCd());

			statement.setInt(4, no);
 
			// プリペアードステートメントを実行

			ResultSet rSet = statement.executeQuery();
 
			if (rSet.next()) {
 
				// テストインスタンスに検索結果をセット

				test.setStudent(student);

				test.setSubject(subject);

				test.setSchool(school);

				test.setClassNum(rSet.getString("class_num"));

				test.setNo(rSet.getInt("no"));

				test.setPoint(rSet.getInt("point"));
 
			} else {
 
				// リザルトセットが存在しない場合

				test = null;

			}
 
		} catch (Exception e) {

			throw e;
 
		} finally {
 
			// プリペアードステートメントを閉じる

			if (statement != null) {

				try {

					statement.close();

				} catch (SQLException sqle) {

					throw sqle;

				}

			}
 
			// コネクションを閉じる

			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException sqle) {

					throw sqle;

				}

			}

		}
 
		return test;

	}
 
	/**

	 * filterメソッド 条件に一致するテスト一覧を取得する

	 *

	 * @param classNum:String

	 * @param subject:Subject

	 * @param no:int

	 * @param school:School

	 * @return テスト一覧

	 * @throws Exception

	 */

	public List<Test> filter(

			String classNum,

			Subject subject,

			int no,

			School school) throws Exception {
 
		// リストを初期化

		List<Test> list = new ArrayList<>();
 
		// コネクションを確立

		Connection connection = getConnection();
 
		// プリペアードステートメント

		PreparedStatement statement = null;
 
		// リザルトセット

		ResultSet rSet = null;
 
		// SQL文の条件

		String condition = "and class_num=? and subject_cd=? and no=?";
 
		// SQL文のソート

		String order = " order by student_no asc";
 
		try {
 
			// プリペアードステートメントにSQL文をセット

			statement = connection.prepareStatement(

				baseSql + condition + order

			);
 
			// 値をバインド

			statement.setString(1, school.getCd());

			statement.setString(2, classNum);

			statement.setString(3, subject.getCd());

			statement.setInt(4, no);
 
			// プリペアードステートメントを実行

			rSet = statement.executeQuery();
 
			// StudentDaoを初期化

			StudentDao studentDao = new StudentDao();
 
			// リザルトセットを全件走査

			while (rSet.next()) {
 
				// テストインスタンスを初期化

				Test test = new Test();
 
				// 検索結果をセット

				test.setStudent(studentDao.get(rSet.getString("student_no")));

				test.setSubject(subject);

				test.setSchool(school);

				test.setClassNum(rSet.getString("class_num"));

				test.setNo(rSet.getInt("no"));

				test.setPoint(rSet.getInt("point"));
 
				// リストに追加

				list.add(test);

			}
 
		} catch (Exception e) {

			throw e;
 
		} finally {
 
			// プリペアードステートメントを閉じる

			if (statement != null) {

				try {

					statement.close();

				} catch (SQLException sqle) {

					throw sqle;

				}

			}
 
			// コネクションを閉じる

			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException sqle) {

					throw sqle;

				}

			}

		}
 
		return list;

	}
 
	/**

	 * saveメソッド テスト情報を保存する

	 *

	 * @param test:Test

	 * @return 保存成功:true 保存失敗:false

	 * @throws Exception

	 */

	public boolean save(Test test) throws Exception {
 
		// コネクションを確立

		Connection connection = getConnection();
 
		// プリペアードステートメント

		PreparedStatement statement = null;
 
		// 実行件数

		int count = 0;
 
		try {
 
			// データベースからテストを取得

			Test old = get(

				test.getStudent(),

				test.getSubject(),

				test.getSchool(),

				test.getNo()

			);
 
			if (old == null) {
 
				// テストが存在しなかった場合

				// INSERT文をセット

				statement = connection.prepareStatement(

					"insert into test(student_no,subject_cd,school_cd,no,point,class_num) values(?,?,?,?,?,?)"

				);
 
				// 値をバインド

				statement.setString(1, test.getStudent().getNo());

				statement.setString(2, test.getSubject().getCd());

				statement.setString(3, test.getSchool().getCd());

				statement.setInt(4, test.getNo());

				statement.setInt(5, test.getPoint());

				statement.setString(6, test.getClassNum());
 
			} else {
 
				// テストが存在した場合

				// UPDATE文をセット

				statement = connection.prepareStatement(

					"update test set point=? where student_no=? and subject_cd=? and school_cd=? and no=?"

				);
 
				// 値をバインド

				statement.setInt(1, test.getPoint());

				statement.setString(2, test.getStudent().getNo());

				statement.setString(3, test.getSubject().getCd());

				statement.setString(4, test.getSchool().getCd());

				statement.setInt(5, test.getNo());

			}
 
			// プリペアードステートメントを実行

			count = statement.executeUpdate();
 
		} catch (Exception e) {

			throw e;
 
		} finally {
 
			// プリペアードステートメントを閉じる

			if (statement != null) {

				try {

					statement.close();

				} catch (SQLException sqle) {

					throw sqle;

				}

			}
 
			// コネクションを閉じる

			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException sqle) {

					throw sqle;

				}

			}

		}
 
		if (count > 0) {
 
			// 実行件数が1件以上ある場合

			return true;
 
		} else {
 
			// 実行件数が0件の場合

			return false;

		}

	}

}
 