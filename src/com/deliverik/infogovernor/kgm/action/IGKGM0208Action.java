/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0208Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02081VO;

/**
 * 概述: 知识审核画面Action处理
 * 功能描述：1.查询未审核的知识
 *           2.未审核的知识审核过或驳回
 * 创建记录：宋海洋 2010/12/07
 * 修改记录：
 */
public class IGKGM0208Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0208Action.class);

	/**
	 * 功能：审核处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGKGM0208Form form = (IGKGM0208Form)actionForm;
		
		//BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO生成
		IGKGM03DTO dto = new IGKGM03DTO();
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			//知识查询画面初期显示处理
			log.debug("========知识审核查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========知识审核查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//知识查询处理
			log.debug("========知识审核查询处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGKGM0208");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGKGM0208Form) req.getSession().getAttribute("IGKGM0208Form");
				if ( form == null ) {
					form = new IGKGM0208Form();
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
					form = (IGKGM0208Form) req.getSession().getAttribute("IGKGM0208Form");
					if (form !=null) {
						form.setFromCount(0);
						form.setKnreject(null);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGKGM0208");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//拆分以空格分割的检索条件:关键字
			if(StringUtils.isNotEmpty(form.getKnkey())){
				form.setKnkeys(form.getKnkey().trim().split(" "));
			}else{
				form.setKnkeys(null);
			}
			
			//拆分以空格分割的检索条件:标题
			if(StringUtils.isNotEmpty(form.getKntitle())){
				form.setKntitles(form.getKntitle().trim().split(" "));
			}else{
				form.setKntitles(null);
			}
			
			// 未审核状态
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);
			//DTO输入参数设定
			dto.setKnowledgeSearchCond(form);
			
			//知识信息检索逻辑调用
			dto = ctlBL.searchKnowLedgeAction(dto);
			
			//将知识类型信息检索结果设定到VO中
			IGKGM02081VO vo = new IGKGM02081VO();
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02081VO>setVO(req, vo);
			if(form.getShowFlag()!=null&&!(form.getShowFlag().equals(""))){
			req.setAttribute("showFlag", form.getShowFlag());
				
			}
			log.debug("========知识审核查询处理终了========");
		} else if ("UPDATE".equals(mapping.getParameter())){
			log.debug("========知识审核通过处理开始========");
			
			
			dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			dto.setKnids(form.getKnids());
			dto.setKnversions(form.getKnversions());
			ctlBL.updateKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0208.I001"));
			log.debug("========知识审核通过处理结束========");	
			return mapping.findForward("DISP");
			
		}else if ("REJECT".equals(mapping.getParameter())){
			log.debug("========知识驳回处理开始========");
			
			dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_REJECT);
			dto.setKnids(form.getKnids());
			dto.setKnrejects(form.getKnrejects());
			dto.setKnversions(form.getKnversions());
			ctlBL.updateKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0208.I002"));
			log.debug("========知识驳回处理结束========");	
			return mapping.findForward("DISP");
			
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
