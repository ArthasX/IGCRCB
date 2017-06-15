<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html>
<bean:define id="id" value="IGCRC3001" toScope="request" />
<bean:define id="title" value="跳转页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">
jQuery(document).ready(function() { 
	//从后端获取的参数
	var platformuserid = '${platformuserid}';
	var title = '${ptitle}';//服务请求名称
	var desc = '${pdesc}';//服务请求描述
	var tree = '${tree}';//服务请求分类
	var type1 = '${type1}';//是否为生产数据导出申请
	var type2 = '${type2}';//影响程度
	var type3 = '${type3}';//紧急程度
	var attkey = '${attkey}';//附件key
	var attstr = '${attstr}';//附件显示的串
	var path = '${path}';//附件显示的串

	
	//获取访问路径
//	var str =  "http://192.168.0.155:8080/InfoGovernor/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01100&ptid=8&actname=ACT02SVC0602";
	var str =  path + "/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01100&ptid=8&actname=ACT02SVC0602";
	//用户名
	var user = "&platformuserid="+platformuserid;
	//整合成参数串
	var paramstr = title+"@_@"+desc+"@_@"+tree+"@_@"+type1+"@_@"+type2+"@_@"+type3+"@_@"+attkey+"@_@"+attstr;
	//post方式提交
	var form = document.createElement("form");
	form.target = "_self";
	form.action = str + user;
	form.method = "post";
	document.body.appendChild(form);
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "parameters";
	input.value = paramstr;
	form.appendChild(input);
	form.submit();

});
</script>
<body>
</body>
</html>

