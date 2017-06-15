<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0309" toScope="request"/>
<bean:define id="title" value="设备下发登记页面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	function checkForm(){
		if($F('reciveUser').trim()==""){
    		alert("请输入领用者！");
    		return false;
    	}
    	if($F('orgname').trim()==""){
			alert("请选择使用机构！");
			return false;
		}
    	if($F('reciveUser').strlen()>120){
    		alert("领用者名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
    		return false;
    	}
    	<c:if test="${IGASM0309Form.type == 'S'}">
			if(confirm("是否确认提交?")){
				return true;
			}
		</c:if>
		<c:if test="${IGASM0309Form.type == 'I'}">
		var result = "";
        var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=getSlectedEntityItemNum',
			 onSuccess:  function(req, json){
			 	result = req.responseText;
		     }
			});
        if(result != null && result.trim() != ""){
			if(result > '0') {
				if( window.confirm("是否确认提交?")){
		            return true;
		        } else {
		            return false;
		        }
			} else if(result == '0') {
				alert("请选择要下发的设备！");
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
	 function setRoleDomain(url){
			url = url+"?roletype=IGAC01";
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				 document.forms[0].orgid.value = "";
				 document.forms[0].orgname.value = "";
				 return false;
			 }
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].orgid.value = temp.split("|")[0];
				document.forms[0].orgname.value = temp.split("|")[1];
			}		

	}
	function toback(){
    	form.action = getAppRootUrl() + "/IGASM0308_Back.do";
    	form.submit();
    }

	function setMuchEntityItemValue(){
		<c:if test="${IGASM0309Form.type == 'I'}">
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
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">


<!--container 左菜单 右侧内容-->
<div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            <div class="back"><html:link href="IGASM0308_Back.do">返回</html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM0309" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                   
	                    <legend>设备下发</legend>
	                    
                        <div>
                            <label for="Name"><strong><span class="red">*</span>领用者</strong>：</label>
                            <html:text property="reciveUser" errorStyleClass="inputError imeActive" />
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>使用机构</strong>：</label>
							<html:text property="orgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');"/>
							 <html:hidden property="orgid" />
							<br/>
						</div>
		           		<div id="countinfo">
						</div>
		           		<div id="muchCivalue">
						</div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		                <html:submit  value="返回" styleClass="button" onclick="toback();" />
		            </div>
                    <html:hidden property="eiid" name="IGASM0309Form" styleId="eiid"/>
                    <html:hidden property="eiversion" name="IGASM0309Form" styleId="eiversion"/>
                    <html:hidden property="type" name="IGASM0309Form" styleId="type"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>