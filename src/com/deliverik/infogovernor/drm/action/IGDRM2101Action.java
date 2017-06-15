package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2101Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21011VO;
import com.deliverik.infogovernor.drm.vo.IGDRM21012VO;

/**
 * 预案登记Action
 *
 * @author
 */
public class IGDRM2101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2101Action.class);

	/**
	 * 预案登记
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
		IGDRM2101Form form = (IGDRM2101Form)actionForm;
		
		//BL取得
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");
		
		//DTO生成
		IGDRM21DTO dto = new IGDRM21DTO();
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//设备登记画面初期显示处理
			log.debug("========设备登记画面初期显示处理开始========");
			form = new IGDRM2101Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);

			dto.setForm(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);
			req.setAttribute("IGDRM2101Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","设备基本信息"));
			log.debug("========设备登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 

		if( "INSERT".equals(mapping.getParameter())){
			//设备编辑处理
			if (form.getMode().equals("0")){
				//设备登记处理
				log.debug("========设备登记处理开始========");
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO输入参数设定
				dto.setForm(form);
				
				//设备信息登记逻辑调用
				dto = ctlBL.insertEntityItemAction(dto);
				
				//将登记完了的设备信息设定到VO中
				IGDRM21011VO vo = new IGDRM21011VO();
				
				super.<IGDRM21011VO>setVO(req.getSession(), vo);
				
				req.setAttribute("btn1Val", "添加预案信息");
				req.setAttribute("btn1Url", "IGDRM2102_Disp.do?eiid="+form.getEiidStr()+"&eid="+form.getEid());
				req.setAttribute("btn2Val", "返回");
				req.setAttribute("btn2Url", "IGDRM2101_Disp.do");
				
				log.debug("========设备登记处理终了========");
				
				forward = "DISP";

			}
			if(form.getMode().equals("1")){
				log.debug("========设备更新处理开始========");
				dto.setForm(form);
				dto = ctlBL.updateEntityItemAction(dto);
				log.debug("========设备更新处理终了========");
				
				forward = "BACK";
			}
		}
		//业务系统选择初始化
		if("BSINIT".equals(mapping.getParameter())){
			
			getPaginDTO(req,"IGDRM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0301");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//DTO输入参数设定
			dto.setForm(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//资产检索逻辑调用
			dto = ctlBL.searchEntityDisp(dto);
			
			//将资产信息检索结果设定到VO中
			IGDRM21011VO vo = new IGDRM21011VO();
			vo.setEntityVWItemList(dto.getEntityItemVWInfoList());
			super.<IGDRM21011VO>setVO(req, vo);
			forward = "DISP";
		}
		
		// 初始化页面
		if("EDIT".equals(mapping.getParameter())){
			dto.setForm(form);
			dto = ctlBL.initSoc0118EditInfo(dto);
			IGDRM21012VO vo = new IGDRM21012VO(dto);
			super.<IGDRM21012VO>setVO(req, vo);
			form.setMode("1");
			forward = "DISP";
		}
				
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
