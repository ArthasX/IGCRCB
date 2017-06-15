/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0129Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0129Action extends BaseAction {

	static Log log = LogFactory.getLog(ITEMS0129Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL) this.getBean("items01BL");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		ITEMS01DTO dto = new ITEMS01DTO();
		dto.setUser(user);
		boolean flag = items01BL.checkRoleManagerByUserID(dto);
		if(flag){
			req.setAttribute("selectOrg","Y");
		}else{
			req.setAttribute("selectOrg","N");
		}

		req.setAttribute("accountstatusList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS));
		req.setAttribute("reqstatusList", items01BL.getItemsCodesFor0129Action(DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS));
		if("DISP".equals(mapping.getParameter())){
//			ITEMS0129Form form = (ITEMS0129Form) actionForm;
//			if(flag){
//				form.setOutstockorg_qname(OrgValueBean.getConfigInfo(DefineUtils.DEFAULT_ORGNO));
//				form.setOutstockorg_q(DefineUtils.DEFAULT_ORGNO);
//			}
		} else if ("SEARCH".equals(mapping.getParameter())) {
			ITEMS0129Form form = (ITEMS0129Form) actionForm;
			dto.setTime_f(form.getOuttime_f());
			dto.setTime_t(form.getOuttime_t());
			dto.setOuttype(form.getOuttype());
			dto.setAccountstatus_q(form.getAccountstatus_q());
			dto.setReqstatus(form.getReqstatus());
			dto.setOutstockorg_q(form.getOutstockorg_q());
			if(flag){
				dto.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
			}else{
				dto.setOutstockorg(user.getOrgid());
			}
			dto.setSeqcode_q(form.getSeqcode_q());
			dto.setItemsname_q(form.getItemsname_q());
			
			//分页信息
			getPaginDTO(req,"ITEMS0115");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("ITEMS0115");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = items01BL.reportOutStockAction(dto);
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setOutStockList(dto.getOsList());
			super.<ITEMS01011VO> setVO(req, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				pDto.setFromCount(0);
				pDto.setPageDispCount(0);
				dto.setPagingDto(pDto);
				dto = items01BL.reportOutStockAction(dto);
				vo.setOutStockList(dto.getOsList());
				req.setAttribute("vo", vo);
				req.setAttribute("form", form);
				this.setPaginDTO(req, null);
				return mapping.findForward("REPORT");
			}

		}
		return mapping.findForward("DISP");

	}

}
