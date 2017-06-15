<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0317" toScope="request"/>
<bean:define id="title" value="设备基本信息登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM0317';

         function addFileValue() 
     	{
     		currRow=tb.insertRow();
     		cell=currRow.insertCell();
     		cell.innerHTML = "<label for='Name' style='margin-left:57px;float:left'><strong><span class='red'>*</span>设备编号：</strong></label><input type='text' name='eilabels' contentEditable='true' style='float:left'>"
     		 	+ "<label for='Name' style='float:left'><strong><span class='red'>*</span>设备名称：</strong></label><input type='text' name='einames' contentEditable='true' style='float:left'>"
     			+ "<input type='button' class='button' value='\u5220\u9664' onclick='deleteValue(this)' style='float:left'>";
 	   	}
         function deleteValue(obj)
			{
				var curRow= obj.parentNode.parentNode;
				tb.deleteRow(curRow.rowIndex);
			}
	   	
         
		 function checkForm(){
				var temp = document.getElementsByName("eilabels");
				var einames = document.getElementsByName("einames");
				if(temp!=null&&temp.length==0)
				{
					alert("请增加设备信息！");
					return false;
				}else{
					for ( var i = 0; i < temp.length; i++) {
						if(temp[i].value == "" ){
							alert("请增加第"+(i+1)+"个设备编号！");
							return false;
						}
						if(einames[i].value == "" ){
							alert("请增加第"+(i+1)+"个设备名称！");
							return false;
						}
						if(temp[i].value.strlen()>32 ){
							alert("第"+(i+1)+"个设备编号不能大于32个字符！");
							return false;
						}
						if(einames[i].value.strlen()>120){
							alert("第"+(i+1)+"个设备名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
							return false;
						}
					}
				}
				
	    		var message = '<bean:message key="IGCO10000.W001" arg0="设备基本信息" />';
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
		    	}


		
	</script>
<body >
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 设备批量登记</p>
            <div class="back"><html:link href="IGASM0316_Back.do">返回</html:link></div>
            </div>
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM0317" onsubmit="return checkSubmit(this);">
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
                        <div style="padding-left: 20px"><img src="images/brick.gif" width="13" height="13"/><a
							href="javascript:addFileValue();" id="aAddAttach">&nbsp;增加设备信息</a>
						</div>
                        <table id="tb">
						</table>
			           </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		            </div>
		             <html:hidden property="esyscoding"/>
		             <html:hidden property="eiorgsyscoding"/>
			         <html:hidden property="eid"/>
			         <html:hidden property="pareiid"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>