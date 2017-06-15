<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM1006" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    var gid='IGSYM1501';

		function toback(){
			if("${orgFlag}"){
				form.action = getAppRootUrl() + "/IGDRM1005.do?btn_next=999&orgFlag="+ "${orgFlag}";
			} else {
				form.action = getAppRootUrl() + "/IGDRM1001_DISP.do";
			}
			form.submit();
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
			<html:form styleId="form" action="/IGDRM1005?orgFlag=${orgFlag}" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:submit property="btn_add_conf" value="继续增加数据信息" styleClass="button"/>
		          <html:submit property="btn_next" value="返回" styleClass="button"/>
			</div>
			<html:hidden property="ccid" styleId="ccid" value="${IGDRM10012VO.codeCategoryDefInfo.ccid}"/>
			<html:hidden property="ccname" styleId="ccname" value="${IGDRM10012VO.codeCategoryDefInfo.ccname}"/>
			<html:hidden property="pcid" styleId="pcid" value="${IGDRM10012VO.codeDetailDef.cid}"/>
			<html:hidden property="pcvalue" styleId="pcname" value="${IGDRM10012VO.codeDetailDef.cvalue}"/>
			<bean:define id="pcid" value="${IGDRM10012VO.codeDetailDef.cid}"></bean:define>
			<logic:empty name="pcid">
			<html:hidden property="clevel" styleId="clevel" value="1"/>
			</logic:empty>
			<html:hidden property="psyscoding" styleId="psyscoding" value="${IGDRM10012VO.codeDetailDef.syscoding}"/>
			
			</html:form>
			</div>
		 </div>
    </div>
 </div>


</div>
</body>
</html:html>