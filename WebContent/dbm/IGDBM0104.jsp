<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0104" toScope="request" />
<bean:define id="title" value="运行分析" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type=text/javascript>
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}

	var sp1="db";
	var sp2="db";
	var sp3="db";
	var sp4="db";

	 function playMovie() {
		 try{
			setEquipment();
			setLineForHour1();
			setLineForHour2();
			setLineForHour3();
			setLineForHour4();
			setMeterDouble();
			setSystemPillar1();	
			setSystemPillar2();	
			setSystemPillar3();	
			setSystemPillar4();	
		 }catch(err){
				
		}
	 }

	 function initPlay() { 
			setLineForHour1();
			setLineForHour2();
			setLineForHour3();
			setLineForHour4();
			setDoubleColorLine();
			setEquipment();
			setMeterDouble();
			setSystemPillar1();	
			setSystemPillar2();	
			setSystemPillar3();	
			setSystemPillar4();	
		}

	 function setEquipment() {
			var res;
			var flexrel="";
			try{
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=BasicEquipment&requestMode=equipment',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return true;	
						}	
				    }
				});
				flexrel = all.setEquipment(res);
				if(flexrel != "ok"){
					setTimeout("setEquipment()",1000);
				}
			}catch(err){
				setTimeout("setEquipment()",1000);
			}
	 }

	 function setMeterDouble(){
		var res;
		var flexrel="";
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=BasicEquipment&requestMode=SomeThingsQuestions',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setMeterDouble(res.split("|")[0],res.split("|")[1]);
			if(flexrel != "ok"){
				setTimeout("setMeterDouble()",1000);
			}
		}catch(err){
			setTimeout("setMeterDouble()",1000);
		}
	 }

	function setSystemPillarValue(selectId){
		if(selectId=="a1"){
			sp1="db";
			setSystemPillar1();
		}
		if(selectId=="a2"){
			sp1="cer";
			setSystemPillar1();		
		}
		if(selectId=="b1"){
			sp2="db";
			setSystemPillar2();
		}
		if(selectId=="b2"){
			sp2="cer";
			setSystemPillar2();
		}
		if(selectId=="c1"){
			sp3="db";
			setSystemPillar3();
		}
		if(selectId=="c2"){
			sp3="cer";
			setSystemPillar3();
		}
		if(selectId=="d1"){
			sp4="db";
			setSystemPillar4();
		}
		if(selectId=="d2"){
			sp4="cer";
			setSystemPillar4();
		}
	}
	 
	

	
	function setSystemPillar1(){
		var res;
		var flexrel="";
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=BasicEquipment&requestMode=systempiller&SystemPillarType='+sp1,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setSystemPillar1(res);
			if(flexrel != "ok"){
				setTimeout("setSystemPillar1()",1000);
			}
		}catch(err){
			setTimeout("setSystemPillar1()",1000);
		}	
	
	}

	function setSystemPillar2(){
		var res;
		var flexrel="";
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=BasicEquipment&requestMode=systempiller&SystemPillarType='+sp2,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setSystemPillar2(res);
			if(flexrel != "ok"){
				setTimeout("setSystemPillar2()",1000);
			}
		}catch(err){
			setTimeout("setSystemPillar2()",1000);
		}	
	
	}

	function setSystemPillar3(){
		var res;
		var flexrel="";
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=BasicEquipment&requestMode=systempiller&SystemPillarType='+sp3,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setSystemPillar3(res);
			if(flexrel != "ok"){
				setTimeout("setSystemPillar3()",1000);
			}
		}catch(err){
			setTimeout("setSystemPillar3()",1000);
		}	
	
	}

	function setSystemPillar4(){
		var res;
		var flexrel="";
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=BasicEquipment&requestMode=systempiller&SystemPillarType='+sp4,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setSystemPillar4(res);
			if(flexrel != "ok"){
				setTimeout("setSystemPillar4()",1000);
			}
		}catch(err){
			setTimeout("setSystemPillar4()",1000);
		}	
	
	}
	

	function setDoubleColorLine(){
		var flexrel="";
		try{
			flexrel = all.setDoubleColorLine(document.getElementById("dcl").value);
			if(flexrel != "ok"){
				setTimeout("setDoubleColorLine()",1000);
			}
		}catch(err){
			setTimeout("setDoubleColorLine()",1000);
		}
		
	}

	function setLineForHour1(){
		var res;
		var flexrel="";
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=BasicEquipment&requestMode=LineForHourKernel',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setLineForHour1(res);
		}catch(err){
			setTimeout("setLineForHour1()",3000);
		}	
	
	}

function setLineForHour2(){
	var res;
	var flexrel="";
	try{
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=BasicEquipment&requestMode=LineForHourPrefix',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return true;	
				}	
		    }
		});
		flexrel = all.setLineForHour2(res);
	}catch(err){
		setTimeout("setLineForHour2()",3000);
	}	
		
}

function setLineForHour3(){
	var res;

	var flexrel="";
	try{
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=BasicEquipment&requestMode=LineForHourMiddleOperation',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return true;	
				}	
		    }
		});
		flexrel = all.setLineForHour3(res);
	}catch(err){
		setTimeout("setLineForHour3()",3000);
	}	

}

function setLineForHour4(){
	var res;
	var flexrel="";
	try{
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=BasicEquipment&requestMode=LineForHourNetbank',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return true;	
				}	
		    }
		});
		flexrel = all.setLineForHour4(res);
	}catch(err){
		setTimeout("setLineForHour4()",3000);
	}	

}

	
			
</script>        
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="window.setInterval(playMovie,120000);initPlay();">
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

<center>
	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="images/dbmswf/All04.swf" />
          <param name="wmode" value="transparent" />
        </object>
</center>
</div>
<input type="hidden" id="dcl" value="${dcl }"/>
</body>
</html:html>