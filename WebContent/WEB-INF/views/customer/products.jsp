<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
	<div class="container">
		<h3>${requestScope.mesg}</h3>

		<h2 class="title-page">Category products</h2>

	</div>
	<!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
	<div class="container">

		<div class="row">
			<aside class="col-md-3">

				<div class="card">
					<article class="filter-group">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#collapse_1"
								aria-expanded="true" class=""> <i
								class="icon-control fa fa-chevron-down"></i>
								<h6 class="title">Product type</h6>
							</a>
						</header>
						<div class="filter-content collapse show" id="collapse_1" style="">
							<div class="card-body">

								<c:forEach var="s" items="${requestScope.category_list}">
									<ul class="list-menu">
										<li><a
											href="<spring:url value='/product/listbycategory?categoryName=${s.categoryName}'/>">
												${s.categoryName} </a></li>
									</ul>
								</c:forEach>
							</div>
							<!-- card-body.// -->
						</div>
					</article>

				</div>
				<!-- card.// -->

			</aside>
			<!-- col.// -->
			<main class="col-md-9">

			<div class="row">
				<c:forEach var="p" items="${requestScope.product_list}">
					<div class="col-md-4">
						<figure class="card card-product-grid">
							<div class="img-wrap">
								<img src="${images}/${p.imageUrl}.jpg">
							</div>
							<!-- img-wrap.// -->
							<figcaption class="info-wrap">
								<div class="fix-height">
									<a href="#" class="title">${p.productName}</a>
									<div class="price-wrap mt-2">
										<span class="price">${p.price}</span>
										<del class="weight">${p.weight}</del>
									</div>
									<!-- price-wrap.// -->
								</div>
								<a href="<spring:url value='/product/details?productId=${p.id}'/>"
									class="btn btn-block btn-primary">Details </a>
							</figcaption>
						</figure>
					</div>
				</c:forEach>
				<!-- col.// -->

			</div>
			<!-- row end.// --> </main>
			<!-- col.// -->

		</div>

	</div>
	<!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->