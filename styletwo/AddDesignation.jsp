<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tg' %>  
<tg:FormResubmitted>
<tg:Module name='HOME'/>
<jsp:forward page='/notifyFormResubmission'/>
</tg:FormResubmitted>
<tg:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:setProperty name='designationBean' property='*'/>
<jsp:forward page='/addDesignation'/>