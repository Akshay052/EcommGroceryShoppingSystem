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
								src="images/avatars/avatar3.jpg" alt="User">
						</div>
						<div class="text">
							<p>
								<strong> ${customer_orders.firstName} &nbsp;
									${customer_orders.lastName}</strong> <br> ${customer_orders.email}
								<br>
							</p>
							<a href="<spring:url value='/customer/update?customerId=${customer_orders.customerId}'/>">Edit</a>
						</div>
					</figure>
					<hr>
					<p>
						&nbsp; Billing address: <br>
						${customer_orders.billingAddress} &nbsp;
					<hr />
					<br /> &nbsp; Billing address: <br>
					${customer_orders.shippingAddress} &nbsp;

					</p>

				</div>
				<!-- card-body .// -->
			</article>
			<!-- card.// -->

			<article class="card  mb-3" id="orders">

				<h5 class="card-title mb-4">My orders</h5>

				<caption>Placed Orders</caption>
		

				<c:forEach var="order" items="${customer_orders.orders}">
					<div class="row">
						<div class="col-md-6">Product Name:${order.productName}</div>
						<div class="col-md-6">Weight:${order.weight}</div>
						<div class="col-md-6">Quantity:${order.quantity}</div>
						<div class="col-md-6">Total:${order.value}</div>
						<div class="col-md-6">Order Date:${order.orderDate}</div><br/>
						<div class="col-md-6">Billing Address:${order.billingAddress}</div><br/>
						<div class="col-md-6">Shipping Address:${order.shippingAddress}</div>
						<hr/>
					</div>
				</c:forEach>

			</article>
			<!-- card.// --> </main>
			<!-- col.// -->
		</div>

	</div>
	<!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->