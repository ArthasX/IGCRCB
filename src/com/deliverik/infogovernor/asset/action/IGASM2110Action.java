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
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2107Form;
import com.deliverik.infogovernor.asset.vo.IGASM21071VO;

/**
 * ����: ���������Ϣ����Action����(����ҳ)
 * ��������: ���������Ϣ����Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2110Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2110Action.class);


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
		IGASM2107Form form = (IGASM2107Form)actionForm;
		
		//BLȡ��
		IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		
		//DTO����
		IGASM21DTO dto = new IGASM21DTO();

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2107");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM2107Form) req.getSession().getAttribute("IGASM2107Form");
				if ( form== null){
					form = new IGASM2107Form();
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
					form = (IGASM2107Form) req.getSession().getAttribute("IGASM2107Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��������ѯ����
			log.debug("========��������ѯ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2107");
			
			//DTO��������趨
			dto.setAuditTaskSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�����������߼�����
			dto = ctlBL.searchAuditTaskActionForChoose(dto);
			
			//���������Ϣ��������趨��VO��
			IGASM21071VO vo = new IGASM21071VO(dto.getAuditTaskInfoList());
			
			super.<IGASM21071VO>setVO(req,vo);
			
			log.debug("========��������ѯ��������========");
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
