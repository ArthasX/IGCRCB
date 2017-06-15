<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<title>IGSMR0901年度科技仪表盘</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<bean:define id="id" value="IGSMR0901" toScope="request" />
<bean:define id="title" value="年度科技仪表盘" toScope="request" />

<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
 
<script type="text/javascript">
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
   
	
</script>
<body>
<div class="box">
	
        <ul id="flyout">
        <li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
        <!--[if lte IE 6]><table><tr><td><![endif]-->
        <b></b>
        <ul>
            <ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT04STA"  showtitle="true"/>
        </ul>
        <!--[if lte IE 6]></td></tr></table></a><![endif]-->
        </li>
        </ul>
      <img src="images/03.png" alt="" />
</div>
</body>
</html:html>
