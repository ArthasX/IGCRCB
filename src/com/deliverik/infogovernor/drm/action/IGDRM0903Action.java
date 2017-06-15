/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.action;

import java.util.ArrayList;
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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM09BL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0903Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01012VO;
import com.deliverik.infogovernor.drm.vo.IGDRM09031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急指挥流程列表查询
 * </p>
 * 
 * @version 1.0
 */

public class IGDRM0903Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0903Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGDRM0903Form form = (IGDRM0903Form)actionForm;
		//获取BL接口实例
		IGDRM09BL ctlBL = (IGDRM09BL) getBean("igdrm09BL");
		IGDRM09DTO dto = new IGDRM09DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrtype(form.getPrtype());
		//将查询类型标识放进dto中
		dto.setType(form.getType());
		//动态配置根据表单查询 20130313 end wangtingzhi
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查询画面初期显示处理开始========");
			//为了动态取得页面上的导航信息添加的处理

			
			IGDRM01012VO vo = new IGDRM01012VO();
			dto.setPrtype(form.getPrtype());
			dto.setPdid(form.getPrpdid());
			if(request.getParameter("prpdid")!=null){
				request.getSession().setAttribute("AD_prpdid", request.getParameter("prpdid"));
			}else{
				if(request.getSession().getAttribute("AD_prpdid")!=null){
					request.removeAttribute("AD_prpdid");
				}
			}
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			request.setAttribute("vo", vo);
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========查询画面初期显示处理终了========");
			//跳转到定制JSP
			if(StringUtils.isNotEmpty(dto.getForwardJsp())){
				return new ActionForward(dto.getForwardJsp());
			} else {
				return mapping.findForward("DISP");
			}
		}
		
		
		
		if("SEL".equals(mapping.getParameter())){
			log.info("==============应急指挥流程弹出页查询开始================");
			dto.setPrpdidLike(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);
			IGDRM09031VO vo = new IGDRM09031VO();
			ctlBL.searchProcess(dto);
			vo.setProcessList(dto.getProcessList());
			super.<IGDRM09031VO>setVO(request, vo);
			log.info("==============应急指挥流程弹出页查询结束================");
		}
		
		//工作查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========工作查询处理开始========");
			
			
			//获取分页Bean
			getPaginDTO(request,"IGDRM0903");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0903Form) request.getSession().getAttribute("IGDRM0903Form");
				if ( form == null ) {
					form = new IGDRM0903Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				request.getSession().setAttribute("IGDRM0903Form", form);
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						if (form !=null) {
							form.setFromCount(0);
						}
					  }
			}
			
			int maxCnt = getMaxDataCount("IGDRM0903");
			form.setUserid_q(user.getUserid());
			//排序标识取得
			String orderVal = request.getParameter("orderVal");		
			
			//翻页时保存排序标识
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
			}

			//设定排序方式
			if(StringUtils.isNotEmpty(form.getOrder())){
				if(StringUtils.isNotEmpty(orderVal)){
					if(orderVal.equals(form.getOrder())){
						if("DESC".equals(form.getSing())){
							form.setSing("ASC");
						}else{
							form.setSing("DESC");
						}
					}else{
						form.setSing("ASC");
					}
				}
			}else {//排序标识为空时默认按时间排序
				form.setOrder("propentime");
				form.setSing("DESC");
			}
			
			//设定流程关闭状态查询条件
			if ("0001".equals(form.getPrActive())) {
			   // 未关闭 
			   form.setPrActive("Y"); 
			} else if ("0002".equals(form.getPrActive())) {
			   // 已关闭 
			   form.setPrActive("N"); 
			}
			dto.setUser(user);
			
			dto.setIgdrm0903Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//调用BL查询@@
			dto = ctlBL.getProcessRecords(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			request.setAttribute("statusBeanList", statusBeanList);
			request.setAttribute("isAdmin",dto.getIsAdmin());
			request.setAttribute("prpdid",form.getPrpdid());
			//构造VO
			IGDRM09031VO vo = new IGDRM09031VO(dto.getProcessList());
			vo.setNameURLMap(dto.getNameURLMap());
			vo.setProcessTemplateList(dto.getProcessTemplateList());
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			super.<IGDRM09031VO>setVO(request, vo);
			
			log.debug("========工作查询处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(StringUtils.isNotEmpty(request.getParameter("jump"))){
		    request.getSession().setAttribute("jump", request.getParameter("jump"));
		}else{
		    request.getSession().removeAttribute("jump");
		}
		//跳转到定制JSP
		if(StringUtils.isNotEmpty(dto.getForwardJsp())){
			return new ActionForward(dto.getForwardJsp());
		} else {
			return mapping.findForward("DISP");
		}
	}
}
