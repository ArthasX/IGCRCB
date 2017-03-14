<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;
	int f = 0;
%>
<html:html>
<bean:define id="id" value="IGSVC0612" toScope="request" />
<bean:define id="title" value="设备运行报告画面" toScope="request" />
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




function checkForm(){

	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSVC0603_1.do";
		document.forms[0].submit();	
	}
	
}
function exportExcel() {
	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSVC0603_1.do?report1=1";
		document.forms[0].submit();
	}
}
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
   <div id="location">
       <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>  
     <div id="search">
     <html:form styleId="form" action="/IGSVC0603_1" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
        <span>时间：从</span><span><html:text property="propentime_from" readonly="true" errorStyleClass="inputError imeActive"/></span>
   		<img src="images/date.gif" align="middle" onClick="calendar($('propentime_from'))" border="0"/>                       
        <span>&nbsp;&nbsp;到</span><span><html:text property="propentime_to" readonly="true" errorStyleClass="inputError imeActive"/></span>
         <img src="images/date.gif" align="middle" onClick="calendar($('propentime_to'))" border="0"/>
       <span><input type="hidden" value="001" name="type" />
       <html:submit property="btn_search" styleClass="button" value="查询" onclick="checkForm()"/>
       <html:submit property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
       </span> 
       </div>
      </div>
    </html:form>
    </div>
        
     
     <div id="results_list"><ig:message />
       <table  class="table_style">
						
						<tr>
							<th width="17%">设备名称</th>
							<th width="15%">事件</th>
							<th width="15%">问题</th>
							<th width="15%">变更</th>
							<th width="15%">工作</th>
							<th width="8%">汇总</th>
						</tr>
					
						
						<!-- body部 -->
                            <logic:present name="IGSVC05131VO" property="processCountList">
								<logic:iterate id="bean" name="IGSVC05131VO"
									property="processCountList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<td>
										<div class="nowrapDiv"> ${bean.prassetname}</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="incident" name="bean" property="incident" />
										<% 
											int iIncident = Integer.valueOf(incident + "");
											a += iIncident;
											if(iIncident == 0){
												out.print("0");
											} else {
										%>
										<a href="IGSVC0604.do?prassetid=${bean.prassetid}&type=001&prtype=WD&prpdid=01080&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59&modes=2"> ${bean.incident}</a>		
										<%
											}
										
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="problem" name="bean" property="problem" />
										<% 
											int iproblem = Integer.valueOf(problem + "");
											b += iproblem;
											if(iproblem == 0){
												out.print("0");
											}else{
										%>	
										<a href="IGSVC0604.do?prassetid=${bean.prassetid}&type=001&prtype=WD&prpdid=01083&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59&modes=2"> ${bean.problem}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="change" name="bean" property="change" />
										<% 
											int ichange = Integer.valueOf(change + "");
											c += ichange;
											if(ichange == 0){
												out.print("0");
											}else{
										%>
										<a href="IGSVC0604_1.do?prassetid=${bean.prassetid}&type=001&prtype=WD&prpdid=01084&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59&modes=2"> ${bean.change}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="work" name="bean" property="work" />
										<% 
											int iwork = Integer.valueOf(work + "");
											e += iwork;
											if(iwork == 0){
												out.print("0");
											}else{
										%>
										<a href="IGSVC0604_2.do?prassetid=${bean.prassetid}&type=001&prtype=WAB&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59&modes=2"> ${bean.work}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<span class="red">
										${bean.incident+bean.problem+bean.change+bean.deployment+bean.work}
										</span>
										<% f += Integer.valueOf(incident + "")+Integer.valueOf(problem + "")+Integer.valueOf(change + "")+Integer.valueOf(work + "");%>
										</td>
										
									</tr>
								</logic:iterate>
							</logic:present>
						<%if(request.getAttribute("message") != null){ 
							out.print(request.getAttribute("message"));
						}else if(f > 0){
						
						%>	
						<tr>
							<td width="17%"><strong>统计</strong></td>
							<td width="15%">
								<span class="red">
								<%=a%>
								</span>
							</td>
							<td width="15%">
								<span class="red">
								<%=b%>
								</span>
							</td>
							<td width="15%">
								<span class="red">
								<%=c%>
								</span>
							</td>
							<td width="15%">
								<span class="red">
								<%=e%>
								</span>
							</td>
							<td width="8%">
								<span class="red">
								<%=f%>
								</span>
							</td>
						</tr>
						<% }%>
					</table>
     </div>
     <div id="operate">
	</div>

</div>
</div>
  </div>


</div>
</body>
</html:html>