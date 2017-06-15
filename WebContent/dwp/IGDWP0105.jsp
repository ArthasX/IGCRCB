<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGDWP0105" toScope="request" />
<bean:define id="title"	value="工作详细信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript" src="js/tableform.js"></script>
<style type="text/css">
.currenttable{ 
	width:95%;
	margin-top:10px;
	margin-left:auto;
	margin-right:auto;
}
.currenttable tr td{
	height:20px;
	line-height: 20px;
	text-align: left;
 	word-break: break-all;  
     word-wrap:break-word;     
}

.currenttable tr th{
	background-color: #eeeeee;
	text-align: right;
}
</style>
<script type="text/javascript" src="js/process.js" charset="GBK"></script>
<script type="text/javascript" src="js/dwpsys.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
var jQ  = jQuery.noConflict(true);//jquery与prototype冲突
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
function openSVCPage(obj,index,ccid){
	processObj = obj.parentElement.childNodes[0];
	num = index;
	openSubWindow('/IGSVC0107_Disp.do?prpdid=' + ccid, '_blank','1000','600');
}
//通用表单
<logic:present name="IGDWP01051VO" property="processInfoList">
<logic:iterate id="psid" name="IGDWP01051VO" property="processInfoList">
	arr_pididObj['${psid.pidid}'] = new pidObj('${psid.pidid}', '${psid.pidlabel}');
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
function checkForm(){
	<logic:present name="IGDWP01051VO" property="ptdInfo">
		<bean:define id="titleBean" name="IGDWP01051VO" property="ptdInfo"/>
		<logic:equal value="0" name="titleBean" property="ptitleaccess">
			if(jQ("input[name='prtitle']").val()==""){
				alert("请输入${titleBean.ptitlename }!");
				return false;
			}
			if(jQ("#prtitle").val() !="" ){
				if(jQ("input[name='prtitle']").val().length > 200){
					alert("${titleBean.ptitlename }不能大于" + Math.floor(200/strByteFlag) + "个汉字！")
					return false;
				}
			}
		</logic:equal>
		<logic:equal value="0" name="titleBean" property="pdescaccess">
			if(jQ("#prdesc").val() == ""){
				alert("请输入${titleBean.pdescname }!");
				return false;
			}
			if(jQ("#prdesc").val()!=""){
			if(jQ("#prdesc").val().length > 800){
				alert("${titleBean.pdescname }不能大于" + Math.floor(800/strByteFlag) + "个汉字！")
				return false;
			}		
			}
		</logic:equal>
	</logic:present>
	
	<logic:present name="IGDWP01051VO" property="processInfoList">
	<logic:iterate id="psid" name="IGDWP01051VO" property="processInfoList" indexId="index">
	<logic:equal name="psid" property="pidaccess" value="3">
	<logic:notEqual value="8" name="psid" property="pidtype">
	<logic:equal value="1" name="psid" property="pidrequired">
	if('${psid.pidtype}'=="2"){
		if(jQ("select[name='pivarvalue[${index}]']").val() == ""||jQ("select[name='pivarvalue[${index}]']").val()==undefined){
			alert("请输入${psid.pidlabel}！");
			return false;
		}
	}
	if('${psid.pidtype}'=="9"){
		if(jQ("input[name='pivarvalue[${index}]']").val() == ""){
			alert("请输入${psid.pidlabel}！");
			return false;
		}
	}
	if('${psid.pidtype}'=="A"){
		if(jQ("input[name='pivarvalue[${index}]']").val() == ""){
			alert("请输入${psid.pidlabel}！");
			return false;
		}
	}
	</logic:equal>
	if('${psid.pidtype}'=="A"){
		if(jQ("input[name='pivarvalue[${index}]']").val()!=""|| jQ("input[name='pivarvalue[${index}]']").val()!=undefined){
	 		if(jQ("input[name='pivarvalue[${index}]']").val().length>1500){
			alert("${psid.pidlabel}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
			return false;
		 }
		}
	}
	if('${psid.pidtype}'=="9"){
		if(jQ("input[name='pivarvalue[${index}]']").val()!=""){
	 		if(jQ("input[name='pivarvalue[${index}]']").val().length>1500){
			alert("${psid.pidlabel}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
			return false;
		 }
		}
	}
	</logic:notEqual>
	</logic:equal>
	</logic:iterate>
	</logic:present>
	if(window.confirm("是否确认提交？")){
		form.action=getAppRootUrl() + "/IGDWP0105.do";
		form.submit();
	}else{
		return false;
	}
}

jQ(document).ready(function(){
	jQ("#prroleid").change(function(){
		location.href = "IGDWP0105_Disp.do?id=" + jQ("#planid").val() + "&prroleid=" + this.value;
	});
	if(formFileArr.length > 0){
		for(var i=0;i<formFileArr.length;i++){
			addSingleFileMuti(formFileArr[i]);
		}
	}
	if(assetFormArr.length > 0){
		for(var k=0;k<assetFormArr.length;k++){
			var params = assetFormArr[k].split("_");
			addSingleEntity(params[0],params[1],params[2],params[3]);
		}
	}
	<logic:present name="IGDWP01051VO" property="processStatusDef">
	<bean:define id="processStatusDef" name="IGDWP01051VO" property="processStatusDef"/>
	<logic:notEmpty name="processStatusDef" property="jsfunction">
	${processStatusDef.jsfunction}();
	</logic:notEmpty>
	</logic:present>
});

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
// 			$("pivarvalue[" + num + "]").value = treesyscode + "_tree_" + name;
			jQ("input[name='pivarvalue[" + num + "]']").val(treesyscode + "_tree_" + name);
			jQ("input[name='pivartreename[" + num + "]']").val(name);
// 			$("pivartreename[" + num + "]").value = name;
		}else{
			jQ("input[name='pivarvalue[" + num + "]']").val("");
			jQ("input[name='pivartreename[" + num + "]']").val("");
		}
		
	}		
// 	if($("pivartreename[" + num + "]").onchange){
// 		$("pivartreename[" + num + "]").onchange();
// 	}
	num = 0;
}
function setCheckbox(index,obj){
	var checkboxvalue = jQ("input[name='pivarvalue[" + index + "]']").val();
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
	jQ("input[name='pivarvalue[" + index + "]']").val(checkboxvalue);
}
function getEditDivValue(obj,index){
	jQ("input[name='pivarvalue[" + index + "]']").val(getEditValue(obj,true));
}

function onChangeIsAffect(obj){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	if(affect == '是'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "";
		getFormObj("计划影响业务时长（分钟）").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
		getFormObj("计划影响业务时长（分钟）").parentElement.parentElement.style.display = "none";
	}
}
/**
 * 功能：是否影响业务，选择为“否”时，“业务影响范围”、“计划影响时长”，不显示，只有选择“是”时，才显示，默认为隐藏的不显示
 * 配置：是否影响业务表单onchange事件和待发起节点onload事件
 * */
function onChangeIsAffect2(obj){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	if(affect == '是'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "";
		getFormObj("计划影响业务时长（分钟）").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
		getFormObj("计划影响业务时长（分钟）").parentElement.parentElement.style.display = "none";
	}
}
</script>
<logic:present name="IGDWP01051VO" property="processDefinition">
	<bean:define id="pd" name="IGDWP01051VO" property="processDefinition" type="com.deliverik.framework.workflow.prd.model.entity.IG380TB"/>
<%-- 	<script type="text/javascript" src="js/prr/<%=pd.getPdid().substring(0,5)%>.js" charset="GBK"></script> --%>
</logic:present>
<body onload="onChangeIsAffect();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
</div>
<html:form action="/IGDWP0105.do" onsubmit="return checkSubmit(this);" enctype="multipart/form-data" styleId="form">
<ig:message/>
<logic:present name="IGDWP01051VO">
<div id="results_list">
<bean:define id="plan" name="IGDWP01051VO" property="plan"/>
	<fieldset>
		<legend>任务信息</legend>
		<table class="currenttable">
			<tr>
				<th width="15%">任务名称：</th>
				<td>${plan.pname }</td>
				<th width="15%">任务描述：</th>
				<td>${plan.pdesc }</td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>发起者信息</legend>
		<table class="currenttable">
			<tr>
				<th width="15%">姓名：</th>
				<td width="85%">${LOGIN_USER.username }</td>
			</tr>
			<tr>
				<th width="15%">发起者部门：</th>
				<td width="85%">${LOGIN_USER.orgname }</td>
			</tr>
			<tr>
				<th width="15%">发起角色：</th>
				<td width="85%">
					<logic:present name="IGDWP01051VO" property="labelValueBeanList">
						<bean:size id="roleListSize" name="IGDWP01051VO" property="labelValueBeanList"/>
						<logic:equal value="1" name="roleListSize">
							<logic:iterate id="bean" name="IGDWP01051VO" property="labelValueBeanList">
								<html:hidden property="prroleid"/>
								${bean.label }
							</logic:iterate>
						</logic:equal>
						<logic:notEqual value="1" name="roleListSize">
							<html:select property="prroleid" styleId="prroleid">
								<logic:iterate id="bean" name="IGDWP01051VO" property="labelValueBeanList">
									<html:option value="${bean.value }">${bean.label }</html:option>
								</logic:iterate>
							</html:select>
						</logic:notEqual>
					</logic:present>
				</td>
			</tr>
			<tr>
				<th width="15%">联系方式：</th>
				<td width="85%">
					<html:text property="prinfo" styleId="prinfo"/>
				</td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>工单信息</legend>
		<table class="currenttable" id="prinfo">
			<tr>
				<th width="15%">工作类型：</th>
				<td>
					${IGDWP01051VO.processDefinition.pdname }
				</td>
			</tr>
			<logic:present name="IGDWP01051VO" property="ptdInfo">
				<bean:define id="titleBean" name="IGDWP01051VO" property="ptdInfo"/>
				<logic:equal value="0" name="titleBean" property="ptitleaccess">
					<tr>
						<th><span class="red">*</span>${titleBean.ptitlename }：</th>
						<td>
							<html:text property="prtitle" styleId="prtitle" style="width:435px;"/>
						</td>
					</tr>
				</logic:equal>
				<logic:equal value="1" name="titleBean" property="ptitleaccess">
					<tr style="display:none;">
						<td colspan="2">
							<html:hidden property="prtitle" styleId="prtitle" value="${LOGIN_USER.username }_${IGDWP01051VO.processDefinition.pdname}"/>
						</td>
					</tr>
				</logic:equal>
				<logic:equal value="0" name="titleBean" property="pdescaccess">
					<tr>
						<th><span class="red">*</span>${titleBean.pdescname }：</th>
						<td>
							<html:textarea property="prdesc" styleId="prdesc" rows="5" cols="60"></html:textarea>
						</td>
					</tr>
				</logic:equal>
				<logic:equal value="1" name="titleBean" property="pdescaccess">
					<tr style="display:none;">
						<td colspan="2">
							<html:hidden property="prdesc" styleId="prdesc"  value="${LOGIN_USER.username }_${IGDWP01051VO.processDefinition.pdname}"/>
						</td>
					</tr>
				</logic:equal>
			</logic:present>
			<logic:present name="IGDWP01051VO" property="processInfoList">
				<logic:iterate id="psid" name="IGDWP01051VO" property="processInfoList" indexId="index">
					<tr>
						<c:if test="${psid.pidlabel !='相关程序开发流程'}">
							<th>
								<logic:equal value="1" name="psid" property="pidrequired"><span class="red">*</span></logic:equal>
								${psid.pidlabel }：
							</th>
							<td>
								<ig:formToTag 
									name="IGPRR0101Form" 
									pidid="${psid.pidid }" 
									property="pivarvalue[${index}]" 
									formType="${psid.pidtype }" 
									pidaccess="${psid.pidaccess }"
									pidmode="${psid.pidmode }"
									size="32"	
									userid="${LOGIN_USER.userid }"
									roleid="${IGDWP0105Form.prroleid }"
									orgid="${LOGIN_USER.orgid }"
									options="${psid.pidoption }"	
									privatescope="${psid.privatescope}"
									piddefault="${psid.piddefault }"
									pdid="${psid.pdid }"
									ccid="${psid.ccid }"
									pidlabel="${psid.pidlabel }"
									piid="${psid.piid }"
									pidrequired="${psid.pidrequired }"
									textAreaSize="25"
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
								<html:hidden property="pidid" value="${psid.pidid }"/>
								<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
								<html:hidden property="pivartype" value="${psid.pidtype}" /> 
								<html:hidden property="pidaccess" value="${psid.pidaccess}" />
								<html:hidden property="piid" value="${psid.piid}" />
								<html:hidden property="pidmode" value="${psid.pidmode}" />
								<html:hidden property="privatescope" value="${psid.privatescope}" />
								<html:hidden property="parprid" styleId="parprid" />
								<html:hidden property="psdid" styleId="psdid" value="0108406001"/>
							</td>
						</c:if>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</fieldset>
</div>
<html:hidden property="id" styleId="planid"/>
<div class="enter">
	<html:button property="btn_insert" value="保存" styleClass="button" onclick="checkForm();" /> 
</div>
</logic:present>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
<script type="text/javascript">
jQ(document).ready(function(){
	jQ(".editDiv").css("height","100px");
	jQ(".editDiv").css("width","413px");
	jQ("#prdesc").css("width","413px");
	jQ("#prtitle").css("width","412px");
	jQ("input[name^=pivarvalue]").css("width","412px");
	jQ("select[name^=pivarvalue]").css("width","415px");
	jQ("input[name^=pivartreename]").css("width","412px");
});
</script>
</html:html>