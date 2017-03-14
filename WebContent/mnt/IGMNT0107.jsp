<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGMNT0107" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="mntResources" key="ietitle.IGMNT0107"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->

	<style >
		.divCss{
			margin-left:60px; 
			margin-top:10px;
			width:35%;
			float: left;
			clear: none;
		}
		.divCss label {
			width:120px;
		}
		.divObj label {
			float:left;
			width:80px;
			text-align:right;
			margin:2px;
			background-color: #EEEEEE;
			padding-top: 4px;
			padding-right: 2px;
			padding-bottom: 2px;
			padding-left: 4px;
		}
	</style>
	<script type="text/javascript">	
	
	function getAjax(){
		var cnameCid=$('mtCname').value;
		var mtSsn=$('mtSsn').value;
		 //ajax业务运行
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=KPIVAL&cid='+cnameCid+'&mtSsn='+mtSsn,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						var allArr=result.split(":");
						var selectStr=allArr[0];//select字符串
						var objStr=allArr[1];//对象字符串
						var selectArr=selectStr.split(".");
						var kpiStr=selectArr[0];
						var valStr=selectArr[1];
						var valDefaultStr=selectArr[2];
						$('mtKpi').options.length=0;
						$('mtInterval').options.length=0;
						var kpiArr=kpiStr.split(";");
						for(var i=0;i<kpiArr.length;i++){
							var kpioptionArr=kpiArr[i].split(",");
							var kpiovalue=kpioptionArr[0];
							var kpiotext=kpioptionArr[1];
							$('mtKpi').options.add(new Option(kpiotext,kpiovalue));
	   					}
						var valArr=valStr.split(";");
						for(var j=0;j<valArr.length;j++){
							var valoptionArr=valArr[j].split(",");
							var valovalue=valoptionArr[0];
							var valotext=valoptionArr[1];
							$('mtInterval').options.add(new Option(valotext,valovalue));
	   					}
						$('mtInterval').value=valDefaultStr;
						var objArr=objStr.split(",");
						var objTable=$("objTable");
						var tcount=objTable.rows.length;
						//删除所有行
						for(var l=0;l<tcount;l++){
							objTable.deleteRow(0);//永远只删除第二行
						}
						if(objStr!=""&&objStr!=null){
							var num=objArr.length/8;//行数
							for(var k=0;k<num;k++){
							var t2count=objTable.rows.length;//总共有多少行
								var row = objTable.insertRow(t2count);//创建一行
								for(var x=0;x<8;x++){//10个遍历添加
									var objString=objArr[k*8+x];
										var cell1 = row.insertCell(x*2+0);//第一个单元格
										cell1.width="7px";
										var cell2 = row.insertCell(x*2+1);//第二个单元格
										cell2.width="35px";
									if(objString==null){
										objString="";
										cell1.innerHTML="";
									}else{
										cell1.innerHTML=''+
										'<html:checkbox name="IGMNT0107Form" property="selectedid" value="'+objString+'"/>'+
										'';
									}
										cell2.innerHTML=objString;
									
								}
							}
						}
					}else{
						return "";	
					}
			    }
			});
   	}
	function checkSelectNum() {
		var checkCount=$("checkedCount").value;
			var total = 0;
			var tag=document.getElementsByTagName("input");
			for(var i=0;i<tag.length;i++){
				if(tag[i].type=='checkbox'){
					if(tag[i].checked==true) {
						total++;
					}
				}
			}
			if(total>checkCount){
				return true;
			}else{
				return false;
			}
			}
	function insertObj(obj){
		var message = '<bean:message bundle="mntResources" key="message.IGMNT0107.001"/>';
		var confirmVar='<bean:message bundle="mntResources" key="message.IGMNT0107.002"/>';
		var ssnVar='<bean:message bundle="mntResources" key="message.IGMNT0107.004"/>';
		var cname=$("mtCname").value;
		var mtSsn=$("mtSsn").value;
		if(mtSsn==null||mtSsn==""){
			alert(ssnVar);
			return false;
		}
		if(cname!="001"&&checkNum(obj)==0){
			alert(message);
	        return false;
		}
		checkSelectNum();
		if(checkSelectNum()){
			alert('<bean:message bundle="mntResources" key="message.IGMNT0107.003"/>');
			 return false;
		}
		
	    if(window.confirm(confirmVar)){
	       form.action = getAppRootUrl() + "/IGMNT0107_Ins.do";
	        form.submit();
	        return true;
	    } else {
	        return false;
	    }
	}

	</script>

<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
      

    <div id="location">
        <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
	<div id="results_list">
	   			 <!--  message -->
               <ig:message/>
               <!--  /message --> 
		  <html:form styleId="form" action="/IGMNT0107_Ins" onsubmit="return checkSubmit(this);">
				<fieldset>
			<legend><bean:message bundle="mntResources" key="navigation.IGMNT0107.asminsert"/></legend>   
		    	<!-- 存储序列号 -->
		   		<div id="ssnDiv" class="divCss">
		   		<label>
				&nbsp;&nbsp;<span style="color:red">*</span><bean:message bundle="mntResources" key="title.IGMNT0107.mtSsn" />：
				</label> 
				<html:select name="IGMNT0107Form"  styleId="mtSsn" property="mtSsn" style="width: 130px;" errorStyleClass="inputError" >
				<logic:present name="monitorObjectList">
				<html:options collection="monitorObjectList" property="moName" name="" labelProperty="moName" />
				</logic:present>
				</html:select>
				</div>
		    	<!-- 组件类别 -->
		   		<div id="cnameDiv" class="divCss">
		   		<label>
				&nbsp;&nbsp;<bean:message bundle="mntResources" key="select.IGMNT0107.mtCname" />：
				</label> 
				<html:select value="001" name="IGMNT0107Form"  styleId="mtCname" property="mtCname" style="width: 130px;" errorStyleClass="inputError" onchange="getAjax()" >
				<ig:optionsCollection ccid="COMPONENT_TYPE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
				</html:select>
				</div>
				<!-- KPI -->
				<div id="kpiDiv"   class="divCss">
		   		<label>
				&nbsp;&nbsp;<bean:message bundle="mntResources" key="select.IGMNT0107.mtKpi" />：
				</label> 
				<html:select  name="IGMNT0107Form" styleId="mtKpi" property="mtKpi" style="width: 130px;" errorStyleClass="inputError">
				<ig:optionsCollection ccid="SYSTEM_KPI_CODE" isMakeBlankRow="false" isCodeLabel="true" />
				</html:select>
				</div>
				<!-- 采集间隔-->
				<div id="valDiv"   class="divCss">
		   		<label>
				&nbsp;&nbsp;<bean:message bundle="mntResources" key="select.IGMNT0107.mtInterval" />：
				</label> 
				<html:select value="${IGMNT01071VO.interValDefault}" name="IGMNT0107Form" styleId="mtInterval" property="mtInterval" style="width: 130px;" errorStyleClass="inputError">
				<ig:optionsCollection ccid="SYSTEM_VAL_CODE" isMakeBlankRow="false" isCodeLabel="true" />
				</html:select>
				</div>
				<div id="objNameDiv" style="margin-left:60px; width:25%">
				<LABEL style="width: 80px;"><bean:message bundle="mntResources" key="title.IGMNT0107.mtoObj"/>：</LABEL>
				</div>
				<div id="objDiv" align="center" style="height: 350px;overflow-y: auto;margin-left: 25px">
		      	 <table id="objTable" style="width: 90%"  class="table_style" align="center">
		       </table>
				<html:button  style="height:20px;" property="btn_insert"
					styleClass="button" onclick="return insertObj('selectedid');" styleId="btn_insert">
					<bean:message bundle="mntResources" key="button.IGMNT0107.start"/>
				</html:button>
	      		</div>
	     
	    <html:hidden name="IGMNT0107Form" property="mtSsn" value="${IGMNT01071VO.mtSsn}"/>
        <html:hidden name="IGMNT0107Form" property="checkedCount" value="${IGMNT01071VO.checkedCount}"/>
       <input type="hidden" id="tmpMtId" name="tmpMtId" value="${IGMNT01071VO.tmpMtId}">
        </fieldset>
    </html:form>
	    </div>
</div>
<div class="zishiying"></div>

</div>
</div>
</body>
</html:html>