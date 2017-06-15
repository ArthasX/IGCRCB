<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRPT0204" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="rptResources" key="ietitle.IGRPT0104" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">
WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
WebCalendar.timeShow   = false          //是否返回时间
WebCalendar.drag       = true          //是否允许拖动
WebCalendar.darkColor  = "#014DB4";    //控件的暗色
WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
WebCalendar.wordColor  = "#000080";    //控件的文字颜色
WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色
//是否确认删除
function checkdel(obj){
	var confirmMsg1='<bean:message bundle="rptResources" key="message.IGRPT0101.confirmMsg"/>';
	var message='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmMsg"/>';
	if(checkNum(obj)==0){
		alert(message);
        return false;
	}
		if(window.confirm(confirmMsg1)){
			form.action = getAppRootUrl() + "/IGRPT0204_Delete.do";
			return true;
		}else{
			return false;
		}
}
function go_add(){
	location.href="IGRPT0205_Disp.do";
}

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGRPT0204" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div>
	<label><bean:message bundle="rptResources" key="label.IGRPT0104.rtName_like" /></label>
	<html:text property="rmName_like" styleId="rmName_like"
		errorStyleClass="inputError imeDisabled" size="18"/>
	<label>&nbsp;&nbsp; <bean:message bundle="rptResources" key="label.IGRPT0104.dateFrom" /></label>
	<html:text property="dateFrom" styleId="dateFrom"
		errorStyleClass="inputError imeDisabled" size="10" maxlength="12"  readonly="true"/>
	 <img src="images/date.gif" align="middle" onClick="showDate($('dateFrom'))" border="0"/>
	&nbsp;&nbsp;
	<label><bean:message bundle="rptResources" key="label.IGRPT0104.dateTo" /></label>
	<html:text property="dateTo" styleId="dateTo"
		errorStyleClass="inputError imeDisabled" size="10" maxlength="12" readonly="true"/>
	 <img src="images/date.gif" align="middle" onClick="showDate($('dateTo'))" border="0"/>
	<label>&nbsp;&nbsp;<bean:message bundle="rptResources" key="label.IGRPT0101.rtDateType" /></label>
	<html:select styleId="rtdatetype_eq" property="rtdatetype_eq" style="width: 120px;">
		<ig:optionsCollection ccid="REPORT_DATETYPE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
	&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" onclick="">
		<bean:message bundle="rptResources" key="button.IGRPT0101.btn_search" />
	</html:submit>&nbsp;&nbsp;
	<html:button property="btn_add" styleClass="button" onclick="go_add()">
		<bean:message bundle="rptResources" key="button.IGRPT0101.btn_add" />
	</html:button>
	</div>
	</div>
	</div>
	</div>

	<div id="results_list">
	<ig:message/>
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="2%"><input id="isSel" type="checkbox" onclick="selectAll('isSel','delid')" /> </th>
			<th width="3%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.num' /></label></th>
			<th width="10%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.reportName' /></label></th>
			<th width="10%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.appTemName' /></label></th>
			<th width="10%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.dateType' /></label></th>
			<th width="10%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.time' /></label></th>
			<th width="10%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.last_addtionReportTime' /></label></th>
			<th width="8%"><label><bean:message bundle='rptResources' key='label.IGRPT0104.operate' /></label></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGRPT02041VO" property="reportManageList" >
		 <logic:iterate id="bean" name="IGRPT02041VO" property="reportManageList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
			<td><html:checkbox property="delid" value="${bean.rmId}" /></td>
			<td><label>${bean.rmId}</label></td>
			<td><label>${bean.rmName}</label></td>
			<td><label>${bean.rtName}</label></td>
			<td>
			<label>
			<c:if test="${bean.rmDateType==0}"><bean:message bundle='rptResources' key='label.IGRPT0104.month' /></c:if>
			<c:if test="${bean.rmDateType==1}"><bean:message bundle='rptResources' key='label.IGRPT0104.quarter' /></c:if>
			<c:if test="${bean.rmDateType==2}"><bean:message bundle='rptResources' key='label.IGRPT0104.year' /></c:if>
			</label>
			</td>
			<td>
			<label>
			${bean.rmYear}
			<c:if test="${bean.rmMonth!=''&&bean.rmMonth!=null}"><!--月-->
			/${bean.rmMonth}
			</c:if>
			<c:if test="${bean.rmQuarter!=''&&bean.rmQuarter!=null}"><!--季-->
			Q${bean.rmQuarter}
			</c:if>
			</label>
			</td>
			<td><label>${bean.lastAnnexationDate}</label></td>
			<td>
			<a href="IGRPT0205_UpdateDisp.do?rmId=${bean.rmId}">
			<img src="images/edit.gif" width="16" height="16" border="0" alt='<bean:message bundle="rptResources" key="alt.IGRPT0103.edit"/>'/> </a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="IGRPT0207_Down.do?rmId=${bean.rmId}">
			<img src="images/down.png" width="16" height="16" border="0" alt="<bean:message bundle='rptResources' key='img.IGRPT0104.downLoad' />"/></a>
			</td>
			</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<html:submit property="btn_delete" styleClass="button" onclick="return checkdel('delid');">
	<bean:message bundle="rptResources" key="button.IGRPT0101.btn_delete" />
	</html:submit>
<jsp:include page="/include/paging.jsp" />
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>