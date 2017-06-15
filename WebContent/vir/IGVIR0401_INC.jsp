<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<style type="text/css">
 
input {
 
background-color:expression(this.readOnly==true?"#D8D8D8":"#FFFFFF");
}
 
input[readonly]{
 
background-color:#D8D8D8;
}
select {
background-color:expression(this.disabled==true?"#D8D8D8":"#FFFFFF");
color: expression(this.disabled==true?"#000000":"#FFFFFF");
}
 
select[disabled]{
 
background-color:#D8D8D8;
color:#000000;
}
 

 

</style>
<script type="text/javascript">
	function ope(){
		var pid = window.showModalDialog("IGVIR0304_GetProjectList.do",null,"dialogWidth:800px;dialogHeight:400px;status:no;help:no;resizable:yes");
		if (pid === '' || undefined == pid) {
			return;
		}
		jQuery("#pid").val(pid);
		getVmInfo(pid);
	}
</script>
<fieldset>
	<legend>项目信息</legend>

	<table class=table_style1 cellspacing=2 style="margin-top: 5px;">
		<tbody>
			
			<tr style="display: none"><th width="15%"></th>
			<td width="35%"></td>
			<th width="15%"></th>
			<td width="35%"></td>
			</tr>
			<tr>
				<th><label style="float: right" for=name><strong>申请项目名称：</strong></label></th>
				<td>
					<input id="projectName" name="projectName" type="text" size="32" readonly="readonly" />
					<input id="pid" name="pid" type="hidden" />
					<img src="images/seek.gif" alt="选择项目" width="16" height="16" border="0" style="cursor: pointer;" onclick="ope()"/>
				</td>
				<th><label style="float: right" for=name><strong>期望部署时间：</strong></label></th>
				<td>
					<input id="expectDeployTime" name="expectDeployTime" type="text"   readonly="readonly"  size="32" />
				</td>
			</tr>
			<tr>
				<th><label style="float: right" for=name><strong>项目类别：</strong></label></th>
				<td><select  name="projectType" value="" disabled="disabled"><option
							selected value=""></option>
						<option value=poc项目>poc项目</option></select> 
					
				</td>
				<th><label style="float: right" for=name><strong>项目到期时间：</strong></label></th>
				<td>
					<input id="projectExpireTime" name="projectExpireTime" type="text"  readOnly="true" size="32"  readonly="readonly" />
				</td>
			</tr>
		</tbody>
	</table>
</fieldset>

<fieldset>
	<legend>虚机信息</legend>
	<table id="vminfo" cellspacing="0" class="table_form"
		style="margin-top: 5px; width: 98%;" >
		<tr>
			<th style="text-align: center;" width="5%">序号</th>
			<th style="text-align: center;" width="15%">虚机模板</th>
			<th style="text-align: center;" width="15%">虚机名称</th>
			<th style="text-align: center;" width="10%">CPU&#40;个&#41;</th>
			<th style="text-align: center;" width="10%">内存&#40;G&#41;</th>
			<th style="text-align: center;" width="10%">硬盘&#40;G&#41;</th>
			<th style="text-align: center;" width="10%">部署时间</th>
			<th style="text-align: center;" width="10%">到期时间</th>
<!-- 			<th style="text-align: center;" width="10%">操作</th> -->
		</tr>
		
	</table>
</fieldset>

<script type="text/javascript">
function getVmInfo(pid){
	jQuery.post(getAppRootUrl() + "/IGVIR0401_GetVM.do", "pid=" + pid,
		function(data) {
			if (data === '') {
				return;
			}
			var table = document.getElementById("vminfo");
			var allRows = table.getElementsByTagName('tr');
			
			for (var i = allRows.length -1 ; i > 0; i--) {
				table.deleteRow(i);
			}
			
			
			var vmInfo = eval("(" +data + ")");
			// 项目信息
			var porjectInfo = vmInfo.ProjectInfo;
		 	document.getElementById("projectName").value = porjectInfo.projectName;
		 	document.getElementById("expectDeployTime").value = porjectInfo.expectDeployTime;
		 	document.getElementById("projectExpireTime").value = porjectInfo.projectExpireTime;
		 	document.getElementById("projectType").value = porjectInfo.projectType;
			
			
			// 遍历虚拟信息
			jQuery.each(vmInfo.VmInfo, function (i, value) { 
				var currentRows = table.rows.length; 
				var insertTr = table.insertRow(currentRows);
				
				var insertTd = insertTr.insertCell(0);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = (i+1) + "<input type='checkbox' name='vmids' value='" + value.id + "'>";
				
				insertTd = insertTr.insertCell(1);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = value.templateName;
				
				insertTd = insertTr.insertCell(2);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = value.vmName;
				
				insertTd = insertTr.insertCell(3);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = value.vmCpus;
				
				insertTd = insertTr.insertCell(4);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = value.vmMem;
				
				insertTd = insertTr.insertCell(5);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = value.vmDisk;
				
				insertTd = insertTr.insertCell(6);
				insertTd.style.textAlign="center";
				if (undefined != value.applyTime) {
					insertTd.innerHTML = value.applyTime;
				}
				
				insertTd = insertTr.insertCell(7);
				insertTd.style.textAlign="center";
				insertTd.innerHTML = value.expiryTime;
			 });
		});
}
</script>