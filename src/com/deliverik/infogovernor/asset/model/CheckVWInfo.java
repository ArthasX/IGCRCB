/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���ռ��ͳ�Ʋ�ѯ�ӿ� ����飩
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface CheckVWInfo{
	/**
	 * syscodingȡ��
	 * @return syscoding syscoding
	 */
	public String getSyscoding();

	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid();

	/**
	 * ��鷽��ȡ��
	 * @return checkMethod ��鷽��
	 */
	public String getCheckMethod();

	/**
	 * ������Ƶ��ȡ��
	 * @return checkfrequency ������Ƶ��
	 */
	public String getCheckfrequency();
}
