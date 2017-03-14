<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1105" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    var gid='IGSYM1105';

		function toback(){
            IGSYM1105Form.action = getAppRootUrl() + "/IGSYM1101_Disp.do";
            IGSYM1105Form.submit();
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

			 <div id="location">
                <div class="image"></div>
                <p class="fonts1">信息提示</p>
                <div class="back"><html:link href="javascript:toback();">分类列表</html:link></div> 
            </div>
			<div class="msg_box">
			<html:form styleId="form" action="/IGSYM1105" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:submit property="btn_add_conf" value="继续增加数据信息" styleClass="button"/>
		          <html:submit property="btn_next" value="返回" styleClass="button"/>
			</div>
			<html:hidden property="ccid" styleId="ccid" value="${IGSYM11062VO.codeCategoryInfo.ccid}"/>
			<html:hidden property="ccname" styleId="ccname" value="${IGSYM11062VO.codeCategoryInfo.ccname}"/>
			<html:hidden property="pcid" styleId="pcid" value="${IGSYM11062VO.codeDetail.cid}"/>
			<html:hidden property="pcvalue" styleId="pcname" value="${IGSYM11062VO.codeDetail.cvalue}"/>
			<bean:define id="pcid" value="${IGSYM11062VO.codeDetail.cid}"></bean:define>
			<logic:empty name="pcid">
			<html:hidden property="clevel" styleId="clevel" value="1"/>
			</logic:empty>
			<html:hidden property="psyscoding" styleId="psyscoding" value="${IGSYM11062VO.codeDetail.syscoding}"/>
			
			</html:form>
			</div>
		 </div>
    </div>
 </div>


</div>
</body>
</html:html>