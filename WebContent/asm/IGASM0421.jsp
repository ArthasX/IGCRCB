<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGASM0421" toScope="request"/>
<bean:define id="title" value="合同付款登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
       function toback(){
       	form.action = getAppRootUrl() + "/IGASM0420_Back.do?org.apache.struts.taglib.html.CANCEL=1";
       	form.submit();
       }
       function checkForm(){
    	
    	   if(document.getElementById("act2").value==2){
           if($F('actualday2').trim()!=""){
               if($F('actualday1').trim()==""){
            	   alert("第一笔实付日不能为空！");
        		   return false;
               }
           }
        }
    	 
    	   if(document.getElementById("act3").value==3){
           if($F('actualday3').trim()!=""){
               //if($F('actualday1').trim()==""){
            	   //alert("第一笔实付日不能为空！");
        		   //return false;
               //}
               if($F('actualday2').trim()==""){
            	   alert("第二笔实付日不能为空！");
        		   return false;
               }
           }
    	 }
    	  
    	   if(document.getElementById("act4").value==4){
           if($F('actualday4').trim()!=""){
               /**
               if($F('actualday1').trim()==""){
            	   alert("第一笔实付日不能为空！");
        		   return false;
               }
               if($F('actualday2').trim()==""){
            	   alert("第二笔实付日不能为空！");
        		   return false;
               }
               */
               if($F('actualday3').trim()==""){
            	   alert("第三笔实付日不能为空！");
        		   return false;
               }
           }
    	}
    	   if(document.getElementById("act5").value==5){
           if($F('actualday5').trim()!=""){
               /**
               if($F('actualday1').trim()==""){
            	   alert("第一笔实付日不能为空！");
        		   return false;
               }
               if($F('actualday2').trim()==""){
            	   alert("第二笔实付日不能为空！");
        		   return false;
               }
               if($F('actualday3').trim()==""){
            	   alert("第三笔实付日不能为空！");
        		   return false;
               }
               */
               if($F('actualday4').trim()==""){
            	   alert("第四笔实付日不能为空！");
        		   return false;
               }
           }
       }
    	   if(document.getElementById("act6").value==6){
               if($F('actualday6').trim()!=""){
                   if($F('actualday5').trim()==""){
                	   alert("第五笔实付日不能为空！");
            		   return false;
                   }
               }
            }
           
    	   if(document.getElementById("act7").value==7){
               if($F('actualday7').trim()!=""){
                   if($F('actualday6').trim()==""){
                	   alert("第六笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act8").value==8){
               if($F('actualday8').trim()!=""){
                   if($F('actualday7').trim()==""){
                	   alert("第七笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act9").value==9){
               if($F('actualday9').trim()!=""){
                   if($F('actualday8').trim()==""){
                	   alert("第八笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act10").value==10){
               if($F('actualday10').trim()!=""){
                   if($F('actualday9').trim()==""){
                	   alert("第九笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act11").value==11){
               if($F('actualday11').trim()!=""){
                   if($F('actualday10').trim()==""){
                	   alert("第十笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act12").value==12){
               if($F('actualday12').trim()!=""){
                   if($F('actualday11').trim()==""){
                	   alert("第十一笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act13").value==13){
               if($F('actualday13').trim()!=""){
                   if($F('actualday12').trim()==""){
                	   alert("第十二笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act14").value==14){
               if($F('actualday14').trim()!=""){
                   if($F('actualday13').trim()==""){
                	   alert("第十三笔实付日不能为空！");
            		   return false;
                   }
               }
            }

    	   if(document.getElementById("act15").value==15){
               if($F('actualday15').trim()!=""){
                   if($F('actualday14').trim()==""){
                	   alert("第十四笔实付日不能为空！");
            		   return false;
                   }
               }
            }

           
           /**
           if($F('actualday1').trim()!=""){
        	   if(!checkDate("expectday1","actualday1")){
        		   alert("第一笔实付日不能小于应付日！");
        		   return false;
        	   }
           }
           if(document.getElementById("act2").value==2){
           if($F('actualday2').trim()!=""){
        	   if(!checkDate("expectday2","actualday2")){
        		   alert("第二笔实付日不能小于应付日！");
        		   return false;
        	   }
           }
       }
           if(document.getElementById("act3").value==3){
           if($F('actualday3').trim()!=""){
        	   if(!checkDate("expectday3","actualday3")){
        		   alert("第三笔实付日不能小于应付日！");
        		   return false;
        	   }
           }
       }
           if(document.getElementById("act4").value==4){
           if($F('actualday4').trim()!=""){
        	   if(!checkDate("expectday4","actualday4")){
        		   alert("第四笔实付日不能小于应付日！");
        		   return false;
        	   }
           }
      }
           if(document.getElementById("act5").value==5){
           if($F('actualday5').trim()!=""){
        	   if(!checkDate("expectday5","actualday5")){
        		   alert("第五笔实付日不能小于应付日！");
        		   return false;
        	   }
           }
      }
        */   
           var message = "是否确认付款登记？";
           if(window.confirm(message)){
               return true;
           }else{
        	   return false;
           }
           return false;
       }
       
       function pics(){
      	 var pics = "${IGASM04211VO.picsXml}";
    	 openIntegrationWindow(pics, "pics", "1000", "600");
      	 
       }
       
       function picu(){
      	 var picu = "${IGASM04211VO.picuXml}";
    	 openIntegrationWindow(picu, "picu", "1000", "600");
       }     
       
     //生成影像加密XML
   	function createImageXml(eiid,eilabel,einame,eidesc,operType){
   		var xml = "";
           var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=createImageXml&eiid='+eiid+'&eilabel='+eilabel+'&einame='+einame+'&eidesc='+eidesc+'&operType='+operType,
   			 onSuccess:  function(req, json){
           	xml = req.responseText;
   		     }
   			});
           openIntegrationWindow(xml, "imageXml", "1000", "600");
   	}
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body >
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 合同付款登记 </p>
                <div class="back"><html:link href="IGASM0420_Back.do">返回</html:link></div>
                
            </div>

		    <html:form styleId="form" action="/IGASM0421" enctype="multipart/form-data">
                 <div class="title">
                     <div class="name">合同基本信息</div>
                 </div>
                 <div id="results_list">
				    <table class="table_style">
						<tr>
							<th width="10%">模型名称</th>
                            <th width="15%">合同编号</th>
                            <th width="20%">合同名称</th>
                            <th width="10%">合同类别</th>
                            <!-- <th width="18%">服务商</th> -->
                            <th width="15%">经手人</th>
                            <th width="15%">签订时间</th>
                            <th width="15%">合同款</th>
						</tr>
						<tr>
						  <td>${IGASM04211VO.entityItemCompactVWInfo.ename}</td>
						  <td>${IGASM04211VO.entityItemCompactVWInfo.eilabel}</td>
						  <td>${IGASM04211VO.entityItemCompactVWInfo.einame}</td>
						  <td>${IGASM04211VO.entityItemCompactVWInfo.compacttype}</td>
						  <!-- <td>${fn:substringBefore(IGASM04211VO.entityItemCompactVWInfo.facilitator,"(")}</td> -->
						  <td>${IGASM04211VO.entityItemCompactVWInfo.operator}</td>
						  <td>${IGASM04211VO.entityItemCompactVWInfo.condudetime}</td>
						  <td>${IGASM04211VO.entityItemCompactVWInfo.contractpayment}</td>
						</tr>
                     </table>
                  </div>
                   
                  <div class="title">
                     <div class="name">服务商信息</div>
                  </div>
                 <div id="results_list">
				    <table class="table_style">
						<tr>
                            <th width="10%">服务商</th>
                            <th width="10%">开户行</th>
                            <th width="10%">开户账号</th>
                            <th width="10%">开户名称</th>
						</tr>
						<tr>
						  <td>${fn:substringBefore(IGASM04211VO.entityItemCompactVWInfo.facilitator,"(")}</td>
						  <td>${IGASM04211VO.kaihuhang}</td>
						  <td>${IGASM04211VO.kaihuzhanghao}</td>
						  <td>${IGASM04211VO.kaihumingcheng}</td>
						</tr>
                     </table>
                  </div>
                 
                  <div class="title">
                      <div class="name">合同付款信息</div>
                  </div>
    <div class="message"><ig:message /></div>
    <div class="record_list" id="baseMessage">
	<table class="table_style1">
	<logic:empty name="IGASM0421Form" property="actualmoney1">
	<input type="hidden" id="act1" name="act1" value="0"/>
	</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney1">
		<tr>
			<th width="12%">第一笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday1}
			<html:hidden property="expectday1" name="IGASM0421Form" value="${IGASM0421Form.expectday1}"/>
			<input type="hidden" id="act1" name="act1" value="1">
			</td>
			<th width="10%">制单日：</th>
			<td width="11%">
			<logic:empty name="IGASM0421Form" property="zhidanday1">
			<html:text property="zhidanday1" styleId="zhidanday1" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday1'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday1">
			${IGASM0421Form.zhidanday1}
			<html:hidden property="zhidanday1" name="IGASM0421Form" value="${IGASM0421Form.zhidanday1}"/>
			</logic:notEmpty>
			</td>
			<th width="8%">实付日：</th>
			<td width="19%">
			<logic:empty name="IGASM0421Form" property="actualday1">
			<html:text property="actualday1" styleId="actualday1" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday1'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday1">
			${IGASM0421Form.actualday1}
			<html:hidden property="actualday1" name="IGASM0421Form" value="${IGASM0421Form.actualday1}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday1">
			<html:text property="invoiceexplain1" styleId="invoiceexplain1" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday1">
			${IGASM0421Form.invoiceexplain1}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney1}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio1">
				<html:text property="yingfumoneyratio1" styleId="yingfumoneyratio1" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio1">
				${IGASM0421Form.yingfumoneyratio1}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="shifumoney1">
			<html:text property="shifumoney1" styleId="shifumoney1" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney1'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney1'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney1">
			${IGASM0421Form.shifumoney1}
			<html:hidden property="shifumoney1" name="IGASM0421Form" value="${IGASM0421Form.shifumoney1}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId1}','${IGASM0421Form.contractLabel1}','${IGASM0421Form.contractName1}','${IGASM0421Form.contractDesc1}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId1}','${IGASM0421Form.contractLabel1}','${IGASM0421Form.contractName1}','${IGASM0421Form.contractDesc1}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		<logic:empty name="IGASM0421Form" property="actualmoney2">
		<input type="hidden" id="act2" name="act2" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney2">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第二笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday2}
			<html:hidden property="expectday2" name="IGASM0421Form" value="${IGASM0421Form.expectday2}"/>
			<input type="hidden" id="act2" name="act2" value="2">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday2">
			<html:text property="zhidanday2" styleId="zhidanday2" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday2'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday2">
			${IGASM0421Form.zhidanday2}
			<html:hidden property="zhidanday2" name="IGASM0421Form" value="${IGASM0421Form.zhidanday2}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday2">
			<html:text property="actualday2" styleId="actualday2" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday2'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday2">
			${IGASM0421Form.actualday2}
			<html:hidden property="actualday2" name="IGASM0421Form" value="${IGASM0421Form.actualday2}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday2">
			<html:text property="invoiceexplain2" styleId="invoiceexplain2" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday2">
			${IGASM0421Form.invoiceexplain2}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney2}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio2">
				<html:text property="yingfumoneyratio2" styleId="yingfumoneyratio2" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio2">
				${IGASM0421Form.yingfumoneyratio2}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney2">
			<html:text property="shifumoney2" styleId="shifumoney2" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney2'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney2'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney2">
			${IGASM0421Form.shifumoney2}
			<html:hidden property="shifumoney2" name="IGASM0421Form" value="${IGASM0421Form.shifumoney2}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId2}','${IGASM0421Form.contractLabel2}','${IGASM0421Form.contractName2}','${IGASM0421Form.contractDesc2}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId2}','${IGASM0421Form.contractLabel2}','${IGASM0421Form.contractName2}','${IGASM0421Form.contractDesc2}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>

		<logic:empty name="IGASM0421Form" property="actualmoney3">
		<input type="hidden" id="act3" name="act3" value="0"/>
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney3">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第三笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday3}
			<html:hidden property="expectday3" name="IGASM0421Form" value="${IGASM0421Form.expectday3}"/>
			<input type="hidden" id="act3" name="act3" value="3">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday3">
			<html:text property="zhidanday3" styleId="zhidanday3" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday3'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday3">
			${IGASM0421Form.zhidanday2}
			<html:hidden property="zhidanday3" name="IGASM0421Form" value="${IGASM0421Form.zhidanday3}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday3">
			<html:text property="actualday3" styleId="actualday3" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday3'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday3">
			${IGASM0421Form.actualday3}
			<html:hidden property="actualday3" name="IGASM0421Form" value="${IGASM0421Form.actualday3}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday3">
			<html:text property="invoiceexplain3" styleId="invoiceexplain3" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday3">
			${IGASM0421Form.invoiceexplain3}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney3}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio3">
				<html:text property="yingfumoneyratio3" styleId="yingfumoneyratio3" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio3">
				${IGASM0421Form.yingfumoneyratio3}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney3">
			<html:text property="shifumoney3" styleId="shifumoney3" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney3'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney3'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney3">
			${IGASM0421Form.shifumoney3}
			<html:hidden property="shifumoney3" name="IGASM0421Form" value="${IGASM0421Form.shifumoney3}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId3}','${IGASM0421Form.contractLabel3}','${IGASM0421Form.contractName3}','${IGASM0421Form.contractDesc3}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId3}','${IGASM0421Form.contractLabel3}','${IGASM0421Form.contractName3}','${IGASM0421Form.contractDesc3}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		<logic:empty name="IGASM0421Form" property="actualmoney4">
		<input type="hidden" id="act4" name="act4" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney4">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第四笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday4}
			<html:hidden property="expectday4" name="IGASM0421Form" value="${IGASM0421Form.expectday4}"/>
			<input type="hidden" id="act4" name="act4" value="4">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday4">
			<html:text property="zhidanday4" styleId="zhidanday4" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday4'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday4">
			${IGASM0421Form.zhidanday4}
			<html:hidden property="zhidanday4" name="IGASM0421Form" value="${IGASM0421Form.zhidanday4}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday4">
			<html:text property="actualday4" styleId="actualday4" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday4'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday4">
			${IGASM0421Form.actualday4}
			<html:hidden property="actualday4" name="IGASM0421Form" value="${IGASM0421Form.actualday4}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday4">
			<html:text property="invoiceexplain4" styleId="invoiceexplain4" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday4">
			${IGASM0421Form.invoiceexplain4}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney4}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio4">
				<html:text property="yingfumoneyratio4" styleId="yingfumoneyratio4" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio4">
				${IGASM0421Form.yingfumoneyratio4}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney4">
			<html:text property="shifumoney4" styleId="shifumoney4" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney4'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney4'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney4">
			${IGASM0421Form.shifumoney4}
			<html:hidden property="shifumoney4" name="IGASM0421Form" value="${IGASM0421Form.shifumoney4}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId4}','${IGASM0421Form.contractLabel4}','${IGASM0421Form.contractName4}','${IGASM0421Form.contractDesc4}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId4}','${IGASM0421Form.contractLabel4}','${IGASM0421Form.contractName4}','${IGASM0421Form.contractDesc4}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		<logic:empty name="IGASM0421Form" property="actualmoney5">
		<input type="hidden" id="act5" name="act5" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney5">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第五笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday5}
			<html:hidden property="expectday5" name="IGASM0421Form" value="${IGASM0421Form.expectday5}"/>
			<input type="hidden" id="act5" name="act5" value="5">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday5">
			<html:text property="zhidanday5" styleId="zhidanday5" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday5'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday5">
			${IGASM0421Form.zhidanday5}
			<html:hidden property="zhidanday5" name="IGASM0421Form" value="${IGASM0421Form.zhidanday5}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday5">
			<html:text property="actualday5" styleId="actualday5" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday5'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday5">
			${IGASM0421Form.actualday5}
			<html:hidden property="actualday5" name="IGASM0421Form" value="${IGASM0421Form.actualday5}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday5">
			<html:text property="invoiceexplain5" styleId="invoiceexplain5" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday5">
			${IGASM0421Form.invoiceexplain5}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney5}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio5">
				<html:text property="yingfumoneyratio5" styleId="yingfumoneyratio5" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio5">
				${IGASM0421Form.yingfumoneyratio5}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney5">
			<html:text property="shifumoney5" styleId="shifumoney5" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney5'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney5'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney5">
			${IGASM0421Form.shifumoney5}
			<html:hidden property="shifumoney5" name="IGASM0421Form" value="${IGASM0421Form.shifumoney5}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId5}','${IGASM0421Form.contractLabel5}','${IGASM0421Form.contractName5}','${IGASM0421Form.contractDesc5}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId5}','${IGASM0421Form.contractLabel5}','${IGASM0421Form.contractName5}','${IGASM0421Form.contractDesc5}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		<!-- 第6笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney6">
		<input type="hidden" id="act6" name="act6" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney6">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第六笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday6}
			<html:hidden property="expectday6" name="IGASM0421Form" value="${IGASM0421Form.expectday6}"/>
			<input type="hidden" id="act6" name="act6" value="6">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday6">
			<html:text property="zhidanday6" styleId="zhidanday6" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday6'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday6">
			${IGASM0421Form.zhidanday6}
			<html:hidden property="zhidanday6" name="IGASM0421Form" value="${IGASM0421Form.zhidanday6}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday6">
			<html:text property="actualday6" styleId="actualday6" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday6'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday6">
			${IGASM0421Form.actualday6}
			<html:hidden property="actualday6" name="IGASM0421Form" value="${IGASM0421Form.actualday6}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday6">
			<html:text property="invoiceexplain6" styleId="invoiceexplain6" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday6">
			${IGASM0421Form.invoiceexplain6}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney6}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio6">
				<html:text property="yingfumoneyratio6" styleId="yingfumoneyratio6" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio6">
				${IGASM0421Form.yingfumoneyratio6}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney6">
			<html:text property="shifumoney6" styleId="shifumoney6" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney6'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney6'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney6">
			${IGASM0421Form.shifumoney6}
			<html:hidden property="shifumoney6" name="IGASM0421Form" value="${IGASM0421Form.shifumoney6}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId6}','${IGASM0421Form.contractLabel6}','${IGASM0421Form.contractName6}','${IGASM0421Form.contractDesc6}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId6}','${IGASM0421Form.contractLabel6}','${IGASM0421Form.contractName6}','${IGASM0421Form.contractDesc6}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第7笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney7">
		<input type="hidden" id="act7" name="act7" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney7">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第七笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday7}
			<html:hidden property="expectday7" name="IGASM0421Form" value="${IGASM0421Form.expectday7}"/>
			<input type="hidden" id="act7" name="act7" value="7">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday7">
			<html:text property="zhidanday7" styleId="zhidanday7" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday7'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday7">
			${IGASM0421Form.zhidanday7}
			<html:hidden property="zhidanday7" name="IGASM0421Form" value="${IGASM0421Form.zhidanday7}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday7">
			<html:text property="actualday7" styleId="actualday7" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday7'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday7">
			${IGASM0421Form.actualday7}
			<html:hidden property="actualday7" name="IGASM0421Form" value="${IGASM0421Form.actualday7}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday7">
			<html:text property="invoiceexplain7" styleId="invoiceexplain7" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday7">
			${IGASM0421Form.invoiceexplain7}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney7}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio7">
				<html:text property="yingfumoneyratio7" styleId="yingfumoneyratio7" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio7">
				${IGASM0421Form.yingfumoneyratio7}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney7">
			<html:text property="shifumoney7" styleId="shifumoney7" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney7'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney7'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney7">
			${IGASM0421Form.shifumoney7}
			<html:hidden property="shifumoney7" name="IGASM0421Form" value="${IGASM0421Form.shifumoney7}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId7}','${IGASM0421Form.contractLabel7}','${IGASM0421Form.contractName7}','${IGASM0421Form.contractDesc7}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId7}','${IGASM0421Form.contractLabel7}','${IGASM0421Form.contractName7}','${IGASM0421Form.contractDesc7}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第8笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney8">
		<input type="hidden" id="act8" name="act8" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney8">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第八笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday8}
			<html:hidden property="expectday8" name="IGASM0421Form" value="${IGASM0421Form.expectday8}"/>
			<input type="hidden" id="act8" name="act8" value="8">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday8">
			<html:text property="zhidanday8" styleId="zhidanday8" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday8'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday8">
			${IGASM0421Form.zhidanday8}
			<html:hidden property="zhidanday8" name="IGASM0421Form" value="${IGASM0421Form.zhidanday8}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday8">
			<html:text property="actualday8" styleId="actualday8" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday8'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday8">
			${IGASM0421Form.actualday8}
			<html:hidden property="actualday8" name="IGASM0421Form" value="${IGASM0421Form.actualday8}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday8">
			<html:text property="invoiceexplain8" styleId="invoiceexplain8" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday8">
			${IGASM0421Form.invoiceexplain8}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney8}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio8">
				<html:text property="yingfumoneyratio8" styleId="yingfumoneyratio8" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio8">
				${IGASM0421Form.yingfumoneyratio8}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney8">
			<html:text property="shifumoney8" styleId="shifumoney8" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney8'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney8'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney8">
			${IGASM0421Form.shifumoney8}
			<html:hidden property="shifumoney8" name="IGASM0421Form" value="${IGASM0421Form.shifumoney8}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId8}','${IGASM0421Form.contractLabel8}','${IGASM0421Form.contractName8}','${IGASM0421Form.contractDesc8}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId8}','${IGASM0421Form.contractLabel8}','${IGASM0421Form.contractName8}','${IGASM0421Form.contractDesc8}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第9笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney9">
		<input type="hidden" id="act9" name="act9" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney9">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第九笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday9}
			<html:hidden property="expectday9" name="IGASM0421Form" value="${IGASM0421Form.expectday9}"/>
			<input type="hidden" id="act9" name="act9" value="9">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday9">
			<html:text property="zhidanday9" styleId="zhidanday9" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday9'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday9">
			${IGASM0421Form.zhidanday9}
			<html:hidden property="zhidanday9" name="IGASM0421Form" value="${IGASM0421Form.zhidanday9}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday9">
			<html:text property="actualday9" styleId="actualday9" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday9'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday9">
			${IGASM0421Form.actualday9}
			<html:hidden property="actualday9" name="IGASM0421Form" value="${IGASM0421Form.actualday9}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday9">
			<html:text property="invoiceexplain9" styleId="invoiceexplain9" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday9">
			${IGASM0421Form.invoiceexplain9}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney9}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio9">
				<html:text property="yingfumoneyratio9" styleId="yingfumoneyratio9" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio9">
				${IGASM0421Form.yingfumoneyratio9}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney9">
			<html:text property="shifumoney9" styleId="shifumoney9" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney9'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney9'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney9">
			${IGASM0421Form.shifumoney9}
			<html:hidden property="shifumoney9" name="IGASM0421Form" value="${IGASM0421Form.shifumoney9}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId9}','${IGASM0421Form.contractLabel9}','${IGASM0421Form.contractName9}','${IGASM0421Form.contractDesc9}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId9}','${IGASM0421Form.contractLabel9}','${IGASM0421Form.contractName9}','${IGASM0421Form.contractDesc9}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第10笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney10">
		<input type="hidden" id="act10" name="act10" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney10">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第十笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday10}
			<html:hidden property="expectday10" name="IGASM0421Form" value="${IGASM0421Form.expectday10}"/>
			<input type="hidden" id="act10" name="act10" value="10">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday10">
			<html:text property="zhidanday10" styleId="zhidanday10" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday10'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday10">
			${IGASM0421Form.zhidanday10}
			<html:hidden property="zhidanday10" name="IGASM0421Form" value="${IGASM0421Form.zhidanday10}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday10">
			<html:text property="actualday10" styleId="actualday10" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday10'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday10">
			${IGASM0421Form.actualday10}
			<html:hidden property="actualday10" name="IGASM0421Form" value="${IGASM0421Form.actualday10}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday10">
			<html:text property="invoiceexplain10" styleId="invoiceexplain10" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday10">
			${IGASM0421Form.invoiceexplain10}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney10}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio10">
				<html:text property="yingfumoneyratio10" styleId="yingfumoneyratio10" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio10">
				${IGASM0421Form.yingfumoneyratio10}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney10">
			<html:text property="shifumoney10" styleId="shifumoney10" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney10'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney10'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney10">
			${IGASM0421Form.shifumoney10}
			<html:hidden property="shifumoney10" name="IGASM0421Form" value="${IGASM0421Form.shifumoney10}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId10}','${IGASM0421Form.contractLabel10}','${IGASM0421Form.contractName10}','${IGASM0421Form.contractDesc10}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId10}','${IGASM0421Form.contractLabel10}','${IGASM0421Form.contractName10}','${IGASM0421Form.contractDesc10}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		<!-- 第11笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney11">
		<input type="hidden" id="act11" name="act11" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney11">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第十一笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday11}
			<html:hidden property="expectday11" name="IGASM0421Form" value="${IGASM0421Form.expectday11}"/>
			<input type="hidden" id="act11" name="act11" value="11">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday11">
			<html:text property="zhidanday11" styleId="zhidanday11" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday11'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday11">
			${IGASM0421Form.zhidanday11}
			<html:hidden property="zhidanday11" name="IGASM0421Form" value="${IGASM0421Form.zhidanday11}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday11">
			<html:text property="actualday11" styleId="actualday11" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday11'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday11">
			${IGASM0421Form.actualday11}
			<html:hidden property="actualday11" name="IGASM0421Form" value="${IGASM0421Form.actualday11}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday11">
			<html:text property="invoiceexplain11" styleId="invoiceexplain11" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday11">
			${IGASM0421Form.invoiceexplain11}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney11}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio11">
				<html:text property="yingfumoneyratio11" styleId="yingfumoneyratio11" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio11">
				${IGASM0421Form.yingfumoneyratio11}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney11">
			<html:text property="shifumoney11" styleId="shifumoney11" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney11'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney11'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney11">
			${IGASM0421Form.shifumoney11}
			<html:hidden property="shifumoney11" name="IGASM0421Form" value="${IGASM0421Form.shifumoney11}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId11}','${IGASM0421Form.contractLabel11}','${IGASM0421Form.contractName11}','${IGASM0421Form.contractDesc11}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId11}','${IGASM0421Form.contractLabel11}','${IGASM0421Form.contractName11}','${IGASM0421Form.contractDesc11}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第12笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney12">
		<input type="hidden" id="act12" name="act12" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney12">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第十二笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday12}
			<html:hidden property="expectday12" name="IGASM0421Form" value="${IGASM0421Form.expectday12}"/>
			<input type="hidden" id="act12" name="act12" value="12">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday12">
			<html:text property="zhidanday12" styleId="zhidanday12" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday12'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday12">
			${IGASM0421Form.zhidanday12}
			<html:hidden property="zhidanday12" name="IGASM0421Form" value="${IGASM0421Form.zhidanday12}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday12">
			<html:text property="actualday12" styleId="actualday12" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday12'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday12">
			${IGASM0421Form.actualday12}
			<html:hidden property="actualday12" name="IGASM0421Form" value="${IGASM0421Form.actualday12}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday12">
			<html:text property="invoiceexplain12" styleId="invoiceexplain12" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday12">
			${IGASM0421Form.invoiceexplain12}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney12}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio12">
				<html:text property="yingfumoneyratio12" styleId="yingfumoneyratio12" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio12">
				${IGASM0421Form.yingfumoneyratio12}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney12">
			<html:text property="shifumoney12" styleId="shifumoney12" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney12'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney12'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney12">
			${IGASM0421Form.shifumoney12}
			<html:hidden property="shifumoney12" name="IGASM0421Form" value="${IGASM0421Form.shifumoney12}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId12}','${IGASM0421Form.contractLabel12}','${IGASM0421Form.contractName12}','${IGASM0421Form.contractDesc12}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId12}','${IGASM0421Form.contractLabel12}','${IGASM0421Form.contractName12}','${IGASM0421Form.contractDesc12}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第13笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney13">
		<input type="hidden" id="act13" name="act13" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney13">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第十三笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday13}
			<html:hidden property="expectday13" name="IGASM0421Form" value="${IGASM0421Form.expectday13}"/>
			<input type="hidden" id="act13" name="act13" value="13">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday13">
			<html:text property="zhidanday13" styleId="zhidanday13" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday13'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday13">
			${IGASM0421Form.zhidanday13}
			<html:hidden property="zhidanday13" name="IGASM0421Form" value="${IGASM0421Form.zhidanday13}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday13">
			<html:text property="actualday13" styleId="actualday13" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday13'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday13">
			${IGASM0421Form.actualday13}
			<html:hidden property="actualday13" name="IGASM0421Form" value="${IGASM0421Form.actualday13}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday13">
			<html:text property="invoiceexplain13" styleId="invoiceexplain13" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday13">
			${IGASM0421Form.invoiceexplain13}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney13}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio13">
				<html:text property="yingfumoneyratio13" styleId="yingfumoneyratio13" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio13">
				${IGASM0421Form.yingfumoneyratio13}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney13">
			<html:text property="shifumoney13" styleId="shifumoney13" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney13'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney13'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney13">
			${IGASM0421Form.shifumoney13}
			<html:hidden property="shifumoney13" name="IGASM0421Form" value="${IGASM0421Form.shifumoney13}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId13}','${IGASM0421Form.contractLabel13}','${IGASM0421Form.contractName13}','${IGASM0421Form.contractDesc13}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId13}','${IGASM0421Form.contractLabel13}','${IGASM0421Form.contractName13}','${IGASM0421Form.contractDesc13}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第14笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney14">
		<input type="hidden" id="act14" name="act14" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney14">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第十四笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday14}
			<html:hidden property="expectday14" name="IGASM0421Form" value="${IGASM0421Form.expectday14}"/>
			<input type="hidden" id="act14" name="act14" value="14">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday14">
			<html:text property="zhidanday14" styleId="zhidanday14" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday14'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday14">
			${IGASM0421Form.zhidanday14}
			<html:hidden property="zhidanday14" name="IGASM0421Form" value="${IGASM0421Form.zhidanday14}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday14">
			<html:text property="actualday14" styleId="actualday14" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday14'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday14">
			${IGASM0421Form.actualday14}
			<html:hidden property="actualday14" name="IGASM0421Form" value="${IGASM0421Form.actualday14}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday14">
			<html:text property="invoiceexplain14" styleId="invoiceexplain14" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday14">
			${IGASM0421Form.invoiceexplain14}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney14}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio14">
				<html:text property="yingfumoneyratio14" styleId="yingfumoneyratio14" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio14">
				${IGASM0421Form.yingfumoneyratio14}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney14">
			<html:text property="shifumoney14" styleId="shifumoney14" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney14'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney14'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney14">
			${IGASM0421Form.shifumoney14}
			<html:hidden property="shifumoney14" name="IGASM0421Form" value="${IGASM0421Form.shifumoney14}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId14}','${IGASM0421Form.contractLabel14}','${IGASM0421Form.contractName14}','${IGASM0421Form.contractDesc14}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId14}','${IGASM0421Form.contractLabel14}','${IGASM0421Form.contractName14}','${IGASM0421Form.contractDesc14}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
		
		
		<!-- 第15笔 -->
		<logic:empty name="IGASM0421Form" property="actualmoney15">
		<input type="hidden" id="act15" name="act15" value="0">
		</logic:empty>
		<logic:notEmpty name="IGASM0421Form" property="actualmoney15">
		<tr><td colspan="8">&nbsp;</td></tr>
		<tr>
			<th width="12%">第十五笔应付日：</th>
			<td width="8%">
			${IGASM0421Form.expectday15}
			<html:hidden property="expectday15" name="IGASM0421Form" value="${IGASM0421Form.expectday15}"/>
			<input type="hidden" id="act15" name="act15" value="15">
			</td>
			<th width="10%">制单日：</th>
			<td width="12%">
			<logic:empty name="IGASM0421Form" property="zhidanday15">
			<html:text property="zhidanday15" styleId="zhidanday15" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('zhidanday15'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="zhidanday15">
			${IGASM0421Form.zhidanday15}
			<html:hidden property="zhidanday15" name="IGASM0421Form" value="${IGASM0421Form.zhidanday15}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">实付日：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="actualday15">
			<html:text property="actualday15" styleId="actualday15" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/date.gif" onclick="calendar($('actualday15'))" border="0" style="cursor: hand" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday15">
			${IGASM0421Form.actualday15}
			<html:hidden property="actualday15" name="IGASM0421Form" value="${IGASM0421Form.actualday15}"/>
			</logic:notEmpty>
			</td>
			<th width="10%">发票说明：</th>
			<td>
			<logic:empty name="IGASM0421Form" property="actualday15">
			<html:text property="invoiceexplain15" styleId="invoiceexplain15" name="IGASM0421Form" size="35" errorStyleClass="inputError" styleClass="input1" />
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="actualday15">
			${IGASM0421Form.invoiceexplain15}
			</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<th width="12%">应付款额：</th>
			<td width="6%">
				${IGASM0421Form.actualmoney15}
			</td>
			<th width="10%">应付款比例：</th>
			<td width="8%">
				<logic:empty name="IGASM0421Form" property="yingfumoneyratio15">
				<html:text property="yingfumoneyratio15" styleId="yingfumoneyratio15" name="IGASM0421Form" size="10" errorStyleClass="inputError" styleClass="input1" />
				</logic:empty>
				<logic:notEmpty name="IGASM0421Form" property="yingfumoneyratio15">
				${IGASM0421Form.yingfumoneyratio15}
				</logic:notEmpty>
			</td>
			<th width="10%">实付款额：</th>
			<td width="15%">
			<logic:empty name="IGASM0421Form" property="shifumoney15">
			<html:text property="shifumoney15" styleId="shifumoney15" name="IGASM0421Form" errorStyleClass="inputError imeDisabled" size="8" readonly="true" />
			<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('shifumoney15'))" border="0" style="cursor: hand" />
			<a href="javascript:clear($('shifumoney15'));">清空</a>
			</logic:empty>
			<logic:notEmpty name="IGASM0421Form" property="shifumoney15">
			${IGASM0421Form.shifumoney15}
			<html:hidden property="shifumoney15" name="IGASM0421Form" value="${IGASM0421Form.shifumoney15}"/>
			</logic:notEmpty>
			</td>
			<td colspan="2">
				<logic:notEqual value="true" name="IGASM04211VO" property="image_flag">
					<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId15}','${IGASM0421Form.contractLabel15}','${IGASM0421Form.contractName15}','${IGASM0421Form.contractDesc15}','1');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="createImageXml('${IGASM0421Form.contractId15}','${IGASM0421Form.contractLabel15}','${IGASM0421Form.contractName15}','${IGASM0421Form.contractDesc15}','2');"/>
				</logic:notEqual>
			</td>
		</tr>
		</logic:notEmpty>
	</table>
	</div>
    <div class="enter">
    <logic:notEmpty name="IGASM0421Form" property="actualmoney1">
    <c:if test="${IGASM0421Form.btnFlag1==true||IGASM0421Form.btnFlag2==true||IGASM0421Form.btnFlag3==true
    	||IGASM0421Form.btnFlag4==true||IGASM0421Form.btnFlag5==true||IGASM0421Form.btnFlag6==true
    	||IGASM0421Form.btnFlag7==true||IGASM0421Form.btnFlag8==true||IGASM0421Form.btnFlag9==true
    	||IGASM0421Form.btnFlag10==true||IGASM0421Form.btnFlag11==true||IGASM0421Form.btnFlag12==true
    	||IGASM0421Form.btnFlag13==true||IGASM0421Form.btnFlag14==true||IGASM0421Form.btnFlag15==true}">
    <html:submit property="btn_insert" value="保存" styleClass="button" onclick="return checkForm();"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- 
    <html:button property="btn_insert" value="上传影像" styleClass="button" onclick="picu();"/>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="pics();"/>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 -->
	 </c:if>
	</logic:notEmpty>
	<html:button property="btn_back" value="返回" styleClass="button" onclick="toback()"/>
    </div>
    <html:hidden property="eiid" styleId="eiid" value="${IGASM0421Form.eiid}"/>
    <html:hidden property="eiversion" styleId="eiversion" value="${IGASM04211VO.entityItemCompactVWInfo.eiversion}"/>
    <html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGASM04211VO.entityItemCompactVWInfo.eiorgsyscoding}" />
	</html:form>
	</div>
    </div>
</div>


</div>
</body>
</html:html>