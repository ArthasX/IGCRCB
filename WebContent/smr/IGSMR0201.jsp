<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSMR0201" toScope="request" />
<bean:define id="title" value="审批意见新增" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	//链接审批意见增加地址示例
	function url(prid, pidid) {
		var url = "IGSMR0201_Disp.do?prid=" + prid + "&pidid=" + pidid;
		window
				.showModalDialog(url, null,
						"dialogWidth:600px;dialogHeight:400px;status:no;help:no;resizable:no;");
	}
	function close_window() {
		window.close();
	}

	function checkForm() {
		if ($F('suggestion').strlen() > 512) {
			alert("审批意见不能大于" + Math.floor(512 / strByteFlag) + "个汉字！");
			return false;
		} else {
			var message = '请确认是否要进行审批意见填写？';
			if (window.confirm(message)) {
				return true;
			} else {
				return false;
			}
		}
	}
	function result(){
		<logic:present name="flag" >
			<logic:equal name="flag" value="1" >
					parent.returnAndClose(["审批意见保存成功！",${content}]);              
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
						<html:form styleId="form" action="/IGSMR0201"
							onsubmit="return checkSubmit(this);">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset style="width: 550px;">
								<legend>审批意见</legend>
								<div>
									<label for="Name"><strong>表单名称</strong>：</label>
									<p class="p2">${IGSMR02011VO.pidname}</p>
									<br>
								</div>
								<div>
									<label for="Name"><strong>审批意见</strong>：</label>
									<html:textarea name="IGSMR0201Form" property="suggestion"
										styleId="suggestion" errorStyleClass="inputError" rows="6"
										cols="40" tabindex="3" />
									<br>
								</div>
								<html:hidden property="id" name="IGSMR0201Form" />
								<html:hidden property="prid" name="IGSMR0201Form" />
								<html:hidden property="pidid" name="IGSMR0201Form" />
								<html:hidden property="rownumber" name="IGSMR0201Form" />
								<html:hidden property="psdcode" name="IGSMR0201Form"
									value="${IGSMR02011VO.ig500Info.prstatus}" />
								<input type="hidden" name="psdname"
									value='<ig:processDefineTypeValue prid="${IGSMR02011VO.ig500Info.prid}"/>'>
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