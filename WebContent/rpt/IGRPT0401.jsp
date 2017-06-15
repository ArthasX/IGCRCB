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
<bean:define id="id" value="IGRPT0401" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="rptResources" key="ietitle.IGRPT0401"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">

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

function setTab(num,size){
	 for(var i=0;i<size;i++){
		 var menu=document.getElementById(i);
		 var con=document.getElementById("con_"+i);
		 if(i==num){
			 menu.className="hover";
			 con.style.display="block";
		 }else{
			 menu.className="";
			 con.style.display="none";
		 }
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
		retv=window.showModalDialog("IGCOM0215.do?rfdtype="+rfdtype,window,"dialogWidth:750px;dialogHeight:600px;status:no;help:no;resizable:no;titlebar:no;toolbar:no;");
		if(typeof(retv)!="undefined"){
			aclick('con_two_1','con_two_1_'+name);
			$('frmPerformanceReportContext').src="IGSYM1407_Disp.do?reportname="+retv.split(",")[0]+"&objectType="+retv.split(",")[1]+"&dataid="+name+"&fatherName="+fatherName+"&rfdTitle="+encodeURI(encodeURI(retv.split(",")[2]));
		}
	}
	//服务
	function serviceFrm(rfdid,divid,reportname,rfdpictype,isFlag,parnum){ 
		aclick(divid,divid+'_'+reportname);
		$('frmPerformanceReportContext'+parnum).src="IGRPT0402_Disp.do?templateName="+reportname+"&rfdpictype="+rfdpictype+"&isFlag="+isFlag+"&rfdid="+rfdid;
	}
</script>
<body onload="setTab(${0},${numIndex})">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" /> 
<!--container 左菜单 右侧内容-->
	<div id="container" style="height:100%;margin-top: 10px;background-color: transparent"><!--content  右侧内容-->
	
	<div class="Menubox">
    <ul>
    <bean:size id="size" name="IGRPT04011VO" property="parCodeDetailList" />
    <logic:iterate id="parCodeDetail" name="IGRPT04011VO" property="parCodeDetailList" indexId="num">
    	<li id="${num}" onClick="setTab(${num},${size})">${parCodeDetail.cvalue}</li>
    </logic:iterate>
  	</ul>
    </div>
    
    <div class="Contentbox">
    <logic:iterate id="parCodeDetail" name="IGRPT04011VO" property="parCodeDetailList" indexId="parnum">
	   <div id="con_${parnum}" style="">
       <div class="siderbar_nav">
          <TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
        	<TBODY>
            <TR>
            <TD width="15" background="YHMenu.files/new_008.jpg"></TD>
            <TD vAlign="top" width="130" bgColor="#ffffff">
            <TABLE cellSpacing="0" cellPadding="0" width="130" align="left" border="0">
                <TBODY id="tbody_${parnum }">
                
                <logic:present name="IGRPT04011VO" property="cldCodeDetailList" >
                <bean:size id="size" name="IGRPT04011VO" property="cldCodeDetailList"/>
               <logic:iterate id="bean" name="IGRPT04011VO" property="cldCodeDetailList" indexId="cldnum">
               <c:if test="${bean.psyscoding==parCodeDetail.syscoding}">
               
                  <TR>
                   <TD  style="cursor:pointer ;" class="mainMenu" onClick="MenuDisplay('tbody_${parnum }','table_${cldnum}');">
                   <SPAN class="span" id="table_${cldnum}Span">＋</SPAN> ${bean.cvalue}
            		</TD>
                  </TR>
                  
                  <logic:present name="IGRPT04011VO" property="rfdList" >
                  <TR>
                    <TD >
                    	<TABLE id="table_${cldnum}" style="DISPLAY: none" cellSpacing="0" cellPadding="2" 
            width="130" align="center" border="0">
                        <TBODY>
	               		 <logic:iterate id="rfd" name="IGRPT04011VO" property="rfdList" indexId="index">
	               		 <c:if test="${rfd.rfdtype==bean.syscoding}">
	                          <TR>
	                            <TD class="menuSmall"><A class="style2" id="con_two_2_${rfd.rfdfilename}" class="style2" href="#" onclick="serviceFrm('${rfd.rfdid}','con_${parnum}','${rfd.rfdfilename}','${rfd.rfdpictype}','${rfd.isFlag}'),'${parnum}'">－${rfd.rfdtitle}</A></TD>
	                          </TR>
	                     </c:if>
		           		</logic:iterate>
                		</TBODY>
                     	</TABLE>
                     </TD>
         		 </TR>
	             </logic:present>
	             </c:if>
         		  </logic:iterate>
                </logic:present>
                
                <logic:iterate id="map" name="IGRPT04011VO" property="rfdtypeMap" >
                <bean:define id="rfdtype" name="map" property="key" type="java.lang.String"></bean:define>
                <c:if test="${parCodeDetail.syscoding==rfdtype}">
                	<TR>
	                	<TD  style="cursor:pointer ;" class="mainMenu" onClick="MenuDisplay('tbody_${parnum }','table2_${parnum}');"><SPAN 
	            class="span" id="table2_${parnum}Span">＋</SPAN> ${parCodeDetail.cvalue}
	            		</TD>
                    </TR>
                    <logic:present name="IGRPT04011VO" property="rfdList" >
		                  <TR>
		                    <TD >
		                    	<TABLE id="table2_${parnum}" style="DISPLAY: none" cellSpacing="0" cellPadding="2" 
		            width="130" align="center" border="0">
		                        <TBODY>
			               		 <logic:iterate id="rfd" name="IGRPT04011VO" property="rfdList" indexId="index">
			               		 <c:if test="${rfd.rfdtype==parCodeDetail.syscoding}">
			                          <TR>
			                            <TD class="menuSmall"><A class="style2" id="con_two_2_${rfd.rfdfilename}" class="style2" href="#" onclick="serviceFrm('${rfd.rfdid}','con_${parnum}','${rfd.rfdfilename}','${rfd.rfdpictype}','${rfd.isFlag}','${parnum}')">－${rfd.rfdtitle}</A></TD>
			                          </TR>
			                     </c:if>
				           		</logic:iterate>
		                		</TBODY>
		                     	</TABLE>
		                     </TD>
		         		 </TR>
	             	</logic:present>
                </c:if>
		        </logic:iterate>
		             
            </TBODY>
      		</TABLE>
      		</TD>
            <TD width="15" background="YHMenu.files/new_009.jpg"></TD>
          </TR>
          </TBODY>
      </TABLE>
        </div>
          <iframe id="frmPerformanceReportContext${parnum}" src="" width="835" height="530" marginheight="0" marginwidth="0" scrolling="no" frameborder="0" align="middle"></iframe> 
      </div>
    </logic:iterate>
    
    
    
      
	</div>
	</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>