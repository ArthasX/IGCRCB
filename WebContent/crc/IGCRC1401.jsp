<%@page import="com.deliverik.infogovernor.wkm.form.IGWKM0101Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGCRC1401" toScope="request" />
<bean:define id="title" value="变更查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
WebCalendar.timeShow   = true;          //是否返回时间
	 function setTree(obj){
		var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid="+obj,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.getElementById("tree_show_value").value = "";
			document.getElementById("tree_value").value = "";
		}else if(null!=temp && temp.split("|").length>1){
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
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
				if(110==obj){
				
				document.getElementById("tree_show_value").value = name.split("-")[name.split("-").length-1];
				document.getElementById("tree_value").value =treesyscode + "_tree_" + name;
				}else{
					
				document.getElementById("tree_show_value2").value = name;
				}
			}else{
				if(110==obj){
					
				document.getElementById("tree_show_value").value = "";
				document.getElementById("tree_value").value = "";
				}else{
					
				document.getElementById("tree_show_value2").value = "";
				}
			}
		}		
	}
	function init(){
		/* var changetype = '${IGCRC1401Form.changetype}';
		jQuery("#tree_show_value").val(changetype); */
		
		var flag = document.getElementById("showFlag").value;
		if(flag==1){
			onShow();	
		}
		else{
			onHidden();
		} 
		sortDeal();
	}


	function onShow(){
		document.getElementById("showFlag").value = 1;
		jQuery(".hideContext").show();
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	
	function onHidden(){
		document.getElementById("showFlag").value = 0;
		jQuery(".hideContext").hide();
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	function onExcel(){
		form.action = "IGCRC1401_EXCEL.do";
		form.submit();
	}
	function onSubmit(){
		form.action = "IGCRC1401_SEARCH.do";
		form.submit();
	}
	
	function sortDeal(){
		var obj = document.getElementById("table_list");
		for(var i=1;i<obj.rows.length;i++){
			var cell_sort = obj.rows[i].cells[4];
			var value = cell_sort.innerHTML;
			cell_sort.innerHTML = "<a href=\"javascript:void(0)\" style=\"text-decoration:none;color:#000000;\" title=\""+value+"\">"+value.split("-")[value.split("-").length-1]+"</a>";
		}
	}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC1401_SEARCH" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
		<label id="label_img" style="margin-left:736px;margin-top:-1px;">
    		<img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0"/>
   	    </label>
	</div>
	<div>
		<span class="subscribe">工单号：</span>
		<html:text property="prserialnum" size="12" />
		<span class="subscribe">变更名称：</span>
		<html:text property="prtitle"/>
		<span class="subscribe">变更类型：</span>
		<html:text property="changetype" styleId="tree_show_value" readonly="readonly"/>
		<input type="hidden" name="varnames" id="tree_name" value="变更类型"/>
		<input type="hidden" name="varvalues" id="tree_value" />
		<img src="images/seek.gif" alt="查询" onclick="setTree(110);" style="cursor: hand"/>
		<span class="subscribe">处理人：</span>
		<html:text  property="ppusername_like"  style="width:90px" size="100"/> 
		<html:button property="btn_search" value="查询" onclick="onSubmit();" styleClass="button"/>
		<html:hidden property="selectstatus" name="selectstatus" value="1"/>
    </div>
    <div style="margin-top:8px;"> 
    	<span class="subscribe">工单状态：</span>
			<html:select property="prstatus">
	    		<html:options collection="statusBeanList" property="value" labelProperty="label"/>
	    	</html:select>
		<span class="subscribe">变更类别：</span>
			<html:select property="changecategory">
				<html:option value=""></html:option>
				<html:option value="常规变更">常规变更</html:option>
				<html:option value="紧急变更">紧急变更</html:option>
				<html:option value="快速变更">紧急变更</html:option>
	    	</html:select>
		<span class="subscribe">发起时间：</span>
		<html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
		&nbsp;
		<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
		<span>&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;</span>
		<html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
		<input type="button" value="导出" class="button" onclick="onExcel()">
	</div>
	<div style="margin-top:8px;" class="hideContext">
		<span class="subscribe">业务影响范围：</span>
		<html:select property="businessscope">
				<html:option value=""></html:option>
				<html:option value="无">无</html:option>
				<html:option value="全行所有业务">全行所有业务</html:option>
				<html:option value="全行部分业务">全行部分业务</html:option>
				<html:option value="部分分行业务">部分分行业务</html:option>
				<html:option value="大量客户信息">大量客户信息</html:option>
				<html:option value="部分客户信息">部分客户信息</html:option>
				<html:option value="单个客户信息">单个客户信息</html:option>
	    </html:select>
		<span class="subscribe">变更原因：</span>
		<html:text  property="changereason"/> 
		<span class="subscribe">是否影响业务：</span>
		<html:select property="isinfluence">
				<html:option value=""></html:option>
				<html:option value="是">是</html:option>
				<html:option value="否">否</html:option>
		</html:select>
		<span class="subscribe">变更分类：</span>
		<html:select property="changeclassify">
				<html:option value=""></html:option>
				<html:option value="新增需求">新增需求</html:option>
				<html:option value="需求变更">需求变更</html:option>
				<html:option value="项目上线">项目上线</html:option>
				<html:option value="系统优化">系统优化</html:option>
				<html:option value="项目配合">项目配合</html:option>
				<html:option value="bug修复">bug修复</html:option>
		</html:select>
	</div>	
	<div style="margin-top:8px;" class="hideContext">
		<span class="subscribe">更新平台：</span>
		<html:text  property="updateplatform"  style="width:90px" size="100"/> 
		<span class="subscribe">变更内容：</span>
		<html:text  property="changecontent"/> 
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="table_list" class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="8%"><a href="#">工单号</a></th>
			<th width="18%"><a href="#">变更名称</a></th>
			<th width="8%"><a href="#">变更类型</a></th>
			
			<th width="8%"><a href="#">变更分类</a></th>
			<th width="8%"><a href="#">更新平台</a></th>
			<th width="8%"><a href="#">发起人</a></th>
			
			<th width="12%">当前处理人</th>
			<th width="8%"><a href="#">工单状态</a></th>
			<th width="10%"><a href="#">发起时间</a></th>
			<th width="12%"><a href="#">关闭时间</a></th>
		</tr>
		<logic:present name="IGCRC14011VO" property="igcrc14012vos">
			<logic:iterate id="bean" name="IGCRC14011VO" property="igcrc14012vos"
				indexId="index">
				<tr style='cursor:hand' onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
				onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=475');">
					<td>
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td>
						<bean:write name="bean" property="prtitle" />
					</td>
					<td>
						${bean.changetype}
					</td>
					<td>	
						${bean.changeclassify}
					</td>
					<td title="${bean.updateplatform}">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							${bean.updateplatform}
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td>${bean.prusername}
					</td>
					<bean:define id="participant">
					<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }"/>&nbsp;
					</bean:define>
					<td title="${participant }">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							${participant }
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td>	
						${bean.orderstatus}
					</td>
					<td>
						<bean:write name="bean" property="propentime" />
					</td>
					<td>
						<bean:write name="bean" property="prclosetime" />
					</td>
					</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}" > 
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
