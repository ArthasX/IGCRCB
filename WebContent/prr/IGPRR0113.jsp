<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0113" toScope="request" />
<bean:define id="title" value="参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function toSave(){
        if(window.confirm("您是否确认提交？")){
		    return true;
        } else {
            return false;
        }
	}

	function selectAlert(obj) {
		if(obj.value == '${IGPRR0113Form.ppsuperid}_') {
			alert("主办部门不能删除！");
			obj.checked = true;
		}
	}

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
<html:form styleId="form" action="/IGPRR0113" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">参与者</p>
</div>
	<div id="results_list"><ig:message />
	<table class="table_style4" align="left" style="width:300px;">
			<tr>
				<th width="30%"><label></label>
				</th>
				<th width="40%">角色名称</th>
			</tr>
			<logic:present name="IGPRR01131VO" property="roleList">
				<logic:iterate id="bean" name="IGPRR01131VO" property="roleList">
					<tr>
					  <td width="30%"><LABEL><html:multibox styleId="checkbox_${bean.roleid}" property="participants" value="${bean.roleid}_" onclick="selectAlert(this)"/></LABEL></td>
					  <td width="70%">${bean.rolename}<c:if test="${bean.roleid == IGPRR0113Form.ppsuperid}">(主办部门)</c:if></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRR01131VO"
		property="roleList">
		<bean:size id="lst_count" name="IGPRR01131VO" property="roleList"/>
		<c:if test="${lst_count > 0}">
			<span><html:submit property="btn_save" value="提交" styleClass="button"  onclick="return toSave();"/></span>
			<span><html:reset property="btn_reset" value="重置" styleClass="button"/></span>
		</c:if>
	</logic:present>
	</div>
	<html:hidden property="prid" styleId="prid" name="IGPRR0113Form"/>
	<html:hidden property="psdmode" styleId="psdmode" name="IGPRR0113Form"/>
	<html:hidden property="roleid" styleId="roleid" name="IGPRR0113Form"/>
	<html:hidden property="prstatus" styleId="prstatus" name="IGPRR0113Form"/>
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0113Form"/>
	<html:hidden property="psdassign" styleId="psdassign" name="IGPRR0113Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>