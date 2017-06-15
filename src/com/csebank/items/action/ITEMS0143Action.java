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
import com.csebank.items.form.ITEMS0143Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0143Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0143Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�����·���ѯ��ʼ������ʼ========");
			
			log.debug("========�����·���ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========�����·���ѯ����ʼ========");
			ITEMS0143Form form = (ITEMS0143Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//����ҳ.do
				form = (ITEMS0143Form) req.getSession().getAttribute("ITEMS0143Form");
			}
			//��ȡ��ҳBean
			getPaginDTO(req,"ITEMS0143");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (ITEMS0143Form) req.getSession().getAttribute("ITEMS0143Form");
				if ( form == null ) {
					form = new ITEMS0143Form();
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
					form = (ITEMS0143Form) req.getSession().getAttribute("ITEMS0143Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0143");
			
			//�����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
//			boolean flag = items01BL.checkRoleManagerByUserID(dto);
//			if(flag){
//				form.setReqorg_q(DefineUtils.DEFAULT_ORGNO);
//			}else{
//				form.setReqorg_q(user.getOrgid());
//			}

			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DCK);
			
			dto.setItems0143form(form);
			
			dto.setOutStockSearchVWCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		
			
			//����BL��ѯ
			dto = items01BL.searchOutStockVWAction(dto);
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStockList(dto.getOutStockList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========�����·���ѯ��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========�����·�����ʼ========");
			ITEMS0143Form form = (ITEMS0143Form)actionForm;
	
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0143form(form);
			
			//����BL
			dto = items01BL.doStock(dto,"distributionOutStockAction");
			if(dto.getGoToError()!=null){
				String cnr[]=dto.getGoToError().split(";");
				if(cnr!=null&&cnr.length==2)
				{
					if("CK_NUM_ERROR".equals(cnr[0])){
						//�������������������
						String emas[] = cnr[1].split(",");
						for(int i=0;i<emas.length;i+=2)
						{
						addMessage(req, new ActionMessage("IGFXT0301.E006",
								emas[i],emas[i+1]));
						}
						return mapping.findForward("CK_NUM_ERROR");//���ش�����ʾ��Ϣҳ
					}else if("CK_REQSTATUS_ERROR".equals(cnr[0])){
						//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
						String emas[] = cnr[1].split(",");
						for(int i=0;i<emas.length;i++)
						{addMessage(req, new ActionMessage("IGFXT0301.E007",emas[i]));}
						return mapping.findForward("CK_REQSTATUS_ERROR");//���ش�����ʾ��Ϣҳ
					}
				}
			}
			
			log.debug("========�����·���������========");
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
