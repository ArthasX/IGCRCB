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
<bean:define id="id" value="IGRIS0202" toScope="request" />
<bean:define id="title" value="检查策略设定画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
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
window.onload=function(){
	
		<%-- for(var i=0; i<document.getElementById("selectjs").options.length;i++){
			if(document.getElementById("selectjs").options[i].value==<%=rcrtestmode %>){
				document.getElementById("selectjs").options[i].selected=true;
			}
		} --%>
	
	document.getElementById("onlyone").style.display = "none";
	document.getElementById("selectjs").onchange=function(){
		if(document.getElementById("selectjs").value==3){
			document.getElementById("onlyone").style.display = "";
		}else{
			document.getElementById("onlyone").style.display = "none";
		}
	}

	if(<%=rcrtestmode %>==3){
		document.getElementById("onlyone").style.display = "";
	}
}
var gid='IGRIS0202';
	WebCalendar.timeShow   = true;          //是否返回时间
	function confirmDisp(){
		var message = '';
		if ('${IGRIS0202Form.mode}' == '0'){
			message = '请确认是否要进行检查策略登记处理？';
		} else {
			message = '请确认是否要进行检查策略修改处理？';
		}
// 		if(document.forms[0].rccategoryname.value.trim()==""){
// 			alert("请选择检查项类别！");
// 			return false;
// 		}

// 		if(document.forms[0].rccategoryname.value.trim()==""){
// 			alert("请选择检查项类别！");
// 			return false;
// 		}

		/* if(document.forms[0].rcclass.value==""){
			alert("请选择检查项类型!");
			return false;
		} */
		if(document.forms[0].rcname.value.trim()==""){
			alert("请输入检查策略名称！");
			return false;
		} 
		if(document.forms[0].rcname.value.strlen()>128){
			alert("检查项名称不能大于40个汉字！");
			return false;
		} 
		if(document.forms[0].rccommon.value.trim() == ""){
			alert("请输入检查策略描述！");
			return false;
		}
		if(document.forms[0].rccommon.value.strlen()>1500){
			alert("检查策略描述不能大于500个汉字！");
			return false;
		}
		if(document.forms[0].eiids.value.trim()==""){
			alert("请选择检查工作！");
			return false;
		}
		if(document.forms[0].rcstartdate.value.trim()==""){
			alert("请选择开始时间！");
			return false;
		}

		if(!checkDateByContent("<%=IGStringUtils.getCurrentDate() %>",document.forms[0].rcstartdate.value)){
			alert("开始时间不能早于当前时间，请选择‘<%=IGStringUtils.getCurrentDate() %>’之后的时间作为开始时间！");
			return false;
		}
		
		if(document.forms[0].rcenddate.value.trim()==""){
			alert("请选择结束时间！");
			return false;
		}
		if(document.forms[0].rcenddate.value < document.forms[0].rcstartdate.value){
			alert("开始时间不能晚于结束时间！");
			return false;
		}
		/* if(document.getElementById("selectjs").value==""){
			alert("请选择检查方式!");
			return false;
		} */
		//频率
		var count=document.forms[0].rcfrequency.length;
		for(var i=0;i<count;i++) 
		{
			if(document.forms[0].rcfrequency[i].checked){
				var radio = document.forms[0].rcfrequency[i].value; 
			}
		}
		//频率周
		if(radio=="week"){
			var count=document.forms[0].rcfrequencyweek.length; 
			var j=0; 
			for(var i=0;i<count;i++) 
			{ 
			if (document.forms[0].rcfrequencyweek[i].checked) 
			++j; 
			} 
			if(j==0){
				alert("请选择每周频率内容！"); 
				return false;
			}
		}
		//频率月
		if(radio=="month"){
			var count=document.forms[0].rcfrequencymonth.length;
			var j=0; 
			var x=0;
			for(var i=0;i<count;i++) 
			{ 
			if (document.forms[0].rcfrequencymonth[i].checked) 
			++j; 
			}
			if (document.forms[0].rcfrequencymonthlastday.checked){ 
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
		if(document.forms[0].rctype.value.trim()==""){
			alert("请选择重要程度！");
			return false;
		}
		if(document.forms[0].rcrolename.value.trim()==""){
			alert("请选择责任组！");
			return false;
		}
		//if($("rcassetname").value.trim()==""){
		//	alert("请选择相关资产！");
		//	return false;
		//}
		/* if(document.forms[0].rcdesc.value.strlen()>256){
			alert("说明不能多于80个汉字！");
			return false;
		} */
		
		if(document.forms[0].rcusername.value.trim()==""){
			alert("请输入责任人！");
			return false;
		}
		//校验工作执行期限
		//checkWtip();
		
		if( window.confirm(message)){
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

	
	function selectUser(){
		var roleid = document.forms[0].rcroleid.value;
		if(roleid==null || roleid=="" || roleid=="0"){
			alert("请您先选择责任组，再选择责任人！");
		}else{
			openSubWindow('/IGSYM0405.do?flag=user&&roleida='+roleid , 'newpage', '800', '600');
		}
	}
	function selectUser1(){
		var  ciiopid= document.forms[0].cogid.value;
		if(ciiopid==null || ciiopid=="" || ciiopid=="0"){
			alert("请您先选择合作执行组，再选择合作执行人！");
		}else{
			openSubWindow('/IGSYM0405.do?flag=cog&&roleida='+ciiopid , 'newpage', '800', '600');
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
				 document.getElementById("month1").style.display='';
			}else{
				 document.getElementById("month1").style.display='none';
			}
		}else{
			document.getElementById("page").style.display='none';
			document.getElementById("month1").style.display='none';
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
		var quency = jQuery("input[name='rcfrequency']:checked").val();
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
	
	function setParams(eiids,eiversions,einame,eidesc,rcommon,riskitem,eistatus){ 
		
		$("tr").remove(".insertClass");
		
		var einames = einame;
		var eidescs = eidesc;
		var rcommons = rcommon;
		var riskitems = riskitem;
		var eistatus = eistatus;
		
		var one = 0;
		var two = 0;
		var three = 0;
		var four = 0;
		var free = 0;
		var six = 0;
		var serven = 0;
		
		for(var i=0,j=0;i<riskitems.length;i++){
			if('机房' == riskitems[i]){
				one ++;
			}else if('网络' == riskitems[i]){
				two ++;
			}else if('系统' == riskitems[i]){
				three ++;
			}else if('桌面安全' == riskitems[i]){
				four ++;
			}else if('访问控制' == riskitems[i]){
				free ++;
			}else if('开发' == riskitems[i]){
				six ++;
			}else if('其他' == riskitems[i]){
				serven ++;
			}
		}
		var insertText = "";
		if(one>0){
			var flag = 0;
			for(var i=0;i<riskitem.length;i++){
				if('机房' == riskitems[i]){
					if(flag==0){
						flag=1;
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+one+'">机房</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a  onclick="deleteTr('+eiids[i]+');"  style="cursor: hand">删除</a></td></tr>';
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';						
					}
				}
			}
		}
		if(two>0){
			var flag = 0;
			for(var i=0;i<riskitem.length;i++){
				if('网络' == riskitems[i]){
					if(flag==0){
						flag=1;
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+two+'">网络</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');"  style="cursor: hand">删除</a></td></tr>';
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');"  style="cursor: hand">删除</a></td></tr>';					
					}
				}
			}
		}
		if(three>0){
			var flag = 0;
			for(var i=0;i<riskitem.length;i++){
				if('系统' == riskitems[i]){
					if(flag==0){
						flag = 1;
						insertText = insertText +  '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+three+'">系统</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';						
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';					
					}
				}
			}
		}
		if(four>0){
			var flag = 0;
			for(var i=0;i<riskitem.length;i++){
				if('桌面安全' == riskitems[i]){				
					if(flag == 0){
						flag = 1;
						insertText = insertText +  '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+four+'">桌面安全</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';						
					}
				}
			}
		}
		if(free>0){
			var flag = 0;
			for(var i=0;i<riskitem.length;i++){
				if('访问控制' == riskitems[i]){
					if(flag==0){
						flag = 1;
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+free+'">访问控制</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';						
					}
				}
			}
		}
		if(six>0){
			var flag=0;
			for(var i=0;i<riskitem.length;i++){
				if('开发' == riskitems[i]){
					if(flag==0){
						flag = 1;
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+six+'">开发</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';										
					}
				}
			}
		}
		if(serven>0){
			var flag=0;
			for(var i=0;i<riskitem.length;i++){
				if('其他' == riskitems[i]){
					if(flag==0){
						flag = 1;
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td rowspan="'+serven+'">其他</td><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';
					}else{
						insertText = insertText + '<tr class="insertClass" id="'+eiids[i]+'"><td>'+ einame[i]+'</td><td>'+ eidescs[i] +'</td><td>'+rcommon[i]+'</td><td>'+eistatus[i]+'</td><td><a onclick="deleteTr('+eiids[i]+');" style="cursor: hand">删除</a></td></tr>';										
					}
				}
			}
		}
		//alert(insertText);
		$("#firstTr").after(insertText);
		/* var trElement = document.getElementById("firstTr"); */
		
	}
	
	function setParams2(eiids,eiversions,einame,eidesc,rcommon,riskitem,eistatus){
		 var eiid = document.getElementById("eiids").value.split(",");
		 var eiversion = document.getElementById("eiversions").value.split(",");
		 var einames = document.getElementById("einames").value.split(",");
		 
		 var eidescList = document.getElementById("eidescs").value.split(",");
		 var rcommonList = document.getElementById("rcommons").value.split(",");
		 var riskitemList = document.getElementById("riskitems").value.split(",");
		 var eistatusList = document.getElementById("eistatus").value.split(",");
		 if(eiid != null && eiid.length>0 && eiid != ''){
			 for(var i=0;i<eiids.length;i++){
				 eiid[eiid.length] = eiids[i];
				 eiversion[eiversion.length] = eiversions[i];
				 einames[einames.length] = einame[i];
				 eidescList[eidescList.length] = eidesc[i];
				 rcommonList[rcommonList.length] = rcommon[i];
				 riskitemList[riskitemList.length] = riskitem[i];
				 eistatusList[eistatusList.length] = eistatus[i];
			 }			 
		 }else{
			 for(var i=0;i<eiids.length;i++){
				 eiid[i] = eiids[i];
				 eiversion[i] = eiversions[i];
				 einames[i] = einame[i];
				 eidescList[i] = eidesc[i];
				 rcommonList[i] = rcommon[i];
				 riskitemList[i] = riskitem[i];
				 eistatusList[i] = eistatus[i];
			 }
		 }
		 fuzhi(eiid,eiversion,einames,eidescList,rcommonList,riskitemList,eistatusList);
		 setParams(eiid,eiversion,einames,eidescList,rcommonList,riskitemList,eistatusList);
	}
	
	
	function setParams1(eiids,eiversions,einames,eidescs,rcommons,riskitems,eistatus){
		
		 var eidescList = document.getElementById("eidescs").value.split(",");
		 var rcommonList = document.getElementById("rcommons").value.split(",");
		 var riskitemList = document.getElementById("riskitems").value.split(",");
		 var eistatusList = document.getElementById("eistatus").value.split(",");
		
		 var eiid = document.getElementById("eiids").value.split(",");
		 var eiversion = document.getElementById("eiversions").value.split(",");
		 var einame = document.getElementById("einames").value.split(",");
		 
		 if(eiid == ""){
			 document.getElementById("eiids").value = eiids; 
		 }else{
			 document.getElementById("eiids").value = eiid + "," + eiids;  
			 eiid[eiid.length] = eiids;
		 }
		 if(eiversion == ""){
			 document.getElementById("eiversions").value = eiversions;
		 }else{
			 
			 document.getElementById("eiversions").value = eiversion + "," + eiversions;
			 eiversion[eiversion.length] = eiversions;
		 }
		 if(einame == ""){
			 document.getElementById("einames").value = einames;
		 }else{
			 //document.getElementById("einames").value = einame + "," + einames;
			 einame[einame.length] = einames;
		 }
		 if(eidescList == ""){
			 document.getElementById("eidescs").value = eidescList ;
		 }else{
			// document.getElementById("eidescs").value = eidescList + "," + eidescs;
			 eidescList[eidescList.length] = eidescs;
		 }
		 if(rcommonList == ""){
			 document.getElementById("rcommons").value = rcommonList;
		 }else{
			// document.getElementById("rcommons").value = rcommonList + "," + rcommons;
			 rcommonList[rcommonList.length] = rcommons;
		 }
		 if(riskitemList == ""){
			 document.getElementById("riskitems").value = riskitemList;
		 }else{
			// document.getElementById("riskitems").value = riskitemList + "," + riskitems;
			 riskitemList[riskitemList.length] = riskitems;
		 }
		 if(eistatusList == ""){
			 document.getElementById("eistatus").value = eistatusList;
		 }else{
			// document.getElementById("eistatus").value = eistatusList + "," + eistatus;
			 eistatusList[eistatusList.length] = eistatus;
		 }
		 
		 var eidescList1 = document.getElementById("eidescs").value;
		 var rcommonList1 = document.getElementById("rcommons").value;
		 var riskitemList1 = document.getElementById("riskitems").value;
		 var eistatusList1 = document.getElementById("eistatus").value;
		 var eiid1 = document.getElementById("eiids").value;
		 var eiversion1 = document.getElementById("eiversions").value;
		 var einame1 = document.getElementById("einames").value;
		 fuzhi(eiid,eiversion,einame,eidescList,rcommonList,riskitemList,eistatusList);
		 setParams(eiid,eiversion,einame,eidescList,rcommonList,riskitemList,eistatusList);
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
	 	var rcommonList = document.getElementById("rcommons").value.split(",");
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
<logic:equal name="IGRIS0202Form" property="mode" value="1">
	<div class="back"><a href="IGRIS0201_Back.do" target="_self">返回</a></div>
</logic:equal>
</div>
<div id="formwrapper">
	<html:form styleId="form" action="/IGRIS0202" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
		<logic:equal name="IGRIS0202Form" property="mode" value="0">
			<legend>新增检查策略信息</legend>
		</logic:equal> 
		<logic:equal name="IGRIS0202Form" property="mode" value="1">
			<legend>修改检查策略信息</legend>
		</logic:equal>
		<%-- <div><label for="Name"><strong><span class="red">*</span>检查项类型</strong>：</label>
			<html:select property="rcclass" styleId="rcclass">
	            <ig:optionsCollection ccid="RISKCHECK_CLASS_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	        </html:select> 
		<br />
		</div> --%>
		<%-- <div><label for="Name"><strong><span class="red">*</span>检查项类别</strong>：</label>
		<html:text property="rccategoryname" size="18" styleId="rccategoryname" errorStyleClass="inputError imeActive" readonly="true"/>
		<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
		<html:hidden property="rccategory"/>
		<br /> --%>
		<!-- </div> -->
		<%
			
		
		%>
		<div><label for="Name"><strong><span class="red">*</span>检查策略名称</strong>：</label>
		<html:text property="rcname" size="18" styleId="rcname" errorStyleClass="inputError imeActive" style="width:365px;" />
		<br />
		</div>
		
		<div><label for="Name"><strong><span class="red">*</span>检查策略描述</strong>：</label>
		<html:textarea property="rccommon" cols="50" rows="8" styleId="rccommon" />
		<br />
		</div>

		<div><label for="Name"><strong><span class="red">*</span>检查工作列表</strong>：</label>
		<html:hidden property="einames" styleId="einames"/>
		<html:hidden property="eiids" styleId="eiids" />
		<html:hidden property="eiversions" styleId="eiversions"/>
			<a onclick="optionEntity();" style="cursor: hand" >
				<font color="red">
					选择
				</font>
			</a>
			<a onclick="addEntity();" style="cursor: hand" >
				<font color="red">
					增加
				</font>
			</a>
			<a onclick="zhankai('riskcheckTable','key1');" style="cursor: hand" ><font id="key1" color="red">展开</font></a>
		<br /></div>
			
			<br/>
			<div id="riskcheckTable" style="display: none;">
			<select id="closeAndOpen" onchange="selectClose()" style="margin-left: 140px">
				<option value=""></option>
				<option value="启用">启用</option>
				<option value="停用">停用</option>
			</select>
			<table class="table_form"  style="margin-left: 140px">
			<tr id="firstTr">
				<th width="70px">检查项类型</td>
				<th width="100px">检查项名称</td>
				<th width="200px">检查项说明</td>
				<th width="200px">检查方法</td>
				<th width="30px">状态</td>
				<th width="30px">删除</td>
			</tr>
			
			</table>
			</div>
			
			
		<div><label for="Name"><strong><span class="red">*</span>策略开始时间</strong>：</label> 
		<html:text property="rcstartdate" styleId="rcstartdate"
			errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].rcstartdate)"
			border="0" style="cursor: hand" /> <br />
		</div>
		
		<div><label for="Name"><strong><span class="red">*</span>策略结束时间</strong>：</label> 
		<html:text property="rcenddate" styleId="rcenddate"
			errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].rcenddate)"
			border="0" style="cursor: hand" /> <br />
		</div>
	<%-- 	<div><label for="Name"><strong><span class="red">*</span>工作执行期限(小时)</strong>：</label> 
		<html:text property="wtip" styleId="wtip"
			errorStyleClass="inputError imeDisabled" size="18" onblur="checkWtip();"/>
		<br />
		</div> --%>
		<div>
		<label for="Name"><strong><span class="red">*</span>检查方式</strong>：</label> 
		<html:select property="rcrtestmode" styleId="selectjs">
				<html:option value=""></html:option>
				<html:option value="1" >内部常规</html:option>
				<html:option value="2" >等级保护</html:option>
				<html:option value="3" >专项</html:option>
		</html:select> 
		<%-- <select name="rcrtestmode" id="selectjs">
				<option></option>
				<option value="1" <c:if test="${rcrtestmode =='1' }">selected </c:if>>内部常规</option>
				<option value="2" <c:if test="${rcrtestmode =='2' }">selected </c:if>>等级保护</option>
				<option value="3" <c:if test="${rcrtestmode =='3' }">selected </c:if>>专项</option>
		</select> --%>
		
	<%-- 	<html:select property="rcrtestmode" styleId="selectjs" value="2">
            <ig:optionsCollection ccid="RISKCHECK_CLASS_TYPE" isMakeBlankRow="true" isCodeLabel="true" />
        </html:select> --%> 
        <br />
		</div>
		
		<div>
          <label for="Name"><strong><span class="red">*</span>频率</strong>：</label>
          <span  id="onlyone"><input name="rcfrequency" type="radio" value="once" onclick="toQuency(this.value)" <%=onceChecked %>  />立即发起 </span>
           <input name="rcfrequency" type="radio" value="day" onclick="toQuency(this.value)" <%=dayChecked %>/>每日
           <input name="rcfrequency" type="radio" value="week" onclick="toQuency(this.value)" <%=weekChecked %>/>每周
           <input name="rcfrequency" type="radio" value="month" onclick="toQuency(this.value)" <%=monthChecked %>/>每月
           <input name="rcfrequency" type="radio" value="quarter" onclick="toQuency(this.value)" <%=quarterChecked %>/>每季度
            <input name="rcfrequency" type="radio" value="halfyear" onclick="toQuency(this.value)" <%=halfyearChecked %>/>每半年
            <input name="rcfrequency" type="radio" value="year" onclick="toQuency(this.value)" <%=yearChecked %>/>每年
    	</div>
    	<div id="page" style="display:none;height:auto; ">
    		<div id="week" style="display:none ">
    		<logic:present name="IGRIS02021VO" property="monthList">
				<logic:iterate id="bean" name="IGRIS02021VO" property="weekList" indexId="index">
					<c:if test="${bean.ischecked != null }"><input type="checkbox" style="border-color: red;" name="rcfrequencyweek" id="rcfrequencyweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked"/></c:if>
					<c:if test="${bean.ischecked == null }"><input type="checkbox" name="rcfrequencyweek" id="rcfrequencyweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }"/></c:if>
				</logic:iterate>
			</logic:present>
			</div>
			<div id="month" style="display:none; width:704px;height:auto;">
			<logic:present name="IGRIS02021VO" property="monthList">
				<logic:iterate id="bean" name="IGRIS02021VO" property="monthList" indexId="index">
					<c:if test="${bean.ischecked != null }">
						<input type="checkbox" name="rcfrequencymonth" id="rcfrequencymonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" checked="checked" />
					</c:if>
					<c:if test="${bean.ischecked == null }">
						<input type="checkbox" name="rcfrequencymonth" id="rcfrequencymonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" />
					</c:if>
				</logic:iterate>
			</logic:present>
			</div>
		</div>
		<div id="month1" style="display:none; height:42px;">
		<span style="display:block; float:left; height:42px; line-height:42px; padding-left:60px;">请确认每月最后一天是否发起检查：</span>
		<span style="display:block; float:left; height:42px; width:42px;">
		<c:if test="${IGRIS0202Form.rcfrequencymonthlastday != null }">
		<input  type="checkbox" name="rcfrequencymonthlastday" id="rcfrequencymonthlastday" data-on="是" data-off="否" value="1" checked="checked"/>
		</c:if>
		<c:if test="${IGRIS0202Form.rcfrequencymonthlastday == null }">
		<input type="checkbox" name="rcfrequencymonthlastday" id="rcfrequencymonthlastday" data-on="是" data-off="否" value="1"/>
		</c:if></span>	
		</div>
	<logic:equal name="IGRIS0202Form"  property="mode" value="0">
		
	</logic:equal>
	<logic:notEqual name="IGRIS0202Form"  property="mode" value="0">
		<html:hidden property="rcid" styleId="rcid" />
		<html:hidden property="rcattch" styleId="rcattch" />
		<html:hidden property="rcoption" styleId="rcoption" />
		<html:hidden property="rcstatus" styleId="rcstatus" />
		<html:hidden property="rccreatetime" styleId="rccreatetime" />
	</logic:notEqual>
	
	<div>
	<label for="Name"><strong><span class="red">*</span>重要程度</strong>：</label> 
		<html:select property="rctype" styleId="rctype">
            <ig:optionsCollection ccid="RISKCHECK_TYPE_CODE" isMakeBlankRow="true" isCodeLabel="true" />
        </html:select> 
        <br />
	</div>

	<div><label for="Name"><strong><span class="red">*</span>责任组</strong>：</label> 
	<html:text property="rcrolename" size="18" errorStyleClass="inputError imeActive" readonly="true"/> 
	<html:hidden property="rcroleid" styleId="rcroleid" />
	<a href="javascript:void(0)" onclick="selectRole();">
	<img src="images/seek.gif" alt="查询" width="16" height="16" border="0" />
	</a>

	<br />
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>责任人</strong>：</label> 
	<html:text property="rcusername" size="18" errorStyleClass="inputError imeActive" readonly="true"/> 
	<html:hidden property="rcuserid" styleId="rcuserid" />
	<a href="javascript:void(0)" onclick="selectUser();">
	<img src="images/seek.gif" alt="查询" width="16" height="16" border="0" />
	</a>
	<br />
	</div>
 	<div><label for="Name"><strong><span class="red"></span>合作执行组</strong>：</label> 
	<html:text property="cog" size="18" errorStyleClass="inputError imeActive" readonly="true"/> 
	<html:hidden property="cogid" styleId="cogid" />
	<a href="javascript:void(0)" onclick="selectRoleCi();">
	<img src="images/seek.gif" alt="查询" width="16" height="16" border="0" />
	</a>

	<br />
	</div>
	
	<div><label for="Name"><strong>合作执行人</strong>：</label> 
	<html:text property="ciiop" size="18" errorStyleClass="inputError imeActive" readonly="true"/> 
	<html:hidden property="ciiopid" styleId="ciiopid" />
	<a href="javascript:void(0)" onclick="selectUser1();">
	<img src="images/seek.gif" alt="查询" width="16" height="16" border="0" />
	</a>
	<br />
	</div>
	<%-- <div><label for="Name"><strong><span class="red"></span>工作执行期限</strong>：</label>
		<html:text property="wtip" size="18"  readonly="true" styleId="wtip" errorStyleClass="inputError imeActive" onclick="SoftKeyboard(this);"
		/><span style="width:25px;height:25px;line-height:25px;margin-left:7px;position:relative; top:-3px;">天</span>
		<br />
		</div> --%>
	<%-- <div><label for="Name"><strong>相关资产</strong>：</label> 
	<html:text property="rcassetname" size="18" readonly="true" errorStyleClass="inputError imeActive" /> 
	<html:hidden property="rcasset" styleId="rcasset" />
	<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntity()" style="cursor: hand"/>
	<br />
	</div> --%>

	<%-- <div><label for="Name"><strong>检查方法说明</strong>：</label> <html:textarea
		property="rcdesc" cols="50" rows="5" 
		errorStyleClass="inputError imeActive" /> <br />
	</div> --%>
	
	<logic:equal name="IGRIS0202Form"  property="mode" value="1">
	<div><label for="Name"><strong>附件</strong>：</label>
	<p class="p2">
		<logic:present name="IGRIS02021VO" property="attachmentDataList">
		<logic:notEmpty name="IGRIS02021VO" property="attachmentDataList">
				<table id="tb2">
				<logic:iterate id="bean" name="IGRIS02021VO"
					property="attachmentDataList" indexId="index">
					<tr id="${bean.attid}">
					<!-- 附件 -->
						<td>
						<logic:empty name="bean" property="attname"></logic:empty>
						<a href="<%=contextPath %>/downloadFinFile.do?attId=${bean.attid}&type=risk">
						<bean:define id="attname" name="bean" property="attname" />
						<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
						</a>
						&nbsp;
						<img alt="删除" align="middle" onClick="delFile('${bean.attid}')" border="0" style="cursor: hand" src="images/delate.gif">
						</td>
					</tr>
				</logic:iterate>
				</table>
		</logic:notEmpty>
				</logic:present>
	</p>
	</div>
	</logic:equal>
	
	<logic:equal name="IGRIS0202Form"  property="mode" value="0">
		<div style="padding-left: 50px"><img src="images/attachment.gif" />
		<a href="javascript:addFile();" id="aAddAttach">添加附件</a>
		<table id="tb">
		</table>
		</div>
	</logic:equal>
	
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="csid" styleId="csid" />
	<html:hidden property="mode" styleId="mode" />
	<input type="hidden" id="eidescs" value="">
	<input type="hidden" id="rcommons" value="">
	<input type="hidden" id="riskitems" value="">
	<input type="hidden" id="eistatus" value="">
	
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>