<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%><html:html>
<bean:define id="id" value="IGSYM1902" toScope="request"/>
<bean:define id="title" toScope="request">
<bean:message bundle="symResources" key="ietitle.IGSYM1902"/>
</bean:define>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">

function checkForm(){
	var pwtStartTimeHour=Number($F('pwtStartTimeHour').trim());
	var pwtEndTimeHour=Number($F('pwtEndTimeHour').trim());
	var pwtStartTimeMin=Number($F('pwtStartTimeMin').trim());
	var pwtEndTimeMin=Number($F('pwtEndTimeMin').trim());
	var factTime=(pwtEndTimeHour-pwtStartTimeHour)*60+pwtEndTimeMin-pwtStartTimeMin;
    if(factTime<=0){
    	alert('<bean:message bundle="symResources" key="message.IGSYM1902.002"/>');
    	return false;
    }
}
	
function selectChange(){
	var pwtStartTimeHour=Number($F('pwtStartTimeHour').trim());
	var pwtEndTimeHour=Number($F('pwtEndTimeHour').trim());
	var pwtStartTimeMin=Number($F('pwtStartTimeMin').trim());
	var pwtEndTimeMin=Number($F('pwtEndTimeMin').trim());
	var factTime=(pwtEndTimeHour-pwtStartTimeHour)*60+pwtEndTimeMin-pwtStartTimeMin;
	document.forms[0].factTime.value = factTime;
}

function toback(){
	var year=$F('year');
	window.location = "IGSYM1901_ReDisp.do?year="+year+"&month=0";
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
              	<p class="fonts1"><bean:message bundle="symResources" key="navigation.IGASM.sysmanage"/>&gt;&gt; <bean:message bundle="symResources" key="navigation.IGSYM.BaseData"/> &gt;&gt; 
	                  <bean:message bundle="symResources" key="navigation.IGSYM1902.workTimeSetting"/>
                </p>
                <div class="back"><a href="javascript:toback();" target="_self"><bean:message
				bundle="symResources" key="label.IGSYM1902.back" /></a>
				</div>
            </div>

            <div id="formwrapper">
            <html:form action="/IGSYM1902_INSERT">
            <fieldset>
            <legend><bean:message bundle="symResources" key="legend.IGSYM1902.001"/></legend>
            <div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1902.year"/></strong>：</label>
            <p class="p2">
            <bean:write name="IGSYM1902Form" property="year" />
            <html:hidden property="year"/>
            </p>
            <br>
            </div>
            <div>
            <label for="Name"><strong><span class="red">*</span><bean:message bundle="symResources" key="label.IGSYM1902.starttime"/></strong>：</label>
            <html:select name="IGSYM1902Form" property="pwtStartTimeHour" style="width: 50px;" onchange="selectChange()">
            <c:forEach begin="0" end="23" var="hour">
            <c:if test="${hour<10}">
            	<html:option value="0${hour}"></html:option>
            </c:if>
            <c:if test="${hour>=10}">
            	<html:option value="${hour}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1902.hour"/>
            <html:select name="IGSYM1902Form" property="pwtStartTimeMin" style="width: 50px;" onchange="selectChange()">
            <c:forEach begin="0" end="60" var="min">
            <c:if test="${min<10}">
            	<html:option value="0${min}"></html:option>
            </c:if>
            <c:if test="${min>=10}">
            	<html:option value="${min}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1902.min"/>
            <br>
            </div>
            <div>
            <label for="Name"><strong><span class="red">*</span><bean:message bundle="symResources" key="label.IGSYM1902.endtime"/></strong>：</label>
            <html:select name="IGSYM1902Form" property="pwtEndTimeHour" style="width: 50px;" onchange="selectChange()">
            <c:forEach begin="0" end="23" var="hour">
            <c:if test="${hour<10}">
            	<html:option value="0${hour}"></html:option>
            </c:if>
            <c:if test="${hour>=10}">
            	<html:option value="${hour}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1902.hour"/>
            <html:select name="IGSYM1902Form" property="pwtEndTimeMin" style="width: 50px;" onchange="selectChange()">
            <c:forEach begin="0" end="60" var="min">
            <c:if test="${min<10}">
            	<html:option value="0${min}"></html:option>
            </c:if>
            <c:if test="${min>=10}">
            	<html:option value="${min}"></html:option>
            </c:if>
            </c:forEach>
            </html:select><bean:message bundle="symResources" key="label.IGSYM1902.min"/>
			<br>
            </div>
            <div>
            <label for="Name"><strong><bean:message bundle="symResources" key="label.IGSYM1902.facttime"/></strong>：</label>
            <html:text name="IGSYM1902Form" property="factTime" readonly="true"></html:text><bean:message bundle="symResources" key="label.IGSYM1902.mins"/><br>
            </div>
            
            </fieldset>
            <div class="enter">
            <html:submit property="btn_insert"  styleClass="button" onclick="return checkForm();">
				    <bean:message bundle="symResources" key="button.IGSYM1902.btn_insert"/>
			</html:submit>
            </div>
            </html:form>
             </div>
            </div>
        </div>
    </div>
    
    <div class="zishiying"></div>
</div>

</body>
</html:html>