<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0314" toScope="request"/>
<bean:define id="title" value="设备报废页面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">
function checkForm(){
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}
function toback(){
	form.action = getAppRootUrl() + "/IGASM0310_Back.do";
	form.submit();
}
function setMuchEntityItemValue(){
	<c:if test="${IGASM0314Form.type == 'I'}">
	var selectCount = 0;
	var eid = "";
    var elabel = "";
    var ename = "";
    var eiid = "";
    var eilabel = "";
    var einame = "";
    var ecategory = "";
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=confirmEntityItemfull',
		 onSuccess:  function(req, json){
		 	var result = req.responseText;
			if(result != null && result.trim() != ""){	
				var entityItemArray = result.split("###");
				if(entityItemArray != null && entityItemArray.length > 0) {
		            for(var i = 0; i < entityItemArray.length;) {
						eid += entityItemArray[i++]+"<br />";
	                    eiid += entityItemArray[i++]+"<br />";
	                    einame += entityItemArray[i++]+"<br />";
	                    ecategory += entityItemArray[i++]+"<br />";
	                    eilabel += entityItemArray[i++]+"<br />";
	                    selectCount += 1;
			         }
		            if(selectCount == 0){
						alert("请选择资产");
					}else{
						initEntityItemList(eid, elabel, ename, eiid, eilabel, einame,ecategory);
					}
				} else {
					alert("没有选中资产！");

				}
			} else {
				alert("没有选中资产！");
			}
	     }
		});
	</c:if>
}
var count = 0;
function initEntityItemList(eid, elabel, ename, eiid, eilabel, einame,ecategory){
	var einames  = einame.split("<br />");
	var eiids  = eiid.split("<br />");
	var eilabels  = eilabel.split("<br />");
	var str = "";
	for(var i=0;i<einames.length;i++){
		if(einames[i] != ""){
				str+="<input type='text' id='einames["+ i +"]' name='muchCivalue' size='40' value='("+eilabels[i] + ")" + einames[i]+"' readonly='readonly' class='input1'/>";
				str+="<a href='javascript:deleteEntityItem("+ i + ",1," +eiids[i] + ")' id='a["+ i +"]'>删除<br /></a>";
				++count;
		}
	}
	
	$("muchCivalue").innerHTML=str;
	$("countinfo").innerHTML="<B>共选择" + count + "个设备</B>";
}
function deleteEntityItem(num,flag,eiid) {

	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=removeSlectedEntityItem&eiid=' + eiid,
			 onSuccess:  function(req, json){
			 	var result = req.responseText;
				if(result != null && result.trim() != ""){	
		            $("einames["+ num +"]").outerHTML = "";
		            $("a["+ num +"]").outerHTML = "";
		            $("countinfo").innerHTML="<B>共选择" + (--count) + "个设备</B>";
				} else {
					alert("删除失败！");
					return false;
				}
		     }
			});
}
</script>

<body onLoad="setMuchEntityItemValue();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">

<c:if test="${IGASM0314Form.type != 'I'}">
<bean:define id="entityItemVWInfo" name="IGASM03141VO" property="entityItemVWInfo" />
</c:if>
<!--container 左菜单 右侧内容-->
<div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
                <div class="back"><html:link href="IGASM0310_Back.do">返回</html:link></div>
            </div>
            
		    <div id="formwrapper">
		    	<c:if test="${IGASM0314Form.type != 'I'}">
		         <html:form styleId="form" action="/IGASM0314" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                   
	                    <legend>设备报废</legend>
	                    
	                    <div class="record_list">
						<table cellspacing="2" class="table_style1">
							<tr>
								<th width="15%" align="right">
									设备名称：
								</th>
								<td width="35%">
									<bean:write name="entityItemVWInfo" property="einame" />
								</td>
								<th width="15%" align="right">
									设备编号：
								</th>
								<td width="35%">
									<bean:write name="entityItemVWInfo" property="eilabel" />
								</td>
							</tr>
							<tr>
								<th align="right">
								管理人：
								</th>
								<td>
									<bean:write name="entityItemVWInfo" property="eiusername" />
								</td>
								<th align="right">
								登记日：
								</th>
								<td>
									<bean:write name="entityItemVWInfo" property="eiinsdate" />
								</td>
							</tr>
							<tr>
								<th align="right">
								设备说明：
								</th>
								<td colspan="3">
									<bean:write name="entityItemVWInfo" property="eidesc" />
								</td>
							</tr>
							
						</table>
						</div>
			            
		            </fieldset>
		            <div class="enter">
		            <logic:present name="IGASM03141VO" property="flag">
		            <logic:equal value="true" name="IGASM03141VO" property="flag">
		                <html:submit property="btn_insert" value="报废" styleClass="button"  onclick="return checkForm();"  />
		            </logic:equal>
		            </logic:present>
		            	<html:button property="button" value="返回" styleClass="button" onclick="toback();" />
		            </div>
		            <html:hidden property="eiid" value="${IGASM0314Form.eiid}" />
                    <html:hidden property="eiversion" value="${IGASM0314Form.eiversion}" />
		         </html:form>
		         </c:if>
		         <c:if test="${IGASM0314Form.type == 'I'}">
		         <html:form styleId="form" action="/IGASM0314_batch" onsubmit="return checkSubmit(this);">
			     <div id="countinfo">
				 </div>
	          	 <div id="muchCivalue">
				 </div>
				 <html:submit property="btn_insert" value="报废" styleClass="button"  onclick="return checkForm();"  />
				 <html:button property="button" value="返回" styleClass="button" onclick="toback();" />
			     </html:form>
			     </c:if>
		    </div>
        </div>
    </div>
</div>
</div>
</body>
</html:html>