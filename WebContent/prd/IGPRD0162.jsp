<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0162" toScope="request" />
<bean:define id="title" value="外部事件登记" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function toback() {
    form.action = getAppRootUrl() + "/IGPRD0161_List.do";
	form.submit();
}
function checkForm() {
	if ($F('pedeventid').trim() == "") {
		alert("请填写事件ID名称！");
		return false;
	}
	if($F('pedeventid').strlen() > 32) {
		alert("外部事件ID名称不能大于10个汉字！");
		return false;
	}	
	if ($F('pedaction').strlen() > 32) {
		alert("外部事件调用BL不能大于10个汉字！");
		return false;
	}		
	if ($F('peddesc').strlen() > 128) {
		alert("外部事件描述不能大于42个汉字！");
		return false;
	}
	else {
		var message = '确定要添加外部调用基本信息吗?';
		if (window.confirm(message)) {
			return true;
		} else {
			return false;
		}
	}
	

}
function list(){
     form.action =getAppRootUrl()+"/IGPRD0158_List.do";
     form.submit();
}


</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
  <div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
       <div id="content">
            <div id="formwrapper"> 
		           <html:form styleId="form" action="/IGPRD0161">
			          <div id="location">
			               <div class="image"></div>
			               <logic:equal name="IGPRD0161Form" property="mode" value="0">
					           <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 外部事件配置 &gt;&gt; 外部事件登记</p>
				           </logic:equal> 
				           <logic:equal name="IGPRD0161Form" property="mode" value="1">
					            <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 外部事件配置 &gt;&gt; 外部事件修改</p>
				           </logic:equal> 
				           <div class="back">
                           <html:link href="javascript:toback();">返回</html:link>
	                       </div>
			          </div>
			           <!--  message -->
			           <ig:message />
			           <!--  /message -->     
			           <fieldset>         
							<logic:equal name="IGPRD0161Form"  property="mode" value="0">
							<legend>外部事件登记</legend>
							</logic:equal>
							<logic:equal name="IGPRD0161Form"  property="mode" value="1">
							<legend>外部事件修改</legend>
							</logic:equal>
			                 
		                    <div>
								<label for="Name"><strong><span class="red">*</span>事件ID</strong>：</label>
								<html:text name="IGPRD0161Form" property="pedeventid" styleId="pedeventid" size="32" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
								<br>
		    				</div>
		    				<div>
								<label for="Name"><strong><span class="red">*</span>调用BL</strong>：</label>
								<html:text name="IGPRD0161Form" property="pedaction" styleId="pedaction" size="32" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
								<br>
		    				</div>
		    				<div>
								<label for="Name"><strong><span class="red">*</span>描述</strong>：</label>
								<html:textarea name="IGPRD0161Form" property="peddesc" styleId="peddesc"  errorStyleClass="inputError" tabindex="1"  cols="60" rows="6" />
								<br>
		    				</div>
						</fieldset>
				          <div class="enter">
			                    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
			                    
			              </div>										
					     <html:hidden property="pedid"/>				        
					     <html:hidden property="mode" styleId="mode"/>
		             </html:form>
		     </div>		
 		</div>  				          
       </div>
    </div>

</div>

</body>
</html:html>
