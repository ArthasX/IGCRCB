<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSMR0701" toScope="request"/>
<bean:define id="title" value="不定期报表填报发起" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	
 function checkForm(){
	 
	if($F('remark').trim() == ""){
	   	alert("请输入报表说明！");
	   	return false;
	}
   	if($F('limittime').trim() == ""){
   		alert("请输入填报限制时间！");
   		return false;
   	}
   	
   	if($F('remark').strlen()>200){
   		alert("报表说明不能大于"+Math.floor(200/strByteFlag)+"个汉字！");
   		return false;
   	}
   	var pdids="";
   	var selects = document.getElementsByName("pdid");
	if(null != selects && selects.length > 0){
		for(var i = 0; i< selects.length; i++){
			var checkbox = selects[i];
			if(checkbox.checked){
				pdids = pdids+checkbox.value+"#";
			}
		}
	}
	document.getElementById('pdids').value=pdids;
  	var message = '请确认是否要进行不定期报表填报发起处理？';
	if( window.confirm(message)){
		screenLayer();
		document.forms[0].submit();
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
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation /></p>
            </div>
            <div id="formwrapper">
            <html:form styleId="form" action="/IGSMR0701" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					    <legend>基本信息</legend>
	       			<div>
					    <label for="Name"><strong><span class="red">*</span>报表说明</strong>：</label>
					    <html:text name="IGSMR0701Form" property="remark" styleId="remark" errorStyleClass="inputError"  tabindex="3" style="width:130px;"/>
					    <br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>填报限制时间</strong>：</label>
						<html:text name="IGSMR0701Form" readonly="true" property="limittime" styleId="limittime" style="width:130px;" errorStyleClass="inputError" tabindex="2"/>
						<img src="images/date.gif" align="middle" onclick="showDate($('limittime'))" border="0" style="cursor: hand" />
						<br>
    				</div>
    				<div>
							<table class="table_style">
								<tr style="height:20px;">
								    <th width="5%" style="height:20px;"><input id="checkbox" name="checkbox" type="checkbox" onclick="selectAll('checkbox','pdid');"/></th>
									<th width="30%" style="height:20px;">报表名</th>
									<th width="20%" style="height:20px;">报表描述</th>
								</tr>
								<logic:present name="IGSMR07011VO" property="ig380List">
									<logic:iterate id="bean" name="IGSMR07011VO"
										property="ig380List" indexId="index">										
										<tr>
											<td>
											<input name="pdid" type="checkbox" value="${bean.pdid}" id="pdid"/>
											</td>
									 		<td>${bean.pdname}</td>
									 		<td>${bean.pddesc }</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
					</div>		
    				</fieldset>
    			<html:hidden property="pdids"/>	
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				    <html:hidden property="test" name="IGSMR0701Form" styleId="test"/>
				</div>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>