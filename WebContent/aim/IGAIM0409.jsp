<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0409" toScope="request" />
<bean:define id="title" value="列表画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!--header1 -->
<body >
<script type="text/javascript">
function changeName(ccdcategory){
	if($F(ccdcategory).trim()==""){
		alert("请输入名称！");
		return;
	}
	if($F(ccdcategory).strlen()>32){
		alert("名称不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		return;
	}else{
		if(confirm("是否确认改变名称？")){
		var form = document.forms[0];
		document.getElementById("ccdlabel").value = document.getElementById(ccdcategory).value;
		document.getElementById("ccdcategory").value = ccdcategory;
		form.submit();
        }
	}
}
</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
	 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->

<html:form action="/IGAIM0409_ChangeName">
	<input type="hidden" name="ccdcategory" id="ccdcategory" />
	<input type="hidden" name="ccdlabel" id="ccdlabel" />
</html:form>

<table class="table_style">
	<!-- header部 -->

	<tr>
		<th width="25%">编号</th>
		<th width="25%">显示名称</th>
		<th width="25%">修改名称</th>
		<th width="25%">修改属性</th>
	</tr>
	
	<logic:present name="IGCIM04091VO" property="configurationCodeDetailList">
		<logic:iterate id="bean" name="IGCIM04091VO" property="configurationCodeDetailList">
		
		<tr class="<ig:rowcss index="${index}"/>">
			<!-- 编号 -->
			<td>${bean.ccdcategory}</td>
			<!-- 显示名称 -->
			<td>
				<input type="text" id="${bean.ccdcategory}" name="ccdlabel" size="40" value="${bean.ccdlabel}" class="input1">
			</td>	
			<!-- 修改名称 -->
			<td>
				<a href="javascript:changeName('${bean.ccdcategory}')">
					修改名称
				</a>
			</td>
			<!-- 修改属性 -->
			<td>
				<a href="IGAIM0410_Disp.do?ccdcategory=${bean.ccdcategory}">
					修改属性
				</a>
			</td>
		</tr>
		</logic:iterate>
	</logic:present>
	
</table>
</div>
<div class="enter">
	<input type="button" id="btn_add" value="增加" class="button" onclick="window.location='IGAIM0408_Disp.do'" />
</div>
<div id="operate">
<!-- paging --> 
<jsp:include page="/include/paging.jsp" />
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>