<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String contextPath = request.getContextPath();
%>

<html:html>
<bean:define id="id" value="IGCOM0214" toScope="request" />
<bean:define id="title" value="综合管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
//按钮置灰	
function initcheckio(){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=checkIo',onSuccess:  function(req, json){
			 var result=req.responseText;
	//alert(result);
			 //显示签到
				if(result == 1){
					//蓝色签到
					var pic1 = document.getElementById("pica").style.display="";
					//灰色签到
					var pic1 = document.getElementById("picb").style.display="none";
					//蓝色签出
					var pic3 = document.getElementById("picc").style.display="none";
					//灰色签出
					var pic4 = document.getElementById("picd").style.display="";
				}
				//显示签出
				if(result == 2){
					//蓝色签到
					var pic1 = document.getElementById("pica").style.display="none";
					//灰色签到
					var pic1 = document.getElementById("picb").style.display="";
					//蓝色签出
					var pic3 = document.getElementById("picc").style.display="";
					//灰色签出
					var pic4 = document.getElementById("picd").style.display="none";
				}
				//已签到已签出
				if(result ==3){
					//蓝色签到
					var pic1 = document.getElementById("pica").style.display="none";
					//灰色签到
					var pic1 = document.getElementById("picb").style.display="";
					//蓝色签出
					var pic3 = document.getElementById("picc").style.display="none";
					//灰色签出
					var pic4 = document.getElementById("picd").style.display="";
				}
		     }

		});
	}

</script>
<body onload="initcheckio();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容--><div id="contentWrap">
<div id="content">


<div class="caption">
<div class="caption_img">
<img src="images/dj.gif" width="64" height="64" />
</div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
 	综合管理
</p>
</div>
<div class="caption_content">
<p>根据业务要求，进行综合管理。</p>
</div>
</div>
</div>

</div>
</body>
</html:html>
