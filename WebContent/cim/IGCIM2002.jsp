<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM2002" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0103"/>
</bean:define>
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
			<div class="taps"><bean:message bundle="asmResources" key="label.IGCIM0103.InfoTotip"/></div>
			</div>
			<div class="msg_box">
			 <html:form styleId="form" action="/IGCIM2001_Result" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<logic:present name="IGCIM0117Form">
				<logic:equal value="batch" property="type" name="IGCIM0117Form">
				<html:button property="button"   styleClass="button" onclick="window.location='IGCIM0116.do'">
					<bean:message bundle="asmResources" key="button.IGCIM0103.btn_return"/>
				</html:button>
			
				</logic:equal>
				</logic:present>
				<logic:notPresent name="IGCIM0117Form">
				<html:submit property="btn_add_conf" styleClass="button">
					<bean:message bundle="asmResources" key="button.IGCIM0103.btn_AddConfigration"/>
				</html:submit>
		        <html:submit property="btn_back"  styleClass="button">
		        	<bean:message bundle="asmResources" key="button.IGCIM0103.btn_return"/>
		        </html:submit>
				</logic:notPresent>
			</div>
			<html:hidden property="eiid" styleId="eiid" value="${IGCIM20011VO.igcim2001Form.eiidStr}"/>
            <html:hidden property="route" styleId="route" value="1"/>
			</html:form>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>