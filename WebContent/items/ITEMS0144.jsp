<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>

<html:html>
<bean:define id="id" value="ITEMS0144" toScope="request" />
<bean:define id="title" value="我的申领画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function operation(name,id){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0144.do";
			document.forms[0].submit();
		}else if(name=="insert"){
			 
			 if(window.confirm("您确定要接收这些物品吗？")){
				 var count=0;
				 count=checkAndCreate();
				 if(count==0){
					alert("请您先选择要接收的物品！");
		            return ;
				 }
	
				 document.forms[0].action=getAppRootUrl() + "/ITEMS0144_INSERT.do";
				 document.forms[0].submit();

			 } 
		}else if(name=="read"){
			document.forms[0].sid.value=id;
			document.forms[0].action=getAppRootUrl() + "/ITEMS0144_READ.do";
			document.forms[0].submit();
		}else if(name=="edit"){
			 
			 if(window.confirm("您确定要修改这些物品记录吗？")){
				 var count=0;
				 count=checkEditAndDel();
				 if(count==0){
					alert("请您先选择要修改的物品记录！");
		            return ;
				 }
	
				 document.forms[0].action=getAppRootUrl() + "/ITEMS0144_EDIT.do";
				 document.forms[0].submit();

			 } 
		}else if(name=="del"){
			 
			 if(window.confirm("您确定要删除这些物品记录吗？")){
				 var count=0;
				 count=checkEditAndDel();
				 if(count==0){
					alert("请您先选择要删除的物品记录！");
		            return ;
				 }
	
				 document.forms[0].action=getAppRootUrl() + "/ITEMS0144_DEL.do";
				 document.forms[0].submit();

			 } 
		}
	   
	}

function checkEditAndDel(){
	var count=0;
	
	var check = document.getElementsByName("stock_add");

	var outstockorgs = document.getElementsByName("outstockorg");
	var categorys = document.getElementsByName("category");
	var seqcodes = document.getElementsByName("seqcode");
	var typecodes = document.getElementsByName("typecode");
	var seqnos = document.getElementsByName("seqno");
	var outtypes = document.getElementsByName("outtype");
	var reqorgs = document.getElementsByName("reqorg");
	var reqids = document.getElementsByName("reqid");
	var reqnames = document.getElementsByName("reqname");
	var reqtimes = document.getElementsByName("reqtime");

	var new_reqnums = document.getElementsByName("num");
	var reqnums = document.getElementsByName("reqnum");
	var chknums = document.getElementsByName("chknum");
	var outnums = document.getElementsByName("outnum");
	var chkreasons = document.getElementsByName("chkreason");
	var pakreasons = document.getElementsByName("pakreason");
	var packnos = document.getElementsByName("packno");
	var chkids = document.getElementsByName("chkid");
	var chknames = document.getElementsByName("chkname");
	var chktimes = document.getElementsByName("chktime");
	var stockuserids = document.getElementsByName("stockuserid");

	var stocknames = document.getElementsByName("stockname");
	var outtimes = document.getElementsByName("outtime");
	var rcvids = document.getElementsByName("rcvid");
	var rcvnames = document.getElementsByName("rcvname");
	var rcvtimes = document.getElementsByName("rcvtime");
	var reqstatuss = document.getElementsByName("reqstatus");
	var accountstatuss = document.getElementsByName("accountstatus");
	var inprices = document.getElementsByName("inprice");
	var outpricess = document.getElementsByName("outprice");
	var outamounts = document.getElementsByName("outamount");

	var bigpacknums = document.getElementsByName("bigpacknum");
	var smallpacknums = document.getElementsByName("smallpacknum");
	var itemversions = document.getElementsByName("itemversion");
	var stockids = document.getElementsByName("stockid");
	var itemsnames = document.getElementsByName("itemsname");
	var stocknums = document.getElementsByName("stocknum");

	var types = document.getElementsByName("type");
	
	for(var i=0;i<check.length;i++){
		if(check[i].checked==true){
				if(new_reqnums[i].value==null || new_reqnums[i].value.trim()==""){
					alert("请填写物品编号为"+seqcodes[i].value+"的物品的申领数量！");
					return 9;
				}else if(Number(new_reqnums[i].value)<=0){
					alert("物品编号为"+seqcodes[i].value+"的物品的申领数量应该大于0！");
					return 9;
				}else if(stocknums[i]!=null && (Number(stocknums[i].value)>0)){
					if(Number(new_reqnums[i].value)>Number(stocknums[i].value)){
						alert("物品编号为"+seqcodes[i].value+"的物品的申领数量不能超过库存数量！");
						return 9;
					}
				}
		}
	}
	
	for(var i=0;i<check.length;i++){
		if(check[i].checked==true){
			count=1;
			createHiddenInput("outstockids",check[i].value);
			
			createHiddenInput("outstockorgs",outstockorgs[i].value);
			createHiddenInput("categorys",categorys[i].value);
			createHiddenInput("seqcodes",seqcodes[i].value);
			createHiddenInput("typecodes",typecodes[i].value);
			createHiddenInput("seqnos",seqnos[i].value);
			createHiddenInput("outtypes",outtypes[i].value);
			createHiddenInput("reqorgs",reqorgs[i].value);
			createHiddenInput("reqids",reqids[i].value);
			createHiddenInput("reqnames",reqnames[i].value);
			createHiddenInput("reqtimes",reqtimes[i].value);

			createHiddenInput("new_reqnums",new_reqnums[i].value);
			createHiddenInput("reqnums",reqnums[i].value);
			createHiddenInput("chknums",chknums[i].value);
			createHiddenInput("outnums",outnums[i].value);
			createHiddenInput("chkreasons",chkreasons[i].value);
			createHiddenInput("pakreasons",pakreasons[i].value);
			createHiddenInput("packnos",packnos[i].value);
			createHiddenInput("chkids",chkids[i].value);
			createHiddenInput("chknames",chknames[i].value);
			createHiddenInput("chktimes",chktimes[i].value);
			createHiddenInput("stockuserids",stockuserids[i].value);

			createHiddenInput("stocknames",stocknames[i].value);
			createHiddenInput("outtimes",outtimes[i].value);
			createHiddenInput("rcvids",rcvids[i].value);
			createHiddenInput("rcvnames",rcvnames[i].value);
			createHiddenInput("rcvtimes",rcvtimes[i].value);
			createHiddenInput("reqstatuss",reqstatuss[i].value);
			createHiddenInput("accountstatuss",accountstatuss[i].value);
			createHiddenInput("inprices",inprices[i].value);
			createHiddenInput("outpricess",outpricess[i].value);
			createHiddenInput("outamounts",outamounts[i].value);

			createHiddenInput("bigpacknums",bigpacknums[i].value);
			createHiddenInput("smallpacknums",smallpacknums[i].value);
			createHiddenInput("itemversions",itemversions[i].value);
			createHiddenInput("stockids",stockids[i].value);
			createHiddenInput("itemsnames",itemsnames[i].value);
			createHiddenInput("stocknums",stocknums[i].value);

			createHiddenInput("types",types[i].value);
		}
	}

    return count;
}	



	function checkAndCreate(){
		var count=0;
		
		var check = document.getElementsByName("stock_add");

		var outstockorgs = document.getElementsByName("outstockorg");
		var categorys = document.getElementsByName("category");
		var seqcodes = document.getElementsByName("seqcode");
		var typecodes = document.getElementsByName("typecode");
		var seqnos = document.getElementsByName("seqno");
		var outtypes = document.getElementsByName("outtype");
		var reqorgs = document.getElementsByName("reqorg");
		var reqids = document.getElementsByName("reqid");
		var reqnames = document.getElementsByName("reqname");
		var reqtimes = document.getElementsByName("reqtime");

		var reqnums = document.getElementsByName("reqnum");
		var chknums = document.getElementsByName("chknum");
		var outnums = document.getElementsByName("outnum");
		var chkreasons = document.getElementsByName("chkreason");
		var pakreasons = document.getElementsByName("pakreason");
		var packnos = document.getElementsByName("packno");
		var chkids = document.getElementsByName("chkid");
		var chknames = document.getElementsByName("chkname");
		var chktimes = document.getElementsByName("chktime");
		var stockuserids = document.getElementsByName("stockuserid");

		var stocknames = document.getElementsByName("stockname");
		var outtimes = document.getElementsByName("outtime");
		var rcvids = document.getElementsByName("rcvid");
		var rcvnames = document.getElementsByName("rcvname");
		var rcvtimes = document.getElementsByName("rcvtime");
		var reqstatuss = document.getElementsByName("reqstatus");
		var accountstatuss = document.getElementsByName("accountstatus");
		var inprices = document.getElementsByName("inprice");
		var outprices = document.getElementsByName("outprice");
		var outamounts = document.getElementsByName("outamount");

		var bigpacknums = document.getElementsByName("bigpacknum");
		var smallpacknums = document.getElementsByName("smallpacknum");
		var itemversions = document.getElementsByName("itemversion");
		var stockids = document.getElementsByName("stockid");
		var itemsnames = document.getElementsByName("itemsname");
		var stocknums = document.getElementsByName("stocknum");

		var types = document.getElementsByName("type");


		
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				createHiddenInput("outstockids",check[i].value);
				
				createHiddenInput("outstockorgs",outstockorgs[i].value);
				createHiddenInput("categorys",categorys[i].value);
				createHiddenInput("seqcodes",seqcodes[i].value);
				createHiddenInput("typecodes",typecodes[i].value);
				createHiddenInput("seqnos",seqnos[i].value);
				createHiddenInput("outtypes",outtypes[i].value);
				createHiddenInput("reqorgs",reqorgs[i].value);
				createHiddenInput("reqids",reqids[i].value);
				createHiddenInput("reqnames",reqnames[i].value);
				createHiddenInput("reqtimes",reqtimes[i].value);

				createHiddenInput("reqnums",reqnums[i].value);
				createHiddenInput("chknums",chknums[i].value);
				createHiddenInput("outnums",outnums[i].value);
				createHiddenInput("chkreasons",chkreasons[i].value);
				createHiddenInput("pakreasons",pakreasons[i].value);
				createHiddenInput("packnos",packnos[i].value);
				createHiddenInput("chkids",chkids[i].value);
				createHiddenInput("chknames",chknames[i].value);
				createHiddenInput("chktimes",chktimes[i].value);
				createHiddenInput("stockuserids",stockuserids[i].value);

				createHiddenInput("stocknames",stocknames[i].value);
				createHiddenInput("outtimes",outtimes[i].value);
				createHiddenInput("rcvids",rcvids[i].value);
				createHiddenInput("rcvnames",rcvnames[i].value);
				createHiddenInput("rcvtimes",rcvtimes[i].value);
				createHiddenInput("reqstatuss",reqstatuss[i].value);
				createHiddenInput("accountstatuss",accountstatuss[i].value);
				createHiddenInput("inprices",inprices[i].value);
				createHiddenInput("outprices",outprices[i].value);
				createHiddenInput("outamounts",outamounts[i].value);

				createHiddenInput("bigpacknums",bigpacknums[i].value);
				createHiddenInput("smallpacknums",smallpacknums[i].value);
				createHiddenInput("itemversions",itemversions[i].value);
				createHiddenInput("stockids",stockids[i].value);
				createHiddenInput("itemsnames",itemsnames[i].value);
				createHiddenInput("stocknums",stocknums[i].value);

				createHiddenInput("types",types[i].value);
			}
		}
	
	    return count;
	}	
	function checkNum(obj){
		if(isNaN(obj.value)){
			alert("请输入数字！");
			obj.value = "0";
			return;
		}
	}
	
	function showQueryTime(){
		var reqstatus_q = document.forms[0].reqstatus_q.value;
		if("1"==reqstatus_q || "5"==reqstatus_q){
			//申领待审批、审批未通过
			document.getElementById("n1").style.display="";
			document.getElementById("n2").style.display="none";
			document.getElementById("n3").style.display="none";
			document.getElementById("n4").style.display="none";
			document.forms[0].chktime_f.value="";
			document.forms[0].chktime_t.value="";
			document.forms[0].outtime_f.value="";
			document.forms[0].outtime_t.value="";
			document.forms[0].rcvtime_f.value="";
			document.forms[0].rcvtime_t.value="";
		}else if("2"==reqstatus_q){
			//待出库
			document.getElementById("n1").style.display="none";
			document.getElementById("n2").style.display="";
			document.getElementById("n3").style.display="none";
			document.getElementById("n4").style.display="none";
			document.forms[0].reqtime_f.value="";
			document.forms[0].reqtime_t.value="";
			document.forms[0].outtime_f.value="";
			document.forms[0].outtime_t.value="";
			document.forms[0].rcvtime_f.value="";
			document.forms[0].rcvtime_t.value="";
		}else if("3"==reqstatus_q){
			//待接收
			document.getElementById("n1").style.display="none";
			document.getElementById("n2").style.display="none";
			document.getElementById("n3").style.display="";
			document.getElementById("n4").style.display="none";
			document.forms[0].reqtime_f.value="";
			document.forms[0].reqtime_t.value="";
			document.forms[0].chktime_f.value="";
			document.forms[0].chktime_t.value="";
			document.forms[0].rcvtime_f.value="";
			document.forms[0].rcvtime_t.value="";
		}else if("0"==reqstatus_q){
			//出库完成
			document.getElementById("n1").style.display="none";
			document.getElementById("n2").style.display="none";
			document.getElementById("n3").style.display="none";
			document.getElementById("n4").style.display="";
			document.forms[0].reqtime_f.value="";
			document.forms[0].reqtime_t.value="";
			document.forms[0].chktime_f.value="";
			document.forms[0].chktime_t.value="";
			document.forms[0].outtime_f.value="";
			document.forms[0].outtime_t.value="";
		}
	}
//-->
	</script>
<body onload="showQueryTime();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0144_Disp">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<input type="hidden" name="sid" >
<span>物品种类：</span> <span> <html:select property="category_q" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="category_options" property="value" name="" labelProperty="label" />
</html:select> </span>&nbsp;&nbsp; 
<span>状态：</span> <span> <html:select property="reqstatus_q" style="width: 100px;" errorStyleClass="inputError imeActive" onchange="showQueryTime();">
<html:options collection="reqstatus_options" property="value" name="" labelProperty="label" />
</html:select></span>&nbsp;&nbsp;
<span id="n1" style="display:none">
	<span>申领时间：从</span>
    <span><html:text property="reqtime_f" styleId="reqtime_f"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('reqtime_f'))" border="0" style="cursor: hand" />
	</span> 
	<span>&nbsp;&nbsp;到</span>
	<span><html:text property="reqtime_t" styleId="reqtime_t" 
	    errorStyleClass="inputError imeDisabled" size="16" readonly="true" /> 
	<img src="images/date.gif" align="middle"
		onclick="calendar($('reqtime_t'))" border="0" style="cursor: hand" />
	</span>
</span>

<span id="n2" style="display:none">
	 <span>审批时间：从</span>
    <span><html:text property="chktime_f" styleId="chktime_f"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('chktime_f'))" border="0" style="cursor: hand" />
	</span> 
	<span>&nbsp;&nbsp;到</span>
	<span><html:text property="chktime_t" styleId="chktime_t" 
	    errorStyleClass="inputError imeDisabled" size="16" readonly="true" /> 
	<img src="images/date.gif" align="middle"
		onclick="calendar($('chktime_t'))" border="0" style="cursor: hand" />
	</span>

</span>

<span id="n3" style="display:none">
	  <span>出库时间：从</span>
    <span><html:text property="outtime_f" styleId="outtime_f"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('outtime_f'))" border="0" style="cursor: hand" />
	</span> 
	<span>&nbsp;&nbsp;到</span>
	<span><html:text property="outtime_t" styleId="outtime_t" 
	    errorStyleClass="inputError imeDisabled" size="16" readonly="true" /> 
	<img src="images/date.gif" align="middle"
		onclick="calendar($('outtime_t'))" border="0" style="cursor: hand" />
	</span>

</span>

<span id="n4" style="display:none">
	 <span>接收时间：从</span>
    <span><html:text property="rcvtime_f" styleId="rcvtime_f"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('rcvtime_f'))" border="0" style="cursor: hand" />
	</span> 
	<span>&nbsp;&nbsp;到</span>
	<span><html:text property="rcvtime_t" styleId="rcvtime_t" 
	    errorStyleClass="inputError imeDisabled" size="16" readonly="true" /> 
	<img src="images/date.gif" align="middle"
		onclick="calendar($('rcvtime_t'))" border="0" style="cursor: hand" />
	</span>

</span>


<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>	
</div>	
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<logic:equal name="ITEMS0144Form" property="flag" value="1">
		<table class="table_style">
			<tr>
				<th width="5%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','stock_add')"/> 
					
				</label>
				</th>
				<th width="8%">物品种类</th>
				<th width="7%">物品编号</th>
				<th width="7%">物品名称</th>
				<th width="7%">物品型号</th>
				<th width="10%">申领机构</th>
				<th width="7%">申领数量</th>
				<th width="8%">出库单价</th>
				<th width="8%">出库金额</th>
				<th width="7%">审批数量</th>
				<th width="7%">出库数量</th>
				
				<th width="8%">状态</th>
				<th width="5%">查看</th>
				<th width="1%"></th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<label>
						<input name="stock_add" type="checkbox" value="${bean.outstockid}"/>
						</label>
						</td>
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						
						<td>${bean.seqcode}</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.typecode}</td>
						
						<td>
						
							<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
							
						</td>
						
						<td>${bean.reqnum}</td>
						
						<td>${bean.outprice}</td>
						<td>${bean.outamount}</td>
						
						
						<td>${bean.chknum}</td>
						
						<td>${bean.outnum}</td>
						
					
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS%>" codeValue="${bean.reqstatus}" />
						</td>
						
						<td>
							<a href="javascript:operation('read','${bean.outstockid}');" >
							<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0"/></a>					
						</td>
						<td>
							<input type="hidden" name="outstockorg" value="${bean.outstockorg}">
						<input type="hidden" name="category" value="${bean.category}">
						<input type="hidden" name="seqcode" value="${bean.seqcode}">
						<input type="hidden" name="typecode" value="${bean.typecode}">
						<input type="hidden" name="seqno" value="${bean.seqno}">
						<input type="hidden" name="outtype" value="${bean.outtype}">
						<input type="hidden" name="reqorg" value="${bean.reqorg}">
						<input type="hidden" name="reqid" value="${bean.reqid}">
						<input type="hidden" name="reqname" value="${bean.reqname}">
						<input type="hidden" name="reqtime" value="${bean.reqtime}">
						
						<input type="hidden" name="reqnum" value="${bean.reqnum}">
						<input type="hidden" name="chknum" value="${bean.chknum}">
						<input type="hidden" name="chkreason" value="${bean.chkreason}">
						<input type="hidden" name="pakreason" value="${bean.pakreason}">
						<input type="hidden" name="packno" value="${bean.packno}">

						<input type="hidden" name="chkid" value="${bean.chkid}">
						<input type="hidden" name="chkname" value="${bean.chkname}">
						<input type="hidden" name="chktime" value="${bean.chktime}">
						<input type="hidden" name="stockuserid" value="${bean.stockuserid}">
						
						<input type="hidden" name="stockname" value="${bean.stockname}">
						<input type="hidden" name="outnum" value="${bean.outnum}">
						<input type="hidden" name="outtime" value="${bean.outtime}">
						<input type="hidden" name="rcvid" value="${bean.rcvid}">
						<input type="hidden" name="rcvname" value="${bean.rcvname}">
						<input type="hidden" name="rcvtime" value="${bean.rcvtime}">
						<input type="hidden" name="reqstatus" value="${bean.reqstatus}">
						<input type="hidden" name="accountstatus" value="${bean.accountstatus}">
						<input type="hidden" name="inprice" value="${bean.inprice}">
						<input type="hidden" name="outprice" value="${bean.outprice}">
						<input type="hidden" name="outamount" value="${bean.outamount}">
						
						
						<input type="hidden" name="bigpacknum" value="${bean.bigpacknum}">
						<input type="hidden" name="smallpacknum" value="${bean.smallpacknum}">
						<input type="hidden" name="itemversion" value="${bean.itemversion}">
						<input type="hidden" name="stockid" value="${bean.stockid}">
						<input type="hidden" name="itemsname" value="${bean.itemsname}">
						<input type="hidden" name="stocknum" value="${bean.stocknum}">
					
						<input type="hidden" name="type" value="${bean.type}">
						
						</td>
						
					</tr>
				</logic:iterate>
			</logic:present>
	</table>

	</logic:equal>
	
	<logic:equal name="ITEMS0144Form" property="flag" value="2">
	<table class="table_style">
			<tr>
				<th width="5%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','stock_add')"/> 
					
				</label>
				</th>
				<th width="10%">物品种类</th>
				<th width="8%">物品编号</th>
				<th width="7%">物品名称</th>
				<th width="8%">物品型号</th>
				<th width="10%">申领机构</th>
				<th width="7%">库存数量</th>
				<th width="7%">申领数量</th>
				<th width="7%">审批数量</th>
				<th width="8%">状态</th>
				<th width="5%">查看</th>
				<th width="1%"></th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<label>
						<input name="stock_add" type="checkbox" value="${bean.outstockid}"/>
						</label>
						</td>
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						
						<td>${bean.seqcode}</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.typecode}</td>
						
						<td>
						
							<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
							
						</td>
						
						<td>${bean.stocknum}</td>
						
						<td>
							<input name="num" type="text"  value="${bean.reqnum}" size="10" class="input1" onchange="checkNum(this);"/>
						</td>
						
						<td>${bean.chknum}</td>
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS%>" codeValue="${bean.reqstatus}" />
						</td>
						
						<td>
							<a href="javascript:operation('read','${bean.outstockid}');" >
							<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0"/></a>					
						</td>
						<td>
							<input type="hidden" name="outstockorg" value="${bean.outstockorg}">
						<input type="hidden" name="category" value="${bean.category}">
						<input type="hidden" name="seqcode" value="${bean.seqcode}">
						<input type="hidden" name="typecode" value="${bean.typecode}">
						<input type="hidden" name="seqno" value="${bean.seqno}">
						<input type="hidden" name="outtype" value="${bean.outtype}">
						<input type="hidden" name="reqorg" value="${bean.reqorg}">
						<input type="hidden" name="reqid" value="${bean.reqid}">
						<input type="hidden" name="reqname" value="${bean.reqname}">
						<input type="hidden" name="reqtime" value="${bean.reqtime}">
						
						<input type="hidden" name="reqnum" value="${bean.reqnum}">
						<input type="hidden" name="chknum" value="${bean.chknum}">
						<input type="hidden" name="chkreason" value="${bean.chkreason}">
						<input type="hidden" name="outnum" value="${bean.outnum}">
						<input type="hidden" name="pakreason" value="${bean.pakreason}">
						<input type="hidden" name="packno" value="${bean.packno}">
						<input type="hidden" name="chkid" value="${bean.chkid}">
						<input type="hidden" name="chkname" value="${bean.chkname}">
						<input type="hidden" name="chktime" value="${bean.chktime}">
						<input type="hidden" name="stockuserid" value="${bean.stockuserid}">
						
						<input type="hidden" name="stockname" value="${bean.stockname}">
						<input type="hidden" name="outtime" value="${bean.outtime}">
						<input type="hidden" name="rcvid" value="${bean.rcvid}">
						<input type="hidden" name="rcvname" value="${bean.rcvname}">
						<input type="hidden" name="rcvtime" value="${bean.rcvtime}">
						<input type="hidden" name="reqstatus" value="${bean.reqstatus}">
						<input type="hidden" name="accountstatus" value="${bean.accountstatus}">
						<input type="hidden" name="inprice" value="${bean.inprice}">
						<input type="hidden" name="outprice" value="${bean.outprice}">
						<input type="hidden" name="outamount" value="${bean.outamount}">
						
						
						<input type="hidden" name="bigpacknum" value="${bean.bigpacknum}">
						<input type="hidden" name="smallpacknum" value="${bean.smallpacknum}">
						<input type="hidden" name="itemversion" value="${bean.itemversion}">
						<input type="hidden" name="stockid" value="${bean.stockid}">
						<input type="hidden" name="itemsname" value="${bean.itemsname}">
						<input type="hidden" name="stocknum" value="${bean.stocknum}">
						
						<input type="hidden" name="type" value="${bean.type}">
						</td>
	
						
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	
	
	</logic:equal>
	
	
	
	<logic:equal name="ITEMS0144Form" property="flag" value="0">
		<table class="table_style">
			<tr>
				
				<th width="10%">物品种类</th>
				<th width="10%">物品编号</th>
				<th width="12%">物品名称</th>
				<th width="8%">物品型号</th>
				<th width="12%">申领机构</th>
				<th width="8%">申领数量</th>
				<th width="8%">审批数量</th>
				<th width="8%">出库数量</th>
				<th width="8%">状态</th>
				<logic:equal name="ITEMS0144Form" property="reqstatus_q" value="<%=DefineUtils.ITEMSCODES_REQSTATUS_CKWC %>">
				<th width="8%">结账状态</th>
				</logic:equal>
				<th width="8%">查看</th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						
						<td>${bean.seqcode}</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.typecode}</td>
						
						<td>
							<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
							
						</td>
						
						<td>${bean.reqnum}</td>
						
						<td>${bean.chknum}</td>
						
						<td>${bean.outnum}</td>
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS%>" codeValue="${bean.reqstatus}" />
						</td>
						
						
						<logic:equal name="ITEMS0144Form" property="reqstatus_q" value="<%=DefineUtils.ITEMSCODES_REQSTATUS_CKWC %>">
						<td>
							<logic:equal name="bean" property="accountstatus" value="<%=DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ %>">
								未结账
							</logic:equal>
							<logic:equal name="bean" property="accountstatus" value="<%=DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ %>">
								已结账
							</logic:equal>
						</td>
						</logic:equal>
						
						<td>
							<a href="javascript:operation('read','${bean.outstockid}');" >
							<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0"/></a>					
						</td>

					</tr>
				</logic:iterate>
			</logic:present>
	</table>
		
	
	</logic:equal>
	
	
	
	</div>
	<div id="operate">
	<div class="operate_btn">
	<logic:present name="ITEMS01081VO" property="outStockList">
		<logic:equal name="ITEMS0144Form" property="flag" value="1">
		<span> 	
		<html:button property="btn_add" value="接收"
			styleClass="button" onclick="operation('insert')" />
		</span>
		</logic:equal>
		<logic:equal name="ITEMS0144Form" property="flag" value="2">
		<span> 	
		<html:button property="btn_add" value="修改"
			styleClass="button" onclick="operation('edit')" />
		<html:button property="btn_add" value="删除"
			styleClass="button" onclick="operation('del')" />
		</span>
		</logic:equal>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" /></div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>