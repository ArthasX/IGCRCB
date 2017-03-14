<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0107" toScope="request" />
<bean:define id="title" value="流程定义" toScope="request" />
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript" src="js/menu/jquery.js"></script>
<script type="text/javascript" src="js/process.js" charset="UTF-8"></script>
<script>
	jQuery.noConflict();//jquery与prototype冲突
</script>
<script type="text/javascript">
var swfVersionStr = "11.1.0";
var xiSwfUrlStr = "playerProductInstall.swf";
var flashvars = {};
var params = {};
params.quality = "high";
params.bgcolor = "#ffffff";
params.allowscriptaccess = "sameDomain";
params.allowfullscreen = "true";
params.wmode = "opaque";
var attributes = {};
params.wmode = "opaque";//屏蔽系统右键菜单的关键add by wym
attributes.id = "FlowManger";
attributes.name = "FlowManger";
attributes.align = "middle";
attributes.wmode = "opaque";
swfobject.embedSWF("flowswf/SubFlowManager.swf", "flowContent", "100%", "100%", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
swfobject.createCSS("#flowContent", "display:block;text-align:left;");
var num = 0;
function init(){
	if(num > 5) {
		return;
	}
	var obj = document.getElementById("eidtFlowXml");
	if(obj && obj.value){
		return obj.value;
	}else{
		num ++;
		setTimeout("init()", 1000);
	}
}
//保存XML
function conmit_xml(xml){
	var parm = {};
	parm.xmlValue = xml;
	parm.prid = jQuery("#prid").val();
	jQuery.ajax({
		url:"IGDRM0107.do",
		data:parm,
		type:"POST",
		async: false,
		dataType:"JSON",
		success:function(data){
// 			window.console&&console.dir(data);
		}
	});
// 	DOCUMENT.GETELEMENTBYID("XMLVALUE").VALUE = XML;
// 	FORM.SUBMIT();
}
function getButtons(psdid){
	var result = "";
	var parm = {};
	parm.psdid = psdid;
	jQuery.ajax({
		url:"IGDRM0107_ButtonInfo.do",
		data:parm,
		type:"POST",
		async: false,
		success:function(data){
			result = data;
		}
	});
	return result;
}
//获取遮罩效果 -如果isMask为1 说明该流程图只用于显示 添加遮罩
function getMask(){
	var ismask = document.getElementById("isMask").value;
	return ismask;
}
//setContentHeight
function setContentHeight(contentHeight){
	jQuery("#flowContentDiv").css("height",contentHeight);
}
//获取组织架构信息-状态参与人基础数据
function getOrgInfo(){
	var result = "";
	var parm = {};
	jQuery.ajax({
		url:"IGDRM0107_OrgInfo.do",
		data:parm,
		type:"POST",
		async: false,
		success:function(data){
			result = data;
		}
	});
	return result;
}
//获取状态附件
function getAttKey(){
	var pdid = document.getElementById("pdid").value;
	var result = "";
	var parm = {};
	parm.stepPdid = pdid;
	jQuery.ajax({
		url:"IGDRM0107_AttKey.do",
		data:parm,
		type:"POST",
		async: false,
		success:function(data){
			result = data;
		}
	});
	return result;
}
//获取状态表单
function getStateForm(addFlowPdid){
	var pdid = document.getElementById("pdid").value;
	if(addFlowPdid){
		pdid = addFlowPdid;
	}
	var result = "";
	var parm = {};
	parm.stepPdid = pdid;
	jQuery.ajax({
		url:"IGDRM0107_StateForm.do",
		data:parm,
		type:"POST",
		async: false,
		success:function(data){
			result = data;
		}
	});
	return result;
}
//提交保存流程XML
function saveFlowXml(){
	//调用flex中的保存流程图方法
	//alert("danyi："+jQuery("#pdid").val() +":"+jQuery("#psdid").val()+":"+jQuery("#psdid").val().substr(7));
	if(""!=jQuery("#psdid").val()&&"001"==jQuery("#psdid").val().substr(7)){
		var isCanSave = jQuery("#FlowManger")[0].submitSaveXml();
		if(isCanSave){
			return true;
		}else{
			return false;
		}
	}
	return true;
	
}

//是否可以提交

function isCanSave(str){
	if(str == "false"){
		return true;
	}else{
		return false;
	}
}

//打开资产查询页面
function selectEntityStateForm(index,pidid,syscoding){
	num = index;
	var param = '?pidid='+pidid + '&esyscoding=' + syscoding+"&parFlag=flex";
	openSubWindow('/IGDRM0406_Disp.do'+param , '', '850', '600');
}
function setParamIGDRM0406(eid, elabel,ename,eiid, eilabel, einame, ecategory, pidid, eiversion) {
	var ein = "";
	if(""!=eiid&&""!=einame){
		ein = eiid+"_EIID_"+einame;
		alert(ein);
	}
	//调用flex中的保存状态表单-资产的方法
	jQuery("#FlowManger")[0].setEntityValue(ein);
}
//打开应急资源查询页面
function selectEMEntityForm(eiids){
	openSubWindow('/IGDRM0402.do?openFlag=1&eiidNotIn='+eiids, '', '850', '600');
}
function setParamIGDRM04023(result) {
	jQuery("#FlowManger")[0].setEntityValue(result);
}
</script>
<script type="text/javascript">
jQuery(function(){
	jQuery("#openBtn").hide();
	jQuery("#closeBtn").show();
	jQuery("#openBtn").click(function(){
		jQuery("#flowContentDiv").slideToggle(500);
		jQuery("#openBtn").hide();
		jQuery("#closeBtn").show();
	});
	jQuery("#closeBtn").click(function(){
		jQuery("#flowContentDiv").slideToggle(500);
		jQuery("#openBtn").show();
		jQuery("#closeBtn").hide();
	});
});

</script>
<body>
<div id="location" style="margin-left: 15px;border-bottom:1px solid #6699CC;margin-bottom:5px;width:942px;">
	<p class="fonts1" style="color:#0055aa;">场景流程定义图</p>
	<span id="openBtn"><img src="images/maximize.png"  alt="展开" style="margin-top:5px;margin-left:10px;"/></span>
	<span id="closeBtn"><img src="images/minimize.png"  alt="关闭" style="margin-top:5px;margin-left:10px;" /></span>
</div>
<!--container 左菜单 右侧内容-->
<div id="flowContentDiv" style="margin-left: 15px;width:942px;border-style:solid;border-color: #B0DAF7;border-width: 1px;">
         <div id="box">
          <div id="flowContent">
            <p>
                To view this page ensure that Adobe Flash Player version 
                11.1.0 or greater is installed. 
            </p>
            <script type="text/javascript"> 
                var pageHost = ((document.location.protocol == "https:") ? "https://" : "http://"); 
                document.write("<a href='http://www.adobe.com/go/getflashplayer'><img src='" 
                                + pageHost + "www.adobe.com/images/shared/download_buttons/get_flash_player.gif' alt='Get Adobe Flash player' /></a>" ); 
            </script> 
        </div>    
        </div>
         <iframe frameborder="0" name="iframe" style="display:none;">
         </iframe>
         <html:form styleId="form" action="/IGDRM0107.do" target="iframe">
        <html:textarea property="xml" styleId="eidtFlowXml" style="display:none;"/>
        <html:textarea property="xmlValue" styleId="xmlValue" style="display:none;"/>
        <html:textarea property="isMask" styleId="isMask" style="display:none;"/>
        <html:textarea property="pdid" styleId="pdid" style="display:none;"/>
        <html:textarea property="contentH" styleId="contentH" style="display:none;"/>
        </html:form>
</div>  				          
</body>
</html:html>
