<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<title><spring:message code="message.title.uploadpicture"/></title>
		<link rel="stylesheet" type="text/css" href="css.css" />
	</head>
	<body>
		<h1><spring:message code="message.title.uploadpicture"/></h1>
		<form:form commandName="upload" enctype="multipart/form-data">
			<form:errors path="*"/>
			<table border="1">
				<tr>
					<td colspan="2">Click "Browse" to select a picture then click next.</td>
				</tr>
				<tr>
					<td colspan="2"><input type="file" name="upload"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Next" name="_target1" /></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>