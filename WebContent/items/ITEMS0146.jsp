<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>

<html:html>
<bean:define id="id" value="ITEM0146" toScope="request" />
<bean:define id="title" value="下拨物品页面" toScope="request" />
<bean:define id="bean" name="ITEMS01081VO" property="stock" type="com.csebank.items.model.Stock"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<%
	Map<Integer,String> namemap = new HashMap<Integer,String>();
	//Map<Integer,String> buttonmap = new HashMap<Integer,String>();
	//Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("nameMap")){
		namemap = (Map)request.getAttribute("nameMap");
	}
	//if(null!=request.getAttribute("buttonMap")){
	//	buttonmap = (Map)request.getAttribute("buttonMap");
	//}
	//if(null!=request.getAttribute("startbuttonMap")){
	//	startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	//}
	
%>
<script type="text/javascript">

function operation(name){
	/*
	if(name=="insert"){
		 if(window.confirm("您确定要下拨吗？")){
			 var temp = document.getElementsByName("reqorgs");
			 var chnum = document.getElementsByName("chknums");
			 var total = 0;
			 for(var i = 0; i < temp.length; i++){
				 if(temp!=null){
					if(temp[i].value == "" ){
						alert("请选择第"+(i+1)+"行的下拨机构！");
						return;
					}
					if(chnum!=null){
						if(chnum[i].value.trim() == "" ){
							alert("请填写第"+(i+1)+"行的下拨数量！");
							return;
						}else if(Number(chnum[i].value)>Number(${bean.stocknum})){
							alert("第"+(i+1)+"行的下拨数量不能大于库存数量！");
							return;
						}else if(Number(chnum[i].value)<=0){
							alert("第"+(i+1)+"行的下拨数量不能为0！");
							return;
						}
						total+=Number(chnum[i].value);
					}else{
						alert("请填写第"+(i+1)+"行的下拨数量！");
						return;
					}
				}else{
					alert("请先选择要下拨的机构和要下拨的数量！");
					return;
				}
			 }
			 if(total>Number(${bean.stocknum})){
				 alert("下拨总数量不能大于库存数量！");
				 return;
			 }
			

			document.forms[0].action=getAppRootUrl() + "/ITEMS0146_INSERT.do";
			document.forms[0].submit();

		 } 
	}
	*/
	if(name=="insert"){
		
		 if(window.confirm("您确定要下拨吗？")){
			 var count=0;
			 count=checkAndCreate();
			 if(count==0){
				alert("请您先选择要下拨的机构！");
				return;
			 }
			 if(count==9){
				 return;
			 }

			 document.forms[0].action=getAppRootUrl() + "/ITEMS0146_INSERT.do";
			 document.forms[0].submit();
		 } 
	}

}
function checkAndCreate(){
	var count = 0;
	var total = 0;
	var check = document.getElementsByName("stock_add");
	var chknums = document.getElementsByName("chknum");
	var orgs = document.getElementsByName("org");
	var stocknum = <%=bean.getStocknum() %>;

	for(var i=0;i<check.length;i++){
		if(check[i].checked==true){
			if(chknums[i].value==null || chknums[i].value.trim()==""){
				alert("请填写机构名称为‘"+orgs[i].value+"’的记录的下拨数量！");
				return 9;
			}else if(Number(chknums[i].value)<=0){
				alert("机构名称为‘"+orgs[i].value+"’的记录的下拨数量应该大于0！");
				return 9;
			}else if(Number(chknums[i].value)>Number(stocknum)){
				alert("机构名称为‘"+orgs[i].value+"’的记录的下拨数量不能超过库存数量！");
				return 9;
			}
			total+=Number(chknums[i].value);
		}
	}
	if(total>Number(stocknum)){
		 alert("下拨总数量不能大于库存数量！");
		 return 9;
	}
	
	for(var i=0;i<check.length;i++){
		if(check[i].checked==true){
			count=1;
			createHiddenInput("reqorgs",check[i].value);
			createHiddenInput("chknums",chknums[i].value);
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
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
   <div id="content">
   <div id="location">
	<div class="image"></div>
	<p class="fonts1"> <ig:navigation extname1="${urlable}"/> &gt;&gt;下拨</p>
	<div class="back">
		<a href="ITEMS0145.do" target="_self">返回</a>
	</div>
	</div>
	<div class="record_list">
		<table cellspacing="2" class="table_style1">
			<tr>
				<th width="10%">物品种类：</th>
				<td width="40%">
					<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
				</td>
				<th width="10%">物品编号：</th>
				<td width="40%">${bean.seqcode}</td>
			</tr>
			<tr>
				<th>物品名称：</th>
				<td>${bean.itemsname}</td>
				<th>物品型号：</th>
				<td>${bean.typecode}</td>
			</tr>
			<tr>
				<th>物品类型：</th>
				<td>
					<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_TYPE%>" codeValue="${bean.type}"/>
				</td>
				<th>所属机构：</th>
				<td><ig:cseOrgValue orgsyscoding="${bean.stockorg}"/>
				  
				</td>
			</tr>
			<tr>
				<th>登记时间：</th>
				<td>${bean.uptime}</td>
				<th>库存数量：</th>
				<td>${bean.stocknum}
				 
				</td>
			</tr>		
		</table>
  	</div>
  	 <div class="title">
	 <div class="name">下拨信息</div>
	 </div>
	  <html:form method="post" styleId="form">
	 <div id="results_list">
	<ig:message />
	<input type="hidden" name="stockid" id="stockid" value="${bean.stockid}">
	<input type="hidden" name="stocknum" value="${bean.stocknum}">
	<table class="table_style">
			<tr>
				<th width="10%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','stock_add')"/> 
					
				</label>
				</th>
				<th width="50%">机构名称</th>
				<th width="40%">下拨数量</th>
			</tr>
			<logic:present name="ITEMS01081VO" property="orgList">
				<logic:iterate id="bean1" name="ITEMS01081VO" property="orgList" indexId="index">
					<bean:define id="oid" name="bean1" property="orgid"  toScope="request" />
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<label>
						<input name="stock_add" type="checkbox" value="${bean1.orgsyscoding}"/>
						</label>
						</td>
						
						<td title='<%=namemap.get(oid) %>'>${bean1.orgname}</td>
						
						<td>
							<input name="chknum" type="text"  value="" size="30" class="input1" onchange="checkNum(this);"/>						
							<input type="hidden" name="org" value="${bean1.orgname}">
						</td>
						
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<div class="operate_btn">
	<logic:present name="ITEMS01081VO" property="orgList">
		<span> 
			<html:button property="btn_add" value="下拨" styleClass="button" onclick="operation('insert')" />
			
		</span>
	</logic:present>
	</div>
	</div>
	
	
	 </html:form>
	
	
</div>
</div>
</div>
</div>
</body>
</html:html>