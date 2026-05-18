package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String cd = req.getParameter("cd");
        String name = req.getParameter("name");

        SubjectDao dao = new SubjectDao();
        Map<String, String> errors = new HashMap<>();

        // 科目が存在するか確認
        Subject subject = dao.get(cd, teacher.getSchool());
        if (subject == null) {
            errors.put("1", "科目は存在していません");
        }

        // 科目名チェック
        if (name == null || name.isEmpty()) {
            errors.put("2", "科目名を入力してください");
        }

        // エラーがある場合
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("cd", cd);
            req.setAttribute("name", name);
            req.getRequestDispatcher("subject_update.jsp").forward(req, res);
            return;
        }

        // 更新処理
        subject.setName(name);
        dao.save(subject);

        req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
    }
}
