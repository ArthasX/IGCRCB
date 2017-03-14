/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0171Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01711VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0171Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0171Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.getSession().setAttribute("ADcategory_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ��ʼ������ʼ========");
			
			log.debug("========��Ʒ�����ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ����ʼ========");
			ITEMS0171Form form = (ITEMS0171Form)actionForm;
			
			dto.setOutStockDetailSearchCond(form);
			dto.setMaxSearchCount(getMaxDataCount("DEFAULT"));
			//����BL
			dto = items01BL.searchITEMS0171Action(dto);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			//����VO
			ITEMS01711VO vo = new ITEMS01711VO();
			vo.setItems01712VOList(dto.getItems01712VOList());//��Ʒ����
			vo.setTotal(dto.getTotal());//��Ʒ�����ܼ�
			super.<ITEMS01711VO>setVO(req, vo);
			
			log.debug("========��Ʒ�����ѯ��������========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ����ʼ========");
			ITEMS0171Form form = (ITEMS0171Form)actionForm;
			
			dto.setOutStockDetailSearchCond(form);
			dto.setMaxSearchCount(getMaxDataCount("DEFAULT"));
			
			//����BL
			dto = items01BL.searchITEMS0171Action(dto);
			//����VO
			ITEMS01711VO vo = new ITEMS01711VO();
			vo.setItems01712VOList(dto.getItems01712VOList());//��Ʒ����
			vo.setTotal(dto.getTotal());//��Ʒ�����ܼ�
			super.<ITEMS01711VO>setVO(req, vo);
			return mapping.findForward("REPORT");

		}
		
		return mapping.findForward("DISP");
	}
	
}
