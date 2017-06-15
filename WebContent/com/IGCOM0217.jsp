<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="com.deliverik.framework.soc.asset.model.SOC0305Info"%><html:html>

<bean:define id="id" value="IGCOM0217" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="comResources" key="ietitle.IGCOM0217" />
</bean:define>
<head>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="css/new.css" type="text/css"/>
<script type="text/javascript">
//获取告警信息
function getEventInfo(id,impcitype,alarmType){
	document.getElementById("stoId").value=id;
	 var res="";
	 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=EVENT&id='+id,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}
		    }
		});
	if(res!=null&&res!=""){
		var eventInfo=res.split(",");
		//性能告警信息
		if(alarmType=="2"||alarmType=="3"){
			document.getElementById("dmx").style.display="none";
			document.getElementById("ibm").style.display="none";
			document.getElementById("brocade").style.display="none";
			document.getElementById("mcdata").style.display="none";
			document.getElementById("performance").style.display="block";
			document.getElementById("eirootmark_performance").innerText=eventInfo[0];
			document.getElementById("impcitype_performance").innerText=eventInfo[1];
			document.getElementById("detectionTime_performance").innerText=eventInfo[2];
			if(eventInfo[7]=="null"){
				document.getElementById("severity_performance").innerText="";
			}else{
				document.getElementById("severity_performance").innerText=eventInfo[7];
			}
			document.getElementById("errorDesc_performance").innerText=eventInfo[8];
		}else{
			//Brocade事件告警信息
			if(impcitype=="2"){
				document.getElementById("dmx").style.display="none";
				document.getElementById("ibm").style.display="none";
				document.getElementById("brocade").style.display="block";
				document.getElementById("performance").style.display="none";
				document.getElementById("mcdata").style.display="none";
				document.getElementById("eirootmark_brocade").innerText=eventInfo[0];
				document.getElementById("impcitype_brocade").innerText=eventInfo[1];
				document.getElementById("detectionTime_brocade").innerText=eventInfo[2];
				document.getElementById("severity_brocade").innerText=eventInfo[7];
				document.getElementById("errorDesc_brocade").innerText=eventInfo[8];
			}
			//mcdata事件告警信息
			if(impcitype=="9"){
				document.getElementById("dmx").style.display="none";
				document.getElementById("ibm").style.display="none";
				document.getElementById("brocade").style.display="none";
				document.getElementById("performance").style.display="none";
				document.getElementById("mcdata").style.display="block";
				document.getElementById("eirootmark_madata").innerText=eventInfo[0];
				document.getElementById("impcitype_madata").innerText=eventInfo[1];
				document.getElementById("detectionTime_madata").innerText=eventInfo[2];
				document.getElementById("src_madata").innerText=eventInfo[3];
				document.getElementById("severity_madata").innerText=eventInfo[7];
				document.getElementById("errorDesc_madata").innerText=eventInfo[8];
			}
			//DMX事件告警信息
			if(impcitype=="3"){
				document.getElementById("dmx").style.display="block";
				document.getElementById("ibm").style.display="none";
				document.getElementById("brocade").style.display="none";
				document.getElementById("performance").style.display="none";
				document.getElementById("mcdata").style.display="none";
				document.getElementById("eirootmark_dmx").innerText=eventInfo[0];
				document.getElementById("impcitype_dmx").innerText=eventInfo[1];
				document.getElementById("detectionTime_dmx").innerText=eventInfo[2];
				document.getElementById("src_dmx").innerText=eventInfo[3];
				document.getElementById("errorNum_dmx").innerText=eventInfo[4];
				document.getElementById("dir_dmx").innerText=eventInfo[5];
				document.getElementById("category_dmx").innerText=eventInfo[6];
				document.getElementById("severity_dmx").innerText=eventInfo[7];
				document.getElementById("errorDesc_dmx").innerText=eventInfo[8];
			}
			//IBM事件告警信息
			if(impcitype=="5"){
				document.getElementById("dmx").style.display="none";
				document.getElementById("ibm").style.display="block";
				document.getElementById("brocade").style.display="none";
				document.getElementById("performance").style.display="none";
				document.getElementById("mcdata").style.display="none";
				document.getElementById("eirootmark_ibm").innerText=eventInfo[0];
				document.getElementById("impcitype_ibm").innerText=eventInfo[1];
				document.getElementById("detectionTime_ibm").innerText=eventInfo[2];
				document.getElementById("src_ibm").innerText=eventInfo[3];
				document.getElementById("errorNum_ibm").innerText=eventInfo[4];
				document.getElementById("errorDesc_ibm").innerText=eventInfo[8];
				if(eventInfo[9]=="null"){
					document.getElementById("lparName_ibm").innerText="";
				}else{
					document.getElementById("lparName_ibm").innerText=eventInfo[9];
				}
			}
		}
	}
}

function inti(){
	document.getElementById("dmx").style.display="none";
	document.getElementById("ibm").style.display="none";
	document.getElementById("brocade").style.display="none";
	document.getElementById("performance").style.display="none";
	document.getElementById("mcdata").style.display="none";
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'type=NatrueAlarm',
		 onSuccess:  function(req, json){
		 	var result = req.responseText;
			if(result != null && result.trim() != ""){
				var temp = window.showModalDialog("IGASM2701_POP.do",null,"dialogWidth:1000px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if(temp=="1"){
					new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'type=NatrueAlarmRead',
						 onSuccess:  function(req, json){
					     }
						});
				}
			} 
	     }
		});
}

function updStatus(){
	var confirmMsg = '<bean:message bundle="comResources" key="message.IGCOM0217.001"/>';
	if(window.confirm(confirmMsg)){
		var id=document.getElementById("stoId").value;
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=StorageEventStatus&id='+id,
				 onSuccess:  function(req, json){
				 
			    }
			});
		window.location="IGCOM0202.do?linkID=IGCOM0217";
	}
}
function refresh(){
	window.location="IGCOM0202.do?linkID=IGCOM0217";
}
window.setInterval(refresh,60000);
</script>
</head>
<body style="text-align:center;" onload="inti();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
	<div class="jh_left">
	<div class="tab">
      <fieldset style="width: 720px;height: 300px;border-color:#CCCCCC;">
		<legend style="background-color:#EEEEEE;border-color:#CCCCCC;">
		<span style="color:#000000;">
		<bean:message bundle="comResources" key="group.IGCOM0217.event"/>
		</span>
		</legend>
	  <div style="float:left; width:590px; height:22px;line-height:22px; text-align:right ">
      <bean:define id="bpr" name="IGCOM02181VO" property="soc0307List"/>
      <c:if test="${fn:length(bpr)>11}">
      <a href="IGCOM0202.do?linkID=IGMNT0206&actname=ACT06MNT0201" target="_self">
      	<bean:message bundle="comResources" key="label.IGCOM0217.more" />&gt;&gt;
      </a></c:if>
      </div>
      <table border="0"  align="center" cellpadding="0" cellspacing="0" class="table_style">
				<tr style="height:24px">
					  <th width="5%"></th>
			          <th width="20%">
			          <bean:message bundle="comResources" key="label.IGCOM0217.eirootmark" />
			          </th>
			          <th width="15%">
			          <bean:message bundle="comResources" key="label.IGCOM0217.impTypename" />
			          </th>
			          <th width="15%">
			           <bean:message bundle="comResources" key="label.IGCOM0217.eventType" />
			          </th>
			          <th width="30%">
			          <bean:message bundle="comResources" key="label.IGCOM0217.detectiontime" />
			          </th>
			          <th width="15%">
			          <bean:message bundle="comResources" key="label.IGCOM0217.severity" />
			          </th>
				</tr>
				<logic:present name="IGCOM02181VO" property="soc0307List">
                <logic:iterate id="bean" name="IGCOM02181VO" property="soc0307List" length="12" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'<ig:rowcss index="${index}"/>');" onclick="getEventInfo(${bean.id},${bean.imptypeid},${bean.alarmType});" >
					<td><img src="images/emergency.gif" width="16" height="16" /></td>
					<td>${bean.eirootmark}</td>
					<td>${bean.imptypename}</td>
					<td>
					<ig:codeValue ccid="ALARM_TYPE_CODE" cid="${bean.alarmType}"/>
					</td>
					<td>${bean.detectiontime}</td>
					<td>${bean.severity}</td>
					</tr>
				</logic:iterate>	
				</logic:present>
				</table>
      </fieldset>
    </div>
    
    <!-- 告警详细信息 -->
    <input type="hidden" id="stoId">
    <div id="dmx">
    <fieldset style="width: 720px;height: 165px;border-color:#CCCCCC; ">
		<legend style="background-color:#EEEEEE;border-color:#CCCCCC;">
		<span style="color:#000000;">
		<bean:message bundle="comResources" key="legend.IGCOM0217.details"/>
		</span>
		</legend>
    
	<table cellspacing="2" class="table_style1" style="margin-top: 10px;">
		<tr>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.eirootmark"/>：</th>
			<td width="35%"><span id="eirootmark_dmx"></span></td>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.impTypename"/>：</th>
			<td width="35%"><span id="impcitype_dmx"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.detectiontime"/>：</th>
			<td><span id="detectionTime_dmx"></span></td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.Src"/>：</th>
			<td><span id="src_dmx"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.ErrorNum"/>：</th>
			<td>
				<span id="errorNum_dmx"></span>
			</td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.Dir"/>：</th>
			<td>
				<span id="dir_dmx"></span>
			</td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.Category"/>：</th>
			<td>
				<span id="category_dmx"></span>
			</td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.severity"/>：</th>
			<td>
				<span id="severity_dmx"></span>
			</td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.errorDesc"/>：</th>
			<td colspan="3">
				<span id="errorDesc_dmx"></span>
			</td>
		</tr>
	</table>
	</fieldset>
	<div class="enter">
	<html:button property="btn_insert" styleClass="button" styleId="btn_insert" onclick="updStatus()">
		<bean:message bundle="comResources" key="button.IGCOM0217.btn_commit"/>
	</html:button>
	</div>
	</div>
	<div id="ibm">
	<fieldset style="width: 720px;height: 165px;border-color:#CCCCCC; ">
		<legend style="background-color:#EEEEEE;border-color:#CCCCCC;">
		<span style="color:#000000;">
		<bean:message bundle="comResources" key="legend.IGCOM0217.details"/>
		</span>
		</legend>
    
	<table cellspacing="2" class="table_style1" style="margin-top: 10px;">
		<tr>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.eirootmark"/>：</th>
			<td width="35%"><span id="eirootmark_ibm"></span></td>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.impTypename"/>：</th>
			<td width="35%"><span id="impcitype_ibm"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.detectiontime"/>：</th>
			<td><span id="detectionTime_ibm"></span></td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.Src"/>：</th>
			<td><span id="src_ibm"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.ErrorNum"/>：</th>
			<td>
				<span id="errorNum_ibm"></span>
			</td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.LparName"/>：</th>
			<td>
				<span id="lparName_ibm"></span>
			</td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.errorDesc"/>：</th>
			<td colspan="3">
				<span id="errorDesc_ibm"></span>
			</td>
		</tr>
	</table>
	</fieldset>
	<div class="enter">
	<html:button property="btn_insert" styleClass="button" styleId="btn_insert" onclick="updStatus()">
		<bean:message bundle="comResources" key="button.IGCOM0217.btn_commit"/>
	</html:button>
	</div>
	</div>
	<div id="brocade">
	<fieldset style="width: 720px;height: 165px;border-color:#CCCCCC; ">
		<legend style="background-color:#EEEEEE;border-color:#CCCCCC;">
		<span style="color:#000000;">
		<bean:message bundle="comResources" key="legend.IGCOM0217.details"/>
		</span>
		</legend>
    
	<table cellspacing="2" class="table_style1" style="margin-top: 10px;">
		<tr>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.eirootmark"/>：</th>
			<td width="35%"><span id="eirootmark_brocade"></span></td>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.impTypename"/>：</th>
			<td width="35%"><span id="impcitype_brocade"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.detectiontime"/>：</th>
			<td><span id="detectionTime_brocade"></span></td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.severity"/>：</th>
			<td><span id="severity_brocade"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.errorDesc"/>：</th>
			<td colspan="3">
				<span id="errorDesc_brocade"></span>
			</td>
		</tr>
	</table>
	</fieldset>
	<div class="enter">
	<html:button property="btn_insert" styleClass="button" styleId="btn_insert" onclick="updStatus()">
		<bean:message bundle="comResources" key="button.IGCOM0217.btn_commit"/>
	</html:button>
	</div>
	</div>
	
	<div id="mcdata">
	<fieldset style="width: 720px;height: 165px;border-color:#CCCCCC; ">
		<legend style="background-color:#EEEEEE;border-color:#CCCCCC;">
		<span style="color:#000000;">
		<bean:message bundle="comResources" key="legend.IGCOM0217.details"/>
		</span>
		</legend>
    
	<table cellspacing="2" class="table_style1" style="margin-top: 10px;">
		<tr>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.eirootmark"/>：</th>
			<td width="35%"><span id="eirootmark_madata"></span></td>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.impTypename"/>：</th>
			<td width="35%"><span id="impcitype_madata"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.detectiontime"/>：</th>
			<td><span id="detectionTime_madata"></span></td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.severity"/>：</th>
			<td><span id="severity_madata"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.Src"/>：</th>
			<td>
				<span id="src_madata"></span>
			</td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.errorDesc"/>：</th>
			<td>
				<span id="errorDesc_madata"></span>
			</td>
		</tr>
	</table>
	</fieldset>
	<div class="enter">
	<html:button property="btn_insert" styleClass="button" styleId="btn_insert" onclick="updStatus()">
		<bean:message bundle="comResources" key="button.IGCOM0217.btn_commit"/>
	</html:button>
	</div>
	</div>
	
	<div id="performance">
	<fieldset style="width: 720px;height: 165px;border-color:#CCCCCC; ">
		<legend style="background-color:#EEEEEE;border-color:#CCCCCC;">
		<span style="color:#000000;">
		<bean:message bundle="comResources" key="legend.IGCOM0217.details"/>
		</span>
		</legend>
    
	<table cellspacing="2" class="table_style1" style="margin-top: 10px;">
		<tr>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.eirootmark"/>：</th>
			<td width="35%"><span id="eirootmark_performance"></span></td>
			<th width="15%"><bean:message bundle="comResources" key="label.IGCOM0217.impTypename"/>：</th>
			<td width="35%"><span id="impcitype_performance"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.detectiontime"/>：</th>
			<td><span id="detectionTime_performance"></span></td>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.severity"/>：</th>
			<td><span id="severity_performance"></span></td>
		</tr>
		<tr>
			<th><bean:message bundle="comResources" key="label.IGCOM0217.errorDesc"/>：</th>
			<td colspan="3">
				<span id="errorDesc_performance"></span>
			</td>
		</tr>
	</table>
	</fieldset>
	<div class="enter">
	<html:button property="btn_insert" styleClass="button" styleId="btn_insert" onclick="updStatus()" >
		<bean:message bundle="comResources" key="button.IGCOM0217.btn_commit"/>
	</html:button>
	</div>
	</div>
</div>
	

  <div class="jh_right">
  <div class="shortcut">
    <div class="sbtil">
    <span class="stfb">
    	<bean:message bundle="comResources" key="label.IGCOM0217.shortcut" />
    </span></div>
      <div class="kjfs">
       <div class="kjfs_link">
          <div class="ql_icon"><img src="images/monitor-sidebar.gif" width="16" height="16" /></div>
          <div class="ql_text">
          <ig:menuAuth actname="ACT01ASM2501">
			<a href="IGCOM0202.do?linkID=IGASM2501&actname=ACT01ASM2501" target="_self">
          	<bean:message bundle="comResources" key="label.IGCOM0217.alerting" />
            </a>
	     </ig:menuAuth>
		 <ig:menuAuth actname="ACT01ASM2501" permission="false">
			<bean:message bundle="comResources" key="label.IGCOM0217.alerting" />
		 </ig:menuAuth>
        </div>
      </div> 
     
      <div class="kjfs_link">
         <div class="ql_icon"><img src="images/clock-history.gif" width="16" height="16" /></div>
         <div class="ql_text">
         <ig:menuAuth actname="ACT17KGM0201">
			<a href="IGCOM0202.do?linkID=IGMNT0201&actname=ACT17KGM0201" target="_self">
        	 <bean:message bundle="comResources" key="label.IGCOM0217.KPIsetting" />
         	</a>
	     </ig:menuAuth>
		 <ig:menuAuth actname="ACT17KGM0201" permission="false">
			<bean:message bundle="comResources" key="label.IGCOM0217.KPIsetting" />
		 </ig:menuAuth>
        </div>
     </div>
     
      <div class="kjfs_link" style="width:200px;">
          <div class="ql_icon"><img src="images/flow-manage.gif" width="16" height="16" /></div>
          <div class="ql_text">
         	<ig:menuAuth actname="ACT17KGM0104">
			<a href="IGCOM0202.do?linkID=IGKGM0205&actname=ACT17KGM0104" target="_self">
         	<bean:message bundle="comResources" key="label.IGCOM0217.knowledgeManage" />
         	</a>
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17KGM0104" permission="false">
 			<bean:message bundle="comResources" key="label.IGCOM0217.knowledgeManage" />
			</ig:menuAuth>
         </div>
          <div style="float:left;margin-left: -20pt;margin-top: 2pt;"><img  src="images/newSY.gif"/></div>
     </div>
    </div>
	</div>
  
    <div class="exam">
   	  <bean:define id="know" name="IGCOM02181VO" property="knowledgeList"/>
      <div class="sbtil">
      <span class="stfb">
	  <bean:message bundle="comResources" key="label.IGCOM0217.knowledge" />
	  </span>
	   <bean:define id="kl" name="IGCOM02181VO" property="knowledgeList"/>
      <c:if test="${fn:length(kl)>11}">
      <span id="more2"  style="float:right; padding-top:5px;">
       <a href="IGCOM0202.do?linkID=IGKGM0205&actname=ACT17KGM0104" target="_self">
       <img alt="<bean:message bundle="comResources" key="img.IGCOM0217.more.alt" />" src="images/more.gif" style="border: 0px;">
       </a>
       </span>
       </c:if>
      </div>
      <div class="ancli">
        <table width="100%"  border="0">
          <logic:present name="IGCOM02181VO" property="knowledgeList">
					<logic:iterate id="bean" name="IGCOM02181VO"
						property="knowledgeList" indexId="index" length="11">
						<tr style="height: 26px;">
							<td width="5%">&nbsp;</td>					
							<td width="60%">
							<img src="images/location_img.gif"/>&nbsp;
							<a href="javascript:doLook('IGKGM0205_READ.do?knid=${bean.knid}&knversion=${bean.knversion}');" >
							<c:if test="${fn:length(bean.kntitle)>9}">
							${fn:substring(bean.kntitle,0,8)}...
							</c:if>
							<c:if test="${fn:length(bean.kntitle)<=9}">
							${bean.kntitle}
							</c:if>
							</a>
							</td>
							<td width="35%" align="right">[${fn:substring(bean.knproffertime,0,10)}]</td>
						</tr>
					</logic:iterate>
		  </logic:present>
        </table>
      </div>
    </div>
    
  </div>
  </div>
</div>
</body>
</html:html>
