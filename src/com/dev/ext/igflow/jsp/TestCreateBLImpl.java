/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.jsp;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowJspHandlerBL;

/**
 * <p>
 * ����JSP��תҵ���߼�ʵ��
 * </p>
 */
public class TestCreateBLImpl extends BaseBLImpl implements
		WorkFlowJspHandlerBL {

	/**
	 * ������תJSPȡ��
	 * 
	 * @param pdid���̶���ID
	 * @param prid����ID
	 * @param pjdtypeҳ������
	 * @param user��¼�û���Ϣ
	 * @return JSP·��
	 */
	public String forwardExecute(String pdid, Integer prid, String pjdtype, User user)
			throws BLException {
		return "/prrff/IGPRR0101.jsp";
	}
	

}
