<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="include-bootstrap.jsp"%>
<title>Navbar</title>
</head>
<body>

	<div class="modal" tabindex="-1" id="addNoteModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add Note</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="AddNote" method="post" enctype="multipart/form-data">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Title</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required">

						</div>
						<div class="mb-1">
							<label for="exampleInputEmail1" class="form-label">Content</label>



						</div>
						<textarea rows="10" cols="30" class="container-fluid mb-4 p-3"
							name="content" required="required" ></textarea>
						<div class="mb-1">
							<label for="formFile" class="form-label">Add image
								(optional)</label> <input class="form-control" type="file" id="formFile"
								name="image">
						</div>

						<button type="submit" class="btn btn-primary">Save
							Changes</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>






	<div class="container">
		<nav class="navbar navbar-expand-lg bg-primary ">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
						<li class="nav-item "><a class="nav-link active"
							aria-current="page" href="home.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							data-bs-toggle="modal" data-bs-target="#addNoteModal">Add
								Note</a></li>

						<li class="nav-item"><a class="nav-link" href="#">Show
								All Notes</a></li>
					</ul>
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search Notes" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>

			</div>
		</nav>


	</div>
</body>
</html>