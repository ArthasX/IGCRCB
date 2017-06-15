<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%><html:html>
<bean:define id="id" value="IGSYM1903" toScope="request"/>
<bean:define id="title" toScope="request">
<bean:message bundle="symResources" key="ietitle.IGSYM1903"/>
</bean:define>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->

<body onload="sleepTimeChange()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
             	<p class="fonts1">
             	<bean:define id="urlable">
	                  <bean:message bundle="symResources" key="navigation.IGSYM1903.update"/>
	            </bean:define> 
	            <ig:navigation extname1="${urlable}" />      
                </p>
                 <div class="back"><a href="javascript:toback();" target="_self"><bean:message
				bundle="symResources" key="label.IGSYM1903.back" /></a>
				</div>
            </div>

            <div id="formwrapper">
            <html:form action="/IGSYM1903_UPDATE">
            <fieldset>
            <legend><bean:message bundle="symResources" key="legend.IGSYM1903.001"/></legend>
            
            <div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1903.date"/></strong>：</label>
             <p class="p2">
             	<bean:write name="IGSYM1903Form" property="pwtDate" />
             	<html:hidden property="pwtDate"/>
             </p>      
          	<br />
      		</div>
       		<div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1903.sleeptime"/></strong>：</label>
            <html:select property="pwtSleepTime" style="width: 130px;" errorStyleClass="inputError" onchange="sleepTimeChange()">
			 <ig:optionsCollection ccid="DATETYPE" isMakeBlankRow="true" isCodeLabel="true"/>
			</html:select>
            <br>
            </div>
            <div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1903.starttime"/></strong>：</label>
            <html:select name="IGSYM1903Form" property="pwtStartTimeHour" style="width: 50px;" onclick="selectChange()">
            <c:forEach begin="0" end="23" var="hour">
            <c:if test="${hour<10}">
            	<html:option value="0${hour}"></html:option>
            </c:if>
            <c:if test="${hour>=10}">
            	<html:option value="${hour}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1903.hour"/>
            <html:select name="IGSYM1903Form" property="pwtStartTimeMin" style="width: 50px;" onclick="selectChange()">
            <c:forEach begin="0" end="60" var="min">
            <c:if test="${min<10}">
            	<html:option value="0${min}"></html:option>
            </c:if>
            <c:if test="${min>=10}">
            	<html:option value="${min}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1903.min"/>
            <br>
            </div>
            <div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1903.endtime"/></strong>：</label>
            <html:select name="IGSYM1903Form" property="pwtEndTimeHour" style="width: 50px;" onclick="selectChange()">
            <c:forEach begin="0" end="23" var="hour">
            <c:if test="${hour<10}">
            	<html:option value="0${hour}"></html:option>
            </c:if>
            <c:if test="${hour>=10}">
            	<html:option value="${hour}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1903.hour"/>
            <html:select name="IGSYM1903Form" property="pwtEndTimeMin" style="width: 50px;" onclick="selectChange()">
            <c:forEach begin="0" end="60" var="min">
            <c:if test="${min<10}">
            	<html:option value="0${min}"></html:option>
            </c:if>
            <c:if test="${min>=10}">
            	<html:option value="${min}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1903.min"/>
			<br>
            </div>
            <div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1903.facttime"/></strong>：</label>
            <html:text name="IGSYM1903Form" property="factTime" readonly="true"></html:text><bean:message bundle="symResources" key="label.IGSYM1903.mins"/><br>
            </div>
            
            </fieldset>
            <div class="enter">
            <html:submit property="btn_update"  styleClass="button"  onclick="return checkForm();"  >
				    <bean:message bundle="symResources" key="button.IGSYM1903.btn_update"/>
			</html:submit>
            </div>
            <html:hidden property="pwtId" value="${IGSYM1903Form.pwtId}"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
<script type="text/javascript">
var pwtStartTimeHour_old=$F('pwtStartTimeHour');
var pwtEndTimeHour_old=$F('pwtEndTimeHour');
var pwtStartTimeMin_old=$F('pwtStartTimeMin');
var pwtEndTimeMin_old=$F('pwtEndTimeMin');
var factTime_old=$F('factTime');

function checkForm(){
	
	var pwtStartTimeHour=Number($F('pwtStartTimeHour'));
	var pwtEndTimeHour=Number($F('pwtEndTimeHour'));
	var pwtStartTimeMin=Number($F('pwtStartTimeMin'));
	var pwtEndTimeMin=Number($F('pwtEndTimeMin'));
	var pwtSleepTime=Number($F('pwtSleepTime'));
	var factTime=(pwtEndTimeHour-pwtStartTimeHour)*60+pwtEndTimeMin-pwtStartTimeMin;
	if(factTime<=0&&pwtSleepTime==0){
		alert('<bean:message bundle="symResources" key="message.IGSYM1903.002"/>');
		return false;
	}
	if($F('pwtStartTimeHour')==""&&$F('pwtEndTimeHour')==""&&$F('pwtStartTimeMin')==""&&$F('pwtEndTimeMin')==""){
		return true;
	}else if($F('pwtStartTimeHour')!=""&&$F('pwtEndTimeHour')!=""&&$F('pwtStartTimeMin')!=""&&$F('pwtEndTimeMin')!=""){
		return true;
	}else{
		alert('<bean:message bundle="symResources" key="message.IGSYM1903.004"/>');
		return false;
	}
}

function selectChange(){
	var pwtStartTimeHour=Number($F('pwtStartTimeHour'));
	var pwtEndTimeHour=Number($F('pwtEndTimeHour'));
	var pwtStartTimeMin=Number($F('pwtStartTimeMin'));
	var pwtEndTimeMin=Number($F('pwtEndTimeMin'));
	var factTime=(pwtEndTimeHour-pwtStartTimeHour)*60+pwtEndTimeMin-pwtStartTimeMin;
	document.forms[0].factTime.value=factTime;
}

function sleepTimeChange(){
	var pwtSleepTime=Number($F('pwtSleepTime'));
	if(pwtSleepTime>0){
		document.forms[0].pwtStartTimeHour.value="";
		document.forms[0].pwtStartTimeHour.disabled="true";
		document.forms[0].pwtEndTimeHour.value="";
		document.forms[0].pwtEndTimeHour.disabled="true";
		document.forms[0].pwtStartTimeMin.value="";
		document.forms[0].pwtStartTimeMin.disabled="true";
		document.forms[0].pwtEndTimeMin.value="";
		document.forms[0].pwtEndTimeMin.disabled="true";
		document.forms[0].factTime.value=0;
	}else{
		document.forms[0].pwtStartTimeHour.disabled="";
		document.forms[0].pwtEndTimeHour.disabled="";
		document.forms[0].pwtStartTimeMin.disabled="";
		document.forms[0].pwtEndTimeMin.disabled="";

		document.forms[0].pwtStartTimeHour.value=pwtStartTimeHour_old;
		document.forms[0].pwtEndTimeHour.value=pwtEndTimeHour_old;
		document.forms[0].pwtStartTimeMin.value=pwtStartTimeMin_old;
		document.forms[0].pwtEndTimeMin.value=pwtEndTimeMin_old;
		document.forms[0].factTime.value = factTime_old;
	}
}

function toback(){
	var pwtDate=$F('pwtDate');
	var year=pwtDate.substring(0,4);
	var month=pwtDate.substring(5,7);
	window.location = "IGSYM1901_ReDisp.do?year="+year+"&month="+(month-1);
}
</script>