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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM2714ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM2714ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.vo.IGASM27071VO;

/**
 * 风险点查询画面Action处理
 *
 */
public class IGASM2714Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2714Action.class);

	/**
	 * 风险点资产查询
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
		IGASM2713Form igasm2713form = (IGASM2713Form)actionForm;
		
		//BL取得
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		UserBL userbl = (UserBL)getBean("userBL");
		//DTO生成
		IGASM27DTO dto = new IGASM27DTO();
		dto.setIgasm2713Form(igasm2713form);
		
		if ("DISP".equals(mapping.getParameter())){
			//风险点修改处理显示
			log.debug("========风险点查询初始化显示开始========");
			/**初始化数据查询*/
			ctlBL.searchRiskPropertyActioin(dto);
			IGASM27071VO vo=new IGASM27071VO();
			vo.setGradeList(dto.getGradeList());
			vo.setLevelList(dto.getLevelList());
			vo.setPossibleList(dto.getPossibleList());
			vo.setSignList(dto.getSignList());
			super.<IGASM27071VO>setVO(req, vo);
			log.debug("========风险点查询初始化显示终了========");
		}//初始化页面
		if("SEARCH".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM2714");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			int maxCnt = getMaxDataCount("IGASM2714");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setForm(igasm2713form);
			/**初始化数据查询*/
			ctlBL.searchRiskPropertyActioin(dto);
			
			//调用bl 进行数据处理
			dto=ctlBL.searchRiskPointManagerAction(dto);
			
			
			IGASM27071VO vo=new IGASM27071VO();
			vo.setGradeList(dto.getGradeList());
			vo.setLevelList(dto.getLevelList());
			vo.setPossibleList(dto.getPossibleList());
			vo.setSignList(dto.getSignList());
			vo.setRiskList(dto.getRiskList());
			req.getSession().setAttribute("IGASM2713Form", dto.getIgasm2713Form());
			super.<IGASM27071VO>setVO(req, vo);
			//实例化vo
			log.debug("=======风险查询处理结束========");
			
		}
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================风险点查询导出开始=======================");

			dto.setForm(igasm2713form);
			
			// 取得Excel处理BL
			IGASM2714ExcelBL excelBL = (IGASM2714ExcelBL) getBean("igasm2714ExcelBL");
			
			/**初始化数据查询*/
			ctlBL.searchRiskPropertyActioin(dto);
			//调用bl 进行数据处理
			dto=excelBL.searchRiskPointManagerAction(dto);
			
			// 实例ExeclDTO
			IGASM2714ExcelDTO excelDTO = new IGASM2714ExcelDTO();
			excelDTO.setProcessList(dto.getRiskList());
			// 填充模板编号
			excelDTO.setFileid("ASM2714");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			
			log.debug("=====================风险点查询导出结束=======================");
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
