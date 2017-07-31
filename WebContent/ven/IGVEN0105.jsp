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
<bean:define id="id" value="IGVEN0105" toScope="request" />
<bean:define id="title" value="风险策略设定画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- <script src="/js/jquery-1.9.1.min.js" type="text/javascript"></script> -->
<!-- <script type="text/javascript"> -->
<!-- // 	var jq = jQuery.noConflict(true); -->
<!-- </script> -->
<%-- <script src="<html:rewrite forward='jquery.min.js'/>"></script> --%>
<!-- <script type="text/javascript"> -->
<!-- // var jquery15=jQuery.noConflict(true); -->
<!-- </script> -->
<script>
var jQ = jQuery.noConflict(true);//jquery与prototype冲突
</script>
<script src="<html:rewrite forward='jquery.tzCheckbox.js'/>"></script>

<link rel="stylesheet" href="<html:rewrite forward='jquery.tzCheckbox.css'/>" type="text/css">
<!-- /header1 -->

<script type="text/javascript">	
function loadfunction(){
	
		
		var eiids = '${IGVEN0102Form.eiids}'.split(",");
		var eiversions = '${IGVEN0102Form.eiversions}'.split(",");
		var einames = '${IGVEN0102Form.einames}'.split(",");
		var risklys = '${IGVEN0102Form.risklys}'.split(",");
		var riskareas = '${IGVEN0102Form.riskareas}'.split(",");
		var riskitems = '${IGVEN0102Form.riskitems}'.split(",");
		var eilabels = '${IGVEN0102Form.eilabels}'.split(",");
		fuzhi(eiids,eiversions,risklys,riskareas,riskitems,eilabels,einames);
		setParams(eiids,eiversions,risklys,riskareas,riskitems,eilabels,einames);
		
		var check = '${IGVEN01021VO.igVEN0102Form.rcfrequency}';
		//jQuery().attr("checked", "checked");
		jQuery("input[name='rcfrequency'][value*='"+ check +"']").attr("checked", "checked");
		jQuery("input[name='rcfrequency'][value!='"+ check +"']").attr("disabled", "disabled");
		jQuery("input[name='rcfrequency'][value*='"+ check +"']").click();
		//需要复选每日和每周和每月的时候,将下面的注释放开
		if(check == 'week'){
			var cronExpression = '${IGVEN01021VO.igVEN0102Form.rcfrequencydesc}'.split(",");
			for(var i=0;i<cronExpression.length;i++){
				jQuery("input[name='rcfrequencyweek'][value*='"+ cronExpression[i] +"']").attr("checked", "checked");
			}
		}else if(check == 'month'){
			var cronExpression = '${IGVEN01021VO.igVEN0102Form.rcfrequencydesc}'.split(",");
			for(var i=0;i<cronExpression.length;i++){
				if(cronExpression[0] == '最后一 '){
					jQuery("#rcfrequencymonthlastday").attr("checked", "checked");
					break;
				}
				jQuery("input[name='rcfrequencymonth'][value*='"+ cronExpression[i] +"']").attr("checked", "checked");
			}
		}
		counterTable();
	}
	
	//去除换行
	function clearBr(key){
		key = key.replace(/<\/?.+?>/g,"");
		key = key.replace(/[\r\n]/g,"");
		return key;
	}
	var gid='IGRIS0202';
	WebCalendar.timeShow   = true;          //是否返回时间

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
			   jQuery(divArray[i]).show();
			   jQuery(divArray[i]).children().show();
// 			   .style.display='';
			  }else {
				  jQuery(divArray[i]).hide();
				  jQuery(divArray[i]).children().hide();
// 			   divArray[i].style.display='none';
			  }
			 }
			 if(quency == 'month'){
				 jQuery(document.getElementById("month1")).show();
				 jQuery(document.getElementById("month1")).children().show();
				 jQuery(document.getElementById("rcfrequencymonthlastday")).show();
// 				 document.getElementById("month1").style.display='';
			}else{
				jQuery(document.getElementById("month1")).hide();
				jQuery(document.getElementById("month1")).children().hide();
				jQuery(document.getElementById("rcfrequencymonthlastday")).hide();
// 				 document.getElementById("month1").style.display='none';
			}
		}else{
			jQuery(document.getElementById("page")).hide();
			jQuery(document.getElementById("page")).children().hide();
			jQuery(document.getElementById("month1")).hide();
			jQuery(document.getElementById("month1")).children().hide();
// 			document.getElementById("page").style.display='none';
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
		var quency = jQuery("input[name='rcfrequency']:checked").val();
		toQuency(quency);
	});
	
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
	
	//保存属性
	function fuzhi(eiids,eiversions,risklys,riskareas,riskitems,eilabels,einames){
		document.getElementById("eiids").value = eiids; 
		document.getElementById("eiversions").value = eiversions;
		document.getElementById("risklys").value = risklys;

		document.getElementById("riskareas").value = riskareas;
		document.getElementById("riskitems").value = riskitems;
		document.getElementById("eilabels").value = eilabels;
		document.getElementById("einames").value = einames;
	}
	
	//构造表格
	function setParams(eiids,eiversions,risklys,riskareas,riskitems,eilabels,einames){ 
		
		jQuery("tr").remove(".insertClass");
		
		var tableForm = document.getElementById("table_form");
		for(var i=0,j=0;i<eiids.length;i++){
			if(eiids[i] == '' || typeof eiids[i] == 'undefined'){
				continue;
			}
			var x = tableForm.insertRow(tableForm.rows.length);
			x.className = 'insertClass';
			
			var y = x.insertCell(0);
			y.innerHTML=risklys[i];
			var y = x.insertCell(1);
			y.innerHTML=riskareas[i];
			var y = x.insertCell(2);
			y.innerHTML=riskitems[i];
			var y = x.insertCell(3);
			y.innerHTML=eilabels[i];
			var y = x.insertCell(4);
			y.innerHTML=einames[i];
		}
		jQuery("table#table_form tr").not("#firstTr").each(function(i,obj){
			obj = jQuery(obj);
			jQuery(obj).children("td").not("td:contains('删除')").each(function(i,obj1){
				obj1 = jQuery(obj1);
				obj1.addClass("content");
				obj1.attr("title",obj1.text());
				var len = obj1.text().length;
				if(len>10){
					obj1.text(obj1.text().substring(0,9)+'...');					
				}
			});
		});
		//jQuery("#firstTr").after(insertText);
		/* var trElement = document.getElementById("firstTr"); */
	}
	function counterTable(){
		var num = 0;
		jQuery("table[class='table_form'][id='table_form'] tr").not("#firstTr").each(function(i,obj){
			obj = jQuery(obj);
			num++;
		});
		jQuery("#spanNum").text("("+num+")");
		jQuery("#spanNum").addClass("par_0");
	}
	//传值
	function setParams2(eiids,eiversions,risklys,riskareas,riskitems,eilabels,einames){
		
		 var eiidList = document.getElementById("eiids").value.split(",");
		 var eiversionList = document.getElementById("eiversions").value.split(",");
		 var risklyList = document.getElementById("risklys").value.split(",");
		 
		 var riskareaList = document.getElementById("riskareas").value.split(",");
		 var riskitemList = document.getElementById("riskitems").value.split(",");
		 var eilabelList = document.getElementById("eilabels").value.split(",");
		 var einameList = document.getElementById("einames").value.split(",");
		 
		 if(eiidList != null && eiidList.length>0 && eiidList != ''){
			 for(var i=0;i<eiids.length;i++){
				 eiidList[eiidList.length] = eiids[i];
				 eiversionList[eiversionList.length] = eiversions[i];
				 risklyList[risklyList.length] = risklys[i];
				 riskareaList[riskareaList.length] = riskareas[i];
				 riskitemList[riskitemList.length] = riskitems[i];
				 eilabelList[einameList.length] = eilabels[i];
				 einameList[einameList.length] = einames[i];
			 }			 
		 }else{
			 for(var i=0;i<eiids.length;i++){
				 eiidList[i] = eiids[i];
				 eiversionList[i] = eiversions[i];
				 risklyList[i] = risklys[i];
				 riskareaList[i] = riskareas[i];
				 riskitemList[i] = riskitems[i];
				 eilabelList[i] = eilabels[i];
				 einameList[i] = einames[i];
			 }
		 }
		 fuzhi(eiidList,eiversionList,risklyList,riskareaList,riskitemList,eilabelList,einameList);
		 setParams(eiidList,eiversionList,risklyList,riskareaList,riskitemList,eilabelList,einameList);
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
	
	function deleteOrg(obj){
		var tr=obj.parentNode.parentNode;
		var tbody=tr.parentNode;
		tbody.removeChild(tr);
	}
//-->
</script>
<style>
.par_0{
	color:red;
}
.content {
width:120px;
height:14px;
white-space:nowrap;
overflow:hidden;
text-overflow:ellipsis;/*以省略号替代截除部分*/
}
</style>
<body onload="loadfunction();">
<%-- <script src="<html:rewrite forward='jquery.script.js'/>"></script> --%>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}" extname4="查看风险策略信息"/></p>
<logic:equal name="IGVEN0102Form" property="mode" value="1">
	<div class="back"><a href="IGVEN0101_Back.do" target="_self">返回</a></div>
</logic:equal>
</div>
<div id="formwrapper">
	<html:form styleId="form" action="/IGVEN0102" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
			<legend>查看风险策略信息</legend>
		<div><label for="Name"><strong><span class="red">*</span>风险策略名称</strong>：</label>
		<html:text property="rcname" size="18" styleId="rcname" errorStyleClass="inputError imeActive" style="width:365px;" disabled="true"/>
		<br />
		</div>
		
		<div><label for="Name"><strong>风险策略描述</strong>：</label>
		<html:textarea property="rccommon" cols="50" rows="8" styleId="rccommon" disabled="true"/>
		<br />
		</div>

		<div><label for="Name"><strong><span class="red">*</span>监测指标列表</strong>：</label>
		<html:hidden property="einames" styleId="einames"/>
		<html:hidden property="eiids" styleId="eiids" />
		<html:hidden property="eiversions" styleId="eiversions"/>
			<a onclick="zhankai('riskcheckTable','key1');" style="cursor: hand" ><font id="key1" color="red">展开</font></a><span id="spanNum"></span>
		<br /></div>
			
			<br/>
			<div id="riskcheckTable" style="display: none;">
			<table class="table_form"  id="table_form" style="margin-left: 140px">
			<tr id="firstTr">
				<th width="120px">风险领域</td>
				<th width="120px">风险子域</td>
				<th width="120px">风险项</td>
				<th width="120px">指标编号</td>
				<th width="120px">指标名称</td>
			</tr>
			
			</table>
			</div>
			
	<%-- 	<div><label for="Name"><strong><span class="red">*</span>工作执行期限(小时)</strong>：</label> 
		<html:text property="wtip" styleId="wtip"
			errorStyleClass="inputError imeDisabled" size="18" onblur="checkWtip();"/>
		<br />
		</div> --%>
		
		<div>
          <label for="Name"><strong><span class="red">*</span>频率</strong>：</label>
          <span  id="onlyone"><input name="rcfrequency" type="radio" value="once" onclick="toQuency(this.value)" />立即发起 </span>
           <input name="rcfrequency" type="radio" value="day" onclick="toQuency(this.value)" />每日
           <input name="rcfrequency" type="radio" value="week" onclick="toQuency(this.value)" />每周
           <input name="rcfrequency" type="radio" value="month" onclick="toQuency(this.value)" />每月 
           <input name="rcfrequency" type="radio" value="quarter" onclick="toQuency(this.value)"  checked="checked"/>每季度
            <input name="rcfrequency" type="radio" value="halfyear" onclick="toQuency(this.value)"/>每半年
            <input name="rcfrequency" type="radio" value="year" onclick="toQuency(this.value)" />每年
    	</div>
    	<div id="page" style="display:none;height:auto; ">
    		<div id="week" style="display:none ">
    		<logic:present name="IGVEN01021VO" property="monthList">
				<logic:iterate id="bean" name="IGVEN01021VO" property="weekList" indexId="index">
					<c:if test="${bean.ischecked != null }"><input type="checkbox" style="border-color: red;" name="rcfrequencyweek" id="rcfrequencyweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked" disabled="disabled"/>${bean.weekvalue }</c:if>
					<c:if test="${bean.ischecked == null }"><input type="checkbox" name="rcfrequencyweek" id="rcfrequencyweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" disabled="disabled"/>${bean.weekvalue }</c:if>
				</logic:iterate>
			</logic:present>
			</div>
			<div id="month" style="display:none; width:704px;height:auto;">
			<logic:present name="IGVEN01021VO" property="monthList">
				<logic:iterate id="bean" name="IGVEN01021VO" property="monthList" indexId="index">
					<c:if test="${bean.ischecked != null }">
						<input type="checkbox" name="rcfrequencymonth" id="rcfrequencymonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" checked="checked" disabled="disabled"/>${bean.dayvalue }
					</c:if>
					<c:if test="${bean.ischecked == null }">
						<input type="checkbox" name="rcfrequencymonth" id="rcfrequencymonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" disabled="disabled"/>${bean.dayvalue }
					</c:if>
				</logic:iterate>
			</logic:present>
			</div>
		</div>
		<div id="month1" style="display:none; height:20px;">
		<span style="display:block; float:left; height:20px; line-height:20px; padding-left:60px;">请确认每月最后一天是否发起风险：</span>
		<span style="display:block; float:left; height:20px; width:42px;">
		<c:if test="${IGVEN0102Form.rcfrequencymonthlastday != null }">
		<input  type="checkbox" name="rcfrequencymonthlastday" id="rcfrequencymonthlastday" disabled="disabled" data-on="是" data-off="否" value="1" checked="checked"/>
		</c:if>
		<c:if test="${IGVEN0102Form.rcfrequencymonthlastday == null }">
		<input type="checkbox" name="rcfrequencymonthlastday" id="rcfrequencymonthlastday" disabled="disabled" data-on="是" data-off="否" value="1" />
		</c:if></span>	
		</div>
		
		<div><label for="Name"><strong><span class="red">*</span>策略开始时间</strong>：</label> 
		<html:text property="rcstartdate" styleId="rcstartdate"
			errorStyleClass="inputError imeDisabled" size="18"  disabled="true"/>
		 <br />
		</div>
		
		<div><label for="Name"><strong><span class="red">*</span>策略结束时间</strong>：</label> 
		<html:text property="rcenddate" styleId="rcenddate"
			errorStyleClass="inputError imeDisabled" size="18" disabled="true"/>
		<br />
		</div>
	<logic:equal name="IGVEN0102Form"  property="mode" value="0">
		
	</logic:equal>
	<logic:notEqual name="IGVEN0102Form"  property="mode" value="0">
		<html:hidden property="rcattch" styleId="rcattch" />
		<html:hidden property="rcoption" styleId="rcoption" />
		<html:hidden property="rcstatus" styleId="rcstatus" />
		<html:hidden property="rccreatetime" styleId="rccreatetime" />
	</logic:notEqual>

	<logic:equal name="IGVEN0102Form"  property="mode" value="1">
	<div><label for="Name"><strong>附件</strong>：</label>
	<p class="p2">
		<logic:present name="IGVEN01021VO" property="attachmentDataList">
			<logic:notEmpty name="IGVEN01021VO" property="attachmentDataList">
				<table id="tb2">
				<logic:iterate id="bean" name="IGVEN01021VO"
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
						</td>
					</tr>
				</logic:iterate>
				</table>
			</logic:notEmpty>
		</logic:present>
	</p>
	</div>
	</logic:equal>
	
	<logic:equal name="IGVEN0102Form"  property="mode" value="0">
	</logic:equal>
	
	</fieldset>
	<html:hidden property="rsid" styleId="csid" />
	<html:hidden property="mode" styleId="mode" />
	<input type="hidden" id="risklys" value="">
	<input type="hidden" id="riskareas" value="">
	<input type="hidden" id="riskitems" value="">
	<input type="hidden" id="eilabels" value="">
	<input type="hidden" name="predelkey" id="predelkey" value="">

</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>