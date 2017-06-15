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
<meta http-equiv="Content-Language" content="ja">
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>" type="text/css">
<link rel="stylesheet" href="<html:rewrite forward='portal.css'/>" type="text/css"/>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<script language="JavaScript" src="<html:rewrite forward='calendar.js'/>" type="text/javascript" charset="gbk"></script>
<script language="JavaScript" src="<html:rewrite forward='SoftKey.js'/>" type="text/javascript" charset="gbk"></script>
<script language="JavaScript" src="js/igAjax.js" type="text/javascript" charset="gbk"></script>
<title><bean:write name="id"/><bean:write name="title"/></title>
<base target="_self">
<script type="text/javascript">
var ZD_mark=false;
</script>
</head>