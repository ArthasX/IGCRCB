<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0301" toScope="request"/>
<bean:define id="title" value="资产模型查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	    var gid='IGCOM0301';
		//画面再表示
		function redisplay1(){
			$("ekey1").value = "";
			$("ekey2").value = "";
			form.action = getAppRootUrl() + "/IGCOM0301_ReDisp.do";
			form.submit();
		}
		function redisplay2(){
			$("ekey2").value = "";
			form.action = getAppRootUrl() + "/IGCOM0301_ReDisp.do";
			form.submit();
		}
        function setParentValue(eid, elabel, ename){
            if(!window.opener.closed){
                window.opener.setParamIGCOM0301(eid, elabel,ename);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGCOM0301("", "","");
            }
            window.close();
        }
	</script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="container">
<html:form styleId="form" action="/IGCOM0301" onsubmit="return checkSubmit(this);">
    <div id="location">
        <div class="image"></div>
            <p class="fonts1">资产模型查询</p>
    </div>
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
	                <label>编号：</label><html:text property="elabel" styleId="elabel"  errorStyleClass="inputError imeDisabled" size="6"/> &nbsp;&nbsp;&nbsp;&nbsp;
	                <label>名称：</label><html:text property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10"/> 
	                <label>类别：</label><logic:equal name="IGCOM0301Form" property="enable" value="0">
	                       <html:select property="ecategory" style="width: 100px;" errorStyleClass="inputError" onchange="javascript:redisplay1();">
	                           <ig:optionsCollection ccid="ENTITY_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                       </html:select>
	                   </logic:equal>
                       <logic:equal name="IGCOM0301Form" property="enable" value="1">
                           <html:select property="ecategory" style="width: 100px;" errorStyleClass="inputError" onchange="javascript:redisplay1();" disabled="true">
                               <ig:optionsCollection ccid="ENTITY_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
                           </html:select>
                       </logic:equal>
                </div>
             
                <div>   
					<label>一级子类：</label>
					<html:select property="ekey1" style="width: 100px;" errorStyleClass="inputError" onchange="javascript:redisplay2();">
					    <ig:optionsCollection ccid="ENTITY_EKEY1_CODE" isChild="true" pccid="ENTITY_CATEGORY_CODE"  pcid="${IGCOM0301Form.ecategory}" isMakeBlankRow="true" isCodeLabel="true"/>
					</html:select>
					 <label>二级子类：</label>
					<html:select property="ekey2" style="width: 100px;" errorStyleClass="inputError" onchange="javascript:redisplay3();">
					 <ig:optionsCollection ccid="ENTITY_EKEY2_CODE" isChild="true" pccid="ENTITY_EKEY1_CODE" pcid="${IGCOM0301Form.ekey1}" isMakeBlankRow="true" isCodeLabel="true"/>
					</html:select>
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
                        <th width="8%" >编号</th>
                        <th width="15%">名称</th>
                        <th width="20%">说明</th>
                        <th width="12%" ></th>
                        <th width="15%">类别</th>
                        <th width="10%">一级子类</th>
                        <th width="10%">二级子类</th>
                        <th width="10%">三级子类</th>
                    </tr>
                <!-- body部 -->
		      
		           <logic:present name="IGCOM03011VO" property="entityDataList" >
		               <logic:iterate id="bean" name="IGCOM03011VO" property="entityDataList" indexId="index">
		                   <tr class="<ig:rowcss index="${index}"/>">
		                       <!-- 编号 -->
		                       <td>
		                           <div class="nowrapDiv">
		                               <a href="javaScript:setParentValue(
		                                   '${bean.eid}',
		                                   '${bean.elabel}',
		                                   '${bean.ename}'			
		                               )">
		                                        ${bean.elabel}
		                                        </a>
		                           </div>
		                       </td>
		                       <!-- 名称 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
		                           ${bean.ename}
		                           </div>
		                       </td>
		                       <!-- 说明 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="edesc">&nbsp;</logic:empty>
		                           ${bean.edesc}
		                           </div>
		                       </td>
		                       <!-- 状态 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="estatus">&nbsp;</logic:empty>
		                           <ig:codeValue ccid="ENTITY_STATUS_CODE" cid="${bean.estatus}"/>                                 
		                           </div>
		                       </td>
		                       <!-- 类别 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="ecategory">&nbsp;</logic:empty>
		                           <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${bean.ecategory}"/>                                 
		                           </div>
		                       </td>
		                       <!-- 一级子类 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="ekey1">&nbsp;</logic:empty>
		                           <ig:codeValue ccid="ENTITY_EKEY1_CODE" cid="${bean.ekey1}" isChild="true" 
		                           pccid="ENTITY_CATEGORY_CODE" pcid="${bean.ecategory}"/>                                
		                           </div>
		                       </td>
		                       <!-- 二级子类 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="ekey2">&nbsp;</logic:empty>
		                           <ig:codeValue ccid="ENTITY_EKEY2_CODE" cid="${bean.ekey2}" isChild="true"
		                            pccid="ENTITY_EKEY1_CODE" pcid="${bean.ekey1}"/>                                 
		                           </div>
		                       </td>
		                       <!-- 三级子类 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           <logic:empty name="bean" property="ekey3">&nbsp;</logic:empty>
		                           <ig:codeValue ccid="ENTITY_EKEY3_CODE" cid="${bean.ekey3}" isChild="true"
		                            pccid="ENTITY_EKEY2_CODE" pcid="${bean.ekey2}"/>                                 
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
        <html:hidden property="enable" styleId="enable" value="${IGCOM0301Form.enable}"/>
    </html:form>
</div>
</div>
</body>
</html:html>