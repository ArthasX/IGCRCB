<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGKGM0208" toScope="request" />
<bean:define id="title" value="知识审批画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	//存入知识库
	function updateRec(){
		 var count=0;
		 count=checkForUpdate();
		 if(count==0){
			alert("请您先选择要存入知识库的记录！");
			return;
		 }
	    if(window.confirm("您确定要将记录存入知识库吗？")){
	    	
	        document.forms[0].action = getAppRootUrl() + "/IGKGM0208_UPDATE.do";
	        document.forms[0].submit();
	    } 
	}

	function checkForUpdate(){
		var count=0;
		var check = document.getElementsByName("del");
		var versions = document.getElementsByName("knversion");
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				createHiddenInput("knids",check[i].value);
				createHiddenInput("knversions",versions[i].value);
			}
		}
	    return count;
	}
	
	//知识驳回
	function rejectRec(){
		var count=0;
		 count=checkForRejectRec();
		
		 if(count==-1){
				return;
		 }
		 if(count==0){
			alert("请您先选择要驳回的记录！");
			return;
		 }
	    if(window.confirm("您确定要将记录驳回吗？")){
	    	
	    	 
			 
	        document.forms[0].action = getAppRootUrl() + "/IGKGM0208_REJECT.do";
	        document.forms[0].submit();
	    } 
	}
	
	function checkForRejectRec(){
		var count=0;
		var check = document.getElementsByName("del");
		var knreject = document.getElementsByName("knreject");
		var versions = document.getElementsByName("knversion");
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				if(knreject[i].value.strlen()>64){
					alert("第"+(i+1)+"条知识驳回信息不能大于"+Math.floor(63/strByteFlag)+"个汉字！");
					return -1;
				}
				createHiddenInput("knids",check[i].value);
				createHiddenInput("knrejects",knreject[i].value);
				createHiddenInput("knversions",versions[i].value);
			}
		}
	    return count;
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
	 //将字符串 两边空格去掉
	function trimblank(str){
		$("knkey").value = trimMid($("knkey").value).trim()
		$("kntitle").value = trimMid($("kntitle").value).trim()
		return true;
	}
	// 将字符串中间的多余空格都替换为1个空格
	function trimMid(str){
		return str.replace(/[\s]+/g," ");
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
          <html:form styleId="form" action="/IGKGM0208" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">流程管理 &gt;&gt; 知识库 &gt;&gt; 知识审批</p>
            		
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
			<html:text property="knserial_like" styleId="knserial_like" errorStyleClass="inputError imeDisabled" size="20" />
			<span class="subscribe">关键字：</span>
			<html:text property="knkey" styleId="knkey" errorStyleClass="inputError imeDisabled" size="20" />
			 <span class="subscribe">贡献人：</span>
				<html:text property="knproffername" styleId="knproffername" errorStyleClass="inputError imeDisabled" size="18" />
		    
			 <span class="subscribe">内容：</span>
			<html:text property="kntitle" styleId="kntitle" errorStyleClass="inputError imeDisabled" size="118" />
			<html:submit property="btn_search" styleClass="button" value="查询" onclick="trimblank();" />
			
			
			
			
			
			
	     </div>
		<div style="margin-top:12px">
		    <span class="subscribe">分类：</span>
			<html:text property="knclassname" styleId="knclassname" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
                           	                   <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTree('252','knclass','knclassname')" style="cursor: hand"/>
			<span class="subscribe">来源：</span>
			<html:text property="knoriginname" styleId="knoriginname" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
                           	                   <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTree('254','knorigin','knoriginname')" style="cursor: hand"/>	
                           		               <html:hidden property="knorigin"/>
			
			<span class="subscribe">技术领域：</span>

			<html:text property="kntelareaname" styleId="kntelareaname" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
                 	                   <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTecknowlegyArea()" style="cursor: hand"/>	
                 		               <html:hidden property="kntelarea"/>
			
		</div>
		<div id="div_0.0" style="margin-top:12px;display:none">
		   <span class="subscribe">申请时间：</span>
			<html:text property="knproffertime_f" styleId="knproffertime_f" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	        <img src="images/date.gif" align="middle" onclick="calendar($('knproffertime_f'))" border="0" style="cursor: hand" />
			<span class="subscribe">截止时间：</span>
			<html:text property="knproffertime_t" styleId="knproffertime_t" errorStyleClass="inputError imeDisabled" size="14" readonly="true" />
	                                      <img src="images/date.gif" align="middle" onclick="calendar($('knproffertime_t'))" border="0" style="cursor: hand" />
                           	<html:hidden property="knclass"/>
        </div>
                   	
                   	</div>
                </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table  class="table_style">
							<tr>
							    <th width="10%">编号</th>
								<th width="30%">标题</th>
								<th width="30%">关键字</th>
								<th width="15%">时间</th>
								<th width="15%">分类</th>
							</tr>
						
						
						<!-- body部 -->
						
                            <logic:present name="IGKGM02081VO" property="knowledgeList">
								<logic:iterate id="bean" name="IGKGM02081VO"
									property="knowledgeList" indexId="index">
									<tr  onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('IGKGM0214_CHECK.do?knid=${bean.knid}&knflag=0&knversion=${bean.knversion}');">
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
										<!-- 关键字 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knkey">&nbsp;</logic:empty> ${bean.knkey}</div>
										</td>
										<!-- 时间 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knproffertime">&nbsp;</logic:empty> ${bean.knproffertime}</div>
										</td>
										<!-- 分类 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knclassname">&nbsp;</logic:empty> ${bean.knclassname}</div>
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
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>