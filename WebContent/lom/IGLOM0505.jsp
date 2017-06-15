<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.LOMHelper" %>
<html:html>
<bean:define id="id" value="IGLOM0505" toScope="request" />
<bean:define id="title" value="工作餐收益统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function changeSearchType(){
		if($F('searchtype')=="M"){
			//document.getElementById('quarter').value="0";
			//document.getElementById('quarter').disabled=true;
			//document.getElementById('month').disabled=false;
			document.getElementById('quarter').value="";
			document.getElementById("q").style.display="none";
			document.getElementById("m").style.display="";
		} else if($F('searchtype')=="Q"){
			document.getElementById('m').value="0";
			document.getElementById("m").style.display="none";
			document.getElementById("q").style.display="";
		} else if($F('searchtype')=="Y"){
			document.getElementById('m').value="";
			document.getElementById('quarter').value="";
			document.getElementById("m").style.display="none";
			document.getElementById("q").style.display="none";
		}
		
	}

	function confirmDisp(){
		return true;
	}

	function checkNum(obj){
    	if(isNaN(obj.value)){
    		alert("请输入数字！");
    		obj.value = "";
    		return;
    	}
    }

	function checkYear(obj){
    	if($F('year').length!=0 && $F('year').trim().length!=4 ){
			alert("请输入4位数字！");
			obj.value = "";
			return false;
		}
    }

	function checkMonth(obj){
    	if($F('month').length!=0 && ($F('month').trim().length>2 || $F('month').trim().length<1)){
			alert("请输入1~2位数字！");
			obj.value = "";
			return false;
		}
    }
	
	function exportExcel() {
		form.action = getAppRootUrl() + "/IGLOM0505_Report.do";
		form.submit();
		form.action = getAppRootUrl() + "/IGLOM0505.do";
	}
</script>
<body onload="changeSearchType();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0505"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 工作餐收益统计 
	<logic:equal name="IGLOM0505Form" property="searchtype" value="D">
    	&gt;&gt; 工作餐明细查询
    </logic:equal>
    </p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>查询类型：</span>
	<html:select property="searchtype" style="width: 100px;" onchange="changeSearchType(this);">
        <html:option value="M">按月份查询</html:option>
        <html:option value="Q">按季度查询</html:option>
        <html:option value="Y">按年份查询</html:option>
    </html:select>&nbsp;&nbsp;
    
    <label for='Name'>年：</label> 
	<html:select property="year"  name="IGLOM0505Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
	
	<span id="m" style="display:">
    <label for='Name'>月：</label> 
    <html:select property="month"  name="IGLOM0505Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
	</span>
    <span id="q" style="display:">
    	季度：
		<html:select property="quarter" styleId='quarter' style="width: 80px;">
			<html:option value=""></html:option>
	        <html:option value="1">1季度</html:option>
	        <html:option value="2">2季度</html:option>
	        <html:option value="3">3季度</html:option>
	        <html:option value="4">4季度</html:option>
	    </html:select>
    </span>
   
    
	
	<html:submit property="btn_search" styleClass="button" value="查询" />
	<html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="9%">时间</th>
			<th width="9%">原料成本</th>
			<th width="9%">酒成本</th>
			<th width="9%">其他成本</th>
			<th width="9%">成本合计</th>
			<th width="10%">餐卡数量</th>
			<th width="10%">收益合计</th>
			<th width="10%">损益合计</th>
			<th width="15%">查看明细</th>
			
		</tr>
		<logic:present name="IGLOM05051VO" property="map">
		<logic:iterate id="bean" name="IGLOM05051VO" property="map" indexId="index">
			<bean:define id="keycode" name="bean" property="key" type="java.lang.String"/>
			<bean:define id="valuevo" name="bean" property="value"/>
	          <logic:iterate id="list" name="valuevo" property="workLunchEateryList" indexId="index">
              <tr>  
	              <td><bean:write name="list" property="wldate" /></td>
	                 
	              <td><bean:write name="list" property="estaplecost" /></td>
				  
				  <td><bean:write name="list" property="eflavouringcost" /></td>
	                 
	              <td><bean:write name="list" property="eothercost" /></td>
				  
				  <td><bean:write name="list" property="allcost" /></td>
				  
				  
				  <td><bean:write name="list" property="lunchcardnum" /></td>
				  
				  <td><bean:write name="list" property="incost" /></td>
				  
				  <td><bean:write name="list" property="outcost" /></td>
				  
				  <c:if test="${index == '0'}">
				  	<logic:equal name="IGLOM0505Form" property="searchtype" value="M">
				  	<td>
					  	<html:link action="IGLOM0505_POP.do?edate=${list.wldate}">
							<img src="images/xx.gif" width="16" height="16" border="0"/>
						</html:link>	
					</td>
					</logic:equal>
					<logic:notEqual name="IGLOM0505Form" property="searchtype" value="M">
				  	<td>
					</td>
					</logic:notEqual>
				  </c:if>
				  <c:if test="${index != '0'}">
				  	<td>
					</td>
				  </c:if>
			  </tr>	
              </logic:iterate>
            
        </logic:iterate>
        </logic:present>
	</table>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>