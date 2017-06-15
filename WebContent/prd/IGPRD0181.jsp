<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0181" toScope="request" />
<bean:define id="title" value="通用表单管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toback(){
	    	IGPRD0118Form.action = getAppRootUrl() + "/IGPRD0101_Back.do";
	    	IGPRD0118Form.submit();
	    }
	    function toDel(pidid){
	    	if( window.confirm("您是否确认删除？")){
	    		IGPRD0118Form.action = getAppRootUrl() + "/IGPRD0118_Del.do?pidid="+pidid;
	    		IGPRD0118Form.submit();
			}
	    }
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0118_Disp" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 编辑列 &gt;&gt; 通用表单管理</p>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="5%">序号</th>
			<th width="15%">表单名称</th>
			<th width="10%">表单类型</th>
			<th width="20%">取值范围</th>
            <th width="10%">默认值</th>
			<th width="10%">表单说明</th>
			<th width="7%">模式</th>
			<th width="7%">显示</th>
			<th width="10%">删除</th>
		</tr>
		<logic:present name="IGPRD01101VO" property="processInfoDefGeneralList">
			<logic:iterate id="bean" name="IGPRD01101VO"
				property="processInfoDefGeneralList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>
					<html:link action="/IGPRD0118_Edit_Disp.do?pidid=${bean.pidid}&mode=1">
					${bean.pidname}
					</html:link>
					</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
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
					<td>
					<%//if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
					<html:link
						href="javascript:toDel('${bean.pidid}')">
						<img src="images/delete.gif" width="16" height="16" border="0"
							alt="删除" />
					</html:link>
					<%//} %>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<%//if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
	<html:submit styleClass="button" value="增加" />
	<%//} %>
	</div>
	<div id="operate"><jsp:include page="/include/paging.jsp" /></div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
