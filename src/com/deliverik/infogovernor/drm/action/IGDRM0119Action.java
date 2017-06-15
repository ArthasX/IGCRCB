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
 * Ӧ�������������Թ���Action
 * 
 * @author zhangjian
 * 
 *
 */
public class IGDRM0119Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0119Action.class);

    /**
	 * Ӧ�������������Թ���Action����
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
			log.info("============Ӧ�������������Բ鿴��ʼ==============");

			dto.setForm(form);

			ctlBL.searchSenceStrategy(dto);

			IGDRM01191VO vo = new IGDRM01191VO();
			vo.setPlanInfo(dto.getPlanInfo());
			vo.setResponseStrategyList(dto.getResponseStrategyList());
			super.<IGDRM01191VO> setVO(req, vo);

			log.info("============Ӧ�������������Բ鿴���==============");
		} else if ("SAVE".equals(mapping.getParameter())) {
			log.info("============Ӧ�������������Ա��濪ʼ==============");
			dto.setForm(form);
			ctlBL.saveSenceStrategy(dto);
			req.setAttribute("closeFlag", "close");
			log.info("============Ӧ�������������Ա������==============");
		} else if ("DISP".equals(mapping.getParameter())) {
			log.info("============Ӧ�������������Ա༭/������ʼ==============");
			if (form.getRsid() != null) {
				dto.setForm(form);
				ctlBL.getSenceStrategy(dto);
				if (dto.getResponseStrategyInfo() != null) {
					BeanUtils.copyProperties(dto.getResponseStrategyInfo(), form);
				}

			}
			log.info("============Ӧ�������������Ա༭/�������==============");
		} else if ("DELETE".equals(mapping.getParameter())) {
			log.info("============Ӧ��������������ɾ����ʼ==============");
			dto.setForm(form);
			ctlBL.delSenceStrategy(dto);
			log.info("============Ӧ��������������ɾ�����==============");
		}else if("DETAIL".equals(mapping.getParameter())){
			log.info("============Ӧ����������������ϸ��ʼ==============");
			if (form.getRsid() != null) {
				dto.setForm(form);
				ctlBL.getSenceStrategy(dto);
				//��ֵ���뵽form����ʾ
				form.setKeyword(dto.getResponseStrategyInfo().getKeyword());
				form.setHandleBL(dto.getResponseStrategyInfo().getHandleBL());
				form.setRsargs(dto.getResponseStrategyInfo().getRsargs());
				form.setStrategyDesc(dto.getResponseStrategyInfo().getStrategyDesc());
			}
			log.info("============Ӧ����������������ϸ���==============");
		}
        return mapping.findForward("DISP");
    }

}
