<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Locale"%>
<%@ page import="org.apache.struts.Globals;"%>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<%
	Locale loc = Locale.getDefault();
	if (request.getSession().getAttribute(Globals.LOCALE_KEY) != null) {
		loc = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
	}
%>

<script type="text/javascript">
	var jitype = '${jitype}';
	var eiid = '${IGASM1114Form.eiid}';
	//设置机柜地板块
	function getJitype(){
		return jitype;
	}
	//设置机柜地板块
	function getEiid(){
		return eiid;
	}

	//取得查询条件下拉菜单
	function getSearchValue(jitype){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getSearchValue&jitype='+jitype,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		return res;
	}

	//设置未上架的主机列表 2013.08.12 add SerialNum
	function getZhuJiData(syscoding,einame,serialnum,cabinet){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getZhuJiData&esyscoding='+syscoding+'&einame='+einame+'&serialnum='+serialnum+'&eiid='+eiid+'&cabinet='+cabinet,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}

	//取得机柜基本信息
	function getJiguiData(jiguiID){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getJiguiData&jiguiID='+jiguiID,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}

	//设置已上架的主机列表
	function getJiguiDetal(jiguiID,jitype){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getJiguiDetal&jiguiID='+jiguiID+'&jitype='+jitype,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}

	//保存机柜中设备信息
	function getZhujiDetal(zhujiID){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getZhujiDetal&zhujiID='+zhujiID,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}
	//保存上架设备
	function saveHostRelation(shebeiId,address,jiguiID){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=saveHostRelation&shebeiId='+shebeiId+'&address='+address+'&jiguiID='+jiguiID,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
			return res;
	}
	//删除上架设备
	function removeHostRelation(shebeiId){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=removeHostRelation&shebeiId='+shebeiId,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
			return res;
	}

	//跳转设备详细页
	function gotoZhuJiURL(jiguiID){
		jiguiID = jiguiID.replace("zhuji","");
		openSubWindow('/IGASM0323_Window.do?eiid=' +jiguiID, '_blank','1024','600');
	}

	//跳转设备关系页
	function gotoGuanXiURL(jiguiID){
		jiguiID = jiguiID.replace("zhuji","");
		openSubWindow('/IGASM1110_Disp.do?eiid=' +jiguiID, '_blank','1024','600');
	}
	
	//保存机柜中设备信息
	function saveZhuJiRelation(shebeiXML,jiguiDetalXML,jiguiID){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=saveZhuJiRelation&jiguiID='+jiguiID+'&shebeiXML='+escape(encodeURIComponent(shebeiXML))+'&jiguiDetalXML='+escape(encodeURIComponent(jiguiDetalXML)),
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;

	}

</script>
<html:html>
<bean:define id="id" value="IGASM1109" toScope="request" />
<bean:define id="title" value="机柜效果图" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common_<%=loc %>.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

        <script type="text/javascript">
            var swfVersionStr = "10.0.0";
            var xiSwfUrlStr = "playerProductInstall.swf";
            var flashvars = {};
            var params = {};
            params.quality = "high";
            params.bgcolor = "#ffffff";
            params.allowscriptaccess = "sameDomain";
            params.allowfullscreen = "true";
            var attributes = {};
            attributes.id = "rongqi";
            attributes.name = "rongqi";
            attributes.align = "middle";
            swfobject.embedSWF("images/dbmswf/rongqi.swf", "flashContent", "1010", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
			swfobject.createCSS("#flashContent", "display:block;text-align:left;");
        </script>
        
<title>容器平面图</title>
<body>

<div class="box">	
<div id="flashContent">
</div>
</div>
</body>

</html:html>