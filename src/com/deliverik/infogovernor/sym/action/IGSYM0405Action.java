/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 */
 
public class IGSYM0405Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0405Action.class);
	
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
	 * @update
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getParameter("flag")!=null){
			request.getSession().setAttribute("cog", request.getParameter("flag"));
		}
		//ʵ����FORM
		IGSYM0405Form form = (IGSYM0405Form)actionForm;
		if(form!=null){
			Integer roleid = form.getRoleida();
			Integer count = form.getFromCount();
			String username = form.getUsername();
			String orgida = form.getOrgida();
			String orgname = form.getOrgname();
			String roletype = form.getRoletype();
			String from_s = form.getFrom_s();
			String flag = form.getFlag();
			request.getSession().setAttribute("IGSYM0405Form", null);
			form = new IGSYM0405Form();
			form.setRoleida(roleid);
			form.setFromCount(count);
			form.setUsername(username);
			form.setOrgida(orgida);
			form.setOrgname(orgname);
			form.setRoletype(roletype);
			form.setFrom_s(from_s);
			form.setFlag(flag);
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
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0405");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
			int maxCnt = getMaxDataCount("IGSYM0405");
			
			dto.setUserInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			//====================================================>
			if("Y".equals(form.getFrom_s())){//��������ѡ��������ʱ�ĵ������ڡ���Ҫ�����Ŷ���Ա���й���
				User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setOrgid(user.getOrgid());
				dto = ctlBL.searchRoleUserByOrg(dto);
			}else{//�����������߼�����
				dto = ctlBL.searchRoleUser(dto);
			}
			//<===================================================
			dto = ctlBL.getProcessInfoAll(dto);  //��ѯ�û�������Ϣ
			//ȡ�ò�ѯ�����û�����
			List<UserInfo> userList = dto.getRoleUserList();
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
		List<UserInfo>userInfoList = dto.getRoleUserList();
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
