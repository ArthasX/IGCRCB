<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGSVC0613" toScope="request" />
<bean:define id="title" value="报告详细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

if (document.getElementById){ //DynamicDrive.com change
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

function SwitchMenu(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
		if(el.style.display != "block"){ //DynamicDrive.com change
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu") //DynamicDrive.com change
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}
	}
}
function openRelatedIncident(prid,prtype){
	openRelatedProcess(prid, prtype);
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
        <div class="back">	
        <a href="IGSVC0609.do?type1=user">返回</a>
        </div>
    </div>
   
     <div id="results_list">
       <table  class="table_style">
		<%if(!"GD".equals(request.getAttribute("prtype")) ){ %>					
		<tr>
			<th width="3%"></th>
			<th width="8%">编号
			</th>
			<th width="25%">名称
			</th>
			<th width="10%">类型
			</th>
			<th width="8%">发起者
			</th>
			<th width="11%">发起时间
			</th>
			<th width="11%">发生时间
			</th>
			<th width="11%">关闭时间
			</th>
			<th width="13%">状态
			</th>
		</tr>
					
						
		<!-- body部 -->
        <logic:present name="IGSVC05131VO" property="processRecordInfo">
			<logic:iterate id="bean" name="IGSVC05131VO" property="processRecordInfo"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				<bean:define id="prid" name="bean" property="prid" />
				<bean:define id="prpdid" name="bean" property="prpdid" />
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="openRelatedIncident('${prid}','${prtype}')">
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
						<ig:publicProcessInfoValue pidname="发生时间" prid="${bean.prid}"/>
					</td>
					<td><bean:write name="bean"
						property="prclosetime" />
					</td>
					<td>
					<logic:notEqual value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
					</logic:notEqual>
					<logic:equal value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
					</logic:equal>
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
		<%}else{ %>
		<tr>
			<th width="4%"></th>
			<th width="9%">编号
			</th>
			<th width="27%">名称
			</th>
			<th width="16%">类型
			</th>
			<th width="12%">发起者
			</th>
			<th width="15%">登记时间
			</th>
			<th width="17%">状态
			</th>
		</tr>
		<logic:present name="IGSVC05131VO" property="processGdRecordInfoList">
			<logic:iterate id="bean" name="IGSVC05131VO" property="processGdRecordInfoList"
				indexId="index">
				<bean:define id="sfid" name="bean" property="sfid" />
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="openRelatedIncident('${sfid}','GD')" >
					<td>
					</td>
						
					<td><bean:write name="bean" property="sfcode" />
					</td>
					<td><bean:write name="bean"
						property="sftitle" />
					</td>
					<td>
					工单
					</td>
					<td><bean:write name="bean"
						property="sfregisterid" />
					</td>
					<td><bean:write name="bean"
						property="sfinstime" />
					</td>
					<td>
					关闭
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
		<%} %>				
					</table>
     </div>
     <div id="operate">
	</div>

</div>
</div>
  </div>


</div>
</body>
</html:html>