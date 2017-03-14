package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1601Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16011VO;

/**
 * ������Ϣ����Action����
 *
 */
public class IGCIM1601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1601Action.class);

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
		IGCIM1601Form form = (IGCIM1601Form)actionForm;
		
		//BLȡ��
		IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
		
		//DTO����
		IGCIM16DTO dto = new IGCIM16DTO();
		
		dto.setIgcim1601Form(form);
		
		if ("INSERT".equals(mapping.getParameter())){
			//������Ϣ����
			log.debug("========������Ϣ���洦����ʾ��ʼ========");
			ctlBL.insertSoc0501Info(dto);
			log.debug("========������Ϣ���洦����ʾ����========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//������Ϣɾ��
			log.debug("========������Ϣɾ��������ʾ��ʼ========");
			ctlBL.deleteSoc0501Info(dto);
			log.debug("========������Ϣɾ��������ʾ����========");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM1601");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�豸��ѯ����
			log.debug("========�豸��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM1601Form)req.getSession().getAttribute("IGCIM1601Form");
				if ( form== null){
					form = new IGCIM1601Form();
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
					form = (IGCIM1601Form) req.getSession().getAttribute("IGCIM1601Form");
					if (form !=null) {
						if(StringUtils.isNotEmpty(req.getParameter("addFlag"))){
							form = new IGCIM1601Form();
							this.clearSessionFormData(req);
						}
						form.setFromCount(0);
					}
				}
			}
		
		
		
			int maxCnt = getMaxDataCount("IGCIM1601");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgcim1601Form(form);
			
			ctlBL.getSoc0501Info(dto);
			
			IGCIM16011VO vo = new IGCIM16011VO();
			vo.setSoc0501Infos(dto.getSoc0501List());
			
			super.setVO(req, vo);
			
			log.debug("========������Ϣ���Ҵ�����ʾ����========");
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
