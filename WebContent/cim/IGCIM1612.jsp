<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM1612" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style>
	fieldset div{
		
		text-align: left;
	}
	fieldset input{
		margin-left: 15px;
	}
</style>

	<script type="text/javascript">	
	function toback(){
		var form = document.forms[0];
		form.action = getAppRootUrl() +"/IGCIM1611.do?pid="+pid;
		form.submit();
    }
// 	function submitForm(){
// 		this.openner.refresh();
// 		this.close();
// 	}
		var pid = '${pid }';
// 	function init(){
// 		var flag = '${addFlag}';
// 		if(flag){
// 			//this.opener.window.location.reload(); 
// 			this.opener.window.location= getAppRootUrl()+"/IGCIM1611.do?pid="+pid; 
// 			this.close();
// 		}
// 	}
	
	function checkForm(){
		if(!document.getElementById('rName').value){
			alert("请填写关系名称!");
			return false;
		}
		if(!document.getElementById('rDescription').value){
			alert("请填写关系描述!");
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
		if(!document.getElementById('operationInfo').value){
			alert("请填写操作内容!");
			return false;
		}
		if(!document.getElementById('regDate').value){
			alert("请选择登记日期!");
			return false;
		}
	}
	
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
                   <div class="back"><html:link href="javascript:toback();">返回</html:link></div>
            </div> 

  
			  <div id="formwrapper" style="width:100%; text-align: center;">
        	<!--  message -->
                   <ig:message/>
            <!--  /message -->
        	<html:form action="IGCIM1611_Insert" method="POST" onsubmit="return checkForm()" >
        	<fieldset>
             <legend>密码变更关联关系添加</legend>
        	
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>关系名称</strong>：</label>
                     <html:text property="rName" styleId="rName" errorStyleClass="inputError imeActive" tabindex="0"></html:text>
                 </div>
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>关系描述</strong>：</label>
                     <html:text property="rDescription" styleId="rDescription" errorStyleClass="inputError imeActive" tabindex="1"/>
                 </div>
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>服务器IP</strong>：</label>
                     <html:text property="serverIp" styleId="serverIp" errorStyleClass="inputError imeActive"  tabindex="2"/>
                 </div>
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>操作内容</strong>：</label>
                    <html:text property="operationInfo" styleId="operationInfo" errorStyleClass="inputError imeActive"  tabindex="3"/>
                 </div>
        		<div>
                      <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.MarkDay"/></strong>：</label>
                      <html:text property="regDate" styleId="regDate" size="12" tabindex="5"  errorStyleClass="inputError imeActive" readonly="true" />
                      <img src="images/date.gif" align="middle" onClick="calendar($('regDate'))" border="0"/>
                      <br>
                </div>
        			<html:hidden property="pid" value="${pid }"/>
				
	            </fieldset>
	                <html:submit property="btn_insert"   styleClass="button"  value="提交" />
			</html:form>
			</div>
		 </div>
		 </div>
</body>
</html:html>