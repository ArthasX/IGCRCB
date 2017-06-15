<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0000" toScope="request" />
<bean:define id="title" value="应急管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
 <div id="contentWrap">
   <div id="content">
   	 <ig:menuAuth actname="ACT29DRM">
     <div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/mxgl.gif" width="64" height="64" /></div>
		<div class="caption_right">
			<div class="caption_title">
				<ig:menuAuth actname="ACT29DRM0101">
					<p class="fonts1">
							<html:link action="/IGCOM0202.do?linkID=IGDRM1003&actname=ACT29DRM0101">总体预案</html:link>
					</p>
				</ig:menuAuth>
				<ig:menuAuthThree actname="ACT29DRM0101">
					<p class="fonts1"> 
						组织架构关系管理
					</p>
				</ig:menuAuthThree>
			</div>
			<div class="caption_content">
				<p>对应急指挥流程及应急组织架构进行定义。</p>
			</div>
		</div>
	</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM02">
		<div class="caption" style="height: 100px;">
			<div class="caption_img"><img src="images/sbgl.gif" width="64" height="64" /></div>
			<div class="caption_right">
				<div class="caption_title">
					<ig:menuAuth actname="ACT29DRM0201">
						<p class="fonts1">
							<html:link action="/IGCOM0202.do?linkID=IGDRM0104&actname=ACT29DRM0201">应急场景 </html:link>
						</p>
					</ig:menuAuth>
					<ig:menuAuthThree actname="ACT29DRM0201">
						<p class="fonts1"> 
							应急场景管理
						</p>
					</ig:menuAuthThree>
				</div>
			<div class="caption_content">
			<p>根据灾难场景设定相应的场景，可对应急场景进行定义、查询、修订及版本控制，并支持对场景的审批流程。</p>
			</div>
			</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM03">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/wbsgl.png" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM0301">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGDRM0502&actname=ACT29DRM0301">专项预案</html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM0301">
				<p class="fonts1"> 
					专项预案管理
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>定义专项预案的基本信息，可对已定义的专项预案进行查询、修订、复制和版本控制，并可进行历史版本比较。</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM04">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/rjgl1.gif" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM0401">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGDRM0402&actname=ACT29DRM0401">应急资源 </html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM0401">
				<p class="fonts1"> 
					应急资源管理
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>提供应急资源文档的修改、删除和权限控制功能，并可以进行历史版本比较。<br/>&nbsp;</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM06">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/wbspggl.png" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM0601">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGDRM0703&actname=ACT29DRM0601">演练管理</html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM0601">
				<p class="fonts1"> 
					演练查询
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>对演练计划、演练方案及演练流程进行管理，跟踪记录演练执行过程发生的具体恢复操作步骤及结果反馈，以供演练后回顾和统计。</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM07">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/yygl.gif" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM0701">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGDRM1701&actname=ACT29DRM0701">培训管理</html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM0701">
				<p class="fonts1"> 
					培训记录管理
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>对已发布的演练方案进行培训发起操作，记录相关人员的培训情况以及反馈信息。</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM08">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/jfgl.gif" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM0801">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGDRM0903&actname=ACT29DRM0801">应急指挥</html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM0801">
				<p class="fonts1"> 
					应急指挥查询
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>记录事件处置流程信息，并可以通过指挥图，进入应急指挥DashBoard。<br/>&nbsp;</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM09">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/wbrygl.png" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM0902">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prpdid=02300&prtype=WD&actname=ACT29DRM0902">评估整改</html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM0902">
				<p class="fonts1"> 
					评估查询
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>对演练及应急过程中发现的问题进行评估和整改。</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
	<ig:menuAuth actname="ACT29DRM10">
		<div class="caption" style="height: 100px;">
		<div class="caption_img"><img src="images/wlgl.gif" width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
			<ig:menuAuth actname="ACT29DRM1001">
				<p class="fonts1">
					<html:link action="/IGCOM0202.do?linkID=IGDRM1401&actname=ACT29DRM1001">通知管理</html:link>
				</p>
			</ig:menuAuth>
			<ig:menuAuthThree actname="ACT29DRM1001">
				<p class="fonts1"> 
					通知管理
				</p>
			</ig:menuAuthThree>
		</div>
		<div class="caption_content">
		<p>对通知信息进行管理，可选择是否推送到指挥台、是否推送通知，并选择推送人员和推送方式。</p>
		</div>
		</div>
		</div>
	</ig:menuAuth>
<%-- 	<ig:menuAuth actname="ACT06ASM10"> --%>
<!-- 		<div class="caption" style="height: 100px;"> -->
<!-- 		<div class="caption_img"><img src="images/zctjfx.gif" width="64" height="64" /></div> -->
<!-- 		<div class="caption_right"> -->
<!-- 		<div class="caption_title"> -->
<%-- 			<ig:menuAuth actname="ACT06ASM1001"> --%>
<!-- 				<p class="fonts1"> -->
<%-- 					<html:link action="/IGCOM0202.do?linkID=IGASM1001&actname=ACT06ASM1001">工作监督</html:link> --%>
<!-- 				</p> -->
<%-- 			</ig:menuAuth> --%>
<%-- 			<ig:menuAuthThree actname="ACT06ASM1001"> --%>
<!-- 				<p class="fonts1">  -->
<!-- 					资产统计分析 -->
<!-- 				</p> -->
<%-- 			</ig:menuAuthThree> --%>
<!-- 		</div> -->
<!-- 		<div class="caption_content"> -->
<!-- 		<p>针对应急管理的工作流程进行统计分析，从而监督应急相关工作的执行情况。</p> -->
<!-- 		</div> -->
<!-- 		</div> -->
<!-- 		</div> -->
<%-- 	</ig:menuAuth> --%>
	
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>