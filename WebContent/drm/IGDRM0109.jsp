<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM0109" toScope="request"/>
<bean:define id="title" value="资产查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGCOM0302';


        function setParentValue(eid, elabel, ename, eiid, eilabel, einame, ecategory, eiversion){
        	if(!window.opener.closed){
                if(document.forms[0].pidid.value=="" || document.forms[0].pidid.value==null){
                	window.opener.setParamIGDRM0109(eid, elabel, ename, eiid, eilabel, einame ,ecategory);
	            }else{
	            	window.opener.setParamIGDRM0109(eid, elabel, ename, eiid, eilabel, einame , ecategory, document.forms[0].pidid.value,eiversion);	 			
	            }
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGDRM0109("", "", "", "", "", "" ,"");
            }
            window.close();
        }
        function setEntity(url){

        	if(document.forms[0].esyscodingbegin.value.trim()!=""){
        		url+=document.forms[0].esyscodingbegin.value;
            }else{
        		url+="999&type=0";
            }
        	if(document.forms[0].ecategory.value.trim()!="" && document.forms[0].ecategory.value.trim()!="SDL" ){
        		url+=document.forms[0].ecategory.value;
            	}

        	if(document.forms[0].estatus.value.trim()!="" ){
        		url+="&estatus="+document.forms[0].estatus.value;
            	}
        	if(document.forms[0].emodeltype_eq.value.trim()!="" ){
        		url+="&emodeltype_eq="+document.forms[0].emodeltype_eq.value;
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
					alert("资产模型不可用！请选择其他模型！");
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
        <html:form styleId="form" action="/IGDRM0109" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1">资产查询</p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<label>所属模型：</label><html:text name="IGCOM0302Form" property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<%if(request.getParameter("compt")!=null){ %>
					<img src="images/tree.gif" style="cursor: hand;" alt="所属模型" width="16" height="16" border="0" 
							onclick="setEntity('IGCIM1203_ENTITY_TREE.do?levelnode=999001&del=');"/>
					<%}else{ %>
					<img src="images/tree.gif" style="cursor: hand;" alt="所属模型" width="16" height="16" border="0" 
							onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=');"/>
					<%} %>
					<html:hidden name="IGCOM0302Form" property="esyscodingbegin" styleId="esyscodingbegin"/>
					<html:hidden name="IGCOM0302Form" property="esyscoding" styleId="esyscoding"/>&nbsp;&nbsp;
					<html:hidden name="IGCOM0302Form" property="estatus" styleId="estatus"/>

	                <label>资产名称：</label><html:text name="IGCOM0302Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/> 
	             	<html:submit property="btn_search" value="查询" styleClass="button"/>
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

                        <th width="5%">选择</th> 
                        <th width="15%">模型名称</th>
                        <th width="10%">资产编号</th>
                        <th width="20%">资产名称</th>
                        <th width="23%">资产说明</th>
                        <th width="7%">管理人</th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGCOM03271VO" property="entityDataList" >
	                    <logic:iterate id="bean" name="IGCOM03271VO" property="entityDataList" indexId="index">
	                        <tr  >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             
                                              <img src="images/select_asset.gif" border="0" alt="选择" onclick="javaScript:setParentValue(
                                                  '${bean.eid}',
                                                  '${bean.elabel}',
                                                  '${bean.ename}',         
                                                  '${bean.eiid}',
                                                  '${bean.eilabel}',
                                                  '${bean.einame}',
                                                  '${bean.ecategory}',
                                                  ${bean.eiversion }       
                                              );" style="cursor:hand"/>
                                              
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
                	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGCOM0302Form" property="ecategory" styleId="ecategory"/>
	    <html:hidden name="IGCOM0302Form" property="pidid" styleId="pidid" />
	    <html:hidden name="IGCOM0302Form" property="emodeltype_eq" styleId="emodeltype_eq"/>
	   
    </html:form>
</div>


</div>
</body>
</html:html>