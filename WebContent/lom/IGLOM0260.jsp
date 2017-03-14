<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<%@ page import="com.csebank.common.OrgValueBean"%>
<%@ page import="com.csebank.lom.util.LOMHelper" %>
<%@ page import="java.math.BigDecimal" %>

<html:html>
<bean:define id="id" value="IGLOM0260" toScope="request" />
<bean:define id="title" value="已领用物品信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function operation(name){
		document.forms[0].action=getAppRootUrl() + "/IGLOM0260.do";
	 	document.forms[0].submit();
	}

//-->
	</script>

   <body>

<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>

<logic:equal name="IGLOM0203Form" property="lomid" value="lom0103">
 	<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待工作管理 &gt;&gt; 领用物品信息</p>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0107">
	<p class="fonts1">后勤管理 &gt;&gt; 就餐管理 &gt;&gt; 外出就餐管理 &gt;&gt; 领用物品信息</p>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0111">
 	<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待月度汇总 &gt;&gt; 接待工作明细 &gt;&gt; 领用物品信息</p>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0113">
 	<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 部门接待汇总 &gt;&gt; 接待工作明细  &gt;&gt; 领用物品信息</p>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0114">
 	<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待客人查询 &gt;&gt; 领用物品信息</p>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0118">
	<p class="fonts1">后勤管理 &gt;&gt; 就餐管理 &gt;&gt; 外餐月度汇总 &gt;&gt; 外出就餐明细 &gt;&gt; 领用物品信息</p>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0121">
	<p class="fonts1">后勤管理 &gt;&gt; 就餐管理 &gt;&gt; 部门外餐汇总 &gt;&gt; 外出就餐明细 &gt;&gt; 领用物品信息</p>
</logic:equal>

<logic:equal name="IGLOM0203Form" property="lomid" value="lom0103">
<div class="back"><a href="IGLOM0103_Back.do" target="_self">返回</a></div>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0118">
<div class="back"><a href="IGLOM0118_Back.do" target="_self">返回</a></div>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0107">
<div class="back"><a href="IGLOM0107_Back.do" target="_self">返回</a></div>
</logic:equal>

<logic:equal name="IGLOM0203Form" property="lomid" value="lom0111">
<div class="back"><a href="IGLOM0111_Back.do" target="_self">返回</a></div>
</logic:equal>

<logic:equal name="IGLOM0203Form" property="lomid" value="lom0113">
<div class="back"><a href="IGLOM0113_Back.do" target="_self">返回</a></div>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0121">
<div class="back"><a href="IGLOM0121_Back.do" target="_self">返回</a></div>
</logic:equal>
<logic:equal name="IGLOM0203Form" property="lomid" value="lom0114">
<div class="back"><a href="IGLOM0114_Back.do" target="_self">返回</a></div>
</logic:equal>
</div>
<html:form styleId="form" action="/IGLOM0260" onsubmit="return checkSubmit(this);">
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">序号</th>
				<th width="15%">物品编号</th>
				<th width="15%">物品名称</th>
				<th width="20%">物品种类</th>
				<th width="10%">单价</th>
				<th width="15%">已领用数量</th>
				<th width="15%">领用合计</th>
			</tr>
			<logic:present name="IGLOM02051VO" property="goutstockTBList">
				<logic:iterate id="bean" name="IGLOM02051VO" property="goutstockTBList" indexId="index">
                    <bean:define id="price"  name="bean" property="gooutprice" type="java.math.BigDecimal"></bean:define>
				    <bean:define id="num"  name="bean" property="goinnum"></bean:define>
					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<div class="nowrapDiv">${1+index}
							</div>
						</td>
						<td>${bean.gocode}</td>
						
						<td>${bean.goname}</td>

						<td>
							<ig:projectTypeValue ptype="${bean.gocategory}" />
						</td>
						<td><%=LOMHelper.round(String.valueOf(LOMHelper.getDivide(price,new BigDecimal(String.valueOf(num)))),2)%></td>
						<td>${bean.goinnum}</td>
						<td>${bean.gooutprice}</td>
						
					</tr>
				</logic:iterate>
			</logic:present>
			
	</table>
	</div>
	
		<logic:equal name="IGLOM0203Form" property="rstatus" value="1">
		<div id="operate">
		<div class="operate_btn">
		<span> 
		<logic:equal name="IGLOM0203Form" property="lomid" value="lom0107">
           <html:button property="btn_add" value="物品领用" styleClass="button" onclick="operation('lom0107')"  />
        </logic:equal>
		<logic:equal name="IGLOM0203Form" property="lomid" value="lom0103">
           <html:button property="btn_add" value="物品领用" styleClass="button" onclick="operation('lom0103')"  />
        </logic:equal>	

		</span>
		</div>
		</div>
		</logic:equal>
	
	<bean:define id="orgsyscode" name="IGLOM0203Form" property="goorg"></bean:define>
	<html:hidden property="rid"/>
	<html:hidden property="goorg"/>
	<html:hidden property="goorgname" value="<%=OrgValueBean.getConfigInfo(String.valueOf(orgsyscode))%>"/>
</html:form>
</div>

<div class="zishiying"></div>
</div>

</div>
</div>
</body>
</html:html>