<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGASM0404" toScope="request" />
<bean:define id="title" value="合同配置信息编辑画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	var gid='IGASM0404';
	var showCount = 0;
	var proCount ='';
	WebCalendar.timeShow   = false;          //是否返回时间

	function addent(){
		if(showCount==0){
			alert("已达到最大付款笔数");
		}
		if(showCount==1){
			showCount-=1;
			document.getElementById("LABEL_IG_0254").style.display='';
			document.getElementById("LABEL_IG_0255").style.display='';
			document.getElementById("LABEL_IG_0256").style.display='';
			document.getElementById("LABEL_IG_0257").style.display='';
			document.getElementById("LABEL_IG_0258").style.display='';
			document.getElementById("LABEL_IG_0259").style.display='';
			document.getElementById("LABEL_IG_0260").style.display='';
		}
		if(showCount==2){
			showCount-=1;
			document.getElementById("LABEL_IG_0247").style.display='';
			document.getElementById("LABEL_IG_0248").style.display='';
			document.getElementById("LABEL_IG_0249").style.display='';
			document.getElementById("LABEL_IG_0250").style.display='';
			document.getElementById("LABEL_IG_0251").style.display='';
			document.getElementById("LABEL_IG_0252").style.display='';
			document.getElementById("LABEL_IG_0253").style.display='';
		}
		if(showCount==3){
			showCount-=1;
			document.getElementById("LABEL_IG_0240").style.display='';
			document.getElementById("LABEL_IG_0241").style.display='';
			document.getElementById("LABEL_IG_0242").style.display='';
			document.getElementById("LABEL_IG_0243").style.display='';
			document.getElementById("LABEL_IG_0244").style.display='';
			document.getElementById("LABEL_IG_0245").style.display='';
			document.getElementById("LABEL_IG_0246").style.display='';
		}
		if(showCount==4){
			showCount-=1;
			document.getElementById("LABEL_IG_0233").style.display='';
			document.getElementById("LABEL_IG_0234").style.display='';
			document.getElementById("LABEL_IG_0235").style.display='';
			document.getElementById("LABEL_IG_0236").style.display='';
			document.getElementById("LABEL_IG_0237").style.display='';
			document.getElementById("LABEL_IG_0238").style.display='';
			document.getElementById("LABEL_IG_0239").style.display='';
		}
		if(showCount==5){
			showCount-=1;
			document.getElementById("LABEL_IG_0226").style.display='';
			document.getElementById("LABEL_IG_0227").style.display='';
			document.getElementById("LABEL_IG_0228").style.display='';
			document.getElementById("LABEL_IG_0229").style.display='';
			document.getElementById("LABEL_IG_0230").style.display='';
			document.getElementById("LABEL_IG_0231").style.display='';
			document.getElementById("LABEL_IG_0232").style.display='';
		}
		if(showCount==6){
			showCount-=1;
			document.getElementById("LABEL_IG_0219").style.display='';
			document.getElementById("LABEL_IG_0220").style.display='';
			document.getElementById("LABEL_IG_0221").style.display='';
			document.getElementById("LABEL_IG_0222").style.display='';
			document.getElementById("LABEL_IG_0223").style.display='';
			document.getElementById("LABEL_IG_0224").style.display='';
			document.getElementById("LABEL_IG_0225").style.display='';
		}
		if(showCount==7){
			showCount-=1;
			document.getElementById("LABEL_IG_0212").style.display='';
			document.getElementById("LABEL_IG_0213").style.display='';
			document.getElementById("LABEL_IG_0214").style.display='';
			document.getElementById("LABEL_IG_0215").style.display='';
			document.getElementById("LABEL_IG_0216").style.display='';
			document.getElementById("LABEL_IG_0217").style.display='';
			document.getElementById("LABEL_IG_0218").style.display='';
		}
		if(showCount==8){
			showCount-=1;
			document.getElementById("LABEL_IG_0205").style.display='';
			document.getElementById("LABEL_IG_0206").style.display='';
			document.getElementById("LABEL_IG_0207").style.display='';
			document.getElementById("LABEL_IG_0208").style.display='';
			document.getElementById("LABEL_IG_0209").style.display='';
			document.getElementById("LABEL_IG_0210").style.display='';
			document.getElementById("LABEL_IG_0211").style.display='';
		}
		if(showCount==9){
			showCount-=1;
			document.getElementById("LABEL_IG_0198").style.display='';
			document.getElementById("LABEL_IG_0199").style.display='';
			document.getElementById("LABEL_IG_0200").style.display='';
			document.getElementById("LABEL_IG_0201").style.display='';
			document.getElementById("LABEL_IG_0202").style.display='';
			document.getElementById("LABEL_IG_0203").style.display='';
			document.getElementById("LABEL_IG_0204").style.display='';
		}
		if(showCount==10){
			showCount-=1;
			document.getElementById("LABEL_IG_0191").style.display='';
			document.getElementById("LABEL_IG_0192").style.display='';
			document.getElementById("LABEL_IG_0193").style.display='';
			document.getElementById("LABEL_IG_0194").style.display='';
			document.getElementById("LABEL_IG_0195").style.display='';
			document.getElementById("LABEL_IG_0196").style.display='';
			document.getElementById("LABEL_IG_0197").style.display='';
		}
		if(showCount==11){
			showCount-=1;
			document.getElementById("LABEL_IG_0133").style.display='';
			document.getElementById("LABEL_IG_0134").style.display='';
			document.getElementById("LABEL_IG_0135").style.display='';
			document.getElementById("LABEL_IG_0136").style.display='';
			document.getElementById("LABEL_IG_0170").style.display='';
			document.getElementById("LABEL_IG_0157").style.display='';
			document.getElementById("LABEL_IG_0162").style.display='';
		}
		if(showCount==12){
			showCount-=1;
			document.getElementById("LABEL_IG_0129").style.display='';
			document.getElementById("LABEL_IG_0130").style.display='';
			document.getElementById("LABEL_IG_0131").style.display='';
			document.getElementById("LABEL_IG_0132").style.display='';
			document.getElementById("LABEL_IG_0169").style.display='';
			document.getElementById("LABEL_IG_0156").style.display='';
			document.getElementById("LABEL_IG_0161").style.display='';
		}
		if(showCount==13){
			showCount-=1;
			document.getElementById("LABEL_IG_0125").style.display='';
			document.getElementById("LABEL_IG_0126").style.display='';
			document.getElementById("LABEL_IG_0127").style.display='';
			document.getElementById("LABEL_IG_0128").style.display='';
			document.getElementById("LABEL_IG_0168").style.display='';
			document.getElementById("LABEL_IG_0155").style.display='';
			document.getElementById("LABEL_IG_0160").style.display='';
		}
		if(showCount==14){
			showCount-=1;
			document.getElementById("LABEL_IG_0121").style.display='';
			document.getElementById("LABEL_IG_0122").style.display='';
			document.getElementById("LABEL_IG_0123").style.display='';
			document.getElementById("LABEL_IG_0124").style.display='';
			document.getElementById("LABEL_IG_0167").style.display='';
			document.getElementById("LABEL_IG_0154").style.display='';
			document.getElementById("LABEL_IG_0159").style.display='';
		}
	}
	
	function goback(){
			location.href="IGASM0401_Back.do";
	}

	var pay1=0;//第1笔付款额
	var pay2=0;//第2笔付款额
	var pay3=0;//第3笔付款额
	var pay4=0;//第4笔付款额
	var pay5=0;//第5笔付款额
	var pay6=0;//第6笔付款额
	var pay7=0;//第7笔付款额
	var pay8=0;//第8笔付款额
	var pay9=0;//第9笔付款额
	var pay10=0;//第10笔付款额
	var pay11=0;//第11笔付款额
	var pay12=0;//第12笔付款额
	var pay13=0;//第13笔付款额
	var pay14=0;//第14笔付款额
	var pay15=0;//第15笔付款额

	var payed1=0;//第1笔实付款额
	var payed2=0;//第2笔实付款额
	var payed3=0;//第3笔实付款额
	var payed4=0;//第4笔实付款额
	var payed5=0;//第5笔实付款额
	var payed6=0;//第6笔实付款额
	var payed7=0;//第7笔实付款额
	var payed8=0;//第8笔实付款额
	var payed9=0;//第9笔实付款额
	var payed10=0;//第10笔实付款额
	var payed11=0;//第11笔实付款额
	var payed12=0;//第12笔实付款额
	var payed13=0;//第13笔实付款额
	var payed14=0;//第14笔实付款额
	var payed15=0;//第15笔实付款额

	var yfdate1;//第1笔应付日
	var yfdate2;//第2笔应付日
	var yfdate3;//第3笔应付日
	var yfdate4;//第4笔应付日
	var yfdate5;//第5笔应付日
	var yfdate6;//第6笔应付日
	var yfdate7;//第7笔应付日
	var yfdate8;//第8笔应付日
	var yfdate9;//第9笔应付日
	var yfdate10;//第10笔应付日
	var yfdate11;//第11笔应付日
	var yfdate12;//第12笔应付日
	var yfdate13;//第13笔应付日
	var yfdate14;//第14笔应付日
	var yfdate15;//第15笔应付日

	var sfdate1;//第1笔实付日
	var sfdate2;//第2笔实付日
	var sfdate3;//第3笔实付日
	var sfdate4;//第4笔实付日
	var sfdate5;//第5笔实付日
	var sfdate6;//第6笔实付日
	var sfdate7;//第7笔实付日
	var sfdate8;//第8笔实付日
	var sfdate9;//第9笔实付日
	var sfdate10;//第10笔实付日
	var sfdate11;//第11笔实付日
	var sfdate12;//第12笔实付日
	var sfdate13;//第13笔实付日
	var sfdate14;//第14笔实付日
	var sfdate15;//第15笔实付日
	
	function confirmDisp(ident){

		var total=0;//合同总价款
		var pay=0;//应付款总额
		var payed=0;//已付款
		
		var lastpayday="";//最后付款日
		
		var message1 = '<bean:message key="IGCO10000.W003" arg0="合同配置信息" />';
		
		<logic:present name="IGASM04041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM04041VO" property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<logic:iterate id="bean" name="list" indexId="index">
					<logic:equal name="bean" property="cattach" value="1">
						<logic:equal value="1" name="bean" property="crequired">
							<logic:equal value="" name="bean" property="civalue">
							if($F('attachFile[${ADcheckCount}]').trim() == ""){
								alert("请输入${bean.cname}！");
								return false;
							} 
							</logic:equal>
						</logic:equal>
					</logic:equal>
					<logic:equal name="bean" property="cattach" value="5">
						var flag = false;
						var submitValue = "";
						var check=document.getElementsByName("cb_civalue[${ADcheckCount}]");
						<logic:equal value="1" name="bean" property="crequired">
							for(var i=0;i<check.length;i++){
								if(check[i].checked==true){
									if(submitValue != ""){
										submitValue = submitValue + "；" + check[i].value;
									} else {
										submitValue = check[i].value;
									}
									flag = true;
								}
							}
							if(submitValue.strlen()>128){
								alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
								submitValue = "";
								return false;
							}
							if(flag){
								document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
							} else {
								alert("请选择${bean.cname}！");
								return false;
							}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
							var flag = false;
							for(var i=0;i<check.length;i++){
								if(check[i].checked==true){
									if(submitValue != ""){
										submitValue = submitValue + "；" + check[i].value;
									} else {
										submitValue = check[i].value;
									}
									flag = true;
								}
							}
							if(submitValue.strlen()>128){
								alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
								submitValue = "";
								return false;
							}
							if(flag){
								document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
							} else {
								document.getElementById("civalue[${ADcheckCount}]").value = "";
							}
						</logic:notEqual>
					</logic:equal>
					<logic:notEqual name="bean" property="cattach" value="1">
					<logic:notEqual name="bean" property="cattach" value="5">
					<logic:notEqual name="bean" property="cattach" value="6">

						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert("请输入${bean.cname}！");
							return false;
						}
						if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
							alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
							alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:notEqual>

						var val=Number($F('civalue[${ADcheckCount}]'))
						//合同总价款
						<logic:equal value="IG_0116" name="bean" property="clabel">
							total=val;
						</logic:equal>
						//第1笔应付款额
						<logic:equal value="IG_0117" name="bean" property="clabel">
							pay+=val;
							pay1=val;
						</logic:equal>
						//第2笔应付款额
						<logic:equal value="IG_0121" name="bean" property="clabel">
							pay+=val;
							pay2=val;
						</logic:equal>
						//第3笔应付款额
						<logic:equal value="IG_0125" name="bean" property="clabel">
							pay3=val;
							if(pay2==0&&pay3!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第4笔应付款额
						<logic:equal value="IG_0129" name="bean" property="clabel">
							pay4=val;
							if(pay3==0&&pay4!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第5笔应付款额
						<logic:equal value="IG_0133" name="bean" property="clabel">
							pay5=val;
							if(pay4==0&&pay5!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第6笔应付款额
						<logic:equal value="IG_0191" name="bean" property="clabel">
							pay6=val;
							if(pay5==0&&pay6!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第7笔应付款额
						<logic:equal value="IG_0198" name="bean" property="clabel">
							pay7=val;
							if(pay6==0&&pay7!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第8笔应付款额
						<logic:equal value="IG_0205" name="bean" property="clabel">
							pay8=val;
							if(pay7==0&&pay8!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第9笔应付款额
						<logic:equal value="IG_0212" name="bean" property="clabel">
							pay9=val;
							if(pay8==0&&pay9!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第10笔应付款额
						<logic:equal value="IG_0219" name="bean" property="clabel">
							pay10=val;
							if(pay9==0&&pay10!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第11笔应付款额
						<logic:equal value="IG_0226" name="bean" property="clabel">
							pay11=val;
							if(pay10==0&&pay11!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第12笔应付款额
						<logic:equal value="IG_0233" name="bean" property="clabel">
							pay12=val;
							if(pay11==0&&pay12!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第13笔应付款额
						<logic:equal value="IG_0240" name="bean" property="clabel">
							pay13=val;
							if(pay12==0&&pay13!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第14笔应付款额
						<logic:equal value="IG_0247" name="bean" property="clabel">
							pay14=val;
							if(pay13==0&&pay14!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>
						//第15笔应付款额
						<logic:equal value="IG_0254" name="bean" property="clabel">
							pay15=val;
							if(pay14==0&&pay15!=0){
								alert("不能进行跳笔付款，请先进行上一笔付款！");
								return false;
							}
							pay+=val;
						</logic:equal>	
						
						//第1笔实付款额
						<logic:equal value="IG_0153" name="bean" property="clabel">
							payed1=val;
						</logic:equal>
						//第2笔实付款额
						<logic:equal value="IG_0154" name="bean" property="clabel">
							payed2=val;
							if(pay2==0){
								payed2=0;
							}
						</logic:equal>
						//第3笔实付款额
						<logic:equal value="IG_0155" name="bean" property="clabel">
							payed3=val;
							if(pay3==0){
								payed3=0;
							}
						</logic:equal>
						//第4笔实付款额
						<logic:equal value="IG_0156" name="bean" property="clabel">
							payed4=val;
							if(pay4==0){
								payed4=0;
							}
						</logic:equal>
						//第5笔实付款额
						<logic:equal value="IG_0157" name="bean" property="clabel">
							payed5=val;
							if(pay5==0){
								payed5=0;
							}
						</logic:equal>
						//第6笔实付款额
						<logic:equal value="IG_0193" name="bean" property="clabel">
							payed6=val;
							if(pay6==0){
								payed6=0;
							}
						</logic:equal>
						//第7笔实付款额
						<logic:equal value="IG_0200" name="bean" property="clabel">
							payed7=val;
							if(pay7==0){
								payed7=0;
							}
						</logic:equal>
						//第8笔实付款额
						<logic:equal value="IG_0207" name="bean" property="clabel">
							payed8=val;
							if(pay8==0){
								payed8=0;
							}
						</logic:equal>
						//第9笔实付款额
						<logic:equal value="IG_0214" name="bean" property="clabel">
							payed9=val;
							if(pay9==0){
								payed9=0;
							}
						</logic:equal>
						//第10笔实付款额
						<logic:equal value="IG_0221" name="bean" property="clabel">
							payed10=val;
							if(pay10==0){
								payed10=0;
							}
						</logic:equal>
						//第11笔实付款额
						<logic:equal value="IG_0228" name="bean" property="clabel">
							payed11=val;
							if(pay11==0){
								payed11=0;
							}
						</logic:equal>
						//第12笔实付款额
						<logic:equal value="IG_0235" name="bean" property="clabel">
							payed12=val;
							if(pay12==0){
								payed12=0;
							}
						</logic:equal>
						//第13笔实付款额
						<logic:equal value="IG_0242" name="bean" property="clabel">
							payed13=val;
							if(pay13==0){
								payed13=0;
							}
						</logic:equal>
						//第14笔实付款额
						<logic:equal value="IG_0249" name="bean" property="clabel">
							payed14=val;
							if(pay14==0){
								payed14=0;
							}
						</logic:equal>
						//第15笔实付款额
						<logic:equal value="IG_0256" name="bean" property="clabel">
							payed15=val;
							if(pay15==0){
								payed15=0;
							}
						</logic:equal>

						var val=$F('civalue[${ADcheckCount}]');
						//第1笔应付日
						<logic:equal value="IG_0118" name="bean" property="clabel">
							yfdate1=val;
						</logic:equal>
						//第1笔实付日
						<logic:equal value="IG_0119" name="bean" property="clabel">
							sfdate1=val;
							if(sfdate1){
								//if(sfdate1<yfdate1){
									//alert("第一笔实付日不能早于应付日！");
									//return false;
								//}
								lastpayday=sfdate1;
							}else{
								payed1=0;
							}
						</logic:equal>
						//第2笔应付日
						<logic:equal value="IG_0122" name="bean" property="clabel">
							yfdate2=val;
						</logic:equal>
						//第2笔实付日
						<logic:equal value="IG_0123" name="bean" property="clabel">
							sfdate2=val;
							if(sfdate2){
								if(yfdate2==""||pay2==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								//if(sfdate2<yfdate2){
									//alert("第二笔实付日不能早于应付日！");
									//return false;
								//}
								lastpayday=sfdate2;
							}else{
								payed2=0;
							}
							
						</logic:equal>
						//第3笔应付日
						<logic:equal value="IG_0126" name="bean" property="clabel">
							yfdate3=val;
						</logic:equal>
						//第3笔实付日
						<logic:equal value="IG_0127" name="bean" property="clabel">
							sfdate3=val;
							if(sfdate3){
								if(yfdate3==""||pay3==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								//if(sfdate3<yfdate3){
									//alert("第三笔实付日不能早于应付日！");
									//return false;
								//}
								lastpayday=sfdate3;
							}else{
								payed3=0;
							}
						</logic:equal>
						//第4笔应付日
						<logic:equal value="IG_0130" name="bean" property="clabel">
							yfdate4=val;
						</logic:equal>
						//第4笔实付日
						<logic:equal value="IG_0131" name="bean" property="clabel">
							sfdate4=val;
							if(sfdate4){
								if(yfdate4==""||pay4==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								//if(sfdate4<yfdate4){
									//alert("第四笔实付日不能早于应付日！");
									//return false;
								//}
								lastpayday=sfdate4;
							}else{
								payed4=0;
							}
						</logic:equal>
						//第5笔应付日
						<logic:equal value="IG_0134" name="bean" property="clabel">
							yfdate5=val;
						</logic:equal>
						//第5笔实付日
						<logic:equal value="IG_0135" name="bean" property="clabel">
							sfdate5=val;
							if(sfdate5){
								if(yfdate5==""||pay5==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								//if(sfdate5<yfdate5){
									//alert("第五笔实付日不能早于应付日！");
									//return false;
								//}
								lastpayday=sfdate5;
							}else{
								payed5=0;
							}
						</logic:equal>
						//第6笔应付日
						<logic:equal value="IG_0194" name="bean" property="clabel">
							yfdate6=val;
						</logic:equal>
						//第6笔实付日
						<logic:equal value="IG_0196" name="bean" property="clabel">
							sfdate6=val;
							if(sfdate6){
								if(yfdate6==""||pay6==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate6;
							}else{
								payed6=0;
							}
						</logic:equal>
						//第7笔应付日
						<logic:equal value="IG_0201" name="bean" property="clabel">
							yfdate7=val;
						</logic:equal>
						//第7笔实付日
						<logic:equal value="IG_0203" name="bean" property="clabel">
							sfdate7=val;
							if(sfdate7){
								if(yfdate7==""||pay7==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate7;
							}else{
								payed7=0;
							}
						</logic:equal>
						//第8笔应付日
						<logic:equal value="IG_0208" name="bean" property="clabel">
							yfdate8=val;
						</logic:equal>
						//第8笔实付日
						<logic:equal value="IG_0210" name="bean" property="clabel">
							sfdate8=val;
							if(sfdate8){
								if(yfdate8==""||pay8==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate8;
							}else{
								payed8=0;
							}
						</logic:equal>
						//第9笔应付日
						<logic:equal value="IG_0215" name="bean" property="clabel">
							yfdate9=val;
						</logic:equal>
						//第9笔实付日
						<logic:equal value="IG_0217" name="bean" property="clabel">
							sfdate9=val;
							if(sfdate9){
								if(yfdate9==""||pay9==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate9;
							}else{
								payed9=0;
							}
						</logic:equal>
						//第10笔应付日
						<logic:equal value="IG_0222" name="bean" property="clabel">
							yfdate10=val;
						</logic:equal>
						//第10笔实付日
						<logic:equal value="IG_0224" name="bean" property="clabel">
							sfdate10=val;
							if(sfdate10){
								if(yfdate10==""||pay10==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate10;
							}else{
								payed10=0;
							}
						</logic:equal>
						//第11笔应付日
						<logic:equal value="IG_0229" name="bean" property="clabel">
							yfdate11=val;
						</logic:equal>
						//第11笔实付日
						<logic:equal value="IG_0231" name="bean" property="clabel">
							sfdate11=val;
							if(sfdate11){
								if(yfdate11==""||pay11==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate11;
							}else{
								payed11=0;
							}
						</logic:equal>
						//第12笔应付日
						<logic:equal value="IG_0236" name="bean" property="clabel">
							yfdate12=val;
						</logic:equal>
						//第12笔实付日
						<logic:equal value="IG_0238" name="bean" property="clabel">
							sfdate12=val;
							if(sfdate12){
								if(yfdate12==""||pay12==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate12;
							}else{
								payed12=0;
							}
						</logic:equal>
						//第13笔应付日
						<logic:equal value="IG_0243" name="bean" property="clabel">
							yfdate13=val;
						</logic:equal>
						//第13笔实付日
						<logic:equal value="IG_0245" name="bean" property="clabel">
							sfdate13=val;
							if(sfdate13){
								if(yfdate13==""||pay13==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate13;
							}else{
								payed13=0;
							}
						</logic:equal>
						//第14笔应付日
						<logic:equal value="IG_0250" name="bean" property="clabel">
							yfdate14=val;
						</logic:equal>
						//第14笔实付日
						<logic:equal value="IG_0252" name="bean" property="clabel">
							sfdate14=val;
							if(sfdate14){
								if(yfdate14==""||pay14==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate14;
							}else{
								payed14=0;
							}
						</logic:equal>
						//第15笔应付日
						<logic:equal value="IG_0257" name="bean" property="clabel">
							yfdate15=val;
						</logic:equal>
						//第15笔实付日
						<logic:equal value="IG_0259" name="bean" property="clabel">
							sfdate15=val;
							if(sfdate15){
								if(yfdate15==""||pay15==""){
									alert("有实付日时，付款额及应付日不能为空！");
									return false;
								}
								lastpayday=sfdate15;
							}else{
								payed15=0;
							}
						</logic:equal>
						
					</logic:notEqual>

					<logic:equal name="bean" property="cattach" value="6">
						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert("请输入${bean.cname}！");
							return false;
						}
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
							alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
							alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:notEqual>
					</logic:equal>
					<logic:equal name="bean" property="cattach" value="7">
						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert("请输入${bean.cname}！");
							return false;
						}
						
						if(checkFloatNum($F('civalue[${ADcheckCount}]').trim())){
							alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if(checkFloatNum($F('civalue[${ADcheckCount}]').trim())){
							alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
							return false;
						}
						</logic:notEqual>

					</logic:equal>
					</logic:notEqual>
					</logic:notEqual>
					<c:set var="ADcheckCount" value="${ADcheckCount+1}"/>
				</logic:iterate>
			</logic:iterate>
		</logic:present>
		
		if(total!=pay){
			alert("合同总价款必须等于各笔付款额之和");
			total=0;
			pay=0;
			return false;
		}

		if(pay2!=0&&yfdate2==""){
			alert("第二笔应付日不能为空！");
			return false;
		}
		if(pay3!=0&&yfdate3==""){
			alert("第三笔应付日不能为空！");
			return false;
		}
		if(pay4!=0&&yfdate4==""){
			alert("第四笔应付日不能为空！");
			return false;
		}
		if(pay5!=0&&yfdate5==""){
			alert("第五笔应付日不能为空！");
			return false;
		}
		if(pay6!=0&&yfdate6==""){
			alert("第六笔应付日不能为空！");
			return false;
		}
		if(pay7!=0&&yfdate7==""){
			alert("第七笔应付日不能为空！");
			return false;
		}
		if(pay8!=0&&yfdate8==""){
			alert("第八笔应付日不能为空！");
			return false;
		}
		if(pay9!=0&&yfdate9==""){
			alert("第九笔应付日不能为空！");
			return false;
		}
		if(pay10!=0&&yfdate10==""){
			alert("第十笔应付日不能为空！");
			return false;
		}
		if(pay11!=0&&yfdate11==""){
			alert("第十一笔应付日不能为空！");
			return false;
		}
		if(pay12!=0&&yfdate12==""){
			alert("第十二笔应付日不能为空！");
			return false;
		}
		if(pay13!=0&&yfdate13==""){
			alert("第十三笔应付日不能为空！");
			return false;
		}
		if(pay14!=0&&yfdate14==""){
			alert("第十四笔应付日不能为空！");
			return false;
		}
		if(pay15!=0&&yfdate15==""){
			alert("第十五笔应付日不能为空！");
			return false;
		}

		if(pay2==0&&yfdate2!=""){
			alert("第二笔付款额不能为空！");
			return false;
		}
		if(pay3==0&&yfdate3!=""){
			alert("第三笔付款额不能为空！");
			return false;
		}
		if(pay4==0&&yfdate4!=""){
			alert("第四笔付款额不能为空！");
			return false;
		}
		if(pay5==0&&yfdate5!=""){
			alert("第五笔付款额不能为空！");
			return false;
		}
		if(pay6==0&&yfdate6!=""){
			alert("第六笔付款额不能为空！");
			return false;
		}
		if(pay7==0&&yfdate7!=""){
			alert("第七笔付款额不能为空！");
			return false;
		}
		if(pay8==0&&yfdate8!=""){
			alert("第八笔付款额不能为空！");
			return false;
		}
		if(pay9==0&&yfdate9!=""){
			alert("第九笔付款额不能为空！");
			return false;
		}
		if(pay10==0&&yfdate10!=""){
			alert("第十笔付款额不能为空！");
			return false;
		}
		if(pay11==0&&yfdate11!=""){
			alert("第十一笔付款额不能为空！");
			return false;
		}
		if(pay12==0&&yfdate12!=""){
			alert("第十二笔付款额不能为空！");
			return false;
		}
		if(pay13==0&&yfdate13!=""){
			alert("第十三笔付款额不能为空！");
			return false;
		}
		if(pay14==0&&yfdate14!=""){
			alert("第十四笔付款额不能为空！");
			return false;
		}
		if(pay15==0&&yfdate15!=""){
			alert("第十五笔付款额不能为空！");
			return false;
		}

		if(sfdate2!=""&&sfdate1==""){
			alert("第一笔实付日不能为空！");
			return false;
		}
		if(sfdate3!=""&&sfdate2==""){
			alert("第二笔实付日不能为空！");
			return false;
		}
		if(sfdate4!=""&&sfdate3==""){
			alert("第三笔实付日不能为空！");
			return false;
		}
		if(sfdate5!=""&&sfdate4==""){
			alert("第四笔实付日不能为空！");
			return false;
		}
		if(sfdate6!=""&&sfdate5==""){
			alert("第五笔实付日不能为空！");
			return false;
		}
		if(sfdate7!=""&&sfdate6==""){
			alert("第六笔实付日不能为空！");
			return false;
		}
		if(sfdate8!=""&&sfdate7==""){
			alert("第七笔实付日不能为空！");
			return false;
		}
		if(sfdate9!=""&&sfdate8==""){
			alert("第八笔实付日不能为空！");
			return false;
		}
		if(sfdate10!=""&&sfdate9==""){
			alert("第九笔实付日不能为空！");
			return false;
		}
		if(sfdate11!=""&&sfdate10==""){
			alert("第十笔实付日不能为空！");
			return false;
		}
		if(sfdate12!=""&&sfdate11==""){
			alert("第十一笔实付日不能为空！");
			return false;
		}
		if(sfdate13!=""&&sfdate12==""){
			alert("第十二笔实付日不能为空！");
			return false;
		}
		if(sfdate14!=""&&sfdate13==""){
			alert("第十三笔实付日不能为空！");
			return false;
		}
		if(sfdate15!=""&&sfdate14==""){
			alert("第十四笔实付日不能为空！");
			return false;
		}
		
		total=0;
		pay=0;
		document.getElementById("payed").value=payed1+payed2+payed3+payed4+payed5+payed6
			+payed7+payed8+payed9+payed10+payed11+payed12+payed13+payed14+payed15;
		document.getElementById("lastpayday").value=lastpayday;
		document.getElementById("ident").value = ident;
       if( window.confirm(message1)){
           return true;
       } else {
           return false;
       }
	}
	
       function toback(){
       	form.action = getAppRootUrl() + "/IGASM0404.do?org.apache.struts.taglib.html.CANCEL=1";
       	form.submit();
       }
       var num = 0;
       function selectEntityItem(obj,index){
           num = index;
		   openSubIGCOM0302PARAM("?esyscoding="+obj);
      }
       function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
    	   if(einame == "" && eilabel =="" ){
	            $("civalue["+num+"]").value = "";
	            $("entityItemCivalue["+num+"]").value = "";
           }else{
	            $("civalue["+num+"]").value = einame;
	            $("entityItemCivalue["+num+"]").value = einame+"("+eiid+")";
           }
           num = 0;
       }
     //删除附件
   	function delFile(fileid){
   		 if( window.confirm("您是否确定删除附件？")){
   			form.action = getAppRootUrl() + "/IGASM0404.do?delfile["+fileid+"]="+1+"&ident="+0;
   	        form.submit();
   		 }
     }
     
     function pics(){
    	 var pics = "${IGASM04041VO.picsXml}";
    	 openIntegrationWindow(pics, "pics", "1000", "600");
     }
     
     function picu(){
    	 var picu = "${IGASM04041VO.picuXml}";
    	 openIntegrationWindow(picu, "picu", "1000", "600");
     }     
     
     function addPro(){
 		if(proCount==''){
			alert("已达到最大子项目数");
			return;
		}

 		if(proCount.indexOf('|IG_0142')!=-1){
 			proCount=proCount.replace('|IG_0142', '');
			document.getElementById("LABEL_IG_0142").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0143')!=-1){
 			proCount=proCount.replace('|IG_0143', '');
			document.getElementById("LABEL_IG_0143").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0144')!=-1){
 			proCount=proCount.replace('|IG_0144', '');
			document.getElementById("LABEL_IG_0144").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0145')!=-1){
 			proCount=proCount.replace('|IG_0145', '');
			document.getElementById("LABEL_IG_0145").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0146')!=-1){
 			proCount=proCount.replace('|IG_0146', '');
			document.getElementById("LABEL_IG_0146").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0147')!=-1){
 			proCount=proCount.replace('|IG_0147', '');
			document.getElementById("LABEL_IG_0147").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0148')!=-1){
 			proCount=proCount.replace('|IG_0148', '');
			document.getElementById("LABEL_IG_0148").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0149')!=-1){
 			proCount=proCount.replace('|IG_0149', '');
			document.getElementById("LABEL_IG_0149").style.display='';
			return;
 		}
 		if(proCount.indexOf('|IG_0150')!=-1){
 			proCount=proCount.replace('|IG_0150', '');
			document.getElementById("LABEL_IG_0150").style.display='';
			return;
 		}
     }     
     
     
</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 合同配置编辑</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM0404"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">合同基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">模型名称</th>
			<th width="15%">合同编号</th>
			<th width="20%">合同名称</th>
			<th width="10%">合同所属机构</th>
			<th width="18%">合同说明</th>
			<th width="7%">管理人</th>
			<th width="8%">登记日</th>
		</tr>
		<tr>
			<td>${IGASM04041VO.entityData.ename}</td>
			<td>${IGASM04041VO.entityData.eilabel}</td>
			<td>${IGASM04041VO.entityData.einame}</td>
			<td>${IGASM04041VO.eiorgname}</td>
			<td>${IGASM04041VO.entityData.eidesc}</td>
			<td>${IGASM04041VO.entityData.eiusername}</td>
			<td>${IGASM04041VO.entityData.eiinsdate}</td>
		</tr>
	</table>
	</div>

	<div class="title">
	<div class="name">合同配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM04041VO" property="flag">
		<logic:equal value="true" name="IGASM04041VO" property="flag">
			<logic:present name="IGASM04041VO" property="configItemVWInfoMap">
				<div id="TabbedPanels1" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<logic:iterate id="map" name="IGASM04041VO" property="configItemVWInfoMap" indexId="number">
					 	<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
					</logic:iterate>
				</ul>
				<div class="TabbedPanelsContentGroup">
				<logic:present name="IGASM04041VO" property="configItemVWInfoMap">
					<logic:iterate id="map" name="IGASM04041VO" property="configItemVWInfoMap" indexId="number">
						<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
						<bean:define id="dismap" property="dismap" name="IGASM04041VO" />
						<div class="TabbedPanelsContent">
						<div class="record_list">
						<table class="table_style2">
							<tr>
								<th width="4%"></th>
								<th width="15%" align="left">配置项名称</th>
								<th width="40%" align="left">配置项内容</th>
								<th width="20%" align="left">配置项说明</th>
								<th width="15%" align="left">附件</th>
								<th width="10%">版本号</th>
								<!--  th width="9%">更新时间</th-->
								<th></th>
							</tr>
							<logic:iterate id="bean" name="list" indexId="index">
							<bean:define id="hiddenValue" value="n" />
							<logic:equal name="bean" property="cseq" value="1">
								<bean:define id="hiddenValue" value="y" />
							</logic:equal>
							<logic:equal name="dismap" property="${bean.clabel}" value="n">
								<bean:define id="hiddenValue" value="y" />
								<logic:equal name ="bean" property="clabel" value="IG_0121"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0125"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0129"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0133"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0191"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0198"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0205"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0212"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0219"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0226"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0233"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0240"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0247"><script>showCount+=1;</script></logic:equal>
								<logic:equal name ="bean" property="clabel" value="IG_0254"><script>showCount+=1;</script></logic:equal>
							</logic:equal>

							<logic:equal name ="bean" property="clabel" value="IG_0142">
									<logic:equal name ="bean" property="civalue" value="">
											<script>proCount=proCount+'|IG_0142';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0143">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0143';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0144">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0144';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0145">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0145';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0146">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0146';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0147">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0147';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0148">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0148';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0149">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0149';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>
							<logic:equal name ="bean" property="clabel" value="IG_0150">
									<logic:equal name ="bean" property="civalue" value="">
										<script>proCount=proCount+'|IG_0150';</script>
										<bean:define id="hiddenValue" value="y" />
									</logic:equal>
							</logic:equal>

								<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" id = "LABEL_${bean.clabel }"
									<logic:equal name="hiddenValue"  value="y">style="display: none;"</logic:equal>
								>
									<!-- 占位调整格式使用 -->
									<td></td>
									<!-- 名称 -->
									<td align="left">
										<div class="nowrapDiv">
											<logic:equal value="1" name="bean" property="crequired">
												<span class="red">*</span>
											</logic:equal>
											 <logic:empty name="bean" property="cname">&nbsp;</logic:empty>
											${bean.cname}
										</div>
									</td>
									<!-- 内容 -->
									<td align="left" 
										<logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"</logic:equal>
										<logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>
									>
									<div class="nowrapDiv">
									<logic:equal name="bean" property="cattach" value="1">
										<html:file property="attachFile[${ADcount}]" styleId="attachFile[${ADcount}]" size="25" errorStyleClass="inputError imeDisabled" onkeydown="return false;" styleClass="imeDisabled" />
										<img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${ADcount}]','civalue[${ADcount}]')" border="0" style="cursor: hand" />
										<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
									</logic:equal> 
									<logic:equal name="bean" property="cattach" value="0">
										<logic:equal value="IG_0137" name="bean" property="clabel">
											<html:text property="civalue[${ADcount}]" styleId="payed" size="40" errorStyleClass="inputError" styleClass="input_left" readonly="true" />
										</logic:equal>
										<logic:equal value="IG_0138" name="bean" property="clabel">
											<html:text property="civalue[${ADcount}]" styleId="lastpayday" size="40" errorStyleClass="inputError" styleClass="input_left" readonly="true" />
										</logic:equal>
										<logic:notEqual value="IG_0137" name="bean" property="clabel">
											<logic:notEqual value="IG_0138" name="bean" property="clabel">
												<html:text property="civalue[${ADcount}]" styleId="civalue" size="40" errorStyleClass="inputError" styleClass="input_left" />
											</logic:notEqual>
										</logic:notEqual>
										<logic:equal name ="bean" property="clabel" value="IG_0141">
											<a href ="javascript:addPro();"><img src="images/addinfo.png" border="0" style="cursor: hand" width="18" height="18"></a>
									</logic:equal>
									</logic:equal> 
									<logic:equal name="bean" property="cattach" value="2">
										<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
											<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
										</html:select>
										<c:set var="ADmapcount" value="${ADmapcount+1}" />
									</logic:equal> 
									<logic:equal name="bean" property="cattach" value="3">
										<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
										<img src="images/date.gif" align="middle" onclick="calendar($('civalue[${ADcount}]'))" border="0" style="cursor: hand" />
									</logic:equal>
									<logic:equal name="bean" property="cattach" value="4">
										<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" errorStyleClass="inputError imeDisabled" size="30" readonly="true" />
										<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand" />
										<html:checkbox property="isUpgrade[${ADcount}]" styleId="isUpgrade[${ADcount}]" value="1"><span style="vertical-align: middle;">是否关系升级</span></html:checkbox>
										<br />
									</logic:equal> 
									<logic:equal name="bean" property="cattach" value="5">
										<logic:present name="IGASM0404Form" property="civalue[${ADcount}]">
											<bean:define id="civalue" name="IGASM0404Form" property="civalue[${ADcount}]" type="java.lang.String" />
											<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
												<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
												<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}"
												<%=ASMHelper.isChecked(civalue,cb_civalue)? "checked='checked'": ""%> />${checkboxbean.value}
												<br />
											</logic:iterate>
										</logic:present>
										<logic:notPresent name="IGASM0404Form" property="civalue[${ADcount}]">
											<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
												<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" />${checkboxbean.value}
												<br />
											</logic:iterate>
										</logic:notPresent>
										<html:hidden property="civalue[${ADcount}]" />
										<c:set var="ADmapcount" value="${ADmapcount+1}" />
									</logic:equal>
									<logic:equal name="bean" property="cattach" value="6">
										<html:textarea property="civalue[${ADcount}]" styleId="civalue" errorStyleClass="inputError" rows="5" cols="25" />
									</logic:equal> 
									<logic:equal name="bean" property="cattach" value="7">
										<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" />
										<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('civalue[${ADcount}]'))" border="0" style="cursor: hand" />
										<a href="javascript:clear($('civalue[${ADcount}]'));">清空</a>
										<logic:equal value="IG_0117" name="bean" property="clabel" >
														<a href ="javascript:addent();"><img src="images/addinfo.png" border="0" style="cursor: hand" width="18" height="18"></a>
										</logic:equal>
										<br />
									</logic:equal>
									</div>
									</td>
									<!-- 配置项说明 -->
									<td align="left">
										<div class="nowrapDiv"><logic:empty name="bean" property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
									</td>
									<!-- 附件 -->
									<td align="left">
										<div id="file[${ADcount}]" class="nowrapDiv">
											<logic:equal name="bean" property="cattach" value="1">
												<a href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">${bean.civalue} </a>
												<html:hidden property="delfile[${ADcount}]" styleId="delfile[${ADcount}]" />
												<c:if test="${bean.civalue > ''}">
													<img src="images/delate.gif" align="middle" onClick="delFile('${ADcount}')" border="0" style="cursor: hand" alt="删除" />
												</c:if>
											</logic:equal>
										</div>
									</td>
									<!-- 版本号 -->
									<td align="center">
										<div class="nowrapDiv"><logic:empty name="bean" property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
									</td>
									<!-- 更新时间 -->
									<td align="center"><!--  div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}
							</div--> 
										<html:hidden property="ciid" styleId="ciid" value="${bean.ciid}" /> 
										<html:hidden property="cid" styleId="cid" value="${bean.cid}" /> 
										<html:hidden property="clabel" styleId="clabel" value="${bean.clabel}" />
										<html:hidden property="ciattach" styleId="ciattach" value="${bean.cattach}" />
										<html:hidden property="eid" styleId="eid" value="${bean.eid}" />
										<html:hidden property="esyscoding" styleId="esyscoding" value="${bean.esyscoding}" /> 
										<html:hidden property="entityItemCivalue[${ADcount}]" styleId="entityItemCivalue[${ADcount}]" /> 
										<html:hidden property="civalue_bak[${ADcount}]" styleId="civalue_bak[${ADcount}]" />
								</td>
								</tr>
								<c:set var="ADcount" value="${ADcount+1}" />
							</logic:iterate>
						</table>
						</div>
						</div>
					</logic:iterate>
				</logic:present></div>
				</div>
				<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
		</script>
			</logic:present>
		</logic:equal>
	</logic:present>
	<div class="enter">
	<logic:present name="IGASM04041VO" property="flag">
		<logic:equal value="true" name="IGASM04041VO" property="flag">
			<html:hidden property="ident" />
			<!-- 
			<html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp(0);" />
			 -->
			<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp(1);" />
		</logic:equal>
	</logic:present>
<!--	<logic:present name="IGASM04041VO" property="image_flag">-->
<!--		<logic:notEqual value="true" name="IGASM04041VO" property="image_flag">-->
<!--			<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="picu();"/>-->
<!--			<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="pics();"/>-->
<!--		</logic:notEqual>-->
<!--	</logic:present>-->
	<html:button property="btn_back" value="返回" styleClass="button" onclick="goback()" /></div>
	<html:hidden property="eiid" styleId="eiid" value="${IGASM0404Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion" value="${IGASM04041VO.entityData.eiversion}" />
	<html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGASM04041VO.entityData.eiorgsyscoding}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>