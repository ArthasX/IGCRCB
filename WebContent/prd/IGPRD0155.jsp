<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0155" toScope="request" />
<bean:define id="title" value="按钮事件配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function toback(pdid) {
		form.action = getAppRootUrl() + "/IGPRD0104_Back.do?ppsdid=${IGPRD0141Form.ppsdid}&pdid=" + pdid;
		form.submit();
	}
	function checkForm() {
		if ($F('pedblid').trim() == "") {
			alert("请输入流程名称！");
			return false;
		}
		if ($F('pedblid').strlen() > 32) {
			alert("前后处理方式不能大于32个字符！");
			return false;
		}
		else {
			var message = '请确认是否新增？';
			
			if (window.confirm(message)) {
				return true;
			} else {
				return false;
			}
		}
	}

	 function add(pdid,psdid,psdcode){
	     form.action = getAppRootUrl() + "/IGPRD0141_Disp.do?pdid="+pdid+"&psdid="+psdid+"&ppsdid=${IGPRD0141Form.ppsdid}&psdcode="+psdcode;
	     form.submit();
	 }
	 function checkDel(){
         if(window.confirm("请确认是否删除？")){
             return true;
         }
        return false;
     }
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form">
     <div id="location">
        <div class="image"></div>
           <p class="fonts1"><ig:navigation />  &gt;&gt; 状态列表  &gt;&gt; 按钮事件配置</p>
        <div class="back">
			<a href="IGPRD0104_Back.do?pdid=${IGPRD0141Form.pdid}&ppsdid=${IGPRD0141Form.ppsdid}" target="_self">返回</a>
        </div>
     </div>
     <div id="results_list"><ig:message /> 
	<table class="table_style">
		<tr>
			<th width="10%">处理顺序</th>
			<th width="10%">按钮名称</th>
			<th width="15%">自定义BL名称</th>		
			<th width="25%">任务描述</th>
			<th width="5%">修改</th>
			<th width="5%">删除</th>
		</tr>
		<logic:present name="IGPRD0141VO" property="">
		
		</logic:present>
		<logic:present name="IGPRD0141VO" property="processStatusButtonDefList">
			<logic:iterate id="bean" name="IGPRD0141VO" property="processStatusButtonDefList" indexId="index" type="com.deliverik.framework.workflow.prd.model.IG156Info">
				<tr>
			        <td>${bean.pseorder}</td>
					<td>${bean.psbdname}</td>
					<td>${bean.pseactionid}</td>			
					<td>${bean.psedec}</td>
					<td><html:link action="/IGPRD0141_Update.do?pseid=${bean.pseid}&ppsdid=${IGPRD0141Form.ppsdid}&psdcode=${psdcode}&psdid=${psdid}&pdid=${pdid}"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改" /></html:link></td>
					<td><html:link action="/IGPRD0141_Delete.do?pseid=${bean.pseid}&ppsdid=${IGPRD0141Form.ppsdid}&pdid=${bean.pdid}&psdid=${bean.psdid}&psdcode=${psdcode}" onclick="return checkDel();"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></html:link></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
</html:form>
<div id="operate">
<div class="content">
<div class="enter"><html:submit property="btn_add" value="增加"
	styleClass="button" onclick="return add('${pdid}','${psdid}','${psdcode}');" /> <html:submit
	property="btn_back" styleClass="button" value="返回"
	onclick="javascript:toback('${pdid}')" /></div>
</div>
</div>
</div>
</div>
</div>
</div>

</body>
</html:html>
