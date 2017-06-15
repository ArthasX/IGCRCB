<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2409" toScope="request" />
<bean:define id="title" value="发票配置信息查看画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGASM2409';
var proCount ='';
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM2408_Back.do";
        	form.submit();
        }
        function pics(){
			var pics = "${IGASM24041VO.picsXml}";
			openIntegrationWindow(pics, "pics", "1000", "600");
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
	 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 发票配置查看</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM2404"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">发票基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
<!--			<th width="10%">模型名称</th>-->
            <th width="15%">费用编号</th>
            <th width="20%">费用名称</th>
<!--            <th width="10%">发票所属机构</th>-->
            <th width="18%">费用摘要</th>
            <th width="7%">管理人</th>
            <th width="8%">登记日</th>
           
		</tr>
		<tr>
<!--			<td align="center">${IGASM24041VO.entityData.ename}</td>-->
			<td>${IGASM24041VO.entityData.eilabel}</td>
			<td>${IGASM24041VO.entityData.einame}</td>
<!--			<td>${IGASM24041VO.eiorgname}</td>-->
			<td>${IGASM24041VO.entityData.eidesc}</td>
			<td>${IGASM24041VO.entityData.eiusername}</td>
			<td>${IGASM24041VO.entityData.eiinsdate}</td>
			
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name">发票配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM24041VO" property="flag">
	<logic:equal value="true" name="IGASM24041VO" property="flag"> 
	<logic:present name="IGASM24041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM24041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM24041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM24041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="4%"></th>
						<th width="20%" align="left">配置项名称</th>
						<th width="35%" align="left">配置项内容</th>
<!--						<th width="30%" align="left">附件</th>-->
<!--						<th width="10%">版本号</th>-->
						<!--th width="9%">更新时间</th-->
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
					<bean:define id="hiddenValue" value="n" />
					<logic:equal name="bean" property="cseq" value="1">
						<bean:define id="hiddenValue" value="y" />
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0172">
						<logic:equal name ="bean" property="civalue" value="">
								<script>proCount=proCount+'|IG_0172';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0173">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0173';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0174">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0174';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0175">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0175';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0176">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0176';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0177">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0177';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0178">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0178';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0179">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0179';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0180">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0180';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0181">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0181';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0182">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0182';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0183">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0183';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0184">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0184';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0185">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0185';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0186">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0186';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0187">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0187';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0188">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0188';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0189">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0189';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0190">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0190';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" id = "LABEL_${bean.clabel }"
									<logic:equal name="hiddenValue"  value="y">style="display: none;"</logic:equal>
								>
							<!-- 占位调整格式使用 -->
							<td></td>
							<!-- 名称 -->
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
		<logic:notEqual value="true" name="IGASM24041VO" property="image_flag">
			<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="pics();"/>
		</logic:notEqual>
		<html:button property="btn_back" styleClass="button" value="返回" onclick="toback()"/>
	</div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGASM2404Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGASM24041VO.entityData.eiversion}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>