/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

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

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0220Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02201VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 
 * ÿ���̵�Action
 * 
 */
public class IGLOM0220Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0220Action.class);
	
	/**
	 * ÿ���̵�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IGLOM0220Form form = (IGLOM0220Form)actionForm;
		
		IGLOM02BL iglom02BL = (IGLOM02BL)this.getBean("iglom02BL");
		
		IGLOM02DTO dto = new IGLOM02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.setAttribute("category_options", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		
		String forward = "";
		
		if("DISP".equals(mapping.getParameter())){
			
			log.debug("========ÿ���̵��ѯ��ʼ������ʼ========");
			
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth(IGStringUtils.getCurrentDate().substring(5,7));
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			
			log.debug("========ÿ���̵��ѯ��ʼ����������========");
			forward = "DISP";
			
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========ÿ���̵��ѯ����ʼ========");
			
			form = (IGLOM0220Form) req.getSession().getAttribute("IGLOM0220Form");
			//��ȡ��ҳBean
			getPaginDTO(req,"IGLOM0214");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");

			int maxCnt = getMaxDataCount("IGLOM0214");
			dto.setIglom0220Form(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			//����BL��ѯ
			dto = iglom02BL.searchInventoryAction(dto);
			
			//����VO
			IGLOM02201VO vo = new IGLOM02201VO();
			vo.setInventoryList(dto.getInventoryList());
			super.<IGLOM02201VO>setVO(req, vo);
			
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			} else {
				forward = "DISP";
			}
			log.debug("========ÿ���̵��ѯ��������========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward(forward);
	}
	
}
