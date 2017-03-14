<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<html:html>
<bean:define id="id" value="IGPRD0177" toScope="request"/>
<bean:define id="title" value="流程页面管理修改" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	function confirmDisp(){
		
		if($("pjdtype").value.trim()==""){
			alert("请选择页面类型！");
			return false;
		}
		if($('pjdurl').value.trim()==""){	
			alert("请填写相对路径！");
			return false;
			
		}
		if($F('pjdblid').strlen()>32){
			alert("页面调用bl不能长于32位！");
			return false;
		}
		
		if($F('pjdurl').strlen()>32){
			alert("页面相对路径不能长于32位！");
			return false;
		}
		else{
			return true;
			}
		
	}
	
	
	function addsubmit(){
			
		if(confirmDisp()){
			//alert(1);
			//form.action = getAppRootUrl() + "/IGPRD0168_Insert.do?pdid="+pdid;
			form.submit();
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
                <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 页面管理 &gt;&gt;流程页面修改
	            </p>
	            <div class="back"><a href="IGPRD0168_Disp.do?pdid=${IGPRD0168Form.pdid}" target="_self">返回</a></div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGPRD0169_Edit.do" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
				 <fieldset>
					   <legend>流程页面修改</legend>
					 <div>
						<label for="Name"><strong><span class="red">*</span>页面类型</strong>：</label>
							<html:select name="IGPRD0169Form" property="pjdtype"
							  value="${IGPRD01681VO.lst_IG126Info[0].pjdtype }">
								<ig:optionsCollection ccid="PROCESS_JSP_CODE" isMakeBlankRow="false" isCodeLabel="true" 
								
								/>
								
							</html:select>
							
						<br>
    				</div>                                    
    				<div>
						<label for="Name"><strong><span class="red">*</span>页面相对路径</strong>：</label>
							<html:text name="IGPRD0169Form" property="pjdurl" styleId="pjdurl" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"
							value="${IGPRD01681VO.lst_IG126Info[0].pjdurl }"
							/>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong>页面调用BL</strong>：</label>
							<html:text name="IGPRD0169Form" property="pjdblid" styleId="pjdblid" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"
							value="${IGPRD01681VO.lst_IG126Info[0].pjdblid }"
							/>
						<br>
    				</div>
    				<html:hidden property="pjdid" value="${IGPRD01681VO.lst_IG126Info[0].pjdid }"/>
	       			<html:hidden property="mode" value="1"/>
    				</fieldset>
				<div class="enter">
				    <input name="add" type="button" class="button" value="提交" onclick="addsubmit();" /> 
				    <html:reset property="btn_clear" styleClass="button" value="重置" />
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