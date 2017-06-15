<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html>
<bean:define id="id" value="IGCRC3003" toScope="request" />
<bean:define id="title" value="跳转页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">
jQuery(document).ready(function() { 
	//从后端获取的参数
	var platformuserid = '${platformuserid}';
	var title = '${ptitle}';//变更名称
	var desc = '${pdesc}';//变更描述
	var begintime = '${begintime}';//计划执行开始时间
	var tree = '${tree}';//变更类型
	var type1 = '${type1}';//变更类别
	var type2 = '${type2}';//变更分类
	var type3 = '${type3}';//更新平台
	var type4 = '${type4}';//变更原因分类
	var text1 = '${text1}';//变更原因
	var text2 = '${text2}';//变更内容
	var type5 = '${type5}';//是否影响业务
	var text3 = '${text3}';//执行计划
	var text4 = '${text4}';//回退计划
	var text5 = '${text5}';//验证计划
	var attkey = '${attkey}';//附件key
	var attstr = '${attstr}';//附件显示的串
	var path = '${path}';//附件显示的串

	
	//获取访问路径
//	var str =  "http://192.168.0.155:8080/InfoGovernor/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01100&ptid=8&actname=ACT02SVC0602";
	var str =  path + "/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01084&ptid=8&actname=ACT02SVC0402";
	//用户名
	var user = "&platformuserid="+platformuserid;
	//整合成参数串
	var paramstr = title+"@_@"+desc+"@_@"+begintime+"@_@"+tree+"@_@"+type1+"@_@"+type2+"@_@"+type3+"@_@"+type4+"@_@"+text1+"@_@"+text2+"@_@"+type5+"@_@"+text3+"@_@"+text4+"@_@"+text5+"@_@"+attkey+"@_@"+attstr;
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

