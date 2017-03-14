<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGPRJ010112" toScope="request" />
<bean:define id="title" value="明细" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<body>

 <div class="title">
	<div class="name"><ig:codeValue ccid="Project_LOGTYPE" cid="${IGPRJ0101DetailForm.pltype}" />明细</div>
</div>

<div align="center">	
	<fieldset style="width: 680px;">
	<table width="100%">
	<tr>	
		<td colspan="4" align="left" ><strong>日志类别:<ig:codeValue ccid="Project_LOGTYPE" cid="${IGPRJ0101DetailForm.pltype}" /></strong></td>
	</tr>
	<c:if test="${IGPRJ0101DetailForm.pltype=='C' }">
	<logic:iterate id="bean" name="IGPRJ0101VO" property="plcList">
	<tr><td colspan="4">
	<div class="title">
	<div class="name">预算信息</div>
	</div>
	<table class="table_style">
		<tr>
			<th style="background-color:#e4f8ed; " width="20%">分类</th>
			<th colspan="6" style="background-color:#e1edf9; ">资本金(万元)</th>
			<th colspan="2" style="background-color:#faecdf; ">成本金(万元)</th>
		</tr>
		<tr>
			<th style="background-color:#e4f8ed; ">类别</th>
			<th style="background-color:#e1edf9; "></th>
			<th style="background-color:#e1edf9; ">开发</th>
			<th style="background-color:#e1edf9; ">硬件</th>
			<th style="background-color:#e1edf9; ">软件</th>
			<th style="background-color:#e1edf9; ">工程</th>
			<th style="background-color:#e1edf9; ">其他</th>
			<th style="background-color:#faecdf; ">实施</th>
			<th style="background-color:#faecdf; ">其他</th>
		</tr>
		<c:if test="${IGPRJ0101VO.pbsummaryList.size()==0 }">
		<tr>
			<td></td>
			<td>已用预算</td>
			<td>${bean.bzdevelop }</td>
			<td>${bean.bzhardware }</td>
			<td>${bean.bzsoftware }</td>
			<td>${bean.bzproject }</td>
			<td>${bean.bzelse }</td>
			<td>${bean.bcimplement }</td>
			<td>${bean.bcelse }</td>
		</tr>
		</c:if>
		<logic:iterate id="be" name="IGPRJ0101VO" property="pbsummaryList">
		<tr>
			<td>${be.btitle}</td>			
			<td>已用预算</td>
			<td><html:text property="use1" size="5" value="${be.use1}" readonly="true" /></td>
			<td><html:text property="use2" size="5" value="${be.use2}" readonly="true" /></td>
			<td><html:text property="use3" size="5" value="${be.use3}" readonly="true" /></td>
			<td><html:text property="use4" size="5" value="${be.use4}" readonly="true" /></td>
			<td><html:text property="use5" size="5" value="${be.use5}" readonly="true" /></td>
			<td><html:text property="use6" size="5" value="${be.use6}" readonly="true" /></td>
			<td><html:text property="use7" size="5" value="${be.use7}" readonly="true" /></td>
		</tr>
		</logic:iterate>
		<tr>
			<td></td>
			<td>总计</td>
			<td><bean:write name="bean" property="bzdevelop" format="######.##" /></td>
			<td><bean:write name="bean" property="bzhardware" format="######.##" /></td>
			<td><bean:write name="bean" property="bzsoftware" format="######.##" /></td>
			<td><bean:write name="bean" property="bzproject" format="######.##" /></td>
			<td><bean:write name="bean" property="bzelse" format="######.##" /></td>
			<td><bean:write name="bean" property="bcimplement" format="######.##" /></td>
			<td><bean:write name="bean" property="bcelse" format="######.##" /></td>
		</tr>
	</table>
	</td></tr>
	<tr><td colspan="4">
		<div class="title">
		<div class="name">合同信息</div>
		</div>
	</td></tr>
	<tr>
	<td><span>合同编号:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcnumber" size="20" value="${bean.plcnumber }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcnumber" style="width:160px"/></span></td>
	</tr>
	<tr>
	<tr>
	<td width="15%"><span>合同金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcsum" size="20" value="${bean.plcsum }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcsum" style="width:160px"/>(万元)</span></td>
	<td width="15%"><span>付款条件:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcsumterm" size="20" value="${bean.plcsumterm }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcsumterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>一期金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcfirst" size="20" value="${bean.plcfirst }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfirst" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcfirstterm" size="20" value="${bean.plcfirstterm }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfirstterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>二期金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcsecond" size="20" value="${bean.plcsecond }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcsecond" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcsecondterm" size="20" value="${bean.plcsecondterm }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcsecondterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>三期金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcthird" size="20" value="${bean.plcthird }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcthird" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcthirdterm" size="20" value="${bean.plcthirdterm }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcthirdterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>四期金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcfourth" size="20" value="${bean.plcfourth }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfourth" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcfourthterm" size="20" value="${bean.plcfourthterm }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfourthterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>五期金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcfifth" size="20" value="${bean.plcfifth }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfifth" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plcfifthterm" size="20" value="${bean.plcfifthterm }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfifthterm" style="width:178px"/></span></td>
	</tr>
	</logic:iterate>
	</c:if>
	<c:if test="${IGPRJ0101DetailForm.pltype=='J' }">
	<logic:iterate id="bean" name="IGPRJ0101VO" property="plbList">
	<tr>
	<td><span>一期付款金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbfirst" size="20" value="${bean.plbfirst }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbfirst" style="width:160px"/>(万元)</span></td>
	<td><span>合同总额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbplcsum" size="20" value="${bean.plbplcsum }"
	 	readonly="true" errorStyleClass="inputError imeActive" styleId="plbplcsum" style="width:178px"/>(万元)</span></td>
	</tr>
	<tr>
	<td><span>二期付款金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbsecond" size="20" value="${bean.plbsecond }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbsecond" style="width:160px"/>(万元)</span></td>
	<td><span>已付款总额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbsum" size="20" value="${bean.plbsum }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbsum" style="width:178px"/>(万元)</span></td>
	</tr>
	<tr>
	<td><span>三期付款金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbthird" size="20" value="${bean.plbthird }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbthird" style="width:160px"/>(万元)</span></td>
	<td><span>已付款比例:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbscale" size="20" value="${bean.plbscale }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbscale" style="width:178px"/>%</span></td>
	</tr>
	<tr>
	<td><span>四期付款金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbfourth" size="20" value="${bean.plbfourth }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbfourth" style="width:160px"/>(万元)</span></td>
	<td><span>未付款总额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbnotsum" size="20" value="${bean.plbnotsum }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbnotsum" style="width:178px"/>(万元)</span></td>
	</tr>
	<tr>
	<td><span>五期付款金额:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbfifth" size="20" value="${bean.plbfifth }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfifth" style="width:160px"/>(万元)</span></td>
	<td><span>未付款比例:</span></td><td align="left"><span><html:text name="IGPRJ0101DetailForm" property="plbnotscale" size="20" value="${bean.plbnotscale }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbnotscale" style="width:178px"/>%</span></td>
	</tr>
	</logic:iterate>
	</c:if>		
	</table>
	</fieldset>
	<div align="center">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</div>
</body>
</html:html>