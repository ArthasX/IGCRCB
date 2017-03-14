/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.ram.bl.IGRAM03BL;
import com.deliverik.infogovernor.ram.dto.IGRAM03DTO;
import com.deliverik.infogovernor.ram.form.IGRAM0301Form;
import com.deliverik.infogovernor.ram.vo.IGRAM03011VO;
import com.deliverik.infogovernor.xls.ram.bl.IGRAM0301ExcelBL;
import com.deliverik.infogovernor.xls.ram.dto.IGRAM0301ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息安全管理平台
 * </p>
 * <p>
 * Description: 风险评估_部门工作统计ACTION
 * </p>
 * 
 * @author tangzhen@deliverik.com
 * @version 1.0
 */

public class IGRAM0301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRAM0301Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 实例化DTO
		IGRAM03DTO dto = new IGRAM03DTO();
		// 获取BL接口实例
		IGRAM03BL ctlBL = (IGRAM03BL) getBean("igram03BL");
		IGRAM0301Form form = (IGRAM0301Form) actionForm;
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("==========部门评估查询初始化开始==========");
			if (StringUtils.isEmpty(form.getPropentime_from())) {
				java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DATE, 1);
				form.setPropentime_from(df.format(c.getTime()));
				form.setPropentime_to(df.format(Calendar.getInstance().getTime()));
			}
			log.debug("==========部门评估查询初始化结束==========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("==========部门评估查询开始 ==========");
			dto.setPropentime_from(form.getPropentime_from());
			dto.setPropentime_to(form.getPropentime_to());
			dto = ctlBL.getAssessmentOrgReport(dto);
			IGRAM03011VO vo = new IGRAM03011VO();
			vo.setOrgReport(dto.getOrgReport());
			super.<IGRAM03011VO> setVO(request, vo);
			log.debug("==========部门评估查询开始 ==========");
		}
		if ("EXPORT".equals(mapping.getParameter())) {
			log.debug("==========部门评估导出开始 ==========");
			dto.setPropentime_from(form.getPropentime_from());
			dto.setPropentime_to(form.getPropentime_to());
			dto = ctlBL.getAssessmentOrgReport(dto);
			IGRAM0301ExcelDTO excelDTO = new IGRAM0301ExcelDTO();
			//查询模板
			excelDTO.setFileid("RAM0301");
			//查询结果集设置
			excelDTO.setOrgReport(dto.getOrgReport());
			excelDTO.setResponse(response);
			//查询条件设置
			excelDTO.setPropentime_from(form.getPropentime_from());
			excelDTO.setPropentime_to(form.getPropentime_to());
			
			IGRAM0301ExcelBL excelBL = (IGRAM0301ExcelBL) getBean("igram0301excelBL");
			excelBL.initExcel(excelDTO);

			request.removeAttribute("report1");
			log.debug("========部门评估导出理终了========");
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
