/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.workItem.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 
 * @Description ������-����ʵ������BL�ӿ� 
 *
 * @date 2017��6��22��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public interface WorkRemindBL extends BaseBL{

	/**
	 * ����ʵ������
	 * @throws BLException
	 */
	public void workInstanceRemind() throws BLException;
}
