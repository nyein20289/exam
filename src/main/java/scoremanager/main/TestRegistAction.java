package scoremanager.main;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistAction extends Action {

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
                (Teacher)session.getAttribute("user");

        // null対策
        if (teacher == null) {

            res.sendRedirect(
                req.getContextPath()
                + "/scoremanager/main/login.jsp");

            return;
        }

        // DAO生成
        ClassNumDao classNumDao =
                new ClassNumDao();

        SubjectDao subjectDao =
                new SubjectDao();

        // クラス一覧取得
        List<String> classList =
                classNumDao.filter(
                    teacher.getSchool());

        // 科目一覧取得
        List<Subject> subjectList =
                subjectDao.filter(
                    teacher.getSchool());

        // requestへ保存
        req.setAttribute(
                "classList",
                classList);

        req.setAttribute(
                "subjectList",
                subjectList);

        // JSPへ
        req.getRequestDispatcher(
                "test_regist.jsp")
                .forward(req, res);
    }
}