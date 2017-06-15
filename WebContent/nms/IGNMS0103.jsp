<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGNMS0103" toScope="request" />
<bean:define id="title" value="任务配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		function init(){
			<c:if test="${flag == '1' || IGNMS0103Form.type == null || IGNMS0103Form.type == ''}">
				$("type").value = "1";
				$("fromIP").value = "";
				$("toIP").value = "";
				$('subNet').value="";
				$('isEnablePing').value="0";
			</c:if>
			taskSelect($("type"));
			<c:if test="${flag == '1' || IGNMS0103Form.type == null || IGNMS0103Form.type == ''}">
				clearValue();
			</c:if>
		}
	    function toDel(id){
	    	if( window.confirm("您是否确认删除？")){
	    		IGNMS0103Form.action = getAppRootUrl() + "/IGNMS0103_Del.do?id="+id;
	    		IGNMS0103Form.submit();
			}
	    }
	  	//增加
		function toAdd(){
			if($("type").value=="1"){
				if($F("fromIP").trim()==""){
					alert("请输入起始IP！");
					return false;
				}
				if($F("toIP").trim()==""){
					alert("请输入终止IP！");
					return false;
				}
				if(!isIP($F("fromIP").trim())){
					alert("起始IP无效！");
					return false;
				}
				if(!isIP($F("toIP").trim())){
					alert("终止IP无效！");
					return false;
				}
			} else if($("type").value=="2"){
				if($F("subNet").trim()==""){
					alert("请输入网络号！");
					return false;
				}
				if(!isIP($F("subNet").trim())){
					alert("网络号无效！");
					return false;
				}
			} else if($("type").value=="3"){
				if($F("fromIP").trim()==""){
					alert("请输入起始IP！");
					return false;
				}
				if(!isIP($F("fromIP").trim())){
					alert("起始IP无效！");
					return false;
				}
			}
		    if(window.confirm("您是否确认增加？")){
		        return true;
		    } else {
		        return false;
		    }
		}
	  	function taskSelect(obj) {
	  		var tmp = obj.value;
	  		if(tmp == "1") {
	  			$("div_subNet").style.display = "none";
	  			$("subNet").style.display = "none";
	  			$("div_fromIP").style.display = "";
	  			$("div_toIP").style.display = "";
	  			$("fromIP").style.display = "";
	  			$("toIP").style.display = "";
	  		} else if(tmp == "2") {
	  			$("div_subNet").style.display = "";
	  			$("div_fromIP").style.display = "none";
	  			$("div_toIP").style.display = "none";
	  			$("subNet").style.display = "";
	  			$("fromIP").style.display = "none";
	  			$("toIP").style.display = "none";
	  		} else if(tmp == "3") {
	  			$("div_fromIP").style.display = "";
	  			$("div_toIP").style.display = "none";
	  			$("div_subNet").style.display = "none";
	  			$("fromIP").style.display = "";
	  			$("toIP").style.display = "none";
	  			$("subNet").style.display = "none";
	  		}
	  	}
	  	function clearValue() {
  			$("fromIP").value = "";
  			$("toIP").value = "";
  			$("subNet").value = "";
  			$("isEnablePing").value = "0";
	  	}
	</script>
<body onload="init()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGNMS0103_Ins" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /></p>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">任务类型</th>
			<th width="15%">起始IP</th>
			<th width="15%">终止IP</th>
			<th width="15%">网络号</th>
			<th width="15%">是否支持Ping</th>
			<th width="25%">删除</th>
		</tr>
		<logic:present name="IGNMS01031VO" property="lst_NMS03Info">
			<logic:iterate id="bean" name="IGNMS01031VO"
				property="lst_NMS03Info" indexId="index">
				<tr>
					<td><c:if test="${bean.type == '1'}">IP段</c:if><c:if test="${bean.type == '2'}">子网</c:if><c:if test="${bean.type == '3'}">路由</c:if></td>
					<td>${bean.fromIP}</td>
					<td>${bean.toIP}</td>
					<td>${bean.subNet}</td>
					<td><c:if test="${bean.isEnablePing == '0'}">否</c:if><c:if test="${bean.isEnablePing == '1'}">是</c:if></td>
					<td>
					<html:link href="javascript:toDel('${bean.id}')">
						<img src="images/delete.gif" width="16" height="16" border="0"
							alt="删除" />
					</html:link>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="formwrapper">
	<fieldset>
	<div><label for="Name"><strong>任务类型</strong>：</label>
	<p class="p2"><html:select property="type" name="IGNMS0103Form" onchange="taskSelect(this),clearValue();" styleId="type">
	<html:option value="1">IP段</html:option>
	<html:option value="2">子网</html:option>
	<html:option value="3">路由</html:option>
	</html:select> </p>
	<br />
	</div>
	<div id="div_fromIP"><label for="Name"><strong>起始IP</strong>：</label> 
	<html:text property="fromIP" name="IGNMS0103Form" size="18" styleId="fromIP"/> <br />
	</div>
	<div id="div_toIP"><label for="Name"><strong>终止IP</strong>：</label>
	<html:text property="toIP" name="IGNMS0103Form" size="18" styleId="toIP"/> <br />
	</div>
	<div id="div_subNet"><label for="Name"><strong>网络号</strong>：</label>
	<html:text property="subNet" name="IGNMS0103Form" size="18" styleId="subNet"/> <br />
	</div>
	<div><label for="Name"><strong>是否支持Ping</strong>：</label>
	<html:select property="isEnablePing" name="IGNMS0103Form" styleId="isEnablePing">
	<html:option value="0">否</html:option>
	<html:option value="1">是</html:option>
	</html:select>
	</div>
	</fieldset>
	<div class="enter">
	<html:hidden property="gid" name="IGNMS0103Form" styleId="gid"/>
	<html:submit property="btn_add" styleClass="button" value="增加" onclick="return toAdd()"/>
	</div>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
