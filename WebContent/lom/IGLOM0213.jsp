<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0213" toScope="request" />
<bean:define id="title" value="库存预警信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function check(){
		var type = document.forms[0].warntype.value;

		if(type=="2"){
			if($("warnnum").value.trim()==""){
				alert("请输入临界预警数量！");
				document.forms[0].warnnum.focus();
				return false;
			}
			
		}
		document.forms[0].action=getAppRootUrl() + "/IGLOM0213.do";
		document.forms[0].submit();
	}
	function showText(){
		var type = document.forms[0].warntype.value;
		if(type=="2"){
			document.getElementById("n").style.display="";
		}else{
			document.getElementById("n").style.display="none";
		}
		
	}
	function clearText(){
		document.forms[0].warnnum.value = "";
	}
	
	function checkNum(obj){
		if(obj.value!=""){
			if(!checkIsNumberForCSE(obj.value)){
				alert("请输入正整数！");
				obj.value = "";
				obj.focus();
				event.returnValue = false;
			}
		}
		
	}

	function checkIsNumberForCSE(str){
	 	myReg = /^[1-9][0-9]{0,9}$/;
		
	 	return myReg.test(str);
	}
//-->
</script>
<body onload="showText();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 库存预警</p>
</div>
<div id="search">
<html:form action="/IGLOM0213">
<div class="img"></div>
<div class="conditions">
<div>

<span>查询类型：</span>
<html:select property="warntype" errorStyleClass="inputError imeActive" onchange="showText();clearText();">
<html:option value="1">已预警查询</html:option>
<html:option value="2">临界预警查询</html:option>
</html:select>&nbsp;&nbsp;
<span id="n" style="display:none">临界预警数量：
<html:text property="warnnum" styleId="warnnum" errorStyleClass="inputError imeDisabled" size="15" maxlength="32" onchange="checkNum(this);"/>

</span>
&nbsp;&nbsp;
 	<html:button property="btn_search" styleClass="button" value="查询" onclick="check()"/>
    
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="25%">物品种类</th>
		<th width="20%">物品编号</th>
		<th width="20%">物品名称</th>
		<th width="10%">库存数量</th>
		<th width="10%">冻结数量</th>
		<th width="10%">预警数量</th>
		
	</tr>

	<logic:present name="IGLOM02131VO" property="gstockVWList">
		<logic:iterate id="bean" name="IGLOM02131VO" property="gstockVWList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>${PagingDTO.viewStartCount+index}</td>
				<td><ig:projectTypeValue ptype="${bean.gcategory}" /></td>
				<td>${bean.gcode}</td>
				<td>${bean.gname}</td>
				<td>${bean.gsnum}</td>
				<td>${bean.gsfreezenum}</td>
				<td>${bean.gwarningnum}</td>
				
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div id="operate">
	<div class="operate_btn">
		<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>