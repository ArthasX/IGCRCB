/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0407Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04071VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_值班负责人ACTION
 * </p>
 * 
 * @version 1.0
 */
 
public class IGSYM0409Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0409Action.class);
	
	/**
	 * <p>
	 * Description: 角色负责人action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//实例化FORM
		IGSYM0407Form form = (IGSYM0407Form)actionForm;
		
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		
		dto.setUserRoleVWSearchCond(form);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========值班人查询画面初期显示处理开始========");
			//调用BL查询
			dto = ctlBL.searchRoleManagerAction(dto);
			
			//初始化复选框
			Map<Integer, UserInfo> userInfoMap = dto.getUserInfoMap();
			if(userInfoMap != null) {
				List<String> uridList = new ArrayList<String>();
				Set<Map.Entry<Integer, UserInfo>> set = userInfoMap.entrySet();
				for(Iterator<Map.Entry<Integer, UserInfo>> iter = set.iterator();iter.hasNext();){
					Map.Entry<Integer, UserInfo> entry = iter.next();
					//值班人
					if("1".equals(entry.getValue().getDutyflag())) {
						uridList.add(entry.getKey().toString());
					}
				}
				if(!uridList.isEmpty()) {
					String[] uridArray = new String[uridList.size()];
					for(int i = 0; i < uridList.size(); i++) {
						uridArray[i] = uridList.get(i);
					}
					form.setUrids(uridArray);
					//form.setHasWatchManager("1");
				}
			}
			//构造VO
			IGSYM04071VO vo = new IGSYM04071VO(dto.getUserInfoMap());	
			super.<IGSYM04071VO>setVO(request, vo);
			log.debug("========值班人查询画面初期显示处理终了========");
		} else if( "SAVE".equals(mapping.getParameter())){
			log.debug("========设置值班人处理开始========");
			dto = ctlBL.searchRoleManagerAction(dto);
			boolean saveOrnotsave = true;
			//角色负责人不能和值班人不能为同一人判断
			Map<Integer, UserInfo> userInfoMap = dto.getUserInfoMap();
			if(userInfoMap != null) {
				List<String> uridList = new ArrayList<String>();
				Set<Map.Entry<Integer, UserInfo>> set = userInfoMap.entrySet();
				for(Iterator<Map.Entry<Integer, UserInfo>> iter = set.iterator();iter.hasNext();){
					Map.Entry<Integer, UserInfo> entry = iter.next();
					//值班人
					if("1".equals(entry.getValue().getRolemanager())) {
						uridList.add(entry.getKey().toString());
					}
				}
				if(!uridList.isEmpty() && form.getUrids()!=null){
					String userids[] = form.getUrids();
					for(int i=0;i<userids.length;i++){
						for(int j=0;j<uridList.size();j++){
							if(userids[i].equals(uridList.get(j).toString())){
								addMessage(request,new ActionMessage("IGSYM0407.E001"));
								saveOrnotsave = false;
								break;
							}
						}
					}
				}
				
			}
			dto.setUrid(form.getUrids());
			dto.setUserRoleSearchCond(form);
			//调用BL查询
			if(saveOrnotsave){
			dto = ctlBL.saveDutyflagAction(dto);
			}
			//构造VO
			IGSYM04071VO vo = new IGSYM04071VO(dto.getUserInfoMap());	
			super.<IGSYM04071VO>setVO(request, vo);
			log.debug("========设置值班人处理终了========");
		}	
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
