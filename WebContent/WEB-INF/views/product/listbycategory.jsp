<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div>
	<h3>Last Action Status : ${requestScope.mesg}</h3>

	<table style="background-color: cyan; margin: auto;" border="1">

		<caption>Product List</caption>
		<c:forEach var="s" items="${requestScope.product_list}">
			<tr>
				<td>Name:${s.productName}</td>
				<td>Price:${s.price}</td>
			</tr>
			<tr>
				<td>weight:${s.weight}</td>
				<td>quantity:${s.quantity}</td>
			</tr>
			<tr>
				<td>description:${s.description}</td>


				<td><img src="${images}/${s.imageUrl}" width="50px"
					height="50px"></td>
			</tr>
			<tr>
				<td><a
					href="<spring:url value='/product/details?productId=${s.id}'/>">Select</a></td>
			</tr>
		</c:forEach>
	</table>

	<h4>
		<a href="<spring:url value='/customer/logout'/>">Log Me Out</a>
	</h4>
</div>


<%@ include file="../includes/footer.jsp"%>