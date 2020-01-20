
<div>
	<sf:form method="post" modelAttribute="cartItem">

		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>${cartItem.product. }</td>
			</tr>

		</table>

		<div class="col-md-6">
			<figure class="card card-product-grid">
				<div class="img-wrap">
					<img src="${images}/${product.imageUrl}">
				</div>
				<!-- img-wrap.// -->
				<figcaption class="info-wrap">
					<div class="fix-height">
						<a href="#" class="title">${product.productName}</a>
						<div class="price-wrap mt-2">
							<span class="price">Price: ${product.price}</span>&nbsp; &nbsp; <span
								class="weight">Weight: ${product.weight}</span>
						</div>
						<div>
							<label for="quantity">Quantity:</label>
							<sf:input class="form-control" id="quantity"
								placehonder="${cartItem.quantity}" path="quantity" />
							<sf:errors path="quantity" />
						</div>
						<p class="product-description">${product.description}</p>
						<!-- price-wrap.// -->
					</div>
					<a
						href="<spring:url value='/cart/addtocart?productId=${product.id}'/>"
						class="btn btn-block btn-primary">Add to Cart </a>
				</figcaption>
			</figure>
		</div>
	</sf:form>


</div>
