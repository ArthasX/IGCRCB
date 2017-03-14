<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="com.deliverik.infogovernor.prr.vo.IGPRR01011VO"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>

<html>
<bean:define id="id" value="IGDRM0701" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<% 
IGPRR01011VO vo = (IGPRR01011VO)request.getSession().getAttribute("IGPRR01011VO");
	String lastrowwidth = "";
	String trStartTag = "";
	String trEndTag = "";
	String tdStartTag = "";
	String textSize = "32";
	String textAreaSize = "25";
	int columnNum = 0;
	boolean privateIsNull = true;
%>
<logic:present name="IGPRR01011VO" property="process">
<script src="js/prr/<%=(vo.getProcess()!=null && vo.getProcess().getPrpdid()!=null) ? vo.getProcess().getPrpdid().substring(0,5) : "" %>.js" charset="GBK"></script>
</logic:present>

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="<html:rewrite forward='script.js'/>"></script>
<script type="text/javascript" src="js/tableform.js"></script>
<script type="text/javascript">
var formFileArr = new Array();
var assetFormArr = new Array();
var gid='IGPRR0101';
var num = 0;
var processObj;
var columnNameInfo = null;
var cpidid = null;

function selectTree(index,ccidinfo,selecedlast){
	num = index;
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = "";
		$("pivartreename[" + num + "]").value = "";
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
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
			$("pivarvalue[" + num + "]").value = treesyscode + "_tree_" + name;
			$("pivartreename[" + num + "]").value = name;
		}else{
			$("pivarvalue[" + num + "]").value = '';
			$("pivartreename[" + num + "]").value = '';
		}
		
	}		
	if($("pivartreename[" + num + "]").onchange){
		$("pivartreename[" + num + "]").onchange();
	}
	num = 0;
}

function selectRole(){
	var roleid = document.getElementById("prroleid").value;
	var pdid = document.getElementById("pdid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0101_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdid+"&roleid="+roleid);

}
function changePrRolename(){
	var obj = IGPRR0101Form.prroleid;
	IGPRR0101Form.prrolename.value = obj.options[obj.selectedIndex].text;
}
function selectEntityItem(index){
    num = index;
    openSubIGCOM0302();
}

function selectProject(index){
	num = index;
	openSubWindow('/IGFIN0108_Disp.do', '_blank','1000','600');
}
function openSVCPage(obj,index,ccid){
	processObj = obj.parentElement.childNodes[0];
	num = index;
	openSubWindow('/IGSVC0107_Disp.do?prpdid=' + ccid, '_blank','1000','600');
}

function setParams(prcorid,prcortype,prcortitle){
	var id = processObj.parentElement.parentElement.id;
	var value="";
	var rvalue = "";
	if(processObj.name == "show_value"){
		rvalue = $("pivarvalue[" + num + "]").value;
	}
	if(processObj.name == "column_show"){
		rvalue = getTarget(processObj.parentElement.parentElement.parentElement.parentElement).value;
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
        processObj.value = prcortitle;
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
	if(processObj.name == "show_value"){
		$("pivarvalue[" + num + "]").value = cvalue;
	}
	if(processObj.name == "column_show"){
		getTarget(processObj.parentElement.parentElement.parentElement.parentElement).value = cvalue;
	}
	num = 0;
	processObj = null;
}
function setPrjParams(pid,pcode,pname){
	if("" == pid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarprjname[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = pid + "_prj_" + pname;
		$("pivarprjname[" + num + "]").value = pname;
	}
	num = 0;
}

function selectRoleOnIGSYM0306(index,pdid){
    num = index;
    openSubIGSYM0306(pdid);
}
function setRoleParams(roleid,rolename) {
	if("" == roleid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarrolename[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = roleid + "_role_" + rolename;
		$("pivarrolename[" + num + "]").value = rolename;
	}
	num = 0;
}

function setRadio(index,obj){
	$("pivarvalue[" + index + "]").value = obj.value;
}

function setRadio_other(index,obj,obj2){
	$("pivarvalue[" + index + "]").value = obj.value;
	if(obj2 == 'other'){
		$("pivarvalue_Other[" + index + "]").value = "";
		$("pivarvalue_Other[" + index + "]").style.display = "";
	}else{
		$("pivarvalue_Other[" + index + "]").style.display = "none";
	}
}
function setOnChage_other(index,obj){
	$("pivarvalue[" + index + "]").value = "cv_cev_" + obj.value;
}

function setCheckbox(index,obj){
	var checkboxvalue = $("pivarvalue[" + index + "]").value;
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
				if(i == 0){
					afterDelValue = str[i];
				}else{
					afterDelValue += "#"+str[i];
				}
			}
		}
		checkboxvalue = afterDelValue;
	}
	$("pivarvalue[" + index + "]").value = checkboxvalue;
}
function checkForm(action,vbrequired){
	var title = "";
	var desc = "";
	packagingTableValue();
	<logic:present name="IGPRR01011VO" property="processTitleDefTB">
		<bean:define id="processTitleTB" name="IGPRR01011VO" property="processTitleDefTB" type="com.deliverik.framework.workflow.prd.model.IG243Info" />
		<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="ptitleaccess">
			<logic:empty name="processTitleTB" property="ptitlename">
				title="主题简述";
			</logic:empty>
			<logic:notEmpty name="processTitleTB" property="ptitlename">
				title="${processTitleTB.ptitlename}";
			</logic:notEmpty>
			if($F('prtitle').trim()==""){
				alert("请输入"+title+"！");
				return false;
			}
			if($F('prtitle').strlen()>160){
				alert(title+"不能大于"+Math.floor(160/strByteFlag)+"个汉字！");
				return false;
			}
		</logic:equal>
		<logic:equal value="0" name="processTitleTB" property="pdescaccess">
			<logic:empty name="processTitleTB" property="pdescname">
				desc="内容描述";
			</logic:empty>
			<logic:notEmpty name="processTitleTB" property="pdescname">
				desc="${processTitleTB.pdescname}";
			</logic:notEmpty>
			if($F('prdesc').trim()==""){
				alert("请输入"+desc+"！");
				return false;
			}
			if($F('prdesc').strlen()>3000){
				alert(desc+"不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
				return false;
			}
		</logic:equal>
	</logic:present>
	
	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
				<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
					<logic:equal value="8" name="psid" property="pidtype">
					var rq = '${psid.pidrequired}';
					if(vbrequired=="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO%>"){
					    rq = '0';
					}
					var vflag = checkTableForm('${psid.pidid}','${psid.pidname}',rq);
					if(!vflag){
						return false;
					}
					</logic:equal>
					<logic:notEqual value="8" name="psid" property="pidtype">
					if(vbrequired=="<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES%>"){
						<logic:equal value="1" name="psid" property="pidrequired">
						<logic:equal value="P" name="psid" property="pidtype">
						var tb = document.getElementById("people_${psid.pidid}");
						if(tb.rows.length < 2){
							alert("请选择人员！");
							go = "0";
							return false;
						}
						</logic:equal>
						<logic:notEqual value="P" name="psid" property="pidtype">
							if($F('pivarvalue[${index}]').trim() == ""){
								alert("请输入${psid.pidlabel}！");
								return false;
							}
						</logic:notEqual>
						</logic:equal>
					}
					<logic:equal value="7" name="psid" property="pidtype">
						if(checkFloatNum($F('pivarvalue[${index}]'))){
				    		alert("${psid.pidlabel}为数字,整数位最多13位,小数位最多2位!");
							return false;
						}
					</logic:equal>
					if($F('pivarvalue[${index}]').strlen()>3000){
						alert("${psid.pidlabel}不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
						return false;
					}
					</logic:notEqual>
				</logic:equal>
			</logic:present>
		</logic:iterate>
	</logic:present>
	
	<logic:present name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
	<logic:iterate id="bean" name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
	if('${bean.vbid}'==action){
		<logic:notEmpty name="bean" property="vbacturl">
			if(!${bean.vbacturl}('${IGPRR0101Form.prid}','${IGPRR0101Form.pdid}')) {
				return false;
			};
		</logic:notEmpty>
	}
	</logic:iterate>
	</logic:present> 
	
	if( window.confirm("您是否确认提交？")){
		
		//移除表格类表单要添加列模板table wangtingzhi  
		deleteTemplate();
		
		$("action").value = action;
		if($F('prtitle').trim()=="" && $F('prdesc').trim() !="" ){
			$("prtitle").value = "${IGPRR0101Form.prusername}"+"_"+"${IGPRR0101Form.prpdname}";
		}
		if($F('prtitle').trim() !="" && $F('prdesc').trim() =="" ){
			$("prdesc").value = $("prtitle").value;
		}
		if($F('prtitle').trim()=="" && $F('prdesc').trim() =="" ){
			$("prdesc").value = "${IGPRR0101Form.prusername}"+"_"+"${IGPRR0101Form.prpdname}";
			$("prtitle").value = "${IGPRR0101Form.prusername}"+"_"+"${IGPRR0101Form.prpdname}";
		}
		return true;
	} else {
		return false;
	}
}

function checkTableForm(pidid,pidname,pidrequired){
	if(columnNameInfo == null){
		packagingTableColumnDef();
	}
	var pids = columnNameInfo[pidid];
	var len = 0;
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
function packagingTableColumnDef(){
	columnNameInfo = new Array();
	<logic:present name="AD_columnInfoMap" scope="session">
		<logic:iterate id="map" name="AD_columnInfoMap">
			var columnNames = new Array();
			<bean:define id="list" name="map" property="value"/>
			<logic:iterate id="bean" name="list">
				var columnInfo = new Array();
				columnInfo["pidname"] = "${bean.pidname }";
				columnInfo["pidrequired"] = "${bean.pidrequired}";
				columnInfo["pidtype"] = "${bean.pidtype}";
				columnNames["${bean.pidid }"] = columnInfo;
			</logic:iterate>
			columnNameInfo["${map.key }"] = columnNames;
		</logic:iterate>
	</logic:present>
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

function ShowpProcessFlow(){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?pdid=${IGPRR0101Form.pdid}&psdid=${IGPRR0101Form.psdid}',null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
var asmNum=0;
var tp=0;
function addEntity(pidid,syscoding , index, required, property) 
{	
	tp=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' asm='" + pidid + "' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "','"+ syscoding +"')\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deleteEntity(this, '" + pidid + "','" + property + "')\" style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";
	asmNum++;
	
}

function addSingleEntity(pidid,syscoding , index, required, property) 
{	
	tp=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' asm='" + pidid + "' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "','"+ syscoding +"')\" style='cursor: hand'/>&nbsp;&nbsp;<input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";
	asmNum++;
	
}

function deleteEntity(obj, pidid, property)
{
	var curRow= obj.parentNode.parentNode;
	$("tbentity" + pidid).deleteRow(curRow.rowIndex);
	checkAsm(pidid, property);
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

function selectEntity(index, pidid,syscoding){
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
			$("entityname[" + num + "]").value = einame ;
			if(pidid != 'A'){
				$("pivarvalue[" + tp + "]").value = "N/A";
			}
		}
	
		num = 0;
	}

}

function selectOrgTree(index){
	num = index;
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = '';
		$("pivartreename[" + num + "]").value = '';
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		$("pivarvalue[" + num + "]").value = temp.split("|")[0]+"_OrgTree_"+temp.split("|")[1];
		$("pivartreename[" + num + "]").value = temp.split("|")[1];
	}
	num = 0;
}

function initAttFormFile(){
	if(formFileArr.length > 0){
		for(var i=0;i<formFileArr.length;i++){
			addSingleFileMuti(formFileArr[i]);
		}
	}
	if(assetFormArr.length > 0){
		for(var k=0;k<assetFormArr.length;k++){
			var params = assetFormArr[k].split("_");
			addSingleEntity(params[0],params[1],params[2],params[3],params[4]);
		}
	}
	
	   <logic:present name="IGPRR01011VO" property="processStatusDef">
	    <bean:define id="processStatusDef" name="IGPRR01011VO" property="processStatusDef"/>
	    <logic:notEmpty name="processStatusDef" property="jsfunction">
	        ${processStatusDef.jsfunction}();
	    </logic:notEmpty>
	    </logic:present>
}
function selectPeople(pidid,roletype,index){
	if(roletype == "N/A"){
		roletype = "";
	}
	cpidid = pidid;
	num = index;
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
var arr_pididObj = new Array();
var arr_pidlabelObj = new Array();
//定义表单全路径实体对象
function pidObj(pidid, pidlabel, pididPar) {
	this.pidid = pidid;
	this.pidlabel = pidlabel;
	this.pidlabelFull = null;
	if(pididPar) {
		this.pididPar = pididPar;
	} else {
		this.pididPar = null;
	}
}
//通用表单
<logic:present name="IGPRR01011VO" property="processInfoDefmap">
<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
<logic:present name="psid">
	arr_pididObj['${pidid}'] = new pidObj('${psid.pidid}', '${psid.pidlabel}');
</logic:present>
</logic:iterate>
</logic:present>
//递归拼接表单名全路径
function getFullPidlabel(pidid) {
	var obj = arr_pididObj[pidid];
	if(!obj) return "";
	if(obj.pididPar) {
		return getFullPidlabel(obj.pididPar) + "#" + obj.pidlabel;
	} else{
		return obj.pidlabel;
	}
}
//将表单全路径赋予实体
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pididObj[obj].pidlabelFull = getFullPidlabel(obj);
	}
}
//填充表单全路径集合
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pidlabelObj[arr_pididObj[obj].pidlabelFull] = obj;
	}
}
//根据表单名获取通用表单控件
function getFormObj(pidlabel) {
	return $("pidid" + arr_pidlabelObj[pidlabel]);
}
//取得表格行号
function getTableRownum(obj,tableFlag){
	var rownum = "";
	var rownums = null;
	if("1" == tableFlag){
		var thisTD = obj.parentElement;
		var tb = obj.parentElement.parentElement.parentElement;
		if(tb.rows[0].name == "titlerow"){
			if(tb.rows.length > 2){
				rownums = tb.rows[2].cells[thisTD.cellIndex].childNodes;
			}
		}else{
			if(tb.rows.length > 1){
				rownums = tb.rows[1].cells[thisTD.cellIndex].childNodes;
			}
		}
	}else{
		var thisTD = obj.parentElement;
		var tr = thisTD.parentElement;
		if(tr.cells.length > thisTD.cellIndex + 1){
			rownums = tr.cells[thisTB.cellIndex + 1].childNodes;
		}
	}
	if(rownums != null && rownums.length > 0){
		for(var i=0;i<rownums.length;i++){
			if(rownums[i].name == "column_rownumber"){
				rownum = rownums[i].value;
			}
		}
	}
	return rownum
}

//=====组装表单全路径集合开始
var arr_pididObj = new Array();
var arr_pidlabelObj = new Array();
//定义表单全路径实体对象
function pidObj(pidid, pidlabel, pididPar) {
	this.pidid = pidid;
	this.pidlabel = pidlabel;
	this.pidlabelFull = null;
	if(pididPar) {
		this.pididPar = pididPar;
	} else {
		this.pididPar = null;
	}
}
//递归拼接表单名全路径
function getFullPidlabel(pidid) {
	var obj = arr_pididObj[pidid];
	if(!obj) return "";
	if(obj.pididPar) {
		return getFullPidlabel(obj.pididPar) + "#" + obj.pidlabel;
	} else{
		return obj.pidlabel;
	}
}
//表格式表单的子表单
<logic:present name="AD_columnInfoMap">
<logic:iterate id="map" name="AD_columnInfoMap" indexId="index" >
<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
<bean:define id="lst_psid" name="map" property="value" type="java.util.List" />
<logic:iterate id="psid" name="lst_psid" indexId="index" >
if("rawdef" == "${pidid}"){
	arr_pididObj['${psid.pidid}']= new pidObj('${psid.pidid}', '${psid.pidlabel}');
}else{
	arr_pididObj['${psid.pidid}']= new pidObj('${psid.pidid}', '${psid.pidlabel}', '${pidid}');
}
</logic:iterate>
</logic:iterate>
</logic:present>
//将表单全路径赋予实体
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pididObj[obj].pidlabelFull = getFullPidlabel(obj);
	}
}
//填充表单全路径集合
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pidlabelObj[arr_pididObj[obj].pidlabelFull] = obj;

	}
}
//根据表单名获取通用表单控件
function getFormObj(pidlabel) {
	return $("pidid" + arr_pidlabelObj[pidlabel]);
}
//根据表单名获取表格式表单中的子表单表单控件
function getTableFormObj(pidlabel, rownumber) {
//		return $(arr_pidlabelObj[pidlabel] + "_" + obj.rownumber);
		return $(arr_pidlabelObj[pidlabel] + "_" + rownumber);
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
	var j = 0;
	var inputs = document.getElementsByTagName("INPUT");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
			arr_objs[j++] = inputs[i];
		}
	}
	inputs = document.getElementsByTagName("TEXTAREA");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
			arr_objs[j++] = inputs[i];
		}
	}
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
	var returnObj;
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
    var returnObj;
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
function delEntity(pieid, pidid, property){
	var flag = window.confirm("您是否确认删除？");
	if(flag){
		document.getElementById(pieid).style.display = "none";
		document.getElementById(pieid + "ENT").style.display = "none";
		pieids = pieids + "#" + pieid;
		document.forms[0].pieids.value = pieids;
		checkAsm(pidid, property);
	}
	return flag;
}

function delSingleEntity(pieid, pidid, property,pidid,syscoding,index,required){
	var flag = delEntity(pieid, pidid, property);
	if(flag){
		addSingleEntity(pidid,syscoding , index, required, property);
	}
}

function checkAsm(pidid, property) {
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
			document.getElementById(property).value = "";
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
</script>
<body onload="initAttFormFile();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRR0101" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	 <ig:ProcessBackUrlTag jump="${IGPRR0101Form.jump}"/>
	</div>
	<div>
		<p class="fonts1" align="center" style="font-size: 20px;">${IGPRR0101Form.prpdname}</p>
	</div>
	<div id="formwrapper" style="display:none"><!--  message --> <!--  /message -->
	<fieldset>
	<legend>发起人信息 </legend>
		<div><label for="Name"><strong>发起人姓名</strong>：</label>
		<html:text property="prusername" size="18" errorStyleClass="inputError imeActive"  readonly="true"></html:text>
	    <html:hidden property="pruserid" />
	    </div>
		<div><label for="Name"><strong>发起人部门</strong>：</label>
		<p class="p2">&nbsp;&nbsp;<bean:write name="IGPRR0101Form" property="prorgname"/></p>
		<html:hidden property="prorgid" />
		</div>
		<div><label for="Name"><strong>发起人联系方式</strong>：</label>
	    <html:text property="prinfo" size="18" errorStyleClass="inputError imeActive" readonly="true"></html:text>
	    </div>
	</fieldset>
	</div>
	<div style="margin-top:10px;margin-right:10px;float: right">
		<a href="javascript:ShowpProcessFlow();">查看流程图</a>
	</div>
	<div id="formwrapper"><ig:message />
	<fieldset>
	<legend>工单信息</legend>
	<table cellspacing="2" class="table_style1">
		<tr style="display:none">
			<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%"></td>
		</tr>
		<tr>
<!-- 			<th> -->
<!-- 				<label for="Name" style="float: right;"><strong><span class="red">*</span>发起人角色</strong>：</label> -->
<!-- 			</th> -->
<!-- 			<td colspan="3"> -->
<%-- 				<logic:present name="IGPRR01011VO" property="disp"> --%>
<%-- 				<logic:equal value="0" name="IGPRR01011VO" property="disp"> --%>
<%-- 					<html:select property="prroleid" errorStyleClass="inputError imeActive" --%>
<%-- 						tabindex="2" styleId = "prroleid" onchange="selectRole();" name="IGPRR0101Form"> --%>
<%-- 					<html:options collection="ADroleList" property="value" name="" labelProperty="label"/> --%>
<%-- 					</html:select> --%>
<%-- 					<html:hidden property="prrolename" name="IGPRR0101Form" styleId="prrolename"/> --%>
<%-- 				</logic:equal> --%>
<%-- 				<logic:notEqual value="0" name="IGPRR01011VO" property="disp"> --%>
<%-- 					<html:text property="prrolename" size="18" errorStyleClass="inputError imeActive"  --%>
<%-- 					readonly="true" name="IGPRR0101Form" styleId="prrolename"/> --%>
<%-- 					<html:hidden property="prroleid" name="IGPRR0101Form" styleId="prroleid"/> --%>
<%-- 				</logic:notEqual> --%>
<%-- 			</logic:present>	 --%>
<!-- 			</td> -->
		</tr>
		<logic:present name="IGPRR01011VO" property="processTitleDefTB">
			<bean:define id="processTitleTB" name="IGPRR01011VO" property="processTitleDefTB" type="com.deliverik.framework.workflow.prd.model.IG243Info" />
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="ptitleaccess">
			<tr>	
				<th>
					<label for="Name" style="float: right;"><strong><span class="red">*</span>
					<logic:empty name="processTitleTB" property="ptitlename">
						主题简述
					</logic:empty>
					<logic:notEmpty name="processTitleTB" property="ptitlename">${processTitleTB.ptitlename}</logic:notEmpty></strong>：</label>
				</th>
				<td colspan="3"><html:text property="prtitle" size="82" errorStyleClass="inputError imeActive" />
				</td>
			</tr>
			</logic:equal>
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="pdescaccess">
			<tr>
				<th><label for="Name" style="float: right;"><strong><span class="red">*</span><logic:empty name="processTitleTB" property="pdescname">内容描述</logic:empty>
				<logic:notEmpty name="processTitleTB" property="pdescname">${processTitleTB.pdescname}</logic:notEmpty></strong>：</label>
				</th>
				<td colspan="3">
<%-- 				<html:textarea property="prdesc" cols="60" rows="6"  errorStyleClass="inputError imeActive"></html:textarea></td> --%>
				<div id="prdescdiv" class="editDiv" style="width:440px;min-height:85px;" contenteditable="true" onkeydown="editDivContent(this);" onblur="getProcessDescValue(this);">
				${IGPRR0101Form.prdesc }
				</div>
				<html:hidden property="prdesc" styleId="prdesc" style="prdesc" name="IGPRR0101Form"/>
			</tr>
			</logic:equal>
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="processTitleTB" property="pdescaccess">
				<html:hidden property="prdesc"/>
			</logic:equal>
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="processTitleTB" property="ptitleaccess">
				<html:hidden property="prtitle"/>
			</logic:equal>
		</logic:present>
	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
					<% 
			if("2".equalsIgnoreCase(psid.getPidaccess()) || "3".equalsIgnoreCase(psid.getPidaccess()) || "4".equalsIgnoreCase(psid.getPidaccess())){
					String rowwidth = StringUtils.isEmpty(psid.getRowwidth())?"0":psid.getRowwidth().trim();
					rowwidth = StringUtils.isEmpty(rowwidth)?"0":rowwidth;
					tdStartTag = "<td>";
					textSize = "32";
					textAreaSize = "25";
					if(StringUtils.isEmpty(lastrowwidth)){
						trStartTag = "<tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("0".equalsIgnoreCase(lastrowwidth)){
						trStartTag = "</tr><tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("1".equalsIgnoreCase(lastrowwidth)){
						if("0".equals(rowwidth)){
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "<td></td><td></td></tr><tr>";
							}
							tdStartTag = "<td colspan=\"3\">";
						}else{
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "";
							}
						}
					}
					if("0".equalsIgnoreCase(rowwidth)){
						columnNum = 0;
					}else{
						columnNum = (columnNum+1)%2;
					}
					lastrowwidth = rowwidth;
					if("0".equals(rowwidth)){
						textSize = "82";
						textAreaSize = "60";
					}
				}
				%>
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
					<%=trStartTag %>
					<logic:equal value="T" name="psid" property="titledisplay">
						<%tdStartTag="<td colspan=\"4\">"; %>
					</logic:equal>
					<logic:notEqual value="T" name="psid" property="titledisplay">
						<logic:notEmpty name="psid" property="piddesc">
							<th>
								<label for="Name" style="float: right;" onmousemove="tooltip.show('<pre>${psid.piddesc}</pre>');" onmouseout="tooltip.hide();"><strong>
								<logic:equal value="1" name="psid" property="pidrequired"><span class="red">*</span></logic:equal>
								${psid.pidlabel}：</strong></label>
							</th>
						</logic:notEmpty>
						<logic:empty name="psid" property="piddesc">
							<th>
								<label for="Name" style="float: right;" ><strong>
								<logic:equal value="1" name="psid" property="pidrequired"><span class="red">*</span></logic:equal>
								${psid.pidlabel}：</strong></label>
							</th>
						</logic:empty>
					</logic:notEqual>
					<%=tdStartTag %>
				</logic:notEqual>
					<ig:formToTag 
						name="IGPRR0101Form" 
						pidid="${pidid }" 
						property="pivarvalue[${index}]" 
						formType="${psid.pidtype }" 
						pidaccess="${psid.pidaccess }"
						pidmode="${psid.pidmode }"
						size="<%= textSize%>"	
						userid="${IGPRR01021VO.userid }"
						roleid="${IGPRR01021VO.roleid }"
						orgid="${IGPRR01021VO.roleid }"
						options="${psid.pidoption }"	
						privatescope="${psid.privatescope}"
						piddefault="${psid.piddefault }"
						pdid="${psid.pdid }"
						ccid="${psid.ccid }"
						pidlabel="${psid.pidlabel }"
						piid="${psid.piid }"
						pidrequired="${psid.pidrequired }"
						textAreaSize="<%=textAreaSize %>"
						hasattach="${psid.hasattach }"
						piddisplay="${psid.piddisplay }"
						pidwidth="${psid.pidwidth }"
						pidrows="${psid.pidrows }"
						piduse="${psid.piduse }"
						value="${psid.pidvalue}"
						showrownum="${psid.showrownum }"		
						pidunit="${psid.pidunit}"
						remarks="${psid.remarks}"
						pidcomment="${psid.pidcomment}"
						showstyles="${psid.showstyles}"
						showline="${psid.showline }"
						titledisplay="${psid.titledisplay }"
						pidhide="${psid.pidhide }"
						jsfunction="${psid.jsfunction }"
						selecedlast="${psid.selecedlast }"
						numbertype="${psid.numbertype }"
						align="${psid.align }"
						/>
				<html:hidden property="pivarname" value="${psid.pidname}" /> 
				<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
				<html:hidden property="pivartype" value="${psid.pidtype}" /> 
				<html:hidden property="pidid" value="${psid.pidid}" />
				<html:hidden property="pidaccess" value="${psid.pidaccess}" />
				<html:hidden property="piid" value="${psid.piid}" />
				<html:hidden property="pidmode" value="${psid.pidmode}" />
				<html:hidden property="privatescope" value="${psid.privatescope}" />
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
				</td>
				</logic:notEqual>
				
			</logic:present>
		</logic:iterate>
		<% 
			if(StringUtils.isEmpty(lastrowwidth)){
			}
			if("0".equalsIgnoreCase(lastrowwidth)){
				trEndTag = "</tr>";
			}
			if("1".equalsIgnoreCase(lastrowwidth)){
				if(columnNum == 0){
					trEndTag = "</tr>";
				}else{
					trEndTag = "<td></td><td></td></tr>";
				}
			}
			%>
			<%=trEndTag%>
	</logic:present> 
	</table>
	<div style="display:none"><label for="Name"><strong>备注</strong>：</label>
		<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br />
	</div>
	<div id="att"><img src="images/attachment.gif" />
	<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
	<table id="tb">
	</table>
	</div>
</fieldset>
	<div class="enter">
	<div>
	<logic:present name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:iterate id="bean" name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
			<html:submit styleClass="button" value="${bean.vbname}" onclick="return checkForm('${bean.vbid}','${bean.vbrequired }');"/>
		</logic:iterate>
		<html:reset styleClass="button" value="重置"  onclick="return resetDesc();"/>
	</logic:present> 
	</div>
	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0101Form" />
	<html:hidden property="parprid" styleId="parprid" name="IGPRR0101Form" />
	<html:hidden property="parameters" styleId="parameters" name="IGPRR0101Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0101Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0101Form" />
	<html:hidden property="prassetid" styleId="prassetid" name="IGPRR0101Form" />
	<html:hidden property="pts" styleId="pts" name="IGPRR0101Form" />
	<html:hidden property="prpdid" styleId="prpdid" name="IGPRR0101Form" />
	<html:hidden property="strpsidid" styleId="strpsidid" name="IGPRR0101Form" />
	<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
	<input type="hidden" id="addTableColumnFileStr" name="addTableColumnFileStr" value=""/>
	<input type="hidden" id="delTableColumnFileStr" name="delTableColumnFileStr" value=""/>
	<html:hidden property="pieids" value=""/>
	<input type="hidden" id="iWantToTest" name="iWantToTest" value="${iWantToTest}"/>
</html:form></div>
</div>


</div>
</div>

</body>
</html>

