<%@page import="com.deliverik.infogovernor.asset.form.IGASM3201Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.asset.vo.IGASM32011VO"%>

<html:html>
<bean:define id="id" value="IGASM3201" toScope="request"/>
<bean:define id="title" value="风险事件查询画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
	function checkForm(obj){
		window.location.href = "IGASM3203_Disp.do?eiid="+obj;
	}
	
	function showPolicy(obj){
		var result= "";
		//设置请求的Action
		igAjax.ajaxAction = "/IGASM3201_showPolicy.do";
		//是否异步    false：同步    true：异步
		igAjax.asynchronous = false;
		//提交方式    "POST"    "GET"
		igAjax.method = "POST";
		//参数列表
		igAjax.parameters = {
			"eiid":obj
		};
		//回调函数
		igAjax.back = function(req, json){
			 result=req.responseText;
		};
		//执行
		igAjax.doAjax();
		openNewDiv('newDiv',result);
		/* createTable(result); */
	}
	function docEle(id){
	   return document.getElementById(id) || null;
	}
	function openNewDiv(_id,result) {
	    if (docEle(_id)) {
		    document.body.removeChild(docEle(_id));
	    }
	    if(result){
		    //新激活图层
		    var newDiv = document.createElement("div");
		    newDiv.id = _id;
		    newDiv.style.position = "absolute";
		    newDiv.style.zIndex = "9999";
		    newDiv.style.width = "200px";
		    newDiv.style.height = "50px";
		    newDiv.style.top = "290px";
		    newDiv.style.left = (parseInt(document.body.scrollWidth) - 340) / 2 + "px"; // 屏幕居中
		    newDiv.style.background = "EEEEEE";
		    newDiv.style.border = "1px solid #0066cc";
		    newDiv.style.padding = "5px";
		    newDiv.innerHTML = result;
		    document.body.appendChild(newDiv);   
		    newDiv.onclick = function() {
		 	    document.body.removeChild(docEle(_id));
			    return false;
		    };
	    }
	}
	
	function goToEdit(obj){
		var result= "";
		//设置请求的Action
		igAjax.ajaxAction = "/IGASM3203_Disp.do";
		//是否异步    false：同步    true：异步
		igAjax.asynchronous = true;
		//提交方式    "POST"    "GET"
		igAjax.method = "POST";
		//参数列表
		igAjax.parameters = {
			"eiid":obj
		};
		//回调函数
		igAjax.back = function(req, json){
			 result=req.responseText;
		};
		//执行
		igAjax.doAjax();
	}
	
	
	
	function createTable(str){
		if(str == '') return '';
		var row = str.split("@_@");
		var start = '<table class="table_style" style="width:auto;height:18px;" >';
		for(var i=0;i<row.length;i++){
			var cell = row[i].split("#_#");
			var level = cell[0];     //级别
			var id = cell[1];	     //ID
			var checkflag = cell[2]; //复选框
			var prid = cell[3];		 //流程ID（用于判断逻辑）	
			var levelword = cell[4]; //级别英文标识
			var createtime = cell[5];//发生时间
			var ip = cell[6];		 //ip
			var msg = cell[7];		 //告警信息
			var isalarm = cell[8];   //是否是告警
	
			var tr = '<tr class="alarmcolor_level'+level+'"><td width="6%">';
			if(prid == '0'){
				tr = tr + '<input type="checkbox" name="ids" value="'+id+'"  '+checkflag+' >';
			}else{
				tr = tr + '<img src="images/sitemap.png" border="0" onclick="tiaozuan('+prid+',1);" alt="查看流程" style="cursor: pointer;"/>';
			}
			tr = tr + '</td><td width="6%" style="text-align:left;">';
			if(isalarm == '1'){
				tr = tr + '<img src="images/plugin/hq3.png" align="middle"  style="cursor: pointer;" /></td>';
			}
			tr = tr + '<td style="text-align:left;" width="7%">'+levelword+'</td>';
			tr = tr + '<td style="text-align:left;" width="12%">'+createtime+'</td>';
			tr = tr + '<td style="text-align:center;" width="12%">'+ip+'</td>';
			tr = tr + '<td style="text-align:left;">'+msg+'</td></tr>';
			tr = tr + '<input type="hidden" value="'+isalarm+'" name="isalarm'+id+'"/>';
			tr = tr + '<input type="hidden" value="'+level+'" name="level'+id+'"/>';
			tr = tr + '<input type="hidden" value="'+ip+'" name="ip'+id+'"/>';
			tr = tr + '<input type="hidden" value="'+msg+'" name="msg'+id+'"/>';
	
			start = start + tr;
		}
		var end = '</table>';	
	    return start+end;
	}
	
	
	
	
	
	
	function setTree(){
		var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid=114",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.getElementById("tree_show_value").value = "";
			document.getElementById("tree_value").value = "";
		}else if(null!=temp && temp.split("|").length>1){
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
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

			if(treesyscode!=null && name!=null && treesyscode != ''){
				document.getElementById("tree_show_value").value = name;
				document.getElementById("tree_value").value =treesyscode + "_tree_" + name;
			}else{
				document.getElementById("tree_show_value").value = "";
				document.getElementById("tree_value").value = "";
			}
		}		
	}
	function init(){
		var flag = document.getElementById("showFlag").value;
		if(flag!=1){
			onHidden();
		}
		else{
			onShow();	
		}
	}
	function onShow(){
		document.getElementById("showFlag").value = 1;
		document.getElementById("div3").style.display="";
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	function onHidden(){
		document.getElementById("showFlag").value = 0;
		document.getElementById("div3").style.display="none";
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGASM3201" styleId="form">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">风险管理&gt;&gt; 风险事件管理&gt;&gt; 风险事件查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
		<label id="label_img" style="margin-left:736px;margin-top:-1px;">
    		<img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0"/>
   	    </label>
	</div>
	<div>
		<span class="subscribe">风险事件名称：</span>
		<html:text property="fcname" size="12" />
		<span class="subscribe">风险事件来源：</span>
		<html:select property="fcorigin"  tabindex="2" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_CASE_ORIGIN" isCodeLabel="true"/>
		</html:select>
		<span class="subscribe" style="width:110px">风险事件所属领域：</span>
		<html:select property="fccategory"  tabindex="5" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_CASE_CATEGORY" isCodeLabel="true"/>
		</html:select>
		<span class="subscribe" style="width:80px;">风险点名称：</span>
		<html:text property="fcriskname" readonly="true" tabindex="5" />
		<input width="0px" type="hidden" name="riskid" id="riskid" />
		<html:submit styleClass="button" value="查询" />
		<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">风险识别时间：</span>
		<html:text property="riskcatchtime_from" styleId="riskcatchtime_from" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('riskcatchtime_from'))" border="0" style="cursor: hand" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="riskcatchtime_to" styleId="riskcatchtime_to" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('riskcatchtime_to'))" border="0" style="cursor: hand" />
		<span class="subscribe" style="width:110px">应对策略：</span>
		<html:select property="fcpolicy"  tabindex="12" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_POLICY" isCodeLabel="true"/>
		</html:select>
		<span class="subscribe">评审结果：</span>
		<html:select property="riskreviewresult"  tabindex="12" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_REVIEW_RESULT" isCodeLabel="true"/>
		</html:select>
	</div>
	<div style="margin-top:12px;" id="div3">
		<span class="subscribe">状态：</span>
		<html:select property="eistatus"  tabindex="12" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_STATUS" isCodeLabel="true"/>
		</html:select>
	</div>

	</div>
	</div>

	<div id="results_list" style="overflow: scroll;"><ig:message />
	
	<table class="table_style" style="table-layout: fixed;">
		<tr>
			<th width="86px" >
				<a href="IGASM3201.do?orderVal=prserialnum">风险事件名称
				<logic:equal name="IGASM3201Form" property="order" value="prserialnum">
					<logic:equal name="IGASM3201Form" property="sing" value="ASC">
						<img src="images/timeup.gif" border="0">
					</logic:equal>
					<logic:equal name="IGASM3201Form" property="sing" value="DESC">
						<img src="images/timedown.gif" border="0">
					</logic:equal>
				</logic:equal></a>
			</th>
			
			
			<th width="86px">
				<a href="IGASM3201.do?orderVal=prtitle">风险点名称			
					<logic:equal name="IGASM3201Form" property="order" value="prtitle">
						<logic:equal name="IGASM3201Form" property="sing" value="ASC">
							<img src="images/timeup.gif" border="0">
						</logic:equal>
						<logic:equal name="IGASM3201Form" property="sing" value="DESC">
							<img src="images/timedown.gif" border="0">
						</logic:equal>
					</logic:equal>
				</a>
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=prstatus">风险严重等级
			<logic:equal name="IGASM3201Form" property="order" value="prstatus">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="100px"><a href="IGASM3201.do?orderVal=prusername">风险发生可能性
			<logic:equal name="IGASM3201Form" property="order" value="prusername">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="60px">风险级别</th>
			
			<th width="90px"><a href="IGASM3201.do?orderVal=prclosetime">风险识别时间
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=propentime">应对任务名称
			<logic:equal name="IGASM3201Form" property="order" value="propentime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">应对策略
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">应对目标
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">应对部门
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=prclosetime">应对负责人
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=prclosetime">抄送风控人员
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="56px"><a href="IGASM3201.do?orderVal=prclosetime">评审结果
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">状态
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
		</tr>
	<logic:present name="IGASM32011VO" property="riskcaseVWList">
			<logic:iterate id="bean" name="IGASM32011VO" property="riskcaseVWList"
				indexId="index">
				<tr class="alarmcolor_level" style='cursor:hand' onclick="checkForm('${bean.EIID}');">
					<td>
						${bean.fcname}
					</td>
					<td title="${bean.fcriskname}">
						<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
							${bean.fcriskname}
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td>
						${bean.fcseveritylevel}
					</td>
					<td>
						${bean.fcpossibility}
					</td>
					<td>
						${bean.fclevel}
					</td>
					<td>
						${bean.riskcatchtime}
					</td>
					<td>
						${bean.fcrisktask}
					</td>
					<td onmouseover="showPolicy('${bean.EIID}');">
						<ig:codeValue ccid="RISK_POLICY" cid="${bean.fcpolicy}"/>
					</td>
					<td>
						${bean.fcoperatoraim}
					</td>
					<td>
						${bean.fcoperatordept}
					</td>
					<td>
						${bean.fcoperator}
					</td>
					<td>
						${bean.fcccoperator}
					</td>
					<td>
						<ig:codeValue ccid="RISK_REVIEW_RESULT" cid="${bean.riskreviewresult}"/>
					</td>
					<td>
						<ig:codeValue ccid="RISK_STATUS" cid="${bean.EISTATUS}"/>
						<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}" >
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
		
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>
