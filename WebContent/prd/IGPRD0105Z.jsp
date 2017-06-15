<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>

<html:html>
<bean:define id="id" value="IGPRD0105Z" toScope="request"/>
<bean:define id="title" value="流程状态信息变更画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
function toback(){
	IGPRD0105Form.action = getAppRootUrl() + "/IGPRD0104_Back.do";
	IGPRD0105Form.submit();
}
function checkForm(){
	var message = '<bean:message key="IGCO10000.W003" arg0="状态基本信息" />';
	if($F("assignPageType").strlen()>32){
		alert("分派页面不能大于32个字符！");
		return false;
	}
	if($F("jsfunction") != ""){
		if(checkStr($F("jsfunction"))){
			alert("请输入正确格式的js方法名称！");
			return false;
		}
		if($F("jsfunction").length > 128){
			alert("js方法名称不能超过128个字符");
			return false;
		}
	}
    if( window.confirm(message)){
		return true;
	} else {
		return false;
	}
}
function checkStr(str){
	var patrn=/^([a-zA-Z0-9]|[_]|[?]|[=]){0,128}$/;
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	} 
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
            <div id="location">
                <div class="image"></div>
                <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 状态列表 &gt;&gt; 状态变更</p>
            	<div class="back">
            		<html:link href="javascript:toback();">返回</html:link>
            	</div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGPRD0105_Z" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
	                <legend> 状态基本信息变更</legend>
                    <div>
                    	<label for="Name"><strong>状态名称</strong>：</label>
                    	<bean:write name="IGPRD0105Form" property="psdname"/>
                    </div>
                    <div>
                    	<label for="Name"><strong>状态类型</strong>：</label>
						<html:select name="IGPRD0105Form" property="psdtype" styleId="psdtype" errorStyleClass="inputError" tabindex="2" disabled="true">
							<ig:optionsCollection ccid="PROCESS_NODE_TYPE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
						</html:select>
                    </div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>状态模式</strong>：</label>
						<html:select name="IGPRD0105Form" property="psdmode" styleId="psdmode" errorStyleClass="inputError" tabindex="3" disabled="true">
							<ig:optionsCollection ccid="PROCESS_NODE_MODE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
						</html:select>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>可被分派</strong>：</label>
						<html:select name="IGPRD0105Form" property="psdflag" styleId="psdflag" errorStyleClass="inputError" tabindex="4" disabled="true">
							<ig:optionsCollection ccid="PROCESS_NODE_DYNAMIC_CODE" isMakeBlankRow="false" isCodeLabel="true" />
						</html:select>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>参与者选择范围</strong>：</label>
						<html:select name="IGPRD0105Form" property="psdorg" styleId="psdorg" errorStyleClass="inputError" tabindex="6" disabled="true">
							<ig:optionsCollection ccid="PROCESSSTATUSDEF_PSDORG" isMakeBlankRow="false" isCodeLabel="true" />
						</html:select>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>可调整参与者</strong>：</label>
						<html:select name="IGPRD0105Form" property="participantchange" styleId="participantchange" errorStyleClass="inputError" tabindex="5" disabled="true">
							<html:option value="0">否</html:option>
							<html:option value="1">是</html:option>
						</html:select>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>确认动作</strong>：</label>
						<html:select name="IGPRD0105Form" property="psdconfirm" styleId="psdconfirm" errorStyleClass="inputError" tabindex="7" disabled="true">
							<ig:optionsCollection ccid="PROCESSSTATUSDEF_PSDCONFIRM" isMakeBlankRow="false" isCodeLabel="true" />
						</html:select>
    				</div>
    				<div>
                        <label for="Name"><strong>分派页面</strong>：</label>
                        <html:text name="IGPRD0105Form" property="assignPageType" styleId="assignPageType" style="width:200px;"/>
                    </div>
                    <div>
                    	<label for="Name"><strong>表单全局控制</strong>：</label>
                    	<html:select name="IGPRD0105Form" property="formGlobalControl" styleId="formGlobalControl" errorStyleClass="inputError" tabindex="6">
                    		<html:option value="N">否</html:option>
                    		<html:option value="Y">是</html:option>
                    	</html:select>
                    </div>
                    <div>
						<label for="Name"><strong>JS方法</strong>：</label>
						<html:text property="jsfunction" name="IGPRD0105Form" styleId="jsfunction" size="18" style="width:200px;" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="red">只能包含字母、数字、"_"、"?"、"="</span>
					</div>
				</fieldset>
				<div class="enter">
					<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
				    <html:submit property="btn_insert" value="提交" styleClass="button"/>
				    <html:reset property="btn_clear" styleClass="button" value="重置" />
				    <%} %>
				</div>
				<html:hidden property="psdid" styleId="psdid" name="IGPRD0105Form"/>
				<html:hidden property="pdid" styleId="pdid" name="IGPRD0105Form"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>

</body>
</html:html>