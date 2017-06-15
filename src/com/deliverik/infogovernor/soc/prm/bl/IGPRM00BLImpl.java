/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.bl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.infogovernor.soc.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.soc.srv.bl.IGPROCESSType;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��������ControlBL 
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM00BLImpl extends BaseBLImpl implements IGPRM00BL {
	
	/**
	 * ig259BL�趨
	 *
	 * @param ig259bl ig259BL
	 */
	public void setIg259BL(IG259BL ig259bl) {
		ig259BL = ig259bl;
	}

	/**
	 * ig380BL�趨
	 *
	 * @param ig380bl ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * ig333BL�趨
	 *
	 * @param ig333bl ig333BL
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/**
	 * ig222BL�趨
	 *
	 * @param ig222bl ig222BL
	 */
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}

	static Log log = LogFactory.getLog(IGPRM00BLImpl.class);

	/**����ģ�����*/
	protected IG259BL ig259BL;
	
	/**���̶������*/
	protected IG380BL ig380BL;
	
	/**����״̬*/
	protected IG333BL ig333BL;
	
	/**�Զ������̲�����*/
	protected IG222BL ig222BL;
	
	/**��Ա��ɫ*/
	protected UserRoleBL userRoleBL;
	
	/** ��ɫ���� */
	protected RoleBL roleBL;
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.prm.prmResources");


	/**
	 * ��Ա��ɫ
	 * @param userRoleBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ��ɫ����
	 * @param roleBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * <p>
	 * ��ѯ��������
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchProcessDefinitionAction(IGPRM00DTO dto) throws BLException{
		log.debug("========�������Ͳ�ѯ����ʼ========");
		IG259Info gpt = ig259BL.searchIG259ByPrType(dto.getProcessType());

		String pttype = dto.getProcessType();

		if(IGPROCESSType.INCIDENT_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID;
		}else if(IGPROCESSType.PROBLEM_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD;
		}else if(IGPROCESSType.CHANGE_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD;
		}else if(IGPROCESSType.DEPLOYMENT_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD;
		}else if(IGPROCESSType.SERVICE_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD;
		}

		
		IG259Info spt = ig259BL.searchIG259ByPrType(pttype);
		if(gpt == null){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGPRM00BLImpl.001"));
		}
		Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(gpt.getPtid());
		List<IG380Info> zdyPdList = null;
		if(spt != null){
			String[] pdstatuses = new String[2];
			pdstatuses[0] = "a";
			pdstatuses[1] = "t";
			IG380SearchCondImpl cond = new IG380SearchCondImpl();
			cond.setPtid(spt.getPtid());
			cond.setPdstatuses(pdstatuses);
//			zdyPdList = ig380BL.searchIG380Info(cond);
			zdyPdList = this.ig380BL.findSelfDefinitionByUserIdCom(dto.getUserid(), spt.getPtid(),"a"); //sign1
		}
		if(zdyPdList != null && zdyPdList.size()>0){
			//��Ҫ���й��˽���ptid�ظ������̲��������
			for(IG380Info zdyInfo : zdyPdList){
				if(!pdList.contains(zdyInfo)){
					pdList.add(zdyInfo);
				}
			}
			//pdList.addAll(zdyPdList);
		}else{
			pdList=zdyPdList;
		}
		map.put(gpt, pdList);
		dto.setGpt(gpt);
		dto.setSpt(spt);
		dto.setTemplateDefinitionMap(map);
		log.debug("========�������Ͳ�ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ɿ�ݷ�����������
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	
	public IGPRM00DTO searchQuickProcessDefinitionAction(IGPRM00DTO dto) throws BLException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		log.debug("========�������Ͳ�ѯ����ʼ========");
		
		
		if(StringUtils.isEmpty(dto.getProcessType())) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGPRM00BLImpl.002"));
		} else {
			//��ȡָ���������̿ɿ�ݷ������������
			Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_RELATION_TYPE_" + dto.getProcessType());
			String[] prtypeArray = (String[])type.get(IGPRMCONSTANTS.class);
			

			String flag = "0";
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			IG259SearchCondImpl cond = new IG259SearchCondImpl();
			String[] ptstatuses = new String[2];
			ptstatuses[0] = "a";//����
			ptstatuses[1] = "t";//����
			cond.setPtstatuses(ptstatuses);
			List<IG259Info> ptList = ig259BL.searchIG259Info(cond, 0, 0);
			for(IG259Info pt : ptList){
				for(String prtype : prtypeArray) {
					//�¼�
					if("I".equals(prtype)){
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							IG380SearchCondImpl pscond = new IG380SearchCondImpl();
							pscond.setPdstatuses(ptstatuses);
							pscond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_ID);//�Զ����¼�
							List<IG380Info> pddList = ig380BL.searchIG380Info(pscond);//�Զ����¼�����
							if(!pddList.isEmpty()){	 
								//�ж��Ƿ���Ȩ�޷���
								for(IG380Info pd : pddList){
									IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
									psdcond.setPdid(pd.getPdid());
									psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//����״̬
									List<IG333Info> psdlist = this.ig333BL.searchIG333Info(psdcond);
									//�ж��Ƿ��з���Ȩ��
									for(IG333Info psd : psdlist){
										IG222SearchCondImpl ppdcond = new IG222SearchCondImpl();
										ppdcond.setPsdid(psd.getPsdid());
										List<IG222Info> ppdlist = this.ig222BL.searchIG222Info(ppdcond);
										//�����Ȩ��,�˵��ɼ�
										if(!ppdlist.isEmpty()){
											UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
											urcond.setUserid(dto.getUserid());
											List<UserRole> urlist = this.userRoleBL.searchUserRole(urcond);
											for(IG222Info ppd : ppdlist){
												if("1".equals(flag))
													break;
												for(UserRole ur : urlist){
													if(ppd.getRoleid().equals(ur.getRoleid())){
														pdList.add(pd);
														flag = "1";
														break;
													}
												}
											}
										}
									}
								}
							}
							map.put(pt, pdList);
							break;
						}
					}
					//���
					else if("C".equals(prtype)){
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							IG380SearchCondImpl pscond = new IG380SearchCondImpl();
							pscond.setPdstatuses(ptstatuses);
							pscond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_CD);//�Զ�����
							List<IG380Info> pddList = ig380BL.searchIG380Info(pscond);//�Զ���������
							if(!pddList.isEmpty()){
								//�ж��Ƿ���Ȩ�޷���
								for(IG380Info pd : pddList){
									IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
									psdcond.setPdid(pd.getPdid());
									psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//����״̬
									List<IG333Info> psdlist = this.ig333BL.searchIG333Info(psdcond);
									//�ж��Ƿ��з���Ȩ��
									for(IG333Info psd : psdlist){
										IG222SearchCondImpl ppdcond = new IG222SearchCondImpl();
										ppdcond.setPsdid(psd.getPsdid());
										List<IG222Info> ppdlist = this.ig222BL.searchIG222Info(ppdcond);
										//�����Ȩ��,�˵��ɼ�
										if(!ppdlist.isEmpty()){
											UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
											urcond.setUserid(dto.getUserid());
											List<UserRole> urlist = this.userRoleBL.searchUserRole(urcond);
											for(IG222Info ppd : ppdlist){
												if("1".equals(flag))
													break;
												for(UserRole ur : urlist){
													if(ppd.getRoleid().equals(ur.getRoleid())){
														pdList.add(pd);
														flag = "1";
														break;
													}
												}
											}
										}
									}
								}
							}
							map.put(pt, pdList);
							break;
						}
					}else{
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							map.put(pt, pdList);
							break;
						}
					}
					
				}
			}
			dto.setTemplateDefinitionMap(map);
		}
		log.debug("========�������Ͳ�ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ��������
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionAction(IGPRM00DTO dto) throws BLException{
		log.debug("========�������Ͳ�ѯ����ʼ========");
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setIsWorkPt(1);
		cond.setPtstatus("a");
		cond.setPtqrtzflag(dto.getPtqrtzflag());
		if("svc".equals(dto.getPage()) || "3".equals(dto.getProcessType())){
			//��ȡ��������
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			List<IG259Info> pts = ig259BL.searchIG259Info(cond);
			for(IG259Info pt : pts){
				List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
				map.put(pt, pdList);
			}
			//��ȡ�û����Է�����Զ�������
			IG259Info pt = this.ig259BL.searchIG259ByPrType(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE);
			if (pt != null) {
				List<IG380Info> pdList = this.ig380BL.findSelfDefinitionByUserId(dto.getUserid(),"a");//sign1
				map.put(pt, pdList);
			}
			dto.setTemplateDefinitionMap(map);
		}
		
		//�ճ���ά�ƻ���������ԵǼǣ���ֻ��������ɫ�ɼ�ָ�ɲ˵�
		else if("4".equals(dto.getProcessType())){
			//��ȡ���˹�������
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			List<IG259Info> pts = ig259BL.searchIG259Info(cond);
			for(IG259Info pt : pts){
				List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
				map.put(pt, pdList);
			}
			//�ж��û��Ƿ�ӵ��������ɫ
			UserRoleSearchCondImpl ucond = new UserRoleSearchCondImpl();
			ucond.setUserid(dto.getUserid());
			List<UserRole> ulist = this.userRoleBL.searchUserRole(ucond);
			List<Role> roleList = roleBL.getApproveRoles();
			for(Role r : roleList){
				//��ǰ�û�ӵ��������ɫ
				for(UserRole ur : ulist){
					if(ur.getRoleid().equals(r.getRoleid())){
						IG259Info pt = this.ig259BL.searchIG259ByPrType(IGPROCESSType.NEW_WORK_PRTYPE_1);
						if (pt != null) {
							List<IG380Info> pdList = this.ig380BL.searchIG380InfoByPtid(pt.getPtid());
							map.put(pt, pdList);
						}
						break;
					}
				}
			}
			dto.setTemplateDefinitionMap(map);
		}
		
		else{
			//��ȡ��������
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			List<IG259Info> pts = new ArrayList<IG259Info>();
			List<IG259Info> ptsTemp = ig259BL.searchIG259Info(cond);
			boolean approveFlag = false;
			if("0".equals(dto.getProcessType())){
				for(int i=0; i<ptsTemp.size(); i++){
					if("WB".equals(ptsTemp.get(i).getPttype())){
						pts.add(ptsTemp.get(i));
						break;
					}
					
				}
				for(IG259Info pt : pts){
					List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
					map.put(pt, pdList);
				}
			}else if("1".equals(dto.getProcessType())){
				//�ж��û��Ƿ�ӵ��������ɫ
				UserRoleSearchCondImpl ucond = new UserRoleSearchCondImpl();
				ucond.setUserid(dto.getUserid());
				List<UserRole> ulist = this.userRoleBL.searchUserRole(ucond);
				List<Role> roleList = roleBL.getApproveRoles();
				for(Role r : roleList){
					//��ǰ�û�ӵ��������ɫ
					for(UserRole ur : ulist){
						if(ur.getRoleid().equals(r.getRoleid())){
							approveFlag = true;
							break;
						}
					}
				}
				
				
				for(int i=0; i<ptsTemp.size(); i++){
					if("WA".equals(ptsTemp.get(i).getPttype())){
						pts.add(ptsTemp.get(i));
						break;
					}
				}
				for(IG259Info pt : pts){
					if(approveFlag){
						List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
						map.put(pt, pdList);
						
					}else{
						map.put(pt, new ArrayList<IG380Info>());
					}
				}
			}
			/** �޸�Ϊһ�����,���ָ��˹�������ָ�ɹ���,�����ܷ�ָ�ɹ���ʱ,���ܷ����˹��� **/
			if ("5".equals(dto.getProcessType())) {
				// �ж��û��Ƿ�ӵ��������ɫ
				UserRoleSearchCondImpl ucond = new UserRoleSearchCondImpl();
				ucond.setUserid(dto.getUserid());
				List<UserRole> ulist = this.userRoleBL.searchUserRole(ucond);
				List<Role> roleList = roleBL.getApproveRoles();
				for (Role r : roleList) {
					// ��ǰ�û�ӵ��������ɫ
					for (UserRole ur : ulist) {
						if (ur.getRoleid().equals(r.getRoleid())) {
							approveFlag = true;
							break;
						}
					}
				}
				if (approveFlag) {
					for (IG259Info pt : ptsTemp) {
						if ("WA".equals(pt.getPttype())) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							map.put(pt, pdList);
						}
					}
				} else {
					for (IG259Info pt : ptsTemp) {
						if ("WB".equals(pt.getPttype())) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							map.put(pt, pdList);
						}
					}
				}
			}
			/** �޸�Ϊһ�����,���ָ��˹�������ָ�ɹ���,�����ܷ�ָ�ɹ���ʱ,���ܷ����˹��� **/
			//��ȡ�û����Է�����Զ�������
			if("2".equals(dto.getProcessType())){
				IG259Info pt = this.ig259BL.searchIG259ByPrType(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE);
				if (pt != null) {
					List<IG380Info> pdList = this.ig380BL.findSelfDefinitionByUserId(dto.getUserid(),"a");//sign1
					map.put(pt, pdList);
				}
			}
			dto.setTemplateDefinitionMap(map);
		}
		log.debug("========�������Ͳ�ѯ�������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * ��ѯ��������
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionTreeAction(IGPRM00DTO dto) throws BLException{
		log.debug("========�������Ͳ�ѯ����ʼ========");
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setIsWorkPt(1);
		cond.setPtstatus("a");
		List<IG259Info> pts = ig259BL.searchIG259Info(cond);
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		for(IG259Info pt : pts){
			TreeNode ptNode = new TreeNode();
			ptNode.setId(pt.getPtid()+"");
			ptNode.setName(pt.getPtname());
			ptNode.setRemark(pt.getPtstartpg());
			ptNode.setBelong("0");
			getChildTreeNodeMap(pt.getPtid(),ptNode,pt.getPtstartpg());
			treeNodeMap.put(ptNode.getId(),ptNode);
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========�������Ͳ�ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�������̶���
	 * </p>
	 * 
	 * @param processTemplateId ����ģ��id
	 * @param ptNode ģ��ڵ�
	 * @param ptstartpg ����ҳurl
	 */
	private void getChildTreeNodeMap(Integer processTemplateId,TreeNode ptNode,String ptstartpg){
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(processTemplateId);
		for(IG380Info pd : pdList){
			TreeNode pdNode = new TreeNode();
			pdNode.setId(pd.getPdid()+"");
			pdNode.setName(pd.getPdname());
			pdNode.setRemark(ptstartpg);
			pdNode.setBelong("1");
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}
	}


}

