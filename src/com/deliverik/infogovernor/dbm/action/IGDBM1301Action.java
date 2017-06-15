package com.deliverik.infogovernor.dbm.action;

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
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.dbm.vo.IGDBM13011VO;
import com.deliverik.infogovernor.xls.svc.bl.IGSVC1301ExcelBL;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC1301ExcelDTO;

/**
 * 工作管理查询画面Action处理
 *
 */
public class IGDBM1301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM1301Action.class);

	/**
	 * 工作管理查询处理
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
		IGDBM1301Form form = (IGDBM1301Form)actionForm;
		
		//BL取得
		IGDBM13BL ctlBL = (IGDBM13BL) getBean("igdbm13BL");
		//附件
//		AttachmentBL attachmentBL = (AttachmentBL)getBean("attachmentBL");
		//DTO生成
		IGDBM13DTO dto = new IGDBM13DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========风险检查新增画面初期显示处理开始========");
//			addMessage(req, new ActionMessage("IGCO10000.I001","风险检查基本信息"));
			log.debug("========风险检查新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========工作管理查询开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDBM1301");
			
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			log.debug("========文档查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDBM1301Form) req.getSession().getAttribute("IGDBM1301Form");
				if ( form== null){
					form = new IGDBM1301Form();
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
//					form = (IGRIS0202Form) req.getSession().getAttribute("IGRIS0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDBM1301");
			//DTO输入参数设定
			dto.setIgdbm1301Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgdbm1301Form(form);
			dto = ctlBL.searchWorkmanagerInfos(dto);
			
			IGDBM13011VO vo = new IGDBM13011VO();
			vo.setWmList(dto.getWmList());
			super.<IGDBM13011VO>setVO(req, vo);
			log.debug("========工作管理查询结束========");
			return mapping.findForward("DISP");
		}else if("FINISH".equals(mapping.getParameter())){
			log.debug("=======工作信息完成处理开始========");
			
			dto.setIgdbm1301Form(form);
			dto.setUser(user);
			//调用BL新增
			dto = ctlBL.updateWorkmanagerInfo(dto);
			
			log.debug("========工作信息完成处理终了========");
		}else if ("EXPORT".equals(mapping.getParameter())) {
			log.debug("==========工作信息导出开始 ==========");
			
			dto.setIgdbm1301Form(form);
			dto = ctlBL.exportWorkmanagerInfos(dto);
			IGSVC1301ExcelDTO excelDTO = new IGSVC1301ExcelDTO();
			//查询模板
			excelDTO.setFileid("SVC1302");
			excelDTO.setResponse(res);
			excelDTO.setIgdbm1301Form(form);
			excelDTO.setWmList(dto.getWmList());
			IGSVC1301ExcelBL excelBL = (IGSVC1301ExcelBL) getBean("igsvc1301excelBL");
			excelBL.initExcel(excelDTO);

			log.debug("========工作信息出理终了========");
			return null;
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
