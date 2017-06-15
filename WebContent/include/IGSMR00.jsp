<%@page import="com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT"%>
<%@page import="com.deliverik.infogovernor.common.ProcessDefineTypeValueBean"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<link type="text/css" href="css/new.css" rel="stylesheet" />
<script src="js/alertjs/effects.js"></script>
<script src="js/alertjs/side-bar.js"></script>
<script type="text/javascript">
function processChart(){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?pdid=${IGPRR0102Form.pdid}&psdid=${IGPRR0102Form.psdid}',null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
function participants(){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0122_Disp.do?prid=${IGPRR0102Form.prid}',null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
var win = null;
function history(){
	var prid = document.getElementById("prid").value;
	var showCopy = 'Y';
	<%
	IGPRR01021VO vo = (IGPRR01021VO)request.getSession().getAttribute("IGPRR01021VO");
	String psdname = ProcessDefineTypeValueBean.getConfigInfo(vo.getProcess().getPrid());
	if(!IGSMRCONSTANT.PRSTATUSNAME_REPORT.equals(psdname)){
		%>
			showCopy = 'N';
		<%
	}
	%>
	var url = '/IGSMR0501_Disp.do?pdid=${IGPRR01021VO.process.prpdid}&showCopy=' + showCopy + '&prtype=${IGPRR01021VO.process.prtype}&currentPrid=' + prid;
	var iTop = (window.screen.availHeight-30-400)/2;       //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-500)/2;           //获得窗口的水平位置;
	win = window.open(getAppRootUrl() + url, '_bank', 'width=400,height=500,scrollbars=yes,resizable=no,status=yes,top='+iTop+',left='+iLeft+',');
	win.focus();
}
function setProcessInfos(prid){
	var cprid = document.getElementById("prid").value;
	location.href = getAppRootUrl() + '/IGPRR0102_Copy.do?&prtype=${IGPRR01021VO.process.prtype}&prid=' + cprid + '&jump=77&historyPrid=' + prid;
}
function reportDesc(){
	var pdid = document.getElementById("pdid").value;
	var url = "/IGSMR0502_Disp.do?pdid=" + pdid;
	openSubWindow(url, '_blank', '1050', '600');
}
function goTopEx(){
    var obj=document.getElementById("goTopBtn");
    function getScrollTop(){
            return document.documentElement.scrollTop;
        }
    function setScrollTop(value){
            document.documentElement.scrollTop=value;
        }    
    window.onscroll=function(){getScrollTop()>0?obj.style.display="":obj.style.display="none";}
    obj.onclick=function(){
        var goTop=setInterval(scrollMove,10);
        function scrollMove(){
                setScrollTop(getScrollTop()/1.1);
                if(getScrollTop()<1)clearInterval(goTop);
            }
    }
}
</script>
<div style="position:fixed; width:990px;">
<div id="sideBar">
	<a id="sideBarTab" style="cursor: hand">
		<img src="images/slide-smr.gif" alt="sideBar" title="sideBar" />
	</a>
	<div id="sideBarContents" style="display:none;">
		<div id="sideBarContentsInner">
<!-- 			<h2 style="padding-left:34px;">功能菜单</h2> -->
			<ul>
				<li><a href="javascript:processChart();">流程图</a></li>
				<li><a href="javascript:participants();">处理记录</a></li>
				<li><a href="javascript:reportDesc();">填报说明</a></li>
				<li><a href="javascript:history();">历史填报</a></li>
				<li id="goTopBtn" style="display:none"><a href="#">返回顶部</a></li>
			</ul>
			<SCRIPT type=text/javascript>goTopEx();</SCRIPT>
		</div>
	</div>
</div>
</div>