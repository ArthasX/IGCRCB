/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-02-01
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGASM11201VO extends BaseVO {

	/**3D����֧��IP��ѯ��� */
	List<EquipmentInquireVWInfo> eilist;
	
	/**
	 * 3D����֧��IP��ѯ���ȡ��
	 * @return 3D����֧��IP��ѯ���
	 */
	public List<EquipmentInquireVWInfo> getEilist() {
		return eilist;
	}
	/**
	 * 3D����֧��IP��ѯ����趨
	 *
	 * @param 3D����֧��IP��ѯ���
	 */
	public void setEilist(List<EquipmentInquireVWInfo> eilist) {
		this.eilist = eilist;
	}
}
