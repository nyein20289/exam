package scoremanager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

<<<<<<< HEAD
/*
 * 成績変更アクションクラス
 *
 * 成績変更画面を表示する
 */
=======
>>>>>>> 8bf4539d044c9820a18188f4422f475280194553
public class ScoreUpdateAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

<<<<<<< HEAD
        // リクエストパラメーターの取得
        String studentNo = req.getParameter("studentNo");
        String subjectCd = req.getParameter("subjectCd");

        // レスポンス値をセット
        req.setAttribute("studentNo", studentNo != null ? studentNo : "");
        req.setAttribute("subjectCd", subjectCd != null ? subjectCd : "");

        // JSPへフォワード
        req.getRequestDispatcher("/scoremanager/main/score_update.jsp").forward(req, res);
=======
        req.getRequestDispatcher("/score/score_update.jsp").forward(req, res);
>>>>>>> 8bf4539d044c9820a18188f4422f475280194553
    }
}
