<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0329" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="comResources" key="ietitle.IGCOM0302"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGCOM0329';


        function setParentValue(eid, elabel, ename, eiid, eilabel, einame,ecategory){
            if(!window.opener.closed){
	        	if(document.forms[0].pidid.value=="" || document.forms[0].pidid.value==null){
		                window.opener.setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame ,ecategory);
	            }else{
	 	                window.opener.setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame , ecategory, document.forms[0].pidid.value);
	 		 	}
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGCOM0327("", "", "", "", "", "" ,"");
            }
            window.close();
        }
        function setEntity(url){

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

        function confirmDisp(){
	    	if($F('esyscoding').trim()==""){
	    		alert("请选择所属模型！");
	    		return false;
	    	}
	    	return true;
		}

	</script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="container">
        <html:form styleId="form" action="/IGCOM0329" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1"><bean:message bundle="comResources" key="navigation.IGCOM0302.asmsearch"/></p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<label><span class="red">*</span><bean:message bundle="comResources" key="label.IGCOM0302.model"/></label>
                	<html:select name="IGCOM0329Form" styleId="esyscoding" property="esyscoding" style="width: 130px;" errorStyleClass="inputError">
	 				<html:options collection="ADEsyscodingList" property="value" name="" labelProperty="label"/>
	 				</html:select>
	 				<html:hidden property="eirrelation" value="${IGCOM0329Form.eirrelation}"/>
	                <label><bean:message bundle="comResources" key="label.IGCOM0302.assetname"/></label>
	                <html:text name="IGCOM0329Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/> 
	             	<html:submit property="btn_search"  styleClass="button" onclick="return confirmDisp();"><bean:message bundle="comResources" key="button.IGCOM0302.search"/></html:submit>
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
	       
	                <logic:present name="IGCOM03291VO" property="soc0118List" >
	                    <logic:iterate id="bean" name="IGCOM03291VO" property="soc0118List" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             
                                              <img src="images/select_asset.gif" border="0" alt="<bean:message bundle="comResources" key="img.IGCOM0302.select.alt"/>" onclick="javaScript:setParentValue(
                                                  '${bean.eid}',
                                                  '${bean.soc0117TB.elabel}',
                                                  '${bean.soc0117TB.ename}',         
                                                  '${bean.eiid}',
                                                  '${bean.eilabel}',
                                                  '${bean.einame}',
                                                  '${bean.soc0117TB.ecategory}'         
                                              );"/>
                                              
                                          </div>
                                      </td>
                                      <!-- 名称 -->
                                      <td>
                                          <div class="nowrapDiv">
                                          ${bean.soc0117TB.ename}
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
	    <html:hidden name="IGCOM0329Form" property="ecategory" styleId="ecategory"/>
	    <html:hidden name="IGCOM0329Form" property="pidid" styleId="pidid"/>
    </html:form>
</div>


</div>
</body>
</html:html>