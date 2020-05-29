<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<title><spring:message code="message.title.albumpictures"/></title>
		<link rel="stylesheet" type="text/css" href="css.css" />
	</head>
	<body>
		<table border="1">									
			<c:forEach var="picture" items="${album.pictures}">
				<tr>
					<td><img src="${picture.path}${picture.file}" /></td>
				</tr>
				<tr>				  
				   <td>
						Name : <a href="formpicture.htm?pictureid=${picture.pictureId}">${picture.name}</a><br>
						Description : ${picture.description}<br>
						Size : ${picture.size}
				   </td>
				</tr>
			</c:forEach>							
		</table>
		<a href="upload.htm?albumid=${album.albumId}">Upload Pictures</a>
	</body>
</html>