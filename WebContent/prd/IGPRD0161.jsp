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
<bean:define id="id" value="IGPRD0161" toScope="request" />
<bean:define id="title" value="外部事件配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	


function toback(pedid) {

		if (pedid) {
			form.action = getAppRootUrl() + "/IGPRD0161_Back.do?pedid=" + pedid;
		} else {
			form.action = getAppRootUrl() + "/IGPRD0161_Back.do";
		}
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

	 function add(pedid){
	     form.action = getAppRootUrl() + "/IGPRD0161_Back.do";
	     form.submit();
	 }
	 function checkDel(){
         if(window.confirm("确认要删除外部事件信息吗！")){
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
           <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 外部事件配置</p>
     </div>
     <div id="results_list"><ig:message /> 
	<table class="table_style">
		<tr>
		    <th width="3%">序号</th>
			<th width="15%">事件ID</th>
			<th width="15%">调用BL</th>
			<th width="20%">描述 </th>		
			<th width="5%">修改</th>
			<th width="5%">删除</th>
		</tr>
		<logic:present name="IGPRD01611VO" property="processExternalDefList">
			<logic:iterate id="bean" name="IGPRD01611VO" property="processExternalDefList" indexId="index" type="com.deliverik.framework.workflow.prd.model.IG992Info">
				<tr>
				    <td>${index+1}</td>
			        <td>${bean.pedeventid}</td>
					<td>${bean.pedaction}</td>			
					<td>${bean.peddesc}</td>
					<td><html:link action="/IGPRD0161_Update.do?pedid=${bean.pedid}"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改" /></html:link></td>
					<td><html:link action="/IGPRD0161_Delete.do?pedid=${bean.pedid}" onclick="return checkDel();"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></html:link></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	
</html:form>
<div id="operate">
<div class="content">
<div class="enter"><html:submit property="btn_add" value="增加"
	styleClass="button" onclick="return add();" /> </div>
</div>
</div>
</div>
</div>
</div>
</div>

</body>
</html:html>

