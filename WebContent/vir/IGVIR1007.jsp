<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverik.framework.user.model.Organization" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG160Info" %>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<html:html>
<bean:define id="id" value="IGVIR1007" toScope="request" />
<bean:define id="title" value="虚拟化资源管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link  href="css/vir/homepage/1007.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
	function openTemplateWindow(){
		openSubWindow('/IGVIR1000_GetTemplate.do', '', '850', '600');
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="serviceCatalog">
		<div id="serviceCatelogTitle">
			服务目录
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR0204">
				<img  src="images/vim/vim01.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01002&actname=ACT17VIR0204">
					申请查询
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR0204" permission="false">
				<img  src="images/vim/vim01-1.gif" align="middle">
				申请查询			
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR0304">
				<img  src="images/vim/vim02.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01003&actname=ACT17VIR0304">
					调整查询
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR0304" permission="false">
				<img  src="images/vim/vim02-1.gif" align="middle">
				调整查询			
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR0404">
				<img  src="images/vim/vim03.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01004&actname=ACT17VIR0404">
					回收查询
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR0404" permission="false">
				<img  src="images/vim/vim03g.gif" align="middle">
				回收查询				
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR1301">
				<img  src="images/vim/vim04.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGVIR1301&actname=ACT17VIR1301">
					虚机资源管理
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR1301" permission="false">
				<img  src="images/vim/vim04-1.gif" align="middle">
				虚机资源管理		
			</ig:menuAuth>
		</div>
	</div>
	<div id="applyforme">
		<div class="divTitle">
			<span style="display:block;float:left;">我的申请</span>
			<a style="display:block;float:right;margin-right:10px;" href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101">更多</a>
		</div>
		<table class="table_css">
			<tr>
				<th width="15%">序号</th>
				<th width="20%">状态</th>
				<th width="40%">申请内容</th>
				<th width="25%">申请时间</th>
			</tr>
			<logic:present name="IGVIR10071VO" property="pihList" >
				<logic:iterate id="bean" name="IGVIR10071VO" property="pihList" indexId="idx">
				<c:if test="${idx < 5 }">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" style="cursor:hand;" onclick="doLook('IGPRR0102_Disp.do?prid=${bean.prid}');">
						<td>${bean.prserialnum }</td>
						<td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
						<td><span style="display:block;width:100%;height:25px;line-height:25px;overflow:hidden;" title="${bean.prtitle }">${bean.prtitle }</span></td>
						<td>${bean.propentime }</td>
					</tr>
				</c:if>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="template">
		<div class="divTitle">
			<span style="display:block;float:left;">模板资源</span>
			<a style="display:block;float:right;margin-right:10px;" href="javascript:openTemplateWindow();">更多</a>
		</div>
		<table class="table_css">
			<tr>
				<th width="49%">模板名称</th>
				<th width="17%">CPU</th>
				<th width="17%">内存(G)</th>
				<th width="17%">硬盘(G)</th>
			</tr>
			<logic:present name="IGVIR10071VO"  property="templateList">
				<logic:iterate id="bean" name="IGVIR10071VO"  property="templateList" indexId="idx">
					<c:if test="${idx < 5 }">
						<tr>
							<td><span title="${bean.name }" style="display:block;height:20px;width:100%;line-hieght:20px;margin-top:5px;margin-left:3px;">${bean.name }</span></td>
							<td align="center">${bean.numCPU }</td>
							<td align="center">${bean.memoryGB }</td>
							<td align="center">${bean.diskGB }</td>
						</tr>
					</c:if>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="vminfo">
		<div class="divTitle">
			主机资源
		</div>
		<div style="height:260px;" id="slideBox" class="slideBox">
			<div id="towardsleft">
				<img src="images/towardsleft_a.gif" class="prev">
			</div>
			<div id="hostContent">
				<ul>
					<logic:present name="IGVIR10071VO" property="showHostList">
						<logic:iterate id="list" name="IGVIR10071VO" property="showHostList">
							<li>
								<div class="HostContentPanel">
									<logic:present name="list">
										<logic:iterate id="map" name="list" indexId="idx">
										<logic:present name="map">
										<logic:iterate id="mapEntity" name="map">
										<bean:define id="bean" name="mapEntity" property="value"/>
											<div class="HostContent" style="margin-top:5px;
											<c:if test="${idx != 0 || idx != 3 }">
											margin-left:11px;
											</c:if>
											"
											>
											<div class="HostContentHead">
												<logic:equal value="poweredOn" name="bean" property="powerState">
													<img alt="状态：开机" src="images/hostPoweredOn.gif" width="32" height="32" align="middle" onclick="doLook('IGVIR1201.do?hostname=${mapEntity.key}_${bean.name }');"/>
												</logic:equal>
												<logic:notEqual value="poweredOn" name="bean" property="powerState">
													<img alt="状态：关机" src="images/hostPoweredOff.gif" width="32" height="32" align="middle" onclick="doLook('IGVIR1201.do?hostname=${mapEntity.key}_${bean.name }');"/>
												</logic:notEqual>
												<span class="HostName">${bean.name }</span>
											</div>
											<div class="HostContentBody">
												<table>
													<tr>
														<th style="with:40px;">&nbsp;&nbsp;CUP：</th>
														<td style="width:150px;">
															<div class="progressDiv">
																<div class="progressDiv1" widthflag="${bean.cpuUseRate}" style="width:${bean.cpuUseRate};"></div>
																<span class="HostInfoFount">${bean.cpuUsage } &nbsp;&nbsp;/&nbsp;&nbsp; ${bean.cpuHz } x ${bean.cpuCores }(MHz)</span>
															</div>
														</td>
													</tr>
													<tr>
														<th>&nbsp;&nbsp;内存：</th>
														<td>
															<div class="progressDiv">
																<div class="progressDiv1" widthflag="${bean.memoryUseRate}" style="width:${bean.memoryUseRate}"></div>
																<span class="HostInfoFount">${bean.memoryUsageGB } &nbsp;&nbsp;/&nbsp;&nbsp; ${bean.memoryGB }(G)</span>
															</div>
														</td>
													</tr>
													<tr>
														<th>&nbsp;&nbsp;硬盘：</th>
														<td>
															<div class="progressDiv">
																<div class="progressDiv1" widthflag="${bean.diskUseRate}" style="width:${bean.diskUseRate}"></div>
																<span class="HostInfoFount">${bean.capacity - bean.freeSpace } &nbsp;&nbsp;/&nbsp;&nbsp; ${bean.capacity }(G)</span>
															</div>
														</td>
													</tr>
												</table>
											</div>
											</div>
										</logic:iterate>
										</logic:present>
										</logic:iterate>
									</logic:present>
								</div>
							</li>
						</logic:iterate>
					</logic:present>
				</ul>
			</div>
			<div id="towardsright">
				<img src="images/towardsright_a.gif" class="next">
			</div>
		</div>
	</div>
	<div id="zysqqs">
		<div class="divTitle">
			资源申请趋势
		</div>
		<div id="zysqqscontent" style="height:150px;">
		</div>
	</div>
	<div id="ywlcqs">
		<div class="divTitle">
			运维流程趋势
		</div>
		<div id="ywlcqscontent" style="height:150px;">
		</div>
	</div>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
var jQ = jQuery.noConflict(true);
jQ(document).ready(function () {
	jQ(".prev").mousemove(function(){
		jQ(this).attr("src","images/towardsleft_b.gif");
	});
	jQ(".prev").mouseout(function(){
		jQ(this).attr("src","images/towardsleft_a.gif");
	});
	jQ(".next").mousemove(function(){
		jQ(this).attr("src","images/towardsright_b.gif");
	});
	jQ(".next").mouseout(function(){
		jQ(this).attr("src","images/towardsright_a.gif");
	});
	jQ(".progressDiv1").each(function(i,o){
		var widthflag = jQ(o).attr("widthflag");
		if(widthflag != ""){
			var width = parseInt(widthflag.substr(0,widthflag.indexOf("%")));
			if(width > 80){
				jQ(o).css("background-image","url(images/progress2.jpg)");
			}else if(width > 50){
				jQ(o).css("background-image","url(images/progress1.jpg)");
			}
		}
	});
});
</script>
<script type="text/javascript" src="js/SuperSlide/jquery.SuperSlide.2.1.1.js"></script>
<script src="js/Highcharts/highcharts.js"></script>
<script src="js/Highcharts/highcharts-more.js"></script>
<script src="js/Highcharts/modules/exporting.js"></script>
<script type="text/javascript">
jQ(".slideBox").slide( { 
	mainCell:"#hostContent ul", 
	effect:"left",
	autoPlay:false,
	trigger:"click",
	easing:"swing",
	delayTime:500,
	mouseOverStop:true,
	pnLoop:false 
});
jQ(function () {
    jQ('#zysqqscontent').highcharts({
        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: ['1月', '2月', '3月', '4月', '5月', '6月',
                '7月', '8月', '9月', '10月', '11月', '12月']
        },
        yAxis: {
        	min:0,
            title: {
                text: '数量'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        exporting:{
       	   enabled:false
       	},
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [
        {
        	name:'申请回收',
        	data:[
<logic:present name="IGVIR10071VO" property="vmReportMap">
<logic:iterate id="map" name="IGVIR10071VO" property="vmReportMap" indexId="idx">
	<c:if test="${idx > 0 }">,</c:if>
	${map.value }
</logic:iterate>
</logic:present>
      	      ]
        }
        ]
    });
});


jQ('#ywlcqscontent').highcharts({
    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    legend:{
    	align:'right',
    	enabled:false
    },
    exporting:{
    	   enabled:false
    	},
    xAxis: {
        categories: [
<logic:present name="IGVIR10071VO" property="prRecportMap">
<logic:iterate id="map" name="IGVIR10071VO" property="prRecportMap" indexId="idx">
	<c:if test="${idx > 0 }">,</c:if>
	${map.key }
</logic:iterate>
</logic:present>
        ]
    },
    yAxis: {
        min: 0,
        title: {
            text: '数量'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}年：</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: '故障',
        data: [
<logic:present name="IGVIR10071VO" property="prRecportMap">
<logic:iterate id="map" name="IGVIR10071VO" property="prRecportMap" indexId="idx">
	<c:if test="${idx > 0 }">,</c:if>
	<logic:iterate id="bean" name="map" property="value">
		<logic:equal value="01080" name="bean" property="key">
		${bean.value }
		</logic:equal>
	</logic:iterate>
</logic:iterate>
</logic:present>
			]

    }, {
        name: '问题',
        data: [
<logic:present name="IGVIR10071VO" property="prRecportMap">
<logic:iterate id="map" name="IGVIR10071VO" property="prRecportMap" indexId="idx">
	<c:if test="${idx > 0 }">,</c:if>
	<logic:iterate id="bean" name="map" property="value">
		<logic:equal value="01083" name="bean" property="key">
		${bean.value }
		</logic:equal>
	</logic:iterate>
</logic:iterate>
</logic:present>
		]

    }, {
        name: '变更',
        data: [
<logic:present name="IGVIR10071VO" property="prRecportMap">
<logic:iterate id="map" name="IGVIR10071VO" property="prRecportMap" indexId="idx">
	<c:if test="${idx > 0 }">,</c:if>
	<logic:iterate id="bean" name="map" property="value">
		<logic:equal value="01084" name="bean" property="key">
		${bean.value }
		</logic:equal>
	</logic:iterate>
</logic:iterate>
</logic:present>
               ]

    }]
});
</script>
</html:html>