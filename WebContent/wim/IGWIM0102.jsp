<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGWIM0102" toScope="request" />
<bean:define id="title" value="工作项管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%

	Map<Integer,String> stopbuttonmap = new HashMap<Integer,String>();
	Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("stopbuttonMap")){
		stopbuttonmap = (Map)request.getAttribute("stopbuttonMap");
	}
	if(null!=request.getAttribute("startbuttonMap")){
		startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	}
	
%>

<!-- /header1 -->
<script type="text/javascript">	
 var gid='IGWIM0102';
  //删除所选
  function deleteRec(){
       var message ='<bean:message key="IGCO10000.E002"/>';
       var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="工作项基本信息" />';
       var frm = window.document.forms[0];
       if(frm.deleteEiid) {
        if(frm.deleteEiid.length > 0){
            var bchecked = false;
            for( i=0; i<frm.deleteEiid.length; i++ ){
                if (frm.deleteEiid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
            	alert(message);
                return false;
            }
        } else {
          if ($("deleteEiid").checked == false){
              alert(message);
              return false;
          }  
        }
       } else {
       	alert("没有可删除的数据！");
           return false;
       }

       if( window.confirm(confirmMsg)){
    	   jQuery.ajax({
    		   url:'IGWIM0102_Del.do',
    		   data:jQuery("#form").serialize(),
    		   type:'post',
    		   dataType:'json',
    		   async:true,
    		   cache:false,
    		   success:function(data){
    			   if(data){
    				   alert(data);
    				   if(data.length<=10){
	    				   window.location.href="IGWIM0102_Back.do";
    				   }
    			   }else{
    				   alert("工作项删除失败！");
    			   }
    		   },
    		   error:function(XMLHttpRequest,textStatus,errorThrown){
    			   alert("工作项删除操作异常！");
    		   }
    	   });
           return true;
           
       } else {
           return false;
       }
}
//工作项修改
function modifyWD(wdid){
	window.location.href="IGWIM0101_Disp.do?wdid="+wdid+"&mode=1";
}

//更新启、停用状态
function changeStatus(wdid){
	
	if(confirm("是否改变状态？")){
		//执行发起
		jQuery.ajax({
			url:'IGWIM0101_Modify.do',
			data:'wdid='+wdid,
			data:{
				wdid:wdid,
				mode:1
			},
			type:'post',
			dataType:'json',
			async:true,
			cache:false,
			success:function(data){
				if(data && data=='工作项状态更新成功！'){
					alert(data);
					window.location.href="IGWIM0102.do";
				}else{
					alert(data);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('出错了'+XMLHttpRequest+textStatus+errorThrown);
			}
		})
	}
}

//校验开始日期是否大于结束日期
function ckRange(){
	var start = jQuery("#beginDateStart").val();
	var over = jQuery("#beginDateOver").val();
	if(start && over){
		if(start>over){
			alert("开始日期不能晚于结束日期，请重新选择！");
			jQuery("#beginDateStart").val("");
			jQuery("#beginDateOver").val("");
			return;
		}
	}
}

//手动发起（wdid：工作定义主键ID；status：工作项状态）
function manualLaunch(wdid,status){
	//若该工作项未启用，则无法手动发起
	if("1"!=status){
		alert("工作项已停用，请启用工作项后重试！");
	}else{
		if(confirm("确定要立即发起工作实例吗？")){
			//执行发起
			jQuery.ajax({
				url:'IGWIM0101_Manual.do',
				data:'wdid='+wdid,
				type:'post',
				dataType:'json',
				async:true,
				cache:false,
				success:function(data){
					if(data){
						alert(data);
					}else{
						alert("工作实例发起失败！");
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert('出错了'+XMLHttpRequest+textStatus+errorThrown);
				}
			})
		}
	}
}
/**
 *弹出导入文件页面
 */
function importData(){
	var url = '/IGWIM0102_Import_Disp.do';
	openSubWindow(url,"_blank",800,180);
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style type="text/css">
.rlcomment{cursor: hand;}
#rlshowvaluediv{
	word-wrap:break-word;
	position:absolute;
	z-index: 9999;
	width: 400px;
	min-height: 50px;
	background-color: #eee;
	border:1px solid #ccc;
}
#rlshowvaluediv #title{
	width:395px;
	height:23px;
	line-height:23px;
	font-weight: bold;
	background:url(images/title-23.gif);
	padding-left:5px;
}
#rlshowvaluediv #title #fountDiv{
	width:100px;
	height:23px;
	float: left;
}
#rlshowvaluediv #title #imgDiv{
	width:30px;
	height:23px;
	float: right;
	padding-top:3px;
	cursor: hand;
}
#rlshowvaluediv #content{
	width:395px;
	padding:5px;
	line-height: 20px;
}
</style>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">

			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form styleId="form" action="/IGWIM0102"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								流程管理 &gt;&gt; 工作管理 &gt;&gt; 工作项管理
							</p>
						</div>
						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span style="font-size: 15px;"><strong>查询条件</strong></span>

								</div>
								<div style="margin-top: 4px">
									<span class="subscribe">工作项名称：</span>
									<html:text property="wdname" styleId="wdname" />
									
									<!-- 普通用户不可以操作发起人 -->
									<c:if test="${IGWIM0102Form.isNormalUser=='1' }">
										<span class="subscribe">发起人 ：</span>
										<input type="text" readonly="readonly" value="${IGWIM0102Form.initiatorId }">
									</c:if>
									<!-- 中心负责人以上可以操作发起人 -->
									<c:if test="${IGWIM0102Form.isNormalUser!='1' }">
										<span class="subscribe">发起人 ：</span>
										<html:text property="initiatorId" styleId="initiatorId" />
									</c:if>
									
									<span class="subscribe">负责人 ：</span>
									<html:text property="leaderName" styleId="leaderName" />
							    	<!-- 查询按钮 -->
									<html:submit property="btn_search" style="margin-left:5px" styleClass="button" value="查询" />
							    	<input type="button" value="导入" class="button" onclick="importData();">
							    	<br/><span class="subscribe">启用状态 ：</span>
									<html:select property="wdstatus" style="width: 105px;" styleId="wdstatus">
							    		<html:option value=""></html:option>
							    		<html:option value="0">未启用</html:option>
							    		<html:option value="1">已启用</html:option>
							    	</html:select>	
							    	<span class="subscribe">开始日期从 ：</span>
							    	<html:text property="beginDateStart" onchange="ckRange()" styleId="beginDateStart" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].beginDateStart)" border="0" style="cursor: hand" />
									
							    	<span class="subscribe">到 ：</span>
							    	<html:text property="beginDateOver" onchange="ckRange()" styleId="beginDateOver" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].beginDateOver)" border="0" style="cursor: hand" />
									
									
								</div>
							</div>
						</div>

						<div id="results_list">
							<ig:message />
							<table class="table_style">
								<!-- header部 -->

								<tr>
									<th width="2%">
										<label> <input type="checkbox"
											style="width: 20px;" name="allbox" id="allbox"
											onclick="selectAll('allbox','deleteEiid')" />
										</label>
									</th>
									<th width="15%">工作项名称</th>
									<th width="10%">周期</th>
									<th width="10%">开始日期</th>
									<th width="10%">负责人</th>
									<th width="13%">执行人</th>
									<th width="10%">预计完成时间</th>
									<th width="10%">发起人</th>
									<th width="10%">启用状态</th>
									<th width="10%">操作</th>
								</tr>

								<logic:present name="IGWIM01012VO" property="definitionInfos">
									<logic:iterate id="bean" name="IGWIM01012VO"
										property="definitionInfos" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<!-- checkbox -->
											<td>
												<c:if test="${bean.wdstatus != 1}">
													<input type="checkbox" style="width: 20px;" name="deleteEiid" value="${bean.wdid}" />
												</c:if>
											</td>
											<!-- 工作项名称 -->
											<td>
												<c:if test="${bean.wdstatus == 1}">
														${bean.wdname }
												</c:if>
												<c:if test="${bean.wdstatus != 1}">
													<a href="javascript:void(0)" onclick="modifyWD('${bean.wdid}')">
														${bean.wdname }
													</a>
												</c:if>
											</td>
											<!-- 周期 -->
											<td>
												<c:if test="${bean.cycle=='day' }">
													日
												</c:if>
												<c:if test="${bean.cycle=='week' }">
													周
												</c:if>
												<c:if test="${bean.cycle=='month' }">
													月
												</c:if>
												<c:if test="${bean.cycle=='quarter' }">
													季度
												</c:if>
												<c:if test="${bean.cycle=='halfyear' }">
													半年
												</c:if>
												<c:if test="${bean.cycle=='year' }">
													年
												</c:if>
											</td>
											<!-- 开始日期 -->
											<td>
												 <c:out value="${fn:substring(bean.beginDate, 0, 10)}"/>
											</td>
											<!-- 负责人 -->
											<td>
												${bean.leaderName}
											</td>
											<!-- 执行人 -->
											<td>
												${bean.excutorName }
											</td>
											
											<!-- 预计完成时间 -->
											<td>
												${bean.estimateFinishDate }
											</td>
											<!-- 发起人 -->
											<td>
												${bean.initiatorId }
											</td>
											<!-- 启用状态 -->
											<td>
												<c:if test="${bean.wdstatus == 1}">
													<a href="javascript:changeStatus(${bean.wdid});">
														<img src="images/stop.gif" border="0" alt="点击后停用"/>
													</a> 
												</c:if>	
												<c:if test="${bean.wdstatus != 1}">
													<a href="javascript:changeStatus(${bean.wdid});">
														<img src="images/start.gif" border="0" alt="点击后启用"/>
													</a>
												</c:if>	
<%-- 												<input type="text" name="status" value="${bean.wdstatus}"> --%>
											</td>
											<!-- 操作 -->
											<td align="center">
												<a href="javascript:void(0);" onclick="manualLaunch('${bean.wdid}','${bean.wdstatus }')" >
													<img src="images/9.gif" style="border:0px;" title ="手动发起" />
												</a>
											</td>
										</tr>

									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">

							<logic:present name="IGWIM01012VO" property="definitionInfos">
								<html:button property="btn_delete" value="删除所选"
									styleClass="button" onclick="return deleteRec();" />
							</logic:present>
							<jsp:include page="/include/paging.jsp" />
						</div>
<%-- 						<html:hidden property="syscoding" /> --%>
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>