<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0102h" toScope="request"/>
<logic:equal name="IGPRD0102Form" property="mode" value="0">
<bean:define id="title" value="流程基本信息登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGPRD0102Form" property="mode" value="1">
<bean:define id="title" value="流程基本信息查看画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		var title = "主题简述";
		var desc = "内容描述";
	    function toback(){
	        IGPRD0102Form.action = getAppRootUrl() + "/IGPRD0140_Back.do?pdid=IGPRD0102Form.pdid";
	        IGPRD0102Form.submit();
	    }

	    function checkForm(){
	    	if($F('pdname').trim() == ""){
	    		alert("请输入流程名称！");
	    		return false;
	    	}
	    	if($F('pdname').strlen()>128){
	    		alert("流程名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('ptitlename').trim() == ""){
	    		alert("请输入"+title+"！");
	    		return false;
	    	}
	    	if(document.getElementById("ptitle").checked){
	    		if($F('ptitlename').strlen()>32){
		    		alert(title+"不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		    		return false;
		    	}
		    }
	    	if($F('pdescname').trim() == ""){
	    		alert("请输入"+desc+"！");
	    		return false;
	    	}
	    	if(document.getElementById("pdesc").checked){
	    		if($F('pdescname').strlen()>32){
		    		alert(desc+"不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		    		return false;
		    	}
		    }
	    	if($F('pddesc').strlen()>64){
	    		alert("流程说明不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '';
	            if ('${IGPRD0102Form.mode}' == '0'){
	                message = '<bean:message key="IGCO10000.W001" arg0="流程基本信息" />';
	            } else {
	                message = '<bean:message key="IGCO10000.W003" arg0="流程基本信息" />';
	            }
				if( window.confirm(message)){
					document.getElementById("ptitleaccess").value = document.getElementById("ptitle").checked==true?<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>:<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>;
					document.getElementById("pdescaccess").value= document.getElementById("pdesc").checked==true?<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>:<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>;
					return true;
				} else {
					return false;
				}
	    	}
	    }
	    function initValue(){
		  	<c:if test = "${IGPRD0102Form.mode == '0'}">
    			document.getElementById("ptitlename").value = title;
    			document.getElementById("pdescname").value = desc;
    			document.getElementById("ptitle").checked=true;
    			document.getElementById("pdesc").checked=true;
    		</c:if>
    		<c:if test = "${IGPRD0102Form.mode == '1'}">
				document.getElementById("ptitle").checked=true;
				document.getElementById("pdesc").checked=true;
    			<c:if test = "${IGPRD0102Form.ptdid == 0}">
					document.getElementById("ptitlename").value = title;
					document.getElementById("pdescname").value = desc;
				</c:if>
				<c:if test = "${IGPRD0102Form.ptdid > 0}">
					<c:if test = "${IGPRD0102Form.ptitleaccess == '1'}">
						document.getElementById("ptitle").checked=false;
					</c:if>
					<c:if test = "${IGPRD0102Form.pdescaccess == '1'}">
						document.getElementById("pdesc").checked=false;
					</c:if>
				</c:if>
			</c:if>
		}
	</script>
<body onload="initValue()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt;流程管理 &gt;&gt; 历史版本 &gt;&gt;流程定义 &gt;&gt; 
	                <logic:equal name="IGPRD0102Form" property="mode" value="0">
	                                             流程登记
	                </logic:equal>
					<logic:equal name="IGPRD0102Form" property="mode" value="1">
					流程查看
					</logic:equal>
                </p>
                <logic:equal name="IGPRD0102Form" property="mode" value="1">
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGPRD0102"  onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGPRD0102Form" property="mode" value="0">
					    <legend>基本信息添加</legend>
					</logic:equal>
					<logic:equal name="IGPRD0102Form" property="mode" value="1">
	                          <legend>基本信息查看</legend>
					</logic:equal>

					
                    <div>
						<label for="Name"><strong><span class="red">*</span>流程名称</strong>：</label>
						<html:text name="IGPRD0102Form" property="pdname" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1" />
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>流程日志权限</strong>：</label>
						<html:select name="IGPRD0102Form" property="permission" styleId="permission" tabindex="1" >
							<html:option value="<%=IGPRDCONSTANTS.RECORDLOG_PERMISSION_NO %>">无权限控制</html:option>
							<html:option value="<%=IGPRDCONSTANTS.RECORDLOG_PERMISSION_YES %>">同角色可见</html:option>
						</html:select>
						<br>
    				</div>
	       			<div>
					    <label for="Name"><strong>流程说明</strong>：</label>
					    <html:text name="IGPRD0102Form" property="pddesc" styleId="pddesc" tabindex="3" size="41" style="width:450px;" errorStyleClass="inputError" />
					    <br>
    				</div>
    				</fieldset>
    			<fieldset>
					<logic:equal name="IGPRD0102Form" property="mode" value="0">
					    <legend>基本表单信息设定</legend>
					</logic:equal>
					<logic:equal name="IGPRD0102Form" property="mode" value="1">
	                          <legend>基本表单信息变更</legend>
					</logic:equal>
    				<div>
						<label for="Name"><strong><span class="red">*</span>主题名称</strong>：</label>
						<html:text name="IGPRD0102Form" maxlength="32" property="ptitlename" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"  />
						&nbsp;&nbsp;
						<input type="checkbox" id="ptitle" />可见
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>描述名称</strong>：</label>
						<html:text name="IGPRD0102Form" maxlength="32" property="pdescname" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1" />
						&nbsp;&nbsp;
						<input type="checkbox" id="pdesc" />可见
						<br>
    				</div>
    				</fieldset>
				<div class="enter" style="display:none">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				</div>
		        <html:hidden property="pdid" styleId="pdid" name="IGPRD0102Form"/>
		        <html:hidden property="ptid" styleId="ptid" name="IGPRD0102Form"/>
		        <html:hidden property="mode" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="ptdid" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="ptitleaccess" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="pdescaccess" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="pttype" styleId="pttype" name="IGPRD0102Form" value="WD"/>
		        <html:hidden property="pdname_bak" styleId="pdname_bak" name="IGPRD0102Form"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>

</body>
</html:html>