package com.deliverik.infogovernor.drm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0119Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01191VO;

/**
 * 应急场景触发策略管理Action
 * 
 * @author zhangjian
 * 
 *
 */
public class IGDRM0119Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0119Action.class);

    /**
	 * 应急场景触发策略管理Action处理
	 *
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
    @Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		IGDRM01BL ctlBL = (IGDRM01BL) getBean("igdrm01BL");

		IGDRM0119Form form = (IGDRM0119Form) actionForm;

		IGDRM01DTO dto = new IGDRM01DTO();


		if ("SEARCH".equals(mapping.getParameter())) {
			log.info("============应急场景触发策略查看开始==============");

			dto.setForm(form);

			ctlBL.searchSenceStrategy(dto);

			IGDRM01191VO vo = new IGDRM01191VO();
			vo.setPlanInfo(dto.getPlanInfo());
			vo.setResponseStrategyList(dto.getResponseStrategyList());
			super.<IGDRM01191VO> setVO(req, vo);

			log.info("============应急场景触发策略查看完成==============");
		} else if ("SAVE".equals(mapping.getParameter())) {
			log.info("============应急场景触发策略保存开始==============");
			dto.setForm(form);
			ctlBL.saveSenceStrategy(dto);
			req.setAttribute("closeFlag", "close");
			log.info("============应急场景触发策略保存完成==============");
		} else if ("DISP".equals(mapping.getParameter())) {
			log.info("============应急场景触发策略编辑/新增开始==============");
			if (form.getRsid() != null) {
				dto.setForm(form);
				ctlBL.getSenceStrategy(dto);
				if (dto.getResponseStrategyInfo() != null) {
					BeanUtils.copyProperties(dto.getResponseStrategyInfo(), form);
				}

			}
			log.info("============应急场景触发策略编辑/新增完成==============");
		} else if ("DELETE".equals(mapping.getParameter())) {
			log.info("============应急场景触发策略删除开始==============");
			dto.setForm(form);
			ctlBL.delSenceStrategy(dto);
			log.info("============应急场景触发策略删除完成==============");
		}else if("DETAIL".equals(mapping.getParameter())){
			log.info("============应急场景触发策略详细开始==============");
			if (form.getRsid() != null) {
				dto.setForm(form);
				ctlBL.getSenceStrategy(dto);
				//将值传入到form中显示
				form.setKeyword(dto.getResponseStrategyInfo().getKeyword());
				form.setHandleBL(dto.getResponseStrategyInfo().getHandleBL());
				form.setRsargs(dto.getResponseStrategyInfo().getRsargs());
				form.setStrategyDesc(dto.getResponseStrategyInfo().getStrategyDesc());
			}
			log.info("============应急场景触发策略详细完成==============");
		}
        return mapping.findForward("DISP");
    }

}
