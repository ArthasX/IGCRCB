package com.deliverik.infogovernor.ven.action;

import java.util.ArrayList;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.ven.bl.IGVEN02BL;
import com.deliverik.infogovernor.ven.dto.IGVEN02DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0201Form;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.vo.IGVEN02012VO;
import com.deliverik.infogovernor.ven.vo.IGVEN02013VO;

/**
 * 风险检查结果报告查询画面Action处理
 * 
 */
public class IGVEN0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0201Action.class);

	/**
	 * 风险检查结果报告查询处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		// FORM取得
		IGVEN0201Form form = (IGVEN0201Form) actionForm;
		// BL取得
		IGVEN02BL ctlBL = (IGVEN02BL) getBean("IGVEN02BL");
		// DTO生成
		IGVEN02DTO dto = new IGVEN02DTO();
		// 获取发起角色列表
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);

		String forward = req.getParameter("return");

		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())) {
			// 类型查询处理
			log.debug("========风险监测管理查询处理开始========");
			// 分页用DTO取得
			getPaginDTO(req, "IGVEN0201");
			PagingDTO pDto;
			pDto = (PagingDTO) req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGVEN0201Form) req.getSession().getAttribute("IGVEN0201Form");
				if (form == null) {
					form = new IGVEN0201Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGVEN0201Form) req.getSession().getAttribute("IGVEN0201Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			// 查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGVEN0201");
			// DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			dto.setIgVEN0201Form(form);
			// 信息检索逻辑调用
			dto = ctlBL.searchRiskMonitoringAction(dto);
			// 监测工作执行，计划结束时间不是策略结束时间，而应该是监测工作发起时间与工作执行期限之和
			IGVEN02013VO vo = new IGVEN02013VO();
			List<IGVEN02012VO> voList = new ArrayList<IGVEN02012VO>();
			IGVEN02012VO IGVEN02012vo = null;
			if (dto.getRiskMonitoringInfos() != null) {
				for (RiskMonitoringInfo riskCheckResult : dto.getRiskMonitoringInfos()) {
					IGVEN02012vo = new IGVEN02012VO();
					IGVEN02012vo.setRiskMonitoringInfo(riskCheckResult);
					voList.add(IGVEN02012vo);
				}
			}
			vo.setIgven02012voList(voList);
			super.<IGVEN02013VO> setVO(req, vo);

			log.debug("========风险监测管理查询处理终了========");
		}

		

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}
		if (StringUtils.isNotEmpty(forward)) {
			return mapping.findForward("READ");
		} else {
			return mapping.findForward("DISP");
		}
	}
}
