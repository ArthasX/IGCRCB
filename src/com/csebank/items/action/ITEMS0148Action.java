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
import com.csebank.items.form.ITEMS0148Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0148Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0148Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		//req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========配送清单查询初始化处理开始========");
			
			log.debug("========配送清单查询初始化处理终了========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========配送清单查询处理开始========");
			ITEMS0148Form form = (ITEMS0148Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//返回页.do
				form = (ITEMS0148Form) req.getSession().getAttribute("ITEMS0148Form");
			}
			//获取分页Bean
			
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0148");
			
			//根据用户ID判断当前用户是否可以管理总行库存
//			boolean flag = items01BL.checkRoleManagerByUserID(dto);
//			if(flag){
//				form.setReqorg_q(DefineUtils.DEFAULT_ORGNO);
//			}else{
//				form.setReqorg_q(user.getOrgid());
//			}

			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//设置出库状态为：待接收

			form.setSortType(DefineUtils.OUTSTOCK_SORT_BYOUTTIME);
			
			dto.setItems0148form(form);
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);

		
			
			//调用BL查询
			dto = items01BL.searchOutStockBy0148Action(dto);
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutmap(dto.getOutmap());//配送清单
			super.<ITEMS01081VO>setVO(req, vo);
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			log.debug("========配送清单查询处理终了========");
			
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			}
		}else if("DETAIL".equals(mapping.getParameter())){
			log.debug("========配送清单明细查询处理开始========");
			ITEMS0148Form form = (ITEMS0148Form)actionForm;
			
			//获取分页Bean
			getPaginDTO(req,"ITEMS0166");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (ITEMS0148Form) req.getSession().getAttribute("ITEMS0148Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			

			int maxCnt = getMaxDataCount("ITEMS0166");
			
			form.setSortType(DefineUtils.OUTSTOCK_SORT_BYSEQCODE);//按物品编号、出库时间、领用机构升序排序
			
			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//设置出库状态为：待接收
			
			dto.setItems0148form(form);
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//调用BL
			dto = items01BL.searchOutStockDetailBy0148Action(dto);
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStocktbList(dto.getOsList());//配送清单明细
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========配送清单明细查询处理终了========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("========配送清单明细查询处理开始========");
			ITEMS0148Form form = (ITEMS0148Form)actionForm;

			int maxCnt = getMaxDataCount("ITEMS0166");
			
			form.setSortType(DefineUtils.OUTSTOCK_SORT_BYSEQCODE);//按物品编号、出库时间、领用机构升序排序
			
			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//设置出库状态为：待接收
			
			dto.setItems0148form(form);
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//调用BL
			dto = items01BL.searchExcelDataBy0148Action(dto);
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStocktbList(dto.getOsList());//配送清单明细
			super.<ITEMS01081VO>setVO(req, vo);
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			
			log.debug("========配送清单明细查询处理终了========");
			
			return mapping.findForward("REPORT");

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
