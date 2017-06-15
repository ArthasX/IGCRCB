<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html:html>
<bean:define id="id" value="IGCIM1632" toScope="request"/>
<bean:define id="title" value="密码影响分析" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->

<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 	<div id="location">
          <div class="image"></div>
          <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 密码关系</p>
          <div class="back"><html:link href="javascript:toback();">返回</html:link></div>
    </div> 

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
        <!--  message -->
                   <ig:message/>
            <!--  /message -->
        <html:form styleId="form" action="IGCIM1632_Delete"  onsubmit="return checkForm()"> 
      
        <div style="text-align: center;">
 			<fieldset>
 				<legend>CI基本信息</legend>
 				<br/>
				<bean:define id="entityItem" name="IGCIM16321VO" property="entityItemData"></bean:define>
 				<table width="100%" class="table_style">
 					<tr>
 						<th>CI分类</th>
 						<th>搜索代码</th>
 						<th>名称</th>
 						<th>管理人</th>
 						<th>采集时间</th>
 						<th>更新时间</th>
 					</tr>
 					<tr>
 						<td>${entityItem.ename }</td>
 						<td>${entityItem.eilabel}</td>
 						<td>${entityItem.einame }</td>
 						<td>${entityItem.eiusername }</td>
 						<td>${entityItem.eiinsdate}</td>
 						<td>${entityItem.eiupdtime}</td>
 					</tr>
 				</table>
 				<html:hidden property="eiid" value="${entityItem.eiid }"/>
 			</fieldset>
 			<logic:present name="IGCIM16321VO" parameter="soc0119List">
 			<c:if test="${fn:length(IGCIM16321VO.soc0119List)>0 }">
 			
			<fieldset>
 				<legend>密码关系</legend>
 				<br/>
 				<table width="100%" class="table_style">
 					<tr>
 						<th width="10%"><input type="checkbox" onclick="cheClick(this)"/></th>
 						<th width="18%">相关CI搜索代码</th>
 						<th width="18%">相关CI名称</th>
 						<th width="14%">登记日期</th>
 						<th width="40%">说明</th>
 					</tr>
 					<logic:iterate id="bean" name="IGCIM16321VO" property="soc0119List">
	 					<tr>
	 						<td><html:checkbox property="deleteEirid" value="${bean.eirid }"/> </td>
	 						<td>${bean.cldEntityItemVW.eilabel }</td>
	 						<td>${bean.cldEntityItemVW.einame}</td>
	 						<td>${bean.eirupdtime }</td>
	 						<td>${bean.eirdesc }</td>
	 					</tr>
 					</logic:iterate>
 				</table>
 				
 			</fieldset>
 		
 			
 				<html:submit styleClass="button" style="margin-top:10px;" >删除所选</html:submit>
 				</c:if>
 				</logic:present>
 				&nbsp;&nbsp;&nbsp;
 				<html:button styleClass="button" onclick="toAdd(${entityItem.eiid })" style="margin-top:10px;" property="btn_add">新增关系</html:button>
 			
 			</div>
 			</html:form>
		 </div>
    </div>
</div>


</div>
	<script type="text/javascript">	

	function cheClick(obj){
		jQuery(":checkbox").attr("checked",jQuery(obj).attr("checked"));
		//,jQuery(obj).attr("checked");
	}
	
	function toback(){
		form.action = getAppRootUrl() + "/IGCIM1631_Back.do";
    	form.submit();
	}
	function toAdd(eiid){
	//	openSubWindow("/IGCIM1611_Disp.do","_blank","400","500");
		form.action = getAppRootUrl()+"/IGCIM1633_Edit.do?eiid="+eiid;
		form.submit();
	}
	function checkForm(){
		if(jQuery(":checkbox[checked=true]").length==0){
			alert("请选择将要删除的关联关系");
			return false;
		}
		if(!confirm("请确认删除选择的业务系统关系!")){
			return false;
		}
	}
	</script>
</body>
</html:html>