<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2411" toScope="request"/>
<bean:define id="title" value="发票关系管理详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGASM2411';
	    function deleteRec(){
	        var message ='<bean:message key="IGCO10000.E002"/>';
	        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="发票关系信息" />';
	        var frm = window.document.forms[0];
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
	
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM2406_Del.do";
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    function toback(){
	        form.action = getAppRootUrl() + "/IGASM2408_Back.do";
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 关系查看</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>
            <html:form styleId="form"  action="/IGASM2406" onsubmit="return checkSubmit(this);">
                <div class="title">
                    <div class="name">发票基本信息</div>
                </div>
                <div id="results_list">
                    <table class="table_style">
                        <tr>
<!--                            <th width="10%">模型名称</th>-->
	                        <th width="15%">费用编号</th>
	                        <th width="20%">费用名称</th>
<!--	                        <th width="10%">发票所属机构</th>-->
	                        <th width="18%">费用摘要</th>
	                        <th width="7%">管理人</th>
	                        <th width="8%">登记日</th>
	                        <th width="12%">更新时间</th>
                        </tr>
                        <tr>
<!--                          <td align="center">-->
<!--                            ${IGASM24061VO.entityData.ename}-->
<!--                          </td>-->
                          <td align="center">${IGASM24061VO.entityData.eilabel}</td>
                          <td align="center">${IGASM24061VO.entityData.einame}</td>
<!--                          <td>${IGASM24061VO.eiorgname}</td>-->
					 	  <td>${IGASM24061VO.entityData.eidesc}</td>
                          <td align="center">${IGASM24061VO.entityData.eiusername}</td>
                          <td align="center">${IGASM24061VO.entityData.eiinsdate}</td>
                          <td align="center">${IGASM24061VO.entityData.eiupdtime}</td>
                        </tr>
                     </table>
                 
                </div>
                    
                                <div class="title">
                    <div class="name">发票关系信息</div>
                </div>
                <div class="message"><ig:message /></div>
                <logic:present name="IGASM24061VO" property="flag">
	<logic:equal value="true" name="IGASM24061VO" property="flag"> 
	            <div id="results_list"> <logic:present
		name="IGASM24061VO" property="parEntityItemRelationMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM24061VO"
				property="parEntityItemRelationMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="ENTITY_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM24061VO" property="parEntityItemRelationMap">
			<logic:iterate id="map" name="IGASM24061VO"
				property="parEntityItemRelationMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="15%">关联资产编号</th>
						<th width="20%">关联资产名称</th>
						<th width="15%">关联资产关系</th>
						<th width="15%">关系登记时间</th>
						<th width="35%">关联资产说明</th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<logic:equal name="bean" property="parflag" value="0">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<!-- 编号 -->
							<td align="center">
							<div class="nowrapDiv">${bean.cldEntityItemVW.eilabel}
							</div>
							</td>
							<!-- 名称 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cldEntityItemVW.einame">&nbsp;</logic:empty> <html:link
								href="javascript:openSubIGCOM0303('${bean.cldEntityItemVW.eiid}',
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
                            <!-- 登记时间 -->
                            <td align="center">
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
							<!-- 编号 -->
							<td align="center">
							<div class="nowrapDiv">${bean.parEntityItemVW.eilabel}
							</div>
							</td>
							<!-- 名称 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="parEntityItemVW.einame">&nbsp;</logic:empty> <html:link
								href="javascript:openSubIGCOM0303('${bean.parEntityItemVW.eiid}',
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
                            <!-- 登记时间 -->
                            <td align="center">
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
	</logic:present></div>
	</logic:equal>
</logic:present>
	            <div class="enter">
                     <html:submit property="btn_back" styleClass="button" value="返回" onclick="toback()"/>
	            </div>
                <html:hidden property="pareid" styleId="pareid" value="${IGASM24061VO.entityData.eid}"/>
                <html:hidden property="pareiid" styleId="pareiid" value="${IGASM24061VO.entityData.eiid}"/>
                <html:hidden property="pareiname" styleId="pareiname" value="${IGASM24061VO.entityData.einame}"/>
            </html:form>  
		 </div>
     </div>
</div>


</div>
</body>
</html:html>