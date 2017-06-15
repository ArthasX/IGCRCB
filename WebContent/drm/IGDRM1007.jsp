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
<bean:define id="id" value="IGDRM1007" toScope="request" />
<bean:define id="title" value="应急组织架构图" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
#orgtree {
	position: relative;
}


#orgWarp{
	width: 58%;
	float: left;
/* 	height: 610px; */
/* 	overflow: scroll; */
	position: relative;
}
#orgList {
	width: 41%;
	float: left;
}
#orgtree #orgtreetb{
	width: 98%;
}
#orgtree table {
	border: 0px;
	border-collapse: collapse;
	text-align: center;
	vertical-align: middle;
	width: 100%;
	background: #C7CCD2;
}

#orgtree table div {
	text-align: center;
}

#orgtree table #titOrg {
	writing-mode: tb-rl;
	font-size: 16px;
	color: #fff;
	background-color: #BB0116;
	width: 2.9em;
	font-family:'微软雅黑', 'Microsoft YaHei UI';
	height: 8.5em;
	vertical-align: middle;
	background-image: url("images/drm/p08.png");
}

#orgtree table  .orgBox {
	background-color: #fff;
	height: 44px;
	width: 160px;
}

#orgtree table  .orgBox div {
	text-align: left;
	float: left;
	height: 100%;
	vertical-align: middle;
	line-height: 20px;
}

.orgBox .icon {
	width: 44px;
	background-color: #BB0214;
}

.roleBox {
	background-color: #fff;
	height: 40px;
	width: 200px;
	cursor: pointer;
}

#orgtree table .roleBox .icon {
	width: 40px;
	background-color: #BB0214;
}
#orgtree table .tit{
	font-size: 13px;
	font-weight: 600;
}
#orgtree table .account{
background-image:url("images/drm/p07-1.png");
background-position:-2px -4px;
background-repeat:no-repeat;
text-indent:2em;
	color: #858686;
}
#orgtree table .roleBox span{
	display: inline-block;
}
#orgtree table .content{
	padding-left: 1em;
	padding-top: 1
	px;
}

#orgtree table  .roleBox div {
	text-align: left;
	float: left;
	height: 100%;
	vertical-align: middle;
	line-height: 20px;
}
#orgtree table .roleTd{
	height: 50px;
}
#userrole_list{
	margin-top: 10px;
}
#orgList .roletd{
	background-color:#BB0214 ;
	color: #fff;
	font-size: 15px;
	height: 1.9em;
	vertical-align: middle;
	font-weight: 600;
}
#orgList th{
	color: #000;
	font-weight: 600;
}
.curRoleTd{
	background:#F39A00 !important; 
}
.curIcon{
background-image:url("images/drm/p07.png")!important;
}
.orgBox .icon{
	background-image: url("images/drm/p03.png")!important;
	background-position: -2px -4px!important;
}
.roleBox .icon{
	background-image: url("images/drm/p06.png")!important;
	background-position: -4px -3px!important;
}
#titOrg{
	
}
.ellips{
width:100%; 
white-space:nowrap; 
text-overflow:ellipsis; 
overflow:hidden;
}
#location{
	padding-bottom: 5px;
}
</style>

<%! 	private String getFullOrgName(OrganizationTB orgTB) {
	if (orgTB.getOrganizationTB() != null && !orgTB.getOrgpar().equals("0001")) {
		String[] parNameArr = orgTB.getOrgparname().split("-");
		String[] orgNameArr = orgTB.getOrgname().split("-");
		return parNameArr[parNameArr.length > 0 ? parNameArr.length - 1 : 0] + "-" + orgNameArr[orgNameArr.length > 0 ? orgNameArr.length - 1 : 0];
	} else {
		return orgTB.getOrgname();
	}
} %>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
<%-- 		<jsp:include page="/include/header2.jsp" /> --%>
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">

					<html:form styleId="form" action="/IGDRM1007_Disp">
						<div id="location">
<!-- 							<div class="image"></div> -->
							<p  style="font-size: 26px;width:400px;display:inline; font-family: 'heiti';font-weight: 600;">
									常熟农商行应急组织架构图
									
							</p>
								<span style="margin-right:0px;margin-top:0px;text-align:right;color:blue; cursor:pointer; display:inline-block; width:620px;  font-size : 12px">
									<button onclick="exportExl()"  class="button" style="float: right;text-align:center; line-height:25px;">导出</button>
								</span>
							
						</div>
						<div id="userrole_list">
							<!-- 组织架构树 -->
							<div id="orgWarp">
							<div id="orgtree">
								<table id="orgtreetb">
									<tr>
										<td style="width: 50px;">
											<div id="titOrg">&nbsp;</div>
										</td>
										<td>
											<table>
												<!-- 遍历组织架构下的层次 -->
												<logic:present name="IGDRM10031VO" property="orgArr">
													<c:forEach var="orgMap" items="${IGDRM10031VO.orgArr }">
														<tr id = "org${orgMap.key }" data-syscoding="${orgMap.key }">
															<td style="width: 270px">
																<div class="orgBox">
																	<div class="icon">&nbsp;</div>
																	<div class = "content">
																		<span class="tit" title="${orgMap.value['name'] }"><div style="width:100%; height:50%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${orgMap.value['name'] }</div> </span>
																		<span class="account"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${orgMap.value['sumUser'] }人</span>
																		
																	</div>
																</div>
															</td>
															<td>
																<!-- 遍历层次下的岗位 --> <c:set var="roleArr"
																	value="${orgMap.value['roleArr'] }"></c:set>
																<table>
																	<c:forEach var="roleMap" items="${roleArr }">
																		<tr data-roleid="${orgMap.key }_${roleMap.key }">
																			<td class="roleTd">
																				<div class="roleBox">
																					<div class="icon"></div>
																					<div class = "content">
																						<span class="tit" title="${roleMap.value['roleName'] }"><div style="width:100%;height:50%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${roleMap.value['roleName'] }</div></span>
																						<span class="account"> ${roleMap.value['sumUser'] }人</span>
																					</div>
																				</div>
																			</td>
																		</tr>
																	</c:forEach>
																</table>
															</td>
														</tr>

													</c:forEach>
												</logic:present>
											</table>

										</td>
									</tr>

								</table>
							</div>
							</div>
							<!-- 人员信息 -->
							<div id="orgList">
								<logic:present name="IGDRM10031VO" property="structureRoleList">
									<table class="table_style" id="table1" cellspacing="0"
										cellpadding="0" style="border-collapse: collapse;" >
										<logic:iterate id="bean" name="IGDRM10031VO"
											property="structureRoleList" indexId="index">
											<tr data-roleid = "${bean.syscoding }_${bean.roleid }" class="roletd" >
												<td style="border: 1px solid #ccc;">${bean.rolename}</td>
											</tr>
											<tr>
												<td  style="padding: 0px; border: 0px;">
													<table class="table_style" style="border: 0px;">
														<logic:present name="IGDRM10031VO" property="userRoleMap">
														<tr>
															<th>姓名</th>
															<th>部门</th>
															<th>联系方式</th>
															<th>邮箱</th>
														</tr>
															<logic:iterate id="map" name="IGDRM10031VO"	property="userRoleMap" indexId="index1">
																<c:if test="${bean.roleid ==map.key}">
																	<bean:define id="list" name="map" property="value"
																		type="java.util.ArrayList" />
																	<logic:iterate id="bean1" name="list" type="com.deliverik.framework.user.model.entity.UserTB">
																		<tr>
																			<td align="center" style="border: 1px solid #ccc;">${bean1.username}</td>
																			<td align="center" style="border: 1px solid #ccc;"><%=getFullOrgName(bean1.getOrganizationTB()) %></td>
																			<td align="center" style="border: 1px solid #ccc;">${bean1.usermobile}</td>
																			<td align="center" style="border: 1px solid #ccc;">${bean1.useremail}</td>
																		</tr>
																	</logic:iterate>
																</c:if>
															</logic:iterate>
														</logic:present>
													</table>
												</td>
											</tr>
										</logic:iterate>
									</table>
								</logic:present>
							</div>
						</div>
					</html:form>
				</div>
			</div>
		</div>


	</div>
</body>
<script type="text/javascript">
function showRoleDetail(syscoding){
	 form.action = getAppRootUrl() + "/IGDRM1007_Disp.do?syscoding="+syscoding;
     form.submit();
}

/**
 * 画线到子集上并装载子集对象
 */
function lineToChild(parObj,domArr,lineLevel){
	
	var children = [];
	
	domArr.each(function(i,t){
		var _t = jQ(t);
		var childObj = {
				dom:_t,
				position:_t.position(),
				parObj:parObj,
				parLinePosition : function(){return{x:this.position.left,y:this.position.top+_t.height()/2}},
				childLinePosition : function(){return{x:this.position.left+_t.width(),y:this.position.top+_t.height()/2}},
				parLine:[]
		}
		
        children.push(childObj);
		
		//画出折线
        drawTurnLine(parObj,childObj,lineLevel);
        
			window.orgMap = window.orgMap||{};
        if(lineLevel==1){
        	childObj.children = lineToChild(childObj,childObj.dom.parent().parent().find(".roleBox"),2);
        }else{
        }
	});
	return children;
	
}


jQuery(function(){
	
// 	jQ("body").width(1024).height(768).css("overflow","scroll");
	//滚动的距顶距离
	var marTop = 40;
	window.startTime = new Date().getTime();
	var orgBoxArr = jQ(".orgBox"),roleBoxArr = jQ(".roleBox"),titBox = jQ("#titOrg");
	
	window.firstTurnX = jQuery(orgBoxArr[0]).position().left-30;
	window.secondTurnX = jQuery(roleBoxArr[0]).position().left-50;
	
	var titObj = {
			dom : titBox,
			position : titBox.position(),
			childLinePosition :function(){return{x:this.position.left+titBox.width(),y:this.position.top+titBox.height()/2}}
	}
	
	//画线
	titObj.children = lineToChild(titObj,orgBoxArr,1);
	
	
	//滚动
	//设置列表容器的高,使其小于等于树容器的高,并且开启自动滚动
	if(jQuery("#orgWarp").height()<jQuery("#orgList").height()){
		
		//装载所有列表中的岗位的高度到map中 key=高度,value = 岗位的标题的dom元素
		window.orgPosiMap = {};
		jQuery(".roletd").each(function(i,t){
			
			orgPosiMap[jQuery(t).position().top-marTop+18] = jQ(t);
			jQ("#orgtreetb tr[data-roleid='"+jQ(t).data("roleid")+"'] .roleBox").data("scrollTop",jQ(t).position().top-marTop) ;
		})
		
		
		jQuery("#orgList").height(jQuery("#orgWarp").height());
		jQuery("#orgList").css({overflowY:"hidden",overflowX:"hidden"});
		jQuery("#orgList").append(jQuery("#orgList").html());
		window.orgTreeHeight = jQuery("#orgList table").height();
		setCur(jQ(".roletd:first").data("roleid"));
		
		//开始滚动
		window.scrollTimer = setInterval("scrollList()",50);
		
		//鼠标悬浮时停止滚动,离开时继续滚动
		jQ("#orgList").hover(function(){
			clearInterval(scrollTimer);
		},function(){
			window.scrollTimer = setInterval("scrollList()",50);
		});
		
		//架构树中岗位的点击事件
		roleBoxArr.click(function(e){
			var _this = jQ(this);
			setCur(jQ(_this).parent().parent().data("roleid"));
			clearInterval(scrollTimer);
			jQ("#orgList").animate({scrollTop: jQ(this).data("scrollTop")}, 300,function(){
			});
			
		})
		
// 		console.log("完成事件绑定>>>"+(new Date().getTime()-startTime));
	}else{
		loopList();
		window.loopTimer = setInterval("loopList()",2000);
		roleBoxArr.click(function(e){
			clearInterval(loopTimer);
			var _this = jQ(this);
			setCur(jQ(_this).parent().parent().data("roleid"));
			window.curBox = jQ("#orgList .curRoleTd:first");
		});
		//开始滚动
		//鼠标悬浮时停止滚动,离开时继续滚动
		jQ("#orgList").hover(function(){
			clearInterval(loopTimer);
		},function(){
			window.loopTimer = setInterval("loopList()",2000);
		});
// 		console.log("完成gundong>>>"+new Date().getTime()-startTime);
	}
	
	
});
//遍历列表
function loopList(){
		window.curBox = window.curBox||jQ(".roletd:first");
		setCur(curBox.data("roleid"));
		window.curBox = (window.curBox.next().next().length==0?jQ(".roletd:first"):window.curBox.next().next());
}


//滚动列表
function scrollList(){
	 var obj = jQuery("#orgList");
	if(orgPosiMap[obj.scrollTop()]){
		var roleid = orgPosiMap[obj.scrollTop()].next().next().data("roleid")||jQ("#orgList table[id='table1']:eq(1)").find(".roletd:first").data("roleid")
		setCur(roleid);
	}
		//如果滚动到重复的table时 滚回到最头部
	if(obj.scrollTop()>=orgTreeHeight){
		obj.scrollTop("1");
	}else{
		obj.scrollTop(1+(obj.scrollTop()||1));
	}
}
function setCur(roleid){
	jQ(".curRoleTd").removeClass("curRoleTd");
	jQ(".curIcon").removeClass("curIcon");
	jQ("#orgList").find("[data-roleid='"+roleid+"']").addClass("curRoleTd");
	
	jQ("#orgtreetb").find("[data-roleid='"+roleid+"']").find(".icon").addClass("curRoleTd").next().find(".account").addClass("curIcon");
	jQ("#orgtreetb").find("[data-syscoding='"+roleid.split("_")[0]+"']").find(".icon:first").addClass("curRoleTd").next().find(".account").addClass("curIcon");
}
/**
 * 划出折线
 */
function drawTurnLine(parObj,chlidObj,lineLevel){
	//第一个折点的坐标
	turnPositon1 = {
						y : parObj.childLinePosition().y,
						x : (lineLevel==1)?firstTurnX:secondTurnX
						},
	//第二个折点的坐标
	 turnPositon2 = {
			y : chlidObj.parLinePosition().y,
			x : (lineLevel==1)?firstTurnX:secondTurnX
			}				
	//从父划出横线
	chlidObj.parLine.push( drawDivLine(parObj.childLinePosition(),turnPositon1));
	//划出竖线
	chlidObj.parLine.push( drawDivLine(turnPositon1,turnPositon2));
	//从竖线画到子
	chlidObj.parLine.push( drawDivLine(turnPositon2,chlidObj.parLinePosition()));
	
	
}

/**
 * 通过div划出长线
 */
function drawDivLine(pos1,pos2){
	var oDiv=document.createElement('div');  
	oDiv.style.position='absolute';  
	oDiv.style.backgroundColor='#808D93';  
	oDiv.style.left = pos1.x+'px';  
	oDiv.style.top = (pos1.y < pos2.y?pos1.y:pos2.y)+'px';  
	//画竖线
	if(pos1.x == pos2.x){
		oDiv.style.height = Math.abs(pos2.y-pos1.y)+'px';  
		oDiv.style.width ='2px';  
			
	}else{
		//画横线
		oDiv.style.height = '2px';  
		oDiv.style.width = Math.abs(pos2.x-pos1.x)+'px';
		
	}
	return document.getElementById('orgtree').appendChild(oDiv);  
}

function exportExl(){
	window.location.href=getAppRootUrl()+"/IGDRM1007_Export.do";
}

</script>
</html:html>