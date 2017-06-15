<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>

<script type="text/javascript">	
	var num=0;
	function addFile() 
	{
		currRow=tb.insertRow();
		cell=currRow.insertCell();
		cell.innerHTML= "<input type='file' name='attachFile["+num+"]' class='inputbutton'><input type='hidden' name='rlattkey'/><input type='button' class='delbutton' value='删除' onclick='deleteitem(this)'>";
		num++;
	}
	
	function deleteitem(obj)
	{
		var curRow= obj.parentNode.parentNode;
		tb.deleteRow(curRow.rowIndex);
	}
	function submitForm(){  
		if($F('plinfo').strlen()>512){
			alert("项目说明不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
			return false;
		}
		
		if(confirm("是否确认提交")){
			return true;
		}
		return false;
	}
</script>

<html:html>
<bean:define id="id" value="IGPRJ010103" toScope="request" />
<bean:define id="title" value="项目关闭" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
	 <!--content  右侧内容-->
	 
<div id="contentWrap">
   <div id="content">
  	<div id="location">
	<div class="image"></div>
	<p class="fonts1">查看 &gt;&gt; 项目关闭</p>
	<div class="back"><a href="#" target="_self" onclick="window.location='IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}';">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">使用预算：</th>
			<td width="35%"><ig:codeValue ccid="Project_ISUSEBUDGET" cid="${igprj0101VO.form.isUseBudget}" /></td>
			<th width="15%" align="right">项目状态：</th>
			<td width="35%"><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${igprj0101VO.form.pstatus}" /></td>
		</tr>
		
		<c:if test="${igprj0101VO.form.isUseBudget == '0001'}">
		<tr>
			<th width="15%" align="right">预算名称：</th>
			<td width="35%">${igprj0101VO.form.pbname}</td>
			<th width="15%" align="right">预算金额：</th>
			<td width="35%"><bean:write name="igprj0101VO" property="form.pamount" format="##.##"></bean:write></td>
		</tr>
		</c:if>

		<tr>
		  <th width="15%" align="right">项目名称：</th>
		  <td >${igprj0101VO.form.pname}</td>
		  <th width="15%" align="right">项目金额：</th>
		  <td width="35%"><bean:write name="igprj0101VO" property="form.plimit" format="##.##"></bean:write></td>
		</tr>	
		
		<tr>
		  <th align="right">项目编号：</th>
		  <td><pre>${igprj0101VO.form.pcode}</pre></td>
			<th align="right">计划结束时间：</th>
			<td>${igprj0101VO.form.pplanclosetime}</td>
		</tr>
		
		<tr>
			<th align="right">开始时间：</th>
			<td>${igprj0101VO.form.popentime}</td>
			<th align="right">实际结束时间：</th>
			<td>${igprj0101VO.form.pclosetime}</td>
		</tr>
		
		<tr>
			<c:if test="${igprj0101VO.form.isUseBudget == '0001'}">
			<th align="right">预算用途：</th>
			<td><ig:codeValue ccid="Project_CATEGORY" cid="${igprj0101VO.form.puse}" /></td>
		  	<th align="right">需求部门：</th>
			<td><ig:codeValue ccid="Project_NEEDBRANCH" cid="${igprj0101VO.form.pbranch}" /></td>
			</c:if>
			<c:if test="${igprj0101VO.form.isUseBudget == '0002'}">
			<th align="right">需求部门：</th>
			<td colspan="3"><ig:codeValue ccid="Project_NEEDBRANCH" cid="${igprj0101VO.form.pbranch}" /></td>
			</c:if>
		</tr>
	
		<tr>
		  <th align="right">项目简介：</th>
		  <td colspan="3"><pre>${igprj0101VO.form.pdesc}</pre></td>
		</tr>
		
		<tr>
			<th align="right">项目目的：</th>
			<td colspan="3">${igprj0101VO.form.paim}</td>
		</tr>
		 <tr>
		  <th align="right">项目用途：</th>
		  <td colspan="3"><pre>${igprj0101VO.form.ppurpose}</pre></td>
		  </tr>
	</table>
	</div>
	
 <div class="title">
	<div class="name">关闭说明</div>
	</div>
	<div id="formwrapper">
	<form action="IGPRJ0101_Detail_Close.do" method="post" enctype="multipart/form-data">
	<fieldset>
	<ig:message />
	<div><textarea name="plinfo" cols="60" rows="8"></textarea> <br />
	</div>
    <div >
		<img src="images/attachment.gif" />
		<a href="javascript:addFile();" id="aAddAttach">添加附件</a>
   		<table id="tb">
        </table>
	</div>
	<div>
	<input type="hidden" name="isUseBudget" value="${igprj0101VO.form.isUseBudget}" />
	<input type="hidden" name="paim" value="${igprj0101VO.project.paim}" />
	<input type="hidden" name="ppurpose" value="${igprj0101VO.project.ppurpose}" />
	<input type="hidden" name="pbranch" value="${igprj0101VO.form.pbranch}" />
	<input type="hidden" name="pplanclosetime" value="${igprj0101VO.form.pplanclosetime}" />
	<input type="hidden" name="plimit" value="${igprj0101VO.form.plimit}" />
	
	<input type="hidden" name="pid" value="${igprj0101VO.project.pid}" />
	<input type="hidden" name="ptype" value="${igprj0101VO.project.ptype}" />
	<input type="hidden" name="pcode" value="${igprj0101VO.project.pcode}" />
	<input type="hidden" name="pname" value="${igprj0101VO.project.pname}" />
	<input type="hidden" name="pdesc" value="${igprj0101VO.project.pdesc}" />
	<input type="hidden" name="popentime" value="${igprj0101VO.project.popentime}" />
	<input type="hidden" name="pclosetime" value="${igprj0101VO.project.pclosetime}" />
	<input type="hidden" name="pstatus" value="C" />
	<input type="hidden" name="porg" value="${igprj0101VO.project.porg}" />
	<input type="hidden" name="prole" value="${igprj0101VO.project.prole}" />
	<input type="hidden" name="puser" value="${igprj0101VO.project.puser}" />
</div>
	
	</fieldset>
		<div class="enter">
		<input type="submit" value="提交" class="button" onclick="return submitForm();">
	<input type="reset" value="返回" class="button" onclick="window.location='IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}';">
	<div class="Placeholder"></div>
		</div>
	</form>
	</div>
  </div>
   </div>  
   
 
</div>
</div>
</body>
</html:html>