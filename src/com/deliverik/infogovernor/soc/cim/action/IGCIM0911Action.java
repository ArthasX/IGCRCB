package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0911Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM09111VO;

/**
 * 网络交换机端口查询画面 Action处理
 *
 */
public class IGCIM0911Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0911Action.class);

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
		IGCIM0911Form form = (IGCIM0911Form)actionForm;
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		
		dto.setLocale(this.getLocale(req));
		
		//网络交换机端口查询画面初期显示处理
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========网络交换机端口查询画面初期显示处理开始========");
			form = new IGCIM0911Form();
			req.setAttribute("IGCIM0911Form", form);
			log.debug("========网络交换机端口查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//网络交换机端口查询画面再显示处理
			log.debug("========网络交换机端口查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========网络交换机端口查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		//网络交换机端口查询处理
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0911");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			log.debug("========网络交换机端口查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0911Form) req.getSession().getAttribute("IGCIM0911Form");
				if ( form== null){
					form = new IGCIM0911Form();
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
					form = (IGCIM0911Form) req.getSession().getAttribute("IGCIM0911Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0911");
			//DTO输入参数设定
			dto.setIgcim0911Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//设备检索逻辑调用
			dto = ctlBL.searchIGCIM0911Action(dto);
			//将设备信息检索结果设定到VO中
			IGCIM09111VO vo = new IGCIM09111VO();
			vo.setNetDeviceList(dto.getNetDeviceList());
			super.<IGCIM09111VO>setVO(req, vo);
			log.debug("========网络交换机端口查询处理终了========");
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
