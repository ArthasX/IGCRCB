<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRDP0102" toScope="request"/>
<bean:define id="title" value="升级任务结果查看页面" toScope="request"/>
<script src="js/menu/jquery.js" type="text/javascript"></script>
<script src="js/alerts/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="js/alerts/jquery.alerts.js" type="text/javascript" charset="gbk"></script>
<link href="js/alerts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<link href="js/menu/menu.css" rel="stylesheet" type="text/css" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>

<style type="text/css">
#realtimedetailBox{
	position: absolute;
	z-index: 99;
	display: none;
	min-height: 40px;
	width: 400px;
	
	border: 5px solid #6699CC;
	background-color: #fff;
	text-align: center;
}
#resultTitle{
	height: 30px;
	border-bottom: 1px ridge #5678ab;
	font-weight: 400;
	color: #4FB2EE;
	font-family: '黑体';
	font-size: 16px;
	line-height: 30px;
}
#realtimedetailBox ul{

	max-height:400px;
	width:100%;
	float:left;
	list-style: none;
	margin-left: 0px;
	overflow-y: auto;
	overflow-x: hidden;
	min-height: 60px;
}
#realtimedetailBox ul li{
	line-height:25px;
	height: 25px;
	border-bottom: 1px solid #eeeeee;
	text-align: left;
	text-indent: 15px;
	color: #7f7f7f;
}
.boxHover{
	cursor: move;;
}

.realtimedetail{
	cursor: pointer;
}
#consoleUL{
	height: 80px;
	overflow: hidden;
	width:80%;
	float: left;
	margin-left: 20px;
	padding-top: 0px;
	margin-top: -10px;
	
}
#consoleUL li{
	margin-top: 0px;
}
#consoleUL li div{
	width:95%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
	color: #5F6567;
}
#consoleBox{
	height: 76px;
	border: 1px solid #9DABB8;
	background-image: url("images/bg_line.jpg");
	width: 97.9%;
	margin: 0 auto;
	overflow:hidden;
	display: none;
}
</style>
<!-- /header1 -->
	<script type="text/javascript">	
		var autoSearch;
	    var taskid = '${IGRDP0102Form.taskid_eq}';
	    var hostids = new Array();
		
		function load(){
			if('yes' != $('isquery').value){
// 				autoSearch = setInterval("searchResultList()",3*1000);
// 				rollResult();
			}
		}
		
	    function seeLog(hostid,taskid){
	    	openSubWindow('/IGRDP0102_Log.do?hostid='+hostid+'&taskid='+taskid+'&flag=resultLog','_blank','1000','800');
	    }
	    
	    function seeScriptLog(hostid,taskid){
	    	openSubWindow('/IGRDP0102_Log.do?hostid='+hostid+'&taskid='+taskid+'&flag=scriptLog','_blank','1000','800');
	    }
	    
	    function seeLog_ajax(v){
	    	openSubWindow('/IGRDP0102_Log.do?hostid='+hostids[v]+'&taskid='+taskid+'&flag=resultLog','_blank','1000','800');
	    }
	    
	    function seeScriptLog_ajax(v){
	    	openSubWindow('/IGRDP0102_Log.do?hostid='+hostids[v]+'&taskid='+taskid+'&flag=scriptLog','_blank','1000','800');
	    }
	    
		function searchResultList(){
			taskid = '${IGRDP0102Form.taskid_eq}';
			var objAjax = new Ajax.Request(getAppRootUrl() + '/IGRDP0102_SearchByAjax.do?taskid='+taskid,{asynchronous:false,parameters:'',method:"post",
				 onSuccess:  function(req, json){
				 	 var result = req.responseText;
				 	 if(result == null) result = '';
				 	 var tableStr = createTable(result,taskid);
				 	 results_list.innerHTML = tableStr;
				 	bindClick();
			     }
				});
			return false;
		}
	
		function createTable(str,str1){
			var start = '<table class="table_style"><tr><th width="25%">主机</th><th width="25%" align="left">脚本执行状态</th><th width="25%">脚本执行信息</th><th width="25%">日志</th></tr>';
			var end = '</table>';
			if(str != ''){
				var row = str.split("@_@");
				for(var i=0;i<row.length;i++){
					var cell = row[i].split("#_#");
					var host = cell[0];     
					var state = cell[1];	     
					var result = cell[2]; 
					var log = cell[3];	
					var realtime = cell[4];
					
					hostids[i] = host;
					if(result == 'null') {
						result ='';
					}
					if(log == 'null') {
						log = '';
					}
	
					var tr = '<tr>';
					
					tr = tr + '<td><div class="nowrapDiv">'+ host + '</div></td>';
					
					tr = tr + '<td align="left"><div class="nowrapDiv">';
					if(state == '0') {
						tr = tr + '准备中...';
					}else if(state == '1') {
						tr = tr + '<br/>传输中:';
					}else if(state == '2') {
						tr = tr + '<br/>传输成功,执行脚本:';
					}else if(state == '3') {
						tr = tr + '<span class="red">传输失败:</span>';
					}else if(state == '4') {
						tr = tr + '<span style="color: green;">已执行:</span>';
					}else if(state == '5') {
						tr = tr + '<span class="red">执行失败</span>';
					}
					if(state != '0') {
						tr = tr + '<br/><br/>';
					}
					tr = tr + '<span style="color: grey;">' + realtime + '</span><br/>';
					tr = tr + '</div></td>';
					
					tr = tr + '<td><div class="nowrapDiv">';
					
					if(result != null && result != ''){
						tr = tr + '<img src="images/d1.gif" class="realtimedetail" alt="查看执行信息" width="16" height="16" border="0" hostip="${bean.hostid}" taskid="${bean.taskid}" />';
// 						TR = TR + '<IMG SRC="IMAGES/D1.GIF" ALT="查看执行信息" WIDTH="16" HEIGHT="16" BORDER="0" ONCLICK="RETURN SEESCRIPTLOG_AJAX('+I+');"/>';
						//tr = tr + '<html:button property="btn_log" styleClass="button" style="height: 20px;width:70px;" onclick="return seeScriptLog_ajax('+i+');">查看</html:button>';
					}
					
					tr = tr + '</div></td>';
					
					tr = tr + '<td><div class="nowrapDiv">';
					if(log != null && log != ''){
						tr = tr + '<img src="images/notepad_16x16.gif" alt="查看程序日志" width="16" height="16" border="0" onclick="return seeLog_ajax('+i+');"/>';
						//tr = tr + '<html:button property="btn_log" styleClass="button" style="height: 20px;width:70px;" onclick="return seeLog_ajax('+i+');">查看</html:button>';
					}
					tr = tr + '</div></td></tr>';
					
					start = start + tr;
				}
				
			}
		    return start+end;
		}

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd";  //回传日期的格式
	    WebCalendar.timeShow   = false;          //是否返回时间
	    WebCalendar.drag       = true;          //是否允许拖动
	    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色
	

		function checkForm(){
			form.action = 'IGRDP0102_Search.do?isquery=yes';
			form.submit();
		}

	    
	</script>

<body onload="load();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGRDP0102_Search"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
						远程部署&gt;&gt; 远程升级 &gt;&gt;升级结果查看
                    </p>
                <div class="back"><a href="IGRDP0101_Search.do" target="_self">返回</a></div>
            </div>
            
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                         	<label for="Name">任务名称：</label>
								<html:select styleId="taskid" property="taskid_eq" style="width: 120px;" errorStyleClass="inputError" >
									<html:options collection="tasks" property="id" name="" labelProperty="taskName"/>
								</html:select>
								&nbsp;&nbsp;
		         			<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
		         				查询
		         			</html:submit>
		         			<html:submit property="btn_fresh" styleClass="button" onclick="return checkForm();">刷新</html:submit>
                          </div>
		     </div>
		     
          </div>
		     <div id="consoleBox" >
		     	<div style='width:40px;float:left;margin-top:30px;margin-left:30px;vertical-align: middle;line-height: 78px;vertical-align: middle;'><img src="images/console.png"></div>
		     	<ul id="consoleUL" >
		     	<li id="tempLi" style="height: 60px;" ><div style='width:95%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'></div></li>
		     	</ul>
		     </div>
		     
           
                               
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table id="tbResult" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="25%">主机</th>
					           <th width="25%" align="left">脚本执行状态</th>
					           <th width="25%">脚本执行信息</th>
					           <th width="25%">日志</th>
			                </tr>
			                
			            <!-- body部 -->
			                <logic:present name="IGRDP01021VO" property="results" >
			                    <logic:iterate id="bean" name="IGRDP01021VO" property="results" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>" >
			                            <td>
			                            	<div class="nowrapDiv">
			                                ${bean.hostid}
			                                </div>
			                            </td>
			                            <td align="left">
			                                <div class="nowrapDiv">
				                                <c:if test="${bean.state == 0}">
				                            		准备中...
				                           	 	</c:if>
				                           	 	<c:if test="${bean.state == 1}">
				                            		传输中...
				                           	 	</c:if>
                                                <c:if test="${bean.state == 2}">
				                            		传输成功,执行中...
				                           	 	</c:if>
				                           	 	<c:if test="${bean.state == 3}">
				                            		<span class="red">传输失败</span>
				                           	 	</c:if>
				                           	 	<c:if test="${bean.state == 4}">
				                            		<span style="color: green;">已执行</span>
				                           	 	</c:if>
				                           	 	<c:if test="${bean.state == 5}">
				                            		<span class="red">执行失败</span>
				                           	 	</c:if>
				                           	 	<c:if test="${bean.state != 0}">
				                           	 		<br/><br/>
				                           	 	</c:if>
				                           	 	<span style="color: grey;">${bean.realtimedetail }</span>
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                	<logic:empty name="bean" property="result">&nbsp;</logic:empty>
			                                	<logic:notEmpty name="bean" property="result">
			                                			<img src="images/d1.gif" class="realtimedetail" alt="查看执行信息" width="16" height="16" border="0" hostip="${bean.hostid}" taskid="${bean.taskid}" />
			                                			<!--
			                                			<html:button property="btn_log" styleClass="button" onclick="return seeScriptLog('${bean.hostid}','${bean.taskid}');" style="height: 20px;width:70px;">查看</html:button>
			                                			-->
			                               		</logic:notEmpty>
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                	<logic:empty name="bean" property="resultDetail">&nbsp;</logic:empty>
			                                	<logic:notEmpty name="bean" property="resultDetail">
			                                	
			                                		<img src="images/notepad_16x16.gif" alt="查看程序日志" width="16" height="16" border="0" onclick="return seeLog('${bean.hostid}','${bean.taskid}');"/>
			                                	<!--
			                                		<html:button property="btn_log" styleClass="button" onclick="return seeLog('${bean.hostid}','${bean.taskid}');" style="height: 20px;width:70px;">查看</html:button>
			                               		-->
			                               		</logic:notEmpty>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			  
			       </table>
			     </div>
			     <div id="operate">
			     	<jsp:include page="/include/paging.jsp"/>
			     </div>
			     <html:hidden property="isquery"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
<div id="realtimedetailBox"> 
	<div id= "resultTitle">脚本执行信息</div>
	<ul id = "detailUL">
		
	</ul>
</div>
</div>
</body>
<Script>
	var hostip;
	 var taskid = '${IGRDP0102Form.taskid_eq}';
	 var rollFlag;
	 var maxid;
	jQuery(function(){

		//if('yes' != $('isquery').value){
			rollResult();
			rollLog();
		//}
		//绑定查看日志图标的点击事件
		bindClick();
		//绑定 弹窗窗口的鼠标悬浮事件
		jQuery("#resultTitle").hover(function(){jQuery(this).addClass("boxHover");},function(){jQuery(this).removeClass("boxHover");})
		//绑定弹出窗口的拖拽方法
		jQuery("#resultTitle").mousedown(function(event){
			var offLeft = event.clientX-jQuery("#realtimedetailBox").position().left;
			var offTop = event.clientY-jQuery("#realtimedetailBox").position().top;
			
			jQuery("body").mousemove(function(e){
				jQuery("#realtimedetailBox").css({left:(e.clientX-offLeft)+'px',top:(e.clientY-offTop)+'px'});
			})
			jQuery(this).mouseup(function(){
				jQuery("body").unbind("mousemove");
			})
		});
		
		//关闭弹窗方法
		jQuery(document).click(function(){
			jQuery("#realtimedetailBox").hide();
			jQuery("#detailUL").empty();
			jQuery("body").unbind("mousemove");
			hostip='';
		});
		//在弹窗上屏蔽关闭方法
		jQuery("#realtimedetailBox").click(function(event){
			event.stopPropagation();
		});

	});
	
	//绑定查看日志图标的点击事件的方法
	function bindClick(){
			jQuery(".realtimedetail").unbind("click").removeAttr("onclick").click(
					function(event){
						 event.stopPropagation();
							if(jQuery("#realtimedetailBox:hidden").length==0){
								return;
							}
						 hostip=jQuery(this).attr("hostip");
						jQuery.ajax({
							url:getAppRootUrl()+"/IGRDP0102_Detail.do",
							data:{taskid:this.taskid,hostip:this.hostip},
							type:"post",
							dataType:"json",
							success:function(result){
								for(var i=0;i<result.length;i++){
									jQuery("#detailUL").append("<li  id='li_"+result[i].id+"' title='"+result[i].content+"' ><div style='width:95%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'>"+result[i].content+"</div></li>");
								}
								
								var left = ((jQuery(window).width()-jQuery("#realtimedetailBox").width())/2)+'px';
								var top = 260+'px';
								jQuery("#realtimedetailBox").css({left:left,top:top}).show();
								 pollingSearch();
							}
						});
				});
	
	}
	
		
	
	//日志轮询
	function pollingSearch(){
		if(jQuery("#realtimedetailBox:hidden").length>0){
			return;
		}
		jQuery.ajax({
			url:getAppRootUrl()+"/IGRDP0102_Detail.do",
			data:{taskid:taskid,hostip:hostip},
			type:"post",
			dataType:"json",
			success:function(result){
				//倒序追加
// 				if(result.length>0){
// 					for(var i=result.length;i>0;i--){
// 						var t = result[i-1];
// 						if(jQuery('#li_'+t.id).length==0){
// 							jQuery("#detailUL").prepend("<li id='li_"+t.id+"' style='height:0px'>"+t.content+"</li>");
// 							jQuery("#detailUL li:first").animate({height:'25px'},500);
// 						}
// 					}
// 				}
				//正序追加
				if(result.length>0){
					for(var i=0;i<result.length;i++){
						var t = result[i];
						if(jQuery('#li_'+t.id).length==0){
							jQuery("#detailUL").append("<li id='li_"+t.id+"' title='"+result[i].content+"'  style='height:0px'><div style='width:95%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;'>"+t.content+"</div></li>");
							jQuery("#detailUL li:last").animate({height:'25px'},500);
							jQuery("#detailUL").scrollTop(jQuery("#detailUL").height());
						}
					}
				}
				

			}
		});
		setTimeout("pollingSearch()",1000);
	}
	

	//主机列表状态轮询
	function rollResult(){
		jQuery.ajax({
			url:getAppRootUrl() + '/IGRDP0102_SearchByAjax.do?taskid='+taskid,
			type:"post",
			success:function(result){
				if(result){
					var row = result.split("@_@");
					jQuery.each(row,function(i,t){
						var cell = row[i].split("#_#");
						var host = cell[0];     
						var state = cell[1];	     
						var result = cell[2]; 
						var log = cell[3];	
						var realtime = cell[4];
						var td = jQuery("td .nowrapDiv:contains('"+host+"')");
						hostids[i] = host;						
						if(td.length>0){
							td = jQuery(td[0]).parent();
							td.next().children()[0].innerHTML=parseStatus(state,realtime);
							if(state == '2'){
								td.next().next().html('<div class="nowrapDiv"><img src="images/d1.gif" class="realtimedetail" alt="查看执行信息" width="16" height="16" border="0" hostip="${bean.hostid}" taskid="${bean.taskid}" /></div>');
							}
							if(state == '3' || state == '4' || state == '5'){
								td.next().next().next().html('<div class="nowrapDiv"><img src="images/notepad_16x16.gif" alt="查看程序日志" width="16" height="16" border="0" onclick="return seeLog_ajax('+i+');"/></div>');
							}
							bindClick();
						}else{
							var html='<tr><td><div class="nowrapDiv">'+ host + '</div></td>';
							html+='<td align="left">'+parseStatus(state,realtime)+'</td>';
							html+='<td><div class="nowrapDiv"><img src="images/d1.gif" class="realtimedetail" alt="查看执行信息" width="16" height="16" border="0" hostip="${bean.hostid}" taskid="${bean.taskid}" /></div></td>';
							html+='<td><div class="nowrapDiv"><img src="images/notepad_16x16.gif" alt="查看程序日志" width="16" height="16" border="0" onclick="return seeLog_ajax('+i+');"/></div></td></tr>';
							jQuery("#tbResult tr:last").append(html);
							bindClick();
						}
					});
				}
			}
		})
		
		setTimeout("rollResult()",3000);
	}
	//解析状态
	function parseStatus(state,realtime){
		var status='<div class="nowrapDiv">';
		switch(state){
		case '0':
			status+='准备中...';
			break;
		case '1':
			status+='<br/>传输中:<br/><br/>';
			break;
		case '2':
			status+='<br/>传输成功,执行脚本:<br/><br/>';
			break;
		case '3':
			status+='<span class="red">传输失败:</span><br/><br/>';
			break;
		case '4':
			status+='<span style="color: green;">已执行:</span><br/><br/>';
			break;
		case '5':
			status+='<span class="red">执行失败</span><br/><br/>';
			break;
		}
		status+='<span style="color: grey;">' + realtime + '</span><br/></div>';
		return status;
	}
	
	//轮询本任务的最新日志信息并追加到 显示列表中
	function rollLog(){
		var rtdid= maxid||'';
		jQuery.ajax({
			url:getAppRootUrl()+"/IGRDP0102_SearchLog.do",
			data:{taskid:taskid,rtdid:rtdid},
			dataType:"json",
			type:"post",
			success:function(result){
				if(result&&result.length>0){
					result.each(function(t,i){
						var li = jQuery("#tempLi").clone().removeAttr("id").show().css({height:'24px'});
						li.attr("rtdid",t.id);
						li.children()[0].innerHTML=t.hostip+"&nbsp;&gt;&nbsp;"+t.content;
						li.appendTo("#consoleUL");
						maxid = t.id;
					});
					if(jQuery("#consoleUL").children().size()>1){
						jQuery("#consoleBox").show();
// 						jQuery("#consoleUL").before("<div style='width:80px;float:left;margin-top:4px;margin-left:30px;'>脚本执行信息:&nbsp;</div>");
						setTimeout("printLog()",2000);
					}
				}
				setTimeout("rollLog()",5000);
			}
		})
	}
	
	//滚动显示日志
	function printLog(){
		var curentLi=jQuery("li:nth-child(2)",jQuery("#consoleUL"));
		if(curentLi.size()>0&&curentLi.nextAll().length>2){
			if(jQuery("#tempLi").height()>0){
				if(jQuery("#consoleUL").children().size()>2){
					
					jQuery("#tempLi").height()>0&&(jQuery("#tempLi").animate({height:((jQuery("#tempLi").height()-30)<30?0:jQuery("#tempLi").height()-30)},"slow"));
				}
				
			}else{
				curentLi.animate({marginTop:'-24px'},"slow",function(){
					jQuery(this).remove();
				
				});
			}
		}
		setTimeout("printLog()",2000);
	}
</Script>
</html:html>