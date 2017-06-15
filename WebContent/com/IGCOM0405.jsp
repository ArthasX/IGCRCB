<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.vo.IGCOM04051VO" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG677Info" %>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList"%>
<%
	IGCOM04051VO igcom04051vo = (IGCOM04051VO)request.getAttribute("IGCOM04051VO");
	List<IG677Info> ProcessRecordInitForMeList = igcom04051vo.getProcessRecordInitForMeList();
	List<IG677Info> processRecordInfoForMeList = igcom04051vo.getProcessRecordInfoForMeList();
	Map<String,String> urlMap = igcom04051vo.getUrlMap();
%>

<html:html>
<bean:define id="id" value="信息科技风险管理平台" toScope="request" />
<bean:define id="title" value="首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<style type="text/css">
	body {
		margin: 0px;
		padding: 0px;
	}
	
	.octmain {
		height: 798px;
		width: 1000px;
		margin-right: auto;
		margin-left: auto;
	}
	.octhead {
		height: 79px;
		width: 1000px;
		background-image: url(images/ywindex/headbg.png);
		background-repeat: no-repeat;
	}
	.octnav {
		height: 409px;
		width: 1000px;
		background-image: url(images/ywindex/navbg.png);
		background-repeat: no-repeat;
		background-position: left top;
	}
	.octcont {
		height: 310px;
		width: 1000px;
		background-image: url(images/ywindex/contbg.png);
	}
	
#business_top{
	background:url(../images/business_top.gif);
	background-repeat:no-repeat
}
#business_top  p{
    color:#565656;
    font-size:14px;
	font-weight: 600;
	margin-top:10px;
	margin-left:40px;
}
</style>
<script type="text/javascript">
	function showMove(obj,url){
		obj.src="images/"+url;
	}
	function show(url){
		var obj = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if(obj != null){ 
			window.location.href = obj;
		}
    }
	function openNewWindow(userid){
		openSubWindow('/IGSYM0204.do',"newpage","1000","600");
		
	}
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
	//弹出签到签出对话框
	function checkinout(flag){
			var url = null;
			//签到-->
			if(flag == 1){
				url = '/IGUCI0101_Disp.do';
				}else{
					//签出
					if(flag == 2){
						url = '/IGUCI0102_Disp.do'
						}
					}
			openSubWindow(url, 'newpage', '800', '300');
		 }
	 //按钮置灰	
	   function initcheckio(){
	   		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=checkIo',onSuccess:  function(req, json){
	  			 var result=req.responseText;
	   			 //显示签到
	   				if(result == 1){
	   					//蓝色签到
	  					var pic1 = document.getElementById("pica").style.display="";
	  					//灰色签到
	  					var pic1 = document.getElementById("picb").style.display="none";
	   					//蓝色签出
	   					var pic3 = document.getElementById("picc").style.display="none";
	  					//灰色签出
	  					var pic4 = document.getElementById("picd").style.display="";
	   				}
	   				//显示签出
	  				if(result == 2){
	  					//蓝色签到
	  					var pic1 = document.getElementById("pica").style.display="none";
	  					//灰色签到
	  					var pic1 = document.getElementById("picb").style.display="";
	  					//蓝色签出
	   					var pic3 = document.getElementById("picc").style.display="";
	   					//灰色签出
	  					var pic4 = document.getElementById("picd").style.display="none";
	   				}
	   				//已签到已签出
	   				if(result ==3){
	  					//蓝色签到
	  					var pic1 = document.getElementById("pica").style.display="none";
	  					//灰色签到
	  					var pic1 = document.getElementById("picb").style.display="";
	  					//蓝色签出
	   					var pic3 = document.getElementById("picc").style.display="none";
	   					//灰色签出
	  					var pic4 = document.getElementById("picd").style.display="";
	   				}
	  		     }

	   		});
	  	}
</script>
<link rel="stylesheet" href="<html:rewrite forward='master1.css'/>" type="text/css" />
<script src="<html:rewrite forward='swfobject_modified.js'/>"></script> 
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels2.css'/>" type="text/css"/>
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script> 
<body onload="initcheckio();">
<div class="octmain">
  <div class="octhead">
  		<div style="float:right;color:white;  font-siza:12px; display: block;padding: 10px;">
		<table>
			<tr>
				<td style="padding-top: 4px">
				<logic:equal name="LOGIN_USER" property="userid" value="admin">用户</logic:equal>
				<logic:notEqual name="LOGIN_USER" property="userid" value="admin">${LOGIN_USER.orgname}
				</logic:notEqual> ：<bean:write name="LOGIN_USER" property="username" />
				</td>
				<td><a href="javascript:openNewWindow()"><img src="js/menu/images/mycenter.gif" border="0"></a></td>
				<td><a href="javascript:quit()"><img src="js/menu/images/out.gif" border="0"></a></td>
			</tr>
			<tr>
				<td style="padding-top: 4px" colspan="3">
				<img id="pica" style="display: none; float: left;"
					src="js/menu/images/qd01.gif" onclick="checkinout(1)" alt="签到" style="cursor: hand">
				<img id="picb" style="display: none; float: left;"
					src="js/menu/images/qd02.gif" >
				<img id="picc" style="display: none; float: right;"
					src="js/menu/images/qt01.gif" onclick="checkinout(2)" alt="签出" style="cursor: hand">
				<img id="picd" style="display: none; float: right;"
					src="js/menu/images/qt02.gif">
				</td>
			</tr>
		</table>
		</div>
  </div>

  <div class="octnav"> 
    <object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="409">
      <param name="movie" value="images/ywindex/ydzq.swf" />
      <param name="quality" value="high" />
      <param name="wmode" value="opaque" />
      <param name="swfversion" value="9.0.45.0" />
      <!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
      <param name="expressinstall" value="Scripts/expressInstall.swf" />
      <!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
      <!--[if !IE]>-->
      <object type="application/x-shockwave-flash" data="images/ywindex/octflash.swf" width="1000" height="409">
        <!--<![endif]-->
        <param name="quality" value="high" />
        <param name="wmode" value="opaque" />
        <param name="swfversion" value="9.0.45.0" />
        <param name="expressinstall" value="Scripts/expressInstall.swf" />
        <!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
        <div>
          <h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
          <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="获取 Adobe Flash Player" width="112" height="33" /></a></p>
        </div>
        <!--[if !IE]>-->
      </object>
      <!--<![endif]-->
    </object>
  </div>
  <div class="octcont">
	<div id="business_bottom" style="padding-left:12px; width:980px;">
		<div id="business_bottom_content">
			<div id="TabbedPanels1" class="TabbedPanels">
	            <ul class="TabbedPanelsTabGroup">
	              <li class="TabbedPanelsTab">待办工作</li>
	              <li class="TabbedPanelsTab">相关工作</li>
	              <li class="TabbedPanelsTab">我的发起</li>
	              <li class="TabbedPanelsTab">历史工作</li>
	            </ul>
					<div class="TabbedPanelsContentGroup" style="width:958px; height:230px; overflow-x:hidden; overflow-y:auto;">
						<div class="TabbedPanelsContent">
							<table width="880" border="0" cellspacing="0" cellpadding="0">
								<tr align="left" style="background-color:#EEEEEE;height:20px;">
							  		 <th width="30"></th>
							         <th width="30"></th>
							         <th width="160">编号</th>
							         <th width="230">名称</th>
							         <th width="180">类型</th>
							         <th width="170">发起时间</th>
							         <th width="80">状态</th>
								</tr>	
								<logic:present name="IGCOM04051VO" property="myWorkList">
									<logic:iterate id="bean" name="IGCOM04051VO" property="myWorkList" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
										<tr class="my_work" style="height:28px" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" onclick="doLook('${bean.showurl}${bean.prid }&jump=100','${bean.prid }','${bean.prtitle }');">
											<td height="24"  valign="middle"></td>
									    	<td></td>
				    						<td>${bean.prserialnum }</td>
								    		<td>
								    			<%
								    			String prtitle = bean.getPrtitle();
								    			String showText = prtitle;
									    		if(prtitle.length() > 12){
									    			showText = showText.substring(0,11) + "...";
									    		}
								    			%>
												<span title="<%=prtitle %>"><%=showText %></span>
											</td>
								    		<td style="text-align: left">
								    			<%
									    		String prpdname = bean.getPrpdname();
									    		String showText1 = prpdname;
									    		if(prpdname.length() > 10){
									    			showText1 = showText1.substring(0,9) + "...";
								    			}
								    			%>
								    			<span title="<%=prpdname %>"><%=showText1 %></span>
								    		</td>
										    <td>${bean.propentime }</td>
								    		<td>
												<ig:processDefineTypeValue prid="${bean.prid }"/>
								    		</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div class="TabbedPanelsContent">
							<table width="880" border="0" cellspacing="0" cellpadding="0">
								<tr align="left" style="background-color:#EEEEEE;height:20px;">
									  <th width="30"></th>
							          <th width="30"></th>
							          <th width="160">编号</th>
							          <th width="230">名称</th>
							          <th width="180">类型</th>
							          <th width="170">发起时间</th>
							          <th width="80">状态</th>
								</tr>
								<logic:present name="IGCOM04051VO" property="relevanceWorkList">
									<logic:iterate id="bean" name="IGCOM04051VO" property="relevanceWorkList" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
										<tr class="my_work" style="height:28px" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" onclick="doLook('${bean.showurl}${bean.prid }&jump=100','${bean.prid }','${bean.prtitle }');">
											<td height="24"  valign="middle"></td>
									    	<td></td>
				    						<td>${bean.prserialnum }</td>
								    		<td>
								    			<%
								    			String prtitle = bean.getPrtitle();
								    			String showText = prtitle;
									    		if(prtitle.length() > 12){
									    			showText = showText.substring(0,11) + "...";
									    		}
								    			%>
												<span title="<%=prtitle %>"><%=showText %></span>
											</td>
								    		<td style="text-align: left">
								    			<%
									    		String prpdname = bean.getPrpdname();
									    		String showText1 = prpdname;
									    		if(prpdname.length() > 10){
									    			showText1 = showText1.substring(0,9) + "...";
								    			}
								    			%>
								    			<span title="<%=prpdname %>"><%=showText1 %></span>
								    		</td>
										    <td>${bean.propentime }</td>
								    		<td>
												<ig:processDefineTypeValue prid="${bean.prid }"/>
								    		</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
    					<div class="TabbedPanelsContent">
							<table width="880" border="0" cellspacing="0" cellpadding="0">
								<tr align="left" style="background-color:#EEEEEE;height:20px;">
									  <th width="30"></th>
							          <th width="30"></th>
							          <th width="160">编号</th>
							          <th width="230">名称</th>
							          <th width="180">类型</th>
							          <th width="170">发起时间</th>
							          <th width="80">状态</th>
								</tr>	
								<logic:present name="IGCOM04051VO" property="processRecordInitForMeList">
									<logic:iterate id="processRecordInfo" name="IGCOM04051VO" property="processRecordInitForMeList" indexId="index" type="com.deliverik.framework.workflow.prr.model.IG677Info">
									<tr class="my_work" style="height:28px" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" onclick="doLook('<%=urlMap.get(String.valueOf(processRecordInfo.getPrtype()))+processRecordInfo.getPrid() %>&jump=100','<%=processRecordInfo.getPrid()%>','<%=processRecordInfo.getPrtype()%>');">
										<td height="24" valign="middle">
 											<ig:processWarningImg beginTime="<%=processRecordInfo.getPropentime()%>" processType="<%=processRecordInfo.getPrtype()%>" prStrategyVersion="<%=processRecordInfo.getPrStrategyVersion()%>" prPdid="<%=processRecordInfo.getPrpdid()%>" prUrgency="<%=processRecordInfo.getPrurgency()%>"/>
										</td>
							    		<td>
							    		</td>
		   								<td><%=String.valueOf(processRecordInfo.getPrserialnum()) %></td>
							    		<td>
								    		<%
								    		String prtitle = processRecordInfo.getPrtitle();
								    		String showText = prtitle;
								    		if(prtitle.length() > 12){
								    			showText = showText.substring(0,11) + "...";
								    		}
								    		%>
											<span title="<%=prtitle %>"><%=showText %></span>
										</td>
		 										<td style="text-align: left">
								    		<%
								    		String prpdname = processRecordInfo.getPrpdname();
								    		String showText1 = prpdname;
								    		if(prpdname.length() > 10){
								    			showText1 = showText1.substring(0,9) + "...";
								    		}
								    		%>
		 											<span title="<%=prpdname %>"><%=showText1 %></span>
		 										</td>
		   								<td><%=processRecordInfo.getPropentime()%></td>
							    		<td>
							    			<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype())){%>
											<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/>
											<%}else{ %>
											<ig:codeValue ccid="<%=processRecordInfo.getPrtype() %>" cid="<%=processRecordInfo.getPrstatus() %>" />	
											<%} %>
							    		</td>
									</tr>
									</logic:iterate>
								</logic:present>	
							</table>
						</div>

						<div class="TabbedPanelsContent">
							<table width="880" border="0" cellspacing="0" cellpadding="0">
								<tr align="left" style="background-color:#EEEEEE;height:20px;">
									  <th width="30"></th>
								         <th width="30"></th>
								         <th width="160">编号</th>
								         <th width="230">名称</th>
								         <th width="180">类型</th>
								         <th width="170">发起时间</th>
								         <th width="80">状态</th>
								</tr>
								<logic:present name="IGCOM04051VO" property="processRecordInitForHistoryList">
								<logic:iterate id="processRecordInfo" name="IGCOM04051VO" property="processRecordInitForHistoryList" indexId="index" type="com.deliverik.framework.workflow.prr.model.IG500Info">
								<tr class="my_work" style="height:28px" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" onclick="doLook('<%=urlMap.get(String.valueOf(processRecordInfo.getPrtype()))+processRecordInfo.getPrid() %>&jump=100','<%=processRecordInfo.getPrid()%>','<%=processRecordInfo.getPrtype()%>');">
									<td height="24"  valign="middle">
						    			<ig:processWarningImg beginTime="<%=processRecordInfo.getPropentime()%>" processType="<%=processRecordInfo.getPrtype()%>" prStrategyVersion="<%=processRecordInfo.getPrStrategyVersion()%>" prPdid="<%=processRecordInfo.getPrpdid()%>" prUrgency="<%=processRecordInfo.getPrurgency()%>"/>
						    		</td>
						    		<td>
						    		</td>
	    							<td><%=String.valueOf(processRecordInfo.getPrserialnum()) %></td>
						    		<td>
						    			<%
						    			String prtitle = processRecordInfo.getPrtitle();
						    			String showText = prtitle;
							    		if(prtitle.length() > 12){
							    			showText = showText.substring(0,11) + "...";
							    		}
						    			%>
										<span title="<%=prtitle %>"><%=showText %></span>
									</td>
						    		<td style="text-align: left">
						    			<%
							    		String prpdname = processRecordInfo.getPrpdname();
							    		String showText1 = prpdname;
							    		if(prpdname.length() > 10){
							    			showText1 = showText1.substring(0,9) + "...";
						    			}
						    			%>
						    			<span title="<%=prpdname %>"><%=showText1 %></span>
						    		</td>
								    <td><%=processRecordInfo.getPropentime()  %></td>
						    		<td>
										<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/>
						    		</td>
								</tr>
							</logic:iterate>
							</logic:present>
						</table>
					</div>
					</div>
				</div>
			</div>
		</div> 
	</div>
</div>
<script type="text/javascript">swfobject.registerObject("FlashID");</script>
<script type="text/javascript">var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");</script>
</body>
</html:html>