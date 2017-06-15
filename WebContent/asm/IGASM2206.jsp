<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2106" toScope="request"/>
<bean:define id="title"  toScope="request">
	审计任务信息登记成功界面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
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
			 <html:form styleId="form" action="/IGASM2106" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:submit property="btn_add_conf" styleClass="button" styleId="btn_add_conf">
					继续登记
				</html:submit>
		        <html:submit property="btn_back"  styleClass="button" styleId="btn_back">
		        	返回
		        </html:submit>
			</div>
			</html:form>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>