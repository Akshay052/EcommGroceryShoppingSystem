<%@include file="../includes/header.jsp"%>

<div class="wrapper">
	<!-- navigation -->
	<%@include file="../includes/nav.jsp"%>

	<!-- Content here -->
	<div class="content">

		<c:if test="${clickHome == true}">
			<!-- Carousel
    ================================================== -->
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img class="first-slide" src="${images}/dm1.jpg" alt="First slide">
						<div class="container">
							<div class="carousel-caption">
								<h1>Example headline.</h1>
								<p>Note: If you're viewing this page via a buttons on the
									left and right might not load/display properly due to web
									browser security rules.</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Sign
										up today</a>
								</p>
							</div>
						</div>
					</div>
					<div class="item">
						<img class="second-slide" src="${images}/dm2.jpg"
							alt="Second slide">
						<div class="container">
							<div class="carousel-caption">
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Learn
										more</a>
								</p>
							</div>
						</div>
					</div>
					<div class="item">
						<img class="third-slide" src="${images}/dm3.jpg" height="20px"
							width="50px" alt="Third slide">
						<div class="container">
							<div class="carousel-caption">
								<h1>One more for good measure.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Browse
										gallery</a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			<!-- /.carousel -->

			<!-- Marketing messaging and featurettes
    ================================================== -->
			<!-- Wrap the rest of the page in another container to center all the content. -->

			<div class="container marketing">
				<!-- Three columns of text below the carousel -->
				<div class="row">
					<div class="col-lg-4">
						<img class="img-circle"
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							alt="Generic placeholder image" width="140" height="140">
						<h2>Heading</h2>
						<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
							euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
							Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
							Praesent commodo cursus magna.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="img-circle"
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							alt="Generic placeholder image" width="140" height="140">
						<h2>Heading</h2>
						<p>Duis mollis, est non commodo luctus, nisi erat porttitor
							ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
							purus sit amet fermentum. Fusce dapibus, tellus ac cursus
							commodo, tortor mauris condimentum nibh.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="img-circle"
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							alt="Generic placeholder image" width="140" height="140">
						<h2>Heading</h2>
						<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
							in, egestas eget quam. Vestibulum id ligula porta felis euismod
							semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
							condimentum nibh, ut fermentum massa justo sit amet risus.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
				</div>
				<!-- /.row -->
			</div>

			<!-- General pages -->

		</c:if>

		<!-- General pages -->

		<c:if test="${clickLogin == true}">
			<%@include file="login.jsp"%>
		</c:if>

		<c:if test="${clickAbout==true}">
			<%@include file="about.jsp"%>
		</c:if>


		<!--=========================== seller pages============== -->

		<c:if test="${sellerLogin == true}">
			<%@include file="../seller/login.jsp"%>
		</c:if>

		<c:if test="${SellercategoryList == true}">
			<%@include file="../category/sellerCategoryList.jsp"%>
		</c:if>

		<c:if test="${sellerRegister == true}">
			<%@include file="../seller/register.jsp"%>
		</c:if>

		<c:if test="${sellerList == true}">
			<%@include file="../seller/list.jsp"%>
		</c:if>

		<c:if test="${sellertask == true}">
			<%@include file="../seller/task.jsp"%>
		</c:if>

		<c:if test="${addProduct == true}">
			<%@include file="../product/addproduct.jsp"%>
		</c:if>

		<c:if test="${uploadImage == true}">
			<%@include file="../product/uploadimage.jsp"%>
		</c:if>

		<c:if test="${errorinseller == true}">
			<%@include file="../seller/error.jsp"%>
		</c:if>

		<c:if test="${sellerUpdate == true}">
			<%@include file="../seller/update.jsp"%>
		</c:if>
		<c:if test="${sellerLogout == true}">
			<%@include file="../seller/logout.jsp"%>
		</c:if>

		<!-- ======================= Customer pages ========================-->

		<c:if test="${customerLogin == true}">
			<%@include file="../customer/login.jsp"%>
		</c:if>

		<c:if test="${customerRegister == true}">
			<%@include file="../customer/register.jsp"%>
		</c:if>

		<c:if test="${showCategories == true}">
			<%@include file="../customer/categories.jsp"%>
		</c:if>
		
		<c:if test="${productList == true}">
			<%@include file="../customer/categories.jsp"%>
		</c:if>

		<c:if test="${productDetails == true}">
			<%@include file="../product/details.jsp"%>
		</c:if>
		
		<c:if test="${customerAccount == true}">
			<%@include file="../customer/account.jsp"%>
		</c:if>

		<c:if test="${customertask == true}">
			<%@include file="../customer/task.jsp"%>
		</c:if>

		<c:if test="${customerUpdate == true}">
			<%@include file="../customer/update.jsp"%>
		</c:if>

		<c:if test="${customerLogout == true}">
			<%@include file="../customer/logout.jsp"%>
		</c:if>

		<!--=========================== product pages============== -->

		<c:if test="${productsBySeller == true}">
			<%@include file="../product/listbyseller.jsp"%>
		</c:if>

		<c:if test="${addproduct == true}">
			<%@include file="../product/addproduct.jsp"%>
		</c:if>

		<!--===================== Cart pages ===================== -->

		<c:if test="${showCart == true}">
			<%@include file="../customer/cart.jsp"%>
		</c:if>

		<!-- ========== Payment and order ========== -->

		<c:if test="${showPaymentPage == true}">
			<%@include file="../orders/payment.jsp"%>
		</c:if>



	</div>

	<%@ include file="../includes/footer.jsp"%>
</div>