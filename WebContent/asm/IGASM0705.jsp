<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0705" toScope="request"/>
<bean:define id="title" value="机房配置信息历史版本画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    function toback(){
        form.action = getAppRootUrl() + "/IGASM0705_Back.do?btn_back=1";
        form.submit();
    }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body >
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 历史版本</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

		     <div class="title">
		       <div class="name">历史版本信息</div>
		     </div>

             <!-- 历史版本显示 -->
             <div id="results_list">
	             <jsp:include page="/include/history.jsp">
	                  <jsp:param name="eiid" value="${IGASM0705Form.eiid}"/>
	                  <jsp:param name="eiversion" value="${IGASM07051VO.entityData.eiversion}"/>
	                  <jsp:param name="civersion" value="${IGASM0705Form.civersion}"/>
                      <jsp:param name="action" value="IGASM0705_Disp"/>
	             </jsp:include>
             </div>
             <!-- 历史版本显示 -->
    				     
             <div class="title">
                 <div class="name">机房基本信息</div>
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
                          <td align="center">${IGASM07051VO.entityData.eilabel}</td>
                          <td align="center">${IGASM07051VO.entityData.einame}</td>
                          <td align="center">
                             ${IGASM07051VO.entityData.eidesc}
                         </td>
                          <td align="center">
                          <ig:codeValue ccid="ENTITY_ITEM_STATUS_CODE" cid="${IGASM07051VO.entityData.eistatus}"/>
                         </td>
                         <td align="center">
                           ${IGASM07051VO.entityData.eiinsdate}
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
                            ${IGASM07051VO.entityData.elabel}
                          </td>
                          <td align="center">
                            ${IGASM07051VO.entityData.ename}
                          </td>
                          <td align="center">
                            <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${IGASM07051VO.entityData.ecategory}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY1_CODE" cid="${IGASM07051VO.entityData.ekey1}" isChild="true"
                                pccid="ENTITY_CATEGORY_CODE" pcid="${IGASM07051VO.entityData.ecategory}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY2_CODE" cid="${IGASM07051VO.entityData.ekey2}" isChild="true"
                                pccid="ENTITY_EKEY1_CODE" pcid="${IGASM07051VO.entityData.ekey1}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY3_CODE" cid="${IGASM07051VO.entityData.ekey3}" isChild="true"
                                pccid="ENTITY_EKEY2_CODE" pcid="${IGASM07051VO.entityData.ekey2}" />
                          </td>
                        </tr>
                     </table>
             </div>
             <div class="title">
                 <div class="name">机房配置信息</div>
             </div>
                    
	         <div id="results_list">
	                <!--  message -->
	                <ig:message/>
	                <!--  /message -->     
                  <table class="table_style">
                       <!-- header部 -->
                       
                           <tr class="bgTblTitle">
					           <th width="8%">编号</th>
					           <th width="12%">名称</th>
					           <th width="25%">内容</th>
					           <th width="15%">状态</th>
					           <th width="10%">版本号</th>
					           <th width="10%">版本信息</th>           
					           <th width="10%">更新时间</th>
					           <th width="10%">失效时间</th>
                           </tr>
                   
                       <!-- body部 -->
                   
                           <logic:present name="IGASM07051VO" property="voDataList" >
                               <logic:iterate id="bean" name="IGASM07051VO" property="voDataList" indexId="index">
                                   <tr class="<ig:rowcss index="${index}"/>">
                                       <!-- 编号 -->
                                       <td>
                                           <div class="nowrapDiv">
                                                  <logic:empty name="bean" property="configuration.clabel">&nbsp;</logic:empty>
                                                  ${bean.configuration.clabel}
                                           </div>
                                       </td>
                                       <!-- 名称 -->
                                       <td>
                                           <div class="nowrapDiv">
                                                  <logic:empty name="bean" property="configuration.cname">&nbsp;</logic:empty>
                                                ${bean.configuration.cname}
                                           </div>
                                       </td>
                                       <!-- 内容 -->
                                       <td>
                                           <div class="nowrapDiv">
                                                <logic:notEqual name="bean" property="configuration.cattach" value="1">
                                                ${bean.civalue}
                                                </logic:notEqual>
                                                <logic:equal name="bean" property="configuration.cattach" value="1">
                                                <a href = "javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
                                                ${bean.civalue}
                                                </a>
                                                </logic:equal>
                                           </div>
                                       </td>
                                       <!-- 状态 -->
                                       <td>
                                           <div class="nowrapDiv">
                                           <logic:empty name="bean" property="cistatus">&nbsp;</logic:empty>
                                           <ig:codeValue ccid="CONFIG_ITEM_STATUS_CODE" cid="${bean.cistatus}"/>                                 
                                           </div>
                                       </td>
                                       <!-- 版本号 -->
                                       <td>
                                           <div class="nowrapDiv">
                                           <logic:empty name="bean" property="civersion">&nbsp;</logic:empty>
                                           ${bean.civersion}
                                           </div>
                                       </td>
                                          <!-- 版本信息 -->
                                          <td>
                                              <div class="nowrapDiv">
                                              <logic:empty name="bean" property="civerinfo">&nbsp;</logic:empty>
                                              ${bean.civerinfo}
                                              </div>
                                          </td>
                                       <!-- 更新时间 -->
                                       <td>
                                           <div class="nowrapDiv">
                                           <logic:empty name="bean" property="ciupdtime">&nbsp;</logic:empty>
                                           ${bean.ciupdtime}
                                           </div>
                                       </td>
                                       <!-- 失效时间 -->
                                       <td>
                                           <div class="nowrapDiv">
                                           <logic:empty name="bean" property="ciexpire">&nbsp;</logic:empty>
                                              ${bean.ciexpire}
                                              </div>
                                       </td>
                                   </tr>
                               </logic:iterate>
                           </logic:present>
             
                  </table>
	         </div>
                    
            <div class="enter">
              <html:form styleId="form"  action="/IGASM0705_Back" onsubmit="return checkSubmit(this);">
                      <html:submit property="btn_back" styleClass="button" value="返回"/>
              </html:form>  
            </div>
		</div>
    </div>
</div>


</div>
</body>
</html:html>