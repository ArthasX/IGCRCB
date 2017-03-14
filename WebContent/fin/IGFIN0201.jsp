<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0201" toScope="request" />
<bean:define id="title" value="费用登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">


function confirmDisp(){
	if(document.forms[0].btitle.value == ""){
		alert("请选择费用预算！");
		return false;
	}
	if(0 == document.getElementById("examount").value){
		alert("请输入费用金额！");
		return false;
	}		
	if(document.forms[0].exapvname.value == ""){
		alert("请输入费用名称！");
		return false;
	}

		if($F('exapvname').strlen()>128){
			alert("费用名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('exdesc').strlen()>512){
			alert("费用说明不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
			return false;
		}
		
		return checkNumber($F('examount'));
		if(confirm("是否确认提交")){
			document.forms[0].submit();
			return true;
		}

}
function selectBudget(){
	openSubWindow('/IGFIN0202_Disp.do?', '_blank','1000','600');
}
function setParamIGFIN0202(bid,btitle) {

	
    $("bid").value = bid;
	$("btitle").value = btitle;	
	document.getElementById("bid").value = bid;
}

var num = 0;
function addFile() {
	currRow=tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' class='inputbutton' name='attachFile["+num+"]'><input type='hidden' name='exattkey'/><input type='button' class='delbutton' value='删除' onclick='deleteitem(this)'>";
	num++;
}

function deleteitem(obj){
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}
function checkNumber(obj){           

    if (fIsNumber(obj.value)){   
    	 if(obj.value.length > 10){
         	alert("费用金额输入过长！");
         	document.getElementById("examount").value = "";   
             return false;   
         }
        	return true;   
    }else if(obj.value==0){
		alert("费用金额请输入非0的数字！");
		document.getElementById("examount").value = ""; 
		return false;
	}else {   
       alert("费用金额请输入数字！");   
       document.getElementById("examount").value = "";
       return false;   
    }   
} 
</script>


<body>
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
        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 费用登记</p>
        
     </div>
      
   <div id="formwrapper">
	<html:form styleId="form" action="/IGFIN0201"
	               onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	               
	    <ig:message />        <fieldset>
        <legend>费用信息</legend>
         <div>
            <label for="Name"><strong><span class="red">*</span>费用预算</strong>：</label>
          	<html:text property="btitle" size="20" errorStyleClass="inputError imeDisabled" readonly="true"/> <html:hidden property="bid" />
<!--			<input type="button" name="btn_budget" value="查询" onclick="selectBudget();" class="button"> -->
				<img src="images/seek.gif" width="16" height="16" onclick="selectBudget();" style="cursor: hand" alt="查询"/>
			<br />
        </div>
        
        <div>
          <label for="Name"><strong><span class="red">*</span>费用金额（元）</strong>：</label>
          <html:text property="examount" size="20"/>
          <br />
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>费用名称</strong>：</label>
          	<html:text property="exapvname" size="40" />
          	<br />
        </div>
       
        <div>
          	<label for="Name"><strong><span class="red">*</span>发生时间</strong>：</label>
          	<html:text property="exopentime" size="20" readonly="true"/>
          	<img src="images/date.gif" align="middle" onClick="calendar($('exopentime'))" border="0"/>
	                        &nbsp;&nbsp;
          <br />
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>登记时间</strong>：</label>
          	<html:text property="exclosetime" size="20" readonly="true"/>
          	<img src="images/date.gif" align="middle" onClick="calendar($('exclosetime'))" border="0"/>
	                        &nbsp;&nbsp;
          <br />
        </div>
        <div>
            <label for="Name"><strong>费用说明</strong>：</label>
            <html:textarea property="exdesc" cols="50" rows="6" />
          <br />
       	</div>
       	<div style="padding-left:50px">
       		<html:hidden property="bid" />
    		<img src="images/attachment.gif" /><a href="javascript:addFile();" id="aAddAttach">添加附件</a>
        	<table id="tb">
        </table>
        </div>
        </fieldset>
    <div class="enter">
        <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		<html:reset styleClass="button"	value="重置" />
    <div class="Placeholder"></div>
    </div>
   </html:form>
     </div>
   </div>

   </div>
  

</div>

</div>
</body>
</html:html>