<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM16021VO"%>
<html:html>
<bean:define id="id" value="IGDRM1603" toScope="session" />
<bean:define id="title" value="事件修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='jquery.tzCheckbox.css'/>" type="text/css">
<script>
var jQ = jQuery.noConflict(true);//jquery与prototype冲突
</script>
<script src="<html:rewrite forward='jquery.tzCheckbox.js'/>"></script>
<style>
#search label {
	margin:2px;
	background-color: #EEEEEE;
	padding-top: 4px;
	padding-right: 2px;
	padding-bottom: 2px;
	padding-left: 4px;
}
</style>
<script type="text/javascript">
	function doEdit() {
		if($('upEventname').value.length>64){
			alert("输入事件名称的字符过多，请重新输入！");	
			return false;
		}
		if($('upEventdes').value.length>256){
			alert("输入事件描述的字符过多，请重新输入！");	
			return false;
		}
		if(window.confirm("确认修改？")){
		form.action = getAppRootUrl() + "/IGDRM1603_Toupdate.do";
		form.submit();
		return true;
		}
	}
</script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">

			<!--content  右侧内容-->

			<div id="contentWrap" >
				<div id="content">
					<html:form action="IGDRM1603_Toupdate.do" styleId="form"
						onsubmit="">
						<div id="location">
							<div class="image"></div>
							<%--  <p class="fonts1"><ig:navigation extname4="事件等级修改"/></p> --%>
							<p class="fonts1">应急管理 &gt;&gt; 事件管理 &gt;&gt;事件等级修改</p>
							<div class="back">
								<a href="IGDRM1602_Disp.do" target="_self">返回</a>
							</div>
						</div>
						<div id="search">
							<div class="img"></div>
							<div class="conditions">


								<html:hidden property="upEventid" styleId="upEventid"
									value="${IGDRM16021VO.eventssInfo.eventid}" />
								<html:hidden property="upLabels" styleId="upLabels"
									value="${IGDRM16021VO.eventssInfo.labels}" />

								<div>
									<label for="Name" ><strong><span class="red">*</span>事件等级名称</strong>：</label>
									<html:text tabindex="1" property="upEventname"
										styleId="upEventname" errorStyleClass="inputError imeDisabled"
										size="12" value="${IGDRM16021VO.eventssInfo.eventname}"  style="width:30%;"/>

									</a> <br />
								</div>
								<div>	
								<div align="center">
								
									<label for="Name" style="float:left;"><strong><span class="red">*</span>事件描述</strong>：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>
								<div>
									<textarea rows="6" cols="80" name="upEventdes" id="upEventdes" value="${IGDRM16021VO.eventssInfo.eventdes}">${IGDRM16021VO.eventssInfo.eventdes}</textarea>
								</div>
<%-- 									<html:textarea property="upEventdes" styleId="upEventdes"   --%>
<%-- 									value="${IGDRM16021VO.eventssInfo.eventdes}" style="width:30%;" rows="6" /> --%>
<%-- 									<html:textarea tabindex="1" property="upEventdes" --%>
<%-- 										styleId="upEventdes" errorStyleClass="inputError imeDisabled" --%>
<%-- 										size="12" value="${IGDRM16021VO.eventssInfo.eventdes}" /> --%>

									</a> <br />
									
								</div>

								</a>
							</div>
							<br />
						</div>
						<div class="enter">
							<input type="button" value="修改" class="button"
								onClick="return doEdit();" />
							<html:reset property="btn_clear" styleClass="button" value="重置" />
						</div>
					</html:form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/include/paging.jsp" />
</body>

</html:html>