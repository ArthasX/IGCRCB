var num = 0;
var asmNum=0;
var formFileArr = new Array();
var assetFormArr = new Array();
var processObj = null;
var columnNameInfo = null;
var cpidid = null;
var tempNum = 0;
var arr_pididObj = new Array();
var arr_pidlabelObj = new Array();
var setEntityObj = null;
var tableValueArray = new Array();
function selectTree(obj,ccidinfo,selecedlast){
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		jQuery(obj).parent().find("input[name='show_value']").val("");
		jQuery(obj).parent().find("input[name='pivarvalue']").val("");
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}

		if(treesyscode!=null && name!=null && treesyscode != ''){
			jQuery(obj).parent().find("input[name='show_value']").val(name);
			jQuery(obj).parent().find("input[name='pivarvalue']").val(treesyscode + "_tree_" + name);
		}else{
			jQuery(obj).parent().find("input[name='show_value']").val("");
			jQuery(obj).parent().find("input[name='pivarvalue']").val("");
		}
		
	}	
	jQuery(obj).parent().find("input[name='show_value']").change();
}
function selectProject(obj,index){
	processObj = obj;
	openSubWindow('/IGPRJ0108_SEARCH.do?closeflag=0', '_blank','1000','600');//
}
//查询显示项目基本信息
function selectProjectValue(prjid){
	openSubWindow('/IGPRJ0109_DISP.do?prjid='+prjid, '_blank','1000','600');//
}
function openSVCPage(obj,ccid){
	processObj = obj;
	openSubWindow('/IGSVC0107_Disp.do?prpdid=' + ccid, '_blank','1000','600');
}

function setParams(prcorid,prcortype,prcortitle){
	var $target = jQuery(processObj).parent().parent().parent().parent().parent().find("[name='pivarvalue']");
	var $show_target = jQuery(processObj).parent().find("[name='show_value']");
	var id = $show_target.parent().parent().attr("id");
	var value = "";
	var rvalue = "";
	if($target.length == 1){
		rvalue = $target.val();
	} else {
		$target = jQuery(getTarget(processObj.parentElement.parentElement.parentElement.parentElement));
		rvalue = $target.val();
	}
	var str1 = "";
	var str2 = "",str3 = "";
	var infos = rvalue.split("_processValue_");
	if(infos != null && infos.length > 0){
		str1 = infos[0];
		if(infos.length > 1){
			str2 = infos[1];
		}
		if(infos.length > 2){
			str3 = infos[2];
		}
	}
	if(prcorid == ""){
		processObj.value = "";
	} else {
		value = id + "_id_" + prcorid + "_svc_" + prcortype + "_name=" + prcortitle;
		$show_target.val(prcortitle);
	}
	if(str2 != ""){
		var tempstr = "";
		var adds = str2.split("#");
		if(adds != null){
			var flag = true;
			for(var i=0;i<adds.length;i++){
				if(adds[i].split("_id_")[0] == id){
					if(value != ""){
						tempstr += "#" + value;
					}
					flag = false;
				}else{
					tempstr += "#" + adds[i];
				}
			}
			if(flag){
				tempstr += "#" + value;
			}
		}
		if(tempstr != ""){
			str2 = tempstr.substring(1);
		}else{
			str2 = "";
		}
		
	}else{
		if(value != ""){
			str2 = value;
		}
	}
	var cvalue = str1;
	if(str2 != ""){
		cvalue += "_processValue_" + str2;
	}
	if(str3 != ""){
		cvalue += "_processValue_" + str3;
	}
	$target.val(cvalue);
	$target.change();
	processObj = null;
}
function addProcessForm(pidid,ccid){
	var tb = document.getElementById("processform" + pidid);
	var tr = tb.insertRow();
	var cdate = new Date();
	tr.id = "" + cdate.getFullYear() + cdate.getMonth() + cdate.getDate() + cdate.getHours() + cdate.getMinutes() + cdate.getSeconds() + cdate.getMilliseconds();
	var td = tr.insertCell();
	td.style.border="none";
	td.innerHTML = '<input type="text" size="32" name="show_value" /><img src="images/seek.gif" alt="查询" onclick="openSVCPage(this,\'' + ccid + '\');" style="cursor: hand;" />&nbsp;&nbsp;<img src="images/delate.gif" alt="删除" onclick="deleteProcess(this);" style="cursor: hand;" />';
}
function addSingleProcessForm(pidid,ccid){
	var tb = document.getElementById("processform" + pidid);
	var tr = tb.insertRow();
	var cdate = new Date();
	tr.id = "" + cdate.getFullYear() + cdate.getMonth() + cdate.getDate() + cdate.getHours() + cdate.getMinutes() + cdate.getSeconds() + cdate.getMilliseconds();
	var td = tr.insertCell();
	td.style.border="none";
	td.innerHTML = '<input type="text" size="32" name="show_value" /><img src="images/seek.gif" alt="查询" onclick="openSVCPage(this,\'' + ccid + '\');" style="cursor: hand;" />';
}
function deleteProcess(obj){
	var tr = obj.parentElement.parentElement;
	var $target = jQuery(tr).parent().parent().parent().find("[name='pivarvalue']");
	var id = tr.id;
	var rvalue = null;
	if($target.length == 1){
		rvalue = $target.val();
	}else{
		rvalue = getTarget(tr.parentElement.parentElement).value;
		$target = jQuery(getTarget(tr.parentElement.parentElement));
	}
	var str1 = "";
	var str2 = "",str3 = "";
	var infos = rvalue.split("_processValue_");
	if(infos != null && infos.length > 0){
		str1 = infos[0];
		if(infos.length > 1){
			str2 = infos[1];
		}
		if(infos.length > 2){
			str3 = infos[2];
		}
	}
	if(str2 != ""){
		var infos = str2.split("#");
		var tempstr = "";
		if(infos != null && infos.length > 0){
			for(var i=0;i<infos.length;i++){
				if(infos[i].split("_id_")[0] != id){
					tempstr += "#" + infos[i];
				}
			}
		}
		if(tempstr != ""){
			str2 = tempstr.substring(1);
		}else{
			str2 = "";
		}
	}
	var cvalue = str1;
	if(str2 != ""){
		cvalue += "_processValue_" + str2;
	}
	if(str3 != ""){
		cvalue += "_processValue_" + str3;
	}
	$target.val(cvalue);
	tr.parentElement.deleteRow(tr.rowIndex);
}

function deleteProcessValue(obj,piprrid){
	var $target = jQuery(obj).parent().parent().parent().parent().parent().find("[name='pivarvalue']");
	var rvalue =  $target.val();
	var str1 = "";
	var str2 = "",str3 = "";
	var infos = rvalue.split("_processValue_");
	if(infos != null && infos.length > 0){
		str1 = infos[0];
		if(infos.length > 1){
			str2 = infos[1];
		}
		if(infos.length > 2){
			str3 = infos[2];
		}
	}
	if(str3 == ""){
		str3 = piprrid + "";
	}else{
		str3 += "#" + piprrid;
	}
	$target.val(str1 + "_processValue_" + str2 + "_processValue_" + str3);
	var tr = document.getElementById(piprrid).parentElement.parentElement;
	tr.parentElement.deleteRow(tr.rowIndex);
}

function deleteSingleProcessValue(obj,piprrid,pidid,ccid){
	deleteProcessValue(obj,piprrid);
	addSingleProcessForm(pidid,ccid);
}
function setPrjParams(pid, pname){
	if("" == pid){
		jQuery(processObj).parent().find("[name='show_value']").val("");
		jQuery(processObj).parent().find("[name='pivarvalue']").val("");
		$("pivarvalue[" + num + "]").value = "";
		$("pivarprjname[" + num + "]").value = "";
	} else {
		jQuery(processObj).parent().find("[name='show_value']").val(pname);
		jQuery(processObj).parent().find("[name='pivarvalue']").val(pid + "_prj_" + pname);
	}
	processObj = null;
}

function selectRoleOnIGSYM0306(obj,pdid){
    openSubIGSYM0306(pdid);
    processObj = obj;
}
function setRoleParams(roleid,rolename) {
	if(tablerole){
		getTarget(tablerole).value = roleid + "_role_" + rolename;
		getShowTarget(tablerole).value = rolename;
		tablerole = null;		
	}else{
		if("" == roleid){
			jQuery(processObj).parent().find("[name='show_value']").val("");
			jQuery(processObj).parent().find("[name='pivarvalue']").val("");
		} else {
			jQuery(processObj).parent().find("[name='show_value']").val(rolename);
			jQuery(processObj).parent().find("[name='pivarvalue']").val(roleid + "_role_" + rolename);
		}
		processObj = null;
	}
}

function setRadio(obj){
	jQuery(obj).parent().parent().find("[name='pivarvalue']").val(obj.value);
}

function setRadio_other(obj,obj2){
	setRadio(obj);
	var $other_value = jQuery(obj).parent().parent().find("[name='other_value']");
	if(obj2 == 'other'){
		$other_value.val("");
		$other_value.show();
	}else{
		$other_value.hide();
	}
}
function setOnChage_other(obj){
	jQuery(obj).parent().find("[name='pivarvalue']").val("cv_cev_" + obj.value);
}

function setCheckbox(obj){
	var $target = jQuery(obj).parent().parent().find("[name='pivarvalue']");
	var checkboxvalue = $target.val();
	if(obj.checked){
		if(checkboxvalue == ""){
			checkboxvalue = obj.value;
		}else{
			checkboxvalue = checkboxvalue+"#"+obj.value;
		}
	}else{
		var afterDelValue = "";
		var str = checkboxvalue.split("#");
		for(var i=0; i<str.length;i++){
			if(str[i] != obj.value){
				if(afterDelValue != ""){
					afterDelValue += "#";
				}
				afterDelValue = str[i];
			}
		}
		checkboxvalue = afterDelValue;
	}
	 $target.val(checkboxvalue);
}
function showOrHiddenCheckBoxElse(obj){
	var $other_value = jQuery(obj).parent().find("[name='other_value']");
	if(obj.checked){
		$other_value.show();
	}else{
		$other_value.val("");
		$other_value.hide();
		var $target = jQuery(obj).parent().parent().find("[name='pivarvalue']");
		var checkBoxValue = $target.val();
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				if(valueStr != ""){
					valueStr += "#";
				}
				valueStr += strs[i];
			}
		}
		$target.val(valueStr);
	}
}
function setCheckBoxElseValue(obj){
	var $target = jQuery(obj).parent().parent().find("[name='pivarvalue']");
	var rowValue = $target.val();
	if(rowValue != null){
		var strs = rowValue.split("#");
		var flag = true;
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(valueStr != ""){
				valueStr += "#";
			}
			if(strs[i].indexOf("_cev_") > -1){
				flag = false;
				valueStr += "cv_cev_" + obj.value;
			}else{
				valueStr += strs[i];
			}
		}
		if(flag){
			if($target.val() == ""){
				$target.val("cv_cev_" + obj.value);
			}else{
				$target.val($target.val() + "#cv_cev_" + obj.value);
			}
		}else{
			$target.val(valueStr);
		}
	}
}
function checkTableForm(pidid,pidname,pidrequired){
	if(columnNameInfo == null){
		packagingTableColumnDef();
	}
	var pids = columnNameInfo[pidid];
	for(var pidkey in pids){
		if(pids[pidkey]["pidtype"] == "8"){
			var flag = checkTableForm(pidkey,pidname,pidrequired);
			if(!flag){
				return false;
			}
		}else{
			if(tableValueArray != null){
				var values = tableValueArray[pidkey];
				if(values != null && values.length > 0){
					for(var i=0;i<values.length;i++){
						if(values[i] != null){
							if(values[i].trim() == ""){
								if("1" == pidrequired && "1" == pids[pidkey]["pidrequired"]){
									alert("请输入" + pidname + pids[pidkey]["pidname"] + "！");
									return false;
								}
							}else{
								if(values[i].strlen()>3000){
									alert(pidname + pids[pidkey]["pidname"] + "不能大于" +Math.floor(3000/strByteFlag)+"个汉字！");
									return false;
								}
							}
						}
					}
				}
			}
		}
	}
	return true;
}
function packagingTableValue(){
	tableValueArray = new Array();
	var pidids = document.getElementsByName("column_pidid");
	var values = document.getElementsByName("column_value");
	if(pidids != null){
		for(var i=0;i<pidids.length;i++){
			if(values[i].rownumber.indexOf("#") < 0){
				if(tableValueArray[pidids[i].value] == null){
					var temp = new Array();
					temp[temp.length] = values[i].value;
					tableValueArray[pidids[i].value] = temp;
				}else{
					tableValueArray[pidids[i].value][tableValueArray[pidids[i].value].length] = values[i].value;
				}
			}
		}
	}
}
function addEntity(pidid,syscoding , index, required) {	
	tp=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' asm='" + pidid + "' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "','"+ syscoding +"')\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deleteEntity(this, '" + pidid + "')\" style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";
	asmNum++;
	
}

function addSingleEntity(pidid,syscoding ,required, property) {	
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' asm='" + pidid + "' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "','"+ syscoding +"')\" style='cursor: hand'/>&nbsp;&nbsp;<input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";
	asmNum++;
}

function deleteEntity(obj, pidid){
	var curRow= obj.parentNode.parentNode;
	$("tbentity" + pidid).deleteRow(curRow.rowIndex);
	checkAsm(pidid);
}

function checkAsm(pidid, property) {
	var flag = true;
	var arr = document.getElementsByTagName("INPUT");
	for(var i=0; i<arr.length; i++) {
		if(arr[i].asm == pidid) {
			if(arr[i].type == "text" && arr[i].value > "") {
				flag = false;
				break;
			}
		}
	}
	if(flag) {
		document.getElementById(property).value = "";
	}
}

function selectEntity(index,pidid,syscoding){
	num = index;
	openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding);
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame, ecategory, pidid, eiversion) {
	if(setEntityObj != null){
		var showvalue = null;
		var showvalues = setEntityObj.parentElement.childNodes;
		if(showvalues != null){
			for(var i=0;i<showvalues.length;i++){
				if(showvalues[i].name == "show_value"){
					showvalue = showvalues[i];
				}
			}
		}
		var columnvalue = null;
		var columnvalues = setEntityObj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
		if(columnvalues != null){
			for(var k=0;k<columnvalues.length;k++){
				if(columnvalues[k].name == "column_value"){
					columnvalue = columnvalues[k];
				}
			}
		}
		var crowIndex = setEntityObj.parentElement.parentElement.id;
		if("" == eiid){
			showvalue.value = "";
			if(columnvalue.value != ""){
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex != strs[index].split("_rowIndex_")[0]){
						valueStr += strs[index];
					}
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}else{
			showvalue.value = einame;
			var crowIndex = setEntityObj.parentElement.parentElement.id;
			if(columnvalue.value == ""){
				columnvalue.value = "_entityValue_" + crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
			}else{
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var flag = true;
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex == strs[index].split("_rowIndex_")[0]){
						flag = false;
						valueStr += crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
					}else{
						valueStr += strs[index];
					}
				}
				if(flag){
					valueStr += "#" + crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}
		setEntityObj = null;
	}else{
		if("" == eiid){
			$("entityId[" + num + "]").value = "";
			$("entityname[" + num + "]").value = "";
		} else {
			$("entityId[" + num + "]").value = pidid + "#" + eiid + "#" + eiversion;
			$("entityname[" + num + "]").value = einame;
			if(pidid != 'A'){
				jQuery("#pidid" + pidid).val("N/A");
			}
		}
		num = 0;
	}

}

function selectOrgTree(obj){
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		jQuery("[name='pivartreename["+obj+"]']").val("");
		jQuery("[name='pivarvalue["+obj+"]']").val("");
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		jQuery("[name='pivartreename["+obj+"]']").val(temp.split("|")[1]);
		jQuery("[name='pivarvalue["+obj+"]']").val(temp.split("|")[0]+"_OrgTree_"+temp.split("|")[1]);
	}
}
function selectPeople(pidid,roletype){
	if(roletype == "N/A"){
		roletype = "";
	}
	cpidid = pidid;
	openSubWindow('/IGPRR0303_Disp.do?pidid=' + pidid + '&roletype=' + roletype , '_pblank','1050','600');
}
function setParticipant(obj){
	var tb = document.getElementById("people_" + cpidid);
	var tr,td1,td2,td3,td4,td5;
	if(obj != null && obj.length > 0){
		for(var k=0;k<obj.length;k++){
			for(var n=0;n<tb.rows.length;n++){
				if(obj[k][0] == tb.rows[n].name){
					alert("用户 \"" + obj[k][1] + "\" 在列表中已存在，请重新选择！");
					return true;
				}
			}
		}
		for(var i=0;i<obj.length;i++){
			tr = tb.insertRow();
			tr.name = obj[i][0];
			td1 = tr.insertCell();
			td1.innerHTML = obj[i][1] + 
							'<input type="hidden" name="par_userid" value="' + obj[i][0] + '" />' + 
							'<input type="hidden" name="par_username" value="' + obj[i][1] + '" />';
			td2 = tr.insertCell();
			td2.innerHTML = obj[i][3] +
							'<input type="hidden" name="par_orgid" value="' + obj[i][2] + '" />' +
							'<input type="hidden" name="par_orgname" value="' + obj[i][3] + '" />';
			td3 = tr.insertCell();
			td3.innerHTML = obj[i][5] + 
							'<input type="hidden" name="par_roleid" value="' + obj[i][4] + '" />' + 
							'<input type="hidden" name="par_rolename" value="' + obj[i][5] + '" />';
			td4 = tr.insertCell();
			td4.innerHTML = obj[i][6] + 
							'<input type="hidden" name="par_phone" value="' + obj[i][6] + '" />';
			td5 = tr.insertCell();
			td5.style.textAlign = "center";
			td5.innerHTML = '<a href="javascript:void(0);" onclick="deleteParticipant(this);">删除</a>' +
							'<input type="hidden" name="par_pidid" value="' + cpidid + '"/>';
		}
	}
}
function deleteParticipant(obj){
	var tr = obj.parentElement.parentElement;
	tr.parentElement.deleteRow(tr.rowIndex);
}
//根据表单名获取表格式表单中的check子表单的所有选项对象
function getTableFormCheckBox(pidlabel, rownumber){
	var obj = getTableFormObj(pidlabel, rownumber);
	var arr = new Array();
	if(obj != null){
		var spans = obj.parentElement.childNodes;
		if(spans != null && spans.length > 0){
			for(var i=0;i<spans.length;i++){
				var checks = spans[i].childNodes;
				if(checks != null && checks.length > 0){
					for(var k=0;k<checks.length;k++){
						if(checks[k].type == "checkbox"){
							arr[arr.length] = checks[k];
						}
					}
				}
			}
		}
	}
	return arr;
}

//根据表单名获取常规表单中的选项对象
function getFormCheckBox(pidlabel){
    var obj = getFormObj(pidlabel);
    var arr = new Array();
    if(obj != null){
        var spans = obj.parentElement.childNodes;
        if(spans != null && spans.length > 0){
            for(var i=0;i<spans.length;i++){
                var checks = spans[i].childNodes;
                if(checks != null && checks.length > 0){
                    for(var k=0;k<checks.length;k++){
                        if(checks[k].type == "checkbox"){
                            arr[arr.length] = checks[k];
                        }
                    }
                }
            }
        }
    }
    return arr;
}

//将表格式表单的复选框变为只读或可写
function disableTableCheckBox(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
				getTarget(objs[i].parentElement).value = "";
				//清空“其他”并设置为只读
				var showvalue = getShowTarget(objs[i].parentElement);
				showvalue.value = "";
				showvalue.style.display="none";
			}
		}
	}
}

//将常规表单的复选框变为只读或可写
function disableCheckBox(objs,flag){
    if(objs != null && objs.length > 0){
        for(var i=0;i<objs.length;i++){
            objs[i].disabled = flag;
            if(flag){
                objs[i].checked = false;
                //清空“其他”并设置为只读
                var showvalue = getNomalShowTarget(objs[i]);
                if (showvalue !=null){
	                showvalue.value = "";
	                showvalue.style.display="none";
                }
            }
        }
    }
}

//根据表单名获取表格式表单中的子表单表单控件集合
function getTableFormObjs(pidlabel) {
	var arr_objs = new Array();
	jQuery("[id^='" + arr_pidlabelObj[pidlabel] + "_']").each(function(i,o){
		arr_objs[i] = o;
	});
	return arr_objs;
}

//根据表单名获取单附件
function getSingalFileObj(pidlabel, rownumber) {
	var obj;
	if(rownumber) {
		obj = getTableFormObj(pidlabel, rownumber);
	} else {
		obj = getFormObj(pidlabel);
	}
	//return obj.parentElement.childNodes[0].childNodes[0].childNodes[0].childNodes[0].childNodes[1];
	var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
	var returnObj = null;
	for(var i=0;i<temps.length;i++){
		if(temps[i].type == "file"){
			returnObj = temps[i];
			break;
		}
	}
	return returnObj;
}

//取得附件类型表单的文本框对象
function getSingalFileTextObj(pidlabel, rownumber) {
	var obj;
    if(rownumber) {
        obj = getTableFormObj(pidlabel, rownumber);
    } else {
        obj = getFormObj(pidlabel);
    }
    var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
    var returnObj = null;
    for(var i=0;i<temps.length;i++){
        if(temps[i].type == "text"){
            returnObj = temps[i];
            break;
        }
    }
    return returnObj;
}

//取得文本域div
function getEditDiv(obj){
    return obj.parentElement.childNodes[0];
}
var pieids = "";
function delEntity(pieid, pidid){
	var flag = window.confirm("您是否确认删除？");
	if(flag){
		document.getElementById(pieid).style.display = "none";
		document.getElementById(pieid + "ENT").style.display = "none";
		pieids = pieids + "#" + pieid;
		document.forms[0].pieids.value = pieids;
		checkAsm(pidid);
	}
	return flag;
}

function delSingleEntity(pieid, pidid, property,pidid,syscoding,index,required){
	var flag = delEntity(pieid, pidid, property);
	if(flag){
		addSingleEntity(pidid,syscoding , index, required, property);
	}
}

function checkAsm(pidid) {
	var flag = true;
	var flag1 = true;
	var arr = document.getElementsByTagName("INPUT");
	for(var i=0; i<arr.length; i++) {
		if(arr[i].asm == pidid) {
			if(arr[i].type == "text" && arr[i].value > "") {
				flag = false;
				break;
			}
		}
	}
	if(flag) {
		var arr1 = document.getElementsByTagName("A");
		for(var i=0; i<arr1.length; i++) {
			if(arr1[i].asm == pidid) {
				if(arr1[i].style.display != "none") {
					flag1 = false;
					break;
				}
			}
		}
		if(flag1) {
			jQuery("#pidid" + pidid).val("");
		}
	}
}
function resetDesc(){
	document.getElementById("prdesc").value = "";
	if(document.getElementById("prdescdiv")){
		document.getElementById("prdescdiv").innerHTML = "";
	}
	
	var objs = document.getElementsByTagName("div");
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(objs[i].className == "editDiv"){
				objs[i].innerHTML = "";
			}
		}
	}
}
function dealre(){
	var deal=jQuery("#dealrecord").attr("src");
	if(deal=="images/redu.gif"){
		jQuery("#dealrecord").attr("src","images/addd.gif");
		jQuery("#handlerecord").toggle();
	}else{
		jQuery("#dealrecord").attr("src","images/redu.gif");
		jQuery("#handlerecord").toggle();
	}
	
}

var relevantPorcess_prid;
var relevantProcess_pdid;
var relevantProcess_parameters;
var relevantProcess_url;
var relevantProcess_flag;
var relevantProcess_type;
var relevantProcess_psdid;
var relevantProcess_roleid;

function relevantProcess(isMoreRelevantProcess){
	if(isMoreRelevantProcess!='1'){
		showInitProcessPageDialog();
	}else{
		showChooseProcessPageDialog();
	}
}

function showInitProcessPageDialog() {
	if(relevantProcess_flag){
		window.showModalDialog(getAppRootUrl() + "/IGPRR0305_Disp.do?parprid="+relevantPorcess_prid+
            "&prtype=WD&prpdid=" + relevantProcess_pdid+
            "&ptid=8&parameters=" + relevantProcess_parameters,
            null,"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
		window.location.href = relevantProcess_url;
	}
}
function openProcessInfoLog(prid){
	openSubWindow("/IGPRR0123.do?prid="+prid,"_blank",1100,600);
}
function showChooseProcessPageDialog() {
	if(relevantProcess_flag){
	    window.showModalDialog(getAppRootUrl() + "/IGPRR0305_Disp.do?prid=" + relevantPorcess_prid + 
	            "&prtype=" + relevantProcess_type+ 
	            "&pdid=" + relevantProcess_pdid+
	            "&psdid=" + relevantProcess_psdid+
	            "&roleid=" + relevantProcess_roleid+
	            "&parameters=" + relevantProcess_parameters,
	            null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    window.location.href = relevantProcess_url;
	}
}
//并行节点切换
function selectStatus(obj){
	var prid = document.getElementById("prid").value;
	var pdid = document.getElementById("pdid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0102_Disp.do?pdid="+pdid+"&prid="+prid+ "&prstatus=" + obj.value);
}