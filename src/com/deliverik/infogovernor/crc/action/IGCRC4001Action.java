package com.deliverik.infogovernor.crc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC02BL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.form.IGCRC4001Form;
import com.deliverik.infogovernor.crc.vo.IGCRC4001VO;
/**	
 * 概述: 事件和问题联合查询action
 * 创建记录：zhaoziting    2017/08/02
 * 修改记录：null
 */	
public class IGCRC4001Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//实例化FORM
		IGCRC4001Form form = (IGCRC4001Form)actionForm;
		//获取BL接口实例
		IGCRC02BL bl = (IGCRC02BL) getBean("igcrc02bl");
		IGCRC02DTO dto = new IGCRC02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if( "SEARCHEVentandProblem".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGCRC4001");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCRC4001Form) req.getSession().getAttribute("IGCRC4001Form");
				if ( form == null ) {
					form = new IGCRC4001Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {

				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGCRC4001Form) req.getSession().getAttribute("IGCRC4001Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGCRC4001");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgCRC4001Form(form);
			dto = bl.getEventAndProblem(dto);
			//事件来源
			dto = bl.getEventSource(dto);
			//事件影响范围
			dto = bl.getEventAffect(dto);
			//事件状态
			dto = bl.getEventStatus(dto);
			//问题状态
			dto = bl.getProblemStatus(dto);
			//构造VO
			IGCRC4001VO vo = new IGCRC4001VO();
			vo.setListep(dto.getListep());
			vo.setAffectlist(dto.getAffectlist());
			vo.setEslist(dto.getEslist());
			vo.setSourcelist(dto.getSourcelist());
			vo.setPslist(dto.getPslist());			
			super.<IGCRC4001VO>setVO(req, vo);			
			req.setAttribute("vo", vo);
		}
		if("EXCEL".equals(mapping.getParameter())){
			dto.setIgCRC4001Form(form);		
			res.reset();// 清空输出流
			res.setHeader("Content-disposition", "attachment; filename=" + new String("生产事件汇总信息".getBytes("gb2312"), "8859_1") + ".xls");// 设定输出文件头
			res.setContentType("application/msexcel");
			dto.setOps(res.getOutputStream());
			bl.exportEventAndProblem(dto);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		//跳转到定制JSP
		return mapping.findForward("DISP");
	}

}
