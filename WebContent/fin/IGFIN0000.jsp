<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0000" toScope="request" />
<bean:define id="title" value="删除信息错误提示" toScope="request" />
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
				<div class="msg_img"><img src="images/exception.gif" border="0" /></div>
				<div class="msgcontent"><p class="p1" style="font-size: 12px;"><strong>该预算已有费用，无法删除！</strong></p>
		
               		<input type="button" class="button" value="返回"  onclick="window.location='IGFIN0102.do'" />
				</div>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>