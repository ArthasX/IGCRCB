/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;

/**
 * ����: ���̲����趨��Ϣҵ���߼��ӿ�
 * �������������̲����趨��Ϣҵ���߼��ӿ�
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public interface IG105BL extends BaseBL {
	
	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond��������
	 * @return ���������������
	 */
	public int getSearchCount(IG105SearchCond cond);

	/**
	 * ���ܣ�������������
	 * 
	 * @param pk ���̲����趨��Ϣ����
	 * @return ���̲����趨��Ϣ
	 */
	public IG105Info searchIG105InfoByKey(IG105PK pk) throws BLException;
	
	/**
	 * ���ܣ�ȫ����������
	 *
	 * @return ȫ�����̲����趨��Ϣ
	 */
	public List<IG105Info> searchIG105InfoAll();

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG105Info> searchIG105Info(IG105SearchCond cond, int start, int count);

	/**
	 * ���ܣ���¼����
	 * 
	 * @param ig105Info ��¼����
	 * @return ���̲����趨��Ϣ
	 */
	public IG105Info registIG105Info(IG105Info ig105Info) throws BLException;

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param pk ���̲����趨��Ϣ����
	 */
	public void deleteIG105Info(IG105PK pk) throws BLException;

	/**
	 * ���ܣ��������
	 * 
	 * @param ig105Info �������
	 * @return ���̲����趨��Ϣ
	 */
	public IG105Info updateIG105Info(IG105Info ig105Info) throws BLException;
	
	/**
	 * ���ܣ���ȡָ�����̶���ID��ǰ�������汾��
	 * @param pdid���̶���ID
	 * @return ��ǰ�������汾��
	 */
	public Integer getMaxgPsdversion(String pdid);
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG105Info> searchIG105Info(IG105SearchCond cond);

}
