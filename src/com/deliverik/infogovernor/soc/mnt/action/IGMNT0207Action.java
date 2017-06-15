/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0207Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02071VO;

/**
 * ����: �������ݱ�����ѯ����Action����
 * ��������: �������ݱ�����ѯ����Action����
 * ������¼: 2011/11/24
 * �޸ļ�¼: 
 */
public class IGMNT0207Action extends BaseAction{
	static Log log = LogFactory.getLog(IGMNT0207Action.class);
	/**
	 * �������ݱ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGMNT0207Form form = (IGMNT0207Form)actionForm;
		
		//BLȡ��
		IGMNT02BL ctlBL = (IGMNT02BL) getBean("igmnt02BL");
		
		//DTO����
		IGMNT02DTO dto = new IGMNT02DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�������ݱ������ڻ��濪ʼ========");
			log.debug("========�������ݱ������ڻ�������========");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGMNT0207");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGMNT0207Form) req.getSession().getAttribute("IGMNT0207Form");
				if ( form== null){
					form = new IGMNT0207Form();
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
					form = (IGMNT0207Form) req.getSession().getAttribute("IGMNT0207Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//�洢��ѯ����
			log.debug("========�������ݱ�����ѯ��ʼ========");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGMNT0207");
			
			//DTO��������趨
			dto.setIgmnt0207Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������ݱ�����ѯ����
			dto = ctlBL.searchSOC0306Action(dto);
			//���������ݱ�����ѯ����趨��VO��
			IGMNT02071VO vo = new IGMNT02071VO();
			
			vo.setSoc0306List(dto.getSoc0306List());
			
			super.<IGMNT02071VO>setVO(req,vo);
			
			log.debug("========�������ݱ�����ѯ����========");
		}else if( "POP".equals(mapping.getParameter())){

			log.debug("========�������ݱ����������ڿ�ʼ========");
			
			//DTO��������趨
			dto.setIgmnt0207Form(form);
			
			//���������ݱ�����ѯ����
			dto = ctlBL.popSOC0306Action(dto);
			
			//���������ݱ�����ѯ����趨��VO��
			IGMNT02071VO vo = new IGMNT02071VO();
			
			vo.setSoc0306List(dto.getSoc0306List());
			
			super.<IGMNT02071VO>setVO(req,vo);
			
			log.debug("========�������ݱ���������������========");
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
