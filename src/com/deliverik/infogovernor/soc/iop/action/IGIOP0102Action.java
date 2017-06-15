package com.deliverik.infogovernor.soc.iop.action;

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
import com.deliverik.infogovernor.soc.iop.IOPKeyWords;
import com.deliverik.infogovernor.soc.iop.bl.IGIOP01BL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP01DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0102Form;
import com.deliverik.infogovernor.soc.iop.vo.IGIOP01021VO;

/**
 * IP段管理Action处理
 *
 */
public class IGIOP0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIOP0102Action.class);

	/**
	 * IP段管理Action处理
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
		// FORM取得
		IGIOP0102Form form = (IGIOP0102Form) actionForm;

		// BL取得
		IGIOP01BL ctlBL = (IGIOP01BL) getBean("igiop01BL");

		// DTO生成
		IGIOP01DTO dto = new IGIOP01DTO();
		dto.setLocale(this.getLocale(req));

		if ("DISP".equals(mapping.getParameter())) {
			clearSessionFormData(req);
		} 

		if ("SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())) {
			// 分页用DTO取得
			getPaginDTO(req, "IGIOP0102");

			PagingDTO pDto;

			pDto = (PagingDTO) req.getAttribute("PagingDTO");
			// 设备查询处理
			log.debug("========IP段查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				form = (IGIOP0102Form) req.getSession().getAttribute(
						"IGIOP0102Form");
				if (form == null) {
					form = new IGIOP0102Form();
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
					form = (IGIOP0102Form) req.getSession().getAttribute(
							"IGIOP0102Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			// 查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIOP0102");
			if(StringUtils.isEmpty(form.getEid()))
				form.setEid(IOPKeyWords.IPS_EID);
			dto.setIgiop0102Form(form);
			
			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);

			// 设备检索逻辑调用
			dto = ctlBL.searchIPS(dto);

			// 将设备信息检索结果设定到VO中
			IGIOP01021VO vo = new IGIOP01021VO();
			
			vo.setIpsList(dto.getSoc0118List());
			
			super.<IGIOP01021VO> setVO(req, vo);

			log.debug("========IP段查询处理终了========");
		}
		
		
		if ("RECOVERY".equals(mapping.getParameter())) {
			// IP回收处理
			log.debug("========IP回收处理开始========");
			
			dto.setIgiop0102Form(form);
			
			ctlBL.recoveryAllIP(dto);
			

			log.debug("========IP回收处理终了========");
		}
		if("VIEW".equals(mapping.getParameter())){
			log.debug("==============查看段内IP开始==========");
			
			dto.setIgiop0102Form(form);
			
			ctlBL.showIP(dto);
			
			IGIOP01021VO vo = new IGIOP01021VO();
			
			vo.setIpList(dto.getSoc0118List());
			
			super.<IGIOP01021VO>setVO(req, vo);
			
			log.debug("==============查看段内IP结束==========");
		}
		if("EDIT".equals(mapping.getParameter())){
			
			//clearSessionFormData(req);
			
			form.setEidesc(null);
			
			dto.setIgiop0102Form(form);
			
			dto= ctlBL.searchIPByEiids(dto);
			
			IGIOP01021VO vo = new IGIOP01021VO();
			
			vo.setIpList(dto.getSoc0118List());
			
			super.<IGIOP01021VO>setVO(req, vo);
			
		}
		if("ALLOT".equals(mapping.getParameter())){
			
			log.debug("============IP分配开始================");
			
			dto.setIgiop0102Form(form);
			
			ctlBL.allotIP(dto);
			
			
			
			log.debug("============IP分配结束================");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("=========生成IP开始=============");
			
			User user = (User)getSessionAttribute(req, SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgiop0102Form(form);
			
			ctlBL.regIP(dto);
			
			log.debug("=========生成IP结束=============");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("=============删除子网开始=================");
			dto.setIgiop0102Form(form);
			
			ctlBL.delSubNet(dto);
			log.debug("=============删除子网结束=================");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("=============分配子网开始=================");
			dto.setIgiop0102Form(form);
			
			ctlBL.updateSubNet(dto);
			log.debug("=============分配子网结束=================");
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
