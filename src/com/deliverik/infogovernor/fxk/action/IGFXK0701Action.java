/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.fxk.bl.IGFXK07BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;
import com.deliverik.infogovernor.fxk.vo.IGFXK07011VO;
import com.deliverik.infogovernor.fxk.vo.IGFXK07012VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 2014-6-16
 * @author zhangq@deliverik.com
 * @version 1.0
 */
public class IGFXK0701Action extends BaseAction {

	/**��־����*/
	private static Log log = LogFactory.getLog(IGFXK0701Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse res) throws Exception {
		log.debug("=======================�������ѹ���ʼ=======================");
		
		IGFXK0700Form form = (IGFXK0700Form)actionForm;
		IGFXK07DTO dto=new IGFXK07DTO();
		dto.setForm(form);
		
		//��ȡBL�ӿ�ʵ��
		IGFXK07BL ctrlBL = (IGFXK07BL) getBean("igFXK07BL");
		//��תҳ��
		String forward = "DISP"; 
		//��ʼ��ҳ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("========������ʾ��ѯ��ʼ������ʼ========");
			
			log.debug("========������ʾ��ѯ��ʼ����������========");
		}
		//��ʼ��ҳ��
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGFXK0701");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGFXK0700Form) request.getSession().getAttribute("IGFXK0700Form");
				if ( form == null ) {
					form = new IGFXK0700Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} 
			int maxCnt = getMaxDataCount("IGFXK0701");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setForm(form);
			
			//����bl �������ݴ���
			ctrlBL.searchRiskmanagerwaring(dto);
			//ʵ����vo
			IGFXK07011VO vo = new IGFXK07011VO();
			//���ݷ��ظ�ҳ��
			vo.setVoList(dto.getVoList());
			super.<IGFXK07011VO>setVO(request, vo);
			log.debug("=======������ʾ�����ѯ�������========");
			
		}else if("EACH".equals(mapping.getParameter())){
			String rwid=request.getParameter("rwid");
			dto.setRwid(Integer.parseInt(rwid));
			dto=ctrlBL.searchRiskmanagerwaringById(dto);
			form.setNorgname(dto.getForm().getNorgname());
			form.setNtel(dto.getForm().getNtel());
			form.setNtime(dto.getForm().getNtime());
			form.setNusername(dto.getForm().getNusername());
			form.setRwcontext(dto.getForm().getRwcontext());
			form.setRwname(dto.getForm().getRwname());
			form.setType(dto.getForm().getType());
			
			if (dto.getForm().getRwkey()!=null &&!dto.getForm().getRwkey().equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(dto.getForm().getRwkey());
				form.setAttachmentList(attachmentList);
			}
//			 /**ҳ��չʾVO�趨*/
			IGFXK07012VO vo = new IGFXK07012VO();
			vo.setAcceptuserList(dto.getAcceptList());
			super.<IGFXK07012VO>setVO(request, vo);
			log.debug("=======������ʾ�����ѯ�������========");
		}
		//��������
	if ("LOADFILE".equals(mapping.getParameter())){
		log.debug("========֪ͨ�������ش���ʼ========");
		String exattkey=request.getParameter("exattkey");
		String attId=request.getParameter("attid");	
		String type="sym";
		request.setAttribute("type", type);
		request.setAttribute("attId", attId);

		log.debug("========֪ͨ�������ش������========");
		forward="LOADFILE";
	}

		return mapping.findForward(forward);
	}
}
