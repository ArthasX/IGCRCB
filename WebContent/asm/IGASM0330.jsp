<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0330" toScope="request"/>
<bean:define id="title" value="设备批量入库基本信息登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM0331';

		 function checkForm(){
	    		var message = '<bean:message key="IGCO10000.W001" arg0="设备批量入库基本信息" />';
				if( window.confirm(message)){
					var count=0;
	   			 	count=checkAndCreate();
	   				if(count==0){
	   					alert("请您先选择要提交的设备信息记录！");
	   					return false;
	   			 	}
	   			 	if(count==9){
	   				 	return false;
	   			 	}
	   			disableAllButton();
	   			document.forms[0].action=getAppRootUrl() + "/IGASM0317.do";
	 			document.forms[0].submit();

	   			 	return true;
				} else {
					return false;
				}
		 }

		 function checkAndCreate(){
			var count=0;	
			var check = document.getElementsByName("ids");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;

					if($("einames["+i+"]").value.trim() == "" ){
						alert("请填写第"+(i+1)+"行的设备名称！");
						count=9;
						break;
					}
					if($("einames["+i+"]").value.strlen()>120){
						alert("第"+(i+1)+"行的设备名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
						count=9;
						break;
					}
					if($("serials["+i+"]").value.strlen()>2000){
						alert("第"+(i+1)+"行的设备序列号不能大于"+2000+"个字符！");
						count=9;
						break;
					}
				}
			}

			
		    return count;
		}
		 function disableAllButton(){
		 	var el = document.getElementsByTagName("input");

	 		for(var i = 0;i<el.length;i++)
	 		{
	 			if(el[i].type=="button" || el[i].type=="submit" || el[i].type=="reset")
	 			{
	 				el[i].disabled=true;
	 			}
	 		}
	 		
	 		
	 		
	 		try
	 		{
	 			//显示请等候的DIV
	 			var bodyel = document.getElementsByTagName("body");
	 			bodyel[0].innerHTML +="<div id=\"disableAllButtonWaitDIV\" class=\"layer\"><div><div><img src=\"images/loding.gif\" /><br /><bean:message key='IGASM0331.I001' /><br><br></div></div><iframe src=\"javascript:false\" style=\"position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-2; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)';\"></iframe></div>"

	 		}catch(ex)
	 		{
	 			//由于这不是一个主要功能所以隐藏这个异常
	 			//alert("函数发生异常。\n异常内容为:"+ex.description+"\n错误号："+ex.number); 
	 			//throw ex;
	 		}

		 }
	</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
		 <html:form styleId="form" action="/IGASM0317" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 设备批量登记
                </p>
            <div class="back"><html:link href="IGASM0317_Disp_Back.do">返回</html:link></div>
            </div>
		    <div id="formwrapper">

		            <fieldset>
			            <legend>设备基本信息</legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
                            <html:text property="ename" errorStyleClass="inputError imeActive" readonly="true"  styleClass="inputDisable" tabindex="2"/>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>所属机构</strong>：</label>
							<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive" styleClass="inputDisable"></html:text>
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong>设备说明</strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" size="50" tabindex="3" styleClass="inputDisable" errorStyleClass="inputError" readonly="true" />
			                <br>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
                            <html:text property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            
                            <br>
                        </div>
                       </fieldset>
                    </div>
                     <div style="padding-left: 20px"><img src="images/brick.gif" width="13" height="13"/>
                     	&nbsp;设备批量登记信息添加
					</div>
					<div id="results_list">
					 <!--  message -->
                      <ig:message/>
                      <!--  /message -->     	
					
						<table class="table_style">
                        	<tr>
								<th width="5%">
								<label> 
								<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','ids')"/> 
								</label>
								</th>
								<th width="64%" align="left"><span class="red">*</span>设备名称</th>
								<th width="18%" align="left">序列号</th>
								<th></th>
							</tr>
                        	 <logic:present name="IGASM0317Form" property="ids_default" >
			                    <logic:iterate id="bean" name="IGASM0317Form" property="ids_default"  indexId="index" >
			                    <tr>
     							   <td height="20">
									<label>
									 <html:multibox property="ids" value="${IGASM0317Form.ids_default[index]}" />
				 					</label>
								   </td>
								   
									
								   <td align="left">
								   	 <html:text property="einames[${index}]" size="100"  errorStyleClass="inputError imeActive" />
								   </td>
								   <td align="left">
								   	 <html:text property="serials[${index}]"  errorStyleClass="inputError imeActive" />
								   </td>
								   
     							  	<td>
     							  		 <html:hidden property="ids_default" value="${IGASM0317Form.ids_default[index]}"/>
     							  	</td>
     							 </tr> 
		                        
			                    </logic:iterate>
			                </logic:present>
						</table>
					
					</div>	
						
                        
			          
		            <div class="enter">
		                <html:button property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		                <html:reset styleClass="button" value="重置" />
		            </div>
		             <html:hidden property="esyscoding"/>
		             <html:hidden property="eiorgsyscoding"/>
			         <html:hidden property="eid"/>
			         <html:hidden property="pareiid"/>
			         <html:hidden property="addcount"/>
			         <html:hidden property="maxcount"/>
		         	 
		     </html:form>
        </div>
       
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>