/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

import java.util.ArrayList;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0103Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01033VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程分派action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0103Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0103Action.class);
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化dto
		IGPRR01DTO dto = new IGPRR01DTO();
		//form取得
		IGPRR0103Form form = (IGPRR0103Form) actionForm;
		//user对象取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		dto.setAction(form.getAction());
		String prid = request.getAttribute("prid") == null ? null : request.getAttribute("prid").toString();
		if(StringUtils.isNotEmpty(prid)){
			dto.setPrid(Integer.valueOf(prid));
			form.setPrid(Integer.valueOf(prid));
		}else{
			dto.setPrid(form.getPrid());
		}
		dto.setPsdid(form.getPsdid());
		dto.setPdid(form.getPdid());
		String forward = null;
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============分派页面初始化操作开始==============");
			dto = ctlBL.searchAssignParticipantAction(dto);
			 //取得分派的跳转页面
		    dto = ctlBL.getAssignPageAction(dto);
            forward = dto.getAssignPage();
			if(dto.getLst_participant() != null && !dto.getLst_participant().isEmpty()) {
				form.setParticipants(dto.getLst_participant().toArray(new String[0]));
				form.setParticipants_(dto.getLst_participant().toArray(new String[0]));
			} else {
				form.setParticipants(new String[]{""});
				form.setParticipants_(new String[]{""});
			}
			if(dto.getLst_ppsuper() != null && !dto.getLst_ppsuper().isEmpty()) {
				String[] ppuserList = dto.getLst_ppsuper().toArray(new String[0]);
				List<String> urList = new ArrayList<String>();
				
				for(String pu:ppuserList){
					if(StringUtils.isNotEmpty(pu)){
						urList.add(pu);
					}
				}
				if(urList.size()>0){
					form.setPpsupers(urList.toArray(new String[0]));
				}else{
					form.setPpsupers(new String[]{""});
				}
			} else {
				form.setPpsupers(new String[]{""});
			}
			String[] ppusers = form.getParticipants_();
			if(ppusers!=null){
				for(int i=0;i<ppusers.length;i++){
					String ppuser = ppusers[i];
					if(StringUtils.isNotEmpty(ppuser)){
						ppusers[i] = ppuser.split("_")[0]+"_"+ppuser.split("_")[1]+"_";
					}
				}
			}
			form.setParticipants_(ppusers);
			//构造VO
			IGPRR01033VO vo = new IGPRR01033VO(dto.getMap_AssignParticipant());
			super.<IGPRR01033VO>setVO(request.getSession(), vo);
			saveToken(request);
			log.debug("=============分派页面初始化操作结束==============");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(StringUtils.isNotEmpty(forward) && StringUtils.isNotEmpty(forward.trim())){
			return new ActionForward(forward);
		}else{
			return mapping.findForward("DISP");
		}
	}
}
