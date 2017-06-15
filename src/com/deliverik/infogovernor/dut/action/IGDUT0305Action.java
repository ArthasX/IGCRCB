/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0305Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03051VO;

/**
 * 概述: 日常维修表查询&删除action 
 * 功能描述: 日常维修表查询&删除action 
 * 创建记录: 2012/04/01 
 * 修改记录:
 */

public class IGDUT0305Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0305Action.class);

	/**
	 * 日常维修表查询&删除action
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 实例化FORM
		IGDUT0305Form form = (IGDUT0305Form) actionForm;
		// 获取BL接口实例
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		// 实例化DTO
		IGDUT03DTO dto = new IGDUT03DTO();

		// 删除
		if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========批量删除开始========");
			// 传值
			dto.setIgDUT0305Form(form);
			dto.setOnDutyPersonRecordSearchCond(form);
			// 调用删除方法
			ctlBL.deleteOnDutyPersonRecordAction(dto);
			log.debug("========批量删除终了========");
		}

		// 查询
		if ("SEARCH".equals(mapping.getParameter())
				|| "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========通知查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				form = (IGDUT0305Form) request.getSession().getAttribute(
						"IGDUT0305Form");
			}
			// 获取分页Bean
			getPaginDTO(request, "IGDUT0305");

			PagingDTO pDto;

			pDto = (PagingDTO) request.getAttribute("PagingDTO");

			if ("SEARCH1".equals(mapping.getParameter())) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDUT0305Form) request.getSession().getAttribute(
						"IGDUT0305Form");
				if (form == null) {
					form = new IGDUT0305Form();
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
					form = (IGDUT0305Form) request.getSession().getAttribute(
							"IGDUT0305Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGDUT0305");

			dto.setOnDutyPersonRecordSearchCond(form);

			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);
			// 调用BL查询
			dto = ctlBL.searchODPRAction(dto);

			// 调用BL查询出进入区域List
			// dto= ctlBL.searchOnDutyPersonRecordArea(dto);//codeDetailList取得

			// 构造VO
			IGDUT03051VO vo = new IGDUT03051VO();
			// 存入记录列表
			vo.setOnDutyPersonRecordInfoList(dto.getOnDutyPersonRecordList());
			// 存入进入区域列表
			vo.setCodeDetailList(dto.getCodeDetailList());
			// 存入request
			super.<IGDUT03051VO> setVO(request, vo);
			log.debug("========通知查询处理终了========");
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
