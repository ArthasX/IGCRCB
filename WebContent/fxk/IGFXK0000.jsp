<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGFXK0000" toScope="request" />
<bean:define id="title" value="风险管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/risk.css" rel="stylesheet" />
<script type="text/javascript">	
jQuery(document).ready(function() {
	//风险首页，切换到风险评估工作tab，选择“个人/全部”，刷新后应该还保留在风险评估工作tab
	if('${flag}'=='pgselect'){
		showa();
	}
	var qdlistsize=jQuery("#qdlistsize").val();
	var qmlistsize=jQuery("#qmlistsize").val();
	var prlistsize=jQuery("#prlistsize").val();
	var risklistsize=jQuery("#risklistsize").val();
	var pglistsize = jQuery("#pglistsize").val();
	if(pglistsize<4){
		document.getElementById("pgmore").style.display="none";
	}else{
		document.getElementById("pgmore").style.display="";	
	}
	if(qdlistsize<4){
		//风险清单更多 显示隐藏
		document.getElementById("qdlistsizemore").style.display="none";
	}
	else{
		document.getElementById("qdlistsizemore").style.display="";
	}
	if(qmlistsize<4){
		//问题整改 更多 按钮  显示隐藏
		document.getElementById("qmlistsizemore").style.display="none";
	}
	else{
		document.getElementById("qmlistsizemore").style.display="";
	}
	if(prlistsize<4){
		//风险计划   更多按钮  显示隐藏
		document.getElementById("prpglistsizemore").style.display="none";
	}
	else{
		document.getElementById("prpglistsizemore").style.display="";
	}
	if(risklistsize<=1){
		//风险提示  更多按钮 显示隐藏 	
		document.getElementById("risklistsizemore").style.display="none";
	}
	else{
		document.getElementById("risklistsizemore").style.display="";
	}
});
function hidea(){


	document.getElementById("fxp").style.display="none";
	document.getElementById("fxj").style.display="";
	jQuery("#f2").removeClass("fxpg hover");
	jQuery("#f1").addClass("hover");
	jQuery("#f2").removeClass("fxpg1");
	jQuery("#selectjh").show();
	jQuery("#selectpg").hide();
	//jQuery("#f2").addClass("fxpg1");
	var prlistsize=jQuery("#prlistsize").val();
	jQuery("#riskpggz").hide();
	jQuery("#riskjhgz").show();
	if(prlistsize<4){
		document.getElementById("prpglistsizemore").style.display="none";
	}
	else{
		document.getElementById("prpglistsizemore").style.display="";
	}
}
function showa(){

	
	document.getElementById("fxp").style.display="";
	document.getElementById("fxj").style.display="none";
	jQuery("#f1").removeClass("hover");
	jQuery("#f1").addClass("fxpg");
	jQuery("#f2").removeClass("fxpg");
	jQuery("#f2").addClass("fxpg hover");
	jQuery("#riskpggz").show();
	jQuery("#riskjhgz").hide();
	jQuery("#selectjh").hide();
	jQuery("#selectpg").show();
	
	var pglistsize=jQuery("#pglistsize").val();
	if(pglistsize<4){
		document.getElementById("prpglistsizemore").style.display="none";
	}
	else{
		document.getElementById("prpglistsizemore").style.display="";
	}
}


function detailRiskWar(rwid){
window.showModalDialog(getAppRootUrl() +"/IGFXK0701_T.do?rwid="+rwid+"", null,
			"dialogWidth:900px;dialogHeight:500px;status:no;help:no;resizable:yes");
}

function riskselect(){
	var type = document.getElementById("riskselecttype").value;
	document.getElementById("pgworkselecttype").value = type;
	if(type==""||type==null){
		type=0;
	}
	window.location.href=getAppRootUrl() +"/IGFXK0000.do?actname=ACT03FXK&riskselecttype="+type+"&pgworkselecttype="+type+"&flag=riskselect";
}
function pgselect(){
	var type = document.getElementById("pgworkselecttype").value;
	document.getElementById("riskselecttype").value = type;
	if(type==""||type==null){
		type=0;
	}
	window.location.href=getAppRootUrl() +"/IGFXK0000.do?actname=ACT03FXK&riskselecttype="+type+"&pgworkselecttype="+type+"&flag=pgselect";
}

</script>
<body>
<div id="maincontent">
	<!-- header  头部和 一级菜单-->
	<jsp:include page="/include/header2.jsp" />
	<!--container 左菜单 右侧内容-->
	<div id="container">
		<!--content  右侧内容-->
		<div id="contentWrap">
			<div id="content">
			<!--第3横条开始-->
<div class="bar3">
<!--left开始-->
<div class="left">
  <div class="top"><span><img src="images/pic0007.gif" width="16" height="15" /></span>风险总体情况</div>
  <div class="fxlistbox">
    <ul>
     <li><span>[ <a href="IGASM2714.do?&actname=ACT03FXK0101" class="cBlack">${IGFXK0700Form.riskCount }</a> ]</span><div class="fxpic"><img src="images/fxpic02.jpg" width="21" height="21" /></div>风险点</li>
     <li><span>[ <a href="IGASM2814.do?&actname=ACT03FXK0201" class="cBlack">${IGFXK0700Form.checkCount }</a> ]</span><div class="fxpic"><img src="images/fxpic01.jpg" width="21" height="21" /></div>检查项</li>
     <li><span>[ <a href="IGASM3201.do?eistatus=1&showFlag=1" class="cBlack">${IGFXK0700Form.qdExcing }</a> ]</span><div class="fxpic"><img src="images/fxpic05.jpg" width="21" height="21" /></div>风险清单（未关闭）</li>
     <li><span>[ <a href="IGASM3201.do?eistatus=2&showFlag=1" class="cBlack">${IGFXK0700Form.qdYear }</a> ]</span><div class="fxpic"><img src="images/fxpic06.jpg" width="21" height="21" /></div>风险清单（年度）</li>
     <li><span>[ <a href="IGWKM0103.do?prtype=WD&prpdid=01001&prActive=Y&actname=ACT03FXK0401" class="cBlack">${IGFXK0700Form.pgExcing }</a> ]</span><div class="fxpic"><img src="images/fxpic03.jpg" width="21" height="21" /></div>评估工作（正在执行）</li>
     <li><span>[ <a href="IGWKM0103.do?prtype=WD&prpdid=01001&actname=ACT03FXK0401" class="cBlack">${IGFXK0700Form.pgYear }</a> ]</span><div class="fxpic"><img src="images/fxpic04.jpg" width="21" height="21" /></div>评估工作（年度）</li>
    </ul>
  </div>
</div>
	<!--left_end-->
<!--right开始-->
<div class="right">
 <div class="top"><span><img src="images/pic0008.gif" width="16" height="15" /></span>风险提示<div class="more"><a id="risklistsizemore" href="IGFXK0701_Search.do" class="cRed">更多>></a></div></div>
 <input id="risklistsize" type="hidden" value="${risklistsize}">
 <div class="fxlistbox1">
  <logic:present name="IGFXK01011VO" property="voList">
				<logic:iterate id="bean1" name="IGFXK01011VO" property="voList" indexId="index1"> 
					<c:if test="${index1<1}">
						 <div class="menu"  style="cursor:hand;" onclick="detailRiskWar(${bean1.risk.rwid})">
						 <div class="fxpic1" ><img src="images/fxpic07.jpg" width="14" height="15" /></div> ${bean1.risk.rwname}</div>
		    			 <div class="nr"  title='${fn:replace(fn:replace(bean1.risk.rwcontext,"<p>",""),"</p>","")}' style="width:100%; height:25px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">
		    			 ${fn:replace(fn:replace(bean1.risk.rwcontext,"<p>",""),"</p>","")}</div>
					</c:if> 
				</logic:iterate>
			</logic:present>
 <div class="nrlist">
			<span class="more" > <a href="IGFXK0701_Search.do"></a></span>
			
			 <ul>
			<logic:present name="IGFXK01011VO" property="voList">
				<logic:iterate id="bean" name="IGFXK01011VO" property="voList" indexId="index"> 
				<c:if test="${(index <3)&&(index>0)}">
				<div style="height:20px;cursor:hand;margin-top:5px;width:400px;float: left;margin-left:5px" onclick="detailRiskWar(${bean.risk.rwid})">
				
				 <li><span>&nbsp;&nbsp;[ ${bean.risk.showTime }]</span><div class="fxpic2"><img src="images/fxpic08.jpg" width="6" height="6" /></div>${bean.risk.rwname}</li>
				</div>
			

  	 			<c:if test="${(index+1)%2==0 }">
				<br />
				</c:if> 
				 </c:if>
			</logic:iterate>
			</logic:present>
			 </ul>
		
 </div>
 </div>
</div>
<!--right_end-->
</div>
<!--第3横条_end-->


<!--第2横条开始-->
  
  <div class="bar2">
  
  <!--最新动态等切换栏目开始-->
  <div class="left">
   
   <div class="qiehuan">
   


<!--标题开始-->
        
		<div  class="qiehuan-menubox"> 
			<ul>
			<li class="hover">&nbsp;风险事件清单（${qdlistsize}）</li> <input id="qdlistsize" type="hidden" value="${qdlistsize}">
		
			</ul>
		</div> 
        
<div class="qiehuan-menubox31"><a id="qdlistsizemore" href="IGASM3201.do" class="cRed">更多>></a></div>
<!--标题结束-->		

		<div  class="Contentbox" style=" height:187px;">  
			 <div>
			   <div class="Contentbox-qiehuan">  
					  
		<div class="k">
            <table width="707" border="0" cellspacing="0" cellpadding="0" class="table">
 			<tr>
				<th width="20%">风险事件名称</th>
				<th width="15%">风险识别时间</th>
				<th width="15%">风险事件来源</th>
				<th width="20%">应对策略</th>
				<th width="15%">应对负责人</th>
				<th width="15%">状态</th>
			</tr>
			<tr>
				<logic:present name="IGFXK01011VO" property="qdList">
				<logic:iterate id="bean" name="IGFXK01011VO" property="qdList" indexId="index3">
					<c:if test="${index3<5 }">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${index }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGASM3203_Disp.do?eiid=${bean.EIID}');">				
					<td class="tdbg${index3%2 }">
						${bean.fcname}
					</td>
					<td class="tdbg${index3%2 }">
						${bean.riskcatchtime}
					</td>
					<td class="tdbg${index3%2 }">
					<ig:codeValue ccid="RISK_CASE_ORIGIN" cid="${bean.fcorigin}"/>
						
					</td>
					<td class="tdbg${index3%2 }">
					<ig:codeValue ccid="RISK_POLICY" cid="${bean.fcpolicy}"/>
					</td>
					<td class="tdbg${index3%2 }">
						${bean.fcoperator}
					</td>
					<td class="tdbg${index3%2 }">
						<ig:codeValue ccid="RISK_STATUS" cid="${bean.EISTATUS}"/>
					</td>
			</tr>
			</c:if>
			</logic:iterate>
		</logic:present>
                        </table>

                 </div>
			   </div>
			 </div>
						
	
      
         
	    </div>
	</div>
  </div>
   
   <!--最新动态等切换栏结束-->
   

</div>

<!--第2横条结束-->

<!--第2横条开始-->
  
  <div class="bar2">
  
  <!--最新动态等切换栏目开始-->
  <div class="left">
   
   <div class="qiehuan">
   


<!--标题开始-->
   
		<div  class="qiehuan-menubox"> 
			<ul>
			<li   id="f1" onclick="hidea()"  class="hover">&nbsp;风险计划（${prlistsize}）
			<input id="prlistsize" type="hidden" value="${prlistsize}"/>
			</li>
	        
			<li  class="fxpg" id="f2" onclick="showa()" >&nbsp;风险评估工作（${pglistsize}）
			<input id="pglistsize" type="hidden" value="${pglistsize}"/>
			</li> 
			</ul>
		</div> 
        <div class="qiehuan-menubox2" id="selectjh">	
        <html:select property="riskselecttype" name="IGFXK0700Form" onchange="riskselect();">
				<html:option value="">全部</html:option>
				<html:option value="1">个人</html:option>
        </html:select>
        </div>
        <div class="qiehuan-menubox2" id="selectpg" style="display:none;">	
        <html:select property="pgworkselecttype" name="IGFXK0700Form" onchange="pgselect();">
				<html:option value="">全部</html:option>
				<html:option value="1">个人</html:option>
        </html:select>
        </div>
<div  id="riskjhgz" class="qiehuan-menubox3"><a id="prpglistsizemore" href="IGFXK0303_Search.do" class="cRed">更多>></a></div>
<div id="riskpggz" style="display:none" class="qiehuan-menubox3"><a id="pgmore" href="IGWKM0103.do?prtype=WD&prpdid=01001&actname=ACT03FXK0401" class="cRed">更多>></a></div>
<!--标题结束-->		

		<div  class="Contentbox" style=" height:187px;">  
			 <div  id="con_f_1" class="hover">
			   <div class="Contentbox-qiehuan">  
					  
					  <div id="fxj" class="k">
					
                        <table width="707" border="0" cellspacing="0" cellpadding="0" class="table">
  <tr>
				<th width="10%">风险计划编号</th>
				<th width="20%">风险计划标题</th>
				<th width="15%">风险计划类型</th>
				<th width="15%">计划开始时间</th>
				<th width="20%">计划结束时间</th>
				<th width="20%">状态</th>
			</tr>
			<logic:present name="IGFXK01011VO" property="prList">
			<logic:iterate id="bean" name="IGFXK01011VO" property="prList"
				indexId="index">
				<c:if test="${index<5 }">
				<bean:define id="prtype" name="bean" property="prtype" />
					<tr style='cursor:hand'  onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=131');">
					<td class="tdbg${index%2 }">
						<bean:write name="bean" property="prserialnum" />
					</td>
					<td class="tdbg${index%2 }">
						<bean:write name="bean" property="prtitle" />
						<%-- 
						<ig:publicProcessInfoValue pidname="计划标题" prid="${bean.prid}"/>
						 --%>
					</td>
					<td class="tdbg${index%2 }">
						<ig:publicProcessInfoValue pidname="计划分类" prid="${bean.prid}"/>
					</td>
					<td class="tdbg${index%2 }">
						<ig:publicProcessInfoValue pidname="计划开始日期" prid="${bean.prid}"/>
					</td>
					<td class="tdbg${index%2 }">
						   <ig:publicProcessInfoValue pidname="计划结束日期" prid="${bean.prid}"/>
					</td>
					<td class="tdbg${index%2 }">	
							<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
					</tr>
					</c:if>
			</logic:iterate>
		</logic:present>
                        </table>

                 </div>
                  <div class="k"  id="fxp" style="display:none">
                
                        <table width="707" border="0" cellspacing="0" cellpadding="0" class="table">
 <tr>
				<th width="10%">风险评估编号</th>
				<th width="20%">风险评估名称</th>
				<th width="15%">计划开始时间</th>
				<th width="15%">计划结束时间</th>
				<th width="20%">风险评估发起人</th>
				<th width="20%">状态</th>
			</tr>
			<tr>
				<logic:present name="IGFXK01011VO" property="pgList">
			<logic:iterate id="bean" name="IGFXK01011VO" property="pgList"
				indexId="index">
				<c:if test="${index<5 }">
				<bean:define id="prtype" name="bean" property="prtype" />
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=131');">
					<td class="tdbg${index%2 }">
						<bean:write name="bean" property="prserialnum" />
					</td>
					<td class="tdbg${index%2 }">
					    <bean:write name="bean" property="prtitle"/>
					</td>
					
					<td class="tdbg${index%2 }">
					  <ig:publicProcessInfoValue pidname="评估开始时间" prid="${bean.prid}"/>
					</td>
					<td class="tdbg${index%2 }">
					  <ig:publicProcessInfoValue pidname="评估结束时间" prid="${bean.prid}"/>
					</td>
					<td class="tdbg${index%2 }">
						<bean:write name="bean" property="prusername" />
					</td>
					<td class="tdbg${index%2 }">	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
					</tr>
			</c:if>
			</logic:iterate>
		</logic:present>
                        </table>

                 </div>
			   </div>
			 </div>
						

                      
		
	    </div>
	</div>
  </div>
   
   <!--最新动态等切换栏结束-->
   

</div>

<!--第2横条结束-->

<!--第2横条开始-->
  
  <div class="bar2">
  
  <!--最新动态等切换栏目开始-->
  <div class="left">
   
   <div class="qiehuan">
   


<!--标题开始-->
        
		<div  class="qiehuan-menubox"> 
			<ul>
			<li class="hover">&nbsp;问题整改（${qmlistsize}）</li> <input id="qmlistsize" type="hidden" value="${qmlistsize}">
			</ul>
		</div> 
		<div class="qiehuan-menubox2"></div>
<div class="qiehuan-menubox3"><a id="qmlistsizemore" href="IGWKM0103.do?&prtype=WD&prpdid=01002&actname=ACT03FXK0601" class="cRed">更多>></a></div>
<!--标题结束-->		

		<div  class="Contentbox" style=" height:187px;">  
			 <div>
			   <div class="Contentbox-qiehuan">  
					  
					  <div class="k">
                        <table width="707" border="0" cellspacing="0" cellpadding="0" class="table">
  <tr>
				<th width="10%">问题整改编号</th>
				<th width="20%">问题整改标题</th>
				<th width="15%">问题整改来源</th>
				<th width="15%">问题整改开始日期</th>
				<th width="20%">问题整改结束日期</th>
				<th width="20%">状态</th>
			</tr>
			<tr>
				<logic:present name="IGFXK01011VO" property="qmList">
			<logic:iterate id="bean" name="IGFXK01011VO" property="qmList" indexId="index6">
				<c:if test="${index6<5 }">
				<bean:define id="prtype" name="bean" property="prtype" />
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=131');">
					<td class="tdbg${index6%2 }">
						<bean:write name="bean" property="prserialnum" />
					</td>
					<td class="tdbg${index6%2 }">
					    <bean:write name="bean" property="prtitle" />
					</td>
					<td class="tdbg${index6%2 }">
						<ig:publicProcessInfoValue pidname="问题整改来源" prid="${bean.prid }"/>
					</td>
					<td class="tdbg${index6%2 }"><ig:publicProcessInfoValue pidname="整改开始时间" prid="${bean.prid }"/>
					</td>
					<td class="tdbg${index6%2 }"><ig:publicProcessInfoValue pidname="整改结束时间" prid="${bean.prid }"/>
					</td>
					<td class="tdbg${index6%2 }">	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
				</tr>
					</c:if>
			</logic:iterate>
		</logic:present>
                        </table>

                 </div>
			   </div>
			 </div>
						     
	    </div>
	</div>
  </div>
   
   <!--最新动态等切换栏结束-->
   

</div>

<!--第2横条结束-->

			</div>
		</div>
	</div>
</div>


</body>
</html:html>
