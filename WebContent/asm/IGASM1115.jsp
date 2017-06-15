<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1115" toScope="request"/>
<bean:define id="title" value="设备选择画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
    var gid='IGASM1115';
	   function addDevice(eiid,container_id) {
           var message1 = '<bean:message key="IGASM1115.W001"/>';
           var message2 = '<bean:message key="IGASM1115.W002"/>';
           var message = '';

           if (container_id == '') {
        	   message = message1;
           } else {
               message = message2;
           }
           $('sel_device_eiid').value = eiid;
           if( window.confirm(message)){
               form.action = getAppRootUrl() + "/IGASM1115_Add.do";
               form.submit();
               
           }
	   }

	   function initCheck(){
		   success = '<bean:write name="IGASM1115Form" property="success"/>';

		   if (success == '1') {
               if(!window.opener.closed){
                   window.opener.redisplay();
               }
               window.close();
		   }
	   }	
	</script>
	<style>
html{
overflow:auto;
}
</style>
<body onload="initCheck();">
<div id="maincontent">
<div id="container">
    <html:form styleId="form" action="/IGASM1115" onsubmit="return checkSubmit(this);">
    <div id="location">
        <div class="image"></div>
            <p class="fonts1">设备查询</p>
    </div>

	    <div class="title">
	        <div class="name">当前机柜信息</div>
	    </div>
	    <div id="results_list">
	       <table class="table_style6" align="left">
	           <tr>
	               <th width="25%">机柜名</th>
	               <td width="25%">${IGASM1115Form.cur_container_name}</td>
	               <th width="25%">被选机柜位置</th>
	               <td width="25%">${IGASM1115Form.cur_container_u_value}U</td>
	           </tr>
	        </table>
	     </div>

        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
	                <label>设备编号：</label><html:text name="IGASM1115Form" property="eilabel" styleId="eilabel"  errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
	                <label>设备名：</label><html:text name="IGASM1115Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="20" />&nbsp;&nbsp; 
                    <label>设备高：</label><html:text name="IGASM1115Form" property="u_total" styleId="u_total" errorStyleClass="inputError imeDisabled" size="5" /> 
                    <html:submit property="btn_search" value="查询" styleClass="button"/>
                </div>
             
            </div>
        </div>
           
        <div id="results_list">
			<!--  message -->
			<ig:message/>
			<!--  /message -->     
            <table class="table_style">
				<!-- header部 -->
				<thead>
				    <tr>
                        <th width="3%"></th>
				    	<th width="8%"></th>
                        <th width="15%">设备编号
                        </th>
                        <th width="20%">设备名称
                        </th>
                        <th width="19%">所属类型
                        </th>
                        <th width="10%">设备高
                        </th>
                        <th width="15%">所属机柜
                        </th>
                        <th width="10%">位置（U）
                        </th>
                    </tr>
                </thead>
                <!-- body部 -->
		       <tbody>
		           <logic:present name="IGASM11151VO" property="entityDataList" >
		               <logic:iterate id="bean" name="IGASM11151VO" property="entityDataList" indexId="index">
		                   <tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this,'');">
		                       <td align="right">
                               <html:link href="javaScript:addDevice('${bean.eiid}','${bean.container_eiid}');">
                               <img onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" src="images/michest.gif" alt="设备上架" width="16" height="16"  border="0"/>
                               </html:link>
                               </td>
                               <td align="left" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');">
                               	<html:link href="javaScript:addDevice('${bean.eiid}','${bean.container_eiid}');">设备上架</html:link>
                               </td>
		                       <!-- 设备编号 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                                        ${bean.eilabel}
		                           </div>
		                       </td>
		                       <!-- 设备名称 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
		                           ${bean.einame}
		                           </div>
		                       </td>
		                       <!-- 所属模型 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
		                           ${bean.ename}
		                           </div>
		                       </td>
		                       <!-- 设备高 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="u_width">&nbsp;</logic:empty>
                                   ${bean.u_width}
		                           </div>
		                       </td>
		                       <!-- 所属机柜 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="container_einame">&nbsp;</logic:empty>
                                   ${bean.container_einame}
		                           </div>
		                       </td>
		                       <!-- 位置（U） -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="u_value">&nbsp;</logic:empty>
                                   ${bean.u_value}
		                           </div>
		                       </td>
		                   </tr>
		               </logic:iterate>
		           </logic:present>
		       </tbody>  
            </table>
        </div>
        <div id="operate">
		           <!-- paging -->
		        <jsp:include page="/include/paging.jsp"/>
		           <!-- /paging -->
                <div class="enter">
                    <input type="button" name="btn_close" value="关闭"  onclick="window.close()" class="button">
                </div>
        </div>
        <html:hidden name="IGASM1115Form" property="sel_device_eiid" styleId="sel_device_eiid" value=""/>
        <html:hidden name="IGASM1115Form"  property="container_eid" styleId="container_eid" value="${IGASM1115Form.container_eid}"/>
        <html:hidden name="IGASM1115Form" property="cur_container_name" styleId="cur_container_name" value="${IGASM1115Form.cur_container_name}"/>
        <html:hidden name="IGASM1115Form" property="cur_container_eiid" styleId="cur_container_eiid" value="${IGASM1115Form.cur_container_eiid}"/>
        <html:hidden name="IGASM1115Form" property="cur_container_u_value" styleId="cur_container_u_value" value="${IGASM1115Form.cur_container_u_value}"/>
     </html:form>
</div>


</div>
</body>
</html:html>