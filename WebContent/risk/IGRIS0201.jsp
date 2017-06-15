<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGRIS0201" toScope="request" />
<bean:define id="title" value="检查策略管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">	
<!--
	//删除所选
	/*function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="风险检查基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM0101_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}*/

	

	function changeStatus(csid,csstatus,rcenddate,rcfrequency,rcstartdate){
		if(confirm("您是否确认改变状态？")){
			if("1"==csstatus){
				if (rcfrequency == 'once' && !checkDateByContent('<%=IGStringUtils.getCurrentDate() %>',rcstartdate.split(" ")[0])) {
					alert("该检查策略的执行日期早于当前日期，不能启用！");
					return;
				}
				if(!checkDateByContent('<%=IGStringUtils.getCurrentDate() %>',rcenddate.split(" ")[0])){
					alert("该检查策略的结束日期早于当前日期，不能启用！");
					return;
				}else{
					var form = document.getElementById("form");
					form.action="IGRIS0201_Change.do?csid="+csid+"&rcstatus="+csstatus;
					form.submit();
				}
			}else{
				var form = document.getElementById("form");
				form.action="IGRIS0201_Change.do?csid="+csid+"&rcstatus="+csstatus;
				form.submit();
			}

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
			$("rccategory").value="";
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
			$("rccategory").value=treesyscode;
			$("rccategoryname").value=name;
			
		}		
		
	}
	function isCopy(){
		if( window.confirm("是否确认复制？")){
	        return true;
	     }else{
	    	 false;
	     }
	}
	 
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGRIS0201" onsubmit="return checkSubmit(this);">
	
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div>
	<span class="subscribe">检查方式：</span>
	<html:select property="rcrtestmode" styleId="rcrtestmode" style="margin-left:-5px">
		<ig:optionsCollection ccid="RISKCHECK_CLASS_TYPE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> 
	<%-- <span class="subscribe">检查项类别：</span><html:text property="rccategoryname" size="18" styleId="rccategoryname" errorStyleClass="inputError imeActive" readonly="true"/>
		<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
		<html:hidden property="rccategory"/> --%>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe">检查策略名称：</span>
	<html:text property="rcname" styleId="rcname" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe">重要程度：</span>
	<html:select property="rctype" styleId="rctype" style="margin-left:-5px">
		<ig:optionsCollection ccid="RISKCHECK_TYPE_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe" >状态：</span>
	<html:select property="rcstatus">
		<html:option value=""></html:option>
		<html:option value="0">停用</html:option>	
		<html:option value="1">启用</html:option>												
    </html:select>
    <br />
	<span class="subscribe">责任组名称：</span><html:text property="rcrolename" size="18" styleId="rcrolename" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe">责任人姓名：</span>
	<html:text property="rcusername" size="15" styleId="rcusername"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	 <span class="subscribe">频率：</span>
    <html:select property="rcfrequency">
       	<html:option value=""></html:option>
       	<html:option value="once">立即发起</html:option>
   		<html:option value="day">每日</html:option>
   		<html:option value="week">每周</html:option>
   		<html:option value="month">每月</html:option>
   		<html:option value="quarter">每季度</html:option>
   		<html:option value="halfyear">每半年</html:option>
   		<html:option value="year">每年</html:option>
   	</html:select>
   	&nbsp;&nbsp;&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				
				<th width="5%">序号</th>
				<th width="20%">检查策略名称</th>
				<th width="10%">检查方式</th>
				<th width="10%">责任人</th>
				<th width="7%">合作责任人</th>
				<th width="6%">频率</th>
				<th width="10%">策略开始时间</th>
				<th width="10%">策略结束时间</th>
				<th width="4%">状态</th>
			 	<th width="4%">编辑</th>
				<th width="4%">详细</th>
				<th width="4%">复制</th>
			</tr>
			<logic:present name="IGRIS02011VO" property="checkStrategyList">
				<logic:iterate id="bean" name="IGRIS02011VO"
					property="checkStrategyList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
						</td>
						<td>
							${bean.csname}	
						</td>
						<td>
							<ig:codeValue ccid="RISKCHECK_CLASS_TYPE" cid="${bean.csrtestmode}"/>						
							<%-- <c:if test="${bean.csrtestmode=='1'}" >内部常规</c:if>
							<c:if test="${bean.csrtestmode=='2'}" >等级保护</c:if>
							<c:if test="${bean.csrtestmode=='3'}" >专项</c:if> --%>
							<%-- ${bean.csrtestmode} --%>
						</td>
						<td>
							${bean.csusername}
						</td>
						<td>
							${bean.csassetname}								
						</td>
						<td>
							<%-- ${bean.csfrequency}  --%>
							<c:if test="${bean.csfrequency=='once'}" >立即发起</c:if>
							<c:if test="${bean.csfrequency=='day'}" >每日</c:if>
							<c:if test="${bean.csfrequency=='week'}" >每周</c:if>
							<c:if test="${bean.csfrequency=='month'}" >每月</c:if>
							<c:if test="${bean.csfrequency=='quarter'}" >每季度</c:if> 
							<c:if test="${bean.csfrequency=='halfyear'}" >每半年</c:if>
							<c:if test="${bean.csfrequency=='year'}" >每年</c:if>
						</td>

						<td>${bean.csstartdate}</td>

						<td>${bean.csenddate}</td>
						
						<td>
							<c:if test="${IGRIS0201Form.isSecurityApproval == '1'}">
							<logic:equal name="bean" property="csstatus"  value="1">
							<a href="javascript:changeStatus('${bean.csid}','0','${bean.csenddate}','${bean.csfrequency}', '${bean.csstartdate}');"><img src="images/stop.gif" border="0" alt="点击后停用"/></a> 
						    </logic:equal>
						   
						   
							<logic:equal name="bean" property="csstatus"  value="0">
							<a href="javascript:changeStatus('${bean.csid}','1','${bean.csenddate}','${bean.csfrequency}', '${bean.csstartdate}');"><img src="images/start.gif" border="0" alt="点击后启用"/></a>
						    </logic:equal>
							</c:if>	
							<c:if test="${IGRIS0201Form.isSecurityApproval != '1'}">
							
							<logic:equal name="bean" property="csstatus"  value="1">
							<img src="images/start-1.gif" border="0" />
						    </logic:equal>
						   
						   
							<logic:equal name="bean" property="csstatus"  value="0">
							<img src="images/stop.gif" border="0" />
						    </logic:equal>							
							</c:if>
							
						</td>
						<td>		
							<logic:equal name="bean" property="csstatus"  value="1">
							<html:link action="/IGRIS0202_Detail.do?csid=${bean.csid}">
								<img src="images/xx.gif" width="16" height="16" border="0" alt="查看"/>
							</html:link>
							</logic:equal>
							<logic:equal name="bean" property="csstatus"  value="0">
							<html:link action="/IGRIS0202_Edit.do?csid=${bean.csid}">
								<img src="images/edit.gif" width="16" height="16" border="0" alt="编辑"/>
							</html:link>
							</logic:equal>
								

						</td>
							<%-- <html:link action="/IGRIS0201_POINT.do?csid=${bean.csid}"> --%>
						<td>		
							<html:link action="/IGRIS0205_LASTSEARCH.do?csid=${bean.csid}"> 
								<img src="images/look.gif" width="16" height="16" border="0" alt="详细"/>
							</html:link>	
						</td>
						<td>
							<html:link action="/IGRIS0202_COPY.do?csid=${bean.csid}" onclick="return isCopy()">
								<img src="images/bdld.gif" width="16" height="16" border="0" alt="复制"/>
							</html:link>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>

</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>