<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1204" toScope="request"/>
<bean:define id="title" value="机柜配置信息编辑画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		function confirmDisp(){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="机柜配置信息" />';
            if( window.confirm(message1)){
                return true;
            } else {
                return false;
            }
		}
		
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM1204.do?org.apache.struts.taglib.html.CANCEL=1";
        	form.submit();
        }
	</script>
<body onload="$('eidesc').focus();">
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 机柜配置编辑 </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

		    <html:form styleId="form" action="/IGASM1204" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
                 <div class="title">
                     <div class="name">机柜基本信息</div>
                 </div>
                 <div id="results_list">
				    <table class="table_style">
						<tr>
                            <th width="8%">编号</th>
                            <th width="15%">名称</th>
                            <th width="32%">说明</th>
                            <th width="15%">状态</th>
                            <th width="15%">登记日</th>
                           
						</tr>
						<tr>
						  <td align="center">${IGASM12041VO.entityData.eilabel}</td>
						  <td align="center">${IGASM12041VO.entityData.einame}</td>
						  <td align="center">
						    <label>
	                                  <html:text property="eidesc" size="40" errorStyleClass="inputError" styleClass="input1"/>
						    </label>
						  </td>
						  <td align="center">
	                        <html:select property="eistatus" style="width: 120px;" errorStyleClass="inputError" tabindex="4">
	                            <ig:optionsCollection ccid="ENTITY_ITEM_STATUS_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                        </html:select>
						  </td>
                         <td align="center">
                           ${IGASM12041VO.entityData.eiinsdate}
                         </td>
						  
						</tr>
                     </table>
                    <table class="table_style">
                        <tr>
                            <th width="8%">模型编号</th>
                            <th width="32%">模型名称</th>
                            <th width="15%">类别</th>
                            <th width="15%">一级子类</th>
                            <th width="15%">二级子类</th>
                            <th width="15%">三级子类</th>
                        </tr>
                        <tr>
                          <td align="center">
                            ${IGASM12041VO.entityData.elabel}
                          </td>
                          <td align="center">
                            ${IGASM12041VO.entityData.ename}
                          </td>
                          <td align="center">
                            <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${IGASM12041VO.entityData.ecategory}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY1_CODE" cid="${IGASM12041VO.entityData.ekey1}" isChild="true"
                                pccid="ENTITY_CATEGORY_CODE" pcid="${IGASM12041VO.entityData.ecategory}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY2_CODE" cid="${IGASM12041VO.entityData.ekey2}" isChild="true"
                                pccid="ENTITY_EKEY1_CODE" pcid="${IGASM12041VO.entityData.ekey1}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY3_CODE" cid="${IGASM12041VO.entityData.ekey3}" isChild="true"
                                pccid="ENTITY_EKEY2_CODE" pcid="${IGASM12041VO.entityData.ekey2}" />
                          </td>
                        </tr>
                     </table>
                  </div>
                    
                  <div class="title">
                      <div class="name">机柜配置信息</div>
                  </div>
                    
                  <div id="results_list">
		                 <!--  message -->
		                 <ig:message/>
		                 <!--  /message -->     
	                   <table class="table_style">
	                        <!-- header部 -->

	                            <tr>
								    <th width="8%">编号</th>
								    <th width="12%">名称</th>
								    <th width="35%">内容</th>
								    <th width="25%">附件</th>
								    <th width="8%">版本号</th>
								    <th width="12%">更新时间</th>
	                            </tr>

	                        <!-- body部 -->

	                            <logic:present name="IGASM12041VO" property="configItemDataList" >
	                                <logic:iterate id="bean" name="IGASM12041VO" property="configItemDataList" indexId="index">
	                                    <tr class="<ig:rowcss index="${index}"/>">
	                                        <!-- 编号 -->
	                                        <td align="center">
	                                            <div class="nowrapDiv">
                                                    <logic:empty name="bean" property="clabel">&nbsp;</logic:empty>
	                                                ${bean.clabel}
	                                            </div>
	                                        </td>
	                                        <!-- 名称 -->
	                                        <td align="center">
	                                            <div class="nowrapDiv">
                                                    <logic:empty name="bean" property="cname">&nbsp;</logic:empty>
    	                                            ${bean.cname}
	                                            </div>
	                                        </td>
	                                        <!-- 内容 -->
	                                        <td align="center">
	                                            <div class="nowrapDiv">
                                                <logic:equal name="bean" property="cattach" value="1">
                                                <html:file property="attachFile[${index}]" styleId="attachFile[${index}]" size="30" errorStyleClass="inputError imeDisabled" onkeydown="return false;" styleClass="imeDisabled"/>
                                                <html:hidden property="civalue[${index}]" styleId="civalue"/>
                                                </logic:equal>
                                                <logic:notEqual name="bean" property="cattach" value="1">
                                                <html:text property="civalue[${index}]" styleId="civalue" size="40" errorStyleClass="inputError" styleClass="input1"/>                                         
                                                </logic:notEqual>
	                                            </div>
	                                        </td>
	                                        <!-- 附件 -->
	                                        <td align="center">
	                                            <div class="nowrapDiv">
                                                <logic:equal name="bean" property="cattach" value="1">
                                                <a href = "javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
                                                ${bean.civalue}
                                                </a>
                                                </logic:equal>
	                                            </div>
	                                        </td>
	                                        <!-- 版本号 -->
	                                        <td align="center">
	                                            <div class="nowrapDiv">
	                                            <logic:empty name="bean" property="civersion">&nbsp;</logic:empty>
	                                            ${bean.civersion}
	                                            </div>
	                                        </td>
	                                        <!-- 更新时间 -->
	                                        <td align="center">
	                                            <div class="nowrapDiv">
	                                            <logic:empty name="bean" property="ciupdtime">&nbsp;</logic:empty>
	                                            ${bean.ciupdtime}
	                                            </div>
	                                        </td>
	                                    </tr>
                                        <html:hidden property="ciid" styleId="ciid" value="${bean.ciid}"/>
                                        <html:hidden property="cid" styleId="cid" value="${bean.cid}"/>
                                        <html:hidden property="clabel" styleId="clabel" value="${bean.clabel}"/>
                                        <html:hidden property="ciattach" styleId="ciattach" value="${bean.cattach}"/>
	                                </logic:iterate>
	                            </logic:present>
	                   </table>
	              </div>
                  <div class="enter">
	                <html:submit property="btn_insert" value="保存" styleClass="button"  onclick="return confirmDisp();"  />
	                <html:cancel styleClass="button" value="返回"/>
	              </div>
		          <html:hidden property="eiid" styleId="eiid" value="${IGASM1204Form.eiid}"/>
	              <html:hidden property="eiversion" styleId="eiversion" value="${IGASM12041VO.entityData.eiversion}"/>
	              <html:hidden property="eid" styleId="eid" value="${IGASM12041VO.entityData.eid}"/>
		    </html:form>
		</div>
    </div>
</div>


</div>
</body>
</html:html>