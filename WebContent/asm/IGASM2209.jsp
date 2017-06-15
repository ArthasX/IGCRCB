<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2109" toScope="request" />
<bean:define id="title" toScope="request" >
    设备配置信息查看画面
</bean:define>

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGASM0323';
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM2108.do";
        	form.submit();
        }
        function goLook(eiid,v,sv){
        	var url = "/IGASM0341.do?eiid="+eiid+"&eiversion="+v+"&eismallversion="+sv;
        	openSubWindow(url, '_blank', '800', '600');
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
	<div class="image"></div>
	<p class="fonts1">资产管理 &gt;&gt; CI更新管理 &gt;&gt; 
		CI查询 &gt;&gt; 设备配置查看</p>
	<div class="back">
		<html:link href="javascript:toback();">
			返回
		</html:link>
	</div>
</div>

<html:form styleId="form" action="/IGASM2108"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">设备基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">模型名称</th>
			<th width="14%">设备编号</th>
			<th width="15%">设备名称</th>
			<th width="15%">设备所属机构</th>
			<th width="18%">设备说明</th>
			<!--<th width="8%">设备状态</th>-->
			<th width="10%">管理人</th>
			<th width="10%">登记日</th>
		</tr>
		<tr>
			<td align="center">${IGASM21091VO.entityItemData.ename}</td>
			<td>${IGASM21091VO.entityItemData.eilabel}</td>
			<td>${IGASM21091VO.entityItemData.einame}</td>
			<td>${IGASM21091VO.eiorgname}</td>
			<td>${IGASM21091VO.entityItemData.eidesc}</td>
			<!--<td><ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${IGASM21091VO.entityItemData.eistatus}"/></td>-->
			<td>${IGASM21091VO.entityItemData.eiusername}</td>
			<td>${IGASM21091VO.entityItemData.eiinsdate}</td>
		</tr>
	</table>
</div>
<logic:present name="IGASM21091VO" property="configItemVersionTime">
<div class="title">
	<div class="name">历史版本信息</div>
</div>
<div id="results_list">
   <table width="100%" class="table_style" >
     <!-- header部 -->
	 <tr>
		<th width="50%">版本号 </th>
		<th width="50%">修改时间</th>
	 </tr>
		<logic:iterate id="bean" name="IGASM21091VO" property="configItemVersionTime"
			indexId="index">
			<tr>
	       		<td>
			       <c:if test="${IGASM21091VO.flag==true}">
			          <a href='javascript:openVersionInfoDetail(${IGASM21091VO.entityItemData.eiid},${bean.civersion},${bean.cismallversion})'>${bean.civersion}<c:if test="${IGASM21091VO.entityItemData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if>版</a>
			       </c:if>
			       <c:if test="${IGASM21091VO.flag!=true}">${bean.civersion}<c:if test="${IGASM21091VO.entityItemData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if>版</c:if>
	       		</td>
	       		<td>
	          		${bean.ciupdtime}
	       		</td>
	       </tr>
		</logic:iterate>
    </table>
    <div class="enter">
		<logic:present name="IGASM21091VO" property="configItemVersionTime">
			<bean:size id="num" name="IGASM21091VO" property="configItemVersionTime"/>
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button" style="height:20px;" onclick="openEiVersionWindow('${IGASM21091VO.entityItemData.eiid}');" >
			    		 版本比较 
			    	</html:button>
    			</c:if>
		</logic:present>
	</div>
</div>
</logic:present>
	<div class="title">
	<div class="name">设备配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM21091VO" property="flag">
	<logic:equal value="true" name="IGASM21091VO" property="flag">
	<logic:present name="IGASM21091VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM21091VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM21091VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM21091VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
					    <th width="30px"></th>
						<th width="20%" align="left">配置项名称</th>
						<th width="35%" align="left">配置项内容</th>
					<th width="35%">附件</th>
						<th width="10%">版本号</th>
						<!--th width="9%">更新时间</th-->
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							<td></td>
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}
								<logic:equal name="bean" property="cattach" value="8">
									<html:button property="btn_look" styleClass="button"  onclick="goLook('${IGASM21091VO.entityItemData.eiid}','${IGASM21091VO.entityItemData.eiversion}','${IGASM21091VO.entityItemData.eismallversion}');" >
										查看
									</html:button>
								</logic:equal></div>
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
							<td align="center">
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}<c:if test="${IGASM21091VO.entityItemData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if></div>
							</td>
							<!-- 更新时间 -->
							<!--td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div>
							</td -->
						</tr>
					</logic:iterate>
				</table>
				</div>
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
		<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>
	</logic:present>
	</logic:equal>
	</logic:present>
	<div class="enter">
		<html:button property="btn_back" styleClass="button"  onclick="toback()">
			返回
		</html:button>
	</div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGASM2109Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGASM21091VO.entityItemData.eiversion}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>