<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGKGM0230" toScope="request" />
<bean:define id="title" value="知识查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

function setParentValue(knid, kntitle, knversion){
    if(!window.opener.closed){
	    window.opener.setParamIGKGM0206(knid, kntitle, knversion);
    }
    window.close();
}
function clearParentValue(){
    if(!window.opener.closed){
        window.opener.setParamIGKGM0206("", "", "");
    }
    window.close();
}

function goToKnowledgeInfo(url){
	openSubWindow(url,"Knowledge","1000","600");
	
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
	var reloadFlag = true;
	function trimblank(str){
		$("knkey").value = trim($("knkey").value).trim();
		$("kntitle").value = trim($("kntitle").value).trim();
		reloadFlag = false;
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

	//知识检索时刷新父页面
	function reloadParent() {
		if(!window.opener.closed && opener.reloadMyself && '${IGKGM0203Form.selectDisp}' == '0' && reloadFlag) {
			opener.reloadMyself();
		}
	}

</script>


<body onunload="reloadParent()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
     
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGKGM0230" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div> 
                <p class="fonts1">知识查询</p>           		
            </div>
          
               	<div id="search">
                   	<div class="conditions">
                          	<table width="100%">
		<tr>
			<td width="10%" align="right">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
			<td width="15%" align="left"><html:text property="knserial_like" styleId="knserial_like" errorStyleClass="inputError imeDisabled" size="20" /></td>
			<td width="10%" align="right">关&nbsp;&nbsp;键&nbsp;&nbsp;字：</td>
			<td width="15%" align="left"><html:text property="knkey" styleId="knkey" errorStyleClass="inputError imeDisabled" size="20" /></td>
			<td width="10%" align="right">内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容：</td>
			<td width="15%" align="left">
			<html:text property="kntitle" styleId="kntitle" errorStyleClass="inputError imeDisabled" size="20" /></td>
			<td width="10%" align="right">贡&nbsp;&nbsp;献&nbsp;&nbsp;人：</td>
			<td width="15%" align="left">
				<html:text property="knproffername" styleId="knproffername" errorStyleClass="inputError imeDisabled" size="18" />	
			</td>
		</tr>
		<tr>
		    <td width="10%" align="right">分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：</td>
			<td width="15%" align="left">
			<html:text property="knclassname" styleId="knclassname" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
                           	                   <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTree('252','knclass','knclassname')" style="cursor: hand"/>
			</td>
			<td width="10%" align="right">来&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;源：</td>
			<td width="15%" align="left">
			<html:text property="knoriginname" styleId="knoriginname" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
                           	                   <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTree('254','knorigin','knoriginname')" style="cursor: hand"/>	
                           		               <html:hidden property="knorigin"/>
			</td>
			<td width="10%" align="right">技术领域：</td>
			<td width="15%" align="left">
			<html:text property="kntelareaname" styleId="kntelareaname" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
                 	                   <img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTecknowlegyArea()" style="cursor: hand"/>
                 		               <html:hidden property="kntelarea"/>
			</td>
			<td width="10%" align="right">业务系统：</td>
			<td width="15%" align="left">
			<html:select property="systemid" style="width: 120px;">
							 	<ig:optionsCollection ccid="BUSINESS_SYSTEM_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
							 </html:select>
			</td>
		</tr>
		<tr>
		    <td width="10%" align="right">归档时间：</td>
			<td width="15%" align="left">
			<html:text property="knapprovetime_f" styleId="knapprovetime_f" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	                                             <img src="images/date.gif" align="middle" onclick="calendar($('knapprovetime_f'))" border="0" style="cursor: hand" />
			</td>
			<td width="10%" align="right">截止时间：</td>
			<td width="15%" align="left">
			<html:text property="knapprovetime_t" styleId="knapprovetime_t" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	                                            <img src="images/date.gif" align="middle" onclick="calendar($('knapprovetime_t'))" border="0" style="cursor: hand" />
                           	<html:hidden property="knclass"/>
			</td>
			<td width="10%"></td>
			<td width="15%"></td>
			<td colspan="2" width="25%" align="center"><html:submit property="btn_search" styleClass="button" value="查询" onclick="trimblank();" /></td>
		</tr>
  	</table>
                   	</div>
                </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table  class="table_style">
							<tr>
								<th width="10%">编号</th>
								<th width="20%">标题</th>
								<th width="10%">关键字</th>
								<th width="10%">时间</th>
								<th width="20%">分类</th>
								<th width="10%">评分</th>
								<th width="10%">引用流程数</th>
								<th width="10%">查看</th>
								
							</tr>
						
						
						<!-- body部 -->
						
                            <logic:present name="IGKGM02051VO" property="knowLedgeInfoList">
								<logic:iterate id="bean" name="IGKGM02051VO"
									property="knowLedgeInfoList" indexId="index">
									<tr >
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
										<div class="nowrapDiv"><logic:empty name="bean"
											property="processnum">&nbsp;</logic:empty> ${bean.processnum}</div>
										</td>
										<td>
											<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0" style="cursor:hand" onclick="javascript:goToKnowledgeInfo('/IGKGM0215_Detail.do?knid=${bean.knid}&knversion=${bean.knversion }&prid=${IGKGM0203Form.prid}&sfid=${IGKGM0203Form.sfid}');"/>
										</td>
										
									</tr>
								</logic:iterate>
							</logic:present>
						
					</table>
				</div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
		<div class="enter">
	
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	</div>
	<html:hidden property="selectDisp" name="IGKGM0203Form" styleId="selectDisp"/>
	<html:hidden property="prid" name="IGKGM0203Form" styleId="prid"/>
	<html:hidden property="sfid" name="IGKGM0203Form" styleId="sfid"/>
    </html:form>
    </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>