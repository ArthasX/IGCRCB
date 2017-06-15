package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1632Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16321VO;

/**
 * ���������ϵ����Action����
 *
 */
public class IGCIM1632Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1632Action.class);

	/**
	 * �¼�����
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
				IGCIM1632Form form = (IGCIM1632Form)actionForm;
				
				//BLȡ��
				IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
				
				//DTO����
				IGCIM16DTO dto = new IGCIM16DTO();
				dto.setLocale(this.getLocale(req));
				//������ת�趨
				String forword = null;
				
				if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
					//�豸��ϵ�����������ʾ����
					log.debug("========�����ϵ�����������ʾ����ʼ========");
					if ("REDISP".equals(mapping.getParameter())){
						form = (IGCIM1632Form) req.getSession().getAttribute("IGCIM1632Form");
					}
					
					//��ѯ��¼������ȡ��
					int maxCnt = getMaxDataCount("IGCIM1632");
					
					//DTO��������趨
					dto.setIgcim1632Form(form);
					
					dto.setMaxSearchCount(maxCnt);
					User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
					
					dto.setUser(user);
					dto = ctlBL.initIGCIM1632BelongAction(dto);
					
					//�����͹�ϵ������Ϣ��������趨��VO��
					IGCIM16321VO vo = new IGCIM16321VO();
					
					vo.setEntityItemData(dto.getSoc0124Info());
					
					//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
					vo.setFlag(dto.getFlag());
					vo.setEiorgname(dto.getEiorgname());
					//����������ϵ�б�
					vo.setSoc0119List(dto.getSoc0119List());
					super.<IGCIM16321VO>setVO(req.getSession(), vo);
					saveToken(req);
					log.debug("========�����ϵ�����������ʾ��������========");
					
					forword = "DISP";
				}
				
				
				
				
				
				if ("DELETE".equals(mapping.getParameter())){
					//�豸��ϵɾ������
					log.debug("========�豸��ϵɾ������ʼ========");
					
					form.getEiid();
					
					//DTO��������趨
					dto.setDeleteEntityItemRelation(form.getDeleteEirid());
					
					dto = ctlBL.delRelation(dto);
					
					log.debug("========�豸��ϵɾ����������========");
					
					
					forword = "DISP";
				}

				//�߼���������е���Ϣ��ʾ
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward(forword);
			}
}
