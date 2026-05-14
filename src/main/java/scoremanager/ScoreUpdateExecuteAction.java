package scoremanager;

import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

<<<<<<< HEAD
/*
 * 成績変更実行アクションクラス
 *
 * 成績変更を実行する
 */
=======
>>>>>>> 8bf4539d044c9820a18188f4422f475280194553
public class ScoreUpdateExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

<<<<<<< HEAD
        // ローカル変数の指定 1
=======
>>>>>>> 8bf4539d044c9820a18188f4422f475280194553
        String studentNo = req.getParameter("studentNo");
        String subjectCd = req.getParameter("subjectCd");
        int point = Integer.parseInt(req.getParameter("point"));

<<<<<<< HEAD
        // ビジネスロジック 4
        // 点数更新
        TestDAO testDAO = new TestDAO();
        testDAO.updatePoint(studentNo, subjectCd, point);

        // JSPへフォワード 7
        req.getRequestDispatcher("/scoremanager/main/score_update_done.jsp").forward(req, res);
=======
        TestDAO dao = new TestDAO();
        dao.updatePoint(studentNo, subjectCd, point);

        req.getRequestDispatcher("/score/score_update_done.jsp").forward(req, res);
>>>>>>> 8bf4539d044c9820a18188f4422f475280194553
    }
}
