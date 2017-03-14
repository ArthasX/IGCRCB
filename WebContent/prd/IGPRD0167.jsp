<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRD0166" toScope="request" />
<bean:define id="title" value="表单初始化配置修改" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function toback(pdid,psdid) {
		form.action = getAppRootUrl() + "/IGPRD0165_Disp.do?pdid=" + pdid+"&psdid=" + psdid + "&ppsdid=${IGPRD0166Form.ppsdid}";
		form.submit();
	}
	function checkForm() {
		if ($F('piidblid').trim() == "") {
			alert("请输入自定义BL名称！");
			return false;
		}
		if ($F('piidblid').strlen() > 32) {
			alert("自定义BL名称不能大于32个字符！");
			return false;
		}
		if($F('piiddec').strlen() > 256){
			alert("任务描述不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
			return false;
		}
		else {
			var message = '请确认是否修改？';
			if (window.confirm(message)) {
				return true;
			} else {
				return false;
			}
		}
	}
</script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt;
							状态列表 &gt;&gt; 表单初始化配置 &gt;&gt; 修改</p>
						<div class="back">
							<html:link href="javascript:toback('${IGPRD0166Form.pdid}','${IGPRD0166Form.psdid}');">返回</html:link>
						</div>
					</div>
					<div id="formwrapper">
						<html:form styleId="form" action="/IGPRD0166_Edit.do">
							<ig:message />
							<fieldset>
								<legend>表单初始化配置修改</legend>
								<div>
									<label for="Name"><strong><span class="red">*</span>自定义BL名称</strong>：</label>
									<html:text property="piidblid" styleId="piidblid" size="32"
										style="width:200px;" errorStyleClass="inputError" tabindex="1" />
									<br>
								</div>
								<div>
									<label for="Name"><strong>任务描述</strong>：</label>
									<html:textarea property="piiddec" styleId="piiddec" cols="60"
										rows="6" errorStyleClass="inputError imeActive" tabindex="4" />
									<br>
								</div>
							</fieldset>
							<div class="enter">
								<html:submit property="btn_insert" value="提交"
									styleClass="button" onclick="return checkForm();" />
								<html:submit property="btn_back" styleClass="button" value="返回"
									onclick="javascript:toback('${IGPRD0166Form.pdid}', '${IGPRD0166Form.psdid}')" />
							</div>
							<html:hidden name="IGPRD0166Form" property="pdid" />
							<html:hidden name="IGPRD0166Form" property="psdid" />
							<html:hidden name="IGPRD0166Form" property="ppsdid" />
							<html:hidden name="IGPRD0166Form" property="piidid" />
						</html:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>