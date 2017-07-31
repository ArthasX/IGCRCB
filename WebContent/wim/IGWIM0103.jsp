<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGWIM0103" toScope="request" />
<bean:define id="title" value="工作项数据导入" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">
function onSearch() {
	var check = true;
		var obj = document.getElementById("fileMap");
		if (obj.value == "") {
			alert("请选择上传的文件");
			check = false;
		} else {
			var suffix = obj.value.substring(obj.value.lastIndexOf(".") + 1);
			if (suffix != "xls") {
				alert("请上传Excel2003类型文件");
				check = false;
			}
		}
		return check; 
	}
	jQuery(function($){
		var result="${IGWIM0102Form.result}";
		if(result!=''){
			alert(result);
			if(window.opener.form){
				window.opener.form.submit();
			}
			if(result=='导入成功！'){
				window.close();
			}
		}
	});
	
</script>
<body >
<div id="maincontent">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGWIM0102_Import.do" styleId="formform" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<ig:message />
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
	数据导入</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<label for="Name"><strong><span class="red">*</span>选择文件</strong>：</label> 
	<html:file property="fileMap" styleId="fileMap" style="width:367px;heigth:20px;" />
	<html:submit property="btn_insert" styleClass="button" onclick="return onSearch();" value="导入"/>
	<input type="button" value="关闭" class="button" onclick="window.close();"/>
	</div>
	</div>
	</div>
	</html:form>
</div>
</div>
</div>
</body>
</html:html>
