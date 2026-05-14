package bean;

/*
 * Subjectクラス
 *
 * SUBJECTテーブルの情報を保存するBeanクラス
 */

/*
 * Subjectクラス
 *
 * SUBJECTテーブルの情報を保存するBeanクラス
 */
public class Subject {

    // 学校コード
    private String schoolCd;

    // 科目コード
    private String cd;

    // 科目名
    private String name;

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
     * 科目コードを取得
     */
    public String getCd() {
        return cd;
    }

    /*
     * 科目コードを設定
     */
    public void setCd(String cd) {
        this.cd = cd;
    }

    /*
     * 科目名を取得
     */
    public String getName() {
        return name;
    }

    /*
     * 科目名を設定
     */
    public void setName(String name) {
        this.name = name;
    }
}