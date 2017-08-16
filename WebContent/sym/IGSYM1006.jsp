<%@page import="com.deliverik.plugin.sms.WXThread"%>
<%@page import="com.deliverik.plugin.mail.MAILThread"%>
<%@page import="com.deliverik.plugin.sms.SMSThread"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1006" toScope="request"/>
<bean:define id="title" value="数据详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    function deleteRec(cid){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="数据详细信息" />';
        if( window.confirm(confirmMsg)){
        	$("cid").value = cid;
            var form = window.document.forms[0];
            form.action = getAppRootUrl() + "/IGSYM1006_Del.do";
            form.submit();
        }
    }

    function add(){
        form.action = getAppRootUrl() + "/IGSYM1004_Disp.do?route=1";
        form.submit();
    }

    function toback(){
    	form.action = getAppRootUrl() + "/IGSYM1006.do?btn_back=1";
    	form.submit();
    }
	function testConnection(port){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=testConnection&port='+port,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		alert(res);
	}
function setSMSstatus(type, SMSCTLbtnValue){
	if(confirm("请确认是否"+SMSCTLbtnValue+"短信服务功能")){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type='+type+'&status='+SMSCTLbtnValue,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		$('SMSCTLbtn').value=res;
		if(res!=null && res !=""){
			if(res == "开启"){
				$('sms_status').innerHTML="已关闭";
// 				alert("关闭成功!");
			}else{
				$('sms_status').innerHTML="已开启";
// 				alert("启动成功!");
			}
		}else{
// 			alert("变更状态失败！");
		}
	}
}
function setWXstatus(type, WXCTLbtnValue){
	alert(type+" "+WXCTLbtnValue);
	if(confirm("请确认是否"+WXCTLbtnValue+"微信服务功能")){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type='+type+'&status='+WXCTLbtnValue,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		$('WXCTLbtn').value=res;
		if(res!=null && res !=""){
			if(res == "开启"){
				$('wx_status').innerHTML="已关闭";
// 				alert("关闭成功!");
			}else{
				$('wx_status').innerHTML="已开启";
// 				alert("启动成功!");
			}
		}else{
// 			alert("变更状态失败！");
		}
	}
}

</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
        
            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; ${IGSYM10061VO.codeCategoryInfo.ccname}</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

            <html:form styleId="form" action="/IGSYM1006" onsubmit="return checkSubmit(this);">
			    <div class="title">
			        <div class="name">数据分类信息</div>
			    </div>
			    <div id="results_list" style="width:60%;">
			        <table width="100%" class="table_style">
			            <tr>
			                <th width="50%" >编号</th>
			                <th width="50%" >名称</th>
 			            </tr>
			            <tr>
			               <td height="20" align="center">${IGSYM10061VO.codeCategoryInfo.ccid}</td>
			               <td align="center">${IGSYM10061VO.codeCategoryInfo.ccname}</td>
			               <td align="center">${IGSYM10061VO.codeCategoryInfo.ccinfo}</td>
			            </tr>
			        </table>
		        </div>
		        <c:if test="${IGSYM10061VO.codeCategoryInfo.ccid != 159 && IGSYM10061VO.codeCategoryInfo.ccid != 177}">
				<div class="title">
				<div class="name">数据详细信息</div>
				</div>  
                <div id="results_list">
                    <!--  message -->
                    <ig:message/>
                    <!--  /message -->     
			        <table class="table_style">
			            <!-- header部 -->
			                <tr>
			                   <th width="5%"></th>
					           <th width="30%" >说明</th>
					           <th width="30%" >内容</th>
					           <th width="30%">更新时间</th>
					           <th width="5%">修改</th>
			                </tr>
			            <!-- body部 -->
			           
			                <logic:present name="IGSYM10061VO" property="codeDetailList" >
			                    <logic:iterate id="bean" name="IGSYM10061VO" property="codeDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td align="center">
			                               ${index+1}
			                            </td>
			                            <!-- 说明 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
                                                ${bean.cdinfo}
                                                <logic:equal value="153" name="IGSYM1006Form" property="ccid">
                                                	<logic:equal value="10" name="bean" property="cid"></logic:equal>
                                                </logic:equal>
			                                </div>
			                            </td>
			                            <!-- 内容 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>
			                                <logic:equal name="bean" property="cdstatus" value="P">
			                                	******
			                                </logic:equal>
			                                <logic:notEqual name="bean" property="cdstatus" value="P">
			                                	${bean.cvalue}
			                                </logic:notEqual>
			                                </div>
			                            </td>
			                            <!-- 更新时间 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="updtime">&nbsp;</logic:empty>
			                                ${bean.updtime}                           
			                                </div>
			                            </td>
			                            <td align="center">
			                                <div class="nowrapDiv">
				                             	<html:link action="/IGSYM1004_Disp.do?ccid=${IGSYM10061VO.codeCategoryInfo.ccid}&cid=${bean.cid}">
				                             	<img src="images/edit.gif" alt="修改" width="16" height="16" border="0"/></html:link>                
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
	                </table>
		        </div>
				</c:if>
                <div id="operate">
				
				
				
				<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 160}">
				<div class="title">
				<div class="name">微信服务状态</div>
				</div> 
				    <table class="table_style" >
				    <tr>
				   <th>
				    	状态
				    </th>
				    <th>
				    	操作
				    </th>
				    </tr>
				    <tr>
				   <td>
					&nbsp;&nbsp;&nbsp;
					<label id="wx_status">
						
						
						<%=(WXThread.iswxOpen()?"已开启":"已关闭") %>
					<%-- <%=(SMSThread.isSmsOpen()?"已开启":"已关闭") %> --%>
					</label>
				    </td>
				    <td>
				    	<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 160}">
				    	
							<input id="WXCTLbtn" class="button" type="button" value="<%=(WXThread.iswxOpen()?"关闭":"开启") %>" onclick="setWXstatus('setWXstatus',$('WXCTLbtn').value)" >
					
				    	</c:if>    	
				    </td>
				    </tr>
				    </table>
				    <br/>
				    <br/>
				    	
				    </c:if>
				<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 153}">
				<div class="title">
				<div class="name">短信服务状态</div>
				</div> 
				    <table class="table_style" >
				    <tr>
				   <th>
				    	状态
				    </th>
				    <th>
				    	操作
				    </th>
				    </tr>
				    <tr>
				   <td>
					&nbsp;&nbsp;&nbsp;
					<label id="sms_status">
						<c:if test="${IGSYM10061VO.flag == '0'}">
							已关闭
						</c:if>
						<c:if test="${IGSYM10061VO.flag == '1'}">
							已开启
						</c:if>
					<%-- <%=(SMSThread.isSmsOpen()?"已开启":"已关闭") %> --%>
					</label>
				    </td>
				    <td>
				    	<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 153}">
				    		<c:if test="${IGSYM10061VO.flag == '0'}">
							<input id="SMSCTLbtn" class="button" type="button" value="开启" onclick="setSMSstatus('setSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
							<c:if test="${IGSYM10061VO.flag == '1'}">
								<input id="SMSCTLbtn" class="button" type="button" value="关闭" onclick="setSMSstatus('setSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
				    	</c:if>
				    	<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 159}">
				    		<c:if test="${IGSYM10061VO.flag == '0'}">
							<input id="SMSCTLbtn" class="button" type="button" value="开启" onclick="setSMSstatus('setEveryDayWorkSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
							<c:if test="${IGSYM10061VO.flag == '1'}">
								<input id="SMSCTLbtn" class="button" type="button" value="关闭" onclick="setSMSstatus('setEveryDayWorkSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
				    	</c:if>
				    	<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 177}">
				    		<c:if test="${IGSYM10061VO.flag == '0'}">
							<input id="SMSCTLbtn" class="button" type="button" value="开启" onclick="setSMSstatus('setWorkItemSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
							<c:if test="${IGSYM10061VO.flag == '1'}">
								<input id="SMSCTLbtn" class="button" type="button" value="关闭" onclick="setSMSstatus('setWorkItemSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
				    	</c:if>
				    </td>
				    </tr>
				    </table>
				    <br/>
				    <br/>
				    	
				    </c:if>
				    <c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 159}">
				<div class="title">
				<div class="name">短信服务状态</div>
				</div> 
				    <table class="table_style" >
				    <tr>
				   <th>
				    	状态
				    </th>
				    <th>
				    	操作
				    </th>
				    </tr>
				    <tr>
				   <td>
					&nbsp;&nbsp;&nbsp;
					<label id="sms_status">
						<c:if test="${IGSYM10061VO.flag == '0'}">
							已关闭
						</c:if>
						<c:if test="${IGSYM10061VO.flag == '1'}">
							已开启
						</c:if>
					<%-- <%=(SMSThread.isSmsOpen()?"已开启":"已关闭") %> --%>
					</label>
				    </td>
				    <td>
				    	<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 159}">
				    		<c:if test="${IGSYM10061VO.flag == '0'}">
							<input id="SMSCTLbtn" class="button" type="button" value="开启" onclick="setSMSstatus('setEveryDayWorkSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
							<c:if test="${IGSYM10061VO.flag == '1'}">
								<input id="SMSCTLbtn" class="button" type="button" value="关闭" onclick="setSMSstatus('setEveryDayWorkSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
				    	</c:if>
				    </td>
				    </tr>
				    </table>
				    <br/>
				    <br/>
				    </c:if>
				<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 170}">
				<div class="title">
				<div class="name">邮件服务状态</div>
				</div> 
				    <table class="table_style" >
				    <tr>
				   <th>
				    	状态
				    </th>
				    <th>
				    	操作
				    </th>
				    </tr>
				    <tr>
				   <td>
					&nbsp;&nbsp;&nbsp;<label id="mail_status"><%=(MAILThread.isMailOpen()?"已开启":"已关闭") %></label>
				    </td>
				    <td>
				    	<input id="MAILCTLbtn" class="button" type="button" value="<%=(MAILThread.isMailOpen()?"关闭":"开启") %>" onclick="setMAILstatus($('MAILCTLbtn').value)" >
				    </td>
				    </tr>
				    </table>
				    <br/>
				    <br/>
				    
				    </c:if>
				    <c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 177}">
				<div class="title">
				<div class="name">短信服务状态${IGSYM10061VO.flag}</div>
				</div> 
				    <table class="table_style" >
				    <tr>
				   <th>
				    	状态
				    </th>
				    <th>
				    	操作
				    </th>
				    </tr>
				    <tr>
				   <td>
					&nbsp;&nbsp;&nbsp;
					<label id="sms_status">
						<c:if test="${IGSYM10061VO.flag == '0'}">
							已关闭
						</c:if>
						<c:if test="${IGSYM10061VO.flag == '1'}">
							已开启
						</c:if>
					<%-- <%=(SMSThread.isSmsOpen()?"已开启":"已关闭") %> --%>
					</label>
				    </td>
				    <td>
				    	<c:if test="${IGSYM10061VO.codeCategoryInfo.ccid == 177}">
				    		<c:if test="${IGSYM10061VO.flag == '0'}">
							<input id="SMSCTLbtn" class="button" type="button" value="开启" onclick="setSMSstatus('setWorkItemSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
							<c:if test="${IGSYM10061VO.flag == '1'}">
								<input id="SMSCTLbtn" class="button" type="button" value="关闭" onclick="setSMSstatus('setWorkItemSMSstatus',$('SMSCTLbtn').value)" >
							</c:if>
				    	</c:if>
				    </td>
				    </tr>
				    </table>
				    <br/>
				    <br/>
				    </c:if>
			        <div class="content">
			            <div class="enter">
	                        <html:submit property="btn_back" styleClass="button" value="返回"/>
			            </div>
			        </div> 
    		    </div>
                <html:hidden property="ccid" styleId="ccid" value="${IGSYM10061VO.codeCategoryInfo.ccid}"/>
                <html:hidden property="ccname" styleId="ccname" value="${IGSYM10061VO.codeCategoryInfo.ccname}"/>
                <html:hidden property="cid" styleId="cid" value=""/>
		    </html:form>
        </div>
    </div>
</div>


</div>
</body>
</html:html>