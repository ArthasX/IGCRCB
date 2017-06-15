<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0205" toScope="request"/>
<bean:define id="title" value="配置项信息历史版本画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	var gid='IGASM0205';
    function toback(){
        form.action = getAppRootUrl() + "/IGASM0205_Back.do?btn_back=1";
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
						<jsp:param name="eiid" value="${IGASM0205Form.eiid}"/>
						<jsp:param name="eiversion" value="${IGASM02051VO.entityData.eiversion}"/>
						<jsp:param name="civersion" value="${IGASM0205Form.civersion}"/>
						<jsp:param name="action" value="IGASM0205_Disp"/>
						<jsp:param name="flag" value="1"/>
				</jsp:include>
             </div>
             <!-- 历史版本显示 -->
    				     
             <div class="title">
                 <div class="name">配置项基本信息</div>
             </div>

             <div id="results_list">
              <table class="table_style">
                  <tr>
                  	  <th width="15%">模型名称</th>
                      <th width="8%">资产编号</th>
                      <th width="20%">资产名称</th>
                      <th width="25%">资产说明</th>
                      <th width="7%">管理人</th>
                      <th width="10%">登记日</th>
                     
                  </tr>
                  <tr>
                    <td align="center">${IGASM02051VO.entityData.ename}</td>
                    <td align="center">${IGASM02051VO.entityData.eilabel}</td>
                    <td align="center">${IGASM02051VO.entityData.einame}</td>
                    <td align="center">${IGASM02051VO.entityData.eidesc}</td>
                    <td align="center">${IGASM02051VO.entityData.eiusername}</td>
                    <td align="center">${IGASM02051VO.entityData.eiinsdate}</td>
                    
                  </tr>
               </table>
             </div>
             <div class="title">
                 <div class="name">配置信息</div>
             </div>
                    
	         <div class="message"><ig:message /></div>
<logic:present name="IGASM02051VO" property="configItemMap">
	<div id="TabbedPanels1" class="TabbedPanels">
	<ul class="TabbedPanelsTabGroup">
		<logic:iterate id="map" name="IGASM02051VO" property="configItemMap"
			indexId="number">
			<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
				ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
		</logic:iterate>

	</ul>
	<div class="TabbedPanelsContentGroup"><logic:present
		name="IGASM02051VO" property="configItemMap">
		<logic:iterate id="map" name="IGASM02051VO" property="configItemMap"
			indexId="number">
			<bean:define id="list" name="map" property="value"
				type="java.util.ArrayList" />
			<div class="TabbedPanelsContent">
			<div class="record_list">
			<table class="table_style2">
				<tr>
					<th width="12%">配置项名称</th>
					<th width="30%">配置项内容</th>
					<th width="10%">版本号</th>
				</tr>
				<logic:iterate id="bean" name="list" indexId="index">
					<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);"
						<logic:equal name="bean" property="configuration.cseq" value="1">style="display: none;"</logic:equal>
						<logic:equal name="bean" property="cicurver" value="1">bgcolor="#FFFF99"</logic:equal>>
						<!-- 名称 -->
						<td>
						<div class="nowrapDiv"><logic:empty name="bean"
							property="configuration.cname">&nbsp;</logic:empty>
						${bean.configuration.cname}</div>
						</td>
						<!-- 内容 -->
						<td>
						<div class="nowrapDiv">
						<logic:notEqual name="bean"
							property="configuration.cattach" value="1">
						<logic:notEqual name="bean"
							property="configuration.cattach" value="4">
                                                ${bean.civalue}
                                                </logic:notEqual> 
                                                </logic:notEqual> 
                                                <logic:equal
							name="bean" property="configuration.cattach" value="1">
							<a
								href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
							${bean.civalue} </a>
						</logic:equal>
						<logic:equal name="bean" property="configuration.cattach" value="4">
						<bean:define id="ei" value="${bean.civalue}"/>
						<logic:notEmpty name="ei">
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(")+1, ei.length()-1)%>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
						</logic:notEmpty>
							</logic:equal>
						</div>
						</td>
						<!-- 版本号 -->
						<td>
						<div class="nowrapDiv"><logic:empty name="bean"
							property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
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
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
</script>
</logic:present>
                    
            <div class="enter">
              <html:form styleId="form"  action="/IGASM0205_Back" onsubmit="return checkSubmit(this);">
                      <html:submit property="btn_back" styleClass="button" value="返回"/>
              </html:form>  
            </div>
		</div>
    </div>
</div>


</div>
</body>
</html:html>