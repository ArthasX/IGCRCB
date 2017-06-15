<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0111" toScope="request" />
<bean:define id="title" value="配置原数据页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var categorys = new Array();
var data;
var tempdata;
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
			if(tb.rows[i].cells.length==5&&tb.rows[i].cells[0].innerHTML.indexOf(val)<0){
				var rowLength = tb.rows[i].cells[0].rowSpan;
				for(var num=0;num<rowLength;num++){
					tb.deleteRow(i);
				}
				flag = true;
				break;
			}
		}else{
			if(tb.rows[i].cells.length==5){
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

/**
* 版本比较弹出画面
* @param eiid 资产ID
*/
function openCollectCommandDetail(keys,tablenames,host,type,ip,servername){
	//alert("-----"+keys+"=====-----"+tablenames+"====="+host+"-----");
	//alert(document.getElementById(""+keys).value); 
	var keyValue=document.getElementById(""+keys).value; 
	openSubWindow('/IGCIM0114_Search.do?keys='+keyValue+'&tablenames='+tablenames+'&host='+host+'&type='+type+'&ip='+ip+'&servername='+servername, '_blank', window.screen.width,window.screen.height);
	//openSubWindow('/IGCIM0112_Search.do?keys=' + keys + '&screenWidth='+window.screen.width, 'eiversion',window.screen.width,window.screen.height);
}
</script>
<style type="text/css">
	#datatable tr td{
		border-left:#d3d3d3 1px solid;
		border-right:#d3d3d3 1px solid;
	}
</style>
<body onload="initBody();">
<div id="maincontent">
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
    	<div class="image"></div>
        <p class="fonts1">配置原数据版本比较</p>
    </div>  
    <html:form styleId="form" action="/IGCIM0111_Disp.do">
		<logic:present name="IGCIM01111VO" property="data">
			<div class="title">
				<div class="name">配置原数据</div>
			</div>
			<div>
				<table cellspacing="2" class="table_style1" style="margin-left:10px;">
					<tr>
						<th width="13%">设备标识：</th>
						<td width="20%">${IGCIM01111VO.host }</td>
						<th width="13%">配置类别：</th>
						<td width="20%">
							<select id="category" name="category" style="width:150px;" onchange="changeCategory(this.value);">
								<option value=""></option>
								<logic:present name="IGCIM01111VO" property="categorys">
									<logic:iterate id="cbean" name="IGCIM01111VO" property="categorys">
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
						</td>
						<th width="13%">关键字：</th>
						<td width="20%">
							<select name="keys" id="keys" style="width:150px;" onchange="changeKeys(this.value);">
								<option value=""></option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div style="margin-top:20px;">
				<logic:present name="IGCIM01111VO" property="titleList">
					<div>
						<table class="table_style" style="width:960px;margin-left:13px;">
							<tr>
								<logic:iterate id="bean" name="IGCIM01111VO" property="titleList">
									<th width="20%" style="border-left:#d3d3d3 1px solid;border-right:#d3d3d3 1px solid;">
									${bean }
									</th>
								</logic:iterate>
							</tr>
						</table>
					</div>
					<div style="height:400px;overflow-y:scroll;overflow-x:hidden;" id="datadiv">
						<table class="table_style" style="width:960px;margin-left:13px;" id="datatable">
						<logic:iterate id="map" name="IGCIM01111VO" property="data">
							<bean:define id="list" name="map" property="value"/>
							<bean:size id="listsize" name="list"/>
							<logic:iterate id="bean" name="list" indexId="index">
								<tr>
									<c:if test="${index==0 }">
									<td width="20%" align="left" rowspan="${listsize }">
									<pre>${map.key }</pre>
									</td>
									</c:if>
									<td width="20%" align="left" >
									<pre>${bean.keys }</pre>
									</td>
									<td width="20%" align="left" >
									<a  href="javascript:void(0)" onclick="openCollectCommandDetail('${index}','${IGCIM0111Form.tablenames }','${IGCIM0111Form.host }','${IGCIM0111Form.type}','${IGCIM0111Form.ip}','${IGCIM0111Form.servername}')">
									${bean.command }
									</a>
									<input type="hidden" id="${index}" value="${bean.command }"/>
									</td>
									<td width="20%" align="left">
									<div style="width:190px;">
									<pre>${bean.compare1 }</pre>
									</div>
									</td>
									<td width="20%" align="left" style="${bean.compareStyle}">
									<div style="width:190px;">
									<pre>${bean.compare2 }</pre>
									</div>
									</td>
								</tr>
							</logic:iterate>
						</logic:iterate>
						</table>
					</div>
				</logic:present>
			</div>
		</logic:present>
		<div class="enter">
			<html:button property="close" value="关闭" styleClass="button" onclick="window.close();"/>
		</div>
    </html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>

