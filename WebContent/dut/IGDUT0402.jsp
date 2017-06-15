<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDUT0402" toScope="request" />
<bean:define id="title" value="延时解锁管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript"> 
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgname_eq.value = temp.split("|")[1];
	}		

}
//删除所选
function deleteRec(obj){
	var message = '<bean:message key="IGCO10000.E002"/>';
    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="延时解锁信息" />';
	if(checkNum(obj)==0){
		alert(message);
        return false;
	}
    if(window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGDUT0402_Del.do";
        return true;
    } else {
        return false;
    }
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

	 <!--content  右侧内容-->
	 
<div id="contentWrap">
   <div id="content">
    <html:form styleId="form" action="/IGDUT0402.do">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 延时、解锁管理</p>
    </div>
     <div id="search">
         <div class="img"></div>
          <div class="conditions">
      <div>
       <span>申请单位：</span><html:text name="IGDUT0402Form" property="orgname_eq" readonly="true"></html:text>
			<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>&nbsp;&nbsp;
       <span>日期时间：从</span><html:text property="datetime_from" styleId="datetime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
       <img src="images/date.gif" onClick="calendar($('datetime_from'))" border=0 />&nbsp;&nbsp;
        <span>到</span><html:text property="datetime_to" styleId="datetime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
       <img src="images/date.gif" onClick="calendar($('datetime_to'))" border=0 />&nbsp;&nbsp;
       <span>申请（标题）：</span><label><html:select name="IGDUT0402Form" property="title_like" style="width: 50px;">
       	<html:options collection="titleList" property="value" name="" labelProperty="label" />
       </html:select>
       </label>
       <span>
       <input name="search" type="submit" class="button" value="查询"  />
       </span>    
       </div>
      </div>
    </div>
        
     
     <div id="results_list">
     <ig:message />
       <table class="table_style" >
         <tr>
           <th width="5%"><label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteId')"/> </label>
		   </th>
           <th width="10%">日期时间</th>
           <th width="8%">申请单位</th>
           <th width="8%">行长</th>
           <th width="8%">行长电话</th>
           <th width="8%">经理</th>
           <th width="8%">经理电话</th>
           <th width="8%">操作人</th>
           <th width="20%">备注</th>
           <th width="5%">修改</th>
         </tr>
         
         
         <logic:present name="IGDUT04021VO" property="delayList">
			<logic:iterate id="bean" name="IGDUT04021VO" property="delayList" indexId="index" >
        <tr>
           <td>
            <label>
            <html:checkbox property="deleteId" value="${bean.id}"/>
			</label>
		   </td>
           <td>${bean.datetime}</td>
           <td>${bean.orgname}</td>
           <td>${bean.hzname}</td>
           <td>${bean.hztel}</td>
           <td>${bean.jlname}</td>
           <td>${bean.jltel}</td>
           <td>${bean.operater}</td>
           <td>${bean.remark}</td>
           <td>
           	<html:link action="/IGDUT0401_Edit_Disp.do?id=${bean.id}">
				<img src="images/edit.gif" alt="修改" width="16" height="16" border="0" />
			</html:link>
		   </td>
         </tr>
         
         </logic:iterate>
         </logic:present>
         
       </table>
     </div>
<div id="operate">
	<logic:present name="IGDUT04021VO"
		property="delayList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteId');" /></span>
	</logic:present> 
	<jsp:include page="/include/paging.jsp" />
</div>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>