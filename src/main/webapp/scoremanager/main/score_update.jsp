<%-- 成績変更JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">
    <c:param name="title">
        得点管理システム
    </c:param>

    <c:param name="scripts"></c:param>

    <c:param name="content">
        <section>
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績変更</h2>

            <form action="ScoreUpdateExecute.action" method="post">

                <div class="mb-3 px-4">
                    <label for="studentNo" class="form-label">学生番号</label>
                    <input
                        class="form-control"
                        type="text"
                        id="studentNo"
                        name="studentNo"
                        value="${studentNo}"
                        required />
                </div>

                <div class="mb-3 px-4">
                    <label for="subjectCd" class="form-label">科目コード</label>
                    <input
                        class="form-control"
                        type="text"
                        id="subjectCd"
                        name="subjectCd"
                        value="${subjectCd}"
                        required />
                </div>

                <div class="mb-3 px-4">
                    <label for="point" class="form-label">点数</label>
                    <input
                        class="form-control"
                        type="number"
                        id="point"
                        name="point"
                        min="0"
                        max="100"
                        required />
                </div>

                <div class="px-4">
                    <button class="btn btn-secondary" type="submit">更新</button>
                </div>

            </form>

            <div class="mt-3 px-4">
                <a href="StudentList.action">学生一覧へ戻る</a>
            </div>

        </section>
    </c:param>
</c:import>
