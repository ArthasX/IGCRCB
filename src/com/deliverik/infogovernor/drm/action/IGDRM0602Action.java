/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM06BL;
import com.deliverik.infogovernor.drm.dto.IGDRM06DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0602Form;
import com.deliverik.infogovernor.drm.vo.IGDRM06021VO;


/**
 * 演练计划管理Action
 * @author wyw
 * 
 * 2015-2-12 上午9:51:47
 */
public class IGDRM0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0602Action.class);

	/**
	 * 
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
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BL取得
		IGDRM06BL ctlBL = (IGDRM06BL) getBean("igdrm06BL");
		
		IGDRM0602Form form = (IGDRM0602Form)actionForm;
		
		//DTO生成
		IGDRM06DTO dto = new IGDRM06DTO();
		dto.setForm(form);
		dto.setUser(user);
		//画面跳转设定
		String forward = "DISP";

//		if( "DISP".equals(mapping.getParameter())){
//			Calendar cal = Calendar.getInstance();
//			Integer year = cal.get(Calendar.YEAR);
//			req.setAttribute("crttimestart", year);
//			
//		    return mapping.findForward(forward);
//		}
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========演练计划查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0602");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0602Form) req.getSession().getAttribute("IGDRM0602Form");
				if ( form == null ) {
					form = new IGDRM0602Form();
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
//					form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			form.setDid(0);
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0602");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//查询
			dto = ctlBL.searchIGDRM0602Action(dto);
			req.setAttribute("crttimestart", form.getCrttimestart());
			IGDRM06021VO vo = new IGDRM06021VO();
			vo.setSearchDrillplanMap(dto.getSearchDrillplanMap());
			super.<IGDRM06021VO>setVO(req.getSession(), vo);
			log.debug("========演练计划查询处理终了========");
		}
		//送审
		if("TOD".equals(mapping.getParameter())){
		    ctlBL.drillplanToJudgeAction(dto);
		    addMessage(req, new ActionMessage("IGDRM0601.I001", "送审成功！"));
		}
		
		//删除
		if("DELETE".equals(mapping.getParameter())){
//		    if (isTokenValid(req, true)){
		        ctlBL.deleteDrillplanAction(dto);
//		    }else{
//	               addMessage(req, new ActionMessage("IGCO00000.E007"));
//                   return mapping.findForward("/error1");
//		    }
		    addMessage(req, new ActionMessage("IGDRM0601.I001", "删除成功！"));
		}
		
		//审批
		if("JUDGE".equals(mapping.getParameter())){
		    String status=form.getIsthrough();
		    if("F".equals(status)){
		        dto.setJudgeopinion(form.getDopinion());
		    }
		    dto.setJudgestatus(status);
		    ctlBL.drillplanJudgeAction(dto);
		    String message="";
		    if("T".equals(status)){
		        message="审批成功！";
		    }else{
		        message="驳回成功！";
		    }
		    addMessage(req, new ActionMessage("IGDRM0601.I001", message));
		}
		
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
