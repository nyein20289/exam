package scoremanager.main;

import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

/*
 * 成績変更実行アクションクラス
 *
 * 成績変更を実行する
 */
public class TestUpdateExecuteAction extends Action {

    @Override
    public void execute(
            HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        // ローカル変数の指定 1
        String studentNo = "";  // 学生番号
        String subjectCd = "";  // 科目コード
        int point = 0;          // 点数

        // リクエストパラメーターの取得 2
        studentNo = req.getParameter("studentNo");
        subjectCd = req.getParameter("subjectCd");
        point = Integer.parseInt(req.getParameter("point"));

        // DBからデータ取得 3
        // なし

        // ビジネスロジック 4
        // 点数更新
        TestDAO testDAO = new TestDAO();
        testDAO.updatePoint(studentNo, subjectCd, point);

        // レスポンス値をセット 6
        // なし

        // JSPへフォワード 7
        req.getRequestDispatcher("score_update_done.jsp").forward(req, res);
    }
}
