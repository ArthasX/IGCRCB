<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<script type="text/javascript">
function checkForm(){

	if($F('ptname')==""){
		alert("请输入模板名称！");
		return false;
	}
	if($F('pttype')==""){
		alert("请输入模板类型！");
		return false;
	}
	if($F('ptstartpg')==""){
		alert("请输入起始URL！");
		return false;
	}
	if($F('ptpicinfo')==""){
		alert("请输入流程图！");
		return false;
	}
	if($F('ptdetailpg')==""){
		alert("请输入查看页！");
		return false;
	}

	if($F('ptname').trim().strlen()>128){
		alert("模板名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('pttype').trim().strlen()>3){
		alert("模板类型不能大于"+Math.floor(3/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('ptstartpg').trim().strlen()>64){
		alert("起始URL不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('ptpicinfo').trim().strlen()>32){
		alert("流程图不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('ptdetailpg').trim().strlen()>64){
		alert("查看页不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	
	if($F('ptsavepg').trim().strlen()>64){
		alert("任务调度URL不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('ptqrtzflag').trim().strlen()>4){
		alert("调度类型不能大于"+Math.floor(4/strByteFlag)+"个汉字！");
		return false;
	}
	
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}
</script>
<html:html>
<bean:define id="id" value="IGPRM0102" toScope="request" />
<bean:define id="title" value="模板新增画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
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
<p class="fonts1">系统管理 &gt;&gt; 流程模板 &gt;&gt; 模板新增</p>
</div>

<div id="formwrapper">
       <html:form action="IGPRM0102.do" method="post" >
       <ig:message />
    <fieldset>
       <legend>流程模板信息</legend>
 
       <div>
            <label for="ptname"><span class="red">*</span><strong>模板名称</strong>：</label>
            <html:text property="ptname" styleId="ptname" errorStyleClass="inputError" size="32"/>
            <br />
	   </div>
	   
       <div>
          <label for="pttype"><span class="red">*</span><strong>模板类型</strong>：</label>
          <html:text property="pttype" styleId="pttype" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        
        <div>
          <label for="ptstartpg"><span class="red">*</span><strong>起始URL</strong>：</label>
           <html:text property="ptstartpg" styleId="ptstartpg" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        
        <div>
          <label for="ptpicinfo"><span class="red">*</span><strong>流程图</strong>：</label>
           <html:text property="ptpicinfo" styleId="ptpicinfo" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        <div>
          <label for="ptdetailpg"><span class="red">*</span><strong>查看页</strong>：</label>
           <html:text property="ptdetailpg" styleId="ptdetailpg" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        
        <div>
          <label for="ptsavepg"><strong>任务调度URL</strong>：</label>
           <html:text property="ptsavepg" styleId="ptsavepg" errorStyleClass="inputError" size="32"/>
          <br />
        </div>
        <div>
          <label for="ptqrtzflag"><strong>调度类型</strong>：</label>
           <html:text property="ptqrtzflag" styleId="ptqrtzflag" errorStyleClass="inputError" size="32"/>
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