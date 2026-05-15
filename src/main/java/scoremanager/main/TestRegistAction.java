// TestRegistAction.java

package score;

import java.io.IOException;

import bean.Score;
import dao.ScoreDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestRegistAction extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // パラメータ取得
            String studentNo =
                request.getParameter("studentNo");

            String subjectCd =
                request.getParameter("subjectCd");

            int point =
                Integer.parseInt(
                    request.getParameter("point"));

            // Bean作成
            Score score = new Score();

            score.setStudentNo(studentNo);
            score.setSubjectCd(subjectCd);
            score.setPoint(point);

            // DAO実行
            ScoreDao dao = new ScoreDao();

            dao.save(score);

            // 完了画面へ
            response.sendRedirect("test_list.jsp");

        } catch (Exception e) {

            throw new ServletException(e);
        }
    }
}