<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM1602" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	
	</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 
			<div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div> 
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
        
        
        
        <div id="formwrapper">
        	<!--  message -->
                   <ig:message/>
            <!--  /message -->
        	<html:form action="IGCIM1601_Insert" method="POST" onsubmit="return checkForm()">
             <fieldset>
             <legend>密码变更信息添加</legend>
        	
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>密码分类</strong>：</label>
                     <html:select property="pwdType">
                     	 <ig:optionsCollection ccid="PWD_TYPE" isMakeBlankRow="true" isCodeLabel="true"/>
                     </html:select>
                 </div>
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>服务器IP</strong>：</label>
                     <html:text property="serverIP" errorStyleClass="inputError imeActive" tabindex="1"/>
                 </div>
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>用户名</strong>：</label>
                     <html:text property="userName" errorStyleClass="inputError imeActive"  tabindex="2"/>
                 </div>
<!--         		 <div> -->
<!--                      <label for="Name"><strong><span class="red"></span>密码</strong>：</label> -->
<%--                      <html:text property="pwd" errorStyleClass="inputError imeActive" readonly="true" tabindex="3"/> --%>
<!--                  </div> -->
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>密码描述</strong>：</label>
                     <html:text property="pwdDescription" errorStyleClass="inputError imeActive"  tabindex="4"/>
                 </div>
        		<div>
                      <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.MarkDay"/></strong>：</label>
                      <html:text property="regDate" styleId="regDate" size="12" tabindex="5"  errorStyleClass="inputError imeActive" readonly="true" />
                      <img src="images/date.gif" align="middle" onClick="calendar($('regDate'))" border="0"/>
                      <br>
                </div>
        	
			</fieldset>
				<div class="enter">
	                <html:submit property="btn_insert"   styleClass="button"  value="提交" />
	            </div>
			</html:form>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
<script type="text/javascript">
function checkForm(){
	if(!document.getElementById('pwdType').value){
		alert("请选择密码类型!");
		return false;
	}
	if(!document.getElementById('serverIp').value){
		alert("请填写服务器IP!");
		return false;
	}else{
		var rex = new RegExp(/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/);
		if(!rex.test(document.getElementById('serverIp').value)){
			alert("请正确填写服务器IP");
			return false;
		}
	}
	if(!document.getElementById('userName').value){
		alert("请填写用户名!");
		return false;
	}
	if(!document.getElementById('pwdDescription').value){
		alert("请填写密码描述!");
		return false;
	}
	if(!document.getElementById('regDate').value){
		alert("请选择登记日期!");
		return false;
	}
}
</script>


</html:html>