<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<sf:form method="post" modelAttribute="s">

						<table style="background-color: cyan; margin: auto;">

							<tr>
								<td>Enter First Name:</td>
								<td><sf:input path="firstName" value="${s.firstName}" /></td>
								<td><sf:errors path="firstName" /></td>
							</tr>
							<tr>
								<td>Enter Last Name:</td>
								<td><sf:input path="lastName" value="${s.lastName}" /></td>
								<td><sf:errors path="lastName" /></td>
							</tr>

							<tr>
								<td>Enter User Email:</td>
								<td><sf:input path="email" value="${s.email}" /></td>
								<td><sf:errors path="email" /></td>
							</tr>

							<tr>
								<td>Enter Password:</td>
								<td><sf:password path="password" value="${s.password}" /></td>
								<td><sf:errors path="password" /></td>
							</tr>
							<tr>
								<td>Enter Phone No:</td>
								<td><sf:input path="phoneNumber" value="${s.phoneNumber}" /></td>
								<td><sf:errors path="phoneNumber" /></td>
							</tr>
							<tr>
								<td>Enter Account No:</td>
								<td><sf:input path="accountNumber"
										value="${s.accountNumber}" /></td>
								<td><sf:errors path="accountNumber" /></td>
							</tr>
							<tr>
								<td>Enter IFSC No:</td>
								<td><sf:input path="IFSC" value="${s.IFSC}" /></td>
								<td><sf:errors path="IFSC" /></td>
							</tr>
							<tr>
								<td>Enter Address:</td>
								<td><sf:input path="address" value="${s.address}"  /></td>
								<td><sf:errors path="address" /></td>
							</tr>
<tr>
								<td>Status:</td>
								<td><sf:input path="status" value="${s.status}" readonly="true" /></td>
								<td><sf:errors path="status" /></td>
							</tr>

							<tr>
								<td><input type="submit" value="Update Details" /></td>


							</tr>
						</table>
					</sf:form>


				</div>
			</div>
		</div>
	</div>
</div>

