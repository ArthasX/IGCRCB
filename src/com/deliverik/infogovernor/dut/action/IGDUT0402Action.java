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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dut.bl.IGDUT04BL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0402Form;
import com.deliverik.infogovernor.dut.vo.IGDUT04021VO;

/**
 * 延时解锁管理Action
 */
public class IGDUT0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0402Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGDUT0402Form form = (IGDUT0402Form)actionForm;
		
		//BL取得
		IGDUT04BL ctlBL = (IGDUT04BL) getBean("igdut04BL");
		
		//DTO生成
		IGDUT04DTO dto = new IGDUT04DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========延时解锁管理画面初期显示处理开始========");
			dto=ctlBL.getTitle(dto);
			List<LabelValueBean> titleList = dto.getTitleList();
			req.getSession().setAttribute("titleList", titleList);
			log.debug("========延时解锁管理画面初期显示处理终了========");
			forward = "DISP";
		} else if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter()) ) {
			
			dto=ctlBL.getTitle(dto);
			List<LabelValueBean> titleList = dto.getTitleList();
			req.getSession().setAttribute("titleList", titleList);
			
			getPaginDTO(req,"IGPRJ0101");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//编辑画面返回查询画面时的再检索处理
				form = (IGDUT0402Form) req.getSession().getAttribute("IGDUT0402Form");
				if ( form == null ) {
					form = new IGDUT0402Form();
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
					form = (IGDUT0402Form) req.getSession().getAttribute("IGDUT0402Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGDUT0402");
			
			dto.setDelaySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchDelayByCond(dto);
			IGDUT04021VO vo=new IGDUT04021VO();
			vo.setDelayList(dto.getDelayList());
			super.<IGDUT04021VO>setVO(req, vo);
			forward="DISP";
			
		} else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========延时解锁删除处理开始========");
			dto.setDeleteId(form.getDeleteId());
			dto=ctlBL.deleteDelayAction(dto);
			log.debug("========延时解锁删除处理终了========");
			forward="DISP";
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
