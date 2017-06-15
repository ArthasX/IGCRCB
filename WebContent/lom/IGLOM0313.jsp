<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0313" toScope="request" />
<bean:define id="title" value="还款登记画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		

		function confirmDisp(){
			
			var message = '<bean:message key="IGCO10000.W001" arg0="还款基本信息" />';
           
			if($("lpdactuser").value.trim() == ""){
    			alert("请输入还款人！");
    			return false;
    		}

    		if($("lpddate").value.trim() == ""){
    			alert("请选择还款日期！");
    			return false;
    		}

    		if($("lpdtype").value.trim() == ""){
    			alert("请选择还款方式！");
    			return false;
    		}

    		//发票还款
    		if($F("lpdtype") == "2"){

        		if($("lpdinvoiceamount").value.trim() == ""){
        			alert("请输入实际报销金额！");
        			return false;
        		}

        		if($("lpdactinvoice").value.trim() == ""){
        			alert("请输入发票面额！");
        			return false;
        		}

        		if($("lpdinvoiceamount").value == 0) {
					alert("实际报销金额不能等于0！");
					return false;
				}
				
        		if($("lpdactinvoice").value == 0) {
					alert("发票面额不能等于0！");
					return false;
				}

        		if(parseFloat($F('lpdinvoiceamount'),10) - parseFloat($F('lpdactinvoice'),10) > 0){
        			alert("实际报销金额不能大于发票面额！");
        			return false;
        		} 

    		}else{

        		//现金还款
        		if($F("lpdtype") == "1"){
        			
            		if($("lpdamount").value.trim() == ""){
            			alert("请输入还款现金金额！");
            			return false;
            		}

            		if($("lpdamount").value == 0) {
    					alert("还款现金金额不能等于0！");
    					return false;
    				}
            	}
    		}
	    	
	    	if($F('lpdactuser').strlen()>32){
	    		alert("还款人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
	    	if($F('lpdinvoicenum').strlen()>16){
	    		alert("发票号不能大于"+Math.floor(16/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
	    	if($F('lpdinvoicecor').strlen()>64){
	    		alert("发票单位不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
	    	if($F('lpdinvoicecomment').strlen()>256){
	    		alert("实际用途说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}

			if( window.confirm(message)){
	            form.action = getAppRootUrl() + "/IGLOM0313_Insert.do";
				form.submit();
				return true;
			} else {
				return false;
			}
		}
		
		function setTypeDiv(){
	
		
			<c:if test="${IGLOM03131VO.loanPayDetailData.lpdstatus == '0'}"> 
			$('lpdactuser').value = $('lpduser').value;
			if($F('lpdtype') == '2'){
				$('type').style.display = "";
				$('type1').style.display = "none";
				$('lpdamount').value = "0.00";
			} else {
				$('type').style.display = "none";
				$('type1').style.display = "";
				$('lpdamount').value = "0.00";
			}
			$('lpdinvoicenum').value = "";
			$('lpdinvoicedate').value = "";
			$('lpdinvoiceamount').value = "0.00";
			$('lpdactinvoice').value = "0.00";
			$('lpdinvoicecor').value = "";
			$('lpdinvoicecomment').value = "";
			</c:if>
		}

        
	    function payAmount(amount, lpdamount, lpdinvoiceamount){
	    	if($('lpdamount').value == ""){
	    		$('lpdamount').value = "0.00";
		    }
	    	if($('lpdinvoiceamount').value == ""){
	    		$('lpdinvoiceamount').value = "0.00";
		    }
	    	if($('lpdactinvoice').value == ""){
	    		$('lpdactinvoice').value = "0.00";
		    }

	    	if(parseFloat((parseFloat(lpdamount,10) + parseFloat(lpdinvoiceamount,10)),10).toFixed(2)- parseFloat(amount,10).toFixed(2) < 0){
		    	var i = parseFloat(amount,10).toFixed(2) - parseFloat((parseFloat(lpdamount,10) + parseFloat(lpdinvoiceamount,10)),10).toFixed(2);

		    	if(window.confirm("还款总金额不能小于借款金额,是否还现金" + i + "！")){
		    		 form.action = getAppRootUrl() + "/IGLOM0313_Change.do";
					 form.submit();
				     return true;
		    	}else{
					 return false;
			    }
//				alert("还款总金额不能小于借款金额,是否还现金" + i + "！");
//				return false;
			}
		    if(parseFloat(lpdinvoiceamount,10).toFixed(2) - parseFloat(amount,10).toFixed(2) > 0 && parseFloat(lpdamount,10) > 0){
				alert("还款发票金额大于借款金额，不能现金还款！");
				return false;
			}
		    if(parseFloat(amount,10).toFixed(2) !=  parseFloat((parseFloat(lpdamount,10) + parseFloat(lpdinvoiceamount,10)),10).toFixed(2) && parseFloat(lpdamount,10) > 0){
				alert("还款总金额不等于借款金额，不能还款！");
				return false;
			}

			var money = parseFloat(lpdamount,10) + parseFloat(lpdinvoiceamount,10) - parseFloat(amount,10);
			if(money > 0){
				 if(window.confirm("还款总金额大于借款金额,是否同意从本月余额中扣除"+ parseFloat(money,10).toFixed(2) + "返还现金？确认后不能继续还款")){
					form.action = getAppRootUrl() + "/IGLOM0313_Change.do";
					form.submit();
			         return true;
				 } else {
					 return false;
				 }
			}else{

		        if( window.confirm("请确认是否要进行还款确认处理？确认后不能继续还款")){
		            form.action = getAppRootUrl() + "/IGLOM0313_Change.do";
					form.submit();
		            return true;
		        } else {
		            return false;
		        }

			}
	        
		}
		
		 function changeStatus(lpdid){
		    	if($('lpdamount').value == ""){
		    		$('lpdamount').value = "0.00";
			    }
		    	if($('lpdinvoiceamount').value == ""){
		    		$('lpdinvoiceamount').value = "0.00";
			    }
		    	if($('lpdactinvoice').value == ""){
		    		$('lpdactinvoice').value = "0.00";
			    }
				if(confirm("是否删除当前还款信息？")){
					var form = document.getElementById("form");
					form.action="IGLOM0313_Delete.do?lpdid="+lpdid;
					form.submit();
				}
		 }
	    

		 function checkFloatNumFor0313(obj,name,mess){
		 	if(obj.value!=""){
		 		if(isNaN(obj.value)){
		 			alert(mess);
		 			obj.value = "0.00";
		 			obj.focus();
		 			event.returnValue = false;
		 		}else if(!checkFloatNumber(obj.value)){
		 			alert(name);
		 			obj.value = "0.00";
		 			obj.focus();
		 			event.returnValue = false;
		 		}
		 	}
		 }
	</script>
<body onload="setTypeDiv();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">后勤管理 &gt;&gt;预支管理 &gt;&gt;还款管理 &gt;&gt;还款登记</p>
                <div class="back"><a href="IGLOM0306_Back.do" target="_self">返回</a></div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0313" onsubmit="return checkSubmit(this);">

			    <div class="title">
			        <div class="name">借款信息</div>
			    </div>
			    <div id="results_list">
			        <table width="100%" class="table_style">
			            <tr>
			                <th width="10%" >借款人</th>
			                <th width="15%" >借款人机构</th>
			                <th width="8%" >借款日期</th>
			                <th width="13%" >借款金额</th>
			                <th width="13%" >已还现金金额</th>
			                <th width="13%" >已还发票金额</th>
			                <th width="28%" >用途</th>
			            </tr>
			            <tr>
			               <td align="center">${IGLOM03131VO.loanPayDetailData.lpduser}</td>
			               <td align="center">${IGLOM03131VO.loanPayDetailData.organizationTB.orgname}</td>
			               <td align="center">${IGLOM03131VO.loanPayDetailData.lpddate}</td>
			               <td align="center">${IGLOM03131VO.loanPayDetailData.lpdamount}</td>
			               <td align="center">${IGLOM03131VO.db[0]}</td>
			               <td align="center">${IGLOM03131VO.db[1]}</td>
			               <td align="center">${IGLOM03131VO.loanPayDetailData.lpdcomment}</td>
			            </tr>
			        </table>
		        </div>
		        
		        
				<div class="title">
				   <div class="name">还款信息</div>
				</div>  
          		
                <div id="results_list">     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="10%">还款日期</th>
					           <th width="10%">还款方式</th>
					           <th width="15%">还款现金金额</th>
					           <th width="10%">发票号</th>
					           <th width="10%">发票日期</th>
					           <th width="20%">发票单位</th>
					           <th width="10%">实际报销金额</th>
					           <th width="10%">发票面额</th>
					           <th width="5%"></th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM03131VO" property="loanPayDetailList" >
			                    <logic:iterate id="bean" name="IGLOM03131VO" property="loanPayDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            
			                            <!-- 还款日期 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.lpddate}</div>
			                            </td>
			                            <!--还款方式 -->
		                            	<td>
                                           	<div class="nowrapDiv">
                                           		<ig:cseCodeValue codeIndex="<%=CodeUtils.LOANPAYDETAIL_LPDTYPE%>" codeValue="${bean.lpdtype}" />
                                           	</div>
                                       	</td>
			                            <!-- 还款现金金额 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.lpdamount}</div>
			                            </td>
			                            <!-- 发票号 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.lpdinvoicenum}</div>
			                            </td>
			                            <!-- 发票日期 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdinvoicedate}</div>
			                            </td>
			                            <!-- 发票单位 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdinvoicecor}</div>
			                            </td>
			                            <!-- 实际报销金额 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdinvoiceamount}</div>
			                            </td>
			                            <!-- 发票面额 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdactinvoice}</div>
			                            </td>
				                            <!-- 删除 -->
			                            <td>
		                            		<c:if test="${IGLOM03131VO.loanPayDetailData.lpdstatus == '0'}">
			                            	<a href="javascript:changeStatus('${bean.lpdid}');"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></a>
		                            		</c:if>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     
              		
		        <c:if test="${IGLOM03131VO.loanPayDetailData.lpdstatus == '0'}">  			
				<div align="right">
			    	<html:button property="btn_pay" value="还款确认" styleClass="button" onclick="payAmount(${IGLOM03131VO.loanPayDetailData.lpdamount},${IGLOM03131VO.db[0]},${IGLOM03131VO.db[1]});"/>
				</div>
				</c:if> 
					<!--  message -->
					<ig:message/>
					<!--  /message -->
		          
		        <c:if test="${IGLOM03131VO.loanPayDetailData.lpdstatus == '0'}"> 
               	<fieldset>
					    <legend> 还款信息</legend> 
						<div>
							<label for="Name"><strong><span class="red">*</span>还款人</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpdactuser" styleId="lpdactuser" size="15" tabindex="2" errorStyleClass="inputError imeActive" /> 
							<br>
						</div>
						<div>
							<label for="Name"><strong><span class="red">*</span>还款日期</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpddate" styleId="lpddate" size="15" tabindex="2" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" /> 
							<br>
						</div>
                        <div>
							<label for="Name"><strong><span class="red">*</span>还款方式</strong>：</label>
							<span> 
								<html:select name="IGLOM0313Form" property="lpdtype" style="width: 100px;" tabindex="3" errorStyleClass="inputError imeActive" onchange="setTypeDiv()">
								<html:options collection="ADloanpaydetail_lpdtype" property="value" name="" labelProperty="label" /></html:select>
							</span>
							<br>
    					</div>
						<div id="type" style="display:none">
							<label for="Name"><strong>发票号</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpdinvoicenum" styleId="lpdinvoicenum" tabindex="6" size="20" errorStyleClass="inputError imeActive" />
							<br/>
							<label for="Name"><strong>发票日期</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpdinvoicedate" styleId="lpdinvoicedate" tabindex="7" size="15" errorStyleClass="inputError imeActive" readonly="true" />
							<img src="images/date.gif" align="middle" onClick="calendar($('lpdinvoicedate'))" border="0" />
							<br/>
							<label for="Name"><strong><span class="red">*</span>实际报销金额</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpdinvoiceamount" styleId="lpdinvoiceamount" tabindex="8" size="20" errorStyleClass="inputError imeActive" onblur="checkFloatNumFor0313(this,'实际报销金额整数部分最大为10位，小数部分为2位！','请输入数字！');"/>
							<br/>
							<label for="Name"><strong><span class="red">*</span>发票面额</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpdactinvoice" styleId="lpdactinvoice" tabindex="9" size="20" errorStyleClass="inputError imeActive" onblur="checkFloatNumFor0313(this,'发票面额整数部分最大为10位，小数部分为2位！','请输入数字！');"/>
							<br/>
							<label for="Name"><strong>发票单位</strong>：</label>
							<html:text name="IGLOM0313Form" property="lpdinvoicecor" styleId="lpdinvoicecor" tabindex="10" size="20" errorStyleClass="inputError imeActive" />
							<br/>
						</div>
	   					<div id="type1">
	             			<label for="Name"><strong><span class="red">*</span>还款现金金额</strong>：</label>
	             			<html:text property="lpdamount" name="IGLOM0313Form"  size="20" tabindex="4" errorStyleClass="inputError" onblur="checkFloatNumFor0313(this,'还款现金金额整数部分最大为10位，小数部分为2位！','请输入数字！');"/>
	             		</div>
			            <div>
			                <label for="Name"><strong>实际用途说明</strong>：</label>
           					<html:textarea property="lpdinvoicecomment" styleId="lpdinvoicecomment" errorStyleClass="inputError" rows="6" cols="60"/>
			                <br>
			            </div>
              		            	
               	</fieldset>
              		  			
				<div class="enter">
			    	<html:button property="btn_insert" value="保存" styleClass="button" onclick="confirmDisp();"/>
				</div>
				</c:if>
		    	<html:hidden property="lpduser" name="IGLOM0313Form"/> 
			    <html:hidden property="ldid" name="IGLOM0313Form"/>
			    <html:hidden property="lpduserorg" name="IGLOM0313Form" value="${IGLOM03131VO.loanPayDetailData.lpduserorg}"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>