<%@ include file="prefixes.jsp"%>
<html>
<head>
<%@include file="cssJs.jsp"%>
<title>Add project</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div class="row" id="body">
			<div class="col-md-1" id="menu">
				<%@include file="menu.jsp"%>
			</div>
			<div class="col-md-9 context">
				<h1>My Projects</h1>
				<div class="row">
					<c:forEach var="project" items="${projects}">
						<div class="col-sm-6 col-md-5">
							<div class="thumbnail my_thumbnail">
								<img src="<c:out value="${project.link}" />" alt="">
								<div class="caption">
									<h3>
										<c:out value="${project.name}" />
									</h3>
									<p>
										<c:out value="${project.shortDesc}" />
									</p>
									<p>
										<a href="/kickstarter/projects/<c:out value="${project.id}"/>"
											class="btn btn-success" role="button">Open Project</a> <a
											href="/kickstarter/updateProjects/<c:out value="${project.id}"/>"
											class="btn btn-success" role="button">Update Project</a> <a
											href="/kickstarter/dropProjects/<c:out value="${project.id}"/>"
											class="btn btn-success" role="button">Drop Project</a>
											<a href="/kickstarter/addPost/<c:out value="${project.id}"/>"
											class="btn btn-success" role="button">Add post</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="row" id="footer"></div>
	</div>

</body>
</html>