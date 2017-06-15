<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSYM0413" toScope="request" />
<bean:define id="title" value="报表授权" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function selectRfdtype(){
		var ccid = "217";
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
			$("rfdtype").value="";
			$("rfdtypename").value="";
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
	
			$("rfdtype").value=treesyscode;
			$("rfdtypename").value=name;
			
		}		
		
	}
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="报表基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM1401_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}
	//版本升级
	function insertVersion(rfdid){
	    var confirmMsg = "请确认是否要进行版本升级处理？";
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM1401_Version.do?rfdid=" + rfdid;
	        form.submit();
	        return true;
	    } else {
	        return false;
	    }
	}
	//查看版本列表
	function showVersion(rfdid){
		form.action = getAppRootUrl() + "/IGSYM0412_Disp.do?rfdid=" + rfdid;
        form.submit();
	}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGSYM0413" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>&nbsp;&nbsp;显示名称：</span><span><html:text
		property="rfdtitle_like" name="IGSYM0413Form" styleId="rfdtitle_like" /></span>
			<span>&nbsp;&nbsp;分类：</span><span><html:text
		name="IGSYM0413Form" property="rfdtypename" styleId="rfdtypename"
		style="width:100px;" errorStyleClass="inputError" readonly="true" /> <img
		src="images/tree.gif" border="0" width="16" height="16" alt="查询"
		onclick="selectRfdtype()" style="cursor: hand" /> <html:hidden
		name="IGSYM0413Form" property="rfdtype" styleId="rfdtype" /></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span> <html:submit styleClass="button" value="查询" /></span></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="21%">显示名称</th>
			<th width="14%">报表分类</th>
			<th width="8%">报表类型</th>
			<th width="8%">当前版本</th>
			<th width="8%">最新版本</th>
			<th width="12%">创建日期</th>
			<th width="8%">版本信息</th>
			<th width="8%">授权报表</th>
		</tr>
		<logic:present name="IGSYM04091VO" property="reportFileDefinitionList">
			<logic:iterate id="bean" name="IGSYM04091VO"
				property="reportFileDefinitionList" indexId="index">
				<tr>
					<td><logic:empty name="bean" property="rfdtitle">&nbsp;</logic:empty><html:link
						action="/IGSYM1402_Exa_Disp.do?rfdid=${bean.rfdid}">${bean.rfdtitle}</html:link></td>
					<td><logic:empty name="bean" property="rfdtype">&nbsp;</logic:empty>${bean.codeDetailTB.cvalue}</td>
					<td><logic:empty name="bean" property="isFlag">&nbsp;</logic:empty>
						<logic:equal value="0" name="bean" property="isFlag">定制报表</logic:equal>
						<logic:equal value="1" name="bean" property="isFlag">常规报表</logic:equal>
					</td>
					<td><logic:empty name="bean" property="rfdversion">&nbsp;</logic:empty>${bean.rfdversion}版</td>
					<td><logic:empty name="bean" property="rfdversion">&nbsp;</logic:empty>${bean.rfdnewversion}版</td>
					<td><logic:empty name="bean" property="rfdinstime">&nbsp;</logic:empty>${bean.rfdinstime}</td>
					<td><html:link href="javascript:showVersion('${bean.rfdid}')"><img src="images/info.gif" alt="版本信息" width="16" height="16"  border="0"/></html:link></td>
					<td>
						<a href="IGSYM0410_Disp.do?rfdid=${bean.rfdid}&rfdpictype=${bean.rfdpictype}">
							<img src="images/sq.gif" width="16" height="16" border="0"/>
						</a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGSYM04091VO"
		property="reportFileDefinitionList">
		<bean:size id="num" name="IGSYM04091VO"
			property="reportFileDefinitionList" />
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" /></div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
