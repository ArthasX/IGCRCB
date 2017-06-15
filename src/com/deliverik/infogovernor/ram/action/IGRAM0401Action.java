/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.ram.bl.IGRAM04BL;
import com.deliverik.infogovernor.ram.dto.IGRAM04DTO;
import com.deliverik.infogovernor.ram.form.IGRAM0401Form;
import com.deliverik.infogovernor.ram.vo.IGRAM04011VO;
import com.deliverik.infogovernor.xls.ram.bl.IGRAM0401ExcelBL;
import com.deliverik.infogovernor.xls.ram.dto.IGRAM0401ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息安全管理平台
 * </p>
 * <p>
 * Description: 风险评估_年度工作统计ACTION
 * </p>
 * 
 * @author tangzhen@deliverik.com
 * @version 1.0
 */

public class IGRAM0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRAM0401Action.class);
	
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 实例化DTO
		IGRAM04DTO dto = new IGRAM04DTO();
		// 获取BL接口实例
		IGRAM04BL ctlBL = (IGRAM04BL) getBean("igram04BL");
		// 实例化Form
		IGRAM0401Form form = (IGRAM0401Form) actionForm;

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("==========年度评估查询初始化开始==========");
			//设置默认查询年度
			form.setCurrentyear(IGStringUtils.getCurrentYear());
			log.debug("==========年度评估查询初始化结束==========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("==========年度评估查询开始 ==========");
			dto.setCurrentyear(form.getCurrentyear());
			//查询年度评估统计，页面显示
			dto = ctlBL.getAssessmentYearReport(dto);
			IGRAM04011VO vo = new IGRAM04011VO();
			vo.setYearReport(dto.getYearReport());
			super.<IGRAM04011VO> setVO(request, vo);
			log.debug("==========年度评估查询开始 ==========");
		}
		if ("EXPORT".equals(mapping.getParameter())) {
			log.debug("==========年度评估导出开始 ==========");
			dto.setCurrentyear(form.getCurrentyear());
			dto = ctlBL.getAssessmentYearReport(dto);
			IGRAM0401ExcelDTO excelDTO = new IGRAM0401ExcelDTO();
			//查询模板号
			excelDTO.setFileid("RAM0401");
			//查询结果设置
			excelDTO.setYearReport(dto.getYearReport());
			excelDTO.setResponse(response);
			//添加查询年度显示
			excelDTO.setCurrentyear(form.getCurrentyear());
			
			IGRAM0401ExcelBL excelBL = (IGRAM0401ExcelBL) getBean("igram0401excelBL");
			excelBL.initExcel(excelDTO);
			request.removeAttribute("report1");
			log.debug("========年度评估导出理终了========");
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
