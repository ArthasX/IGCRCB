/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0501Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05011VO;


/**
 * 专项预案查询Action
 * @author zyl
 *
 * 2015-2-27 09:31:36
 */
public class IGDRM0501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0501Action.class);

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
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		IGDRM0501Form form = (IGDRM0501Form)actionForm;
		
		//DTO生成
		IGDRM05DTO dto = new IGDRM05DTO();
		dto.setUser(user);
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//获取当前时间
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			
			dto.setIgdrm0501Form(form);
			//初始化专项预案资产新增页面
			ctlBL.init0501Action(dto);
			
			IGDRM05011VO vo = new IGDRM05011VO();
			
			vo.setConfigurationList(dto.getConfigurationList());
			
			vo.setConfigItemList(dto.getConfigItemList());
			if(dto.getEntityItemVW()!=null)
			BeanUtils.copyProperties(dto.getEntityItemVW(), form);
			vo.setEntityItemVW(dto.getEntityItemVW());
			super.<IGDRM05011VO>setVO(req, vo);
			
		}
		//专项预案保存
		if("INSERT".equals(mapping.getParameter())){
			dto.setIgdrm0501Form(form);
			dto.setUser(user);
			//专项预案资产保存操作
			ctlBL.regSpecialPlanResource(dto);
			dto.getMessageList().add(new ActionMessage("IGCO10000.I000","专项预案保存成功!"));
		}
		
		//获取最大编号的Ajax
		if("LABEL".equals(mapping.getParameter())){
			PrintWriter out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(),"UTF-8")); 
			String eid = req.getParameter("eid");
			form.setEid(eid);
			dto.setIgdrm0501Form(form);
			//获取最大编号
			dto = ctlBL.getSpecialPlanMaxNumber(dto);
			if(dto.getMaxSPNumber()!=null&&!"".equals(dto.getMaxSPNumber())){
				//返回编号值
				out.print(dto.getMaxSPNumber());
			}else{
				
				out.print("");
			}
			out.close();
			return null;
		}
		
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========应急资源查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0501");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0501Form) req.getSession().getAttribute("IGDRM0501Form");
				if ( form == null ) {
					form = new IGDRM0501Form();
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
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0501");
			
			dto.setIgdrm0501Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			saveToken(req);
			
			log.debug("========应急资源查询处理终了========");
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
