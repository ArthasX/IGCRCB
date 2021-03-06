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
<bean:define id="id" value="ITEMS0175" toScope="request" />
<bean:define id="title" value="下拔物品画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	

	
	function operation(name,id){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0175.do";
			document.forms[0].submit();

		}else if(name=="insert"){
			
			 if(window.confirm("您确定要下拨这些物品吗？")){
				 var count=0;
				 count=checkAndCreate();
				 if(count==0){
					alert("请您先选择要下拨的物品！");
					return;
				 }
				 if(count==9){
					 return;
				 }

				 document.forms[0].action=getAppRootUrl() + "/ITEMS0175_INSERT.do";
				 document.forms[0].submit();
			 } 
		}
	}

	function checkAndCreate(){
		var count=0;
	
		var check = document.getElementsByName("stock_add");
		var seqcodes = document.getElementsByName("seqcode");
		var itemsnames = document.getElementsByName("itemsname");
		var typecodes = document.getElementsByName("typecode");
		var categorys = document.getElementsByName("category_q");
		var reqnums = document.getElementsByName("num");
		var stocknums = document.getElementsByName("stocknum1");
		
		for(var i=0;i<reqnums.length;i++){
			if(check[i].checked==true){
				if(reqnums[i].value==null || reqnums[i].value.trim()==""){
					alert("请填写物品编号为"+seqcodes[i].value+"的物品的下拨数量！");
					return 9;
				}else if(!checkIsNumberForCSE(reqnums[i].value)){
					alert("物品编号为"+seqcodes[i].value+"的物品的下拨数量应该为正整数！");
					return 9;
				}
			}else{
				if(reqnums[i].value!=null && reqnums[i].value.trim()!=""){
					alert("请勾选物品编号为"+seqcodes[i].value+"的物品！");
					return 9;
				}
				
			}
			
		}
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				createHiddenInput("seqcodes",seqcodes[i].value);
				createHiddenInput("itemsnames",itemsnames[i].value);
				createHiddenInput("typecodes",typecodes[i].value);
				createHiddenInput("categorys",categorys[i].value);
				createHiddenInput("reqnums",reqnums[i].value);
				createHiddenInput("stocknum",stocknums[i].value);
			}
		}
	
	    return count;
	}	

	function checkNum(obj){
		if(obj.value!=""){
			if(!checkIsNumberForCSE(obj.value)){
				alert("请输入最大长度为9位的正整数！");
				obj.value = "";
				obj.focus();
				event.returnValue = false;
			}
		}
		
	}

	function checkIsNumberForCSE(str){
	 	myReg = /^[1-9][0-9]{0,8}$/;
		
	 	return myReg.test(str);
	}

	
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0175">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 下拨物品</p>
	<div class="back">
		<a href="ITEMS0174_Back.do" target="_self">返回</a>
	</div>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<input type="hidden" name="sid" >
<span>物品种类：</span> <span> <html:select property="category" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="category_options" property="value" name="" labelProperty="label" /></html:select></span>&nbsp;&nbsp;

<span>物品名称：</span><html:text property="typecode_q" styleId="typecode_q" errorStyleClass="inputError imeDisabled" size="15" maxlength="32" />
&nbsp;&nbsp;
<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','stock_add')"/> 
					
				</label>
				</th>
				<th width="25%">物品名称</th>
				<th width="10%">物品编号</th>				
				<th width="15%">物品型号</th>
				<th width="15%">物品种类</th>
				<th width="10%">库存数量</th>
				<th width="15%">下拨数量</th>
				<th></th>
			</tr>
			<logic:present name="ITEMS01081VO" property="stockList">
				<logic:iterate id="bean" name="ITEMS01081VO" property="stockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<input name="stock_add" type="checkbox" value="${bean.stockid}"/>

						</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.seqcode}</td>

						<td>${bean.typecode}</td>
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						<td>${bean.stocknum}</td>
						<td>
							<input name="num" type="text"  value="" size="15" class="input1" onblur="checkNum(this);"/>						
						
						</td>
						<td>
							<input type="hidden" name="seqcode" value="${bean.seqcode}">
							<input type="hidden" name="itemsname" value="${bean.itemsname}">
							<input type="hidden" name="typecode" value="${bean.typecode}">
							<input type="hidden" name="category_q" value="${bean.category}">
							<input type="hidden" name="stocknum1" value="${bean.stocknum}">
						</td>
						
						
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<div class="operate_btn">
	<logic:present name="ITEMS01081VO" property="stockList">
		<span> 
			<html:button property="btn_add" value="下拨" styleClass="button" onclick="operation('insert')" />
			
		</span>
	</logic:present>
	</div>
	</div>
	<html:hidden property="reqorg"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>