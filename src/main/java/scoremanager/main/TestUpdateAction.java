package scoremanager.main;

import bean.Teacher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

        // ローカル変数の指定 1
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        // リクエストパラメーターの取得 2
        String studentNo = req.getParameter("studentNo");
        String subjectCd = req.getParameter("subjectCd");

        // DBからデータ取得 3
        // なし

        // ビジネスロジック 4
        // なし

        // レスポンス値をセット 6
        req.setAttribute("studentNo", studentNo != null ? studentNo : "");
        req.setAttribute("subjectCd", subjectCd != null ? subjectCd : "");

        // JSPへフォワード 7
        req.getRequestDispatcher("score_update.jsp").forward(req, res);
    }
}
