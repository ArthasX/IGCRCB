<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRIS0616" toScope="request" />
<bean:define id="title" value="检查项修改画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	var gid = '0';
	function checkForm() {
		var flag = true;
		if ($F('fcname').trim() == "") {
			alert("请输入风险事件名称！");
			return false;
		}

		var objs = document.getElementsByTagName("select");
		if (objs[1].value == null || objs[1].value == "") {
			alert("请选择风险事件来源");
			flag = false;
			return;
		}
		var ename = document.getElementById("fcdesc").value;
		if (ename == "" || ename == null) {
			alert("请输入风险事件描述！");
			flag = false;
			return;
		}
		if (objs[2].value == null || objs[2].value == "") {
			alert("请选择风险事件所属领域 ");
			flag = false;
			return;
		}

		var ename = document.getElementById("fcriskname").value;
		if (ename == "" || ename == null) {
			alert("请输入风险点名称！");
			flag = false;
			return;
		}
		var message = '<bean:message key="IGCO10000.W001" arg0="风险事件基本信息" />';
		if (window.confirm(message)) {
			flag = true;
		} else {
			flag = false;
			return;
		}
		if (flag) {
			form.action = "IGASM3203.do";
			form.submit();
		}
	}

	function selectVersion() {
		var a = document.getElementById("selecteiversion").value;
		var eiid = document.getElementById("eiid").value;
		window.location.href = "IGRIS0604_Disp.do?eiid=" + eiid + "&eiversion="
				+ a;
	}
	/* function setOrg(url) {

		var temp = window
				.showModalDialog(url, null,
						"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if ("_resetall" == temp) {
			document.getElementById("riskoperatordept").value = "";
			document.getElementById("fcoperatordept").value = "";
			return false;
		}
		if (null != temp && temp.split("|").length > 1) {
			document.getElementById("riskoperatordept").value = temp.split("|")[0];
			document.getElementById("fcoperatordept").value = temp.split("|")[1];
		}

	} */

	/* function searchuser() {
		gid = '0';
		var obj = $F('riskoperatordept');
		openSubWindow('/IGSYM1905_Disp.do?orgStr=' + obj, '_blank', '1000',
				'600', 'center:1');
	} */
	/* function searchccuser() {
		gid = '1';
		openSubWindow('/IGSYM1905_Disp.do?', '_blank', '1000', '600',
				'center:1');
	} */
	/* function setIGCYB0101Params(username, orgname, orgid, useremail, userphone,
			usermobile, userid) {
		if (gid == '0') {
			document.getElementById("fcoperator").value = username;
			document.getElementById("riskoperator").value = userid;
		} else {
			document.getElementById("fcccoperator").value = username;
			document.getElementById("riskccoperator").value = userid;
		}
	} */

	/* function rectification(eiid) {
		var url = '/IGCOM0401.do?parprid=&prtype=WD&prpdid=01002&flag=0&ptid=8&parameters='
				+ eiid
				+ '&isServiceStart=C&parameters=${IGASM3202Form.eiid}&pjdtype=3';
		window
				.showModalDialog(getAppRootUrl() + url, null,
						"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
		location.reload();
	} */
	/* function relatedRectification(prid) {
		var url = '/IGPRR0112_Disp.do?prid=' + prid;
		openSubWindow(url, '_blank', '1000', '600', 'center:1');
	} */
	/* function toBack() {
		form.action = "./IGFXK0000.do";
		form.submit();
	}
 */
	function setParams(prcorid, prcortype, prcortitle) {
		document.getElementById("fccheckjob").value = prcortitle;
		document.getElementById("riskjobid").value = prcorid;

	}

	function setParams2(eiid, einame, riskitem, poss, levels, grad) {

		document.getElementById("riskid").value = eiid;
		document.getElementById("fcriskname").value = einame;
		document.getElementById("fctypename").value = riskitem;
		document.getElementById("risktype").value = riskitem;
		document.getElementById("fcseveritylevel").value = poss;
		document.getElementById("fcpossibility").value = levels;
		document.getElementById("fclevel").value = grad;

	}
	/* function setOrg2(url) {
		openSubWindow('/IGSVC0107_Disp.do?prpdid=01001', '_blank', '1000',
				'600', 'center:1');

	} */
	/* function setOrg3(url) {
		var a = document.getElementById("riskjobid").value
		if (a == null || a == 0) {
			a = 0;
		}
		openSubWindow('/IGWKM0104.do?prid=' + a + '&jump=78', '_blank', '1000',
				'600', 'center:1');
	} */

	WebCalendar.timeShow = true; //是否返回时间
</script>
<style>
input {
	width: 254px;
	margin-left: 1px;
	border: 1px solid #ccc;
	height: 20px;
}

select {
	width: 255px;
	margin-left: 1px;
	border: 1px solid #ccc;
	height: 20px;
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

					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation extname1="风险事件处理" />
						</p>
						<div class="back">
							<a href="IGASM3201_Back.do">返回</a>
						</div>
					</div>

					<div id="formwrapper">
						<html:form styleId="form" action="/IGASM3203">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset>
								<legend>检查项基本信息</legend>
								<table width="860px"
									style="margin-left: 60px; margin-top: 20px;">
									<tr>
										<td align="right" width="160px"
											style="background-color: #EEEEEE;"><strong>检查项版本：</strong></td>
										<td align="left" width="254px"><logic:iterate id="map"
												name="IGRIS06041VO" property="configItemVWInfoMap"
												indexId="number">
												<html:select property="selecteiversion"
													onchange="selectVersion();"
													style="border:1px solid #CCCCCC;">
													<option value="">版本选择&nbsp&nbsp当前版本${IGRIS0604Form.selecteiversion}.0
													</option>
													<logic:present name="IGRIS06041VO"
														property="checkVersionMap">
														<%-- <html:optionsCollection name="IGASM27041VO" property="checkVersionMap" label="${versionMap.value}" value="${versionMap.value}"/> --%>
														<logic:iterate id="versionMap" name="IGRIS06041VO"
															property="checkVersionMap" indexId="index">
															<option value="${versionMap.value}">版本选择&nbsp&nbsp第&nbsp&nbsp
																${versionMap.value} &nbsp&nbsp版</option>
														</logic:iterate>
													</logic:present>
												</html:select>
											</logic:iterate></td>
									</tr>
									<tr>
										<td align="right" width="160px"
											style="background-color: #EEEEEE;"><span class="red">*</span><strong>检查项类别：</strong></td>
										<td align="left" width="250px"><html:select
												property="ename" style="width: 130px;" styleId="ename"
												onchange="setEntity(this)">
												<html:options collection="labelAndValueList"
													property="value" labelProperty="label" />
											</html:select></td>
									</tr>
									<logic:present name="IGRIS06041VO"
										property="configItemVWInfoMap">
										<logic:iterate id="map" name="IGRIS06041VO"
											property="configItemVWInfoMap" indexId="number">
											<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
											<logic:iterate id="bean" name="list" indexId="index">
												<%-- <c:if test="${bean.cattach =='2'}"> --%>
													<tr>
														<td height="20px" align="right" width="130px"
															style="background-color: #EEEEEE;"><span class="red">*</span><strong>${bean.cname
																}：</strong></td>
														<td align="left" width="250px"><html:text
																property="civalue"
																errorStyleClass="inputError imeActive" tabindex="2" /></td>
													</tr>
												<%-- </c:if> --%>

												<%-- <c:if test="${bean.cattach == '6' }"> --%>
													<tr>
														<td height="20px" align="right" width="130px"
															style="background-color: #EEEEEE;"><span class="red"><c:if
																	test="${bean.cname == '检查方法'  }">*</c:if></span><strong>${bean.cname
																}：</strong></td>
														<td align="left" width="250px"><html:textarea
																property="civalue"
																errorStyleClass="inputError imeActive"
																style="height:50px;width:250px;" tabindex="5" /></td>
														<td align="left" width="40px"></td>
													</tr>
												<%-- </c:if> --%>
												<%-- <c:if test="${bean.cattach == '1' }"> --%>
													<tr>
														<td height="20px" align="right" width="130px"
															style="background-color: #EEEEEE;"><span class="red"></span><strong>${bean.cname
																}：</strong></td>
														<td align="left" width="250px"><html:text
																property="civalue"
																errorStyleClass="inputError imeActive" tabindex="2" />
														</td>
													</tr>
												<%-- </c:if> --%>
											</logic:iterate>
										</logic:iterate>
									</logic:present>

								</table>
							</fieldset>
							<div class="enter">
								<html:button property="btn_insert" value="提交"
									styleClass="button" onclick="checkForm();" />
							</div>

							<html:hidden property="esyscoding" />
							<html:hidden property="eiorgsyscoding" />
							<html:hidden property="eistatus" />
							<html:hidden property="eiid" />
							<html:hidden property="eid" />
							<html:hidden property="highVersion" value="${highVersion}" />

						</html:form>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>