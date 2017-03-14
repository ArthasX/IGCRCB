/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM03BL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0303Form;
import com.deliverik.infogovernor.iam.vo.IGIAM01011VO;
import com.deliverik.infogovernor.iam.vo.IGIAM03011VO;

/**
 * ����:�ṩ����Ʊ�����Ϣ����ɾ�Ĳ�
 * �����������ṩ����Ʊ�����Ϣ����ɾ�Ĳ�
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-10
 * �޸ļ�¼��
 */
public class IGIAM0303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0303Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡForm��
		IGIAM0303Form igiamForm = (IGIAM0303Form)form ;
		// ��ȡҵ���߼�BL
		IGIAM03BL iam03BL = (IGIAM03BL) getBean("igiam03bl");
		// ����DTO
		IGIAM03DTO igiam03DTO = new IGIAM03DTO();
		// ��ȡ��ǰ��¼�û�
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("TOUPDATE".equals(mapping.getParameter())){
			log.debug("========��ת����Ʊ���鿴ҳ��========");
			//��form��װ��dto��
			igiam03DTO.setIgiam0303Form(igiamForm);
			//����ҵ�񷽷�ִ��������ѯ����
			igiam03DTO = iam03BL.dsearchIAMAction(igiam03DTO);
			//form���¸�ֵ
			igiamForm = igiam03DTO.getIgiam0303Form();
			//��ʼ��VO
			IGIAM03011VO vo = new IGIAM03011VO();
			//������List��װ��VO��
			vo.setAttkeyList(igiam03DTO.getAttkeyList());
			//����VO
			super.<IGIAM03011VO>setVO(request, vo);
			log.debug("========��ת����Ʊ���鿴ҳ�����========");
		}
		//������Ŀ�޸�
		if ("UPDATE".equals(mapping.getParameter())) {
			log.debug("========��Ʊ��汣���޸�========");
			//��form��װ��dto��
			igiam03DTO.setIgiam0303Form(igiamForm);
			//����ҵ�񷽷����и��²���
			igiam03DTO = iam03BL.updateIAMAction(igiam03DTO);
			log.debug("========��Ʊ��汣���޸Ľ���========");
		}
		if("DELETE".equals(mapping.getParameter())){
			//ִ��ɾ������
			log.debug("========��Ʊ���ɾ������ʼ========");
			//��ȡҪɾ����Ʊ�����Ϣ������
			String apids = request.getParameter("apids");
			igiam03DTO.setApids(apids);
			//����ɾ��ҵ���߼�����
			iam03BL.deleteIAMAction(igiam03DTO);
			log.debug("========��Ʊ���ɾ���������========");
		}
		List<ActionMessage> messageList = igiam03DTO.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
