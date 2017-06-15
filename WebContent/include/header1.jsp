<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN">
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>" type="text/css">
<link type="text/css" href="css/portal.css" rel="stylesheet" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<script language="JavaScript" src="<html:rewrite forward='calendar.js'/>" type="text/javascript" charset="gbk"></script>
<script language="JavaScript" src="<html:rewrite forward='SoftKey.js'/>" type="text/javascript" charset="gbk"></script>
<script language="JavaScript" src="js/igAjax.js" type="text/javascript" charset="gbk"></script>
<title><bean:write name="id"/><bean:write name="title"/></title>
<base target="_self">

<script type="text/javascript" src="js/menu/jquery.js"></script>
<script>
	var j$ = jQuery.noConflict(true);//jquery与prototype冲突
	
</script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script>
	var jQ  = jQuery.noConflict(true);//jquery与prototype冲突
	jQuery = jQ;
</script>
<script type="text/javascript">
var ZD_mark=false;
String.prototype.trim = function(){return jQuery.trim(this)};
window.$F = function(name){
	return jQuery("[name='"+name+"']").val()||jQuery("#"+name).val()||"";
	}
</script>
</head>