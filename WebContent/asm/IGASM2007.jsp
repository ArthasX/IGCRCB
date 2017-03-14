<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2007" toScope="request" />
<bean:define id="title" toScope="request" value="导入对象信息管理界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
	    var message ="请选择删除对象！";
	    var arg0  = "导入对象基本信息";
	    var alertMsg= "没有可删除的数据。";
	    var confirmMsg ="请确认是否要进行"+arg0+"删除处理?";
	    var frm = window.document.forms[0];
    	if(frm.deleteImpeiid) {
        	if(frm.deleteImpeiid.length > 0){
           	 	var bchecked = false;
            	for( i=0; i<frm.deleteImpeiid.length; i++ ){
                	if (frm.deleteImpeiid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
            	alert(message);
                return false;
            }
        } else {
          if ($("deleteImpeiid").checked == false){
        	  alert(message);
              return false;
          }  
        }
    } else {
    	alert(alertMsg);
        return false;
    }
	
    if( window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGASM2007_Del.do";
        return true;
    } else {
        return false;
    }
}
	function changeStatus(impversion,impeiname){
		//"是否改变状态？"
		if(confirm("是否改变状态？")){
			var form = document.getElementById("form");
			form.action="ChangeDeleteflag.do?impversion=" + impversion +"&impeiname_eq="+impeiname;
			form.submit();
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGASM2007"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">资产管理 &gt;&gt; 导入管理&gt;&gt; 对象管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; 实体名称： </label> <html:text
		property="impeiname_like" styleId="impeiname_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21"
		name="IGASM2007Form" /> &nbsp;&nbsp; <html:submit
		property="btn_search" styleClass="button" value="查询"/>
		</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<!--<th width="4%"><label> </label></th>-->
			<th width="15%">实体名称</th>
			<th width="10%">版本号</th>
			<th width="10%">顶级CI类型</th>	
			<th width="12%">导入时间</th>
			<th width="12%">导入文件名</th>	
			<th width="8%">调整</th>
			<th width="10%">历史版本</th>	
			<!-- 	
			<th width="8%">详细信息</th>
			<th width="8%">修改</th>
			-->
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM20071VO" property="importVersionInfoList">
			<logic:iterate id="bean" name="IGASM20071VO"
				property="importVersionInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!--
					<td><html:checkbox property="deleteImpeiid"
						value="${bean.impeiname}_${bean.impversion}" /></td>
						-->
					<!-- 实体名称 -->
					<td>
					<div class="nowrapDiv">${bean.impeiname}</div>
					</td>
					<!-- 版本号-->
					<td>
					<div class="nowrapDiv">${bean.impversion}</div>
					</td>
					<!-- 顶级CI类型 -->
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<!-- 导入时间-->
					<td>
					<div class="nowrapDiv">${bean.impcreatetime}</div>
					</td>
					<!-- 导入文件名-->
					<td>
					<div class="nowrapDiv">${bean.impfilename}</div>
					</td>
					<!-- 调整-->
					<td>
					<div class="nowrapDiv">
					<logic:equal name="bean" property="deleteflag" value="0">
						<a href="javascript:changeStatus('${bean.impversion}','${bean.impeiname}');"> <img
							src="images/stop.gif" border="0"
							alt="停用" />
						</a>
					</logic:equal> 
					<logic:equal name="bean" property="deleteflag" value="1">
						<a href="javascript:changeStatus('${bean.impversion}','${bean.impeiname}');"> <img
							src="images/start.gif" border="0"
							alt="启用" />
						</a>
					</logic:equal>
					</div>
					</td>
					 <!-- 历史版本 -->
			          <td>
			          <div class="nowrapDiv">
                          <html:link action="/IGASM2011_Disp.do?impeiname=${bean.impeiname}&&impversion=${bean.impversion}"><img src="images/notepad_16x16.gif" alt="显示历史版本" width="16" height="16"  border="0"/></html:link>
			          </div>
			          </td>
					<!-- 详细信息 -->
					<!-- 
					<td>
					<div align="center"><html:link
						action="/###.do?impeiname=${bean.impeiname}&&impversion=${bean.impversion}">
						<img src="images/xx.gif"
							alt="显示详细信息"
							width="16" height="16" border="0" />
					</html:link></div>
					</td>
					 -->
					<!-- 修改 -->
					<!-- 
					<td>
					<div align="center"><html:link
						action="/###.do?impeiname=${bean.impeiname}&&impversion=${bean.impversion}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></div>
					</td>
					 -->
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGASM20071VO"
		property="importVersionInfoList">
		<!--  
		<html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec();" value="删除" />
		-->
	</logic:present> 
	<!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>