package scoremanager;

import java.util.List;

import bean.StudentScoreList;
import dao.StudentScoreListDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ScoreListAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        String studentNo = req.getParameter("studentNo");
        StudentScoreListDAO dao = new StudentScoreListDAO();
        List<StudentScoreList> list = dao.filter(studentNo);
        req.setAttribute("list", list);
        req.setAttribute("studentNo", studentNo);
        req.getRequestDispatcher("/score/score_list.jsp").forward(req, res);
    }
}
