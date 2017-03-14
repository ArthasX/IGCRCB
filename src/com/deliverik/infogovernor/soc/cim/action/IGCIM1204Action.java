/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM12BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1204Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM12041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资产配置项信息版本比较ACTION
 * </p>
 * 
 * @author wangxing@deliverik.com
 * @version 1.0
 */

public class IGCIM1204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1204Action.class);


	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//FORM取得
		IGCIM1204Form form = (IGCIM1204Form)actionForm;
		
		// 获取BL接口实例
		IGCIM12BL ctlBL = (IGCIM12BL) getBean("igcim12BL");
		
		// 实例化DTO
		IGCIM12DTO dto = new IGCIM12DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			//资产配置项信息版本比较画面初期显示处理
			log.debug("========资产配置项信息版本比较画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgcim1204form(form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//资产配置项信息版本比较画面初期显示逻辑调用
			dto = ctlBL.initIGCIM1204Action(dto);
			
			//将资产配置项信息版本比较检索结果设定到VO中
			IGCIM12041VO vo = new IGCIM12041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemList());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGCIM12041VO>setVO(request, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
				
			}
			log.debug("========资产配置项信息版本比较画面初期显示处理终了========");
		}
		return mapping.findForward("DISP");
	}

}
