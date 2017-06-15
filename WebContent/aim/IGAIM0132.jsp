<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGAIM0132" toScope="request"/>
<bean:define id="title"   toScope="request" >
	<bean:message bundle="asmResources" key="ietitle.IGASM0810"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	var gid='IGASM0810';
    function toback(){
        form.action = getAppRootUrl() + "/IGASM0808_Back.do";
        form.submit();
    }
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><bean:message bundle="asmResources" key="navigation.IGASM.assetConfig"/> &gt;&gt; <bean:message bundle="asmResources" key="navigation.IGASM.UserAsset"/> &gt;&gt;
	<bean:message bundle="asmResources" key="navigation.IGASM.UserSearch"/>  &gt;&gt; <bean:message bundle="asmResources" key="navigation.IGASM.HistoryVersion"/>
</p>
<div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGASM0810.btn_toback"/></html:link></div>
</div>



<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGASM0810.UserInfo"/></div>
</div>

 <div id="results_list">
                    <table class="table_style">
                        <tr>
                         	<th width="10%"><bean:message bundle="asmResources" key="label.IGASM0810.ModelName"/></th>
	                        <th width="15%"><bean:message bundle="asmResources" key="label.IGASM0810.UserNO"/></th>
	                        <th width="20%"><bean:message bundle="asmResources" key="label.IGASM0810.UserName"/></th>
	                        <th width="10%"><bean:message bundle="asmResources" key="label.IGASM0810.UserOrgan"/></th>
	                        <th width="18%"><bean:message bundle="asmResources" key="label.IGASM0810.UserRemark"/></th>
	                        <th width="7%"><bean:message bundle="asmResources" key="label.IGASM0810.UserManager"/></th>
	                        <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0810.UserMarkDay"/></th>
	                        
                        </tr>
                        <tr>
                         <td align="center">
                            ${IGCIM01251VO.entityData.ename}
                          </td>
                          <td align="center">${IGCIM01251VO.entityData.eilabel}</td>
                          <td align="center">${IGCIM01251VO.entityData.einame}</td>
                          <td>${IGCIM01251VO.eiorgname}</td>
					 	  <td>${IGCIM01251VO.entityData.eidesc}</td>
					 	  
                         <td align="center">${IGCIM01251VO.entityData.eiusername}</td>
                         <td align="center">${IGCIM01251VO.entityData.eiinsdate}</td>
                         
                        </tr>
                     </table>
             </div>

<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGASM0810.HistoryVersionInfo"/></div>
</div>
<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGASM0810.VersionNO"/></th>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGASM0810.ModifyTime"/></th>        
		 </tr>
		 <logic:present name="IGCIM01251VO" property="configItemVersionTime">
			<logic:iterate id="bean" name="IGCIM01251VO" property="configItemVersionTime"
				indexId="index">
				<tr>
		       		<td>
				       <c:if test="${IGCIM01251VO.flag==true}">
				          <a href='javascript:openVersionInfoDetail(${IGCIM01251VO.entityData.eiid},${bean.civersion},${bean.cismallversion})'>${bean.civersion}<bean:message bundle="asmResources" key="label.IGASM0810.Version"/> </a>
				       </c:if>
				       <c:if test="${IGCIM01251VO.flag!=true}">${bean.civersion}<bean:message bundle="asmResources" key="label.IGASM0810.Version"/> </c:if>
		       		</td>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<html:form styleId="form"  action="/IGASM0808_Back" onsubmit="return checkSubmit(this);">
	<c:if test="${IGCIM01251VO.flag==true}">
    	<logic:present name="IGCIM01251VO" property="configItemVersionTime">
			<bean:size id="num" name="IGCIM01251VO" property="configItemVersionTime"/>
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button" onclick="openEiVersionWindow('${IGCIM01251VO.entityData.eiid}');" >
			    		<bean:message bundle="asmResources" key="button.IGASM0810.btn_compare"/>
			    	</html:button>	
    			</c:if>
		</logic:present>
	</c:if>
		<html:submit property="btn_back" styleClass="button" >
			<bean:message bundle="asmResources" key="button.IGASM0810.btn_toback"/>
		</html:submit>
	</html:form>
</div>

</div>
</div>
</div>


</div>
</body>
</html:html>