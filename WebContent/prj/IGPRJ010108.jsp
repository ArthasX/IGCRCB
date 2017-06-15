<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils"%>

<html:html>
<bean:define id="id" value="IGPRJ010108" toScope="request" />
<bean:define id="title" value="项目计划" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	var num = 0;
	var flag = 0;
	
	function wcl(){
		document.getElementById("wc1").style.display='';
		document.getElementById("wc2").style.display='';
	}

	function checkPPTime() {

		if(document.getElementById("ppltitle").value.trim()==""){
			alert("请填写标题！");
			return false;
		}
		if(document.getElementById("ppltitle").value.strlen()>64){
			alert("标题不能大于20个汉字！");
			return false;
		}
		if(document.getElementById("pplopentime").value==""){
			alert("请填写开始时间！");
			return false;
		}
		if(document.getElementById("pplclosetime").value==""){
			alert("请填写结束时间！");
			return false;
		}
		if(document.getElementById("pplclosetime").value<document.getElementById("pplopentime").value){
			alert("计划结束时间不能小于项目结束时间！");
			return false;
		}
		if(document.getElementById("pplclosetime").value>"${igprj0101VO.project.pclosetime}"){
			alert("计划结束时间不能大于项目结束时间！");
			return false;
		}
		if(document.getElementById("pplinfo").value.strlen()>1024){
			alert("描述不能大于320个汉字！");
			return false;
		}
		if(confirm("请确认是否提交项目计划?")){
			return true;
		}
		return false;
		
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
   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back"><a href="#" target="_self" onclick="window.location='IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}';">返回</a></div>
	
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">项目预算：</th>
			<td width="35%">${igprj0101VO.project.pamount}</td>
			<th width="15%" align="right">预算额度：</th>
			<td width="35%">${igprj0101VO.project.plimit}</td>
		</tr>
		
		<tr>
		  <th width="15%" align="right">项目名称：</th>
		  <td >${igprj0101VO.project.pname}</td>
		  <th width="15%" align="right">项目编号：</th>
		  <td width="35%">${igprj0101VO.project.pcode}</td>
		</tr>
		
		<tr>
			<th align="right">开始时间：</th>
			<td>${igprj0101VO.project.popentime}</td>
			<th align="right">结束时间：</th>
			<td>${igprj0101VO.project.pclosetime}</td>
		</tr>
		
		<tr>
			<th align="right">预算用途：</th>
			<td><ig:codeValue ccid="Project_CATEGORY" cid="${igprj0101VO.project.puse}" /></td>
			<th align="right">需求部门：</th>
			<td><ig:codeValue ccid="Project_NEEDBRANCH" cid="${igprj0101VO.project.pbranch}" /></td>
		</tr>
		
		<tr>
			<th align="right">项目状态：</th>
			<td colspan="3"><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${igprj0101VO.project.pstatus}" /></td>
		</tr>
		
		<tr>
		  <th align="right">项目简介：</th>
		  <td colspan="3"><pre>${igprj0101VO.project.pdesc}</pre></td>
		</tr>
		
		<tr>
			<th align="right">项目目的：</th>
			<td colspan="3">${igprj0101VO.project.paim}</td>
		</tr>
		 <tr>
		  <th align="right">项目用途：</th>
		  <td colspan="3"><pre>${igprj0101VO.project.ppurpose}</pre></td>
		 </tr>
	</table>
	</div>
	
	 <div class="title">
		<div class="name">项目计划</div>
		</div>
		<div id="formwrapper">
		<form action="IGPRJ0101_Detail_ProjectPlan.do" method="post" enctype="multipart/form-data">
		
			<div class="record_list"  style="margin-left: 0px;">
	<div class="action"  style="background-color: #e3f3ff;width: 70px;text-align: center;margin-left: 5px;"><a href="#" id="addPlan" onclick="wcl();"><img src="images/xm1.gif" border="0" style="vertical-align:-3px;" />&nbsp;需求分析</a></div>
	<div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm2.gif" border="0" style="vertical-align:-3px;" />&nbsp;立项</div>
	<div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm3.gif" border="0" style="vertical-align:-3px;" />&nbsp;签订合同</div>
	<div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm4.gif" border="0" style="vertical-align:-3px;" />&nbsp;实施</div>
	<div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm5.gif" border="0" style="vertical-align:-3px;" />&nbsp;测试</div>
	<div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm6.gif" border="0" style="vertical-align:-3px;" />&nbsp;验收</div>
	<div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm7.gif" border="0" style="vertical-align:-3px;" />&nbsp;交付</div>	  
	</div>
		<fieldset  id='wc1' style="display: none;">
		

		<div>
	    	<span class="label1" style="width:80px; display:inline-block;"><span class="red">*</span>标题：</span>
	    	<input type="text" name="ppltitle" value="" size="74" />
	    	<input type="hidden" name="pplversion" value="1"/>
	    	<input type="hidden" name="confirmTime" value="N"/>
	       	<input type="hidden" name="confirmDesc" value="N" />
	       	<input type="hidden" name="pplstatus" value="A" />
			<input type="hidden" name="pid" value="${igprj0101VO.project.pid}" /><br />
			<span class="label1" style="width:80px; display:inline-block;"><span class="red">*</span>开始时间：</span>
			<input type="text" name="pplopentime" value="" size="20" readonly="readonly"/>
	       	<img src="images/date.gif" onClick="calendar($('pplopentime'))" border=0 style="cursor: hand;" />
	       	<span class="label1" style="width:80px; display:inline-block;"><span class="red">*</span>结束时间：</span>
	       	<input type="text" name="pplclosetime" id="pplclosetime" value="" size="19" readonly="readonly" />
	       	<img src="images/date.gif" onClick="calendar($('pplclosetime'))" border=0 style="cursor: hand;" /><br />
	       	<span class="label1" style="width:80px; display:inline-block;vertical-align:top;" >描述：</span>
	       	<textarea name="pplinfo" cols="54" rows="5"></textarea>
	       	
	    </div>
    <div>
		<span class="label1"  style="width:80px; display:inline-block;">附件信息：</span>
		<input type="hidden" name="pplriskatt" value="${projectplan.pplriskatt }"/>
		<img src="images/attachment.gif" /><a href="javascript:addFile();" id="aAddAttach">添加附件</a><br>
       	<table id="tb" style="height: 50px;"></table> 
	</div>
		<div >

			<input type="hidden" name="popentime" value="${igprj0101VO.project.popentime}" />
			<input type="hidden" name="pclosetime" value="${igprj0101VO.project.pclosetime}" />
			<input type="hidden" name="pltype" value="P" /><!-- 记录是否已经建立计划 -->
			<input type="hidden" name="pplstatus" value="A" />
			<input type="hidden" name="pplversion" value="1" />
		</div>
		
		
		</fieldset>
		
		<div class="enter" id='wc2' style="display: none;">
		<input type="submit" id="submitPlan" value="提交" class="button" onclick="return checkPPTime();">
		<input type="button" value="返回" class="button" onclick="window.location='IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}';">
		</div>
		
		
		</form>
		</div>
		
		
	  </div>
	   </div>   
	</div>
     



</div>
</body>
</html:html>