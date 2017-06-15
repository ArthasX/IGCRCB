/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0214Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02141VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * 库存统计Action
 * 
 */
public class IGLOM0214Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0214Action.class);
	
	/**
	 * 库存统计
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IGLOM02BL iglom02BL = (IGLOM02BL)this.getBean("iglom02BL");
		
		IGLOM02DTO dto = new IGLOM02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		req.setAttribute("category_options", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========物品申领查询初始化处理开始========");
			saveToken(req);
			log.debug("========物品申领查询初始化处理终了========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========物品申领查询处理开始========");
			saveToken(req);
			IGLOM0214Form form = (IGLOM0214Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//返回页.do
				form = (IGLOM0214Form) req.getSession().getAttribute("IGLOM0214Form");
			}
			//获取分页Bean
			getPaginDTO(req,"IGLOM0214");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0214Form) req.getSession().getAttribute("IGLOM0214Form");
				if ( form == null ) {
					form = new IGLOM0214Form();
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
					form = (IGLOM0214Form) req.getSession().getAttribute("IGLOM0214Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGLOM0214");
			dto.setIglom0214Form(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			dto.setOrg_q(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//设置默认机构号为总行机构号
			//调用BL查询
			dto = iglom02BL.searchGstockAction(dto);
			
			//构造VO
			IGLOM02141VO vo = new IGLOM02141VO();
			vo.setGstockList(dto.getGstockList());
			super.<IGLOM02141VO>setVO(req, vo);
			//req.setAttribute("IGLOM0214Form", form);
			log.debug("========物品申领查询处理终了========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("========申领物品处理开始========");
			saveToken(req);
			IGLOM0214Form form = (IGLOM0214Form)actionForm;
			//获取分页Bean
			getPaginDTO(req,"IGLOM0214");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGLOM0214");
			dto.setIglom0214Form(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			dto.setOrg_q(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//设置默认机构号为总行机构号
			//调用BL查询
			dto = iglom02BL.searchGstockForExcelAction(dto);
			
			//构造VO
			IGLOM02141VO vo = new IGLOM02141VO();
			vo.setGstockList(dto.getGstockList());
			super.<IGLOM02141VO>setVO(req, vo);
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			log.debug("========申领物品处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
