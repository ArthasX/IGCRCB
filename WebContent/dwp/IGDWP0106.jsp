<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDWP0106" toScope="request" />
<bean:define id="title"	value="分派画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<style type="text/css">
.currentTable{
	width:540px;
	margin-top:10px; 
    border-collapse:collapse;     
    table-layout:fixed;  
}

.currentTable tr th{
	background-color: #eeeeee;
	text-align: left;
}
.img_cl{
	cursor: pointer;
}
</style>
<script type="text/javascript">
<!--
	jQuery(document).ready(function(){
		var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
		jQuery(".img_cl").click(function(){
			if(jQuery(this).attr("src") == "images/plus.gif"){
				jQuery(this).parent().parent().parent().find("tr[name='content']").each(function(i,o){
					jQuery(o).show();
				});
				jQuery(this).attr("src","images/minus.gif");
				jQuery(this).attr("alt","收起");
			}else{
				jQuery(this).parent().parent().parent().find("tr[name='content']").each(function(i,o){
					jQuery(o).hide();
				});
				jQuery(this).attr("src","images/plus.gif");
				jQuery(this).attr("alt","展开");
			}
		});
		jQuery(".checkbox_cl").click(function(){
			jQuery(this).parent().parent().parent().find("input[type='checkbox']").attr("checked",this.checked);
		});
		jQuery("#but_submit").click(function(){
			<logic:present name="IGDWP01061VO" property="assignInfoMap">
			<logic:iterate id="map" name="IGDWP01061VO" property="assignInfoMap">
			<c:if test="${map.key.assignflag == '1' }">
				if(jQuery("input[type='checkbox'][name='participants'][value^='${map.key.psdid }_']:checked").length == 0){
					alert("请选择${map.key.psdname}的人！");
					return false;
				}
			</c:if>
			</logic:iterate>
			</logic:present>
			if(window.confirm("是否确认提交?")){
				return true;
			}else{
				return false;
			}
		});
	});
//-->
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
</div>
<html:form action="/IGDWP0106.do" onsubmit="return checkSubmit(this);">
<logic:present name="IGDWP01061VO" property="assignInfoMap">
<div id="TabbedPanels1" class="TabbedPanels">
	<ul class="TabbedPanelsTabGroup">
		<logic:iterate id="map" name="IGDWP01061VO" property="assignInfoMap">
			<li class="TabbedPanelsTab" tabindex="0">
				<c:if test="${map.key.assignflag == '1' }">
					<span class="red">*</span>
				</c:if>
				${map.key.psdname }
			</li>
		</logic:iterate>
	</ul>
	<div class="TabbedPanelsContentGroup">
		<logic:iterate id="map" name="IGDWP01061VO" property="assignInfoMap">
			<div class="TabbedPanelsContent">
				<logic:iterate id="roleMap" name="map" property="value">
					<table class="currentTable" id="${map.key.psdid }_${roleMap.key.roleid}">
						<tr>
							<th style="width:30px;">
								<input type="checkbox" class="checkbox_cl"/>
							</th>
							<th colspan="3" style="width:480px;">${roleMap.key.rolename }</th>
							<th width="30px;">
								<img alt="收起" src="images/minus.gif" class="img_cl">
							</th>
						</tr>
						<logic:present name="roleMap" property="value">
							<logic:iterate id="user" name="roleMap" property="value">
								<tr name="content">
									<td style="width:30px;">
										<input type="checkbox" name="participants" value="${map.key.psdid }_${roleMap.key.roleid}_${user.userida }"/>
									</td>
									<td style="width:160px;">${user.username }</td>
									<td style="width:160px;">${user.usermobile }</td>
									<td style="width:160px;">${user.orgname }</td>
									<td style="width:30px;"></td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</logic:iterate>
			</div>
		</logic:iterate>
	</div>
</div>
<div style="margin-left:10px;">
	<html:hidden property="prid"/>
	<html:hidden property="planid"/>
	<html:submit styleClass="button" value="提交" styleId="but_submit"/>
	<html:reset styleClass="button" value="重置"/>
</div>
</logic:present>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>