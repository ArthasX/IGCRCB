<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0329" toScope="request"/>
<bean:define id="title" value="设备基本信息画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM0330';

		 function checkForm(){
			var addcount = document.forms[0].addcount.value;
			var maxcount = document.forms[0].maxcount.value;
			var eiinsdate = document.forms[0].eiinsdate.value;
			if(eiinsdate.trim()==""){
				alert("请您选择登记日！");
				return false;
			}
			if(addcount.trim()==""){
				alert("请您填入批量登记条数！");
				$("addcount").focus();
				return false;
			}
			if(parseInt(addcount, 10)>parseInt(maxcount, 10)){
				alert("批量登记条数不能超过单次最大登记数！");
				$("addcount").value = "2";
				$("addcount").focus();
				return false;
			}
			
			if( window.confirm("您确定要提交吗？")){
				return true;
			} else {
				return false;
			}
		 }
		 function checkNum(obj){
				if(isNaN(obj.value)){
					alert("请输入数字！");
					obj.value = "2";
					obj.focus();
					event.returnValue = false;
				}
				if(obj.value <= 0){
					alert("请输入正整数！");
					obj.value = "2";
					obj.focus();
					event.returnValue = false;
				}
				var intnum = /^(\+|-)?\d+$/;
				if(!intnum.test(obj.value)){
					alert("请输入整数！");
					obj.value = "2";
					obj.focus();
					event.returnValue = false;
				}
		}
					
		 
		 function setFocus(){
			if($("addcount")){
				$("addcount").focus();
			}
		 }
		
		
	</script>
<body onload="setFocus();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 设备批量登记
                </p>
            <div class="back"><html:link href="IGASM0316_Back.do">返回</html:link></div>
            </div>
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM0317_Disp_Insert" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
			            <legend>设备基本信息添加</legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
                            <html:text property="ename" errorStyleClass="inputError imeActive" readonly="true"  styleClass="inputDisable" tabindex="2"/>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>所属机构</strong>：</label>
							<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive" styleClass="inputDisable"></html:text>
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong>设备说明</strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" size="50" tabindex="3" styleClass="inputDisable" errorStyleClass="inputError" readonly="true" />
			                <br>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
                            <html:text property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiinsdate'))" border="0"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>单次最大登记数</strong>：</label>
                             <p class="p2">&nbsp;&nbsp;<bean:write name="IGASM0317Form" property="maxcount"/></p>				
                            <br>
                        </div>
                       	<div>
                            <label for="Name"><strong><span class="red">*</span>批量登记条数</strong>：</label>
                            <html:text property="addcount" errorStyleClass="inputError imeActive" onchange="checkNum(this);" />
                            <br>
                        </div>
			           </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		            </div>
		             <html:hidden property="esyscoding"/>
		             <html:hidden property="eiorgsyscoding"/>
			         <html:hidden property="eid"/>
			         <html:hidden property="pareiid"/>
			         <html:hidden property="maxcount"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>