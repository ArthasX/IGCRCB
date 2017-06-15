<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.vo.IGCOM03041VO"%>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG677Info"%>
<%@ page import="com.deliverik.infogovernor.soc.srv.bl.IGPROCESSType"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%	
	int num = 0;//我的工作已显示的条数
	int groupnum = 0;//相关工作已显示的条数
	String contextPath = request.getContextPath();
	String page_width = null;
	if(null!=request.getAttribute("page_width")){
		page_width = request.getAttribute("page_width").toString();
	}
	
	String screen=(request.getParameter("screen_width")==null?"1280":request.getParameter("screen_width"));
	if(page_width!=null){
		screen = page_width;
	}
	int screen_width=Integer.parseInt(screen);
	
%>
<html:html>
<bean:define id="id" value="IGPOR0101" toScope="request" />
<bean:define id="title" toScope="request" >
<bean:message bundle="comResources" key="ietitle.IGPOR0101"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script src="<html:rewrite forward='FusionCharts.js'/>"></script>
<link type="text/css" href="css/portal.css" rel="stylesheet" />
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css"/>
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script> 

<script type="text/javascript">

function switchShowJob(str){

	if(str == 1){	 	
		document.getElementById('showJobPersion').style.display='';
		document.getElementById('showJobGrpup').style.display='none';
	}else if(str == 2){
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='';
	}else if(str == 3){
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
	}
}
function showModal(url){
	var obj = window.showModalDialog("<%=request.getContextPath()%>" + url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if(obj != null){ 
		window.parent.location.href = obj;
	}
	resetSVC0111();
	resetPortal0103();
	//alert(iframe2.window);
}
function resetPortal0103(){
	//0秒后刷下
	setTimeout(resetPOR0103,0);
}
function resetSvc0111(){
	//0秒后刷下
	setTimeout(resetSVC0111,0);
}
function resetPOR0103(){
	iframe3.window.location.reload();
}
function resetSVC0111(){
	//alert(frame.src);
	//alert(frame.location);
	frame.window.location.reload();
}

</script>
<style>
  #portal_main{
	width:1002px;
	margin:0px auto;
	padding:0px;
	font-size:12px;
	background-color: #FFFFFF;
	text-transform:capitalize;
}
</style>
<body>
<div id="maincontent">
<jsp:include page="/include/header2.jsp" />
   <div id="portal_main">
    <div id="main_left" >
        <div id="box1" style="height:513px;width:682px;">		       
            <div id="showJobPersion" >
        	    <font style="font-family:Arial, Helvetica, sans-serif"><bean:message bundle="comResources" key="href.IGPOR0101.serif"/>&nbsp;|&nbsp;<a href="IGSRV0111.do" style="color: #006BC6" target="frame" onclick="javascript:switchShowJob('2')"><bean:message bundle="comResources" key="href.IGPOR0101.whole"/></a></font>
			</div>
			<div id="showJobGrpup" style="display:none">
				<font style="font-family:Arial, Helvetica, sans-serif"><a href="IGPOR0102.do" style="color: #006BC6" target="frame" onclick="javascript:switchShowJob('1')" ><bean:message bundle="comResources" key="href.IGPOR0101.serif"/></a>&nbsp;|&nbsp;<bean:message bundle="comResources" key="href.IGPOR0101.whole"/></font>
			</div>
			<div style="background-color: #FFFFFF;">
			 <iframe id="iframe" src="IGPOR0102.do" width="100%" height="100%" scrolling="no" name="frame" frameborder="0" ></iframe>
			</div>
       </div>
    </div>
      <div id="main_right">
       <div id="box7">   
        <h1><bean:message bundle="comResources" key="legend.IGPOR0101.001"/></h1>
        <div id="chartdiv5" align="center" style="margin-top:20px;font-size:12px;font-weight: bold;">
            <div  align="center" style="width:45%;height:80px;float:left;margin-top:25px; margin-bottom: 24px; padding-left:12px;">
          		<div align="center" style="height:50px; padding-left:10px; ">
                   <div style="line-height:30px; float:left;"><img src="images/sjgl_portal.gif"/></div><div style="line-height:30px; float:left; padding-left:8px;"><a href="###" onclick="showModal('/IGCOM0202.do?linkID=IGSRV0202&actname=ACT02SVC0202')"><bean:message bundle="comResources" key="href.IGPOR0101.event"/></a></div>
				</div>
				<div align="center" style="height:50px; padding-left:10px; ">
                   <div style="line-height:30px; float:left;"><img src="images/bggl_portal.gif"/></div><div style="line-height:30px; float:left; padding-left:8px;"><a href="###" onclick="showModal('/IGCOM0202.do?linkID=IGSRV0402&actname=ACT02SVC0402')"><bean:message bundle="comResources" key="href.IGPOR0101.edit"/></a></div> 
           		</div>
           	</div>
           	<div  align="center" style="width:50%;height:80px;float:right;margin-top:25px;margin-bottom:0px;">
           		<div align="center" style="height:50px; padding-left:10px; ">
                   <div style="line-height:30px; float:left;"><img src="images\wkm\extwa\01.gif" /></div><div style="line-height:30px; float:left; padding-left:8px;"><a href="###" onclick="showModal('/IGCOM0202.do?linkID=IGWKMSOC0202&type=1&page=job&actname=ACT02SVC0904')"><bean:message bundle="comResources" key="href.IGPOR0101.jobmanage"/></a></div>
           		</div>
           		<div align="center" style="height:50px; padding-left:10px; ">
                   <div style="line-height:30px; float:left;"><img src="images\wkm\extwb\01.gif" /></div>
                   <div style="line-height:30px; float:left; padding-left:8px;"><a href="IGSVC1501_Disp.do" target="frame" onclick="javascript:switchShowJob('3')"><bean:message bundle="comResources" key="href.IGPOR0101.workTimeSetting"/></a></div>
           		</div>
			</div>
		</div>
       </div>    
        <div>
           <iframe src ="IGPOR0103.do" frameborder="0" width="318px" height="380px" scrolling="no" style="margin-top:0px" id="iframe3">
           </iframe>        	
        </div>
      </div>    
    </div>
  </div> 
</body>
<c:if test="${processWorkTimeCount==0}">
	<script type="text/javascript">
		alert('<bean:message bundle="comResources" key="message.IGPOR0101.setprocessworktime"/>');
		document.getElementById("iframe").src="IGSVC1501_Disp.do";
	</script>
</c:if>
</html:html>