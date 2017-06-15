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
<bean:define id="id" value="IGVIR1005" toScope="request" />
<bean:define id="title" value="虚拟化管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link  href="css/vir/homepage/1005.css" rel="stylesheet" type="text/css"/>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="processCount">
		<div style="height:10px;">
		</div>
		<div style="height:130px;">
			<div id="processCountTitlePanel">
				<div class="processCountTitle">申请</div>
				<div class="processCountTitle">调整</div>
				<div class="processCountTitle">回收</div>
			</div>
			<div id="processCountContentPanel">
				<div id="counts" class="processCountContent">
				</div>
				<div id="countt" class="processCountContent">
				</div>
				<div id="counth" class="processCountContent">
				</div>
			</div>
		</div>
	</div>
	<div class="rightLogPanel">
		<div class="divTitle">
			本月申请统计
		</div>
		<div style="height:115px;" id="countcontainer">
		</div>
	</div>
	<div id="serviceCatelog">
		<div id="serviceCatelogTitle">
			服务目录
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR1401">
				<img  src="images/vim/vim01.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGVIR1401&actname=ACT17VIR1401">
					资源申请统计
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR1401" permission="false">
				<img  src="images/vim/vim01-1.gif" align="middle">
				资源申请统计		
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR1402">
				<img  src="images/vim/vim02.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGVIR1402&actname=ACT17VIR1402">
					资源使用情况统计
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR1402" permission="false">
				<img  src="images/vim/vim02-1.gif" align="middle">
				资源使用情况统计		
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR1403">
				<img  src="images/vim/vim03.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGVIR1403&actname=ACT17VIR1403">
					运行及运维情况
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR1403" permission="false">
				<img  src="images/vim/vim03g.gif" align="middle">
				运行及运维情况		
			</ig:menuAuth>
		</div>
	</div>
	<div class="rightLogPanel" style="margin-top:5px;">
		<div class="divTitle">
			主机资源
		</div>
		<div style="height:260px;" id="slideBox" class="slideBox">
			<div id="towardsleft">
				<img src="images/towardsleft_a.gif" class="prev">
			</div>
			<div id="hostContent">
				<ul>
					<logic:present name="IGVIR10051VO" property="showHostList">
						<logic:iterate id="list" name="IGVIR10051VO" property="showHostList">
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
														<th style="with:40px;">&nbsp;&nbsp;CPU：</th>
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
	<div id="orgstopfive">
		<div class="divTitle">
			部门申请TOP5
		</div>
		<div style="height:143px;" id="orgtop5">
		</div>
	</div>
	<div id="tendency">
		<div class="divTitle">
			资源申请趋势
		</div>
		<div style="height:143px;" id="zyqs">
		</div>
	</div>
</div>
</div>
</div>
</div>
</body>
<logic:present name="IGVIR10051VO">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
var jQ = jQuery.noConflict(true);
</script>
<script type="text/javascript" src="js/SuperSlide/jquery.SuperSlide.2.1.1.js"></script>
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
</script>
<script src="js/Highcharts/highcharts.js"></script>
<script src="js/Highcharts/highcharts-more.js"></script>
<script src="js/Highcharts/modules/exporting.js"></script>
<script type="text/javascript">
	jQ(document).ready(function () {
		var counts = '${IGVIR10051VO.countSImg}';
		var countt = '${IGVIR10051VO.countTImg}';
		var counth = '${IGVIR10051VO.countHImg}';
		jQ("#counts").append(counts);
		jQ("#countt").append(countt);
		jQ("#counth").append(counth);
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
	
	function getMaxValue(arg0){
		if (0 == arg0) {
			return 10;
		} 
		return parseInt (10 * Math.ceil(arg0 / 10.0));
	}
	
	jQ(function () {
		var countS_C = ${IGVIR10051VO.countS_C};
		var countT_C = ${IGVIR10051VO.countT_C};
		var countH_C = ${IGVIR10051VO.countH_C};
		
		var countS_C_Max = getMaxValue(countS_C);
		var countT_C_Max = getMaxValue(countT_C);
		var countH_C_Max = getMaxValue(countH_C);
		jQ('#countcontainer').highcharts({
		
		    chart: {
		        type: 'gauge',
		        plotBorderWidth: 0,
		        plotBackgroundColor: {
		        	linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1,x3 : 0, y3 : 2 },
		        	stops: [
		        		[0, '#FFFFFF'],
		        		[0.3, '#FFFFFF'],
		        		[1, '#FFFFFF']
		        	]
		        },
		        plotBackgroundImage: null,
		        height: 115
		    },
		
		    title: {
		        text: ''
		    },
		    exporting:{
	        	   enabled:false
          	},
		    
		    pane: [{
		        startAngle: -45,
		        endAngle: 45,
		        background: null,
		        center: ['15%', '145%'],
		        size: 200
		    }, {
		    	startAngle: -45,
		    	endAngle: 45,
		    	background: null,
		        center: ['50%', '145%'],
		        size: 200
		    },
		    {
		    	startAngle: -45,
		    	endAngle: 45,
		    	background: null,
		        center: ['85%', '145%'],
		        size: 200
		    }
		    ],	    		        
		
		    yAxis: [{
		        min: 0,
		        max: countS_C_Max,
		        minorTickPosition: 'outside',
		        tickPosition: 'outside',
		        labels: {
		        	rotation: 'auto',
		        	distance: 20
		        },
		        plotBands: [{
		        	color: '#C02316',
		        	innerRadius: '100%',
		        	outerRadius: '105%'
		        }],
		        pane: 0,
		        title: {
		        	text: '<span style="font-size:12px">本月申请</span>',
		        	y: -20
		        }
		    }, {
		        min: 0,
		        max: countT_C_Max,
		        minorTickPosition: 'outside',
		        tickPosition: 'outside',
		        labels: {
		        	rotation: 'auto',
		        	distance: 20
		        },
		        plotBands: [{
		        	color: '#C02316',
		        	innerRadius: '100%',
		        	outerRadius: '105%'
		        }],
		        pane: 1,
		        title: {
		        	text: '<span style="font-size:12px">本月调整</span>',
		        	y: -20
		        }
		    },
		    {
		        min: 0,
		        max: countH_C_Max,
		        minorTickPosition: 'outside',
		        tickPosition: 'outside',
		        labels: {
		        	rotation: 'auto',
		        	distance: 20
		        },
		        plotBands: [{
		        	color: '#C02316',
		        	innerRadius: '100%',
		        	outerRadius: '105%'
		        }],
		        pane: 2,
		        title: {
		        	text: '<span style="font-size:12px">本月回收</span>',
		        	y: -20
		        }
		    }
		    ],
		    
		    plotOptions: {
		    	gauge: {
		    		dataLabels: {
		    			enabled: false
		    		},
		    		dial: {
		    			radius: '100%'
		    		}
		    	}
		    },
		    	
		
		    series: [{
		    	name:"本月申请",
		        data: [countS_C],
		        yAxis: 0
		    }, {
		    	name:"本月调整",
		        data: [countT_C],
		        yAxis: 1
		    },
		    {
		    	name:"本月回收",
		        data: [countH_C],
		        yAxis: 2
		    }
		    ]
		
		},
		function(chart) {
		
		});
	});
	
	jQ('#orgtop5').highcharts({
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
<logic:present name="IGVIR10051VO" property="top5Map">
<logic:iterate id="map" name="IGVIR10051VO" property="top5Map" indexId="idx">
<c:if test="${idx > 0 }">,</c:if>
'${map.key}'
</logic:iterate>
</logic:present>
	        ]
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: ''
	        }
	    },
	    tooltip: {
	        headerFormat: '<span style="font-size:10px">{point.key}：</span><table>',
	        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
	        footerFormat: '</table>',
	        shared: true,
	        useHTML: true
	    },
	    plotOptions: {
	        column: {
	            pointPadding: 0.2,
	            borderWidth: 0,
	            pointWidth:15
	        }
	    },
	    series: [{
	        name: '数量',
	        data: [
<logic:present name="IGVIR10051VO" property="top5Map">
<logic:iterate id="map" name="IGVIR10051VO" property="top5Map" indexId="idx">
<c:if test="${idx > 0 }">,</c:if>
${map.value}
</logic:iterate>
</logic:present>
				]

	    }]
	});

    jQ(function () {
        jQ('#zyqs').highcharts({
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
            	name:'申请数量',
            	data:[
<logic:present name="IGVIR10051VO" property="monthCountS">
<logic:iterate id="count" name="IGVIR10051VO" property="monthCountS" indexId="idx">
	<c:if test="${idx > 0 }">
	,
	</c:if>
	${count }
</logic:iterate>
</logic:present>
          	      ]
            },
            {
            	name:'申请调整',
            	data:[
<logic:present name="IGVIR10051VO" property="monthCountT">
<logic:iterate id="count" name="IGVIR10051VO" property="monthCountT" indexId="idx">
	<c:if test="${idx > 0 }">
	,
	</c:if>
	${count }
</logic:iterate>
</logic:present>
          	      ]
            },
            {
            	name:'申请回收',
            	data:[
<logic:present name="IGVIR10051VO" property="monthCountH">
<logic:iterate id="count" name="IGVIR10051VO" property="monthCountH" indexId="idx">
	<c:if test="${idx > 0 }">
	,
	</c:if>
	${count }
</logic:iterate>
</logic:present>
          	      ]
            }
            ]
        });
    });
</script>
</logic:present>
</html:html>