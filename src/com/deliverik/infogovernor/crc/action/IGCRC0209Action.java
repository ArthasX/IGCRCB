package com.deliverik.infogovernor.crc.action;

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
import com.deliverik.infogovernor.crc.bl.IGCRC02BL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.vo.IGCRC0301VO;
import com.deliverik.infogovernor.wkm.bl.IGWKM01BL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_工作管理_个人工作查询ACTION
 * </p>
 *  
 * @author zhaoziting@deliverik.com
 * @version 1.0
 */

public class IGCRC0209Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC0209Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//实例化FORM
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		//获取BL接口实例
		IGWKM01BL ctlBL = (IGWKM01BL) getBean("igwkm01BL");
		IGCRC02BL igcrc02bl = (IGCRC02BL) getBean("igcrc02bl");
		IGWKM01DTO dto = new IGWKM01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrtype(form.getPrtype());
		//将查询类型标识放进dto中
		dto.setType(form.getType());
		//判断是否是定制查询页面
		if(!"0".equals(form.getCustom())) {
			dto.setPdid(form.getPrpdid());//设定流程定义ID
			//获取流程查询页路径
			dto = ctlBL.searchForwardJsp(dto);
		}

		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		String actname = req.getParameter("actname");//菜单ID取得
		String actsortid = perm.getActsortid(actname);//获取指定菜单ID的ACTSORTID
		//获取菜单名称
		dto.setUserPermission(perm);
		dto.setActname(actname);
		String actlabel = ctlBL.getActionName(dto);
		        
		if(actname != null){
			actsortid = perm.getActsortid(req.getParameter("actname"));
		} else if(StringUtils.isNotEmpty(form.getActname())){
			actsortid = perm.getActsortid(form.getActname());
		}
		if(StringUtils.isNotEmpty(actsortid)){
			setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
			if(actsortid.length()>=4){
				setSessionAttribute(req, "secondactid", actsortid.substring(0,4));
		    }  
		}else{
			//获取菜单权限
			perm = (UserPermission)req.getSession().getAttribute("UserPermission");					
			//设置高亮菜单
			if(perm != null) {
				actsortid = perm.getActsortid("ACT02SVC09");//获取指定菜单ID的ACTSORTID
				if(StringUtils.isNotEmpty(actsortid)){
					setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
					setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
				}
			}
		}
		//动态配置根据表单查询 20130313 start wangtingzhi
		//判断表单查询条件是否已经存在
		if(req.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			//pdid取得
			if(StringUtils.isEmpty(form.getPrpdid())){
				if(req.getParameter("prpdid")!=null){
					form.setPrpdid(req.getParameter("prpdid"));
				}
			}
		    //dto参数设定
		    dto.setIgwkm0101From(form);
			ctlBL.getPivarQueryInfoAction(dto);
			req.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
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
		req.setAttribute("statusBeanList", statusBeanList);
				
				
		//动态配置根据表单查询 20130313 end wangtingzhi
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查询画面初期显示处理开始========");
					//为了动态取得页面上的导航信息添加的处理
					
			setSessionAttribute(req, "igactionid", actsortid);
			IGCRC0301VO vo = new IGCRC0301VO();
			dto.setPrtype(form.getPrtype());
			dto.setPdid(form.getPrpdid());
			if(req.getParameter("prpdid")!=null){
				req.getSession().setAttribute("AD_prpdid", req.getParameter("prpdid"));
			}else{
				if(req.getSession().getAttribute("AD_prpdid")!=null){
					req.removeAttribute("AD_prpdid");
				}
			}
					
			dto = ctlBL.getProcessTemplate(dto);
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			vo.setActlabel(actlabel);//封装三级菜单名称
			req.setAttribute("vo", vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
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
					
				if(req.getSession().getAttribute("AD_prpdid")!=null&&StringUtils.isEmpty(form.getPrpdid())){
						form.setPrpdid(String.valueOf(req.getSession().getAttribute("AD_prpdid")));
				}
					
				form.setIsWork(1);
					
				//获取分页Bean
				getPaginDTO(req,"IGWKM0101");
				PagingDTO pDto;
				pDto = (PagingDTO)req.getAttribute("PagingDTO");
					
				if ("SEARCH1".equals(mapping.getParameter())){
					//由详细画面，编辑画面返回查询画面时的再检索处理
					form = (IGWKM0101Form) req.getSession().getAttribute("IGWKM0101Form");
					if ( form == null ) {
						form = new IGWKM0101Form();
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
						form = (IGWKM0101Form) req.getSession().getAttribute("IGWKM0101Form");
						if (form != null) {
							form.setFromCount(0);
						}
					}
				}
					
					//pDto.setFromCount(form.getFromCount());
				int maxCnt = getMaxDataCount("IGWKM0101");
				form.setUserid_q(user.getUserid());
				//排序标识取得
				String orderVal = req.getParameter("orderVal");		
					
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
				IGCRC02DTO igcrc02dto = new IGCRC02DTO();
				igcrc02dto.setPrSearchCond(cond);
				igcrc02dto.setMaxSearchCount(maxCnt);
				igcrc02dto.setPagingDto(pDto);
				igcrc02dto.setPrtype(form.getPrtype());
					
//					dto = ctlBL.getProcessRecords(dto);	//原流程查询
				igcrc02dto = igcrc02bl.getProblemProcessRecords(igcrc02dto);//自定义流程查询

				req.setAttribute("isAdmin",dto.getIsAdmin());
				//构造VO
				IGCRC0301VO vo = new IGCRC0301VO(igcrc02dto.getProblemproList());
				vo.setNameURLMap(dto.getNameURLMap());
				vo.setProcessTemplateList(dto.getProcessTemplateList());
				vo.setProcessDefinitionList(dto.getProcessDefinitionList());
				vo.setActlabel(actlabel);//封装三级菜单名称
				super.<IGCRC0301VO>setVO(req, vo);
				req.setAttribute("vo", vo);
				req.setAttribute("showFlag", form.getShowFlag());
				log.debug("========工作查询处理终了========");
			}

				
		List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
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
