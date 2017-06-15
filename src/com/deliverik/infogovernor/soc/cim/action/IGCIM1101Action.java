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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1101Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM11011VO;

/**
 * Ӧ�ò�ѯ����Action����
 *
 */
public class IGCIM1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1101Action.class);

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
		IGCIM1101Form form = (IGCIM1101Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�ò�ѯ���������ʾ����
			log.debug("========Ӧ�ò�ѯ���������ʾ����ʼ========");
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ӧ�ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM1101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//Ӧ�ò�ѯ����
			log.debug("========Ӧ�ò�ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM1101Form) req.getSession().getAttribute("IGCIM1101Form");
				if ( form== null){
					form = new IGCIM1101Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
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
					form = (IGCIM1101Form) req.getSession().getAttribute("IGCIM1101Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM1101");
			form.setEsyscoding("999003001");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//Ӧ�ü����߼�����
			dto = ctlBL.searchEntityItemActionApp(dto);
			
			//��Ӧ����Ϣ��������趨��VO��
			IGCIM11011VO vo = new IGCIM11011VO(dto.getEntityItemVWInfoList());
			
			super.<IGCIM11011VO>setVO(req, vo);
			
			log.debug("========Ӧ�ò�ѯ��������========");
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
