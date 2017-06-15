package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2104Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21041VO;
import com.google.gson.Gson;

/**
 * 预案详细信息登记Action
 *
 * @author
 */
public class IGDRM2104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2104Action.class);

	/**
	 * 预案登记
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
		IGDRM2104Form form = (IGDRM2104Form)actionForm;
		//BL取得
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");
		
		//DTO生成
		IGDRM21DTO dto = new IGDRM21DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		dto.setForm(form);
		//画面跳转设定
		String forward = null;

		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//设备登记画面初期显示处理
			log.debug("========设备登记画面初期显示处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM2104");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM2104Form) req.getSession().getAttribute("IGDRM2104Form");
				if ( form== null){
					form = new IGDRM2104Form();
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
					form = (IGDRM2104Form) req.getSession().getAttribute("IGDRM2104Form");
					clearSessionFormData(req);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGDRM2104");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
        	ctlBL.searchPlan(dto);
        	IGDRM21041VO vo = new IGDRM21041VO();
        	vo.setPlanList(dto.getPlanList());
        	super.<IGDRM21041VO>setVO(req, vo);
        	forward = "DISP";
			log.debug("========设备登记画面初期显示处理终了========");
		} 

		if("INSERT".equals(mapping.getParameter())){
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			ctlBL.savePlanInfo(dto);
	        PrintWriter out = res.getWriter();
	        Gson gson = new Gson();
        	out.write(gson.toJson("保存成功"));
        	out.flush();
            out.close();
            return null;
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
