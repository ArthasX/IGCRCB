<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGAFF0101" toScope="request"/>
<bean:define id="title"  toScope="request">
	主机影响分析画面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">

	function setParam(eiid, einame){
		$("eiid").value = eiid;
		$("einame").value = einame;
	}
	
	function checkForm(){
		if($F('einame').trim()==""){
			alert("请选择主机");
			return false;
		}else {
			return true;
		}
	}


	 function selectEntityItem(){
	     	openSubWindow('/IGAFF0000_Disp.do?paramEsyscoding=999001001', '', '850', '600');
     }
	 function showView(eiid){
		// openSubWindow("/IGAIM0148.do?EIID="+eiid,'','1366', '768' );
		 var url="/IGAIM0148.do?EIID="+eiid;
			var obj = window.showModalDialog("<%=request.getContextPath()%>" + url,null,"dialogWidth:1000px;dialogHeight:700px;status:no;help:no;resizable:yes");
			if(obj != null){ 
				window.parent.location.href = obj;
			}
	 }
</script>

<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGAFF0101"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div>
			                <label><span class="red">*</span>主机</label>
			                <html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="15" ><script type="text/javascript">printBRByScreenWidth();</script></html:text>
	                         <html:hidden property="eiid"/>
	                        <img src="images/seek.gif" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGCIM0901.search.alt"/>' onclick="selectEntityItem()" style="cursor: hand"/>&nbsp;&nbsp; 
                        <html:submit property="btn_search"   styleClass="button" onclick="return checkForm();">
                        		<bean:message bundle="asmResources" key="button.IGCIM0101.btn_search"/>
                        </html:submit>
                        </div>
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
								<th>序号</th>
								<th>业务系统名称</th>
								<th>业务系统编号</th>
								<th>应用说明</th>
								<th>更新时间</th>
								<th>影响分析</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGAFF01011VO" property="soc0118List" >
			                	<bean:define id="vo"  name="IGAFF01011VO" />
			                    <logic:iterate id="bean" name="IGAFF01011VO" property="soc0118List" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                           
			                            <td>
                                            <div class="nowrapDiv">
                                            	${PagingDTO.viewStartCount+index}
                                            </div>
			                            </td>
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.einame}
                                            </div>
			                            </td>
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eilabel}
                                            </div>
			                            </td>
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eidesc}
                                            </div>
			                            </td>
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiupdtime}
                                            </div>
			                            </td>
			                         	<td>
			                         		 <div class="nowrapDiv">
			                         		 	<img SRC ="images\igsym0101.gif" style="cursor: pointer;" alt="影响分析" onclick="showView('${bean.eiid}')"/>	
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
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM0101Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>