<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0207" toScope="request" />
<bean:define id="title" value="费用详细显示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

function deleteFin(){
	if(confirm("请确认是否删除费用?")){
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
	<div class="back"><a href="IGFIN0206_BACK.do" target="_self">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<bean:define id="bean1" name="IGFIN02013VO" property="expenseData" type="com.deliverik.infogovernor.fin.model.Expense" ></bean:define>
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">
			费用编号：
			</th>
			<td width="35%">${IGFIN02013VO.expenseData.exid}</td>
			<th width="15%" align="right">
			费用金额：
			</th>
			<td width="35%"><bean:write name="bean1" property="examount" format="##.##"/>
			</td>
			
		</tr>
		<tr>
			<th align="right">
			预算名称：
			</th>
			<td>${IGFIN02013VO.expenseData.btitle}</td>
			<th align="right">
			费用名称：
			</th>
			<td>${IGFIN02013VO.expenseData.exapvname}</td>
			
		</tr>
		<tr>
			<th align="right">
			发生时间：
			</th>
			<td>${IGFIN02013VO.expenseData.exopentime}</td>
			<th align="right">
			登记时间：
			</th>
			<td>${IGFIN02013VO.expenseData.exclosetime}</td>
		</tr>
		<tr>
		  <th align="right">
			附件：
			</th>
		  <td colspan="3">
				<logic:present name="IGFIN02014VO" property="attachmentDataList">
				<logic:iterate id="bean" name="IGFIN02014VO"
					property="attachmentDataList" indexId="index">
					<!-- 附件 -->
					<logic:empty name="bean"
					property="attname">&nbsp;</logic:empty>
					<a href="downloadFinFile.do?attId=${bean.attid}&type=fin">
					<bean:define id="attname" name="bean" property="attname" />
					<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1) %>
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
				</logic:iterate>
				
				</logic:present>
		  </td>
		  </tr>
		  <tr>
			<th align="right">
			费用说明：
			</th>
			<td colspan="3"><pre>${IGFIN02013VO.expenseData.exdesc}</pre></td>
		
		  </tr>
	</table>
	</div>

<div class="title">
	<div class="name"></div>
	</div>
	<div class="record_list">
             <div class="action">
             <img src="images/deldata.gif" width="16" height="16" /><a href="IGFIN0208_Disp.do?id=${IGFIN02013VO.expenseData.exid}" onclick="return deleteFin();">删除</a></div>
      </div>
   </div>
   </div>  
  </div>


</div>
</body>
</html:html>