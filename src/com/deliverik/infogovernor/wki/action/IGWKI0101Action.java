package com.deliverik.infogovernor.wki.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.vo.IGDBM13011VO;
import com.deliverik.infogovernor.wki.bl.IGWKI01BL;
import com.deliverik.infogovernor.wki.dto.IGWKI01DTO;
import com.deliverik.infogovernor.wki.form.IGWKI0101Form;
import com.deliverik.infogovernor.wki.vo.IGWKI01011VO;

public class IGWKI0101Action extends BaseAction {
	static Log log = LogFactory.getLog(IGWKI0101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// 获得FORM
		IGWKI0101Form form = (IGWKI0101Form) actionForm;
		// 获得BL
		IGWKI01BL ctlBL = (IGWKI01BL) getBean("igwki01BL");
		// dto
		IGWKI01DTO dto = new IGWKI01DTO();

		User user = (User) req.getSession()
				.getAttribute(SESSION_KEY_LOGIN_USER);

		dto.setUser(user);

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========工作信息新增画面初期显示处理开始========");
			// ？？
			log.debug("========工作信息新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========工作信息查询开始========");
			// 获取分页DTO 如果没有对应的IGWKI0101，则是default
			getPagingDTO(req, "IGWKI0101");
			PagingDTO pDto;
			pDto = (PagingDTO) req.getAttribute("PagingDTO");

			if ("SEARCH1".equals(mapping.getParameter())) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGWKI0101Form) req.getSession().getAttribute(
						"IGWKI0101Form");
				if (form == null) {// 不存在的话就从开头开始查询
					form = new IGWKI0101Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				// 如果是正常翻页，则按照正常逻辑获得相关的paging参数值
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			// 获得最大记录数限制的配置信息
			int maxCnt = getMaxDataCount("IGWKI0101");

			dto.setIgwki01Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			// 获取工作信息list
			dto = ctlBL.searchWorkInfos(dto);
			IGWKI01011VO vo = new IGWKI01011VO();
			vo.setWkiList(dto.getWkiList());
			super.<IGWKI01011VO> setVO(req, vo);
			log.debug("=========工作信息查询结束==========");
			return mapping.findForward("DISP");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}

		return mapping.findForward("DISP");
	}

}
