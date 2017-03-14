<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGIOP0202" toScope="request"/>
<bean:define id="title"  toScope="request" value="IP分配"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">

	
</script>

<body onLoad="">
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
                  <p class="fonts1">IP管理 &gt;&gt;IP管理 &gt;&gt;IP分配 </p>
            </div> 
            <html:form action="IGIOP0202_Allot" method="POST">
            
            	<fieldset>
             			<legend>IP登记</legend>
             			<div>
		                     <label for="Name"><strong>子网掩码</strong>：</label>
		                  	 <input type="text" style="border:0px" readonly="readonly"  value="${IGIOP02021VO.subnet }"/>
                 		</div>
                 		<div>
		                     <label for="Name"><strong>所选IP</strong>：</label> 
		                  	 <input type="text" style="border:0px" readonly="readonly"  value="${IGIOP02021VO.IPAddr }"/>
		                     
                 		</div>
                 		<div>
		                     <label for="Name"><strong>分配说明</strong>：</label>
		                     <html:hidden property="eiid" value="${IGIOP02021VO.eiid }"/>
		                    
		                     <html:textarea property="desc" styleId="desc" tabindex="5" style="width:300px;height:100px;"></html:textarea>
                 		</div>
             		</fieldset>      
             		<div class="enter">
							<html:submit  styleClass="button">提交</html:submit>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<html:button property="btn_Back" styleClass="button" onclick="toBack()">返回</html:button>
             		</div>    
	            
            </html:form>
           
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
<script type="text/javascript">
	function toBack(){
		document.forms[0].action = getAppRootUrl()+"/IGIOP0201_Back.do";
		document.forms[0].submit();
	}
	
</script>
</body>
</html:html>