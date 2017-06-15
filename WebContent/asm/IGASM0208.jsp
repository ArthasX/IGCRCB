<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0208" toScope="request" />
<bean:define id="title" value="配置项查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
function toBack(){
	var urlstr = document.referrer; 
	document.forms[0].action =  getAppRootUrl() + urlstr.substring(urlstr.lastIndexOf("/"));
	document.forms[0].submit();
}
function openSubIGASM0209(eiid){
	openSubWindow('/IGASM0209_Disp.do?eiid='+eiid,'_blank','800','600');
}
function openSubIGASM0210(eiid,civersion){
	openSubWindow('/IGASM0210_Disp.do?eiid='+eiid+'&civersion='+civersion,'_blank','800','600');
}
function openSubIGASM0211(eiid){
	openSubWindow('/IGASM0211_Disp.do?eiid='+eiid,'_blank','800','600');
}
</script>

<body style="background-color: #FFFFFF; background-image: none;">
<div id="maincontent">
<div id="container">
<html:form styleId="form" action="/IGASM0208"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>

</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="10%">资产编号</th>
			<th width="20%">资产名称</th>
			<th width="26%">资产说明</th>
			<th width="7%">管理人</th>
			<th width="12%">更新时间</th>
			<th width="7%">详细信息</th>
			<th width="7%">关系管理</th>
			<th width="7%">历史版本</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM02011VO" property="entityDataList">
			<logic:iterate id="bean" name="IGASM02011VO"
				property="entityDataList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 编号 -->
					<td>
					<div class="nowrapDiv">${bean.eilabel}</div>
					</td>
					<!-- 名称 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="einame">&nbsp;</logic:empty> ${bean.einame}</div>
					</td>
					<!-- 说明 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="eidesc">&nbsp;</logic:empty> ${bean.eidesc}</div>
					</td>
					<!-- 管理人 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="eiusername">&nbsp;</logic:empty> ${bean.eiusername}</div>
					</td>
					<!-- 状态 
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="eistatus">&nbsp;</logic:empty> <ig:codeValue
						ccid="EQUIPMENT_STATUS_CODE" cid="${bean.eistatus}" /></div>
					</td>
					--><!-- 更新时间 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="eiupdtime">&nbsp;</logic:empty> ${bean.eiupdtime}</div>
					</td>
					<!-- 详细信息 -->
					<td>
					<div align="center">
					<a href="javascript:openSubIGASM0211('${bean.eiid}')">
						<img src="images/xx.gif" alt="显示详细信息" width="16" height="16"
							border="0" />
					</a></div>
					</td>
					<!-- 关系管理 -->
					<td>
					<div class="nowrapDiv">
					<a href="javascript:openSubIGASM0209('${bean.eiid}')">
						<img src="images/record_(copy)_16x16.gif" alt="关系信息" width="16"
							height="16" border="0" />
					</a></div>
					</td>
					<!-- 历史版本 -->
					<td>
					<div class="nowrapDiv">
					<a href="javascript:openSubIGASM0210('${bean.eiid}','')">
						<img src="images/notepad_16x16.gif" alt="历史版本" width="16"
							height="16" border="0" />
					</a></div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><!-- paging --> 
	<jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
	<div class="enter">
		<html:button styleClass="button" property="button" value="关闭" onclick="window.close()" ></html:button>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>

</body>
</html:html>