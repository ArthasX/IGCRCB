<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0110h" toScope="request" />
<bean:define id="title" value="表单信息管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toback(){
	    	IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0140_Back.do?pdid=IGPRD0110Form.pdid";
	    	IGPRD0111Form.submit();
	    }
	   
	    function toDel(pidid){
	    	if( window.confirm("您是否确认删除？")){
	    		IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0111_Del.do?pidid="+pidid;
	    		IGPRD0111Form.submit();
			}
	    }
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0111_Disp" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt;流程管理 &gt;&gt; 历史版本 &gt;&gt; 表单管理</p>
	<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" id="table1">
		<tr>
			<th width="4%">序号</th>
			<th style="display:none"></th>
			<th width="10%">表单名称</th>
			<th width="6%">表单类型</th>
			<th width="28%">取值范围</th>
            <th width="7%">默认值</th>
			<th width="20%">表单说明</th>
			<th width="7%">编辑列</th>
			<th width="4%">模式</th>
			<th width="4%">显示</th>
		</tr>
		<logic:present name="IGPRD01101VO" property="processInfoDefList">
			<logic:iterate id="bean" name="IGPRD01101VO"
				property="processInfoDefList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td style="display:none">${bean.pidid}</td>
					<td>
						<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
						<html:link action="/IGPRD0111_Edit_Disp.do?pidid=${bean.pidid}&mode=1&viewhistory=1">
							<logic:empty name="bean" property="pidlabel">&nbsp;</logic:empty>${bean.pidlabel}
						</html:link>
						<%} else {%>
							<logic:empty name="bean" property="pidlabel">&nbsp;</logic:empty>${bean.pidlabel}
						<%}%>
					</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
					<td>
						<logic:equal name="bean" property="pidtype"  value="8">
							<html:link action="/IGPRD0178.do?pdid=${bean.pdid}&flag=flase&viewhistory=1&tableColumn=Y&ppidid=${bean.pidid}&piddisplay=${bean.piddisplay}">
							<img src="images/xx.gif" width="16" height="16" border="0" alt="编辑列" />
							</html:link>
						</logic:equal>
					</td>
					<td>
						<logic:empty name="bean" property="pidmode">
							<ig:codeValue ccid="PROCESSINFODEF_MODE_CODE" cid="0" />
						</logic:empty>
						<logic:notEmpty name="bean" property="pidmode">
							<ig:codeValue ccid="PROCESSINFODEF_MODE_CODE" cid="${bean.pidmode}" />
						</logic:notEmpty>
					</td>
					<td>
						<logic:empty name="bean" property="rowwidth">
							<ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>" />
						</logic:empty>
						<logic:notEmpty name="bean" property="rowwidth">
							<ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="${bean.rowwidth}" />
						</logic:notEmpty>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter" style="display:none">
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
	<html:submit styleClass="button" value="增加" />
	&nbsp;&nbsp;
	<input type="button" name="gttc" value="选择共通表单" class="button" onclick="location='IGPRD0117.do?gtbl=ok&pdid=${IGPRD0110Form.pdid}'"> 
	<%} %>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRD0110Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
