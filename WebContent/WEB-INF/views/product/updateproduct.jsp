
<div>
	<sf:form method="post" action="updateproduct" modelAttribute="product">

		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>${requestScope.product}</td>
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
								placehonder="${product.quantity}" path="quantity" />
							<sf:errors path="quantity" />
						</div>
						<p class="product-description">${product.description}</p>
						<!-- price-wrap.// -->
					</div>
					<button type="submit" class=" btn btn-blockbtn-primary">Update
					</button>
				</figcaption>
			</figure>
		</div>
	</sf:form>


</div>
