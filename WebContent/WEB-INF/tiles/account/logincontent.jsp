
<br />
<form name='f' action='${root}/j_spring_security_check' method='POST'>
	<table class="formtable">
		<tr>
			<td>User:</td>
			<td><input type='text' name='j_username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='j_password' /></td>
		</tr>
		<tr>
			<td><span id="staysignedin">Stay signed in:</span></td>
			<td><input type='checkbox' name='_spring_security_remember_me' /></td>
		</tr>
		<tr>
			<td colspan='2'><br /><input name="submit" type="submit" value="Login" /></td>
		</tr>
	</table>
</form>
