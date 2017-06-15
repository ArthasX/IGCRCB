<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2004" toScope="request" />
<bean:define id="title" toScope="request" value="Domain添加画面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(obj,flag){
        var message ="请选择删除对象！";
        var arg0= "导入实体";
        var confirmMsg = "请确认是否要进行"+arg0+"删除处理?";
        var mode="0";
		if(flag=="1"){
			//message = '请选择添加导入实体。';
		    message ="请选择添加导入实体。";
			//confirmMsg = '请确认是否要进行角色添加处理?';
			confirmMsg = "请确认是否要进行导入实体添加处理?";
			mode="1";
		}
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
        if(window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGASM2004.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}
function toback(){
	form.action = getAppRootUrl() + "/IGASM2003.do?org.apache.struts.taglib.html.CANCEL=1";
	form.submit();
}
//-->
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
	<p class="fonts1">资产管理 &gt;&gt;Domain管理 &gt;&gt;Domain管理
		&gt;&gt;Domain明细
		</p>
	<div class="back"><a href="javascript:toback();" target="_self">返回</a></div>
	</div>

	<html:form styleId="form" action="/IGASM2004" onsubmit="return checkSubmit(this);">
	<div class="role_title">已有实体</div>
	<div id="results_list">
	<!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style4" align="left" style="width: 100%">
		<tr>
			<th width="10%"><input type="checkbox"
				name="checkbox" id="checkbox"
				onclick="selectAll('checkbox','owneiddids')" /></th>
			<th width="20%">实体名</th>
			<th width="10%">导入版本</th>
			<th width="20%">导入文件名</th>
			<th width="20%">创建时间</th>
			<th width="10%">包含关系图</th>
			<th width="10%">拓扑图</th>
		</tr>

		<logic:present name="IGASM20041VO" property="ownImportVersion">
			<logic:iterate id="bean" name="IGASM20041VO"
				property="ownImportVersion" indexId="index"
				type="com.deliverik.framework.asset.model.ImportVersionInfo">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:checkbox property="owneiddids"
						value="${bean.impversion};${bean.impeiname}" /> </label></td>
					<td><logic:empty name="bean" property="impeiname">&nbsp;</logic:empty>${bean.impeiname}
					</td>
					<td><logic:empty name="bean" property="impversion">&nbsp;</logic:empty>${bean.impversion}
					</td>
					<td><logic:empty name="bean" property="impfilename">&nbsp;</logic:empty>${bean.impfilename}
					</td>
					<td><logic:empty name="bean" property="impcreatetime">&nbsp;</logic:empty>${bean.impcreatetime}
					</td>
					<!-- 包含关系图 -->
                    <td>
                    
                    <c:if test='${bean.belongcount != null && bean.belongcount > 0}'>
                   
                       <div class="nowrapDiv">
                              <a href="javascript:void(0)" onclick="openSubIGASM0346('${bean.entityItemTB.eirootmark}','${bean.entityItemTB.eiid}','${bean.entityItemTB.eiversion}','${bean.entityItemTB.eismallversion}')"><img src="images/relationships.gif" alt='包含关系' width="16" height="16"  border="0"/></a>
                        </div>
                        </c:if>
				        <c:if test='${bean.belongcount == null || bean.belongcount == "0"}'>
				            <img src="images/unrelationships.gif" alt='没有包含关系' width="16" height="16"  border="0"/>
				        </c:if>
                    </td>
					 <td>
				         <c:if test='${bean.eircount != null && bean.eircount > 0}'>
	                          <a href="javascript:void(0)" onclick="openSubIGCOM0310('${bean.impeiid}','${IGASM2004Form.eiddid}','${IGASM2004Form.eiddversion}','${IGASM2004Form.updatetime}')"><img src="images/relationships.gif" alt='拓扑图' width="16" height="16"  border="0"/></a>
				          </c:if>
				         <c:if test='${bean.eircount == null || bean.eircount == "0"}'>
	                          <img src="images/unrelationships.gif" alt='没有拓扑关系' width="16" height="16"  border="0"/>
				          </c:if>			                               
			        </td>
				</tr>
			</logic:iterate>
		</logic:present>

	</table>
	</div>
	<div id="operate"><logic:present name="IGASM20041VO"
		property="ownImportVersion">
		<span> <html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec('owneiddids','0');" value="删除所选"/>
			</span>
	</logic:present></div>
	
	
	<div class="role_title">可选实体</div>
			<div id="results_list">
			<table class="table_style4" align="left" style="width: 100%">
				<tr>
					<th width="10%">
					<input type="checkbox" name="checkbox_other" id="checkbox_other"
						onclick="selectAll('checkbox_other','eiddids')" /></th>
					<th width="22%">实体名</th>
					<th width="22%">导入版本</th>
					<th width="22%">导入文件名</th>
					<th width="22%">创建时间</th>
				</tr>
				<logic:present name="IGASM20041VO" property="otherImportVersion">
				<logic:iterate id="bean" name="IGASM20041VO" indexId="index" property="otherImportVersion"
					type="com.deliverik.framework.asset.model.ImportVersionInfo">
					<tr class="<ig:rowcss index="${index}"/>">
						<td><label> <html:checkbox property="eiddids"
							value="${bean.impversion};${bean.impeiname}" /> </label></td>
						<td><logic:empty name="bean" property="impeiname">&nbsp;</logic:empty>${bean.impeiname}
						</td>
						<td><logic:empty name="bean" property="impversion">&nbsp;</logic:empty>${bean.impversion}
						</td>
						<td><logic:empty name="bean" property="impfilename">&nbsp;</logic:empty>${bean.impfilename}
						</td>
						<td><logic:empty name="bean" property="impcreatetime">&nbsp;</logic:empty>${bean.impcreatetime}
						</td>
					</tr>
				</logic:iterate>
				</logic:present>
			</table>
			</div>
		<div id="operate"><logic:present name="IGASM20041VO" property="otherImportVersion">
		<span> <html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec('eiddids','1');" value="添加所选"/>
			</span>
	</logic:present></div>
	<html:hidden property="eiddid" />
	<html:hidden property="eiddversion" />
</html:form>
<div class="Placeholder"></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>