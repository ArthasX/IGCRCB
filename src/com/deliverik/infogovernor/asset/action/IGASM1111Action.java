package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1111Form;
import com.deliverik.infogovernor.asset.vo.IGASM11111VO;
import com.deliverik.infogovernor.asset.vo.IGASM11201VO;

/**
 * �����б���Action����
 *
 */
public class IGASM1111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1111Action.class);

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
		IGASM1111Form form = (IGASM1111Form)actionForm;

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		//������ת����
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter()) || "SEARCH".equals(mapping.getParameter())){
			//����ѡ���������ʾ����
			log.debug("========�����б��������ʾ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM1111");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM1111Form) req.getSession().getAttribute("IGASM1111Form");
				if ( form== null){
					form = new IGASM1111Form();
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
					form = (IGASM1111Form) req.getSession().getAttribute("IGASM1111Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1111");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������߼�����
			dto = ctlBL.initIGASM1111Action(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11111VO vo = new IGASM11111VO(
					dto.getComputerContainerVWInfoList());
			
			super.<IGASM11111VO>setVO(req, vo);
			
			forward = "DISP";
			
			log.debug("========�����б��������ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//����ɾ������
			log.debug("========����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//����ɾ���߼�����
			ctlBL.deleteComputerContainerInfoAction(dto);
			
			forward = "DISP";

			log.debug("========����ɾ����������========");
		}
		if ("Detail".equals(mapping.getParameter())){
			//��ѯ�����豸��ϸ
			log.debug("========�豸��ϸ����ʼ========");
			String eiid = null;
			if(StringUtils.isEmpty(form.getComputerContainerId())){
				 eiid=req.getSession().getAttribute("eiid").toString();
				 dto.setComputerContainerId(eiid);
				 forward = "Detail2";
			}else{
				dto.setComputerContainerId(form.getComputerContainerId());
				req.getSession().setAttribute("eiid", form.getComputerContainerId());
				forward = "Detail1";
			}	
			dto = ctlBL.getEquipmentAndIpAction(dto);
			IGASM11201VO vo = new IGASM11201VO();			
			vo.setEilist(dto.getEilist());
			super.<IGASM11201VO>setVO(req, vo);						
			log.debug("========�豸��ϸ��������========");
		}

		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
