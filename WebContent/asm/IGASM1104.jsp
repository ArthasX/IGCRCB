<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1104" toScope="request"/>
<bean:define id="title" value="机房平面管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
    var gid='IGASM1104';
	   function redisplay(){
		   form.submit();
	   }

	   function moveout(container_eiid){
           var message = '<bean:message key="IGASM1104.W001"/>';
		   $('container_eiid').value = container_eiid;
           if( window.confirm(message)){
               form.action = getAppRootUrl() + "/IGASM1104.do";
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
	<table class="table_style3">
	  <tr>
	    <th width="20%">机房名称</th>
	    
	     <th width="15%">机房负责人</th>
	    
	    <th width="15%">负责人电话</th>
	   
	    <th width="40%">机房说明</th>
	    <th width="10%"></th>
	  </tr>
	  <tr>
	  <td>${IGASM11041VO.computerRoomVWInfo.einame}</td>
	   <td>${IGASM11041VO.computerRoomVWInfo.manager}</td>
	    <td>${IGASM11041VO.computerRoomVWInfo.tel}</td>
	    <td>${IGASM11041VO.computerRoomVWInfo.eidesc}</td>
	    <td><input type="button" name="button" id="button" value="关闭"  onclick="window.close()" class="button"/></td>
	  </tr>
	</table>
    <html:form styleId="form" action="/IGASM1104_Disp" onsubmit="return checkSubmit(this);">
            <!--  message -->
            <ig:message/>
            <!--  /message -->     
           
            <table width="${IGASM11041VO.tableWidth}" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF" class="engine_table">
              <c:if test="${IGASM11041VO.x_total>0}">
			  <tr>
			    <td width="20" height="20" bgcolor="#6699CC">&nbsp;</td>
                <c:forEach begin="1" end="${IGASM11041VO.x_total}" var="colnum">
                <td width="50" bgcolor="#6699CC">${colnum}</td>
                </c:forEach>
			  </tr>
              </c:if>
              <logic:present name="IGASM11041VO" property="rowList">
              <logic:iterate id="rowBean" name="IGASM11041VO" property="rowList" indexId="rowIndex">
              <tr>
                <td height="50" bgcolor="#6699CC">${rowIndex+1}</td>
                <logic:iterate id="colBean" name="rowBean" property="columnList" indexId="colIndex">
	                <logic:equal name="colBean" property="space" value="true">
		                <td bgcolor="#FFFFFF"><html:submit property="btn_new" styleClass="button2" value=" " 
		                onclick="javascript:openSubIGASM1105('${IGASM1104Form.eiid}','${colIndex+1}','${rowIndex+1}');"/></td>
	                </logic:equal>
	                <logic:equal name="colBean" property="space" value="false">
	                    <logic:equal name="colBean" property="oneUnit" value="true">
    	                    <td background="images/floor.jpg" rowspan="${colBean.entityData.y_width}" colspan="${colBean.entityData.x_width}"><a href="#" onclick="javascript:openSubIGASM1114('${colBean.entityData.eiid}');">
    	                    <img src="images/engine.gif" alt="${colBean.entityData.einame}" width="35" height="40" border="0"/></a>
    	                    &nbsp;<a href="#" onclick="javascript:moveout('${colBean.entityData.eiid}');"><img src="images/002.gif" width="9" height="9"  alt="移除" border="0" /></a>
    	                    </td>
	                    </logic:equal> 
	                </logic:equal>
                </logic:iterate>
              </tr>
              </logic:iterate>
              </logic:present>
            </table>
        <html:hidden property="eiid" styleId="eiid" value="${IGASM1104Form.eiid}"/>
        <html:hidden property="container_eiid" styleId="container_eiid"/>
    </html:form>
</body>
</html:html>