<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGMNT0106" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="mntResources" key="ietitle.IGMNT0106"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGMNT0106';


        function setParentValue(eid, elabel, ename, eiid, eilabel, einame,ecategory){
            if(!window.opener.closed){
	        	if(document.forms[0].pidid.value=="" || document.forms[0].pidid.value==null){
		                window.opener.setParamIGMNT0106(eid, elabel, ename, eiid, eilabel, einame ,ecategory);
	            }else{
	 	                window.opener.setParamIGMNT0106(eid, elabel, ename, eiid, eilabel, einame , ecategory, document.forms[0].pidid.value);
	 		 	}
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGMNT0106("", "", "", "", "", "" ,"");
            }
            window.close();
        }
        
        function setEntity(url){

   		 var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
   		 var alterModel= '<bean:message bundle="asmResources" key="message.IGASM0320.002"/>';
   			 if("_resetall"==temp){
   				 document.forms[0].ename.value = "";
   	//			 document.forms[0].eid.value = "";
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
   					alert(alterModel);
   					return false;
   					
   				}else if(syscode_eid.split("_").length>1){
   					eid = syscode_eid.split("_")[0];
   					syscode = syscode_eid.split("_")[1];
   				}
   				document.forms[0].ename.value = name;
   			//	document.forms[0].eid.value = eid;
   				document.forms[0].esyscoding.value = syscode;
   			}			
   		}
	</script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent" style="background-color: #FFFFFF; background-image: none;">
<div id="container">
        <html:form styleId="form" action="/IGMNT0106" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1"><bean:message bundle="mntResources" key="navigation.IGMNT0106.asmsearch"/></p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<label><bean:message bundle="mntResources" key="label.IGMNT0106.model"/></label>
                	<html:select name="IGMNT0106Form" styleId="impcitype" property="esyscoding" style="width: 130px;" errorStyleClass="inputError">
						<html:options collection="esyscodingList" property="value" name="" labelProperty="label" />
					</html:select>
                	<!-- 
                	<html:text name="IGMNT0106Form" property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/tree.gif" style="cursor: hand;" alt="<bean:message bundle="mntResources" key="img.IGMNT0106.model.alt"/>" width="16" height="16" border="0" 
							onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999001');"/>
					 -->
					<html:hidden name="IGMNT0106Form" property="esyscodingbegin" styleId="esyscodingbegin"/>
					<html:hidden name="IGMNT0106Form" property="esyscoding" styleId="esyscoding"/>&nbsp;&nbsp;
	                <label><bean:message bundle="mntResources" key="label.IGMNT0106.assetname"/></label><html:text name="IGMNT0106Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/> 
	             	<html:submit property="btn_search"  styleClass="button"><bean:message bundle="mntResources" key="button.IGMNT0106.search"/></html:submit>
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
                        <th width="5%"><bean:message bundle="mntResources" key="title.IGMNT0106.select"/></th> 
                        <th width="15%"><bean:message bundle="mntResources" key="title.IGMNT0106.modelname"/></th>
                        <th width="10%"><bean:message bundle="mntResources" key="title.IGMNT0106.assetserial"/></th>
                        <th width="20%"><bean:message bundle="mntResources" key="title.IGMNT0106.assetname"/></th>
                        <th width="23%"><bean:message bundle="mntResources" key="title.IGMNT0106.assetdes"/></th>
                        <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0106.manager"/></th>
                        <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0106.detail"/></th>
					    <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0106.relationinfo"/></th>
					    <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0106.version"/></th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGMNT01061VO" property="entityDataList" >
	                    <logic:iterate id="bean" name="IGMNT01061VO" property="entityDataList" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             
                                              <img src="images/select_asset.gif" border="0" alt="<bean:message bundle="mntResources" key="img.IGMNT0106.select.alt"/>" onclick="javaScript:setParentValue(
                                                  '${bean.eid}',
                                                  '${bean.elabel}',
                                                  '${bean.ename}',         
                                                  '${bean.eiid}',
                                                  '${bean.eilabel}',
                                                  '${bean.einame}',
                                                  '${bean.ecategory}'         
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
	                           <!-- 详细信息 -->
	                            <td>
	                                <div align="center">
                                         <html:link action="/IGASM0326_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="<bean:message bundle="mntResources" key="img.IGMNT0106.showdetail.alt"/>" width="16" height="16"  border="0"/></html:link>
	                                </div>
	                            </td>
	                            <!-- 关系信息 -->
	                            <td>
	                                <div class="nowrapDiv">
                                         <html:link action="/IGASM0327_Disp.do?eiid=${bean.eiid}"><img src="images/record_(copy)_16x16.gif" alt="<bean:message bundle="mntResources" key="img.IGMNT0106.relationmanage.alt"/>" width="16" height="16"  border="0"/></html:link>
	                                </div>
	                            </td>
	                            
	                            <!-- 历史版本 -->
	                            <td>
	                                <div class="nowrapDiv">
                                         <html:link action="/IGASM0328_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="<bean:message bundle="mntResources" key="img.IGMNT0106.version.alt"/>" width="16" height="16"  border="0"/></html:link>
	                                </div>
	                            </td>
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
                	<input type="button" name="btn_clear" value="<bean:message bundle="mntResources" key="button.IGMNT0106.clear"/>" onclick="clearParentValue()" class="button">
                    <input type="button" name="btn_close" value="<bean:message bundle="mntResources" key="button.IGMNT0106.close"/>" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGMNT0106Form" property="ecategory" styleId="ecategory"/>
	    <html:hidden name="IGMNT0106Form" property="pidid" styleId="pidid"/>
    </html:form>
</div>


</div>
</body>
</html:html>