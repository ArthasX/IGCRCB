/**
 * 2014-R-R-1
 */

function initSet(){
	
}

jQuery(function() {
	var pdid = jQuery("#pdid").val();
	
//	var preObj = jQuery("input[id = 'pidid"+pdid+"443']").prev();
	var preObj = jQuery("input[value='"+pdid+"443']").prev().prev().prev().prev().prev();
	var textObj = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"报 告 要 点</br>" +
			"一、信息科技规划</br>" +
			"&nbsp;&nbsp;&nbsp;包括但不限于：本年度业务战略要点、信息科技战略支持业务战略情况、信息科技战略规划要点及本年度修订情况、执行情况。" +
			"二、信息科技治理情况</br>" +
			"&nbsp;&nbsp;&nbsp;1.信息科技治理组织架构（三道防线）情况，附《信息科技治理组织架构图》。</br>" +
			"&nbsp;&nbsp;&nbsp;2.董事会与高管层的信息科技履职情况，本年度信息科技治理方面的进展情况。</br>" +
			"&nbsp;&nbsp;&nbsp;3.信息科技管理委员会履职情况。</br>" +
			"&nbsp;&nbsp;&nbsp;4.风险管理委员会的信息科技风险管理工作情况。</br>" +
			"&nbsp;&nbsp;&nbsp;5.CIO履职情况。</br>" +
			"&nbsp;&nbsp;&nbsp;6.信息科技部门工作概况，包括但不限于：信息科技建设概况，信息系统稳定运行情况，信息安全管理情况等。</br>" +
			"&nbsp;&nbsp;&nbsp;7.信息科技风险管理工作概况，包括但不限于：信息科技风险管理整体概况，本年度风险评估、风险监测工作情况，其他工作。</br>"+
			"&nbsp;&nbsp;&nbsp;8.信息科技审计工作概况，包括但不限于：本年度信息科技风险内外部审计主要工作，主要内外部审计发现整改情况，其他工作。</br>" +
			"三、信息科技重大活动与项目情况</br>" +
			"&nbsp;&nbsp;&nbsp;列举本年度信息科技的重大活动与项目，总数不超过5个，文字简洁，内容充实，总字数不超过1000字。具体内容包括但不限于：在信息科技风险管理、信息科技治理、信息安全管理、外包管理和业务连续性管理等方面的重大举措，重要基础设施建设情况，重大项目上线投产情况等。</br>" +
			"四、信息科技创新与引领金融产品创新情况</br>" +
			"&nbsp;&nbsp;&nbsp;列举本年度在信息科技创新、新技术运用、信息科技与金融产品创新融合等方面具有代表性和典型意义的成功案例，数量不超过5个，文字简洁，内容充实，总字数不超过1000字。金融产品创新具体内容包括但不限于：产品名称、产品功能、产品特色、信息科技在支撑引领金融产品创新方面发挥的积极作用。信息科技创新具体内容包括但不限于：技术名称、技术特点、使用范围、创新价值。</br>" +
			"五、下年度信息科技规划</br>" +
			"&nbsp;&nbsp;&nbsp;下年度信息化建设和信息科技风险管理工作计划。包括信息科技建设对业务发展支持、信息科技总体架构建设、信息科技风险管理、信息科技制度和标准建设、信息科技基础设施建设、信息系统建设、科技人才培养等。</br>" +
			"六、信息科技风险自评估</br>" +
			"&nbsp;&nbsp;&nbsp;包括但不限于：信息科技治理框架完整性、信息科技风险管理水平、信息科技主要风险点和需要改进的方面。描述出现的信息科技风险事件，造成的影响和损失、补救措施、问题整改落实、经验总结等内容。</br>" +
			"七、对监管部门的建议</br>" +
			"&nbsp;&nbsp;&nbsp;针对当前信息科技监管工作需要解决的问题，向监管部门提出的工作建议。</br>" +
			"&nbsp;&nbsp;&nbsp;附：金融资产管理公司、信托公司，企业集团财务公司，金融租赁公司，汽车金融公司，货币经纪公司，消费金融公司还应在本报告中描述本年度机构全部重"+
			"要信息系统基本情况，包括但不限于系统名称、业务类型、客户范围、客户数量、交易范围、系统用户数量、功能简述、系统外包管理情况和系统应急演练情况等。</br>";		
	preObj.html(textObj);
});