<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGWKM0104" toScope="request" />
<bean:define id="title" value="风险点查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

var formFileArr = new Array();
var assetFormArr = new Array();

function setParentValue(eiid,einame,riskitem,poss,levels,grad,eiversion){
       if(!window.opener.closed){
           window.opener.setParams2(eiid,einame,riskitem,poss,levels,grad,eiversion);
        }
       window.close();
}
function clearParentValue(){
       if(!window.opener.closed){
           window.opener.setParams("", "", "", "", "","");
        }
       window.close();
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
<html:form action="/IGPRR0102" styleId="form" onsubmit="return checkSubmit(this);">
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1">风险点查询画面</p>
    </div>
    <div id="search">

	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">选择</th>
			<th width="10%">风险点名称</th>
			<th width="10%">风险点分类</th>
			<th width="10%">风险严重情况</th>
			<th width="10%">风险发生可能性</th>
			<th width="10%">风险级别</th>
		</tr>
		<logic:present name="IGPRR01021VO" property="listPointVMs">
			<logic:iterate id="map" name="IGPRR01021VO" property="listPointVMs"
				indexId="index">
				<tr>
					<td>
						<img src="images/select_asset.gif" border="0" alt="选择" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="setParentValue('${map.eiid}','${map.einame}','${map.riskitem}','${map.levels}','${map.poss}','${map.grad}','${map.eiversion}')"/>
					</td>
					<td><bean:write name="map" property="einame" /></td>
					<td><bean:write name="map" property="riskitem" /></td>
					<td><bean:write name="map" property="levels" /></td>
					<td><bean:write name="map" property="poss" /></td>
					<td><bean:write name="map" property="grad" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
		
	</table>
	
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	</div>	
	</html:form>
</div>
</div>
</body>
</html:html>








