<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGFIN0108" toScope="request" />
<bean:define id="title" value="项目查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">
function setParentValue(pid,pcode,pname){
    if(!window.opener.closed){
        window.opener.setPrjParams(pid, pcode, pname);
     }
    window.close();
}
function clearParentValue(){
    if(!window.opener.closed){
        window.opener.setPrjParams("", "", "");
     }
    window.close();
}
</script>
<body style="background-image: none;background-color: #FFFFFF;">


<!--container  内容-->



   <div id="location">
       <div class="img"></div>
        <p class="fonts1">项目查询</p>
    </div>
     <div id="search">
      <html:form action="/IGFIN0108.do">
         <div class="img"></div>
          <div class="conditions">
      <div>
       <span>项目名称：</span><html:text name="IGPRJ0101Form" property="pname" styleId="pname" errorStyleClass="inputError imeDisabled" size="15"/>&nbsp;&nbsp;
       <span>时间：</span><span>从</span><html:text name="IGPRJ0101Form" property="popentime" styleId="popentime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
       <img src="images/date.gif" onClick="calendar($('popentime'))" />&nbsp;&nbsp;
        <span>到</span><html:text name="IGPRJ0101Form" property="pclosetime" styleId="pclosetime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
       <img src="images/date.gif" onClick="calendar($('pclosetime'))" />&nbsp;&nbsp;
       <span>状态：</span><label><html:select name="IGPRJ0101Form" property="pstatus" style="width: 50px;">
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
       </html:form>
    </div>
        
     
     <div id="results_list">
       <table class="table_style" >
			<tr>
			  <th width="5%" >序号</th>
			  <th width="20%">项目编号</th>
			  <th width="30%">项目名称</th>
			  <th width="15%">项目金额</th>
			  <th width="10%">起始时间</th>
			  <th width="10%">结束时间</th>
			  <th width="10%">状态</th>
			</tr>
        	<logic:present name="IGPRJ0101VO" property="voList">
			<logic:iterate id="bean" name="IGPRJ0101VO" property="voList" indexId="index" >
	         <tr class="<ig:rowcss index="<%=index %>"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="javaScript:setParentValue('${bean.pid }','${bean.pcode }','${bean.pname }')">
	           <td>${PagingDTO.viewStartCount+index}</td>
	           <td>${bean.pcode}</td>
	           <td>${bean.pname}</td>
	           <td><ig:codeValue ccid="Project_ISUSEBUDGET" cid= "${bean.isUseBudget}" isChild="true"/></td>
	           <td>${bean.popentime}</td>
	           <td>${bean.pclosetime}</td>
	           <td><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${bean.pstatus }" /></td>
	         </tr>
		      </logic:iterate>
		      </logic:present>
       </table>
     </div>
     <div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
		<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</body>
</html:html>