<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM0904" toScope="request" />
<bean:define id="title" value="演练实施发起" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>

#contBox{
	border: 1px solid #55A5DA;
	text-align: center;
	width: 290px;
	height: 290px;
	margin-top: 5px;
	margin-left: 5px;
}
.dvTil{
	color:#fff;
	font-size: 12px;
	background-color: #0077CB;
	height: 32px;
	line-height: 32px;
	font-weight: 600;
	
}
#contBox  ul{
	margin: 0 auto;
}
#contBox li{
	background-color: #D9E6EF;
	margin-top: 1px;
	color: #3E566E;
	height: 30px;
	line-height: 30px;
	
}
#contBox li:HOVER {
	color:#0179C7;
	background-color: #C5E8FE;
	cursor: pointer;
	font-weight: 600;
}
#contBox li span{
	 width:1px; 
	 height:1px; 
	 float:right;
	 border-top:4px solid transparent;
	 border-bottom:4px solid transparent;
	 border-left:4px solid #72879a; 
	 margin-top:10px;
	 margin-right:15px;
	
}
#contBox li:HOVER span {
	width:1px; 
	height:1px; 
	float:right;
	border-top:4px solid transparent;
	border-bottom:4px solid transparent;
	border-left:4px solid #0078c9;
	margin-top:10px; 
	margin-right:15px;
}
</style>

<!-- /header1 -->
<body >
<div id="maincontent">

<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
 <!--content  右侧内容-->
	<div id="contBox">
	<html:form action="/IGDRM0904" styleId="form" >
	<!--  message --> <ig:message /> <!--  /message -->
	
	<div class ="dvTil">应急指挥流程</div>
	<ul>
		<logic:present name="IGDRM09041VO" property="processDefinitionList">
			<logic:iterate id="bean" name="IGDRM09041VO" property="processDefinitionList">
				<li onclick="runProcess('${fn:substring(bean.pdid,0,5)}')"><span></span> ${bean.pdname }</li>
			</logic:iterate>			
		</logic:present>
	</ul>
<%--     <html:hidden property="prtype" styleId="prtype"/> --%>
    <!-- 应急演练prid -->
    <html:hidden property="drillPrid" style="drillPrid"/>
	</html:form>
</div>
</div>


</body>
<script type="text/javascript">
	function runProcess(pdid){
		window.opener.location.href = getAppRootUrl()+"/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid="+pdid+"&ptid=8&parameters="+document.getElementById("drillPrid").value;
		window.close();
	}
	
</script>
</html:html>
