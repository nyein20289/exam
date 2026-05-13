package scoremanager;

import bean.Student;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        String no = req.getParameter("no");
        String name = req.getParameter("name");
        String classNum = req.getParameter("classNum");

        Student s = new Student();
        s.setNo(no);
        s.setName(name);
        s.setClassNum(classNum);

        StudentDao dao = new StudentDao();
        dao.update(s);

        req.getRequestDispatcher("/student/student_update_done.jsp").forward(req, res);
    }
}
