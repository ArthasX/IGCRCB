<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<script type="text/javascript" src="js/menu/jquery.js"></script>
<html:html>
<bean:define id="id" value="IGVIR3003" toScope="request"/>
<bean:define id="title" value="部署进度" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	var test = 1;
	var intId;
	jQuery(document).ready(function(){
		intId=self.setInterval("getProgress()",2000);
	});
	function getProgress(){
		var refreshFlag = '0';
		jQuery("td[id^='vmprogress_']").each(function(){
			if(jQuery(this).text()!='100%'){
				refreshFlag = '1';
				return;
			}
		});
		if(refreshFlag == '1'){
			var par = {};
			par.pid = jQuery("#vmpid").val();
			jQuery.ajax({
				url:"IGVIR3003_GETPROGRESS.do",
				type:"POST",
				dataType :"json",
				data:par,
				cache:false,
				success:function(res){
					jQuery(res).each(function(i,t){
						if(jQuery("#vmprogress_"+t.id).length>0){
							var str = t.progress;
							if(str==null || str==undefined || str==''){
								str = '0';
							}
							jQuery("#vmprogress_"+t.id).text(str+"%");
						}
					});
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					//alert('出错了');
				}
			});
		}else{
			intId = window.clearInterval(intId);
		}
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">
     
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content" style="width: 800px">
			<div class="title">
			<div class="name">虚机信息</div>
			</div>
			<table id="vminfo" cellspacing="0" class="table_style" style="margin-top: 5px; width: 98%;" >
				<tr>
					<th style="text-align: center;" width="5%">序号</th>
					<th style="text-align: center;" width="15%">vCenter</th>
					<th style="text-align: center;" width="15%">虚机模板</th>
					<th style="text-align: center;" width="15%">虚机名称</th>
					<th style="text-align: center;" width="10%">CPU</th>
					<th style="text-align: center;" width="10%">内存</th>
					<th style="text-align: center;" width="10%">硬盘</th>
					<th style="text-align: center;" width="10%">进度</th>
				</tr>
				<logic:present name="IGVIR30031VO" property="vcd03List">
						<logic:iterate id="bean" name="IGVIR30031VO"
							property="vcd03List" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">				
								<td>${index+1}</td>
								
								<td>${bean.vcname}</td>
								
								<td>${bean.templateName}</td>
								
								<td>${bean.vmName}</td>
								
								<td>${bean.vmCpus}(个)</td>
								
								<td>${bean.vmMem}(G)</td>
								
								<td>${bean.vmDisk}(G)</td>
								
								<td id='vmprogress_${bean.id}'>${bean.progress}%</td>
							</tr>
						</logic:iterate>
					</logic:present>
			</table>
			<input type="hidden" id="vmpid" value="${IGVIR30031VO.pid}">
        </div>
    </div>
</div>

</div>
</body>
</html:html>