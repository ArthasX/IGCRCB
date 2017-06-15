<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1505" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    var gid='IGSYM1501';

		function toback(){
			IGSYM1504Form.action = getAppRootUrl() + "/IGSYM1501_Disp.do";
			IGSYM1504Form.submit();
		}
		
	</script>
<body">
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
                <p class="fonts1">信息提示</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>
			<div class="msg_box">
			<html:form styleId="form" action="/IGSYM1504" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:submit property="btn_add_conf" value="继续增加数据信息" styleClass="button" />
		          <html:submit property="btn_next" value="返回" styleClass="button"/>
			</div>
			<html:hidden property="ccid" styleId="ccid" value="${IGSYM15022VO.codeCategoryDefInfo.ccid}"/>
			<html:hidden property="ccname" styleId="ccname" value="${IGSYM15022VO.codeCategoryDefInfo.ccname}"/>
			<html:hidden property="pcid" styleId="pcid" value="${IGSYM15022VO.codeDetailDef.cid}"/>
			<html:hidden property="pcvalue" styleId="pcname" value="${IGSYM15022VO.codeDetailDef.cvalue}"/>
			<bean:define id="pcid" value="${IGSYM15022VO.codeDetailDef.cid}"></bean:define>
			<logic:empty name="pcid">
			<html:hidden property="clevel" styleId="clevel" value="1"/>
			</logic:empty>
			<html:hidden property="psyscoding" styleId="psyscoding" value="${IGSYM15022VO.codeDetailDef.syscoding}"/>
			
			</html:form>
			</div>
		 </div>
    </div>
 </div>


</div>
</body>
</html:html>