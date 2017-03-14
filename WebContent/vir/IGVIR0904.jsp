<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0901" toScope="request"/>
<bean:define id="title"  toScope="request">
	计费策略修改画面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		 function checkForm(){  	
		 }
		 function init(){
			
		 }

	    function toback(){
	        form.action = getAppRootUrl() + "/IGVIR0901_Back.do";
	        form.submit();
	    }
	</script>
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">
                	计费管理 >> 计费策略 >> 策略管理 >> 策略修改
                </p>
                <div class="back">
                	<html:link href="javascript:toback();">返回</html:link>
                </div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGVIR0901_Edit" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <legend>计费策略修改</legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>策略名称</strong>：</label>
                            <html:text property="strategyName" errorStyleClass="inputError imeActive" tabindex="2" value="${IGVIR09011VO.strategyEntity.name}"/>
                            <html:hidden property="strid" value="${IGVIR09011VO.strategyEntity.id}"/>
                            <br>
                        </div>
                        <logic:present name="IGVIR09011VO" property="configItemList" >
	                        <logic:iterate id="bean" name="IGVIR09011VO" property="configItemList" indexId="index">
	                        <div>
			                	<label for="Name"><strong>${bean.cvalue}</strong>：</label>
			                	<%
					       			String flag = "no";
					       		%>
			                	<logic:iterate id="bean1" name="IGVIR09011VO" property="strategyEntity.configItemList" indexId="index1">
			                		<c:if test="${bean1.resourceitem == bean.cid}">
			                			<html:text property="values" tabindex="1" style="width:125px;" errorStyleClass="inputError" value="${bean1.price}"
			                			styleId="values${index}"/>(元/天)
			                			<%
					       					flag = "yes";
					       				%>
			                		</c:if>
			                	</logic:iterate>
			                	<%
					       			if("no".equals(flag)){
					       		%>	
					       			<html:text property="values" tabindex="1" style="width:125px;" errorStyleClass="inputError" value="0" styleId="values${index}"/>(元/天)
					       		<%} %>
			                	<html:hidden property="configItemCids" value="${bean.cid}"/>
			                	<br>
			            	</div>
	                        </logic:iterate>
                        </logic:present>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert"  styleClass="button"  onclick="return checkForm();"  value="提交"/>
		                <html:reset  property="btn_reset"  styleClass="button"  value="重置"/>
		            </div>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
<script type="text/javascript">	
	 function checkForm(){ 
	    var patrn=/[\/\\:*?<>&;|\"\']+/;
	    var enopatrn =/^[0-9]*$/;
		var name = $F('strategyName'); 	
		var length = '${index}';
		if(name.trim() == ''){
			alert("策略名称不能为空！");
			return false;
		}
		if(patrn.exec(name)){   
    		alert("策略名称不能包含下列字符:  "+"\/\\:*?\"'<>&;|");
    		return false;
    	}
    	for(var i=0;i<=length;i++){
	    	var temp = document.getElementById("values"+i).value;
			if(temp.trim() != '' && !enopatrn.exec(temp)){
				alert("价格必须是数字！");
				return false;
			}
		}
		return true;
	  }
</script>
</html:html>