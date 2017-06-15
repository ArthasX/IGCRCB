/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0115Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0115Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0115Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0115Form form = (ITEMS0115Form)actionForm;
		
		ArrayList<String> reqstatusList = new ArrayList<String>();
		reqstatusList.add(DefineUtils.ITEMSCODES_REQSTATUS_DJS);
		reqstatusList.add(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
		form.setReqstatusList(reqstatusList);
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		//分页信息
		getPaginDTO(req,"ITEMS0115");
		PagingDTO pDto;
		pDto = (PagingDTO)req.getAttribute("PagingDTO");

		int maxCnt = getMaxDataCount("ITEMS0115");
		
		dto.setMaxSearchCount(maxCnt);
		dto.setPagingDto(pDto);
		
		//根据用户ID判断当前用户是否可以管理总行库存
		boolean flag = items01BL.checkRoleManagerByUserID(dto);
		if(flag){
			form.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
		}else{
			form.setOutstockorg(user.getOrgid());//出库机构（从哪个库出库的机构号）
		}
		dto.setItems0115form(form);
		dto.setOutStockSearchCond(form);
		dto = items01BL.searchOutStockAction(dto);
		
		ITEMS01011VO vo = new ITEMS01011VO();
		vo.setOutStockList(dto.getOsList());
		super.<ITEMS01011VO>setVO(req, vo);
		return mapping.findForward("DISP");
		
	}
	
}
