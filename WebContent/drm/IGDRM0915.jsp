<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM19011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<html:html>
<bean:define id="id" value="IGDRM0915" toScope="request" />
<bean:define id="title" value="应急处置查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style>
div span{
overflow:hidden;text-overflow:ellipsis；
}

</style>
<script>
//表单配置的查询条件加样式 
function initPage() {
	jQuery("div[name='searchCond']>span").attr("class","subscribe");
	
	if(jQuery("#showFlag").val()!=1){
		jQuery("div[name='searchCond']").each(function (index, item) {
			jQuery(item).hide();
		});
		document.getElementById("showFlag").value = "2";
	}else{
		jQuery("div[name='searchCond']").each(function (index, item) {
			jQuery(item).show();
		});
		jQuery("#imgid").attr("src", "images/backup.gif");
		jQuery("#imgid").attr("alt", "收起");
		document.getElementById("showFlag").value = "1";
		
	}
}

function bindEvent() {
// 	jQuery("#label_img").bind("click", function (e) {
// 		var flag = document.getElementById("showFlag").value;
// 		jQuery("div[name='searchCond']").each(function (index, item) {
// 			jQuery(item).toggle();
// 			if (jQuery(item).is(":visible")) {
// 				document.getElementById("showFlag").value = "2";
// 			}
// 		});
// 		if ("2" == flag) {
// 			jQuery(e.target).attr("src", "images/backup.gif");
// 			jQuery(e.target).attr("alt", "收起");
// 			document.getElementById("showFlag").value = "1";
// 		} else {
// 			jQuery(e.target).attr("src", "images/moreSearch.gif");
// 			jQuery(e.target).attr("alt", "更多收索条件");
// 			document.getElementById("showFlag").value = "2";
// 		}
// 	});
}

jQuery(document).ready(function() {
	initPage();
	
	bindEvent();

	jQuery("#form").submit(function () {

	}); // end onsubmit 

});	// end ready 
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
	<html:form action="/IGDRM1901" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
    <div>
	 <span style="font-size:15px;"><strong>查询条件</strong></span>
<!-- 	 <label id="label_img" style="margin-left: 736px; margin-top: -1px;"> <img id="imgid" src="images/moreSearch.gif" align="middle" style="cursor: hand;" border="0" /> -->
<!-- 									</label> -->
	</div>
				 
	<div class="conditions">
	<div style="margin-top:4px">
	<span class="subscribe">编号：</span><html:text property="prserialnum" size="12" />
	<span class="subscribe">名称：</span><html:text property="prtitle"/>
	<span class="subscribe">时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
	<span>--</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
	<html:submit styleClass="button" value="查询" />
	</div>
	<div style="margin-top:12px">
	<span class="subscribe">发起者：</span><html:text property="prusername"/>
	<span class="subscribe">内容：</span>
	<span><html:text errorStyleClass="inputError imeActive" style='margin-left:-5px'
		property="prdesc" size="40" /></span>
    </div>
	
	<logic:present name="AD_ProcessInfoQueryMap" scope="session">
    <div style="margin-top:11px; display: none;" name='searchCond' >
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			<bean:define id="bean" name="map" property="value"/>
			<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGDRM1901Form" property="varvalues[${index }]"/>
			<c:if test="${(index+1)%4==0 }">
	</div>
	<div style="margin-top:11px; display: none;" name='searchCond' >
			</c:if>
		</logic:iterate> 
	</div>
	</logic:present>
	
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="1%"></th>
			<th width="1%"></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prserialnum">编号
			<logic:equal name="IGDRM1901Form" property="order" value="prserialnum">
				<logic:equal name="IGDRM1901Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGDRM1901Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="18%"><a href="IGWKM0103.do?orderVal=prtitle">名称			
			<logic:equal name="IGDRM1901Form" property="order" value="prtitle">
				<logic:equal name="IGDRM1901Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGDRM1901Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="8%"><a href="IGWKM0103.do?orderVal=prusername">发起者
			<logic:equal name="IGDRM1901Form" property="order" value="prusername">
				<logic:equal name="IGDRM1901Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGDRM1901Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=propentime">发起时间
			<logic:equal name="IGDRM1901Form" property="order" value="propentime">
				<logic:equal name="IGDRM1901Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGDRM1901Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=prclosetime">关闭时间
			<logic:equal name="IGDRM1901Form" property="order" value="prclosetime">
				<logic:equal name="IGDRM1901Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGDRM1901Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="12%">当前处理人</th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=prstatus">状态
			<logic:equal name="IGDRM1901Form" property="order" value="prstatus">
				<logic:equal name="IGDRM1901Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGDRM1901Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="5%">处置大屏</th>
			<th width="5%">工作台</th>
		</tr>
		<logic:present name="IGDRM19011VO" property="processList">
			<logic:iterate id="bean" name="IGDRM19011VO" property="processList"
				indexId="index">
				
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />');">
					<td>
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td><bean:write name="bean"
						property="prusername" />
					</td>
					<td><bean:write name="bean"
						property="propentime" />
					</td>
					<td><bean:write name="bean"
						property="prclosetime" />
					</td>
					
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
					</td>
					<td>	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
					<td><img src="images/drmEmy.png" alt="进入处置图" width="16" height="16" border="0" style="cursor:hand" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" onclick="enterFigure('${bean.prid}');" /></td>
					<td><img src="images/drm/console.png" alt="进入工作台" width="24" height="24" border="0" style="cursor:hand"   onclick = "showConsole('${bean.prid}')"/></td>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}">
    <html:hidden property="prtype" styleId="prtype"/>
    <html:hidden property="prpdid" styleId="prpdid"/>
    <html:hidden property="actname" styleId="actname"/>
	</html:form>
</div>
</div>
</div>


</div>
<script type="text/javascript">
// 	隐藏查询流程节点
	jQuery(function(){
		jQuery("select[name = 'prstatus']").prev().hide();
		jQuery("select[name = 'prstatus']").hide();
		
	});
	
	//弹出流程图
	function enterFigure(prid){
		(window.event)&&(window.event.cancelBubble=true); 
		var url = getAppRootUrl()+"/IGDRM0912.do?prid="+prid+"&cldtype=1";
		this.subWindow = window.open(url, '应急处置Dashboard', 'width=1024, height=768, scrollbars=no, resizable=no, status=no, top=0, left=1024').focus();
	}
	
	function showConsole(prid){
		window.open('IGDRM1010.do?prid='+prid, '应急工作台', 'width=1024, height=768, scrollbars=yes, status=no, top=0, left=0').focus();
		
		//阻止事件冒泡
		(window.event)&&(window.event.cancelBubble=true); 
//	 	var e = event||window.event;
//	 	e&&e.stopPropagation();
	}
</script>
</body>
</html:html>
