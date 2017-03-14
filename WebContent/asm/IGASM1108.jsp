<%@page import="com.deliverik.framework.utility.ResourceUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.*"%>

<%@ page import="org.apache.struts.Globals;"%>
<link rel="stylesheet" href="/InfoGovernor/js/alertjs/new.css" type="text/css"/>

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
var originalTitle = "3D机房效果图";
//告警开关	开："on"		关："off"
var alarmSwitch = "off";

document.attachEvent('onpropertychange', function (evt) {
    evt = evt || window.event;
    if(evt.propertyName === 'title' && document.title !== originalTitle) {
        setTimeout(function () {
           document.title = originalTitle;
        }, 1);
    }
})
	//获取告警开关
	function getAlarmSwitch(){
		return alarmSwitch;
	}
	
	//载人告警数据
	function loadAlarmData(){
		if(alarmSwitch == "on"){
			var roomID =  document.getElementById("roomID").value;
			
			var xmlstr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
			"<ROOT>"+
			"<DATA><NAME>IBM小型机</NAME><IP>192.168.1.2</IP><CONTENT>IBM小型机XXX出现XX问题</CONTENT><DATE>2013/12/18 11:11</DATE><CABINETID>1967</CABINETID><ALARMID>1</ALARMID></DATA>"+
			"<DATA><NAME>HP小型机</NAME><IP>192.168.1.3</IP><CONTENT>HP小型机XXX出现XX问题</CONTENT><DATE>2013/12/18 11:12</DATE><CABINETID>1968</CABINETID><ALARMID>2</ALARMID></DATA>"+
			"<DATA><NAME>HP小型机(2)</NAME><IP>192.168.1.4</IP><CONTENT>HP小型机(2)XXX出现XX问题</CONTENT><DATE>2013/12/18 11:13</DATE><CABINETID>1952</CABINETID><ALARMID>3</ALARMID></DATA>"+
			"<DATA><NAME>HP小型机(1)</NAME><IP>192.168.1.5</IP><CONTENT>HP小型机(1)XXX出现XX问题</CONTENT><DATE>2013/12/18 11:14</DATE><CABINETID>1967</CABINETID><ALARMID>4</ALARMID></DATA>"+
			"<DATA><NAME>IBM小型机(2)</NAME><IP>192.168.1.5</IP><CONTENT>IBM小型机(2)XXX出现XX问题</CONTENT><DATE>2013/12/18 11:15</DATE><CABINETID>1967</CABINETID><ALARMID>5</ALARMID></DATA>"+
			"</ROOT>";
			return xmlstr;
		}
	}
	
	//查看告警信息
	function showAlarm(AlarmId){
		alert(AlarmId);
	}
	
	//设置机柜地板块
	function getDibanXY(){
		var dibanX = document.getElementById("dibanX").value;
		var dibanY = document.getElementById("dibanY").value;
		return dibanX+"|"+dibanY;
	}
	
	//设置隔断信息
	function getRelateRoomDate(){
		var relateRoomXML = document.getElementById("relateRoomXML").value;
		return relateRoomXML;
	}
	
	//设置已上架的机柜列表
	function getJiGuiData(){
		var jiguiXML = document.getElementById("jiguiXML").value;
		return jiguiXML;
	}
	
	//设置未上架的机柜列表
	function getToolsData(){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getToolsData',
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
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
	
	
	//保存机房信息
	function saveJiFangXML(jiguiXML,toolsXML,wuxiaoXML,legendXML){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=saveJifangData&roomID='+roomID+'&jiguiXML='+escape(encodeURIComponent(jiguiXML))+'&toolsXML='+escape(encodeURIComponent(toolsXML))+'&wuxiaoXML='+escape(encodeURIComponent(wuxiaoXML))+'&legendXML='+escape(encodeURIComponent(legendXML)),
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		return res;
	}
	
	//保存隔断信息
	function saveGeDuanXML(relateRoomXML,baseMessageXML){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=saveGeDuanData&roomID='+roomID+'&relateRoomXML='+escape(encodeURIComponent(relateRoomXML))+'&baseMessageXML='+escape(encodeURIComponent(baseMessageXML)),
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		return res;
	}
	
	//删除分区信息
	function deletePart(partID){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=deletePart&partID='+partID,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		return res;
	}
	
	//保存隔断绝对坐标
	function savePartAbsolute(partID,absoluteX,absoluteY){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=savePartAbsolute&partID='+partID+'&absoluteX='+absoluteX+'&absoluteY='+absoluteY,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }	
		    }
		});
		return res;
	}
	
	//取得隔断信息
	function getRealPartInfo(zoneid){
		var roomID =  document.getElementById("roomID").value;
		if(zoneid=='room'){
			var res;
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
				parameters: 'type=getRoomInfo&roomID='+roomID,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }	
			    }
			});
			return res;
		}else{
			var res;
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
				parameters: 'type=getZoneInfo&zoneid='+escape(encodeURIComponent(zoneid)),
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }	
			    }
			});
			return res;
		}
	}
	
	//取得隔断坐标
	function getPartXY(){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getPartXY&roomID='+roomID,
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
	function getZhuJiData(syscoding,einame,serialnum){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getZhuJiData&esyscoding='+syscoding+'&einame='+einame+'&serialnum='+serialnum,
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
	//查询主机所在机柜及机房
	function traceZhuJiLocation(zhuJiName,zhuJiNum){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=traceZhuJiLocation&zhuJiName='+escape(encodeURIComponent(zhuJiName))+'&zhuJiNum='+zhuJiNum+'&jiFangId='+roomID,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}
	//查询机柜详细信息，包含剩余U位，承重(KG)
	function getJiGuiDetail(jiGuiName,jiGuiNum){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getJiGuiLastDetail&jiGuiName='+escape(encodeURIComponent(jiGuiName))+'&jiGuiNum='+escape(encodeURIComponent(jiGuiNum))+'&jiFangId='+roomID,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}
	
	//查询当前机房下，满足U高，电力，负载大于等于查询条件的机柜
	function traceJiGuiLocation(U_High,power,load){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=traceJiGuiLocation&jiFangId='+roomID+'&U_High='+U_High+'&power='+power+'&load='+load,
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
	
	//取得机柜基本信息
	function checkEntityItemByKey(roomid){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=checkEntityItemByKey&roomID='+roomid,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res = result;
			   }
		    }
		});
		return res;
	}
	
	//取得无效地区信息
	function getNaFData(){
		var wuxiaoXML = document.getElementById("wuxiaoXML").value;
		return wuxiaoXML;
	}
	
	//取得图例信息
	function getLegendData(){
		var legendXML = document.getElementById("legendXML").value;
		return legendXML;
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
	//设置地板数据名
	function getSWFmap(){
		return "image1.swf";
	}
	//设置地板4顶点坐标
	function getMap4Vec(){
		var lx=0;
		var ly=0;
		
		var tx=0;
		var ty=0;
		
		var rx=0;
		var ry=0;
		
		var bx=0;
		var by=0;
		jifang3d_obj.setMap4Vec(lx,ly,tx,ty,rx,ry,bx,by);
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
	//保存上架机柜
	function realTimeSave(id,x,y,cttype,index,floorx,floory,zoneid){
		var res;
		var roomID =  document.getElementById("roomID").value;
		if('LEGEND'!=id){
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
				parameters: 'type=realTimeSave&roomID='+roomID+'&id='+id+'&x='+x+'&y='+y+'&cttype='+cttype+'&index='+index+'&floorx='+floorx+'&floory='+floory+'&zoneid='+zoneid,
				onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res = result;
					   }
				    }
				});
		}else{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
				parameters: 'type=saveLegend&roomID='+roomID+'&id='+id+'&x='+x+'&y='+y+'&cttype='+cttype+'&index='+index+'&floorx='+floorx+'&floory='+floory,
				onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res = result;
					   }
				    }
				});
		}
		return res;
	}
	//更新上架机柜
	function realTimeUpdate(id,x,y,floorx,floory,index,cttype,zoneid){
			var res;
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
				parameters: 'type=realTimeUpdate&id='+id+'&x='+x+'&y='+y+'&floorx='+floorx+'&floory='+floory+'&index='+index+'&zoneid='+zoneid+'&cttype='+cttype,
				onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res = result;
					   }
				    }
				});
		return res;
	}
	//删除上架机柜
	function deleteCabinetByAjax(id){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=deleteCabinet&id='+id,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}
	//删除图例
	function deleteLegendByAjax(id){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=deleteLegend&id='+id,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}
	
	//保存分区
	function saveZone(zid,zname,zinfo,zsx,zsy,zenx,zeny){;
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=saveZone&roomID='+roomID+'&zid='+escape(encodeURIComponent(zid))+'&zname='+escape(encodeURIComponent(zname))+'&zinfo='+escape(encodeURIComponent(zinfo))+'&zsx='+zsx+'&zsy='+zsy+'&zenx='+zenx+'&zeny='+zeny,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}
	
	//删除分区
	function deleteZoneAndCabinet(zoneid,flag){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=deleteZoneAndCabinet&zoneid='+escape(encodeURIComponent(zoneid))+'&flag='+flag,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}
	//调整朝向
	function changeAngle(ctid,cttype){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=changeAngle&ctid='+ctid+'&cttype='+cttype,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}
	//由设备查询跳转到机房显示设备所在机柜
	function showCabinet(){
		var container_eiid =  document.getElementById("container_eiid").value;
		if(container_eiid!=null||container_eiid!=""){
			jifang3d_obj.showCabinet(container_eiid);
		}
	}
	//初始化地板
	function initApp(){
		var roomID =  document.getElementById("roomID").value;
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=getMap4Vec&roomID='+roomID,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		var str = res.split("#");
		if(str.length>=11){
			var urlstr = ''+document.location;
			var ustr = urlstr.split("/");
			var rooturl = '';
			for(i=0;i<ustr.length-1;i++){
				rooturl += ustr[i]+'/';
			}
			rooturl += str[10];
			jifang3d_obj.initApp(str[0],str[1],str[2],str[3],str[4],str[5],str[6],str[7],str[8],str[9],rooturl);
		}
		return res;
	}
	
	
	//下移机柜
	function changeIndex(pkid,ctindex){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=c&pkid='+pkid+'&ctindex='+ctindex,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}
	
	//添加无效地板
	function addNaFByAjax(ctx,cty,floorx,floory){
		var res;
		var roomID = document.getElementById("roomID").value;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=addNaF&roomID='+roomID+'&ctx='+ctx+'&cty='+cty+'&floorx='+floorx+'&floory='+floory,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	};
	
	//删除无效地板
	function deleteNaFByAjax(id){
		var res;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=deleteNaF&id='+id,
			onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res = result;
				   }
			    }
			});
		return res;
	}

	function isNAFbyAjax(x,y){
		var res;
		var roomID = document.getElementById("roomID").value;
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
			parameters: 'type=isNAF&roomID='+roomID+'&x='+x+'&y='+y,
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
<bean:define id="id" value="IGASM1108" toScope="request" />
<bean:define id="title" value="3D机房效果 图" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common_<%=loc%>.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
        
<title><bean:write name="id"/><bean:write name="title"/></title>
<body style="font-weight: normal;">

<div align="center" style="position:relative; width:1003px; margin-left:auto; margin-right:auto;">
  	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" id="jifang3d_obj">
          <param name="movie" value="images/dbmswf/RoomMain.swf" />
          <param name="wmode" value="Opaque" />
      </object>
      

</div>
<input type="hidden" name="dibanX" id="dibanX" value="${IGASM11041VO.computerRoomVWInfo.x_total}" />
<input type="hidden" name="dibanY" id="dibanY" value="${IGASM11041VO.computerRoomVWInfo.y_total}" />
<input type="hidden" name="jiguiXML" id="jiguiXML" value='${IGASM11041VO.jiguiXml}' />
<input type="hidden" name="toolsXML" id="toolsXML" value='${IGASM11041VO.toolsXml}' />
<input type="hidden" name="legendXML" id="legendXML" value='${IGASM11041VO.legendXML}' />
<input type="hidden" name="wuxiaoXML" id="wuxiaoXML" value='${IGASM11041VO.wuxiaoXML}' />
<input type="hidden" name="relateRoomXML" id="relateRoomXML" value='${IGASM11041VO.relateRoomXML}' />
<input type="hidden" name="roomID" id="roomID" value='${IGASM1104Form.eiid}' />
<input type="hidden" name="container_eiid" id="container_eiid" value='${IGASM1104Form.container_eiid}' />
</body>

</html:html>