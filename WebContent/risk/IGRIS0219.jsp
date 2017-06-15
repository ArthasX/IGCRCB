<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGRIS0219" toScope="request" />
<bean:define id="title" value="检查日报查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function readInfo(rcrid){
		openSubWindow('/IGRIS0219_Read.do?rcrid='+rcrid, '_blank', '800', '600');
	}
function setDefualtDate(){
	var temp = document.forms[0].rcrplandate.value;
	if(temp==""){
		document.forms[0].rcrplandate.value = "<%=IGStringUtils.getCurrentDate() %>";
	}

}
	
//-->
</script>
<body onload="setDefualtDate();" style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGRIS0219" onsubmit="return checkSubmit(this);" >
<div id="location">
<div class="image"></div>
<p class="fonts1">检查日报</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>计划执行检查的时间：</span><html:text property="rcrplandate" styleId="rcrplandate" errorStyleClass="inputError imeDisabled"  size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('rcrplandate'))" border="0" style="cursor: hand" /> &nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">重要程度</th>
				<th width="20%">检查项名称</th>
				<th width="10%">实际检查时间</th>
				<th width="10%">责任组</th>
				<th width="10%">责任人</th>
				<th width="10%">执行人</th>
				<th width="30%">结果</th>

			</tr>
			<logic:present name="IGRIS02011VO" property="riskCheckResultDataList">
				<logic:iterate id="bean1" name="IGRIS02011VO" property="riskCheckResultDataList" indexId="index" type="com.deliverik.infogovernor.risk.model.RiskCheckResult">
					<bean:define id="bean" name="bean1" property="riskCheck" ></bean:define>
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="readInfo('${bean1.rcrid}')">
						
						<td>
							<img src="images/${bean1.rctype}.gif" alt="重要程度：<ig:codeValue ccid="RISKCHECK_TYPE_CODE"
									cid="${bean1.rctype}"/>" width="10" height="16" />
						</td>
						<td>
							${bean.rcname}
						</td>

						<td>
							<%if((IGStringUtils.getCurrentDate().compareTo(bean1.getRcrplandate())>0) && (bean1.getRcrrealtime()==null || "".equals(bean1.getRcrrealtime()))){ %>
								<img src="images/red_light.gif" alt="未执行过检查"  width="16" height="16" />
							<%}else if(bean1.getRcrrealtime()!=null && bean1.getRcrrealtime().substring(0,10).compareTo(bean1.getRcrplandate())>0){ %>
								<img src="images/yellow_light.gif" alt="未按时执行检查"  width="16" height="16" />
							<%}else{%>
								${bean1.rcrrealtime}
							<%}%>
						</td>
						
						<td>${bean.rcrolename}</td>

						<td>${bean.rcusername}</td>
						
						<td>${bean1.rcrusername}</td>
						
						<td><ig:codeValue ccid="RISKCHECKRESULT_CODE" cid="${bean1.rcrresult}" /></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>

</body>
</html:html>