package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2105Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21051VO;

public class IGDRM2105Action extends BaseAction {
	
	private static Log log = LogFactory.getLog(IGDRM2105Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm aform,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGDRM2105Form form = (IGDRM2105Form) aform;
		// BLȡ��
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");

		// DTO����
		IGDRM21DTO dto = new IGDRM21DTO();
		
		dto.setForm(form);
		
		String p = mapping.getParameter();
		
		if(null != req.getParameter("btn_delete_sel")){
			log.debug("===============ɾ��ѡ���Ԥ����Ϣ��ʼ================");
			
			dto = ctlBL.deleteSelectedSoc0118(dto);
			
			log.debug("===============ɾ��ѡ���Ԥ����Ϣ����================");
		}
		
		// �ж��ǹ����ѯ���Ǽ򵥲�ѯ
		if("MANAGE".equals(p) || null != req.getParameter("MANAGE")){
			// �������
			form.setMode("1");
			p = "SEARCH";
		}
		
		if("SEARCH".equals(p) || "SEARCH1".equals(p)){
			log.debug("===============��ѯԤ����Ϣ��ʼ================");
			getPaginDTO(req, "IGDRM2105");
			PagingDTO pDto = (PagingDTO) req.getAttribute("PagingDTO");
			dto.setPagingDto(pDto);

			if ("SEARCH1".equals(p)) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM2105Form) req.getSession().getAttribute("IGDRM2105Form");
				if (form == null) {
					form = new IGDRM2105Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM2105Form) req.getSession().getAttribute("IGDRM2105Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ȡ��ѯ����¼����
			int maxCnt = getMaxDataCount("IGDRM2105");
			dto.setMaxSearchCount(maxCnt);
			dto = ctlBL.searchSpecialPlanAction(dto);
			
			IGDRM21051VO vo = new IGDRM21051VO(dto.getSoc0118VWList());
			super.<IGDRM21051VO>setVO(req, vo);
			log.debug("===============��ѯԤ����Ϣ����================");
		}
		
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("=================ר��Ԥ������������ʼ===================");
			dto.setResponse(res);
			dto = ctlBL.exportSpecialPlanAction(dto);
			log.debug("=================ר��Ԥ��������������===================");
			return null;
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}
