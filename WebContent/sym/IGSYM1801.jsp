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
<bean:define id="id" value="IGSYM1801" toScope="request" />
<bean:define id="title" value="首页管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

function ope(){
	location.href = "IGSYM1801_Insert_Init.do";	
}
function opedel(hpid){
	if(window.confirm("确认删除该行？")){
		location.href = "IGSYM1802_Del.do?&hpid="+hpid;		
	}
	
}
function opeedit(hpid){
	location.href = "IGSYM1802_Edit_Init.do?&hpid="+hpid;		
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
<html:form styleId="form" action="/IGPRD0168_Disp" >
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="formwrapper">
    </div>
	<div id="results_list">
	<ig:message /> 
	<table class="table_style">
		<tr>		
			<th width="20%">首页描述 </th>
			<th width="25%">首页显示名称</th>
			<th width="35%">首页URL </th>
			<th width="10%">修改</th>
			<th width="10%">删除</th>
		</tr>
		<logic:present name="IGSYM18011VO" property="firstJspInfoList">
			<logic:iterate id="bean" name="IGSYM18011VO"
				property="firstJspInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">					
					<td>
						${bean.hplabel}
					</td>
					<td>${bean.hptitle}</td>
					
					<td>${bean.hpurl}</td>
				
					<td>
					<a href="javascript:opeedit('${bean.hpid}');"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改" /></a>
					</td>
					<td>
					<a href="javascript:opedel('${bean.hpid}');"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	
	<input name="add" type="button" class="button"
		value="增加" onclick="ope();" /> 
	</div>
	
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>