<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGRIS0109" toScope="request" />
<bean:define id="title" value="审计发起查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toChange(raiid,raistatus){
	    	if( window.confirm("您是否确认修改状态？")){
		        form.action = getAppRootUrl() + "/IGRIS0110_Change.do?raiid="+raiid+"&raistatus="+raistatus;
		        form.submit();
			}
	    }
	    function toUpdate(raiid){
	        form.action = getAppRootUrl() + "/IGRIS0110_Edit_Disp.do?raiid="+raiid;
	        form.submit();
	    }
	    function toPerson(raiid,raid){
	    	form.action = getAppRootUrl() + "/IGRIS0112_Disp.do?raiid=" + raiid;
	        form.submit();
	    }
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGRIS0109" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt; 审计管理</p>
	</div>
	<div id="search">
      <div class="img"></div>
         <div class="conditions">
         <div><span>版本名称：</span><span><logic:present name="labelList"><html:select property="raid" errorStyleClass="inputError imeActive" name="IGRIS0109Form" styleId="raid">
				<html:options collection="labelList" property="value" name="" labelProperty="label"/>
			</html:select> 
		 </logic:present>
         </span>
         <span>&nbsp;&nbsp;时间：从</span><span><html:text
		property="raistart" styleId="raistart" name="IGRIS0109Form"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('raistart'))" border="0" style="cursor: hand" />
	</span>
	<span>&nbsp;&nbsp;到</span><span><html:text
		property="raiend" styleId="raiend" name="IGRIS0109Form"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('raiend'))" border="0" style="cursor: hand" /></span>
        <span>&nbsp;<html:submit styleClass="button" value="查询" /></span>
         </div>
        </div>
    </div>
	<div id="results_list">
	<ig:message/>
	<table class="table_style">
		<tr>
            <th width="15%">审计编号</th>
            <th width="10%">版本名称</th>
            <th width="10%">开始时间</th>
            <th width="10%">结束时间</th>
            <th width="25%">说明</th>
            <th width="9%">状态</th>
            <th width="7%">修改</th>
            <th width="7%">调整</th>  
            <th width="7%">审计人</th>  
		</tr>
		<logic:present name="IGRIS01091VO" property="riskAuditInsList">
			<logic:iterate id="bean" name="IGRIS01091VO"
				property="riskAuditInsList" indexId="index">
				<tr>
					<td><logic:empty name="bean" property="raicode">&nbsp;</logic:empty>${bean.raicode}</td>
					<td><logic:empty name="bean" property="raversion">&nbsp;</logic:empty>${bean.raversion}</td>
					<td><logic:empty name="bean" property="raistart">&nbsp;</logic:empty>${bean.raistart}</td>
					<td><logic:empty name="bean" property="raiend">&nbsp;</logic:empty>${bean.raiend}</td>
					<td><logic:empty name="bean" property="raidesc">&nbsp;</logic:empty>${bean.raidesc}</td>
					<td><logic:empty name="bean" property="raistatus">&nbsp;</logic:empty>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE %>" name="bean" property="raistatus">已启用</logic:equal>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITINS_STATUS_DISABLE %>" name="bean" property="raistatus">已关闭</logic:equal>
					</td>
					<td>
						<html:link  href="javascript:toUpdate('${bean.raiid}')">
						<img src="images/edit.gif" width="16" height="16" border="0" alt="修改" />
						</html:link>
					</td>
					<td>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITINS_STATUS_DISABLE %>" name="bean" property="raistatus">
						<html:link  href="javascript:toChange('${bean.raiid}','${bean.raistatus}')">
						<img src="images/start.gif" width="16" height="16" border="0" alt="启用" />
						</html:link>
					</logic:equal>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE %>" name="bean" property="raistatus">
						<html:link  href="javascript:toChange('${bean.raiid}','${bean.raistatus}')">
						<img src="images/stop.gif" width="16" height="16" border="0" alt="关闭" />
						</html:link>
					</logic:equal>
					</td>
					<td>
						<html:link  href="javascript:toPerson('${bean.raiid}')">
						<img src="images/gif-0468.gif" width="16" height="16" border="0" alt="审计人" />
						</html:link>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><jsp:include page="/include/paging.jsp" /></div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
