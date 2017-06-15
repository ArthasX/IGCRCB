<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0320" toScope="request"/>
<bean:define id="title" value="借款管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function changeStatus(lpdstatus){
        var message ='请选择要审批的记录！';
        var confirmMsg ='请确认是否审批通过？';
        
        if(lpdstatus ==3){
        	 message ='请选择审批未通过的记录！';
             confirmMsg ='请确认是否审批未通过？';
        }
        var frm = window.document.forms[0];
        if(frm.deleteLpdid) {
	        if(frm.deleteLpdid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteLpdid.length; i++ ){
	                if (frm.deleteLpdid[i].checked == true){
		                
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteLpdid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        }
        
        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGLOM0320_Change.do?&lpdstatus="+lpdstatus;
            return true;
        } else {
            return false;
        }
	}

	    function init(){
			if($F('flag') == "3"){
				//接待工作借款菜单
				SwitchMenu('sub2');
			}else{
				//预制管理借款菜单
				SwitchMenu('sub4');
			}
		}
	
	</script>

<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGLOM0320" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 借款审批</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
            		
            		 	<span>&nbsp;&nbsp;&nbsp;&nbsp;借款人：</span><html:text property="lpduser_q" styleId="lpduser_q" errorStyleClass="inputError imeDisabled" size="18"/>&nbsp;&nbsp;
					<label>借款日期：从</label>
		                 <html:text property="time_from" styleId="rtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('rtime_from'))" border="0" />&nbsp;&nbsp;
		                 <label>到</label>
		                 <html:text property="time_to" styleId="rtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('rtime_to'))" border="0"/>
			        	<html:submit property="btn_search" value="查询" styleClass="button"/>
		     		</div>
          		</div> 
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="5%">
					              <label> <input type="checkbox"
					                     name="checkbox" id="checkbox" onclick="selectAllNoDisable('checkbox','deleteLpdid')"/> 
				                  </label>
					           </th>
					           <th width="10%">借款人</th>
					           <th width="15%">借款人机构</th>
					           <th width="10%">借款日期</th>
					           <th width="12%">借款金额</th>
					           <th width="25%">用途</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM03041VO" property="loanPayDetailList" >
			                    <logic:iterate id="bean" name="IGLOM03041VO" property="loanPayDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
					                    	<html:checkbox property="deleteLpdid" value="${bean.lpdid}"/>
			                            </td>
			                            <!-- 借款人 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.lpduser}</div>
			                            </td>
			                            <!-- 借款人机构 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.organizationTB.orgname}</div>
			                            </td>
			                            <!-- 借款日期 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpddate}</div>
			                            </td>
			                            <!-- 借款金额 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdamount}</div>
			                            </td>
			                            <!-- 用途 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdcomment}</div>
			                            </td>

			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGLOM03041VO" property="loanPayDetailList" >
                            		<html:submit property="btn_delete" value="审批通过" styleClass="button" onclick="return changeStatus('2');" />
                            		<html:submit property="btn_delete" value="审批未通过" styleClass="button" onclick="return changeStatus('3');" />
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
			    <html:hidden property="lpdstatus_q" styleId="lpdstatus_q" name="IGLOM0304Form"/>
			    <html:hidden property="lpdtype_q" styleId="lpdtype_q" name="IGLOM0304Form"/>
			    <html:hidden property="flag" styleId="flag" name="IGLOM0304Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>