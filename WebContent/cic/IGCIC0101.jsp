<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html:html>
<bean:define id="id" value="IGCIC0101" toScope="request" />
<bean:define id="title" value="对比规则查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style type="text/css">
 .conditions span,select{
 	vertical-align: middle;
 }
 a img{
 	border: 0px;
 	margin-left: 20px;
 	margin-right:5px;
 	vertical-align: middle;
 }
</style>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCIC0101" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>业务系统名称：&nbsp;&nbsp;</span>
		<html:select property="crsystemid" style="width:150px;" styleId ="crsystemid">
			<html:option value=""></html:option>
			<html:optionsCollection name="IGCIC01011VO" property="systemList" label="einame" value="eiid"/>
		</html:select>
	<span>&nbsp;&nbsp;对比规则：</span>
			<html:select property="crtype" style="width:150px;" styleId="crtype"  >
				<ig:optionsCollection ccid="COMPARE_TYPE" />
			</html:select>
	<html:submit styleClass="button" value="查询" />
	&nbsp;&nbsp;
	<html:button styleClass="button" property="btn_add" styleId="addRole">新建规则</html:button>
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="35%">业务系统名称</th>
			<th width="35%">规则类型</th>
			
			<th width="30%">操作</th>
			
		</tr>
		<logic:present name="IGCIC01011VO" property="crList">
			<logic:iterate id="bean" name="IGCIC01011VO" property="crList"
				indexId="index">
				<tr>
					<td>${bean.crsystemname }</td>
					<td><ig:codeValue ccid="COMPARE_TYPE" cid="${bean.crtype }"/> </td>
					<td>
						<span><a href="IGCIC0102_Disp.do?crid=${bean.crid }"><img alt="修改" src="images/edit.gif" />修改</a></span>
						<span><a href="javascript:;" onclick="doDel('${bean.crid}')"><img alt="删除" src="images/delete_16x16.gif"/>删除</a></span>
					</td>
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
<script>
	jQuery(function(){
		//添加按钮绑定事件
		jQuery("#addRole").click(function(){
			window.location.href="IGCIC0102_Disp.do";
		});
		var flag = '${flagurl}';
		if(flag){
			jQuery("#crsystemid,#crtype").val('');
		}
	})
	function doDel(crid){
		if(confirm("确定删除该条规则?")){
			document.forms[0].action= getAppRootUrl()+"/IGCIC0101_Del.do?crid="+crid;
			document.forms[0].submit();
		}
	}
</script>
</html:html>
