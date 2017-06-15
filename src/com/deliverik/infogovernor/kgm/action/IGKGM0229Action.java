package com.deliverik.infogovernor.kgm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0229Form;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCondImpl;
import com.deliverik.infogovernor.kgm.vo.IGKGM02291VO;

public class IGKGM0229Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0229Action.class);

	/**
	 * 知识日志查询
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGKGM0229Form form = (IGKGM0229Form) actionForm;
		// BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		// DTO生成
		IGKGM02DTO dto = new IGKGM02DTO();
		// VO生成
		IGKGM02291VO vo = new IGKGM02291VO();
		// 知识查询处理
		log.debug("========知识日志查询处理开始========");
		KnowLogSearchCondImpl cond = new KnowLogSearchCondImpl();
		cond.setKlkid(form.getKlkid());
		dto.setKnowLogSearchCond(cond);
		dto = ctlBL.searchProcessRecordLogAction(dto);
		vo.setRecordList(dto.getRecordList());
		super.<IGKGM02291VO> setVO(req, vo);
		log.debug("========知识日志查询处理终了========");
		return mapping.findForward("DISP");
	}
}
