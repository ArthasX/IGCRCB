<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<!--javascript-->
<script type="text/javascript">
var gid='IGSDL0203';


function checkForm(){
	if(confirm("是否确认删除?")){
		return true;
	}
	return false;
}

function selectEntity(){
	openSubIGCOM0302();
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
    $("qjassetid").value = eiid;
	//$("qjassetname").value = eilabel;
	$("qjassetname").value = einame;
}

function showIncident(){
	var ccid = "116";
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
		$("qjassettypeid").value="";
		$("qjassettypename").value="";
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
		$("qjassettypeid").value=treesyscode;
		$("qjassettypename").value=name;
	}		
}
</script>
<bean:define id="id" value="IGSDL0203" toScope="request" />
<bean:define id="title" value="服务统计" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container"><!--container 左菜单 右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGSDL0203" styleId="form">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<div class="img"></div>
<div class="conditions">
	<div>
	<span>相关资产：</span><html:text property="qjassetname" readonly="true" /> 
    <img alt="资产查询" src="images/seek.gif" onclick="selectEntity();" style="cursor: hand;" />
	<html:hidden property="qjassetid" />
	<span>&nbsp;&nbsp;策略类别：</span><html:text property="qjassettypename" readonly="true" /> 	
		<img alt="分类查询" src="images/tree.gif" onclick="showIncident();" style="cursor: hand;" />
		<html:hidden property="qjassettypeid" /> <span>
		<html:submit styleClass="button" value="查询" /></span></div>
</div>
</div>
<div id="results_list"><ig:message />
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="20%">任务名称</th>
		<th width="25%">任务描述</th>
		<th width="15%">任务类型</th>
		<th width="15%">执行人</th>
		<th width="15%">开始时间</th> 

	</tr>
	<logic:present name="IGSDL01101VO" property="quartzJobsList">
		<logic:iterate id="bean" name="IGSDL01101VO" property="quartzJobsList"
			indexId="index">

			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('IGSDL0204_List.do?qjid=<bean:write name="bean" property="qjid" />&qjtype=<bean:write name="bean" property="qjtype" />');" >
				<td>${PagingDTO.viewStartCount+index}</td>
				<td><bean:write name="bean" property="qjname" /></td>
				<td><bean:write name="bean" property="qjdesc" /></td>
				<td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean.qjtype}" /></td>
				<td><bean:write name="bean" property="qjimplusername" /></td>
				<td><bean:write name="bean" property="qjcrttime" /></td>
				
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</div>
<div id="operate">
<jsp:include page="/include/paging.jsp" />
</div>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>