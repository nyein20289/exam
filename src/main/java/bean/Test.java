package bean;



public class Test   {

    private Student student;   // 生徒
    private String classNum;   // クラス番号
    private Subject subject;   // 科目
    private School school;     // 学校
    private int no;            // 回数
    private int point;
	/**
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student セットする student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return classNum
	 */
	public String getClassNum() {
		return classNum;
	}
	/**
	 * @param classNum セットする classNum
	 */
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	/**
	 * @return subject
	 */
	public Subject getSubject() {
		return subject;
	}
	/**
	 * @param subject セットする subject
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	/**
	 * @return school
	 */
	public School getSchool() {
		return school;
	}
	/**
	 * @param school セットする school
	 */
	public void setSchool(School school) {
		this.school = school;
	}
	/**
	 * @return no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no セットする no
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return point
	 */
	public int getPoint() {
		return point;
	}
	/**
	 * @param point セットする point
	 */
	public void setPoint(int point) {
		this.point = point;
	}         // 点数

}
