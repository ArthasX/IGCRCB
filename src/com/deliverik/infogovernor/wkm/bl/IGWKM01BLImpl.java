/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.wkm.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG108BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0102Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0110Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���˹���ҵ���߼��ӿ�ʵ����
 * </p>
 * 
 * @version 1.0
 */

public class IGWKM01BLImpl implements IGWKM01BL {

	static Log log = LogFactory.getLog(IGWKM01BLImpl.class);
	
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**CodeDetail��ϢBL*/
	protected CodeDetailBL codeDetailBL;
	
	/**�û���ɫ��Ȩ��ϢBL*/
	protected UserRoleBL userRoleBL;
	
	/**��ɫ��Ϣҵ��BL*/
	protected RoleBL roleBL;
	
	/** �������ѯ����BL */
	protected IG108BL ig108BL;

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * CodeDetail��ϢBL�趨
	 *
	 * @param codeDetailBL CodeDetail��ϢBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * �������ѯ����BL�趨
	 * @param ig108bl �������ѯ����bL
	 */
	public void setIg108BL(IG108BL ig108bl) {
		ig108BL = ig108bl;
	}
	

	/**
	 * <p>
	 * Description: �жϵ�ǰ�û��Ƿ������������Ȩ��
	 * </p>
	 * 
	 * @param dto IGWKM01DTO
	 * @return IGWKM01DTO
	 * @throws BLException
	 * @update 
	 */
	public boolean isApproveRole(String userid) throws BLException {
	    
		//����������ʶ 
		boolean approveFlag = false;
		
		// ��ȡ��ǰ�û���ɫ
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(userid);
		
		// �Ե�ǰ�û��Ľ�ɫѭ���ж�
		for(UserRoleInfo uri:userroleList){
			// �ж��û�ʱ���������������ɫ
			if(WorkFlowConstDefine.APPROVE_ROLE_TYPE.equals(uri.getRoletype())){
				approveFlag = true;
				break;
			}
		}
		
		return approveFlag;
	}

	/**
	 * ��ѯ��¼�û��Ƿ��ǹ���ʦ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isEngineerFlag(IGWKM01DTO dto){
		log.debug("========��ѯ��¼�û��Ƿ��ǹ���ʦ����ʼ========");
		
		boolean flag = false;
		
		//��ȡ��¼�û�
		User user = dto.getUser();
		
		UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
		urcond.setRoletype(IGPRDCONSTANTS.ROLETYPE_ENGINEER);
		urcond.setUserid(user.getUserid());
		List<UserRoleInfo> searchUserRoleVW = userRoleBL.searchUserRoleVW(urcond, 0, 5);
		if(searchUserRoleVW != null && searchUserRoleVW.size() > 0){
			flag = true;
		}

		log.debug("========��ѯ��¼�û��Ƿ��ǹ���ʦ�������========");
		return flag;
	}
	
	/**
	 * ��ѯ��¼�û��Ƿ��Ƿ���̨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isServiceDeskFlag(IGWKM01DTO dto){
		log.debug("========��ѯ��¼�û��Ƿ��Ƿ���̨����ʼ========");
		
		boolean flag = false;
		
		//��ȡ��¼�û�
		User user = dto.getUser();
		
		UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
		urcond.setRoletype(IGPRDCONSTANTS.ROLETYPE_SERVICE_DESK);
		urcond.setUserid(user.getUserid());
		List<UserRoleInfo> searchUserRoleVW = userRoleBL.searchUserRoleVW(urcond, 0, 5);
		if(searchUserRoleVW != null && searchUserRoleVW.size() > 0){
			flag = true;
		}
		
		log.debug("========��ѯ��¼�û��Ƿ��Ƿ���̨�������========");
		return flag;
	}
	
	/**
	 * ��ѯ�ͻ������б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<LabelValueBean> getLstClient(IGWKM01DTO dto){
		log.debug("========��ѯ�ͻ������б���ʼ========");
		
		//��¼�����б���
		List<LabelValueBean> lstClient = new ArrayList<LabelValueBean>();
		
		//�ͻ������б��ѯ����
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("PROCESS_CLIENT").getCcid());
		List<CodeDetail> searchCodeDetail = codeDetailBL.searchCodeDetail(cond, 0);
		
		//����ѯ������Ϣ��װ��LabelValueBean����
		for (CodeDetail codeDetail : searchCodeDetail) {
			lstClient.add(new LabelValueBean(codeDetail.getCvalue(),codeDetail.getCdinfo()));
		}
		
		log.debug("========��ѯ�ͻ������б������========");
		return lstClient;
	}
	
	/**
	 * ��ѯ����������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchIGWKM0106Action(IGWKM01DTO dto){
		log.debug("========��ѯ����������Ϣ����ʼ========");
		
		int totalCount = workFlowOperationBL.getProcessRecordSearchCount(dto.getPrSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		//��ҳ��ԃ����������Ϣ
		List<IG500Info> lstProcessRecord = workFlowOperationBL.searchProcessRecord(dto.getPrSearchCond(),
						pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setProcessList(lstProcessRecord);
		
		log.debug("========��ѯ����������Ϣ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ѯ������¼
	 * </p>
	 * 
	 * @param dto IGWKM01DTO
	 * @return IGWKM01DTO
	 * @throws BLException
	 * @update sunkaiyu@deliverik.com
	 */
	
	public IGWKM01DTO getProcessRecords(IGWKM01DTO dto) throws BLException {
		log.debug("========��ѯ������¼����ʼ========");
		// ��ѯ��¼����
		int totalCount = workFlowOperationBL.searchProcessCount(dto.getPrSearchCond(), dto.getType());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			this.getProcessTemplate(dto);
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			this.getProcessTemplate(dto);
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(dto.getPrSearchCond(), pDto.getFromCount(), pDto.getPageDispCount(),dto.getType());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		this.getProcessTemplate(dto);
		log.debug("========��ѯ������¼��������========");
		return dto;
	}

	public IGWKM01DTO getExcel(IGWKM01DTO dto) throws BLException{
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(dto.getPrSearchCond(), 0, 0,dto.getType());
		dto.setProcessList(prList);
		this.getProcessTemplate(dto);
		return dto;
	}
	
	
	private void setDetailURLToDTO(IGWKM01DTO dto) throws BLException{
		Map<String,String> nameURLMap = new HashMap<String,String>();
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(dto.getPrtype());
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = workFlowDefinitionBL.searchProcessTemplate(cond);
		for (IG259Info processTemplate : processTemplateList) {
			nameURLMap.put(processTemplate.getPttype(), processTemplate.getPtdetailpg());
		}
		dto.setNameURLMap(nameURLMap);
	}

	public IGWKM01DTO getProcessTemplate(IGWKM01DTO dto) throws BLException {
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setIsWorkPt(1);
		List<IG259Info> pts = workFlowDefinitionBL.searchProcessTemplate(cond);
		List<IG380Info> pds = new ArrayList<IG380Info>();
		for(IG259Info pt : pts) {
			if(StringUtils.isEmpty(dto.getPrtype()) || "".equals(dto.getPrtype())){
				pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
			}else{
				if(pt.getPttype().equals(dto.getPrtype())){
					pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
				}
			}
		}
		dto.setProcessDefinitionList(pds);
		dto.setProcessTemplateList(pts);
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ɾ�����̼�¼
	 * </p>
	 */
	public IGWKM01DTO delProcessRecord(IGWKM01DTO dto) throws BLException {
		workFlowOperationBL.delProcessRecord(dto.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0201.I001"));
		return dto;
	}
	
	/**
	 * ���̲�ѯJSPȡ��
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGWKM01DTO searchForwardJsp(IGWKM01DTO dto) throws BLException {
		log.debug("========������תJSPҳ���ѯ����ʼ========");
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(dto.getPdid());
		cond.setPdstatus("a");
		List<IG380Info> lst_IG380 = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_IG380 == null || lst_IG380.isEmpty()) {
			//throw new BLException("IGCO10000.E004","���̶������");
		} else {
			String forward = workFlowOperationBL.searchForwardJsp(lst_IG380.get(lst_IG380.size() - 1).getPdid(), null,
					IGPRDCONSTANTS.SEARCHJSP, dto.getUser());
			dto.setForwardJsp(forward);
		}
		log.debug("========������תJSPҳ���ѯ�������========");
		return dto;
	}

	/**
	 * ��ȡ���̱������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getPivarQueryInfoAction(IGWKM01DTO dto) throws BLException {
		log.debug("=================��ȡ�������ѯ����������ʼ=================");
		//ҳ����Ϣȡ��
		IGWKM0101Form form = dto.getIgwkm0101From();
		List<IG108Info> piqueryList = this.ig108BL.findBypdid(form.getPrpdid());
		if(piqueryList != null){
			Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
			for(IG108Info pq:piqueryList){
				IG007TB pid = pq.getPidTB();
				map.put(pid.getPidname(), pid);
			}
			dto.setProcessInfoQueryMap(map);
		}
		log.debug("=================��ȡ�������ѯ������������=================");
		return dto;
	}
	
	/**
	 * ��ȡ���е�ǰ�����˵ı��¹���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getCurrentManagerAction(IGWKM01DTO dto)
			throws BLException {
        log.debug("========��ѯ���е�ǰ�����˵ı��¹�������ʼ========");
        IGWKM0102Form form = dto.getIgwkm0102From();
		// ��ǰ�û�id
		String userid = dto.getUser().getUserid();
		// ��ȡ��ǰ�û���ɫ
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(userid);
		String[] roleid=null;
		if(userroleList!=null&&userroleList.size()>0){			
			roleid = new String[userroleList.size()];
			//����ǰ��¼�ߵ����н�ɫ�����������ŵ�һ��������
			int index=0;
			for(UserRoleInfo info:userroleList){
				roleid[index]=String.valueOf(info.getRoleid());
				index++;
			}
		}
		//ʵ������ѯ����
		CurrentMonthWorkVWSearchCondImpl cond = new CurrentMonthWorkVWSearchCondImpl();	
		cond.setMonth(IGStringUtils.getCurrentDate().substring(0, 7));
		cond.setRoleid(roleid);
		if(StringUtils.isNotEmpty(form.getOrder())){			
			cond.setOrder(form.getOrder());
			cond.setSing(form.getSing());
		}
		int totalCount = workFlowOperationBL.SearchCurrentWorkWithManageCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			this.getProcessTemplate(dto);
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			this.getProcessTemplate(dto);
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<CurrentMonthWorkVWInfo> cmList = workFlowOperationBL.SearchCurrentWorkWithManage(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setCurrentManagerList(cmList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		this.getProcessTemplate(dto);							
		log.debug("========��ѯ���е�ǰ�����˵ı��¹�����������========");
		return dto;
	}

	/**
	 * ���ݲ˵���ʶ��ȡ�˵�����
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGWKM01DTO dto) throws BLException {
		log.debug("========���ݲ˵���ʶ��ȡ�˵�����ȡ�ô���ʼ========");
        //��ȡ��¼�˿ɼ��˵�����
		UserPermission userPermission = dto.getUserPermission();
		
		String titlename = "�¼�";
		
		//��ȡ�˵���ʶ
		String actname = dto.getActname();
		//��ȡ�˵��ϼ���ʶ
		String actname_m1 = "";
		String actname_m2 = "";
		//����ȡ�Ĳ˵���ʶ�������˵�ʱ
		if(StringUtils.isNotEmpty(actname) && actname.length() > 10){//start if 1
			//��ȡһ���˵��Ͷ����˵���ʶ
			actname_m1 = actname.substring(0, 8);
			actname_m2 = actname.substring(0, 10);
			//��ȡ�˵�����
			List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = userPermission.getActionList();
			tit: for(Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> map: actionList) {//start for 1
				
				//��ȡһ���˵�
				Set<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> set_m1 = map.entrySet();
				for(Iterator<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> iter_m1 = set_m1.iterator();
					iter_m1.hasNext();){//start for 2
					
					//�ҵ���Ӧ��һ���˵�
					Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> next_m1 = iter_m1.next();
					if(actname_m1.equals(next_m1.getKey().getActname())){//start if 2
						
						//��¼�����˵���ϢList
						List<Map<Action, List<Map<Action, List<Action>>>>> list_m2 = next_m1.getValue();
						for (Map<Action, List<Map<Action, List<Action>>>> map_m2 : list_m2) {//start for 3
							
							//��ȡ�����˵�
							Set<Entry<Action, List<Map<Action, List<Action>>>>> set_m2 = map_m2.entrySet();
							for(Iterator<Entry<Action, List<Map<Action, List<Action>>>>> iter_m2 = set_m2.iterator();
								iter_m2.hasNext();){//start for 4
								
								//�ҵ���Ӧ�Ķ����˵�
								Entry<Action, List<Map<Action, List<Action>>>> next_m2 = iter_m2.next();
								if(actname_m2.equals(next_m2.getKey().getActname())){ //start if 3
									
									//��¼�����˵���ϢList
									List<Map<Action, List<Action>>> list_m3 = next_m2.getValue();
									for (Map<Action, List<Action>> map_m3 : list_m3) {//start for 5
										
										//��ȡ�����˵�
										Set<Entry<Action, List<Action>>> set_m3 = map_m3.entrySet();
										for(Iterator<Entry<Action, List<Action>>> iter_m3= set_m3.iterator();
											iter_m3.hasNext();){//start for 6
											
											//�ҵ���Ӧ�������˵�
											Entry<Action, List<Action>> next_m3 = iter_m3.next();
											//�ҵ���Ӧ�������˵�
											if(actname.equals(next_m3.getKey().getActname())){
												titlename = next_m3.getKey().getActlabel();
												break tit;
											}
										}//end for 6
									}//end for 5
								}//end if 3
							}//end for 4
						}//end for 3
					}//end if 2
				}//end for 2
			}//end for 1
		}//end if 1
		
        log.debug("========���ݲ˵���ʶ��ȡ�˵�����ȡ�ô�������========");
		return titlename;
	}
	
	/**
	 * ����PDID��ȡ���õ�����PDID
	 */
	public IGWKM01DTO searchPdid7BitAction(IGWKM01DTO dto) throws BLException {
		log.debug("========��ǰ�����������ð汾��PDIDȡ�ô���ʼ========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like(dto.getPdid());
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = workFlowDefinitionBL.searchProcessDefinition(condImpl);
        if (ig380infoList.size() == 0) {
            //throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(ig380infoList.size() - 1).getPdid());
          //��ѯ�����̶����µ���������״̬
            IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
            ig333Cond.setPdid(dto.getPdid());
            List<IG333Info> ig333Infos = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
            dto.setIG333InfoList(ig333Infos);
        }
        log.debug("========��ǰ�����������ð汾��PDIDȡ�ô�������========");
		return dto;
	}
	
    
    /**
	 * ���̲�ѯ����
	 * @param dto 
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchProcessRecordAction(IGWKM01DTO dto) throws BLException{
		log.debug("===========���̲�ѯ������ʼ=============");
		//dto����ȡ��
		IGWKM0110Form form = dto.getIgwkm0110Form();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		try {
			BeanUtils.copyProperties(cond,form);
		} catch (Exception e) {
			log.error("",e);
		}
		// ��ѯ��¼����
		int totalCount = workFlowOperationBL.searchProcessCount(cond, form.getType());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(cond, pDto.getFromCount(), pDto.getPageDispCount(),form.getType());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("===========���̲�ѯ��������=============");
		return dto;
	}

}