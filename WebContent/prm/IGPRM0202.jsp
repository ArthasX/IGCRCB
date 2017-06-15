<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.prm.vo.IGPRM02011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<script type="text/javascript">
function checkForm(){
	if($F('ptid').trim()==""){
		alert("请选择流程模板！");
		return false;
	}
	if($F('pdname').trim()==""){
		alert("请输入类型名称！");
		return false;
	}
	if($F('pdname').trim().strlen()>128){
		alert("类型名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('pddesc').trim().strlen()>64){
		alert("类型描述不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}
</script>
<html:html>
<bean:define id="id" value="IGPRM0202" toScope="request" />
<bean:define id="title" value="类型新增画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
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
<p class="fonts1">系统管理 &gt;&gt; 流程类型 &gt;&gt; 类型新增</p>
</div>


 <div id="formwrapper">
       <html:form action="IGPRM0202.do" method="post">
       <ig:message />
    <fieldset>
       <legend>流程类型信息</legend>
 
       <div>
            <label for="ptid"><span class="red">*</span><strong>流程模板</strong>：</label>
            <html:select property="ptid" errorStyleClass="inputError imeActive" styleId="ptid">
				<html:options collection="list" property="value" name="" labelProperty="label"/>
			</html:select>
            <br />
    	</div>
        <div>
          <label for="pdname"><span class="red">*</span><strong>类型名称</strong>：</label>
           <html:text property="pdname" styleId="pdname" errorStyleClass="inputError" size="32"/>
          <br />
       </div>
        <div>
          <label for="pddesc"><strong>类型描述</strong>：</label>
           <html:textarea property="pddesc" styleId="pddesc" errorStyleClass="inputError" rows="6" cols="60"/>
          <br />
        </div>
        </fieldset>
        <div class="enter">
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