/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM07BL;
import com.deliverik.infogovernor.drm.dto.IGDRM07DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0701Form;
import com.deliverik.infogovernor.drm.vo.IGDRM07011VO;


/**
 * 演练方案定义和应急指挥发起Action
 * @author zyl
 * 
 * 2015年3月6日09:12:52
 */
public class IGDRM0701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0701Action.class);

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
		IGDRM0701Form form = (IGDRM0701Form)actionForm;
		//BL取得
		IGDRM07BL ctlBL = (IGDRM07BL) getBean("igdrm07BL");
		
		//DTO生成
		IGDRM07DTO dto = new IGDRM07DTO();
		dto.setUser(user);
		//画面跳转设定
		String forward = "DISP";
		//演练方案定义
		if( "DEFINE".equals(mapping.getParameter())){
		    dto=ctlBL.initIGDRM0701DefAction(dto);
		    //构造VO
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
		    return mapping.findForward(forward);
		}
		//演练实施
		if( "IMPL".equals(mapping.getParameter())){
			dto=ctlBL.initIGDRM0701ImplAction(dto);
			//构造VO
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			return mapping.findForward(forward);
		}
		//演练查询
		if( "ALLPROCESS".equals(mapping.getParameter())||"SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========全面演练查询开始========");

			//分页用DTO取得
			getPaginDTO(req,"IGDRM0701");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
				if ( form== null){
					form = new IGDRM0701Form();
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
					form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGDRM0701");
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0701Form(form);
			dto.setPagingDto(pDto);
			dto=ctlBL.initIGDRM0701ALLProcessAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//将资产项信息检索结果设定到VO中
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			log.debug("========全面演练查询结束========");
		
		}
		//演练评估查询
		if("SEARCHCLOSE".equals(mapping.getParameter())){
			log.debug("========评估演练查询开始========");
			form.setPrstatus("C");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0701");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			int maxCnt = getMaxDataCount("IGDRM0701");
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0701Form(form);
			dto.setPagingDto(pDto);
			dto=ctlBL.initIGDRM0701ALLProcessAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//将资产项信息检索结果设定到VO中
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			log.debug("========评估演练查询结束========");
			
		}
		//弹出页
		if( "SEL".equals(mapping.getParameter())){
			dto.setPrpdidLike(IGDRMCONSTANTS.DRILL_PROCESS_DEF_ID);
			dto=ctlBL.searchProcess(dto);
			//构造VO
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			return mapping.findForward(forward);
		}
		
		if("SEARCHEMCLOSE".equals(mapping.getParameter())){
			log.debug("========应急指挥查询开始========");
			form.setPrstatus("C");
			form.setPrurgency("0");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0701");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			int maxCnt = getMaxDataCount("IGDRM0701");
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0701Form(form);
			dto.setPagingDto(pDto);
			dto=ctlBL.initIGDRM0701ALLProcessAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//将资产项信息检索结果设定到VO中
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			log.debug("========应急指挥查询结束========");
		}
		
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
