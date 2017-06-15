<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<script type="text/javascript">
	function ope(){
		var pid = window.showModalDialog("IGVIR0304_GetProjectList.do",null,"dialogWidth:800px;dialogHeight:400px;status:no;help:no;resizable:yes");
		if (pid === '' || undefined == pid) {
			return;
		}
		jQuery("#pid").val(pid);
		getVmInfo(pid);
	}
	
	function getVmInfo(pid){
		jQuery.post(getAppRootUrl() + "/IGVIR0301_GetVM.do", "pid=" + pid,
			function(data) {
				if (data === '') {
					return;
				}
				var vmInfo = eval("(" +data + ")");
				// 项目信息
				var porjectInfo = vmInfo.ProjectInfo;
			 	document.getElementById("projectName").value = porjectInfo.projectName;
			 	document.getElementById("expectDeployTime").value = porjectInfo.expectDeployTime;
			 	document.getElementById("projectExpireTime").value = porjectInfo.projectExpireTime;
			 	document.getElementById("projectType").value = porjectInfo.projectType;
			 	document.getElementById("hpid").value = porjectInfo.id;
			});
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
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 项目名称：</strong></label></th>
				<td>
					<input id="projectName" name="projectName" type="text" size="32"/>
					<input id="hpid" name="hpid" type="hidden">
					<img src="images/seek.gif" alt="选择项目" width="16" height="16" border="0" style="cursor: pointer;" onclick="ope()"/>
				</td>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 期望部署时间：</strong></label></th>
				<td>
					<input id="expectDeployTime" name="expectDeployTime" type="text" onclick=showDate(this); readOnly="true" size="32" />
				</td>
			</tr>
			<tr>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 项目类别：</strong></label></th>
				<td><select  name="projectType" value=""><option
							selected value=""></option>
						<option value=poc项目>poc项目</option></select> 
					
				</td>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 项目到期时间：</strong></label></th>
				<td>
					<input id="projectExpireTime" name="projectExpireTime" type="text" onclick=showDate(this); readOnly="true" size="32" />
				</td>
			</tr>
			<tr style="display:none;">
				<th><label style="float: right" for=name><strong>项目说明：</strong></label>
				</th>
				<td>
					<textarea id="projectDesc" name="projectDesc" style="width: 200px; height: 100px;"></textarea>
				</td>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 申请原因：</strong></label></th>
				<td>
					<textarea id="projectApplyReason" name="projectApplyReason" style="width: 200px; height: 100px;"></textarea>
				</td>
			</tr>
		</tbody>
	</table>
</fieldset>

<fieldset>
	<legend>虚机信息</legend>
	<table id="vminfo" cellspacing="0" class="table_form"
		style="margin-top: 5px; width: 98%;">
		<tr>
			<th style="text-align: center;" width="3%">序号</th>
			<th style="text-align: center;" width="15%">虚机模板</th>
			<th style="text-align: center;" width="20%">虚机名称</th>
			<th style="text-align: center;" width="10%">CPU&#40;个&#41;</th>
			<th style="text-align: center;" width="10%">内存&#40;G&#41;</th>
			<th style="text-align: center;" width="10%">硬盘&#40;G&#41;</th>
<!-- 			<th style="twext-align: center;" width="10%">申请时间</th> -->
			<th style="text-align: center;" width="13%">到期时间</th>
			<th style="text-align: center;" width="13%">操作</th>
		</tr>
		<tr id="temp" style="display: none;">
			<td style="text-align: center;"></td>
			<td style="text-align: center;"><select id="sel_template" name="templates"
				style="width: 100px;" onchange="onChange(this)">
					<option></option>
					<option value="">模板1</option>
					<option>模板2</option>
					<option>模板3</option>
			</select></td>
			<td style="text-align: center;"><input name="vmnames" style="width: 100px;" /></td>
			<td style="text-align: center;"><input name="vmcpus" style="width: 30px;" /></td>
			<td style="text-align: center;"><input name="vmmems" style="width: 30px;" /></td>
			<td style="text-align: center;"><input name="vmdisks" style="width: 30px;" /></td>
<!-- 			<td><input name="applyTime" style="width: 80px;" onclick=showDate(this); /></td> -->
			<td style="text-align: center;"><input name="expiryTime" style="width: 80px;" onclick=showDate(this); /></td>
			<td style="text-align: center;">
				<img src="images/bullet_delete.png" alt="删除" width="16" height="16" border="0" style="cursor: pointer;" align="middle" onclick="removeRow(this)"/>
				<img src="images/copy.gif" alt="复制" width="16" height="16" border="0" style="cursor: pointer;" align="middle" onclick="copyRow(this)"/>
			</td>
		</tr>
		<tr>
			<td>
			<img id="addBut" src="images/bullet_add.png" alt="添加" align="middle" width="16" height="16" border="0" style="cursor: pointer;" onclick="addRow(this)"/>
			</td>
			<td>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
<!-- 			<td></td> -->
			<td></td>
			<td></td>
		</tr>
		
	</table>
</fieldset>

<script type="text/javascript">
	// 模板虚拟json对象
	var templateInfo;

	// 添加行
	function addRow(r) {
		var root = r.parentNode.parentNode.parentNode;
		var allRows = root.getElementsByTagName('tr');

		// 克隆模板
		var cRow = allRows[1].cloneNode(true);
		cRow.style.display = "";
		var cRowTds = cRow.getElementsByTagName('td');
		// 设置序号
		cRowTds[0].innerHTML = allRows.length - 2;
		root.insertBefore(cRow, r.parentNode.parentNode);
	}

	// 复制行
	function copyRow(r) {
		var tr = r.parentNode.parentNode;
		var root = tr.parentNode;
		var allRows = root.getElementsByTagName('tr');
		// 克隆当前行
		var stds = tr.getElementsByTagName('td');
		var sourceSel = stds[1].outerHTML;
		var cRow = tr.cloneNode(true);
		cRow.style.display = "";
		var cRowTds = cRow.getElementsByTagName('td');
		// 设置序号
		cRowTds[0].innerHTML = allRows.length - 2;
		cRowTds[1].innerHTML = sourceSel;
		root.insertBefore(cRow, allRows[allRows.length - 1]);
	}

	// 删除行
	function removeRow(r) {
		// 取得table对象
		var tr = r.parentNode.parentNode;
		var root = tr.parentNode;
		var allRows = root.getElementsByTagName('tr');
		// alert(allRows.length);
		if (allRows.length > 4) {
			root.removeChild(tr);
			// 重置序号
			for (var i = 1; i < allRows.length - 1; i++) {
				var cRow = allRows[i];
				var cRowTds = cRow.getElementsByTagName('td');
				cRowTds[0].innerHTML = i - 1;
			}

		} else {
			alert("最后一行不能删除.");
		}
	}

	/*
	 * 功能： 当模板发生变化是联动虚机配置信息
	 */
	function onChange(sel) {
		var sleValue = sel.value;
		var tr = sel.parentNode.parentNode;
		var tds = tr.childNodes;
		// 		var vmname = tds[2].childNodes[0]; // 虚机名称
		var vmcpu = tds[3].childNodes[0]; // CPU
		var vmmem = tds[4].childNodes[0]; // 内存
		var vmdisk = tds[5].childNodes[0]; // 硬盘
		// 当模板为空时清空表单
		if (sleValue === "") {
			vmcpu.value = "";
			vmmem.value = "";
			vmdisk.value = "";
		} else {
			var template = templateInfo[sleValue];
			vmcpu.value = template.numCPU;
			vmmem.value = template.memoryGB;
			vmdisk.value = template.diskGB;
		}
		//alert(templateInfo[sel.value].name);
		// 		alert(vmname.value);
	}

	/*
	 * 功能： 获取模板信息
	 */
	function getTemplate() {
		var objAjax = new Ajax.Request(getAppRootUrl()
				+ "/IGVIR0201_GetTemplate.do", {
			asynchronous : false,
			parameters : 'type=getTopoMapXML',
			onSuccess : function(req, json) {
				var result = req.responseText;
				var sel = document.getElementById("sel_template");
				sel.options.length = 0;
				// var resJson = jQuery.parseJSON(result);
				templateInfo = eval("(" + result + ")"); //强制转换一下json字符串，生成json对象
				sel.options.add(new Option("", ""));
				jQuery.each(templateInfo, function(key, value) {
					sel.options.add(new Option(key.split("@_@")[1], key));
				});
			}
		});
	}

	// 初始化模板信息
	function initVMTemplate() {
		// 初始化获取
		getTemplate();
		// 初始化时触发一次添加按钮
		document.getElementById("addBut").click();
	}
	initVMTemplate();
</script>