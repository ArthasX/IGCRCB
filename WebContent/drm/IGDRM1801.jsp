<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM1801" toScope="request" />
<bean:define id="title" value="预案统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
.condTable{
	width:80%;
	float: left;
}
.condTable th{
text-align: right;
}
.condTable td{
	line-height: 20px;
	text-align: left;
}
</style>
<script type="text/javascript">	

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
				<html:form  action="/IGDRM1801" styleId="form">
		<div id="search">
			<div class="img"></div>
			<div class="conditions">
					<table class="condTable" >
						<tr>
							<th width="15%">登记时间：</th>
							<td width="20%"><html:text property="eiinstimeFrom" readonly="true" styleId="eiinstimeFrom" onclick="showDate(this)"/>
							</td>
							<th width="5%">	到：</th>
							<td width="20%">
								<html:text property="eiinstimeTo" readonly="true"  styleId="eiinstimeTo" onclick="showDate(this)" />
							</td>
							<td>
								<html:submit styleClass="button">查询</html:submit>
							</td>
						</tr>
					</table>
			</div>
		</div>
				</html:form>
	<fieldset> 
		<legend>预案统计</legend>
		<br/>
		<table width="100%" class="table_style">
			<tr>
				<th >预案类型</th>
				<th width="16%">数量</th>
				<th width="16%">已演练数量</th>
				<th width="16%">已演练占比</th>
				<th width="16%">修订数量</th>
				<th width="16%">修订占比</th>
			</tr>
			<logic:present name="IGDRM18011VO" property="planRateList">
				<logic:iterate id="rateMap" name="IGDRM18011VO" property="planRateList">
					<tr esyscoding = "${rateMap['ESYSCODING'] }">
						<td>${rateMap['ENAME'] }</td>
						<td>
							<c:if test="${rateMap['SUMCOUNT'] >0}">
								<a href="javascript:void(0);" onclick="showAll(this,'A')">${rateMap['SUMCOUNT'] }</a>
							</c:if>
							<c:if test="${rateMap['SUMCOUNT'] == 0}">
								${rateMap['SUMCOUNT'] }
							</c:if>
						</td>
						<td>
							<c:if test="${rateMap['DRILLCOUNT'] >0}">
								<a href="javascript:void(0);" onclick="showAll(this,'D')">${rateMap['DRILLCOUNT'] }</a>
							</c:if>
							<c:if test="${rateMap['DRILLCOUNT'] == 0}">
								${rateMap['DRILLCOUNT'] }
							</c:if>
						</td>
						<td>${rateMap['DRILLRATE'] }</td>
						<td>
							<c:if test="${rateMap['MODIFYCOUNT'] >0}">
								<a href="javascript:void(0);" onclick="showAll(this,'U')">${rateMap['MODIFYCOUNT'] }</a>
							</c:if>
							<c:if test="${rateMap['MODIFYCOUNT'] == 0}">
								${rateMap['MODIFYCOUNT'] }
							</c:if>
						</td>
						<td>${rateMap['MODIFYRATE'] }</td>
					</tr>
				</logic:iterate>
				
			</logic:present>
		</table>
		
	</fieldset>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>

<script type="text/javascript">
/**打开钻取页面*/
function showAll(obj,searchFlag){
	var param = "?esyscoding="+jQ(obj).parent().parent().attr("esyscoding")+(jQ("#eiinstimeFrom").val()&&"&eiinstimeFrom="+jQ("#eiinstimeFrom").val())
			+(jQ("#eiinstimeTo").val()&&"&eiinstimeTo="+jQ("#eiinstimeTo").val())+"&searchFlag="+searchFlag;
	openSubWindow("/IGDRM1802.do"+param,"专项预案钻取",800,600);
}

</script>
</html:html>