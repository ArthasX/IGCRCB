<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGIOP0103" toScope="request"/>
<bean:define id="title"  toScope="request" value="IP分配"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style type="text/css">
	.table{
/* 		width:90%; */
		border-collapse: collapse;
		margin-top: 5px;
	}
	.table td{
		height: 25px;
		text-align: center;
		vertical-align: middle;
		border: 1px solid black;
		font-size: 14px;
		font-weight: 400;
		width:56px;
	}
	.table th{
	}
	#dvIPS{
		padding-left:20px;
		padding-right:20px;
		text-align: left;
	}

	.tdFree{
		filter:progid:DXImageTransform.Microsoft.gradient(startcolorstr=#E1EBEF,endcolorstr=#4BA7FF, gradientType=0 );
		cursor: pointer;
	}
	.filldiv{
		height: 100%;
		width: 100%;
		line-height: 25px;
	}
	.tdUsed{
		filter:progid:DXImageTransform.Microsoft.gradient(startcolorstr=#E1EBEF,endcolorstr=#00ff00, gradientType=0 );
	}
	.tdEdit{
		filter:progid:DXImageTransform.Microsoft.gradient(startcolorstr=#E1EBEF,endcolorstr=#FF9343, gradientType=0 );
		cursor: pointer;
	}
	#naviUL{
		list-style: none;
		width: 95%;
	}
	#naviUL li{
		float: left;
		width: 100px;
		height: 30px;
		cursor: pointer;
		line-height: 30px;
		font-size: 16px;
		text-align: center;
		margin: 5px;
	}
	.curLi{
		color:#fff;
		background-image: url("./images/bb.gif");
	}
	.defauLi{
		color:#000;
		background-image: url("./images/aa.gif");
	}
	.titleTH{
		text-align: left;;
		height: 30px;
		font-size: 18px;
		font-weight: 800;
	}
	.titleTH span{
		height:100%;
		filter:progid:DXImageTransform.Microsoft.gradient(startcolorstr=#E1EBEF,endcolorstr=#4BA7FF, gradientType=0 );
	}
</style>

<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />

<script type="text/javascript">

	function toback(){
		document.forms[0].action = getAppRootUrl()+"/IGIOP0102_Back.do";
		document.forms[0].submit();
	}

	
		function clickTd(obj){
			var j = jQuery(obj);
			if(j.find(":hidden[name]").length>0){
				j.removeClass("tdEdit");
				jQuery(j.find(":hidden").get(0)).removeAttr("name");
			}else{
				j.addClass("tdEdit");
				jQuery(j.find(":hidden").get(0)).attr("name","eiids");
			}
				
		}
	
	function checkIP(){
		
		if(jQuery("td > :hidden[name]").length==0){
			alert("请选出至少一个IP地址");
			return false;
		}
			
	}
	function addNavi(txt,index){
		txt = txt.trim();
		jQuery("#naviUL").append("<li id='li"+index+"' class='defauLi' onclick='selLi(this)'>"+txt+".</li>");
		if(jQuery("#naviUL").children().length==1){
			jQuery("#naviUL li:first").removeClass("defauLi").addClass("curLi");
		}
	}
	function selLi(obj){
		
		jQuery(obj).parent().children().removeClass("curLi").addClass("defauLi");
		jQuery(obj).removeClass("defauLi").addClass("curLi");
	//	jQuery(".table").hide();
		jQuery("div[id^='tb']").hide();
		jQuery("#tb"+obj.id.substring(2)).show();
			
		
	}
	
	
</script>
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
                  <p class="fonts1">网络管理 &gt;&gt; 子网管理 &gt;&gt; 子网管理&gt;&gt; IP分配</p>
                 <div class="back" >
					<html:link href="javascript:toback();">
						<bean:message bundle="asmResources" key="button.IGCIM0106.btn_toback"/>
					</html:link>
				</div>
        	</div> 
            <html:form action="IGIOP0102_Edit" method="POST">
            <ig:message/>
            <div id="dvIPS">
            	<ul id="naviUL"></ul>
            			<!-- 定义临时变量 -->
           			<bean:define id="tempBean" value=""></bean:define>
            		<logic:iterate id="bean" name="IGIOP01021VO" property="ipList" type="com.deliverik.framework.soc.asset.model.SOC0118Info" indexId="index">
            			<bean:define id="IPAddr" value="${fn:split(bean.einame,'.')[0] }.${fn:split(bean.einame,'.')[1] }.${fn:split(bean.einame,'.')[2] } "></bean:define>
						
						<logic:notEqual name="tempBean" value="${IPAddr}">
								<script>addNavi('${IPAddr }','${index}')</script>
            				<c:set var="tbIndex" value="0"></c:set>
	            				<logic:equal name="index" value="0" >
	            				<div id="tb${index}">
            				 		<div class="titleTH"><span>${fn:substring(bean.eilabel,0,fn:indexOf(bean.eilabel,"_")) } _${IPAddr }</span></div>
	            				 <table class="table" >
	            				 <tr>
	            				</logic:equal>
	            				<logic:notEqual name="index" value="0" >
	            				 </tr></table> </div>
	            				 <div id="tb${index}" style="display: none;">
	            				 <div class="titleTH"><span>${fn:substring(bean.eilabel,0,fn:indexOf(bean.eilabel,"_")) } _${IPAddr }</span></div>
	            				 <table class="table" >
	            				 <tr>
	            				</logic:notEqual>
							<c:set var="tempBean" value="${IPAddr }" > </c:set>
	            			</tr>
	            			
						</logic:notEqual>   
						
						
						
						<c:set var="tbIndex" value="${tbIndex+1 }"></c:set>   
            			<logic:empty name="bean" property="eidesc">
            				<td class="tdFree" onclick="clickTd(this)"><div class="filldiv">${fn:substring(bean.einame,fn:length(IPAddr),fn:length(bean.einame)) }</div><input type="hidden"  value="${bean.eiid }"/> </td>
            			</logic:empty>
            			<logic:notEmpty name="bean" property="eidesc">
	            			<td class="tdUsed" title="${bean.eidesc}"> <div class="filldiv">${fn:substring(bean.einame,fn:length(IPAddr),fn:length(bean.einame)) }</div></td>
            			</logic:notEmpty>
            			<c:if test="${(tbIndex)%16==0 }">
            				</tr>
            				<tr>
            			</c:if>
            			
            		</logic:iterate>
            	
            		</tr>
            	</table></div>
            	<c:if test="${fn:length(IGIOP01021VO.ipList)>0 }">
		            <div class="enter">
			       		<html:submit styleClass="button" style="margin-top:10px;" onclick="return checkIP()">下一步</html:submit>     
		            </div>
            	</c:if>
            	<c:if test="${fn:length(IGIOP01021VO.ipList)==0 }">
		            <div class="enter">
			       		<html:submit styleClass="button" style="margin-top:10px;"  onclick="toback()">返回</html:submit>     
		            </div>
            	</c:if>
           </div>
            
	       
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>

</body>
</html:html>