package bean;

/*
 * StudentScoreListクラス
 *
 * 学生別成績一覧画面で使用するBeanクラス
 *
 * 学生情報 + 科目情報 + 点数を保存する
 */

/*
 * StudentScoreListクラス
 *
 * 学生別成績一覧画面で使用するBeanクラス
 *
 * 学生情報 + 科目情報 + 点数を保存する
 */
public class StudentScoreList {

    // 学生番号
    private String studentNo;

    // 学生名
    private String studentName;

    // 科目名
    private String subjectName;

    // 点数
    private int point;

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
     * 学生名を取得
     */
    public String getStudentName() {
        return studentName;
    }

    /*
     * 学生名を設定
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /*
     * 科目名を取得
     */
    public String getSubjectName() {
        return subjectName;
    }

    /*
     * 科目名を設定
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
}