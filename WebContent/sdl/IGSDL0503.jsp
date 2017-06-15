<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0503" toScope="request" />
<bean:define id="title" value="信息详细画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	<script type="text/javascript">
    var gid='IGSDL0503';
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
</div>

<div class="record_list">
<bean:define id="sdlInfo" name="IGSDL05011VO" property="sdlInfo"/>
<bean:define id="attachmentList" name="IGSDL05011VO" property="attachmentList"/>
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="12%">
			类别：
			</th>
			<td width="38%"><ig:codeValue ccid="SERVER_CATEGORY_CODE" cid="${sdlInfo.sitype}" /></td>
			
			<th width="12%">
			相关资产：
			</th>
			<td width="38%"><a href="javascript:void(0)" onclick="openSubIGCOM0303('${sdlInfo.sieiid}','')">
			${sdlInfo.sieiname}
			</a></td>
			
		</tr>
		<tr>
			<th >
			相关事件：
			</th>
			<td>${sdlInfo.siprtitle}</td>
			<th >
			附件：
			</th>
			<td>
			<logic:present name="attachmentList">
			<logic:iterate id="attachment" name="attachmentList" indexId="number">

						<html:link
							action="downloadSvcFile.do?attId=${attachment.attid}&type=sdl">
							<bean:define id="attname" name="attachment" property="attname" />
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>&nbsp;&nbsp;
			</html:link>
			</logic:iterate>
			</logic:present>
			</td>
		</tr>
		<tr>
			<th>
			开始时间：
			</th>
			<td>${sdlInfo.sibegin}</td>
			<th>
			结束时间：
			</th>
			<td>${sdlInfo.siend}</td>
		</tr>
		<tr>
			<th>
			说明：
			</th>
			<td colspan="3"><pre>${sdlInfo.sidesc}</pre></td>

			
		</tr>
	</table>
</div>
<div id="operate">
    <div class="content">
         <div class="enter">
             <input type="button" name="btn_close" value="关闭"  onclick="window.close()" class="button">
         </div>
    </div> 
</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>