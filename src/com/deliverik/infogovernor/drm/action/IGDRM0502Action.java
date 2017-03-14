/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0502Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05021VO;
import com.google.gson.Gson;


/**
 * 专项预案管理Action
 * @author zyl
 *
 * 2015-2-28 10:27:47
 */
public class IGDRM0502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0502Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BL取得
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		IGDRM0502Form form = (IGDRM0502Form)actionForm;
		
		//DTO生成
		IGDRM05DTO dto = new IGDRM05DTO();
		dto.setUser(user);
		//预置Gson
		Gson g = new Gson();
		
		//画面跳转设定
		String forward = "DISP";

	
		if("DISP".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========专项预案查询初始化处理开始========");
			form.setEsyscoding("");
			form.setEiname("");
			dto.setIgdrm0502Form(form);
			getPaginDTO(req,"IGDRM0501");
			
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0502");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//专项预案资产查询
			dto = ctlBL.searchSpeicalPlanResource(dto);
			
			IGDRM05021VO vo = new IGDRM05021VO();
			vo.setEntityItemList(dto.getEntityItemList());	
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			super.<IGDRM05021VO>setVO(req, vo);
			
			log.debug("========专项预案查询初始化处理终了========");
		}
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========专项预案查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0501");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0502Form) req.getSession().getAttribute("IGDRM0502Form");
				if ( form == null ) {
					form = new IGDRM0502Form();
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
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0502");
			
			dto.setIgdrm0502Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//获取当前年
//			if(StringUtil.isEmpty(form.getEiinsdate())){
//				Calendar cal = Calendar.getInstance();
//				int year = cal.get(Calendar.YEAR);
//				req.setAttribute("eiinsdate", year);
//			}else{
//				req.setAttribute("eiinsdate", form.getEiinsdate());
//			}
			//专项预案资产查询逻辑调用
			dto = ctlBL.searchSpeicalPlanResource(dto);
			
			IGDRM05021VO vo = new IGDRM05021VO();
			
			vo.setEntityItemList(dto.getEntityItemList());
			
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			
			super.<IGDRM05021VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========专项预案查询处理终了========");
		}
		//删除	
		if("DELETE".equals(mapping.getParameter())){
			dto.setIgdrm0502Form(form);
			dto.setUser(user);
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			//专项预案资产信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}
			log.debug("========专项预案配置信息历史记录画面初期显示处理终了========");

		return mapping.findForward(forward);
	}
}
