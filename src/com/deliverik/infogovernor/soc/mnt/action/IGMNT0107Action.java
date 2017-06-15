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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.bl.IGMntConstantDefine;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0107Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01071VO;

/**
 * DEBUG监控对象Action处理
 *
 */
public class IGMNT0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMNT0107Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		 //获取菜单权限
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//设置高亮菜单
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT17KGM02");//获取指定菜单ID的ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
			}
		}
		//FORM取得
		IGMNT0107Form ig07form = (IGMNT0107Form)actionForm;
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO生成
		IGMNT01DTO dto = new IGMNT01DTO();
		User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		String mtSsn=(String) req.getParameter("mtSsn");
		dto.setMtSsn(mtSsn);
		if("DISP".equals(mapping.getParameter())){
			//将form放入dto中
			//初始化查询
			ctlBL.searchDebugTaskInitAction(dto);
			saveToken(req);
		}if("INSERT".equals(mapping.getParameter())){
			if(isTokenValid(req, true)){
				dto.setIgmnt0107Form(ig07form);
				ctlBL.insertDebugTaskAction(dto);
				String errFlag=dto.getErrFlag();
				if(errFlag!=null&&!"".equals(errFlag)&&errFlag.equals(IGMntConstantDefine.ERR_FLAG)){
					saveToken(req);
				}
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		IGMNT01071VO igmnt01071vo=new IGMNT01071VO();
		//设置vo
		igmnt01071vo.setSoc0304List(dto.getSoc0304List());
		req.setAttribute("monitorObjectList", dto.getMonitorObjectList());
		igmnt01071vo.setMtSsn(dto.getMtSsn());
		igmnt01071vo.setCheckedCount(dto.getCheckedCount());
		igmnt01071vo.setInterValDefault(dto.getInterValDefault());
		igmnt01071vo.setTmpMtId(dto.getTmpMtId());
		//放入vo
		super.<IGMNT01071VO>setVO(req, igmnt01071vo);
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		String errFlag=dto.getErrFlag();
		if(errFlag!=null&&!"".equals(errFlag)&&errFlag.equals(IGMntConstantDefine.ERR_FLAG)){
			return mapping.findForward("ERR");
		}else{
			return mapping.findForward("DISP");
		}
	}
}
