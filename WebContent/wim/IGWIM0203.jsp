<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGWIM0203" toScope="request"/>
<bean:define id="title" value="当天工作确认画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
		function checkSubmit(){
		 var excuteTime = document.getElementById("excuteTime").value;
		 if(excuteTime==""||excuteTime==null){
		   		alert("执行时间不能为空！");
		   		return false;
	   	}else{
	   		//校验执行时间输入范围（正数）
	   		var reg = /^\d+(?=\.{0,1}\d+$|$)/;
	   		if(!reg.test(excuteTime) || excuteTime<=0){
	   			jQuery("#excuteTime").val("");
	   			jQuery("#excuteTime").focus();
	   			alert("请输入有效的执行时间（小时）！");
	   			return false;
	   		}
	   	}
		if(jQuery('#wlDescription').length>2000){
			alert("执行情况描述不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
			return false;
		}
		var message = '是否确认当天工作？';
		var btn = jQuery("#btnAction").val();
		if(btn == '0'){
			message = '是否保存当天工作？';
		}
		if( window.confirm(message)){
			return true;
		}else{
			return false;
		}
		}
		//关闭父页，关闭此页,1工作查询，2首页3首页more
		function refreshAndClose(){
			if('${close}'){
				if('${close}'=='2'){
		        	this.opener.location.href = getAppRootUrl()+'/IGCOM0105.do?index=1';
				}else if('${close}'=='1'){
	        		this.opener.location.href = getAppRootUrl()+'/IGWIM0201_Back.do';
				}else{
	        		this.opener.location.href = getAppRootUrl()+'/IGWIM0201_FirstPage.do';
				}
				window.close();
			}
		}
		//用来判断保存或确认
		function onbtnAction(obj){
			if(obj==1){
				//确认按钮
				jQuery("#btnAction").val("1");
			}else{
				jQuery("#btnAction").val("0");
			}
			
		}
	</script>
<style type="text/css">
	input {
	width:250px;
	margin-left:1px;
	border:1px solid #ccc;
	height:20px;
	line-height: 20px;
	font-size: 12px;
	}
	textarea {
		width:255px;
		padding:1px;
		border:1px solid #ccc;
		margin:1px;
		font-family:'Tahoma';	
		font-size:12px;
		font-weight: normal;
	}
	select {
	width:258px;
	margin-left:-2px;
	margin-top:-2px;
	height:40px;
	border: solid #ccc;
	} 
	#shade{
	border:solid 1px #ccc;
	width:253px;
	height:17px;
	overflow:hidden;
	margin-left:1px;
	}
	.333select{
	width:255px;
		padding:1px;
		border:1px solid #ccc;
		margin:1px;
		font-family:'Tahoma';	
		font-size:12px;
		font-weight: normal;
	}
</style>
	
<body onload="refreshAndClose();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">工作确认</p>
            </div>
            
		    <div id="formwrapper">
         <html:form styleId="form" action="/IGWIM0201_Today" onsubmit="return checkSubmit();">
            <ig:message/>
            <fieldset>
	            <legend>当天工作确认信息</legend>
			<logic:present name="IGWIM02011VO" property="wiInfo">
            <table  width="850px" style="margin-left:60px;margin-top:20px;">
            	<tr>
            	<bean:define id="wiinfo" name="IGWIM02011VO" property="wiInfo"></bean:define>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><strong>工作项名称：</strong></td>
            	<td align="left" width="250px"> ${wiinfo.wdname }
            	<html:hidden property="wiid" value="${wiinfo.wiid }"/>
            	<html:hidden property="titleDate" value="${titleDate}"/>
            	</td>
            	<td align="left" width="40px"></td>
            	<td align="right" width="130px" style="background-color: #EEEEEE; "><strong>周期：</strong></td>
            	<td align="left" width="250px">
            	<c:if test="${wiinfo.cycle=='day' }">每日</c:if>
            	<c:if test="${wiinfo.cycle=='week' }">每周</c:if>
            	<c:if test="${wiinfo.cycle=='month' }">每月</c:if>
            	<c:if test="${wiinfo.cycle=='quarter' }">每季度</c:if>
            	<c:if test="${wiinfo.cycle=='halfyear' }">每半年</c:if>
            	<c:if test="${wiinfo.cycle=='year' }">每年</c:if>
            	</td>
            	<td align="left" width="60px"></td>
            	</tr>
	            <tr>
          		<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>工作项描述：</strong></td>
				<td align="left" width="250px">  ${IGWIM02011VO.desc }
				</td>
            	<td align="left" width="40px"></td>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>开始日期：</strong></td>
				<td align="left" width="250px"> ${wiinfo.beginDate }
				 </td>
            	<td align="left" width="40px"></td>
            	</tr>
	            <tr>
          		<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>负责人：</strong></td>
				<td align="left" width="250px">${wiinfo.leaderName }
				</td>
            	<td align="left" width="40px"></td>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>执行人：</strong></td>
				<td align="left" width="250px">${wiinfo.excutorName }
				</td>
            	<td align="left" width="40px"></td>
            	</tr>
	            <tr>
          		<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>执行时间(小时)：</strong></td>
				<td align="left" width="250px"> 
				<c:if test="${wiinfo.wistatus=='结束' or wiinfo.wistatus=='终止'}">
					${wiinfo.excuteTime }
				</c:if>
				<c:if test="${wiinfo.wistatus!='结束' && wiinfo.wistatus!='终止'}">
				<c:if test="${empty lookFlag}">
					<html:text property="excuteTime" errorStyleClass="inputError imeActive" tabindex="5" value="${wiinfo.excuteTime }"/>
					</c:if>
					<c:if test="${not empty lookFlag}">
						${wiinfo.excuteTime}
					</c:if>	
				</c:if>
				<c:if test="${empty wiinfo.wistatus}">
					<c:if test="${empty lookFlag}">
						<html:text property="excuteTime" errorStyleClass="inputError imeActive" tabindex="5" value="${wiinfo.excuteTime }"/>
					</c:if>
					工作处理完成了，只能查看
					<c:if test="${not empty lookFlag}">
						${wiinfo.excuteTime}
					</c:if>	
				</c:if>
            	<td align="left" width="40px"></td>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>执行情况描述：</strong></td>
				<td align="left" width="250px">
				<c:if test="${wiinfo.wistatus=='结束' or wiinfo.wistatus=='终止'}">
					${wiinfo.description }
				</c:if>
				<c:if test="${wiinfo.wistatus!='结束' && wiinfo.wistatus!='终止'}">
				<c:if test="${empty lookFlag}">
					 <html:textarea property="wlDescription" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5" value="${wiinfo.description }"/>
				</c:if>
				<c:if test="${not empty lookFlag}">
<%-- 						${bean.wlDescription} --%>
						${wiinfo.description }
					</c:if>
				</c:if>
				<c:if test="${empty wiinfo.wistatus}">
					工作处理
					<c:if test="${empty lookFlag}">
					 <html:textarea property="wlDescription" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5" value="${wiinfo.description }"/>
					</c:if>
					工作处理完成了，只能查看
					<c:if test="${not empty lookFlag}">
<%-- 						${bean.wlDescription} --%>
						${wiinfo.description }
					</c:if>
				</c:if>			
				</td>
            	<td align="left" width="40px"></td>
            	</tr>
		        </table>
		        </logic:present>   
	            <div class="enter">
            	 <!-- 工作未超时处理的显示按钮 -->
	             <c:if test="${IGWIM02011VO.isOverTime=='0'}">
					<!-- 确认过的隐藏按钮 -->
	             	<c:if test="${wiinfo.wistatus!='1'}">
		            <c:if test="${empty lookFlag}">
		                <html:submit property="btn_save" value="保存" styleClass="button"  onclick="onbtnAction('0');"  />
		                <html:submit property="btn_insert" value="确认" styleClass="button" onclick="onbtnAction('1');" />
		            </c:if>
		         	</c:if>
	             </c:if>
	                <html:button property="btn_ext" value="关闭" styleClass="button" onclick="javascript:window.close();"/>
	            </div>
	            
				<DIV class=title>
					<DIV class=name><strong>执行记录</strong></DIV>
				</DIV>
	            <div id="results_list"><ig:message />
					<table class="table_style">
						<tr>
							<th width="12%">执行人</th>
							<th width="40%">执行情况描述</th>
							<th width="20%">执行时间(小时)</th>
							<th width="20%">确认时间</th>
						</tr>
						<!-- 处理记录 -->
						<logic:present name="IGWIM02011VO" property="wlogList"> 
							<logic:iterate id="bean" name="IGWIM02011VO" property="wlogList">
								<tr>
								<td>${bean.excutorName }</td>							
								<td>${bean.wlDescription }</td>							
								<td>${bean.excuteTime }</td>							
								<td>${bean.actualDealwithDate }</td>							
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</div>
	            </fieldset>
                <html:hidden property="btnAction" styleId="btnAction"/>
	            <html:hidden property="openFlag" value="${IGWIM0201Form.openFlag }"/>
	         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>