<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGWIM0202" toScope="request"/>
<bean:define id="title" value="周期工作确认画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
		function checkSubmit(){
			if(!jQuery('#excuteTime').val()){
		  		alert("执行时间不能为空！");
		  		return false;
			}else{
				//校验执行时间输入范围（正数）
		   		var reg = /^\d+(?=\.{0,1}\d+$|$)/;
		   		if(!reg.test(jQuery('#excuteTime').val()) || jQuery('#excuteTime').val()<=0){
		   			jQuery("#excuteTime").val("");
		   			jQuery("#excuteTime").focus();
		   			alert("请输入有效的执行时间（小时）！");
		   			return false;
		   		}
			}
			if(jQuery('#wiDescription').length>2000){
				alert("执行情况描述不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
				return false;
			}
			var message = '是否确认周期工作？';
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
		//用来判断终止或确认
		function btnAction(obj){
			if(obj==1){
				//终止
				jQuery("#wistatus").val("终止");
			}else{
				jQuery("#wistatus").val("结束");
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
		         <html:form styleId="form" action="/IGWIM0201_CYCLE" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
			            <legend>周期工作确认信息</legend>
			            
            <table  width="850px" style="margin-left:60px;margin-top:20px;">
            	<tr>
            	<bean:define id="wiinfo" name="IGWIM02011VO" property="wiInfo"></bean:define>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><strong>工作项名称：</strong></td>
            	<td align="left" width="250px"> ${wiinfo.wdname }
            	<html:hidden property="wiid" value="${wiinfo.wiid }"/>
            	<html:hidden property="wdname" styleId="wdname" value=" ${wiinfo.wdname }"/>
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
            	 <html:hidden property="cycle"  value="${wiinfo.cycle }"/>
            	</td>
            	<td align="left" width="60px"></td>
            	</tr>
	            <tr>
          		<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>工作项描述：</strong></td>
				<td align="left" width="250px">  ${IGWIM02011VO.desc }
				<html:hidden property="description" value=" ${IGWIM02011VO.desc }"/>
				</td>
            	<td align="left" width="40px"></td>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>开始日期：</strong></td>
				<td align="left" width="250px"> ${wiinfo.beginDate }
				 <html:hidden property="beginDate" value="${wiinfo.beginDate }"/>
				 </td>
            	<td align="left" width="40px"></td>
            	</tr>
	            <tr>
          		<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>负责人：</strong></td>
				<td align="left" width="250px">${wiinfo.leaderName }
				 <html:hidden property="leaderName" value="${wiinfo.leaderName }"/>
				 <html:hidden property="leaderId" value="${wiinfo.leaderId }"/>
				</td>
            	<td align="left" width="40px"></td>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>执行人：</strong></td>
				<td align="left" width="250px">${wiinfo.excutorName }
				 <html:hidden property="excutorName" value="${wiinfo.excutorName }"/>
				 <html:hidden property="excutorId" value="${wiinfo.excutorId }"/>
				</td>
            	<td align="left" width="40px"></td>
            	</tr>
	            <tr>
          		<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>执行时间(小时)：</strong></td>
				<td align="left" width="250px"> 
				<!-- 工作处理 -->
				<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
					${bean.excuteTime}
				</c:if>
				<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
					<html:text property="excuteTime" errorStyleClass="inputError imeActive" tabindex="5" styleId="excuteTime" value="${wiinfo.excuteTime}"/>
				</c:if>
<%-- 				<c:if test="${empty lookFlag}"> --%>
<%-- 					<html:text property="excuteTime" errorStyleClass="inputError imeActive" tabindex="5"/> --%>
<%-- 				</c:if> --%>
<!-- 				工作处理完成了，只能查看 -->
<%-- 				<c:if test="${not empty lookFlag}"> --%>
<%-- 					${bean.excuteTime} --%>
<%-- 				</c:if> --%>
				</td>
            	<td align="left" width="40px"></td>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>执行情况描述：</strong></td>
				<td align="left" width="250px">
				
								
				<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
					${bean.wiDescription}
				</c:if>
				<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
				 <html:textarea property="wiDescription" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5" value="${wiinfo.wiDescription }"/>
				</c:if>
					<!-- 工作处理 -->
<%-- 				<c:if test="${empty lookFlag}"> --%>
<%-- 				 <html:textarea property="wiDescription" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5"/> --%>
<%-- 				</c:if> --%>
				<!-- 工作处理完成了，只能查看 -->
				<c:if test="${not empty lookFlag}">
					${bean.wiDescription}
				</c:if>
				 </td>
            	<td align="left" width="40px"></td>
            	</tr>
		        </table>
	            <div class="enter">
					<!-- 工作处理完成了，只能查看 -->
					<c:if test="${empty lookFlag}">
	                <html:submit property="btn_insert" value="确认" styleClass="button" onclick="btnAction(0);"/>
						<!-- 终止工作 -->
		                <html:submit property="btn_over" value="终止" styleClass="button" onclick="btnAction(1);"/>
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
                <html:hidden property="wistatus" styleId="wistatus"/>
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