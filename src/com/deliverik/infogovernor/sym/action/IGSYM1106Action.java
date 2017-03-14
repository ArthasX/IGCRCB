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
import com.deliverik.infogovernor.sym.form.IGSYM1106Form;
import com.deliverik.infogovernor.sym.vo.IGSYM11061VO;
import com.deliverik.infogovernor.sym.vo.IGSYM11062VO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_基础数据_数据详细信息画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class IGSYM1106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1106Action.class);

	/**
	 * 数据详细信息画面Action处理
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
		IGSYM1106Form form = (IGSYM1106Form)actionForm;
		
		
		//BL取得
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO生成
		IGSYM11DTO dto = new IGSYM11DTO();
		
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			if("1".equals(req.getParameter("back"))){
				if(!"1".equals(form.getClevel())){
					form.setCcid(form.getPccid());
				}
				form.setCid(form.getPcid());
			}else if("2".equals(req.getParameter("back"))){
				form.setClevel("1");
			}else if("3".equals(req.getParameter("back"))){
				if(!"1".equals(form.getClevel())){
					form.setCid(form.getPcid());
				}
			}
			//数据详细信息查询画面初期显示处理
			log.debug("========数据详细信息查询画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgsym1106Form(form);
			
			//数据详细信息画面初期显示处理逻辑调用
			dto = ctlBL.initIGSYM1106Action(dto);
			
			//将数据详细信息检索结果设定到VO中
			IGSYM11061VO vo = new IGSYM11061VO(dto.getCodeCategoryInfo(),
					dto.getCodeDetailList(),dto.getCodeDetail());
			
			super.<IGSYM11061VO>setVO(req.getSession(), vo);
			
			super.<IGSYM11062VO>setVO(req.getSession(),  new IGSYM11062VO(dto.getCodeCategoryInfo(),
					dto.getCodeDetail()));

			log.debug("========数据详细信息画面初期显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//数据详细删除处理
			log.debug("========数据详细删除处理开始========");
			//DTO输入参数设定
			dto.setIgsym1106Form(form);
			
			//数据配置删除处理逻辑调用
			ctlBL.deleteCodeDetailAction(dto);
			
			form.setCid(null);
			
			log.debug("========数据详细删除处理终了========");
		}
		
		if ("BACK".equals(mapping.getParameter())){
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				
				if("1".equals(form.getClevel())){
					//返回处理
					forward = "BACK1";
				}else{
					
					//DTO输入参数设定
					dto.setIgsym1106Form(form);
					
					//数据详细信息画面初期显示处理逻辑调用
					dto = ctlBL.initIGSYM1106BackAction(dto);
					
					//将数据详细信息检索结果设定到VO中
					IGSYM11061VO vo = new IGSYM11061VO(dto.getCodeCategoryInfo(),
							dto.getCodeDetailList(),dto.getCodeDetail());
					
					super.<IGSYM11061VO>setVO(req, vo);
					
					super.<IGSYM11062VO>setVO(req.getSession(),  new IGSYM11062VO(dto.getCodeCategoryInfo(),
							dto.getCodeDetail()));
					//返回处理
					forward = "BACK";
				}
			}

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
