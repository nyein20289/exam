package scoremanager;

import java.util.List;

import bean.Student;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentListAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        StudentDao dao = new StudentDao();
        List<Student> list = dao.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/student/student_list.jsp").forward(req, res);
    }
}
