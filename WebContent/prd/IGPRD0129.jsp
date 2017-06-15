<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0129" toScope="request" />
<bean:define id="title" value="共通变量查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toback(pdid){
	    	IGPRD0118Form.action = getAppRootUrl() + "/IGPRM0301_Disp.do?pdid="+pdid;
	    	IGPRD0118Form.submit();
	    }

	    function checkSubmit(){
		    var count = checkAndCreate();
		    if(count<=0)
		    {
			    alert("请选择一个共通变量");
			    return false;
		    }
		    return true;
	    }
	    
	    function checkAndCreate(){
	    	var count=0;
	    	var pidgids = document.getElementsByName("pidgid");
	    	

	    	for(var i=0;i<pidgids.length;i++){
	    		if(pidgids[i].checked==true){
	    			count++;
	    		}
	    	}
	    	return count;
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
<div id="content"><html:form action="/IGPRD0118_COPYGT" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 共通变量</p>
	<div class="back"><html:link href="javascript:toback(${pdid});">返回</html:link></div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="5%"></th>
			<th width="5%">序号</th>
			<th width="15%">变量名称</th>
			<th width="10%">变量类型</th>
			<th width="20%">取值范围</th>
            <th width="10%">默认值</th>
			<th width="10%">变量说明</th>
			<th width="7%">位置</th>
			<th width="8%">必填</th>
		</tr>
		<logic:present name="IGPRD01101VO" property="processInfoDefGeneralList">
			<logic:iterate id="bean" name="IGPRD01101VO"
				property="processInfoDefGeneralList" indexId="index">
				<tr>
				
					<td>
					<input type="checkbox" name="pidgid" id="pidgid" value="${bean.pidid }">
					</td>
					<td>${index+1}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
					<td><logic:empty name="bean" property="pidsortid">&nbsp;</logic:empty>${bean.pidsortid}</td>
					<td><logic:equal name="bean" property="pidrequired" value="1">是</logic:equal>
					<logic:notEqual name="bean" property="pidrequired" value="1">否</logic:notEqual>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<input type="hidden" name="pdid" id="pdid" value="${pdid }">
	<html:hidden property="basic" styleId="basic" name="IGPRD0117Form" value="basic"/>
	<c:if test="${IGPRD0117Form.disp != '0'}">
	<logic:present name="IGPRD01101VO" property="processInfoDefGeneralList">
		<html:submit styleClass="button" value="确定" />
	</logic:present>
	</c:if>
	</div>
	<div id="operate"><jsp:include page="/include/paging.jsp" /></div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
