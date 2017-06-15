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
import com.csebank.items.form.ITEMS0144Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0144Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0144Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		req.setAttribute("reqstatus_options", items01BL.getPartItemsCodesFor0144(DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�ҵ������ѯ��ʼ������ʼ========");
			
			log.debug("========�ҵ������ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========�ҵ������ѯ����ʼ========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
		
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());

		
			
			//��ȡ��ҳBean
			getPaginDTO(req,"ITEMS0144");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (ITEMS0144Form) req.getSession().getAttribute("ITEMS0144Form");
				if ( form == null ) {
					form = new ITEMS0144Form();
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
					form = (ITEMS0144Form) req.getSession().getAttribute("ITEMS0144Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//����ѯ״̬Ϊ������ʱ����flag��Ϊ1
			if(DefineUtils.ITEMSCODES_REQSTATUS_DJS.equals(form.getReqstatus_q())){
				form.setFlag("1");
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP.equals(form.getReqstatus_q())){
				//����ѯ״̬Ϊ���������ʱ����flag��Ϊ2
				form.setFlag("2");
			}else{
				form.setFlag("0");
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0144");
			
			//�������û���Ϊ��ǰ�û�����������
			//form.setReqorg_q(user.getOrgid());

			//�����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
//			boolean flag = items01BL.checkRoleManagerByUserID(dto);
//			if(flag){
//				form.setReqorg_q(DefineUtils.DEFAULT_ORGNO);
//			}else{
//				form.setReqorg_q(user.getOrgid());
//			}
			form.setReqorg_q(user.getOrgid());
			dto.setItems0144form(form);
			
			dto.setOutStockSearchVWCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		
			
			//����BL��ѯ
			dto = items01BL.searchOutStockVWAction(dto);
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStockList(dto.getOutStockList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========�ҵ������ѯ��������========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========�ҵ�����鿴��ϸ����ʼ========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			dto.setOutstockid(Integer.valueOf(form.getSid()));
			//����BL��ѯ
			dto = items01BL.searchOutStockDetailAction(dto);
			
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStock(dto.getOutStock());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========�ҵ�����鿴��ϸ��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========�ҵ�����'����'����ʼ========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0144form(form);
			
			//����BL
			dto = items01BL.doStock(dto,"receiveOutStockAction");
			if("JS_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
				return mapping.findForward("JS_REQSTATUS_ERROR");//���ش�����ʾ��Ϣҳ
			}
			
			
			log.debug("========�ҵ�����'����'��������========");
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========�ҵ�����'�޸�'����ʼ========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0144form(form);
			
			//����BL
			dto = items01BL.doStock(dto,"editOutStockAction");
			if("EDIT_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
				return mapping.findForward("EDIT_REQSTATUS_ERROR");//���ش�����ʾ��Ϣҳ
			}
			
			
			log.debug("========�ҵ�����'�޸�'��������========");
		}else if("DEL".equals(mapping.getParameter())){
			log.debug("========�ҵ�����'ɾ��'����ʼ========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0144form(form);
			
			//����BL
			dto = items01BL.doStock(dto,"delOutStockAction");
			if("DEl_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
				return mapping.findForward("DEl_REQSTATUS_ERROR");//���ش�����ʾ��Ϣҳ
			}
			
			
			log.debug("========�ҵ�����'ɾ��'��������========");
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
