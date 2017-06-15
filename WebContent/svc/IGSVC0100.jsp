<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGPRJ0101" toScope="request" />
<bean:define id="title" value="项目工作画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
var gid='IGSVC0100';
function viewDetail(prid,prtype){
	window.open("IGPRJ0101_Detail_findKGM.do?eid=" + prid + "&type=" + prtype,"_blank","width=1100,height=600");
}
</script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1">查看 &gt;&gt; 项目工作</p>
    </div>
	<div id="results_list">
	<table class="table_style">
		<tr>
		<th width="3%"></th>
          <th width="10%">编号</th>
          <th width="28%">名称 </th>
          <th width="10%">发起者</th>
          <th width="10%">发起时间</th>
          <th width="10%">执行时间</th>
          <th width="10%">结束时间</th>
          <th width="12%">状态</th>
          <th width="7%">影响程度</th>
	   </tr>
		
		<logic:present name="IGSVC01001VO" property="processRecordList">
			<logic:iterate id="bean" name="IGSVC01001VO" property="processRecordList"
				indexId="index">
					
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="viewDetail('${bean.prid}','${bean.prtype}');" >
					<td>
					<c:if test="${bean.prurgency != null and bean.prurgency > ' '}">
						 <img
							src="images/<bean:write name="bean" property="prurgency" />.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />"
							border="0" />
					</c:if>
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td >
						<bean:write name="bean" property="prtitle" />
					</td>
					<td>
					<bean:write name="bean" property="prusername" />
					</td>
					<td>
					<bean:write name="bean" property="propentime" />
					</td>
					<td><bean:write name="bean" property="prplantime" />
					</td>
					<td>
					<bean:write name="bean" property="prduration" />
					</td>
					<td>
					<logic:notEqual value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />（<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>）
					</logic:notEqual>
					<logic:equal value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
					</logic:equal>
					</td>
					<td>
						<ig:codeValue ccid="${bean.prtype}URGENCY_GRADE_CODE" cid="${bean.prurgency}" />
					</td>
					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
		
	
</div>
</div>
</body>
</html:html>
