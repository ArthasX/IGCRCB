package com.deliverik.infogovernor.ven.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;
import com.deliverik.infogovernor.ven.bl.IGVEN01BL;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0101Form;
import com.deliverik.infogovernor.ven.form.IGVEN0102Form;
import com.deliverik.infogovernor.ven.vo.IGVEN01011VO;

/**
 * 风险检查查询画面Action处理
 *
 */
public class IGVEN0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0101Action.class);

	/**
	 * 风险检查查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//BL取得
		IGVEN01BL ctlBL = (IGVEN01BL) getBean("igven01BL");
		
		//DTO生成
		IGVEN01DTO dto = new IGVEN01DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========风险检查查询画面初期显示处理开始========");
			
			//FORM取得
			IGVEN0101Form form = (IGVEN0101Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险检查查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========风险检查查询处理开始========");

			//FORM取得
			IGVEN0101Form form = (IGVEN0101Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//分页用DTO取得
			getPaginDTO(req,"IGVEN0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(StringUtils.isEmpty(form.getRcstatus_q())){
				form.setRcstatus_q("0");//启用状态
			}
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGVEN0101Form) req.getSession().getAttribute("IGVEN0101Form");
				if ( form == null ) {
					form = new IGVEN0101Form();
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
					form = (IGVEN0101Form) req.getSession().getAttribute("IGVEN0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO输入参数设定
			dto.setIgven0101Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchRiskCheckAction(dto);
				
			//将类型信息检索结果设定到VO中
			IGVEN01011VO vo = new IGVEN01011VO();

			vo.setRiskStrategyList(dto.getRiskStrategyList());
			super.<IGVEN01011VO>setVO(req, vo);
			
			log.debug("========风险检查查询处理终了========");
		}else if ("CHANGE".equals(mapping.getParameter())){
			//修改状态1启用 0停用
			log.debug("========风险检查状态变化处理开始========");

			//FORM取得
			IGVEN0102Form form = (IGVEN0102Form)actionForm;
			dto.setIgVEN0102Form(form);
//			dto = ctlBL.changeRiskCheckStatusAction(dto);
			dto = ctlBL.changeCheckStrategyStatusOnlyAction(dto);
			
			log.debug("========风险检查状态变化处理终了========");
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
