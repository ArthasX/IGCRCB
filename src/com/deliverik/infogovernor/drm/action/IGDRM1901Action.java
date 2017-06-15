/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.drm.bl.IGDRM19BL;
import com.deliverik.infogovernor.drm.dto.IGDRM19DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1901Form;
import com.deliverik.infogovernor.drm.vo.IGDRM19011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询Action
 * </p>
 * <p>
 * 流程默认查询，无需配置，默认显示流程标题，描述，工单号，发起人，发起时间，关闭时间，处理人，状态等信息
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1901Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1901Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 日志对象取得
		// 实例化FORM
		IGDRM1901Form form = (IGDRM1901Form) actionForm;
		// 获取BL接口实例
		IGDRM19BL ctlBL = (IGDRM19BL) getBean("igdrm19BL");
		IGDRM19DTO dto = new IGDRM19DTO();
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrtype(form.getPrtype());
		// 将查询类型标识放进dto中
		dto.setType(form.getType());
		// 工作查询
		if ("SEARCH".equals(mapping.getParameter())
				|| "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========工作查询处理开始========");
			// 获取分页Bean
			getPaginDTO(request, "IGWKM0101");
			PagingDTO pDto;
			pDto = (PagingDTO) request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM1901Form) request.getSession().getAttribute(
						"IGDRM1901Form");
				if (form == null) {
					form = new IGDRM1901Form();
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {

				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM1901Form) request.getSession().getAttribute(
							"IGDRM1901Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGDRM1901");
			form.setUserid_q(user.getUserid());
			dto.setUser(user);
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			try {
				BeanUtils.copyProperties(cond, form);
			} catch (Exception e) {
				log.error("", e);
			}
			dto.setPrSearchCond(cond);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			// 调用BL查询
			dto = ctlBL.getProcessRecords(dto);
			// 构造VO
			IGDRM19011VO vo = new IGDRM19011VO(dto.getProcessList());
			super.<IGDRM19011VO> setVO(request, vo);
			log.debug("========工作查询处理终了========");
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
