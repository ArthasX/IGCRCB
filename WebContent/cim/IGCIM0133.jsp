<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0133" toScope="request"/>
<bean:define id="title"   toScope="request" >
	<bean:message bundle="asmResources" key="ietitle.IGASM0811"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGASM0811';
	    function deleteRec(){
	        var message ='<bean:message key="IGCO10000.E002"/>';
	        var arg0= '<bean:message bundle="asmResources" key="message.IGASM0811.001"/>';
	        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
	        var frm = window.document.forms[0];
	        if(frm.deleteEirid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteEirid.length; i++ ){
	                if (frm.deleteEirid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	                alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteEirid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
	
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM0806_Del.do";
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    function toback(){
	        form.action = getAppRootUrl() + "/IGASM0808_Back.do";
	        form.submit();
	    }
	</script>
	<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
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
                <p class="fonts1">
                <bean:define id="urlable">
         			<bean:message bundle="asmResources" key="navigation.IGASM.RelationshipView"/>
    			</bean:define> 
    			<ig:navigation extname1="${urlable}" />
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGASM0811.btn_toback"/></html:link></div> 
            </div>
            <html:form styleId="form"  action="/IGASM0806" onsubmit="return checkSubmit(this);">
                <div class="title">
                    <div class="name"><bean:message bundle="asmResources" key="label.IGASM0811.UserInfo"/></div>
                </div>
                <div id="results_list">
                    <table class="table_style">
                        <tr>
                            <th width="10%"><bean:message bundle="asmResources" key="label.IGASM0811.ModelName"/></th>
	                        <th width="15%"><bean:message bundle="asmResources" key="label.IGASM0811.UserNO"/></th>
	                        <th width="20%"><bean:message bundle="asmResources" key="label.IGASM0811.UserName"/></th>
	                        <th width="10%"><bean:message bundle="asmResources" key="label.IGASM0811.UserOrgan"/></th>
	                        <th width="18%"><bean:message bundle="asmResources" key="label.IGASM0811.UserRemark"/></th>
	                        <th width="7%"><bean:message bundle="asmResources" key="label.IGASM0811.UserManager"/></th>
	                        <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0811.UserMarkDay"/></th>
	                        <th width="12%"><bean:message bundle="asmResources" key="label.IGASM0811.UpdateTime"/></th>
                        </tr>
                        <tr>
                          <td align="center">
                            ${IGCIM01261VO.entityData.ename}
                          </td>
                          <td align="center">${IGCIM01261VO.entityData.eilabel}</td>
                          <td align="center">${IGCIM01261VO.entityData.einame}</td>
                          <td>${IGCIM01261VO.eiorgname}</td>
					 	  <td>${IGCIM01261VO.entityData.eidesc}</td>
                          <td align="center">${IGCIM01261VO.entityData.eiusername}</td>
                          <td align="center">${IGCIM01261VO.entityData.eiinsdate}</td>
                          <td align="center">${IGCIM01261VO.entityData.eiupdtime}</td>
                        </tr>
                     </table>
                 
                </div>
                    
                                <div class="title">
                    <div class="name"><bean:message bundle="asmResources" key="label.IGASM0811.RelationshipInfo"/></div>
                </div>
                <div class="message"><ig:message /></div>
<logic:present name="IGCIM01261VO" property="flag">
<logic:equal value="true" name="IGCIM01261VO" property="flag">
	            <div id="results_list"> <logic:present
		name="IGCIM01261VO" property="parEntityItemRelationMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCIM01261VO"
				property="parEntityItemRelationMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="ENTITY_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCIM01261VO" property="parEntityItemRelationMap">
			<logic:iterate id="map" name="IGCIM01261VO"
				property="parEntityItemRelationMap" indexId="number">
				<bean:define id="category" name="map" property="key"/>
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="12%"><bean:message bundle="asmResources" key="label.IGASM0811.RelevanceUserNO"/></th>
						<th width="13%"><bean:message bundle="asmResources" key="label.IGASM0811.RelevanceUserName"/></th>
						<th width="12%"><bean:message bundle="asmResources" key="label.IGASM0811.RelevanceUserRelationship"/></th>
						<th width="14%"><bean:message bundle="asmResources" key="label.IGASM0811.RelationshipMarkDay"/></th>
						<th width="33%"><bean:message bundle="asmResources" key="label.IGASM0811.RelevanceUserRemark"/></th>
						<c:if test="${category=='001'}">
						<th width="8%"><bean:message bundle="asmResources" key="label.IGASM0811.FSRelation"/></th>
						</c:if>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<logic:equal name="bean" property="parflag" value="0">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<!-- 编号 -->
							<td>
							<div class="nowrapDiv">${bean.cldEntityItemVW.eilabel}
							</div>
							</td>
							<!-- 名称 -->
							<td>
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cldEntityItemVW.einame">&nbsp;</logic:empty> <html:link
								href="javascript:openSubIGCOM0303('${bean.cldEntityItemVW.eiid}',
                                                   '${bean.cldEntityItemVW.eiversion}');">
                                                   ${bean.cldEntityItemVW.einame}</html:link>
							</div>
							</td>
							<!-- 关系 -->
                            <td>
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
                                </div>
                            </td>
                            <!-- 登记时间 -->
                            <td>
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty>
                               	${bean.eirupdtime}                             
                                </div>
                            </td>
							<!-- 说明 -->
							<td>
							<div class="nowrapDiv"><logic:empty name="bean"
								property="eirdesc">&nbsp;</logic:empty> ${bean.eirdesc}</div>
							</td>
							<!-- FS关系 -->
							<c:if test="${category=='001'}">
							<td align="center">
							<div class="nowrapDiv">
							<html:link action="/IGASM0813_Disp.do?eiid=${bean.cldEntityItemVW.eiid}&pareiid=${IGCIM01261VO.entityData.eiid}&parversion=${IGCIM01261VO.entityData.eiversion}&parsmallversion=${IGCIM01261VO.entityData.eismallversion}&flag=1"><img src="images/record_(copy)_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0806.FSRelation.alt"/>' width="16" height="16"  border="0"/>
							</html:link>
							</div>
							</td>
							</c:if>
						</tr>
						</logic:equal>
						<logic:equal name="bean" property="parflag" value="1">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<!-- 编号 -->
							<td>
							<div class="nowrapDiv">${bean.parEntityItemVW.eilabel}
							</div>
							</td>
							<!-- 名称 -->
							<td>
							<div class="nowrapDiv"><logic:empty name="bean"
								property="parEntityItemVW.einame">&nbsp;</logic:empty> <html:link
								href="javascript:openSubIGCOM0303('${bean.parEntityItemVW.eiid}',
                                                   '${bean.parEntityItemVW.eiversion}');">
                                                   ${bean.parEntityItemVW.einame}</html:link>
							</div>
							</td>
							<!-- 关系 -->
                            <td>
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
                                </div>
                            </td>
                            <!-- 登记时间 -->
                            <td>
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty>
                               	${bean.eirupdtime}                             
                                </div>
                            </td>
							<!-- 说明 -->
							<td>
							<div class="nowrapDiv"><logic:empty name="bean"
								property="eirdesc">&nbsp;</logic:empty> ${bean.eirdesc}</div>
							</td>
							<!-- FS关系 -->
							<c:if test="${category=='001'}">
							<td align="center">
							<div class="nowrapDiv">
							<html:link action="/IGASM0813_Disp.do?eiid=${bean.cldEntityItemVW.eiid}&pareiid=${IGCIM01261VO.entityData.eiid}&parversion=${IGCIM01261VO.entityData.eiversion}&parsmallversion=${IGCIM01261VO.entityData.eismallversion}&flag=1"><img src="images/record_(copy)_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0806.FSRelation.alt"/>' width="16" height="16"  border="0"/>
							</html:link>
							</div>
							</td>
							</c:if>
						</tr>
						</logic:equal>
					</logic:iterate>
				</table>
				</div>
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
		<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
	</logic:present></div>
	</logic:equal>
</logic:present>
	            <div class="enter">
                     <html:submit property="btn_back" styleClass="button" onclick="toback()">
                     	<bean:message bundle="asmResources" key="button.IGASM0811.btn_toback"/>
                     </html:submit>
	            </div>
                <html:hidden property="pareid" styleId="pareid" value="${IGCIM01261VO.entityData.eid}"/>
                <html:hidden property="pareiid" styleId="pareiid" value="${IGCIM01261VO.entityData.eiid}"/>
                <html:hidden property="pareiname" styleId="pareiname" value="${IGCIM01261VO.entityData.einame}"/>
            </html:form>  
		 </div>
     </div>
</div>


</div>
</body>
</html:html>