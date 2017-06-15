<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0107" toScope="request" />
<bean:define id="title" value="变更流程综合分析" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
         var swfVersionStr = "10.0.0";
         var xiSwfUrlStr = "images/dbmswf/ProcessChange.swf";
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "processChange";
         attributes.name = "processChange";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1005", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);


     	function quit(){
    		if(window.confirm("您确定要退出系统吗？")){
    			window.location="./IGCOM0102.do";
    		}
    	}
    	
 		 function getFlexSubmitValue(typeValue,yearValue,pn1Value,pn2Value,pn3Value,pn4Value){
   			 var res;
	   		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	   				parameters: 'type=processChange&&requestMode=allMode&typeValue='+
	   							typeValue+'yearValue='+yearValue+"pn1Value="+pn1Value+
	   							"pn2Value="+pn2Value+"pn3Value="+pn3Value+"pn4Value="+pn4Value,
	   				 onSuccess:  function(req, json){
	   				 var result=req.responseText;
	   					if(result != null && result != ""){
	   						res=result;
	   					}else{
	   						return "";	
	   					}
	   			    }
	   			});
             var pieValue = res.split('#')[0];
             var pn1Str =   res.split('#')[1];
             var pn2Str =   res.split('#')[2];
             var pn3Str =   res.split('#')[3];
             
             setPieGraph(pieValue.split('|')[0],pieValue.split('|')[1],pieValue.split('|')[2],pieValue.split('|')[3]);
             setProcessLine1(pn1Str);
             setProcessLine2(pn2Str);
             setProcessLine3(pn3Str);
 		 }

 		 //当鼠标移动到导航条时调用的方法
 		 function getProcessNavigateValue(typeValue,yearValue,navigateValue,navigateType){

    		 var res = "";
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=processChange&requestMode=navigateValue&typeValue='+
    							typeValue+'&yearValue='+yearValue+"&navigateValue="+navigateValue+
    							'&navigateType='+navigateType,
    				 onSuccess:  function(req, json){
    				 var result=req.responseText;
    					if(result != null && result != ""){
    						res=result;
    					}else{
    						return "";	
    					}
    			    }
    			});

    			if(navigateType =='pn1'){ //设置月变更类型数量及占比
    				setPieGraph(res.split('|')[0],res.split('|')[1],res.split('|')[2],res.split('|')[3]);
    			}
    			if(navigateType =='pn2'){ //设置变更平均解决时间趋势
    				setProcessLine2(res);
    			}
    			if(navigateType =='pn3'){//设置变更数量趋势
    				setProcessLine1(res);
    			}
    			if(navigateType =='pn4'){//设置变更及时解决率趋势
    				setProcessLine3(res);
    			}
 		 }

 		 //设置月变更类型数量及占比
         function setPieGraph(p1value,p2value,p3value,p4value){
        	 processChange.setPieGraph(p1value,p2value,p3value,p4value);
         }
         
      	 //设置变更数量趋势
         function setProcessLine1(strXml){
        	 processChange.setProcessLine1(strXml);
         }
         
       //设置变更平均解决时间趋势
         function setProcessLine2(strXml){
        	 processChange.setProcessLine2(strXml);
         }
         
       //设置变更及时解决率趋势
         function setProcessLine3(strXml){
            processChange.setProcessLine3(strXml);
         }
         
		//程序初始化入口
         function initApp(){
             try{
	             var pieValue = '<bean:write name="AD_PN1RETURN" filter="false" />';
	             var pn1Str =   '<bean:write name="AD_PN2RETURN" filter="false" />';
	             var pn2Str =   '<bean:write name="AD_PN3RETURN" filter="false" />';
	             var pn3Str =   '<bean:write name="AD_PN4RETURN" filter="false" />';
	             
	             setPieGraph(pieValue.split('|')[0],pieValue.split('|')[1],pieValue.split('|')[2],pieValue.split('|')[3]);
	             setProcessLine1(pn1Str);
	             setProcessLine2(pn2Str);
	             setProcessLine3(pn3Str);
             }catch(err){
            	 setTimeout("initApp()",2000);
             }
         }
</script>
        
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="initApp();">


<div class="box">
	<div>
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
	</div>
		<div id="flashContent" style="z-index: -1"></div>
</div>



</body>

</html:html>