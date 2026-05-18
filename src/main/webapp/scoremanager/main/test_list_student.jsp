<%-- 成績参照JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">

    <%-- タイトル --%>
    <c:param name="title">
        得点管理システム
    </c:param>

    <%-- script --%>
    <c:param name="scripts"></c:param>

    <%-- メインコンテンツ --%>
    <c:param name="content">

        <section class="me-4">

            <%-- 見出し --%>
            <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">
                成績一覧（学生）
            </h2>

            <%-- 検索フォーム --%>
            <form method="get" action="TestListStudent.action">

                <div class="row border mx-3 mb-3 py-3 align-items-end rounded">

                    <%-- 入学年度 --%>
                    <div class="col-3">
                    <label class="form-label">科目情報</label>
                        <label class="form-label">入学年度</label>

                        <select class="form-select" name="f1">
                            <option value="">--------</option>

                            <c:forEach var="year" items="${ent_year_set}">
                                <option value="${year}"
                                    <c:if test="${year == f1}">selected</c:if>>
                                    ${year}
                                </option>
                            </c:forEach>

                        </select>
                    </div>

                    <%-- クラス --%>
                    <div class="col-3">
                        <label class="form-label">クラス</label>

                        <select class="form-select" name="f2">
                            <option value="">--------</option>

                            <c:forEach var="num" items="${class_num_set}">
                                <option value="${num}"
                                    <c:if test="${num == f2}">selected</c:if>>
                                    ${num}
                                </option>
                            </c:forEach>

                        </select>
                    </div>

                    <%-- 科目 --%>
                    <div class="col-3">
                        <label class="form-label">科目</label>

                        <select class="form-select" name="f3">
                            <option value="">--------</option>

                            <c:forEach var="subject" items="${subject_set}">
                                <option value="${subject.cd}"
                                    <c:if test="${subject.cd == f3}">selected</c:if>>
                                    ${subject.name}
                                </option>
                            </c:forEach>

                        </select>
                    </div>

                    <%-- 検索ボタン --%>
                    <div class="col-2">
                        <button class="btn btn-secondary">
                            検索
                        </button>
                    </div>

                </div>

            </form>

            <%-- 学生番号検索 --%>
            <form method="get" action="TestListStudent.action">

                <div class="row border mx-3 mb-4 py-3 align-items-end rounded">

                    <div class="col-4">
                    <label class="form-label">学生情報</label>
                        <label class="form-label">学生番号</label>

                        <input type="text"
                            name="no"
                            class="form-control"
                            value="${no}">
                    </div>

                    <div class="col-2">
                        <button class="btn btn-secondary">
                            検索
                        </button>
                    </div>

                </div>

            </form>

            <%-- 学生情報表示 --%>
            <c:if test="${student != null}">

                <div class="mb-2 px-3">
                    氏名：${student.name}（${student.no}）
                </div>

            </c:if>

            <%-- 成績一覧 --%>
            <c:choose>

                <%-- データあり --%>
                <c:when test="${tests.size() > 0}">

                    <table class="table table-hover">

                        <tr>
                            <th>科目名</th>
                            <th>科目コード</th>
                            <th>回数</th>
                            <th>点数</th>
                        </tr>

                        <c:forEach var="test" items="${tests}">

                            <tr>

                                <%-- 科目名 --%>
                                <td>${test.subjectName}</td>

                                <%-- 科目コード --%>
                                <td>${test.subjectCd}</td>

                                <%-- 回数 --%>
                                <td>${test.no}</td>

                                <%-- 点数 --%>
                                <td>${test.point}</td>

                            </tr>

                        </c:forEach>

                    </table>

                </c:when>

                <%-- データなし --%>
                <c:otherwise>

                    <div class="px-3">
                        成績情報が存在しませんでした。
                    </div>

                </c:otherwise>

            </c:choose>

        </section>

    </c:param>

</c:import>