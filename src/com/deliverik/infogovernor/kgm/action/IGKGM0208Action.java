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
import com.deliverik.infogovernor.kgm.form.IGKGM0208Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02081VO;

/**
 * ����: ֪ʶ��˻���Action����
 * ����������1.��ѯδ��˵�֪ʶ
 *           2.δ��˵�֪ʶ��˹��򲵻�
 * ������¼���κ��� 2010/12/07
 * �޸ļ�¼��
 */
public class IGKGM0208Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0208Action.class);

	/**
	 * ���ܣ���˴���
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
		IGKGM0208Form form = (IGKGM0208Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			//֪ʶ��ѯ���������ʾ����
			log.debug("========֪ʶ��˲�ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ��˲�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//֪ʶ��ѯ����
			log.debug("========֪ʶ��˲�ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGKGM0208");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGKGM0208Form) req.getSession().getAttribute("IGKGM0208Form");
				if ( form == null ) {
					form = new IGKGM0208Form();
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
					form = (IGKGM0208Form) req.getSession().getAttribute("IGKGM0208Form");
					if (form !=null) {
						form.setFromCount(0);
						form.setKnreject(null);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGKGM0208");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//����Կո�ָ�ļ�������:�ؼ���
			if(StringUtils.isNotEmpty(form.getKnkey())){
				form.setKnkeys(form.getKnkey().trim().split(" "));
			}else{
				form.setKnkeys(null);
			}
			
			//����Կո�ָ�ļ�������:����
			if(StringUtils.isNotEmpty(form.getKntitle())){
				form.setKntitles(form.getKntitle().trim().split(" "));
			}else{
				form.setKntitles(null);
			}
			
			// δ���״̬
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);
			//DTO��������趨
			dto.setKnowledgeSearchCond(form);
			
			//֪ʶ��Ϣ�����߼�����
			dto = ctlBL.searchKnowLedgeAction(dto);
			
			//��֪ʶ������Ϣ��������趨��VO��
			IGKGM02081VO vo = new IGKGM02081VO();
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02081VO>setVO(req, vo);
			if(form.getShowFlag()!=null&&!(form.getShowFlag().equals(""))){
			req.setAttribute("showFlag", form.getShowFlag());
				
			}
			log.debug("========֪ʶ��˲�ѯ��������========");
		} else if ("UPDATE".equals(mapping.getParameter())){
			log.debug("========֪ʶ���ͨ������ʼ========");
			
			
			dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			dto.setKnids(form.getKnids());
			dto.setKnversions(form.getKnversions());
			ctlBL.updateKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0208.I001"));
			log.debug("========֪ʶ���ͨ���������========");	
			return mapping.findForward("DISP");
			
		}else if ("REJECT".equals(mapping.getParameter())){
			log.debug("========֪ʶ���ش���ʼ========");
			
			dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_REJECT);
			dto.setKnids(form.getKnids());
			dto.setKnrejects(form.getKnrejects());
			dto.setKnversions(form.getKnversions());
			ctlBL.updateKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0208.I002"));
			log.debug("========֪ʶ���ش������========");	
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
