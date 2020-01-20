
<header class="section-header">
	<section class="header-main border-bottom">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-2 col-4">
					<a href="${SITE_URL}" class="brand-wrap"> <img class="logo"
						src="${images}/logo.jpeg">
					</a>
					<!-- brand-wrap.// -->
				</div>

				<div class="col-lg-4 col-sm-6 col-12">
					<div class="widgets-wrap float-md-right">
						<c:if test="${sessionScope.customer_details != null}">
							<div class="widget-header  mr-3">
								<a href="<spring:url value='/customer/cart/showcart' />" class="icon icon-sm rounded-circle border">Cart</a>
							</div>
							<div class="widget-header icontext">
								<a href="<spring:url value='/customer/account'/>"
									class="icon icon-sm rounded-circle border">User</a>
								<div class="text">
									<span class="text-muted">Welcome: ${sessionScope.customer_details.firstName}</span>

								</div>
							</div>
						</c:if>
						<c:if test="${sessionScope.seller_details != null}">
							<div class="widget-header icontext">
								<a href="<spring:url value='/customer/account'/>"
									class="icon icon-sm rounded-circle border">User</a>
								<div class="text">
									<span class="text-muted">Welcome: ${sessionScope.seller_details.firstName}</span>

								</div>
							</div>
						</c:if>
						<c:if test="${sessionScope.customer_details == null}">
						<div>
							<button class="btn btn-lg btn-block " type="submit">
								<a href="<spring:url value='/home/login'/>"> Login</a>
							</button>
						</div>
						</c:if>
					</div>
					<!-- widgets-wrap.// -->
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->
		</div>
		<!-- container.// -->
	</section>
	<!-- header-main .// -->
</header>
<!-- section-header.// -->





