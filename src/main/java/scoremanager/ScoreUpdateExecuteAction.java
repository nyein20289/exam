package scoremanager;

import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

/*
 * 成績変更実行アクションクラス
 *
 * 成績変更を実行する
 */
public class ScoreUpdateExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        // ローカル変数の指定 1
        String studentNo = req.getParameter("studentNo");
        String subjectCd = req.getParameter("subjectCd");
        int point = Integer.parseInt(req.getParameter("point"));

        // ビジネスロジック 4
        // 点数更新
        TestDAO testDAO = new TestDAO();
        testDAO.updatePoint(studentNo, subjectCd, point);

        // JSPへフォワード 7
        req.getRequestDispatcher("/scoremanager/main/score_update_done.jsp").forward(req, res);
    }
}
