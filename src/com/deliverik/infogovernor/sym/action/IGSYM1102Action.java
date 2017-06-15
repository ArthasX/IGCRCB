/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1102Form;
import com.deliverik.infogovernor.sym.vo.IGSYM11021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_基础数据_数据分类信息编辑画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1102Action.class);

	/**
	 * 数据分类信息编辑画面Action处理
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
		IGSYM1102Form form = (IGSYM1102Form)actionForm;
		
		//BL取得
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO生成
		IGSYM11DTO dto = new IGSYM11DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//数据分类登记画面初期显示处理
			log.debug("========数据分类登记画面初期显示处理开始========");
			req.setAttribute("IGSYM1102Form", new IGSYM1102Form());
			addMessage(req, new ActionMessage("IGCO10000.I001","数据分类信息"));
			log.debug("========数据分类登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//数据分类编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//数据分类登记画面按下返回按钮时的返回处理
				if (form.getMode().equals("1")){
					//返回类型查询画面
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//数据分类登记处理
				log.debug("========数据分类登记处理开始========");
				//DTO输入参数设定
				dto.setIgsym1102Form(form);
				
				//数据分类信息登记逻辑调用
				dto = ctlBL.insertCodeCategoryAction(dto);
				
				//将登记完了的类型信息设定到VO中
				IGSYM11021VO vo = new IGSYM11021VO(form);
				
				super.<IGSYM11021VO>setVO(req.getSession(), vo);
				
				log.debug("========数据分类登记处理终了========");
				
				if (form.getMode().equals("2")) {
					//返回层次列表画面
					forward = "BACK1";
				} else {
					forward = "DISP";
				}
			} else {
				//类型变更处理
				log.debug("========数据分类变更处理开始========");
				
				dto.setIgsym1102Form(form);
				
				//类型信息变更逻辑调用
				dto = ctlBL.updateCodeCategoryAction(dto);
				
				log.debug("========数据分类变更处理终了========");
				
				forward = "BACK";
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========数据分类变更初期显示处理开始========");
			dto.setIgsym1102Form(form);
			
			dto = ctlBL.initIGSYM1102Action(dto);
			
			log.debug("========数据分类变更初期显示处理终了========");

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
