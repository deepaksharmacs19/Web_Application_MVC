<jsp:useBean id='errorBean' class='com.thinking.machines.hr.beans.ErrorBean' scope='request'/>

<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>

<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>

</head>
<body>
<div style='margin: 5px; width: 90vw; height: auto; display: flex; align-items: center;'>
  <img src='/styleone/images/logo.png' style='margin-right: 10px;'>

<span style='font-size: 30pt;margin-top:30px'>Thinking Machines</span>
</div>

<span style='display:grid; place-items:center; margin:5px;padding:20px;font-size:20pt'>
Administrator</span>

<div style='display:grid; place-items:center; margin-left:auto;margin-right:auto;padding:20px;width:20%;border:1px solid black'>

<form method='post' action='/styletwo/Login.jsp'>
<table>
<span style='color:red'>
<jsp:getProperty name='errorBean' property='error'/>
</span>

<tr>
<td>Username: </td>

<td><input type='text' id='username' name='username'></td>


</tr>
<tr>
<td>
Password: 
</td>

<td><input type='password' id='password' name='password'></td>

</tr>
<tr>
<td></td>
<td><input type="submit" value="Login" style='display:block'>

</td>
</tr>

</table>
</form>

</div>

<!-- Main container ends here -->
</body>
</html>