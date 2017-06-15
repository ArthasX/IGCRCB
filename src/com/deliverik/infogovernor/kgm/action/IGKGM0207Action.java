/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.action;

import java.util.Date;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0207Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02071VO;

/**
 * 概述:知识库评分Action
 * 功能描述：知识库评分Action
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public class IGKGM0207Action extends BaseAction{

	static Log log = LogFactory.getLog(IGKGM0201Action.class);
	
	/**
	 * 知识登记处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGKGM0207Form form = (IGKGM0207Form)actionForm;
		
		//BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO生成
		IGKGM03DTO dto = new IGKGM03DTO();
		
		

		 if( "INSERT".equals(mapping.getParameter())){
			//知识补录处理
			log.debug("========知识评分登记处理开始========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//设定知识库评分登记人ID
			form.setKguserid(user.getUserid());
			//当前时间取得
			Date nowDateTime = new Date();
			//当前时间格式化
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
			//当前时间设定
			form.setKgtime(datetime);
			//将Form设定到Dto中
			dto.setIgkgm0207Form(form);
			dto.setUser(user);
			//评分持久化
			dto = ctlBL.registKnowledgeGradeAction(dto);
			addMessage(req, new ActionMessage("IGKGM0207.I001"));
			log.debug("========知识评分登记处理终了========");

		 }
		 if("SEARCH".equals(mapping.getParameter())){
			 
			 int maxCnt = getMaxDataCount("IGKGM0207");
			 dto.setMaxSearchCount(maxCnt);
		
			 //知识ID取得
			 String knid = req.getParameter("knid");
			 
			 dto.setKnid(Integer.valueOf(knid));
			 //查询知识评分结果
			 dto = ctlBL.searchKnowledgeGradeAction(dto);
			 //添加业务系统
			 dto = ctlBL.getKnowledgeAppImpact(dto);
			 
			 IGKGM02071VO vo = new IGKGM02071VO();
			 vo.setKnowledgeGradeList(dto.getKnowledgeGradeList());
			 vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			 super.<IGKGM02071VO>setVO(req, vo);
			 
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
