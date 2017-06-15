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
import com.csebank.items.form.ITEMS0106Form;
import com.csebank.items.form.ITEMS0141Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0141Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0141Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		String requestStatus = 
			items01BL.getRequsetStatus(DefineUtils.ITEMSCODES_ITEMSCODES_REQUESTSTATUS);
		if(DefineUtils.ITEMSCODES_REQUEST_TRUE.equals(requestStatus)){
			req.setAttribute("isDisabled", "");
			req.setAttribute("canSearch", "��ѯ");
			req.setAttribute("message", "������Ʒ");
		} else if(DefineUtils.ITEMSCODES_REQUEST_FALSE.equals(requestStatus)){
			req.setAttribute("isDisabled", "true");
			req.setAttribute("canSearch", "��ǰ���칦���Ѿ��ر�");
			req.setAttribute("message", "��ǰ���칦���Ѿ��ر�");
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ��ʼ������ʼ========");
			saveToken(req);
			log.debug("========��Ʒ�����ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ����ʼ========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//����ҳ.do
				form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
			}
			//��ȡ��ҳBean
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
				if ( form == null ) {
					form = new ITEMS0106Form();
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
					form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setItems0106form(form);
			//dto.setStockSearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setCategory(form.getCategory());
			dto.setTypecode_q(form.getTypecode_q());//��Ʒ����
			dto.setStockorg_q(DefineUtils.DEFAULT_ORGNO);//����Ĭ�ϻ�����Ϊ���л�����
			//����BL��ѯ
			dto = items01BL.searchStockForInsertOutStockAction(dto);
			//����VO
			
//			String requestStatus = 
//				items01BL.getRequsetStatus(DefineUtils.ITEMSCODES_ITEMSCODES_REQUESTSTATUS);
//			if(DefineUtils.ITEMSCODES_REQUEST_TRUE.equals(requestStatus)){
//				req.setAttribute("isDisabled", "");
//				req.setAttribute("canSearch", "��ѯ");
//				req.setAttribute("message", "������Ʒ");
//			} else if(DefineUtils.ITEMSCODES_REQUEST_FALSE.equals(requestStatus)){
//				req.setAttribute("isDisabled", "true");
//				req.setAttribute("canSearch", "��ǰ���칦���Ѿ��ر�");
//				req.setAttribute("message", "��ǰ���칦���Ѿ��ر�");
//			}
			
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setItemsCategoryList(dto.getItemsCategoryList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========��Ʒ�����ѯ��������========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========��Ʒ����鿴��ϸ����ʼ========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			dto.setStockid(Integer.valueOf(form.getSid()));
			//����BL��ѯ
			dto = items01BL.searchStockDetailAction(dto);
			
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setStock(dto.getStock());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========��Ʒ����鿴��ϸ��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========������Ʒ����ʼ========");
			ITEMS0141Form form = (ITEMS0141Form)actionForm;
			
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0141form(form);
			
			//����BL
			if(isTokenValid(req, true)){
				dto = items01BL.doStock(dto,"insertOutStockAction");
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========������Ʒ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
