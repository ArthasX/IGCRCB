<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM0407" toScope="request" />
<bean:define id="title" value="查看" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	<script type="text/javascript">
    var gid='IGCOM0328';
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<style>
.nowrapDiv{
		margin-left: 0px;
		text-align: left;
	}
</style>
<body  onload="startCheckOpenerClosed();">
	<div id="location">
         <div class="image"></div>
         <p class="fonts1" id = "navi">    </p>
     </div> 
<div id="maincontent">
<div id="container">
		
	    <div class="message"><ig:message /></div>
		<fieldset>
			<legend class="name til"> 基本信息</legend>
			<br/>
		    <div id="results_list">
		       <table class="table_style">
		           <tr>
		               <th class = "til" width="8%">分类</th>
		               <th  class = "til" width="11%">编号</th>
		               <th  class = "til" width="20%">名称</th>
		               <!--<th width="15%">资产所属机构</th>-->
		               <th  class = "til" width="20%">说明</th>
		               <th width="7%">管理人</th>
		           </tr>
		           <tr>
		               <td>
		               	${IGDRM04071VO.entityData.ename}
		               		<input type="hidden" id="esyscoding" value="${IGDRM04071VO.entityData.esyscoding}">
		               </td>
		               <td>${IGDRM04071VO.entityData.eilabel}</td>
		               <td>${IGDRM04071VO.entityData.einame}</td>
		               <!--<td>${IGDRM04071VO.entityData.organizationTB.orgname}</td>-->
		               <td>${IGDRM04071VO.entityData.eidesc}</td>
		               <td>${IGDRM04071VO.entityData.eiusername}</td>
		           </tr>
		       </table>
		    </div>
	    </fieldset>
			<logic:present name="IGDRM04071VO" property="configItemVWInfoMap">
				<c:if test="${fn:length(IGDRM04071VO.configItemVWInfoMap)>0 }">
			    <fieldset>
			    	<legend class="name">详细信息</legend>
			    	<br/>
					<logic:iterate id="map" name="IGDRM04071VO" property="configItemVWInfoMap" indexId="number">
						<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
						<div class="record_list" style="margin:0 auto;width:98%;">
							<table class="table_style2" >
								<tr>
									<TH width="4%"></TH>
									<th width="20%">名称</th>
									<th width="35%">内容</th>
<!-- 									<th width="10%">版本号</th> -->
								</tr>
								<logic:iterate id="bean" name="list" indexId="index">
									<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);"
									<logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
									<td></td>									
									<!-- 名称 -->
									<td>
									<div class="nowrapDiv"><logic:empty name="bean"
										property="cname">&nbsp;</logic:empty>
									${bean.cname}</div>
									</td>
									<!-- 内容 -->
									<logic:notEqual name="bean" property="cattach" value="6">
									<td>
									<div class="nowrapDiv">
									<logic:notEqual name="bean"
										property="cattach" value="1">
									<logic:notEqual name="bean"
										property="cattach" value="4">
			                                                ${bean.civalue}
			                                                </logic:notEqual> 
			                                                </logic:notEqual> 
			                                                <logic:equal
										name="bean" property="cattach" value="1">
										<a
											href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
										${bean.civalue} </a>
									</logic:equal>
									<logic:equal name="bean" property="cattach" value="4">
									<bean:define id="ei" value="${bean.civalue}"/>
									<logic:notEmpty name="ei">
									<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=ei.substring(ei.lastIndexOf("(")+1, ei.length()-1)%>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
									</logic:notEmpty>
										</logic:equal>
									</div>
									</td>
										</logic:notEqual>
									<logic:equal name="bean" property="cattach" value="6">
										<td align="left"><pre> ${bean.civalue} </pre></td>
									</logic:equal>
								</tr>
								</logic:iterate>
							</table>
						</div>
					</logic:iterate>
				</fieldset>
				</c:if>
			</logic:present>
		
	    <div id="operate">
		        <div class="content">
			            <div class="enter">
			                <input type="button" name="btn_close" value="关闭"  onclick="window.close()" class="button">
			            </div>
		        </div> 
	    </div>
</div>
</div>
</body>

<script>
jQ(function(){
	var esyscoding = jQ("#esyscoding").val();
	var ename ;
	if(/999040.*/.test(esyscoding)){
		ename = "应急资源";
	}else if(/999050.*/.test(esyscoding)){
		ename = "专项预案";
	}else if(/999060.*/.test(esyscoding)){
		ename = "场景";
	}else{
		ename = "资产";
	}
	jQ(".til").each(function(i,t){
		t = jQ(t);
		t.html(ename+t.html());
	})
	jQ("#navi").html(ename+"信息查看");
	document.title = ename+"信息查看";
	
	
});
jQ(".nowrapDiv").each(function (index, item) {
		
	if(jQ(item).text().trim()=="定义场景流程ID"){
		jQ(item).parent().parent().hide();
	}
	if(jQ(item).text().trim()=="场景类型"){
		jQ(item).parent().parent().hide();
	}
	
	if(jQ(item).text().trim()=="场景应急处置步骤"){
		jQ(item).parent().parent().hide();
	}
	
});
</script>

</html:html>