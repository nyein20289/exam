<%-- 成績登録JSP --%>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts">
	</c:param>

	<c:param name="content">

		<section class="me-4">

			<h2
				class="h3 mb-4 fw-normal bg-secondary bg-opacity-10 py-2 px-4">
				成績管理
			</h2>

			<form action="TestRegistExecute.action"
				method="post">

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

					<!-- 検索ボタン -->
					<div class="col-md-2">

						<input type="submit"
							value="検索"
							class="btn btn-secondary w-100">

					</div>

				</div>

			</form>

			<!-- エラーメッセージ -->
			<c:if test="${errors.size() > 0}">

				<div class="mt-4 px-4">

					<ul class="text-danger">

						<c:forEach var="error"
							items="${errors}">

							<li>${error}</li>

						</c:forEach>

					</ul>

				</div>

			</c:if>

			<!-- 検索結果 -->
			<c:if test="${students != null}">

				<div class="mt-4 px-4">

					<form action="TestRegistExecute.action"
						method="post">

						<table class="table table-bordered table-hover">

							<thead class="table-secondary">

								<tr>

									<th>
										学生番号
									</th>

									<th>
										氏名
									</th>

									<th>
										点数
									</th>

								</tr>

							</thead>

							<tbody>

								<c:forEach var="student"
									items="${students}"
									varStatus="status">

									<tr>

										<td>

											${student.no}

											<input type="hidden"
												name="studentNo"
												value="${student.no}">

										</td>

										<td>
											${student.name}
										</td>

										<td>

											<input type="number"
												name="point"
												min="0"
												max="100"
												class="form-control">

										</td>

									</tr>

								</c:forEach>

							</tbody>

						</table>

						<div class="text-end">

							<input type="submit"
								value="登録して終了"
								class="btn btn-primary">

						</div>

					</form>

				</div>

			</c:if>

		</section>

	</c:param>

</c:import>