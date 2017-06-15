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
import com.csebank.items.form.ITEMS0147Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0147Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0147Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		req.setAttribute("reqstatus_options", items01BL.getPartItemsCodesFor0147(DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�²���ѯ��ʼ������ʼ========");
			
			log.debug("========�²���ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========�²���ѯ����ʼ========");
			ITEMS0147Form form = (ITEMS0147Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//����ҳ.do
				form = (ITEMS0147Form) req.getSession().getAttribute("ITEMS0147Form");
			}
			//��ȡ��ҳBean
			getPaginDTO(req,"ITEMS0147");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (ITEMS0147Form) req.getSession().getAttribute("ITEMS0147Form");
				if ( form == null ) {
					form = new ITEMS0147Form();
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
					form = (ITEMS0147Form) req.getSession().getAttribute("ITEMS0147Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0147");

			//�����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(flag){
//				form.setReqorg_q(DefineUtils.DEFAULT_ORGNO);
			}else{
				form.setReqorg_q(user.getOrgid());
			}
			form.setOuttype_q(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);	
			dto.setItems0147form(form);
			dto.setOutStockSearchVWCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		
			
			//����BL��ѯ
			dto = items01BL.searchOutStockVWAction(dto);
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStockList(dto.getOutStockList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========�²���ѯ��������========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========�²��鿴��ϸ����ʼ========");
			ITEMS0147Form form = (ITEMS0147Form)actionForm;
			dto.setOutstockid(Integer.valueOf(form.getSid()));
			//����BL��ѯ
			dto = items01BL.searchOutStockDetailAction(dto);
			
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStock(dto.getOutStock());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========�²��鿴��ϸ��������========");
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
