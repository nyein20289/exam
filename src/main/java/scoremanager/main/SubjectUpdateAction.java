package scoremanager.main;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String cd = req.getParameter("cd");

        SubjectDao dao = new SubjectDao();
        Subject subject = dao.get(cd, teacher.getSchool());

        // 科目が存在しない場合
        if (subject == null) {
            req.setAttribute("error", "科目は存在していません");
            req.setAttribute("cd", cd);
            req.getRequestDispatcher("subject_update.jsp").forward(req, res);
            return;
        }

        // 科目が存在する場合
        req.setAttribute("cd", subject.getCd());
        req.setAttribute("name", subject.getName());

        req.getRequestDispatcher("subject_update.jsp").forward(req, res);
    }
}
