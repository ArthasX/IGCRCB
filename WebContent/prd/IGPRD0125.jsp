<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>
<html:html>
<bean:define id="id" value="IGPRD0125" toScope="request" />
<bean:define id="title" value="表单联动管理页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

function ope(pdid){
	location.href = "IGPRD0125.do"+"?&pdid="+pdid;	
}
function opedel(plid,pdid){
	if(window.confirm("确认删除该级联表单？")){
		location.href = "IGPRD0125_Del.do?&plid="+plid+"&pdid="+pdid;			 
		}	
}

	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0125_Disp" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 表单联动管理</p>
<div class="back"><a href="IGPRD0101_Back.do" target="_self">返回</a></div> 
</div>
	<div id="formwrapper">
	<fieldset>
					   <legend>流程信息</legend>
                    <div>
						<label for="Name"><strong><span class="red"></span>流程名称</strong>：</label>
						${IGPRD0125Form.pdname}
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red"></span>流程说明</strong>：</label>
						${IGPRD0125Form.pddesc}
						<br>
    				</div>
    				</fieldset>
    				</div>
	<div id="results_list">
	<ig:message /> 
	<table class="table_style">
		<tr>
			<th width="10%">主动表单</th>
			<th width="10%">联动表单</th>
			<th width="10%">联动描述</th>
			<th width="10%">表单类型</th>
			<th width="10%">调用BL</th>
			<th width="10%">JS事件</th>
			<th width="10%">删除</th>
		</tr>
		<logic:present name="IGPRD01251VO" property="processLinkageDefList">
			<logic:iterate id="bean" name="IGPRD01251VO"
				property="processLinkageDefList" indexId="index">
				<tr>
					<td>${bean.initiativepidname}</td>
					<td>${bean.passivitypidname}</td>
					<td>${bean.pldesc}</td>
					<td>
						<ig:codeValue ccid="PROCESS_LINK_CODE" cid="${bean.pljtype}"/>
					</td>
					<td>${bean.plblname}</td>
					<td>${bean.pljsevent}</td>
					
					<td>
					<a href="javascript:opedel('${bean.plid}','${bean.pldpdid}');"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	
	<input name="add" type="button" class="button"
		value="增加" onclick="ope('${IGPRD0125Form.pdid}');" /> 

	</div>
	
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>