<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>

<fieldset>
	<legend>项目信息</legend>

	<table class=table_style1 style="margin-top: 5px;">
		<tbody>
			<tr style="display: none"><th width="15%"></th>
			<td width="35%"></td>
			<th width="15%"></th>
			<td width="35%"></td>
			</tr>
			<tr>
				<th>
					<label style="float: right" for=name>
						<strong>
							<span class=red>*</span> 
							项目名称：
						</strong>
					</label>
				</th>
				<td>
					<input id="projectName" name="projectName" type="text" size="32"/>
				</td>
				<th>
					<label style="float: right" for=name>
						<strong>
							<span class=red>*</span> 
							期望部署时间：
						</strong>
					</label>
				</th>
				<td>
					<input id="expectDeployTime" name="expectDeployTime" type="text" onclick=showDate(this); readOnly="true" size="32" />
				</td>
			</tr>
			<tr>
				<th>
					<label style="float: right" for=name>
						<strong>
							<span class=red>*</span> 
							项目类别：
						</strong>
					</label>
				</th>
				<td>
					<select name="projectType" value="">
						<option selected value=""></option>
						<option value=poc项目>poc项目</option>
					</select> 
					
				</td>
				<th>
					<label style="float: right" for=name>
						<strong>
							<span class=red>*</span> 
							项目到期时间：
							</strong>
						</label>
					</th>
				<td>
					<input id="projectExpireTime" name="projectExpireTime" type="text" onclick=showDate(this); readOnly="true" size="32" />
				</td>
			</tr>
		</tbody>
	</table>
</fieldset>

<fieldset>
	<legend>虚机信息</legend>
	<table class="table_style1" style="margin-top: 5px;width:500px;margin-left:0px;">
		<tr>
			<th>部门名称：</th>
			<td>
				<span id="orginfo"></span>
				<input type="hidden" name="orgname" id="orgname"/>
				<input type="hidden" name="orgid" id="orgid"/>
				<input type="hidden" name="vcid" id="vcid"/>
				<input type="hidden" name="vcname" id="vcname"/>
				<input type="hidden" name="vorg" id="vorg"/>
			</td>
			<th>目录：</th>
			<td>
				<select name="template" id="template">
					<option></option>
				</select>
			</td>
		</tr>
	</table>
	<table id="vminfo" class="table_style" >
		<tr>
			<th style="text-align: center;" width="3%">序号</th>
			<th style="text-align: center;" width="15%">虚机模板</th>
			<th style="text-align: center;" width="15%">虚机名称</th>
			<th style="text-align: center;" width="10%">CPU</th>
			<th style="text-align: center;" width="10%">内存</th>
			<th style="text-align: center;" width="10%">硬盘</th>
			<th style="text-align: center;" width="10%">申请时间</th>
			<th style="text-align: center;" width="13%">到期时间</th>
			<th style="text-align: center;" width="13%">操作</th>
		</tr>
		<tr id="temp" style="display: none;">
			<td></td>
			<td>
<!-- 				<select id="sel_template" name="templates" style="width:100px;" onchange="onChange(this);"> -->
				<select id="sel_template" name="templates" style="width:100px;">
					<option></option>
				</select>
			</td>
			<td><input name="vmnames" style="width: 100px;" /></td>
			<td><input name="vmcpus" style="width: 30px;" />（个）</td>
			<td><input name="vmmems" style="width: 30px;" />（G）</td>
			<td><input name="vmdisks" style="width: 30px;" />（G）</td>
			<td><input name="applyTime" style="width: 80px;" onclick=showDate(this); /></td>
			<td><input name="expiryTime" style="width: 80px;" onclick=showDate(this); /></td>
			<td>
				<img src="images/bullet_delete.png" alt="删除" width="16" height="16" border="0" style="cursor: pointer;" align="middle" onclick="removeRow(this)"/>
				<img src="images/copy.gif" alt="复制" width="16" height="16" border="0" style="cursor: pointer;" align="middle" onclick="copyRow(this)"/>
			</td>
		</tr>
		<tr id="addtr" style="display:none;">
			<td>
			<img id="addBut" src="images/bullet_add.png" alt="添加" align="middle" width="16" height="16" border="0" style="cursor: pointer;" onclick="addRow(this)"/>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
	</table>
</fieldset>
<script type="text/javascript">
	//模板虚拟json对象
	var templateInfo;
	function getBasicInfo(){
		var objAjax = new Ajax.Request(getAppRootUrl() + "/IGVIR3001_Disp.do",{
			asynchronous : false,
			parameters : 'type=getTopoMapXML',
			onSuccess : function(req, json) {
				var result = req.responseText;
				var json = eval("(" + result + ")");
				if(json){
					if(json.resultCode == "success"){
						var orgid = json.orgInfo.orgsyscoding;
						var orgname = json.orgInfo.orgname;
						var vorg = json.orgInfo.vorg;
						var vcid = json.vcInfo.vcid;
						var vcname = json.vcInfo.vcname;
						jQuery("#orginfo").append(orgname);
						jQuery("#orgname").val(orgname);
						jQuery("#orgid").val(orgid);
						jQuery("#vorg").val(vorg);
						jQuery("#vcid").val(vcid);
						jQuery("#vcname").val(vcname);
						jQuery.each(json.catalogs, function(i,o) {
							jQuery("#template").append("<option value='" + o.name + "'>" + o.name + "</option>")
						});
					}
				}
			}
		});
	}
	jQuery(document).ready(function(){
		jQuery("#template").change(function(){
			var catalog = jQuery(this).val(); 
			if(catalog == ""){
				jQuery("#addtr").hide();
			}else{
				var orgname = jQuery("#orgname").val();
				var vorg = jQuery("#vorg").val();
				var vcid = jQuery("#vcid").val();
				var objAjax = new Ajax.Request(getAppRootUrl() + "/IGVIR3001_GetTemplate.do", {
					asynchronous : false,
					parameters : 'catalog=' + catalog + "&orgname=" + orgname + "&vorg=" + vorg + "&vcid=" + vcid,
					onSuccess : function(req, json) {
						var result = req.responseText;
						var sel = document.getElementById("sel_template");
						sel.options.length = 0;
						var json = eval("(" + result + ")"); //强制转换一下json字符串，生成json对象
						if(json.resultCode == "success"){
							templateInfo = json.templateInfo;
							sel.options.add(new Option("", ""));
							jQuery.each(templateInfo, function(i, o) {
								sel.options.add(new Option(o.name,o.name));
							});
						}
					}
				});
				jQuery("#addtr").show();
			}
		});
	});
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
	}
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
	getBasicInfo();
</script>