<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>

<html:html>
<bean:define id="id" value="IGLOM0251" toScope="request" />
<bean:define id="title" value="食堂入库画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	

	
	function operation(name,id){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/IGLOM0251_Disp1.do";
			document.forms[0].submit();

		}else if(name=="insert"){
			 
			 if(window.confirm("您确定要入库这些物品吗？")){
				 var count=0;
	
				var check=document.getElementsByName("gsids");
				var seqcodes = document.getElementsByName("gcodes");
				var itemsnames = document.getElementsByName("gnames");
				var categorys = document.getElementsByName("gcategorys");

				for(var i=0;i<check.length;i++){
					if(check[i].checked==true){
						if($F('goinnums['+i+']').trim()==""){
							alert("请填写物品编号为\""+seqcodes[i].value+"\"的物品的入库数量！");
							return false;
						}else if(!checkIsNumberForCSE($F('goinnums['+i+']'))){
							alert("物品编号为\""+seqcodes[i].value+"\"的物品的入库数量应该为正整数！");
							return false;
						}
						count = 1;
					}else{
						if($F('goinnums['+i+']').trim()!=""){
							alert("请勾选物品编号为\""+seqcodes[i].value+"\"的物品！");
							return false;
						}
					}
				}

			 if(count==0){
				alert("请您先选择要入库的物品！");
				return false;
			 }
			 document.forms[0].action=getAppRootUrl() + "/IGLOM0251_Insert.do";
			 document.forms[0].submit();
			 } 
		}else if(name=="read"){
			//document.forms[0].sid.value=id;
			//document.forms[0].action=getAppRootUrl() + "/ITEMS0141_READ.do";
			//document.forms[0].submit();
			
		}
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
<html:form styleId="form" action="/IGLOM0251_Disp1">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 食堂入库</p>
<div class="back"><a href="IGLOM0250_Disp.do" target="_self">返回</a></div> 
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<html:hidden property="rid"/>

<span>物品名称：</span><html:text property="gsname" styleId="gsname" errorStyleClass="inputError imeDisabled" size="15" maxlength="32" />
&nbsp;&nbsp;

<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>
<br>
<span>登记人：</span><span>${IGLOM0203Form.gorequsername}</span>

<html:hidden property="goorg"/>
<html:hidden property="rid"/>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">
					<label> 
					<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','gsids')"/> 
					</label>
				</th>
				<th width="20%">物品编号</th>
				<th width="30%">物品名称</th>
				<th width="20%">仓库库存数量</th>
				<th width="20%">入库数量</th>
				<th></th>
			</tr>
			<logic:present name="IGLOM02051VO" property="itemsCategoryList">
				<logic:iterate id="bean" name="IGLOM02051VO" property="itemsCategoryList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>					
							<label>
							<html:multibox property="gsids" value="${bean.gsid}" />
						 	</label>
						</td>
						
						<td>${bean.gscode}</td>
						
						<td>${bean.gsname}</td>
						
						<td>${bean.gsnum}</td>
						
						<td >

							<html:text name="IGLOM0203Form" property="goinnums[${ADcount}]"  size="10" errorStyleClass="inputError" />
						</td>
						<td>

							<html:hidden property="gcodes" styleId="gcodes" name="IGLOM0203Form" value="${bean.gscode}"  />
			    			<html:hidden property="gnames" styleId="gnames" name="IGLOM0203Form" value="${bean.gsname}"  />
			    			<html:hidden property="gcategorys" styleId="gcategorys" name="IGLOM0203Form" value="${bean.gscategory}"  />

						</td>
					</tr>
					<c:set var="ADcount" value="${ADcount+1}"/>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<div class="operate_btn">
	<logic:present name="IGLOM02051VO" property="itemsCategoryList">
		<span> 
			<html:button property="btn_add" value="入库" styleClass="button" onclick="operation('insert')"  />
			<html:reset property="btn_clear" styleClass="button" value="重置" />
		</span>
	</logic:present>
	</div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>