<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<html:html>
<bean:define id="id" value="ITEMS0104" toScope="request" />
<bean:define id="title" value="类别管理页面" toScope="request" />
<bean:define id="bean" name="ITEMS0104Form" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkForm(){

	if($F('category')==""){
		alert("物品种类不能为空！");
		return false;
	}
	if($F('seqcode')==""){
		alert("物品编号不能为空！");
		return false;
	}
	if($F('typecode')==""){
		alert("物品名称不能为空！");
		return false;
	}
	/*
	if($F('type')==""){
		alert("物品型号不能为空！");
		return false;
	}
	*/
	if($F('status')==""){
		alert("状态不能为空！");
		return false;
	}
	
	if($F('type').strlen()>32){
		alert("物品型号不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('typecode').strlen()>120){
		alert("物品名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('desc').strlen()>128){
		alert("描述不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 类别修改</p>
<div class="back"><a href="ITEMS0101.do" target="_self">返回</a></div>
</div>
<div id="formwrapper">
<html:form action="/ITEMS0104" onsubmit="return checkForm();">
	<!--  message -->
	<ig:message />
	<!--  /message -->
<fieldset><legend>物品信息</legend>
<div><label for="Name"><span class="red">*</span><strong>物品种类</strong>：</label>
<p class="p2">
<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
</p>
<br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品编号</strong>：</label>
<html:text property="seqcode" name="bean" size="30" /><br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品名称</strong>：</label>
<html:text property="typecode" size="30" name="bean"/> <br />
</div>
<div><label for="Name"><strong>物品型号</strong>：</label>
<html:text property="type" size="30" name="bean" /><br />
</div>
<div><label for="Name"><span class="red">*</span><strong>状态</strong>：</label>
<html:select property="status" name="bean">
	<html:option value="1">使用</html:option>
	<html:option value="0">停用</html:option>
</html:select> <br />
</div>
<div><label for="Name"><strong>说明</strong>：</label> 
<html:textarea property="desc" cols="60" rows="5" name="bean"></html:textarea><br />
</div>

</fieldset>
<div class="enter">
	<html:hidden property="category" name="bean"/>
	<html:hidden property="icid" name="bean"/>
	<input name="save" type="submit" class="button" value="提交" /> 
	<input name="cancel" type="reset" class="button" value="重置" />
</div>
</html:form>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>