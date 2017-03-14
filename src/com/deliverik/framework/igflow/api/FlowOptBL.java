/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.ProcessGroupInfo;
import com.deliverik.framework.igflow.parameter.ProcessRecordInfo;
import com.deliverik.framework.igflow.parameter.SuspendProcessInfo;

/**
 * ���̴�����API
 */
public interface FlowOptBL extends BaseBL {

	/**
	 * �����鷢��
	 * 
	 * @param processGroupInfo �����鷢����Ϣ
	 * @return ������ID
	 * @throws BLException
	 */
	public Integer initProcessGroupAction(ProcessGroupInfo processGroupInfo) throws BLException;
	
	/**
	 * ���̷���
	 * 
	 * @param processRecordInfo ���̷�����Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer initProcessAction(ProcessRecordInfo processRecordInfo) throws BLException;
	
	
	/**
	 * ���̷���
	 * 
	 * @param processRecordInfo ���̷�����Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer saveProcessAction(ProcessRecordInfo processRecordInfo) throws BLException;
	
	/**
	 * ������ֹ
	 * 
	 * @param suspendProcessInfo ������ֹ��Ϣ
	 * @throws BLException
	 */
	public void suspendProcess(SuspendProcessInfo suspendProcessInfo) throws BLException;
	
	/**
	 * ����ԾǨ
	 * ֻ֧����ͨģʽ�µ���ͨ�ڵ㣬֧�ְ�ťԾǨ���򵫲�֧�ֱ�ԾǨ����
	 * 
	 * @param prid ����ID
	 * @param userid �����û�ID
	 * @param action ��ť����
	 * @param datetime ����ʱ��
	 * @throws BLException
	 */
	public void transitionProcess(Integer prid, String userid, String action, String datetime) throws BLException;

}
