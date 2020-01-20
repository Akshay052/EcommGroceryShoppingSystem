
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div>
						<h3>Last Action Status : ${requestScope.mesg}</h3>

						<table style="background-color: cyan; margin: auto;" border="1">

							<caption>Seller List</caption>
							<c:forEach var="s" items="${requestScope.seller_list}">
								<tr>
									<td>${s.firstName}${s.lastName}</td>
									<td>${s.address}</td>
									<td>${s.phoneNumber}</td>
									<td>${s.status}</td>
									<td><a
										href="<spring:url value='/seller/update?sellerId=${s.sellerId}'/>">Update</a></td>
									<td><a
										href="<spring:url value='/seller/delete?sellerId=${s.sellerId}'/>">Delete</a></td>

								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
