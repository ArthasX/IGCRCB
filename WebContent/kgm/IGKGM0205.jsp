<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGKGM0205" toScope="request" />
<bean:define id="title" value="知识查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style>
<!--
.checkbox{
border:none;	
}
-->
</style>

<script type="text/javascript">	
<%--

--%>

jQuery(document).ready(function() {
	var knapprovetime_f="<%=request.getParameter("knapprovetime_f")%>";
	   var knapprovetime_t ="<%=request.getParameter("knapprovetime_t")%>";

	   if(knapprovetime_f=="null"){
		   if(knapprovetime_t=="null"){

			   onHidden();
	    	   }		    	   
	   }else{
		   onShow();

	   }
	   if(knapprovetime_f==''){
		   if(knapprovetime_t==''){
		
			  onHidden();
	    	   }		    	   
	   }
	});



function showTecknowlegyArea(){
	var ccid = '255';
	var url = "IGSYM1202_TREE_BY_STATUS.do?ccid="+ccid;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		$("kntelarea").value = "";
		$("kntelareaname").value = "";
	}else if(null!=temp && temp.split("|").length>1){
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

		if(treesyscode!=null && name!=null){
			$("kntelarea").value = treesyscode;
			$("kntelareaname").value = name;
		}
		
	}		

}
function showTree(ccid,code,knname){
	
	var ccid = ccid;
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
		$(code).value="";
		$(knname).value="";
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
		$(code).value=treesyscode;
		$(knname).value=name;
		
	}		
}

	function trimblank(str){
//		$("knkey").value = trim($("knkey").value).trim();
		$("kntitle").value = trim($("kntitle").value).trim();
		return true;
	}
	function trim(str){
		return str.replace(/[\s]+/g," ");
	}

	function getDetail(id,version){
		   doLook("IGKGM0216_READ.do?knid="+id+"&knversion="+version);
		}

	function goToKnowledgehistory(url){
		openSubWindow(url,"KnowledgeHistory","1000","600");
	}
	
	 function exportExcel() {
		 
	 	var count=0;
	 	var check = document.getElementsByName("del");
	 	for(var i=0;i<check.length;i++){
	 		if(check[i].checked==true){
	 			count=1;
	 			createHiddenInput("knids",check[i].value);
	 		}
	 	}

		if(count == 0){
			alert("请选择需要导出的知识!");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGKGM0228_Report.do";
		document.forms[0].submit();
		document.forms[0].action = getAppRootUrl() + "/IGKGM0205.do";
		while(1){
			var o = document.getElementById("knids");
			if(o!=null){
				document.forms[0].removeChild(o);   
			}else{
				break;
			}
		}
	}
	 function onShow(){
		document.getElementById("showFlag").value = 1;
		document.getElementById("div_0.0").style.display="";
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
		
	 function onHidden(){
		document.getElementById("showFlag").value = 0;
		document.getElementById("div_0.0").style.display="none";
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
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
	
	function exportExcel() {
		 
	 	var count=0;
	 	var check = document.getElementsByName("del");
	 	for(var i=0;i<check.length;i++){
	 		if(check[i].checked==true){
	 			count=1;
	 			createHiddenInput("knids",check[i].value);
	 		}
	 	}

		if(count == 0){
			alert("请选择需要导出的知识!");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGKGM0228_Report.do";
		document.forms[0].submit();
		document.forms[0].action = getAppRootUrl() + "/IGKGM0205.do";
		while(1){
			var o = document.getElementById("knids");
			if(o!=null){
				document.forms[0].removeChild(o);   
			}else{
				break;
			}
		}
	}
	
		
</script>
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
     
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGKGM0205" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">流程管理 &gt;&gt; 知识库 &gt;&gt; 知识查询</p>
            		
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
		<div style="margin-top:4px">
			<span class="subscribe">编号：</span>
			<html:text property="knserial_like" styleId="knserial_like" size="12" style="width:80px;" /> 
			<span class="subscribe">分类：</span>
			<html:text property="knclassname" styleId="knclassname"  size="5" readonly="true" />
             <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTree('252','knclass','knclassname')" style="cursor: hand"/>
             <html:hidden property="knclass"/>
			<span class="subscribe">内容：</span>
			<html:text property="kntitle" styleId="kntitle" errorStyleClass="inputError imeDisabled" size="12" />
			<span class="subscribe">贡献人：</span>
			<html:text property="knproffername" styleId="knproffername" errorStyleClass="inputError imeDisabled" size="12" />
			<html:submit property="btn_search" styleClass="button" value="查询" onclick="trimblank();" />
		</div>
		<div style="margin-top:12px">
		
			<span class="subscribe">来源：</span>
			<html:text property="knoriginname" styleId="knoriginname" errorStyleClass="inputError imeDisabled" size="12" style="width:80px;" readonly="true" />
			<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTree('254','knorigin','knoriginname')" style="cursor: hand;"/>
            <html:hidden property="knorigin"/>
			<span class="subscribe">技术领域：</span>
			<html:text property="kntelareaname" styleId="kntelareaname" style="width:80px;" errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
       	     <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTecknowlegyArea()" style="cursor: hand"/>
       		<html:hidden property="kntelarea"/>
            <span class="subscribe">关键字：</span>
			<html:text property="knkey" styleId="knkey" errorStyleClass="inputError imeDisabled" size="12" />
			<span class="subscribe">业务系统：</span>
			<html:text property="systemid" styleId="systemid" errorStyleClass="inputError imeDisabled" size="12" />
			 <html:button property="btn_search" styleClass="button" value="批量导出"  onclick="exportExcel()"/>
		</div>
		<div id="div_0.0" style="margin-top:12px">
		    <span class="subscribe">归档时间：</span>
			<html:text property="knapprovetime_f" styleId="knapprovetime_f" style="width:80px;" errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('knapprovetime_f'))" border="0" style="cursor: hand" />&nbsp
			<span>--</span>
			<html:text property="knapprovetime_t" styleId="knapprovetime_t" style="width:80px;" errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('knapprovetime_t'))" border="0" style="cursor: hand" />
            
								
		</div>
		<html:hidden property="selectstatus" name="selectstatus" value="1"/>
     </div>
                </div>
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table  id="table_list" class="table_style">
							<tr>
								
							   <th width="5%">
									<label><input  type="checkbox" name="checkbox" class="checkbox" onclick="selectAll('checkbox','del')"/> 
									</label>
								</th>
								<th width="5%"><a href="IGKGM0205.do?orderVal=knserial">编号
									<logic:equal name="IGKGM0203Form" property="order" value="knserial">
										<logic:equal name="IGKGM0203Form" property="sing" value="ASC">
											<img src="images/timeup.gif" border="0">
										</logic:equal>
										<logic:equal name="IGKGM0203Form" property="sing" value="DESC">
											<img src="images/timedown.gif" border="0">
										</logic:equal>
									</logic:equal>
								</a></th>
								<th width="29%"><a href="IGKGM0205.do?orderVal=kntitle">标题
									<logic:equal name="IGKGM0203Form" property="order" value="kntitle">
										<logic:equal name="IGKGM0203Form" property="sing" value="ASC">
											<img src="images/timeup.gif" border="0">
										</logic:equal>
										<logic:equal name="IGKGM0203Form" property="sing" value="DESC">
											<img src="images/timedown.gif" border="0">
										</logic:equal>
									</logic:equal>
								</a></th>
								<th width="12%"><a href="IGKGM0205.do?orderVal=knproffername">贡献人
									<logic:equal name="IGKGM0203Form" property="order" value="knproffername">
										<logic:equal name="IGKGM0203Form" property="sing" value="ASC">
											<img src="images/timeup.gif" border="0">
										</logic:equal>
										<logic:equal name="IGKGM0203Form" property="sing" value="DESC">
											<img src="images/timedown.gif" border="0">
										</logic:equal>
									</logic:equal>
								</a></th>
								<th width="10%"><a href="IGKGM0205.do?orderVal=knapprovetime">归档时间
									<logic:equal name="IGKGM0203Form" property="order" value="knapprovetime">
										<logic:equal name="IGKGM0203Form" property="sing" value="ASC">
											<img src="images/timeup.gif" border="0">
										</logic:equal>
										<logic:equal name="IGKGM0203Form" property="sing" value="DESC">
											<img src="images/timedown.gif" border="0">
										</logic:equal>
									</logic:equal>
								</a></th>
								<th width="5%"><a href="IGKGM0205.do?orderVal=knclassname">分类
									<logic:equal name="IGKGM0203Form" property="order" value="knclassname">
										<logic:equal name="IGKGM0203Form" property="sing" value="ASC">
											<img src="images/timeup.gif" border="0">
										</logic:equal>
										<logic:equal name="IGKGM0203Form" property="sing" value="DESC">
											<img src="images/timedown.gif" border="0">
										</logic:equal>
									</logic:equal>
								</a></th>
								<th width="4%"><a href="IGKGM0205.do?orderVal=grade">评分
									<logic:equal name="IGKGM0203Form" property="order" value="grade">
										<logic:equal name="IGKGM0203Form" property="sing" value="ASC">
											<img src="images/timeup.gif" border="0">
										</logic:equal>
										<logic:equal name="IGKGM0203Form" property="sing" value="DESC">
											<img src="images/timedown.gif" border="0">
										</logic:equal>
									</logic:equal>
								</a></th>
								<th width="4%">查看</th>
								<th width="5%">历史版本</th>
							</tr>
						
						
						<!-- body部 -->
						
                            <logic:present name="IGKGM02051VO" property="knowLedgeInfoList">
								<logic:iterate id="bean" name="IGKGM02051VO" property="knowLedgeInfoList" indexId="index">
									<tr>
							            <td>
											<label>
												<input name="del" type="checkbox" class="checkbox" value="${bean.knid}"/>
											</label>
										</td>
                                        <!-- 编号 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knserial">&nbsp;</logic:empty> ${bean.knserial}</div>
										</td>

										<!-- 标题 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="kntitle">&nbsp;</logic:empty> ${bean.kntitle}</div>
										</td>
										<!-- 贡献人 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knproffername">&nbsp;</logic:empty> ${bean.knproffername}</div>
										</td>
										<!-- 时间 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knapprovetime">&nbsp;</logic:empty> ${bean.knapprovetime}</div>
										</td>
										<!-- 分类 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knclass">&nbsp;</logic:empty> ${bean.knclassname}</div>
										</td>
										<!-- 评分 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="grade">&nbsp;</logic:empty> ${bean.grade}</div>
										</td>
										<td>
											<a href="javascript:doLook('IGKGM0205_READ.do?knid=${bean.knid}&knversion=${bean.knversion}');" >
											<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0"/></a>
											
										</td>
										<td>
			                                <a href="javascript:goToKnowledgehistory('/IGKGM0205_History.do?knid=${bean.knid}');" ><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></a>
			                            </td>
									</tr>
								</logic:iterate>
							</logic:present>
						
					</table>
				</div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	
	
	<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}" > 
	</div>
    </html:form>
    </div>
    </div>
</div>

	

</div>
</body>
</html:html>