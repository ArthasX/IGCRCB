<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1105" toScope="request"/>
<bean:define id="title" value="机柜选择画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
    var gid='IGASM1105';
	   function addContainer(eiid,room_id) {
           var message1 = '<bean:message key="IGASM1105.W001"/>';
           var message2 = '<bean:message key="IGASM1105.W002"/>';
           var message = '';

           if (room_id == '') {
        	   message = message1;
           } else {
               message = message2;
           }
           $('sel_container_eiid').value = eiid;
           if( window.confirm(message)){
               form.action = getAppRootUrl() + "/IGASM1105_Add.do";
               form.submit();
               
           }
	   }

	   function initCheck(){
		   success = '<bean:write name="IGASM1105Form" property="success"/>';

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
body{
overflow-x:auto;
overflow-y:auto;
}
</style>
<body onload="initCheck();">
<div id="container">
    <html:form styleId="form" action="/IGASM1105" onsubmit="return checkSubmit(this);">
    <div id="location">
        <div class="image"></div>
            <p class="fonts1">机柜查询</p>
    </div>
	    <div class="title">
	        <div class="name">当前机房信息</div>
	    </div>
	    <div id="results_list">
	       <table class="table_style6" align="left">
	           <tr>
	               <th width="15%" >机房名</th>
	               <td width="25%" >${IGASM1105Form.cur_room_name}</td>
	               <th width="15%" >横向座标</th>
	               <td width="15%" >${IGASM1105Form.cur_room_x_value}</td>
	               <th width="15%" >纵向座标</th>
	               <td width="15%" >${IGASM1105Form.cur_room_y_value}</td>
	           </tr>
	        </table>
	     </div>

        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
	                <label>机柜编号：</label><html:text name="IGASM1105Form" property="eilabel" styleId="eilabel"  errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
	                <label>机柜名：</label><html:text name="IGASM1105Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="20" /> &nbsp;&nbsp;
                    <label>机柜高：</label><html:text name="IGASM1105Form" property="u_total" styleId="u_total" errorStyleClass="inputError imeDisabled" size="5" /> 
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
                        <th width="2%"></th>
				    	<th width="8%"></th>
                        <th width="8%">机柜编号
                        </th>
                        <th width="10%">机柜名称
                        </th>
                        <th width="18%">机柜说明
                        </th>
                        <th width="8%">机柜高
                        </th>
                        <th width="10%">横向宽(地板)
                        </th>
                        <th width="10%">纵向宽(地板)
                        </th>
                        <th width="10%">所属机房
                        </th>
                        <th width="8%">位置（X）
                        </th>
                        <th width="8%" >位置（Y）
                        </th>
                    </tr>
                </thead>
                <!-- body部 -->
		       <tbody>
		           <logic:present name="IGASM11051VO" property="entityDataList" >
		               <logic:iterate id="bean" name="IGASM11051VO" property="entityDataList" indexId="index">
		                   <tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this,'');">
                               <td align="right">
                               <html:link href="javaScript:addContainer('${bean.eiid}','${bean.room_eiid}');">
                               <img onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" src="images/miroom.gif" alt="移入机房" width="16" height="16"  border="0"/>
                               </html:link>
                               </td>
                               <td align="left" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');">
                               	<html:link href="javaScript:addContainer('${bean.eiid}','${bean.room_eiid}');">移入机房</html:link>
                               </td>
		                       <!-- 机柜编号 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                                        ${bean.eilabel}
		                           </div>
		                       </td>
		                       <!-- 机柜名称 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
		                           ${bean.einame}
		                           </div>
		                       </td>
		                       <!-- 机柜说明 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
		                           ${bean.eidesc}
		                           </div>
		                       </td>
		                       <!-- 机柜高 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="u_total">&nbsp;</logic:empty>
                                   ${bean.u_total}
		                           </div>
		                       </td>
                               <!-- 机柜横向宽 -->
                               <td align="center">
                                   <div class="nowrapDiv">
                                   <logic:empty name="bean" property="x_width">&nbsp;</logic:empty>
                                   ${bean.x_width}块
                                   </div>
                               </td>
                               <!-- 机柜纵向宽 -->
                               <td align="center">
                                   <div class="nowrapDiv">
                                   <logic:empty name="bean" property="y_width">&nbsp;</logic:empty>
                                   ${bean.y_width}块
                                   </div>
                               </td>
		                       <!-- 所属机房 -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="room_einame">&nbsp;</logic:empty>
                                   ${bean.room_einame}
		                           </div>
		                       </td>
		                       <!-- 位置（X） -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           	<logic:empty name="bean" property="x_value">&nbsp;</logic:empty>
		                           <logic:notEmpty name="bean" property="room_einame">
                                   	${bean.x_value}
                                  	</logic:notEmpty>
		                           </div>
		                       </td>
		                       <!-- 位置（Y） -->
		                       <td align="center">
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="y_value">&nbsp;</logic:empty>
		                           <logic:notEmpty name="bean" property="room_einame">
                                   	${bean.y_value}
                                   </logic:notEmpty>
		                           </div>
		                       </td>
		                   </tr>
		               </logic:iterate>
		           </logic:present>
		       </tbody>  
            </table>
        </div>
        <div id="operate">
		       <jsp:include page="/include/paging.jsp"/>
                <div class="enter">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
            </div> 
        </div>
        <html:hidden name="IGASM1105Form" property="sel_container_eiid" styleId="sel_container_eiid" value=""/>
        <html:hidden name="IGASM1105Form" property="room_eid" styleId="room_eid" value="${IGASM1105Form.room_eid}"/>
        <html:hidden name="IGASM1105Form" property="cur_room_name" styleId="cur_room_name" value="${IGASM1105Form.cur_room_name}"/>
        <html:hidden name="IGASM1105Form" property="cur_room_eiid" styleId="cur_room_eiid" value="${IGASM1105Form.cur_room_eiid}"/>
        <html:hidden name="IGASM1105Form" property="cur_room_x_value" styleId="cur_room_x_value" value="${IGASM1105Form.cur_room_x_value}"/>
        <html:hidden name="IGASM1105Form" property="cur_room_y_value" styleId="cur_room_y_value" value="${IGASM1105Form.cur_room_y_value}"/>
     </html:form>
</div>



</body>
</html:html>