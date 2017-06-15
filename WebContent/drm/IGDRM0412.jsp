<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM0412" toScope="request"/>
<logic:equal name="IGDRM0412Form" property="mode" value="0">
<bean:define id="title" value="应急资源模型基本信息登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGDRM0412Form" property="mode" value="1">
<bean:define id="title" value="模型基本信息变更画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

		function confirmDisp(){
			var message = '';
            if ('${IGDRM0412Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="模型基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="模型基本信息" />';
            }
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}
		
	    function toback(){
	        form.action = getAppRootUrl() + "/IGDRM0412.do?org.apache.struts.taglib.html.CANCEL=1";
	        form.submit();
	    }

	    function setEntity(url){
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				jQ("#ename").val("");
				jQ("#esyscoding").val("");
				jQ("#configLabel").hide();
				jQ("#configDiv").hide();
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				jQ("#ename").val(temp.split("|")[1]);
				jQ("#esyscoding").val(temp.split("|")[0]);
			}
			var checkboxs = "";
			if(null!=temp){
				jQ.ajax({
					url:getAppRootUrl()+"/IGDRM0412_AjaxConfig.do?fingerPrint="+jQ("#fingerPrint").val()+"&esyscoding="+temp.split("|")[0],
					type:"POST",
					dataType:"json",
					async:false,
					success:function(result){
						var checkboxs = "";
							checkboxs = checkboxs + "<table id='table"+name.split("_")[1]+"' style=' clear:none;border:1px solid #959499;'>";
						jQ.each(result,function(name,value) {
							checkboxs = checkboxs + "<tr style='float:left;clear:none;'><td style=' float:left;border:1px solid #959499;'><input type='checkbox' id='allboxcids"+name.split("_")[0]+"' onclick='selectAll("+"\"cids\",\"cids"+name.split("_")[0]+"\");' />"+name.split("_")[1]+"</td>";
							var br = 0;
							checkboxs = checkboxs + "<td style='float:left;border:1px solid #959499;'><table><tr>";
							jQ.each(value,function(n,v) {
								checkboxs = checkboxs + "<td style=' display:inline-block;float:left;width:138px;'><input type='checkbox' name= 'cids' attr= 'cids"+name.split("_")[0]+"' ";
								if(v.checked=='1'){
									checkboxs = checkboxs+" checked='checked'";
								}
								checkboxs = checkboxs +" value = "+v.cid+" />"+v.cname+"</td>";
								br = br+1;
								if(br%4==0) 
									checkboxs = checkboxs + "</tr><tr>";
							});
							checkboxs = checkboxs + "</tr></td></table></tr>";
						});
							checkboxs = checkboxs + "</table>";
						jQ("#configDiv").html(checkboxs);
						jQ("#configLabel").show();
						jQ("#configDiv").show();
						}
				});
			}
	    }
	    function setEntityAjax(url){
	    	var flag ;
	    	jQ.ajax({
				url:getAppRootUrl()+"/IGDRM0402_Ajax.do?erid="+'${IGDRM0412Form.fingerPrint}',
				type:"POST",
				dataType:"text",
				async:false,
				success:function(result){
					flag = result;
				}
			});
	    	if(flag == 'true'){
	    		alert("当前模型下已经关联资产，请先解除关联！");
			}else{
				
				var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if("_resetall"==temp){
					jQ("#ename").val("");
					jQ("#esyscoding").val("");
					return false;
				}
				if(null!=temp && temp.split("|").length>1){
					jQ("#ename").val(temp.split("|")[1]);
					jQ("#esyscoding").val(temp.split("|")[0]);
				}
				var checkboxs = "";
				if(null!=temp){
				jQ.ajax({
					url:getAppRootUrl()+"/IGDRM0412_AjaxConfig.do?fingerPrint="+jQ("#fingerPrint").val()+"&esyscoding="+temp.split("|")[0]+"&flag=new",
					type:"POST",
					dataType:"json",
					async:false,
					success:function(result){
						var checkboxs = "";
							checkboxs = checkboxs + "<table id='table"+name.split("_")[1]+"' style=' clear:none;border:1px solid #959499;'>";
						jQ.each(result,function(name,value) {
							checkboxs = checkboxs + "<tr style='float:left;clear:none;'><td style=' float:left;border:1px solid #959499;'><input type='checkbox'  id='allboxcids"+name.split("_")[0]+"' onclick='selectAll("+"\"cids\",\"cids"+name.split("_")[0]+"\");' />"+name.split("_")[1]+"</td>";
							var br = 0;
							checkboxs = checkboxs + "<td style='float:left;border:1px solid #959499;'><table><tr>";
							jQ.each(value,function(n,v) {
								checkboxs = checkboxs + "<td style=' display:inline-block;float:left;width:138px;'><input type='checkbox' name= 'cids' attr= 'cids"+name.split("_")[0]+"' ";
								if(v.checked=='1'){
									checkboxs = checkboxs+" checked='checked'";
								}
								checkboxs = checkboxs +" value = "+v.cid+" />"+v.cname+"</td>";
								br = br+1;
								if(br%4==0) 
									checkboxs = checkboxs + "</tr><tr>";
							});
							checkboxs = checkboxs + "</tr></td></table></tr>";
						});
							checkboxs = checkboxs + "</table>";
						jQ("#configDiv").html(checkboxs);
						jQ("#configLabel").show();
						jQ("#configDiv").show();
						}
				});
				}
			}
	    	}
	    function setEMEntity(url){

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].eparname.value = "";
				document.forms[0].eparcoding.value = "";
				document.forms[0].ecategory.value = "";
				return false;
			}
			if(null!=temp &&temp.split("|")[2].length==15){
				alert("最多添加四级模型！");
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].eidStr.value = temp.split("|")[0];
// 				document.forms[0].eid.value = temp.split("|")[0];
				document.forms[0].eparname.value = temp.split("|")[1];
				document.forms[0].eparcoding.value = temp.split("|")[2];
			
			}		
			
		}
	    function checkForm(){
	    	var patrn=/[\/\\:*?<>|\"]+/;

	    	var s=$F('ename');
			
			 if(patrn.exec(s))
	    	{   
	    		alert("文件名不能包含下列字符:  "+"\/\\:*?\"<>|");
	    		return false;
	    	}
	       if($F('eparname').trim()==""){
	    		alert("请选择上级模型！");
	    		return false;
	    	}
	       if('${IGDRM0412Form.mode}'=='0'){
	        if($F('ename').trim()==""){
	    		alert("请输入对应资产分类！");
	    		return false;
	    	}
	       }
	        //判断是否符合正则表达式-字母:(/^[A-Z]+$/
// 	        var reg= /^[A-Z]+$/;
// 	        if (!reg.test($F('elabel'))||($F('elabel').strlen()!=4)){
// 	        	alert("模型编号规则必须为4位大写字母！");
// 	    		return false;
// 	        } 
	    	if($F('ername').trim()==""){
	    		alert("请输入模型名称！");
	    		return false;
	    	}
	    	if($F('ername').strlen()>128){
	    		alert("模型名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('edesc').strlen()>3000){
	    		alert("模型说明不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '';
	            if ('${IGDRM0412Form.mode}' == '0'){
	                message = '<bean:message key="IGCO10000.W001" arg0="模型基本信息" />';
	            } else {
	                message = '<bean:message key="IGCO10000.W003" arg0="模型基本信息" />';
	            }
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
				
	    	}
	    }
	    function loadCongif(){
	    	var checkboxs = "";
	    	if('${IGDRM0412Form.mode}'=='1'){
	    		jQ.ajax({
					url:getAppRootUrl()+"/IGDRM0412_AjaxConfig.do?fingerPrint="+'${IGDRM0412Form.fingerPrint}'+"&esyscoding="+'${IGDRM0412Form.esyscoding}',
					type:"POST",
					dataType:"json",
					async:false,
					success:function(result){
						var checkboxs = "";
							checkboxs = checkboxs + "<table id='table"+name.split("_")[1]+"' style=' clear:none;border:1px solid #959499;'>";
						jQ.each(result,function(name,value) {
							checkboxs = checkboxs + "<tr style='float:left;clear:none;'><td style=' float:left;border:1px solid #959499;'><input type='checkbox'  id='allboxcids"+name.split("_")[0]+"' onclick='selectAll("+"\"cids\",\"cids"+name.split("_")[0]+"\");' />"+name.split("_")[1]+"</td>";
							var br = 0;
							checkboxs = checkboxs + "<td style='float:left;border:1px solid #959499;'><table><tr>";
							jQ.each(value,function(n,v) {
								checkboxs = checkboxs + "<td style=' display:inline-block;float:left;width:138px;'><input type='checkbox' name= 'cids' attr= 'cids"+name.split("_")[0]+"' ";
								if(v.checked=='1'){
									checkboxs = checkboxs+" checked='checked'";
								}
								checkboxs = checkboxs +" value = "+v.cid+" />"+v.cname+"</td>";
								br = br+1;
								if(br%4==0) 
									checkboxs = checkboxs + "</tr><tr>";
							});
							checkboxs = checkboxs + "</tr></td></table></tr>";
						});
							checkboxs = checkboxs + "</table>";
						jQ("#configDiv").html(checkboxs);
						jQ("#configLabel").show();
						jQ("#configDiv").show();
						}
				});
	    	}
	    }
	    function selectAll(name,obj) { 
	    	if(!jQuery("#allbox"+obj).attr("checked")){
	    		jQuery("#allbox"+obj).removeAttr("checked");
	    		jQuery("input[name='"+name+"'][attr='"+obj+"']").removeAttr("checked");
	    	}else{
	    		jQuery("#allbox"+obj).attr("checked","checked");
	    		jQuery("input[name='"+name+"'][attr='"+obj+"']").attr("checked","checked");
	    	}
	    }
	</script>
<!-- <body> -->
<body onload="loadCongif();">
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
                <p class="fonts1">应急管理&gt;&gt; 应急资源管理&gt;&gt; 
	                <logic:equal name="IGDRM0412Form" property="mode" value="0">
	                                             应急资源模型登记
	                </logic:equal>
					<logic:equal name="IGDRM0412Form" property="mode" value="1">
					应急资源模型查询 &gt;&gt; 应急资源模型变更
					</logic:equal>
                </p>
                <logic:equal name="IGDRM0412Form" property="mode" value="1">
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                </logic:equal>
            </div>
            <div id="formwrapper">
            <html:form styleId="form" action="/IGDRM0412" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGDRM0412Form" property="mode" value="0">
					    <legend>基本信息添加</legend>
					</logic:equal>
					<logic:equal name="IGDRM0412Form" property="mode" value="1">
	                          <legend>基本信息变更</legend>
					</logic:equal>
					 <div>
						<label for="Name"><strong>
						<logic:equal name="IGDRM0412Form" property="mode" value="0">
						<span class="red">*</span>
						</logic:equal>
						上级模型</strong>：</label>
						<logic:equal name="IGDRM0412Form" property="mode" value="0">
						<html:text name="IGDRM0412Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEMEntity('IGDRM0412_Tree.do');"/>
						</logic:equal>
						<logic:equal name="IGDRM0412Form" property="mode" value="1">
						<html:text name="IGDRM0412Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true" styleClass="inputDisable"/>
						</logic:equal>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong>
						<logic:equal name="IGDRM0412Form" property="mode" value="0">
						<span class="red">*</span>
						</logic:equal>
						模型名称</strong>：</label>
						<html:text name="IGDRM0412Form" property="ername" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
    				
<!--     		 		<div> -->
<!-- 						<label for="Name"><strong><span class="red">*</span>模型编号规则</strong>：</label> -->
<%-- 						<html:text name="IGDRM0412Form" property="elabel" size="18" style="width:200px;" errorStyleClass="inputError" maxlength="4" tabindex="2"/><span class="red">（请输入4位大写字母！）</span> --%>
<!-- 						<br> -->
<!--     				</div> -->
					
                    <div>
						<label for="Name"><strong>
						<logic:equal name="IGDRM0412Form" property="mode" value="0">
						<span class="red">*</span>
						</logic:equal>
						对应资产分类</strong>：</label>
						<logic:equal name="IGDRM0412Form" property="mode" value="0">
						<html:text name="IGDRM0412Form" property="ename" styleId="ename" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="对应资产分类" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0&socVWflag=yes');"/>
						</logic:equal>
						<logic:equal name="IGDRM0412Form" property="mode" value="1">
						<html:text name="IGDRM0412Form" property="ename" styleId="ename" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="对应资产分类" width="16" height="16" border="0" onclick="setEntityAjax('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0&socVWflag=yes');"/>
						</logic:equal>
						<br>
    				</div>
    				<div id="configLabel" style="clear: none;display: none;float: left;">
    				<label for="Name"><strong>
						<logic:equal name="IGDRM0412Form" property="mode" value="0">
						</logic:equal>
						资产属性导出项</strong>：</label>
    				</div>
                    <div id="configDiv" style="display: none;clear: none;float: left;margin-left: 0px;" >
                    
    				</div>
	       			<div>
					    <label for="Name"><strong>模型说明</strong>：</label>
					    <html:text name="IGDRM0412Form" property="edesc" styleId="edesc" tabindex="3" size="41" style="width:450px;" errorStyleClass="inputError"/>
					    <br>
    				</div>
    				</fieldset>
    				<html:hidden property="esyscoding" styleId="esyscoding"/>
				<html:hidden property="eparcoding"/>
				<html:hidden property="estatus"/>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();confirmDisp();"  />
				    <logic:equal name="IGDRM0412Form" property="mode" value="1">
				    <html:cancel styleClass="button" value="返回"/>
				    </logic:equal>
				</div>
		        <html:hidden property="eid" styleId="eid"/>
		        <html:hidden property="eidStr" styleId="eidStr"/>
		        <html:hidden property="mode" styleId="mode"/>
		        <html:hidden property="ecategory" styleId="ecategory"/>
		        <html:hidden property="emodeltype" styleId="emodeltype"/>
		        <html:hidden property="fingerPrint" styleId="fingerPrint"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>