<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0706" toScope="request"/>
<bean:define id="title" value="机房关系管理详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGASM0706';
	    function deleteRec(){
	        var message ='<bean:message key="IGCO10000.E002"/>';
	        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="机房关系信息" />';
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
		        alert("不存在可以删除的数据！");
		              return false;
		    }
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM0706_Del.do";
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    function toback(){
	        form.action = getAppRootUrl() + "/IGASM0706.do?btn_back=1";
	        form.submit();
	    }
	</script>
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 关系管理</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>
            <html:form styleId="form"  action="/IGASM0706" onsubmit="return checkSubmit(this);">
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
                            <th width="15%">更新时间</th>
                        </tr>
                        <tr>
                          <td align="center">${IGASM07061VO.entityData.eilabel}</td>
                          <td align="center">${IGASM07061VO.entityData.einame}</td>
                          <td align="center">
                              <label>
                                   ${IGASM07061VO.entityData.eidesc}
                              </label>
                         </td>
                          <td align="center">
                               <ig:codeValue ccid="ENTITY_ITEM_STATUS_CODE" cid="${IGASM07061VO.entityData.eistatus}"/>
                         </td>
                         <td align="center">
                           ${IGASM07061VO.entityData.eiinsdate}
                         </td>
                          <td align="center">
                                  ${IGASM07061VO.entityData.eiupdtime}
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
                            ${IGASM07061VO.entityData.elabel}
                          </td>
                          <td align="center">
                            ${IGASM07061VO.entityData.ename}
                          </td>
                          <td align="center">
                            <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${IGASM07061VO.entityData.ecategory}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY1_CODE" cid="${IGASM07061VO.entityData.ekey1}" isChild="true"
                                pccid="ENTITY_CATEGORY_CODE" pcid="${IGASM07061VO.entityData.ecategory}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY2_CODE" cid="${IGASM07061VO.entityData.ekey2}" isChild="true"
                                pccid="ENTITY_EKEY1_CODE" pcid="${IGASM07061VO.entityData.ekey1}" />
                          </td>
                          <td align="center">
                            <ig:codeValue
                                ccid="ENTITY_EKEY3_CODE" cid="${IGASM07061VO.entityData.ekey3}" isChild="true"
                                pccid="ENTITY_EKEY2_CODE" pcid="${IGASM07061VO.entityData.ekey2}" />
                          </td>
                        </tr>
                     </table>
                </div>
                    
                <div class="title">
                    <div class="name">关系信息（正向关联关系）</div>
                </div>

	            <div id="results_list">
	                <!--  message -->
	                <ig:message/>
	                <!--  /message -->     
	                <table class="table_style">
                        <!-- header部 -->
                            <tr>
                               <th width="8%"></th>
					           <th width="12%">类别</th>
					           <th width="15%">编号</th>
					           <th width="15%">名称</th>
					           <th width="15%">关系</th>
					           <th width="35%">说明</th>
                            </tr>
                        <!-- body部 -->
                            <logic:present name="IGASM07061VO" property="parEntityItemRelationList" >
                                <logic:iterate id="bean" name="IGASM07061VO" property="parEntityItemRelationList" indexId="index">
                                    <tr class="<ig:rowcss index="${index}"/>">
                                        <td align="center">
                                            <html:checkbox property="deleteEirid" value="${bean.eirid}"/>
                                        </td>
                                        <!-- 类别 -->
                                        <td align="center">
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="cldEntityItemVW.ecategory">&nbsp;</logic:empty>
                                            <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${bean.cldEntityItemVW.ecategory}"/>                                 
                                            </div>
                                        </td>
                                        <!-- 编号 -->
                                        <td align="center">
                                            <div class="nowrapDiv">${bean.cldEntityItemVW.eilabel}
                                            </div>
                                        </td>
                                        <!-- 名称 -->
                                        <td align="center">
                                            <div class="nowrapDiv">
                                                   <logic:empty name="bean" property="cldEntityItemVW.einame">&nbsp;</logic:empty>
                                                   <html:link href="javascript:openSubIGCOM0303('${bean.cldEntityItemVW.eiid}',
                                                   '${bean.cldEntityItemVW.eiversion}');">
                                                   ${bean.cldEntityItemVW.einame}</html:link>
                                            </div>
                                        </td>
                                           <!-- 关系 -->
                                           <td align="center">
                                               <div class="nowrapDiv">
                                               <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
                                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
                                               </div>
                                           </td>
                                        <!-- 说明 -->
                                        <td align="center">
                                            <div class="nowrapDiv">
                                               <logic:empty name="bean" property="eirdesc">&nbsp;</logic:empty>
                                            ${bean.eirdesc}
                                            </div>
                                        </td>
                                    </tr>
                                </logic:iterate>
                            </logic:present>  
	                </table>
	            </div>
                    
                <div class="title">
                    <div class="name">关系信息（反向关联关系）</div>
                </div>

                <div id="results_list">
                    <!--  message -->
                    <!--  /message -->     
                    <table class="table_style">
                        <!-- header部 -->
                            <tr>
                               <th width="12%">类别</th>
                               <th width="15%">编号</th>
                               <th width="15%">名称</th>
                               <th width="15%">关系</th>
                               <th width="35%">说明</th>
                            </tr>
                        <!-- body部 -->
                            <logic:present name="IGASM07061VO" property="cldEntityItemRelationList" >
                                <logic:iterate id="bean" name="IGASM07061VO" property="cldEntityItemRelationList" indexId="index">
                                    <tr class="<ig:rowcss index="${index}"/>">
                                        <!-- 类别 -->
                                        <td align="center">
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="parEntityItemVW.ecategory">&nbsp;</logic:empty>
                                            <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${bean.parEntityItemVW.ecategory}"/>                                 
                                            </div>
                                        </td>
                                        <!-- 编号 -->
                                        <td align="center">
                                            <div class="nowrapDiv">${bean.parEntityItemVW.eilabel}
                                            </div>
                                        </td>
                                        <!-- 名称 -->
                                        <td align="center">
                                            <div class="nowrapDiv">
                                                   <logic:empty name="bean" property="parEntityItemVW.einame">&nbsp;</logic:empty>
                                                   <html:link href="javascript:openSubIGCOM0303('${bean.parEntityItemVW.eiid}',
                                                   '${bean.parEntityItemVW.eiversion}');">
                                                   ${bean.parEntityItemVW.einame}</html:link>
                                            </div>
                                        </td>
                                           <!-- 关系 -->
                                           <td align="center">
                                               <div class="nowrapDiv">
                                               <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
                                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
                                               </div>
                                           </td>
                                        <!-- 说明 -->
                                        <td align="center">
                                            <div class="nowrapDiv">
                                               <logic:empty name="bean" property="eirdesc">&nbsp;</logic:empty>
                                            ${bean.eirdesc}
                                            </div>
                                        </td>
                                    </tr>
                                </logic:iterate>
                            </logic:present>  
                    </table>
                </div>
                    
	            <div class="enter">
                     <html:submit property="btn_add" styleClass="button" value="增加"/>
                     <logic:present name="IGASM07061VO" property="parEntityItemRelationList" >
                     <html:submit property="btn_delete" styleClass="button" value="删除所选" onclick="return deleteRec();"/>
                     </logic:present>
                     <html:submit property="btn_back" styleClass="button" value="返回"/>
	            </div>
                <html:hidden property="pareid" styleId="pareid" value="${IGASM07061VO.entityData.eid}"/>
                <html:hidden property="pareiid" styleId="pareiid" value="${IGASM07061VO.entityData.eiid}"/>
                <html:hidden property="pareiname" styleId="pareiname" value="${IGASM07061VO.entityData.einame}"/>
                <html:hidden property="parversion" styleId="parversion" value="${IGASM07061VO.entityData.eiversion}" />
				<html:hidden property="parsmallversion" styleId="parsmallversion" value="${IGASM07061VO.entityData.eismallversion}" />
            </html:form>  
		 </div>
     </div>
</div>


</div>
</body>
</html:html>