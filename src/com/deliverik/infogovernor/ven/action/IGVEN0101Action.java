package com.deliverik.infogovernor.ven.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;
import com.deliverik.infogovernor.ven.bl.IGVEN01BL;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0101Form;
import com.deliverik.infogovernor.ven.form.IGVEN0102Form;
import com.deliverik.infogovernor.ven.vo.IGVEN01011VO;

/**
 * ���ռ���ѯ����Action����
 *
 */
public class IGVEN0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0101Action.class);

	/**
	 * ���ռ���ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//BLȡ��
		IGVEN01BL ctlBL = (IGVEN01BL) getBean("igven01BL");
		
		//DTO����
		IGVEN01DTO dto = new IGVEN01DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���ռ���ѯ���������ʾ����ʼ========");
			
			//FORMȡ��
			IGVEN0101Form form = (IGVEN0101Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ռ���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ���ѯ����ʼ========");

			//FORMȡ��
			IGVEN0101Form form = (IGVEN0101Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGVEN0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(StringUtils.isEmpty(form.getRcstatus_q())){
				form.setRcstatus_q("0");//����״̬
			}
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGVEN0101Form) req.getSession().getAttribute("IGVEN0101Form");
				if ( form == null ) {
					form = new IGVEN0101Form();
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
					form = (IGVEN0101Form) req.getSession().getAttribute("IGVEN0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO��������趨
			dto.setIgven0101Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchRiskCheckAction(dto);
				
			//��������Ϣ��������趨��VO��
			IGVEN01011VO vo = new IGVEN01011VO();

			vo.setRiskStrategyList(dto.getRiskStrategyList());
			super.<IGVEN01011VO>setVO(req, vo);
			
			log.debug("========���ռ���ѯ��������========");
		}else if ("CHANGE".equals(mapping.getParameter())){
			//�޸�״̬1���� 0ͣ��
			log.debug("========���ռ��״̬�仯����ʼ========");

			//FORMȡ��
			IGVEN0102Form form = (IGVEN0102Form)actionForm;
			dto.setIgVEN0102Form(form);
//			dto = ctlBL.changeRiskCheckStatusAction(dto);
			dto = ctlBL.changeCheckStrategyStatusOnlyAction(dto);
			
			log.debug("========���ռ��״̬�仯��������========");
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
