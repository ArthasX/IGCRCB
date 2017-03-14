package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1414Form;
import com.deliverik.infogovernor.asset.vo.IGASM14141VO;

/**
 * <p>
 * Title : �豸�����¼��ѯ����
 * </p>
 * <p>
 * Description: �豸�����¼��ѯ����Action
 * </p>
 * 
 * @author songhaiyang@deliverik.com
 * @version 1.0
 */
public class IGASM1414Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1414Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM1414Form form = (IGASM1414Form)actionForm;
		
		//BLȡ��
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO����
		IGASM14DTO dto = new IGASM14DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�豸��ѯ���������ʾ����
			log.debug("========�豸�����¼��ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(�豸)�趨
			form = new IGASM1414Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGASM1414Form", form);

			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸�����¼��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM1414");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�豸��ѯ����
			log.debug("========�豸�����¼��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬���ز�ѯ����ʱ���ټ�������
				form = (IGASM1414Form) req.getSession().getAttribute("IGASM1414Form");
				if ( form== null){
					form = new IGASM1414Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
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
					form = (IGASM1414Form) req.getSession().getAttribute("IGASM1414Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1414");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�豸�����߼�����
			dto = ctlBL.searchServiceAction(dto);
			
			//���豸��Ϣ��������趨��VO��
			IGASM14141VO vo = new IGASM14141VO(dto.getEntityItemList());
			
			super.<IGASM14141VO>setVO(req, vo);
			
			log.debug("========�豸�����¼��ѯ��������========");
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
