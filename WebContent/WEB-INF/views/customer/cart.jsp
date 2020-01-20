<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
	<div class="container">
		<h2 class="title-page">Shopping cart</h2>
	</div>
	<!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->




<!-- ========================= SECTION CONTENT ========================= -->

<div class="container">
	<table id="cart" class="table table-hover table-condensed">
		<thead>
			<tr>
				<th style="width: 50%">Product</th>
				<th style="width: 10%">Price</th>
				<th style="width: 8%">Quantity</th>
				<th style="width: 22%" class="text-center">Subtotal</th>
				<th style="width: 10%"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartItem" items="${cart.cartItems}">
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img src="${images}/${cartItem.product.imageUrl} alt="
									..." class="img-responsive" />
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin">${cartItem.product.productName}</h4>
							</div>
						</div>
					</td>
					<td data-th="Price">${cartItem.product.price}</td>
					<td data-th="Quantity"><input type="number" id="quantity"
						class="form-control text-center" value="${cartItem.quantity}">
					</td>
					<td data-th="Subtotal" class="text-center">${cartItem.value}</td>
					<td class="actions" data-th=""><a
						href="<spring:url value='/customer/cart/updatecartitem?cartItemId=${cartItem.cartItemId}&quantity=2' />"
						class="btn btn-info btn-sm"><i class="fa fa-refresh"></i>Refresh</a>
						<a href="<spring:url value='/customer/cart/removecartitem?cartItemId=${cartItem.cartItemId}' />"
						class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i>Remove</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr class="visible-xs">
				<td class="text-center"><strong>Total 1.99</strong></td>
			</tr>
			<tr>
				<td><a href="<spring:url value='/customer/categories' />"
					class="btn btn-warning"><i class="fa fa-angle-left"></i>
						Continue Shopping</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<td class="hidden-xs text-center"><strong>Total:
						${requestScope.cart.amount}</strong></td>
				<td><a href="<spring:url value='/customer/cart/checkout' />"
					class="btn btn-success btn-block">Checkout <i
						class="fa fa-angle-right"></i></a></td>
			</tr>
		</tfoot>
	</table>
</div>

<!-- ========================= SECTION CONTENT END// ========================= -->

<!-- ========================= SECTION  ========================= -->
<section class="section-name bg padding-y">
	<div class="container">
		<h6>Payment and refund policy</h6>
		<p>Concerning any payments by credit card or electronic funds
			transfer, by submitting your order for processing, you authorise us
			to charge your order (including taxes, shipping, handling and any
			amounts agreed upon before order submission) to your credit card or
			account. If your credit card or account cannot be verified, or is
			invalid, or is not otherwise acceptable, your order may be suspended
			or cancelled automatically. All prices and availability of products
			are subject to change without notice. Taxes will be adjusted from the
			amount shown on the billing screens, which may be caused by several
			factors, including variances between processor programs and changes
			in tax rates.</p>

	</div>
	<!-- container // -->
</section>
<!-- ========================= SECTION  END// ========================= -->