<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0110" toScope="request" />
<bean:define id="title" value="列表画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!--header1 -->
<script type="text/javascript">
function changeStatus(ccdid,ccdcategory){
	if(confirm("是否确认改变状态？")){
		var form = document.forms[0];
		document.getElementById("ccdid").value = ccdid;
		document.getElementById("ccdcategory").value = ccdcategory;
		form.action="changeCCDStatus.do";
		form.submit();
	}
}

function changeValue(ccdid,ccdcategory){
	if(confirm("是否确认改变属性值？")){
		var form = document.forms[0];
		var ccdvalue = document.getElementById(ccdid).value;
		if(ccdvalue.trim()==""){
    		alert("属性值不能为空！");
    		return;
    	}
		if(ccdvalue.strlen()>32){
    		alert("属性值不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
    		return;
    	}
		document.getElementById("ccdvalue").value = ccdvalue;
		document.getElementById("ccdid").value = ccdid;
		document.getElementById("ccdcategory").value = ccdcategory;
		form.submit();
	}
}

</script>
<body >
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

<html:form action="/changeValue">
	<input type="hidden" name="ccdid" id="ccdid" />
	<input type="hidden" name="ccdvalue" id="ccdvalue" />
	<input type="hidden" name="ccdcategory" id="ccdcategory" />
</html:form>

<table class="table_style">
	<!-- header部 -->

	<tr>
		<th width="20%">显示名称</th>
		<th width="20%">属性值</th>
		<th width="20%">修改属性值</th>
		<th width="20%">状态</th>
		<th width="20%">调整</th>
	</tr>
	
	<logic:present name="IGASM01101VO" property="configurationCodeDetailList">
		<logic:iterate id="bean" name="IGASM01101VO" property="configurationCodeDetailList">
			
		<tr class="<ig:rowcss index="${index}"/>">
			<!-- 显示名称 -->
			<td>${bean.ccdlabel}</td>
			<!-- 属性值-->
			<td>
				<input type="text" id="${bean.ccdid}" name="ccdlabel" size="27" value="${bean.ccdvalue}" class="input1">
			</td>
			<!-- 修改属性值-->
			<td>
				<a href="javascript:changeValue('${bean.ccdid}','${bean.ccdcategory}')">
					修改属性值
				</a>
			</td>
			<!-- 状态 -->
			<td>
				<logic:equal name="bean" property="ccdstatus" value="0">停用</logic:equal>
				<logic:equal name="bean" property="ccdstatus" value="1">可用</logic:equal>
			</td>
			<!-- 调整 -->
			<td>
				<a href="javascript:changeStatus('${bean.ccdid}','${bean.ccdcategory}');">
					<logic:equal name="bean" property="ccdstatus" value="0">
						<img src="images/start.gif" border="0" alt="启动" />
					</logic:equal>
					<logic:equal name="bean" property="ccdstatus" value="1">
						<img src="images/stop.gif" border="0" alt="停止" />
					</logic:equal>
				</a>
			</td>		
		</tr>
		</logic:iterate>
	</logic:present>
</table>
</div>
<div class="enter">
	<input type="button" value="增加" class="button" onclick="window.location='IGASM0111_Disp.do?ccdcategory=<%=request.getParameter("ccdcategory") %>';"/>
	<input type="button" value="返回" class="button" onclick="window.location='IGASM0109_Disp.do'"/>
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