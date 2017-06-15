<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="com.deliverik.infogovernor.prr.vo.IGPRR01011VO"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>

<html>
<bean:define id="id" value="IGDRM0201" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript" src="js/process.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/tableform.js"></script>
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
	System.out.print(vo.getProcess().getPrpdid());
%>
<logic:present name="IGPRR01011VO" property="process">
<script src="js/prr/<%=(vo.getProcess()!=null && vo.getProcess().getPrpdid()!=null) ? vo.getProcess().getPrpdid().substring(0,5) : "" %>.js" charset="GBK"></script>
</logic:present>

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="<html:rewrite forward='script.js'/>"></script>
<script type="text/javascript">
var gid='IGPRR0101';
function selectRole(){
	var roleid = document.getElementById("prroleid").value;
	var pdid = document.getElementById("pdid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0101_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdid+"&roleid="+roleid);

}
function changePrRolename(){
	var obj = IGPRR0101Form.prroleid;
	IGPRR0101Form.prrolename.value = obj.options[obj.selectedIndex].text;
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
			if($F('prtitle').strlen()>200){
				alert(title+"不能大于"+Math.floor(200/strByteFlag)+"个汉字！");
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
			if($F('prdesc').strlen()>1000){
				alert(desc+"不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
				return false;
			}
		</logic:equal>
	</logic:present>
	
	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
				var rq = '${psid.pidrequired}';
				var obj = document.getElementById("pidid${psid.pidid}");
				<logic:equal value="9" name="psid" property="pidtype">
					obj = jQuery(obj).parent().find("[name='pivarvalue']");
				</logic:equal>
				<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
					<logic:equal value="8" name="psid" property="pidtype">
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
							if(obj.value&&obj.value.trim() == ""){
								alert("请输入${psid.pidlabel}！");
								return false;
							}
						</logic:notEqual>
						</logic:equal>
					}
					<logic:equal value="7" name="psid" property="pidtype">
						if(checkFloatNum(obj.value)){
				    		alert("${psid.pidlabel}为数字,整数位最多13位,小数位最多2位!");
							return false;
						}
					</logic:equal>
					
					<logic:equal value="F" name="psid" property="pidtype">
					<logic:equal value="1" name="psid" property="pidrequired">
						var tb = document.getElementById("${psid.pidlabel}");
						if(tb){
							var fhas = false;
							if(!fhas){
								for(var i=0;i<tb.rows.length;i++){
									for(var j=0;j<tb.rows[i].cells.length;j++){
										var childs = tb.rows[i].cells[j].childNodes;
										for(var n=0;n<childs.length;n++){
											if(childs[n].getAttribute("type") == "file"){
												if(childs[n].value != ""){
													fhas = true;
													break;
												}
											}
										}
									}
								}
							}
							if(!fhas){
								alert("请选择${psid.pidlabel}！");
								go = "0";
								return false;
							}
						}
					</logic:equal>
					</logic:equal>

					
					if(obj.value&&obj.value.strlen()>2100){
						alert("${psid.pidlabel}不能大于"+Math.floor(2100/strByteFlag)+"个汉字！");
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
	
	//场景发起页面表单check 
	if(!checkSituationForm()){
		return false;
	}
	
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

function ShowpProcessFlow(){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?pdid=${IGPRR0101Form.pdid}&psdid=${IGPRR0101Form.psdid}',null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
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
			addSingleEntity(params[0],params[1],params[2],params[3]);
		}
	}
	
	   <logic:present name="IGPRR01011VO" property="processStatusDef">
	    <bean:define id="processStatusDef" name="IGPRR01011VO" property="processStatusDef"/>
	    <logic:notEmpty name="processStatusDef" property="jsfunction">
	        ${processStatusDef.jsfunction}();
	    </logic:notEmpty>
	    </logic:present>
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
</script>
<body onload="initAttFormFile();">
<div id="maincontent"><!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGPRR0101" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
<%-- 	<ig:navigation extname1="${urlable}"/> 解决场景复制不显示导航栏问题--%>
	应急管理 >> 应急场景管理 >> 场景定义
</p> 
	<ig:ProcessBackUrlTag jump="${jump}"/>
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
	<legend>场景信息</legend>
	<table cellspacing="2" class="table_style1">
		<tr style="display:none">
			<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%"></td>
		</tr>
		<tr>
<!-- 			<th> -->
<!-- 				<label for="Name" style="float: right;"><strong><span class="red">*</span>发起人角色</strong>：</label> -->
<!-- 			</th> -->
			<td colspan="3">
				<logic:present name="IGPRR01011VO" property="disp">
				<logic:equal value="0" name="IGPRR01011VO" property="disp">
					<html:select property="prroleid" errorStyleClass="inputError imeActive" style="display :none;"
						tabindex="2" styleId = "prroleid" onchange="selectRole();" name="IGPRR0101Form">
					<html:options collection="ADroleList" property="value" name="" labelProperty="label"/>
					</html:select>
					<html:hidden property="prrolename" name="IGPRR0101Form" styleId="prrolename"/>
				</logic:equal>
				<logic:notEqual value="0" name="IGPRR01011VO" property="disp">
					<html:text property="prrolename" size="18" errorStyleClass="inputError imeActive" 
					readonly="true" name="IGPRR0101Form" styleId="prrolename" style="display :none;"/>
					<html:hidden property="prroleid" name="IGPRR0101Form" styleId="prroleid"/>
				</logic:notEqual>
			</logic:present>	
			</td>
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
					<ig:formToTag 
						name="IGPRR0101Form" 
						pidid="${pidid }" 
						property="pivarvalue" 
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
				<html:hidden property="pidid" value="${psid.pidid}" />
				<html:hidden property="pidaccess" value="${psid.pidaccess}" />
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
	<div style="display:none;">
		<logic:present name="IGPRR01011VO" property="processInfoDefmap">
			<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<%if("Y".equals(psid.getIsFlag())){ %>
				<div style="display:none;">
					<ig:formToTag 
						name="IGPRR0101Form" 
						pidid="${psid.pidid }" 
						property="pivarvalue" 
						formType="${psid.pidtype }" 
						pidaccess="${psid.pidaccess }"
						pidmode="${psid.pidmode }"
						size="32"	
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
				<html:hidden property="pidid" value="${psid.pidid}" />
				<html:hidden property="pidaccess" value="${psid.pidaccess}" />
				</div>
			<%} %>
			</logic:iterate>
		</logic:present>
	</div>
	<div style="display:none"><label for="Name"><strong>备注</strong>：</label>
		<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br />
	</div>
	<div><!--  <img src="images/attachment.gif" />
	<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;-->
	<table id="tb">
	</table>
	</div>
</fieldset>
	<div class="enter">
	<div>
	<logic:present name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:iterate id="bean" name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:equal value="01" name="bean" property="vbid">
			<html:submit styleClass="button" value="${bean.vbname}" onclick="return checkForm('${bean.vbid}','${bean.vbrequired }');"/>
		</logic:equal>
		</logic:iterate>
		<%-- <html:reset styleClass="button" value="重置"  onclick="return resetDesc();"/> --%>
	</logic:present> 
	</div>
	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0101Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0101Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0101Form" />
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
<script type="text/javascript">
//单一场景定义流程
jQ(function(){
	//当前单一场景定义流程pdid
	var pdid = jQ("#pdid").val();
	//场景应急处置步骤
	var jStepPdid = jQ("#pidid"+pdid+"004");
	jStepPdid.parent().parent().hide();
	//应急资源资产
	var jSouEiid = jQ("#pidid"+pdid+"006");
	jSouEiid.parent().parent().hide();
	//old场景应急处置步骤
	var jOldStepPdid = jQ("#pidid"+pdid+"012");
	jOldStepPdid.parent().parent().hide();
	//原资产ID
	var jOldEiid = jQ("#pidid"+pdid+"013");
	jOldEiid.parent().parent().hide();
	//原应急资源资产ID
	var jOldSouEiid = jQ("#pidid"+pdid+"014");
	jOldSouEiid.parent().parent().hide();
	//原prid
	var jOldprid = jQ("#pidid"+pdid+"015");
	jOldprid.parent().parent().hide();
	//审批意见 opinions
	var jOpinions = jQ("#pidid"+pdid+"010");
	jOpinions.parent().parent().hide();
});
</script>
</html>

