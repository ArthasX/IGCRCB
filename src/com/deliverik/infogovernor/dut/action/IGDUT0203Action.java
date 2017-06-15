/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0203Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02031VO;




/**
 * 值班日报处理Action
 * 
 */
public class IGDUT0203Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDUT0203Action.class);

	/**
	 * 值班日报处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGDUT0203Form form = (IGDUT0203Form) actionForm;
		// BL取得
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		// DTO生成
		IGDUT02DTO dto = new IGDUT02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if ("DISP".equals(mapping.getParameter())) {
			// 值班检查设定初期显示处理
			log.debug("========值班日报画面初期显示处理开始========");
			dto.setIgDUT0203Form(form);
			dto = ctlBL.initIGDUT0203Action(dto);
			if(dto.getNum()!=null && dto.getNum()>0){
				Integer[] dadids = new Integer[dto.getNum()];
				String[] dadtypes = new String[dto.getNum()];
				String[] dadnames = new String[dto.getNum()]; 
				String[] dattimes = new String[dto.getNum()]; 
				String[] datlimtimes = new String[dto.getNum()]; 
				String[] dadcontents = new String[dto.getNum()]; 
				String[] dadcontenttypes = new String[dto.getNum()]; 
				String[] drfilltimes = new String[dto.getNum()]; 
				String[] drresults = new String[dto.getNum()];
				
				form.setDadids(dadids);
				form.setDadtypes(dadtypes);
				form.setDadnames(dadnames);
				form.setDattimes(dattimes);
				form.setDatlimtimes(datlimtimes);
				form.setDadcontents(dadcontents);
				form.setDadcontenttypes(dadcontenttypes);
				form.setDrfilltimes(drfilltimes);
				form.setDrresults(drresults);
				
			}
			req.getSession().setAttribute("ADcount", 0);//数组计数器
			req.getSession().setAttribute("ADcheckCount", 0);
			form.setDutyPlan(dto.getDutyPlan());
			form.setDridList(dto.getDridList());
			IGDUT02031VO vo = new IGDUT02031VO();
			vo.setShowList(dto.getShowList());
			vo.setShowResultList(dto.getShowResultList());
			vo.setTypeMap(dto.getTypeMap());
			vo.setUsersinfo(dto.getUsersinfo());//值班人
			vo.setDptype(dto.getDptype());//值班时间
			vo.setDpremarks(dto.getDpremarks());// 值班日报日志
			super.<IGDUT02031VO>setVO(req.getSession(), vo);

			log.debug("========值班日报画面初期显示处理终了========");
			saveToken(req);
			//return mapping.findForward("DISP");
		} 

		if( "INSERT".equals(mapping.getParameter())){
			log.debug("========值班日报保存处理开始========");
			dto.setIgDUT0203Form(form);
			if (isTokenValid(req, true)) {
				dto = ctlBL.insertIGDUT0203Action(dto);
				addMessage(req, new ActionMessage("IGDUT0203.I002"));
			} else {
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========值班日报保存处理终了========");
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward("DISP");
	}
}
