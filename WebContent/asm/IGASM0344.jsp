<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0344" toScope="request" />
<bean:define id="title" value="设备配置信息历史版本画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

	function toClose() {
		window.close();
	}

	function checkboxSubmit(){

		count = checkNumber();
    	if(count==0){
    		message = "请选择要比对的版本！";
    		alert(message);
            return;
    	}else if(count!=2){
    		message = "请在列表中选择两个历史版本进行比对！";
    		alert(message);
            return;
    	}
    	var url = "/IGASM0345_Disp.do?eiid="+<%=request.getParameter("eiid")%>+"&pre="+pre+"&next="+next;
    	openSubWindow(url, '_blank', '800', '600');
	}

	function checkNumber(){
		var count=0;
		var checkbox = document.getElementsByName("checkbox");
		
		for(var i=0;i<checkbox.length;i++){
			if(checkbox[i].checked==true){
				count++;
			}
		}
		if(count==2){
			var num=0;
			for(i=0;i<checkbox.length;i++){
				if(checkbox[i].checked==true){
					if(num==0){
						pre=checkbox[i].value;
						num++;
					}else if(num==1){
						next=checkbox[i].value;
						break;
					}
				}
			}
		}
		return count;
	}
	
</script>
<body>

<div class="title">
<div class="name">历史版本信息</div>
</div>

<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
		 	<th width="10%"></th>
			<th width="45%">版本号</th>
			<th width="45%">修改时间</th>
		 </tr>
		 <logic:present name="IGASM03051VO" property="configItemVersionTime">
			<logic:iterate id="bean" name="IGASM03051VO" property="configItemVersionTime"
				indexId="index">
				<tr>
					<td>
						<input name="checkbox" type="checkbox" value="${bean.civersion}<c:if test="${IGASM03051VO.entityData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if>" />
					</td>
		       		<td>
				       ${bean.civersion}<c:if test="${IGASM03051VO.entityData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if>版
		       		</td>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<input onclick="checkboxSubmit();" type="button"  class="button" value="配置文件比较">
	<input onclick="toClose();" type="button"  class="button" value="关闭">
</div>

</body>
</html:html>