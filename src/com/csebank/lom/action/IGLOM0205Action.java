/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

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

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0203Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02051VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * 物品领用Action
 * 
 */
public class IGLOM0205Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0205Action.class);
	
	/**
	 * 物品领用
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
		}else if("TO".equals(mapping.getParameter())){
			log.debug("========物品申领查询初始化处理开始========");
			saveToken(req);
			log.debug("========物品申领查询初始化处理终了========");
		}else if("STDISP".equals(mapping.getParameter())){
			log.debug("========食堂入库查询初始化处理开始========");
			saveToken(req);
			IGLOM0203Form form = (IGLOM0203Form)actionForm;
			form.setGoorg(IGLOMCONSTANTS.ST_ORGSYSCODING);//食堂机构码
			form.setGoorgname(IGLOMCONSTANTS.ST_ORGNAME);//食堂名称
			log.debug("========食堂入库查询初始化处理终了========");
		}else if("STTO".equals(mapping.getParameter())){
			log.debug("========食堂入库查询初始化处理开始========");
			saveToken(req);
			log.debug("========食堂入库查询初始化处理终了========");
		}else if("JDDISP".equals(mapping.getParameter())){
			log.debug("========接待工作_物品申领查询处理开始========");
			saveToken(req);
			IGLOM0203Form form = (IGLOM0203Form)actionForm;
			if(StringUtils.isNotEmpty(req.getParameter("goorg"))){
				form.setGoorg(req.getParameter("goorg"));
			}
//			if(StringUtils.isNotEmpty(req.getParameter("goorgname"))){
//				form.setGoorgname(req.getParameter("goorgname"));
//			}
			if(StringUtils.isNotEmpty(req.getParameter("rid"))){
				form.setRid(Integer.valueOf(req.getParameter("rid")));
			}
			if(StringUtils.isNotEmpty(req.getParameter("lomid"))){
				form.setLomid(req.getParameter("lomid"));
			
			}
			if(StringUtils.isNotEmpty(req.getParameter("hascategory"))){
				form.setHascategory(true);
			
			}
			//获取分页Bean
			getPaginDTO(req,"IGLOM0205");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGLOM0260");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto.setIglom0203Form(form);

			//调用BL查询
			dto = iglom02BL.searchGoodsForRecptionAction(dto);
			
			//构造VO
			IGLOM02051VO vo = new IGLOM02051VO();
			vo.setGoutstockTBList(dto.getGoutstockTBList());
			super.<IGLOM02051VO>setVO(req, vo);
			
			log.debug("========接待工作_物品申领查询处理终了========");
		}else if("JDTO".equals(mapping.getParameter())){
			log.debug("========物品申领查询初始化处理开始========");
			saveToken(req);
			log.debug("========物品申领查询初始化处理终了========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========物品申领查询处理开始========");
			saveToken(req);
			IGLOM0203Form form = (IGLOM0203Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//返回页.do
				form = (IGLOM0203Form) req.getSession().getAttribute("IGLOM0203Form");
			}
			//获取分页Bean
			getPaginDTO(req,"IGLOM0205");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0203Form) req.getSession().getAttribute("IGLOM0203Form");
				if ( form == null ) {
					form = new IGLOM0203Form();
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
					form = (IGLOM0203Form) req.getSession().getAttribute("IGLOM0203Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGLOM0205");
			dto.setIglom0203Form(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			dto.setOrg_q(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//设置默认机构号为总行机构号
			//调用BL查询
			dto = iglom02BL.searchGoodsForApplyAction(dto);
			
			if(dto.getGstockList()!=null){
				if(!"SEARCH1".equals(mapping.getParameter())){
					Integer[] gsids = new Integer[dto.getGstockList().size()];
					Integer[] goinnums = new Integer[dto.getGstockList().size()];
					String[] gcategorys = new String[dto.getGstockList().size()];
					String[] gnames = new String[dto.getGstockList().size()];
					String[] gcodes = new String[dto.getGstockList().size()];
					String[] goreasons = new String[dto.getGstockList().size()];
					
					form.setGsids(gsids);
					form.setGoinnums(goinnums);
					form.setGcategorys(gcategorys);
					form.setGnames(gnames);
					form.setGcodes(gcodes);
					form.setGoreasons(goreasons);
				}else{
					Integer[] goinnums = form.getGoinnums();
					Integer[] new_goinnums = new Integer[goinnums.length];
					for(int i=0,j=goinnums.length;i<j;i++){
						if(goinnums[i]==0){
							new_goinnums[i] = null;
						}else{
							new_goinnums[i] = goinnums[i];
						}
					}
					form.setGoinnums(new_goinnums);
				}
			}else{
				Integer[] gsids = new Integer[1];
				Integer[] goinnums = new Integer[1];
				String[] gcategorys = new String[1];
				String[] gnames = new String[1];
				String[] gcodes = new String[1];
				String[] goreasons = new String[1];
				
				form.setGsids(gsids);
				form.setGoinnums(goinnums);
				form.setGcategorys(gcategorys);
				form.setGnames(gnames);
				form.setGcodes(gcodes);
				form.setGoreasons(goreasons);
			}
			
			

			req.getSession().setAttribute("ADcount", 0);//数组计数器
			req.getSession().setAttribute("ADcheckCount", 0);
			
			//构造VO
			IGLOM02051VO vo = new IGLOM02051VO();
			vo.setItemsCategoryList(dto.getGstockList());
			super.<IGLOM02051VO>setVO(req, vo);
			
			log.debug("========物品申领查询处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========申领物品处理开始========");
			IGLOM0203Form form = (IGLOM0203Form)actionForm;
			dto.setUser(user);

			dto.setIglom0203Form(form);
			
			//调用BL
			if(isTokenValid(req, true)){
				dto = iglom02BL.doStock(dto,"insertGoutStockAction");
//				if("CK_NUM_ERROR".equals(dto.getGotoError())){
//					//出库数量超过库存数量
//					return mapping.findForward("CK_NUM_ERROR");//返回错误提示信息页
//				}
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========申领物品处理终了========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========物品申领查看详细处理开始========");
			saveToken(req);
			
			log.debug("========物品申领查看详细处理终了========");
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
