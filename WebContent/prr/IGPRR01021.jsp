<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<script type="text/javascript">
<!--
	jQuery(document).ready(function(){
		jQuery(".rlcomment").click(function(){
			removeShowRlComment();
			var $value = jQuery(this).find("[name='rlShowValue']").val();
			if($value){
				var event = window.event;
				//新激活图层
			    var newDiv = document.createElement("div");
			    newDiv.id = "rlshowvaluediv";
			    newDiv.style.top = (event.clientY + document.documentElement.scrollTop) + "px";
			    newDiv.style.left = (parseInt(document.body.scrollWidth) - 340) / 2 + "px"; // 屏幕居中
			    var str = "<div id='title'><div id='fountDiv'>处理记录</div><div id='imgDiv' onclick='removeShowRlComment();'><img src='images/title-delete.gif' width='20' height='20'/></div></div>";
			    newDiv.innerHTML = str + "<div id='content'><pre>" + $value + "</pre></div>";
			    document.body.appendChild(newDiv);   
			}
		});
	});
	function removeShowRlComment(){
		if(jQuery("#rlshowvaluediv").length > 0){
			jQuery("#rlshowvaluediv").remove();
		}
	}
//-->
</script>
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
<logic:present name="IGPRR01021VO" property="voList">
	<bean:size id="number" name="IGPRR01021VO" property="voList"/>
	<c:if test="${number > 0}">
	<div class="record_list" style="width:98%;margin-left:auto;margin-right:auto;">
		<div class="title">
	    	<div class="name">相关流程</div>
	    </div> 
	    <table cellspacing="2" class="table_style">
	    	<tr>
               <th width="20%">工单号</th>
               <th width="15%">流程名称</th>
               <th width="15%">流程类型</th>
               <th width="15%">发起时间</th>
               <th width="15%">状态</th>
               <th width="15%">处理人</th>
            </tr>
           	<logic:iterate id="element" name="IGPRR01021VO" property="voList">
           		<bean:define id="bean" name="element" property="info"/>
           		<tr>
                    <td>
          				<logic:equal value="P" name="element" property="type">
          					<img src="images/parentProcess.gif" align="middle" alt="主流程"/>
          				</logic:equal>
          				<logic:equal value="C" name="element" property="type">
          					<img src="images/childProcess.gif" align="middle" alt="子流程"/>
          				</logic:equal>
          				&nbsp;&nbsp;
	                    <a href="javascript:void(0)" onclick="openRelatedProcess('${bean.prid}','${bean.prtype}')">
	                    ${bean.prserialnum} </a>
                    </td>
                    <td>${bean.prtitle}</td>
                    <td>${bean.prpdname}</td>
                    <td>${bean.propentime}</td>
                    <td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
                    <td><ig:processDisposePersonValue prid="${bean.prid}" prstatus="${bean.prstatus}"/></td>
                </tr>
           	</logic:iterate>
	    </table>
	</div>
	</c:if>
</logic:present>
	<logic:present name="IGPRR01021VO" property="recordLogMap">
	<logic:equal name="IGPRR01021VO" property="hasCLRecord" value="1">
	<div class="title">
	<div class="name" onclick="tabbedPanel()" style="cursor: pointer;">日志信息<img id="loginfo" src="images/addd.gif" width="10" height="10" border="0"/>
	</div>
	</div>
	
	<div style="margin-top:-30px; margin-right: 27px; float: right;">
		<table>
			<tr>
				<td>
					<logic:present name="IGPRR0112Form" property="prid">
						<bean:define id="prid" name="IGPRR0112Form" property="prid"/>
					</logic:present>
					<a href="javascript:openProcessInfoLog(${prid })" class="a1">查看表单日志</a>
				</td>
			</tr>
		</table>
	</div>
	        <div id="TabbedPanels1" class="TabbedPanels" style="display:none;">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
			<c:if test="${map.key=='处理类日志'}">
				<li class="TabbedPanelsTab" tabindex="0" id="${map.key}" >
					${map.key}
				</li>
			</c:if>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup">
		    <logic:present name="IGPRR01021VO">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
				<c:if test="${map.key=='处理类日志'}">
				<bean:define id="logList" name="map" property="value" type="java.util.List" />
				<div class="TabbedPanelsContent">
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<tr>
						<th width="15%">状态</th>
						<th width="15%">部门</th>
						<th width="40%">内容</th>
						<th width="10%">处理人</th>
						<th width="10%">操作</th>
						<th width="10%">处理时间</th>
					</tr>
				</table>
				</div>
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<logic:iterate id="recordLog" name="logList" indexId="index" >	
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<td width="15%">${recordLog.psname}</td>
							<td width="15%">${recordLog.rlorgname}</td>
							<td width="40%" align="left" class="rlcomment">
							<pre><ig:SubstringShowEllipsisWriteTag len="100" showEllipsis="true"><bean:write name="recordLog" property="rlcomment" filter="false" /></ig:SubstringShowEllipsisWriteTag></pre>
							<textarea style="display:none;" rows="6" cols="60" name="rlShowValue">${recordLog.rlcomment }</textarea>
							<logic:present name="recordLog" property="attachmentList">
									<logic:notEmpty	name="recordLog" property="attachmentList">
										<bean:define id="attachmentList" name="recordLog" property="attachmentList" type="java.util.List" />
										<logic:iterate id="attachment" name="attachmentList" indexId="number">
											<html:link
												action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
												<bean:define id="attname" name="attachment" property="attname" />
												<%= attname.toString().substring(attname.toString().indexOf("_")+1) %>
											</html:link>
											<br />
										</logic:iterate>
									</logic:notEmpty>
							</logic:present>
							</td>
							<td width="10%">${recordLog.rlusername}</td>
							<td width="10%">${recordLog.rldesc}</td>
							<td width="10%"><SPAN class="red">${recordLog.rltime}</SPAN></td>
						</tr>
					</logic:iterate>
				</table>
				</div>
			</div>
			</c:if>
			</logic:iterate>
			</logic:present>
		</div>
		</div>
		<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			function tabbedPanel(){
				var path=jQuery("#loginfo").attr("src");
				if(path=="images/redu.gif"){
					jQuery("#loginfo").attr("src","images/addd.gif");
					jQuery("#TabbedPanels1").toggle();
				}else{
					jQuery("#loginfo").attr("src","images/redu.gif");
					jQuery("#TabbedPanels1").toggle();
				}
				
				//bullet_delete.png
				//////jQuery("#TabbedPanels1").hide();
			}
			//-->
		</script>
	</logic:equal>
	</logic:present>