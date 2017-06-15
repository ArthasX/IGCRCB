<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0310" toScope="request" />
<bean:define id="title"  toScope="request" >
<bean:message bundle="asmResources" key="ietitle.IGCIM0310"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
body,html{background-color: #FFFFFF;
      background-image: none;
     }
</style>
<body>
<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0310.assetconfig"/></div>
</div>
<div class="message"><ig:message /></div>
					<div class="record_list">
					<table class="table_style2">
						<tr>
							<th width="10%">NO.</th>
							<th width="20%"><bean:message bundle="asmResources" key="title.IGCIM0310.einame"/></th>
							<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0310.eiversion"/></th>
						</tr>
					<logic:present name="IGCIM03081VO" property="entityItemVWInfoMap">
						<logic:iterate id="map" name="IGCIM03081VO" property="entityItemVWInfoMap" indexId="number">
						<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
						<logic:iterate id="bean" name="list" indexId="index">
							<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
								<!-- 编号 -->
								<td>
								<div class="nowrapDiv">
								${index+1}
								</div>
								</td>
								<!-- 名称 -->
								<td>
								<div class="nowrapDiv">
								${bean.einame}
								</div>
								</td>
								<!-- 版本号 -->
								<td>
								<div class="nowrapDiv">${bean.eiversion}</div>
								</td>
							</tr>
							</logic:iterate>
							</logic:iterate>
			</logic:present>
					</table>
			</div>
	<div class="enter">
		<input type="button" class="button" value="<bean:message bundle="asmResources" key="button.IGCIM0310.close"/>" onclick="window.close();">
	</div>

</body>
</html:html>