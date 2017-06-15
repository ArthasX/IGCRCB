<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFXK0704" toScope="request" />
<bean:define id="title" value="提示查询信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script language="JavaScript" src="/js/prototype-1.5.0.js" type="text/javascript" charset="gbk"></script>
<script type=text/javascript src="ueditor/ueditor.config.bbs.js"></script>  
<script type=text/javascript src="ueditor/ueditor.all.js"></script>
<script>
window.UEDITOR_HOME_URL = "/ueditor";
var editor = new UE.ui.Editor({
	readonly:true
});

</script>
<style>
fieldset div {
	
	margin-bottom:2px;
	margin-top: 2px;
	margin-left: 0px;
}
.table_s{    
    width:600px;    
    margin:0 auto;    
    border-collapse:collapse;     
    text-align:center; 
    table-layout:fixed;  
    float:left;
    margin-top:2px;

}    
.table_s th{ 
	color:#000000;   
    border-bottom:1px solid #CCCCCC; 
    background-color:#EEEEEE;
    height:17px;      
}    
.table_s td{ 
    border-bottom:1px solid #D3D3D3;
    height:18px;
    word-break: break-all; 
    word-wrap:break-word;
}  
</style>
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
<p class="fonts1">风险管理 &gt;&gt; 风险提示管理 &gt;&gt;风险提示查询
</p>
<div class="back"><html:link href="IGFXK0701_Back.do">返回</html:link></div>
</div>
<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><legend>风险提示查询结果</legend>
	<div><label for="Name"><strong>下发者姓名</strong>：</label>
	 <p class="p2">&nbsp;&nbsp;<bean:write property="nusername" name="IGFXK0700Form"/></p><br />
	</div>
	<div>
	<label for="Name"><strong>下发者部门</strong>：</label> 
	<p class="p2">&nbsp;&nbsp;<bean:write property="norgname" name="IGFXK0700Form"/></p><br />
	</div>
	
	<div>
		<label for="Name"><strong>下发人员联系方式</strong>：</label> 
		
		<p class="p2">&nbsp;&nbsp;<bean:write property="ntel" name="IGFXK0700Form"/></p><br />
	</div>
	<div>
		<label for="Name"><strong>风险提示名称</strong>：</label>
		<p class="p2">&nbsp;&nbsp;<bean:write property="rwname" name="IGFXK0700Form"/></p><br />
	</div>
	<div>
		<label for="Name"><strong>下发日期</strong>：</label> 
		<p class="p2">&nbsp;&nbsp;<bean:write property="ntime" name="IGFXK0700Form"/></p><br />
	</div>
	
	<div>
		<label for="Name"><strong>下发方式</strong>：</label>
		<logic:equal property="type"   value="0" name="IGFXK0700Form">
		<p class="p2">&nbsp;&nbsp;按部门下发</p><br />
		</logic:equal>
		<logic:equal property="type"   value="1" name="IGFXK0700Form">
		<p class="p2">&nbsp;&nbsp;按人员下发</p><br />
		</logic:equal>
						<br>
		
		
	</div>
	<div>
		<label for="Name"><strong>风险提示描述</strong>：</label> 
		<html:textarea styleId="myEditor" property="rwcontext" name="IGFXK0700Form"  style="float: left;height:200px;width:700px;margin-left:140px;"></html:textarea>
					<script type="text/javascript">
					    editor.render("myEditor");
					</script> 
				<br />
	
	
	</div>
	<logic:equal property="type"   value="0" name="IGFXK0700Form">
	 	<div>
	 	 <label for="Name"><strong>接收部门</strong>：</label>
			<table class="table_s" id="orgtraa">
				<tr>
					<th style="display:none" width="25%">部门ID</th>
					<th width="100px">部门名称</th>
				</tr>
				<logic:present name="IGFXK07012VO" property="acceptuserList">
				<logic:iterate id="bean" name="IGFXK07012VO" property="acceptuserList" indexId="index">
				<tr>
					<td style="display:none">${bean.aporgid}</td>
					<td width="100px">${bean.aporgname}</td>
				</tr>
				</logic:iterate>
			</logic:present>
			</table>
		</div>
		</logic:equal>
	<logic:equal property="type"   value="1" name="IGFXK0700Form">
	<div>
	 <label for="Name"><strong>接收人员</strong>：</label>
		<table class="table_s" id="usera">
			<tr>
				<th width="25%">人员ID</th>
				<th width="25%">人员姓名</th>
				<th width="25%">部门名称</th>
			</tr>
			<logic:present name="IGFXK07012VO" property="acceptuserList">
				<logic:iterate id="bean" name="IGFXK07012VO" property="acceptuserList" indexId="index">
				<tr>
					<td>${bean.apuserid}</td>
					<td>${bean.apusername}</td>
					<td>${bean.aporgname}</td>
				</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
		</logic:equal>
    				
	       
	               <logic:notEmpty name="IGFXK0700Form" property="attachmentList">	
	<div><label for="Name"><strong>附件</strong>：</label>
	                 <table id="tb2">		   
				    <logic:iterate id="attachment" name="IGFXK0700Form" property="attachmentList"
				              indexId="index">
				               <tr id="${attachment.attid}"><td>	
				               <img src="images/attachment.png" />			         
						       <html:link action="/IGSYM0502_loadFIle.do?attid=${attachment.attid}"  styleId='attach${attachment.attid}'>				       
						       <bean:define id="attname" name="attachment" property="attname" />						       
								<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>						  							
								</html:link> 									
								</td></tr>							
				    </logic:iterate>
				    </table>
								     
		<br/>
	</div>	 
	    </logic:notEmpty>	
</fieldset>   
	<div class="enter">
</div>
</div>
</div>

</div>

<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>