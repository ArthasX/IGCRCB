<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0328" toScope="request" />
<bean:define id="title" value="配置项信息历史版本画面" toScope="request" />
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript">
var gid='IGASM0328';
	function toback() {
		form.action = getAppRootUrl() + "/IGCOM0302_BACK.do";
		form.submit();
	}
</script>
<body>
<div id="maincontent">
<div id="container">

    <!--content  右侧内容-->

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 历史版本</p>
            </div>

    				     
             <div class="title">
                 <div class="name">配置项基本信息</div>
             </div>

             <div id="results_list">
				<table width="100%" class="table_style">
					<tr>
						<th width="10%">模型名称</th>
						<th width="10%">资产编号</th>
						<th width="20%">资产名称</th>
						<th width="15%">资产所属机构</th>
						<th width="20%">资产说明</th>
						<th width="7%">管理人</th>
						<th width="8%">登记日</th>
						
					</tr>
					<tr>
						<td>${IGASM03051VO.entityData.ename}</td>
						<td>${IGASM03051VO.entityData.eilabel}</td>
						<td>${IGASM03051VO.entityData.einame}</td>
						<td>${IGASM03051VO.entityData.organizationTB.orgname}</td>
						<td>${IGASM03051VO.entityData.eidesc}</td>
                        			<td>${IGASM03051VO.entityData.eiusername}</td>
                        			<td>${IGASM03051VO.entityData.eiinsdate}</td>
					    	
					</tr>
				</table>
             </div>

<div class="title">
<div class="name">历史版本信息</div>
</div>
<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="50%">版本号</th>
			<th width="50%">修改时间</th>
		 </tr>
		 <logic:present name="IGASM03051VO" property="configItemVersionTime">
			<logic:iterate id="bean" name="IGASM03051VO" property="configItemVersionTime"
				indexId="index">
				<tr>
		       		<td>
				       <c:if test="${IGASM03051VO.flag==true}">
				          <a href='javascript:openVersionInfoDetail(${IGASM03051VO.entityData.eiid},${bean.civersion})'>${bean.civersion}版 </a>
				       </c:if>
				       <c:if test="${IGASM03051VO.flag!=true}">${bean.civersion}版 </c:if>
		       		</td>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<html:form styleId="form"  action="/IGCOM0302_BACK" onsubmit="return checkSubmit(this);">
	<c:if test="${IGASM03051VO.flag==true}">
    	<logic:present name="IGASM03051VO" property="configItemVersionTime">
			<bean:size id="num" name="IGASM03051VO" property="configItemVersionTime"/>
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button" value="版本比较" onclick="openEiVersionWindow('${IGASM03051VO.entityData.eiid}');" />	
    			</c:if>
		</logic:present>
	</c:if>
		<html:submit property="btn_back" styleClass="button" value="返回"/>
	</html:form>
</div>

</div>
</div>
</body>
</html:html>