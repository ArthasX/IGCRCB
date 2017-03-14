/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

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

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0106Form;
import com.csebank.items.form.ITEMS0146Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;

public class ITEMS0145Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0145Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========下拨物品查询初始化处理开始========");
			saveToken(req);
			log.debug("========下拨物品查询初始化处理终了========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========下拨物品查询处理开始========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			//获取分页Bean
			getPaginDTO(req,"ITEMS0106");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
				if ( form == null ) {
					form = new ITEMS0106Form();
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
					form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0106");

			dto.setItems0106form(form);
			
			//dto.setStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setCategory(form.getCategory());
			dto.setSeqcode(form.getSeqcode());
			dto.setStockorg_q(DefineUtils.DEFAULT_ORGNO);//设置机构号为总行机构号
			
			//调用BL查询
			dto = items01BL.searchStockAction(dto);
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setStockList(dto.getStockList());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========下拨物品查询处理终了========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========下拨物品查看详细处理开始========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			dto.setStockid(Integer.valueOf(form.getSid()));
			//调用BL查询
			dto = items01BL.searchStockDetailAction(dto);
			
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setStock(dto.getStock());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========下拨物品查看详细处理终了========");
		}else if("ALLOCATE".equals(mapping.getParameter())){
			log.debug("========下拨物品下拨页初始化处理开始========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			dto.setStockid(Integer.valueOf(form.getSid()));
			//调用BL查询
			//dto = items01BL.searchOutStockDetailAction(dto);
			dto = items01BL.searchStockDetailAction(dto);
			
			//查询所有一级机构机构
			IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
			IGSYM01DTO symdto = new IGSYM01DTO();
			ArrayList<String> not_in_syscoding_area = new ArrayList<String>();
			String orgTemp = DefineUtils.NOT_SHOW_LIST;
			if(orgTemp!=null){
				String[] temp = orgTemp.split(",");
				if(temp!=null && temp.length>0){
					for(int i=0,j=temp.length;i<j;i++){
						not_in_syscoding_area.add(temp[i]);
					}
				}
			}
			OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
			//cond.setOrgparid(DefineUtils.DEFAULT_XB_ORGNO);//设置上级机构
			cond.setNot_in_syscoding_area(not_in_syscoding_area);
			cond.setXbtype(form.getSelectorg());
			symdto.setOrganizationSearchCond(cond);
			getPaginDTO(req,"IGSYM0101");
			PagingDTO pDto;		
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGSYM0101");
			//pDto.setFromCount(0);
			//pDto.setPageDispCount(0);
			symdto.setMaxSearchCount(maxCnt);
			symdto.setPagingDto(pDto);
			//调用BL查询
			symdto = ctlBL.searchOrganizationAction(symdto);
			req.setAttribute("nameMap", symdto.getCompletenameMap());
			req.setAttribute("buttonMap", symdto.getButtonMap());
			req.setAttribute("startbuttonMap", symdto.getStartbuttonMap());
			
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setStock(dto.getStock());
			vo.setOrgList(symdto.getOrganizationCondList());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========下拨物品下拨页初始化处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========下拨物品'下拨'处理开始========");
			ITEMS0146Form form = (ITEMS0146Form)actionForm;
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			dto.setStockid(Integer.valueOf(form.getStockid()));
			dto.setItems0146form(form);
			if(isTokenValid(req, true)){
			//调用BL
			dto = items01BL.doStock(dto,"allocateOutStockAction");
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			if("XB_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//页面提交记录的出库状态与数据库中记录的出库状态不一致
				saveToken(req);
				return mapping.findForward("XB_REQSTATUS_ERROR");//返回错误提示信息页
			}
			
			log.debug("========下拨物品'下拨'处理终了========");
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
