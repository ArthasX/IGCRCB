/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * ����JSP��תHandlerBL
 * </p>
 */
public interface WorkFlowJspHandlerBL extends BaseBL {

	/**
	 * ������תJSPȡ��
	 * 
	 * @param pdid���̶���ID
	 * @param prid����ID
	 * @param pjdtypeҳ������
	 * @param user��¼�û���Ϣ
	 * @return JSP·��
	 */
	public String forwardExecute(String pdid, Integer prid, String pjdtype, User user) throws BLException;

}
