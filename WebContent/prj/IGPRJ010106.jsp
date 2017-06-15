<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String eid = request.getParameter("eid");
	String type = request.getParameter("type");
%>
<html:html>
<bean:define id="id" value="IGPRJ010106" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<bean:define id="title" value="项目工作详细显示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
</script>
<body>

    <!--content  右侧内容-->

   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="8%">
			标题：
			</th>
			<td width="42%">${IGKGM01021VO.processRecordData.prtitle}</td>
			<th width="8%">
			描述：
			</th>
			<td width="42%">${IGKGM01021VO.processRecordData.prdesc}</td>
		</tr>
		<tr>
			<th>
			发起人：
			</th>
			<td>${IGKGM01021VO.username}</td>
			<th>
			角色：
			</th>
			<td>${IGKGM01021VO.jiaose}</td>
		</tr>
		<tr>
			<th>
			发起日期：
			</th>
			<td>${IGKGM01021VO.processRecordData.propentime}</td>
			<th>
			相关资产：
			</th>
			<td>${IGKGM01021VO.zican}</td>
		</tr>
		
		
			
	</table>
	</div>
	<div class="title">
	<div class="name">详细信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
	<tr>
					<th width="8%">时间</th>
					<th width="8%">相关人员</th>
					<th width="8%">角色</th>
					<th width="34%">内容</th>
					<th width="20%">日志</th>
					<th width="22%">附件</th>	
				</tr>
				
				<%if(type.equals("K")){%>
				<tr>
					<td>${IGKGM01021VO.processRecordData.propentime}</td>
					<td>${IGKGM01021VO.username}</td>
					<td></td>
					<td>${IGKGM01022VO.comment}</td>
        			<td></td>
        			<td>
        			<logic:present name="IGKGM01023VO" property="attachmentDataList">
						<logic:iterate id="attachment" name="IGKGM01023VO"
									property="attachmentDataList" indexId="index">
						
								<html:link
									action="downloadKgmFile.do?attId=${attachment.attid}&type=kgm">
									<bean:define id="attname" name="attachment" property="attname" />
									<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1) %>
								</html:link><br/>
						
						</logic:iterate>
						</logic:present>
					</td>
					</tr>
				<%}else{ %>	

	<logic:present name="IGSVC03111VO" property="recordLogMap">
		<logic:iterate id="map" name="IGSVC03111VO" property="recordLogMap" indexId="index">
			<bean:define id="recordLog" name="map" property="key" />
			<bean:define id="attachmentList" name="map" property="value" />

				<tr class="<ig:rowcss index="${index}"/>">	
					<td><bean:write name="recordLog" property="rltime" /></td>
					<td><bean:write name="recordLog" property="rlusername" /></td>
					<td><bean:write name="recordLog" property="rlrolename" /></td>
					<td><bean:write name="recordLog" property="rlcomment" filter="false"/></td>
        			<td><bean:write name="recordLog" property="rldesc" filter="false"/></td>
        			<td>
						<logic:iterate id="attachment" name="attachmentList"
							indexId="number">
							
								<html:link
									action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
									<bean:define id="attname" name="attachment" property="attname" />
									<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1) %>
								</html:link><br/>
						
						</logic:iterate>
					
					</td>
				</tr>
	</logic:iterate>
	</logic:present>
	<%} %>
	</table>
	</div>
	<div style="margin-top:50px;" align="center">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>

  

</body>
</html:html>