<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
	<div class="container">

		<div class="row">
			<aside class="col-md-3">
				<ul class="list-group">
					<a class="list-group-item active" href="#"> Account overview</a>
					<a class="list-group-item" href="#"> My Products </a>
					<a class="list-group-item" href="#"> Received orders </a>
					<a class="list-group-item"
						href="<spring:url value='/seller/logout'/>">Log Out</a>

				</ul>
			</aside>
			<!-- col.// -->
			<main class="col-md-9">

			<article class="card mb-3">
				<div class="card-body">

					<figure class="icontext">
						<div class="icon">
							<img class="rounded-circle img-sm border"
								src="images/avatars/avatar3.jpg" alt="User">
						</div>
						<div class="text">
							<strong> ${seller_details.firstName}
								${seller_details.lastName} </strong> <br> ${seller_details.email} <br>
							<form action="<spring:url value='/seller/update'/>" method="post">
								<input type="hidden" name="sellerId"
									value="${seller_details.sellerId}" />
								<button type="submit" class="btn btn-block btn-link">Edit</button>
							</form>
						</div>
					</figure>
					<hr>
					<p>
						<i class="fa fa-map-marker text-muted"></i> &nbsp; My address: <br>
						${seller_details.address} &nbsp; 
					</p>
				</div>
				<!-- card-body .// -->
			</article>
			<!-- card.// -->

			<article class="card  mb-3">
				<div class="card-body">
					<h5 class="card-title mb-4">Recent orders</h5>

					<div class="row">
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
						<div class="col-md-6">
							<figure class="itemside  mb-3">
								<div class="aside">
									<img src="images/items/2.jpg" class="border img-sm">
								</div>
								<figcaption class="info">
									<time class="text-muted">
										<i class="fa fa-calendar-alt"></i> 12.09.2019
									</time>
									<p>Machine for kitchen to blend</p>
									<span class="text-success">Departured</span>
								</figcaption>
							</figure>
						</div>
						<!-- col.// -->
						<div class="col-md-6">
							<figure class="itemside mb-3">
								<div class="aside">
									<img src="images/items/3.jpg" class="border img-sm">
								</div>
								<figcaption class="info">
									<time class="text-muted">
										<i class="fa fa-calendar-alt"></i> 12.09.2019
									</time>
									<p>Ladies bag original leather</p>
									<span class="text-success">Shipped </span>
								</figcaption>
							</figure>
						</div>
						<!-- col.// -->
					</div>
					<!-- row.// -->

					<a href="#" class="btn btn-outline-primary"> See all orders </a>
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