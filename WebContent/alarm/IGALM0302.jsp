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
<bean:define id="id" value="IGALM0302" toScope="request" />
<bean:define id="title" value="告警规则配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/menu/jquery.js"></script>
<!-- /header1 -->
<script type="text/javascript">	

var jq = jQuery.noConflict();
jq(document).ready(function(){
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


function resetpage(){
	window.location.href= getAppRootUrl()+'/IGALM0302_Disp.do';
}

function back(){
	var flag = '${IGALM03021VO.flag}';
	window.location.href= getAppRootUrl()+'/IGALM0301_Back.do?flag='+flag;
}

function markReturnButton(){

	var flag = '${IGALM03021VO.flag}';
	if(flag == 'yes'){
		createHiddenInput("flag","yes");
	}
}


function checkIP(ip,n){

	/** 检查输入框是否填写 */
	var result;
	var isNewIP = true;
	if( ip == "" && n == 1){
		alert("请输入单网卡IP！");
		return false;
	}
	

	/** 检查IP格式是否正确(ipv4) */
	var ipFormat = /^([0-9]{1,3}\.{1}){3}[0-9]{1,3}$/;
	var ipstrs = ip.split(".");
	if((!ipFormat.test(ip)) || parseInt(ipstrs[0])>255 || parseInt(ipstrs[1])>255 
			|| parseInt(ipstrs[2])>255 || parseInt(ipstrs[3])>255){
		 if(n == 1){
			 alert("单网卡IP格式不正确！");
			 return false;
		 }else if(n == 2 && ip != ""){//双网卡IP为空的情况不包括在内
			 alert("双网卡IP格式不正确！");
			 return false;
		 }
	}
	
	return true;
}

function confirmDisp(){

	var ip = jq("input[name=ip]").val();
	if(!checkIP(ip,1)){
		return false;
	} 
	var ip2 = jq("input[name=ip2]").val();
	if(!checkIP(ip2,2)){
		return false;
	}

	var maxalarmtime = jq("input[name=maxalarmtime]").val();
	var maxalarmnum = jq("input[name=maxalarmnum]").val();

	var numberFormat = /^[0-9]*$/;
	if(maxalarmtime != "" && !numberFormat.test(maxalarmtime)){
		alert("分钟数请输入数字！");
		return false;
	}

	if(maxalarmnum != "" && !numberFormat.test(maxalarmnum)){
		alert("最大重复告警数请输入数字！");
		return false;
	}

	if(parseInt(maxalarmtime.trim()) > 1440){
		jq("input[name=maxalarmtime]").focus();
		alert("分钟数不能超过1440！");
		return false;
	}

	if(parseInt(maxalarmnum.trim()) > 100){
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
		}else{
			createHiddenInput("ruletempids",null);
		}
		return true;
	} else {
		return false;
	}
}
</script>
<body onload="markReturnButton();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">
	<c:if test="${IGALM03021VO.flag != 'yes'}">
		<ig:navigation extname1="${urlable}"/>
	</c:if>
	<c:if test="${IGALM03021VO.flag == 'yes'}">
     	<p class="fonts1">监控管理&gt;&gt; ITO &gt;&gt; 指标模板管理 &gt;&gt; 监控对象配置</p>
   	</c:if>
</p>
</div>
<div id="formwrapper">
<html:form styleId="form"
	action="/IGALM0302_Insert" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	
	<fieldset>
		<legend>告警规则配置</legend>
		<br/>
		<div>
			<label for="Name"><strong>监控对象名称</strong>：</label> 
			<html:text name="IGALM0302Form" property="servername"  errorStyleClass="inputError imeActive" readonly="true" styleClass="inputDisable"/> <br />
		</div>	
		<div>
			<label for="Name"><span class="red">*</span><strong>单网卡IP</strong>：</label>
			<html:text name="IGALM0302Form" property="ip" errorStyleClass="inputError imeActive"/> 
		</div>
		<div>
			<label for="Name"><strong>&nbsp;双网卡IP</strong>：</label> 
			<html:text name="IGALM0302Form" property="ip2"  errorStyleClass="inputError imeActive"/>
		</div>
		<div>
			<label for="Name"><strong>监控对象类型</strong>：</label> 
	       <html:text name="IGALM0302Form" property="type"  errorStyleClass="inputError imeActive" readonly="true" styleClass="inputDisable"/>
		</div>
		<div>
			<label for="Name"><strong>&nbsp;告警规则</strong>：</label> 
		  	<select size="10" id="pre_from" style="width: 300px;">
		  		<logic:present name="IGALM03021VO" property="ruleTempsNeed">
		  			<logic:iterate id="bean" name="IGALM03021VO" property="ruleTempsNeed" indexId="index">
		  				<option value="${bean.ruletempid}">${bean.ruletempname}</option>
		  			</logic:iterate>
		  		</logic:present>
	        </select>
	        &nbsp;
		    <select size="10" style="width:300px;" id="pre_to">
		    	<logic:present name="IGALM03021VO" property="ruleTemps">
		   			<logic:iterate id="bean" name="IGALM03021VO" property="ruleTemps" indexId="index">
		  				<option value="${bean.ruletempid}">${bean.ruletempname}</option>
		  			</logic:iterate>
		  		</logic:present>
		    </select><br/>
	    </div>
	    <div>
	    	<label for="Name"><strong>&nbsp;告警抑制</strong>：</label>
			当
			<html:text property="maxalarmtime"  errorStyleClass="inputError imeActive" value="${IGALM03021VO.crm09Info.maxalarmtime}"></html:text>
			分钟内发生
			<html:text property="maxalarmnum"  errorStyleClass="inputError imeActive" value="${IGALM03021VO.crm09Info.maxalarmnum}"></html:text>
			次告警时，发送一次告警信息<br />
		</div>
		<br/>
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:button property="btn_clear" styleClass="button" value="重置" onclick="resetpage();"/>
		<html:button property="btn_clear" styleClass="button" value="返回" onclick="back();"/>
	</div>

	</fieldset>
</html:form></div>	

</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>