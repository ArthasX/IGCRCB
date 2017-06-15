/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.util.ArrayList;
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
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.drm.bl.IGDRM14BL;
import com.deliverik.infogovernor.drm.dto.IGDRM14DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1401Form;
import com.deliverik.infogovernor.drm.form.IGDRM1402Form;
import com.deliverik.infogovernor.drm.vo.IGDRM14011VO;
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * Description: Ӧ������_֪ͨ����_ACTION
 * @author zyl
 */

public class IGDRM1401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM1401Action.class);
	
	/**
	 * <p>
	 * Description: ֪ͨaction����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGDRM1401Form form = (IGDRM1401Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGDRM14BL ctlBL = (IGDRM14BL) getBean("igdrm14BL");
		//ʵ����DTO
		IGDRM14DTO dto = new IGDRM14DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========֪ͨ��ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ͨ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		//portalҳ֪ͨ��ϸ
		if("NOTICE".equals(mapping.getParameter())){
			log.debug("========portalҳ֪ͨ��ϸ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGDRM1404");
            String nid=request.getParameter("nid");
            if(nid!=null){
            	form.setNid(nid);
            }
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("DEFAULT");
			
			dto.setNoticeSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//nid!=null��������֪ͨ���в鿴
		    if(nid!=null){
		       dto=ctlBL.searchNoticeDetail(dto);
		       
		     //����VO
		       Notice notice = dto.getNotice();
		       //modify by yangl
		       IGDRM1402Form igForm = new IGDRM1402Form();
		       igForm.setNattkey(notice.getNattkey());
		       igForm.setNdesc(notice.getNdesc());
		       igForm.setNid(notice.getNid());
		       igForm.setNname(notice.getNname());
		       igForm.setNorgid(notice.getNorgid());
		       igForm.setNorgname(notice.getNorgname());
		       igForm.setNtime(notice.getNtime());
		       igForm.setNuserid(notice.getNuserid());
		       igForm.setNusername(notice.getNusername());

		       if (notice.getNattkey()!=null &&!notice.getNattkey().equals("")) {
					AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
					List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
					igForm.setAttachmentList(attachmentList);
				}    	       
		      
				request.setAttribute("notice", igForm);
				log.debug("========portalҳ֪ͨ��ϸ��������========");
				return mapping.findForward("NOTICE_DETAIL");
		    }else{
			 dto = ctlBL.searchNoticeAction(dto);
			 
			 
			//����VO
			 List<Notice> astNoticeMore = new ArrayList<Notice>();
			 List<Notice> astNotice = dto.getNoticeCondList();
			 AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");	
			 for (int i = 0; i < astNotice.size(); i++) {
				Notice notice  = astNotice.get(i);
				 IGDRM1402Form igForm = new IGDRM1402Form();
			       igForm.setNattkey(notice.getNattkey());
			       igForm.setNdesc(notice.getNdesc());
			       igForm.setNid(notice.getNid());
			       igForm.setNname(notice.getNname());
			       igForm.setNorgid(notice.getNorgid());
			       igForm.setNorgname(notice.getNorgname());
			       igForm.setNtime(notice.getNtime());
			       igForm.setNuserid(notice.getNuserid());
			       igForm.setNusername(notice.getNusername());

			       if (notice.getNattkey()!=null &&!notice.getNattkey().equals("")) {		
						List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
						igForm.setAttachmentList(attachmentList);			
				   } 
			       astNoticeMore.add(igForm);
			}
				IGDRM14011VO vo = new IGDRM14011VO(astNoticeMore);
				request.setAttribute("jump", request.getParameter("jump"));
				super.<IGDRM14011VO>setVO(request, vo);
				log.debug("========portalҳ֪ͨ��ϸ��������========");
				return mapping.findForward("NOTICE");
		     }
			
		}
		//֪ͨ��ѯ
		if ("SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========֪ͨ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				form = (IGDRM1401Form) request.getSession().getAttribute("IGDRM1401Form");
			}
			// ��ȡ��ҳBean
			getPaginDTO(request, "IGDRM1401");

			PagingDTO pDto;

			pDto = (PagingDTO) request.getAttribute("PagingDTO");

			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM1401Form) request.getSession().getAttribute(
						"IGDRM1401Form");
				if (form == null) {
					form = new IGDRM1401Form();
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM1401Form) request.getSession().getAttribute(
							"IGDRM1401Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGDRM1401");
			//ֻ�����͵�dashboard�ϵ���Ϣ
			form.setFingerprint("drm");
			dto.setNoticeSearchCond(form);

			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);
			// ����BL��ѯ
			dto = ctlBL.searchNoticeAction(dto);
			//����VO
			IGDRM14011VO vo = new IGDRM14011VO(dto.getNoticeCondList());
			super.<IGDRM14011VO>setVO(request, vo);
			log.debug("========֪ͨ��ѯ��������========");
		}
		//֪ͨ��ѯ
//		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
//			log.debug("========֪ͨ��ѯ����ʼ========");
//			if ("SEARCH1".equals(mapping.getParameter())){
//				form = (IGDRM1401Form) request.getSession().getAttribute("IGDRM1401Form");
//			}
//			//��ȡ��ҳBean
//			getPaginDTO(request,"IGDRM1401");
//
//			PagingDTO pDto;
//			
//			pDto = (PagingDTO)request.getAttribute("PagingDTO");
//			
//			if ("SEARCH1".equals(mapping.getParameter())){
//				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
//				form = (IGDRM1401Form) request.getSession().getAttribute("IGDRM1401Form");
//				if ( form== null){
//					form = new IGDRM1401Form();
//				}else {
//					if (request.getParameter("PAGING") == null) {
//						pDto.setFromCount(form.getFromCount());
//					} else {
//						form.setFromCount(pDto.getFromCount());
//					}
//				}
//			} else {
//				if (request.getParameter("PAGING") == null) {
//					pDto.setFromCount(0);
//					form = (IGDRM1401Form) request.getSession().getAttribute("IGDRM1401Form");
//					if (form !=null) {
//						form.setFromCount(0);
//					}
//				}
//			}
//			
//			int maxCnt = getMaxDataCount("IGDRM1401");
//			
//			dto.setNoticeSearchCond(form);
//			
//			dto.setMaxSearchCount(maxCnt);
//			
//			dto.setPagingDto(pDto);
//			//����BL��ѯ
//			dto = ctlBL.searchNoticeAction(dto);
//			
//			//��װҳ����ʾ�õĸ���;
//	
//			List<Notice>noticeList = dto.getNoticeCondList();
//			AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");
//			List<Notice>astForm = new ArrayList<Notice>();
//			if(noticeList != null && noticeList.size()>0){
//				
//				for (int i = 0; i < noticeList.size(); i++) {
//					Notice notice = noticeList.get(i);
//					IGDRM1402Form igForm = new IGDRM1402Form();
//					igForm.setNid(notice.getNid());				
//					igForm.setNname(notice.getNname());				
//					igForm.setNdesc(notice.getNdesc());				
//					igForm.setNuserid(notice.getNuserid());				
//					igForm.setNusername(notice.getNusername());				
//					igForm.setNorgid(notice.getNorgid());				
//					igForm.setNorgname(notice.getNorgname());				
//					igForm.setNtime(notice.getNtime());			
//					igForm.setNattkey(notice.getNattkey());	
//					List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
//					igForm.setAttachmentList(attachmentList);
//					astForm.add(igForm);
//				}
//			}
//			
//		
//			//����VO
//			IGDRM14011VO vo = new IGDRM14011VO(astForm);
//			super.<IGDRM14011VO>setVO(request, vo);
//			log.debug("========֪ͨ��ѯ��������========");
//		}
		//ɾ��
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========֪ͨɾ������ʼ========");
			dto.setDeleteNid(form.getDeleteNid());
			ctlBL.deleteNoticeAction(dto);
			log.debug("========֪ͨɾ����������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
