<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSTL -->
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<!-- STRUTS -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>


<html:html>

	<bean:define id="id" value="IGDRM1503" toScope="request" />
	<bean:define id="title" value="培训计划制定" toScope="request" />
	<!-- header1 -->
	<jsp:include page="/include/header1.jsp" />
	<!-- /header1 -->
	<style>
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
		.table_style_scroll td {
		    border-bottom: 1px solid #D3D3D3;
		    height: 18px;
		    word-break: break-all;
		    word-wrap: break-word;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		var jQ = jQuery.noConflict(true);
		
		var ZD_mark = false;
		function initPage () {
// 			jQ("#currentUID").val(currentUser.userid);
// 			jQ("#promoters").val(currentUser.username);
// 			jQ("#departmentID").val(currentUser.orgid);
// 			jQ("#sponsorDepartment").val(currentUser.orgname);
		} 
		
		function bindClick() {
			jQ("#btnAdd").bind("click", function(e) {
				var rowIndex = jQ("#contentTable>tbody>tr").size();
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
				jQ("#contentTable>tbody>tr").last().after(rowContent);
			}); 

			jQ("#btnDelete").bind("click", function (e) {
				// 删除选中行
				jQ("input[type='checkbox']:checked").each(function (index, item) {
					jQ(this).parent().parent().remove();
				}); 

				// 重排序号
				jQ("#contentTable>tbody>tr").each(function (index, item) {
					jQ(this).find("[id^='sn']").attr("id", "sn" + index);
					jQ(this).find("[id^='sn']").text(index + 1);
					jQ(this).find("[id^='attachFile']").attr("name", "attachment[" + index + "]");
				});
			}); 

 			jQ("#btnReset").bind("click", function(e){
 				jQ("input:not([type='button']):not([type='submit']):not([type='hidden']):not([id='upTptime']):not([id='upTpusername']):not([id='upTporgname']):not([id='currentUID']):not([id='promoters']):not([id='departmentID']):not([id='sponsorDepartment'])").val("");
 				jQ("input[type='checkbox']").each(function (index, item) {
 					jQ(this).attr("checked", false);
 				});
 				jQ("input[type='file']").each(function(e){
 					var item = "uploadtd" + e;	//组合成td的id
 					var cfile = jQ(this).clone();	//复制当前file
 					jQ(this).remove();	//移除当前file
 					cfile.appendTo("#" + item);  //把复制的file添加到目标td中
 				});
			}); 
		} 

		jQ(document).ready(function() {

			initPage();

			bindClick();

			jQ("#form").submit(function(e) {
				var flag = true;
				if ("" == jQ("#upTpname").val()) {
					alert("培训计划名称不能为空!");
					return false;
				} // end if 
				if (jQ("#upTpname").val().strlen() > 128) {
					alert("培训计划名称不能大于" + Math.floor(128 / strByteFlag) +" 个汉字!");
					return false;
				} // end if 
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
							if(jQ(o).children("input[id^='tmcourse']").val().strlen() > 128){
								alert("培训课程不能大于"+Math.floor(128/strByteFlag)+"个汉字!");
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
							if(jQ(o).children("input[id^='tmorg']").val().strlen() > 128){
								alert("培训机构不能大于"+Math.floor(128/strByteFlag)+"个汉字!");
								flag = false;
								return false;
							}
						}
						if ("" == jQ(o).children("input[id^='tmtime']").val()) {
							alert("培训时间不能为空!");
							flag = false;
							return false;
						}
					}); 
				});
				return window.confirm("是否确认提交？");
			}); 
		});	// end ready 
	</script>
	<body>
		<div id="maincontent">
			<!--header  头部和 一级菜单-->
			<jsp:include page="/include/header2.jsp" />
			<!--container 左菜单 右侧内容-->
			<div id="container">
				<div id="contentWrap">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
					</div>
					<div id="content">
						<html:form action="/IGDRM1503_ADD" method="post" styleId="form" enctype="multipart/form-data">
							<div id="results_list">
								<fieldset>
									<legend>培训计划登记</legend>
									<br/>
									<div>
										<label for="Name"><strong>发起时间</strong>：</label>
										<html:text property="upTptime" styleId="upTptime" style="width: 125px; border: 0px;" readonly="true"/>
									</div>
									<div>
										<label for="Name"><strong>发起人</strong>：</label>
										<input type="hidden" id="upTpuserid" name="upTpuserid" value="${LOGIN_USER.userid}"/>
										<input type="text" id="upTpusername" name="upTpusername" value="${LOGIN_USER.username}" style="width: 125px; border: 0px;" readonly="readonly"/>
									</div>
									<div>
										<label for="Name"><strong>发起部门</strong>：</label>
										<input type="hidden" id="upTporgid" name="upTporgid" value="${LOGIN_USER.orgid}"/>
										<input type="text" id=upTporgname name="upTporgname" value="${LOGIN_USER.orgname}" style="width: 125px; border: 0px;" readonly="readonly"/>
									</div> 
									<div>
										<label for="Name"><span class="red">*</span><strong>培训计划名称</strong>：</label>
										<input type="text" id="upTpname" name="upTpname" value="${IGDRM1512Form.upTpname}"/>
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
										<tr>
											<th width="5%" align="center">序号</th>
											<th width="3%" align="center"></th>
											<th width="16%" align="center">培训对象</th>
											<th width="16%" align="center">培训课程</th>
											<th width="16%" align="center">培训机构</th>
											<th width="16%" align="center">培训时间</th>
											<th width="18%" align="center">附件</th>
										</tr>
									</table>
								</div>
								<div style="overflow-x: hidden; overflow-y: auto; min-height: 480px;">
									<table id="contentTable" class="table_style_scroll">
										<tr class="bgRow0">
											<td width="5%" align="center"><label id="sn0">1</label></td>
											<td width="3%" align="center"></td>
											<td width="16%" align="center"><input type="text" id="tmtarget0" name="tmtarget"/></td>
											<td width="16%" align="center"><input type="text" id="tmcourse0" name="tmcourse"/></td>
											<td width="16%" align="center"><input type="text" id="tmorg" name="tmorg"/></td>
											<td width="16%" align="center"><input type="text" id="tmtime0" name="tmtime" readonly="readonly"/><img src="images/date.gif" align="middle" onclick="calendar($('tmtime0'))" border="0" style="cursor: hand;"/></td>
											<td id="uploadtd0" width="18%" align="center"><input type="file" id="attachFile0" name="attachment[0]" class="inputbutton"  contentEditable="false" style="width: 185px; height: 18px;"/></td>
										</tr>
									</table>
									<div style="text-align: center;">
										<input type="submit" id="btnSubmit" name="btnSubmit" value="保存" class="button"/>
<!-- 										<input type="button" id="btnReset" name="btnReset" value="重置" class="button"/> -->
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