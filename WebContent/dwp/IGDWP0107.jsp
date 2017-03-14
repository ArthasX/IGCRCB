<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDWP0107" toScope="request" />
<bean:define id="title"	value="任务编辑" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript" src="js/process.js" charset="GBK"></script>
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#location").find(".back").append("<a href='IGDWP0101_Back.do'>返回</a>");
});

//查找到是那一个被选择了
function findSelected(obj){
	for(var i = 0;i<obj.length;i++){
		if(obj[i].checked){
			return 	obj[i];			
		}			
	}
}
function confirmDisp(){
	if($F("pname").trim() == ""){
		alert("请输入任务名称！");
		return false;
	}
	if(jQuery("#pname").val().length > 40){
		alert("任务名称不能大于" + Math.floor(120/strByteFlag) + "个汉字！");
		return false;
	}
	if($F("pdesc").trim() == ""){
		alert("请输入任务描述！");
		return false;
	}
	if(jQuery("#pdesc").val().length > 150){
		alert("任务描述不能大于" + Math.floor(450/strByteFlag) + "个汉字！");
		return false;
	}
	if($F("startdate").trim() == ""){
		alert("开始日期为空，请检查路径是否合法！");
		return false;
	}
	if($F("phour") == "" || $F("pminute") == ""){
		alert("请选择完整执行时间！")
		return false;
	}
	if($F("enddate") == ""){
		alert("请选择结束日期！");
		return false;
	}
	if(window.confirm("是否确认提交？")){
		return true;
	}else{
		return false;
	}
}
function init(){
	jQuery("#pidid"+$F("pdid")+"067")[0].parentElement.parentElement.style.display = "none";
	// 是否影响业务
	var affect =jQuery("#pidid"+$F("pdid")+"022").val();
 	if(affect == '是'){	// 是否影响业务为是，显示业务影响范围、计划影响业务时长（分钟）
		jQuery("#pidid"+$F("pdid")+"023")[0].parentElement.parentElement.style.display = "";
		jQuery("#pidid"+$F("pdid")+"041")[0].parentElement.parentElement.style.display = "";
	}else{				// 是否影响业务为否，隐藏业务影响范围、计划影响业务时长（分钟）
		jQuery("#pidid"+$F("pdid")+"023")[0].parentElement.parentElement.style.display = "none";
		jQuery("#pidid"+$F("pdid")+"041")[0].parentElement.parentElement.style.display = "none";
	} 
}
</script>
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<style type="text/css">
.currenttable tr td{
	height:20px;
	line-height: 20px;
	text-align: left;
	word-break: break-all;  
    word-wrap:break-word;
}
.currenttable{ 
	width:95%;
	margin-top:10px;
	margin-left:auto;
	margin-right:auto;
}
.currenttable tr th{
/* 	width:139px; */
	background-color: #eeeeee;
	text-align: right;
}
.editDiv{
/* 	height:100%; */
	border:1px solid #ccc;
	margin-left:1px;
	overflow-x:hidden; 
	overflow-y:auto; 
}
</style>
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
	<div class="back"></div>
</div>
<html:form action="/IGDWP0103.do" onsubmit="return checkSubmit(this);">
	<fieldset>
		<legend>任务信息</legend>
		
		<table class="currenttable">
			<tr>
				<th width="15%"><span class="red">*</span>任务名称：</th>
				<td width="85%" colspan="3"><html:text property="pname" styleId="pname" style="width:585px;"/></td>
			</tr>
			<tr>
				<th width="15%"><span class="red">*</span>任务描述：</th>
				<td width="85%" colspan="3"><html:text property="pdesc" styleId="pdesc" style="width:585px;"/></td>
			</tr>
			<tr>
				<th width="15%">开始日期：</th>
				<td width="35%">
					<html:text property="startdate" styleId="startdate" readonly="true"/>
					<img alt="" src="images/date.gif" onclick="calendar($('startdate'));" style="cursor: hand;" border="0">
				</td>
				<th width="15%"><span class="red">*</span>结束时间：</th>
				<td width="35%">
					<html:text property="enddate" styleId="enddate" readonly="true"/>
					<img alt="" src="images/date.gif" onclick="calendar($('enddate'));" style="cursor: hand;" border="0">
				</td>
			</tr>
			<tr>
				<th width="15%"><span class="red">*</span>执行时间：</th>
				<td width="35%">
					<html:select property="phour" styleId="phour">
					<html:option value=""></html:option>
					<%
						for(int i=0;i<24;i++){
							String key = i > 9 ? i + "" : "0" + i;
							%>
							<html:option value="<%=key %>"><%=key %></html:option>
							<%
						}
					%>
				</html:select>
				时&nbsp;
				<html:select property="pminute" styleId="pminute">
					<html:option value=""></html:option>
					<%
						for(int i=0;i<60;i++){
							String key = i > 9 ? i + "" : "0" + i;
							%>
							<html:option value="<%=key %>"><%=key %></html:option>
							<%
						}
					%>
				</html:select>
				分
				</td>
				<th width="15%"><span class="red">*</span>周期类型：</th>
				<td width="35%">
<!-- 					<span> -->
<%-- 					<html:radio property="ptype" value="0">仅一次</html:radio> --%>
<!-- 					</span> -->
					<span>
					<html:radio property="ptype" value="1">日</html:radio>
					</span>
					<span>
					<html:radio property="ptype" value="2">周</html:radio>
					</span>
					<span>
					<html:radio property="ptype" value="3">月</html:radio>
					</span>
					<span>
					<html:radio property="ptype" value="4">季度</html:radio>
					</span>
				</td>
			</tr>
		</table>
		</fieldset>
			<div class="enter">
		<html:hidden property="id" styleId="planid"/>
		<html:hidden property="pdid" name="pdid" value="${IGDWP01071VO.processDefinition.pdid}"/>
		<html:hidden property="pmode" name="IGDWP0103Form" value="${IGDWP0103Form.pmode}"/>
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
</html:form>
		<fieldset>
		<legend>发起者信息</legend>
		<table class="currenttable">
			<tr>
				<th width="15%">姓名：</th>
				<td width="35%">${LOGIN_USER.username }</td>
				<th width="15%">发起者部门：</th>
				<td width="35%">${LOGIN_USER.orgname }</td>
			</tr>
			<tr>
				<th width="15%">发起角色：</th>
				<td width="35%">
					<logic:present name="IGDWP01071VO" property="labelValueBeanList">
						<bean:size id="roleListSize" name="IGDWP01071VO" property="labelValueBeanList"/>
							<logic:iterate id="bean" name="IGDWP01071VO" property="labelValueBeanList">
								${bean.label }
							</logic:iterate>
					</logic:present>
				</td>
				<th width="15%">联系方式：</th>
				<td width="35%">
					${IGDWP0103Form.prinfo }
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
					${IGDWP01071VO.processDefinition.pdname }
				</td>
			</tr>
			<logic:present name="IGDWP01071VO" property="ptdInfo">
				<bean:define id="titleBean" name="IGDWP01071VO" property="ptdInfo"/>
				<logic:equal value="0" name="titleBean" property="ptitleaccess">
					<tr>
						<th>${titleBean.ptitlename }：</th>
						<td>
							${IGDWP0103Form.prtitle }
						</td>
					</tr>
				</logic:equal>
				<logic:equal value="1" name="titleBean" property="ptitleaccess">
					<tr style="display:none;">
						<td colspan="2">
							<html:hidden property="prtitle" styleId="prtitle" value="${LOGIN_USER.username }_${IGDWP01071VO.processDefinition.pdname}"/>
							
						</td>
					</tr>
				</logic:equal>
				<logic:equal value="0" name="titleBean" property="pdescaccess">
					<tr>
						<th>${titleBean.pdescname }：</th>
						<td style="word-break: break-all; word-wrap:break-word;">
							${IGDWP0103Form.prdesc }
						</td>
					</tr>
				</logic:equal>
				<logic:equal value="1" name="titleBean" property="pdescaccess">
					<tr style="display:none;">
						<td colspan="2">
							<html:hidden property="prdesc" styleId="prdesc"  value="${LOGIN_USER.username }_${IGDWP01071VO.processDefinition.pdname}"/>
						</td>
					</tr>
				</logic:equal>
			</logic:present>
			<logic:present name="IGDWP01071VO" property="processInfoList">
				<logic:iterate id="psid" name="IGDWP01071VO" property="processInfoList" indexId="index">
					<tr>
						<c:if test="${psid.pidlabel !='相关程序开发流程'}">
						<th>
							<logic:equal value="1" name="psid" property="pidrequired"></logic:equal>
							${psid.pidlabel }：
						</th>
						<td class="tdclass">
							<ig:formToTag 
								name="IGPRR0102Form" 
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
						</td>
						</c:if>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</fieldset>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>