<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGFIN0204"  toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	function SwitchMenu(obj){
		if(document.getElementById){
		var el = document.getElementById(obj);
		var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
			if(el.style.display != "block"){ //DynamicDrive.com change
				for (var i=0; i<ar.length; i++){
					if (ar[i].className=="submenu") //DynamicDrive.com change
					ar[i].style.display = "none";
				}
				el.style.display = "block";
			}else{
				el.style.display = "none";
			}
		}
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
			
			<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<input type="button" class="button" value="继续新增"  
                       onclick="window.location='IGFIN0201_Disp.do';" />
                            	
                <input type="button" class="button" value="费用查询" 
                       onclick="window.location='IGFIN0206_Disp.do';" />
			</div>
			
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>