package scoremanager;

import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ScoreUpdateExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        String studentNo = req.getParameter("studentNo");
        String subjectCd = req.getParameter("subjectCd");
        int point = Integer.parseInt(req.getParameter("point"));

        TestDAO dao = new TestDAO();
        dao.updatePoint(studentNo, subjectCd, point);

        req.getRequestDispatcher("/score/score_update_done.jsp").forward(req, res);
    }
}
