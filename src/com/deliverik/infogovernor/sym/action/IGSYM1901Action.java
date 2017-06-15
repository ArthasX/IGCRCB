/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.action;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM19BL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1901Form;
import com.deliverik.infogovernor.sym.vo.IGSYM19011VO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
/**
 * 概述:作息日期模板查询Action
 * 功能描述：作息日期模板查询
 * 创建记录：张楠 2011/10/18
 * 修改记录：LuJiayuan 迁移功能将名称由IGSYM1701Action变更为IGSYM1901Action 2013/01/30
 */
public class IGSYM1901Action extends BaseAction{

	static Log log = LogFactory.getLog(IGSYM1901Action.class);
	
	/**
	 * 作息日期模板查询处理
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGSYM1901Form igsym1901Form = (IGSYM1901Form)actionForm;
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto = new IGSYM19DTO();
		//初始化作息模板查询画面
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============作息模板查询画面初始化开始===============");
			Calendar cal=Calendar.getInstance();
			//取得当前年
			Integer year = cal.get(Calendar.YEAR);
			//取得当前月
			Integer month = cal.get(Calendar.MONTH);
			igsym1901Form.setYear(year);
			igsym1901Form.setMonth(month);
			dto.setIgsym1901Form(igsym1901Form);
			//作息模板记录查询
			dto = igsym19BL.searchProcessWorkTimeTemplate(dto);
			//作息模板记录结果集
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = dto.getProcessWorkTimeTemplateInfoList();
			IGSYM19011VO igsym19011vo=new IGSYM19011VO();
			igsym19011vo.setProcessWorkTimeTemplateInfoList(processWorkTimeTemplateInfoList);
			super.<IGSYM19011VO>setVO(request, igsym19011vo);
			request.setAttribute("voMap", dto.getVoMap());
			log.debug("==============作息模板查询画面初始化结束===============");
		}
		//重查询作息模板画面
		if("REDISP".equals(mapping.getParameter())){
			log.debug("==============作息模板重查询画面开始===============");
			dto.setIgsym1901Form(igsym1901Form);
			//作息模板记录查询
			dto = igsym19BL.searchProcessWorkTimeTemplate(dto);
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = dto.getProcessWorkTimeTemplateInfoList();
			IGSYM19011VO igsym19011vo=new IGSYM19011VO();
			igsym19011vo.setProcessWorkTimeTemplateInfoList(processWorkTimeTemplateInfoList);
			request.setAttribute("voMap", dto.getVoMap());
			super.<IGSYM19011VO>setVO(request, igsym19011vo);
			log.debug("==============作息模板重查询画面结束===============");
		}
		return mapping.findForward("DISP");
	}

}
