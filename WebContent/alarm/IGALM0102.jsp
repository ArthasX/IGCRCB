<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.soc.alarm.vo.IGALM01021VO"%>
<html:html>
<bean:define id="id" value="IGALM0102" toScope="request" />
<bean:define id="title" toScope="request">
	指标模板管理
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	WebCalendar.timeShow   = false;          //是否返回时间

	function fun_Import(){
        if($F("xmlFile") == "") {
        	alert("请选择XML文件！");
            return false;
        }
        form.action = getAppRootUrl() + "/IGALM0102_Import.do";
       	return true;
	}

	function seeServers(fileid){
		window.location = getAppRootUrl() + "/IGALM0301_Search.do?fileid="+fileid+"&flag=yes";
	}
	function deleteRec(obj){
		if(checkNum(obj)==0){
			alert("请选择删除对象！");
	        return false;
		}
	    
	    if( window.confirm("确认删除吗？")){
	        form.action = getAppRootUrl() + "/IGALM0102_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}
</script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGALM0102" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<!-- 文件名 -->
	<span>文件名：</span>
	<span> <html:text
		property="filename_like" styleId="filename_like"
		errorStyleClass="inputError imeDisabled" size="20" maxlength="255"
		tabindex="2"></html:text>
	</span>&nbsp;
	<!--开始,结束时间-->
	 <span>开始时间：</span> 
	 <span><html:text property="uploadtime_begin" readonly="true" /></span>
	  <img src="images/date.gif" align="middle" style="cursor: pointer;"
		onClick="calendar($('uploadtime_begin'))" border="0" />
	 <span>&nbsp;&nbsp;结束时间：</span>
	 <span><html:text property="uploadtime_end" readonly="true" /></span> 
		<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('uploadtime_end'));" />&nbsp;&nbsp;
	 <span><html:submit property="btn_search" styleClass="button" >查询</html:submit></span>
	 <br/>
	 <span>XML文件：</span>
	 <span><html:file property="xmlFile" styleId="xmlFile"  errorStyleClass="inputError imeDisabled" size="30"/>
	 </span>&nbsp;
	 <span><html:submit property="btn_import" styleClass="button" value="上传" onclick="return fun_Import();" /></span>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" >
		<tr>
			<th width="4%">
					<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteId')"/> </label>
			</th>
			<th width="35%">文件名</th>
			<th width="35%">上传路径</th>
			<th width="20%">上传时间</th>
		</tr>
		<logic:present name="IGALM01021VO" property="igalm0102List">
			<logic:iterate id="bean" name="IGALM01021VO"
				property="igalm0102List" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>
							<html:checkbox property="deleteId" value="${bean.fileid}"/>
					</td>
					<td><a href="javascript:seeServers('${bean.fileid}');" target="_self">${bean.filename}</a></td>
					<td>${bean.filepath}</td>
					<td>${bean.uploadtime}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGALM01021VO" property="igalm0102List" >
                            <html:submit property="btn_delete"  styleClass="button" onclick="return deleteRec('deleteId');" >
                        		删除
                            </html:submit>
                            </logic:present>
		<!-- paging --> 
		<jsp:include page="/include/paging.jsp" />
	</div>
	
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>