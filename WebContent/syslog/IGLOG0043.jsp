
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOG0043" toScope="request" />
<bean:define id="title" value="规则模板修改" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var attachFileNum=0;
function selectRadio(){
	var list = "${IGLOG0043VO.mss00003InfoList}";
	var prioritiesArr = list.split("],");
	for(var i=0;i<prioritiesArr.length;i++){
		if(prioritiesArr[i] != ""){
			attachFileNum++;
		}
	}
	 document.all("tempstate")[0].checked=true;//
	 //document.all("rulecondition")[0].checked=true;
	 var conditions = document.all("rulecondition");
	 for(var j=0;j<conditions.length;j++){
		 if(conditions[j].value == "${IGLOG0043VO.mss00004TB.rulecondition}"){
			 conditions[j].checked=true;
		 }
	 }
	 
}


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
	
	var h2='<html:select name="IGLOG0042Form" styleId="priority" property="priority" style="width: 110px;" errorStyleClass="inputError"><html:option value="100">没有级别</html:option>';
	var priorities="${IGLOG0043VO.alarmPriorities}";
	var prioritiesArr = priorities.split(",");
	for(var i=0;i<prioritiesArr.length;i++){
		if(prioritiesArr[i] != ""){
			var values = prioritiesArr[i].split("&");
			h2 = h2 + '<html:option value="'+values[0]+'">'+values[1]+'</html:option>';
		}
	}
	h2 = h2 + '</html:select>';
	var h3='<html:select property="alarmconditions" styleId="alarmconditions" style="width: 110px;" errorStyleClass="inputError" value="${bean.alarmcondition}">'
	    +'<html:option value="0">没有条件</html:option>'
	    +'<html:option value="1">包含</html:option>'
	    +'<html:option value="2">等于</html:option>'
	    +'</html:select>';
	var h4='<html:text property="alarmmsgs" errorStyleClass="inputError imeActive" value="${bean.alarmmsg}" styleId="alarmmsgs${index}" />';
	var h5='<img src="images/delete.gif" onclick="deleteitem1(this);" border="0" alt="删除添加编辑框！" style="cursor: hand"/>';
	currRow=tb2.insertRow();
	cell0=currRow.insertCell();
	cell1=currRow.insertCell();
	cell2=currRow.insertCell();
	cell3=currRow.insertCell();
	cell4=currRow.insertCell();
	cell0.innerHTML=h1;
	cell1.innerHTML=h2;
	cell2.innerHTML=h3;
	cell3.innerHTML=h4;
	cell4.innerHTML=h5;
	attachFileNum++;
}

function deleteitem1(obj)
{
	var curRow= obj.parentNode.parentNode;
	tb2.deleteRow(curRow.rowIndex);
	attachFileNum--;
}

function resetpage(ruletempid){
	window.location.href= getAppRootUrl()+'/IGLOG0043_EDIT_DISP.do?ruletempid='+ruletempid;
}

function confirmDisp(){
	if($("ruletempname").value.trim()==""){
		alert("请输入模板名称！");
		return false;
	}
	if($F('ruletempname').strlen()>128){
		alert("模板名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($("typeid").value.trim()==""){
		alert("请选择设备类型！");
		return false;
	}
	if($F('tempdesc').strlen()>256){
		alert("描述内容不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}
	for(var i=0;i<attachFileNum;i++){
		if(document.getElementsByName("alarmconditions")[i].value.trim()=="0" && document.getElementsByName("priority")[i].value == "100"){
			alert("条件和级别不能同时为空 ！");
			return false;
		}
		if(document.getElementsByName("alarmmsgs")[i].value.strlen()>256){
			alert("内容不能大于256个字符！");
			return false;
		}
		if(document.getElementsByName("alarmconditions")[i].value.trim()!="0" && document.getElementsByName("alarmmsgs")[i].value.trim() =="" ){
			document.getElementsByName("alarmmsgs")[i].focus();
			alert("内容不能为空！");
			return false;
		}
	 }
	if( window.confirm('确认提交?')){
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
<p class="fonts1">监控管理 &gt;&gt; 监控配置&gt;&gt; 修改规则模板</p>
<div class="back"><a href="IGLOG0041.do" target="_self">返回</a>
</div>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGLOG0043_EDIT" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
		<legend>规则信息</legend>
	<div><label for="Name"><strong><span class="red">*</span>名称</strong>：</label> 
	<html:text
		property="ruletempname" 
		errorStyleClass="inputError imeActive" value="${IGLOG0043VO.mss00004TB.ruletempname}"/><br />

	</div>
	<div><label for="Name"><strong><span class="red">*</span>设备类型</strong>：</label> 
    <html:select name="IGLOG0042Form" property="typeid" style="width: 85px;" errorStyleClass="inputError" tabindex="4" value="${IGLOG0043VO.mss00004TB.typeid}">
           <html:option value="0000">通用</html:option>
           <ig:optionsCollection ccid="SYSLOG_DEVICETYPE" isMakeBlankRow="false" isCodeLabel="true"/>
    </html:select><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>条件</strong>：</label> 
	<p class="p2">
	<!-- 
	<html:select name="IGLOG0042Form" property="rulecondition" style="width: 85px;" errorStyleClass="inputError" value="${IGLOG0043VO.mss00004TB.rulecondition}" >
	    <html:option value="0">与</html:option>
	    <html:option value="1">或</html:option>
	</html:select>
	 -->
		<html:radio property="rulecondition" styleId="rulecondition" value="0">与</html:radio>&nbsp;&nbsp;
		<html:radio property="rulecondition" styleId="rulecondition" value="1">或</html:radio>
	</p><br />
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>状态</strong>：</label> 
	<p class="p2">
	<html:select name="IGLOG0042Form" property="tempstate" style="width: 85px;" errorStyleClass="inputError" value="${IGLOG0043VO.mss00004TB.tempstate}" >
	    <html:option value="1">可用</html:option>
	    <html:option value="0">停用</html:option>
	</html:select>	
	</p><br />
	</div>
	
	<div><label for="Name"><strong>备注</strong>：</label> 
	<html:textarea cols="55" rows="3"
		property="tempdesc" 
		errorStyleClass="inputError imeActive" value="${IGLOG0043VO.mss00004TB.tempdesc}"/><br />
	</div>
	
	<c:if test="${IGLOG0043VO.mss00004TB.typeid != '0000'}">
		<div><label for="Name"><strong>设备列表</strong>：</label> 
		<html:textarea cols="55" rows="6"
			property="deviceList" 
			errorStyleClass="inputError imeActive" value="${IGLOG0043VO.deviceListString}" readonly="true" styleClass="inputDisable"/><br/>
		</div>
	</c:if>
	
	</fieldset>
	<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span style="color: #6092c1;font-weight: bold;">规则条件 </span>
	<c:if test="${xh==null }">
			<c:set value="-1" var="xh"></c:set>
    </c:if>
	<input name="add" type="button" class="button" value="添加" onclick="addWHMFile(${xh+1});" /><br/><br/>
	<table class="table_style" id="tb2">
		<tr align="center">
			<th width="10%">序号</th>
			<th width="22%">级别</th>
			<th width="22%">条件</th>
			<th width="24%">内容</th>
			<th>操作</th>
		</tr>
		<logic:present name="IGLOG0043VO" property="mss00003InfoList">
			<logic:iterate id="bean" name="IGLOG0043VO" property="mss00003InfoList" indexId="index">
				
				<tr class="<ig:rowcss index="${index}"/>" id="t">
				<c:set value="${index}" var="xh"></c:set>
					<td align="center">${index+1}</td>
					<td width="30%">
					&nbsp;
						<html:select name="IGLOG0042Form" styleId="priority" property="priority" value="${bean.alarmlevel}"
							style="width: 110px;" errorStyleClass="inputError">
							<html:option value="100">没有级别</html:option>
							<logic:present name="IGLOG0043VO" property="alarmPrioritiesList">
								<logic:iterate id="bean1" name="IGLOG0043VO" property="alarmPrioritiesList" indexId="index">
									<html:option value="${bean1.cid}">${bean1.cvalue}</html:option>
								</logic:iterate>
							</logic:present>
						</html:select>
					</td>
				    <td width="20%">
				    &nbsp;
                     <html:select property="alarmconditions" styleId="alarmconditions" style="width: 110px;" errorStyleClass="inputError" value="${bean.alarmcondition}">
         			    <html:option value="0">没有条件</html:option>
					    <html:option value="1">包含</html:option>
					    <html:option value="2">等于</html:option>
                     </html:select>
                      </td>
                      <td width="40%">
                        <html:text property="alarmmsgs" errorStyleClass="inputError imeActive" value="${bean.alarmmsg}" styleId="alarmmsgs${index}" />
                       </td>
					<td align="center">
							<img src="images/delete.gif" onclick="deleteitem1(this);" border="0" alt="删除添加编辑框！" style="cursor: hand"/>
					</td>
					
				</tr>
			</logic:iterate>
		</logic:present>
		</table>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" />
		 <html:button property="btn_clear" styleClass="button" value="重置" onclick="resetpage(${IGLOG0043VO.mss00004TB.ruletempid});"></html:button></div>
<html:hidden property="ruletempid" styleId="ruletempid" />    
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>