<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tg'%>

<jsp:useBean id='administratorBean' class='com.thinking.machines.hr.beans.AdministratorBean' scope='session'/>


<tg:If condition='${administratorBean.username==""}'>
<jsp:forward page='/LoginForm.jsp' />
</tg:If>


<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>

<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>

</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styleone/images/logo.png' class='logo'>

<div class='brand-name'>Thinking Machines
<a href='/styletwo/logout' style='float:right;margin-right:20px;font-size:20pt'>Logout</a>

<img src='/styletwo/images/admin.png' style='float:right;margin-right:100px;width:50px'>
<span style='float:right;margin-right:10px'>${administratorBean.username}</span>
</div>



</div> <!-- header ends  here -->
<!-- content section starts  here -->
<div class='content'>
<!-- left panel starts  here -->
<div class='content-left-panel'>

<tg:If condition='${module!=DESIGNATION}'>
<a href='/styletwo/Designations.jsp'>Designations</a>
</tg:If>
<tg:If condition='${module==DESIGNATION}'>
<b>Designations<b>
</tg:If>
<br>
<tg:If condition='${module!=EMPLOYEE}'>
<a href='/styletwo/Employees.jsp'>Employees</a>
</tg:If>
<tg:If condition='${module==EMPLOYEE}'>
<b>Employees<b>
</tg:If>
<br><br>

<tg:If condition='${module!=HOME}'>
<a href='/styletwo/index.jsp'>Home</a>
</tg:If>



</div>
<!-- left panel ends here -->
<!-- right panel starts  here -->
<div class='content-right-panel'>
