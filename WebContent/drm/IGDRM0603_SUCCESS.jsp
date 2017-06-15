<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0603" toScope="request" />
<bean:define id="title" value="信息提示" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript">
	function jumpIGFAP1104(){
		document.forms[0].action=getAppRootUrl() + "/IGDRM0602_Back.do";
		document.forms[0].submit();
	}
</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
 		<div class="msg">
			<div class="taps">信息提示</div>
			</div>
			<div class="msg_box">
			<html:form>
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent">
<!-- 				<div>修改数据成功！</div> -->
				<ig:message/>
<%-- 				<html:link action="/" style="color:#bb0500;vertical-align: top">&nbsp;&nbsp;增加配置信息</html:link> --%>
				<input type="button" class="button"  value="演练计划管理" onclick="jumpIGFAP1104()"/>
<!-- 				<input type="button" class="button"  value="返回" onclick="backIGFAP1102();"/> -->
			</html:form>
			</div>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>