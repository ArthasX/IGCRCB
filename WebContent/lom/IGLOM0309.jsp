<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0309" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	
	function exportExcel() {
		
			document.forms[0].action = getAppRootUrl() + "/IGLOM0309.do?report=1";
			document.forms[0].submit();
	
	}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0309"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 预支月度统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
				         
		          
	<div>       &nbsp;&nbsp;&nbsp;&nbsp;
			<span class="red">*</span>年度：
	        	 <html:select property="year"  name="IGLOM0309Form" styleId="year">
						<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
				 </html:select>&nbsp;&nbsp;

	<html:submit property="btn_search" styleClass="button" value="查询"  />
	<html:button property="btn_search1" styleClass="button" value="导出"  onclick="exportExcel()"/>
	</div>
	</div>
	</div>
	
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="8%">月份</th>
			<th width="10%">月初余额</th>
			<th width="10%">本月预支金额</th>
			<th width="10%">本月发票金额</th>
			<th width="10%">未还借款</th>
			<th width="10%">本月余额</th>
		</tr>
	
		<logic:present name="IGLOM0309VO" property="summaryList" >
		 <logic:iterate id="bean" name="IGLOM0309VO" property="summaryList" indexId="index">
			                        <tr> 
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="asyear">&nbsp;</logic:empty>
			                                ${bean.asmonth}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="asprebalance">&nbsp;</logic:empty>
			                                ${bean.asprebalance}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="asadvancescost">&nbsp;</logic:empty>
			                                ${bean.asadvancescost}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="asinvoice">&nbsp;</logic:empty>
			                                ${bean.asinvoice}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="asloan">&nbsp;</logic:empty>
			                                ${bean.asloan}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="asbalance">&nbsp;</logic:empty>
			                                ${bean.asbalance}
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
	</table>
	</div>
</html:form>

</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>