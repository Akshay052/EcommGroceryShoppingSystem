
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div>
						<h3>Last Action Status : ${requestScope.mesg}</h3>

						<table style="background-color: cyan; margin: auto;" border="1">

							<caption>Vendor List</caption>
							<c:forEach var="s" items="${requestScope.customer_list}">
								<tr>
									<td>${s.firstName}${s.lastName}</td>
									<td>${s.phoneNumber}</td>
									<td><a
										href="<spring:url value='/customer/update?customerId=${s.customerId}'/>">Update</a></td>
									<td><a
										href="<spring:url value='/customer/delete?customerId=${s.customerId}'/>">Delete</a></td>

								</tr>
							</c:forEach>
						</table>

						<h4>
							<a href="<spring:url value='/Customer/logout'/>">Log Me Out</a>
						</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
