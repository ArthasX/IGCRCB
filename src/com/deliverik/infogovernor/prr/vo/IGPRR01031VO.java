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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01031VO extends BaseVO implements Serializable {
	
	/** ��ɫ���� */
	private List<Role> roleList;
	
	/** �ɷ��ɽ�ɫ */
	private List<IGPRR01032VO> lst_IGPRR01032VO;
	
	/** ���첿�� */
	protected List<LabelValueBean> labelList;
	
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
	public List<IGPRR01032VO> getLst_IGPRR01032VO() {
		return lst_IGPRR01032VO;
	}

	/**
	 * �ɷ��ɽ�ɫ�趨
	 * 
	 * @param lst_IGPRR01032VO �ɷ��ɽ�ɫ
	 */
	public void setLst_IGPRR01032VO(Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign) {
		labelList = new ArrayList<LabelValueBean>();
		if(map_ParticipantDefToBeAssign != null) {
			Set<Map.Entry<Role, List<UserRoleInfo>>> set = map_ParticipantDefToBeAssign.entrySet();
			if(set.size() > 0) {
				this.lst_IGPRR01032VO = new ArrayList<IGPRR01032VO>();
				labelList.add(new LabelValueBean("", ""));
				Map.Entry<Role, List<UserRoleInfo>> entry = null;
				for(Iterator<Map.Entry<Role, List<UserRoleInfo>>> iter = set.iterator();iter.hasNext();){
					entry = iter.next();
					labelList.add(new LabelValueBean(entry.getKey().getRolename(),entry.getKey().getRoleid().toString()));
					this.lst_IGPRR01032VO.add(new IGPRR01032VO(entry.getKey(), entry.getValue()));
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

}
