<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html:html>
<bean:define id="id" value="IGCIC0102" toScope="request" />
<bean:define id="title" value="新增对比规则" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">

	#dvComRole{
		padding:10px;
		text-align: center;
		margin-top:10px;
		text-align: left;
	}
	#dvComRole span,select {
		vertical-align: middle;
		line-height: 25px;
	}
	#addBtn_box{
		text-align: right;
		margin-top: 20px;
	}
	.sub_box{
		text-align: right;
	}	
	.dvobj{
		margin-top: 20px;
		padding:10px;
		border:1px solid #b6e0f7;
		background-color: #E7F5FE;
	}
	.tbstyle{
		width:100%;
		border-collapse: collapse;
	}
	.tbstyle th{
		text-align: right;
		padding-right: 15px;
	}
	.warp_box{
		border: 1px solid #234566;
		width: 260px;
		height: 160px;
		float: left;
		margin-right: 60px;
		background: #FFF;
		text-align: center;
	}
	.dvobj span{
		color:#06479e;
	}
	.warp_box ul{
		list-style: none;
		width: 100%;
		float: left;
		margin-left: 0px;
		
	}
	.warp_box span{
		color:#C3C3C3;
	}
	.warp_box ul li{
		float: left;
		cursor: pointer;
		width: 100%;
		margin-left: 0px;
		height: 28px;
		line-height: 28px;
		vertical-align: middle;
		text-indent: 10px;
		text-align: left;
	}
	.errorBox{
		border:1px solid #f00;
	}
	.hoverli{
		background-color: #D1E7FE;
	}
	#content select{
		border:1px solid #B3E0FD;
		width: 150px;
	}
	.btnBg{
		background: url("images/btn.jpg");
		width: 60px;
		height: 22px;
		border: 0px;
	}
</style>

<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCIC0102" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/>&gt;&gt;
		<c:if test="${IGCIC01021VO.compareRoleInfo.crid == null}">
			新建对比规则 
		</c:if>
		<c:if test="${IGCIC01021VO.compareRoleInfo.crid != null}">
			修改对比规则 
		</c:if>
	
	</p>
	<div class="back"><html:link href="javascript:goback();">返回</html:link></div>
	</div>
	<div id="dvComRole">

	<div><span>业务系统名称：&nbsp;&nbsp;</span>
		<html:select property="crsystemid" styleId="crsystemid" value="${IGCIC01021VO.compareRoleInfo.crsystemid }">
			<html:option value=""></html:option>
			<html:optionsCollection name="IGCIC01021VO" property="systemList" label="einame" value="eiid"/>
		</html:select>
		<html:hidden property="crsystemname" styleId="crsystemname" value="${IGCIC01021VO.compareRoleInfo.crsystemname }"/>
		<html:hidden property="crid" styleId="crid" value="${IGCIC01021VO.compareRoleInfo.crid}" />
	<span>对比类型:</span>
			<html:select property="crtype" styleId="crtype" value="${IGCIC01021VO.compareRoleInfo.crtype }" >
				<ig:optionsCollection ccid="COMPARE_TYPE" />
			</html:select>
			&nbsp;&nbsp;&nbsp;
	
	</div>

	</div>
	<div id="dvComObject"><!--  message --> <ig:message /> <!--  /message -->
		
		<div id ="tempaleBox" style="display:none;" class="dvobj">
			<div class="sub_box"></div>
			<table class="tbstyle">
				<tr height="60px">
					<th width="25%"><span >选择对比主机:</span></th> 
					<td width="70%">
						<select onchange="changeSourceHost(this)">
							<logic:present name="IGCIC01021VO" property="sourceHostList">
								<logic:iterate id="map" name="IGCIC01021VO" property="sourceHostList">
									<option value='${map["eiid"] }'>${map["ip"] }_${map["einame"]}</option>
								</logic:iterate>
							</logic:present>
						</select>
						<input type="hidden" />
					 </td>
					 <td width="5%"><button class="btnBg" onclick="subObj(this)">删除</button></td>
				</tr>
				<tr>
					<th style="vertical-align: top;"><span >选择目标主机:</span></th>
					<td colspan="2">
					<div  class="warp_box">
						<span>未选择主机</span>
						<ul class="targetList_box">
							<logic:present name="IGCIC01021VO" property="targetHostList">
								<logic:iterate id="map" name="IGCIC01021VO" property="targetHostList">
									<li eiid='${map["eiid"] }' onclick='toggleHost(this)'>${map["ip"] }_${map["einame"]}</li>
								</logic:iterate>
							</logic:present>
						</ul>
					</div>
					<div class="warp_box">
						<span>已选择主机</span>
						<ul class="selectedHostList"></ul>
					</div></td>
				</tr>
			</table>
		</div>
	<div id="addBtn_box"> <a id="addObj" style="margin-right:0px;line-height: 28px;" href="#"  ><img alt=""  style="border:0px;vertical-align: middle;" src="images/pic1.png">&nbsp;添加对比主机</a></div>
	<div id="btnBox" style="text-align:center; display:none;">
			<button id = "btn_save" onclick="save()" class="btnBg" >保存</button>
			
	</div>
	</div>
	</html:form>
</div>
</div>
</div>


</div>
</body>
<script>

		var objList = {},crid='',coListJson = '${IGCIC01021VO.compareObjectListJson}';
	jQuery(function(){
		
		//绑定 业务系统下拉框事件
		jQuery("#crsystemid").change(function(){
			
			//清空对比类型下拉框 
			jQuery("#crtype").val("");
			
			if(this.selectedIndex){
				jQuery("#crsystemname").val(this.options[this.selectedIndex].innerText);
			}else{
				jQuery("#crsystemname").val('');
			}

		});
		jQuery("#crtype").focus(function(){
			//先选择业务系统
			if(!jQuery("#crsystemid").val()){
				alert("请先选择业务系统");
				this.blur();
				return false;
			}
		})
		jQuery("#crtype").change(function(){
			
			
			//变更时 情况所有的 比较对象
			removeAllComObj();
			//ajax 加载目标比较对象
			if(this.selectedIndex){
				jQuery.ajax({
					url:getAppRootUrl()+"/ajax.do",
					data:{type:'searchCompareSourchHostList',systemId:jQuery("#crsystemid").val(),crtype:this.value},
					dataType:'json',
					cache:false,
					success:function(result){
						
						//绑定目标主机
						var ul = jQuery(jQuery("#tempaleBox .targetList_box")[0]);
						ul.empty();
						jQuery(result.targetHostList).each(function(i,t){
							ul.append("<li eiid='"+t.eiid+"' onclick='toggleHost(this)'>"+t.ip+"_"+t.einame+"</li>");
						});
						//绑定源主机
						var selBox = jQuery(jQuery("#tempaleBox select")[0]);
						selBox.empty().append("<option></option>");
						jQuery(result.sourceHostList).each(function(i,t){
							selBox.append("<option value='"+t.eiid+"'>"+t.ip+"_"+t.einame+"</option>");
						});
						jQuery("#crid").val('');
						if(result.crInfo){
							
							jQuery("#crid").val(result.crInfo.crid);
							coListJson=result.coList;
						}
						
						initPage();
					}
				});
				
			}
		})
		
		//添加按钮事件
		jQuery("#addObj").click(function(){
			jQuery("#tempaleBox").clone(true).removeAttr("id").insertBefore(jQuery("#addBtn_box")).css("display","");
			showBtn();
		})
		
		initPage();
	});
	
	//删除一个比较组  (减号的 事件方法)
	function subObj(obj){
		jQuery(obj).parents(".dvobj").remove();
		showBtn();
	}
	//目标主机的 点击事件
	function toggleHost(obj){
		obj = jQuery(obj);
		obj.removeClass("hoverli");
		var sel=jQuery(obj.parents("tr").prev().find("select")[0]);
		var sourceEiid = sel.next().val()||sel.val(),
		sourceIp = sel.find("option[value='"+sourceEiid+"']")[0].innerText;
		if(!sourceEiid){
			alert("请先选择对比主机");
			return;  
		}
		if(obj.parent().attr('class')=='targetList_box'){
			obj.clone(true).appendTo(obj.parent().parent().next().children("ul:first"));
			objList[crid+"#"+sourceEiid+"#"+sourceIp+"#"+obj.attr('eiid')+"#"+obj.text()]=true;
			obj.parent().parent().next().removeClass("errorBox");
		}else{
			obj.clone(true).appendTo(obj.parent().parent().prev().children("ul:first"));
			objList[crid+"#"+sourceEiid+"#"+sourceIp+"#"+obj.attr('eiid')+"#"+obj.text()]=false;
		}
		obj.remove();
	}
	//初始化页面
	function initPage(){
		crid = jQuery("#crid").val();
		if(crid){
			//装载 该规则下的对比对象到页面中
			coListJson= (coListJson instanceof Object)?coListJson:eval('('+coListJson+')');
			if(coListJson&&coListJson.length>0){
				var tempSource;
				jQuery(coListJson).each(function(i,t){
					if(tempSource!=t.cosource){
						tempSource=t.cosource;
						jQuery("#tempaleBox").clone(true).removeAttr("id").attr("id",tempSource).insertBefore(jQuery("#addBtn_box")).css("display","");
						jQuery(jQuery("#"+tempSource).find("select")[0]).val(tempSource).next().val(tempSource);
					}
					jQuery(jQuery(".targetList_box")).children().hover(
							  function () {
								    jQuery(this).addClass("hoverli");
								  },
								  function () {
									  jQuery(this).removeClass("hoverli");
								  }
							);
					jQuery("#"+tempSource).find(".targetList_box").find("li[eiid='"+t.cotarget+"']")[0].click();
				});
			}
			if(jQuery(".fonts1:contains('修改对比规则')").length>0){
				jQuery("#crsystemid").attr("disabled","disabled");	
				jQuery("#crtype").attr("disabled","disabled");	
			}
		}
		
		showBtn();
	}
	//选择主机下拉框变更事件
	function changeSourceHost(obj){
		obj = jQuery(obj);
		if(jQuery(".dvobj").find("select[value='"+obj.val()+"']").length>1){
			alert("已有相同主机为目标主机,请选择其他主机");
			obj.val(obj.next().val());
			return false;
		}
			//显示待选择的所有主机
			obj.parents("tr").next().find(".targetList_box").children().show();
		if(obj.val()){
			obj.parents("tr").next().find(".selectedHostList").children().click();
			//隐藏与本身相同的待比较主机
			obj.parents("tr").next().find(".targetList_box").find("[eiid='"+obj.val()+"']").hide();
		}else{
				var sourceEiid = obj.next().val(),
				sourceIp = obj.find("[value='"+sourceEiid+"']")[0].innerText;
				obj.parent().next().children(".selectedHostList").children().each(function(i,t){
					t=jQuery(t);
					t.clone(true).appendTo(obj.parent().parent().prev().children("ul:first"));
					objList[crid+"#"+sourceEiid+"#"+sourceIp+"#"+t.attr('eiid')+"#"+t.text()]=false;
				});
		}
			obj.next().val(obj.val());
	}
	
	//保存按钮方法
	function save(){
		jQuery(".selectedHostList").each(function(i,t){
			if(jQuery(t).parents("#tempaleBox").length>0){
				return;
			}
			if(jQuery(t).children().length==0){
				jQuery(t).parent().addClass("errorBox");
			}
		});
		if(jQuery(".errorBox").length>0)return false;
		
		for(var k in objList){
			if(objList[k]){
				jQuery("#form").append("<input name='compareObjectName' type='hidden' value='"+k+"'/>");
// 				jQuery("#form").append("<input name='targetEiids' type='hidden' value='"+k.split("#")[2]+"'/>");
			}
		}
		if(confirm("确认保存对比规则?")){
			document.form.submit();
		}
		
	}
	function goback(){
		
		window.location.href= getAppRootUrl()+"/IGCIC0101.do";
	}
	function removeAllComObj(){
		objList= {};
		jQuery(".dvobj:not(#tempaleBox)").remove();
		showBtn();
	}
	function showBtn(){
		jQuery("#btnBox").hide();
		if(jQuery(".dvobj:not(#tempaleBox)").length>0){
			jQuery("#btnBox").show();
		}
	}
</script>
</html:html>
