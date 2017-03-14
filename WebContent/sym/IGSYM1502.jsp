<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM1502" toScope="request" />
<bean:define id="title" value="新增数据定义基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function confirmDisp(){
		var message = '';
		var arg0= '数据定制基本信息';
		var alertClassfy= '请填写数据定制名称！';
		var alertClassfyNameMax= '数据定制名称不能大于';
		var alertCount= '个汉字！';
		var alertNO= '请填写数据定制编号！';
		var alertClassfyRemarkMax= '数据定制说明不能大于';
		message = "请确认是否要进行"+arg0+"变更处理?";
		if($("ccname").value.trim()==""){
			alert(alertClassfy);
			return false;
		}
		if($F('ccname').strlen()>128){
			alert(alertClassfyNameMax+Math.floor(128/strByteFlag)+alertCount);
			return false;
		}

		if($F('ccinfo').strlen()>40){
			alert(alertClassfyRemarkMax+Math.floor(40/strByteFlag)+alertCount);
			return false;
		}

		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}


	function checkCcid(obj){
		if(obj.value!=""){
			var alertNOMax= '请填入3位数字！';
			if(!checkIsNumberForSYM(obj.value)){
				alert(alertNOMax);
				obj.value = "";
				obj.focus();
				event.returnValue = false;
			}
		}
		
	}

	function checkIsNumberForSYM(str){
	 	myReg = /^[0-9]{3,3}$/;
		
	 	return myReg.test(str);
	}
//-->
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
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 数据分类新增</p>

<div class="back"><a href="IGSYM1501_Disp.do" target="_self">返回</a></div> 

</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGSYM1501" onsubmit="return checkSubmit(this);">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	<legend>新增数据分类信息</legend>

	<div><label for="Name"><strong><span class="red">*</span>树名称</strong>：</label>
	<html:text property="ccname" size="20" maxlength="30" errorStyleClass="inputError imeActive" tabindex="1" />
	<br />
	</div>
	
	<div style="display:none"><label for="Name"><strong><span class="red">*</span>数据分类编号</strong>：</label>
	<html:text  property="ccid" size="3" maxlength="3" errorStyleClass="inputError imeActive" tabindex="1" onchange="checkCcid(this);"/>
	注：请填入3位数字，如001。
	<br />
	</div>
	
	<div><label for="Name"><strong>树说明</strong>：</label> 
	<html:text property="ccinfo" size="20" maxlength="30" errorStyleClass="inputError imeActive" tabindex="2" /> 
	<br />
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_insert" styleClass="button" onclick="return confirmDisp();" >
		提交
	</html:submit> 
	<html:reset property="btn_clear" styleClass="button"  >
		重置
	</html:reset>
	</div>

</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>