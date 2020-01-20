
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h4 style="color: red;">${requestScope.mesg}</h4>
					<h4>Welcome:${sessionScope.customer_dtls.email}</h4>


					<h4>choose operation</h4>
					<h4>
						<a href="<spring:url value='/customer/categories'/>">Show
							Catagories</a>
					</h4>
					<h4>
						<a href="list">list</a>
					</h4>
					<h4>
						<a href="">show products</a>
					</h4>
					<h4>
						<a href="">add to cart</a>
					</h4>
					<h4>
						<a href="">show order</a>
					</h4>

				</div>
			</div>
		</div>
	</div>
</div>
