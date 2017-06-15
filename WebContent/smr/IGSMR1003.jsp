<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSMR1003" toScope="request" />
<bean:define id="title" value="信息科技项目分析" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="js/swfobject.js"></script>

<script type="text/javascript">

        var swfVersionStr = "12.0.0";
        var xiSwfUrlStr = "images/dbmswf/QuarTecAnalyseMain.swf";
        var flashvars = {};
        var params = {};
        var attributes = {};
        attributes.id = "QuarTecAnalyseMain";
        attributes.name = "QuarTecAnalyseMain";
        params.wmode = "Opaque";
        swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1010", "800", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

        
     	function quit(){
    		if(window.confirm("您确定要退出系统吗？")){
    			window.location="./IGCOM0102.do";
    		}
    	}

        function initApp(){
         	setQuarAnalysePieGraph(null,null,null);
        	setQuarAnalyseTrendGraph(null,null);
        	setQuarAnalyseGridGraph(null,null);
        }

        function setQuarAnalysePieGraph(proAttr,year,quarter){
            var res;
            var parametersStr = 'searchType=PieGraph';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            if(quarter != null) parametersStr = parametersStr + '&quarter='+quarter;
            if(proAttr != null) parametersStr = parametersStr + '&projectAttr='+proAttr;
     		try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0903_Search.do",{asynchronous:false, 
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

	            QuarTecAnalyseMain.getQuarAnalysePieGraph(res);
     		}catch(err){
 				setTimeout("setQuarAnalysePieGraph("+proAttr+","+year+","+quarter+")",100);
			}
        }

        function setQuarAnalysePieGraphByQuery(proAttr,year,quarter){
            var res;
            var parametersStr = 'searchType=PieGraph';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            if(quarter != null) parametersStr = parametersStr + '&quarter='+quarter;
            if(proAttr != null) parametersStr = parametersStr + '&projectAttr='+proAttr;
            new Ajax.Request(getAppRootUrl() + "/IGSMR0903_Search.do",{asynchronous:false, 
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
             return res;
        }
        
        function setQuarAnalyseTrendGraph(year,quarter){
            var res;
            var parametersStr = 'searchType=TrendGraph';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            if(quarter != null) parametersStr = parametersStr + '&quarter='+quarter;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0903_Search.do",{asynchronous:false, 
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
	            QuarTecAnalyseMain.getQuarAnalyseTrendGraph(res);
	           
			}catch(err){
				setTimeout("setQuarAnalyseTrendGraph("+year+","+quarter+")",50);
			}
        }
        
        function setQuarAnalyseGridGraph(year,quarter){
            var res;
            var parametersStr = 'searchType=GridGraph';
            if(year != null) parametersStr = parametersStr + '&year='+year;
            if(quarter != null) parametersStr = parametersStr + '&quarter='+quarter;
            try{
	            new Ajax.Request(getAppRootUrl() + "/IGSMR0903_Search.do",{asynchronous:false, 
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
	            QuarTecAnalyseMain.getQuarAnalyseGridGraph(res);
			}catch(err){
				setTimeout("setQuarAnalyseGridGraph("+year+","+quarter+")",50);
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