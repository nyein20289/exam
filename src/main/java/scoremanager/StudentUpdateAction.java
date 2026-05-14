package scoremanager;

import bean.Student;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentUpdateAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        String no = req.getParameter("no");
        StudentDao dao = new StudentDao();
        Student student = dao.findByNo(no);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/student/student_update.jsp").forward(req, res);
    }
}
