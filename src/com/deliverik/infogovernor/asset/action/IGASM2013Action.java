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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2013Form;
import com.deliverik.infogovernor.asset.vo.IGASM20131VO;

/**
 * ����: ��CI��ѯ����Action����
 * ��������: ��CI��ѯ����Action����
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class IGASM2013Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2013Action.class);
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
		IGASM2013Form form = (IGASM2013Form)actionForm;
		
		//BLȡ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			// ��CI��ѯ���������ʾ����
			log.debug("========��CI��ѯ���������ʾ����========");
			
			dto = ctlBL.searchIGASM2013Action(dto);
			
			req.getSession().setAttribute("ADDomainList", dto.getDomainList());
			
			req.getSession().setAttribute("ADTypeList", dto.getTypeList());
			
			log.debug("========��CI��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2013");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM2013Form) req.getSession().getAttribute("IGASM2013Form");
				if ( form== null){
					form = new IGASM2013Form();
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
					form = (IGASM2013Form) req.getSession().getAttribute("IGASM2013Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��������ѯ����
			log.debug("========��CI��ѯ����ʼ========");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2013");
			
			//DTO��������趨
			dto.setIgasm2013Form(form);
			
			dto.setEiDomainDetailVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�����������߼�����
			dto = ctlBL.searchDoaminCiInfoAction(dto);
			//�����������Ϣ��������趨��VO��
			IGASM20131VO vo = new IGASM20131VO();
			
			vo.setEiDomainDetailVWInfoList(dto.getEiDomainDetailVWInfoList());
			
			vo.setEilabel(form.getEilabel());
			
			vo.setEiDomainDetailCIInfoList(dto.getEiDomainDetailCIInfoList());
			super.<IGASM20131VO>setVO(req,vo);
			
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
