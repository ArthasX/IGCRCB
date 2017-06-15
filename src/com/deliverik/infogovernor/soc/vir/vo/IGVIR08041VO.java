package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * ������Դͳ�ƽ��	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR08041VO extends BaseVO implements Serializable{
	
	/**
	 * ������Դͳ�ƽ����ĳһ�û���
	 */
	protected List<VIM03Info> oneVim03oList;
	/**
	 * ������Ϣ
	 */
	protected Organization orgbean;
	
	/**
	 * ������Դͳ�ƽ����ĳһ�û���ȡ��
	 * @return oneVim03oList ������Դͳ�ƽ����ĳһ�û���
	 */
	public List<VIM03Info> getOneVim03oList() {
		return oneVim03oList;
	}
	/**
	 * ������Դͳ�ƽ����ĳһ�û����趨
	 * @param oneVim03oList ������Դͳ�ƽ����ĳһ�û���
	 */
	public void setOneVim03oList(List<VIM03Info> oneVim03oList) {
		this.oneVim03oList = oneVim03oList;
	}
	/**
	 * ������Ϣȡ��
	 * @return orgbean ������Ϣ
	 */
	public Organization getOrgbean() {
		return orgbean;
	}
	/**
	 * ������Ϣ�趨
	 * @param orgbean ������Ϣ
	 */
	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}
	
}


