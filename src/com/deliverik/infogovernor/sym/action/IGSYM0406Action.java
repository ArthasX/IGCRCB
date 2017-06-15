/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0405Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04051VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_根据角色查询用户ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 * @update zhaojun 2010-12-13
 */

public class IGSYM0406Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0406Action.class);
	
	/**
	 * <p>
	 * Description: 用户action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update zhaojun 2010-12-13
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSYM0405Form form = (IGSYM0405Form)actionForm;
		if(form!=null){
			Integer roleid = form.getRoleida();
			Integer count = form.getFromCount();
			String username = form.getUsername();
			String orgida = form.getOrgida();
			String orgname_q = form.getOrgname_q();
			request.getSession().setAttribute("IGSYM0405Form", null);
			form = new IGSYM0405Form();
			form.setRoleida(roleid);
			form.setFromCount(count);
			form.setUsername(username);
			form.setOrgida(orgida);
			form.setOrgname_q(orgname_q);
			request.getSession().setAttribute("IGSYM0405Form", form);
			
		}
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========用户查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========用户查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========用户查询处理开始========");
			dto.setUserInfoSearchCond(form);
			//调用BL查询
			dto = ctlBL.searchRoleUserALL(dto);
			dto = ctlBL.getProcessInfoAll(dto);  //查询用户流程信息
			//取得查询到的用户集合
			List<UserInfo> userList = dto.getRoleUserList();
			//去除页面重复数据开始
			if(!userList.isEmpty()){
				List<UserInfo> newUserList = new ArrayList<UserInfo>();
				Map<String,UserInfo> map= new HashMap<String, UserInfo>();
				for(UserInfo user:userList){
					if(map.containsKey(user.getUserida()) || "admin".equals(user.getUserida())){
						continue;
					}else{
						map.put(user.getUserida(), user);
					}
				}
				for(String key:map.keySet()){
					newUserList.add(map.get(key));
				}
				userList=newUserList;
				dto.setRoleUserList(userList);
			}
			//去除页面重复数据结束
			//取得已选处理用户id集合
			List<String> useridList = (List<String>) request.getSession().getAttribute("AD_hasUser");
			//页面最终显示用户集合
			List<UserInfo> userInfoList = new ArrayList<UserInfo>();
			//遍历集合判断该用户是否存在
			if(useridList!=null&&useridList.size()>0&&userList!=null&&userList.size()>0){
				for (UserInfo userInfo : userList) {
					boolean flag = true;
					for (String userid : useridList) {
						if(userInfo.getUserida().equals(userid)){
							flag = false;
							break;
						}
					}
					//如果不存在，将用户显示到页面，否则，移除该用户
					if(flag){
						userInfoList.add(userInfo);
					}
				}
				dto.setRoleUserList(userInfoList);
			}
			//构造VO
			IGSYM04051VO vo = new IGSYM04051VO(dto.getRoleUserList());
			this.setVoForDto(vo, dto);
			super.<IGSYM04051VO>setVO(request, vo);
			log.debug("========用户查询处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
	/**
	 * <p>
	 * Description: 设置页面显示VO信息
	 * </p>
	 * @return IGSYM04DTO
	 * @author zhaojun@deliverik.com
	 * @update2010-12-13
	 */
	private void setVoForDto(IGSYM04051VO vo,IGSYM04DTO dto){
		List<UserInfo> userInfoList = dto.getRoleUserList();
		List<IGSYM04051VO> voList = new ArrayList<IGSYM04051VO>();
		if(userInfoList != null){
			for(UserInfo urBean:userInfoList){
				List<IG677Info> processInfoList = dto.getProcessRecordInfoList();
				List<IG677Info> meProcessList = new ArrayList<IG677Info>();
				IGSYM04051VO dataVo = new IGSYM04051VO();
				dataVo.setUserida(urBean.getUserida());
				dataVo.setOrgname(urBean.getOrgname());
				dataVo.setUsername(urBean.getUsername());
				dataVo.setUserphone(urBean.getUserphone());
				dataVo.setUsermobile(urBean.getUsermobile());
				dataVo.setUseremail(urBean.getUseremail());
				dataVo.setOrgida(urBean.getOrgida());
				dataVo.setUserstatus(urBean.getUserstatus());
				if(processInfoList!=null){
					for(IG677Info prBean:processInfoList){     //我的工作
						if(urBean.getUserida().equals(prBean.getPpuserid())){
							meProcessList.add(prBean);
						}
					}
				}
				dataVo.setProcessRecordInfoList(meProcessList);
				dataVo.setWorkCount(meProcessList.size());  //我的工作数量
				voList.add(dataVo);
			}
		}
		
		Collections.sort(voList, new Comparator<IGSYM04051VO>(){
			public int compare(IGSYM04051VO o1, IGSYM04051VO o2){ 
				return String.valueOf(o1.getWorkCount()).compareTo(String.valueOf(o2.getWorkCount()));
			}
		});
		
		vo.setDesplayVOList(voList);
	}

}
