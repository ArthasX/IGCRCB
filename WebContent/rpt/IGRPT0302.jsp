<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<link href="styles/baobiao.css" rel="stylesheet" type="text/css" />
<bean:define id="id" value="IGRPT0302" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="rptResources" key="ietitle.IGRPT0301"/>
</bean:define>
<jsp:include page="/include/header1.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
 select{
 	width:100px;
 }
</style>
<script type="text/javascript">
	var numLimit=12;//数量限制
	var gtNum="gtNum";
	function chgUrl(){
		var objType=$('objType').value;//对象类型
		var mode=$('mode').value;//对象类型
		var timeType=$('timeType').value;
		var yearValue=$('yearSel').value;
		var quarterValue=$('quarterSel').value;
		var monthValue=$('monthSel').value;
		var dateTime="";//时间
		if(timeType=='year'){
			dateTime=yearValue;
		}else if(timeType=='quarter'){
			dateTime=yearValue+"/"+quarterValue;
		}else if(timeType=='month'){
			dateTime=yearValue+"/"+monthValue;
		}
		var url="IGRPT0302_Sear.do?dateTime="+dateTime+"&timeType="+timeType+"&mode="+mode;
		
		if(objType=='storage'){
			url=url+"&storageName="+$('storageName').value+"&objType="+objType;
		}else if(objType=='business'){
			url=url+"&businessName="+$('businessName').value+"&objType="+objType;
		}else if(objType=='host'){
			var objTypeTmp=getRadioName();
			if(objTypeTmp=='host'){
			url=url+"&hostName="+$('hostName').value+"&objType="+objTypeTmp;
			}else if(objTypeTmp=='vg'){
				var vgName=getObjNames("vgNameArr");
				var vgIsRight=valiSel(vgName);
				if(vgIsRight){
					url=url+"&hostName="+$('hostName').value+"&objType="+objTypeTmp;
					url=url+"&vgName="+vgName;
				}else {
					return false;
				}
			}else if(objTypeTmp=='fs'){
				var vgName=getObjNames("vgNameArr");
				var fsName=getObjNames("fsNameArr");
				var fsIsRight=valiSel(fsName);
				if(fsIsRight){
					url=url+"&hostName="+$('hostName').value+"&objType="+objTypeTmp;
					url=url+"&vgName="+vgName;
					url=url+"&fsName="+fsName;
				}else {
					return false;
				}
			}else if(objTypeTmp=='db'){
				var dbIsRight=valiSel($('dbName').value);
				if(dbIsRight){
					url=url+"&hostName="+$('hostName').value+"&objType="+objTypeTmp;
					url=url+"&dbName="+$('dbName').value;
				}else {
					return false;
				}
			}else if(objTypeTmp=='ts'){
				var tsName=getObjNames("tsNameArr");
				var tsIsRight=valiSel(tsName);
				if(tsIsRight){
					url=url+"&hostName="+$('hostName').value+"&objType="+objTypeTmp;
					url=url+"&dbName="+$('dbName').value;
					url=url+"&tsName="+tsName;
				}else {
					return false;
				}
			}
		}
		$("birti").src=url;
	}
	function valiSel(objNames){
		var selectObj = '<bean:message bundle="rptResources" key="message.IGRPT0301.alertMsg1"/>';
		var obj12 = '<bean:message bundle="rptResources" key="message.IGRPT0301.alertMsg2"/>';
		if(objNames==null||objNames==""){
			alert(selectObj);
			return false;
		}else if(objNames==gtNum){
			alert(obj12);
			return false;
		}
		return true;
	}
	//把数组变成字符串
	//objName对象名字
	function getObjNames(objName){
		var fsNames=document.getElementById(objName);
		if(fsNames){
			var objNames="";
			var n=0;
				for(var i=0;i<fsNames.length;i++){
					if(fsNames[i].selected){
						if(objNames!=""){
							objNames+=",";
						}
						if(objName!='vgNameArr'){
							objNames+=fsNames[i].value;
						}else{
							objNames+=fsNames[i].value;
						}
						n++;
						if(n==(numLimit+1)){//对象最多选N个
							return gtNum;
						}
					}
				}
				return objNames;
		}else{
			return null;
		}
	}

	function changeDateType(){
		var timeType=$('timeType').value;
		if(timeType=='year'){
			$('monthDiv').style.display="none";
			$('quarterDiv').style.display="none";
		}else if(timeType=='month'){
			$('monthDiv').style.display="";
			$('quarterDiv').style.display="none";
		}else if(timeType=='quarter'){
			$('monthDiv').style.display="none";
			$('quarterDiv').style.display="";
		}
	}
	function searTsAjax(){
		var name=getRadioName();
			if(name=='ts'){
			var dbName=$('dbName').value;
			var hostName=$('hostName').value;
			//ajax运行
			 var result="";
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=getTsNames&name='+hostName+"_"+dbName,
					 onSuccess:  function(req, json){
					 result=req.responseText;
					 $('tsNameArr').options.length=0;
					 if(result!=null&&result!=""){
						var tsArr=result.split(",");
						for(var i=0;i<tsArr.length;i++){
							var tsName=tsArr[i];
							$('tsNameArr').options.add(new Option(tsName,tsName));
						}
					 }
			 		}
				});
			return result;
		}
	}
	function searFsAjax(){
		var name=getRadioName();
			if(name=='fs'){
			var vgName=$('vgNameArr').value;
			//var vgEiid="1";
			//if(vgNameArr!=""&&vgNameArr!=null){
			//	vgEiid=vgNameArr.split(":")[1];
			//}
			//ajax运行
			 var result="";
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=getFsNames&name='+$F('hostName')+"_"+vgName,
					 onSuccess:  function(req, json){
					 result=req.responseText;
					 $('fsNameArr').options.length=0;
					 if(result!=null&&result!=""){
						var fsArr=result.split(",");
						for(var i=0;i<fsArr.length;i++){
							var fsName=fsArr[i];
							$('fsNameArr').options.add(new Option(fsName,fsName));
						}
					 }
			 		}
				});
			return result;
		}
	}
	//获取单选框名称
	function getRadioName(){
		var radios=document.getElementsByName('sradio');
		for ( var i = 0; i < radios.length; i++) {
			if(radios[i].checked)
            {
            	return radios[i].value;
            }
			
		}
	}
	function getHostOfObj(objType){
		var eiid=$('eiid').value;
		var hostName=$('hostName').value;
		//ajax运行
		 var result="";
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getHostOfObj&objType='+objType+'&eiid='+eiid+"&hostName="+hostName,
				 onSuccess:  function(req, json){
				 result=req.responseText;
		 		}
			});
		return result;
	}
	function showHideDiv(){
		var objType=getRadioName();
		var result=getHostOfObj(objType);
     	$('vgDiv').style.display="none";
     	$('fsDiv').style.display="none";
     	$('dbDiv').style.display="none";
     	$('tsDiv').style.display="none";
     	$('vgLabel1Div').style.display="none";
     	$('vgLabel2Div').style.display="none";
     	$('fsLabelDiv').style.display="none";
     	$('dbLabelDiv').style.display="none";
     	$('tsLabelDiv').style.display="none";
         if(objType=='host'){
	        }else if(objType=='vg'){
	        	$('vgDiv').style.display="";
	        	$('vgLabel1Div').style.display="";
	        	$('vgNameArr').options.length=0;
	        	$('vgNameArr').size=4;
      		 	$('vgNameArr').multiple="multiple";
	        	if(result!=""){
					var vgArr=result.split(",");
					for(var i=0;i<vgArr.length;i++){
						var vgName=vgArr[i];
						//var vgLabelName=vgName.split(":")[0];
						$('vgNameArr').options.add(new Option(vgName,vgName));
					}
		        }
		    }else if(objType=='fs'){
		    	$('vgDiv').style.display="";
		    	$('fsDiv').style.display="";
		    	$('vgLabel2Div').style.display="";
		     	$('fsLabelDiv').style.display="";
		    	if(result!=""){
	        		 $('vgNameArr').options.length=0;
	        		 $('vgNameArr').size=1;
	        		 $('vgNameArr').multiple="";
	        		 $('fsNameArr').options.length=0;
					var objArr=result.split(";");
					if(objArr.length>1){
						var vgArr=objArr[0].split(",");
						var fsArr=objArr[1].split(",");
						for(var i=0;i<vgArr.length;i++){
							var vgName=vgArr[i];
							//var vgLabelName=vgName.split(":")[0];
							$('vgNameArr').options.add(new Option(vgName,vgName));
						}
						$('vgNameArr').options[0].selected=true;
						for(var j=0;j<fsArr.length;j++){
							var fsName=fsArr[j];
							$('fsNameArr').options.add(new Option(fsName,fsName));
						}
					}
		        }
		    }else if(objType=='db'){
		    	$('dbDiv').style.display="";
		     	$('dbLabelDiv').style.display="";
		    	if(result!=""){
	        		 $('dbName').options.length=0;
					var dbArr=result.split(",");
					for(var i=0;i<dbArr.length;i++){
						var dbName=dbArr[i];
						$('dbName').options.add(new Option(dbName,dbName));
					}
		        }
		    }else if(objType=='ts'){
		    	$('dbDiv').style.display="";
		     	$('tsDiv').style.display="";
		     	$('dbLabelDiv').style.display="";
		     	$('tsLabelDiv').style.display="";
		     	if(result!=""){
	        		 $('dbName').options.length=0;
	        		 $('fsNameArr').options.length=0;
					var objArr=result.split(";");
					if(objArr.length>1){
						var dbArr=objArr[0].split(",");
						var tsArr=objArr[1].split(",");
						for(var i=0;i<dbArr.length;i++){
							var dbName=dbArr[i];
							$('dbName').options.add(new Option(dbName,dbName));
						}
						for(var j=0;j<tsArr.length;j++){
							var tsName=tsArr[j];
							$('tsNameArr').options.add(new Option(tsName,tsName));
						}
					}
		        }
		    }
	}
	
	function load_yearAndTypes(){//获取近5年 
		 $('yearSel').options.length=0;
		 var y_date=new Date().getFullYear();
		 var yest_date="";
		 for ( var i = 0; i < 5; i++) {  // 5-1/2=x ; i==x ; y_date-x+i
			 if(i==2){
				 yest_date=y_date;
		     }else{
		    	 yest_date=y_date-2+i;
			 }
			 $('yearSel').options.add(new Option(yest_date,yest_date));
			 if(i==2){
				 $('yearSel').options[i].selected = true;
			 }
		 }
	 }
	//容量添加超链接
	 function collectLink(){
	 	var confirmCollect='<bean:message bundle="rptResources" key="message.IGRPT0301.confirmCollect"/>';
		if(confirm(confirmCollect)){
		//传递的参数
		var rclReportType='03';
		var rclObjName="";
		var objType=$('objType').value;//对象类型
		var mode=$('mode').value;
		var eiid=$('eiid').value;
		var rclCaType="";
		if(objType=='storage'){
			if(mode=='sum'){
				rclObjName='allStorage';
			}else{
				rclObjName=$('storageName').value;
			}
		}else if(objType=='business'){
			rclObjName=$('businessName').value;
		}else if(objType=='host'){
			rclObjName=$('hostName').value;
			var objTypeTmp=getRadioName();
			rclCaType=objTypeTmp;
		}
		var paramter='type=addReportCustomLink&rclReportType='+rclReportType
		+'&eiid='+eiid+'&rclObjName='+rclObjName+'&objType='+objType+'&mode='+mode+'&rclCaType='+rclCaType;
		var result="";
		var collected='<bean:message bundle="rptResources" key="message.IGRPT0301.collected"/>';
		var collectsuc='<bean:message bundle="rptResources" key="message.IGRPT0301.collectSuccess"/>';
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: paramter,
				 onSuccess:  function(req, json){
				 result=req.responseText;
				 if(result!=null&&result!=""){
						if(result=='exists'){
							alert(collected);
						}else if(result=='insert'){
							alert(collectsuc);
						}
			  		 }
		 		}
			});
		return result;
		}
	 }
	 function initReportTask(){
		 var caType="${IGRPT0302Form.rclCaType}";
		 var objType="${IGRPT0302Form.objType}";
		 if(objType=='host'){
			 var radios=document.getElementsByName('sradio');
				var radios=document.getElementsByName('sradio');
				for ( var i = 0; i < radios.length; i++) {
					if(radios[i].value==caType)
		            {
		            	radios[i].checked="checked";
		            }
				}
			showHideDiv();
		 }
		 if("host"!=caType){
			
		 }
		 load_yearAndTypes();
	 }
</script>
<body onload="initReportTask()">
<!--container 左菜单 右侧内容-->
<html:form	action="/IGRPT0302_Sear.do" >
<div class="r_main">
<div class="Contentbox3" >
<c:if test="${IGRPT0302Form.objType=='host'}">
     <div id="con_three_1" >
       <table  width="100%" border="0" style="height:13px; ">
  		<tr>
    <td width="15%" height="19"><bean:message bundle="rptResources" key="label.IGRPT0301.host"/>：
    <input type="radio" id="sradio" name="sradio" checked="checked" onclick="showHideDiv()" value="host" />
        <label for="radio"></label></td>
    <td width="15%" height="19"><bean:message bundle="rptResources" key="label.IGRPT0301.vg"/>：
    <input type="radio" id="sradio" name="sradio" onclick="showHideDiv()" value="vg"/>
        <label for="radio"></label></td>
    <td width="15%" height="19"><bean:message bundle="rptResources" key="label.IGRPT0301.fs"/>：
    <input type="radio" id="sradio" name="sradio" onclick="showHideDiv()" value="fs"/>
        <label for="radio"></label></td>
    <td width="15%" height="19"><bean:message bundle="rptResources" key="label.IGRPT0301.db"/>：
    <input type="radio" id="sradio" name="sradio" onclick="showHideDiv()" value="db" />
        <label for="radio"></label></td>
    <td width="15%" height="19"><bean:message bundle="rptResources" key="label.IGRPT0301.ts"/>：
    <input type="radio" id="sradio" name="sradio" onclick="showHideDiv()" value="ts" />
        <label for="radio"></label></td>
    <td width="25%" height="19">&nbsp;</td>
  </tr>
</table>
</div>

</c:if>
   <div id="con_three_1" >
   <c:if test="${IGRPT0302Form.objType=='host'}">
    <div class="srccdt" style="height:80px;">
     

     <table width="100%" height="68"  border="0">
  <tr>
    <td width="20%" align="right">
    <div class="label_div"> <label style="font-size: 10px"><bean:message bundle="rptResources" key="select.IGRPT0301.timeType"/>：</label>
      <label for="select2"></label>
      <select id="timeType" name="timeType" onchange="changeDateType()" style="font-size: 10px">
       	<option value="year"><bean:message bundle="rptResources" key="select.IGRPT0301.year"/></option>
		<option value="quarter"><bean:message bundle="rptResources" key="select.IGRPT0301.quarter"/></option>
		<option value="month"><bean:message bundle="rptResources" key="select.IGRPT0301.month"/></option>
      </select>  
      </div>
      </td>
    <td width="7%" rowspan="3" align="right" valign="middle">
    <div id="vgLabel1Div" style="display: none;"><label><bean:message bundle="rptResources" key="label.IGRPT0301.vg"/>：<br/><bean:message bundle="rptResources" key="select.IGRPT0301.warn"/></label></div>
    <div id="vgLabel2Div" style="display: none;"><label><bean:message bundle="rptResources" key="label.IGRPT0301.vg"/>：</label></div>
    <div id="dbLabelDiv"  style="display: none;"><label><bean:message bundle="rptResources" key="label.IGRPT0301.db"/>：</label></div>
    </td>
    <td width="14%" rowspan="3" valign="middle">
    	<div  id="vgDiv"  style="display: none;"><label for="select3"></label>
      	<html:select property="vgNameArr" size="4"  multiple="multiple" onchange="searFsAjax()">
		</html:select>
      	</div>
      	<div id="dbDiv" style="display: none;">
			<html:select property="dbName" onchange="searTsAjax()">
			</html:select>
		</div>
      </td>
	  
	  <td width="7%" rowspan="3" align="right" valign="middle">
    <div id="fsLabelDiv" style="display: none;"><label><bean:message bundle="rptResources" key="label.IGRPT0301.fs"/>：<br/><bean:message bundle="rptResources" key="select.IGRPT0301.warn"/></label></div>
    <div id="tsLabelDiv" style="display: none;"><label><bean:message bundle="rptResources" key="label.IGRPT0301.ts"/>：<br/><bean:message bundle="rptResources" key="select.IGRPT0301.warn"/></label></div>
    </td>
    <td width="20%" rowspan="3" valign="middle">
    	<div  id="fsDiv"  style="display: none;">
					<html:select property="fsNameArr" size="4" multiple="multiple" style="width:150px;">
					</html:select>
		</div>
      	<div id="tsDiv" style="display: none;">
					<html:select property="tsNameArr" size="4" multiple="multiple" style="width:150px;">
					</html:select>
		</div>
      </td>
    <td width="8%" rowspan="3">
    <input id="i_btn"  style="height:30px; width:76px; cursor: hand" type="button" value='<bean:message bundle="rptResources" key="button.IGRPT0301.select"/>' class="i_btn" onclick="chgUrl();" />
    </td>
    <td width="4%" rowspan="3" align="center">
    <img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink()"/>
    </td>
  </tr>
  <tr align="center">
    <td width="20%" align="right" ><div class="label_div"  id="yearDiv"><label style="font-size: 10px"><bean:message bundle="rptResources" key="select.IGRPT0301.year"/>：</label>
	      <label for="select2"></label>
	     <select id="yearSel" name="yearSel" style="font-size: 10px">
		</select>
     </div></td>
  </tr>
  <tr align="center">
    <td width="20%" align="right"  ><div class="label_div"  id="quarterDiv"  style="display: none;"> <label style="font-size: 10px"><bean:message bundle="rptResources" key="select.IGRPT0301.quarter"/>：</label>
      <label for="select2"></label>
      <html:select property="quarterSel" style="font-size: 10px">
		<ig:optionsCollection ccid="REPORT_DATETYPEQ_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
		</html:select>
      </div><div class="label_div"  id="monthDiv" style="display: none;"> <label style="font-size: 10px"><bean:message bundle="rptResources" key="select.IGRPT0301.month"/>：</label>
      <label for="select2"></label>
      <html:select property="monthSel"  style="font-size: 10px">
		 <ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	  </html:select>
      </div></td>
  </tr>
     </table>
</div>
   </c:if>
<c:if test="${IGRPT0302Form.objType!='host'}">
     <div class="srccdt">
<table width="100%" height="68" border="0">
  <tr>
    <td width="25%" align="right" valign="middle" height="68"><div class="label_div"> <label><bean:message bundle="rptResources" key="select.IGRPT0301.timeType"/>：</label>
      <label for="select2"></label>
      <select id="timeType" name="timeType" onchange="changeDateType()"  style="font-size: 5">
       	<option value="year"><bean:message bundle="rptResources" key="select.IGRPT0301.year"/></option>
		<option value="quarter"><bean:message bundle="rptResources" key="select.IGRPT0301.quarter"/></option>
		<option value="month"><bean:message bundle="rptResources" key="select.IGRPT0301.month"/></option>
      </select>  
      </div>
     </td>
    <td width="25%"  align="right" valign="middle"><div class="label_div"  id="yearDiv"><label><bean:message bundle="rptResources" key="select.IGRPT0301.year"/>：</label>
	      <label for="select2"></label>
	     <select id="yearSel" name="yearSel" >
		</select>
     </div>
     </td>
    <td width="25%" align="right" valign="middle"><div class="label_div"  id="quarterDiv"  style="display: none;"> <label><bean:message bundle="rptResources" key="select.IGRPT0301.quarter"/>：</label>
      <label for="select2"></label>
		 <html:select property="quarterSel" >
		<ig:optionsCollection ccid="REPORT_DATETYPEQ_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
		</html:select>
      </div><div class="label_div"  id="monthDiv" style="display: none;"> <label><bean:message bundle="rptResources" key="select.IGRPT0301.month"/>：</label>
      <label for="select2"></label>
      <html:select property="monthSel">
		 <ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	  </html:select>
      </div></td>
    <td width="15%" align="center" valign="middle">
    <input id="i_btn"  style="height:30px; width:76px;cursor: hand" type="button" value='<bean:message bundle="rptResources" key="button.IGRPT0301.select"/>' class="i_btn" onclick="chgUrl();" />
    </td>
    <td width="10%" align="center" valign="middle">
    <img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink()"/>
    </td>
  </tr>
  </table>
</div>
</c:if>

   </div>
	<!-- 下为 birt viewer 框架 -->
   <div class="chart">
   <iframe id="birti" width="100%" height="384" frameborder="0" scrolling="auto" src="" >
	</iframe>
   </div>
	<div class="zishiying"></div>
</div>
</div>
			<input type="hidden" name="mode" value="${IGRPT0302Form.mode}"/>
			<input type="hidden" name="objType" value="${IGRPT0302Form.objType}"/>
			<input type="hidden" name="eiid" value="${IGRPT0302Form.eiid}"/>
			<input type="hidden" name="hostName" value="${IGRPT0302Form.hostName}"/>
			<input type="hidden" name="storageName" value="${IGRPT0302Form.storageName}"/>
			<input type="hidden" name="businessName" value="${IGRPT0302Form.businessName}"/>
</html:form>
</body>
</html:html>