<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<title><spring:message code="message.title.albums"/></title>
		<link rel="stylesheet" type="text/css" href="css.css" />
	</head>
	<body>
		<table border="1">			
			<tr>
				<td>Edit</td>
				<td>Name</td>
				<td>Description</td>
				<td>Creation Date</td>
			</tr>					
			<c:forEach var="album" items="${albumList}">
				<tr>
				   <td><a href="formalbum.htm?albumid=${album.albumId}">${album.albumId}</a></td>				   
				   <td><a href="albumpictures.htm?albumid=${album.albumId}">${album.name}</a></td>
				   <td>${album.description}</td>
				   <td>${album.creationDate}</td>				   
				</tr>
			</c:forEach>
			<tr>
			  <td colspan="5"><a href="formalbum.htm">add new Album</a></td>
			</tr>
		</table>		
	</body>
</html>