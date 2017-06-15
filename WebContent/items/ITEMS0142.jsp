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
<bean:define id="id" value="ITEMS0142" toScope="request" />
<bean:define id="title" value="申领审批画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function operation(name,flag){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0142.do";
			document.forms[0].submit();
		}else if(name=="insert"){
			 document.forms[0].flag.value=flag;
			 if(window.confirm("您确定要审批这些记录吗？")){
				 var count=0;
				 count=checkAndCreate();
				 if(count==0){
					alert("请您先选择要审批的记录！");
		            return;
				 }
				 if(count==9){
					 return;
				 }	 
				
				 document.forms[0].action=getAppRootUrl() + "/ITEMS0142_INSERT.do";
				 document.forms[0].submit();

			 } 
		}
	   
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
		var chknums = document.getElementsByName("num");
		var outnums = document.getElementsByName("outnum");
		var chkreasons = document.getElementsByName("desc");
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

		var flag = document.forms[0].flag.value;
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				if(flag!=null && flag=="1"){
					if(chknums[i].value==null || chknums[i].value.trim()==""){
						alert("请填写物品名称为"+itemsnames[i].value+"物品编号为"+seqcodes[i].value+"的物品的审批数量！");
						return 9;
					}else if(Number(chknums[i].value)<=0){
						alert("物品名称为"+itemsnames[i].value+"物品编号为"+seqcodes[i].value+"的物品的审批数量应该大于0！");
						return 9;
					}else if(Number(chknums[i].value)>Number(stocknums[i].value)){
						alert("物品名称为"+itemsnames[i].value+"物品编号为"+seqcodes[i].value+"的物品的审批数量不能超过库存数量！");
						return 9;
					}
					if(chkreasons[i].value!=null || chkreasons[i].value.trim()!=""){
						if(chkreasons[i].value.strlen()>32){
							alert("物品名称为"+itemsnames[i].value+"物品编号为"+seqcodes[i].value+"的物品的说明不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
							return 9;
						}
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
<html:form styleId="form" action="/ITEMS0142_Disp">
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
<span>状态：</span><span><html:select property="reqstatus_q" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="reqstatus_options" property="value" name="" labelProperty="label" /></html:select></span>&nbsp;&nbsp;
<html:hidden property="flag"/>
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
					name="checkbox" id="checkbox" onclick="selectAllNoDisable('checkbox','stock_add')"/> 
					
				</label>
				</th>
				<th width="10%">物品种类</th>
				<th width="7%">物品编号</th>
				<th width="10%">物品名称</th>
				<th width="8%">物品型号</th>
				<th width="10%">申领机构</th>
				<th width="8%">库存数量</th>
				<th width="8%">申领数量</th>
				<th width="8%">审批数量</th>
				<th width="10%">说明</th>
				<th width="15%">申领时间</th>
				<th ></th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
			<bean:define id="exsList" name="ITEMS01081VO" property="exstockList" type="java.util.List"/>
				<logic:iterate id="bean" name="ITEMS01081VO" property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<c:if test="${exsList[index]!=null}">
							<input name="stock_add" type="checkbox"  value="${bean.outstockid}"/>
						</c:if>
						<c:if test="${exsList[index]==null}">
							<input name="stock_add" type="checkbox"  value="${bean.outstockid}" disabled="disabled"/>
						</c:if>
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
						
						<td>
							<c:if test="${exsList[index]!=null}">
								${exsList[index].stocknum}
							</c:if>
							<c:if test="${exsList[index]==null}">
								0
							</c:if>

						</td>
						
						<td>${bean.reqnum}</td>
						
						<td>
							<logic:equal name="bean" property="reqstatus" value="<%=DefineUtils.ITEMSCODES_REQSTATUS_SLDSP%>">
								<input name="num" type="text"  value="${bean.reqnum}" size="10" class="input1" onchange="checkNum(this);"/>	
								
							</logic:equal>
							<logic:notEqual name="bean" property="reqstatus" value="<%=DefineUtils.ITEMSCODES_REQSTATUS_SLDSP%>">
								<input name="num" type="text"  value="${bean.chknum}" size="10" class="input1" onchange="checkNum(this);"/>	

							</logic:notEqual>											
						</td>
						<td>
							<input name="desc" type="text" value="${bean.chkreason}" size="10" class="input1" />						
						</td>
						
						<td>
							${bean.reqtime}
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
						<input type="hidden" name="stockid" value="${exsList[index].stockid}">
						<input type="hidden" name="itemsname" value="${bean.itemsname}">
						<input type="hidden" name="stocknum" value="${exsList[index].stocknum}">
						
						<input type="hidden" name="type" value="${exsList[index].type}">
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
		<html:button property="btn_add" value="通过"
			styleClass="button" onclick="operation('insert','1')" />
		<html:button property="btn_add" value="不通过"
			styleClass="button" onclick="operation('insert','0')" />
		</span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>