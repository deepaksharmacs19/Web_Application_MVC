<jsp:useBean id='designationBean' class='com.thinking.machines.hr.beans.DesignationBean' scope='request'/>
<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tg' %>  
<tg:Module name='DESIGNATION'/>


<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/styletwo/js/DesignationDeleteForm.js'></script>


<h2>Designation (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>

<tg:FormID />

<input type='hidden' id='form_id' name='form_id' value='${form_id}'>

<input type='hidden' name='code' value=${designationBean.code}>
<input type='hidden' name='title' value=${designationBean.title}>

Delete ${designationBean.title}<br>

<button type='submit'>yes</button>

<button type='Button' onclick='cancelDeletion()'>no</button>

</form>
<form id='cancelDeletionForm' action='/styletwo/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>