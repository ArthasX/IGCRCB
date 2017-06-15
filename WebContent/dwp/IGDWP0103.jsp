<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDWP0103" toScope="request" />
<bean:define id="title"	value="任务登记" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#pmode").change(function(){
		if(this.value == '0'){
			jQuery("#smscontentcontainer").show();
// 			jQuery("#worktypecontainer").hide();
		}else if(this.value == '1'){ 
			jQuery("#smscontentcontainer").hide();
// 			jQuery("#worktypecontainer").show();
		}else{
			jQuery("#smscontentcontainer").hide();
// 			jQuery("#worktypecontainer").hide();
		}
	});
	jQuery("[name='ptype']").click(function(){
		if(this.value == '0'){
			jQuery("#enddatecontainer").hide();
		}else{
			jQuery("#enddatecontainer").show();
		}
	});
	jQuery("#selectWorkType").click(function(){
		var temp = window.showModalDialog("IGDWP0104_Disp.do",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall" == temp){
			jQuery("#pdid").val("");
			jQuery("#pdname").val("");
		}else if(temp != null && temp != ""){
			var pdid = temp.split("_sp_")[0];
			var pdname = temp.split("_sp_")[1];
			jQuery("#pdid").val(pdid);
			jQuery("#pdname").val(pdname);
		}
	});
	var planid = jQuery("#planid").val();
	if(planid > 0){
		jQuery("#pname").parent().hide();
		jQuery("#pdesc").parent().hide();
		jQuery("#pmode").parent().hide();
		jQuery("[name='ptype']:first").parent().hide();
		jQuery("#enddatecontainer").show();
		jQuery("#location").find(".back").append("<a href='IGDWP0101_Back.do'>返回</a>");
	}else{
		jQuery("#location").find(".back").remove();
	}
	
});

//查找到是那一个被选择了
function findSelected(obj){
	for(var i = 0;i<obj.length;i++){
		if(obj[i].checked){
			return 	obj[i];			
		}			
	}
}
//显示星期几,每月几号，每三个月几日
jQuery(function(){
	var selectArr = jQuery("input[name = 'ptype']");
	var selectedObj = findSelected(selectArr);
	if(selectedObj.value == "2"){
		//显示星期几
	 	var week = new Date(jQuery("#startdate").val()).getDay();
	 	if(week == "1"){
	 		week = "一";
	 	}else if(week == "2"){
	 		week = "二";
	 	}else if(week == "3"){
	 		week = "三";
	 	}else if(week == "4"){
	 		week = "四";
	 	}else if(week == "5"){
	 		week = "五";
	 	}else if(week == "6"){
	 		week = "六";
	 	}else if(week == "0"){
	 		week = "日";
	 	}
	 	jQuery("#weekP").html(jQuery("#startdate").val()+"  每周星期"+week);
	}else if(selectedObj.value == "3"){
		//每月几号
		var day = new Date(jQuery("#startdate").val()).getDate();
		jQuery("#weekP").html(jQuery("#startdate").val()+"  每月"+day+"日");
	}else if(selectedObj.value == "4"){
		//每三个月几号
		var day = new Date(jQuery("#startdate").val()).getDate();
		jQuery("#weekP").html(jQuery("#startdate").val()+"  每三个月"+day+"日");
	}
	

});
function confirmDisp(){
// 	alert(jQuery("#pname").val().length);
// 	return false;
	if($F("pname").trim() == ""){
		alert("请输入任务名称！");
		return false;
	}
	if(jQuery("#pname").val().length > 40){
		alert("任务名称不能大于" + Math.floor(120/strByteFlag) + "个汉字！");
		return false;
	}
	if($F("pdesc").trim() == ""){
		alert("请输入任务描述！");
		return false;
	}
	if(jQuery("#pdesc").val().length > 150){
		alert("任务描述不能大于" + Math.floor(450/strByteFlag) + "个汉字！");
		return false;
	}
	if($F("startdate").trim() == ""){
		alert("开始日期为空，请检查路径是否合法！");
		return false;
	}
// 	if($F("pmode").trim() == ""){
// 		alert("请选择调度方式！");
// 		return false;
// 	}
	if('0' == $F("pmode")){
		if($F("smscontent").trim() == ""){
			alert("请输入短信内容！");
			return false;
		}
		if($F("smscontent").strlen() > 512){
			alert("短信内容不能大于" + Math.floor(512/strByteFlag) + "个汉字！");
			return false;
		}
	}
	if($F("phour") == "" || $F("pminute") == ""){
		alert("请选择完整执行时间！")
		return false;
	}
	if($F("enddate") == ""){
		alert("请选择结束日期！");
		return false;
	}
	
	if(window.confirm("是否确认提交？")){
		return true;
	}else{
		return false;
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
	<div class="back"></div>
</div>
<html:form action="/IGDWP0103.do" onsubmit="return checkSubmit(this);">
	<fieldset>
		<legend>任务信息</legend>
		<div>
			<label for="Name"><strong><span class="red">*</span>任务名称</strong>：</label>
			<html:text property="pname" styleId="pname" style="width:440px;"/>
			<br>
		</div>
		<div>
			<label for="Name"><strong><span class="red">*</span>任务描述</strong>：</label>
			<html:text property="pdesc" styleId="pdesc" style="width:440px;"/>
			<br>
		</div>
		<div>
			<label for="Name"><strong>开始日期</strong>：</label>
			<p class="p2" id="weekP">${IGDWP0103Form.startdate }</p>
			<html:hidden property="startdate" styleId="startdate"/>
			<br>
		</div>
<!-- 		<div> -->
<!-- 			<label for="Name"><strong><span class="red">*</span>调度方式</strong>：</label> -->
<%-- 			<html:select property="pmode" styleId="pmode"> --%>
<%-- 				<html:option value=""></html:option> --%>
<%-- 				<html:option value="0">短信提醒</html:option> --%>
<%-- 				<html:option value="1">工作发起</html:option> --%>
<%-- 			</html:select> --%>
<!-- 			<br> -->
<!-- 		</div> -->
		<div id="smscontentcontainer" style="display:none;">
			<label for="Name"><strong><span class="red">*</span>短信内容</strong>：</label>
			<html:textarea property="smscontent" styleId="smscontent" rows="8" cols="60">
			</html:textarea>
			<br>
		</div>
		<div id="worktypecontainer" style="display:none;">
			<label for="Name"><strong><span class="red">*</span>工作类型</strong>：</label>
			<html:text property="pdname" styleId="pdname" readonly="true"/>
<!-- 			<img alt="查询" src="images/tree.gif" style="cursor: hand;" id="selectWorkType"> -->
			<html:hidden property="pdid" styleId="pdid"/>
			<br>
		</div>
		<div>
			<label for="Name"><strong><span class="red">*</span>执行时间</strong>：</label>
			<html:select property="phour" styleId="phour">
				<html:option value=""></html:option>
				<%
					for(int i=0;i<24;i++){
						String key = i > 9 ? i + "" : "0" + i;
						%>
						<html:option value="<%=key %>"><%=key %></html:option>
						<%
					}
				%>
			</html:select>
			时&nbsp;
			<html:select property="pminute" styleId="pminute">
				<html:option value=""></html:option>
				<%
					for(int i=0;i<60;i++){
						String key = i > 9 ? i + "" : "0" + i;
						%>
						<html:option value="<%=key %>"><%=key %></html:option>
						<%
					}
				%>
			</html:select>
			分
			<br>
		</div>
		<div>
			<label for="Name"><strong><span class="red">*</span>周期类型</strong>：</label>
<!-- 			<span> -->
<%-- 			<html:radio property="ptype" value="0">仅一次</html:radio> --%>
<!-- 			</span> -->
			<span>
			<html:radio property="ptype" value="1">日</html:radio>
			</span>
			<span>
			<html:radio property="ptype" value="2">周</html:radio>
			</span>
			<span>
			<html:radio property="ptype" value="3">月</html:radio>
			</span>
			<span>
			<html:radio property="ptype" value="4">季度</html:radio>
			</span>
			<br>
		</div>
		<div id="enddatecontainer">
			<label for="Name"><strong><span class="red">*</span>结束时间</strong>：</label>
			<html:text property="enddate" styleId="enddate" readonly="true"/>
			<img alt="" src="images/date.gif" onclick="showDate($('enddate'));" style="cursor: hand;" border="0">
			<br>
		</div>
	</fieldset>
	<div class="enter">
		<html:hidden property="id" styleId="planid"/>
		<html:hidden property="pmode" styleId="pmode" value="1"/>
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>