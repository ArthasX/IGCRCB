<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html:html>
<bean:define id="id" value="IGLOG0022" toScope="request" />
<bean:define id="title" value="告警规则录入" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/menu/jquery.js"></script>
<!-- /header1 -->
<script type="text/javascript">	

var jq = jQuery.noConflict();
jq(document).ready(function(){
	//添加
	jq("#pre_add").click(function(){
		jq("#pre_from option:selected").appendTo("#pre_to");
	});
	//删除
	jq("#pre_del").click(function(){
		jq("#pre_to option:selected").appendTo("#pre_from");
	});
	//双击添加
	jq("#pre_from").dblclick(function(){
		var flag = false;
		jq("#pre_to option").each(function(){
			if(jq(this).val() == jq("#pre_from option:selected").val()){
				alert("不能添加重复的规则！");
				flag = true;
				return;
			}
		});
		if(flag) return;
		jq("#pre_from option:selected").appendTo("#pre_to");
	});
	//双击删除
	jq("#pre_to").dblclick(function(){
		jq("#pre_from option").each(function(){
			if(jq(this).val() == jq("#pre_to option:selected").val()){
				jq(this).remove();
			}
		});
		jq("#pre_to option:selected").appendTo("#pre_from");
	});
});

var typeID = jq("#deviceList").val();//全局设备类型变量

function searchDevicesAndTemps(obj){
	var typeid = obj.value;
	typeID = typeid;
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false,parameters:'type=searchDevicesAndTemps&typeid='+typeid,
		 onSuccess:  function(req, json){
		 var result=req.responseText.split("@@@");
		 var devices = result[0].split(",");
		 var temps = result[1].split(",");
		 jq("#deviceList").empty();
		 jq("#pre_from").empty();
		 jq("#deviceList").append('<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>');
		 jq.each(devices,function(){
			 	if(this.length != 0){
					var values = this.split("&");
					jq("#deviceList").append('<option value="'+values[0]+'">'+values[1]+"&nbsp;"+values[2]+'</option>');
			 	}	
			 });
		 jq.each(temps,function(){
			 	if(this.length != 0){
					var values = this.split("&");
					jq("#pre_from").append('<option value="'+values[0]+'">'+values[1]+'</option>');
			 	}	
			 });
	     }
		});
	
}

function toback(){
	window.location.href = getAppRootUrl() + "/IGCOM0202.do?linkID=IGLOG0101";
}

function searchTempsByDevice(obj){
	var deviceid = obj.value;
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,
			{asynchronous:false,parameters:'type=searchTempsByDevice&deviceid='+deviceid+'&typeid='+typeID,
		 onSuccess:  function(req, json){
		 var result=req.responseText;
		 var temps = result.split(",");
		 jq("#pre_from").empty();
		 jq.each(temps,function(){
			 	if(this.length != 0){
					var values = this.split("&");
					jq("#pre_from").append('<option value="'+values[0]+'">'+values[1]+'</option>');
			 	}	
			 });
	     }
		});
}

function checkIP(ip,n){

	/** 检查输入框是否填写 */
	var result;
	var isNewIP = true;
	if( ip == "" && n == 1){
		jq("input[name=deviceip]").focus();
		alert("请输入单网卡IP！");
		return false;
	}
	

	/** 检查IP格式是否正确(ipv4) */
	var ipFormat = /^([0-9]{1,3}\.{1}){3}[0-9]{1,3}$/;
	var ipstrs = ip.split(".");
	if((!ipFormat.test(ip)) || parseInt(ipstrs[0])>255 || parseInt(ipstrs[1])>255 
			|| parseInt(ipstrs[2])>255 || parseInt(ipstrs[3])>255){
		 if(n == 1){
			 jq("input[name=deviceip]").focus();
			 alert("单网卡IP格式不正确！");
			 return false;
		 }else if(n == 2 && ip != ""){//双网卡IP为空的情况不包括在内
			 jq("input[name=deviceip2]").focus();
			 alert("双网卡IP格式不正确！");
			 return false;
		 }
	}
	

	/** 检查IP是否已被占用 */
	
	if(ip == ""){//如果IP为空（检验双网卡输入框时），则跳过占用校验，否则会出现逻辑错误
		return true;
	}
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,
			{asynchronous:false,parameters:'type=checkIP&deviceip='+ip,
		 onSuccess:  function(req, json){
		 result=req.responseText;
		 if(result != "no") {
			 isNewIP = false;
		  }
	     }
		});
	if(isNewIP == false){
		 if(n == 1){
			 jq("input[name=deviceip]").focus();
			 alert("单网卡IP已被"+result.trim()+"占用！");
		 }
		 if(n == 2){
			 jq("input[name=deviceip2]").focus();
			 alert("双网卡IP已被"+result.trim()+"占用！");
		 }
		 return false;
	}
	return true;
}

function resetpage(){
	window.location.href= getAppRootUrl()+'/IGLOG0022_DISP.do';
}

function confirmDisp(){
	
	if(jq("select[name=typeid]").val().trim() == ""){
		jq("select[name=typeid]").focus();
		alert("请选择设备类型！");
		return false;
	}
	
	if(jq("input[name=devicename]").val().trim() == ""){
		jq("input[name=devicename]").focus();
		alert("请输入设备名称！");
		return false;
	}
	if(jq("input[name=devicename]").val().strlen()>32){
		jq("input[name=devicename]").focus();
		alert("模板名称不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		return false;
	}
	
	var ip = jq("input[name=deviceip]").val();
	if(!checkIP(ip,1)){
		return false;
	} 
	var ip2 = jq("input[name=deviceip2]").val();
	if(!checkIP(ip2,2)){
		return false;
	}

	if(parseInt(jq("input[name=maxalarmtime]").val().trim()) > 1440){
		jq("input[name=maxalarmtime]").focus();
		alert("分钟数不能超过1440！");
		return false;
	}

	if(parseInt(jq("input[name=maxalarmnum]").val().trim()) > 100){
		jq("input[name=maxalarmnum]").focus();
		alert("最大重复告警数不能超过100！");
		return false;
	}

	if( window.confirm('确认提交?')){
		var pres = document.getElementById("pre_to").options;
		if(pres.length>0){
			for(var i=0;i<pres.length;i++){
				createHiddenInput("ruletempids",pres[i].value);
			}
		}
		return true;
	} else {
		return false;
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
	<p class="fonts1">监控管理 &gt;&gt; 监控配置 &gt;&gt; 告警规则录入</p>
	<!-- 
	<c:if test="${IGLOG0022VO.couldReturn == 'yes'}">
		<div class="back">
			<html:link href="javascript:toback();">返回</html:link>
		</div> 
	</c:if>
	 -->
</div>
<div id="formwrapper">
<html:form styleId="form"
	action="/IGLOG0022_INSERT" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	
	<fieldset>
	<legend>选择设备</legend>
		<div><label for="Name"><strong><span class="red">*</span>设备类型</strong>：</label> 
       <html:select name="IGLOG0022Form" property="typeid" errorStyleClass="inputError imeActive" onchange="searchDevicesAndTemps(this);">
       		<ig:optionsCollection ccid="SYSLOG_DEVICETYPE" isMakeBlankRow="true" isCodeLabel="true"/>
       </html:select>
	</div>
	<br />
	<div><label for="Name"><strong><span class="red">*</span>设备名称</strong>：</label> <html:text
		property="devicename" 
		errorStyleClass="inputError imeActive" /> <br />
	</div>	
	<br />
	<div>
		<label for="Name"><strong><span class="red">*</span>单网卡</strong>：</label> <html:text
		property="deviceip" errorStyleClass="inputError imeActive" /> 
	</div>
	<br />
	<div>
		<label for="Name"><strong>&nbsp;双网卡</strong>：</label> 
		<html:text property="deviceip2"  errorStyleClass="inputError imeActive" />
	</div>
	</fieldset>
	<br/>
	
	
	<fieldset>
	<legend>规则条件模板</legend>
	<div>
		<label for="Name"><strong>&nbsp;复制规则</strong>：</label> 
		<select id="deviceList" onchange="searchTempsByDevice(this);">
			<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		</select>
	</div>
	<br/>
	<div><label for="Name"><strong>&nbsp;告警抑制</strong>：</label>
		当<html:text
		property="maxalarmtime" 
		errorStyleClass="inputError imeActive" />分钟内发生
		<html:text
		property="maxalarmnum" 
		errorStyleClass="inputError imeActive" />次告警时，发送一次告警信息<br />
	</div>
	<br/>
	<div >
	   <select size="10" id="pre_from" style="width: 400px;">
       </select>
	   <select size="10" style="width:400px;" id="pre_to"></select><br/>
      </div>
      <br/>
	</fieldset>
	
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:button property="btn_clear" styleClass="button" value="重置" onclick="resetpage();"/>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>