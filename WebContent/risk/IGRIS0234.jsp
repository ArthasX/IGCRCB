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
<bean:define id="id" value="IGRIS0234" toScope="request" />
<bean:define id="title" value="检查策略查看画面" toScope="request" />
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

		if(!"?".equals(day) && " ".equals(day)){
			dayChecked = "checked=\"checked\"";
		}else if("?".equals(day)){
			weekChecked = "checked=\"checked\"";
		}else {
			if("".equals(quarterChecked)){
				//每半年，每年频率 根据 IGRIS02BLImpl 136 行
				String month =  cron.split(" ")[4];
				if(month.contains(" "))
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
	
		var fre = '${IGRIS0202Form.rcfrequency}';
		if(fre != 'once'){
			document.getElementById("onlyone").style.display = "none";
			document.getElementById("selectjs").onchange=function(){
				if(document.getElementById("selectjs").value==3){
					document.getElementById("onlyone").style.display = "";
				}else{
					document.getElementById("onlyone").style.display = "none";
				}
			}		
		}else{
			document.getElementById("onlyone").childNodes[0].checked = true ;
		}
	if(<%=rcrtestmode %>==3){
		document.getElementById("onlyone").style.display = "";
	}
}
var gid='IGRIS0202';
	WebCalendar.timeShow   = true;          //是否返回时间

	function checkWtip(){
		var value=document.forms[0].wtip.value;
		var reg = new RegExp("^[0-9] $");
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
		
		var csid = '${IGRIS0202Form.csid}';
		openSubWindow('/IGRIS0201_POINT.do?csid=' + csid +'', '_blank','1000','600','center:1');	
	}
	
	
	function setParams(eiids,eiversions,einame){
		document.getElementById("eiids").value = eiids; 
		document.getElementById("eiversions").value = eiversions;
		document.getElementById("einames").value = einame;
	}
	function setParams1(eiids,eiversions,einames){
		 
		 eiid = document.getElementById("eiids").value;
		 eiversion = document.getElementById("eiversions").value;
		 einame = document.getElementById("einames").value;
		 if(eiid == ""){
			 document.getElementById("eiids").value = eiids; 
		 }else{
			 document.getElementById("eiids").value = eiid + "," + eiids; 
		 }
		 if(eiversion == ""){
			 document.getElementById("eiversions").value = eiversions;
		 }else{
			 document.getElementById("eiversions").value = eiversion + "," + eiversions;
		 }
		 if(einame == ""){
			 document.getElementById("einames").value = einames;
		 }else{
			 document.getElementById("einames").value = einame + "," + einames;
		 }
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
<p class="fonts1">信息安全   &gt;&gt; 检查策略管理  &gt;&gt; 检查策略查看</p>
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
		<%-- <div><label for="Name"><strong><span class="red"> </span>检查项类型</strong>：</label>
			<html:select property="rcclass" styleId="rcclass">
	            <ig:optionsCollection ccid="RISKCHECK_CLASS_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	        </html:select> 
		<br />
		</div> --%>
		<%-- <div><label for="Name"><strong><span class="red"> </span>检查项类别</strong>：</label>
		<html:text property="rccategoryname" size="18" styleId="rccategoryname" errorStyleClass="inputError imeActive" readonly="true"/>
		<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
		<html:hidden property="rccategory"/>
		<br /> --%>
		<!-- </div> -->
	
		<div><label for="Name"><strong><span class="red"> </span>检查策略名称</strong>：</label>
		<html:text property="rcname" size="18" styleId="rcname" errorStyleClass="inputError imeActive" style="width:365px;"  disabled="true"/>
		<br />
		</div>
		
		<div><label for="Name"><strong><span class="red"> </span>检查策略描述</strong>：</label>
		<html:textarea property="rccommon" cols="50" rows="8" styleId="rccommon"   disabled="true"/>
		<br />
		</div>

		<%-- <div><label for="Name"><strong><span class="red"> </span>检查工作列表</strong>：</label>
		<html:text property="einames" size="18" styleId="einames" errorStyleClass="inputError imeActive" style="width:150px;" disabled="true"/>
		<html:hidden property="eiids" styleId="eiids" />
		<html:hidden property="eiversions" styleId="eiversions"/>
		 
		<br/>
		</div> --%>
		<div >
			
			<label for="Name"><strong><span class="red"> </span>检查工作列表</strong>：</label>
			<a onclick="zhankai('riskcheckTable','key1');" style="cursor: hand" ><font id="key1" color="red">展开</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="optionEntity();" style="cursor: hand" >
				<font color="red">
					查看
				</font>
			</a>
			<br/>
			<div id="riskcheckTable" style="margin-left: 140px;display: none;">
			<table class="table_form">
			<tr>
				<th width="70px">检查项类型</td>
				<th width="100px">检查项名称</td>
				<th width="200px">检查方法</td>
				<th width="200px">检查项说明</td>
				<th width="30px">状态</td>
			</tr> 
					<%-- <logic:present name="IGRIS02021VO" property="riskCheckList">
						<logic:iterate id="bean" name="IGRIS02021VO"
							property="riskCheckList" indexId="index">
							<tr>
								<td></td>
								<td><ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${bean.rcclass}"/></td>
								<td><bean:write name="bean" property="rcname"/></td> 
								<td title="${bean.rcdesc}">
									<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
										${bean.rcdesc}
									</ig:SubstringShowEllipsisWriteTag>
								</td>
								<td title="${bean.rccommon}">
									<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
										${bean.rccommon}
									</ig:SubstringShowEllipsisWriteTag>
								</td>
							</tr>
						</logic:iterate>
					</logic:present> --%>
			
				

				<logic:present name="IGRIS02021VO" property="riskCheckmap">
				<logic:iterate id="map" name="IGRIS02021VO" property="riskCheckmap" indexId="index">
					<logic:present name="map" property="value">
						<bean:size id="valueSize" name="map" property="value"/>
						<logic:iterate id="bean" name="map" property="value" indexId="idx">
							
							<tr class="riskcheckTable">
								<logic:equal value="0" name="idx">
									<%-- <td rowspan="${valueSize }">${index + 1}</td> --%>
									<td rowspan="${valueSize }">
										<ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${map.key }"/>
									</td>
								</logic:equal>
								<td><bean:write name="bean" property="rcname"/></td> 
								<td title="${bean.rcdesc}">
										<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
											${bean.rcdesc}
										</ig:SubstringShowEllipsisWriteTag>
								</td>
								<td title="${bean.rccommon}">
										<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
											${bean.rccommon}
										</ig:SubstringShowEllipsisWriteTag>
								</td>
								<td>
									<c:if test="${bean.rcstatus == '1'}">
										 启用
									</c:if>	
									<c:if test="${bean.rcstatus != '1'}">
										  停用
									</c:if>	
								</td>
								<%-- <td>${bean.rcrattch}</td> --%>
							</tr>
						</logic:iterate>
					</logic:present>
				</logic:iterate>
			</logic:present>
			</table>
			</div>
		</div>
		<div><label for="Name"><strong><span class="red"> </span>策略开始时间</strong>：</label> 
		<html:text property="rcstartdate" styleId="rcstartdate"
			errorStyleClass="inputError imeDisabled" size="18" disabled="true"/>
		</div>
		
		<div><label for="Name"><strong><span class="red"> </span>策略结束时间</strong>：</label> 
		<html:text property="rcenddate" styleId="rcenddate"
			errorStyleClass="inputError imeDisabled" size="18" disabled="true"/>
		</div>
	<%-- 	<div><label for="Name"><strong><span class="red"> </span>工作执行期限(小时)</strong>：</label> 
		<html:text property="wtip" styleId="wtip"
			errorStyleClass="inputError imeDisabled" size="18" onblur="checkWtip();"/>
		<br />
		</div> --%>
		<div>
		<label for="Name"><strong><span class="red"> </span>检查方式</strong>：</label> 
		<html:select property="rcrtestmode" styleId="selectjs" disabled="true">
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
          <label for="Name"><strong><span class="red"> </span>频率</strong>：</label>
          <span  id="onlyone"><input name="rcfrequency" type="radio" value="once" onclick="toQuency(this.value)" <%=onceChecked %>  disabled="disabled"/>立即发起 </span>
           <input name="rcfrequency" type="radio" value="day" onclick="toQuency(this.value)" <%=dayChecked %> disabled="disabled"/>每日
           <input name="rcfrequency" type="radio" value="week" onclick="toQuency(this.value)" <%=weekChecked %> disabled="disabled"/>每周
           <input name="rcfrequency" type="radio" value="month" onclick="toQuency(this.value)" <%=monthChecked %> disabled="disabled"/>每月
           <input name="rcfrequency" type="radio" value="quarter" onclick="toQuency(this.value)" <%=quarterChecked %> disabled="disabled"/>每季度
            <input name="rcfrequency" type="radio" value="halfyear" onclick="toQuency(this.value)" <%=halfyearChecked %> disabled="disabled"/>每半年
            <input name="rcfrequency" type="radio" value="year" onclick="toQuency(this.value)" <%=yearChecked %> disabled="disabled"/>每年
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
	<label for="Name"><strong><span class="red"> </span>重要程度</strong>：</label> 
		<html:select property="rctype" styleId="rctype" disabled="true">
            <ig:optionsCollection ccid="RISKCHECK_TYPE_CODE" isMakeBlankRow="true" isCodeLabel="true" />
        </html:select> 
        <br />
	</div>

	<div><label for="Name"><strong><span class="red"> </span>责任组</strong>：</label> 
	<html:text property="rcrolename" size="18" errorStyleClass="inputError imeActive" disabled="true"/> 
	<html:hidden property="rcroleid" styleId="rcroleid" />

	<br />
	</div>
	
	<div><label for="Name"><strong><span class="red"> </span>责任人</strong>：</label> 
	<html:text property="rcusername" size="18" errorStyleClass="inputError imeActive" disabled="true"/> 
	<html:hidden property="rcuserid" styleId="rcuserid" />

	<br />
	</div>
 	<div><label for="Name"><strong><span class="red"></span>合作执行组</strong>：</label> 
	<html:text property="cog" size="18" errorStyleClass="inputError imeActive" disabled="true"/> 
	<html:hidden property="cogid" styleId="cogid" />


	<br />
	</div>
	
	<div><label for="Name"><strong>合作执行人</strong>：</label> 
	<html:text property="ciiop" size="18" errorStyleClass="inputError imeActive" disabled="true"/> 
	<html:hidden property="ciiopid" styleId="ciiopid" />

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
	<html:hidden property="csid" styleId="csid" />
	
	<html:hidden property="mode" styleId="mode" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>