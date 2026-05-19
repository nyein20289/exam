package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        // セッション取得
        HttpSession session =
                req.getSession();

        // ログインユーザー取得
        Teacher teacher =
                (Teacher) session.getAttribute("user");

        // ログインチェック
        if (teacher == null) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/scoremanager/main/login.jsp");

            return;
        }

        // DAO
        ClassNumDao classNumDao =
                new ClassNumDao();

        SubjectDao subjectDao =
                new SubjectDao();

        StudentDao studentDao =
                new StudentDao();

        TestDAO testDao =
                new TestDAO();

        // プルダウン用
        List<String> classList =
                classNumDao.filter(
                        teacher.getSchool());

        List<Subject> subjectList =
                subjectDao.filter(
                        teacher.getSchool());

        req.setAttribute(
                "classList",
                classList);

        req.setAttribute(
                "subjectList",
                subjectList);

        // パラメータ取得
        String entYearStr =
                req.getParameter("entYear");

        String classNum =
                req.getParameter("classNum");

        String subjectCd =
                req.getParameter("subjectCd");

        String noStr =
                req.getParameter("no");

        // --------------------
        // 検索処理
        // --------------------
        if (entYearStr != null
                && !entYearStr.equals("")
                && classNum != null
                && !classNum.equals("")) {

            int entYear =
                    Integer.parseInt(entYearStr);

            // 学生一覧取得
            List<Student> studentList =
                    studentDao.filter(
                            teacher.getSchool(),
                            entYear,
                            classNum,
                            true);

            // JSPへ渡す
            req.setAttribute(
                    "students",
                    studentList);
        }

        // --------------------
        // 登録処理
        // --------------------
        String[] studentNoList =
                req.getParameterValues("studentNo");

        String[] pointList =
                req.getParameterValues("point");

        if (studentNoList != null
                && pointList != null) {

            List<String> errors =
                    new ArrayList<>();

            for (int i = 0; i < studentNoList.length; i++) {

                String studentNo =
                        studentNoList[i];

                String pointStr =
                        pointList[i];

                // 空欄チェック
                if (pointStr == null
                        || pointStr.equals("")) {

                    continue;
                }

                int point =
                        Integer.parseInt(pointStr);

                // 0～100チェック
                if (point < 0 || point > 100) {

                    errors.add(
                            "0～100の範囲で入力してください");

                    continue;
                }

                // 更新
                testDao.updatePoint(
                        studentNo,
                        subjectCd,
                        point);
            }

            // エラー表示
            req.setAttribute(
                    "errors",
                    errors);

            // 完了メッセージ
            if (errors.size() == 0) {

                req.setAttribute(
                        "message",
                        "登録が完了しました");
            }
        }

        // JSPへ
        req.getRequestDispatcher(
                "test_regist.jsp")
                .forward(req, res);
    }
}