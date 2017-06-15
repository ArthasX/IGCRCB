<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC2401" toScope="request" />
<bean:define id="title" value="事件平均解决时间统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
function modify(isManager,eiid){
	if("1" == isManager){
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
function onSearch(){
	//查询校验
	if(isDepartment() && isYear()){
		form.action = "IGCRC2401.do";
		form.submit();
	}
}
function onExcel(){
	//导出校验
	if(isDepartment() && isYear()){
		form.action = "IGCRC2401_Excel.do";
		form.submit();
	}
}
//如果选择月份但是没有年份提示需要选择年份
function isYear(){
	var selectYear = jQuery("select[name=year] option:selected").text();
	var selectMonth = jQuery("select[name=month] option:selected").text();
	if(selectYear =='' && selectMonth != ''){
		alert("请选择需要查询的年份!");
		return false;
	}
	return true;
}

//部门必填校验 有值返回true
function isDepartment(){
	var selectDepartment = jQuery("select[name=dept] option:selected").text();
	if(selectDepartment == ''){
		alert("请选择需要查询的部门！");
		return false;
	}
	return true;
}
function modify(obj){
	var year=document.getElementById("year").value;
	var month=document.getElementById("month").value;
	var propentime_like=year+"/"+month;
	var userid = jQuery(obj).parent().find("input[name='userId']").val();
	var url = "/IGDBM1200.do?propentime_like="+propentime_like+
			"&prpdid=01080&ppuserid="+userid+"&alarm_Is=0&ppstatus=W";
	
	//var url = '/IGDBM1200.do?prid_in='+jQuery(obj).parent().find("input[name='prid_In']").val();
	window.openSubWindow(url,"_blank", 1100, 600);
}
jQuery(function(){
	jQuery("input[name='prid_In']").each(function(){
		var prids = jQuery(this).val().split(",");
		var pridIn = prids[0];
		jQuery(this).data("prids",pridIn);
		var sum = 1;
		for( var i=1;i<prids.length;i++){
			if(pridIn != prids[i]){
				var prid = jQuery(this).data("prids");
				pridIn = prids[i];
				jQuery(this).data("prids",prid + ',' + pridIn);
				sum++;
			}
		}
		jQuery(this).val(jQuery(this).data("prids"));
		jQuery(this).parent().find("a").text(sum);
		jQuery(this).removeData();
	});
});

</script>
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC2401" styleId="form">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>事件平均解决时间统计</strong></span>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe"><%-- ${IGCRC2401Form.year } --%>年份：</span>
		 <html:select property="year" styleId="year">
			    <html:options collection="yearList" property="value" labelProperty="label"/>
		 </html:select>
		 <span class="subscribe"><%-- ${IGCRC2401Form.month } --%>月份：</span>
		 <html:select property="month" styleId="month">
			    <html:options collection="monthList" property="value" labelProperty="label"/>
		 </html:select>
		 <span class="subscribe"><span class="red">*</span>部门：</span>
		 <html:select property="dept" style="width: 130px;">
			    <html:options collection="deptList" property="value" labelProperty="label"/>
		 </html:select>
		<input type="button" value="查询" class="button" onclick="onSearch()">
		<input type="button" value="导出" class="button" onclick="onExcel()">
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th >事件级别</th>
			<th >V (分钟)</th>
			<th >IV (分钟)</th>
			<th >III (分钟)</th>
			<th >II (分钟)</th>
			<th >I (分钟)</th>
			<th >事件个数</th>
       	</tr>
 		<logic:present name="IGCRC2401VO" property="igcrc2402voList">
			<logic:iterate id="bean" name="IGCRC2401VO"
				property="igcrc2402voList" indexId="index">
				<tr>
					<td >${bean.name}</td>
					<td >${bean.grade5Str}</td>
					<td >${bean.grade4Str}</td>
					<td >${bean.grade3Str}</td>
					<td >${bean.grade2Str}</td>
					<td >${bean.grade1Str}</td>
					<td ><a style='cursor:hand' onclick="modify(this);">${bean.pridNUM}</a>
						<input type="hidden" name="prid_In" value="${bean.prid_In}"/>
						<input type="hidden" name="userId" value="${bean.userId}"/>
 					</td>
					<%-- <td >${bean.gradeIStr}</td>
					<td >${bean.gradeIIStr}</td>
					<td >${bean.gradeIIIStr}</td> --%>
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