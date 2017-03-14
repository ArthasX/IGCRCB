<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0412" toScope="request" />
<bean:define id="title" value="报表版本列表画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	//指定当前版本
	function assignVersion(rfvid){
		var confirmMsg = "请确认是否进行指定当前版本处理？";
		if(window.confirm(confirmMsg)){
		    form.action = getAppRootUrl() + "/IGSYM0412_Assign.do?rfdid=${IGSYM04121VO.reportFileDefinition.rfdid}&rfvid=" + rfvid;
		    form.submit();
		    return true;
		} else {
		    return false;
		}
	}
	//返回
	function toback() {
		form.action = getAppRootUrl() + "/IGSYM0413_Back.do";
		form.submit();
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>
<div class="title">
<div class="name">报表信息</div>
</div>
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="25%">显示名称</th>
		<th width="10%">分类</th>
		<th width="10%">发布名称</th>
		<th width="35%">说明</th>
		<th width="10%">当前版本</th>
		<th width="10%">最新版本</th>
	</tr>
	<tr>
		<td>${IGSYM04121VO.reportFileDefinition.rfdtitle}</td>
		<td>${IGSYM04121VO.reportFileDefinition.codeDetailTB.cvalue}</td>
		<td>${IGSYM04121VO.reportFileDefinition.rfdfilename}</td>
		<td>${IGSYM04121VO.reportFileDefinition.rfddesc}</td>
		<td>${IGSYM04121VO.reportFileDefinition.rfdversion}版</td>
		<td>${IGSYM04121VO.reportFileDefinition.rfdnewversion}版</td>
		
	</tr>
</table>
</div>
<html:form styleId="form"  action="/IGSYM0412_Disp" onsubmit="return checkSubmit(this);">
<div class="title">
<div class="name">版本信息</div>
</div>
<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="35%">版本号</th>
			<th width="35%">创建时间</th>
			<th width="30%">预览报表</th>
		 </tr>
		 <logic:present name="IGSYM04121VO" property="reportFileVersionList">
			<logic:iterate id="bean" name="IGSYM04121VO" property="reportFileVersionList"
				indexId="index">
				<tr>
				    <td>${bean.rfvversion}版</td>
		       		<td>
		          		${bean.rfvinstime}
		       		</td>
				    <td><html:link href="javascript:preview_report('${IGSYM04121VO.reportFileDefinition.rfdfilename}','${bean.rfvversion}','${bean.rfdid}')"><img src="images/preview.gif" alt="预览报表" width="16" height="16"  border="0"/></html:link></td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
<div class="enter">
	<html:button property="btn_back" styleClass="button" value="返回" onclick="toback();" />	
</div>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>