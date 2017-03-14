<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3103" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	
	function onSearch(){
		form.action = "IGASM3101.do";
		form.submit();
	}
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
				<html:form styleId="form" action="/IGASM3103" onsubmit="return checkSubmit(this);">
					<div class="msg_img">
						<img src="images/Round_Icon_09.gif" border="0" />
					</div>
					<div class="msgcontent1">
					风险指标登记成功!
					<br/>
					<br/>
					<div>
					风险指标编号：
					<a href="IGASM3104_Disp.do?eiid=${eiiddd }&eiversion=1">${eilabel}</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
					</div>
					<br/>
					<br/>
					<br/>
					<br/>
				    <html:submit property="btn_back" value="继续登记" styleClass="button"/>
					<html:submit property="btn_add_conf" value="返回" styleClass="button" onclick="onSearch()"/>
					</div>
					<html:hidden property="eiid" styleId="eiid" value="${IGASM31021VO.entityData.eiid}"/>
		            <html:hidden property="route" styleId="route" value="1"/>
				</html:form>
			</div>
			
		 </div>
    </div>
 </div>


</div>
</body>
</html:html>