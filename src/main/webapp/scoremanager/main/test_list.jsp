<%-- 成績参照JSP --%>

<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="content">

		<section class="me-4">

			<h2
				class="h3 mb-4 fw-normal
				bg-secondary bg-opacity-10
				py-2 px-4">

				成績参照

			</h2>

			<!-- 検索フォーム -->
			<form action="TestListSubjectExecute.action"
				method="get">

				<div class="row px-4 g-3 align-items-end">

					<!-- 入学年度 -->
					<div class="col-md-2">

						<label class="form-label">
							入学年度
						</label>

						<select name="entYear"
							class="form-select">

							<option value="">
								--------
							</option>

							<c:forEach var="year"
								items="${yearList}">

								<option value="${year}">
									${year}
								</option>

							</c:forEach>

						</select>

					</div>

					<!-- クラス -->
					<div class="col-md-2">

						<label class="form-label">
							クラス
						</label>

						<select name="classNum"
							class="form-select">

							<option value="">
								--------
							</option>

							<c:forEach var="c"
								items="${classList}">

								<option value="${c}">
									${c}
								</option>

							</c:forEach>

						</select>

					</div>

					<!-- 科目 -->
					<div class="col-md-3">

						<label class="form-label">
							科目
						</label>

						<select name="subjectCd"
							class="form-select">

							<option value="">
								--------

							</option>

							<c:forEach var="s"
								items="${subjectList}">

								<option value="${s.cd}">
									${s.name}
								</option>

							</c:forEach>

						</select>

					</div>

					<!-- 回数 -->
					<div class="col-md-2">

						<label class="form-label">
							回数
						</label>

						<select name="no"
							class="form-select">

							<option value="">
								--------
							</option>

							<option value="1">
								1
							</option>

							<option value="2">
								2
							</option>

						</select>

					</div>

					<!-- 検索 -->
					<div class="col-md-2">

						<input type="submit"
							value="検索"
							class="btn btn-secondary w-100">

					</div>

				</div>

			</form>

			<!-- 学生番号検索 -->
			<form action="TestListStudentExecute.action"
				method="get"
				class="mt-4 px-4">

				<div class="row g-3 align-items-end">

					<div class="col-md-3">

						<label class="form-label">
							学生番号
						</label>

						<input type="text"
							name="studentNo"
							class="form-control"
							placeholder="学生番号を入力してください">

					</div>

					<div class="col-md-2">

						<input type="submit"
							value="検索"
							class="btn btn-secondary w-100">

					</div>

				</div>

			</form>

			<!-- エラー -->
			<c:if test="${errors.size() > 0}">

				<div class="mt-3 px-4">

					<ul class="text-danger">

						<c:forEach var="error"
							items="${errors}">

							<li>
								${error}
							</li>

						</c:forEach>

					</ul>

				</div>

			</c:if>

			<!-- データなし -->
			<c:if test="${testList != null && testList.size() == 0}">

				<div class="mt-4 px-4 text-info">

					学生情報が存在しませんでした

				</div>

			</c:if>

			<!-- 一覧 -->
			<c:if test="${testList != null && testList.size() > 0}">

				<div class="mt-4 px-4">

					<table
						class="table table-bordered table-hover">

						<thead class="table-secondary">

							<tr>

								<th>
									学生番号
								</th>

								<th>
									氏名
								</th>

								<th>
									科目
								</th>

								<th>
									回数
								</th>

								<th>
									点数
								</th>

							</tr>

						</thead>

						<tbody>

							<c:forEach var="t"
								items="${testList}">

								<tr>

									<td>
										${t.studentNo}
									</td>

									<td>
										${t.studentName}
									</td>

									<td>
										${t.subjectName}
									</td>

									<td>
										${t.no}
									</td>

									<td>
										${t.point}
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>

				</div>

			</c:if>

		</section>

	</c:param>

</c:import>