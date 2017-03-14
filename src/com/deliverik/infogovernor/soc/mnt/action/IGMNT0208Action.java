/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.framework.security.UserPermission;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0206Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02081VO;



/**
 * 概述: 告警日志详细信息画面Action处理
 * 功能描述: 告警日志详细信息显示
 * 创建记录: 2012/02/16
 * 修改记录: 
 */
public class IGMNT0208Action extends BaseAction{
	static Log log=LogFactory.getLog(IGMNT0208Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGMNT0206Form form = (IGMNT0206Form)actionForm;
		//获取BL接口实例
		IGMNT02BL ctlBL = (IGMNT02BL)getBean("igmnt02BL");//
		//实例化DTO
		IGMNT02DTO dto=new IGMNT02DTO();
		//国际化设置
		dto.setLocale(this.getLocale(request));
		//检索条件设置
		dto.setSoc0305SearchCond(form);
		//调用BL查询
		dto = ctlBL.searchSOC0305ByCond(dto);
		//构造VO
		IGMNT02081VO vo = new IGMNT02081VO();
		vo.setSoc0305Info(dto.getSoc0305Info());
		super.<IGMNT02081VO>setVO(request, vo);
		
		//获取菜单权限
		UserPermission perm = (UserPermission)request.getSession().getAttribute("UserPermission");
		
		//设置高亮菜单
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT06MNT0201");//获取指定菜单ID的ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(request, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(request, "secondactid", actsortid.substring(0, 4));
			}
		}
		log.debug("========错误日志查询处理终了========");
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
