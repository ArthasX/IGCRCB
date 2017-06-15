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
<bean:define id="id" value="IGVEN0101" toScope="request" />
<bean:define id="title" value="风险策略管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">	
<!--
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
					form.action="IGVEN0101_Change.do?rsid="+csid;
					form.submit();
				}
			}else{
				var form = document.getElementById("form");
				form.action="IGVEN0101_Change.do?rsid="+csid;
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
	    	 return false;
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
<html:form styleId="form" action="/IGVEN0101" onsubmit="return checkSubmit(this);">
	
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
	<span class="subscribe">风险策略名称：</span>
	<html:text property="rcname" styleId="rcname" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				
				<th width="5%">序号</th>
				<th width="20%">风险策略名称</th>
				<th width="30%">风险策略描述</th>
				<th width="10%">策略开始时间</th>
				<th width="10%">策略结束时间</th>
				<th width="4%">状态</th>
			 	<th width="4%">编辑</th>
				<th width="4%">详细</th>
				<th width="4%">复制</th>
			</tr>
			<logic:present name="IGVEN01011VO" property="riskStrategyList">
				<logic:iterate id="bean" name="IGVEN01011VO"
					property="riskStrategyList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
						</td>
						<td title="${bean.rsname}" >
							<ig:SubstringShowEllipsisWriteTag len="15" showEllipsis="true">
								${bean.rsname}
							</ig:SubstringShowEllipsisWriteTag>
						</td>
						<td title="${bean.rsdesc}" >
							<ig:SubstringShowEllipsisWriteTag len="20" showEllipsis="true">
								${bean.rsdesc}
							</ig:SubstringShowEllipsisWriteTag>
						</td>
							
						<td>
							${bean.rsstartdate}
						</td>
						<td>
							${bean.rsenddate}								
						</td>
						
						<td>
							<logic:equal name="bean" property="rsstatus"  value="1">
							<a href="javascript:changeStatus('${bean.rsid}','0','${bean.rsenddate}','${bean.rsfrequency}', '${bean.rsstartdate}');"><img src="images/stop.gif" border="0" alt="点击后停用"/></a> 
						    </logic:equal>
						   
							<logic:equal name="bean" property="rsstatus"  value="2">
							<a href="javascript:changeStatus('${bean.rsid}','1','${bean.rsenddate}','${bean.rsfrequency}', '${bean.rsstartdate}');"><img src="images/start.gif" border="0" alt="点击后启用"/></a>
						    </logic:equal>
						</td>
						<td>		
							<logic:equal name="bean" property="rsstatus"  value="1">
							<html:link action="/IGVEN0102_Detail.do?rsid=${bean.rsid}">
								<img src="images/xx.gif" width="16" height="16" border="0" alt="查看"/>
							</html:link>
							</logic:equal>
							<logic:equal name="bean" property="rsstatus"  value="2">
							<html:link action="/IGVEN0102_Edit.do?rsid=${bean.rsid}">
								<img src="images/edit.gif" width="16" height="16" border="0" alt="编辑"/>
							</html:link>
							</logic:equal>
						</td>
							<%-- <html:link action="/IGRIS0201_POINT.do?csid=${bean.csid}"> --%>
						<td>		
							<html:link action="/IGVEN0201_LASTSEARCH.do?rsid=${bean.rsid}"> 
								<img src="images/look.gif" width="16" height="16" border="0" alt="详细"/>
							</html:link>	
						</td> 
						<td>
							<html:link action="/IGVEN0102_COPY.do?rsid=${bean.rsid}" onclick="return isCopy()">
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