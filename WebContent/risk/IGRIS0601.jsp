<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGRIS0601" toScope="request" />
<bean:define id="title" value="检查项管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%

	Map<Integer,String> stopbuttonmap = new HashMap<Integer,String>();
	Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("stopbuttonMap")){
		stopbuttonmap = (Map)request.getAttribute("stopbuttonMap");
	}
	if(null!=request.getAttribute("startbuttonMap")){
		startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	}
	
%>

<!-- /header1 -->
<script type="text/javascript">	
         var gid='IGRIS0601';
         //删除所选
        function deleteRec(){
             var message ='<bean:message key="IGCO10000.E002"/>';
             var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="检查项基本信息" />';
             var frm = window.document.forms[0];
             if(frm.deleteEiid) {
     	        if(frm.deleteEiid.length > 0){
     	            var bchecked = false;
     	            for( i=0; i<frm.deleteEiid.length; i++ ){
     	                if (frm.deleteEiid[i].checked == true){
     	                    bchecked = true;
     	                }
     	            }
     	            if (!bchecked) {
     	            	alert(message);
     	                return false;
     	            }
     	        } else {
     	          if ($("deleteEiid").checked == false){
     	              alert(message);
     	              return false;
     	          }  
     	        }
             } else {
             	alert("没有可删除的数据！");
                 return false;
             }

             if( window.confirm(confirmMsg)){
                 form.action = getAppRootUrl() + "/IGRIS0614_Del.do";
                 return true;
             } else {
                 return false;
             }
     	}
        function setEntity(obj) {
    		var temp = obj.value;
    		var name = obj.options[obj.selectedIndex].text; 
    		if (null != temp && temp != '') {
    		    var syscode_eid = temp.split("|")[0];
    			var syscode;
    			var eid;
    			if (syscode_eid == "999") {
    				alert("资产模型不可用！请选择其他模型！");
    				return false;

    			} else if (syscode_eid.split("_").length > 1) {
    				eid = syscode_eid.split("_")[0];
    				syscode = syscode_eid.split("_")[1];
    			}
    			//获取风险点编号前几位,类似“IG-D0101”
    			document.forms[0].syscoding.value = temp;
    		}
    	}
function checkitem(eid,version){
	window.location.href="IGRIS0604_Disp.do?eiid="+eid+"&eiversion="+version+"&looksign=1";
}

function changeStatus(eiid){
	if(confirm("是否改变状态？")){
		window.location.href="IGRIS0604_Status.do?eiid="+eiid;
	}
	
}
</script>
<script type="text/javascript">	
function showArea(id, name){
    removeShowRlComment();
	var text = jQuery("#"+id).val();
	if(text){
		var event = window.event;
		//新激活图层
	    var newDiv = document.createElement("div");
	    newDiv.id = "rlshowvaluediv";
	    newDiv.style.top = (event.clientY + document.documentElement.scrollTop) + "px";
	    newDiv.style.left = (parseInt(document.body.scrollWidth) - 340) / 2 + "px"; // 屏幕居中
	    var str = "<div id='title'><div id='fountDiv'>"+name+"</div><div id='imgDiv' onclick='removeShowRlComment();'><img src='images/title-delete.gif' width='20' height='20'/></div></div>";
	    newDiv.innerHTML = str + "<div id='content'><pre>" + text + "</pre></div>";
	    document.body.appendChild(newDiv);   
	} 
}

function removeShowRlComment(){
	if(jQuery("#rlshowvaluediv").length > 0){
		jQuery("#rlshowvaluediv").remove();
	}
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style type="text/css">
.rlcomment{cursor: hand;}
#rlshowvaluediv{
	word-wrap:break-word;
	position:absolute;
	z-index: 9999;
	width: 400px;
	min-height: 50px;
	background-color: #eee;
	border:1px solid #ccc;
}
#rlshowvaluediv #title{
	width:395px;
	height:23px;
	line-height:23px;
	font-weight: bold;
	background:url(images/title-23.gif);
	padding-left:5px;
}
#rlshowvaluediv #title #fountDiv{
	width:100px;
	height:23px;
	float: left;
}
#rlshowvaluediv #title #imgDiv{
	width:30px;
	height:23px;
	float: right;
	padding-top:3px;
	cursor: hand;
}
#rlshowvaluediv #content{
	width:395px;
	padding:5px;
	line-height: 20px;
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
					<html:form styleId="form" action="/IGRIS0601"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								信息安全 &gt;&gt; 检查项管理 &gt;&gt; 检查项管理
							</p>
						</div>
						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span style="font-size: 15px;"><strong>查询条件</strong></span>

								</div>
								<div style="margin-top: 4px">
									<span class="subscribe">检查项分类：</span>
									<html:select property="syscoding" style="width: 130px;" styleId="ename" onchange="setEntity(this)">
							    		<html:options collection="labelAndValueList" property="value" labelProperty="label"/>
							    	</html:select>	
									<span class="subscribe">检查项名称：</span>
									<html:text property="einame" styleId="einame" />
									<html:submit property="btn_search" style="margin-left:5px"
										styleClass="button" value="查询" />
								</div>
							</div>
						</div>

						<div id="results_list">
							<ig:message />
							<table class="table_style">
								<!-- header部 -->

								<tr>
									<th width="2%">
										<label> <input type="checkbox"
											style="width: 20px;" name="allbox" id="allbox"
											onclick="selectAll('allbox','deleteEiid')" />
										</label>
									</th>
									<th width="10%">检查项分类</th>
									<th width="16%">检查项名称</th>
									<th width="28%">检查项说明</th>
									<th width="28%">检查方法</th>
									<th width="8%">状态</th>
									<th width="8%">操作</th>
								</tr>

								<logic:present name="IGRIS06071VO" property="itemList">
									<logic:iterate id="bean" name="IGRIS06071VO"
										property="itemList" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">

											<td><input type="checkbox" style="width: 20px;"
												name="deleteEiid" value="${bean.eiid}" /></td>
											<td>${bean.riskitem }</td>
											<td>${bean.einame }</td>
											<td class="rlcomment" onclick="showArea('jcxsm_${index}','检查项说明')">${fn:substring(bean.eidesc,0,20)}${fn:length(bean.eidesc)>20?'...':''}
											<textarea style="display:none;" rows="6" cols="60" id="jcxsm_${index}">${bean.eidesc }</textarea></td>
											<td class="rlcomment" onclick="showArea('jcff_${index}','检查方法')"><ig:CheckitemMethodDefined eiid="${bean.eiid}"  count="20" />
											<textarea style="display:none;" rows="6" cols="60" id="jcff_${index}"><ig:CheckitemMethod eiid="${bean.eiid}"  /></textarea></td>
											<td>
												<c:if test="${bean.eistatus == 1}">
													<a href="javascript:changeStatus(${bean.eiid});"><img src="images/stop.gif" border="0" alt="点击后停用"/></a> 
												</c:if>	
												<c:if test="${bean.eistatus != 1}">
													<a href="javascript:changeStatus(${bean.eiid});"><img src="images/start.gif" border="0" alt="点击后启用"/></a>
												</c:if>	
											</td>
											
											<td><a href="javascript:void(0)"
												onclick="checkitem('${bean.eiid}','${bean.eiversion }')"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改"/></a></td>
										</tr>

									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">

							<logic:present name="IGRIS06071VO" property="itemList">
								<html:submit property="btn_delete" value="删除所选"
									styleClass="button" onclick="return deleteRec();" />
							</logic:present>
							<jsp:include page="/include/paging.jsp" />
						</div>
						<html:hidden property="syscoding" />
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>