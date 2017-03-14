<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sta.vo.IGSTA0102VO"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<html:html>
<bean:define id="id" value="IGSTA0102" toScope="request" />
<bean:define id="title" value="问题整改监督查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function showIncident(){
		var ccid = "266";
		var cid = "";
		var syscode = "";
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}

		url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			$("pcode").value="";
			$("rccategoryname").value="";
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
			$("pcode").value=treecid;
			$("rccategoryname").value=name;
			
		}		
		
	}
	//查看
	function searchQuestionStatus(){
		var sqstatus = $("questionstatus").value;
		var pdid = "0102001";
		if("" == sqstatus){
			document.getElementById("statusTxt").style.display='none';
			statusTxt.innerHTML= "<SELECT name=\"prstatus\" id=\"prstatus\" style=\"width: 80px;\"><option></option></SELECT>";
	    }else{
		    if("1" == sqstatus){
		    	document.getElementById("statusTxt").style.display='';
			}else{
				document.getElementById("statusTxt").style.display='none';
			}
	    	var prstatusValue = '<bean:write name="prstatusValue" />';
	    	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'type=searchquestionstatus&pdid='+pdid+'&prstatusValue='+prstatusValue,
				 onSuccess:  function(req, json){
	    		var result=req.responseText;
			 	statusTxt.innerHTML= result;
	    		}
			});
		}
		
	}

//-->
	</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="searchQuestionStatus();">
<div id="maincontent"><!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content">
	<html:form action="/IGSTA0102" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top:8px;">
	<span class="subscribe">问题名称：</span>
	<html:text property="prtitle" errorStyleClass="inputError imeActive"/>
	<span class="subscribe">问题状态：</span>
	<html:select name="IGSTA0102Form" property="questionstatus" errorStyleClass="inputError" onchange="searchQuestionStatus(this.value)">
		<html:option value=""></html:option>
		<html:option value="1">未关闭</html:option>
		<html:option value="2">已关闭</html:option>
	</html:select>
	<span id="statusTxt" style="display: none;">
		<SELECT name="prstatus" id="prstatus" style="width: 80px;">
			<option></option>
		</SELECT>
	</span>
	<span class="subscribe">时间：</span>
	<html:text property="propentime_from" readonly="true" errorStyleClass="inputError imeActive" style="width:116px;"/>
   	<img src="images/date.gif" align="middle" onClick="calendar($('propentime_from'))" border="0"/>                  
    <span>&nbsp;--&nbsp;</span>
    <html:text property="propentime_to" readonly="true" errorStyleClass="inputError imeActive" style="width:116px;"/>
    <img src="images/date.gif" align="middle" onClick="calendar($('propentime_to'))" border="0"/> 
	<html:submit styleClass="button" value="查询" /><br>
	<span class="subscribe">检查项类型：</span>
	<html:select name="IGSTA0102Form" property="rcclass" errorStyleClass="inputError">
		<html:option value=""></html:option>
		<html:option value="机房">机房</html:option>
		<html:option value="系统">系统</html:option>
		<html:option value="网络">网络</html:option>
		<html:option value="桌面安全">桌面安全</html:option>
		<html:option value="访问控制">访问控制</html:option>
		<html:option value="开发">开发</html:option>
	</html:select>
	<span class="subscribe">检查来源：</span>
	<html:select name="IGSTA0102Form" property="rcsourse" errorStyleClass="inputError">
		<html:option value=""></html:option>
		<html:option value="科技部">科技部</html:option>
		<html:option value="审计部">审计部</html:option>
		<html:option value="人民银行">人民银行</html:option>
		<html:option value="银监局">银监局</html:option>
		<html:option value="其他监管机构">其他监管机构</html:option>
	</html:select>
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<!-- <th width="17%">检查项类别</th> -->
			<th width="17%">问题来源</th>
			<th width="18%">问题名称</th>
			<th width="17%">问题描述</th>
			<th width="7%">发起者</th>
			<th width="11%">登记时间</th>
			<th width="13%">状态</th>
		</tr>
		<logic:present name="IGSTA0102VO" property="riskCheckProblemSuperviseVWList">
			<logic:iterate id="bean" name="IGSTA0102VO" property="riskCheckProblemSuperviseVWList"
				indexId="index"
				type="com.deliverik.infogovernor.sta.model.entity.RiskCheckProblemSuperviseVW"
				>			
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=130');">
					<%-- <td><%=bean.getRiskprype().split("_")[2] %></td> --%>
					<td>
						<ig:publicProcessInfoValue pidname="检查来源" prid="${bean.prid }"/>
					</td>
					<td><bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prdesc" /></td>
					<td><bean:write name="bean" property="prusername" /></td>					
					<td><bean:write name="bean" property="propentime" /></td>
<%-- 					<td><bean:write name="bean" property="prplantime" /></td> --%>
<%-- 					<td><bean:write name="bean" property="prduration" /></td> --%>
					<td>
					<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
