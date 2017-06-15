<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1512" toScope="request" />
<bean:define id="title" value="培训计划、培训任务更新页面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	jQ(document).ready(function() {
		bindClick();
		
		
	});
	function toback() {
		document.forms[0].action = getAppRootUrl() + "/IGDRM1511_Back.do";
		document.forms[0].submit();
	}
	function checkSubmit() {
		var flag = true;
		var eles = document.getElementById("upTpname");
		if(eles.value.length == 0){
			alert("请输入培训计划名称！");
			return false;
		}else if(eles.value.length >256){
			alert("培训计划名称不能大于" + Math.floor(256 / strByteFlag) + "个汉字！");
			return false;			
		}
		
		jQ("#contentTable>tbody>tr").each(function (index, item) {
			jQ(item).children("td").each(function (i, o) {
				if ("" == jQ(o).children("input[id^='tmtarget']").val()) {
					alert("培训对象不能为空!");
					flag = false;
					return false;
				} // end if 
				if("" != jQ(o).children("input[id^='tmtarget']").val() && jQ(o).children("input[id^='tmtarget']").val()!= undefined ){
					if(jQ(o).children("input[id^='tmtarget']").val().strlen() > 120){
						alert("培训对象不能大于"+Math.floor(120/strByteFlag)+"个汉字!");
						flag = false;
						return false;
					}
				}
				if ("" == jQ(o).children("input[id^='tmcourse']").val()) {
					alert("培训课程不能为空!");
					flag = false;
					return false;
				} // end if 
				if("" != jQ(o).children("input[id^='tmcourse']").val() && jQ(o).children("input[id^='tmcourse']").val()!= undefined ){
					if(jQ(o).children("input[id^='tmcourse']").val().strlen() > 240){
						alert("培训课程不能大于"+Math.floor(240/strByteFlag)+"个汉字!");
						flag = false;
						return false;
					}
				}
				if ("" == jQ(o).children("input[id^='tmorg']").val()) {
					alert("培训机构不能为空!");
					flag = false;
					return false;
				} // end if 
				if("" != jQ(o).children("input[id^='tmorg']").val() && jQ(o).children("input[id^='tmorg']").val()!= undefined ){
					if(jQ(o).children("input[id^='tmorg']").val().strlen() > 240){
						alert("培训机构不能大于"+Math.floor(240/strByteFlag)+"个汉字!");
						flag = false;
						return false;
					}
				}
				if ("" == jQ(o).children("input[id^='tmtime']").val()) {
					alert("培训时间不能为空!");
					flag = false;
					return false;
				} // end if
			}); // end each
		}); // end each 
		if(!flag){
			return false;
		}
		if (window.confirm("是否确认提交？")) {
			return true;
		} else {
			return false;
		}
	}
		
function bindClick(){
			
			jQ("#btnAdd").bind("click", function(e) {
				var rowIndex = jQ("#contentTable tr").size();
				var rowContent = jQ("<tr class='bgRow" + (rowIndex % 2) + "'>" + 
					"<td width='5%' align='center'><label id='sn" + rowIndex + "'>" + (rowIndex + 1) + "</label></td><td width='3%'><input type='checkbox' id='deleteFlag" + rowIndex + "' name='deleteFlag'/></td>" + 
					"<td width='16%' align='center'><input type='text' id='tmtarget" + rowIndex + "' name='tmtarget'/></td>" + 
					"<td width='16%' align='center'><input type='text' id='tmcourse" + rowIndex + "' name='tmcourse'/></td>" + 
					"<td width='16%' align='center'><input type='text' id='tmorg" + rowIndex + "' name='tmorg'/></td>" + 
					"<td width='16%' align='center'>" + 
					"<input type='text' id='tmtime" + rowIndex + "' name='tmtime' readonly='readonly'/>" + 
					"<img src='images/date.gif' align='middle' onclick='calendar($(\"tmtime" + rowIndex + "\"))' border='0' style='cursor: hand;'/></td>" + 
					"<td id='uploadtd" + rowIndex + "' width='16%' align='center'><input type='file' id='attachFile" + rowIndex + "' name='attachment[" + rowIndex + "]' class='inputbutton' contentEditable='false' style='width: 185px; height: 18px;'/></td>" + 
					"</tr>");
				if(rowIndex==0){
					jQ("#contentTable>tbody").append(rowContent);
				}else{
					jQ("#contentTable>tbody>tr").last().after(rowContent);
				}
			}); // end bind  

			jQ("#btnDelete").bind("click", function (e) {
				// 删除选中行
				jQ("input[type='checkbox']:checked").each(function (index, item) {
					jQ(this).parent().parent().remove();
				}); // end each 

				// 重排序号
				jQ("#contentTable>tbody>tr").each(function (index, item) {
					jQ(this).find("[id^='sn']").attr("id", "sn" + index);
					jQ(this).find("[id^='sn']").text(index + 1);
					jQ(this).find("[id^='attachFile']").attr("name", "attachment[" + index + "]");
				}); // end each 
			}); // end bind  

 			jQ("#btnReset").bind("click", function(e){
 				jQ("input:not([type='button']):not([type='submit']):not([type='hidden']):not([id='startTime']):not([id='currentUID']):not([id='promoters']):not([id='departmentID']):not([id='sponsorDepartment']):not([id='upTptime']):not([id='upTpusername']):not([id='upTporgname'])").val("");
 				jQ("input[type='checkbox']").each(function (index, item) {
 					jQ(this).attr("checked", false);
 				});
 				jQ("input[type='file']").each(function(e){
 					var item = "uploadtd" + e;	//组合成td的id
 					var cfile = jQ(this).clone();	//复制当前file
 					jQ(this).remove();	//移除当前file
 					cfile.appendTo("#" + item);  //把复制的file添加到目标td中
 				});
			}); // end bind 

		} // end function bindClick 

		function delAttachment(e) {
			var src = e.target || window.event.srcElement;
			jQ(src).prev().remove();
			jQ(src).next().show();
			jQ(src).next().next().val("");
			jQ(src).remove();
		} 
	
</script>
<style type="text/css">
	.table_form_group {
		border-collapse: collapse;
		margin-top: -1px;
		margin-bottom: -1px;
		width: 960px;
	}
	.tdIcon {
		text-align: center;
		vertical-align: middle;
	}
	.checkboxLabel{
		vertical-align:middle;
		padding-top: 5px;
		float:left;
	}
	.table_style_scroll{
		width: 100%;
	}
	.table_style_scroll td {
		    border-bottom: 1px solid #D3D3D3;
		    height: 18px;
		    word-break: break-all;
		    word-wrap: break-word;
		}
		.table_style_scroll {
			width: 100%;
		    margin: 0 auto;
		    border-collapse: collapse;
		    text-align: center;
		    table-layout: fixed;
		}
		.table_style_scroll th {
			color: #000000;
		    border-top: 1px solid #CCCCCC;
		    border-bottom: 1px solid #CCCCCC;
		    background-color: #EEEEEE;
		    height: 20px;
		}
</style>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script language="JavaScript" src="js/tableform.js" type="text/javascript" charset="gbk"></script>

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
		<p class="fonts1">培训管理 &gt;&gt; 培训计划 &gt;&gt;培训计划管理</p>
		<div class="back">
			<html:link href="javascript:toback();">返回</html:link>
		</div>
	</div>
	<html:form action="/IGDRM1513_ToUpdate" method="post" styleId="form" enctype="multipart/form-data" onsubmit="return checkSubmit(this);" >
		<div id="results_list">
			<ig:message/> 
			<fieldset>
				<legend>培训计划制定</legend>
				<br/>
				<div>
					<label for="Name"><strong>发起时间</strong>：</label>
					<html:text property="upTptime" styleId="upTptime" style="width: 125px; border: 0px;" readonly="true" value="${IGDRM15011VO.trainplanInfo.tptime}"/>
				</div>
				<div>
					<label for="Name"><strong>发起人</strong>：</label>
					<html:hidden property="upTpuserid" styleId="upTpuserid" style="width: 125px; border: 0px;"  value="${IGDRM15011VO.trainplanInfo.tpuserid}" />
					<html:text property="upTpusername" styleId="upTpusername"  style="width: 125px; border: 0px;" value="${IGDRM15011VO.trainplanInfo.tpusername}"  readonly="true"/>
				</div> 
				<div>
					<label for="Name"><strong>发起部门</strong>：</label>
					<html:hidden property="upTporgid" styleId="upTporgid" value="${IGDRM15011VO.trainplanInfo.ptorgid}"/>
					<html:text property="upTporgname" styleId="upTporgname" value="${IGDRM15011VO.trainplanInfo.tporgname}" style="width: 125px; border: 0px;" readonly="true" />
				</div>
				<div>
					<label for="Name"><strong><span class="red">*</span><strong>培训计划名称</strong>：</label>
					<html:text property="upTpname" styleId="upTpname" value="${IGDRM15011VO.trainplanInfo.tpname}"/>
					<html:hidden property="upTpid" styleId="tpid" value="${IGDRM15011VO.trainplanInfo.tpid}"/>
	                <html:hidden property="upTpstatus" styleId="tpstatus" value="${IGDRM15011VO.trainplanInfo.tpstatus}"/>
				</div>
			</fieldset>
		</div>
		<div style="width: 100%;">
			<div>
				<input type="button" id="btnAdd" name="btnAdd" value="添加" class="button"/>
				<input type="button" id="btnDelete" name="btnDelete" value="删除" class="button"/>
			</div>
			<div style="width: 100%;">
			<table class="table_style_scroll">
				<tr >
					<th width="5%"  align="center">序号</th>
					<th width="3%"  align="center"></th>
					<th width="16%" align="center" style="margin-left:28px;"  >培训对象</th>
					<th width="16%" align="center">培训课程</th>
					<th width="16%" align="center">培训机构</th>
					<th width="16%" align="center">培训时间</th>
					<th width="18%" align="center">附件</th>
				</tr>
			</table>
			</div>
			
			<div style="overflow-x: hidden; overflow-y: auto; min-height: 480px;">
				<table id="contentTable" class="table_style_scroll">
					<c:forEach items="${IGDRM15011VO.resultList}" var="rMap" varStatus="status">
						<tr class="bgRow${status.index % 2}">
							<td width="5%" align="center">
								<label id="sn${status.index}">${status.index + 1}</label>
							</td>
							<td width="3%">
								<c:if test="${status.index != 0}"><input type="checkbox" id="deleteFlag${status.index}" name="deleteFlag"/></c:if>
							</td>
							<td width="16%" align="center"><input type="text" id="tmtarget${status.index}" name="tmtarget" value="${rMap.TMTARGET}"/></td>
							<td width="16%" align="center"><input type="text" id="tmcourse${status.index}" name="tmcourse" value="${rMap.TMCOURSE}"/></td>
							<td width="16%" align="center"><input type="text" id="tmorg${status.index}" name="tmorg" value="${rMap.TMORG}"/></td>
							<td width="16%" align="center"><input type="text" id="tmtime${status.index}" name="tmtime" readonly="readonly" value="${rMap.TMTIME}"/><img src="images/date.gif" align="middle" onclick="calendar($('tmtime${status.index}'))" border="0" style="cursor: hand;"/></td>
							<td id="uploadtd${status.index}" width="18%" align="center">
								<logic:empty name="rMap" property="ATTID">
									<input type="file" id="attachFile${status.index}" name="attachment[${status.index}]" class="inputbutton" contentEditable="false" style="width: 185px; height: 18px;"/>
									<input type="hidden" id="attkey${status.index}" name="attkeys" value=""/>
								</logic:empty>
								<logic:notEmpty name="rMap" property="ATTID">
									<html:link action="downloadSvcFile.do?attId=${rMap.ATTID}&type=${rMap.ATTURL}">${rMap.ATTNAME}</html:link>
									<img src="images/delate.gif" align="middle" onclick="delAttachment(this)" border="0" style="cursor: hand;"/>
									<input type="file" id="attachFile${status.index}" name="attachment[${status.index}]" class="inputbutton" contentEditable="false" style="width: 185px; height: 18px; display: none;" flag="1"/>
									<input type="hidden" id="tempAttkey${status.index}" name="attkeys" value="${rMap.ATTKEY}"/>
								</logic:notEmpty>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div style="text-align: center;">
					<input type="submit" id="btnSubmit" name="btnSubmit" value="保存" class="button"  />
<!-- 					<input type="button" id="btnReset" name="btnReset" value="重置" class="button"/> -->
				</div>
			</div>
		</div>
		<input type="hidden" id="detailContent" name="detailContent"/>
	</html:form>
	</div>
</div>
</div>
</div>
</body>
</html:html>