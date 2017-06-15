<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRJ0101" toScope="request" />
<bean:define id="title" value="项目查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function deletePrj(){	
	if(confirm("请确认是否删除项目?")){
		return true;
	}else{
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
    <html:form action="/IGPRJ0101.do">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 项目管理 &gt;&gt; 项目查询</p>
    </div>
     <div id="search">
         <div class="img"></div>
          <div class="conditions">
      <div>
       <span>项目名称：</span><html:text property="pname" styleId="pname" errorStyleClass="inputError imeDisabled" size="15"/>&nbsp;&nbsp;
       <span>时间：从</span><html:text property="popentime" styleId="popentime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
       <img src="images/date.gif" onClick="calendar($('popentime'))" border=0 />&nbsp;&nbsp;
        <span>到</span><html:text property="pclosetime" styleId="pclosetime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
       <img src="images/date.gif" onClick="calendar($('pclosetime'))" border=0 />&nbsp;&nbsp;
       <span>状态：</span><label><html:select property="pstatus" style="width: 50px;">
       	 <ig:optionsCollection ccid="PROJECT_STATUS_CODE"
			 isMakeBlankRow="true"
			isCodeLabel="true" />  
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
           <th width="3%" >序号</th>
           <th width="20%">预算名称</th>
           <th width="7%">预算金额</th>
           <th width="23%">项目名称</th>
           <th width="7%">项目金额</th>
           <th width="9%">项目编号</th>
           <th width="8%">使用预算</th>
           <th width="6%">起始时间</th>
           <th width="6%">结束时间</th>
           <th width="5%" >状态</th>
           <th width="3%" >修改</th>
           <th width="3%" >删除</th>
         </tr>
        <logic:present name="IGPRJ0101VO" property="voList">
		<logic:iterate id="bean" name="IGPRJ0101VO" property="voList" indexId="index" >
		        <tr>
		           <td>${PagingDTO.viewStartCount+index}</td>
		           <td colspan="2">
		           <table width="100%" style="border:0px;">
		           		<logic:present name="bean" property="pbsummaryList">
		           			<logic:iterate id="binfo" name="bean" property="pbsummaryList">
		           				<tr>
		           					<td width="77%" style="border:0px;">${binfo.btitle }</td>
		           					<td width="23%" style="border:0px;">${binfo.bamount }</td>
		           				</tr>
		           			</logic:iterate>
		           		</logic:present>
		           </table>
		           </td>
		           <td><a href="#" onclick="doLook('IGPRJ0101_Detail.do?pid=${bean.pid}');" >${bean.pname}</a></td>
		           <td><bean:write name="bean" property="plimit" format="##.##"></bean:write></td>
		           <td>${bean.pcode}</td>
		           <td>
		           <ig:codeValue ccid="Project_ISUSEBUDGET" cid= "${bean.isUseBudget}" isChild="true"/>
		           </td>
		           <td>${bean.popentime}</td>
		           <td>${bean.pclosetime}</td>
		           <td><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${bean.pstatus}" /></td>
		           <td>
					<a href="IGPRJ0901_EDIT.do?pid=${bean.pid}"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改"/></a>
		           </td>
		           <td><html:link action="/IGPRJ0101_Del.do?pid=${bean.pid}" onclick="return deletePrj();">
		           <img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></html:link></td>
		         </tr>         
         </logic:iterate>
         </logic:present>
         
       </table>
     </div>
<div id="operate">
	<jsp:include page="/include/paging.jsp" />
</div>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>