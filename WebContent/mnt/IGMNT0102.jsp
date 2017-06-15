<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGMNT0102" toScope="request"/>
<bean:define id="title" toScope="request">
<bean:message bundle="mntResources" key="ietitle.IGMNT0102"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	overflow-y: auto;
	background-color: #FFFFFF;
}

.table_style {
	width: 732px;
	margin: 10px 10px;
	border-collapse: collapse;
	text-align: center;
	table-layout: fixed;
}

.table_style th {
	color: #000000;
	border-top: 1px solid #CCCCCC;
	border-bottom: 1px solid #CCCCCC;
	background-color: #EEEEEE;
	height: 20px;
}

.table_style td {
	border-bottom: 1px solid #D3D3D3;
	height: 18px;
	word-break: break-all;
	word-wrap: break-word;
}
.table_style td a:link{
   color:#0066CC;
   text-decoration:none;
}
.table_style td a:visited{
   color:#0066CC;
   text-decoration:none;
}
.table_style td a:hover{
   color:#0066CC;
   text-decoration:underline;
}
.table_style td a:active{
   color:#0066CC;
   text-decoration:none;
}
</style>
<script type="text/javascript">
	function checkForm(){
		var mtdValue1='<bean:message bundle="mntResources" key="message.IGMNT0102.mtdValue1"/>';
		var mtdValue2='<bean:message bundle="mntResources" key="message.IGMNT0102.mtdValue2"/>';
		var mtdDes='<bean:message bundle="mntResources" key="message.IGMNT0102.mtdDes"/>';
		
		var obj=document.getElementsByTagName("input");
		for(var i=0;i<obj.length;i++){
			if(obj[i].type=="text"&&obj[i].name=="mtdValue"){
				if(obj[i].value.trim()==""){
					alert(mtdValue1);
					return false;
				}
				var reg=/^\d+(.\d+)?$/;
				if(!reg.test(obj[i].value)){
					alert(mtdValue2);
					return false;
				}
			}
			if(obj[i].type=="text"&&obj[i].name=="mtdDes"){
				if(obj[i].value.trim()==""){
					alert(mtdDes);
					return false;
				}
			}
		}
		for(var i=0;i<obj.length;i++){
			if(obj[i].type=="checkbox"){
				if(obj[i].checked){
					obj[i].value="0";
				}else{
					obj[i].value="1";
				}
				obj[i].checked="checked";
			}
		}
		return true;
	}
	function addMo(mtId){
		window.parent.location="IGMNT0103_Disp.do?flag=0&mtId="+mtId;
	}
</script>
<body>
<div style="margin-top:4px;margin-left:10px">
<ig:message />
</div>
<html:form action="/IGMNT0102_Update" styleId="form">
        <logic:present name="IGMNT01021VO" property="monitorTypeDefInfoList">
        <c:if test="${mtId<9}">
	        <table class="table_style" style="width: 100%">
	        <tr>
	        <th width="15%"><bean:message bundle="mntResources" key="label.IGMNT0102.mtdName"/></th>
	        <th width="15%"><bean:message bundle="mntResources" key="label.IGMNT0102.mtdValue"/></th>
	        <th width="15%"><bean:message bundle="mntResources" key="label.IGMNT0102.compare"/></th>
	        <th width="10%"><bean:message bundle="mntResources" key="label.IGMNT0102.deleteFlag"/></th>
	        <th width="40%"><bean:message bundle="mntResources" key="label.IGMNT0102.mtdDes"/></th>
	        </tr>
	        <logic:iterate id="bean" indexId="index" name="IGMNT01021VO" property="monitorTypeDefInfoList">
	        <tr>
	        <td>
	        <bean:write name="bean" property="mtdName"/>
	        </td>
	        <td>
	        <input type="text" maxlength="15" name="mtdValue" value="${bean.mtdValue}" class="input1" />
	        </td>
	        <td>
	        <html:select property="compare" value="${bean.compare}">
	        <html:option value=">=">&gt;=</html:option>
	        <html:option value="<=">&lt;=</html:option>
	        </html:select>
	        </td>
	        <td>
	        <c:if test="${bean.deleteFlag==0}">
	        <input type="checkbox" name="deleteFlag" value="0" checked="checked"/>
	        </c:if>
	        <c:if test="${bean.deleteFlag==1}">
	        <input type="checkbox" name="deleteFlag" value="0"/>
	        </c:if>
	        </td>
	        <td>
	        <input type="text" maxlength="60" style="width: 300px;" name="mtdDes" value="${bean.mtdDes}" class="input1" />
	        </td>
	        </tr>
	        <html:hidden property="mtdId" value="${bean.mtdId}"/>
	        </logic:iterate>
	        </table>
        </c:if>
        <c:if test="${mtId>9}">
        	<table class="table_style" style="width: 80%">
	        <tr>
	        <th width="40%"><bean:message bundle="mntResources" key="label.IGMNT0102.severity"/></th>
	        <th width="40%"><bean:message bundle="mntResources" key="label.IGMNT0102.mtdValue"/></th>
	        </tr>
	        <logic:iterate id="bean" indexId="index" name="IGMNT01021VO" property="monitorTypeDefInfoList">
	        <tr>
	        <td>
	        <bean:write name="bean" property="mtdName"/>
	        </td>
	        <td>
	        <input type="text" maxlength="2" name="mtdValue" value="${bean.mtdValue}" class="input1" />%
	        </td>
	        </tr>
	        <html:hidden property="mtdId" value="${bean.mtdId}"/>
	        </logic:iterate>
	        </table>
        </c:if>
        <html:hidden property="mtId"/>
        <div class="enter" style="width: 600px;">
    	<html:submit property="btn_update"  styleClass="button" onclick="return checkForm();">
			<bean:message bundle="mntResources" key="button.IGMNT0102.btn_update"/>
		</html:submit>
		<c:if test="${mtId<9}">
		<html:button property="" styleClass="button" onclick="addMo(${mtId})">
			<bean:message bundle="mntResources" key="button.IGMNT0102.btn_add"/>
		</html:button>
		</c:if>
    	</div>
        </logic:present>
</html:form>
</body>
</html:html>