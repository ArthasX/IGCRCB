<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRM0302" toScope="request" />
<bean:define id="title" value="变量新增画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">

function showDIV(obj){
	if(obj.value == "2"){
		document.getElementById("option").style.display = "";
		document.getElementById("default").style.display = "";
		document.getElementById("tree").style.display = "none";
		document.getElementById("ccid").value = "";
	}else if(obj.value == "T"){
		document.getElementById("tree").style.display = "";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
	} else {
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";

		document.getElementById("tree").style.display = "none";
		document.getElementById("ccid").value = "";
	}
}

function checkForm(){
	if($F('pidname')==""){
		alert("请输入变量名称！");
		return false;
	}
	if($F('pidlabel')==""){
		alert("请输入显示名称！");
		return false;
	}
	if($F('pidtype')==""){
		alert("请输入变量类型！");
		return false;
	}
	if(document.getElementById("pidtype").value == "2"){
		var pidoption = document.getElementById("pidoption").value;
		if("" == pidoption){
			alert("请输入取值范围");
			return false;
		}
	}
		if(document.getElementById("pidtype").value == "T"){
		var ccid = document.getElementById("ccid").value;
		if("" == pidoption){
			alert("请选择一棵树！");
			return false;
		}
	}
	if($F('pidname').trim().strlen()>128){
		alert("变量名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('pidlabel').trim().strlen()>32){
		alert("显示名称不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('pidoption').trim().strlen()>1024){
		alert("取值范围不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('piddefault').trim().strlen()>64){
		alert("默认值不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('piddesc').trim().strlen()>64){
		alert("变量描述不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}

function selectTree(){
	    //openSubIGSYM1108();
	    openSubWindow('/IGSYM1506_Disp.do' , '', '850', '600');
 }
 
  function setCcidParams(ccid,ccname) {
	 if(ccid==null || ""==ccid){
		 document.forms[0].ccid_name.value = "";
		 document.forms[0].ccid.value = "";
	 }else{
		 document.forms[0].ccid_name.value = ccname;
		 document.forms[0].ccid.value = ccid+"_tree_"+ccname;
	 }
		

}

</script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程类型 &gt;&gt; 变量新增</p>
<div class="back"><a href="IGPRM0301_Disp.do?pdid=<bean:write name="IGPRM0302Form" property="pdid" />" target="_self">返回</a></div> 
</div>


 <div id="formwrapper">
       <html:form action="/IGPRM0302">
       <ig:message />
    <fieldset>
       <legend>流程变量信息</legend>
 
        <div>
          <label for="pidname"><span class="red">*</span><strong>变量名称</strong>：</label>
           <html:text property="pidname" styleId="pidname" errorStyleClass="inputError" size="32"/>
          <br />
       </div>
       
       <div>
          <label for="pidlabel"><span class="red">*</span><strong>显示名称</strong>：</label>
           <html:text property="pidlabel" styleId="pidlabel" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        
        <div>
          <label for="pidtype"><span class="red">*</span><strong>变量类型</strong>：</label>
           <html:select name="IGPRM0302Form" property="pidtype" onchange="showDIV(this);" errorStyleClass="inputError">
           	<ig:optionsCollection ccid="PROCESSINFODEF_TYPE_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
           </html:select>
          <br />
        </div>
        
        <div id="option" style="display:none">
          <label for="pidoption"><span class="red">*</span><strong>取值范围</strong>：</label>
           <html:text property="pidoption" styleId="pidoption" errorStyleClass="inputError" size="32"/>
          	 用"#"号分割
          <br />
        </div>
	 <div id="tree" style="display:none">
       <label for="ccid"><span class="red">*</span><strong>定义树</strong>：</label>
       	 	<html:text property="ccid_name" styleId="ccid_name" errorStyleClass="inputError" readonly="true"/>
			<img src="images/seek.gif" alt="查询" onclick="selectTree()" style="cursor: hand"/>
			<html:hidden property="ccid" styleId="ccid"/>
       <br />
     </div>
        <div id="default" style="display:none">
          <label for="piddefault"><strong>默认值</strong>：</label>
           <html:text property="piddefault" styleId="piddefault" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        
        <div>
          <label for="pidrequired"><span class="red">*</span><strong>是否必填</strong>：</label>
           <html:select property="pidrequired">
           	<html:option value="0">否</html:option>
           	<html:option value="1">是</html:option>
           </html:select>
          <br />
        </div>
        
        <div>
          <label for="piddesc"><strong>变量描述</strong>：</label>
           <html:textarea property="piddesc" styleId="piddefault" errorStyleClass="inputError" rows="4" cols="60"/>
          <br />
        </div>
        
        </fieldset>
        <div class="enter">
        	 <html:hidden property="pdid" styleId="pdid"/>
        	<input name="Save" type="submit" class="button" value="保存" onclick="return checkForm();"/>
        	<input name="Reset" type="reset" class="button" value="重置" />
    	</div>
   		</html:form>
    
     </div> 

</div>
</div>
</div>


</div>
</body>
</html:html>