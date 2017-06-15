<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0109" toScope="request" />
<bean:define id="title" value="系统可用率分析" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
         var swfVersionStr = "10.0.0";
         var xiSwfUrlStr = "images/dbmswf/SystemUse.swf";
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "SystemUse";
         attributes.name = "SystemUse";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1005", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);


     	function quit(){
    		if(window.confirm("您确定要退出系统吗？")){
    			window.location="./IGCOM0102.do";
    		}
    	}
    	
 		 //当鼠标移动到菜单选择栏时调用的方法
 		 function getSystemUseValue(selectSystemId){
    		 var res = "";
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=systemUse&requestMode=selectValue&systemid='+selectSystemId,
    				 onSuccess:  function(req, json){
    				 var result=req.responseText;
    					if(result != null && result != ""){
    						res=result;
    					}else{
    						return "";	
    					}
    			    }
    			});

    			var resarray = res.split('#');
    			
    			//设置当前实际可用率
    	        setMeterModeHong(resarray[0]);
    	         
    	      	 //设置实际可用率全年累计
    	        setMeterModeZi(resarray[1]);
    	         
    	       	//设置可用率年度趋势
    	        setSystemUseLine(resarray[2]);
    			
 		 }

 		 //设置当前实际可用率
         function setMeterModeHong(stepLength){
        	 SystemUse.setSystemUseMeterHong(stepLength);
         }
         
      	 //设置实际可用率全年累计
         function setMeterModeZi(stepLength){
        	 SystemUse.setSystemUseMeterZi(stepLength);
         }
         
       //设置可用率年度趋势
         function setSystemUseLine(strXml){
        	 SystemUse.setSystemUseLine(strXml);
         }
         
         //设置工作及时解决率趋势
         function setSystemUsePillar(strXml){
        	 SystemUse.setSystemUsePillar(strXml);
         }
         
		//程序初始化入口
         function initApp(){
             try{
	             var pn1Value = '<bean:write name="AD_PN1RETURN" filter="false" />';
	             var pn2Value = '<bean:write name="AD_PN2RETURN" filter="false" />';
	             var pn3Str =   '<bean:write name="AD_PN3RETURN" filter="false" />';
	             var pn4Str =   '<bean:write name="AD_PN4RETURN" filter="false" />';
	             setMeterModeHong(pn1Value);
	             setMeterModeZi(pn2Value);
	             setSystemUseLine(pn3Str);
	             setSystemUsePillar(pn4Str);
             }catch(err){
            	 setTimeout("initApp()",2000);
             }
         }
</script>
        
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="initApp();">

<div class="box">

		<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
				<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT04STA" />
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
<div id="flashContent">
</div>
</div>


</body>

</html:html>