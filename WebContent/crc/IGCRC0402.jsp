<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGCRC0402" toScope="request" />
<bean:define id="title" value="变更批量处理" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
	function del(obj){
		obj.parentElement.parentElement.parentElement.deleteRow(obj.parentElement.parentElement.rowIndex);
	}
	function dispose(){
		var varnames = document.getElementsByName("pivarnames");
		var varvalues = document.getElementsByName("pivarvalues");
		if(varnames && varvalues && varnames.length > 0 && varvalues.length > 0){
			for(var i=0;i<varnames.length;i++){
				
				if(varnames[i].value.trim() != "生产变更开始时间"
						&& varnames[i].value.trim() != "生产变更结束时间" 
						&& varnames[i].value.trim() != "生产变更执行过程"
						&& varnames[i].value.trim() != "UAT变更执行开始时间"
						&& varnames[i].value.trim() != "UAT变更执行结束时间"
						&& varnames[i].value.trim() != "UAT变更执行过程"){
					
					if(varvalues[i].value.trim() == ""){
						alert("请输入" + varnames[i].value + "！");
						return;
					}
				}
				if(varvalues[i].value.strlen() > 2100){
					alert(varnames[i].value + "不能大于" + Math.floor(2100/strByteFlag) + "个汉字！");
					return;
				}
			}
		}
		if(window.confirm("是否确认提交？")){
			form.submit();
		}
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> 
<div id="container">
<div id="contentWrap">
<div id="content">
<html:form action="/IGCRC0402" styleId="form" enctype="multipart/form-data" onsubmit="return checkSubmit(this);" >
	<html:hidden property="pdid"/>
	<html:hidden property="prstatus"/>
	<div id="location">
		<div class="image"></div>
		<p class="fonts1">
			<ig:navigation extname1="批量处理"/>
		</p>
		<div class="back">
			<a href="IGCRC0401.do?pdid=${IGCRC0402Form.pdid }&statusCode=${IGCRC0402Form.statusCode }" target="_self">返回</a>
		</div>
    </div>
	<!--  message --> <ig:message /> <!--  /message -->
	<div class="title">
	<div class="name">流程列表</div>
	</div>
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="10%">工单号</th>
				<th width="25%">变更名称</th>
				<th width="10%">变更类型</th>
				<th width="10%">发起人</th>
				<th width="15%">工单状态</th>
				<th width="15%">发起时间</th>
				<th width="10%">删除</th>
			</tr>
			<logic:present name="IGCRC04021VO" property="prList">
				<logic:iterate id="bean" name="IGCRC04021VO" property="prList">
					<tr>
						<td>
							<input type="hidden" name="prid" value="${bean.prid }"/>
							<a href="javascript:void(0);" onclick="openRelatedProcess(${bean.prid},'WD');">
								${bean.prserialnum }
							</a>
						</td>
						<td>${bean.prtitle }</td>
						<td>${bean.prpdname }</td>
						<td>${bean.prusername }</td>
						<td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
						<td>${bean.propentime }</td>
						<td><a href="javascript:void(0);" onclick="del(this);">删除</a></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<logic:equal value="005" name="IGCRC0402Form" property="statusCode">
		<html:hidden property="buttonName" value="审批通过"/>
		<bean:define id="buttonName" value="审批通过"/>
		<html:hidden property="buttonCode" value="13"/>
	</logic:equal>
	<logic:notEqual value="005" name="IGCRC0402Form" property="statusCode">
	<div class="title">
	<div class="name">表单信息</div>
	</div>
	<div class="record_list">
		<table cellspacing="2" class="table_style1" style="width:98%;margin-left:auto;margin-right:auto;">
			<logic:equal value="010" name="IGCRC0402Form" property="statusCode">
				<html:hidden property="buttonName" value="审核通过"/>
				<bean:define id="buttonName" value="审核通过"/>
				<html:hidden property="buttonCode" value="11"/>
				<tr>
					<th width="15%">
						<label for="Name"><strong><span class="red">*</span>变更类别：</strong></label>
					</th>
					<td>
						<input type="hidden" name="pivarnames" value="变更类别"/>
						<select name="pivarvalues">
							<option></option>
							<option value="常规变更">常规变更</option>
							<option value="紧急变更">紧急变更</option>
						</select>
					</td>
					<th width="15%">
						<label for="Name"><strong><span class="red">*</span>UAT更新及测试情况：</strong></label>
					</th>
					<td>
						<input type="hidden" name="pivarnames" value="UAT更新及测试情况"/>
						<select name="pivarvalues">
							<option></option>
							<option value="不需要更新UAT">不需要更新UAT</option>
							<option value="更新UAT不需要UAT测试">更新UAT不需要UAT测试</option>
							<option value="更新UAT需要UAT测试">更新UAT需要UAT测试</option>
						</select>
					</td>
				</tr>
			</logic:equal>
			<logic:equal value="013" name="IGCRC0402Form" property="statusCode">
				<html:hidden property="buttonName" value="执行成功"/>
				<bean:define id="buttonName" value="执行成功"/>
				<html:hidden property="buttonCode" value="13"/>
				<tr>
					<th width="15%">
						<label for="Name"><strong>UAT变更执行开始时间：</strong></label>
					</th>
					<td width="35%">
						<input type="hidden" name="pivarnames" value="UAT变更执行开始时间"/>
						<input type = "text"   onclick="showTime(this)" name="pivarvalues" readonly="readonly" id = sTime/> 
					</td>
					<th width="15%">
						<label for="Name"><strong>UAT变更执行结束时间：</strong></label>
					</th>
					<td width="35%">
						<input type="hidden" name="pivarnames" value="UAT变更执行结束时间"/>
						<input type = "text" onclick="showTime(this)" name="pivarvalues" readonly="readonly" id = eTime/> 
					</td>
				</tr>
				<tr>
					<th width="15%">
						<label for="Name"><strong>UAT变更执行过程：</strong></label>
					</th>
					<td width="85%" colspan="3">
						<input type="hidden" name="pivarnames" value="UAT变更执行过程"/>
						<textarea name="pivarvalues" cols="60" rows="6"></textarea>
					</td>
				</tr>
			</logic:equal>
			<logic:equal value="011" name="IGCRC0402Form" property="statusCode">
				<html:hidden property="buttonName" value="申请复核"/>
				<bean:define id="buttonName" value="申请复核"/>
				<html:hidden property="buttonCode" value="10"/>
				<tr>
					<th width="15%">
						<label for="Name"><strong>生产变更开始时间：</strong></label>
					</th>
					<td width="35%">
						<input type="hidden" name="pivarnames" value="生产变更开始时间"/>
						<input type = "text"   onclick="showTime(this)" name="pivarvalues" readonly="readonly" id = sTime/> 
					</td>
					<th width="15%">
						<label for="Name"><strong>生产变更结束时间：</strong></label>
					</th>
					<td width="35%">
						<input type="hidden" name="pivarnames" value="生产变更结束时间"/>
						<input type = "text" onclick="showTime(this)" name="pivarvalues" readonly="readonly" id = eTime/> 
					</td>
				</tr>
				<tr>
					<th width="15%">
						<label for="Name"><strong>生产变更执行过程：</strong></label>
					</th>
					<td width="85%" colspan="3">
						<input type="hidden" name="pivarnames" value="生产变更执行过程"/>
						<textarea name="pivarvalues" cols="60" rows="6"></textarea>
					</td>
				</tr>
			</logic:equal>
			<logic:equal value="014" name="IGCRC0402Form" property="statusCode">
				<html:hidden property="buttonName" value="复核"/>
				<bean:define id="buttonName" value="复核"/>
				<html:hidden property="buttonCode" value="14"/>
				<tr>
					<th width="15%">
						<label for="Name"><strong><span class="red">*</span>变更结果：</strong></label>
					</th>
					<td>
						<input type="hidden" name="pivarnames" value="变更结果"/>
						<select name="pivarvalues">
							<option></option>
							<option value="成功">成功</option>
							<option value="失败">失败</option>
							<option value="存在问题">存在问题</option>
						</select>
					</td>
					<td></td><td></td>
				</tr>
			</logic:equal>
		</table>
	</div>
	</logic:notEqual>
	<div class="title">
	<div class="name">处理记录</div>
	</div>
	<div style="width:98%;margin:5px auto 10px;">
		<fieldset>
			<html:textarea property="rlcomment" cols="60" style="margin-left:60px;" errorStyleClass="inputError imeActive" rows="6"></html:textarea>
			<div>
				<img src="images/attachment.gif" />
				<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
				<table id="tb">
				</table>
			</div>
		</fieldset>
	</div>
	<input type="button" class="button" value="${buttonName }" onclick="dispose();"/>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html>