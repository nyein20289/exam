package scoremanager.main;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // セッションからログインユーザー取得
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        // Dao
        SubjectDao subjectDao = new SubjectDao();

        // ログイン中の先生の学校の科目一覧を取得
        List<Subject> subjects = subjectDao.filter(teacher.getSchool());

        // JSP に渡す
        req.setAttribute("subjects", subjects);

        // 一覧画面へフォワード
        req.getRequestDispatcher("subject_list.jsp").forward(req, res);
    }
}
