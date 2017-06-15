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
<bean:define id="id" value="IGSTA0101" toScope="request" />
<bean:define id="title" value="检查工作监督" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function readInfo(rcrid){
		var form = document.getElementById("form");
		form.action="IGSTA0101_Read.do?rcrid="+rcrid;
		form.submit();

	}
//-->
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSTA0101_Disp" onsubmit="return checkSubmit(this);" >
<div id="location">
<div class="image"></div>
<p class="fonts1">统计分析 &gt;&gt; 工作监督 &gt;&gt; 检查工作监督</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>检查项：</span><span><html:text property="rcname_like" errorStyleClass="inputError imeActive"/></span>
	<span>&nbsp;责任人：</span><span><html:text property="rcusername_like" errorStyleClass="inputError imeActive"/></span>
	<span>&nbsp;检查状态：</span>
	<span><html:select property="rcrstatic" styleId="rcrresult">
			<html:option value=""></html:option>
			<html:option value="1">已检查</html:option>
			<html:option value="2">未检查</html:option>
	</html:select></span>
	<br/>
	<span>计划检查时间：</span><span><html:text property="ntime_from" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('ntime_from'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span>&nbsp;到</span><span><html:text property="ntime_to" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('ntime_to'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span>结果：</span>	   
	<html:select property="rcrresult" styleId="rcrresult">
        <ig:optionsCollection ccid="RISKCHECKRESULT_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select>
	<span>&nbsp;&nbsp;<html:submit styleClass="button" value="查询" /></span></div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="7%">重要程度</th>
				<th width="15%">检查项名称</th>
				<th width="18%">计划检查时间</th>
				<th width="18%">实际检查时间</th>
				<th width="10%">责任组</th>
				<th width="10%">责任人</th>
				<th width="10%">执行人</th>
				<th width="10%">结果</th>

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

						
						<td>${bean1.rcrplandate}</td>
						
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

</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>