<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3116" toScope="request"/>
<bean:define id="title" value="风险指标展示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script src="<html:rewrite forward='FusionCharts.js'/>"></script>
<script type="text/javascript">
       jQuery(document).ready(function(){
        	var divcss = {
        //		'color' : 'blue',
        		'font-weight' :'bolder'
			};
        	var li = jQuery(".dl_leftdb li");
        	li.each(function(index){
        		var li_a = jQuery(this).find("a");
        		var rimid = "${IGASM3116Form.rimid}";
               	if(li_a.attr("value") == rimid){
               		li_a.css(divcss);
               	}
            });
        }); 
        function switchSysBar() {
            var ssrc = document.all("frmTitle").style.display;
            if (ssrc == "none") {
                document.all("frmTitle").style.display = "";
            }
            else {
                document.all("frmTitle").style.display = "none"
            }
        } 
        
    	function setSWF(){
 	 	   chart.render("chartdiv");
 	 	}
    	function toback(){
    		window.location.href=getAppRootUrl() + "/IGASM3115_Disp.do";
        }
    	function onSearch(){
   			form.action = "IGASM3116.do";
   			form.submit();
    	}
    </script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />

<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
 <div id="contentWrap">
   <div id="content">
    <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>  </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div>
    </div>
	<div id="dl1">
		<div class="dl_left">
		     <div class="dl_lefttb">
		        <li>指标名称</li>
		     </div>
		     <div class="dl_leftdb">
	   			<logic:present name="IGASM31071VO" property="searchRiskIndexContextVW" >
	            <logic:iterate id="bean" name="IGASM31071VO" property="searchRiskIndexContextVW" indexId="index">
					  <li class="<ig:rowcss index="${index}"/> limitWords" ><span> >></span> <a value="${bean.rimid }" title="${bean.einame }"  href="IGASM3116.do?rimid=${bean.rimid }&esyscoding=${bean.esyscoding}&eiid=${bean.eiid}">${bean.einame }</a></li>
				</logic:iterate>
				</logic:present>
		     </div>
		</div>

		<div class="dl_right">
			<div class="title">
				<div class="name">风险指标基本信息</div>
			</div>
			<div id="results_list">
				<table class="table_style">
					<tr>
						<th width="10%">风险领域</th>
						<th width="10%">风险子域</th>
						<th width="8%">风险项</th>
						<th width="8%">指标编号</th>
						<th width="16%">指标名称</th>
						<th width="12%">指标说明</th>
						<th width="6%">登记人</th>
						<th width="6%">登记日期</th>
						<th width="8%">更新时间</th>
					</tr>
					<tr>
						<logic:present name="IGASM31071VO"
							property="searchRiskIndexSearchVWList">
							<logic:iterate id="bean" name="IGASM31071VO"
								property="searchRiskIndexSearchVWList" indexId="index">
								<td>${bean.riskly }</td>
								<td>${bean.riskarea}</td>
								<td>${bean.riskitem}</td>
								<td>${bean.eilabel}</td>
								<td>${bean.einame }</td>
								<td>${bean.eidesc}</td>
								<td>${bean.eiusername }</td>
								<td>${bean.eiinsdate }</td>
								<td>${bean.eiupdtime }</td>
							</logic:iterate>
						</logic:present>
					</tr>
				</table>
			</div>
			<%-- <c:if test="${IGASM3116Form.flag ==true }"> --%>
			<div class="title">
				<div class="name">风险指标属性信息</div>
			</div>
			<div id="TabbedPanels1" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup"></ul>
				<logic:notEmpty name="IGASM3116Form" property="RIMTYPE">
					<table class="table_style2">
						<tr>
							<td width="10%">指标模型</td>
							<td align="left" colspan="4">
							<c:if test="${IGASM3116Form.RIMTYPE == '1' }">
								柱状图
							</c:if> 
							<c:if test="${IGASM3116Form.RIMTYPE == '2' }">
								饼状图
							</c:if> 
							<c:if test="${IGASM3116Form.RIMTYPE == '3' }">
								线状图
							</c:if>		
							</td>
						</tr>
						<tr>
							<td width="15%">SQL语句</td>
							<td align="left" colspan="4">
							<label>
								<textarea name="textarea" id="textarea" cols="45" rows="5" readonly="readonly">${IGASM3116Form.RIMSQL }</textarea>
	                        </label>
							</td>
						</tr>
						<tr>
							<td width="15%">说明</td>
							<td align="left" colspan="4">${IGASM3116Form.RIMDESC }</td>
						</tr>
				</table>
			</logic:notEmpty>
			</div>
			<div class="title">
				<div class="name">流程管理统计</div>
			</div>
			<html:form styleId="form" action="/IGASM3116.do" onsubmit="return checkSubmit(this);">
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
				<div>
					<span style="font-size:15px;"><strong>统计条件</strong></span>
				</div>
				<div style="margin-top:12px;">
					<span class="subscribe">年份：</span>
			    	<html:select property="year" name="IGASM3116Form">
						<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
					</html:select>
					<c:if test="${IGASM3116Form.RIMTYPE =='2'}">
					<span class="subscribe">月份：</span>
					<html:select property="month" name="IGASM3116Form">
						<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"/>
					</html:select></c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="查询" class="button" onclick="onSearch()">
					<html:hidden name="IGASM3116Form" property="rimid" value="${IGASM3116Form.rimid }"/>
					<html:hidden name="IGASM3116Form" property="esyscoding" value="${IGASM3116Form.esyscoding }"/>
					<html:hidden name="IGASM3116Form" property="eiid" value="${IGASM3116Form.eiid }"/>
				</div>
				</div>
			</div>
			<div style="text-align:center;">
				<table style="margin:auto" width="790px;">
					<tr>
						<td><html:hidden name="IGASM3116Form" property="asmxml"
								styleId="asmxml" />
							<div id="chartdiv" align="center"></div> <script
								type="text/javascript">
						// 指标模型
						var rimtype =${IGASM3116Form.RIMTYPE};
		            	var asmxml="";
		        	   	function getXmlInfo(){
		        	 	  var temp = document.getElementsByName("asmxml")[0].value;
		        	 	
		        	 	  if(null!=temp && temp!=""){
		        	 		 asmxml=temp;
		        	 		//alert(svcxml);
		        	 	  }
		        	 	
		        	   	}
		        	   	getXmlInfo();
		        	   	if(null!=asmxml && asmxml!=""){
		        	   		var chart = "";
		        	   		if(rimtype=="1"){
		        	   			chart = new FusionCharts("images/Column2D.swf", "ChartId", "790", "300", "0", "0");
		        	   		}else if(rimtype=="2"){
		        	   			chart = new FusionCharts("images/Pie3D.swf", "ChartId", "790", "300", "0", "0");
		        	   		}else if(rimtype=="3"){
		        	   			chart = new FusionCharts("images/Line.swf", "ChartId", "790", "300", "0", "0");
		        	   		}
		        	       chart.setDataXML(asmxml);		   
		        	       chart.render("chartdiv");
		        	   	}
		        	   
		            	</script></td>
					</tr>
				</table>
			</div>
			</html:form>
		</div>
		<%-- </c:if> --%> 
		
		
	</div>
	</div>
  </div>
 </div>
</div>
</body>
</html:html>