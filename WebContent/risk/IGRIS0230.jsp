<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRIS0230" toScope="request" />
<bean:define id="title" value="检查项基本信息登记画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<!-- /header1 -->
<script type="text/javascript">
	var gid = 'IGRIS0602';
	
	//给检查策略设定画面
	function setIGRIK0202(eiids,eiversions,einame,eidescs,rcommons,riskitems,eistatus) {
		window.dialogArguments.setParams1(eiids,'1',einame,eidescs,rcommons,riskitems,'启用');
	}
	function checkForm() {
		var flag = true;
		var ename = document.getElementById("ename").value;
		if (ename == "" || ename == null) {
			alert("请选择检查项分类！");
			flag = false;
			return;
		}
		var inputs = document.getElementsByTagName("input");
		var asss = $('table :input');
		if (asss[1].value == null || asss[1].value == "") {
			alert("检查项名称不能为空！");
			flag = false;
			return;
		}
		if (asss[1].value.strlen() > 150) {
			alert("检查项名称长度不能大于50个汉字！");
			flag = false;
			return;
		}
		var texts = document.getElementsByTagName("textarea");
		if (texts[1].value == null || texts[1].value == "") {
			alert("检查项方法不能为空！");
			flag = false;
			return;
		}
		if (texts[1].value.strlen() > 1500) {
			alert("检查方法内容长度不能大于500个汉字！");
			flag = false;
			return;
		}

		//检查项说明校验设置不大于80个汉字
		if (asss[2].value.strlen() > 1500) {
			alert("检查项说明不能大于" + Math.floor(1500 / strByteFlag) + "个汉字！");
			return false;
		}
		//校验登记时间必填
		if (asss[6].value == null || asss[6].value == "") {
			alert("登记时间不能为空！");
			flag = false;
			return;
		}
		var message = '<bean:message key="IGCO10000.W001" arg0="检查项基本信息" />';
		if (window.confirm(message)) {
			flag = true;
		} else {
			flag = false;
			return;
		}
		if (flag) {
			$.ajax({								
				type:'post',
				url:'IGRIS0602_INSERT.do',
				dataType:'text',
				data:$('form').serialize(),
				success:function(data){  //此处为关闭的代码 
					var rsqText = data;
					var eientys = rsqText.split("_");
					//信息通过输出流输出到session中保存
					setIGRIK0202(eientys[0],'0',eientys[1],eientys[2],eientys[3],eientys[4],'启用');
					window.close();
					this.close();
				}
			}); 
			//setIGRIK0202('2070','0','einame','eidesc','eicommon','机房','启用');
		}
	}

	function searchuser() {
		openSubWindow('/IGSYM1905_Disp.do?', '_blank', '1000', '600',
				'center:1');
	}
	function setIGCYB0101Params(username, orgname, orgid, useremail, userphone,
			usermobile, userid) {

		document.getElementById("mgusername").value = username;
		document.getElementById("mguserid").value = userid;
	}
	function onExcel() {
		form.action = "IGRIS0614_Disp.do";
		form.submit();
	}
	function getsecondLeval(firstLevalCode) {
		var flag;
		if (firstLevalCode == '001') {
			flag = 'IG';
		}
		if (firstLevalCode == '002') {
			flag = 'RM';
		}
		if (firstLevalCode == '003') {
			flag = 'ISM';
		}
		if (firstLevalCode == '004') {
			flag = 'IDT';
		}
		if (firstLevalCode == '005') {
			flag = 'RUN';
		}
		if (firstLevalCode == '006') {
			flag = 'BCM';
		}
		if (firstLevalCode == '007') {
			flag = 'OSM';
		}
		if (firstLevalCode == '008') {
			flag = 'AUM';
		}
		return flag;
	}
	var eilabelvalue;
	function setEntity(obj) {
		var temp = obj.value;

		var name = obj.options[obj.selectedIndex].text;
		if (null != temp && temp != '') {
			var syscode_eid = temp.split("|")[0];
			var syscode;
			var eid;
			if (syscode_eid == "999") {
				alert("资产模型不可用！请选择其他模型！");
				return false;

			} else if (syscode_eid.split("_").length > 1) {
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
				document.getElementById("_eid").value = syscode;
			}
			var eilabelcode = getEilabel(syscode);
			eilabelvalue = eilabelcode;
			searchMaxEntityItemLable();
			//获取风险点编号前几位,类似“IG-D0101”
			document.forms[0].eid.value = eid;
			document.forms[0].esyscoding.value = syscode;

		}
	}
	function getEilabel(syscode) {
		//syscode(999017001001001)中的999017后的前三位,二级分类序号
		var firstLevalCode = syscode.substring(6, 9);
		var firstLeval = getsecondLeval(firstLevalCode);
		var secondLevalCode = syscode.substring(10, 12);
		var thirdLevalCode = syscode.substring(13, 15);
		var eilabel = firstLeval + '-SX' + secondLevalCode + thirdLevalCode;
		return eilabel;
	}
	function searchMaxEntityItemLable() {
		if (eilabelvalue == undefined) {
			alert("请选择检查项分类！");
			return;
		}
		var url = getAppRootUrl() + "/ajaxForEilabel.do";
		jQuery
				.ajax({
					type : "POST",
					url : url,
					data : "ecategorykey=" + eilabelvalue,
					success : function(msg) {
						var result = msg;
						if (result != null && result.trim() != "") {
							document.getElementById("eilabel").value = result;
						} else {
							document.getElementById("labelMessage").innerText = "获取编号失败！";
						}
					}
				});
	}
	var attachFileNum = 0;
	var attach = "";
	function addFile() {
		currRow = tb.insertRow();
		cell = currRow.insertCell();
		cell.innerHTML = "<input type='file' name='fileList["+attachFileNum+"].file' class='inputbutton' contentEditable='false'><input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteitem(this)'>";
		attachFileNum++;
	}
	function deleteAttach(td, obj) {
		//alert(obj);  
		if (window.confirm("确定要删除附件吗？")) {
			var attachLink = document.getElementById("attach" + obj);
			attachLink.linkName = "";
			//alert(attachLink);
			if (attach == "") {
				attach = obj;
			} else {
				attach = attach + '_' + obj;
			}
			//alert(attach);
			var curRow = td.parentNode.parentNode;
			tb2.deleteRow(curRow.rowIndex);
		}
	}
	function deleteitem(obj) {
		var curRow = obj.parentNode.parentNode;
		tb.deleteRow(curRow.rowIndex);
	}

	function deleteitem(obj) {
		var curRow = obj.parentNode.parentNode;
		tb.deleteRow(curRow.rowIndex);
	}
	//删除附件
	//删除附件
	function delFile(attid) {
		if (window.confirm("您是否确定删除附件？")) {
			document.getElementById(attid).style.display = "none";
			if ($("deletekeys").value != "") {
				$("deletekeys").value = $("deletekeys").value + ',' + attid;
			} else {
				$("deletekeys").value = attid;
			}
		}
	}
	function searchuser() {
		openSubWindow('/IGSYM1905_Disp.do?', '_blank', '1000', '600',
				'center:1');
	}
	function setIGCYB0101Params(username, orgname, orgid, useremail, userphone,
			usermobile, userid) {

		document.getElementById("mgusername").value = username;
		document.getElementById("mguserid").value = userid;
	}
	function selectClose(){
		alert($("#closeAndOpen").val());
	}
	//获取登记时间
	function getDate(){
		var obj = document.getElementById("dengjidate");
		showDate(obj);
	}
	//初始化登记时间
	function initDate(){
		var obj = document.getElementById("dengjidate");
		var date = new Date();
		var vYear = date.getFullYear();
		var vMon = date.getMonth() + 1;
		var vDay = (date.getDate()+"").length ==1?"0"+date.getDate():date.getDate();
		obj.value=vYear+"/"+vMon+"/"+vDay;
	}
</script>
<style>
.input {
	width: 368px;
	margin-left: 1px;
	border: 1px solid #ccc;
	line-height: 20px;
	font-size: 12px;
}

textarea {
	width: 368px;
	padding: 1px;
	border: 1px solid #ccc;
	margin: 1px;
	font-family: 'Tahoma';
	font-size: 12px;
	font-weight: normal;
}

select {
	width: 258px;
	margin-left: 1px;
	margin-top: 4px;
	border: solid #ccc;
}

#shade {
	border: solid 1px #ccc;
	width: 253px;
	height: 17px;
	overflow: hidden;
	margin-left: 1px;
}

.333select {
	width: 255px;
	padding: 1px;
	border: 1px solid #ccc;
	margin: 1px;
	font-family: 'Tahoma';
	font-size: 12px;
	font-weight: normal;
}
</style>

<body onload="initDate();">
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">

					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation extname1="${urlable}" /> &gt;&gt; 检查项设定
						</p>
					</div>

					<div id="formwrapper">
						<html:form styleId="form" action="/IGRIS0602"
							onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset>
								<logic:equal name="IGRIS0602Form" property="mode" value="0">
									<legend>检查项基本信息添加</legend>
								</logic:equal>
								<logic:equal name="IGRIS0602Form" property="mode" value="1">
									<legend>检查项基本信息变更</legend>
								</logic:equal>




								<table width=""
									style="margin-left: 60px; margin-top: 20px;">
									<tr>
										<td height="20px" align="right" width=""
											style="background-color: #EEEEEE;"><span class="red"> * </span><strong>检查项分类：</strong></td>
										<td align="left" width="250px"><%-- <html:text
												property="ename" styleId="ename"
												errorStyleClass="inputError imeActive" readonly="true"
												tabindex="2" /> --%>
											<html:select property="ename" style="width: 130px;" styleId="ename" onchange="setEntity(this)">
									    		<html:options collection="labelAndValueList" property="value" labelProperty="label"/>
									    	</html:select>		
										</td>
									</tr>

									<logic:present name="IGRIS06071VO" property="soc0109List">
										<logic:iterate id="bean" name="IGRIS06071VO"
											property="soc0109List" indexId="index">
											<c:if test="${bean.cattach =='0' && bean.cname=='检查项id'}">
												<tr style="display:none">
													<td height="20px" align="right" width=""
														style="background-color: #EEEEEE;"><strong>${bean.cname}：</strong></td>
													<td align="left" width="250px"><html:text styleClass="input"
															property="civalue" styleId="_eid" errorStyleClass="inputError imeActive"
															tabindex="2" /></td>
												</tr>
											</c:if>
											<c:if test="${bean.cattach =='0' && bean.cname=='检查项名称'}">
												<tr>
													<td height="20px" align="right" width=""
														style="background-color: #EEEEEE;"><span class="red"> * </span><strong>${bean.cname}：</strong></td>
													<td align="left" width="250px"><html:text styleClass="input"
															property="civalue" errorStyleClass="inputError imeActive"
															tabindex="2" /></td>
												</tr>
											</c:if>
											
											<c:if test="${bean.cattach == '3' }">
												<tr>
													<td height="20px" align="right" width=""
														style="background-color: #EEEEEE;"><span class="red"> * </span><strong>${bean.cname}：</strong></td>
													<td align="left"  >
													<html:text property="civalue" styleId="dengjidate" errorStyleClass="inputError imeActive" size="12" tabindex="5" styleClass="inputDisable" readonly="true" /> 
													<img src="images/date.gif" align="middle" onClick="getDate()" border="0" style="cursor: hand"/></td>
												</tr>
											</c:if>
											
											<c:if test="${bean.cattach == '6' }">
												<tr>
													<td height="20px" align="right" width=""
														style="background-color: #EEEEEE;"><span class="red"><c:if
																test="${bean.cname == '检查方法'  }"> * </c:if></span><strong>${bean.cname}：</strong></td>
													<td align="left" width="250px"><html:textarea
															property="civalue" errorStyleClass="inputError imeActive"
															cols="50" rows="8" /></td>
													<td align="left" width="40px"></td>
												</tr>
											</c:if>
											<c:if test="${bean.cattach == '1' }">
												<tr>
													<td height="20px" align="right" width=""
														style="background-color: #EEEEEE;"><span class="red"></span><strong>${bean.cname}：</strong></td>
													<td align="left" width="250px">
													<html:text styleClass="input"
															property="civalue" errorStyleClass="inputError imeActive"
															tabindex="2" style="display:none"/>
													</td>
												</tr>
											</c:if>
											
										</logic:iterate>
										<tr>
											<td colspan="2">
											</td>
										</tr>
									</logic:present>
								</table>
								<div>
								<img src="images/attachment.gif" />
								<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
								<table id="tb">
								</table>
								</div>
							</fieldset>
							<div class="enter">
								<html:button property="btn_insert" value="提交"
									styleClass="button" onclick="checkForm();" />
								<input type="button" class="button" value="关闭" onclick="window.close();">
							</div>
							<html:hidden property="eid" styleId="eid" />
							<html:hidden property="esyscoding" />
							<html:hidden property="eilabel" />
							<html:hidden property="mode" styleId="mode" />
						</html:form>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>