/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2207Form;
import com.deliverik.infogovernor.asset.vo.IGASM22071VO;

/**
 * ����: CI���������Ϣ����Action����
 * ��������: CI���������Ϣ����Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2207Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2207Action.class);


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
		IGASM2207Form form = (IGASM2207Form)actionForm;
		
		//BLȡ��
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO����
		IGASM22DTO dto = new IGASM22DTO();

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2207");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM2207Form) req.getSession().getAttribute("IGASM2207Form");
				if ( form== null){
					form = new IGASM2207Form();
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
					form = (IGASM2207Form) req.getSession().getAttribute("IGASM2207Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//CI��������ѯ����
			log.debug("========CI��������ѯ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2003");
			
			//DTO��������趨
			dto.setCiTaskSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//CI�����������߼�����
			dto = ctlBL.searchCITaskAction(dto);
			
			//CI���������Ϣ��������趨��VO��
			IGASM22071VO vo = new IGASM22071VO(dto.getCiTaskInfoList());
			
			super.<IGASM22071VO>setVO(req,vo);
			
			log.debug("========CI��������ѯ��������========");
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
