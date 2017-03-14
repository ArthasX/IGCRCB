<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0278" toScope="request"/>
<bean:define id="title" value="物品领用成功提示画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
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
			<div class="msgcontent">
			<div class="txMessageInf">物品领用成功！</div>
			<logic:equal name="IGLOM0203Form" property="lomid" value="lom0103">
			   <input type="button" class="button" value="接待工作管理"  onclick="window.location='IGLOM0103_Disp.do';" />
          	</logic:equal>
          	
          	<logic:equal name="IGLOM0203Form" property="lomid" value="lom0107">
          	    <input type="button" class="button" value="外出就餐工作管理"  onclick="window.location='IGLOM0107_Disp.do';" />
          	</logic:equal>
			</div>
			</div>
		 </div>
    </div>
</div>
</div>
</body>
</html:html>