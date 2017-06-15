/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0207Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02071VO;

/**
 * 概述: 性能数据报警查询画面Action处理
 * 功能描述: 性能数据报警查询画面Action处理
 * 创建记录: 2011/11/24
 * 修改记录: 
 */
public class IGMNT0207Action extends BaseAction{
	static Log log = LogFactory.getLog(IGMNT0207Action.class);
	/**
	 * 性能数据报警
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
		IGMNT0207Form form = (IGMNT0207Form)actionForm;
		
		//BL取得
		IGMNT02BL ctlBL = (IGMNT02BL) getBean("igmnt02BL");
		
		//DTO生成
		IGMNT02DTO dto = new IGMNT02DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========性能数据报警初期画面开始========");
			log.debug("========性能数据报警初期画面终了========");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGMNT0207");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGMNT0207Form) req.getSession().getAttribute("IGMNT0207Form");
				if ( form== null){
					form = new IGMNT0207Form();
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
					form = (IGMNT0207Form) req.getSession().getAttribute("IGMNT0207Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//存储查询处理
			log.debug("========性能数据报警查询开始========");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGMNT0207");
			
			//DTO输入参数设定
			dto.setIgmnt0207Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//存性能数据报警查询调用
			dto = ctlBL.searchSOC0306Action(dto);
			//将性能数据报警查询结果设定到VO中
			IGMNT02071VO vo = new IGMNT02071VO();
			
			vo.setSoc0306List(dto.getSoc0306List());
			
			super.<IGMNT02071VO>setVO(req,vo);
			
			log.debug("========性能数据报警查询终了========");
		}else if( "POP".equals(mapping.getParameter())){

			log.debug("========性能数据报警弹出窗口开始========");
			
			//DTO输入参数设定
			dto.setIgmnt0207Form(form);
			
			//存性能数据报警查询调用
			dto = ctlBL.popSOC0306Action(dto);
			
			//将性能数据报警查询结果设定到VO中
			IGMNT02071VO vo = new IGMNT02071VO();
			
			vo.setSoc0306List(dto.getSoc0306List());
			
			super.<IGMNT02071VO>setVO(req,vo);
			
			log.debug("========性能数据报警弹出窗口终了========");
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
