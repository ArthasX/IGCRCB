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
<bean:define id="id" value="IGLOM0206" toScope="request" />
<bean:define id="title" value="领用物品画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	

	
	function operation(name,id){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/IGLOM0205_Disp1.do";
			document.forms[0].submit();

		}else if(name=="insert"){
			 
			 if(window.confirm("您确定要领用这些物品吗？")){
				 var count=0;
	
				var check=document.getElementsByName("gsids");
				var seqcodes = document.getElementsByName("gcodes");
				var itemsnames = document.getElementsByName("gnames");
				var categorys = document.getElementsByName("gcategorys");

				for(var i=0;i<check.length;i++){
					if(check[i].checked==true){
						if($F('goinnums['+i+']').trim()==""){
							alert("请填写物品编号为\""+seqcodes[i].value+"\"的物品的领用数量！");
							return false;
						}else if(!checkIsNumberForCSE($F('goinnums['+i+']'))){
							alert("物品编号为\""+seqcodes[i].value+"\"的物品的领用数量应该为正整数！");
							return false;
						}
						if($F('goreasons['+i+']')!=""){
							if($F('goreasons['+i+']').strlen()>40){
								alert("物品编号为\""+seqcodes[i].value+"\"的物品的说明不能大于"+Math.floor(40/strByteFlag)+"个汉字！");
								return false;
							}
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
				alert("请您先选择要领用的物品！");
				return false;
			 }
			 document.forms[0].action=getAppRootUrl() + "/IGLOM0205_Insert.do";
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

	function showIncident(){
		
		var ccid = "216";
		var cid = "";
		var syscode = "";
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}

		url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			$("gscategory").value="";
			$("gscategoryname").value="";
				return false;
			}
		if(null!=temp && temp.split("|").length>1){
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
			var treeccid;
			var treecid;
			var treesyscode;
			
			if(id.split("_").length>1){
				treeccid = id.split("_")[0];
				treecid = id.split("_")[1];
				treesyscode = id.split("_")[2];
			}else{
				treeccid = id.split("_")[0];
				treecid = "";
				treesyscode = "";
			}

			
			$("gscategory").value=treesyscode;
			$("gscategoryname").value=name;
			
			
		}		
		
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
<html:form styleId="form" action="/IGLOM0205_Disp1">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 物品领用</p>
<div class="back"><a href="IGLOM0205_Disp.do" target="_self">返回</a></div> 
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<html:hidden property="rid"/>
<span>物品种类：</span> <span> 
		<html:text property="gscategoryname" size="18" readonly="true"/> 
		<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
		<html:hidden property="gscategory" />
</span>&nbsp;&nbsp;
<span>物品名称：</span><html:text property="gsname" styleId="gsname" errorStyleClass="inputError imeDisabled" size="15" maxlength="32" />
&nbsp;&nbsp;

<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>
<br>
<span>领用机构：</span><span>${IGLOM0203Form.goorgname}</span>&nbsp;&nbsp;
<span>领用人：</span><span>${IGLOM0203Form.gorequsername}</span>

<html:hidden property="goorg"/>
<html:hidden property="rid"/>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">
					<label> 
					<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','gsids')"/> 
					</label>
				</th>
				<th width="15%">物品编号</th>
				<th width="20%">物品名称</th>
				<th width="20%">物品种类</th>
				<th width="10%">库存数量</th>
				<th width="10%">领用数量</th>
				<th width="20%">说明</th>
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

						<td>
							<ig:projectTypeValue ptype="${bean.gscategory}" />
						</td>
						
						<td>${bean.gsnum}</td>
						
						<td >

							<html:text name="IGLOM0203Form" property="goinnums[${ADcount}]"  size="10" errorStyleClass="inputError" />
						</td>
						
						<td >

							<html:text name="IGLOM0203Form" property="goreasons[${ADcount}]"  size="20" maxlength="20" errorStyleClass="inputError" />
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
			<html:button property="btn_add" value="领用" styleClass="button" onclick="operation('insert')"  />
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