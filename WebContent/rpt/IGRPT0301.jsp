<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
 <link href="styles/baobiao.css" rel="stylesheet" type="text/css" />
<bean:define id="id" value="IGRPT0301" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="rptResources" key="ietitle.IGRPT0301"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">

	function initReport(){
		var rclReportType="${IGRPT0301Form.rclReportType}";
		var rclObjName="${IGRPT0301Form.rclObjName}";
		var rclObjType="${IGRPT0301Form.rclObjType}";
		var rclCaType="${IGRPT0301Form.rclCaType}";
		var tabNum=1;
		if(rclReportType=='01'){
			tabNum=1;
			var rclTemDesc="${IGRPT0301Form.rclTemDesc}";
			var rclTemName="${IGRPT0301Form.rclTemName}";
			var rclRfdTitle="${IGRPT0301Form.rclRfdTitle}";
			var encodeTitle=encodeURI(encodeURI(rclRfdTitle));
			MenuDisplay('performance_tbody','performance_table_'+rclObjType);
			aclick('con_two_1','con_two_1_'+rclObjName);
			$('frmPerformanceReportContext').src="IGSYM1407_Disp.do?reportname="+rclTemName
			+"&objectType="+rclTemDesc+"&dataid="+rclObjName+"&fatherName="+rclObjType+"&rfdTitle="+encodeTitle+"&rclCaType="+rclCaType;
		}else if(rclReportType=='03'){
			tabNum=3;
			var rclObjEiid="${IGRPT0301Form.rclObjEiid}";
			var rclMode="${IGRPT0301Form.rclMode}";
			MenuDisplay('capacity_tbody','capacity_table_'+rclObjType);
			if(rclMode=='sum'){
				aclick('con_two_3','con_two_3_'+rclObjType+"_"+rclMode);
			}else{
				aclick('con_two_3','con_two_3_'+rclObjType+"_"+rclObjEiid);
			}
			$("frmCapatityReportContext").src="IGRPT0302_Disp.do?objType="+rclObjType+"&mode="+rclMode
			+"&objName="+rclObjName+"&eiid="+rclObjEiid+"&rclCaType="+rclCaType;
		}
		setTab('two',tabNum,3);

	}



function aclick(divId,linkId) {
     var links = $(divId).getElementsByTagName("a");
    for (var i = 0; i < links.length; i++) {
        var link = links[i];
        links[i].style.color = "#0055bb";
    } 
    if($(linkId)!=null){
    	$(linkId).style.color="red"; 
    }          
}


function setTab(name,cursel,n){
	 for(i=1;i<=n;i++){
	  var menu=document.getElementById(name+i);
	  var con=document.getElementById("con_"+name+"_"+i);
	  menu.className=i==cursel?"hover":"";
	  con.style.display=i==cursel?"block":"none";
	 }
	}
function MenuDisplay(bodyName,obj)
{	
	if($(bodyName)!=null){
		var tables=$(bodyName).getElementsByTagName('table');
		var spans=$(bodyName).getElementsByTagName('span');
		for (var i = 0; i < tables.length; i++) {
			tables[i].style.display='none';
	    } 
		for (var j = 0; j < spans.length; j++) {
			spans[j].innerText='＋';
	    }
	    if($(obj)!=null){
			$(obj).style.display='block';
			$(obj+'Span').innerText='－';
		}
	}
	
}
	//容量frm
	function cgFrmSrc(objType,mode,objName,eiid){
		if(mode=='sum'){
			aclick('con_two_3','con_two_3_'+objType+'_'+mode);
		}else{
			aclick('con_two_3','con_two_3_'+objType+'_'+eiid);
		}
		$("frmCapatityReportContext").src="IGRPT0302_Disp.do?objType="+objType+"&mode="+mode+"&objName="+objName+"&eiid="+eiid;
	}
	//性能
	var retv;//创建子窗体返回值
	function performanceFrm(rfdtype,name,fatherName){
		retv=window.showModalDialog("IGCOM0215.do?rfdtype="+rfdtype,window,"dialogWidth:500px;dialogHeight:500px;status:no;help:no;resizable:no;titlebar:no;toolbar:no;");
		if(typeof(retv)!="undefined"){
			aclick('con_two_1','con_two_1_'+name);
			$('frmPerformanceReportContext').src="IGSYM1407_Disp.do?reportname="+retv.split(",")[0]+"&objectType="+retv.split(",")[1]+"&dataid="+name+"&fatherName="+fatherName+"&rfdTitle="+encodeURI(encodeURI(retv.split(",")[2]));
		}
	}
	//服务
	function serviceFrm(reportname){ 
		aclick('con_two_2','con_two_2_'+reportname);
		$('frmServiceReportContext').src="IGRPT0302_ServiceDisp.do?templateName="+reportname;
	}
</script>
<body onload="initReport()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" /> 
<!--container 左菜单 右侧内容-->
	<div id="container" style="height:100%;margin-top: 10px;background-color: transparent"><!--content  右侧内容-->
	<div class="Menubox">
      <ul>
    	<!-- 性能报表 -->
    <li id="two1" onClick="setTab('two',1,3)" ><bean:message bundle="rptResources" key="label.IGRPT0301.performanceReport"/></li>
	<!-- 服务报表 -->
    <li id="two2" onClick="setTab('two',2,3)" ><bean:message bundle="rptResources" key="label.IGRPT0301.serviceReport"/></li>
	<!-- 容量报表 -->
    <li id="two3" onClick="setTab('two',3,3)"><bean:message bundle="rptResources" key="label.IGRPT0301.capacityReport"/></li>
	<!-- 资产报表 onClick="setTab('two',4,4)"-->
<!--    <li id="two4" ><bean:message bundle="rptResources" key="label.IGRPT0301.assetsReport"/></li>-->
	
  </ul>
    </div>
    <div class="Contentbox">
      <div id="con_two_1" style="display:none">
      
       <div class="siderbar_nav">
          <TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
        <TBODY>
              <TR>
            <TD width="15" background="YHMenu.files/new_008.jpg"></TD>
            <TD vAlign="top" width="130" bgColor="#ffffff"><TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
                <TBODY id="performance_tbody">
                <logic:present name="IGRPT03011VO" property="catagoryCodeDeatilList" >
                <bean:size id="size" name="IGRPT03011VO" property="catagoryCodeDeatilList"/>
               <logic:iterate id="bean" name="IGRPT03011VO" property="catagoryCodeDeatilList" indexId="num">
                  <TR>
                   <TD  style="cursor:pointer ;" class="mainMenu" onClick="MenuDisplay(performance_tbody,'performance_table_${bean.cvalue}');"><SPAN 
            class="span" id="performance_table_${bean.cvalue}Span">＋</SPAN> ${bean.cvalue}
            		</TD>
                  </TR>
                   <logic:present name="IGRPT03011VO" property="objCodeDeatilList" >
                  <TR>
                    <TD ><TABLE id="performance_table_${bean.cvalue}" style="DISPLAY: none" cellSpacing="0" cellPadding="2" 
            width="130" align="center" border="0">
                        <TBODY>
               		 <logic:iterate id="obj" name="IGRPT03011VO" property="objCodeDeatilList" indexId="index">
               		 <c:if test="${obj.pcid==bean.cid}">
                          <TR>
                            <TD class="menuSmall"><A class="style2" id="con_two_1_${obj.cvalue}" href="#" onclick="performanceFrm('${obj.syscoding}','${obj.cvalue}','${bean.cvalue}')">－${obj.cvalue}</A></TD>
                          </TR>
                     </c:if>
	           </logic:iterate>
                </TBODY>
                      </TABLE></TD>
         		 </TR>
		             </logic:present>
         		  </logic:iterate>
                </logic:present>
            </TBODY>
      </TABLE></TD>
            <TD width="15" background="YHMenu.files/new_009.jpg"></TD>
          </TR>
            </TBODY>
      </TABLE>
        </div>
          <iframe id="frmPerformanceReportContext" src="" width="835" height="530" marginheight="0" marginwidth="0" scrolling="no" frameborder="0" align="middle"></iframe> 
      </div>
      
      <div id="con_two_2" style="display:none">
      <div class="siderbar_nav">
          <TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
        <TBODY>
              <TR>
            <TD width="15" background="YHMenu.files/new_008.jpg"></TD>
            <TD vAlign="top" width="130" bgColor="#ffffff"><TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
                <TBODY id="service_tbody">
                  <TR>
                   <TD  style="cursor:pointer ;" class="mainMenu" onClick="MenuDisplay('service_tbody','service_table_service');"><SPAN 
            class="span" id="service_table_serviceSpan">＋</SPAN> <bean:message bundle="rptResources" key="label.IGRPT0301.serviceReport"/>
            		</TD>
                  </TR>
                   <logic:present name="IGRPT03011VO" property="reportFileDefinitionList" >
                  <TR>
                    <TD><TABLE id="service_table_service" style="DISPLAY: none" cellSpacing="0" cellPadding="2" width="130" align="center" border="0">
                        <TBODY>
               		 <logic:iterate id="obj" name="IGRPT03011VO" property="reportFileDefinitionList" indexId="index">
                          <TR>
                            <TD class="menuSmall"><A id="con_two_2_${obj.rfdfilename}" class="style2" href="#" onclick="serviceFrm('${obj.rfdfilename}')">－${obj.rfdtitle}</A></TD>
                          </TR>
	           		 </logic:iterate>
                 </TBODY>
                      </TABLE></TD>
         		 </TR>
		             </logic:present>
            </TBODY>
      </TABLE></TD>
            <TD width="15" background="YHMenu.files/new_009.jpg"></TD>
          </TR>
            </TBODY>
      </TABLE>
        </div>
         <iframe id="frmServiceReportContext" src="" width="835" height="530" marginheight="0" marginwidth="0" scrolling="no" frameborder="no" align="middle"></iframe>  
      </div>
      
  <div id="con_two_3" style="display:none">
    <div class="siderbar_nav" >
      <TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
        <TBODY>
              <TR>
            <TD width="15" background="YHMenu.files/new_008.jpg"></TD>
            <TD vAlign="top" width="130" bgColor="#ffffff"><TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
                <TBODY  id="capacity_tbody">
                  <TR>
                    <TD  style="cursor:pointer ;" class="mainMenu" onClick="MenuDisplay('capacity_tbody','capacity_table_storage');"><SPAN 
            class="span" id="capacity_table_storageSpan">＋</SPAN> <bean:message bundle="rptResources" key="label.IGRPT0301.ssn"/></TD>
                  </TR>
                  <TR>
                    <TD><TABLE id="capacity_table_storage" style="DISPLAY: none" cellSpacing="0" cellPadding="2" 
            width="130" align="center" border="0">
                        <TBODY>
                        <logic:present  name="IGRPT03011VO" property="scList" >
				 		<bean:size id="size" name="IGRPT03011VO" property="scList"/>
				 		<c:if test="${size>0}">
				 		<!-- <div onclick="cgFrmSrc('storage','sum','','')">－总存储</div> -->
				 		<TR>
                            <TD class="menuSmall"><A id="con_two_3_storage_sum" class="style2" href="#" onclick="cgFrmSrc('storage','sum','','')">－<bean:message bundle="rptResources" key="label.IGRPT0301.allSsn"/></A></TD>
                        </TR>
				 		</c:if>
				 		<logic:iterate id="bean" name="IGRPT03011VO" property="scList" indexId="index">
				 		<TR>
                            <TD class="menuSmall"><A id="con_two_3_storage_${bean.eiid}" class="style2" href="#" onclick="cgFrmSrc('storage','single','${bean.einame}','${bean.eiid}')">－${bean.einame}</A></TD>
                        </TR>
						<!-- <div onclick="cgFrmSrc('storage','single','${bean.einame}','${bean.eiid}')">${bean.einame}</div> -->
				 		</logic:iterate>
				 		</logic:present>
                        </TBODY>
                      </TABLE></TD>
                  </TR>
                  <TR>
                    <TD background="YHMenu.files/new_027.jpg" height="1"></TD>
                  </TR>
                  <TR>
                    <TD class="mainMenu" onClick="MenuDisplay('capacity_tbody','capacity_table_business');"><SPAN 
            class="span" id="capacity_table_businessSpan">＋</SPAN> <bean:message bundle="rptResources" key="label.IGRPT0301.business"/></TD>
                  </TR>
                  <TR>
                    <TD><TABLE id="capacity_table_business" style="DISPLAY: none" cellSpacing="0" cellPadding="2" 
            width="130" align="center" border="0">
                        <TBODY>
                        <logic:present name="IGRPT03011VO" property="bcVWList" >
			 		<logic:iterate id="bean" name="IGRPT03011VO" property="bcVWList" indexId="index">
					<!-- <div  onclick="cgFrmSrc('business','single','${bean.einame}','${bean.eiid}')">${bean.einame}</div> -->
                          <TR>
                            <TD class="menuSmall"><A id="con_two_3_business_${bean.eiid}" class="style2" href="#" onclick="cgFrmSrc('business','single','${bean.einame}','${bean.eiid}')">－${bean.einame}</A></TD>
                          </TR>
			 		</logic:iterate>
			 		</logic:present>
                        </TBODY>
                      </TABLE></TD>
                  </TR>
                  <TR>
                    <TD background="YHMenu.files/new_027.jpg" height="1"></TD>
                  </TR>
                  <TR>
                    <TD class="mainMenu" onClick="MenuDisplay('capacity_tbody','capacity_table_host');"><SPAN 
            class="span" id="capacity_table_hostSpan">＋</SPAN> <bean:message bundle="rptResources" key="label.IGRPT0301.host"/></TD>
                  </TR>
                  <TR>
                    <TD><TABLE id="capacity_table_host" style="DISPLAY: none" cellSpacing="0" cellPadding="2" 
            width="130" align="center" border="0">
                        <TBODY>
                        <logic:present name="IGRPT03011VO" property="hcVWList" >
		 		<logic:iterate id="bean" name="IGRPT03011VO" property="hcVWList" indexId="index">
				<!-- <div  onclick="cgFrmSrc('host','single','${bean.einame}','${bean.eiid}')">${bean.einame}</div> -->
                          <TR>
                            <TD class="menuSmall"><A id="con_two_3_host_${bean.eiid}" class="style2" href="#" onclick="cgFrmSrc('host','single','${bean.einame}','${bean.eiid}')">－${bean.einame}</A></TD>
                          </TR>
		 		</logic:iterate>
		 		</logic:present>
                          
                        </TBODY>
                      </TABLE></TD>
                  </TR>
            </TBODY>
      </TABLE></TD>
            <TD width="15" background="YHMenu.files/new_009.jpg"></TD>
          </TR>
            </TBODY>
      </TABLE>
        </div>
        <iframe id="frmCapatityReportContext" src="" width="835" height="530" marginheight="0" marginwidth="0" scrolling="no" frameborder="no" align="middle">11</iframe>
        <!-- <iframe name="ifm" src="a.html" width="842" height="530" marginheight="0" marginwidth="0" scrolling="no" frameborder="no" align="middle"></iframe> -->
      </div>
 	 </div>


	</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>