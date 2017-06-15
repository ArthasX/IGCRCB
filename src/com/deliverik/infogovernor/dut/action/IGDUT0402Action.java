/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dut.bl.IGDUT04BL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0402Form;
import com.deliverik.infogovernor.dut.vo.IGDUT04021VO;

/**
 * ��ʱ��������Action
 */
public class IGDUT0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0402Action.class);

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
		IGDUT0402Form form = (IGDUT0402Form)actionForm;
		
		//BLȡ��
		IGDUT04BL ctlBL = (IGDUT04BL) getBean("igdut04BL");
		
		//DTO����
		IGDUT04DTO dto = new IGDUT04DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ʱ���������������ʾ����ʼ========");
			dto=ctlBL.getTitle(dto);
			List<LabelValueBean> titleList = dto.getTitleList();
			req.getSession().setAttribute("titleList", titleList);
			log.debug("========��ʱ���������������ʾ��������========");
			forward = "DISP";
		} else if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter()) ) {
			
			dto=ctlBL.getTitle(dto);
			List<LabelValueBean> titleList = dto.getTitleList();
			req.getSession().setAttribute("titleList", titleList);
			
			getPaginDTO(req,"IGPRJ0101");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDUT0402Form) req.getSession().getAttribute("IGDUT0402Form");
				if ( form == null ) {
					form = new IGDUT0402Form();
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
					form = (IGDUT0402Form) req.getSession().getAttribute("IGDUT0402Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGDUT0402");
			
			dto.setDelaySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchDelayByCond(dto);
			IGDUT04021VO vo=new IGDUT04021VO();
			vo.setDelayList(dto.getDelayList());
			super.<IGDUT04021VO>setVO(req, vo);
			forward="DISP";
			
		} else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========��ʱ����ɾ������ʼ========");
			dto.setDeleteId(form.getDeleteId());
			dto=ctlBL.deleteDelayAction(dto);
			log.debug("========��ʱ����ɾ����������========");
			forward="DISP";
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
