<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prm.vo.IGPRM03011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG007Info"%>
<%
IGPRM03011VO vo = (IGPRM03011VO)request.getAttribute("vo");
IG007Info processInfoDef = vo.getProcessInfoDef();
%>
<html:html>
<bean:define id="id" value="IGPRM0203" toScope="request" />
<bean:define id="title" value="变量登记成功" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!-- header  头部和 一级菜单-->
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
				<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
				<div class="msgcontent"><div class="txMessageInf">变量登记成功！</div>
			
                <input type="button" class="button" value="继续添加" 
                         onclick="window.location='IGPRM0302_Disp.do?pdid=<%=processInfoDef.getPdid() %>';" />
                    
               	<input type="button" class="button" value="查看变量列表" 
                         onclick="window.location='IGPRM0301_Disp.do?pdid=<%=processInfoDef.getPdid() %>';" />
                            	
			</div>
			</div>
		 </div>
    </div>
</div>

</div>
</body>
</html:html>