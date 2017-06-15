<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0906" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="comResources" key="ietitle.IGCOM0302"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGCIM0906';


        function setParentValue(eirootmark, einame){
            if(!window.opener.closed){
		    	window.opener.setParamIGCIM0906(eirootmark, einame);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGCIM0906("", "");
            }
            window.close();
        }
        function setEntity(url){

        	//if(document.forms[0].esyscodingbegin.value.trim()!=""){
        		//url+=document.forms[0].esyscodingbegin.value;
            //}else{
        		//url+="999";
           // }
        	if(document.forms[0].ecategory.value.trim()!="" && document.forms[0].ecategory.value.trim()!="SDL" ){
        		url+=document.forms[0].ecategory.value;
            	}
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].esyscoding.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					alert('<bean:message bundle="comResources" key="message.IGCOM0302.001"/>');
					return false;
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}

	</script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="container">
        <html:form styleId="form" action="/IGCIM0906" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1"><bean:message bundle="comResources" key="navigation.IGCOM0302.asmsearch"/></p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<label><bean:message bundle="comResources" key="label.IGCOM0302.model"/></label><html:text name="IGCIM0906Form" property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<logic:equal value="false" name="IGCIM0906Form" property="flag">
					<img src="images/tree.gif" style="cursor: hand;" alt="<bean:message bundle="comResources" key="img.IGCOM0302.model.alt"/>" width="16" height="16" border="0" 
							onclick="setEntity('IGSYM0304_ASSET.do?roletype=IGCI01&subtype=999001');"/>
					</logic:equal>
					<html:hidden name="IGCIM0906Form" property="flag" styleId="flag"/>
					<html:hidden name="IGCIM0906Form" property="esyscodingbegin" styleId="esyscodingbegin"/>
					<html:hidden name="IGCIM0906Form" property="esyscoding" styleId="esyscoding"/>&nbsp;&nbsp;
	                <label><bean:message bundle="comResources" key="label.IGCOM0302.assetname"/></label><html:text name="IGCIM0906Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/> 
	             	<html:submit property="btn_search"  styleClass="button"><bean:message bundle="comResources" key="button.IGCOM0302.search"/></html:submit>
	             </div>
			</div>
		</div>
		<div id="results_list">
               <!--  message -->
               <ig:message/>
               <!--  /message -->     
	       <table width="100%" class="table_style">
	            <!-- header部 -->
	         
	                <tr>
                        <th width="5%"><bean:message bundle="comResources" key="title.IGCOM0302.select"/></th> 
                        <th width="15%"><bean:message bundle="comResources" key="title.IGCOM0302.modelname"/></th>
                        <th width="25%"><bean:message bundle="comResources" key="title.IGCOM0302.assetserial"/></th>
                        <th width="25%"><bean:message bundle="comResources" key="title.IGCOM0302.assetname"/></th>
                        <th width="23%"><bean:message bundle="comResources" key="title.IGCOM0302.assetdes"/></th>
                        <th width="7%"><bean:message bundle="comResources" key="title.IGCOM0302.manager"/></th>
                        <!--<th width="7%"><bean:message bundle="comResources" key="title.IGCOM0302.detail"/></th>
					    <th width="7%"><bean:message bundle="comResources" key="title.IGCOM0302.relationinfo"/></th>
					     <th width="7%"><bean:message bundle="comResources" key="title.IGCOM0302.version"/></th> -->
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGCOM03271VO" property="entityDataList" >
	                    <logic:iterate id="bean" name="IGCOM03271VO" property="entityDataList" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             
                                              <img src="images/select_asset.gif" border="0" alt="<bean:message bundle="comResources" key="img.IGCOM0302.select.alt"/>" onclick="javaScript:setParentValue(
                                                  '${bean.eirootmark}',
                                                  '${bean.einame}'     
                                              );"/>
                                              
                                          </div>
                                      </td>
                                      <!-- 名称 -->
                                      <td>
                                          <div class="nowrapDiv">
                                          <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
                                          ${bean.ename}
                                          </div>
                                      </td>
	                            <!-- 编号 -->
	                            <td>
	                                <div class="nowrapDiv">
                                              ${bean.eilabel}
	                                </div>
	                            </td>
	                            <!-- 名称 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
	                                ${bean.einame}
	                                </div>
	                            </td>
	                            <!-- 说明 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
	                                ${bean.eidesc}
	                                </div>
	                            </td>
	                            <!-- 管理人 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
	                                ${bean.eiusername}
	                                </div>
	                            </td>
	                           <!-- 详细信息 
	                            <td>
	                                <div align="center">
                                         <html:link action="/IGCIM0104_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="<bean:message bundle="comResources" key="img.IGCOM0302.showdetail.alt"/>" width="16" height="16"  border="0"/></html:link>
	                                </div>
	                            </td>
	                            -->
	                            <!-- 关系信息 
	                            <td>
	                                <div class="nowrapDiv">
                                         <html:link action="/IGCIM0106_Disp.do?eiid=${bean.eiid}"><img src="images/record_(copy)_16x16.gif" alt="<bean:message bundle="comResources" key="img.IGCOM0302.relationmanage.alt"/>" width="16" height="16"  border="0"/></html:link>
	                                </div>
	                            </td>
	                            -->
	                            <!-- 历史版本 -->
	                            <!--  
	                            <td>
	                                <div class="nowrapDiv">
                                         <html:link action="/IGASM0328_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="<bean:message bundle="comResources" key="img.IGCOM0302.version.alt"/>" width="16" height="16"  border="0"/></html:link>
	                                </div>
	                            </td>
	                            -->
	                        </tr>
	                    </logic:iterate>
	                </logic:present>
	         
	       </table>
		</div>
	    <div id="operate">
	                <!-- paging -->
	                <jsp:include page="/include/paging.jsp"/>
	                <!-- /paging -->
                <div class="enter">
                	<input type="button" name="btn_clear" value="<bean:message bundle="comResources" key="button.IGCOM0302.clear"/>" onclick="clearParentValue()" class="button">
                    <input type="button" name="btn_close" value="<bean:message bundle="comResources" key="button.IGCOM0302.close"/>" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGCIM0906Form" property="ecategory" styleId="ecategory"/>
	    <html:hidden name="IGCIM0906Form" property="pidid" styleId="pidid"/>
    </html:form>
</div>


</div>
</body>
</html:html>