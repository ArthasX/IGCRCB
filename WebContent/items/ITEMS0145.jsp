<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>

<html:html>
<bean:define id="id" value="ITEMS0145" toScope="request" />
<bean:define id="title" value="下拨物品画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	
	function operation(name,id,selectorg){
	
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0145.do";
			document.forms[0].submit();
			
		}else if(name=="read"){
			document.forms[0].sid.value=id;
			document.forms[0].action=getAppRootUrl() + "/ITEMS0145_READ.do";
			document.forms[0].submit();

		}else if(name=="allocate"){
			document.forms[0].sid.value=id;
			document.forms[0].selectorg.value=selectorg;
			document.forms[0].action=getAppRootUrl() + "/ITEMS0145_ALLOCATE.do";
			document.forms[0].submit();

		}
	}
   
	
	

	
//-->
	</script>
<body">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0145_Disp">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<input type="hidden" name="sid" >
	<html:hidden property="selectorg" />
<span>物品种类：</span><span><html:select property="category" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="category_options" property="value" name="" labelProperty="label" />
</html:select></span>&nbsp;&nbsp; 
<span>物品编号：</span><span><html:text property="seqcode" styleId="seqcode" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  /></span>&nbsp;&nbsp;
<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>
</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	
		<table class="table_style">
			<tr>
				
				<th width="10%">物品种类</th>
				<th width="10%">物品编号</th>
				<th width="30%">物品名称</th>
				<th width="15%">物品型号</th>
				<th width="10%">库存数量</th>
				<th width="5%">查看</th>
				<th width="10%">下拨支行</th>
				<!-- <th width="10%">下拨总行</th>
				<th width="10%">下拨全部</th> -->
			</tr>
			<logic:present name="ITEMS01081VO" property="stockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="stockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						
						<td>${bean.seqcode}</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.typecode}</td>
						
						<td>${bean.stocknum}</td>
						
						<td>
							<a href="javascript:operation('read','${bean.stockid}');" >
							<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0"/></a>					
						</td>
						<td>
							<a href="javascript:operation('allocate','${bean.stockid}','<%=DefineUtils.XB_TYPE_ZHIH %>');" >
							<img src="images/apply.gif" alt="下拨支行" width="16" height="16" border="0"/></a>					
						</td>
						<!-- <td>
							<a href="javascript:operation('allocate','${bean.stockid}','<%=DefineUtils.XB_TYPE_ZONGH %>');" >
							<img src="images/apply.gif" alt="下拨总行" width="16" height="16" border="0"/></a>					
						</td>
						<td>
							<a href="javascript:operation('allocate','${bean.stockid}','<%=DefineUtils.XB_TYPE_QB %>');" >
							<img src="images/apply.gif" alt="下拨全部" width="16" height="16" border="0"/></a>					
						</td>-->
					</tr>
				</logic:iterate>
			</logic:present>
	</table>

	
	
	
	</div>
	<div id="operate">
	<div class="operate_btn">
	 <!-- paging --> <jsp:include page="/include/paging.jsp" /></div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>