
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h3>Cateory List</h3>

					<table style="background-color: cyan; margin: auto;" border="1">

						<c:forEach var="s" items="${requestScope.category_list}">
							<tr>
								<td>${s.categoryName}</td>
								<td><a
									href="<spring:url value='/product/listbycategory?categoryName=${s.categoryName}'/>">Select</a></td>
							</tr>
						</c:forEach>
					</table>

					<h4>
						<a href="<spring:url value='/customer/logout'/>">Log Me Out</a>
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>