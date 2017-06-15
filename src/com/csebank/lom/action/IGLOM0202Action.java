/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0202Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

public class IGLOM0202Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0202Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL)this.getBean("iglom02BL");
		IGLOM0202Form form = (IGLOM0202Form)actionForm;
		IGLOM02DTO dto = new IGLOM02DTO();
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========类型查询处理开始========");
			getPaginDTO(req,"DEFAULT");
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0202Form) req.getSession().getAttribute("IGLOM0202Form");
				if (form == null ) {
					form = new IGLOM0202Form();
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
					form = (IGLOM0202Form) req.getSession().getAttribute("IGLOM0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("DEFAULT");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
//			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
//			dto.setUser(user);
			dto.setIglom0202Form(form);
			//调用BL查询
			dto = ctlBL.searchGoodsAction(dto);
			//构造VO
			IGLOM02021VO vo = new IGLOM02021VO();
			vo.setGoodsList(dto.getGoodsList());
			super.<IGLOM02021VO>setVO(req, vo);
			log.debug("========类型查询处理终了========");
			
			if("instock".equals(form.getPath())){
				return mapping.findForward("SELECT");
			}
		} else if("DELETE".equals(mapping.getParameter())){
			log.debug("========删除处理开始========");
			dto.setIglom0202Form(form);
			//调用BL查询
			dto = ctlBL.deleteGoodsAction(dto);
			log.debug("========删除处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		return mapping.findForward("DISP");
	}
	
}
