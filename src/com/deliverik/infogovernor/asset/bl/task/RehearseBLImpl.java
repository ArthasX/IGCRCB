/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.dao.RehearseDAO;




/**
  * ����: ��ɫ��֯�ܹ���ϵ��ҵ���߼�ʵ��
  * ��������: ��ɫ��֯�ܹ���ϵ��ҵ���߼�ʵ��
  * ������¼: 2014/06/16
  * �޸ļ�¼: 
  */
public class RehearseBLImpl extends BaseBLImpl implements RehearseBL {

	/** ��ɫ��֯�ܹ���ϵ��DAO�ӿ� */
	protected RehearseDAO rehearseDAO;
	

	public void setRehearseDAO(RehearseDAO rehearseDAO) {
		this.rehearseDAO = rehearseDAO;
	}


}