/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.ram.bl.IGRAM02BL;
import com.deliverik.infogovernor.ram.dto.IGRAM02DTO;
import com.deliverik.infogovernor.ram.vo.IGRAM02011VO;

/**
 * <p>
 * Title : InfoGovernor 信息安全管理平台
 * </p>
 * <p>
 * Description: 风险评估_评估分数记录查询ACTION
 * </p>
 * 
 * @author tangzhen@deliverik.com
 * @version 1.0
 */

public class IGRAM0201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRAM0201Action.class);
	
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
	 * @author tangzhen@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("====================风险评估评分历史记录查询开始====================");
		//获取BL接口实例
		IGRAM02BL ctlBL = (IGRAM02BL) getBean("igram02BL");
		IGRAM02DTO dto = new IGRAM02DTO();
		
		if(request.getParameter("prid") != null){
			dto.setPrid(request.getParameter("prid"));
		}
		if(request.getParameter("pdid") != null){
			dto.setPdid(request.getParameter("pdid"));
		}
		//根据prid查询历史评分记录
		dto = ctlBL.searchAssessmentScoreHistory(dto);
		
		IGRAM02011VO vo = new IGRAM02011VO();
		//评估打分参与人员
		vo.setPpList(dto.getPpList());
		//评分项
		vo.setPrjMap(dto.getPrjMap());
		//评分分数
		vo.setHsList(dto.getHistoryScoreList());
		
		super.<IGRAM02011VO>setVO(request, vo);
		log.debug("====================风险评估评分历史记录查询结束====================");
		
		return mapping.findForward("DISP");

	}
}
