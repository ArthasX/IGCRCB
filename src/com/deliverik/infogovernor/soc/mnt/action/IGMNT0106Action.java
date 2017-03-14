package com.deliverik.infogovernor.soc.mnt.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0106Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01061VO;

/**
 * 资产项查询HELP画面用Action处理
 *
 */
public class IGMNT0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMNT0106Action.class);

	/**
	 * 
	 * 处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGMNT0106Form form = (IGMNT0106Form)actionForm;
		
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		
		//DTO生成
		IGMNT01DTO dto = new IGMNT01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========资产项HELP查询画面初期显示处理开始========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameAction(dto);
				form.setEname(dto.getEname());
			}
			//重新查询需清除缓存
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			
			//获取下拉列表各项
			dto=ctlBL.searchEsyscodingAction(dto);
			List<LabelValueBean> esyscodingList = dto.getEsyscodingList();
			req.getSession().setAttribute("esyscodingList", esyscodingList);
			
			//设置下拉列表默认值
			String mtId = form.getMtId();
			if(StringUtils.isNotEmpty(mtId)){
				dto.setMtId(mtId);
				MonitorTypeInfo monitorType = ctlBL.searchMonitorTypeByPK(dto);
				String mtSyscoding = monitorType.getMtSyscoding();
				if(mtSyscoding.equals("001001")){//DMX
					form.setEsyscoding("999001009001");
				}else if(mtSyscoding.equals("001002")){//IBM
					form.setEsyscoding("999001009002");
				}else if(mtSyscoding.equals("001003")){//CX
					form.setEsyscoding("999001009003");
				}else if(mtSyscoding.equals("002001")){//Brocade
					form.setEsyscoding("999001006001");
				}else if(mtSyscoding.equals("002002")){//Cisco
					form.setEsyscoding("999001006002");
				}else if(mtSyscoding.equals("002003")){//Mcdata
					form.setEsyscoding("999001006003");
				}
			}
			log.debug("========资产项HELP查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			log.debug("========资产项HELP查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产项HELP查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========资产项查询HELP处理开始========");

			//分页用DTO取得
			getPaginDTO(req,"IGMNT0106");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGMNT0106Form) req.getSession().getAttribute("IGMNT0106Form");
				if ( form== null){
					form = new IGMNT0106Form();
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
					form = (IGMNT0106Form) req.getSession().getAttribute("IGMNT0106Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			
			
//			pDto.setFromCount(form.getFromCount());
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGMNT0106");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			
			if("SEARCH2".equals(mapping.getParameter())){
				//点击查询按钮清除缓存
				if (req.getParameter("PAGING") == null) {
					req.getSession().removeAttribute("ADSelectEntity");
					form.setSelectId(null);
				}
			}
			
			dto.setPagingDto(pDto);
			

			//资产项信息检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将资产项信息检索结果设定到VO中
			IGMNT01061VO vo = new IGMNT01061VO(dto.getEntityItemVWInfoList());
			
			super.<IGMNT01061VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========资产项HELP查询处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
