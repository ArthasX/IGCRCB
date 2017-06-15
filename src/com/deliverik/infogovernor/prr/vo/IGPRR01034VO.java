/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01034VO extends BaseVO implements Serializable {
	
	/** 流程状态信息 */
	protected IG333Info processStatusDef;
	
	/** 可分派角色 */
	private List<IGPRR01035VO> lst_IGPRR01035VO;
	
	/** 主办部门 */
	protected List<LabelValueBean> labelList;
	
	/**
	 * 可分派角色设定
	 * 
	 * @param processStatusDef 流程状态信息
	 * @param map_AssignParticipant 可分派角色集合
	 */
	public IGPRR01034VO(IG333Info processStatusDef, IGPRR01036VO map_AssignParticipant) {
		this.processStatusDef = processStatusDef;
		labelList = new ArrayList<LabelValueBean>();
		if(processStatusDef!=null){
			if(map_AssignParticipant !=null){
				if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(processStatusDef.getPsdassign())){
					Map<Organization, List<UserInfo>> byOrg = map_AssignParticipant.getMap_ParticipantDefToBeAssignByOrg();
					if(byOrg != null){
						Set<Entry<Organization,List<UserInfo>>> set = byOrg.entrySet();
						if(set.size()>0){
							this.lst_IGPRR01035VO = new ArrayList<IGPRR01035VO>();
							labelList.add(new LabelValueBean("", ""));
							Map.Entry<Organization, List<UserInfo>> entry = null;
							for(Iterator<Map.Entry<Organization, List<UserInfo>>> iter = set.iterator();iter.hasNext();){
								entry = iter.next();
								labelList.add(new LabelValueBean(entry.getKey().getOrgname(),processStatusDef.getPsdcode() + "_" + entry.getKey().getOrgsyscoding()));
								IGPRR01035VO vo = new IGPRR01035VO();
								vo.setOrg(entry.getKey());
								vo.setLst_UserInfo(entry.getValue());
								this.lst_IGPRR01035VO.add(vo);
							}
						}
					}
				}else{
					Map<Role, List<UserInfo>> byRole = map_AssignParticipant.getMap_ParticipantDefToBeAssignByRole();
					if(byRole != null){
						Set<Map.Entry<Role, List<UserInfo>>> set = byRole.entrySet();
						if(set.size() > 0) {
							this.lst_IGPRR01035VO = new ArrayList<IGPRR01035VO>();
							labelList.add(new LabelValueBean("", ""));
							Map.Entry<Role, List<UserInfo>> entry = null;
							for(Iterator<Map.Entry<Role, List<UserInfo>>> iter = set.iterator();iter.hasNext();){
								entry = iter.next();
								labelList.add(new LabelValueBean(entry.getKey().getRolename(), processStatusDef.getPsdcode() + "_" + entry.getKey().getRoleid().toString()));
								IGPRR01035VO vo = new IGPRR01035VO();
								vo.setRole(entry.getKey());
								vo.setLst_UserInfo(entry.getValue());
								this.lst_IGPRR01035VO.add(vo);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 流程状态信息取得
	 * 
	 * @return 流程状态信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 可分派角色取得
	 * 
	 * @return 可分派角色
	 */
	public List<IGPRR01035VO> getLst_IGPRR01035VO() {
		return lst_IGPRR01035VO;
	}

	/**
	 * 主办部门取得
	 * 
	 * @return 主办部门
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}
	
	
	
}
