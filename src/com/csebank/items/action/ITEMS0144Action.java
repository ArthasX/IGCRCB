/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0144Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0144Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0144Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		req.setAttribute("reqstatus_options", items01BL.getPartItemsCodesFor0144(DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========我的申领查询初始化处理开始========");
			
			log.debug("========我的申领查询初始化处理终了========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========我的申领查询处理开始========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
		
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());

		
			
			//获取分页Bean
			getPaginDTO(req,"ITEMS0144");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (ITEMS0144Form) req.getSession().getAttribute("ITEMS0144Form");
				if ( form == null ) {
					form = new ITEMS0144Form();
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
					form = (ITEMS0144Form) req.getSession().getAttribute("ITEMS0144Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//当查询状态为待接收时，将flag置为1
			if(DefineUtils.ITEMSCODES_REQSTATUS_DJS.equals(form.getReqstatus_q())){
				form.setFlag("1");
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP.equals(form.getReqstatus_q())){
				//当查询状态为申领待审批时，将flag置为2
				form.setFlag("2");
			}else{
				form.setFlag("0");
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0144");
			
			//设置领用机构为当前用户的所属机构
			//form.setReqorg_q(user.getOrgid());

			//根据用户ID判断当前用户是否可以管理总行库存
//			boolean flag = items01BL.checkRoleManagerByUserID(dto);
//			if(flag){
//				form.setReqorg_q(DefineUtils.DEFAULT_ORGNO);
//			}else{
//				form.setReqorg_q(user.getOrgid());
//			}
			form.setReqorg_q(user.getOrgid());
			dto.setItems0144form(form);
			
			dto.setOutStockSearchVWCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		
			
			//调用BL查询
			dto = items01BL.searchOutStockVWAction(dto);
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStockList(dto.getOutStockList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========我的申领查询处理终了========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========我的申领查看详细处理开始========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			dto.setOutstockid(Integer.valueOf(form.getSid()));
			//调用BL查询
			dto = items01BL.searchOutStockDetailAction(dto);
			
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStock(dto.getOutStock());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========我的申领查看详细处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========我的申领'接收'处理开始========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0144form(form);
			
			//调用BL
			dto = items01BL.doStock(dto,"receiveOutStockAction");
			if("JS_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//页面提交记录的出库状态与数据库中记录的出库状态不一致
				return mapping.findForward("JS_REQSTATUS_ERROR");//返回错误提示信息页
			}
			
			
			log.debug("========我的申领'接收'处理终了========");
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========我的申领'修改'处理开始========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0144form(form);
			
			//调用BL
			dto = items01BL.doStock(dto,"editOutStockAction");
			if("EDIT_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//页面提交记录的出库状态与数据库中记录的出库状态不一致
				return mapping.findForward("EDIT_REQSTATUS_ERROR");//返回错误提示信息页
			}
			
			
			log.debug("========我的申领'修改'处理终了========");
		}else if("DEL".equals(mapping.getParameter())){
			log.debug("========我的申领'删除'处理开始========");
			ITEMS0144Form form = (ITEMS0144Form)actionForm;
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0144form(form);
			
			//调用BL
			dto = items01BL.doStock(dto,"delOutStockAction");
			if("DEl_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//页面提交记录的出库状态与数据库中记录的出库状态不一致
				return mapping.findForward("DEl_REQSTATUS_ERROR");//返回错误提示信息页
			}
			
			
			log.debug("========我的申领'删除'处理终了========");
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
