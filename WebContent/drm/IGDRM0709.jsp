<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html:html>
<bean:define id="id" value="IGDRM0709" toScope="request"/>
<bean:define id="title" value="场景参与人调整界面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<style>
	.title{
		width: 100%;
		height: 20px;
		padding:3px;
		margin-right:10px;
		background-color: red;
		margin-top: 5px;
	}
	.table{
		width: 100%;
		text-align: left;
		line-height:30px;
		border-spacing:0;
		border-collapse:collapse;
		border:1;
		margin-top: 5px;
	}
	.table tbody tr{
		border-bottom:#e6e6e6 1px solid;
		border-left: none;
		border-top:none;
		border-right: none;
		background-color:#fff;
		color:#374552;
	}
	table .table th{
		border-left:#fff 1px solid;
		white-space:nowrap;
		border-right:#fff 1px solid;
		padding-bottom:2px;
		line-height:30px;
		padding-right:10px;
		padding-top:2px;
	}
	.table_style4{
		background-color:#eeeeee;
		height:28px;
		color:#000000;
		border-top:#cccccc 1px solid;
		padding-left:7px;
	}
	
	input{
		padding: 0px;
		margin: 0px;
	}
	.panel{
		border:#8dcae9 1px solid;
		padding: 0px 5px 5px 5px;
	}
	.participant_content div{
		text-align: center;
		margin-top: 3px;
 		float: left;
 		border-bottom: 1px solid #CCCEDB;
	}
</style>

<script>
	//全选
	function checkAll(roleid,obj){
		jQ("input[id^='"+roleid+"']").each(function(){
			this.checked = obj.checked;
		});
	}
	function single(checkAllid,checkid,obj){
		
		var checked = obj.checked;
		var allchecked = jQuery("input[id='"+checkAllid+"']")[0].checked;
		if(allchecked){
			if(!checked){
				var checkflag =false;
				var len = jQuery("input[id='"+checkid+"']").length;
				for(var i=0;i<len;i++){
					var checkbox = jQuery("input[id='"+checkid+"']")[i];
					if(checkbox.checked == true){
						checkflag = true; 
						break;
					}
				}
				if(!checkflag){
					jQuery("input[id='"+checkAllid+"']")[0].checked = false;
				}
			}
		}else{
			if(checked){
				jQuery("input[id='"+checkAllid+"']")[0].checked = true;
			}
		}
	}
	function submitUser(){
		if(!window.opener.closed){
			
			var result = new Array();
			var roleids = new Array();
			
			var valResult = new Object();
			
			jQ("input[type='checkbox'][id^='all_']:checked").each(function(){
				//角色用户信息
				var userrole = new Object();
				
				var value = jQ(this).val();
				roleids.push(value.split("#")[0]);
				
				//获取该角色下所有选中的用户
				var userAry = new Array();
				var usernameAry = new Array();
				
				jQ("input[type='checkbox'][id='check_"+value+"']:checked").each(function(){
					userAry.push(jQ(this).val());
					usernameAry.push(jQ(this).val().split("#")[1]);
				});
				
				valResult[value.split("#")[1]] = usernameAry.join(",");
				
				userrole.role = value;
				userrole.userlist = userAry;
				
				result.push(value+"_role_"+userAry.join("_user_"));
				
				//"".replace(/a.*d/g,"a"+""+"d");
				
				
			});
			 window.opener.setUserParam(result,roleids.join(","),valResult);
		}
		 window.close();
	}
</script>
<body >
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content" class="panel">
               <logic:present name="IGDRM07022VO" property="userRoleMap">
               		<logic:iterate id="map" name="IGDRM07022VO" property="userRoleMap">
               			<bean:define id="key" name="map" property="key"></bean:define>
						<div>
							<div class="titletab">
								<table class="table table_style4">
									<tr>
										<th width="80%" style="text-align: left;">
											<label style="text-align: left;   height: 24px;vertical-align: middle;line-height: 24px;">
												<input type="checkbox" id="all_${key}" style="margin-left: 15px;margin-right: 5px; " onclick="checkAll('check_${key}',this)" value="${key}">
											</label>
											<label >${fn:split(key,"#")[1]}</label>
											<input type="hidden" name="role" value="${key}">
										</th>
										<th width="20%">
											<img width="12" height="12" id="image_${key}" style="cursor: hand;" onclick="toggleElement('role_${key}','image_${key}', '1')" src="images/minus.gif"/>
										</th>
									</tr>
								</table>
							</div>
							<div class="contenttab" id="role_${key}">
								<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
               					<logic:notEmpty name="list">
               						<logic:iterate id="bean" name="list" type="com.deliverik.framework.user.model.entity.UserTB" indexId="indexNum">
               							<div class="participant_content" style="line-height: 24px; width: 100%; height: 24px; clear: both;" show="1">
               								<div style="width: 5%;margin-left:1px; ">
               									<input id="check_${key}" style="margin-top: 4px;" type="checkbox" onclick="single('all_${key}','check_${key}',this)" value="${bean.userid}#${bean.username}"/>
               								</div>
               								<div style="width: 20%;" >
               									${bean.username}
               								</div>
               								<div style="width: 25%; ">
               									${bean.usermobile}
               								</div>
               								<div style="width: 48%;">
               									${bean.orgname}
               								</div>
               							</div>
               						</logic:iterate>
               					</logic:notEmpty>
							</div>
						</div>
               		</logic:iterate>
               </logic:present> 
		 </div>
		 <div align="center" style="margin-top: 5px;margin-right: 5px;">
			 <button class="button" id="ok_btn" onclick="submitUser()">确定</button>
		 </div>
     </div>
</div>
</div>
</body>
</html:html>