/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import org.hyperic.hq.hqapi1.types.Group;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��Դ����Ȩ��Ȩ��ѯVO
 * </p>
 * 
 * @author lujiayun 2012/11/19
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04221VO extends BaseVO implements Serializable {

	/**
	 * ����Ȩ��Դ�����List
	 */
	protected List<Group> groupList;
	/**
	 * δ��Ȩ��Դ�����List
	 */
	protected List<Group> groupUnList;
	
	public IGSYM04221VO(List<Group> grantList,List<Group> ungrantList){
		this.groupList = grantList;
		this.groupUnList = ungrantList;
	}

	/**
	 * ����Ȩ��Դ�����Listȡ��
	 *
	 * @return groupList ����Ȩ��Դ�����List
	 */
	public List<Group> getGroupList() {
		return groupList;
	}

	/**
	 * δ��Ȩ��Դ�����Listȡ��
	 *
	 * @return groupUnList δ��Ȩ��Դ�����List
	 */
	public List<Group> getGroupUnList() {
		return groupUnList;
	}
}