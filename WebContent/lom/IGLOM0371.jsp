<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0371" toScope="request" />
<bean:define id="title" value="信息提示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->


	<script type="text/javascript">	

	    function init(){
			if($F('rid') > 0){
				//接待工作借款菜单
				SwitchMenu('sub2');
			}else{
				//预制管理借款菜单
				SwitchMenu('sub4');
			}
		}
    </script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>

<div class="msg_box"><html:form styleId="form" action="/IGLOM0102_Disp"
	onsubmit="return checkSubmit(this);">
	<div class="msg_img"><img src="images/Round_Icon_09.gif"
		border="0" /></div>
	<div class="msgcontent"><ig:message /></div>
	<div class="msgbtn">
	<c:if test="${IGLOM0303Form.rid > 0}">
	<input type="button" class="button" value="借款信息" onclick="window.location='IGLOM0314_Back.do?';" />
	</c:if>
	<c:if test="${IGLOM0303Form.rid <= 0}">
	<input type="button" class="button" value="借款管理" onclick="window.location='IGLOM0304.do?lpdstatus_q=';" />
	</c:if>
	</div>
	<html:hidden property="rid" name="IGLOM0303Form" />
</html:form></div>

</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</body>
</html:html>