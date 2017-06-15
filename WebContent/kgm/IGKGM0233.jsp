<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGKGM0233" toScope="request" />
<bean:define id="title" value="业务系统" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
	.item{
		margin-top:20px;
		width:200px;
		height:350px;
		margin-left:40px;
		border:1px solid red;
		float:left;
		overflow-y:auto;
		overflow-x:hidden;
		
	}
	.busSysType{
		list-style: none;
		width: 100%;
		margin-left: 0px;
	}
	.busSysType li{
		width: 100%;
		float: left;
		height: 25px;
		text-indent: 25px;
		line-height: 25px;
		cursor: pointer;
	}
	.hoverLi{
		background-color: #F3393E;
		color: #fff;
	}
</style>
<script src="js/json.js" type="text/javascript"></script>
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var jq = jQuery.noConflict(true);
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<html:form action="/IGDBM1200.do" styleId="form" >
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1">业务系统</p>
    </div>
    <div style="height:380px;margin-left:10px;margin-right:10px;">
    	<div class="item">
    		<ul id = "firstUL" class = "busSysType">
    			<logic:present name="IGKGM02331VO">
    				<logic:iterate id="bean" name="IGKGM02331VO" property="businessSystemList">
    					<li syscoding='${bean.syscoding }'>${bean.cvalue } </li>
    				</logic:iterate>
    			</logic:present>
    		</ul>
    	</div>
    	<div class="item">
    		<ul id = "sendUL" class = "busSysType">
    		
    		</ul>

    	</div>
    	<div class="item">
    		<ul id = "resultUL" class = "busSysType"></ul>
    	</div>
    </div>
	<div id="operate">
		<div class="enter">
			<input type="button" class="button" value="关闭" onclick="closeWin()">
		</div>
	</div>
</html:form>
</div>
</body>
<script type="text/javascript">

	var exitsbussys = '${exitsbussys}';

	jq(function(){
		
		
		if(exitsbussys){
			var exitbusysList = jq.parseJSON(exitsbussys);
			
			jq(exitbusysList).each(function(i,t){
				jq("#resultUL").append("<li syscoding='"+t.syscoding+"'>"+t.cvalue+"</li>");
			});
			bindResult();
		}
		
		
		
		jq(".busSysType li").hover(
				function(){
					jq(this).addClass("hoverLi");
				},
				function(){
					jq(this).removeClass("hoverLi");
				}
		);
		jq("#firstUL li").click(
			function(){
				jq("#sendUL").empty();
				jq.ajax({
					url:getAppRootUrl()+"/IGKGM0233.do",
					data:{syscoding:jq(this).attr("syscoding")},
					dataType:"json",
					type:"POST",
					async:false,
					success:function(result){
						if(result&&result.length>0){
							jq(result).each(function(i,t){
								jq("#sendUL").append("<li>"+t.cvalue+"</li>");
								
								jq("#sendUL li:last-child").attr("syscoding",t.syscoding).dblclick(function(){
									//如果结果框中 没有改业务系统则添加到结果框中
									if(jq("#resultUL li[syscoding = '"+t.syscoding+"']").length==0){
										
										jq(jq(this).clone(false).removeClass("hoverLi").appendTo("#resultUL").end()).dblclick(function(){
											jq(this).remove();
										}).hover(
												function(){
													jq(this).addClass("hoverLi");
												},
												function(){
													jq(this).removeClass("hoverLi");
												}
										)
									}
								}).hover(
										function(){
											jq(this).addClass("hoverLi");
										},
										function(){
											jq(this).removeClass("hoverLi");
										}
								);
							})
						}
					}
				})
				
			}		
		)
	})
	
	
	function bindResult(){
		jq("#resultUL li").removeClass("hoverLi").unbind().dblclick(function(){
			jq(this).remove();
		}).hover(
				function(){
					jq(this).addClass("hoverLi");
				},
				function(){
					jq(this).removeClass("hoverLi");
				}
		);
	}
	
	function closeWin(){
		
		window.returnValue = "";
		var resultObj = [];
		jq("#resultUL li").each(function(i,t){
			t = jq(t);
			resultObj.push({syscoding:t.attr("syscoding"),cvalue:t.text()});
		});
		window.returnValue = JSON.stringify(resultObj);
		window.close();
	}
</script>
</html:html>
