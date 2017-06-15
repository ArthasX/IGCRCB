<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ taglib uri="/tags/struts-html" prefix="html" %> --%>
<%-- <%@ taglib uri="/tags/struts-bean" prefix="bean" %> --%>
<%-- <%@ taglib uri="/tags/struts-logic" prefix="logic" %> --%>
<%-- <%@ taglib uri="/tags/ig-tags" prefix="ig" %> --%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0104" toScope="request"/>
<bean:define id="title" value="场景资产查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<script src="<html:rewrite forward='tree.js'/>"></script>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<style type="text/css">
	a img{
		border: 0px;
	}
	.hover{
		background-color: #d3d3d3;
		cursor: pointer;
		
	}
	.leftd{
		text-align: left;
	}
</style>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 	<div id="location">
                <div class="image"></div>
                  <p class="fonts1">
                  <ig:navigation extname1="${urlable}"/>
<!-- 业务连续性 >> 场景管理 >> 场景维护 -->
                  </p>
     </div> 

    <!--content  右侧内容-->
    <div id="contentWrap">  
    <html:form action="IGDRM0104" method="POST">
<!-- 			<div  style="width:200px;float:left;border:0px; border:1px solid #D4EEFD;height:520px;padding-top: 10px;background-color: #EFF6FC"> -->
<!-- 				<div class="conditions" > -->
<!-- 						<div id="treeBox" style="height: 300px;margin-left:10px;"></div> -->
<!-- 		        </div> -->
<!-- 		    </div> -->
		    <!-- 左侧内容 -->
        <div id="content" style="float:left;height:520px; margin-left: 10px;padding-top: 10px;">
        <div id="search" style="width:970px;">
        <div class="img"></div>
        <div class="conditions" >
						
						<table>
							<tr><td>场景编号:</td>
								<td><html:text property="eilabel" styleId="eilabel"></html:text></td>
								<td>场景名称：</td>
				        		<td>
				        			<html:text property="einame" styleId="einame"/>
				        		</td>
								<td>场景负责人:</td>
								<td><html:text property="eiusername" styleId="eiusername"></html:text></td>
								<td>应急资源:</td>
								<td><html:text property="assest" styleId="assest" readonly="true"></html:text>
									<html:hidden property="assesteiid" styleId="eiid" />
									<img src="images/tree.gif" style="cursor: hand;" alt="应急资源" width="16" height="16" border="0" onclick="selectEMEntityForm()"/>
								</td>
							</tr>
							<tr>
							<td>场景类型:</td>
							<td>
								<html:select property="senceClassify" styleId="senceClassify">
									<html:option value=""></html:option>
									<html:option value="0">应急场景</html:option>
									<html:option value="1">演练场景</html:option>
								</html:select>
							</td>	
								<td>参与人:</td>
								<td><html:text property="participants" styleId="participants"></html:text></td>
							<td align="center"><html:submit styleClass="button" styleId="btnSub">查询</html:submit></td></tr>
							
						</table>
		        </div>
		    </div>
		    <div id="results_list" >
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th width="10%">场景编号</th>
	       		<th width="12%">场景名称</th>
	       		<th width="8%">场景负责人</th>
<!-- 	       		<th width="7%">是否需要升版</th> -->
	       		<th width="10%">创建日期</th>
	       		<th width="8%">是否已演练</th>
	       		<th width="8%">场景分类</th>
	       		<th width="6%">版本</th>
	       		<th width="5%">复制</th>
	       		<th width="5%">修订</th>
	       		<th width="5%">策略</th>
	       	</tr>
	       	 <logic:present name="IGDRM01041VO" property="planList" >
	       	 	<logic:iterate id="bean" name="IGDRM01041VO" property="planList" indexId="index">
	       	 		<tr class="<ig:rowcss index="${index}"/>">
	       	 			<td class="">${bean.eilabel}</td>
							<td>
<%-- 							<a href="/InfoGovernor/IGDRM0108_Disp.do?eiid=${bean.eiid}">${bean.einame }</a> --%>
							<html:link action="/IGDRM0108_Disp.do?eiid=${bean.eiid}">${bean.einame }</html:link>
							</td>
	       	 			<td >${bean.eiusername }</td>
	       	 			<td>${bean.eiinsdate }</td>
	       	 			<td>${bean.isplan }</td>
	       	 			<td>
	       	 				<c:if test="${bean.senceClassify == '0' }">
	       	 					应急场景
	       	 				</c:if>
	       	 				<c:if test="${bean.senceClassify == '1' }">
	       	 					演练场景
	       	 				</c:if>
	       	 			</td>
	       	 			<td>V${bean.eiversion }.0</td>
	       	 			<td>
	       	 				<a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01305&ptid=19&parameters=${bean.eiid}&actname=ACT23CCM0301" title="复制"  ><img src="images/copy.gif"/></a>
	       	 			</td>
	       	 			<td>
	       	 				<logic:equal name="bean" property="needrise" value="1"> 
		       	 				<a href="#" title="该组合场景资产需要升版" onclick="openEditPage('${bean.eiid}','/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01441&ptid=20&parameters=${bean.eiid}')" ><img src="images/edit_update.gif"/></a>
		       	 			</logic:equal>
		       	 			<logic:notEqual name="bean" property="needrise" value="1"> 
		       	 				<a href="#" title="修订" onclick="openEditPage('${bean.eiid}','/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01441&ptid=20&parameters=${bean.eiid}')" ><img src="images/edit.gif"/></a>
		       	 			</logic:notEqual>
	       	 			</td>
	       	 			<td>
	       	 				<c:if test="${bean.senceClassify == '0' }">
	       	 					<a href="IGDRM0119_Search.do?senceid=${bean.eiid}" title="策略"  ><img src="images/copy.gif"/></a>
	       	 				</c:if>
	       	 			</td>
	       	 		</tr>
	       	 	</logic:iterate>
	       	 </logic:present>
	       </table>
		 </div>
		<div id="operate" style="float:left;margin-left:10px;">
			 <!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
			 <!-- /paging -->
		</div>
    </div>
    </html:form>
</div>
</div>
</div>
<script type="text/javascript">	
 function setEntity(){
	
		var url = "IGCIM1203_ENTITY_TREE.do?levelnode=999030&ecategory=017";
		var alertMessage = '当前分类不可用,请选择最底层分类';

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			 jQuery("#txtPlanType").val('');
			 document.forms[0].esyscoding.value = "";
			 return false;
		 }
		if(null!=temp && temp.split("|").length>1){
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			if(syscode_eid .length<=12)
			{
				alert(alertMessage);
				return false;
				
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			 jQuery("#txtPlanType").val(name);
			document.forms[0].esyscoding.value = syscode;
		}		
	}
 
 //选择机构
 function setOrg(){
		var temp = window.showModalDialog('IGSYM0101_TREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].eiorgsyscoding.value = "";
			document.forms[0].orgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
			document.forms[0].orgname.value = temp.split("|")[1];
		}		

	}
 function showView(eiid){
	 window.location.href=getAppRootUrl()+'/IGDRM0104_Disp.do?eiid='+eiid+'&mode=view';
 }
 
 
 jQuery(function(){
	 var nodeMap = eval('(${IGDRM01041VO.nodeMapJson})');
	 //初始化树
	 if (document.getElementById){
			var tree = new WebFXTree(nodeMap['999060'].name);
			tree.eid = nodeMap['999060'].id;
			tree.setBehavior('classic');
			
			for(var k in nodeMap['999060'].childTreeNodeMap){
				 loadTree(tree,nodeMap['999060'].childTreeNodeMap[k]);
			}
			 jQuery("#treeBox").html(tree.toString());
				tree.expandAll();
				tree.expandRootChildren();
				 getSelNode(tree,jQuery("#esyscoding_like").val());

		}
	 //绑定树的点击事件
	 jQuery("#treeBox a").click(function(event){
			
			if (tree.getSelected()){
				document.forms[0].esyscoding_like.value=tree.getSelected().eid;
				document.forms[0].submit();
			}
			event.stopPropagation();
			
	});
	 jQuery("#treeBox").click(function(){
		 getSelNode(tree,jQuery("#esyscoding_like").val());
	 });
	 jQuery(".table_style tr:not(:first)").hover(function(){
		 jQuery(this).addClass("hover");
	 },function(){
		 jQuery(this).removeClass("hover");
	 });
 });
 
 	function getSelNode(node,esyscoding){
 		if(node.eid==esyscoding){
 			node.select();
 			document.getElementById("eilabel").focus();
 		}else{
 			for(var i=0;i<node.childNodes.length;i++){
 				getSelNode(node.childNodes[i],esyscoding);
 			}
 		}
 	}
	function loadTree(parentNode,obj){
		if(obj.id!='999060'){
			
			var newNode = new WebFXTreeItem(obj.name);
			newNode.eid = obj.id;
			parentNode.add(newNode);
			if(obj.childTreeNodeMap){
				for(var k in obj.childTreeNodeMap){
					loadTree(newNode,obj.childTreeNodeMap[k]);
				}
			}
		}
	}
	
	function openEditPage(eiid, url) {
		//设置请求的Action
		igAjax.ajaxAction = "/IGDRM0104_Ajax.do";
		//是否异步    false：同步    true：异步
		igAjax.asynchronous = false;
		//提交方式    "POST"    "GET"
		igAjax.method = "POST";
		//参数列表
		igAjax.parameters = {
			"eiid":eiid
		};
		var tflag = "";
		//回调函数
		igAjax.back = function(req, json){
			 var result=req.responseText;
			 if(result != null && result != ""){
				 tflag = result;
			 };
		};
		//执行
		igAjax.doAjax();
		
		if (tflag == "1") {
			alert("该预案正在修订中！");
		} else {
			window.location.href=getAppRootUrl()+url;
		}
	}
	//打开应急资源查询页面
	function selectEMEntityForm(eiids){
		openSubWindow('/IGDRM0402.do?openFlag=1&eiidNotIn='+eiids+'&sign=1&hasAClear=1', '', '850', '600');
	}
	function setParamIGDRM04023(result) {
		if(result == "resetAll"){
			jQuery("#assest").val("");
			jQuery("#eiid").val("");
		}else{
			jQuery("#assest").val(result.split("_EIID_")[1].split("_SOC_")[0]);
			jQuery("#eiid").val(result.split("_EIID_")[0]);
		}
	}
		

</script>
</body>
</html:html>