/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_���ݽ�ɫ��ѯ�û�ACTION
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
	 * Description: �û�action����
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
		//ʵ����FORM
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
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�û���ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�û���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========�û���ѯ����ʼ========");
			dto.setUserInfoSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.searchRoleUserALL(dto);
			dto = ctlBL.getProcessInfoAll(dto);  //��ѯ�û�������Ϣ
			//ȡ�ò�ѯ�����û�����
			List<UserInfo> userList = dto.getRoleUserList();
			//ȥ��ҳ���ظ����ݿ�ʼ
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
			//ȥ��ҳ���ظ����ݽ���
			//ȡ����ѡ�����û�id����
			List<String> useridList = (List<String>) request.getSession().getAttribute("AD_hasUser");
			//ҳ��������ʾ�û�����
			List<UserInfo> userInfoList = new ArrayList<UserInfo>();
			//���������жϸ��û��Ƿ����
			if(useridList!=null&&useridList.size()>0&&userList!=null&&userList.size()>0){
				for (UserInfo userInfo : userList) {
					boolean flag = true;
					for (String userid : useridList) {
						if(userInfo.getUserida().equals(userid)){
							flag = false;
							break;
						}
					}
					//��������ڣ����û���ʾ��ҳ�棬�����Ƴ����û�
					if(flag){
						userInfoList.add(userInfo);
					}
				}
				dto.setRoleUserList(userInfoList);
			}
			//����VO
			IGSYM04051VO vo = new IGSYM04051VO(dto.getRoleUserList());
			this.setVoForDto(vo, dto);
			super.<IGSYM04051VO>setVO(request, vo);
			log.debug("========�û���ѯ��������========");
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
	 * Description: ����ҳ����ʾVO��Ϣ
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
					for(IG677Info prBean:processInfoList){     //�ҵĹ���
						if(urBean.getUserida().equals(prBean.getPpuserid())){
							meProcessList.add(prBean);
						}
					}
				}
				dataVo.setProcessRecordInfoList(meProcessList);
				dataVo.setWorkCount(meProcessList.size());  //�ҵĹ�������
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
