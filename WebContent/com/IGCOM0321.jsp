<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Locale"%>
<%@ page import="org.apache.struts.Globals;"%>


<title>IGCOM0321影响分析</title>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">
<!--
	var gid='IGCOM0321';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/EnhancedRavisGraph_CN.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "EnhancedRavisGraph";
	attributes.name = "EnhancedRavisGraph";
	params.wmode = "Opaque";
	swfobject.embedSWF(xiSwfUrlStr,"flashContent", "2000", "1000", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

	function checkEntityItemInfo(eiid,eiversion,eismallversion){
		openSubIGCOM0316(eiid, eiversion, eismallversion);
	}
	
	function checkEIRelationInfo(srpareiid,srdomainid,srdomainversion,srparversion,srparsmallversion,srcreatetime){
		//openSubIGCOM0303_Relation(eiid);
		//alert(srpareiid+","+srdomainid+","+srdomainversion+","+srparversion+","+srparsmallversion+","+srcreatetime);
		openSubIGCOM0318_Relation(srpareiid,srdomainid,srdomainversion,srparversion,srparsmallversion,srcreatetime);
	}
	
    function initApp(){
    	<logic:present name="IGCOM0321Form" property="graphXml">
        var graphXml = "<bean:write name='IGCOM0321Form' property='graphXml' filter='false'/>"; 
        EnhancedRavisGraph.initXml(graphXml);
        </logic:present>
    }

	
//-->
</script>
<body>
<ig:message/>
<div id="flashContent">
</div>
</body>