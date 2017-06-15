<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSMR0306" toScope="request" />
<bean:define id="title" value="催办信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
	function close_window() {
		window.close();
	}

	function checkForm() {
		if ($F('view').trim() == "") {
			alert("请填写审批意见！");
			return false;
		}
		if ($F('view').strlen() > 256) {
			alert("审批意见不能大于" + Math.floor(256 / strByteFlag) + "个汉字！");
			return false;
		} 
		
	}
	function result(){
		<logic:present name="flag" >
			<logic:equal name="flag" value="1" >
					parent.returnAndClose("催办成功！");              
			</logic:equal>
		</logic:present>
	}
</script>
<body onload="result()">
	<div id="maincontent">
		<!--container 左菜单 右侧内容-->
		<div id="container" style="width: 600px; margin-left: 10px">
			<!--content  右侧内容-->
			<div id="contentWrap" style="width: 600px;">
				<div id="content">
					<div id="formwrapper" style="width: 600px;">
						<html:form styleId="form" action="/IGSMR0302"
							onsubmit="return checkSubmit(this);">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset style="width: 550px;">
								<legend>催办信息</legend>								
								<div>
									<html:textarea name="IGSMR0302Form" property="view"
										styleId="view" errorStyleClass="inputError" rows="6"
										cols="40" tabindex="3" />
									<br>
								</div>
								<html:hidden property="prid" name="IGSMR0302Form" />								
							</fieldset>
							<div class="enter">
								<html:submit property="btn_insert" value="提交"
									styleClass="button" onclick="return checkForm();" />
								<html:button property="btn_close" value="关闭" styleClass="button"
									onclick="return close_window();" />
							</div>
						</html:form>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
</html:html>