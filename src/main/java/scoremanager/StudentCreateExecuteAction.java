package scoremanager;

import bean.Student;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentCreateExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        String no = req.getParameter("no");
        String name = req.getParameter("name");
        int entYear = Integer.parseInt(req.getParameter("entYear"));
        String classNum = req.getParameter("classNum");

        Student s = new Student();
        s.setNo(no);
        s.setName(name);
        s.setEntYear(entYear);
        s.setClassNum(classNum);

        StudentDao dao = new StudentDao();
        dao.insert(s);

        req.getRequestDispatcher("/student/student_create_done.jsp").forward(req, res);
    }
}
