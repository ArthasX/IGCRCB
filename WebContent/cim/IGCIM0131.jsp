<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0131" toScope="request" />
<bean:define id="title"   toScope="request" >
	<bean:message bundle="asmResources" key="ietitle.IGCIM0129"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGCIM0129';
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM0808_Back.do";
        	form.submit();
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">
	<bean:define id="urlable">
         		<bean:message bundle="asmResources" key="navigation.IGASM.UserConfigView"/>
    </bean:define> 
    <ig:navigation extname1="${urlable}" />
</p>
<div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGCIM0129.btn_toback"/></html:link></div>
</div>

<html:form styleId="form" action="/IGASM0804"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0129.UserInfo"/></div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0129.ModelName"/></th>
            <th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0129.UserNO"/></th>
            <th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0129.UserName"/></th>
            <th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0129.UserOrgan"/></th>
            <th width="18%"><bean:message bundle="asmResources" key="label.IGCIM0129.UserRemark"/></th>
            <th width="7%"><bean:message bundle="asmResources" key="label.IGCIM0129.UserManager"/></th>
            <th width="8%"><bean:message bundle="asmResources" key="label.IGCIM0129.UserMarkDay"/></th>
            
		</tr>
		<tr>
			<td align="center">${IGCIM01241VO.entityData.ename}</td>
			<td>${IGCIM01241VO.entityData.eilabel}</td>
			<td>${IGCIM01241VO.entityData.einame}</td>
			<td>${IGCIM01241VO.eiorgname}</td>
			<td>${IGCIM01241VO.entityData.eidesc}</td>
			<td>${IGCIM01241VO.entityData.eiusername}</td>
			<td>${IGCIM01241VO.entityData.eiinsdate}</td>
			
		</tr>
	</table>
</div>
<logic:present name="IGCIM01241VO" property="configItemVersionTime">
<bean:size id="num" name="IGCIM01241VO" property="configItemVersionTime"/>
<c:if test="${num > 0}">        
<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGASM0804.historyVersionInfo"/></div>
</div>
<div class="message"></div>              
    <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGASM0804.VersionINO"/></th>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGASM0804.ModefyTime"/></th>     
		 </tr>
		 
			<logic:iterate id="bean" name="IGCIM01241VO" property="configItemVersionTime"
				indexId="index">
				<tr>
		       		<td>
				       <c:if test="${IGCIM01241VO.flag==true}">
				          <a href='javascript:openVersionInfoDetail(${IGCIM01241VO.entityData.eiid},${bean.civersion},${bean.cismallversion})'>${bean.civersion}<bean:message bundle="asmResources" key="label.IGASM0804.Vesion"/></a>
				       </c:if>
				       <c:if test="${IGCIM01241VO.flag!=true}">${bean.civersion}<bean:message bundle="asmResources" key="label.IGASM0804.Vesion"/> </c:if>
		       		</td>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		
     </table>
 </div>  
 <div class="enter">            
   	<c:if test="${IGCIM01241VO.flag==true}">
    	<logic:present name="IGCIM01241VO" property="configItemVersionTime">
			
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button"  onclick="openEiVersionWindow('${IGCIM01241VO.entityData.eiid}');" >
			    		<bean:message bundle="asmResources" key="button.IGASM0804.btn_compare"/> 
			    	</html:button>	
    			</c:if>
		</logic:present>
	</c:if>               
  </div>    
  </c:if>
 </logic:present>
	<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0129.UserConfigInfo"/></div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGCIM01241VO" property="flag">
	<logic:equal value="true" name="IGCIM01241VO" property="flag">
	<logic:present name="IGCIM01241VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCIM01241VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCIM01241VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGCIM01241VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>		
					    <th width="30px"></th>	
						<th width="20%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0129.ConfigName"/></th>
						<th width="35%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0129.ConfigItem"/></th>
						<th width="35%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0129.Attachment"/></th>
						<th width="5%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0129.VersionNO"/></th>
						<!--th width="9%">更新时间</th-->
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							<td></td>
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
							</td>
							<!-- 内容 -->
							<logic:notEqual name="bean" property="cattach" value="6">
							<td align="left">
							<div class="nowrapDiv">
								<logic:notEqual name="bean" property="cattach" value="4">
								<logic:empty name="bean"
								property="civalue">&nbsp;</logic:empty>${bean.civalue}</logic:notEqual>
								<logic:equal name="bean" property="cattach" value="4">
						<bean:define id="ei" value="${bean.civalue}"/>
						<logic:notEmpty name="ei">
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(")+1, ei.length()-1)%>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
						</logic:notEmpty>
							</logic:equal>
							</div>
							</td>
							</logic:notEqual>
							<logic:equal name="bean" property="cattach" value="6">
								<td align="left"><pre> ${bean.civalue} </pre></td>
							</logic:equal>
							<!-- 附件 -->
							<td align="left">
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td>
							<div class="nowrapDiv">${bean.civersion}</div>
							</td>
							<!-- 更新时间 -->
							<!--td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div>
							</td-->
						</tr>
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
	</logic:present>
	</logic:equal>
	</logic:present>
	<div class="enter">
		<html:button property="btn_back" styleClass="button"  onclick="toback()">
			<bean:message bundle="asmResources" key="button.IGCIM0129.btn_toback"/>
		</html:button>
	</div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGCIM0124Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGCIM01241VO.entityData.eiversion}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>