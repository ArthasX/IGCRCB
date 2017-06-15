<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<%@page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%><html:html>
<bean:define id="id" value="IGPRD0103" toScope="request"/>
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
			 <html:form styleId="form" action="/IGPRD0103?pttype=${IGPRD0103Form.pttype}" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:submit property="btn_add" value="继续增加" styleClass="button"/>
		        <logic:equal value="<%=IGPRDCONSTANTS.PRTYPE_YEAR%>" name="IGPRD0103Form" property="pttype">
			    	 <html:submit property="btn_search" value="报表管理" styleClass="button"/>
			    </logic:equal>
		        <logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_YEAR%>" name="IGPRD0103Form" property="pttype">
	             	<logic:equal value="<%=IGPRDCONSTANTS.PRTYPE_SEASON%>" name="IGPRD0103Form" property="pttype">
		              	<html:submit property="btn_search" value="报表管理" styleClass="button"/>
		             </logic:equal>
	             	<logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_SEASON%>" name="IGPRD0103Form" property="pttype">
		              	<logic:equal value="<%=IGPRDCONSTANTS.PRTYPE_IRREGULAR%>"  name="IGPRD0103Form" property="pttype">
			               <html:submit property="btn_search" value="报表管理" styleClass="button"/>
			            </logic:equal>
		              	<logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_IRREGULAR%>" name="IGPRD0103Form" property="pttype">
			               	<html:submit property="btn_search" value="流程管理" styleClass="button"/>
			            </logic:notEqual>
	             	</logic:notEqual>
	            </logic:notEqual>
			</div>
			</html:form>
			</div>
		 </div>
    </div>
</div>


</div>

</body>
</html:html>