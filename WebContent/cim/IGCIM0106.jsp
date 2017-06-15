<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0106" toScope="request" />
<bean:define id="title"   toScope="request" >
	<bean:message bundle="asmResources" key="ietitle.IGCIM0106"/>
</bean:define>

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    var gid='IGCIM0106';
	    function deleteRec(){
	    	var arg0= '<bean:message bundle="asmResources" key="message.IGCIM0106.001"/>';
	    	var alterMessage= '<bean:message bundle="asmResources" key="message.IGCIM0106.002"/>';
	        var message ='<bean:message key="IGCO10000.E002"/>';
	        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
	        var frm = window.document.forms[0];
	        if(frm.deleteEirid){
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
	        }else{
		        alert(alterMessage);
		              return false;
		    }
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGCIM0106_Del.do";
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    function toback(){
	        form.action = getAppRootUrl() + "/IGCIM0106.do?btn_back=1";
	        form.submit();
	    }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">
	<ig:navigation extname1="${urlable}"/> &gt;&gt; 关系管理
	</p>
	<div class="back">
		<html:link href="javascript:toback();">
			<bean:message bundle="asmResources" key="button.IGCIM0106.btn_toback"/>
		</html:link>
	</div>
</div>
<html:form styleId="form" action="/IGCIM0106"
	onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceInfo"/></div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="8%"><bean:message bundle="asmResources" key="label.IGCIM0106.ModelName"/></th>
			<th width="12%"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceNO"/></th>
			<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceName"/></th>
			<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceOrgan"/></th>
			<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceRemark"/></th>
			<!--<th width="8%">设备状态</th>-->
			<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceManager"/></th>
			<th width="13%"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceMarkDay"/></th>
			<th width="12%"><bean:message bundle="asmResources" key="label.IGCIM0106.UpdateTime"/></th>
		</tr>
		<tr>
			<td align="center">${IGCIM01061VO.entityData.ename}</td>
			<td align="center">${IGCIM01061VO.entityData.eilabel}</td>
			<td align="center">${IGCIM01061VO.entityData.einame}</td>
			<td align="center">${IGCIM01061VO.eiorgname}</td>
			<td align="center">${IGCIM01061VO.entityData.eidesc}</td>
			<!--<td><ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${IGCIM01061VO.entityData.eistatus}"/></td>-->
			<td align="center">${IGCIM01061VO.entityData.eiusername}</td>
			<td align="center">${IGCIM01061VO.entityData.eiinsdate}</td>
			<td align="center">${IGCIM01061VO.entityData.eiupdtime}</td>
		</tr>
	</table>
	
	</div>

	<div class="title">
	<logic:present name="IGCIM01061VO" property="parEntityItemRelationMap">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0106.DeviceRelationshipInfo"/></div>
	</logic:present>
	<logic:present name="IGCIM01061VO" property="eiBelongRelationList">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0106.EiBelongRelationshipInfo"/></div>
	</logic:present>
	</div>
	<div class="message"><ig:message /></div>
	
	<logic:present name="IGCIM01061VO" property="flag">
	 <logic:present name="IGCIM01061VO" property="eiBelongRelationList" >
	 <div id="results_list">
	<table class="table_style">
	  <tr>
	    <th width="8%" align="left"></th> 
         <th width="16%" ><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceNO"/></th>
		<th width="16%" ><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceName"/></th>
		<th width="14%" ><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceAssetRelationship"/></th>
		<th width="15%" ><bean:message bundle="asmResources" key="label.IGCIM0106.RelationType"/></th>
		<th width="15%" ><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceMarkDay"/></th>
		<th width="16%" ><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceAssetRamark"/></th>							
	  </tr>
	  <logic:iterate id="bean" name="IGCIM01061VO" property="eiBelongRelationList" indexId="index">
      <tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
          <td align="left">		 	
              <html:checkbox property="deleteEirid" value="${bean.brid}"/>
         </td>
         <td >
		      ${bean.cldEntityItemVW.eilabel }
		 </td>
		 <td>
		      <html:link href="javascript:openSubIGCOM0328('${bean.cldEntityItemVW.eiid}','${bean.cldEntityItemVW.eiversion}');">
                          ${bean.cldEntityItemVW.einame}
              </html:link>
		 </td>
		  <td >
                
                 <logic:empty name="bean" property="brtype">&nbsp;</logic:empty>
                <ig:codeValue ccid="BELONG_RELATION_TYPE" cid="${bean.brtype}"/>                                 
                 
          </td>
          <td ><logic:empty name="bean" property="brassetrelation">&nbsp;</logic:empty>
                <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.brassetrelation}"/>                                               
          </td>
		 <td>
		      ${bean.brcreatetime }
		 </td>
		 <td>
		      ${bean.brdes }
		 </td>
	   </tr> 
	   </logic:iterate>
	</table>
	
	</div>
	 </logic:present>
	</logic:present>
	
	
	
<logic:present name="IGCIM01061VO" property="flag">
<logic:equal value="true" name="IGCIM01061VO" property="flag">  
<logic:present
		name="IGCIM01061VO" property="parEntityItemRelationMap">
	<div id="results_list">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCIM01061VO"
				property="parEntityItemRelationMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="ENTITY_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCIM01061VO" property="parEntityItemRelationMap">
			<logic:iterate id="map" name="IGCIM01061VO"
				property="parEntityItemRelationMap" indexId="number">
				<bean:define id="category" name="map" property="key"/>
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
					 
					    <th width="8%"  align="left"></th>
				        <th width="15%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceNO"/></th>
						<th width="20%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceName"/></th>
						<th width="15%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceAssetRelationship"/></th>
						<th width="15%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceMarkDay"/></th>
						<th width="35%" align="center"><bean:message bundle="asmResources" key="label.IGCIM0106.RelevanceAssetRamark"/></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<logic:equal name="bean" property="parflag" value="0">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
						
						 	<td align="left">
						 	<logic:notEqual name="bean" property="eirstatus" value="C">
						 	<logic:notEqual name="category" value="012">
                                <html:checkbox property="deleteEirid" value="${bean.eirid}"/>
                                </logic:notEqual>
                                </logic:notEqual>
                            </td>
							<!-- 编号 -->
							<td align="left">
							<div class="nowrapDiv">${bean.cldEntityItemVW.eilabel}
							</div>
							</td>
							<!-- 名称 -->
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cldEntityItemVW.einame">&nbsp;</logic:empty> 
								<html:link href="javascript:openSubIGCOM0328('${bean.cldEntityItemVW.eiid}',
                                                   '${bean.cldEntityItemVW.eiversion}');">
                                                   ${bean.cldEntityItemVW.einame}</html:link>
							</div>
							</td>
							<!-- 关系 -->
                            <td align="left">
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
                                </div>
                            </td>
                            <!-- 登记时间 -->
                            <td align="left">
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty>
                               	${bean.eirupdtime}                             
                                </div>
                            </td>
							<!-- 说明 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="eirdesc">&nbsp;</logic:empty> ${bean.eirdesc}</div>
							</td>
						</tr>
						</logic:equal>
						<logic:equal name="bean" property="parflag" value="1">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<td align="left">
							<logic:notEqual name="bean" property="eirstatus" value="C">
						 	<logic:notEqual name="category" value="012">
                                <html:checkbox property="deleteEirid" value="${bean.eirid}"/>
                                </logic:notEqual>
                                </logic:notEqual>
                            </td>
							<!-- 编号 -->
							<td align="left">
							<div class="nowrapDiv">${bean.parEntityItemVW.eilabel}
							</div>
							</td>
							<!-- 名称 -->
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="parEntityItemVW.einame">&nbsp;</logic:empty> 
								<html:link href="javascript:openSubIGCOM0328('${bean.parEntityItemVW.eiid}',
                                                   '${bean.parEntityItemVW.eiversion}');">
                                                   ${bean.parEntityItemVW.einame}</html:link>
							</div>
							</td>
							<!-- 关系 -->
                            <td align="left">
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
                                </div>
                            </td>
                            <!-- 登记时间 -->
                            <td align="left">
                                <div class="nowrapDiv">
                                <logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty>
                               	${bean.eirupdtime}                             
                                </div>
                            </td>
							<!-- 说明 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="eirdesc">&nbsp;</logic:empty> ${bean.eirdesc}</div>
							</td>
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
	</div></logic:present>
</logic:equal>
</logic:present>

	<div class="enter">
	<logic:present name="IGCIM01061VO" property="flag">
	<logic:equal value="true" name="IGCIM01061VO" property="flag">
	<html:submit property="btn_add" styleClass="button"   >
	             <bean:message bundle="asmResources" key="button.IGCIM0106.btn_add"/>     
	</html:submit>
	<logic:present name="IGCIM01061VO" property="parEntityItemRelationMap">
	        <html:submit property="btn_delete" styleClass="button"  onclick="return deleteRec();" >
			           <bean:message bundle="asmResources" key="button.IGCIM0106.btn_deleteSelect"/>  
			</html:submit>
	</logic:present> 
	<logic:present name="IGCIM01061VO" property="eiBelongRelationList">
	        <html:submit property="btn_delete" styleClass="button"  onclick="return deleteRec();" >
			           <bean:message bundle="asmResources" key="button.IGCIM0106.btn_deleteSelect"/>  
			</html:submit>
	</logic:present> 
	</logic:equal>
	</logic:present>
		<html:submit property="btn_back" styleClass="button" >
			<bean:message bundle="asmResources" key="button.IGCIM0106.btn_toback"/>  
		</html:submit>
	</div>
	<html:hidden property="pareid" styleId="pareid"
		value="${IGCIM01061VO.entityData.eid}" />
	<html:hidden property="pareiid" styleId="pareiid"
		value="${IGCIM01061VO.entityData.eiid}" />
	<html:hidden property="pareilabel" styleId="pareilabel"
		value="${IGCIM01061VO.entityData.eilabel}"/>
	<html:hidden property="pareiname" styleId="pareiname"
		value="${IGCIM01061VO.entityData.einame}" />
     <html:hidden property="relationType" styleId="relationType"
		value="${IGCIM0106Form.relationType}" />
	<html:hidden property="parversion" styleId="parversion"
	value="${IGCIM01061VO.entityData.eiversion}" />
	<html:hidden property="parsmallversion" styleId="parsmallversion"
	value="${IGCIM01061VO.entityData.eismallversion}" />
	<html:hidden property="eirootmark" styleId="eirootmark"
	value="${IGCIM01061VO.entityData.eirootmark}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>