<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM4001" toScope="request" />
<bean:define id="title" value="风险检查统计信息查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
///////////////////////////////////////////////
//功能：合并表格
//参数：tb－－需要合并的表格ID
//参数：colLength－－需要对前几列进行合并，比如，
//想合并前两列，后面的数据列忽略合并，colLength应为2
//缺省表示对全部列合并
//data: 2005.11.6
///////////////////////////////////////////////
function uniteTable(tb,colLength){
	//检查表格是否规整
	//if (!checkTable(tb)) return;
	var i=0;
	var j=0;
	var rowCount=tb.rows.length; // 行数
	var colCount=tb.rows[0].cells.length; // 列数
	var obj1=null;
	var obj2=null;
	//为每个单元格命名
	for (i=0;i<rowCount;i++){
		for (j=0;j<colCount;j++){
			if (j==8 || j==9) continue;
			tb.rows[i].cells[j].id="tb__" + i.toString() + "_" + j.toString();
		}
	}
	//逐列检查合并
	for (i=0;i<colCount;i++){
		if (i==colLength) return;
		if (i==3 || i==4 || i==5) continue;
		obj1=document.getElementById("tb__0_"+i.toString())
		for (j=1;j<rowCount;j++){
			obj2=document.getElementById("tb__"+j.toString()+"_"+i.toString());
			if (obj1.innerText == obj2.innerText){
				obj1.rowSpan++;
				obj2.parentNode.removeChild(obj2);
			}else{
				obj1=document.getElementById("tb__"+j.toString()+"_"+i.toString());
			}
		}
	}
}

function onExcel(){
	form.action = "IGASM4001_Excel.do";
	form.submit();
}
</script>
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="uniteTable(mainTable,3)">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGASM4001" styleId="form" onsubmit="">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style17" id="mainTable" style="b">
		<tr>
			<th width="13%">风险领域(一级分类)</th>
			<th width="13%">风险子域(二级分类)</th>
			<th width="12%">风险项</th>
			<th width="19%">风险点(检查点)</th>
			<th width="3%">严重等级</th>
			<th width="3%">发生可能性</th>
			<th width="3%">风险级别</th>
			<th width="8%">风险点标志</th>
			<th width="20%">检查方法</th>
			<th width="6%">检查频度</th>
       	</tr>
		<logic:present name="IGASM40011VO" property="riskCheckMap">
			<logic:iterate id="map" name="IGASM40011VO" property="riskCheckMap" indexId="index">
				<logic:present name="map" property="key">
					<bean:size id="valueSize" name="map" property="key"/>
					<logic:iterate id="bean" name="map" property="key" indexId="idx">
						<tr>
							<%-- <logic:equal value="0" name="idx">
								<td rowspan="${valueSize }">${index + 1}</td>
								<td rowspan="${valueSize }">
									<ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${map.key }"/>
								</td>
							</logic:equal> --%>
							<td>${bean.riskly}</td>
							<td>${bean.riskarea}</td>
							<td>${bean.riskitem}</td>
							<td>${bean.einame}</td>
							<td>${bean.grad}</td>
							<td>${bean.poss}</td>
							<td>${bean.levels}</td>
							<td>${bean.risksign}</td>
							<logic:equal value="0" name="idx">
								<td rowspan="${valueSize}">
									<table class="table_style18">
										<logic:present name="map" property="value">
										<logic:iterate id="bean1" name="map" property="value" indexId="idx">
											<tr>
												<td>${bean1.checkMethod}</td>
											</tr>
										</logic:iterate>
									</logic:present>
									</table>
								</td>
								<td rowspan="${valueSize}">
									<table id="table_${index +1}" class="table_style18">
										<logic:present name="map" property="value">
										<logic:iterate id="bean1" name="map" property="value" indexId="idx">
											<tr>
												<td>${bean1.checkfrequency}</td>
											</tr>
										</logic:iterate>
									</logic:present>
									</table>
								</td>
							</logic:equal>
						</tr>
					</logic:iterate>
				</logic:present>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate" style="text-align: center;">
		<html:button property="" value="导出" styleClass="button" onclick="onExcel()"/>
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>