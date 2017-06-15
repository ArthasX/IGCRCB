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
<bean:define id="id" value="IGPRD0136h" toScope="request" />
<bean:define id="title" value="前后处理配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function toback(pdid) {
		form.action = getAppRootUrl() + "/IGPRD0104_Back.do?viewhistory=1&pdid=" + pdid;
		form.submit();
	}
	 function add(pdid,psdid){
	     form.action = getAppRootUrl() + "/IGPRD0127_Disp.do?pdid="+pdid+"&psdid="+psdid;
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
           <p class="fonts1"><ig:navigation /> &gt;&gt; 历史版本 &gt;&gt; 状态列表&gt;&gt; 前后处理配置</p>
        <div class="back"><html:link href="javascript:toback('${pdid}');">返回</html:link></div>
     </div>
     <div id="results_list"><ig:message /> <input TYPE="hidden"
		name="pdxml" /> <INPUT TYPE="hidden" value="${IGPRD01041VO.imgxml}"
		name=FlowXML onpropertychange='if(AUTODRAW) redrawVML();'>
	<table class="table_style">
		<tr>
			
			<!--  
			<th width="5%">序号</th>
			<th width="14%">流程定义ID</th>
			<th width="16%">流程状态ID</th>
			-->
			<th width="10%">处理顺序</th>
			<th width="15%">任务类型</th>
			<th width="15%">调用的BL</th>		
			<th width="25%">任务描述</th>
		</tr>
		<logic:present name="IGPRD01062VO" property="processEventDefList">
			<logic:iterate id="bean" name="IGPRD01062VO"
				property="processEventDefList" indexId="index">
				<tr>
					
					<!--  
					<td>${index+1}</td>
			        <td>${bean.pdid}</td>
			        <td>${bean.psdid}</td>
			         -->
			        <td>${bean.pedorder}</td>
					<td><logic:equal value="1" name="bean" property="pedtype">前处理 </logic:equal>
					<logic:equal value="2" name="bean" property="pedtype">后处理</logic:equal></td>
					<td>${bean.pedblid}</td>				
					<td>${bean.pedec}</td>
			</logic:iterate>
		</logic:present>

	</table>
	</div>
</html:form>
<div id="operate" style="display:none">
<div class="content">
<div class="enter"><html:submit property="btn_add" value="增加"
	styleClass="button" onclick="return add('${pdid}','${psdid}');" /> <html:submit
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
