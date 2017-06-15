/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * �����¼����߳�������HandlerBL
 * </p>
 */
public abstract class WorkFlowThreadEventHandlerBLImpl extends BaseBLImpl
		implements WorkFlowThreadEventHandlerBL, Runnable  {
	
	static Log log = LogFactory.getLog(WorkFlowThreadEventHandlerBLImpl.class);

	/** ���̻�����Ϣ*/
	protected IG500Info processRecord;

	/** Դ״̬��Ϣ */
	protected IG333Info fpsd;

	/** ԾǨ״̬��Ϣ */
	protected IG333Info tpsd;
	
	/** ��¼�û���Ϣ */
	protected User user;
	
	/** ������ɫID */
	protected Integer roleid;

	/**
	 * �߳��������
	 */
	public void run() {
		try {
			this.threadTreatmentExecute(processRecord, fpsd, tpsd, user, roleid);
		} catch (BLException e) {
			log.error("���̣�" + processRecord.getPrpdid() + processRecord.getPrpdname() 
					+ ")�ģ�" + fpsd.getPsdname()+ "��״̬���߳���������ʧ�ܡ�");
		}
	}

	/**
	 * ��ʼ��
	 * @param processRecord���̻�����Ϣ
	 * @param fpsdԴ״̬��Ϣ
	 * @param tpsdԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid������ɫID
	 */
	public void init(IG500Info processRecord, IG333Info fpsd,
			IG333Info tpsd, User user, Integer roleid) {
		this.processRecord = processRecord;
		this.fpsd = fpsd;
		this.tpsd = tpsd;
		this.user = user;
		this.roleid = roleid;
	}

}
 