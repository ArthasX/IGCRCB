<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<script src="<html:rewrite forward='editdata.js'/>"></script>
<html:html>
<script type="text/javascript">	
	var num=0;
	function addFile() 
	{
		currRow=tb.insertRow();
		cell=currRow.insertCell();
		cell.innerHTML= "<input type='file' name='attachFile["+num+"]' class='inputbutton'><input type='hidden' name='rlattkey'/><input type='button' class='delbutton' value='删除' onclick='deleteitem(this)'>";
		num++;
	}
	
	function deleteitem(obj)
	{
		var curRow= obj.parentNode.parentNode;
		tb.deleteRow(curRow.rowIndex);
	}
	function submitForm(){
	
		if($F('pltime').trim() == ""){
			alert("请输入时间！");
			return false;
		}
		//合同签订
		if($F('pltype')=="C"){
			var plcfirst = 0;
			var plcsecond = 0;
			var plcthird = 0;
			var plcfourth = 0;
			var plcfifth = 0;
			var usesum = 0;
			var size = 1;
			//是否存在预算
			<c:if test="${fn:length(igprj0101VO.pbsummaryList)>0 }">
			size = ${fn:length(igprj0101VO.pbsummaryList) };
			</c:if>
			for(var i = 0 ; i< size ;i++){
				var use1 = 0;
				var use2 = 0;
				var use3 = 0;
				var use4 = 0;
				var use5 = 0;
				var use6 = 0;
				var use7 = 0;
				var sum = 0;
				var btitle = document.getElementById("btitle["+i+"]").value;
				if($F('use1['+i+']').trim() == ""){
					alert(btitle+"资本金开发已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use1['+i+']'))){
					alert("请在"+btitle+"资本金开发已用预算内输入数字！");
					return false;
				}
				if($F('use2['+i+']').trim() == ""){
					alert(btitle+"资本金硬件已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use2['+i+']'))){
					alert("请在"+btitle+"资本金硬件已用预算内输入数字！");
					return false;
				}
				if($F('use3['+i+']').trim() == ""){
					alert(btitle+"资本金软件已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use3['+i+']'))){
					alert("请在"+btitle+"资本金软件已用预算内输入数字！");
					return false;
				}
				if($F('use4['+i+']').trim() == ""){
					alert(btitle+"资本金工程已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use4['+i+']'))){
					alert("请在"+btitle+"资本金工程已用预算内输入数字！");
					return false;
				}
				if($F('use5['+i+']').trim() == ""){
					alert(btitle+"资本金其他已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use5['+i+']'))){
					alert("请在"+btitle+"资本金其他已用预算内输入数字！");
					return false;
				}
				if($F('use6['+i+']').trim() == ""){
					alert(btitle+"成本金实施已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use6['+i+']'))){
					alert("请在"+btitle+"成本金实施已用预算内输入数字！");
					return false;
				}
				if($F('use7['+i+']').trim() == ""){
					alert(btitle+"成本金其他已用预算必须大于0或者等于0！");
					return false;
				}
				if(isNaN($F('use7['+i+']'))){
					alert("请在"+btitle+"成本金其他已用预算内输入数字！");
					return false;
				}
				use1 = document.getElementById("use1["+i+"]").value;
				use2 = document.getElementById("use2["+i+"]").value;
				use3 = document.getElementById("use3["+i+"]").value;
				use4 = document.getElementById("use4["+i+"]").value;
				use5 = document.getElementById("use5["+i+"]").value;
				use6 = document.getElementById("use6["+i+"]").value;
				use7 = document.getElementById("use7["+i+"]").value;
				use1 = parseFloat(use1);
				use2 = parseFloat(use2);
				use3 = parseFloat(use3);
				use4 = parseFloat(use4);
				use5 = parseFloat(use5);
				use6 = parseFloat(use6);
				use7 = parseFloat(use7);
				if(use1>1000000||use1==1000000){
					alert(btitle+"资本金开发已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r1;
				try{r1=use1.toString().split(".")[1].length}catch(e){r1=0}
				if(r1>2){
					alert(btitle+"资本金开发已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				if(use2>1000000||use2==1000000){
					alert(btitle+"资本金硬件已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r2;
				try{r2=use2.toString().split(".")[1].length}catch(e){r2=0}
				if(r2>2){
					alert(btitle+"资本金硬件已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				if(use3>1000000||use3==1000000){
					alert(btitle+"资本金软件已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r3;
				try{r3=use3.toString().split(".")[1].length}catch(e){r3=0}
				if(r3>2){
					alert(btitle+"资本金软件已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				if(use4>1000000||use4==1000000){
					alert(btitle+"资本金工程已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r4;
				try{r4=use4.toString().split(".")[1].length}catch(e){r4=0}
				if(r4>2){
					alert(btitle+"资本金工程已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				if(use5>1000000||use5==1000000){
					alert(btitle+"资本金其他已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r5;
				try{r5=use5.toString().split(".")[1].length}catch(e){r5=0}
				if(r5>2){
					alert(btitle+"资本金其他已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				if(use6>1000000||use6==1000000){
					alert(btitle+"成本金实施已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r6;
				try{r6=use6.toString().split(".")[1].length}catch(e){r6=0}
				if(r6>2){
					alert(btitle+"成本金实施已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				if(use7>1000000||use7==1000000){
					alert(btitle+"成本金其他已用预算整数部分最多可以输入6位数字！");
					return false;
				}
				var r7;
				try{r7=use7.toString().split(".")[1].length}catch(e){r7=0}
				if(r7>2){
					alert(btitle+"成本金其他已用预算小数部分最多可以输入2位数字！");
					return false;
				}
				sum = sum+use1+use2+use3+use4+use5+use6+use7;
				if(sum==0){
					alert(btitle+"已用预算必须大于0！");
					return false;
				}
				usesum = usesum+sum;
				<c:if test="${fn:length(igprj0101VO.pbsummaryList)>0 }">
				var sub1 = document.getElementById("sub1["+i+"]").value;
				var sub2 = document.getElementById("sub2["+i+"]").value;
				var sub3 = document.getElementById("sub3["+i+"]").value;
				var sub4 = document.getElementById("sub4["+i+"]").value;
				var sub5 = document.getElementById("sub5["+i+"]").value;
				var sub6 = document.getElementById("sub6["+i+"]").value;
				var sub7 = document.getElementById("sub7["+i+"]").value;
				if(use1>sub1){
					alert(btitle+"资本金开发已用预算不能大于可用预算！");
					return false;
				}
				if(use2>sub2){
					alert(btitle+"资本金硬件已用预算不能大于可用预算！");
					return false;
				}
				if(use3>sub3){
					alert(btitle+"资本金软件已用预算不能大于可用预算！");
					return false;
				}
				if(use4>sub4){
					alert(btitle+"资本金工程已用预算不能大于可用预算！");
					return false;
				}
				if(use5>sub5){
					alert(btitle+"资本金其他已用预算不能大于可用预算！");
					return false;
				}
				if(use6>sub6){
					alert(btitle+"成本金实施已用预算不能大于可用预算！");
					return false;
				}
				if(use7>sub7){
					alert(btitle+"成本金其他已用预算不能大于可用预算！");
					return false;
				}
				</c:if>
			}
			usesum = Math.round(usesum*100)/100;
			document.getElementById("plcsum").value = usesum;
			if($F('plcnumber').trim() == ""){
				alert("合同编号不能为空！");
				return false;
			}
			if($F('plcnumber').strlen()>128){
	    		alert("合同编号不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
			if($F('plcsum').trim() == ""){
				alert("合同金额不能为空！");
				return false;
			}
			if(isNaN($F('plcsum'))){
				alert("请在合同金额内输入数字！");
				return false;
			}
			plcsum = parseFloat($F('plcsum'));
			plcsum = Math.round(plcsum*100)/100;
			if(plcsum>1000000||plcsum==1000000){
				alert("小数点前只能输入6位数字！");
				return false;
			}
			document.getElementById("plcsum").value = plcsum;
			if($F('plcfirst').trim() != ""){
				if(isNaN($F('plcfirst'))){
					alert("请在一期金额内输入数字！");
					return false;
				}
				plcfirst = parseFloat($F('plcfirst'));
				if(plcfirst>1000000||plcfirst==1000000){
					alert("一期金额整数部分最多可以输入6位数字！");
					return false;
				}
				var f1;
				try{f1=plcfirst.toString().split(".")[1].length}catch(e){f1=0}
				if(f1>2){
					alert("一期金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plcsecond').trim() != ""){
				if(isNaN($F('plcsecond'))){
					alert("请在二期金额内输入数字！");
					return false;
				}
				plcsecond = parseFloat($F('plcsecond'));
				if(plcsecond>1000000||plcsecond==1000000){
					alert(" 二期金额整数部分最多可以输入6位数字！");
					return false;
				}
				var f2;
				try{f2=plcsecond.toString().split(".")[1].length}catch(e){f2=0}
				if(f2>2){
					alert("二期金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plcthird').trim() != ""){
				if(isNaN($F('plcthird'))){
					alert("请在三期金额内输入数字！");
					return false;
				}
				plcthird = parseFloat($F('plcthird'));
				if(plcthird>1000000||plcthird==1000000){
					alert("三期金额整数部分最多可以输入6位数字！");
					return false;
				}
				var f3;
				try{f3=plcthird.toString().split(".")[1].length}catch(e){f3=0}
				if(f3>2){
					alert("三期金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plcfourth').trim() != ""){
				if(isNaN($F('plcfourth'))){
					alert("请在四期金额内输入数字！");
					return false;
				}
				plcfourth = parseFloat($F('plcfourth'));
				if(plcfourth>1000000||plcfourth==1000000){
					alert("四期金额整数部分最多可以输入6位数字！");
					return false;
				}
				var f4;
				try{f4=plcfourth.toString().split(".")[1].length}catch(e){f4=0}
				if(f4>2){
					alert("四期金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plcfifth').trim() != ""){
				if(isNaN($F('plcfifth'))){
					alert("请在五期金额内输入数字！");
					return false;
				}
				plcfifth = parseFloat($F('plcfifth'));
				if(plcfifth>1000000||plcfifth==1000000){
					alert("五期金额整数部分最多可以输入6位数字！");
					return false;
				}
				var f5;
				try{f5=plcfifth.toString().split(".")[1].length}catch(e){f5=0}
				if(f5>2){
					alert("五期金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			var fsum = plcfirst + plcsecond + plcthird + plcfourth + plcfifth;
			fsum = Math.round(fsum*100)/100;
			if(fsum>usesum){
				alert("付款总金额不能大于合同金额！");
				return false;
			}
			//sum = Math.round(sum*100)/100;			
			//document.getElementById("plcsum").value = sum;			
			if($F('plcsumterm').strlen()>512){
				alert("合同付款条件不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('plcfirstterm').strlen()>512){
				alert("一期付款条件不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('plcsecondterm').strlen()>512){
				alert("二期付款条件不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('plcthirdterm').strlen()>512){
				alert("三期付款条件不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('plcfourthterm').strlen()>512){
				alert("四期付款条件不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('plcfifthterm').strlen()>512){
				alert("五期付款条件不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
		}
		//付款
		if($F('pltype')=="J"){
			var plbfirst = 0;
			var plbsecond = 0;
			var plbthird = 0;
			var plbfourth = 0;
			var plbfifth = 0;
			if($F('plbfirst').trim() != ""){
				if(isNaN($F('plbfirst'))){
					alert("请在一期金额内输入数字！");
					return false;
				}
				plbfirst = parseFloat($F('plbfirst'));
				if(plbfirst>1000000||plbfirst==1000000){
					alert("一期付款金额整数部分最多可以输入6位数字！");
					return false;
				}
				var p1;
				try{p1=plbfirst.toString().split(".")[1].length}catch(e){p1=0}
				if(p1>2){
					alert("一期付款金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plbsecond').trim() != ""){
				if(isNaN($F('plbsecond'))){
					alert("请在二期金额内输入数字！");
					return false;
				}
				plbsecond = parseFloat($F('plbsecond'));
				if(plbsecond>1000000||plbsecond==1000000){
					alert("二期付款金额整数部分最多可以输入6位数字！！");
					return false;
				}
				var p2;
				try{p2=plbsecond.toString().split(".")[1].length}catch(e){p2=0}
				if(p2>2){
					alert("二期付款金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plbthird').trim() != ""){
				if(isNaN($F('plbthird'))){
					alert("请在三期金额内输入数字！");
					return false;
				}
				plbthird = parseFloat($F('plbthird'));
				if(plbthird>1000000||plbthird==1000000){
					alert("三期付款金额整数部分最多可以输入6位数字！！");
					return false;
				}
				var p3;
				try{p3=plbthird.toString().split(".")[1].length}catch(e){p3=0}
				if(p3>2){
					alert("三期付款金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plbfourth').trim() != ""){
				if(isNaN($F('plbfourth'))){
					alert("请在四期金额内输入数字！");
					return false;
				}
				plbfourth = parseFloat($F('plbfourth'));
				if(plbfourth>1000000||plbfourth==1000000){
					alert("四期付款金额整数部分最多可以输入6位数字！！");
					return false;
				}
				var p4;
				try{p4=plbfourth.toString().split(".")[1].length}catch(e){p4=0}
				if(p4>2){
					alert("四期付款金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			if($F('plbfifth').trim() != ""){
				if(isNaN($F('plbfifth'))){
					alert("请在五期金额内输入数字！");
					return false;
				}
				plbfifth = parseFloat($F('plbfifth'));
				if(plbfifth>1000000||plbfifth==1000000){
					alert("五期付款金额整数部分最多可以输入6位数字！！");
					return false;
				}
				var p5;
				try{p5=plbfifth.toString().split(".")[1].length}catch(e){p5=0}
				if(p5>2){
					alert("五期付款金额小数部分最多可以输入2位数字！");
					return false;
				}
			}
			var a = accAdd(plbfirst,plbsecond) + accAdd(plbthird,plbfourth);
			var sum = accAdd(a,plbfifth);
		  	sum = Math.round(sum*100)/100;		
			plbplcsum = parseFloat($F('plbplcsum'));
			if($F('plbplcsum').trim() == ""){
				alert("请先确认合同总额！");
				return false;
			}
			if(plbplcsum<sum){
				alert("已付款总额不能大于合同总额！");
				return false;
			}
			var unsum = Subtr(plbplcsum,sum);
			unsum = Math.round(unsum*100)/100;
			var scale = accMul(accDiv(sum,plbplcsum),100);
			scale = Math.round(scale*100)/100;
			var unscale = Subtr(100,scale);
			unscale = Math.round(unscale*100)/100;
			
			if(isNaN(sum)){			
				document.getElementById("plbsum").value = 0;
			}else{			
				document.getElementById("plbsum").value = sum;
			}
			if(isNaN(unsum)){			
				document.getElementById("plbnotsum").value = 0;
			}else{			
				document.getElementById("plbnotsum").value = unsum;
			}
			if(isNaN(scale)){			
				document.getElementById("plbscale").value = 0;
			}else{
				document.getElementById("plbscale").value = scale;
			}
			if(isNaN(unscale)){			
				document.getElementById("plbnotscale").value = 0;
			}else{
				document.getElementById("plbnotscale").value = unscale;
			}
		}
		if($F('plinfo').trim() == ""){
			alert("请输入项目日志！");
			return false;
		}		
		if($F('plinfo').strlen()>512){
			alert("项目日志不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
			return false;
		}
		
		if(confirm("是否确认提交")){
			return true;
		}
		return false;
	}
	function searchprocessStatus(obj){
		if($F('pltype')=="C"){
			document.forms[0].action = "IGPRJ0101_Detail.do?pid="+obj+"&type=assess&pltype=C";
			document.forms[0].submit();
		}
		else if($F('pltype')=="J"){
			document.forms[0].action = "IGPRJ0101_Detail.do?pid="+obj+"&type=assess&pltype=J";
			document.forms[0].submit();
		}else{
			document.forms[0].action = "IGPRJ0101_Detail.do?pid="+obj+"&type=assess";
			document.forms[0].submit();
		}
	}
	function contractSum(){
		var plcfirst = 0;
		var plcsecond = 0;
		var plcthird = 0;
		var plcfourth = 0;
		var plcfifth = 0;
		var use1 = 0;
		var use2 = 0;
		var use3 = 0;
		var use4 = 0;
		var use5 = 0;
		var use6 = 0;
		var use7 = 0;
		var usesum = 0;
		var size  = 1;
		//是否存在预算
		<c:if test="${fn:length(igprj0101VO.pbsummaryList)>0 }">
		size = ${fn:length(igprj0101VO.pbsummaryList) };
		</c:if>
		for(var i = 0 ; i< size ;i++){
			use1 = document.getElementById("use1["+i+"]").value;
			use2 = document.getElementById("use2["+i+"]").value;
			use3 = document.getElementById("use3["+i+"]").value;
			use4 = document.getElementById("use4["+i+"]").value;
			use5 = document.getElementById("use5["+i+"]").value;
			use6 = document.getElementById("use6["+i+"]").value;
			use7 = document.getElementById("use7["+i+"]").value;
			use1 = parseFloat(use1);
			use2 = parseFloat(use2);
			use3 = parseFloat(use3);
			use4 = parseFloat(use4);
			use5 = parseFloat(use5);
			use6 = parseFloat(use6);
			use7 = parseFloat(use7);
			usesum = usesum+use1+use2+use3+use4+use5+use6+use7;
		}
		usesum = Math.round(usesum*100)/100;
		document.getElementById("plcsum").value = usesum;
		if($F('plcfirst').trim() != ""){
			if(isNaN($F('plcfirst'))){
				alert("请在一期金额内输入数字！");
				return false;
			}
			plcfirst = parseFloat($F('plcfirst'));
			plcfirst = Math.round(plcfirst*100)/100;
			if(plcfirst>1000000||plcfirst==1000000){
				alert("小数点前只能输入6位数字！");
				return false;
			}
			document.getElementById("plcfirst").value = plcfirst;
		}
		if($F('plcsecond').trim() != ""){
			if(isNaN($F('plcsecond'))){
				alert("请在二期金额内输入数字！");
				return false;
			}
			plcsecond = parseFloat($F('plcsecond'));
			plcsecond = Math.round(plcsecond*100)/100;
			if(plcsecond>1000000||plcsecond==1000000){
				alert("小数点前只能输入6位数字！");
				return false;
			}
			document.getElementById("plcsecond").value = plcsecond;
		}
		if($F('plcthird').trim() != ""){
			if(isNaN($F('plcthird'))){
				alert("请在三期金额内输入数字！");
				return false;
			}
			plcthird = parseFloat($F('plcthird'));
			plcthird = Math.round(plcthird*100)/100;
			if(plcthird>1000000||plcthird==1000000){
				alert("小数点前只能输入6位数字！");
				return false;
			}
			document.getElementById("plcthird").value = plcthird;
		}
		if($F('plcfourth').trim() != ""){
			if(isNaN($F('plcfourth'))){
				alert("请在四期金额内输入数字！");
				return false;
			}
			plcfourth = parseFloat($F('plcfourth'));
			plcfourth = Math.round(plcfourth*100)/100;
			if(plcfourth>1000000||plcfourth==1000000){
				alert("小数点前只能输入6位数字！");
				return false;
			}
			document.getElementById("plcfourth").value = plcfourth;
		}
		if($F('plcfifth').trim() != ""){
			if(isNaN($F('plcfifth'))){
				alert("请在五期金额内输入数字！");
				return false;
			}
			plcfifth = parseFloat($F('plcfifth'));
			plcfifth = Math.round(plcfifth*100)/100;
			if(plcfifth>1000000||plcfifth==1000000){
				alert("小数点前只能输入6位数字！");
				return false;
			}
			document.getElementById("plcfifth").value = plcfifth;
		}
		//var sum = plcfirst + plcsecond + plcthird + plcfourth + plcfifth;
		//sum = Math.round(sum*100)/100;			
		//document.getElementById("plcsum").value = sum;
	}
	function businessSum(){
		var plbfirst = 0;
		var plbsecond = 0;
		var plbthird = 0;
		var plbfourth = 0;
		var plbfifth = 0;
		if($F('plbfirst').trim() != ""){
			if(isNaN($F('plbfirst'))){
				alert("请在一期金额内输入数字！");
				return false;
			}
			plbfirst = parseFloat($F('plbfirst'));
			if(plbfirst>1000000||plbfirst==1000000){
				alert("一期付款金额整数部分最多可以输入6位数字！");
				return false;
			}
			var p1;
			try{p1=plbfirst.toString().split(".")[1].length}catch(e){p1=0}
			if(p1>2){
				alert("一期付款金额小数部分最多可以输入2位数字！");
				return false;
			}
		}
		if($F('plbsecond').trim() != ""){
			if(isNaN($F('plbsecond'))){
				alert("请在二期金额内输入数字！");
				return false;
			}
			plbsecond = parseFloat($F('plbsecond'));
			if(plbsecond>1000000||plbsecond==1000000){
				alert("二期付款金额整数部分最多可以输入6位数字！！");
				return false;
			}
			var p2;
			try{p2=plbsecond.toString().split(".")[1].length}catch(e){p2=0}
			if(p2>2){
				alert("二期付款金额小数部分最多可以输入2位数字！");
				return false;
			}
		}
		if($F('plbthird').trim() != ""){
			if(isNaN($F('plbthird'))){
				alert("请在三期金额内输入数字！");
				return false;
			}
			plbthird = parseFloat($F('plbthird'));
			if(plbthird>1000000||plbthird==1000000){
				alert("三期付款金额整数部分最多可以输入6位数字！！");
				return false;
			}
			var p3;
			try{p3=plbthird.toString().split(".")[1].length}catch(e){p3=0}
			if(p3>2){
				alert("三期付款金额小数部分最多可以输入2位数字！");
				return false;
			}
		}
		if($F('plbfourth').trim() != ""){
			if(isNaN($F('plbfourth'))){
				alert("请在四期金额内输入数字！");
				return false;
			}
			plbfourth = parseFloat($F('plbfourth'));
			if(plbfourth>1000000||plbfourth==1000000){
				alert("四期付款金额整数部分最多可以输入6位数字！！");
				return false;
			}
			var p4;
			try{p4=plbfourth.toString().split(".")[1].length}catch(e){p4=0}
			if(p4>2){
				alert("四期付款金额小数部分最多可以输入2位数字！");
				return false;
			}
		}
		if($F('plbfifth').trim() != ""){
			if(isNaN($F('plbfifth'))){
				alert("请在五期金额内输入数字！");
				return false;
			}
			plbfifth = parseFloat($F('plbfifth'));
			if(plbfifth>1000000||plbfifth==1000000){
				alert("五期付款金额整数部分最多可以输入6位数字！！");
				return false;
			}
			var p5;
			try{p5=plbfifth.toString().split(".")[1].length}catch(e){p5=0}
			if(p5>2){
				alert("五期付款金额小数部分最多可以输入2位数字！");
				return false;
			}
		}
		var a = accAdd(plbfirst,plbsecond) + accAdd(plbthird,plbfourth);
		var sum = accAdd(a,plbfifth);
	  	sum = Math.round(sum*100)/100;		
		plbplcsum = parseFloat($F('plbplcsum'));
		if($F('plbplcsum').trim() == ""){
			alert("请先确认合同总额！");
			return false;
		}
		if(plbplcsum<sum){
			alert("已付款总额不能大于合同总额！");
			return false;
		}
		var unsum = Subtr(plbplcsum,sum);
		unsum = Math.round(unsum*100)/100;
		var scale = accMul(accDiv(sum,plbplcsum),100);
		scale = Math.round(scale*100)/100;
		var unscale = Subtr(100,scale);
		unscale = Math.round(unscale*100)/100;
		if(isNaN(sum)){			
			document.getElementById("plbsum").value = 0;
		}else{			
			document.getElementById("plbsum").value = sum;
		}
		if(isNaN(unsum)){			
			document.getElementById("plbnotsum").value = 0;
		}else{			
			document.getElementById("plbnotsum").value = unsum;
		}
		if(isNaN(scale)){			
			document.getElementById("plbscale").value = 0;
		}else{
			document.getElementById("plbscale").value = scale;
		}
		if(isNaN(unscale)){			
			document.getElementById("plbnotscale").value = 0;
		}else{
			document.getElementById("plbnotscale").value = unscale;
		}
	}
</script>

<bean:define id="id" value="IGPRJ010102" toScope="request" />
<bean:define id="title" value="项目日志" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<!-- 付款  -->
<c:if test="${IGPRJ0101DetailForm.pltype=='J' }">
<body onload="businessSum()">
</c:if>
<c:if test="${IGPRJ0101DetailForm.pltype=='C' }">
<body onload="contractSum()">
</c:if>
<c:if test="${(IGPRJ0101DetailForm.pltype!='C')&&(IGPRJ0101DetailForm.pltype!='J') }">
<body>
</c:if>
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
		<p class="fonts1">查看 &gt;&gt; 项目日志</p>
		<div class="back"><a href="#" target="_self" onclick="window.location='IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}';">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">使用预算：</th>
			<td width="35%"><ig:codeValue ccid="Project_ISUSEBUDGET" cid="${igprj0101VO.form.isUseBudget}" /></td>
			<th width="15%" align="right">项目状态：</th>
			<td width="35%"><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${igprj0101VO.form.pstatus}" /></td>
		</tr>
		
		<c:if test="${igprj0101VO.form.isUseBudget == '0001'}">
		<tr>
			<th width="15%" align="right">预算名称：</th>
			<td width="35%">${igprj0101VO.form.pbname}</td>
			<th width="15%" align="right">预算金额：</th>
			<td width="35%"><bean:write name="igprj0101VO" property="form.pamount" format="##.##"></bean:write></td>
		</tr>
		</c:if>

		<tr>
		  <th width="15%" align="right">项目名称：</th>
		  <td >${igprj0101VO.form.pname}</td>
		  <th width="15%" align="right">项目金额：</th>
		  <td width="35%"><bean:write name="igprj0101VO" property="form.plimit" format="##.##"></bean:write>(万元)</td>
		</tr>	
		
		<tr>
		  <th align="right">项目编号：</th>
		  <td><pre>${igprj0101VO.form.pcode}</pre></td>
		  <th align="right">计划结束时间：</th>
			<td>${igprj0101VO.project.pplanclosetime}</td>
		</tr>
		
		<tr>
			<th align="right">开始时间：</th>
			<td>${igprj0101VO.project.popentime}</td>
			<th align="right">实际结束时间：</th>
			<td>${igprj0101VO.project.pclosetime}</td>
		</tr>
		
		<tr>
			<th align="right">需求部门：</th>
			<td colspan="3"><ig:codeValue ccid="Project_NEEDBRANCH" cid="${igprj0101VO.project.pbranch}" /></td>
		</tr>

		<tr>
		  <th align="right">项目简介：</th>
		  <td colspan="3"><pre>${igprj0101VO.project.pdesc}</pre></td>
		</tr>
		
		<tr>
			<th align="right">项目目的：</th>
			<td colspan="3">${igprj0101VO.project.paim}</td>
		</tr>
		 <tr>
		  <th align="right">项目用途：</th>
		  <td colspan="3"><pre>${igprj0101VO.project.ppurpose}</pre></td>
		 </tr>
	</table>
	</div>
	
	<div id="formwrapper">
	<html:form styleId="form" action="/IGPRJ0101_Detail_Assess" onsubmit="return submitForm(this);" enctype="multipart/form-data">
	<c:if test="${IGPRJ0101DetailForm.pltype=='C' }">
	<div class="title">
	<div class="name">预算信息</div>
	</div>

	<div class="record_list">
	<table class="table_style">
		<tr>
			<th style="background-color:#e4f8ed; " width="20%">分类</th>
			<th colspan="6" style="background-color:#e1edf9; ">资本金(万元)</th>
			<th colspan="2" style="background-color:#faecdf; ">成本金(万元)</th>
		</tr>
		<tr>
			<th style="background-color:#e4f8ed; ">类别</th>
			<th style="background-color:#e1edf9; "></th>
			<th style="background-color:#e1edf9; ">开发</th>
			<th style="background-color:#e1edf9; ">硬件</th>
			<th style="background-color:#e1edf9; ">软件</th>
			<th style="background-color:#e1edf9; ">工程</th>
			<th style="background-color:#e1edf9; ">其他</th>
			<th style="background-color:#faecdf; ">实施</th>
			<th style="background-color:#faecdf; ">其他</th>
		</tr>
		<c:if test="${fn:length(igprj0101VO.pbsummaryList) == 0 }">
		<tr>
			<td></td>
			<td>项目金额</td>
			<td>${igprj0101VO.project.pzdevelop }</td>
			<td>${igprj0101VO.project.pzhardware }</td>
			<td>${igprj0101VO.project.pzsoftware }</td>
			<td>${igprj0101VO.project.pzproject }</td>
			<td>${igprj0101VO.project.pzelse }</td>
			<td>${igprj0101VO.project.pcimplement }</td>
			<td>${igprj0101VO.project.pcelse }</td>
		</tr>
		<tr>
			<td></td>
			<td>合同金额<input type="hidden" name="btitle"  id="btitle[0]"/></td>
			<td><html:text property="use1" size="5" styleId="use1[0]" value="${IGPRJ0101DetailForm.use1[0] }"/></td>
			<td><html:text property="use2" size="5" styleId="use2[0]" value="${IGPRJ0101DetailForm.use2[0] }" /></td>
			<td><html:text property="use3" size="5" styleId="use3[0]" value="${IGPRJ0101DetailForm.use3[0] }" /></td>
			<td><html:text property="use4" size="5" styleId="use4[0]" value="${IGPRJ0101DetailForm.use4[0] }" /></td>
			<td><html:text property="use5" size="5" styleId="use5[0]" value="${IGPRJ0101DetailForm.use5[0] }" /></td>
			<td><html:text property="use6" size="5" styleId="use6[0]" value="${IGPRJ0101DetailForm.use6[0] }" /></td>
			<td><html:text property="use7" size="5" styleId="use7[0]" value="${IGPRJ0101DetailForm.use7[0] }" /></td>
		</tr>
		</c:if>
		<logic:iterate id="bean" name="igprj0101VO" property="pbsummaryList" indexId="index" >
		<tr>
			<td rowspan="2">${bean.btitle}
			<input type="hidden" name="btitle" id="btitle[${index }]" value="${IGPRJ0101DetailForm.btitle[index]}" /></td>
			<td>可用预算</td>
			<td>${IGPRJ0101DetailForm.sub1[index]+IGPRJ0101DetailForm.use1[index] }
			<input type="hidden" name="sub1" id="sub1[${index }]" value="${IGPRJ0101DetailForm.sub1[index]+IGPRJ0101DetailForm.use1[index] }" /></td>
			<td>${IGPRJ0101DetailForm.sub2[index]+IGPRJ0101DetailForm.use2[index] }
			<input type="hidden" name="sub2" id="sub2[${index }]" value="${IGPRJ0101DetailForm.sub2[index]+IGPRJ0101DetailForm.use2[index] }" /></td>
			<td>${IGPRJ0101DetailForm.sub3[index]+IGPRJ0101DetailForm.use3[index] }
			<input type="hidden" name="sub3" id="sub3[${index }]" value="${IGPRJ0101DetailForm.sub3[index]+IGPRJ0101DetailForm.use3[index] }" /></td>
			<td>${IGPRJ0101DetailForm.sub4[index]+IGPRJ0101DetailForm.use4[index] }
			<input type="hidden" name="sub4" id="sub4[${index }]" value="${IGPRJ0101DetailForm.sub4[index]+IGPRJ0101DetailForm.use4[index] }" /></td>
			<td>${IGPRJ0101DetailForm.sub5[index]+IGPRJ0101DetailForm.use5[index] }
			<input type="hidden" name="sub5" id="sub5[${index }]" value="${IGPRJ0101DetailForm.sub5[index]+IGPRJ0101DetailForm.use5[index] }" /></td>
			<td>${IGPRJ0101DetailForm.sub6[index]+IGPRJ0101DetailForm.use6[index] }
			<input type="hidden" name="sub6" id="sub6[${index }]" value="${IGPRJ0101DetailForm.sub6[index]+IGPRJ0101DetailForm.use6[index] }" /></td>
			<td>${IGPRJ0101DetailForm.sub7[index]+IGPRJ0101DetailForm.use7[index] }
			<input type="hidden" name="sub7" id="sub7[${index }]" value="${IGPRJ0101DetailForm.sub7[index]+IGPRJ0101DetailForm.use7[index] }" /></td>
		</tr>
		<tr>
			<td>已用预算</td>
			<td><html:text property="use1" styleId="use1[${index }]" size="5" value="${IGPRJ0101DetailForm.use1[index]}" />
				<input type="hidden" name="pbrid" value="${bean.pbid}" /></td>
			<td><html:text property="use2" styleId="use2[${index }]" size="5" value="${IGPRJ0101DetailForm.use2[index]}" /></td>
			<td><html:text property="use3" size="5" styleId="use3[${index }]" value="${IGPRJ0101DetailForm.use3[index]}" /></td>
			<td><html:text property="use4" size="5" styleId="use4[${index }]" value="${IGPRJ0101DetailForm.use4[index]}" /></td>
			<td><html:text property="use5" size="5" styleId="use5[${index }]" value="${IGPRJ0101DetailForm.use5[index]}" /></td>
			<td><html:text property="use6" size="5" styleId="use6[${index }]" value="${IGPRJ0101DetailForm.use6[index]}" /></td>
			<td><html:text property="use7" size="5" styleId="use7[${index }]" value="${IGPRJ0101DetailForm.use7[index]}" /></td>
		</tr>
		</logic:iterate>
	</table>
	</div>
	</c:if>
	<div class="title">
		<div class="name">项目日志</div>
	</div>
	
	<fieldset>
	<ig:message />
	<table width="81%" align="center">
	<tr>
	<td width="15%"><span>时间:</span></td><td width="35%"><span><html:text name="IGPRJ0101DetailForm" property="pltime" size="20"
		readonly="true" errorStyleClass="inputError imeActive" styleId="pltime" style="width:160px"/>
		<img src="images/date.gif" align="middle" onclick="showTime($('pltime'))" border="0" style="cursor: hand" />
		</span></td>
		<td width="15%"><span>日志类别:</span></td><td width="35%"><span>
        <html:select name="IGPRJ0101DetailForm" property="pltype" onchange="searchprocessStatus(${IGPRJ0101DetailForm.pid });" style="width:183px" value="${IGPRJ0101DetailForm.pltype }">
            <logic:iterate id="bean" name="igprj0101VO" property="codeDetailList" indexId="index">
			<html:option value="${bean.cid}">${bean.cvalue}</html:option>
			</logic:iterate>
		</html:select></span></td>
	</tr>
	<c:if test="${IGPRJ0101DetailForm.pltype=='C' }">
	<tr>
	<td><span>合同编号:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcnumber" size="20" value="${igprj0101VO.plcnumber }"
		errorStyleClass="inputError imeActive" styleId="plcnumber" style="width:160px"/></span></td>
	</tr>
	<tr>
	<td><span>合同金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcsum" size="20" value="${igprj0101VO.projectLogContractSum }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcsum" style="width:160px"/>(万元)
		<!-- <input type="button" value="计算" class="button" onclick="contractSum();"> -->
		</span></td>
	<td><span>付款条件:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcsumterm" size="20" value="${igprj0101VO.projectLogContractSumTerm }"
		errorStyleClass="inputError imeActive" styleId="plcsumterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>一期金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcfirst" size="20" value="${igprj0101VO.projectLogContractFirst }"
		errorStyleClass="inputError imeActive" styleId="plcfirst" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcfirstterm" size="20" value="${igprj0101VO.projectLogContractFirstTerm }"
		errorStyleClass="inputError imeActive" styleId="plcfirstterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>二期金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcsecond" size="20" value="${igprj0101VO.projectLogContractSecond }"
		errorStyleClass="inputError imeActive" styleId="plcsecond" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcsecondterm" size="20" value="${igprj0101VO.projectLogContractSecondTerm }"
		errorStyleClass="inputError imeActive" styleId="plcsecondterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>三期金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcthird" size="20" value="${igprj0101VO.projectLogContractThird }"
		errorStyleClass="inputError imeActive" styleId="plcthird" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcthirdterm" size="20" value="${igprj0101VO.projectLogContractThirdTerm }"
		errorStyleClass="inputError imeActive" styleId="plcthirdterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>四期金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcfourth" size="20" value="${igprj0101VO.projectLogContractFourth }"
		errorStyleClass="inputError imeActive" styleId="plcfourth" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcfourthterm" size="20" value="${igprj0101VO.projectLogContractFourthTerm }"
		errorStyleClass="inputError imeActive" styleId="plcfourthterm" style="width:178px"/></span></td>
	</tr>
	<tr>
	<td><span>五期金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcfifth" size="20" value="${igprj0101VO.projectLogContractFifth }"
		errorStyleClass="inputError imeActive" styleId="plcfifth" style="width:160px"/>(万元)</span></td>
	<td><span>付款条件:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plcfifthterm" size="20" value="${igprj0101VO.projectLogContractFifthTerm }"
		errorStyleClass="inputError imeActive" styleId="plcfifthterm" style="width:178px"/></span></td>
	</tr>
	</c:if>
	<c:if test="${IGPRJ0101DetailForm.pltype=='J' }">
	<tr>
	<c:if test="${igprj0101VO.projectLogBusinessFirst!=null }">
	<td><span>一期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbfirst" size="20" value="${igprj0101VO.projectLogBusinessFirst }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbfirst" style="width:160px"/>(万元)</span></td>
	</c:if>
	<c:if test="${igprj0101VO.projectLogBusinessFirst==null }">
	<td><span>一期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbfirst" size="20" value="${igprj0101VO.projectLogBusinessFirst }"
		errorStyleClass="inputError imeActive" styleId="plbfirst" style="width:160px"/>(万元)</span></td>
	</c:if>
	<td><span>合同总额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbplcsum" size="20" value="${igprj0101VO.projectLogContractSum }"
	 	readonly="true" errorStyleClass="inputError imeActive" styleId="plbplcsum" style="width:178px"/></span>
	 	<input type="button" value="计算" class="button" onclick="businessSum();">
	 </td>
	</tr>
	<tr>
	<c:if test="${igprj0101VO.projectLogBusinessSecond!=null }">
	<td><span>二期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbsecond" size="20" value="${igprj0101VO.projectLogBusinessSecond }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbsecond" style="width:160px"/>(万元)</span></td>
	</c:if>
	<c:if test="${igprj0101VO.projectLogBusinessSecond==null }">
	<td><span>二期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbsecond" size="20" value="${igprj0101VO.projectLogBusinessSecond }"
		errorStyleClass="inputError imeActive" styleId="plbsecond" style="width:160px"/>(万元)</span></td>
	</c:if>
	<td><span>已付款总额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbsum" size="20" value="${igprj0101VO.projectLogBusinessSum }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbsum" style="width:178px"/>(万元)</span></td>
	</tr>
	<tr>
	<c:if test="${igprj0101VO.projectLogBusinessThird!=null }">
	<td><span>三期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbthird" size="20" value="${igprj0101VO.projectLogBusinessThird }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbthird" style="width:160px"/>(万元)</span></td>
	</c:if>
	<c:if test="${igprj0101VO.projectLogBusinessThird==null }">
	<td><span>三期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbthird" size="20" value="${igprj0101VO.projectLogBusinessThird }"
		errorStyleClass="inputError imeActive" styleId="plbthird" style="width:160px"/>(万元)</span></td>
	</c:if>
	<td><span>已付款比例:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbscale" size="20" value="${igprj0101VO.projectLogBusinessScale }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbscale" style="width:178px"/></span><span>%</span></td>
	</tr>
	<tr>
	<c:if test="${igprj0101VO.projectLogBusinessFourth!=null }">
	<td><span>四期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbfourth" size="20" value="${igprj0101VO.projectLogBusinessFourth }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbfourth" style="width:160px"/>(万元)</span></td>
	</c:if>
	<c:if test="${igprj0101VO.projectLogBusinessFourth==null }">
	<td><span>四期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbfourth" size="20" value="${igprj0101VO.projectLogBusinessFourth }"
		errorStyleClass="inputError imeActive" styleId="plbfourth" style="width:160px"/>(万元)</span></td>
	</c:if>
	<td><span>未付款总额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbnotsum" size="20" value="${igprj0101VO.projectLogBusinessNotsum }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbnotsum" style="width:178px"/>(万元)</span></td>
	</tr>
	<tr>
	<c:if test="${igprj0101VO.projectLogBusinessFifth!=null }">
	<td><span>五期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbfifth" size="20" value="${igprj0101VO.projectLogBusinessFifth }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plcfifth" style="width:160px"/>(万元)</span></td>
	</c:if>
	<c:if test="${igprj0101VO.projectLogBusinessFifth==null }">
	<td><span>五期付款金额:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbfifth" size="20" value="${igprj0101VO.projectLogBusinessFifth }"
		errorStyleClass="inputError imeActive" styleId="plcfifth" style="width:160px"/>(万元)</span></td>
	</c:if>
	<td><span>未付款比例:</span></td><td><span><html:text name="IGPRJ0101DetailForm" property="plbnotscale" size="20" value="${igprj0101VO.projectLogBusinessNotscale }"
		readonly="true" errorStyleClass="inputError imeActive" styleId="plbnotscale" style="width:178px"/></span><span>%</span>
		</td>
	</tr>
	</c:if>
	<tr>
	<td valign="top"><span>日志内容:</span></td><td colspan="3"><span><textarea name="plinfo" cols="78" rows="8">${igprj0101VO.projectLogInfo }</textarea></span></td>
	</tr>
	<tr>
		<td colspan="4">
		<img src="images/attachment.gif" />
		<a href="javascript:addFile();" id="aAddAttach">添加附件</a>
   		<table id="tb">
        </table>
        </td>
	</tr>
	</table>
	<div >
		<input type="hidden" name="pbsummaryListSize" value="${fn:length(igprj0101VO.pbsummaryList) }" />
		<input type="hidden" name="pid" value="${igprj0101VO.project.pid}" />
		<input type="hidden" name="popentime" value="${igprj0101VO.project.popentime}" />
		<input type="hidden" name="pclosetime" value="${igprj0101VO.project.pclosetime}" />
	</div>
	
	</fieldset>
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" />
		<html:button property="btn_back" value="返回" styleClass="button" onclick="window.location='IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}';"/>
	</div>
	</html:form>
	</div>
  </div>
   </div>   
   

</div>
</div>
</html:html>