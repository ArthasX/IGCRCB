<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRJ0110" toScope="request" />
<bean:define id="title" value="统计分析" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
<!--
	function iuseexport(){
		location.href='IGPRJ0110_IuseExport.do';
	}
	function causeexport(){
		location.href='IGPRJ0110_CauseExport.do';
	}
-->
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

	 <!--content  右侧内容-->
	 
<div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 统计分析</p>
    </div>
        
     <div>
     	<html:form>
	     	<ul>
	     		<li><a href="javascript:iuseexport()">投资使用情况报表</a></li>
	     		<li><a href="javascript:causeexport()">投资类合同明细表</a></li>
	     	</ul>
     	</html:form>
     </div>
</div>
</div>
</div>
</div>
</body>
</html:html>