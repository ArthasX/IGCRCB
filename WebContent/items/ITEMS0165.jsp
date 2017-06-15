<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>

<html:html>
<bean:define id="id" value="ITEMS0165" toScope="request" />
<bean:define id="title" value="配送清单画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
function checkForm(name){
	if($F('outtime_f').trim()==""){
		alert("请选择开始时间！");
		return false;
	}
	if($F('outtime_t').trim()==""){
		alert("请选择结束时间！");
		return false;
	}
	if(!checkDate("outtime_f","outtime_t")){
		alert("开始时间不能晚于结束时间！");
		return false;
	}
	if(name=="search"){
		document.forms[0].action=getAppRootUrl() + "/ITEMS0165.do";
		document.forms[0].submit();

	}else if(name=="detail"){

		 document.forms[0].action=getAppRootUrl() + "/ITEMS0166.do";
		 document.forms[0].submit();

	}else if(name=="excel"){

		document.forms[0].action = getAppRootUrl() + "/ITEMS0165.do?report=1";
		document.forms[0].submit();

	}
}

function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].reqorg.value = "";
		document.forms[0].reqorg_name.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].reqorg.value = temp.split("|")[0];
		document.forms[0].reqorg_name.value = temp.split("|")[1];
	}		

}
	
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0165_Disp">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span><span class="red">*</span>时间：从</span><span><html:text
		property="outtime_f" styleId="outtime_f"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('outtime_f'))" border="0" style="cursor: hand" />
	</span>
	<span>&nbsp;&nbsp;到</span><span><html:text
		property="outtime_t" styleId="outtime_t"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('outtime_t'))" border="0" style="cursor: hand" /></span>
		
	&nbsp;&nbsp;		
	<span>机构：</span>
	<html:text property="reqorg_name" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
	<html:hidden property="reqorg"/>

	&nbsp;&nbsp;	
    <html:button property="btn_button" styleClass="button" value="查询"  onclick="checkForm('search');"/>
    <html:button property="btn_button" styleClass="button" value="导出"  onclick="checkForm('excel');"/>
</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">配送时间</th>
				<th width="15%">机构名称</th>
				<th width="75%">包裹号</th>

			</tr>
			<logic:present name="ITEMS01081VO" property="outmap">
				<logic:iterate id="bean" name="ITEMS01081VO" property="outmap" indexId="index">		
                	<bean:define id="list" name="bean" property="value" type="java.util.Map" />
						<logic:iterate id="bean1" name="list" indexId="index" >
						    <tr class="<ig:rowcss index="${index}"/>">
							<td>
								${bean.key}
							</td>
                			<td>
								<ig:cseOrgValue orgsyscoding="${bean1.key}"/>
							</td>
							<td>${bean1.value}</td>
							</tr>
                		</logic:iterate>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div class="enter">
	<div class="operate_btn" >
	<logic:present name="ITEMS01081VO" property="outmap">
		<span> 
		<html:button property="btn_add" value="全明细"
			styleClass="button" onclick="checkForm('detail')" />
		
		</span>
	</logic:present>
	 <!-- paging --> </div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>