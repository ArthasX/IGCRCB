/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2208Form;
import com.deliverik.infogovernor.asset.vo.IGASM22081VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 概述: 设备检索Action处理
 * 功能描述: 设备检索Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2208Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2208Action.class);


	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM2208Form form = (IGASM2208Form)actionForm;
		
		//BL取得
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO生成
		IGASM22DTO dto = new IGASM22DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//设备查询画面初期显示处理
			log.debug("========设备查询画面初期显示处理开始========");
			
			
			//***************************************************************************
			//类型分类(设备)设定
			form = new IGASM2208Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGASM2208Form", form);
			
			//设置初始权限树
			IGSYM03DTO sym03dto = new IGSYM03DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
			String roletype = req.getParameter("roletype")==null?"IGAC01":req.getParameter("roletype");
			sym03dto = treeBL.getRoleDomainTree(sym03dto, roletype, user);
			Map<String,TreeNode> treeNodeMap = sym03dto.getTreeNodeMap();
			if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
				if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
						Iterator<String> it=treeNodeMap.keySet().iterator();
						while(it.hasNext()){
							Object obj = it.next();
							String key=(String)obj;	
							TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
							req.setAttribute("deforgsys", treeNode.getId());
							req.setAttribute("deforgname", treeNode.getName());
							break;
						}
						
				}
			}
			
			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM2208");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备查询处理
			log.debug("========设备查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM2208Form) req.getSession().getAttribute("IGASM2208Form");
				if ( form== null){
					form = new IGASM2208Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
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
					form = (IGASM2208Form) req.getSession().getAttribute("IGASM2208Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2208");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//设备检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将设备信息检索结果设定到VO中
			IGASM22081VO vo = new IGASM22081VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM22081VO>setVO(req, vo);
			
			log.debug("========设备查询处理终了========");
		}
		if( "INCIDENCE".equals(mapping.getParameter())){
			//设备影响范围画面初期显示处理
			log.debug("========设备影响范围画面初期显示处理开始========");
			
			dto.setIgasm2208Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto=ctlBL.initIGASM2208Action(dto);
			
			//将设备信息检索结果设定到VO中
			IGASM22081VO vo = new IGASM22081VO();
			
			vo.setEntityItemVWInfoMap(dto.getEntityItemVWInfoMap());
			
			super.<IGASM22081VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备影响范围画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
	 return mapping.findForward("DISP");
	}
}
