<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html:html>
<bean:define id="id" value="IGCIM1633" toScope="request"/>
<bean:define id="title" value="密码关系登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style>
	fieldset div{
		
		text-align: left;
	}
	fieldset input{
		margin-left: 15px;
	}
</style>

	<script type="text/javascript">	
	
	
	function toback(){
		var form = document.forms[0];
		form.action = getAppRootUrl() +"/IGCIM1632_Disp.do";
		form.submit();
    }

	
	function checkForm(){
		if(!$("elabel").value.trim()){
			alert("请选择业务系统!");
			return false;
		}
		if($("eirdesc").value.length>256){
			alert("描述信息过长!");
			return false;
		}
	
	}
		 function selectEntityItem(){
			openSubIGCOM0327PARAM("?esyscoding=999003001"+"&flag=false");
	     }

        function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
            $("cldeid").value = eid;
            $("elabel").value = elabel;
            $("cldeiid").value = eiid;
            $("eilabel").value = eilabel;
            $("einame").value = einame;
            
        }
        function initForm(){
        	$("elabel").value='';
        	$("einame").value='';
        }
	</script>
<body onload="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
			<div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 密码关系登记</p>
                   <div class="back"><html:link href="javascript:toback(${IGCIM16321VO.entityItemData.eiid });">返回</html:link></div>
            </div> 

  
			<div id="formwrapper">
        	<!--  message -->
                   <ig:message/>
            <!--  /message -->
        	<html:form action="IGCIM1633_Insert" method="POST" onsubmit="return checkForm()" >
        	<fieldset>
             <legend>密码关系信息添加</legend>
        	
        		 <div>
                     <label for="Name"><strong>搜索代码</strong>：</label>
                     <html:text property="pareilabel" styleId="pareilabel" styleClass="inputDisable" value="${IGCIM16321VO.entityItemData.eilabel }" readonly="true"  errorStyleClass="inputError imeActive" tabindex="0"></html:text>
                     <html:hidden property="pareiid" value="${IGCIM16321VO.entityItemData.eiid }"/>
                     <html:hidden property="pareid" value="${IGCIM16321VO.entityItemData.eid }"/>
                     <html:hidden property="parsmallversion" value="${IGCIM16321VO.entityItemData.eismallversion }"/>
                     <html:hidden property="parversion" value="${IGCIM16321VO.entityItemData.eiversion}"/>
                     <html:hidden property="eirrelationcode" value="${fn:substring(IGCIM16321VO.entityItemData.esyscoding,3,6)}-003"/>
					 <html:hidden property="eiid" value="${IGCIM16321VO.entityItemData.eiid}"/>
                 </div>
        		 <div>
                     <label for="Name"><strong>名称</strong>：</label>
                     <input type="text"  id ="parename" value="${IGCIM16321VO.entityItemData.einame }" class="inputDisable" readonly="readonly" tabindex="1"/>
                 </div>
        		 <div>
                     <label for="Name"><strong><span class="red">*</span>业务系统编号</strong>：</label>
                    <html:text property="eilabel" styleId="eilabel" readonly="true" errorStyleClass="inputError imeActive"  tabindex="3"/>
                     <img src="images/seek.gif" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGCIM0107.search.alt"/>' onclick="selectEntityItem()" style="cursor: hand"/>
                 </div>
        		<div>
                      <label for="Name"><strong><span class="red">*</span>业务系统名称</strong>：</label>
                      <html:text property="einame" styleId="einame" size="12" tabindex="5"  errorStyleClass="inputError imeActive" readonly="true" />
                      <br>
                </div>
        		<div>
                      <label for="Name"><strong>说明</strong>：</label>
                      <html:textarea property="eirdesc" styleId="eirdesc" style="margin-left:15px;" cols="60" rows="6">
                      
                      </html:textarea>
                </div>
                	<html:hidden property="eirrelation" value="CR990100010001"/>
        			<html:hidden property="pidid" />
        			<html:hidden property="cldeid" />
        			<html:hidden property="cldeiid" />
        			<html:hidden property="elabel" />
	            </fieldset>
	             <div class="enter">
	                <html:submit property="btn_insert"   styleClass="button"  value="提交" />
	             </div>
			</html:form>
			</div>
		 </div>
		 </div>
</body>
</html:html>