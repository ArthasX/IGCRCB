/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * �����¼����߳�������HandlerBL
 * </p>
 */
public interface WorkFlowThreadEventHandlerBL extends BaseBL {

	/**
	 * ����״̬���߳��������
	 * 
	 * @param processRecord������Ϣ
	 * @param fpsd����Դ״̬��Ϣ
	 * @param tpsd����ԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid������ɫID
	 */
	public void threadTreatmentExecute(IG500Info processRecord, IG333Info fpsd, IG333Info tpsd, User user, Integer roleid) throws BLException;

}
