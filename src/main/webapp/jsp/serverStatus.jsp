<%@ include file="/jsp/include.jsp"%>
<html>
	<head>
		<title>Server Status App</title>
		<style type="text/css">
		body {
				
			}
		</style>
	</head>
	<body>
		<h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Servers</h3>
    <table border="1">
    <tr>
    <th>Server</th><th>Status</th>
    </tr>
    
    <c:forEach items="${model.serverList}" var="server">
     <tr>
      <td><c:out value="${server.url}"/> </td><td><c:out value="${server.status}"/></td>
      </tr>
    </c:forEach>
    </table>

	<br>
	<br>
	<div
		style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">


	</div>
</body>
</html>