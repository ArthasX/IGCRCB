<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>
<html:html>
<bean:define id="id" value="IGPRD0168" toScope="request" />
<bean:define id="title" value="流程页面管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

function ope(pdid){
	location.href = "IGPRD0168_init.do"+"?&pdid="+pdid;	
}
function opedel(pjdid){
	if(window.confirm("确认删除该行？")){
		location.href = "IGPRD0169_Del.do?&pjdid="+pjdid;		
	}
	
}
function opeedit(pjdid){
	location.href = "IGPRD0169_Edit_Init.do?&pjdid="+pjdid+"&mode=1";		
}
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0168_Disp" >
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 流程页面管理</p>
<div class="back"><a href="IGPRD0101_Back.do" target="_self">返回</a></div> 
</div>
	<div id="formwrapper">
	<fieldset>
	<legend>流程信息</legend>
	    	          <div>
						<label for="Name"><strong><span class="red"></span>流程名称</strong>：</label>
						<span style="position: absolute;margin-top:6px">${IGPRD0168Form.pdname}</span>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red"></span>流程说明</strong>：</label>
						<span style="position: absolute;margin-top:6px">${IGPRD0168Form.pddesc}</span>
						<br>
    				</div>
    </fieldset>
    </div>
	<div id="results_list">
	<ig:message /> 
	<table class="table_style">
		<tr>		
			<th width="10%">页面类型</th>
			<th width="35%">调用BL</th>
			<th width="35%">页面相对路径</th>
			<th width="10%">修改</th>
			<th width="10%">删除</th>
		</tr>
		<logic:present name="IGPRD01681VO" property="lst_IG126Info">
			<logic:iterate id="bean" name="IGPRD01681VO"
				property="lst_IG126Info" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">					
					<td>
						<ig:codeValue ccid="PROCESS_JSP_CODE" cid="${bean.pjdtype}"/>
					</td>
					<td>${bean.pjdblid}</td>
					
					<td>${bean.pjdurl}</td>
				
					<td>
					<a href="javascript:opeedit('${bean.pjdid}');"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改" /></a>
					</td>
					<td>
					<a href="javascript:opedel('${bean.pjdid}');"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	
	<input name="add" type="button" class="button"
		value="增加" onclick="ope('${IGPRD0168Form.pdid}');" /> 
	</div>
	
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>