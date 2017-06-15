/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.iam.bl.IGIAM03BL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0301Form;
import com.deliverik.infogovernor.iam.vo.IGIAM03011VO;

/**
 * ����: ��Ʊ����������action
 * ������������Ʊ����������action
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-8
 * �޸ļ�¼��
 */
public class IGIAM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0301Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡform
		IGIAM0301Form form = (IGIAM0301Form)actionForm;
		//��ȡҵ���߼�BL
		IGIAM03BL iam03BL = (IGIAM03BL)getBean("igiam03bl");
		//����DTO
		IGIAM03DTO igiam03DTO = new IGIAM03DTO();
		//��ȡ��ǰ��¼�û�
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========��Ʊ����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request, "IGIAM0301");	
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
			if ("SEARCH1".equals(mapping.getParameter())){
				form.setApprojectname("");
				form.setApreporttype("");
			//���г��β�ѯ����
			} else {
				//�ж�form�Ƿ�Ϊ��
				if (form == null) {
					//formΪ��ʱ����ʼ��form
					form = new IGIAM0301Form();
				} else {
					//���з�ҳ����
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIAM0301");
			//����ѯ����Ľ������װ��dto��
			igiam03DTO.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			igiam03DTO.setPagingDto(pDto);
			igiam03DTO.setIgiam0301Form(form);
			//��ѯ���
			igiam03DTO = iam03BL.searchIAM03DTOAction(igiam03DTO);
			//����ѯ����ŵ�VO��
			IGIAM03011VO vo = new IGIAM03011VO();
			vo.setAuditProjectInfoList(igiam03DTO.getAuditProjectInfoList());
			//�Ż�VO
			super.<IGIAM03011VO>setVO(request, vo);
			log.debug("========��Ʊ����ѯ�������========");
		}
		return mapping.findForward("DISP");
	}
	
}
