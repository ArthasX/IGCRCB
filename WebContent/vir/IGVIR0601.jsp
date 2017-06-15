<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR0601" toScope="request"/>
<bean:define id="title"  toScope="request">
	虚拟化分析
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
var swfVersionStr = "10.0.0";
var xiSwfUrlStr = "images/dbmswf/BussTopoMap_FuXinApp_VM.swf";
var flashvars = {};
var params = {};
var attributes = {};
attributes.id = "BussTopoMap";
attributes.name = "BussTopoMap";
params.wmode = "Opaque";
params.allowFullScreen = "true";
swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1002", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
var treeEiid;
//程序初始化入口
function initApp(){
	//业务系统关系树
	setFlexTreeData();
	
}

function setFlexTreeData(){

	//业务系统关系树
	var treeXml = "<%=request.getAttribute("treeXml")%>";
	var eiid="<%=request.getAttribute("eiid")%>";
	try{
		treeDoubleClickFunc(eiid);
		BussTopoMap.setFlexTreeData(treeXml);
		BussTopoMap.setSelectItemEiid(eiid);

	}catch(err){
		setTimeout("setFlexTreeData()",1000);
	}
}
function getCIInfoByAjax(){
	//eid=CM01010052
	var tempStr;
	try{
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=getCIInfoVM&eiid=' + treeEiid,
			onSuccess:  function(req, json){
				var result=req.responseText;
				if(result != null && result != ""){
					tempStr=result;
				}
			}
		});
	}catch(err){
		setTimeout("getCIInfoByAjax()",1000);
	}
	return tempStr;
}

function treeDoubleClickFunc(eiid,eid){
	treeEiid=eiid;
	var TOPOMAP_XMLSTR;
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getVWTopoXML&eiid=' + eiid,
				onSuccess:  function(req, json){
					var result=req.responseText;
					if(result != null && result != ""){
						TOPOMAP_XMLSTR=result;
					}
				}
			});
			BussTopoMap.setBussTopoMapXMLStr(TOPOMAP_XMLSTR);
		}catch(err){
			setTimeout("treeDoubleClickFunc(" + eiid +"," + eid + ")",1000);
		}
}


//save xml
function saveXML(str,eiid){
	var res="";
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		parameters: 'type=saveVWTopoMapXML&xmlstr='+str+'&eiid='+eiid,
		 onSuccess:  function(req, json){
		 var result=req.responseText;
			if(result != null && result != ""){
				res=result;
			}else{
				return "";
			}
	    }
	});
	alert(res);
	return res;
}
//header menu
function headerMenu(str){
	var url = "IGCOM0202.do?linkID=IGCOM0219&actname=ACT04CIM";
	switch(str){
		//case 1:setTimeout(function lk(){location.href="IGCOM0105.do?index=1";},800);break;
		//case 2:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0501&actname=ACT13MTM05";},800);break;
		//case 3:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0101&actname=ACT13MTM0101";},800);break;
		//case 4:setTimeout(function lk(){window.open("IGCOM0202.do?linkID=IGATL0102");});break;
		//case 5:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGSYS0001&actname=ACT13MTM0503";},800);break;//sys
		//case 6:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGASM1101&actname=ACT01ASM1201";},800);break;
		case 7:break;//saveXML
		case 8:setTimeout(function lk(){location.href=url;},800);break;
	}
}

//弹出页
function showDetailInfo(eiid,eirootmark,version,smallversion){
	//openSubIGCIM0137(eiid);
	openSubIGAIM0146(eirootmark,eiid,version,smallversion);
}

function clickTitleButton(btnNum,eiid){
	//虚拟化属性维护
	if(btnNum==1){
		this.parent.location.href = getAppRootUrl() + "/IGVIR0602_Disp.do?eiid=" + eiid;
	}
	//配置属性维护
	if(btnNum==2){
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=getHostEiidByVW&eiid='+eiid,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return "";
				}
		    }
		});
		if(res!=null&&res!=""){
			this.parent.location.href = getAppRootUrl() + "/IGVIR0603_Disp.do?eiid=" + res;
		}else{
			alert("该虚拟化设备无关联主机！");
		}
	}
}
</script>
<body onload="initApp();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
<div id="flashContent">
</div>
</div>
</div>
</body>
</html:html>
