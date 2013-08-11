<html>
<head>
<link href="/menu_assets/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%@ include file="Menu.jsp"%>
	<table>
		<tr>
			<td valign="top" height="10px" width="222"><%@ include
					file="springExampleMenu.jsp"%></td>
			<td></td>
			<td align="left" bordercolor="c41200">
				<h2>Web REST/Data Access</h2>
				<p>This example is implemented using REST webservice using spring and Data 
				integration using jdbc. Method that are exposed are as follows</P>
				<h2>Department operations</h2>
				<table border="1" >
					<tr><th>path</th><th>Request Type</th><th>Description</th></tr>
					<tr><td>/dept</td><td>GET</td><td>Get all department</td></tr>
					<tr><td>/dept/{id}</td><td>GET</td><td>Get information pertaining to specified Department id</td></tr>
					<tr><td>/dept/{deptid}/{deptDesc}</td><td>POST</td><td>Add specified Department to Database</td></tr>
					<tr><td>/dept/{deptid}/{deptDesc}</td><td>PUT</td><td>Change the specified Department in Database</td></tr>
					<tr><td>/dept/{id}</td><td>Delete</td><td>Delete the department identified by id</td></tr>
				</table>
				<h2>Employee operations</h2>
				<table border="1" >
					<tr><th>path</th><th>Request Type</th><th>Description</th></tr>
					<tr><td>/emp/{id}</td><td>GET</td><td>Get employee information identified by id</td></tr>
					<tr><td>/empList/{id}</td><td>GET</td><td>Get all employee list</td></tr>
					<tr><td>/emp/{id}/{firstName}/{lastName}/{dept}</td><td>POST</td><td>Add employee identified by information</td></tr>
					<tr><td>/emp/{id}/{firstName}/{lastName}/{dept}</td><td>PUT</td><td>Update employee information identified by id</td></tr>
					<tr><td>/emp/{id}</td><td>Delete</td><td>Delete the employee information identified by id</td></tr>
				</table>
				<p> <b>Base URL :</b> http://restapp.systemlogic.cloudbees.net</p>
				<p><a href='https://github.com/systemlogic/RestApp/archive/master.zip'><span>Download this Example</span></a></p>
		</td>
				<%@ include file="rightPane.jsp" %>
		</tr>
	</table>
	<%@ include file="FooterLink.jsp"%>
	<%@ include file="Footer.jsp"%>
</body>
</html>