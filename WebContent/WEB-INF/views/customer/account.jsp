<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
	<div class="container">

		<div class="row">
			<aside class="col-md-3">
				<ul class="list-group">
					<a class="list-group-item active" href="#overview'/>"> Account
						overview</a>
					<a class="list-group-item" href="#orders"> My Orders </a>
					<a class="list-group-item"
						href="<spring:url value='/customer/logout'/>">Log Out</a>

				</ul>
			</aside>
			<!-- col.// -->
			<main class="col-md-9">

			<article class="card mb-3" id="overview">
				<div class="card-body">

					<figure class="icontext">
						<div class="icon">
							<img class="rounded-circle img-sm border"
								src="images/avatars/avatar3.jpg">
						</div>
						<div class="text">
							<p>
								<strong> ${sessionScope.customer_details.firstName}
									${sessionScope.customer_details.lastName}</strong> <br>
								${sessionScope.customer_details.email} <br>
							</p>
							<a href="<spring:url value='/customer/update'/>">Edit</a>
						</div>
					</figure>
					<hr>
					<p>
						<i class="fa fa-map-marker text-muted"></i> &nbsp; My address: <br>
						Tashkent city, Street name, Building 123, House 321 &nbsp <a
							href="#" class="btn-link"> Edit</a>
					</p>



				</div>
				<!-- card-body .// -->
			</article>
			<!-- card.// -->

			<article class="card  mb-3" id="orders">
				<div class="card-body">
					<h5 class="card-title mb-4">My orders</h5>

					<div class="row">
						<c:forEach var="order" items="${requestScope.customer_orders}">
							<div class="col-md-6">
								<figure class="itemside  mb-3">
									<div class="aside">
										<img src="images/items/1.jpg" class="border img-sm">
									</div>
									<figcaption class="info">
										<time class="text-muted">
											<i class="fa fa-calendar-alt"></i> 12.09.2019
										</time>
										<p>Great item name goes here</p>
										<span class="text-warning">Pending</span>
									</figcaption>
								</figure>
							</div>
							<!-- col.// -->
						</c:forEach>
					</div>
					<!-- row.// -->
				</div>
				<!-- card-body .// -->
			</article>
			<!-- card.// --> </main>
			<!-- col.// -->
		</div>

	</div>
	<!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->