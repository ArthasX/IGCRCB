<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0306" toScope="request"/>
<bean:define id="title" value="资产查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGCOM0327';

		function setMuchParentValue(){
			var selectCount = 0;
			var eid = "";
            var elabel = "";
            var ename = "";
            var eiid = "";
            var eilabel = "";
            var einame = "";
            var ecategory = "";
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=confirmEntityItem',
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
						var entityItemArray = result.split("###");
						if(entityItemArray != null && entityItemArray.length > 0) {
				            for(var i = 0; i < entityItemArray.length;) {
								eid += entityItemArray[i++]+"<br />";
			                    eiid += entityItemArray[i++]+"<br />";
			                    einame += entityItemArray[i++]+"<br />";
			                    ecategory += entityItemArray[i++]+"<br />";
			                    eilabel += entityItemArray[i++]+"<br />";
			                    selectCount += 1;
					         }
				            if(selectCount == 0){
								alert("请选择资产");
							}else{
				            	setParentValue(eid, elabel, ename, eiid, eilabel, einame, ecategory);
							}
						} else {
							alert("没有选中资产！");

						}
					} else {
						alert("没有选中资产！");
					}
			     }
				});
		}
        function setParentValue(eid, elabel, ename, eiid, eilabel, einame, ecategory){
            if(!window.opener.closed){
                window.opener.setMuchParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame ,ecategory);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setMuchParamIGCOM0302("", "", "", "", "", "" ,"");
            }
            window.close();
        }
        function setEntity(url){

        	if(document.forms[0].esyscodingbegin.value.trim()!=""){
        		url+=document.forms[0].esyscodingbegin.value;
            }else{
        		url+="0306&type=0";
            }
        	if(document.forms[0].ecategory.value.trim()!="" && document.forms[0].ecategory.value.trim()!="SDL" ){
        		//url+=document.forms[0].ecategory.value;
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
					alert("资产类型不可用！请选择其他类型！");
					return false;
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}
        function selectEntityItem(obj){
            var type = "del";
            if(obj.checked) {
            	type = "add";
            }
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=selectEntityItem&eiid=' + obj.value + '&clicktype=' + type,
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
					} else {
					}
			     }
				});
		}
	</script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="container">
        <html:form styleId="form" action="/IGCOM0327_SUBMIT" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1">资产查询</p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<label>所属类型：</label><html:text name="IGCOM0327Form" property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/tree.gif" style="cursor: hand;" alt="所属类型" width="16" height="16" border="0" 
							onclick="setEntity('IGSYM1201_ENTITY_TREE.do?socflag=yes&levelnode=');"/>
					<html:hidden name="IGCOM0327Form" property="esyscodingbegin" styleId="esyscodingbegin"/>
					<html:hidden name="IGCOM0327Form" property="esyscoding" styleId="esyscoding"/>&nbsp;&nbsp;
	                <label>资产名称：</label><html:text name="IGCOM0327Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/> 
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
                        <th width="15%">类型名称</th>
                        <th width="10%">资产编号</th>
                        <th width="20%">资产名称</th>
                        <th width="23%">资产说明</th>
                        <th width="7%">管理人</th>
                        <th width="7%">详细信息</th>
					    <th width="7%">关系信息</th>
					    <th width="7%">历史版本</th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGCOM03271VO" property="entityDataList" >
	                    <logic:iterate id="bean" name="IGCOM03271VO" property="entityDataList" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             <html:multibox  property="selectId" value="${bean.eiid}" onclick="selectEntityItem(this)"/>
                                             <input type="hidden" name="eids" value="${bean.eid}" />
                                             <input type="hidden" name="elabels" value="${bean.elabel}" />
                                             <input type="hidden" name="enames" value="${bean.ename}" />
                                             <input type="hidden" name="eiids" value="${bean.eiid}" />
                                             <input type="hidden" name="eilabels" value="${bean.eilabel}" />
                                             <input type="hidden" name="einames" value="${bean.einame}" />
                                             <input type="hidden" name="ecategorys" value="${bean.ecategory}" />
                                             <!-- 
                                              <img src="images/select_asset.gif" border="0" alt="选择" onclick="javaScript:setParentValue(
                                                  '${bean.eid}',
                                                  '${bean.elabel}',
                                                  '${bean.ename}',         
                                                  '${bean.eiid}',
                                                  '${bean.eilabel}',
                                                  '${bean.einame}',
                                                  '${bean.ecategory}'         
                                              );"/>
                                               -->
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
	                            <td><div align="center"><html:link action="/IGASM0332_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link></div></td>
	                            <!-- 关系信息 -->
	                            <td><div class="nowrapDiv"><html:link action="/IGASM0333_Disp.do?eiid=${bean.eiid}"><img src="images/record_(copy)_16x16.gif" alt="关系管理" width="16" height="16"  border="0"/></html:link></div></td>
	                            <!-- 历史版本 -->
	                            <td><div class="nowrapDiv"><html:link action="/IGASM0334_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></html:link></div></td>
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
                	<input type="button" name="btn_clear" value="确认" onclick="setMuchParentValue()" class="button">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGCOM0327Form" property="ecategory" styleId="ecategory"/>
    </html:form>
</div>


</div>
</body>
</html:html>