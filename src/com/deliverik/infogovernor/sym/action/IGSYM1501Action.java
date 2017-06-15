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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM15BL;
import com.deliverik.infogovernor.sym.dto.IGSYM15DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1501Form;
import com.deliverik.infogovernor.sym.vo.IGSYM15011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_基础数据_数据分类列表画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1501Action.class);

	/**
	 * 数据分类列表画面Action处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGSYM1501Form form = (IGSYM1501Form)actionForm;
		//BL取得
		IGSYM15BL ctlBL = (IGSYM15BL) getBean("igsym15BL");
		
		//DTO生成
		IGSYM15DTO dto = new IGSYM15DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//数据分类列表画面初期显示处理
			log.debug("========数据分类列表画面初期显示处理开始========");
			
			getPaginDTO(req,"IGSYM1501");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSYM1501");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.initIGSYM1501Action(dto);
			
			IGSYM15011VO vo = new IGSYM15011VO(dto.getCodeCategoryDefInfoList());
			
			saveToken(req);	
			
			super.<IGSYM15011VO>setVO(req, vo);
//			super.<IGSYM11011VO>setVO(req, vo);
			
			log.debug("========数据分类列表画面初期显示处理终了========");
		}else if("INSERTDISP".equals(mapping.getParameter())){
			log.debug("========数据分类登记画面初期显示处理开始========");
			saveToken(req);	
			log.debug("========数据分类登记画面初期显示处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========数据分类登记处理开始========");
			dto.setIgsym1501Form(form);

			if (isTokenValid(req, true)){
				//调用BL新增
				dto = ctlBL.saveIGSYM11501Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========数据分类登记处理终了========");
		}else if ("DEL".equals(mapping.getParameter())){
			//数据分类删除处理
			log.debug("========数据分类删除处理开始========");

			//DTO输入参数设定
			dto.setIgsym1501Form(form);
			
			if (isTokenValid(req, true)){
				//数据分类删除逻辑调用
				ctlBL.deleteIGSYM1501Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========数据分类删除处理终了========");
		}else if ("DELETE".equals(mapping.getParameter())){
			//数据分类删除处理
			log.debug("========数据分类删除处理开始========");
			
			//IGSYM1101Form form = (IGSYM1101Form)actionForm;

			//DTO输入参数设定
			//dto.setIgsym1001Form(form);
			
			//数据分类删除逻辑调用
			//ctlBL.deleteCodeCategoryAction(dto);
			
			log.debug("========数据分类删除处理终了========");
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
