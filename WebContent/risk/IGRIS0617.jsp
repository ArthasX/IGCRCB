<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRIS0603" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	function reg(){
		window.location.href=getAppRootUrl() + "/IGRIS0602_Disp.do";
	}
	function toback(){
		window.location.href=getAppRootUrl() + "/IGRIS0614_Disp.do";
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
			<div class="msg_img">
				<img src="images/Round_Icon_09.gif" border="0" />
			</div>
			<div class="msgcontent1"><br>
				&nbsp;&nbsp;&nbsp;检查项修改成功!
				<div>
				
				<%-- &nbsp;&nbsp;&nbsp;<a href="IGRIS0604_Disp.do?eiid=${eiiddd }&eiversion=1&looksign=0">返回</a> --%>
				
				</div>
					<div class="msgcontent">
					<!-- <input type="button"  class="button" value="继续登记" onclick="reg();"/> -->
					<input type="button" class="button" value="检查项管理" onclick="toback();"/>
				    </div>
			</div>
			</div>
		 </div>
    </div>
 </div>


</div>
</body>
</html:html>