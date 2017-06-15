<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM1601" toScope="request"/>
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
     </div> 

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
					<html:form action="IGCIM1601" method="POST">
					<table>
						<tr>
							<td>密码分类:</td>
							<td><html:select property="pwdType">
								 	<ig:optionsCollection ccid="PWD_TYPE" isMakeBlankRow="true" isCodeLabel="true"/>
								</html:select>
								</td>
							<td>服务器IP:</td>
							<td><html:text property="serverIP"/> </td>
							<td>用户名:</td>
							<td><html:text property="userName" /></td>
							<td><html:submit  styleClass="button" value="查询"/></td>
<%-- 							<td><html:button  styleClass="button" property="btn_add" onclick="addPwdInfo()" value="添加"/></td> --%>
						</tr>
					</table>
					</html:form>
		        </div>
		    </div>
		    <div id="results_list">
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th>序号</th>
	       		<th>密码分类</th>
	       		<th>服务器IP</th>
	       		<th>用户名</th>
	       		<th>密码描述</th>
	       		<th>关联关系</th>
	       	</tr>
	       	 <logic:present name="IGCIM16011VO" property="soc0501Infos" >
	       	 	<logic:iterate id="bean" name="IGCIM16011VO" property="soc0501Infos" indexId="index">
	       	 		<tr>
	       	 			<td>${PagingDTO.viewStartCount+index}</td>
	       	 			<td><ig:codeValue ccid="PWD_TYPE" cid="${bean.pwdType }"/> </td>
	       	 			<td>${bean.serverIP }</td>
	       	 			<td>${bean.userName }</td>
	       	 			<td>${bean.pwdDescription }</td>
	       	 			<td><html:link action="/IGCIM1611.do?pid=${bean.pid }" style="border:0px;"><img src = "images/node.png" style="border:0px;"  alt=""/></html:link></td>
	       	 		</tr>
	       	 	</logic:iterate>
	       	 	
	       	 </logic:present>
	       </table>
		 </div>
		<div id="operate">
			 <!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
			 <!-- /paging -->
		</div>
    </div>
</div>


</div>
	<script type="text/javascript">	
	
	
	</script>

</body>
</html:html>