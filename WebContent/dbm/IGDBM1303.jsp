<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.dbm.model.WorkmanagerInfo"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGDBM13031" toScope="request" />
<bean:define id="title" value="工作修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<%
WorkmanagerInfo rc = (WorkmanagerInfo)request.getAttribute("workmanager");
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
// 	rcrtestmode=rc.getWmrtestmode();
	String cron = rc.getWmcron();
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
		if("".equals(quarterChecked)){
			//每半年，每年频率 根据 IGRIS02BLImpl 136 行
			String month =  cron.split(" ")[4];
			 if(rc.getWmfrequency().equals("halfyear")){
				halfyearChecked = "checked=\"checked\"";
			}else if(rc.getWmfrequency().equals("day")){
				dayChecked="checked=\"checked\"";
			}
			else if(rc.getWmfrequency().equals("once")){
				onceChecked="checked=\"checked\"";
			}else if(rc.getWmfrequency().equals("week")){
				weekChecked="checked=\"checked\"";
			}else if(rc.getWmfrequency().equals("month")){
				monthChecked="checked=\"checked\"";
			}else if(rc.getWmfrequency().equals("quarter")){
				quarterChecked="checked=\"checked\"";
			} else  {
				yearChecked = "checked=\"checked\"";
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
var gid='IGRIS0202';
	WebCalendar.timeShow   = true;          //是否返回时间
	function confirmDisp(){
		
		var message = '';
		message = '是否要进行工作信息修改处理？';		
		if(document.forms[0].wmname.value.trim()==""){
			alert("请输入工作名称！");
			return false;
		} 
		
		if(document.forms[0].wmname.value.strlen()>128){
			alert("工作名称不能大于40个汉字！");
			return false;
		} 
		if(document.forms[0].wmdesc.value.trim() == ""){
			alert("请输入描述！");
			return false;
		}
		if(document.forms[0].wmdesc.value.strlen()>1500){
			alert("描述不能大于500个汉字！");
			return false;
		}
		
		if(document.forms[0].wmstartdate.value.trim()==""){
			alert("请选择发起时间！");
			return false;
		}
		if(document.forms[0].wmlimitdate.value.trim()==""){
			alert("请选择限期完成时间！");
			return false;
		}
		
		if(document.forms[0].wmstartdate.value>=document.forms[0].wmlimitdate.value){
			alert("限期完成时间需晚于发起时间，请选择发起时间之后的时间！");
			return false;
		}
		//频率
		var count=document.forms[0].wmfrequency.length;
		for(var i=0;i<count;i++) 
		{
			if(document.forms[0].wmfrequency[i].checked){
				var radio = document.forms[0].wmfrequency[i].value; 
			}
		}
		//频率周
		if(radio=="week"){
			var count=document.forms[0].wmfrequencyweek.length; 
			var j=0; 
			for(var i=0;i<count;i++) 
			{ 
			if (document.forms[0].wmfrequencyweek[i].checked) 
			++j; 
			} 
			if(j==0){
				alert("请选择每周频率内容！"); 
				return false;
			}
		}
		//频率月
		if(radio=="month"){
			var count=document.forms[0].wmfrequencymonth.length;
			var j=0; 
			var x=0;
			for(var i=0;i<count;i++) 
			{ 
			if (document.forms[0].wmfrequencymonth[i].checked) 
			++j; 
			}
			if (document.forms[0].wmfrequencymonthlastday.checked){ 
			++x; 
			}
			if(j==0 && x==0){
				alert("请选择每月频率内容！"); 
				return false;
			}
			if(j!=0 && x!=0){
				alert("不能同时选择月份天数及每月最后一天，请重新选择！");
				return false;
			}
		}
		if(document.forms[0].wmremark.value.strlen()>1500){
			alert("备注不能大于500个汉字！");
			return false;
		}		
		if(window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}

	function checkWtip(){
		var value=document.forms[0].wtip.value;
		var reg = new RegExp("^[0-9]*$");
	    if(!reg.test(value)){
	    	document.forms[0].wtip.focus();
	    	alert("工作执行期限请输入正确数字！");
	        return false;
	    }
	}
	
	function selectEntity(){
		openSubIGCOM0302();
	}
	function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
		document.forms[0].rcasset.value = eiid;
	    //$("rcasset").value = eiid;
		//$("prassetname").value = eilabel;
		document.forms[0].rcassetname.value = einame;
		//$("rcassetname").value = einame;
		//$("prassetcategory").value = ecategory;
	}
	
	function selectRole(){
		openSubWindow('/IGSYM0305R_Disp.do?flag=role', '_blank', '800', '600');
	}
	function selectRoleCi(){
		openSubWindow('/IGSYM0305R_Disp.do?flag=ciiop', '_blank', '800', '600');
	}
	function setParamRole(roleid,rolename,ciiop){
		if(ciiop=="ciiop"){
			
			document.forms[0].cogid.value = roleid;
			document.forms[0].cog.value = rolename;
	
			document.forms[0].ciiopid.value = "";
			document.forms[0].ciiop.value = "";
		}else{
		
			document.forms[0].rcroleid.value = roleid;
			document.forms[0].rcrolename.value = rolename;
	
			document.forms[0].rcuserid.value = "";
			document.forms[0].rcusername.value = "";
		}
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname,cog){
		if(cog=="cog"){
			document.forms[0].ciiopid.value = userid;
			document.forms[0].ciiop.value = username;
		}else{
			document.forms[0].rcuserid.value = userid;
			document.forms[0].rcusername.value = username;
		}
	}

	function showIncident(){
		var ccid = "106";
		var cid = "";
		var syscode = "";
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}
		url = "IGSYM1505_TREE.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].rccategory.value = "";
			document.forms[0].rccategoryname.value = "";
				return false;
			}
		if(null!=temp && temp.split("|").length>1){
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
			var treeccid;
			var treecid;
			var treesyscode;
			
			if(id.split("_").length>1){
				treeccid = id.split("_")[0];
				treecid = id.split("_")[1];
				treesyscode = id.split("_")[2];
			}else{
				treeccid = id.split("_")[0];
				treecid = "";
				treesyscode = "";
			}
			//$("rcassetname").value = einame;
			document.forms[0].rccategory.value = treesyscode;
			document.forms[0].rccategoryname.value = name;
		}		
		
	}
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
// 				 document.getElementById("month1").style.display='';
			}else{
// 				 document.getElementById("month1").style.display='none';
			}
		}else{
			document.getElementById("page").style.display='none';
// 			document.getElementById("month1").style.display='none';
		}
	}
	function delFile(attid){
		 if( window.confirm("是否删除附件？")){
			document.getElementById(attid).style.display = "none";
			var delkey=document.getElementById("predelkey");
			if(delkey.value != ""){
				delkey.value = delkey.value + ','+attid;
			}else{
				delkey.value = attid;
			}
		 }
	}
	
	jQuery(document).ready(function(){
		var quency = jQuery("input[name='wmfrequency']:checked").val();
		toQuency(quency);
	});
	
	function addEntity(){
		window.showModalDialog(getAppRootUrl() + "/IGRIS0602_INSERT_Disp.do",
				window,"dialogWidth:1000px;dialogHeight:500px;status:no;help:no;resizable:no");
	}
	function optionEntity(){
		eiids = document.getElementById("eiids").value; 
		if(eiids == "" || eiids == null){
			eiids="0";
		}
		eiversions = document.getElementById("eiversions").value;
		if(eiversions == "" || eiversions == null){
			eiversions="0";
		}		
		openSubWindow('/IGRIS0601_OPTION.do?eiids='+eiids+'&eiversions='+eiversions+'', '_blank','1000','600','center:1');		
	}
	Array.prototype.unique1 = function()
	{
		var n = []; //一个新的临时数组
		for(var i = 0; i < this.length; i++) //遍历当前数组
		{
			//如果当前数组的第i已经保存进了临时数组，那么跳过，
			//否则把当前项push到临时数组里面
			if (n.indexOf(this[i]) == -1) n.push(this[i]);
		}
		return n;
	}
	
	function RiskCheck(einame,eidesc,rcommon,riskitem){
		
		this.einame = einame;
		this.eidesc = eidesc;
		this.rcommon = rcommon;
		this.riskitem = riskitem;
	}
	
	
	function deleteTr(eiid){
		var eiids = document.getElementById("eiids").value.split(",");
		var eiversions = document.getElementById("eiversions").value.split(",");
		var einames = document.getElementById("einames").value.split(",");
		 
		var eidescList = document.getElementById("eidescs").value.split(",");
		var rcommonList = document.getElementById("rcommons").value.split(",");
		var riskitemList = document.getElementById("riskitems").value.split(",");
		var eistatusList = document.getElementById("eistatus").value.split(",");
		for(var i =0;i<eiids.length;i++){
			if(eiid == eiids[i]){
				eiids.splice(i,1);
				eiversions.splice(i,1);
				einames.splice(i,1);
				eidescList.splice(i,1);
				rcommonList.splice(i,1);
				riskitemList.splice(i,1);
				eistatusList.splice(i,1);
			}
		}
		document.getElementById("eiids").value = eiids; 
		document.getElementById("eiversions").value = eiversions;
		
		document.getElementById("einames").value = einames;
		document.getElementById("eidescs").value = eidescList;
		document.getElementById("rcommons").value = rcommonList;
		document.getElementById("riskitems").value = riskitemList;
		document.getElementById("eistatus").value = eistatusList;
		fuzhi(eiids,eiversions,einames,eidescList,rcommonList,riskitemList,eistatusList);
		setParams(eiids,eiversions,einames,eidescList,rcommonList,riskitemList,eistatusList);
		//$("#"+eiid+"").remove();
	}
	function fuzhi(eiids,eiversions,einame,eidesc,rcommon,riskitem,eistatus){
		document.getElementById("eiids").value = eiids; 
		document.getElementById("eiversions").value = eiversions;
		document.getElementById("einames").value = einame;

		document.getElementById("eidescs").value = eidesc;
		document.getElementById("rcommons").value = rcommon;
		document.getElementById("riskitems").value = riskitem;
		document.getElementById("eistatus").value = eistatus;
	}
	function zhankai(id,key){
		 var show= document.getElementById(id).style.display;
		 if(show=='none')
		 {
		 	document.getElementById(id).style.display='block';
		 	document.getElementById(key).innerHTML="收起";
		 }
		 else{
		 	document.getElementById(id).style.display='none';
		    document.getElementById(key).innerHTML="展开";
		 	}
		 }
	
	function selectClose(){
		
		var status = $("#closeAndOpen").val();
		
		var eidescList = document.getElementById("eidescs").value.split(",");
	 	var rcommonList = document.getElementById("wmommons").value.split(",");
		var riskitemList = document.getElementById("riskitems").value.split(",");
	 	var eistatusList = document.getElementById("eistatus").value.split(",");
	
	 	var eiid = document.getElementById("eiids").value.split(",");
	 	var eiversion = document.getElementById("eiversions").value.split(",");
	 	var einame = document.getElementById("einames").value.split(",");
		
	 	var eidescList2 = new Array;
		var rcommonList2 = new Array;
		var riskitemList2 = new Array;
		var eistatusList2 = new Array;
		
		var eiid2 = new Array;
		var eiversion2 = new Array;
		var einame2 = new Array;
	 	
	 	var temp = 0;
	 	for(var i=0;i<eiid.length;i++){
	 		if(eistatusList[i] == status){
	 			eiid2[temp] = eiid[i];
	 			eiversion2[temp] = eiversion[i];
	 			einame2[temp] = einame[i];
	 			eidescList2[temp] = eidescList[i];
	 			rcommonList2[temp] = rcommonList[i];  
	 			riskitemList2[temp] = riskitemList[i];
	 			eistatusList2[temp] = eistatusList[i];
	 			temp++;
	 		}
	 	}
	 	if(temp == 0){
	 		if(status == '停用'){
	 	    	setParams(0,0,0,0,0,0,0);
	 	    }else{
		 		setParams(eiid,eiversion,einame,eidescList,rcommonList,riskitemList,eistatusList);
	 	    }
	 	}
	 	else{
		 	setParams(eiid2,eiversion2,einame2,eidescList2,rcommonList2,riskitemList2,eistatusList2); 		
	 	}
	}
//-->
</script>
<link rel="stylesheet" href="<html:rewrite forward='jquery.tzCheckbox.css'/>" type="text/css">
<body>
<script src="<html:rewrite forward='jquery.min.js'/>"></script>
<script>
var jQ = jQuery.noConflict(true);//jquery与prototype冲突
</script>
<script src="<html:rewrite forward='jquery.tzCheckbox.js'/>"></script>
<script src="<html:rewrite forward='jquery.script.js'/>"></script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	<div class="back"><a href="IGDBM1301_Search.do" target="_self">返回</a></div>
</div>
<div id="formwrapper">
	<html:form styleId="form" action="/IGDBM1302_Update" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
			<legend>新增工作信息</legend>
		<div><label for="Name"><strong><span class="red">*</span>工作名称</strong>：</label>
		<html:text property="wmname" size="18" styleId="wmname" errorStyleClass="inputError imeActive" style="width:365px;" />
		<br />
		</div>
		
		<div><label for="Name"><strong><span class="red">*</span>描述</strong>：</label>
		<html:textarea property="wmdesc" cols="50" rows="8" styleId="wmdesc" />
		<br />
		</div>

		<div><label for="Name"><strong><span class="red">*</span>发起人</strong>：</label>
			${IGDBM1302Form.wmusername }
		<br />
		</div>	
		<div><label for="Name"><strong><span class="red">*</span>发起时间</strong>：</label> 
<%-- 		${IGDBM1302Form.wmstartdate} --%>
		<html:text property="wmstartdate" styleId="wmstartdate"
			errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].wmstartdate)"
			border="0" style="cursor: hand" /> <br />
		</div>
		<div><label for="Name"><strong><span class="red">*</span>限期完成时间</strong>：</label> 
		<html:text property="wmlimitdate" styleId="wmlimitdate"
			errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].wmlimitdate)"
			border="0" style="cursor: hand" /> <br />
		</div>
		<div>
          <label for="Name"><strong><span class="red">*</span>工作周期</strong>：</label>
<%--           <span  id="onlyone"><input name="wmfrequency" type="radio" value="once" onclick="toQuency(this.value)" <%=onceChecked %>  />立即发起 </span> --%>
<%--            <input name="wmfrequency" type="radio" re value="day" onclick="toQuency(this.value)" <%=dayChecked %>/>每日 --%>
<%--            <input name="wmfrequency" type="radio" value="week" onclick="toQuency(this.value)" <%=weekChecked %>/>每周 --%>
<%--            <input name="wmfrequency" type="radio" value="month" onclick="toQuency(this.value)" <%=monthChecked %>/>每月 --%>
<%--            <input name="wmfrequency" type="radio" value="quarter" onclick="toQuency(this.value)" <%=quarterChecked %>/>每季度 --%>
<%--             <input name="wmfrequency" type="radio" value="halfyear" onclick="toQuency(this.value)" <%=halfyearChecked %>/>每半年 --%>
<%--             <input name="wmfrequency" type="radio" value="year" onclick="toQuency(this.value)" <%=yearChecked %>/>每年 --%>
			<input name="wmfrequency" type="radio" disabled="disabled" value="day" <%=dayChecked %>/>每日
           <input name="wmfrequency" type="radio" disabled="disabled" value="week" <%=weekChecked %>/>每周
           <input name="wmfrequency" type="radio" disabled="disabled" value="month" <%=monthChecked %>/>每月
           <input name="wmfrequency" type="radio" disabled="disabled" value="quarter" <%=quarterChecked %>/>每季度
            <input name="wmfrequency" type="radio" disabled="disabled" value="halfyear" <%=halfyearChecked %>/>每半年
            <input name="wmfrequency" type="radio" disabled="disabled" value="year" <%=yearChecked %>/>每年
    	</div>
    	<div id="page" style="display:none;height:auto; ">
    		<div id="week" style="display:none ">
    		<logic:present name="IGDBM13011VO" property="monthList">
				<logic:iterate id="bean" name="IGDBM13011VO" property="weekList" indexId="index">
<%-- 					<c:if test="${bean.ischecked != null }"><input type="checkbox" style="border-color: red;" name="wmfrequencyweek" id="wmfrequencyweeks" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked"/></c:if> --%>
<%-- 					<c:if test="${bean.ischecked == null }"><input type="checkbox" name="wmfrequencyweek" id="wmfrequencyweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }"/></c:if> --%>
					<c:if test="${bean.ischecked != null }"><input type="checkbox" style="border-color: red;" name="wmfrequencyweek" id="wmfrequencyweeks" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked" disabled="disabled"/></c:if>
					<c:if test="${bean.ischecked == null }"><input type="checkbox" disabled="disabled" name="wmfrequencyweek" id="wmfrequencyweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" disabled="disabled"/></c:if>
				
				</logic:iterate>
			</logic:present>
			</div>
			<div id="month" style="display:none; width:704px;height:auto;">
			<logic:present name="IGDBM13011VO" property="monthList">
				<logic:iterate id="bean" name="IGDBM13011VO" property="monthList" indexId="index">
					<c:if test="${bean.ischecked != null }">
						<input type="checkbox" name="wmfrequencymonth" id="wmfrequencymonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" checked="checked"  disabled="disabled"/>
					</c:if>
					<c:if test="${bean.ischecked == null }">
						<input type="checkbox" name="wmfrequencymonth" id="wmfrequencymonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }"  disabled="disabled"/>
					</c:if>
				</logic:iterate>
			</logic:present>
			</div>
		</div>
		<div id="month1" style="display:none; height:42px;">
		<span style="display:block; float:left; height:42px; line-height:42px; padding-left:60px;">请确认每月最后一天是否发起检查：</span>
		<span style="display:block; float:left; height:42px; width:42px;">
		<c:if test="${IGDBM1302Form.wmfrequencymonthlastday != null }">
		<input  type="checkbox" name="wmfrequencymonthlastday" id="wmfrequencymonthlastday" data-on="是" data-off="否" value="1" checked="checked"  disabled="disabled"/>
		</c:if>
		<c:if test="${IGDBM1302Form.wmfrequencymonthlastday == null }">
		<input type="checkbox" name="wmfrequencymonthlastday" id="wmfrequencymonthlastday" data-on="是" data-off="否" value="1" disabled="disabled"/>
		</c:if></span>	
		</div>
		<div><label for="Name"><strong>备注</strong>：</label>
			<html:textarea property="wmremark" cols="50" rows="8" styleId="wmremark" />
			<br />
		</div>
		<html:hidden property="wmid" styleId="wmid" />
		<html:hidden property="wmoption" styleId="wmoption" />
		<html:hidden property="wmstatus" styleId="wmstatus" />
		<html:hidden property="wmcron" styleId="wmcron" />
		<html:hidden property="wmuserid" styleId="wmuserid" />
		<html:hidden property="wmusername" styleId="wmusername" />
		<html:hidden property="wmremindh" styleId="wmremindh" />
		<html:hidden property="wmremindm" styleId="wmremindm" />
		<html:hidden property="wmremind" styleId="wmremind" />
		<html:hidden property="wmtype" styleId="wmtype"/>
		<html:hidden property="rewmid" styleId="rewmid"/>
		<html:hidden property="wmfrequencyweeks" styleId="wmfrequencyweeks" name="IGDBM1302Form"/>
		<html:hidden property="wmfrequencymonths" styleId="wmfrequencymonths" name="IGDBM1302Form"/>
		<html:hidden property="wmfrequencymonthlastday" styleId="wmfrequencymonthlastday" name="IGDBM1302Form"/>
		<html:hidden property="wmfrequency" styleId="wmfrequency" name="IGDBM1302Form"/>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" />
		<html:reset property="btn_clear" styleClass="button" value="重置" /></div>
	
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>