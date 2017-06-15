<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1114" toScope="request"/>
<bean:define id="title" value="机柜平面管理画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
    var gid='IGASM1114';
	   function redisplay(){
		   form.submit();
	   }
	   
       function moveout(device_eiid){
           var message = '<bean:message key="IGASM1114.W001"/>';
           $('device_eiid').value = device_eiid;
           if( window.confirm(message)){
               form.action = getAppRootUrl() + "/IGASM1114.do";
               form.submit();
           }
       }
	</script>
<style>
html{
overflow:auto;
}
body{
overflow-x:auto;
overflow-y:auto;
}
</style>

<body>
	<table width="210" border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="#E9E9E9">
	  <tr>
	    <td height="10" colspan="5" >&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="100" height="25" align="center" bgcolor="#6699CC"><strong><font color="FFFFFF">机柜名称</font></strong></td>
	    <td width="90">${IGASM11141VO.computerContainerVWInfo.einame}</td>
        <td width="20"><input type="button" name="button" id="button" value="关闭"  onclick="window.close()" class="button"/></td>
	  </tr>
	</table>
    <html:form styleId="form" action="/IGASM1114_Disp" onsubmit="return checkSubmit(this);">
            <!--  message -->
            <ig:message/>
            <!--  /message -->     
           
            <table width="210" border="1" align="center" cellpadding="0" cellspacing="1" class="engine_table">
              <logic:present name="IGASM11141VO" property="rowList">
              <logic:iterate id="rowBean" name="IGASM11141VO" property="rowList" indexId="rowIndex">
              <tr>
                <td width="40" height="40"  background="images/jigui.gif">${rowBean.rowNum}U</td>
                <logic:equal name="rowBean" property="space" value="true">
	                <td background="images/jigui.gif"><html:submit property="btn_new" styleClass="button3" value=" " 
	                onclick="javascript:openSubIGASM1115('${IGASM1114Form.eiid}','${rowBean.rowNum}');"/></td>
                </logic:equal>
                <logic:equal name="rowBean" property="space" value="false">
                    <logic:equal name="rowBean" property="oneUnit" value="true">
   	                    <td bgcolor="#C0C0C0" rowspan="${rowBean.entityData.u_width}">
   	                    <a href="#" onclick="javascript:openSubIGASM1116('${rowBean.entityData.eiid}','${rowBean.entityData.eiversion}');">
   	                    <img src="images/machine.gif" alt="${rowBean.entityData.einame}" width="126" height="40" border="0"/></a>
   	                    <a href="#" onclick="javascript:moveout('${rowBean.entityData.eiid}');">
   	                    <img src="images/delete_16x16.gif" alt="移除" width="16" height="16" border="0"/></a>
   	                    </td>
                    </logic:equal> 
                </logic:equal>
              </tr>
              </logic:iterate>
              </logic:present>
            </table>
        <html:hidden property="eiid" styleId="eiid" value="${IGASM1114Form.eiid}"/>
        <html:hidden property="device_eiid" styleId="device_eiid"/>
    </html:form>
</body>
</html:html>