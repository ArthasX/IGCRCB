<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0523" toScope="request" />
<bean:define id="title" value="食堂物品消耗明细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
        

	function checkSearch(){
		
		if(Number($F('month_from')) > Number($F('month_to'))){
			alert("结束月份不能大于开始月份！");
			return false;
		}else{
			document.forms[0].action = getAppRootUrl() + "/IGLOM0513.do";
			document.forms[0].submit();
		}
	}
	function exportExcel() {
		
		if(Number($F('month_from')) > Number($F('month_to'))){
			alert("结束月份不能大于开始月份！");
			return false;
		}else{
			document.forms[0].action = getAppRootUrl() + "/IGLOM0513.do?report=1";
			document.forms[0].submit();
		}
	
	}
	

	
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0513"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 物品消耗明细</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">&nbsp;&nbsp;&nbsp;&nbsp;<span class="red">*</span>年度：
	<html:select property="year" name="IGLOM0513Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select>&nbsp;&nbsp; <span>从</span> <html:select property="month_from"
		name="IGLOM0513Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select><span>月&nbsp;&nbsp; 到</span> <html:select property="month_to"
		name="IGLOM0513Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select> 
	<label>月&nbsp;&nbsp;领用人</label> <html:text property="guser" readonly="false"/>
		 &nbsp;&nbsp;
	 <label for="Name">消耗类型：</label>
		<span> 
			<html:select property="useType" style="width: 100px;" errorStyleClass="inputError imeActive" >
			<html:options collection="gout_consume" property="value" name="" labelProperty="label" /></html:select>
		</span>&nbsp;&nbsp;
		 
		<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkSearch();" /> 
		<html:button property="btn_search" value="导出" styleClass="button" onclick="exportExcel();" /></div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			
			<th width="5%">序号</th>
			<th width="5%">领用人</th>
			<th width="8%">领取物品编号</th>
			<th width="8%">领取物品名称</th>
			<th width="5%">出库数量</th>
			<th width="10%">出库时间</th>
			<th width="15%">接待工作名称</th>
			<th width="8%">消耗类型</th>
			
		</tr>
		<!-- body部 -->
	 <logic:present name="IGLOM05081VO" property="goutDetailInfoList" >
	     <logic:iterate id="bean" name="IGLOM05081VO" property="goutDetailInfoList" indexId="index">
			   <tr class="<ig:rowcss index="${index}"/>">
			      <td><div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div></td>
			           <!-- 领用人-->
			           <td> <div class="nowrapDiv">${bean.gorequsername}</div></td>
			           <td> <div class="nowrapDiv">${bean.gocode}</div></td>
			           <td> <div class="nowrapDiv">${bean.goname}</div></td>
			           <td> <div class="nowrapDiv">${bean.goinnum}</div></td>
			           <td> <div class="nowrapDiv">${bean.gotime}</div></td>
			           <td> <div class="nowrapDiv">${bean.rname}</div></td>
			           <logic:equal name="bean" property="rid" value="0">
			               <td> <div class="nowrapDiv">普通消耗</div></td>              
                       </logic:equal>   
                       <logic:notEqual name="bean" property="rid" value="0">
			               <td> <div class="nowrapDiv">招待消耗</div></td>              
                      </logic:notEqual>           
			    </tr>
			  </logic:iterate>
		</logic:present>
	</table>
	</div>
<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>

</div>

</div>
</body>
</html:html>