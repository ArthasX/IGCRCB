/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.action;

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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0215Form;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.kgm.vo.IGKGM02051VO;

/**
 * 概述:知识库详细页查询Action
 * 功能描述：知识库查询Action
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public class IGKGM0214Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0205Action.class);

	/**
	 * 处理
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
		
		IGKGM0215Form form = (IGKGM0215Form)actionForm;
		//DTO生成
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if ("DETAIL".equals(mapping.getParameter())){
			//知识信息查看
			log.debug("========知识详细信息查看处理开始========");
			
			//获取菜单权限
			UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
			
			//设置高亮菜单
			if(perm != null) {
				String actsortid = perm.getActsortid("ACT02SVC13");//获取指定菜单ID的ACTSORTID
				if(StringUtils.isNotEmpty(actsortid)){
					setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
					setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
				}
			}
			
			dto.setKnid(form.getKnid());//知识ID
			
			dto.setPrid(form.getPrid());//打开知识明细页面的流程ID
			
			dto.setSfid(form.getSfid());//打开知识明细页面的服务工单ID
			
			dto.setKnversion(form.getKnversion());//知识版本
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");

			dto = igkgm02BL.searchKnowLedgeDetailActionbyPK(dto);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			dto = igkgm02BL.getKnowledgeAppImpact(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			//----------------------------------------------------------
			KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
			cond.setKnid(form.getKnid());
			dto.setKnowledgeSearchCond(cond);
			dto = igkgm02BL.getKnowledgeCount(dto);
			//----------------------------------------------------------
			//设置显示信息
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setIgkgm0215form(form);
			vo.setKnowledge(dto.getKnowledge());
			vo.setIsNewKnowledge(Integer.toString(dto.getCount()));
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
			}
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========知识详细信息查看处理终了========");
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
