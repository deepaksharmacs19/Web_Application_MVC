<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tg' %>
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.hr.beans.MessageBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>

<h2>${messageBean.heading}</h2>
${messageBean.message}

<br>

<tg:If condition='${messageBean.generateButtons}'>
  
<table>
<tr>
<td>
<form action='/styletwo/${messageBean.buttonOneAction}'>
<button type='submit'>${messageBean.buttonOneText}</button>
</form>
</td>

<tg:If condition='${messageBean.generateTwoButtons}'>
<td>
<form action='/styletwo/${messageBean.buttonTwoAction}'>
<button type='submit'>${messageBean.buttonTwoText}</button>
</form>

</td>
</tg:If>

</tr>
</table>
</tg:If>


<jsp:include page='/MasterPageBottomSection.jsp'/>