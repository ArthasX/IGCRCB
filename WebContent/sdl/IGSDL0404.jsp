<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0404" toScope="request" />
<bean:define id="title" value="信息详细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">	

	var gid = "IGSDL0401";
</script>
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back"><a href="IGSDL0401_BACK.do" target="_self">返回</a></div>
</div>
<div class="title">
	<div class="name">基本信息</div>
</div>
<div class="record_list">
<logic:present name="IGSDL04011VO" property="sdlInfo">
<bean:define id="sdlInfo" name="IGSDL04011VO" property="sdlInfo"/>
</logic:present>
	<table cellspacing="2" class="table_style1">
		
		<tr>
			<th width="12%">
			相关资产：
			</th>
			<td width="38%"><a href="javascript:void(0)" onclick="openSubIGCOM0303('${sdlInfo.sieiid}','')">
			${sdlInfo.sieiname}
			</a></td>
			<th width="12%">
			相关事件：
			</th>
			<td width="38%">${sdlInfo.siprtitle}</td>
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
			类别：
			</th>
			<td><ig:codeValue ccid="SERVER_CATEGORY_CODE" cid="${sdlInfo.sitype}" /></td>
			<th>
			附件：
			</th>
			<td>
			<logic:present name="IGSDL04011VO" property="attachmentList">
			<logic:iterate id="attachment" name="IGSDL04011VO" property="attachmentList" indexId="number">

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
			说明：
			</th>
			<td colspan="3"><pre>${sdlInfo.sidesc}</pre></td>
			
		</tr>
	</table>
</div>
<div class="enter">
<html:button property="button" value="返回" styleClass="button" 
onclick="window.location='IGSDL0401_BACK.do'"></html:button>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>