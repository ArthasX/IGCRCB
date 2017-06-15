<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGMNT0104" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="mntResources" key="ietitle.IGMNT0104" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	WebCalendar.timeShow   = true          //是否返回时间
	WebCalendar.drag       = true          //是否允许拖动
	WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色
	
	function addMo(){
		form.action = getAppRootUrl() + "/IGMNT0103_Disp.do?flag=1";
		form.submit();
	}

	function toDel(moId,deleteFlag){
		if( window.confirm('<bean:message bundle="mntResources" key="message.IGMNT0104.001"/>')){
    		IGMNT0104Form.action = getAppRootUrl() + "/IGMNT0104_Change.do?moId="+moId+"&deleteFlag="+deleteFlag;
    		IGMNT0104Form.submit();
		}
	}

	function confirmDel(){
		 var alertMsg= '<bean:message bundle="mntResources" key="message.IGMNT0104.002"/>';
		if(window.confirm(alertMsg)){
			return true;
		} else {
			return false;
		}
	}
	function confirmDebug(){
		 var alertMsg= '<bean:message bundle="mntResources" key="message.IGMNT0104.003"/>';
		if(window.confirm(alertMsg)){
			return true;
		} else {
			return false;
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGMNT0104"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div>
	<label>
	&nbsp;&nbsp;<bean:message bundle="mntResources" key="label.IGMNT0104.monitorType" />：
	</label> 
	<html:select name="IGMNT0104Form" styleId="impcitype" property="mtId_eq" style="width: 130px;" errorStyleClass="inputError">
	<html:options collection="monitorTypeList" property="value" name="" labelProperty="label" />
	</html:select>
	<label>
	&nbsp;&nbsp;<bean:message bundle="mntResources" key="label.IGMNT0104.moName"/>：
	</label> 
	<html:text property="moName_eq" styleId="symm_id_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21" name="IGMNT0104Form" /> 
	<br/>
	<label>
	&nbsp;&nbsp;<bean:message bundle="mntResources" key="label.IGMNT0104.moCreateTimeFrom"/>
	</label> 
	<html:text property="moCreateTime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	 <img src="images/date.gif" align="middle" onClick="calendar($('moCreateTime_from'))" border="0"/>
	<label>
	&nbsp;&nbsp;<bean:message bundle="mntResources" key="label.IGMNT0104.moCreateTimeTo"/>：
	</label>
	<html:text property="moCreateTime_to" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	 <img src="images/date.gif" align="middle" onClick="calendar($('moCreateTime_to'))" border="0"/>
	<html:submit property="btn_search" styleClass="button">
	<bean:message bundle="mntResources" key="button.IGMNT0104.btn_search" />
	</html:submit>
	&nbsp;&nbsp;
	<html:button property="btn_add" styleClass="button" onclick="addMo();">
	<bean:message bundle="mntResources" key="button.IGMNT0104.btn_add" />
	</html:button>
	
	</div>
	</div>
	</div>

	</div>

	<div id="results_list">
	<!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<!-- header部 -->
		<tr>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.index" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.moName" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.ip" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.monitorType" /></th>	
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.moCreateTime" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.deleteFlag" /></th>	
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.update" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0104.delete" /></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGMNT01041VO" property="monitorObjectList">
			<logic:iterate id="bean" name="IGMNT01041VO"
				property="monitorObjectList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 序号 -->
					<td>
					<div class="nowrapDiv">${index+1}</div>
					</td>
					<!-- 监控对象名称-->
					<td>
					<div class="nowrapDiv">${bean.moName}</div>
					</td>
					<!-- IP地址-->
					<td>
					<div class="nowrapDiv">${bean.ip}</div>
					</td>
					<!-- 监控类型 -->
					<td>
					<div class="nowrapDiv">${bean.monitorTypeTB.mtName}</div>
					</td>
					<!-- 创建时间-->
					<td>
					<div class="nowrapDiv">${bean.moCreateTime}</div>
					</td>
					<!-- 状态-->
					<td>
					<c:if test="${bean.deleteFlag==0}">
					<html:link  href="javascript:toDel('${bean.moId}',1)">
					<img src="images/stop.gif" width="16" height="16" border="0" alt='<bean:message bundle="mntResources" key="img.IGMNT0104.stop.alt"/>' />
					</html:link>
					</c:if>
					<c:if test="${bean.deleteFlag==1}">
					<html:link  href="javascript:toDel('${bean.moId}',0)">
					<img src="images/start.gif" width="16" height="16" border="0" alt='<bean:message bundle="mntResources" key="img.IGMNT0104.start.alt"/>' />
					</html:link>
					</c:if>
					</td>
					<!-- 修改-->
					<td>
					<div class="nowrapDiv">
					<c:if test="${bean.deleteFlag==0}">
					<html:link action="/IGMNT0105_Disp.do?moId=${bean.moId}">
						<img src="images/edit.gif" width="16" height="16" border="0" alt='<bean:message bundle="mntResources" key="img.IGMNT0104.update.alt"/>'/>
					</html:link>
					</c:if>
					<c:if test="${bean.deleteFlag==1}">
						<img src="images/noedit.gif" width="16" height="16" border="0" alt='<bean:message bundle="mntResources" key="img.IGMNT0104.update.alt"/>'/>
					</c:if>
					</div>
					</td>
					<!-- 删除-->
					<td>
					<div class="nowrapDiv">
					<html:link action="/IGMNT0104_Del.do?moId=${bean.moId}" onclick="return confirmDel();">
						<img src="images/delete.gif" width="16" height="16" border="0" alt="<bean:message bundle="mntResources" key="img.IGMNT0104.delete.alt" />"/>
					</html:link>
					</div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGMNT01041VO" property="monitorObjectList">
		<!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</logic:present> 
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>