package bean;

/*
 * Testクラス
 *
 * TESTテーブルの情報を保存するBeanクラス
 */

/*
 * Testクラス
 *
 * TESTテーブルの情報を保存するBeanクラス
 */
public class Test {

    // 学生番号
    private String studentNo;

    // 科目コード
    private String subjectCd;

    // 学校コード
    private String schoolCd;

    // 回数（1回目・2回目など）
    private int no;

    // 点数
    private int point;

    // クラス番号
    private String classNum;

    /*
     * 学生番号を取得
     */
    public String getStudentNo() {
        return studentNo;
    }

    /*
     * 学生番号を設定
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    /*
     * 科目コードを取得
     */
    public String getSubjectCd() {
        return subjectCd;
    }

    /*
     * 科目コードを設定
     */
    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    /*
     * 学校コードを取得
     */
    public String getSchoolCd() {
        return schoolCd;
    }

    /*
     * 学校コードを設定
     */
    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }

    /*
     * テスト回数を取得
     */
    public int getNo() {
        return no;
    }

    /*
     * テスト回数を設定
     */
    public void setNo(int no) {
        this.no = no;
    }

    /*
     * 点数を取得
     */
    public int getPoint() {
        return point;
    }

    /*
     * 点数を設定
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /*
     * クラス番号を取得
     */
    public String getClassNum() {
        return classNum;
    }

    /*
     * クラス番号を設定
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}