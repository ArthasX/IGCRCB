<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1116" toScope="request"/>
<bean:define id="title" value="设备配置详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
    var gid='IGASM1116';
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<div id="container">
    <div id="location">
        <div class="image"></div>
            <p class="fonts1">设备配置详细信息</p>
    </div>

    <div class="title">
        <div class="name">设备基本信息</div>
    </div>

    <div id="results_list">
       <table class="table_style">
           <tr>
               <th width="18%">设备编号</th>
               <th width="22%">设备名称</th>
               <th width="28%">设备说明</th><!--
               <th width="10%">类别</th>
               <th width="10%">状态</th>
               -->
               <th width="7%">管理人</th>
               <th width="10%">登记日</th>
               
           </tr>
           <tr>
               <td>${IGASM11161VO.entityData.eilabel}</td>
               <td>${IGASM11161VO.entityData.einame}</td>
               <td>
                   <label>
                       ${IGASM11161VO.entityData.eidesc}
                   </label>
               
               </td><!--
               <td><ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${IGASM11161VO.entityData.ecategory}"/>
               </td>
               <td><label>
                 <ig:codeValue ccid="ENTITY_ITEM_STATUS_CODE" cid="${IGASM11161VO.entityData.eistatus}"/>
                 </label>
               </td>
               -->
               <td align="center">${IGASM11161VO.entityData.eiusername}</td>
               <td align="center">${IGASM11161VO.entityData.eiinsdate}</td>
               
           </tr>
       </table>
    </div>
    <div class="title">
        <div class="name">设备配置信息</div>
    </div>
    <div class="message"><ig:message /></div>
    <logic:present name="IGASM11161VO" property="flag">
	<logic:equal value="true" name="IGASM11161VO" property="flag">
    <logic:present name="IGASM11161VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM11161VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM11161VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM11161VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="10%">配置项名称</th>
						<th width="36%">配置项内容</th>
						<th width="29%">附件</th>
						<th width="9%">版本号</th>
						<th width="9%">更新时间</th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							<td>
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
							</td>
							<!-- 内容 -->
							<td align="center">
							<div class="nowrapDiv">
								<logic:empty name="bean"
								property="civalue">&nbsp;</logic:empty><pre>${bean.civalue}</pre>
							</div>
							</td>
							<!-- 附件 -->
							<td align="center">
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
							</td>
							<!-- 更新时间 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div>
							</td>
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
</html:html>