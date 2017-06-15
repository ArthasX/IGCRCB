<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript" src="js/menu/jquery.js"></script>
<html:html>
<bean:define id="id" value="IGLOG0023" toScope="request" />
<bean:define id="title" value="告警规则修改" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
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
		jq("#pre_from option:selected").appendTo("#pre_to");
	});
	//双击删除
	jq("#pre_to").dblclick(function(){
		jq("#pre_to option:selected").appendTo("#pre_from");
	});
});


function selectRadio(){
	 document.all("rulestate")[0].checked=true;//
}
var attachFileNum=0;
var count = 0;
function addWHMFile(index) 
{
	if(index==-1){
		var h1=index+2+count;
		count++;
	}
	else{
		var h1=index+2+count;
		count++;
	}
	
	
	var h2='<html:select property="alarmconditions" styleId="alarmconditions" style="width: 110px;" errorStyleClass="inputError" value="${bean.alarmcondition}">'
	    +'<html:option value="0">没有条件</html:option>'
	    +'<html:option value="1">包含</html:option>'
	    +'<html:option value="2">等于</html:option>'
	    +'</html:select>';
	var h3='<html:text property="alarmmsgs" errorStyleClass="inputError imeActive" value="${bean.alarmmsg}" styleId="alarmmsgs${index}" />';
	var h4='<a href="#"><img src="images/delete.gif" border="0" alt="删除" /></a>';
	currRow=tb2.insertRow();
	cell0=currRow.insertCell();
	cell1=currRow.insertCell();
	cell2=currRow.insertCell();
	cell3=currRow.insertCell();
	cell0.innerHTML=h1;
	cell1.innerHTML=h2;
	cell2.innerHTML=h3;
	cell3.innerHTML=h4;
	attachFileNum++;
}

function confirmDisp(){
	var list = document.getElementsByTagName('alarmcondition');
	alert(list.length);
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
<body onload="selectRadio();">
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
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGLOG0022_INSERT" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	<legend>选择设备</legend>
	<div><label for="Name"><strong><span class="red">*</span>设备类型</strong>：</label> 
	<html:text property="rulename" errorStyleClass="inputError imeActive" />
	</div>
	<br />
	<!-- 	
	<div><label for="Name"><strong><span class="red">*</span>规则状态</strong>：</label> 
	<p class="p2">&nbsp;&nbsp;
		<html:radio property="rulestate" styleId="rulestate" value="1" >可用</html:radio>
		<html:radio property="rulestate" styleId="rulestate" value="0">停用</html:radio>
	</p>
	</div>
	 -->
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
		<label for="Name"><strong><span class="red">*</span>双网卡</strong>：</label> 
		<html:text property="deviceip"  errorStyleClass="inputError imeActive" />
	</div>

	</fieldset>
	<br/>
	<fieldset>
	<legend>选择规则</legend>
	<div><label for="Name"><strong><span class="red">*</span>复制规则</strong>：</label> 
		<html:text property="rulename" errorStyleClass="inputError imeActive" />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>告警抑制</strong>：</label>
	<html:text
		property="maxalarmtime" 
		errorStyleClass="inputError imeActive" />分钟内最大重复
	<html:text
		property="maxalarmnum" 
		errorStyleClass="inputError imeActive" />次告警<br />
	</div>
	<div>
	   <select size="10" id="pre_from" style="width: 207px;">
		<logic:present name="IGLOG0022VO" property="tempList">
		<logic:iterate id="bean" name="IGLOG0022VO" property="tempList">
			<option value="${bean.ruletempid}">${bean.ruletempname}-
			<logic:equal name="bean" property="alarmcondition" value="0">
			没有条件
			</logic:equal>
			<logic:equal name="bean" property="alarmcondition" value="1">
			包含
			</logic:equal>
			<logic:equal name="bean" property="alarmcondition" value="2">
			等于
			</logic:equal>
			-
			<c:if test="${fn:length(bean.alarmtempmsg)>9}">
			${fn:substring(bean.alarmtempmsg,0,8)}...
			</c:if>
			<c:if test="${fn:length(bean.alarmtempmsg)<=9}">
			${bean.alarmtempmsg}
			</c:if>
			</option>
		</logic:iterate>
	</logic:present>    
       </select>
       <input type="button" style="width:30px;" id="pre_add" title="添加" value=">"/>
		<select size="10" style="width:207px;" id="pre_to">
		</select>
       
       <br/>
      </div>
	</fieldset>
	<!--
	<fieldset>
	<legend>自定义规则条件</legend>
		<table class="table_style" id="tb2">
		<tr align="center">
			<th width="5%">序号</th>
			<th width="12%">条件</th>
			<th width="75%">内容</th>
			<th width="8%">操作</th>
		</tr>
		<logic:present name="IGLOG0022VO" property="myTempList">
			<logic:iterate id="bean" name="IGLOG0022VO" property="myTempList" indexId="index">
				
				<tr class="<ig:rowcss index="${index}"/>">
				<c:set value="${index}" var="xh"></c:set>
					<td align="center">${index+1}</td>
				    <td width="20%">
                     <html:select property="alarmconditions" styleId="alarmconditions" style="width: 110px;" errorStyleClass="inputError" value="${bean.alarmcondition}">
         			    <html:option value="0">没有条件</html:option>
					    <html:option value="1">包含</html:option>
					    <html:option value="2">等于</html:option>
                     </html:select>
                      </td>
                      <td width="50%">
                        <html:text property="alarmmsgs" errorStyleClass="inputError imeActive" value="${bean.alarmmsg}" styleId="alarmmsgs${index}" />
                       </td>
					<td align="center">
							<a href="#"><img src="images/delete.gif" border="0" alt="删除" /></a>
					</td>
					
				</tr>
			</logic:iterate>
		</logic:present>
		</table>
	</fieldset>
	-->
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" />
		<c:if test="${xh==null }">
			<c:set value="-1" var="xh"></c:set>
        </c:if>
        <input name="add" type="button" class="button" value="添加" onclick="addWHMFile(${xh});" />
		</div>
    
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>