<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0103" toScope="request" />
<bean:define id="title" value="预算详细显示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

function deleteFin(){
	if(confirm("请确认是否删除预算?")){
		return true;
	}
	return false;
}

function closeFin(){
	if(confirm("请确认是否关闭预算?")){
		return true;
	}
	return false;
}


</script>


<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back"><a href="IGFIN0102_BACK.do" target="_self">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<bean:define id="bean1" name="IGFIN01021VO" property="budgetData" type="com.deliverik.infogovernor.fin.model.Budget" ></bean:define>
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">
			预算编号：
			</th>
			<td width="35%">${IGFIN01021VO.budgetData.bid}</td>
			<th width="15%" align="right">
			项目类别：
			</th>
			<td width="35%">
			<ig:codeValue ccid="BUDGET_TYPE_CATEGORY_CODE" cid= "${IGFIN01021VO.budgetData.btype}" isChild="true"/>
			</td>
		</tr>
		<tr>
			<th align="right">
			项目名称：
			</th>
			<td>${IGFIN01021VO.budgetData.btitle}</td>
			<th align="right">
			项目性质：
			</th>
			<td width="35%">
			<ig:codeValue ccid="BUDGET_QUALITY_CODE" cid= "${IGFIN01021VO.budgetData.pquality}" isChild="true"/>
			</td>
		</tr>
		<tr>
				<th align="right">
				储备项目编号：
				</th>
				<td>${IGFIN01021VO.budgetData.pstorecode}</td>
				<th align="right">
				需求部门：
				</th>
				<td width="35%">
				<ig:codeValue ccid="BUDGET_NEED_DISPART_CODE" cid= "${IGFIN01021VO.budgetData.pneeddispart}" isChild="true"/>
				</td>
		</tr>
		<tr>
			<th align="right">
			预算组成：
			</th>
			<td width="35%">
			<ig:codeValue ccid="BUDGET_BUGGET_FORM_CODE" cid= "${IGFIN01021VO.budgetData.pbuggetform}" isChild="true"/>
			</td>
			<th align="right">
			预算用途：
			</th>
			<td width="35%">
			<ig:codeValue ccid="BUDGET_USE_CODE" cid= "${IGFIN01021VO.budgetData.puse}" isChild="true"/>
			</td>
		</tr>
		  <th align="right">
			预算年份：
			</th>
		  <td>${IGFIN01021VO.budgetData.byear}</td>
		  <th align="right">
			项目预算（元）：
			</th>
		<tr>	
		  <td><bean:write name="bean1" property="bamount" format="##.##"/>
		 </td>
		</tr>
		<tr>
		  <th align="right">
			项目简介：
			</th>
		  <td colspan="3"><pre>${IGFIN01021VO.budgetData.bdesc}</pre></td>
		</tr>
	</table>
	</div>
<div class="title">
	<div class="name"></div>
	</div>
	<div class="record_list">
		<logic:notEqual name="IGFIN01021VO" property="bstatus" value="C">
			<div class="action">
             	<img src="images/nono.gif" width="16" height="16" /><a href="IGFIN0104_Disp.do?bid=${IGFIN01021VO.budgetData.bid}" onclick="return closeFin();">关闭</a></div>
				
		</logic:notEqual>
         
          <div class="action">
             <img src="images/deldata.gif" width="16" height="16" />
             <a href="IGFIN0105_Disp.do?bid=${IGFIN01021VO.budgetData.bid}" onclick="return deleteFin();">删除</a>
             </div>
    </div>
   </div>
   </div>  
  </div>


</div>
</body>
</html:html>