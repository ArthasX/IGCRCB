/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.IG622Info;

/**
 * ����: ��ҳ�����������֣�
 * ������������ҳ�����������֣�
 * ������¼����ѧ־   2012/11/14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM18011VO extends BaseVO implements Serializable{
	
	/** ��ҳ������Ϣ������� */
	protected List<IG622Info> firstJspInfoList;

	/**
	 * ���캯��
	 * @param processDefinition����ҳ������Ϣ�������
	 */
	public IGSYM18011VO(List<IG622Info> firstJspInfoList) {
		this.firstJspInfoList = firstJspInfoList;
	}
	
	
	/**
	 * ��ҳ������Ϣ������� ȡ��
	 * @return the firstJspInfoList
	 */
	public List<IG622Info> getFirstJspInfoList() {
		return firstJspInfoList;
	}

	/**
	 *��ҳ������Ϣ�����������
	 *	
	 * @param firstJspInfoList the firstJspInfoList to set
	 */
	public void setFirstJspInfoList(List<IG622Info> firstJspInfoList) {
		this.firstJspInfoList = firstJspInfoList;
	}

}


