<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html:html>
<bean:define id="id" value="IGCIM1611" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->

<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 	<div id="location">
          <div class="image"></div>
          <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
          <div class="back"><html:link href="javascript:toback();">返回</html:link></div>
    </div> 

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
        <html:form styleId="form" action="IGCIM1611_Del"  onsubmit="return checkForm()"> 
      
        <div style="text-align: center;">
 			<fieldset>
 				<legend>密码信息</legend>
 				<br/>
				<bean:define id="pwdInfo" name="IGCIM16021VO" property="soc0501Info"></bean:define>
 				<table width="100%" class="table_style">
 					<tr>
 						<th>密码分类</th>
 						<th>服务器IP</th>
 						<th>用户名</th>
 						<th>密码描述</th>
 						<th>登记日期</th>
 					</tr>
 					<tr>
 						<td><ig:codeValue ccid="PWD_TYPE" cid="${pwdInfo.pwdType }"/></td>
 						<td>${pwdInfo.serverIP }</td>
 						<td>${pwdInfo.userName }</td>
 						<td>${pwdInfo.pwdDescription }</td>
 						<td>${pwdInfo.regDate }</td>
 					</tr>
 				</table>
 				<html:hidden property="pid" value="${pwdInfo.pid }"/>
 			</fieldset>
 			<logic:present name="IGCIM16021VO" parameter="soc0502Infos">
 			<c:if test="${fn:length(IGCIM16021VO.soc0502Infos)>0 }">
 			
			<fieldset>
 				<legend>关系列表</legend>
 				<br/>
 				<table width="100%" class="table_style">
 					<tr>
 						<th><input type="checkbox" onclick="cheClick(this)"/></th>
 						<th>关系名称</th>
 						<th>关系描述</th>
 						<th>服务器IP</th>
 						<th>操作内容</th>
 						<th>登记日期</th>
 					</tr>
 					<logic:iterate id="bean" name="IGCIM16021VO" property="soc0502Infos">
	 					<tr>
	 						<td><html:checkbox property="rids" value="${bean.rid }"/> </td>
	 						<td>${bean.rName }</td>
	 						<td>${bean.rDescription }</td>
	 						<td>${bean.serverIp }</td>
	 						<td>${bean.operationInfo }</td>
	 						<td>${bean.regDate }</td>
	 					</tr>
 					</logic:iterate>
 				</table>
 				
 			</fieldset>
 		
 			
 				<html:submit styleClass="button" style="margin-top:10px;" >删除所选</html:submit>
 				</c:if>
 				</logic:present>
 				&nbsp;&nbsp;&nbsp;
 				<html:button styleClass="button" onclick="toAdd()" style="margin-top:10px;" property="btn_add">新增关系</html:button>
 			
 			</div>
 			</html:form>
		 </div>
    </div>
</div>


</div>
	<script type="text/javascript">	

	function cheClick(obj){
		jQuery(":checkbox").attr("checked",jQuery(obj).attr("checked"));
		//,jQuery(obj).attr("checked");
	}
	
	function toback(){
		form.action = getAppRootUrl() + "/IGCIM1601_Back.do";
    	form.submit();
	}
	function toAdd(){
	//	openSubWindow("/IGCIM1611_Disp.do","_blank","400","500");
		form.action = getAppRootUrl()+"/IGCIM1611_Disp.do";
		form.submit();
	}
	function checkForm(){
		if(jQuery(":checkbox[checked=true]").length==0){
			alert("请选择将要删除的关联关系");
			return false;
		}
	}
	</script>
</body>
</html:html>