<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<html:html>
<bean:define id="id" value="IGSYM1802" toScope="request"/>
<bean:define id="title" value="首页管理增加" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	function confirmDisp(){
		
		if($("hplabel").value.trim()==""){
			alert("请填写首页描述！");
			return false;
		}
		if($('hptitle').value.trim()==""){	
			alert("请填写首页显示名称！");
			return false;
			
		}
		if($('hpurl').value.trim()==""){	
			alert("请填写首页URL！");
			return false;
			
		}
		if($F('hplabel').strlen()>32){
			alert("首页描述不能长于32位！");
			return false;
		}
		if($F('hpurl').strlen()>32){
			alert("首页URL不能长于32位！");
			return false;
		}
		if($F('hptitle').strlen()>32){
			alert("首页显示名称不能长于32位！");
			return false;
		}
		else{
			return true;
			}
		
	}
	
	
	function addsubmit(){
		if(confirmDisp()){		
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 首页登记
	            </p>
	            <div class="back"><a href="IGSYM1801_Disp.do" target="_self">返回</a></div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGSYM1801_Insert.do" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
				 <fieldset>
					   <legend>首页登记</legend>
					 <div>
						<label for="Name"><strong><span class="red">*</span>首页描述</strong>：</label>
							<html:text name="IGSYM1802Form" property="hplabel" styleId="hplabel" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"/>
						<br>
    				</div>                                    
    				<div>
						<label for="Name"><strong><span class="red">*</span>首页显示名称</strong>：</label>
							<html:text name="IGSYM1802Form" property="hptitle" styleId="hptitle" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"/>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>首页URL </strong>：</label>
							<html:text name="IGSYM1802Form" property="hpurl" styleId="hpurl" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"/>
						<br>
    				</div>
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