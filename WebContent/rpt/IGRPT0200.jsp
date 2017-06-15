<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRPT0200" toScope="request"/>
<bean:define id="title"  toScope="request">
<c:if test="${IGRPT0201Form.mode == 0}"> 
	<bean:message bundle="rptResources" key="ietitle.IGRPT0100a"/>
</c:if>
<c:if test="${IGRPT0201Form.mode == 1}"> 
	<bean:message bundle="rptResources" key="ietitle.IGRPT0100b"/>
</c:if>
<c:if test="${IGRPT0205Form.mode == 0}"> 
	<bean:message bundle="rptResources" key="ietitle.IGRPT0100a"/>
</c:if>
<c:if test="${IGRPT0205Form.mode == 1}"> 
	<bean:message bundle="rptResources" key="ietitle.IGRPT0100b"/>
</c:if>
<c:if test="${IGRPT0203Form.mode == 0}"> 
	<bean:message bundle="rptResources" key="ietitle.IGRPT0100b"/>
</c:if>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">
function findforward(){
	location.href="IGRPT0201_ToBack.do";
}
function findforward_add(){
	location.href="IGRPT0203_Disp.do";
}
function findforward05(){
	location.href="IGRPT0204_ToBack.do";
}
function findforward_add05(){
	location.href="IGRPT0205_Disp.do";
}
function findforward_add06(){
	location.href="IGRPT0201_ToBack.do";
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
			<div class="taps"><bean:message bundle="rptResources" key="label.IGRPT0103.InfoTotip"/></div>
			</div>
			<div class="msg_box">
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<c:if test="${IGRPT0203Form.mode==0 }">
		        <html:button property="btn_back"  styleClass="button" styleId="btn_back" onclick="findforward_add06()">
		        	<bean:message bundle="rptResources" key="button.IGRPT0100.btn_search"/>
		        </html:button>
				</c:if>
				<c:if test="${IGRPT0205Form.mode==1 }">
		       <html:button property="btn_back"  styleClass="button" styleId="btn_back" onclick="findforward05()">
		        	<bean:message bundle="rptResources" key="button.IGRPT0100.btn_search"/>
		        </html:button>
				</c:if>
				<c:if test="${IGRPT0205Form.mode==0}">
				<html:button property="btn_return" styleClass="button"  styleId="btn_return" onclick="findforward_add05()">
					<bean:message bundle="rptResources" key="button.IGRPT0100.btn_return"/>
				</html:button>
		        <html:button property="btn_back"  styleClass="button" styleId="btn_back" onclick="findforward05()">
		        	<bean:message bundle="rptResources" key="button.IGRPT0100.btn_search"/>
		        </html:button>
				</c:if>
				<c:if test="${IGRPT0201Form.mode==1 ||IGRPT0201Form.mode==0}">
				<html:button property="btn_return" styleClass="button"  styleId="btn_return" onclick="findforward_add()">
					<bean:message bundle="rptResources" key="button.IGRPT0100.btn_return"/>
				</html:button>
		        <html:button property="btn_back"  styleClass="button" styleId="btn_back" onclick="findforward()">
		        	<bean:message bundle="rptResources" key="button.IGRPT0100.btn_search"/>
		        </html:button>
				</c:if>
			</div>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>