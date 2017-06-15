<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.deliverik.infogovernor.drm.vo.IGDRM0710VO"%>
<html:html>
<bean:define id="id" value="IGDRM0711" toScope="request" />
<bean:define id="title" value="评论内容" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<link type="text/css" href="css/risk.css" rel="stylesheet" />
<link type="text/css" href="css/master.css" rel="stylesheet" />
<script type="text/javascript" src="js/swfobject.js"></script>
<style type="text/css">
.tdTtitle {
	width: 100px;
	background-color: #FDEDF0;
	font-size: 10;
	font-family: 宋体;
	color: #AB0215;
	vertical-align: middle;
	font-weight: bold;
	text-align: right;
}

.tdContent {
	width: 170px;
	font-size: 10;
	font-family: 宋体;
	background-color: #ECEDEF;
	vertical-align: middle;
	font-weight: bold;
	font-weight: normal;
	text-align: left;
}

.ellips {
	width: 100%;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}

.divTitle {
	background-color: #BB0116;
	width: 133px;
	height: 28px;
	font-family: 宋体;
	font-size: 12;
	font-weight: bold;
	color: #FFFFFF;
	text-align: center;
	line-height: 28px;
	display: inline-block;
}
</style>
<body>
	<div style="margin-left: 50px; margin-top: 50px; height: 100%;">
		<!-- 				基本信息题目 -->
		<div style="width: 989px;">
			<div class="divTitle">基本信息</div>

		</div>
		<!-- 				内容 -->
		<div style="width: 616px;  border: 1px solid #CACACA;">
			<table style="width: 566px; margin: 17px auto;">
				<tbody>
					<!-- 					场景基本信息 -->
					<tr height="22px">
						<td class="tdTtitle">节点名称&nbsp;</td>
						<td class="tdContent" title="${IGDRM0710VO.step.psdname }"><div
								style="width: 100%; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">&nbsp;${IGDRM0710VO.step.psdname }</div></td>
						<td class="tdTtitle">参与人&nbsp;</td>
						<td class="tdContent" title="${IGDRM0710VO.step.people }"
							style="max-width: 170px;"><div
								style="width: 100%; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">&nbsp;${IGDRM0710VO.step.people }</div></td>
					</tr>
					<c:if test="${flexType == 'se'}">
						<tr height="22px">
							<td class="tdTtitle">预计开始时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.expectStartTime }
							</td>
							<td class="tdTtitle">预计结束时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.expectOverTime}</td>
						</tr>

						<tr height="22px">
							<td class="tdTtitle">预计使用时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.expectUseTime }</td>
							<td class="tdTtitle">实际开始时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.factStartTime }</td>
						</tr>
						<tr height="22px">
							<td class="tdTtitle">实际结束时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.factOverTime  }</td>
							<td class="tdTtitle">实际使用时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.factUseTime  }</td>
						</tr>
						<tr height="50px">
							<td class="tdTtitle">应急步骤&nbsp;</td>
							<td colspan="3" class="tdContent"
								title="${IGDRM0710VO.step.nodeStep }" style="max-width: 450px;">
								<div style="width: 100%; text-overflow: ellipsis; overflow: hidden;">
									&nbsp;${IGDRM0710VO.step.nodeStep }</div>
							</td>
						</tr>
					</c:if>
					<!-- 						应急指挥基本信息 -->
					<c:if test="${flexType == 'em'}">
						<tr height="22px">
							<td class="tdTtitle">实际开始时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.factStartTime }</td>
							<td class="tdTtitle">实际结束时间&nbsp;</td>
							<td class="tdContent">&nbsp;${IGDRM0710VO.step.factOverTime  }</td>
						</tr>
						<tr height="22px">
							<td class="tdTtitle">实际使用时间&nbsp;</td>
							<td colspan="3" class="tdContent">&nbsp;${IGDRM0710VO.step.factUseTime  }</td>
							<td colspan="3" class="tdContent">&nbsp;${IGDRM0710VO.step.factUseTime  }</td>
						</tr>
					</c:if>
				</tbody>

			</table>

		</div>
		<div style="height: 300; margin-top: 10px;">
			<div class="divTitle">评估内容</div>
			<div style="width: 700px;">
				<textarea rows="15" cols="90" id="suggestion"
					style="border: 1px solid #CCCCCC; margin: 0px;"></textarea>
			</div>
			<div class="action" onclick="saveDetail()"
				style="cursor: pointer; margin-left: 550px;">
				<img width="16" height="16" src="images/icon2_089.gif"> <a
					title="提交" style="color: #ffffff">提交</a>
			</div>
		</div>
	</div>


	<script type="text/javascript">
	function saveDetail(){
		var suggestion = jQuery("#suggestion").val();
		if(!suggestion){
			alert("请输入评估内容！");
			return false;
		}
		if(suggestion.strlen()>2048){
			alert("评估内容不能大于"+Math.floor(2048/strByteFlag)+"个汉字！");
			return false;
		}
		if(!window.opener.closed){
			 window.opener.saveDetail('${psdid}','${flexType}',  document.getElementById("suggestion").value);
			 window.close();
		}
	}
</script>
</body>

</html:html>