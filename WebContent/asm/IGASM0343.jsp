<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="java.util.Map"%>
<%@ page import="com.deliverik.framework.tree.TreeNode"%>
<html:html>
<bean:define id="id" value="IGASM0343" toScope="request"/>
<bean:define id="title" value="配置信息画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<STYLE>
html{
  overflow-y: auto;
  overflow-x: auto;
}

</STYLE>
<script type="text/javascript">
    var gid='IGCOM0343';
	function goComp(eiid){
		var url = "/IGASM0344_Disp.do?eiid="+eiid;
		openSubWindow(url, '_blank', '800', '600');
	}
</script>
<body  scroll="auto">
<div id="maincontent">
<div id="container">
	    <div id="location">
	        <div class="image"></div>
	            <p class="fonts1">配置详细信息</p>
	    </div>

		<logic:present name="IGASM03011VO" property="infoMap">
	    <div id="results_list">
	       <table border="1" >
			
	        <logic:iterate id="map" name="IGASM03011VO" property="infoMap" indexId="number">
	           <tr>
	               <td width="10%" >
	               
	               ${map.key}
	               
	               </td>
	               
	               <td width="90%" style="padding-left:10px;padding-top:10px">
	               <pre >
	               ${map.value}
	               </pre>
	               </td>
	           </tr>
	        </logic:iterate>
	       </table>
	    </div>
	    </logic:present>

	    <div id="operate">
		        <div class="content">
			            <div class="enter">
			                <input type="button" name="btn_close" value="比较"  onclick="goComp('${IGASM0301Form.eiid}');" class="button">
			            </div>
		        </div> 
	    </div>
</div>
</div>
</body>
</html:html>