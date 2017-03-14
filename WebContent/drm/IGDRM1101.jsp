<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1101" toScope="request" />
<bean:define id="title" value="人员签到查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>

	#results_list a:HOVER{
		text-decoration: none;
	}
	
</style>
<body style="background-color: white; background-image: none;">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
  <div id="contentWrap">
        <div id="content">
	
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<!-- 	<div id="search"> -->
<!-- 	<div class="img"></div> -->
<!-- 	<div class="conditions"> -->
<!-- 	<div> -->
<%-- 	 <html:form styleId="form" action="IGDRM1101_Disp.do" --%>
<%-- 	onsubmit=" return checkSubmit(this);">  --%>
<%-- 	<span>角色：</span><span><html:text property="role" styleId="role" name="IGBCM0320Form" --%>
<%-- 		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" /> --%>
<!-- 	</span> -->
<%-- 	<span>&nbsp;&nbsp;姓名：</span><span><html:text --%>
<%-- 		property="username" styleId="username" --%>
<%-- 		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" name="IGBCM0320Form"/> --%>
<!-- 	</span><span class="red">*</span> -->
<%-- 	<span>选择指挥流程：<html:text property="pushPrtitle" styleId="pushPrtitle" name="IGBCM0320Form" /> --%>
<!-- 	<a href="###" onclick="javascript:selectProcess()"><img alt="选择应急指挥流程" src="images/seek.gif" border="0"/></a> -->
<%-- 	<html:hidden property="pushPrid" styleId="pushPrtitle" name="IGBCM0320Form"  /> --%>
<!-- 	</span><span class="red">*</span> -->
<!-- 	 <span style="margin-left:40">应急组织架构： -->
<%-- 	 <html:select property="yjid" styleId="yjid" name="IGBCM0320Form" style="width: 100px;" errorStyleClass="inputError" > --%>
<%--                                <ig:optionsCollection ccid="YJZZZG_DYNAMICBRANCH_COND" isMakeBlankRow="true" isCodeLabel="true"/> --%>
<%--      </html:select> --%>
<!-- 	 </span> -->
<%-- 	<html:submit property="btn_search" styleClass="button" value="查询" onclick="return searcher()" /> --%>
<%-- 	</html:form> --%>
<!-- 	</div> -->
<!-- 	</div> -->
<!-- 	</div> -->
	<div id="results_list"><ig:message />
	<html:form action="/IGDRM1101_Signin">
		<html:hidden property="isDrill" style="isDrill" styleId="isDrill"/>
	</html:form>
	<table class="table_style">
		<tr>
				<th width="8%">编号 </th>
				<logic:notEqual value="true" name="IGDRM1101Form" property="isDrill">
					<th class="tdname" width="30%">事件名称</th>
				</logic:notEqual>
				<logic:equal value="true" name="IGDRM1101Form" property="isDrill">
					<th class="tddesc" width="30%">演练内容</th>
				</logic:equal>
				
				<th width="10%">开始时间</th>
				<th width="10%">当前状态</th>
				<th width="5%">姓名</th>
				<th width="9%">是否就位</th>
				<th width="10%">签到时间</th>
				<th width="8%">管理</th>
				<th width="10%">场景信息查看</th>
			</tr>
		<logic:present name="IGDRM11011VO" property="signinMap">
			<logic:iterate id="bean" name="IGDRM11011VO" property="signinMap" indexId="index">
				<tr>
					<td>${bean['PRSERIALNUM']}</td>
					<logic:notEqual value="true" name="IGDRM1101Form" property="isDrill">
						<td class="tdname">${bean['PRTITLE'] }</td>
					</logic:notEqual>
					<logic:equal value="true" name="IGDRM1101Form" property="isDrill">
						<td class="tddesc" title="${bean['PRDESC'] }"><div class="ellips" >${bean['PRDESC'] }</div></td>
					</logic:equal>
					<td>${bean['PROPENTIME']}</td>
					<!-- 流程状态 -->
					<td>	
							<ig:processDefineTypeValue prid="${bean['PRID']}"/>
					</td>
					<td>${bean['USERNAME']}</td>
					<td>
						<c:if test="${bean['SIGNINED']==1}">
						已就位
						</c:if>
						<c:if test="${bean['SIGNINED']!=1}">
						未就位
						</c:if>
					</td>
					<td>${bean['SITIME'] }</td>
					<td>
						<a href="javascript:;" onclick="changeFlag('${bean['PRID']}','${bean['SIUSERID']}','${bean['SIGNINED']}')">
							<c:if test="${bean['SIGNINED']!=1}">
								<img src="images/signout.jpg" border="0" alt="签到"/>
							</c:if>
							<c:if test="${bean['SIGNINED']==1}">
								<img src="images/sign.jpg" border="0" alt="签出"/>
							</c:if>
						</a>
						
					</td>
					<td>
						<c:if test="${bean['SIGNINED']==1}">
							<a href="javascript:;" onclick="searchDetail('${bean['PRID']}')">
								<img src="images/look.gif" border="0" alt="查看场景信息"/>
							</a>
						</c:if>
					</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="zishiying"></div>
	</div>
	</div>
</div>
</div>
<script type="text/javascript">
function changeFlag(a,b,c){
	 var confirmMsg = c=='1'?"是否签出？":"是否签到？";
	    if(window.confirm(confirmMsg)){
	        window.location.href = getAppRootUrl() + "/IGDRM1101_Signin.do?siPrid="+a+"&siuserid="+b+"&signined="+c;
	    }
}

// 查看应急指挥相关的详细场景信息
function searchDetail(siPrid){
	var flowType = "em";
	if(jQuery("#isDrill").val()=="true"){
		flowType = "yl";
	}
	var url=encodeURI(encodeURI('/IGDRM1103_Disp.do?prid='+siPrid+'&flowType='+flowType));
	window.openSubWindow(url, '_blank', '1100', '850');		
}
</script>
</body>
</html:html>