/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.bl.IGSYM05BL;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0501Form;
import com.deliverik.infogovernor.sym.form.IGSYM0502Form;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.vo.IGSYM05011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_查询删除ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM0501Action.class);

	/**
	 * <p>
	 * Description: 通知action处理
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 实例化FORM
		IGSYM0501Form form = (IGSYM0501Form) actionForm;
		// 获取BL接口实例
		IGSYM05BL ctlBL = (IGSYM05BL) getBean("igsym05BL");
		// 实例化DTO
		IGSYM05DTO dto = new IGSYM05DTO();
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========通知查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========通知查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		// portal页通知详细
		if ("NOTICE".equals(mapping.getParameter())) {
			log.debug("========portal页通知详细处理开始========");
			// 获取分页Bean
			getPaginDTO(request, "IGSYM0504");
			String nid = request.getParameter("nid");
			if (nid != null) {
				form.setNid(nid);
			}
			PagingDTO pDto;

			pDto = (PagingDTO) request.getAttribute("PagingDTO");

			pDto.setFromCount(form.getFromCount());

			int maxCnt = getMaxDataCount("DEFAULT");

			dto.setNoticeSearchCond(form);

			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);
			
			User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			
			// nid!=null单击单个通知进行查看
			if (nid != null) {
				dto = ctlBL.searchNoticeDetail(dto);

				// 构造VO
				Notice notice = dto.getNotice();
				// modify by yangl
				IGSYM0502Form igForm = new IGSYM0502Form();
				igForm.setNattkey(notice.getNattkey());
				igForm.setNdesc(notice.getNdesc());
				igForm.setNid(notice.getNid());
				igForm.setNname(notice.getNname());
				igForm.setNorgid(notice.getNorgid());
				igForm.setNorgname(notice.getNorgname());
				igForm.setNtime(notice.getNtime());
				igForm.setNuserid(notice.getNuserid());
				igForm.setNusername(notice.getNusername());

				if (notice.getNattkey() != null && !notice.getNattkey().equals("")) {
					AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
					List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
					igForm.setAttachmentList(attachmentList);
				}

				request.setAttribute("notice", igForm);
				log.debug("========portal页通知详细处理终了========");
				return mapping.findForward("NOTICE_DETAIL");
			} else {
				dto = ctlBL.searchNoticeAction(dto);

				// 构造VO
				List<Notice> astNoticeMore = new ArrayList<Notice>();
				List<Notice> astNotice = dto.getNoticeCondList();
				AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
				for (int i = 0; i < astNotice.size(); i++) {
					Notice notice = astNotice.get(i);
					IGSYM0502Form igForm = new IGSYM0502Form();
					igForm.setNattkey(notice.getNattkey());
					igForm.setNdesc(notice.getNdesc());
					igForm.setNid(notice.getNid());
					igForm.setNname(notice.getNname());
					igForm.setNorgid(notice.getNorgid());
					igForm.setNorgname(notice.getNorgname());
					igForm.setNtime(notice.getNtime());
					igForm.setNuserid(notice.getNuserid());
					igForm.setNusername(notice.getNusername());

					if (notice.getNattkey() != null && !notice.getNattkey().equals("")) {
						List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
						igForm.setAttachmentList(attachmentList);
					}
					astNoticeMore.add(igForm);
				}
				IGSYM05011VO vo = new IGSYM05011VO(astNoticeMore);

				super.<IGSYM05011VO> setVO(request, vo);
				log.debug("========portal页通知详细处理终了========");
				return mapping.findForward("NOTICE");
			}

		}

		// 通知查询
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========通知查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				form = (IGSYM0501Form) request.getSession().getAttribute("IGSYM0501Form");
			}
			// 获取分页Bean
			getPaginDTO(request, "IGSYM0501");

			PagingDTO pDto;

			pDto = (PagingDTO) request.getAttribute("PagingDTO");

			if ("SEARCH1".equals(mapping.getParameter())) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM0501Form) request.getSession().getAttribute("IGSYM0501Form");
				if (form == null) {
					form = new IGSYM0501Form();
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
					form = (IGSYM0501Form) request.getSession().getAttribute("IGSYM0501Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGSYM0501");

			dto.setNoticeSearchCond(form);

			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);
			// 调用BL查询
			dto = ctlBL.searchNoticeAction(dto);

			// 封装页面显示用的附件;

			List<Notice> noticeList = dto.getNoticeCondList();
			AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
			List<Notice> astForm = new ArrayList<Notice>();
			if (noticeList != null && noticeList.size() > 0) {

				for (int i = 0; i < noticeList.size(); i++) {
					Notice notice = noticeList.get(i);
					IGSYM0502Form igForm = new IGSYM0502Form();
					igForm.setNid(notice.getNid());
					igForm.setNname(notice.getNname());
					igForm.setNdesc(notice.getNdesc());
					igForm.setNuserid(notice.getNuserid());
					igForm.setNusername(notice.getNusername());
					igForm.setNorgid(notice.getNorgid());
					igForm.setNorgname(notice.getNorgname());
					igForm.setNtime(notice.getNtime());
					igForm.setNattkey(notice.getNattkey());
					List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
					igForm.setAttachmentList(attachmentList);
					astForm.add(igForm);
				}
			}

			// 构造VO
			IGSYM05011VO vo = new IGSYM05011VO(astForm);
			super.<IGSYM05011VO> setVO(request, vo);
			log.debug("========通知查询处理终了========");
		}
		// 删除
		if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========通知删除处理开始========");
			dto.setDeleteNid(form.getDeleteNid());
			ctlBL.deleteNoticeAction(dto);
			log.debug("========通知删除处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
