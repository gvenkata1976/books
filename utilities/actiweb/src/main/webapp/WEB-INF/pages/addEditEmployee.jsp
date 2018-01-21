<%@ include file="/WEB-INF/pages/includes.jsp"%> 
<body>
<div class="success"><c:out value="${msg}"/></div>
<div class="toolbar-popup">
	<input type="submit" name="action" id="action" value="Update" class="button" onclick="javascript:updateEmployee()">&nbsp;
	<input type="submit" name="action" id="action" value="Delete" class="button" onclick="javascript:deleteEmployee()" >&nbsp;			
</div>
<div >
	<form:form commandName="employee" > 
	<table class="request">
			<tr>
				<td>Employee Id<form:hidden path="employeeId" /></td>
				<td><c:out value="${employee.employeeId}" /></td>
			</tr>
			<tr >
				<td>First Name</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr >
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phoneNumber" /></td></tr>
			<tr >
				<td>Hire Date</td>
				<td><form:input path="hireDate" /></td></tr>
			<tr>
				<td>Job Id</td>
				<td><form:input path="jobId" /></td>
			</tr>
 			<tr >
				<td>Salary</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td>Commission %</td>
				<td><form:input path="commissionPct" /></td></tr>
			<tr>
				<td>Manager Id</td>
				<td><form:input path="managerId"/></td>
			</tr>
			<tr>
				<td>Department Id</td>
				<td><form:input path="departmentId.departmentId" /></td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>
