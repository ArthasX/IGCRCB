/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.aut.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.soc.aut.bl.IGAUT01BL;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT01DTO;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0101Form;
import com.deliverik.infogovernor.soc.aut.vo.IGAUT01011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_工作管理_个人工作查询ACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGAUT0101Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGAUT0101Action.class);
	
	/**
	 * <p>
	 * Description: 个人工作action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGAUT0101Form form = (IGAUT0101Form)actionForm;
		//获取BL接口实例
		IGAUT01BL ctlBL = (IGAUT01BL) getBean("igaut01BL");
		IGAUT01DTO dto = new IGAUT01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		
		
		dto.setPrtype(form.getPrtype());
		//将查询类型标识放进dto中
		dto.setType(form.getType());
		//判断是否是定制查询页面
		if(!"0".equals(form.getCustom()) && form.getPrtype().endsWith("D")) {
			dto.setPdid(form.getPrpdid());//设定流程定义ID
			//获取流程查询页路径
			dto = ctlBL.searchForwardJsp(dto);
		}
        UserPermission perm = (UserPermission)request.getSession().getAttribute("UserPermission");
        String actname = request.getParameter("actname");//菜单ID取得
        String actsortid = perm.getActsortid(actname);//获取指定菜单ID的ACTSORTID
        //获取菜单名称
        dto.setUserPermission(perm);
        dto.setActname(actname);
        String actlabel = ctlBL.getActionName(dto);
        
		if(actname != null){
			actsortid = perm.getActsortid(request.getParameter("actname"));
		} else if(StringUtils.isNotEmpty(form.getActname())){
			actsortid = perm.getActsortid(form.getActname());
		}
		if(StringUtils.isNotEmpty(actsortid)){
			setSessionAttribute(request, "firstactid", actsortid.substring(0, 2));
			if(actsortid.length()>=4){
				setSessionAttribute(request, "secondactid", actsortid.substring(0,4));
			}
		}else{
			//获取菜单权限
			perm = (UserPermission)request.getSession().getAttribute("UserPermission");
			
			//设置高亮菜单
			if(perm != null) {
				actsortid = perm.getActsortid("ACT02SVC09");//获取指定菜单ID的ACTSORTID
				if(StringUtils.isNotEmpty(actsortid)){
					setSessionAttribute(request, "firstactid", actsortid.substring(0, 2));
					setSessionAttribute(request, "secondactid", actsortid.substring(0, 4));
				}
			}
		}
		//动态配置根据表单查询 20130313 start wangtingzhi
		//判断表单查询条件是否已经存在
		if(request.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			//pdid取得
			if(StringUtils.isEmpty(form.getPrpdid())){
				if(request.getParameter("prpdid")!=null){
					form.setPrpdid(request.getParameter("prpdid"));
				}
			}
			//dto参数设定
			dto.setIgaut0101From(form);
			ctlBL.getPivarQueryInfo0101Action(dto);
			request.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
		}
		//添加流程状态下拉列表
		
		dto = ctlBL.searchPdid7BitAction(dto);
		List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
		if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
			List<IG333Info> statusList = dto.getiG333InfoList();
			statusBeanList.add(new LabelValueBean());
			for (int i = 0; i < statusList.size(); i++) {
				statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
			}
		}
		request.setAttribute("statusBeanList", statusBeanList);
		
		
		//动态配置根据表单查询 20130313 end wangtingzhi
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查询画面初期显示处理开始========");
			//为了动态取得页面上的导航信息添加的处理

			
			setSessionAttribute(request, "igactionid", actsortid);
			IGAUT01011VO vo = new IGAUT01011VO();
			dto.setPrtype(form.getPrtype());
			dto.setPdid(form.getPrpdid());
			if(request.getParameter("prpdid")!=null){
				request.getSession().setAttribute("AD_prpdid", request.getParameter("prpdid"));
			}else{
				if(request.getSession().getAttribute("AD_prpdid")!=null){
					request.removeAttribute("AD_prpdid");
				}
			}
			
			dto = ctlBL.getProcessTemplate(dto);
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			vo.setActlabel(actlabel);//封装三级菜单名称
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
		
		//工作查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========工作查询处理开始========");
			
			if(request.getSession().getAttribute("AD_prpdid")!=null&&StringUtils.isEmpty(form.getPrpdid())){
				form.setPrpdid(String.valueOf(request.getSession().getAttribute("AD_prpdid")));
			}
			
			form.setIsWork(1);
			
			//获取分页Bean
			getPaginDTO(request,"IGAUT0101");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGAUT0101Form) request.getSession().getAttribute("IGAUT0101Form");
				if ( form == null ) {
					form = new IGAUT0101Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						form = (IGAUT0101Form) request.getSession().getAttribute("IGAUT0101Form");
						if (form !=null) {
							form.setFromCount(0);
						}
					  }
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGAUT0101");
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
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			try {
				BeanUtils.copyProperties(cond,form);
			} catch (Exception e) {
				log.error("",e);
			}
			dto.setPrSearchCond(cond);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.getProcessRecords(dto);
			request.setAttribute("isAdmin",dto.getIsAdmin());
			//构造VO
			IGAUT01011VO vo = new IGAUT01011VO(dto.getProcessList());
			vo.setNameURLMap(dto.getNameURLMap());
			vo.setProcessTemplateList(dto.getProcessTemplateList());
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			vo.setActlabel(actlabel);//封装三级菜单名称
			super.<IGAUT01011VO>setVO(request, vo);
			
			log.debug("========工作查询处理终了========");
		}
		if( "DEL".equals(mapping.getParameter())){
			dto.setPrid(form.getDelprid());
			dto = ctlBL.delProcessRecord(dto);
			
			//构造VO
			IGAUT01011VO vo = new IGAUT01011VO(dto.getProcessList());
			vo.setActlabel(actlabel);//封装三级菜单名称
			super.<IGAUT01011VO>setVO(request, vo);
			request.setAttribute("vo", vo);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		//跳转到定制JSP
		if(StringUtils.isNotEmpty(dto.getForwardJsp())){
			return new ActionForward(dto.getForwardJsp());
		} else {
			return mapping.findForward("DISP");
		}
	}
}
