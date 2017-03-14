<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Locale"%>
<%-- <%@ page import="org.apache.struts.Globals;"%> --%>
<%
// 	Locale loc = Locale.getDefault();
// 	if (request.getSession().getAttribute(Globals.LOCALE_KEY) != null) {
// 		loc = (Locale) request.getSession().getAttribute(
// 				Globals.LOCALE_KEY);
// 	}
%>
<html:html>
<bean:define id="id" value="IGSMR1002" toScope="request" />
<bean:define id="title" value="年报" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="js/swfobject.js"></script>

<script type="text/javascript">

		function initApp(){
// 	    	setTechnologyInfo(null);
// 	    	setPersonnel(null);
// 	    	setTechnologyNumber(null);
// 	    	setPieGraph(null);
// 	  		setBarGraph(null);
// 	    	setTechnologySort(null);
// 	    	setTechnologyAudit(null);
		}
		 var time;
         var swfVersionStr = "12.0.0";
         var xiSwfUrlStr = "images/dbmswf/YearDashboardMain.swf";
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "YearDashboardMain";
         attributes.name = "YearDashboardMain";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1010", "800", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

        
     	function quit(){
    		if(window.confirm("您确定要退出系统吗？")){
    			window.location="./IGCOM0102.do";
    		}
    	}

        function setTechnologyInfo(year){
            
        	var a;
            var res;
            var parametersStr = 'searchType=TechnologyInfo';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                    onSuccess:  function(req, json){
	                    var result=req.responseText;
	                       if(result != null && result != ""){
	                           res=result;
	                       }else{
	                    	   res= "";  
	                       }
	                   }
	               });
            	a = YearDashboardMain.getTechnologyInfo(res);
			}catch(err){
				time = setTimeout("setTechnologyInfo("+year+")",100);
			}	
        }
        
        function setPersonnel(year){
        	var a;
            var res;
            var parametersStr = 'searchType=Personnel';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                   onSuccess:  function(req, json){
	                   var result=req.responseText;
	                      if(result != null && result != ""){
	                          res=result;
	                      }else{
	                    	  res= "";  
	                      }
	                  }
	               });
	            a = YearDashboardMain.getPersonnel(res);
			}catch(err){
				setTimeout("setPersonnel("+year+")",100);
			}
        }
        
        function setTechnologyNumber(year){
        	var a;
            var res;
            var parametersStr = 'searchType=TechnologyNumber';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                   onSuccess:  function(req, json){
	                   var result=req.responseText;
	                      if(result != null && result != ""){
	                          res=result;
	                      }else{
	                    	  res= "";  
	                      }
	                  }
	               });
	            a = YearDashboardMain.getTechnologyNumber(res);
			}catch(err){
				setTimeout("setTechnologyNumber("+year+")",100);
			}
        }
        
        function setPieGraph(year){
            var a;
            var res;
            var parametersStr = 'searchType=PieGraph';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                   onSuccess:  function(req, json){
	                   var result=req.responseText;
	                      if(result != null && result != ""){
	                          res = result;
	                          
	                      }else{
	                    	  res = "";  
	                      }
	                  }
	               });
// 	            console.log(res);
	            a = YearDashboardMain.getPieGraph(res);
	        }catch(err){
				setTimeout("setPieGraph("+year+")",100);
			}
        }
        
        function setBarGraph(year){
            var a;
            var res;
            var parametersStr = 'searchType=BarGraph';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                   onSuccess:  function(req, json){
	                  
	                   var result=req.responseText;
	                      if(result != null && result != ""){
	                          res=result;
	                      }else{
	                          res = "";  
	                      }
	                  }
	               });
	            a = YearDashboardMain.getBarGraph(res);
	         
	        }catch(err){
				setTimeout("setBarGraph("+year+")",100);
			}
        }
        
        function setPieGraph1(year){
            var a;
            var res;
            var parametersStr = 'searchType=TechnologySort';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                   onSuccess:  function(req, json){
	                   var result=req.responseText;
	                      if(result != null && result != ""){
	                          res=result;
	                      }else{
	                    	  res= "";  
	                      }
	                  }
	               });
// 	            console.log(res);
	            a = YearDashboardMain.getPieGraph1(res);
	      	  }catch(err){
				setTimeout("setTechnologySort("+year+")",100);
			  }
        }

        function setTechnologyAudit(year){
            var a;
            var res;
            var parametersStr = 'searchType=TechnologyAudit';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0902_Search.do",{asynchronous:false, 
	                   parameters: parametersStr,
	                   onSuccess:  function(req, json){
	                   var result=req.responseText;
	                      if(result != null && result != ""){
	                          res=result;
	                      }else{
	                    	  res= "";  
	                      }
	                  }
	               });
	            a = YearDashboardMain.getTechnologyAudit(res);
	    	  }catch(err){
	  			setTimeout("setTechnologyAudit("+year+")",100);
	  		  }
        }
     function autoHeight(){
     	  document.getElementById("bg").style.height=document.getElementById("it").getElementsByTagName("li").length*22;
     }
</script>
<body onload="initApp();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--sidebar  左菜单-->
<!--content  右侧内容-->
	<div id="dbmcontentWrap">
	<div id="content">
<div class="box">

		<!-- 在此显示菜单 -->
<!-- 		<ul id="flyout"> -->
<!-- 		<li><a href="#" class="nikon">[if gte IE 7]><!</a><![endif] -->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
<!-- 		<b id="bg"></b> -->
<!-- 		<ul id="it"> -->
<%-- 		<ig:dbMenu acturl="<%=request.getContextPath()%>"/> --%>
<!-- 		</ul> -->
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
<!-- 		</li> -->
<!-- 		</ul>		 -->
<div id="flashContent">
</div>
</div>
	</div>
	</div>
</div>
</div>
</body>

</html:html>