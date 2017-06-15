/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0304Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03041VO;

/**
 * 概述: 日常维修表添加&更新action 
 * 功能描述: 日常维修表添加&更新action 
 * 创建记录: 2012/04/01 修改记录:
 */
public class IGDUT0304Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0304Action.class);

	/**
	 * 日常维修表添加&更新actions
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 获得表单
		IGDUT0304Form igdut0304Form = (IGDUT0304Form) form;
		// 获得bean
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		// 创建DTO
		IGDUT03DTO dto = new IGDUT03DTO();
		if("DISP".equals(mapping.getParameter())){
			log.debug("========显示功能开始========");
			igdut0304Form.setOdprctime(IGStringUtils.getCurrentDateTime());
			igdut0304Form.setOdprinserttime(IGStringUtils.getCurrentDate());
			log.debug("========显示功能终了========");
		}

		// 添加&!!!更新!!!功能
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========添加功能开始========");
			// 真实录入设定
			igdut0304Form.setOdprmodtime(IGStringUtils.getCurrentDateTime());
			if (request.getSession().getAttribute(SESSION_KEY_LOGIN_USER) != null) {
				User user = (User) request.getSession().getAttribute(
						SESSION_KEY_LOGIN_USER);
				// 录入人设定
				igdut0304Form.setOdprusername(user.getUserid());
			}
			//dto存入form
			dto.setIgDUT0304Form(igdut0304Form);
			ctlBL.registOnDutyPersonRecordAction(dto);

			log.debug("========添加功能结束========");
			//设置模式为添加 0新增 1更新
			igdut0304Form.setMode(0);
		}

		// 更新数据取得
		if ("TOUPDATE".equals(mapping.getParameter())) {
			Integer id = null;
			log.debug("========更新数据取得开始========");
			if (request.getParameter("odprid") != null) {
				// 传递主键取得
				id = Integer.parseInt(request.getParameter("odprid"));
				igdut0304Form.setOdprid(id);
				dto.setIgDUT0304Form(igdut0304Form);
				// 初始化更新页面
				ctlBL.initIGDUT0304Action(dto);
				log.debug("========更新数据取得结束========");
				// 设置action更新模式 1为更新模式
				igdut0304Form.setMode(1);
			}
		}

		// 初始化0304VO
		IGDUT03041VO vo = new IGDUT03041VO();
		// 保存记录列表到vo
		vo.setOnDutyPersonRecordInfoList(dto.getOnDutyPersonRecordList());
		// 查询出checkbox基础数据
		ctlBL.searchOnDutyPersonRecordArea(dto);
		// 保存基础数据到vo
		vo.setCodeDetailList(dto.getCodeDetailList());
		// vo保存到request范围
		super.<IGDUT03041VO> setVO(request, vo);

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}

		}

		return mapping.findForward("DISP");
	}

}
