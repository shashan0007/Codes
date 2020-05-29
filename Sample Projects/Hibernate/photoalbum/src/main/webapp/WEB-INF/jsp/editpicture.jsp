<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<title><spring:message code="message.title.editpicture"/></title>
		<link rel="stylesheet" type="text/css" href="css.css" />
	</head>
	<body>
		<h1><spring:message code="message.title.editpicture"/></h1>
		<form:form commandName="upload">
			<table border="1">
				<tr>					
					<td colspan="2">${upload.picture.name}</td>
				</tr>
				<tr>
					<td colspan="2"><img src="${upload.picture.path}${upload.picture.file}" /></td>					
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Cancel Image" name="_cancel"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<table>
							<tr>
								<td align="center">
									Name :<form:input path="picture.name" maxlength="25"/>
								</td>
							</tr>
							<tr>
								<td align="left">
									Description : <form:input path="picture.description" maxlength="50"/>								
								</td>
							</tr>
						</table>						
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Back" name="_target0"/></td>					
					<td align="right"><input type="submit" value="Finish" name="_finish" /></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>