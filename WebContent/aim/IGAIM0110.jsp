<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0110" toScope="request" />
<bean:define id="title" value="配置原数据页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var categorys = new Array();
var data;
var tempdata;
function toback(){
	form.action = getAppRootUrl() + "/IGAIM0104.do?org.apache.struts.taglib.html.CANCEL=1";
	form.submit();
}
function showHistory(tablename){
	createHiddenInputForm("tablename",tablename,form);
	form.action = getAppRootUrl() + "/IGAIM0110.do";
	form.submit();
}
function compareVersions(){
	var objs = document.getElementsByName("tablenames");
	var count = 0;
	var tablenames = "";
	if(objs!=null&&objs.length>0){
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				count++;
				tablenames += objs[i].value+",";
			}
		}
	}
	if(count<2){
		alert("请选择要比较的两个版本！");
		return;
	}
	if(count>2){
		alert("只能选择两个版本比较！");
		return;
	}
	openSubWindow('/IGAIM0111_Disp.do?eiid=${IGCIM0110Form.eiid}&tablenames='+tablenames, 'newpage', '1100', '800');
}
function changeCategory(val){
	var keySelect = document.getElementById("keys");
	if(keySelect!=null){
		keySelect.options.length = 0;  
		if(val!=null&&val.trim()!=""){
			var ops = categorys[val];
			var firstOptionItem = new Option("","");
			keySelect.add(firstOptionItem);
			if(ops!=null&&ops.length>0){
				for(var i=0;i<ops.length;i++){
					var optionItem = new Option(ops[i],ops[i]);
					keySelect.options.add(optionItem);
				}
			}
		}
	}
	document.getElementById("datadiv").innerHTML = data;
	if(val!=null&&val.trim()!=""){
		changTable(val,0);
		tempdata = document.getElementById("datadiv").innerHTML;
	}
}
function initBody(){
	var datadiv = document.getElementById("datadiv");
	if(datadiv!=null){
		data = datadiv.innerHTML;
	}
}
function changTable(val,col){
	var tb = document.getElementById("datatable");
	var length = tb.rows.length;
	var flag = false;
	for(var i=0;i<length;i++){
		if(col==0){
			if(tb.rows[i].cells.length==4&&tb.rows[i].cells[0].innerHTML.indexOf(val)<0){
				var rowLength = tb.rows[i].cells[0].rowSpan;
				for(var num=0;num<rowLength;num++){
					tb.deleteRow(i);
				}
				flag = true;
				break;
			}
		}else{
			if(tb.rows[i].cells.length==4){
				if(tb.rows[i].cells[1].innerHTML.indexOf(val)<0){
					if(i<length){
						var temptd = tb.rows[i].cells[0];
						var tr = tb.rows[i+1];
						var td = tr.insertCell(0);
						td.innerHTML = temptd.innerHTML;
						td.rowSpan = temptd.rowSpan-1;
						td.style.borderColor = '#d3d3d3';
						
					}
					tb.deleteRow(i);
					flag = true;
					break;
				}
			}else{
				if(tb.rows[i].cells[0].innerHTML.indexOf(val)<0){
					tb.deleteRow(i);
					flag = true;
					break;
				}
			}
		}
	}
	if(flag){
		changTable(val,col);
	}
}
function changeKeys(val){
	document.getElementById("datadiv").innerHTML = tempdata;
	if(val!=null&&val.trim()!=""){
		changTable(val,1);
	}
}
</script>
<style type="text/css">
	#datatable tr td{
		border-left:#d3d3d3 1px solid;
		border-right:#d3d3d3 1px solid;
		padding-top:10px;
		padding-bottom:10px;
	}
</style>
<body onload="initBody();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
    	<div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 配置原数据111（${IGCIM01101VO.cr03.host}）</p>
        <div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGCIM0104.btn_toback"/> </html:link></div>
    </div>  
	<html:form styleId="form" action="/IGAIM0110_Disp.do">
		<logic:present name="IGCIM01101VO" property="showFlag">
		<logic:equal value="N" name="IGCIM01101VO" property="showFlag">
			<div style="margin-left:30px;margin-top:20px;">
				<span class="red"><b>配置原数据信息不存在！</b></span>
			</div>
		</logic:equal>
		<logic:present name="IGCIM01101VO" property="cr03List">
			<div style="width:160px;height:490px;margin-left:10px;float:left;">
			<div>
					<div>从
					<html:text styleId="collecttimeFrom" name="IGCIM0110Form" property="collecttimeFrom" readonly="true" size="15"/>
					<img src="images/date.gif" align="middle" onclick="showDate($('collecttimeFrom'))" border="0" style="cursor: hand" />
					</div>
					<div>到
					<html:text styleId="collecttimeTo" name="IGCIM0110Form" property="collecttimeTo" readonly="true" size="15"/>
					<img src="images/date.gif" align="middle" onclick="showDate($('collecttimeTo'))" border="0" style="cursor: hand" />
					</div>
					<div>
						<html:submit value="查询" styleClass="button" style="width:60px;"/>
						<html:button property="check" value="版本比较" styleClass="button" style="width:80px;" onclick="compareVersions();"/>
					</div>
			</div>
				<div style="width:160px;height:30px;">
					<table class="table_style">
						<tr style="height:30px;">
								<th align="center">版本信息</th>
						</tr>
					</table>
				</div>
				<bean:size id="vsize" name="IGCIM01101VO" property="cr03List"/>
				<div style="width:160px;border:#a2cbf3 1px solid;height:365px;margin-top:2px;float:left;
					<c:if test="${vsize>10 }">
						overflow-y:scroll;overflow-x:hidden;
					</c:if>
					">
					<logic:iterate id="bean" name="IGCIM01101VO" property="cr03List">
						<table width="100%" id="versionTable">
							<tr
								<c:if test="${IGCIM01101VO.cr03.collecttime==bean.collecttime }">
									style="background-color: #C4E0FF;"
								</c:if>
							>
								<td>
									<input type="checkbox" name="tablenames" value="${bean.tablename }_sp_${bean.collecttime }" />
									<html:link href="javascript:showHistory('${bean.tablename }_sp_${bean.collecttime }');">
										${bean.showtime }
									</html:link>
								</td>
							</tr>
						</table>
					</logic:iterate>
				</div>
			</div>
			<div style="float:right;width:800px;height:480px;border:#a2cbf3 1px solid;margin-right:10px;margin-top:2px;">
					<div>
						<div style="margin-left:50px;margin-top:10px;">
							<span><b>名称：</b> </span>
						</div>
						<div style="margin-left:50px;margin-top:10px;">
							<span><b>配置类别：</b></span>
							<select id="category" name="category" style="width:150px;" onchange="changeCategory(this.value);">
								<option value=""></option>
								<logic:present name="IGCIM01101VO" property="categorys">
									<logic:iterate id="cbean" name="IGCIM01101VO" property="categorys">
										<option value="${cbean.key }">${cbean.key }</option>
										<script>
											var temp = new Array();
											<logic:present name="cbean" property="value">
											<bean:define id="ckeys" name="cbean" property="value"/>
											<logic:iterate id="key" name="ckeys">
												temp[temp.length] = '${key}';
											</logic:iterate>
											</logic:present>
											categorys["${cbean.key}"] = temp;
										</script>
									</logic:iterate>
								</logic:present>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span><b>关键字：</b></span>
							<select name="keys" id="keys" style="width:150px;" onchange="changeKeys(this.value);">
								<option value=""></option>
							</select>
						</div>
						<table class="table_style" style="width:750px;margin-top:15px;">
							<tr>
								<th width="15%" style="border-left:#d3d3d3 1px solid;">配置类别</th>
								<th width="15%" style="border-left:#d3d3d3 1px solid;">关键字</th>
								<th width="20%" style="border-left:#d3d3d3 1px solid;">采集命令</th>
								<th width="50%" style="border-left:#d3d3d3 1px solid;border-right:#d3d3d3 1px solid;">采集结果</th>
							</tr>
						</table>
					</div>
				<logic:present name="IGCIM01101VO" property="dataMap">
					<div style="height:400px;overflow-y:scroll;overflow-x:hidden;" id="datadiv">
						<table id="datatable" class="table_style" style="width:750px;margin-left:25px;">
							<logic:iterate id="map" name="IGCIM01101VO" property="dataMap">
							<bean:define id="cmap" name="map" property="value"/>
							<bean:size id="csize" name="cmap"/>
							<logic:iterate id="bean" name="cmap" indexId="index">
								<tr>
									<c:if test="${index==0 }">
										<td width="15%" rowspan="${csize }" align="left" valign="top">${map.key }</td>
									</c:if>
									<td width="15%" align="left" valign="top">${bean.value.keys }</td>
									<td width="20%" align="left" valign="top">${bean.key }</td>
									<td width="50%" align="left" valign="top"><pre>${bean.value.cdata }</pre></td>
								</tr>
							</logic:iterate>
							</logic:iterate>
						</table>
					</div>
				</logic:present>
			</div>
		</logic:present>
		</logic:present>
		<ig:message/>
		<html:hidden name="IGCIM0110Form" property="eiid"/>
	</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>

