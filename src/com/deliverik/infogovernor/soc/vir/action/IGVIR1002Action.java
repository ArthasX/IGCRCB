/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR10BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10011VO;

/**
 * ����: vcloud��ҳAction
 * ��������: ��ҳAction
 * ������¼: 2014/03/04
 * �޸ļ�¼: 
 */
public class IGVIR1002Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR1001Action.class);

	/**
	 * ��ҳ��ѯ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
				//BLȡ��
				IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
				
				//DTO����
				IGVIR10DTO dto = new IGVIR10DTO();
				
				//��ȡ�û���Ϣ
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				dto.setUser(user);
				
				if("USER".equals(mapping.getParameter())){
					
					
//					ctlBL.initVir10UserAction(dto);
//					
					IGVIR10011VO vo = new IGVIR10011VO();
					
//					vo.setLstProcessRecord(dto.getLstProcessRecord());
//					
//					vo.setUserCount(dto.getUserCount());
//					
//					vo.setUserExpireCount(dto.getUserExpireCount());
//					
//					vo.setOrgCount(dto.getOrgCount());
//					
//					vo.setOrgExpireCount(dto.getOrgExpireCount());
//					
//					vo.setUsercost(dto.getUsercost());
//					
//					vo.setOrgcost(dto.getOrgcost());
//					
//					vo.setTemplateList(dto.getTemplateList());
//					
//					vo.setOwnVMlist(dto.getOwnVMList());
//					
//					super.<IGVIR10011VO>setVO(req, vo);
					
				}
				
				if("MANAGE".equals(mapping.getParameter())){
//					ctlBL.getResourceSurvey(dto);
//					ctlBL.initVir10ManageAction(dto);
//					
					IGVIR10011VO vo = new IGVIR10011VO();
//					
//					vo.setOrgResList(dto.getOrgResList());
//					
//					vo.setOrgExpiryResList(dto.getOrgExpiryResList());
//
//					vo.setResourceSurveyMap(dto.getResourceSurveyMap());
//					
//					vo.setPihList(dto.getPihList());
//					
//					vo.setTemplateList(dto.getTemplateList());
//					
//					vo.setMonthCountData(dto.getMonthCountData());
					
					super.<IGVIR10011VO>setVO(req, vo);
					
				}
		return mapping.findForward("DISP");
	}
	
	
}
