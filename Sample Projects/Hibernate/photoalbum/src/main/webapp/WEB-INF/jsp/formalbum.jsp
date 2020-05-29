<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title><spring:message code="message.title.formalbum"/></title>
	<link rel="stylesheet" type="text/css" href="css.css" />
</head>
<body>	
<form:form>
	<form:errors path="*" />
	<table id="formAlbum" border="1">
		<tr>
			<td>Name*</td>
			<td><form:input path="name" maxlength="25"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><form:input path="description" maxlength="50"/></td>
		</tr>		
		<tr>
			<td>Creation Date</td>
			<td><form:input path="creationDate" /></td>
		</tr>
		<tr>
          <td colspan="1"></td>
          <td>
          	<input type="submit" name="update" value="Update"/>
          	<input type="submit" name="delete" value="Delete"/>
          </td>
        </tr>      
         <tr>
          <td colspan="2"><input type="submit" name="insert" value="Insert"/></td>
        </tr>  
	</table>	
</form:form>
</body>
</html>