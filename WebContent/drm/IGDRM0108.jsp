<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM0108" toScope="request" />
<bean:define id="title" value="场景信息查看画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<style type="text/css">
.currentPageA{
	text-decoration: none;
	cursor: pointer;
}
.currentPageA a:hover{
	text-decoration: none;
	cursor: pointer;
}
.currentPageA a:link{
	text-decoration: none;
	cursor: pointer;
}
a img{
	border: 0px;
}
.nowrapDiv{
	margin-left: 0px;
}
.leftDiv{
	margin-left: 50px;
}
#flowContainer1 {
	margin-left:0px;
}
#flowContainer1 #flowContentDiv #box{
	margin-left:0px;
}
.table_style3{    
    width:98%;    
    border-collapse:collapse; 
    text-align:right; 
    margin-top:5px;
    margin-left:10px;
    margin-right:10px;   
} 
.table_style4{ 
    width:100%;    
	border-collapse:collapse;
	border:1px solid #959499;
    text-align:left;  
    margin-top:10px;  
   
} 

.table_style4 td{
	border:1px solid #959499;
}
.td_style4 {
		border:0px;
}

</style>
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGDRM0108';
        function toback(){
			window.location.href = getAppRootUrl() + "/IGDRM0104_Back.do";
        }
        function goLook(eiid,v){
        	var url = "/IGASM0341.do?eiid="+eiid+"&eiversion="+v;
        	openSubWindow(url, '_blank', '800', '600');
        }
        function init(){
        	jQuery(".nowrapDiv").each(function (index, item) {
        		if(jQuery(item).text().trim()=="场景应急处置步骤"){
        			jQuery(item).parent().parent().hide();
        		}
        		if(jQuery(item).text().trim()=="定义场景流程ID"){
        			jQuery(item).parent().parent().hide();
        		}
        		if(jQuery(item).text().trim()=="场景类型"){
        			if(jQuery(item).parent().next().next().children("div").text().trim()==0){
        				jQuery(item).parent().next().next().children("div").text("单一场景");
        			}
        			if(jQuery(item).parent().next().next().children("div").text().trim()==1){
        				jQuery(item).parent().next().next().children("div").text("组合场景");
        			}
        		}
        	
        	});
        	//获取流程图编辑器
    		getFlowManger();
		}
        function openSubIGCOM0303(eiid,civersion){
        	param = $H({sp_eiid: eiid,civersion:civersion}).toQueryString();
        	openSubWindow('/IGDRM0702_Detail.do?' + param, '_blank', '1050', '600');
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<%-- <script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script> --%>
<body onload="init();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 场景信息查看</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGDRM0104"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<fieldset>
	<legend>场景基本信息 </legend>
	<div id="results_list">
	<table class="table_style"  style="width: 98%;">
		<tr>
			<th width="10%">场景编号</th>
			<th width="20%">场景名称</th>
			<th width="20%">场景所属机构</th>
			<th width="10%">是否已演练</th>
			<th width="10%">预计恢复时间</th>
			<th width="30%">场景说明</th>
		</tr>
		<tr>
			<td>${IGDRM01081VO.planInfo.eilabel}</td>
			<td>${IGDRM01081VO.planInfo.scename}</td>
			<td>${IGDRM01081VO.planInfo.orgname}</td>
			<td>${IGDRM01081VO.planInfo.isplan}</td>
			<td>${IGDRM01081VO.expectTime}分钟</td>
			<td>${IGDRM01081VO.planInfo.scedes}</td>
		</tr>
	</table>
</div>
</fieldset>
	<fieldset >
	<legend>场景步骤的详细信息</legend>
	<div id="flowDetail" style="margin-left: 0px;"></div>
	</fieldset>
	<c:if test="${IGDRM01081VO.zyList!=null&&fn:length(IGDRM01081VO.zyList)>0 }">	
		<fieldset>
		<legend>应急资源详细信息 </legend>
		<div class="message"><ig:message /></div>
			<div class="TabbedPanelsContent" style="margin-left: 0px;margin-right: 0px;">
				<div class="record_list" style="width: 99%;">
					<table class="table_style2"  >
						<tr>
							<th width="4%"></th>
							<th width="20%" align="center">应急资源编号</th>
							<th width="9%">应急资源名称</th>
							<th width="35%" align="center">应急资源负责人</th>
							<th width="30%" align="center">附件</th>
						</tr>
						<logic:present name="IGDRM01081VO" property="zyList">
							<logic:iterate id="bean" name="IGDRM01081VO" property="zyList" indexId="index">
							<tr >
								<td ></td>
			       	 			<td >${bean.eilabel}</td>
								<td><a class="currentPageA" onclick="openSubIGCOM0303(${bean.eiid},${bean.eiversion })" >${bean.einame }</td>
			       	 			<td >${bean.eiusername }</td>
			       	 			<td>&nbsp; <a href="javascript:void(0)" class="currentPageA" onclick="downLoadAtt('${bean.eiid}','${bean.eiversion }')" > &nbsp;<img title="下载附件" src="images/down.gif"> </a></td>
				       	 	</tr>	
							</logic:iterate>
						</logic:present>
					</table>
				</div>
			</div>
	</fieldset>
	</c:if>
	<fieldset>
<!-- 		<div id="showFlow"></div> -->
		<div id="flowContainer1" ></div>
	</fieldset>
	<div class="enter"><html:button property="btn_back" styleClass="button" value="返回" onclick="toback()"/></div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGDRM01081VO.planInfo.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGDRM01081VO.planInfo.eiversion}" />
	<input type="hidden" id="pdid" value="${IGDRM01081VO.planInfo.scepdid}"/>
</html:form></div>
</div>
</div>


</div>
</body>
<script>
	
	function openSubIGCOM0303(eiid,civersion){
	  	param = $H({sp_eiid: eiid,civersion:civersion}).toQueryString();
	  	openSubWindow('/IGDRM0702_Detail.do?' + param, '_blank', '1050', '600');
	}
	
	function downLoadAtt(eiid,eiversion){
		var ciid ;
		jQ.ajax({
			url:getAppRootUrl()+"/IGDRM0405.do?eiid="+eiid+"&eiversion="+eiversion,
			type:"POST",
			dataType:"text",
			async:false,
			success:function(result){
				ciid = result;
			}
		});
		
		if(ciid&&ciid!="null"){
			var param = "";
			var type = "asm";
			param = $H({type: type, eiid: eiid, ciid:ciid}).toQueryString();
			openSubWindow('/download.do?' + param, '','800','600');
			
		}else{
			alert("附件丢失");
		}
		
	}
	
	//获取流程图编辑器
	function getFlowManger(){
		//只读模式
		var isMask = "1";
		//场景应急处置步骤pdid
		var stepPdid = jQ("#pdid").val();
		//场景类型
		var sceneType = "";
		jQuery(".nowrapDiv").each(function (index, item){
			if(jQuery(item).text().trim()=="场景应急处置步骤"){
// 				stepPdid = jQuery(item).parent().next().next().children("div").text().trim();
       		}
       		if(jQuery(item).text().trim()=="场景类型"){
       			sceneType = jQuery(item).parent().next().next().children("div").text().trim();
       		}
       	});
		if(null!=stepPdid&&""!=stepPdid){
			if(sceneType&&sceneType=='组合场景'){
				
				jQ.ajax({
					type: "post",
					url:"IGDRM0201_Disp.do",
					data:'pgdid='+stepPdid+'&isMask='+isMask,
					async:false,
					dataType:"html",
					success:function(html){
						jQ("#flowContainer1").html(html);
					}
				});
			}else{
				jQ.ajax({
					type: "post",
					url:"IGDRM0107_Disp.do",
					data:'pdid='+stepPdid+'&isMask='+isMask,
					async:false,
					dataType:"html",
					success:function(html){
						jQ("#flowContainer1").html(html);
					}
				});
				//单一场景
				jQ.ajax({
					type: "post",
					url:"IGDRM0108_Detail.do",
					data:'pdid='+stepPdid,
					async:false,
					dataType:"html",
					success:function(html){
						jQuery("#flowDetail").after(html);
					}
				});
			}
		}
	}
	
	function openSOCDetail(id,eiid){
		var url = "IGDRM0430_Disp.do?flag=open&id="+id+"&eiid="+eiid;
		window.showModalDialog(url,null,"dialogWidth:1100px;dialogHeight:600px;status:no;help:no;resizable:yes");
	}
</script>
</html:html>