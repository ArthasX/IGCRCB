<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM04011" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
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

<div class="msg">
			<div class="taps">信息提示</div>
			</div>
			<div class="msg_box">
			<html:form styleId="form" action="/IGDRM0402.do" >
				<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
				<div class="msgcontent"> <ig:message/></div>
				<div class="msgbtn">
				<br/>
		                    <html:submit property="btn_back" value="返回列表" styleClass="button"/>
		                    <html:button property="btn_contiune" styleClass="button" onclick="goAdd()">继续添加</html:button>
				</div>
			</html:form>
			</div>
		 </div>
    </div>
 </div>


</div>
</body>
<script type="text/javascript">
	function goAdd(){
		form.action = getAppRootUrl()+"/IGDRM0401_Disp.do";
		form.submit();
	}
</script>
</html:html>