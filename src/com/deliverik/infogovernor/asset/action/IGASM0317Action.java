package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.vo.IGASM03171VO;

/**
 * 设备批量入库编辑画面Action处理
 *
 * @author
 */
public class IGASM0317Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0317Action.class);
	
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM0317Form form = (IGASM0317Form)actionForm;
		
		//BL取得
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO生成
		IGASM03DTO dto = new IGASM03DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//设备批量入库登记画面初期显示处理
			log.debug("========设备批量入库登记画面初期显示处理开始========");
			form.setAddcount("");
			String maxcount = ResourceUtility.getString("MAXCOUNT");//设备批量入库每次允许的最大条数
			form.setMaxcount(maxcount);
			form.setPareiid(req.getParameter("pareiid"));
			dto.setIgasm0317Form(form);
			dto = ctlBL.initIGASM0317Action(dto);
			addMessage(req, new ActionMessage("IGCO10000.I001","批量入库设备基本信息"));
			log.debug("========设备批量入库登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//设备登记画面再显示处理
			log.debug("========设备登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备登记画面再显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		}	
		if("DISP_BACK".equals(mapping.getParameter())){
			//设备批量入库登记画面初期显示处理
			log.debug("========设备批量入库登记画面初期显示处理开始========");
			//req.setAttribute("IGASM0317Form", req.getSession().getAttribute("IGASM0317Form"));
			addMessage(req, new ActionMessage("IGCO10000.I001","批量入库设备基本信息"));
			log.debug("========设备批量入库登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		}
		
		if( "DISP_INSERT".equals(mapping.getParameter())){
			//设备批量入库登记画面初期显示处理
			log.debug("========设备批量入库登记画面初期显示处理开始========");
			
//			if(form == null){
//				form = (IGASM0317Form)req.getSession().getAttribute("IGASM0317Form");
//			}
			
			String[] eilabels = new String[Integer.valueOf(form.getAddcount())];
			String[] einames = new String[Integer.valueOf(form.getAddcount())];
			String[] ids = new String[Integer.valueOf(form.getAddcount())];
			String[] ids_default = new String[Integer.valueOf(form.getAddcount())];
			String[] serials = new String[Integer.valueOf(form.getAddcount())];

			for(int i=0,j=ids.length;i<j;i++){
				ids[i] = String.valueOf(i); 
				ids_default[i] = String.valueOf(i);
				eilabels[i] = "";
				einames[i] = form.getEiname();
				//serials[i] = String.valueOf(i);
			}
			form.setEilabels(eilabels);
			form.setEinames(einames);
			form.setIds(ids);
			form.setIds_default(ids_default);
			form.setSerials(serials);
			//dto.setIgasm0317Form(form);
			//dto = ctlBL.initIGASM0317Action(dto);
			//req.getSession().setAttribute("IGASM0317Form", form);
			addMessage(req, new ActionMessage("IGCO10000.I001","批量入库设备基本信息"));
			log.debug("========设备批量入库登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//设备批量入库编辑处理
				//设备批量入库登记处理
				log.debug("========设备批量入库登记处理开始========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO输入参数设定
				dto.setIgasm0317Form(form);
				
				if (isTokenValid(req, true)){
					//设备信息登记逻辑调用
					dto = ctlBL.insertBatchEntityItemAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				IGASM03171VO vo = new IGASM03171VO();
				vo.setRelationList(dto.getRelationList());
				super.<IGASM03171VO>setVO(req, vo);
				form.setType("batch");
				req.setAttribute("IGASM0317Form", form);// 批量入库
				log.debug("========设备批量入库登记处理终了========");
				
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
