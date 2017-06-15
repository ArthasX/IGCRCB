<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverik.framework.user.model.Organization" %>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<html:html>
<bean:define id="id" value="IGSTA0202" toScope="request" />
<bean:define id="title" value="检查问题统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

if (document.getElementById){ //DynamicDrive.com change
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

function SwitchMenu(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
		if(el.style.display != "block"){ //DynamicDrive.com change
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu") //DynamicDrive.com change
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}
	}
}

function setOrg(url){
  	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgid.value = "";
		document.forms[0].orgName.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var orgsyscoding ="";
		orgsyscoding = temp.split("|")[0]+"%";
		document.forms[0].orgid.value = orgsyscoding;
		document.forms[0].orgName.value = temp.split("|")[1];
	}		

}



function checkForm(){

	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSTA0202.do";
		document.forms[0].submit();	
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
		document.forms[0].pcode.value = "";
		document.forms[0].pname.value = "";
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
		//document.forms[0].rccategory.value = treesyscode;
		document.forms[0].pcode.value = treecid;
		document.forms[0].pname.value = name ;
	}	
}

function searchButton(){
	var statistictype = $("statistictype").value;
	if(statistictype == "1"){
		document.getElementById("page1").style.display='';
		document.getElementById("page2").style.display='none';
		$("prassetname").value = "";
	}else if(statistictype == "2"){
		document.getElementById("page2").style.display='';
		document.getElementById("page1").style.display='none';
		$("pname").value = "";
		$("pcode").value = "";
	}
}

</script>

<body onload=" searchButton();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--sidebar  左菜单-->
<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">统计分析 &gt;&gt; 工作监督 &gt;&gt; 检查问题统计</p>
    </div>
     <div id="search">
     <html:form styleId="form" action="/IGSTA0202" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
         <div class="conditions">
         <div style="clear:right;">
          <div style="float:left;"><span>统计项选择：</span>
          <span>
          <html:select name="IGSVC1123Form" property="statistictype" onchange="searchButton()" style="width: 120px;" errorStyleClass="inputError">
			<html:option value="1">检查项类别</html:option>
			<html:option value="2">检查来源</html:option>
			</html:select></span>
		  </div>
				<span id="page1">&nbsp;&nbsp;检查项类别：
				<html:text name="IGSVC1123Form" property="pname" size="18" styleId="pname" errorStyleClass="inputError imeActive" readonly="true"/>
				<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
				<html:hidden name="IGSVC1123Form" property="pcode"/></span>
				<span id="page2">&nbsp;&nbsp;检查来源：
				<html:select name="IGSVC1123Form" property="prassetname"  errorStyleClass="inputError imeActive">
					<ig:optionsCollection ccid="IAPSOURCE"/>
				</html:select></span>
		</div>
        <div>
        <span>时间：从</span><span><html:text name="IGSVC1123Form" property="propentime_from" readonly="true" errorStyleClass="inputError imeActive"/></span>
   		<img src="images/date.gif" align="middle" onClick="calendar($('propentime_from'))" border="0"/>                  
        <span>&nbsp;&nbsp;到</span><span><html:text name="IGSVC1123Form" property="propentime_to" readonly="true" errorStyleClass="inputError imeActive"/></span>
         <img src="images/date.gif" align="middle" onClick="calendar($('propentime_to'))" border="0"/>                
		<span>
       <html:submit property="btn_search" styleClass="button" value="查询" onclick="checkForm()"/>
       </span> 
       </div>
      </div>
    </html:form>
    </div>
     <div id="results_list"><ig:message />
       <table  class="table_style" id="caseListTable">						
		<tr>
			<th width="30%">
			<c:if test="${IGSVC1123Form.statistictype != '2'}">检查项类别</c:if>
			<c:if test="${IGSVC1123Form.statistictype == '2'}">检查来源</c:if>
			</th>
			<th width="7%">等待制定</th>
			<th width="7%">等待提交</th>
			<th width="7%">等待审批</th>
			<th width="7%">等待执行</th>
			<th width="7%">等待验证</th>
			<th width="7%">关闭数量</th>
			<th width="7%">总数量</th>
			<th width="7%">类别占比</th>
			<th width="7%">完成率</th>
			<th width="7%">
			<c:if test="${IGSVC1123Form.statistictype != '2'}">来源分析</c:if>
			<c:if test="${IGSVC1123Form.statistictype == '2'}">类别分析</c:if>
			</th>
		 </tr>
		 <logic:present name="IGSVC11231VO" property="igsvc11231voList">
		 <logic:iterate id="bean" name="IGSVC11231VO" property="igsvc11231voList" type="com.deliverik.infogovernor.svc.vo.IGSVC11231VO">
		 <tr>
		 	<td>
		 	<c:if test="${IGSVC1123Form.statistictype != '2'}"><ig:codeValue ccid="EXAMINECATEGORY" cid="<%=0+bean.getPcode().substring(bean.getPcode().length()-3)%>"/></c:if>
			<c:if test="${IGSVC1123Form.statistictype == '2'}"><ig:codeValue ccid="IAPSOURCE" cid="${bean.prassetname}" /></c:if>
		 	</td>
		 	<td><bean:write name="bean" property="dispatch" /></td>
		 	<td><bean:write name="bean" property="initial" /></td>
		 	<td><bean:write name="bean" property="appoval" /></td>
		 	<td><bean:write name="bean" property="implement" /></td>
		 	<td><bean:write name="bean" property="verify" /></td>
		 	<td><bean:write name="bean" property="close" /></td>
		 	<td><span class="red"><bean:write name="bean" property="prssum" /></span></td>
		 	<td><span class="red"><bean:write name="bean" property="prsproportion" format="##.##"/>%</span></td>
		 	<td><span class="red"><bean:write name="bean" property="accomplish" format="##.##" />%</span></td>
		 	<td>
		 	<c:if test="${IGSVC1123Form.statistictype != '2'}">
		 	<html:link action="/IGSTA0202_Analysis.do?statistictype=2&prscode=${bean.pcode}"><img src="images/xx.gif" alt="来源分析" width="16" height="16"  border="0"/>
		 	</html:link></c:if>
			<c:if test="${IGSVC1123Form.statistictype == '2'}"><html:link action="/IGSTA0202_Analysis.do?statistictype=1&prsassetname=${bean.prassetname}"><img src="images/xx.gif" alt="检查项类别分析" width="16" height="16"  border="0"/></html:link></c:if>
		 	</td>
		</tr>
		 </logic:iterate>		 	
		</logic:present>
		<tr>
			<td>合计</td>
			<td><span class="red">${IGSVC11232VO.dispatchsum }</span></td>
			<td><span class="red">${IGSVC11232VO.initialsum }</span></td>
			<td><span class="red">${IGSVC11232VO.appovalsum }</span></td>
			<td><span class="red">${IGSVC11232VO.implementsum }</span></td>
			<td><span class="red">${IGSVC11232VO.verifysum }</span></td>
			<td><span class="red">${IGSVC11232VO.closesum }</span></td>
			<td><span class="red">${IGSVC11232VO.sum }</span></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</table>
     
     <div id="operate">
	</div>

</div>
</div>
  </div>

</div>
</div>
</body>
</html:html>