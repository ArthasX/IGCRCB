<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.risk.model.RiskCheck"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGWIM0105" toScope="request" />
<bean:define id="title" value="工作项定义查看页面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link rel="stylesheet" href="<html:rewrite forward='jquery.tzCheckbox.css'/>" type="text/css">
<script src="<html:rewrite forward='jquery.min.js'/>"></script>
<script>
var jQ = jQuery.noConflict(true);//jquery与prototype冲突
</script>
<script src="<html:rewrite forward='jquery.tzCheckbox.js'/>"></script>
<script src="<html:rewrite forward='script.js'/>"></script>
<style type="text/css">
FIELDSET DIV {
    clear: left;
    margin-bottom: 2px;
    margin-top: 2px;
    margin-left: 0px;
}

.clearLabel{
	float: none;
    width: auto;
    text-align: center;
    margin: 0px;
    background-color: white;
    padding-top: 4px;
    padding-right: 2px;
    padding-bottom: 2px;
    padding-left: 4px;
}

</style>
<!-- /header1 -->
<%
RiskCheck rc = (RiskCheck)request.getAttribute("riskcheck");
String onceChecked="";
String dayChecked = "";
String weekChecked = "";
String monthChecked = "";
String quarterChecked = "";
//增加频率 每半年，每年
String halfyearChecked = "";
String yearChecked = "";
String day = null;
String rcrtestmode="0";
if(rc!=null){
	rcrtestmode=rc.getRcrtestmode();
	String cron = rc.getRccron();
	if(cron!=null){
		String hour = cron.split(" ")[2];
		int qjhour = Integer.valueOf(hour);
		String minute = cron.split(" ")[1];
		int qjminute = Integer.valueOf(minute);
		
		if(cron.contains("/")){
			quarterChecked = "checked=\"checked\"";
			day = cron.split("/")[1].split(" ")[0];
		}else{
			day = cron.split(" ")[3];
		}

		if(!"?".equals(day) && "*".equals(day)){
			dayChecked = "checked=\"checked\"";
		}else if("?".equals(day)){
			weekChecked = "checked=\"checked\"";
		}else {
			if("".equals(quarterChecked)){
				//每半年，每年频率 根据 IGRIS02BLImpl 136 行
				String month =  cron.split(" ")[4];
				if(month.contains("*"))
				{
					monthChecked = "checked=\"checked\"";
				}
				else if(month.contains(","))
				{
					halfyearChecked = "checked=\"checked\"";
				}
				else if(rc.getRcfrequency().equals("once")){
					onceChecked="checked=\"checked\"";
				}
				else 
				{
					yearChecked = "checked=\"checked\"";
				}
				
			}
		}
	}else{
		dayChecked = "checked=\"checked\"";
		
	}
}else{
	dayChecked = "checked=\"checked\"";
}

%>

<script type="text/javascript">	

	function toQuency(quency){
		var page = document.getElementById("page");
		if(quency == 'week' || quency == 'month'){
			 document.getElementById("page").style.display='';
			 var divArray = page.getElementsByTagName("div");
			 for (var i=0;i<divArray.length;i++) {
			  if (divArray[i].id == quency) {
			   divArray[i].style.display='';
			  }else {
			   divArray[i].style.display='none';
			  }
			 }
			 if(quency == 'month'){
				 document.getElementById("month1").style.display='';
			}else{
				 document.getElementById("month1").style.display='none';
			}
		}else{
			document.getElementById("page").style.display='none';
			document.getElementById("month1").style.display='none';
		}
		if(quency == 'quarter' || quency == 'halfyear' || quency == 'year'){
			document.getElementById("time").style.display='none';
		}else{
			jQuery("#time").show();
		}
	}
	
	jQuery(document).ready(function(){
		//设置文本框的宽度
    	jQuery("input[type='text']").width(200);
		
		var quency = jQuery("input[name='cycle']:checked").val();
		toQuency(quency);
	});
	
	
	//设置负责人
	function searchFzr(){
		openSubWindow('/IGSYM1905_Open.do', '_blank','1000','600','center:1');
	}
	//负责人回显
    function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
    	document.getElementById("leaderName").value = username;
		document.getElementById("leaderId").value = userid;
	}
    
    var tempId = "";	//定义tempId变量
  	var tempName = "";	//定义tempName变量
    jQuery(document).ready(function(){
 		jQ('input[type=checkbox]').tzCheckbox({labels:['Enable','Disable']});
 		//设置周联动
    	jQuery("input[weekCk=1]").siblings().click(function (obj){
    		jQuery("input[weekCk=1]").siblings().not(obj).removeClass().addClass("tzCheckBox");
    	});
 		//设置月联动
    	jQuery("input[monthCk=1]").siblings().click(function (obj){
    		jQuery("input[monthCk=1]").siblings().not(obj).removeClass().addClass("tzCheckBox");
    	});
    	
 		//设置是否月最后一天联动
    	jQuery("input[monthCk=2]").siblings().click(function (){
    		jQuery("input[monthCk=1]").siblings().removeClass().addClass("tzCheckBox");
    		jQuery("input[monthCk=1]").attr("checked",false);
    	});
 		
    	//根据周期判断时间元素是否选中
 		if(jQuery("#everyQuarter").checked || jQuery("#everyHalfyear").checked || jQuery("#everyYear").checked){
 			
	 		jQuery("#time").hide();
 		}else{
 			
	 		jQuery("#time").show();
 			
 		}
 		
 		//如果是修改，设置radio默认选中
 		var modifyFlag = jQuery("#mode").val();
 		//mode=1为修改；否则为新增
 		if(modifyFlag=="1"){
 			
 			//获取周期
 			var cycle = jQuery("#cycyleHide").val();
 			//获取周
 			var week = jQuery("#weekHide").val();
 			//获取月份
 			var month = jQuery("#monthHide").val();
 			//获取是否最后一月
 			var lastMonth = jQuery("#lastMonthHide").val();
 			//设置周期默认选中
 			jQuery("input[name='cycle'][value='"+cycle+"']").attr("checked",true);
 			if(cycle=='week'){
 				
 				toQuency('week');
 				//设置周默认值选中
 				jQuery("input[weekCk=1][value='"+week+"']").attr("checked",true);
 				//设置选中样式
 				jQuery("input[weekCk=1][value='"+week+"']").next().removeClass().addClass("tzCheckBox checked");
 				
 			}else if(cycle=='month'){
 				
				toQuency('month');
 				if(lastMonth=="Y"){
 					//设置是否月最后一天选中？？？
 					jQuery("input[name='monthLastDay']").next().click();
 				}else{
 					//设置月份对应的日期选中
 					jQuery("input[monthCk=1][value='"+month+"']").attr("checked",true);
 					jQuery("input[monthCk=1][value='"+month+"']").next().removeClass().addClass("tzCheckBox checked");
 				}
 			}
 			//设置时
 			jQuery("#wdhour").val(jQuery("#hour").val());
 			//设置分
 			jQuery("#wdminute").val(jQuery("#minutes").val());
//  			//设置启用状态
//  			if(jQuery("#status").val()!='' && jQuery("#status").val()!='0'){
//  				jQuery("#wdstatus").val(1);
//  			}else{
//  				jQuery("#wdstatus").val(0);
//  			}
 			
 			//显示执行人
 			var userid = jQuery("#excutorId").val();	//获取userid
 			var username = jQuery("#excutorName").val();	//获取username
 			//给变量赋值
 			tempId = userid;
 			tempName = username;
 			//拆分字符串
 			var ids = userid.split("、");	
 	  		var names = username.split("、");
 	  		if(userid.length>0){
 		  		for(var i = 0;i<ids.length;i++){
 		  			if(i==ids.length-1){
	 		  			jQuery("#zxrArea").append("<a href='javascript:;' uid='"+ids[i]+"' style='cursor:text;text-decoration:none'>"+names[i]+"</a>");
 		  			}else{
	 		  			jQuery("#zxrArea").append("<a href='javascript:;' uid='"+ids[i]+"' style='cursor:text;text-decoration:none'>"+names[i]+"、</a>");
 		  			}
 		  		}
 	  		}
 		}
    });
    
//-->
</script>

<body>

<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> 
<!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location" style="cursor: text;">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
                <logic:equal name="IGWIM0101Form" property="mode" value="1">
					<div class="back"><a href="IGWIM0102_Search.do" target="_self">返回</a></div>
				</logic:equal>
            </div>
            
		    <div id="formwrapper">
				<html:form styleId="form" action="/IGWIM0101" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
							<legend>工作项详细信息</legend>
					 <table  width="860px" style="margin-left:60px;margin-top:20px;">
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>发起人：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="initiatorId" tabindex="1" readonly="true" value="${IGWIM01011VO.workDefinitionInfo.initiatorId }"/>
				            		<!-- 主键wdid -->
					            	<html:hidden property="wdid" value="${IGWIM01011VO.workDefinitionInfo.wdid }"/>
				            	</td>
				            	<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
			            		<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>工作项名称：</strong></td>
				            	<td align="left" width="254px">
				            		<html:text property="wdname" tabindex="1" readonly="true" value="${IGWIM01011VO.workDefinitionInfo.wdname }"/>
				            	</td>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>工作项描述：</strong></td>
				            	<td align="left" width="254px" colspan="6"> 
				            	<html:textarea property="description" readonly="true" rows="3" style="width:635px" cols="88" tabindex="3" value="${IGWIM01011VO.workDefinitionInfo.description }"/></td>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>周期：</strong></td>
				            	<td colspan="5">
									<label for="everyDay" class="clearLabel">
										<input name="cycle" type="radio" id="everyDay" value="day" disabled="disabled"/>每日
				            		</label>
				            		<label for="everyWeek" class="clearLabel">
								        <input name="cycle" type="radio" id="everyWeek" value="week" disabled="disabled"/>每周
				            		</label>
				            		<label for="everyMonth" class="clearLabel">
								        <input name="cycle" type="radio" id="everyMonth" value="month" disabled="disabled"/>每月
				            		</label>
				            		<label for="everyQuarter" class="clearLabel">
								        <input name="cycle" type="radio" id="everyQuarter" value="quarter" disabled="disabled"/>每季度
				            		</label>
				            		<label for="everyHalfyear" class="clearLabel">
								        <input name="cycle" type="radio" id="everyHalfyear" value="halfyear" disabled="disabled"/>每半年
				            		</label>
				            		<label for="everyYear" class="clearLabel">
								        <input name="cycle" type="radio" id="everyYear" value="year" disabled="disabled"/>每年
				            		</label>
						    		    	<!-- 隐藏选项 -->
    								<div id="page" style="display:none;height:auto;">
						    		<!-- 每周 -->
						   			<div id="week" style="display:none ">
							    		<logic:present name="IGWIM01011VO" property="weekList">
											<logic:iterate id="bean" name="IGWIM01011VO" property="weekList" indexId="index">
												<c:if test="${bean.ischecked != null }">
													<input type="checkbox" weekCk="1" style="border-color: red;" name="wdweek" id="wdweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked"/>
												</c:if>
												<c:if test="${bean.ischecked == null }">
													<input type="checkbox" weekCk="1" name="wdweek" id="wdweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }"/>
												</c:if>
											</logic:iterate>
										</logic:present>
									</div>
									<!-- 每月 -->
									<div id="month" style="display:none; height:auto;">
									<logic:present name="IGWIM01011VO" property="monthList">
										<logic:iterate id="bean" name="IGWIM01011VO" property="monthList" indexId="index">
											<c:if test="${bean.ischecked != null }">
												<input type="checkbox" monthCk="1" name="wdmonth" id="wdmonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" checked="checked" />
											</c:if>
											<c:if test="${bean.ischecked == null }">
												<input type="checkbox" monthCk="1" name="wdmonth" id="wdmonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" />
											</c:if>
										</logic:iterate>
									</logic:present>
									</div>
								</div>
								<!-- 月末是否发起检查 -->
								<div id="month1" style="display:none; height:42px;">
									<span style="display:block; float:left;height:42px;vertical-align: middle;">
										请确认每月最后一天是否发起检查：
									</span>
									<span style="display:block; float:left; height:42px; width:42px;">
										<c:if test="${IGWIM0101Form.monthLastDay != null }">
											<input type="checkbox" name="monthLastDay" monthCk="2" id="monthLastDay" data-on="是" data-off="否" value="Y" checked="checked"/>
										</c:if>
										<c:if test="${IGWIM0101Form.monthLastDay == null }">
											<input type="checkbox" name="monthLastDay" monthCk="2" id="monthLastDay" data-on="是" data-off="否" value="Y"/>
										</c:if>
									</span>	
								</div>
				            	</td>
			            	</tr>
			            	<tr id="time">
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>时间：</strong></td>
				            	<td align="left" width="254px"> 
									<select id="wdhour" name="wdhour" disabled="disabled">
										<logic:iterate id="bean" name="IGWIM01011VO" property="hourList" indexId="index">
											<option value="${bean.hourvalue }">${bean.hourvalue }</option>
										</logic:iterate>
									</select>
									时
									<select id="wdminute" name="wdminute" disabled="disabled">
										<logic:iterate id="bean" name="IGWIM01011VO" property="minutesList" indexId="index">
												<option value="${bean.minutesvalue }">${bean.minutesvalue }</option>
										</logic:iterate>
									</select>
									分
									<input type="hidden" id="hour" value="${IGWIM01011VO.workDefinitionInfo.wdhour }"/>
									<input type="hidden" id="minutes" value="${IGWIM01011VO.workDefinitionInfo.wdminute }"/>
				            	</td>
				            	<td align="right" width="16px"></td>
				            </tr>	 
				            <tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>启用状态：</strong></td>
				            	<td align="left" width="254px"> 
									<c:if test="${IGWIM01011VO.workDefinitionInfo.wdstatus=='1' }">已启用</c:if>
									<c:if test="${IGWIM01011VO.workDefinitionInfo.wdstatus=='0' }">已停用</c:if>
									<input type="hidden" id="status" value="${IGWIM01011VO.workDefinitionInfo.wdstatus }"/>
								</td>
								<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span>
				            		<strong>实际完成时间：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
									<html:text property="estimateFinishDate" value="${IGWIM01011VO.workDefinitionInfo.actualFinishDate }" styleId="estimateFinishDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>开始日期：</strong></td>
				            	<td align="left" width="254px"> 
								<html:text property="beginDate" value="${IGWIM01011VO.workDefinitionInfo.beginDate }" styleId="beginDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
								<td align="right" width="16px"/>
								<td align="right" width="160px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span>
				            		<strong>预计完成时间：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
									<html:text property="estimateFinishDate" value="${IGWIM01011VO.workDefinitionInfo.estimateFinishDate }" styleId="estimateFinishDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
								</td>
				            	
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span><strong>负责人：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
				            		<!--对于中心负责人及以上的岗位，发起人为自己，负责人、执行人可以从现有用户列表中选择，且可以选择多个执行人-->
				            		<c:if test="${IGWIM0101Form.isLeader=='1' }">
							   			<html:text property="leaderName" tabindex="15"  readonly="true" value="${IGWIM01011VO.workDefinitionInfo.leaderName }"></html:text>
										<input type="hidden" width="0px" name="leaderId" id="leaderId" value="${IGWIM01011VO.workDefinitionInfo.leaderId }"/>
				            		</c:if>
				            		<!-- 对于普通员工，发起人、负责人、执行人只能是自己。 -->
				            		<c:if test="${IGWIM0101Form.isLeader=='0' }">
										<input type="hidden" width="0px" name="leaderId" id="leaderId" value="${IGWIM01011VO.workDefinitionInfo.leaderId }"/>
							   			<html:text property="leaderName" styleId="leaderName" readonly="true" tabindex="15" value="${IGWIM01011VO.workDefinitionInfo.leaderName }"></html:text>
				            		</c:if>
						   		</td>
								<td align="right" width="16px"/>
								<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>超时停止处理时间：</strong></td>
				            	<td align="left" width="254px"> 
				            	<html:text property="overtimeStopDealTime" styleId="overtimeStopDealTime" readonly="true" value="${IGWIM01011VO.workDefinitionInfo.overtimeStopDealTime }"/>日
								</td>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span><strong>执行人：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
				            		<!--对于中心负责人及以上的岗位，发起人为自己，负责人、执行人可以从现有用户列表中选择，且可以选择多个执行人-->
				            		<c:if test="${IGWIM0101Form.isLeader=='1' }">
										<span id="zxrArea">
					            		</span>
					            		<br/>
										<html:hidden property="excutorName" styleId="excutorName" value="${IGWIM01011VO.workDefinitionInfo.excutorName }"></html:hidden>
										<html:hidden property="excutorId" styleId="excutorId" value="${IGWIM01011VO.workDefinitionInfo.excutorId }"></html:hidden>
				            		</c:if>
				            		<!-- 对于普通员工，发起人、负责人、执行人只能是自己。 -->
				            		<c:if test="${IGWIM0101Form.isLeader=='0' }">
										<html:hidden property="excutorId"  styleId="excutorId" value="${IGWIM01011VO.workDefinitionInfo.excutorId }"></html:hidden>
										<html:text property="excutorName" readonly="true" styleId="excutorName" value="${IGWIM01011VO.workDefinitionInfo.excutorName }"></html:text>
				            		</c:if>
								</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>超时提醒时间：</strong></td>
				            	<td align="left" width="254px"> 
				            	<html:text property="overtimeTipsTime" tabindex="1" readonly="true" value="${IGWIM01011VO.workDefinitionInfo.overtimeTipsTime }"/>日
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>备注：</strong></td>
				            	<td align="left" width="254px" colspan="6"> 
				            		<html:textarea property="remarks" readonly="true" style="width:635px" rows="3" cols="88" tabindex="13" value="${IGWIM01011VO.workDefinitionInfo.remarks }"/>
								</td>
			            	</tr>
			            </table>
				
				<html:hidden property="mode" styleId="mode" />
				<input type="hidden" id="cycyleHide" value="${IGWIM01011VO.workDefinitionInfo.cycle }"/>
				<input type="hidden" id="weekHide" value="${IGWIM01011VO.workDefinitionInfo.wdweek }"/>
				<input type="hidden" id="monthHide" value="${IGWIM01011VO.workDefinitionInfo.wdmonth }"/>
				<input type="hidden" id="lastMonthHide" value="${IGWIM01011VO.workDefinitionInfo.monthLastDay }"/>
				
				</fieldset>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying">
    </div>
</div>
</div>
</body>
</html:html>