/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0213Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02131VO;

/**
 * ����: ��CI��ѯ����Action����
 * ��������: ��CI��ѯ����Action����
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class IGCIM0213Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0213Action.class);
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0213Form form = (IGCIM0213Form)actionForm;
		
		//BLȡ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		if ("DISP".equals(mapping.getParameter())) {
			// ��CI��ѯ���������ʾ����
			log.debug("========��CI��ѯ���������ʾ����========");
			
			dto = ctlBL.searchIGCIM0213Action(dto);
			
			req.getSession().setAttribute("ADDomainList", dto.getDomainList());
			
			req.getSession().setAttribute("ADTypeList", dto.getTypeList());
			
			log.debug("========��CI��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM0213");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0213Form) req.getSession().getAttribute("IGCIM0213Form");
				if ( form== null){
					form = new IGCIM0213Form();
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
					form = (IGCIM0213Form) req.getSession().getAttribute("IGCIM0213Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��������ѯ����
			log.debug("========��CI��ѯ����ʼ========");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0213");
			
			//DTO��������趨
			dto.setIgcim0213Form(form);
			
			dto.setEiDomainDetailVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�����������߼�����
			dto = ctlBL.searchDoaminCiInfoAction(dto);
			//�����������Ϣ��������趨��VO��
			IGCIM02131VO vo = new IGCIM02131VO();
			
			vo.setSoc0138InfoList(dto.getSOC0138InfoList());
			
			vo.setEilabel(form.getEilabel());
			
			vo.setSoc0136infoList(dto.getSOC0136InfoList());
			super.<IGCIM02131VO>setVO(req,vo);
			
			log.debug("========��CI��ѯ��������========");
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
