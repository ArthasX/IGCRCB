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
<bean:define id="id" value="ITEMS0143" toScope="request" />
<bean:define id="title" value="耗材出库画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function operation(name){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0143.do";
			document.forms[0].submit();

		}else if(name=="insert"){
			 
			 if(window.confirm("您确定要下发这些物品吗？")){
				 var count=0;
				 count=checkAndCreate();
				 if(count==0){
					alert("请您先选择要下发的物品！");
		            return ;
				 }
				 if(count==9){
					 return;
				 }		 
				 document.forms[0].action=getAppRootUrl() + "/ITEMS0143_INSERT.do";
				 document.forms[0].submit();

			 } 
		}
	   
	}

	function checkAndCreate(){
		var count=0;
		
		var check = document.getElementsByName("stock_add");

		var outstockorgs = document.getElementsByName("outstockorg");
		var categorys = document.getElementsByName("category");
		var category_names = document.getElementsByName("category_name");
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
		var outnums = document.getElementsByName("num");
		var chkreasons = document.getElementsByName("chkreason");
		var pakreasons = document.getElementsByName("desc");

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

		var pNos = new Array(check.length);//已经存在的（机构;包裹号）

		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){

				if(outnums[i].value==null || outnums[i].value.trim()==""){
					alert("请填写物品种类为"+category_names[i].value+"物品编号为"+seqcodes[i].value+"的物品的出库数量！");
					return 9;
				}else if(Number(outnums[i].value)<=0){
					alert("物品种类为"+category_names[i].value+"物品编号为"+seqcodes[i].value+"的物品的出库数量应该大于0！");
					return 9;
				}else if(Number(outnums[i].value)>Number(chknums[i].value)){
					alert("物品种类为"+category_names[i].value+"物品编号为"+seqcodes[i].value+"的物品的出库数量不能超过审批数量！");
					return 9;
				}
				
				

				if(pakreasons[i].value!=null || pakreasons[i].value.trim()!=""){
					if(pakreasons[i].value.strlen()>32){
						alert("物品种类为"+category_names[i].value+"物品编号为"+seqcodes[i].value+"的物品的说明不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
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
				createHiddenInput("category_names",category_names[i].value);
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

	function checkNum(obj){
		if(!checkIsNumberForCSE(obj.value)){
			alert("请输入最大长度为9位的正整数！");
			obj.value = "0";
			obj.focus();
			event.returnValue = false;
		}
	}

	function checkIsNumberForCSE(str){
	 	myReg = /^[1-9][0-9]{0,8}$/;
		
	 	return myReg.test(str);
	}
	
	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

		if("_resetall"==temp){
			document.forms[0].reqorg_q.value = "";
			document.forms[0].reqorg_name.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].reqorg_q.value = temp.split("|")[0];
			document.forms[0].reqorg_name.value = temp.split("|")[1];
		}
		
	}
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0143_Disp">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
<span>申领机构：</span><span><html:text property="reqorg_name" readonly="true"></html:text>
<img src="images/tree.gif" style="cursor: hand;" alt="选择申领机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/>
<html:hidden property="reqorg_q"/></span>&nbsp;&nbsp; 
<span>物品种类：</span><span><html:select property="category_q" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="category_options" property="value" name="" labelProperty="label" /></html:select></span>&nbsp;&nbsp;
<span>下发方式：</span><span><html:select property="outtype_q" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:option value="<%=DefineUtils.ITEMSCODES_OUTTYPE_ZHSL %>">支行申领</html:option>
<html:option value="<%=DefineUtils.ITEMSCODES_OUTTYPE_ZHXB %>">总行下拨</html:option></html:select></span>&nbsp;&nbsp;
<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>	
</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','stock_add')"/> 
					
				</label>
				</th>
				<th width="10%">物品种类</th>
				<th width="10%">物品编号</th>
				<th width="15%">物品名称</th>
				<th width="8%">物品型号</th>
				<th width="12%">申领机构</th>
				<th width="8%">审批数量</th>
				<th width="8%">出库数量</th>

				<th width="10%">说明</th>
				<th width="10%">状态</th>
				<th ></th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<label>
						<input name="stock_add" type="checkbox"  value="${bean.outstockid}"/>
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
						
						<td>${bean.chknum}</td>
						
						<td>
							<input name="num" type="text"  value="${bean.chknum}" size="10" class="input1" onchange="checkNum(this);"/>						
						</td>
					
						<td>
							<input name="desc" type="text" value="" size="10" class="input1" />						
						</td>
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS%>" codeValue="${bean.reqstatus}" />
						</td>
						<td>
							<input type="hidden" name="outstockorg" value="${bean.outstockorg}">
						
						<input type="hidden" name="category" value="${bean.category}">
						<input type="hidden" name="category_name" value="<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />">
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
	</div>
	<div id="operate">
	<div class="operate_btn">
	<logic:present name="ITEMS01081VO" property="outStockList">
		<span> 
		<html:button property="btn_add" value="出库"
			styleClass="button" onclick="operation('insert')" />
		
		</span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" /></div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>