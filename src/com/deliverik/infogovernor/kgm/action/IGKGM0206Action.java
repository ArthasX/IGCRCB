/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02051VO;

/**
 * ����:֪ʶ���ѯPOPUPAction
 * ����������֪ʶ���ѯPOPUPAction
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public class IGKGM0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0205Action.class);

	/**
	 * ����
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
		IGKGM0203Form form = (IGKGM0203Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//֪ʶ��ѯ���������ʾ����
			log.debug("========֪ʶ��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//֪ʶ��ѯ����
			log.debug("========֪ʶ��ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGKGM0206");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGKGM0203Form) req.getSession().getAttribute("IGKGM0203Form");
				if ( form == null ) {
					form = new IGKGM0203Form();
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
					form = (IGKGM0203Form) req.getSession().getAttribute("IGKGM0203Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGKGM0206");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO��������趨
			dto.setIgkgm0203Form(form);
			//dto.setProcessRecordKnSearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//֪ʶ��Ϣ�����߼�����
			dto = ctlBL.searchKnowLedgeInfoAction(dto);
			
			//��֪ʶ������Ϣ��������趨��VO��
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowLedgeInfoList(dto.getKnowLedgeInfoList());
			super.<IGKGM02051VO>setVO(req, vo);
			
			log.debug("========֪ʶ��ѯ��������========");
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
