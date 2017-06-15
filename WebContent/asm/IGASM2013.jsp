<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2013" toScope="request" />
<bean:define id="title" toScope="request" value="Domain CI查询"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
    $("eilabel").value = eilabel;
    $("eiid").value = eiid;
}
function selectEntityItem(){
	 openSubIGCOM0302PARAM("?estatus=2&emodeltype_eq=1");
   }
function clearParentValue(){
    if(!window.opener.closed){
        window.opener.setParamIGCOM0302("", "", "", "", "", "" ,"");
    }
    window.close();
}
function check(){
	if($F('eilabel').trim()!=""){
		if($F('typeId').trim()=="2"){
			alert("类型只能选择顶级类型！");
    		return false;
		}
	}
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGASM2013"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">资产管理 &gt;&gt; 
		Domain管理&gt;&gt; CI查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; 
	Domain名称： </label> 
	<html:select name="IGASM2013Form" styleId="eiddid" property="eiddid" style="width: 130px;" errorStyleClass="inputError">
	 		<html:options collection="ADDomainList" property="value" name="" labelProperty="label"/>
	</html:select>
	 <label>&nbsp;&nbsp; 
	查询类型：</label>
	<html:select name="IGASM2013Form" styleId="typeId" property="typeId" style="width: 130px;" errorStyleClass="inputError">
	 		<html:options collection="ADTypeList" property="value" name="" labelProperty="label"/>
	</html:select>
	<label>&nbsp;&nbsp; 
	影响CI:</label>
	<html:text property="eilabel" styleId="eilabel" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="3" readonly="true"/>
	<img src="images/seek.gif" width="16" height="16" alt="查询CI" onclick="selectEntityItem()" style="cursor: hand"/>
	<html:hidden property="eiid" styleId="eiid" name="IGASM2013Form"/>
		<html:submit property="btn_search" styleClass="button" onclick="return check();" value="查询"/>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="10%">Domain名称</th>
			<th width="15%">Domain版本</th>
			<th width="10%">CI名称</th>
			<th width="10%">CI版本</th>
			<th width="15%">创建时间</th>
			<th width="10%">包含关系图</th>	
			<th width="10%">影响分析图</th>	
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM20131VO" property="eilabel">
		<logic:notEmpty name="IGASM20131VO" property="eilabel">
			<logic:present name="IGASM20131VO" property="eiDomainDetailCIInfoList">
			<logic:iterate id="bean" name="IGASM20131VO"
				property="eiDomainDetailCIInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 域名称 -->
					<td>
					<div class="nowrapDiv">${bean.name}</div>
					</td>
					<!-- 域版本 -->
					<td>
					<div class="nowrapDiv">${bean.domainversion}</div>
					</td>
					<!-- CI名称-->
					<td>
					<div class="nowrapDiv">${bean.einame}</div>
					</td>
					<!-- CI版本-->
					<td>
					<div class="nowrapDiv">${bean.eiversion}</div>
					</td>
					<!-- 创建时间-->
					<td>
					<div class="nowrapDiv">${bean.eiupdtime}</div>
					</td>
					<!-- 包含关系图 -->
                    <td>
                        <div class="nowrapDiv">                
                        <c:if test='${bean.belongcount != null && bean.belongcount > 0}'>
                              <a href="javascript:void(0)" onclick="openSubIGASM0346('${bean.entityItemTB.eirootmark}','${bean.entityItemTB.eiid}','${bean.entityItemTB.eiversion}','${bean.entityItemTB.eismallversion}')"><img src="images/relationships.gif" alt='包含关系' width="16" height="16"  border="0"/></a>
                        </c:if>
                        <c:if test='${bean.belongcount == null || bean.belongcount == "0"}'>
                            <img src="images/unrelationships.gif" alt='没有包含关系' width="16" height="16"  border="0"/>
                        </c:if>
                        </div>
                    </td>
					<!-- 影响图-->
			        <td>
			        <div class="nowrapDiv">
			         <c:if test='${bean.eircount != null && bean.eircount > 0}'>
	                  <a href="javascript:void(0)" onclick="openSubIGCOM0321('${bean.eiid}','${bean.domainid}','${bean.domainversion}','${bean.eiupdtime}')"><img src="images/relationships.gif" alt="显示影响分析图" width="16" height="16"  border="0"/></a>
			         </c:if>
			         <c:if test='${bean.eircount == null || bean.eircount == "0"}'>
	                    <img src="images/unrelationships.gif" alt='没有影响图' width="16" height="16"  border="0"/>
				     </c:if>	
			        </div>
			       </td>
				</tr>
			</logic:iterate>
		</logic:present>
		</logic:notEmpty>
		</logic:present>
		<logic:present name="IGASM20131VO" property="eiDomainDetailVWInfoList">
			<logic:iterate id="bean" name="IGASM20131VO"
				property="eiDomainDetailVWInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 域名称 -->
					<td>
					<div class="nowrapDiv">${bean.eiDomainDefTB.name}</div>
					</td>
					<!-- 域版本 -->
					<td>
					<div class="nowrapDiv">${bean.eiDomainDefTB.version}</div>
					</td>
					<!-- CI名称-->
					<td>
					<div class="nowrapDiv">${bean.einame}</div>
					</td>
					<!-- CI版本-->
					<td>
					<div class="nowrapDiv">${bean.eiddversion}</div>
					</td>
					<!-- 创建时间-->
					<td>
					<div class="nowrapDiv">${bean.createtime}</div>
					</td>
					<!-- 包含关系图 -->
                    <td>
                       <div class="nowrapDiv">
                         <c:if test='${bean.belongcount != null && bean.belongcount > 0}'>
                              <a href="javascript:void(0)" onclick="openSubIGASM0346('${bean.entityItemTB.eirootmark}','${bean.entityItemTB.eiid}','${bean.entityItemTB.eiversion}','${bean.entityItemTB.eismallversion}')"><img src="images/relationships.gif" alt='包含关系' width="16" height="16"  border="0"/></a>
                         </c:if>
                          <c:if test='${bean.belongcount == null || bean.belongcount == "0"}'>
                            <img src="images/unrelationships.gif" alt='没有包含关系' width="16" height="16"  border="0"/>
                        </c:if>
                        </div>
                    </td>
					<!-- 影响图-->
			        <td>
			        <div class="nowrapDiv">
			        <c:if test='${bean.eircount != null && bean.eircount > 0}'>
	                 <a href="javascript:void(0)" onclick="openSubIGCOM0321('${bean.eiid}','${bean.eiDomainDefTB.eiddid}','${bean.eiDomainDefTB.version}','${bean.eiDomainDefTB.updatetime}')"><img src="images/relationships.gif" alt="显示影响分析图" width="16" height="16"  border="0"/></a>
			        </c:if>
			         <c:if test='${bean.eircount == null || bean.eircount == "0"}'>
	                    <img src="images/unrelationships.gif" alt='没有影响图' width="16" height="16"  border="0"/>
				     </c:if>	
			        </div>
			       </td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>