<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0110" toScope="request" />
<bean:define id="title" value="入库价格修改页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkboxSubmit(){
	message = "请选择要调整的批次！";
    if(window.confirm("是否确认调整？")){
    	count = checkNumber();
    	if(count==0){
    		alert(message);
            return;
    	}
    	if(count==2){
            return;
    	}
    	document.forms[0].submit();
    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var checkbox = document.getElementsByName("checkbox");
	var inprice = document.getElementsByName("inprice");
	var outprice = document.getElementsByName("outprice");
	for(var i=0;i<checkbox.length;i++){
		if(checkbox[i].checked==true){
			count=1;
			createHiddenInput("instockid",checkbox[i].value);
			createHiddenInput("editInprise",inprice[i].value);
			createHiddenInput("editOutprise",outprice[i].value);
		}
	}
	return count;
}	

function createHiddenInput(name,value){
    var inputElement=document.createElement("input");   
    inputElement.name=name;   
    inputElement.value=value;     
    inputElement.type="hidden";
    inputElement.id=name;
    document.forms[0].appendChild(inputElement);   
}

function checkNum(obj){
	if(isNaN(obj.value)){
		alert("请输入数字！");
		obj.value = "0";
		return;
	}
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>  &gt;&gt; 入库批次</p>
<div class="back"><a href="ITEMS0109_BACK.do" target="_self">返回</a></div>
</div>
<html:form action="/ITEMS0110">
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="8%"></th>
		<th width="12%">物品编号</th>
		<th width="12%">物品类型</th>
		<th width="12%">入库时间</th>
		<th width="12%">入库数量</th>
		<th width="8%">出库数量</th>
		<th width="8%">损耗数量</th>
		<th width="8%">销毁数量</th>
		<th width="10%">入库单价</th>
		<th width="10%">出库单价</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="inStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="inStockList" indexId="index">
		    <bean:define id="map" name="ITEMS01011VO" property="editMap" type="java.util.Map"/>
			<bean:define id="inid" value="${bean.instockid}"/>
			<tr class="bgRow<%=index%2 %>">
				<td>
					<c:if test="${map[inid] == '1' }">
					<input name="checkbox" type="checkbox" value="${bean.instockid}" />
					</c:if>
				</td>
				<td>${bean.seqcode}</td>
				<td><ig:cseCodeValue codeIndex="2" codeValue="${bean.type}" /></td>
				<td>${bean.intime}</td>
				<td>${bean.innum}</td>
				<td>${bean.outnum}</td>
				<td>${bean.lossnum}</td>
				<td>${bean.havocnum}</td>
				<td>
					<c:if test="${map[inid] == '1' }">
						<input name="inprice" type="text" value="${bean.inprice}" size="8" maxlength="8" class="input1" onchange="checkNum(this);" />
					</c:if>
					<c:if test="${map[inid] != '1' }">
						${bean.inprice}
					</c:if>
				</td>
				<td>
					<c:if test="${map[inid] == '1' }">
						<input name="outprice" type="text" value="${bean.outprice}" size="8" maxlength="8" class="input1" onchange="checkNum(this);" />
					</c:if>
					<c:if test="${map[inid] != '1' }">
						${bean.outprice}
					</c:if>
				</td>
			</tr>
		</logic:iterate>
	</logic:present>
	
</table>
</div>
</html:form>

<div id="operate">
<div class="operate_btn">
	<span>
	<html:button property="checkBoxSubmit" value="修改" styleClass="button" onclick="checkboxSubmit();" />
	</span>
</div>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>