
function createDynamicRowClickHandler(rowAddress,employeeId)
{
return function()
{
selectEmployee(rowAddress,employeeId);
}
}

function populateEmployeesGridTable()
{
var employeesGridTable=document.getElementById('employeesGridTable');
var employeesGridTableBody=employeesGridTable.getElementsByTagName("tbody")[0];

var 
employeesGridTableBodyRow=employeesGridTableBody.getElementsByTagName("tr")[0];

employeesGridTableBodyRow.remove();

var employeesGridTableColumns=employeesGridTableBodyRow.getElementsByTagName("td");



var cellTemplate;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
for(var k=0;k<employees.length;k++)
{
dynamicRow=employeesGridTableBodyRow.cloneNode(true);
employeesGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName('td');

for(var i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute('placeHolderId');

if(placeHolderFor==null) continue;
if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=(k+1)+".";
if(placeHolderFor=='employeeId') cellTemplate.innerHTML=(employees[k].employeeId);
if(placeHolderFor=='name') cellTemplate.innerHTML=(employees[k].name);
if(placeHolderFor=='designation') cellTemplate.innerHTML=(employees[k].designation);
if(placeHolderFor=='editOption')cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employees[k].employeeId+"'>Edit</a>";
if(placeHolderFor=='deleteOption') cellTemplate.innerHTML="<a href='/styletwo/confirmDeleteEmployee?employeeId="+employees[k].employeeId+"'>Delete</a>";
}

dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);

}  // employee population loop ends here

}

window.addEventListener('load',populateEmployeesGridTable);

function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary=0;
this.panNumber="";
this.aadharCardNumber="";
}
var selectedRow=null;
var employees=[];

function selectEmployee(row,employeeId)
{
if(selectedRow==row) return;
if(selectedRow!=null)
{
selectedRow.style.background="white";
selectedRow.style.color="black";
}
row.style.background="#7C7B7B";
row.style.color="white";
selectedRow=row;
var i;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById("detailPanel_employeeId").innerHTML=emp.employeeId;
document.getElementById("detailPanel_name").innerHTML=emp.name;
document.getElementById("detailPanel_designation").innerHTML=emp.designation;
document.getElementById("detailPanel_gender").innerHTML=emp.gender;
document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.dateOfBirth;
if(emp.isIndian)
{
document.getElementById("detailPanel_isIndian").innerHTML="Yes";
}
else
{
document.getElementById("detailPanel_isIndian").innerHTML="No";
}
document.getElementById("detailPanel_basicSalary").innerHTML=emp.basicSalary;
document.getElementById("detailPanel_panNumber").innerHTML=emp.panNumber;
document.getElementById("detailPanel_aadharCardNumber").innerHTML=emp.aadharCardNumber;
}