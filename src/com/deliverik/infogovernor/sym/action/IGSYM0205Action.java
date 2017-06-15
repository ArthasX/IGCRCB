/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0204Form;
import com.deliverik.infogovernor.sym.vo.IGSYM02011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_��ѯɾ��ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0205Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0205Action.class);
	
	/**
	 * <p>
	 * Description: �û�action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSYM0204Form form = (IGSYM0204Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM02BL ctlBL = (IGSYM02BL) getBean("igsym02BL");
		//ʵ����DTO
		IGSYM02DTO dto = new IGSYM02DTO();

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�û���ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�û���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//�û���ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========�û���ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0201");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0204Form) request.getSession().getAttribute("IGSYM0204Form");
				if ( form== null){
					form = new IGSYM0204Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSYM0204Form) request.getSession().getAttribute("IGSYM0204Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0201");
			
			dto.setUserSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchUserAction(dto);
			//����VO
			IGSYM02011VO vo = new IGSYM02011VO(dto.getUserList());
			
			super.<IGSYM02011VO>setVO(request, vo);
			
			log.debug("========�û���ѯ��������========");
		}
		
		if("DISPCB".equals(mapping.getParameter())){
			log.debug("========�û���ѯ(checkBox)ѡ��ҳ�洦��ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�û���ѯ(checkBox)ѡ��ҳ�洦�����========");
			return mapping.findForward("DISP");
		}
		if("SEARCH_NOPAGE".equals(mapping.getParameter())) {
			log.debug("========�û���ѯ(�޷�ҳ)����ʼ========");
			int maxCnt = getMaxDataCount("IGSYM0201");
			dto.setIgsym0204Form(form);
			dto.setMaxSearchCount(maxCnt);
			//����BL��ѯ
			dto = ctlBL.searchUserActionNoPage(dto);
			//����VO
			IGSYM02011VO vo = new IGSYM02011VO(dto.getUserList());
			super.<IGSYM02011VO>setVO(request, vo);
			log.debug("========�û���ѯ(�޷�ҳ)�������========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
