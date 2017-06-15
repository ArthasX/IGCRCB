<%@ page buffer="2048kb" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.net.URLEncoder" %>
<html:html>
<script type="text/javascript">
     function forword(){
        var forword = "${forword}";
        if(forword=="host"){
            window.location = "IGCOM0319_Relation.do?srpareiid_eq=${srpareiid_eq}&srdomainid_eq=${srdomainid_eq}"+
            	"&srdomainversion_eq=${srdomainversion_eq}"+
            	"&srparversion_eq=${srparversion_eq}&srparsmallversion_eq=${srparsmallversion_eq}&srcreatetime_eq=${srcreatetime_eq}";
        }else if (forword =="switch"){
        	window.location = "IGCOM0320_Relation.do?srpareiid_eq=${srpareiid_eq}&srdomainid_eq=${srdomainid_eq}"
            	+"&srdomainversion_eq=${srdomainversion_eq}&srparversion_eq=${srparversion_eq}&srparsmallversion_eq=${srparsmallversion_eq}&srcreatetime_eq=${srcreatetime_eq}";
        }else if (forword =="storage"){
        	window.location = "IGCOM0322_Relation.do?srcldeiid_eq=${srpareiid_eq}&srdomainid_eq=${srdomainid_eq}"
            	+"&srdomainversion_eq=${srdomainversion_eq}&srcldversion_eq=${srparversion_eq}&srcldsmallversion_eq=${srparsmallversion_eq}&srcreatetime_eq=${srcreatetime_eq}";
        }
        else {
            window.location = "IGCOM0319_Relation.do?srpareiid_eq=${srpareiid_eq}&srdomainid_eq=${srdomainid_eq}"
            	+"&srdomainversion_eq=${srdomainversion_eq}&srparversion_eq=${srparversion_eq}&srparsmallversion_eq=${srparsmallversion_eq}&srcreatetime_eq=${srcreatetime_eq}";
        }
     }
</script>
<body onload="forword()">
</body>
</html:html>