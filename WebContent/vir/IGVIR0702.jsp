<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR0702" toScope="request" />
<logic:equal name="IGVIR0702Form" property="mode" value="0">
	<bean:define id="title" value="vCenter新增" toScope="request" />
</logic:equal>
<logic:equal name="IGVIR0702Form" property="mode" value="1">
	<bean:define id="title" value="vCenter修改" toScope="request" />
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function toback(){
		location.href = "IGVIR0701.do";
	}
	function checkVir0702(){
		if($("vcname").value.trim()==""){
			alert("请输入名称！");
			return false;
		}
		if($("vcurl").value.trim()==""){
			alert("请输入IP！");
			return false;
		}else{
			var vir0702flag = '0';
			if($("mode").value=="0"){
				vir0702flag = '1';
			}else if($("oldurl").value!=$("vcurl").value){
				vir0702flag = '1';
			}
			if(vir0702flag == '1'){
				var res="";
				var objAjax = new Ajax.Request(getAppRootUrl() + "/IGVIR0702_CHECK.do",{asynchronous:false, 
					parameters: 'vcurl='+ $("vcurl").value,
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return "";
						}
				    }
				});
				if(res == '1'){
					alert("IP重复！");
					return false;
				}
			}
		}
		if($("vcusername").value.trim()==""){
			alert("请输入用户名！");
			return false;
		}
		if($("vcpassword").value.trim()==""){
			alert("请输入密码！");
			return false;
		}
		if(!window.confirm("确认提交？")){
			return false;
		}
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">虚拟化管理 &gt;&gt; vCenter管理 &gt;&gt; 
<logic:equal name="IGVIR0702Form" property="mode" value="0">vCenter新增</logic:equal>
<logic:equal name="IGVIR0702Form" property="mode" value="1">vCenter变更</logic:equal>
</p>
<logic:equal name="IGVIR0702Form" property="mode" value="1">
	<div class="back"><a href="javascript:toback();" target="_self">返回</a></div> 
</logic:equal>
</div>
<div id="formwrapper">
<html:form styleId="form"
 	action="/IGVIR0702_INSERT" onsubmit="return checkSubmit(this);">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
 	<fieldset>
 	<logic:equal name="IGVIR0702Form" property="mode" value="0">
		<legend>新增vCenter信息</legend>
	</logic:equal> 
	<logic:equal name="IGVIR0702Form" property="mode" value="1">
		<legend>修改vCenter信息</legend>
	</logic:equal>
 	<div><label for="Name"><strong><span class="red">*</span>名称</strong>：</label>
 	<html:text property="vcname" style="width:300px;"/> <br />
	</div>
 	<div><label for="Name"><strong><span class="red">*</span>IP</strong>：</label> <html:text 
		property="vcurl" style="width:300px;"/> <br />
	</div>
 	<div><label for="Name"><strong><span class="red">*</span>用户名</strong>：</label> <html:text 
		property="vcusername" style="width:300px;"/> <br />
	</div>
 	<div><label for="Name"><strong><span class="red">*</span>密码</strong>：</label> <html:text 
		property="vcpassword" style="width:300px;"/> <br />
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
 		styleClass="button" onclick="return checkVir0702();"/> <html:reset 
		property="btn_clear" styleClass="button" value="重置" /></div>
		
	<html:hidden property="vcid"/>
	<html:hidden property="mode"/>
</html:form>
<input type="hidden" id="oldurl" value="${IGVIR0702Form.vcurl}">
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>