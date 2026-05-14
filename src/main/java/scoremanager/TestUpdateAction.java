package scoremanager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

/*
 * 成績変更アクションクラス
 *
 * 成績変更画面を表示する
 */
public class TestUpdateAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        // リクエストパラメーターの取得
        String studentNo = req.getParameter("studentNo");
        String subjectCd = req.getParameter("subjectCd");

        // レスポンス値をセット
        req.setAttribute("studentNo", studentNo != null ? studentNo : "");
        req.setAttribute("subjectCd", subjectCd != null ? subjectCd : "");

        // JSPへフォワード
        req.getRequestDispatcher("/scoremanager/main/score_update.jsp").forward(req, res);
    }
}
