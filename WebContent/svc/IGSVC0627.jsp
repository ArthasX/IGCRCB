<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGSVC0627" toScope="request" />
<bean:define id="title" value="报告详细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">


function openRelatedIncident(prid,prtype){
	openSubWindow('/IGSVC0605.do?prid=' + prid + "&type=" +prtype ,"_blank","1000","600");
}

</script>

<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">

   <div id="location">
       <div class="image"></div>
        <p class="fonts1">查看</p>
       
    </div>
   
     <div id="results_list">
       <table  class="table_style">
						
		<tr>
			<th width="3%"></th>
			<th width="8%">编号
			</th>
			<th width="24%">名称
			</th>
			<th width="10%">类型
			</th>
			<th width="10%">发起者
			</th>
			<th width="11%">发起时间
			</th>
			<th width="11%">发生时间
			</th>
			<th width="11%">关闭时间
			</th>
			<th width="12%">状态
			</th>
		</tr>
		<!-- body部 -->
        <logic:present name="IGSVC05131VO" property="processRecordList">
			<logic:iterate id="bean" name="IGSVC05131VO" property="processRecordList"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				<bean:define id="prid" name="bean" property="prid" />
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="openRelatedIncident('<%=prid %>','<%= prtype%>')">
					<td>
					<c:if test="${bean.prurgency != null and bean.prurgency > ' '}">
						 <img
							src="images/<bean:write name="bean" property="prurgency" />.gif" alt="紧急程度：<ig:codeValue ccid="${bean.prtype}URGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />"
							border="0" />
					</c:if>
					</td>
						
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td>
					<bean:write name="bean" property="prpdname" />
					</td>
					<td><bean:write name="bean"
						property="prusername" />
					</td>
					<td><bean:write name="bean"
						property="propentime" />
					</td>
					<td><bean:write name="bean"
						property="prplantime" />
					</td>
					<td><bean:write name="bean"
						property="prduration" />
					</td>
					<td>
					<logic:notEqual value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />（<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>）
					</logic:notEqual>
					<logic:equal value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
					</logic:equal>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
						
					</table>
     </div>
     <div id="operate">
	</div>

</div>

<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>

</div>
</body>
</html:html>