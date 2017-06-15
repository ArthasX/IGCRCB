<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM2101" toScope="request"/>
<bean:define id="title" value="预案信息登记" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM0302';
		 function checkForm(){
				if($F('ename').trim()==""){
		    		alert("请选择模型名称！");
		    		return false;
		    	}
		    	if($F('eiorgname').trim()==""){
		    		alert("请选择所属机构！");
		    		return false;
		    	}
		    	if($F('eilabel').trim()==""){
		    		alert("请输入预案编号！");
		    		return false;
		    	}
		    	if($F('einame').trim()==""){
		    		alert("请输入预案名称！");
		    		return false;
		    	}
		    	if($F('eiinsdate').trim()==""){
		    		alert("请输入登记日！");
		    		return false;
		    	}if($F('eilabel').strlen()>32){
		    		alert("预案编号不能大于32个字符！");
		    		return false;
		    	}if($F('einame').strlen()>120){
		    		alert("预案名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		    		return false;
		    	}if($F('eidesc').strlen()>256){
		    		alert("预案说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		    		return false;
		    	}else {
		    		var message = '';
		            if ('${IGDRM2101Form.mode}' == '0'){
		                message = '<bean:message key="IGCO10000.W001" arg0="预案基本信息" />';
		            } else {
		                message = '<bean:message key="IGCO10000.W003" arg0="预案基本信息" />';
		            }
					if( window.confirm(message)){
						return true;
					} else {
						return false;
					}
		    	}
		    }
	    function setRoleDomain(url){
			url = url+"?roletype=IGBP50";
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].eiorgsyscoding.value = "";
				document.forms[0].eiorgname.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
				document.forms[0].eiorgname.value = temp.split("|")[1];
			}		

		}
	    function setEntity(url){
	    	url = url+"?roletype=IGBP50&subtype=888001";
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].eid.value = "";
				document.forms[0].esyscoding.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					alert("资产模型不可用！请选择其他模型！");
					return false;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].eid.value = eid;
				document.forms[0].esyscoding.value = syscode;
			}		
		}
	    function searchMaxEntityItemLable(){
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'ecategorykey=YABH&type=eilable',
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
						document.getElementById("eilabel").value = result;
					} else {
						document.getElementById("labelMessage").innerText = "获取编号失败！";
					}
			     }
			});
		}
	    var num = 0;
	    function addEntity(syscoding) {	
	    	num++;
	    	eval("currRow=tbentity.insertRow();");
	    	cell=currRow.insertCell();
	    	cell.innerHTML= "<input type='text' name='einames' id='einames_"+num+"' size='18' readonly='true' errorStyleClass='inputError imeActive' piid=''><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity('"+syscoding+"',"+num+")\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deleteEntityItem(this)\" style='cursor: hand'/><input type='hidden' name='eids' id='eids_"+num+"'/><input type='hidden' name='eiids' id='eiids_"+num+"'/><input type='hidden' name='eiversions' id='eiversions_"+num+"'/><input type='hidden' name='ids' id='ids_"+num+"'/>";
	    }
	    
	    function deleteEntityItem(obj) {
	    	var curRow= obj.parentNode.parentNode;
	    	$("tbentity").deleteRow(curRow.rowIndex);
	    }
	    var index = 0;
	    function selectEntity(esyscoding,num){
	    	index = num;
	    	window.openSubWindow("/IGDRM2101_BsInit.do?flag=sign&esyscoding="+esyscoding,"_blank", 1100, 600);
    	}
	    function setParamDRM2101(eid, elabel, ename, eiid, eilabel, einame ,ecategory,eiversion,esyscoding,id){
	    	if(einame == "" && eilabel == "" ){
	            jQ("#einames_"+index).val("");
	            jQ("#eids_"+index).val("");
	            jQ("#eiids_"+index).val("");
	            jQ("#eiversions_"+index).val("");
	            jQ("#ids_"+index).val("");
            }else{
            	jQ("#einames_"+index).val(einame);
            	jQ("#eids_"+index).val(eid);
            	jQ("#eiids_"+index).val(eiid);
	            jQ("#eiversions_"+index).val(eiversion);
            	jQ("#ids_"+index).val(id);
            }
	    	index = 0;
	    }
	    function toback(){
	    	IGDRM2101Form.action = getAppRootUrl() + "/IGDRM2105_Back.do?MANAGE=true";
	    	IGDRM2101Form.submit();
	    }
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
                <logic:equal name="IGDRM2101Form" property="mode" value="1">
                	<div class="back">
                		<a href="javascript:toback();">返回</a>
                	</div>
			    </logic:equal>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="IGDRM2101Form" action="/IGDRM2101" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGDRM2101Form" property="mode" value="0">
			            	<legend>预案基本信息添加</legend>
			            </logic:equal>
	                    <logic:equal name="IGDRM2101Form" property="mode" value="1">
	                    	<legend>预案基本信息变更</legend>
	                    </logic:equal>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
                            <logic:equal name="IGDRM2101Form" property="mode" value="0">
	                        	<html:text property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
	                            <img src="images/tree.gif" style="cursor: hand;" alt="预案模板" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/>
                            </logic:equal>
                            <logic:equal name="IGDRM2101Form" property="mode" value="1">
	                        	<html:text property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
	                        	<html:hidden property="eiid" />
                            </logic:equal>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>所属机构</strong>：</label>
							<logic:equal name="IGDRM2101Form" property="mode" value="0">
								<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
								<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');" alt="请选择机构"/>
							</logic:equal>
							<logic:equal name="IGDRM2101Form" property="mode" value="1">
								<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							</logic:equal>
							<html:hidden property="eiorgsyscoding"/>
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>预案编号</strong>：</label>
							<logic:equal name="IGDRM2101Form" property="mode" value="0">
			                	<html:text property="eilabel" tabindex="1" style="width:125px;" errorStyleClass="inputError" readonly="true"/>
			                	<html:link onclick="searchMaxEntityItemLable()" href="javascript:void(0)">获取编号</html:link><span class="red" id="labelMessage"></span>
			                </logic:equal>
							<logic:equal name="IGDRM2101Form" property="mode" value="1">
			                	<html:text property="eilabel" tabindex="1" style="width:125px;" errorStyleClass="inputError" readonly="true"/>
			                </logic:equal>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>预案名称</strong>：</label>
			                <html:text property="einame" style="width:200px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>预案说明</strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>关键字</strong>：</label>
			                <html:text property="fingerPrint" styleId="fingerPrint" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>业务系统</strong>：</label>
			                <table id="tbentity">
								<logic:equal name="IGDRM2101Form" property="mode" value="1">
									<bean:define id="einames" name="IGDRM21012VO" property="soc0119ListNames" />
									<logic:iterate id="info" name="IGDRM21012VO" property="soc0119List" indexId="index">
									<tr>
										<td>
											${einames[index]}
											&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick="deleteEntityItem(this)" style='cursor: hand' />
													<html:hidden property="ids" name="ids" value="${info.eirdesc}" />
													<html:hidden property="eids" name="eids" value="${info.cldeid}" />
													<html:hidden property="eiids" name="eiids" value="${info.cldeiid}" />
													<html:hidden property="eiversions" name="eiversions" value="${info.cldversion}" />
										</td>
									</tr>
									</logic:iterate>
								</logic:equal>
			                	<tr>
			                		<td>
			                			<IMG style="CURSOR: hand" alt="添加" src="images/addasm.gif">
			                			<A id=aAddEntity href="javascript:addEntity('1_CM03000000_999003');">添加业务系统</A>
			                		</td>
			                	</tr>
			                </table>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
                            <html:text property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <logic:equal name="IGDRM2101Form" property="mode" value="0">
                            	<img src="images/date.gif" align="middle" onClick="calendar($('eiinsdate'))" border="0"/>
                            </logic:equal>
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		                <html:reset styleClass="button">重置</html:reset>
		            </div>
		             <html:hidden property="esyscoding"/>
			         <html:hidden property="eid"/>
                    <html:hidden property="mode" styleId="mode"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>