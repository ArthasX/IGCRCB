<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC1301" toScope="request" />
<bean:define id="title" value="文档信息查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">
function modify(isManager,sort,eiid){
	var checksort = sort.split("-")[0];
	var managers = isManager.split("_");
	
	var flag = false;
	
	for (var i = 0; i < managers.length; i++) {
		if (managers[i] == checksort) {
			flag = true;
			break;
		}
	}
	
	if(flag){
		window.location.href = "<%=request.getContextPath()%>"+"/IGASM0504_Disp.do?eiid="+eiid;
	}else{
		window.location.href = "<%=request.getContextPath()%>"+"/IGASM0509_Disp.do?eiid="+eiid;
	}
}

function selectTree(ccidinfo,selecedlast){
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		$("pivartreename").value = "";
	}else if(null!=temp && temp.split("|").length>1){
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

		if(treesyscode!=null && name!=null && treesyscode != ''){
			$("pivartreename").value = name;
		}else{
			$("pivartreename").value = '';
		}
		
	}		
	if($("pivartreename").onchange){
		$("pivartreename").onchange();
	}
}
//设置机构
function setOrg(url){	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].department.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].department.value = temp.split("|")[1];
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
	<html:form action="/IGCRC1301" styleId="form" onsubmit="">
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
	<div style="margin-top:4px;">
		<span class="subscribe">文档编号：</span>
		<html:text property="eiNumber" size="12" />
		<span class="subscribe">文档名称：</span>
		<html:text property="eiName" size="12" />
		<span class="subscribe">文档密级：</span>
		<html:select property="eiDense" styleId="eiDense">
			<html:option value=""></html:option>
			<html:option value="绝密">绝密</html:option>
			<html:option value="机密">机密</html:option>
			<html:option value="秘密">秘密</html:option>
			<html:option value="无">无</html:option>
		</html:select>
		<span class="subscribe">文档类型：</span>
		<html:select property="eiType" styleId="eiType">
			<html:option value=""></html:option>
			<html:option value="电子">电子</html:option>
			<html:option value="纸质">纸质</html:option>
			<html:option value="电子和纸质">电子和纸质</html:option>
		</html:select>
<!-- 		<span class="subscribe">内容：</span> -->
<%-- 		<html:text property="content" size="12" /> --%>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">文档分类：</span>
		<html:text property="eiSort" styleId="pivartreename"  readonly="true"  size="32" style="width:200px"/>
		<img style="cursor: hand;" onclick="selectTree('124_tree_文档分类','1');" alt="查询" src="images/seek.gif" complete="complete"/>
		<span class="subscribe">提交部门：</span>
		<html:text property="department" styleId="department" size="12" />
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择提交部门"/>
		<html:submit styleClass="button" value="查询" />
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="8%">文档编号</th>
			<th width="10%">文档名称</th>
			<th width="7%">文档类型</th>
			<th width="13%">文档分类</th>
			<th width="6%">文档密级</th>
			<th width="10%">提交部门</th>
			<th width="6%">管理人</th>
			<!-- <th width="10%">内容</th> -->
			<th width="7%">存储方式</th>
			<th width="17%">存放位置</th>
       	</tr>
		<logic:present name="IGCRC1301VO" property="igcrc1301VWList">
			<logic:iterate id="bean" name="IGCRC1301VO"
				property="igcrc1301VWList" indexId="index">
				<tr class="alarmcolor_level" style='cursor:hand' onclick="modify('${isManager}','${bean.eiSort}','<bean:write name="bean" property="eiid" />');">
					<td  width="8%" style="text-align:center;">${bean.eiNumber}</td> 
					<td  width="10%" style="text-align:center;">${bean.eiName}</td>
					<td  width="7%" style="text-align:center;">${bean.eiType}</td>
					<td  width="13%" style="text-align:center;">${bean.eiSort}</td>
					<td  width="6%" style="text-align:center;">${bean.eiDense}</td>
					<td  width="10%" style="text-align:center;">${bean.department}</td>
					<td  width="6%" style="text-align:center;">${bean.userName}</td>
					<%-- <td  width="10%" style="text-align:center;">${bean.content}</td> --%>
					<td  width="7%" style="text-align:center;">${bean.storageWay}</td>
					<td  width="17%" style="text-align:center;">${bean.storageLocation}</td>
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