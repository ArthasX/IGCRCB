/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0209Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02091VO;

/**
 * ����: ֪ʶ������Action����
 * ����������1.��ѯ����ġ�ͣ�õ�֪ʶ
 *           2.�Թ������֪ʶɾ����ͣ�á�����
 * ������¼���κ��� 2010/12/09
 * �޸ļ�¼��
 */
public class IGKGM0209Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0209Action.class);

	/**
	 * ���ܣ�֪ʶ������
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
		//FORMȡ��
		IGKGM0209Form form = (IGKGM0209Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			//֪ʶ��ѯ���������ʾ����
			log.debug("========֪ʶ�����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ�����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//֪ʶ��ѯ����
			log.debug("========֪ʶ�����ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGKGM0209");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGKGM0209Form) req.getSession().getAttribute("IGKGM0209Form");
				if ( form == null ) {
					form = new IGKGM0209Form();
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
					form = (IGKGM0209Form) req.getSession().getAttribute("IGKGM0209Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGKGM0209");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//����Կո�ָ�ļ�������:�ؼ���
			if(StringUtils.isNotEmpty(form.getKnkey())){
				form.setKnkeys(form.getKnkey().split(" "));
			}else{
				form.setKnkeys(null);
			}
			
			//����Կո�ָ�ļ�������:����
			if(StringUtils.isNotEmpty(form.getKntitle())){
				form.setKntitles(form.getKntitle().split(" "));
			}else{
				form.setKntitles(null);
			}
			
			// δ����״̬
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED + "," + IGKGMCONSTANTS.KNOWLEDGE_STOP);
			//DTO��������趨
			dto.setKnowledgeSearchCond(form);
			
			//֪ʶ��Ϣ�����߼�����
			dto = ctlBL.searchKnowLedgeAction(dto);
			
			
			//��֪ʶ������Ϣ��������趨��VO��
			IGKGM02091VO vo = new IGKGM02091VO();
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02091VO>setVO(req, vo);
			if(form.getShowFlag()!=null&&!(form.getShowFlag().equals(""))){
				req.setAttribute("showFlag", form.getShowFlag());
			}
			log.debug("========֪ʶ�����ѯ��������========");
		} else if ("UPDATE".equals(mapping.getParameter())){
			log.debug("========֪ʶͣ��/���ô���ʼ========");
			
			dto.setKnstatus(form.getKnstatus());
			
			//dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			
			dto.setKnids(form.getKnids());
			dto.setKnversions(form.getKnversions());
			ctlBL.updateKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0209.I002"));
			log.debug("========֪ʶͣ��/���ô������========");	
			return mapping.findForward("DISP");
			
		}else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========֪ʶɾ������ʼ========");
			
			dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_DELETE);
			dto.setKnids(form.getKnids());
			ctlBL.updateKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0209.I001"));
			log.debug("========֪ʶɾ���������========");	
			return mapping.findForward("DISP");
			
		}
		
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
