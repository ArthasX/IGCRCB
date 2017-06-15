<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM0406" toScope="request"/>
<bean:define id="title" value="应急资源查询" toScope="request">
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGDRM0704';
        function setParentValue(eid, elabel, ename, eiid, eilabel, einame,ecategory,eiversion,esyscoding){
        	if(!window.opener.closed){
	        	if(document.forms[0].pidid.value=="" || document.forms[0].pidid.value==null){
	        		if(document.getElementById("parFlag").value){
	        			window.opener.setParamIGDRM0406(eid, elabel, ename, eiid, eilabel, einame ,ecategory);
	        		}else{
		        		window.opener.setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame ,ecategory,esyscoding);
	        		}
	        			
	            }else{
	            		document.getElementById("esyscoding").value = esyscoding;
	            		if(document.getElementById("parFlag").value){
	            			window.opener.setParamIGDRM0406(eid, elabel, ename, eiid, eilabel, einame , ecategory, document.forms[0].pidid.value,eiversion);	 			
	            		}else{
		 	                window.opener.setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame , ecategory, document.forms[0].pidid.value,eiversion,esyscoding);
	            		}
	 		 	}
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
            	if(document.getElementById("parFlag").value){
            		 window.opener.setParamIGDRM0406("", "", "", "", "", "" ,"");
            	}else{
	            	var esycode = document.getElementById("esyscoding").value;
	                window.opener.setParamIGCOM0302("", "", "", "", "", "" ,"","","",esycode);
            	}
            		
            }
            window.close();
        }
        function setEntity(url){

        	if(document.forms[0].ecategory.value.trim()!="" && document.forms[0].ecategory.value.trim()!="SDL" ){
        		url+=document.forms[0].ecategory.value;
            	}
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
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
					alert('<bean:message bundle="comResources" key="message.IGCOM0302.001"/>');
					return false;
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}

//         function toAdd(){
//         	window.location.href=getAppRootUrl()+"/IGDRM0408_Disp.do?parFlag="+jQ("#parFlag").val()+"&pidid="+document.forms[0].pidid.value;
//         }
        
	</script>
<style>
.nowrapDiv{
		text-align:center;
	}
</style>
<body onload="startCheckOpenerClosed();">
	<div id="location">
                <div class="image"></div>
                  <p class="fonts1" id = "navi">    </p>
     </div> 
<div id="maincontent" style="width:800px;margin: 0 auto;">
        <html:form styleId="form" action="/IGDRM0406" onsubmit="return checkSubmit(this);">
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<html:hidden styleId="parFlag" name="IGDRM0406Form"  property="parFlag"/>
                	<html:hidden name="IGDRM0406Form" property="ename" styleId="ename"  />
					<html:hidden name="IGDRM0406Form" property="esyscodingbegin" styleId="esyscodingbegin"/>
					<html:hidden name="IGDRM0406Form" property="esyscoding" styleId="esyscoding"/>&nbsp;&nbsp;
	                <label id ="labeiname"></label>
	                <html:text name="IGDRM0406Form" property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="35"/> 
	             	<html:submit property="btn_search"  styleClass="button"><bean:message bundle="comResources" key="button.IGCOM0302.search"/></html:submit>
<%-- 	           		<html:button property="btn_Add" styleClass="button" onclick="toAdd();">登记资源</html:button> --%>
	             </div>
			</div>
		</div>
		<div id="results_list">
               <!--  message -->
               <ig:message/>
               <!--  /message -->     
	       <table width="100%" class="table_style">
	            <!-- header部 -->
	         
	                <tr>
                        <th width="5%">选择</th> 
                        <th width="15%" class = "tdname">分类</th>
                        <th width="15%" class = "tdname" >编号</th>
                        <th width="15%" class = "tdname">名称</th>
                        <th width="10%">管理人</th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGDRM04061VO" property="entityDataList" >
	                    <logic:iterate id="bean" name="IGDRM04061VO" property="entityDataList" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             
                                              <img src="images/select_asset.gif" border="0" alt="<bean:message bundle="comResources" key="img.IGCOM0302.select.alt"/>" onclick="javaScript:setParentValue(
                                                  '${bean.eid}',
                                                  '${bean.elabel}',
                                                  '${bean.ename}',         
                                                  '${bean.eiid}',
                                                  '${bean.eilabel}',
                                                  '${bean.einame}',
                                                  '${bean.ecategory}',
                                                  '${bean.eiversion}',
                                                  '${bean.esyscoding}'         
                                              );"/>
                                              
                                          </div>
                                      </td>
                                      <!-- 名称 -->
                                      <td>
                                          <div class="nowrapDiv">
                                          <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
                                          ${bean.ename}
                                          </div>
                                      </td>
	                            <!-- 编号 -->
	                            <td>
	                                <div class="nowrapDiv" >
                                              ${bean.eilabel}
	                                </div>
	                            </td>
	                            <!-- 名称 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
	                                ${bean.einame}
	                                </div>
	                            </td>
	                            <!-- 管理人 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
	                                ${bean.eiusername}
	                                </div>
	                            </td>
	                       
	                        </tr>
	                    </logic:iterate>
	                </logic:present>
	         
	       </table>
		</div>
	    <div id="operate">
	                <!-- paging -->
	                <jsp:include page="/include/paging.jsp"/>
	                <!-- /paging -->
                <div class="enter">
                	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGDRM0406Form" property="ecategory" styleId="ecategory"/>
	    <html:hidden name="IGDRM0406Form" property="pidid" styleId="pidid"/>
	    <html:hidden name="IGDRM0406Form" property="esyscoding" styleId="esyscoding"/>
	    <html:hidden name="IGDRM0406Form" property="sp_eiid" styleId="sp_eiid"/>
	    <html:hidden name="IGDRM0406Form" property="queryflag" styleId="queryflag"/>
    </html:form>


</div>
</body>
<script type="text/javascript">


	jQ(function(){
		var esyscoding = jQ("#esyscoding").val();
		var ename ;
		if(/999040.*/.test(esyscoding)){
			ename = "应急资源";
		}else if(/999050.*/.test(esyscoding)){
			ename = "专项预案";
		}else if(/999060.*/.test(esyscoding)){
			ename = "场景";
		}else{
			ename = "资产";
		}
		jQ("#navi").html(ename+"查询");
		document.title = ename+"查询";
		jQ("#labeiname").html(ename+"名称：");
		if(this.openFlag){
			alert(333);
		}
		jQ(".tdname").each(function(i,t){
			t = jQ(t);
			t.html(ename+t.html());
			
		})
	})
		
	

</script>
</html:html>