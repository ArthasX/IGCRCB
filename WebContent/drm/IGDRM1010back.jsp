<%@page import="com.deliverik.framework.user.model.entity.OrganizationTB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1010" toScope="request" />
<bean:define id="title" value="应急工作台" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
body{
font-family:'微软雅黑', 'Microsoft YaHei UI';

}
div{
	margin: 0px;
	padding: 0px;
	
}
table{
	width: 100%;
	border-collapse: collapse;
}
ul{
	list-style: none;
	float: left;
}
li{
	float: left;
	margin-left: 0px;
}
#titBox{
   
/* 	*margin-top: -8px; */
	margin-bottom: 12px;
	float:left;

}
.tab {
/* 	background: #ff0; */
	width: 100%;
	}
.tab li{
	height: 30px;
	font-size: 16px;
	line-height: 30px;
	border: 1px solid;
	border-bottom: 0px;
	width: 150px;
		text-align: center;
}


#tabBox{

/* 	background: #f00; */
	width: 100%;
}
#content{
	border: 1px solid;
	padding: 1em;
}
#titleTd{
	width:40%;
	font-size: 24px;
	text-indent: 2em;
}
#startTimeTd{
	width: 20%;
}
#useTimeTd{
	width:20%;
}
#endTimeTd{
	width:20%;
}
#consoleBox li{
	border: 1px solid;
	width: 240px;
	margin-right: 10px;
	height: 32px;
	font-size: 14px;
	text-align: center;
	line-height: 32px;
}
#consoleGroup{
	border: 1px solid;
	width: 100%;
}
#consoleGroup th{
	font-size: 14px;
}
td input{
	width: 80%;
	height: 20px;
}
#consoleGroup textarea{
	width: 96%;
	height: 120px;
	margin-bottom: 10px;
	overflow: auto;
}
#btnTd{
	vertical-align: bottom;
	text-align: right;
}
#btnTd .btn{
	margin-bottom: 10px;
}
.btn{
	display: block;
	width: 80px;
	border: 1px solid;
	margin-right: 20px;
}
#statusBox{
	border: 1px solid;
	margin-top: 10px;
}
#statusBox td select{
	width: 90%;
}
.tit{
	border-bottom: 1px solid;
/* 	*margin-top:-15px; */
	display: block;
}
#statusBox .btnTd{
	text-align: right;
	
}
#statusList{
	height: 380px;
	width: 100%;
}
#statusList td,#statusList th{
	text-align: left;
}
.tit th{
	font-size: 15px;
	height: 30px;
}
#titTd{
	font-size: 18px;
	text-indent: 1em;
}
#titBox td div{
	display: inline-block;
	width: 80%;
	height: 30px;
	text-align: center;
	line-height: 30px;
	vertical-align:middle;
	font-weight: 600;

}



/* <!-- 以上是布局样式  一下是颜色 --> */

#warp{
	background:url("images/drm/bluebg.jpg");
	color: white;
}
#main{
  	width: 1000px;
  	height:760px;
  	margin: 10px auto;
	background-color:rgba(4,23,51,.7);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#b2041733,endColorstr=#b2041733);
}
th{
	color: #A2CEFD;
}


#consoleBox{
/*  	background-color: #011955;  */
/*  	opacity:0.4;  */
/*  	fillter:alpha(opacity=40);  */
}

#consoleGroup{
/* 	background-color: #011955; */
/* 	opacity:0.4; */
/* 	fillter:alpha(opacity=40); */
}
#main div{
	border-color: #0251C0;
	float: left;
}
#main input,#main select, #main textarea{
	
	border: 1px solid #0251C0;
/* 	background */
	background-color:rgba(22,60,145,.3); 
	filter: Chroma(Color=#FFFFFF);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#4c164e9d,endColorstr=#4c164e9d);
}
.btn{
	color: white;
	border: 1px solid #2D3E58;
	background-color: #223554;
}
.hbth{
	border: 1px solid #283A59;
	background-color: #0367D5;
}


 li.cur{
	color:#0187E2;
	border-color:#0154C2;
	background-color:rgba(255,255,255,.3);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#4c0154C2,endColorstr=#4c0154C2);
}
 li{
	color:#818EAA;
	border-color:#435B89 ;
	background-color:rgba(34,53,84,.3);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#4c223554,endColorstr=#4c223554);
}
.icon{
	height:30px;
	width: 30px;
	display: inline-block;
	background-image: url("images/drm/icon.png");
	
}
.icon1{
	background-position: 0px 0px;
	
}
.icon2{
	background-position: -30px 0px;
}
.icon3{
	background-position: -63px 0px;
}
.icon4{
	background-position: -90px 0px;
}
.icon5{
	background-position: -130px 0px;
}

.clickable{
cursor: pointer;
}
.sortTxt{
	width: 70%;
}

#startTimeTd div{
	background: #022C77;
	color: #00A0FF;
	border: 1px solid #00A0FF;
}
#useTimeTd div{
	color: #f00;
	font-size: 14px;
}
#endTimeTd div{
	background: #134F06;
	color: #31E80C;
	border: 1px solid #31E80C;
}
</style>

<body>
	<div id ="warp" style=" width:1024px;margin: 2px auto; ">
	<div id="main" >
		&nbsp;
		<!-- tab标题 -->
		<div id="tabBox">
			<ul class="tab">
				<li class="cur" data-type="emg">应急指挥工作台</li>
				<li data-type="rec">应急处置工作台</li>
			</ul>
		</div>
		<div id="content">
			<div id = "titBox">
				<table >
					<tr>
						<td id= "titleTd">事件名称</td>
						<td id= "startTimeTd"><div>开始时间 <font>  01:02:02</font></div></td>
						<td id= "useTimeTd"><div><span class="icon icon1">&nbsp;</span>已用时间 <font>  01:02:02</font></div>  </td>
						<td id= "endTimeTd"> <div>结束时间<font>  01:02:02</font></div></td>
					</tr>
				</table>
			</div>
			<div id = "consoleBox">
				<ul >
					<li data-consoletype="log" class="cur">处理日志</li>
					<li data-consoletype="sms">推送短信</li>
					<li data-consoletype="notice">处推送通知</li>
				</ul>
				<div id = "consoleGroup">
					<div data-consoletype="log" class="consoleContent">
						<table>
							<tr>
								<td>
									<table>
										<tr>
											<th width="15%">处理时间</th>
											<td width="30%"><input type="text" id="txtExetime"> <span class="icon icon2 clickable">&nbsp;</span> </td>
											<th width="15%">填报时间</th>
											<td width="30%"><input type="text" id="txtInputtime"><span class="icon icon2 clickable">&nbsp;</span></td>
										</tr>									
										<tr>
											<th>处置描述</th>
											<td colspan="3">
												<textarea rows="1" cols="1"></textarea>
											</td>
										</tr>
									</table>
								</td>
								<td id="btnTd" width="10%" rowspan="2">
									<button class="btn" value="更新">更新</button>
									<button class="btn hbth">提交</button>
								</td>
							</tr>
						</table>
					</div>
					<div data-consoletype="sms" class="consoleContent"></div>
					<div data-consoletype="notice" class="consoleContent"></div>
				</div>
			</div>
			<div id="statusBox">
				<div class="tit">
					<table>
						<tr>
							<td width="17%" id="titTd"><span class="icon icon5">&nbsp;</span>节点信息</td>
							<th width="8%">节点名称</th>
							<td width="15%"><select></select> </td>
							<th width="8%">参与人 </th>
							<td  ><input type="text" class="sortTxt" /><span class="icon icon3 clickable">&nbsp;</span> </td>
							<th width="8%">节点状态</th>
							<td width="15%"><select></select></td>
							<td width="10%" class="btnTd"> <button class="btn hbth" >查看日志</button></td>
						</tr>
					</table>
				</div>
				<div id = "statusList">
					<table>
						<tr>
							<th><input type="checkbox"  ></th>
							<th>节点名称</th>
							<th>参与人 </th>
							<th>预计开始时间</th>
							<th>预计结束时间</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>预计用时</th>
							<th>实际用时</th>
							<th>处置日志</th>
						</tr>
						<tr>
						</tr>
					</table>
				</div>
			</div>
		</div>
</div>
	</div>
</body>
<script type="text/javascript">

</script>
</html:html>