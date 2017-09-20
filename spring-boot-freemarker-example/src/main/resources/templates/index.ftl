<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Boot FreeMarker example - viralpatel.net</title>
	
	<link href="/bootstrap/4.0.0-beta/css/bootstrap.min.css"
		rel="stylesheet">

	<style>
	.container {
		margin-top: 80px;
	}
	
	.bg-dark {
		background-color: #3b8dbd !important;
	}
	</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="viralpatel.net">Spring Boot
			FreeMarker example - viralpatel.net</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
	<div class="container">
		<form class="form-horizontal" method="post" action="/add">
			<fieldset>
				<legend>Customer details</legend>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="customerName">Customer
						name</label>
					<div class="col-sm-4">
						<input id="customerName" name="customerName" type="text"
							class="form-control form-control-sm" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="email">Email</label>
					<div class="col-sm-4">
						<input id="email" name="email" type="text"
							class="form-control form-control-sm" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="dateOfBirth">Date
						of birth</label>
					<div class="col-sm-4">
						<input id="dateOfBirth" name="dateOfBirth" type="date"
							class="form-control form-control-sm">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-4">
						<button id="save" name="save" class="btn btn-primary">Add</button>
					</div>
				</div>
			</fieldset>
		</form>

		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Customer name</th>
					<th>Email</th>
					<th>Birthdate</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<#list model["customers"] as customer>
				<tr>
					<th scope="row">${customer.customerId}</th>
					<td>${customer.customerName}</td>
					<td>${customer.email}</td>
					<td>${customer.dateOfBirth}</td>
					<td><a class="btn btn-sm btn-warning" role="button"
						href="/delete/${customer.customerId}">Delete</a></td>
				</tr>
				</#list>
			</tbody>
		</table>

	</div>

</body>
</html>

