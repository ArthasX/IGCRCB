<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRPT0102" toScope="request" />
<bean:define id="title" value="统计分析画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	overflow-y: auto;
	background-color: #FFFFFF;
}

.table_style {
	width: 732px;
	margin: 10px 10px;
	border-collapse: collapse;
	text-align: center;
	table-layout: fixed;
}

.table_style th {
	color: #000000;
	border-top: 1px solid #CCCCCC;
	border-bottom: 1px solid #CCCCCC;
	background-color: #EEEEEE;
	height: 20px;
}

.table_style td {
	border-bottom: 1px solid #D3D3D3;
	height: 18px;
	word-break: break-all;
	word-wrap: break-word;
}
.table_style td a:link{
   color:#0066CC;
   text-decoration:none;
}
.table_style td a:visited{
   color:#0066CC;
   text-decoration:none;
}
.table_style td a:hover{
   color:#0066CC;
   text-decoration:underline;
}
.table_style td a:active{
   color:#0066CC;
   text-decoration:none;
}
</style>
<script type="text/javascript">	
<!--
	//设置节点完整名称
	function setCompleteNodeName(){
		parent.rfdtypename.innerHTML = "${IGRPT01021VO.completeNodeName}";
	}
	//查看版本列表
	function showVersion(rfdid){
		openSubWindow('/IGSYM1405_Disp.do?rfdid=' + rfdid, '_blank','1000','600');
	}

	function qhtb(){
		pic.style.display='none';
		tabl.style.display='';
		operate.style.display='';
	}

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

	function orderByUp(ordernum){
		var selrfdids=document.getElementsByName("selrfdid");
		if(ordernum==1){
			return false;
		}
		var rfdidI;
		var rfdidII;
		for(var i=0;i<selrfdids.length;i++){
			if((ordernum-1)==(i+1)){
				rfdidI = selrfdids[i].value;
			}
			if(ordernum==(i+1)){
				rfdidII = selrfdids[i].value;
			}
		}
		location.href="IGRPT0104_ord.do?rfdidI="+rfdidI+"&rfdidII="+rfdidII;
	}

	function orderByDown(ordernum){
		var selrfdids=document.getElementsByName("selrfdid");
		if(ordernum==selrfdids.length){
			return false;
		}
		var rfdidI;
		var rfdidII;
		for(var i=0;i<selrfdids.length;i++){
			if(ordernum==(i+1)){
				rfdidI = selrfdids[i].value;
			}
			if((ordernum+1)==(i+1)){
				rfdidII = selrfdids[i].value;
			}
		}
		location.href="IGRPT0104_ord.do?rfdidI="+rfdidI+"&rfdidII="+rfdidII;
	}

	function checkSubmitI(){
		var count=0;
		var check=document.getElementsByName("selected");
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count++;
			}
		}
		
		if(count==0){
			alert("请选择需要取消订制的报表");
			return false;
		}
		return true;
	}

	function checkSubmitII(){
		var count=0;
		var check=document.getElementsByName("unselect");
		var selrfdids=document.getElementsByName("selrfdid");
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count++;
				for(var j=0;j<selrfdids.length;j++){
					if(check[i].value==selrfdids[j].value){
						alert("序号为["+(i+1)+"]的报表已经被订制，请取消选择");
						return false;
					}
				}
			}
		}
		if(selrfdids.length+count>10){
			alert("订制报表数量超过上限值,最多订制10个报表");
			return false;
		}
		if(count>0){
			createHiddenInputForm("ordernum",selrfdids.length+1,formII);
		}else{
			alert("请选择需要订制的报表");
			return false;
		}
		return true;
	}	
//-->
	</script>
<body onload="setCompleteNodeName()">
<div style="margin-top:4px;margin-left:10px">
<!-- ig:message --> 
<ig:message/>
</div>

<div class="role_title">已订制报表</div>
<html:form styleId="formI" action="/IGRPT0104_del" onsubmit="return checkSubmitI();">
<logic:present name="IGRPT01021VO" property="selectedReportFileDefinitionList">
<table class="table_style">
	<tr>
		<th width="50"></th>
		<th width="50">序号</th>
		<th width="260">报表名称</th>
		<th width="302">报表说明</th>
		<th width="70">排序</th>
	</tr>
	
		<logic:iterate id="bean" name="IGRPT01021VO"
			property="selectedReportFileDefinitionList" indexId="index">
			<tr>
				<td><input type="checkbox" name="selected" id="selected" value="${bean.rfdid}"/></td>
				<td>${index + 1}<input type="hidden" name="selrfdid" id="selrfdid" value="${bean.rfdid}"/></td>
				<td align="left"><logic:empty name="bean" property="rfdtitle">&nbsp;</logic:empty>${bean.rfdtitle}</td>
				<td><logic:empty name="bean" property="rfddesc">&nbsp;</logic:empty>${bean.rfddesc}</td>
				<td>
				<img alt="" src="images/timedown.gif"/ style="cursor: hand;" onclick="orderByDown(${index + 1});">
				&nbsp;
				<img alt="" src="images/timeup.gif"/ style="cursor: hand;" onclick="orderByUp(${index + 1});">
				</td>
			</tr>
		</logic:iterate>
</table>
<div id="operate">
	<logic:present name="IGRPT01021VO"
		property="selectedReportFileDefinitionList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" /></span>
	</logic:present>
</div>
</logic:present>
</html:form>
<BR/>
<div class="role_title">可订制报表</div>
<html:form styleId="formII" action="/IGRPT0104_sel" onsubmit="return checkSubmitII();">
<logic:present name="IGRPT01021VO" property="reportFileDefinitionList">
<table class="table_style">
	<tr>
		<th width="50"></th>
		<th width="50">序号</th>
		<th width="260">报表名称</th>
		<th width="372">报表说明</th>
	</tr>
	
		<logic:iterate id="bean" name="IGRPT01021VO"
			property="reportFileDefinitionList" indexId="index">
			<tr>
				<td><input type="checkbox" name="unselect" id="unselect" value="${bean.rfdid}"/></td>
				<td>${index + 1}</td>
				<td align="left"><logic:empty name="bean" property="rfdtitle">&nbsp;</logic:empty>
				${bean.rfdtitle}</td>
				<td><logic:empty name="bean" property="rfddesc">&nbsp;</logic:empty>${bean.rfddesc}</td>
			</tr>
		</logic:iterate>
	
</table>
<div id="operate">
	<logic:present name="IGRPT01021VO"
		property="reportFileDefinitionList">
		<span> <html:submit property="btn_insert" value="添加所选"
			styleClass="button" /></span>
	</logic:present>
</div>
</logic:present>
</html:form>
</body>
</html:html>