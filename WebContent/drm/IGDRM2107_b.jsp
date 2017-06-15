<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2107" toScope="request" />
<logic:equal name="IGDRM2105Form" property="mode" value="0">
	<bean:define id="title" value="专项预案查询" toScope="request" />
</logic:equal>
<logic:equal name="IGDRM2105Form" property="mode" value="1">
	<bean:define id="title" value="专项预案管理" toScope="request" />
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<!-- 其他bean -->
<c:set var="rowClass" value="row-check" />
<c:set var="delButtonId" value="btn_delete_sel" />
<!-- /其他bean -->
<script type="text/javascript">
	function checkSelected() {
		(window.event)&&(window.event.cancelBubble=true); 
		var rows = j$('.${rowClass}:checked');
		if (rows && rows.length > 0) {
			j$('#${delButtonId}').get(0).disabled = false;
		} else {
			j$('#${delButtonId}').get(0).disabled = true;
		}
	}

	function confirmDelete() {
		var msg = "是否删除此 " + j$('.${rowClass}:checked').length + " 条预案信息？";
		return confirm(msg);
	}

	// 选择业务系统
	function selectYWXT(esyscoding) {
		openSubWindows('/IGDRM2101_BsInit.do?flag=sign&esyscoding='
				+ esyscoding, '', '1100', '600');
	}

	// 清除业务系统
	function clearYWXT() {
		setParamDRM2101("", "", "", "", "", "", "", "", "");
	}

	function setParamDRM2101(eid, elabel, ename, eiid, eilabel, einame,
			ecategory, eiversion, esyscoding,ids) {
		j$("#einame_cld_ywxt").val(einame);
		j$("#eiid_cld_ywxt").val(eiid);
		condChange();
	}

	// 选择应急资源
	function selectYJZY(pidid, esyscoding) {
		openSubWindow('/IGDRM0406_Disp.do?pidid=' + pidid + "&esyscoding=" + esyscoding , '', '850', '600');
	}
	// 清除应急资源
	function clearYJZY(){
		setParamIGCOM0302("", "", "", "", "", "", "", "", "");
	}
	
	function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame,
			ecategory, eiversion, esyscoding) {
		j$("#einame_cld_yjzy").val(einame);
		j$("#eiid_cld_yjzy").val(eiid);
		condChange();
	}
	
	// 选择场景
	function selectCJ(){
		openSubWindow('/IGDRM2104_Search.do', '', '850', '600');
	}
	// 清除场景
	function clearCJ(){
		setParamIGDRM2105([], []);
	}
	
	function setParamIGDRM2105(namesArr, eiidsArr){
		if(null != eiidsArr.length && null != namesArr.length){
			var names = namesArr.join('；'),
				eiids = eiidsArr.join(',');
			j$('#einame_cld_cj').val(names);
			j$('#eiid_cld_cj').val(eiids);
			condChange();
		}
	}
    function openSubWindows(uri, wName, width, height){
    	width = width ? width : 800;
    	height = height ? height : 600;
    	var iTop = (window.screen.availHeight-30-width)/2;            //获得窗口的垂直位置;
    	var iLeft = (window.screen.availWidth-10-height)/2;           //获得窗口的水平位置;
    	window.open(getAppRootUrl() + uri, wName, 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
    }
    
    function condChange(){
    	j$('.cond-value').each(function(index, obj){
    		var o = j$(obj);
        	if(!o.val() || '' == o.val().trim()){
        		o.nextAll('.btn-clear:first').hide();
        		o.nextAll('.btn-seek:first').show();
    	    }
        	else{
        		o.nextAll('.btn-clear:first').show();
        		o.nextAll('.btn-seek:first').hide();
        	}
    	});
    }
    j$(function(){
    	j$("tr[eiid]").addClass("clickable").click(function(event){
    		window.location.href="IGDRM2102_View.do?eid=CM8001002&mode="+j$("#pageMode").val()+"&eiid="+j$(this).attr("eiid");
    	});
    	
    })
    
</script>
<style>
.row-check {
	
}

.subscribe {
	
}

.button[disabled=disabled] {
	user-select: none;
}

.btn-clear{
	display: none;
}
.clickable{
	cursor: pointer;
}

</style>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<div id="contentWrap">
				<!--content  右侧内容-->
				<div id="content" style="padding-top: -10px;">
					<div id="formwrapper">
						<html:form styleId="IGDRM2105Form" action="/IGDRM2105">
							<div id="location">
								<div class="image"></div>
								<p class="fonts1">
									<ig:navigation extname1="${urlable}" />
								</p>
							</div>
							<div id="search">
								<div class="img"></div>
								<div class="conditions">
									<div style="margin-top: 10px;">
										<span class="subscribe"><b>预案名称:</b></span>
										<html:text property="einame_q" />

										<span class="subscribe"><b>业务系统:</b></span>
										<html:text styleId="einame_cld_ywxt" styleClass="cond-value" title="双击选择业务系统"
											property="einame_cld_ywxt" readonly="true"/>
										<img class="btn-seek" src="images/seek.gif" onclick="selectYWXT('1_CM03000000_999003')"
											border="0" width="16" height="16" alt="选择业务系统"
											onclick="clearCJ()" style="cursor: pointer" />
										<img class="btn-clear" src="images/delate.gif"
											border="0" width="16" height="16" alt="清空"
											onclick="clearYWXT()" style="cursor: pointer" />
										<html:hidden styleId="eiid_cld_ywxt" property="eiid_cld_ywxt" />
											
									</div>
									<div>
										<span class="subscribe"><b>&nbsp;&nbsp;&nbsp;&nbsp;场景:</b></span>
										<html:text styleId="einame_cld_cj" styleClass="cond-value"
										 property="einame_cld_cj"
											readonly="true" />
										<img class="btn-seek" src="images/seek.gif" onclick="selectCJ('1_CM03000000_999003')"
											border="0" width="16" height="16" alt="选择场景"
											onclick="clearCJ()" style="cursor: pointer" />
										<img class="btn-clear" src="images/delate.gif"
											border="0" width="16" height="16" alt="清空"
											onclick="clearCJ()" style="cursor: pointer" />
										<html:hidden styleId="eiid_cld_cj" property="eiid_cld_cj" />
										<span class="subscribe"><b>应急资源:</b></span>
										<html:text styleId="einame_cld_yjzy" styleClass="cond-value" title="双击选择应急资源"
											property="einame_cld_yjzy" readonly="true" />
										<img class="btn-seek" src="images/seek.gif" onclick="selectYJZY('0130501006','999040')"
											border="0" width="16" height="16" alt="选择应急资源"
											onclick="clearCJ()" style="cursor: pointer" />
										<img class="btn-clear" src="images/delate.gif"
											border="0" width="16" height="16" alt="清空"
											onclick="clearYJZY()" style="cursor: pointer" />
										<html:hidden styleId="eiid_cld_yjzy" property="eiid_cld_yjzy" />

										<html:submit property="btn_search" styleClass="button"
											value="查询"></html:submit>
									</div>
								</div>
								<script>condChange();</script>
							</div>
							<div id="results_list">
								<ig:message />
								<table class="table_style">
									<tr>
										<logic:equal name="IGDRM2105Form" property="mode" value="1">
											<th width="6%" style="text-align: center;">
												<label>
													<input type="checkbox" id="check_all" title="全选/不全选本页" onclick="selectAll('check_all', 'selectedEiids');checkSelected();" />
												</label>
											</th>
										</logic:equal>
										<logic:equal name="IGDRM2105Form" property="mode" value="0">
											<th width="6%">序号</th>
										</logic:equal>
										<th width="30%">预案名称</th>
										<th width="36%">预案描述</th>
										<th width="8%">登记日期</th>
										<th width="8%">登记人员</th>
										<logic:equal name="IGDRM2105Form" property="mode" value="1">
											<th width="4%">修改</th>
											<th width="4%">详细</th>
										</logic:equal>
											<th width="4%">操作</th>
									</tr>
									<logic:present name="IGDRM21051VO" property="soc0118VWList">
										<logic:iterate id="info" name="IGDRM21051VO"
											property="soc0118VWList" indexId="index">
											<tr eiid="${info.eiid }"  class="<ig:rowcss index="${index}"/>">
												<logic:equal name="IGDRM2105Form" property="mode" value="1">
													<td style="text-align: center;"><html:checkbox
															property="selectedEiids" styleClass="${rowClass}"
															onclick="checkSelected();" value="${info.eiid}" /></td>
												</logic:equal>
												<logic:equal name="IGDRM2105Form" property="mode" value="0">
												<td>${PagingDTO.viewStartCount + index}</td>
												</logic:equal>
												<td>${info.einame}</td>
												<td>${info.eidesc}</td>
												<td>${info.eiinsdate}</td>
												<td>${info.eiusername}</td>
												<logic:equal name="IGDRM2105Form" property="mode" value="1">
													<td><html:link
															action="/IGDRM2101_Edit.do?eiid=${info.eiid}">
															<img src="images/edit.gif" alt="修改" width="16"
																height="16" border="0" />
														</html:link></td>
												</logic:equal>
												<logic:equal name="IGDRM2105Form" property="mode" value="1">
													<td><html:link
															action="/IGDRM2102_Disp.do?eid=${info.eid}&eiid=${info.eiid}">
															<img src="images/xx.gif" alt="显示详细信息" width="16"
																style="cursor: pointer;" height="16" border="0" />
														</html:link></td>
												</logic:equal>
												<td>
													<a href="IGDRM2105_Export.do?eiid=${info.eiid }"><img src="images/batch.gif" alt="导出" width="16"
																style="cursor: pointer;" height="16" border="0" /></a>
												</td>
											</tr>
										</logic:iterate>
									</logic:present>
								</table>
							</div>
							<div id="operate">
								<logic:equal name="IGDRM2105Form" property="mode" value="1">
									<html:submit styleId="${delButtonId}" property="${delButtonId}"
										value="删除所选"  styleClass="button"
										onclick="return confirmDelete();"   />
								</logic:equal>
								<!-- paging -->
								<jsp:include page="/include/paging.jsp" />
							</div>
							<html:hidden styleId="pageMode" property="mode" value="${IGDRM2105Form.mode }" />
						</html:form>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
</html:html>