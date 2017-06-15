<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0313" toScope="request"/>
<bean:define id="title" value="设备上缴登记页面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	function checkForm(){
		<c:if test="${IGASM0313Form.type == 'S'}">
			if(confirm("是否确认提交?")){
				form.action= getAppRootUrl() + "/IGASM0313.do";
				return true;
			}
		</c:if>
		<c:if test="${IGASM0313Form.type == 'I'}">
		 var result = "";
	        var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=getSlectedEntityItemNum',
				 onSuccess:  function(req, json){
				 	result = req.responseText;
			     }
				});
	        if(result != null && result.trim() != ""){
				if(result > '0') {
					if( window.confirm("是否确认提交?")){
						form.action= getAppRootUrl() + "/IGASM0313_Pay.do";
			            return true;
			        } else {
			            return false;
			        }
				} else if(result == '0') {
					alert("请选择要上缴的设备！");
					return false;
				} else {
					alert("操作失败");
					return false;
				}
			} else {
				alert("操作失败");
				return false;
			}
	    </c:if>
		return false;
	}
	function toback(){
    	form.action = getAppRootUrl() + "/IGASM0312_Back.do";
    	form.submit();
    }
	
	function setMuchEntityItemValue(){
		<c:if test="${IGASM0313Form.type == 'I'}">
		var selectCount = 0;
		var eid = "";
        var elabel = "";
        var ename = "";
        var eiid = "";
        var eilabel = "";
        var einame = "";
        var ecategory = "";
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=confirmEntityItem',
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
<jsp:include page="/include/header2.jsp" />
<div id="container">
<!--header  头部和 一级菜单-->


<!--container 左菜单 右侧内容-->
<div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
             <div class="back"><html:link href="IGASM0312_Back.do">返回</html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM0313" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                   
	                    <legend>设备上缴</legend>
	                    <logic:present name="IGASM03131VO">
	                    	
	                    
                        <div>
                            <label for="Name"><strong><span class="red">*</span>领用者</strong>：</label>
                            <p class="p2"><bean:write name="IGASM03131VO" property="recivename"/></p>
                             
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>使用机构</strong>：</label>
							<p class="p2"><bean:write name="IGASM03131VO" property="orgname"/></p>
							<br/>
						</div>
			            </logic:present>
			            <div id="countinfo">
						</div>
						<div id="muchCivalue">
						</div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		           		<html:submit  value="返回" styleClass="button" onclick="toback();" />
		            </div>
                    <html:hidden property="eiid" />
                    <html:hidden property="eiiorgid" />
                    <html:hidden property="eiversion" />
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>