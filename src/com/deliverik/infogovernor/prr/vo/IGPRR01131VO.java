/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01131VO extends BaseVO implements Serializable {
	
	/** ��ɫ���� */
	private List<Role> roleList;
	
	/** �ɷ��ɽ�ɫ */
	private List<IGPRR01132VO> lst_IGPRR01132VO;
	
	/** ���첿�� */
	protected List<LabelValueBean> labelList;
	
	/** �ɷ��ɻ��� */
	protected List<Organization> org_List;
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * ��ɫ�����趨
	 * @param roleList��ɫ����
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * �ɷ��ɽ�ɫȡ��
	 * 
	 * @return �ɷ��ɽ�ɫ
	 */
	public List<IGPRR01132VO> getLst_IGPRR01132VO() {
		return lst_IGPRR01132VO;
	}

	/**
	 * �ɷ��ɽ�ɫ�趨
	 * 
	 * @param lst_IGPRR01132VO �ɷ��ɽ�ɫ
	 */
	public void setLst_IGPRR01132VO(Map<Role, List<IG602Info>> map_ParticipantToBeAssign) {
		labelList = new ArrayList<LabelValueBean>();
		if(map_ParticipantToBeAssign != null) {
			Set<Map.Entry<Role, List<IG602Info>>> set = map_ParticipantToBeAssign.entrySet();
			if(set.size() > 0) {
				this.lst_IGPRR01132VO = new ArrayList<IGPRR01132VO>();
				labelList.add(new LabelValueBean("", ""));
				Map.Entry<Role, List<IG602Info>> entry = null;
				for(Iterator<Map.Entry<Role, List<IG602Info>>> iter = set.iterator();iter.hasNext();){
					entry = iter.next();
					labelList.add(new LabelValueBean(entry.getKey().getRolename(),entry.getKey().getRoleid().toString()));
					this.lst_IGPRR01132VO.add(new IGPRR01132VO(entry.getKey(), entry.getValue()));
				}
			}
		}
	}
	
	/**
	 * ���첿��ȡ��
	 * 
	 * @return ���첿��
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}
	
	/**
	 * ���첿���趨
	 *
	 * @param labelList ���첿��
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}
	
	/**
	 * �ɷ��ɻ���ȡ��
	 * @return �ɷ��ɻ���
	 */
	public List<Organization> getOrg_List() {
		return org_List;
	}

	/**
	 * �ɷ��ɻ����趨
	 * @param org_List �ɷ��ɻ���
	 */
	public void setOrg_List(List<Organization> org_List) {
		this.org_List = org_List;
	}

}
