<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM0423S" toScope="request"/>
<bean:define id="title" value="应急资源选择" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">
function setParentValue(eiid,einame){
	if(!window.opener.closed){
        window.opener.setDrmResourceValue(eiid,einame);
        window.close();
    }
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
	<!--content  右侧内容-->
	<div id="contentWrap">
			<html:form styleId="form" action="/IGDRM0402_Single.do">			
			<div id="content"  >
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
					<div>
						<label for="Name">应急资源模型：</label>
						<html:text property="ername" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGDRM0412_Tree.do');"/>
						&nbsp;&nbsp;<label>应急资源名称：</label>
						<html:text property="einame" styleId="einame" style="width:110px;"  errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<label>负责人：</label><html:text property="eiusername" styleId="eiusername" style="width:110px;" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<html:hidden property="esyscoding" styleId="esyscoding"/>
						<html:hidden property="eistatus" value="1"/>
						<html:submit property="btn_search" value="查询" styleClass="button" onclick=""/>
					</div>
				</div>
			</div>
			<div id="results_list">
				<!--  message -->
				<ig:message/>
				<!--  /message -->
				<table width="100%" class="table_style">
					<!-- header部 -->
					<tr>
						<th width="3%"></th>
						<th width="35%">应急资源名称</th>
						<th width="12%">应急资源模型</th>
						<th width="11%">资产模型</th>
						<th width="10%">负责人</th>
						<th width="10%">登记日期</th>
					</tr>
					<!-- body部 -->
					<logic:present name="IGDRM04021VO" property="entityVWItemList" >
						<logic:iterate id="bean" name="IGDRM04021VO" property="entityVWItemList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
								<td>
									<img alt="选择" src="images/select_asset.gif" width="16" height="16" style="cursor: pointer;" onclick="setParentValue('${bean.eiid}','${bean.einame}')"/>
								<td>
									<div class="nowrapDiv" style="text-align: left;">
										<logic:empty name="bean" property="einame">&nbsp;</logic:empty>
										<div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;" >
											<span title="${bean.einame}">${bean.einame} </span>
										</div>
									</div>
								</td>
								<td>
								${fn:split(bean.fingerPrint,"_")[1]}
								</td>
								<td>
								<ig:GetMOdelNameByEiid eiid="${bean.eiid}" id="${bean.id}"/>
								</td>
								<!-- 说明 -->
								<!-- 管理人-->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
										${bean.eiusername}
									</div>
								</td>
								<!-- 登记日期 -->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
										${bean.eiinsdate}
									</div>
								</td>
										
							</tr>
						</logic:iterate>
					</logic:present>
				</table>
			</div>
			
			<div id="operate">
				<!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
				<!-- /paging -->
			</div>
				<input type="hidden" name="ercode" id="ercode" value="${IGDRM0402Form.ercode }"/>
				<input type="hidden" name="erid" id="erid"/>
			</div>
			<div class="enter">
				<input id="parent" type="button" name="btn_clear" value="清空" onclick="setParentValue('','')" class="button">
				<input type="button" class="button" value="关闭" onclick="window.close();">
			</div>
		</html:form>
	</div>
</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>