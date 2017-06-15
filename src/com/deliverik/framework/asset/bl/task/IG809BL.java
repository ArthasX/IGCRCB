/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;


/**
 * �ʲ���ϵͼ�ļ���Ϣҵ���߼��ӿ�ʵ��
 *
 */
public interface IG809BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG809SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param eirfid ����
	 */
	public IG809Info searchIG809InfoByKey(Integer eirfid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ϣ
	 */
	public List<IG809Info> searchIG809InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG809Info> searchIG809Info(IG809SearchCond cond, int start, int count);
	
	/**
	 * ��¼����
	 * 
	 * @param ig809Info ��¼����
	 * @return �ʲ���ϵͼ�ļ���Ϣ
	 */
	public IG809Info registIG809Info(IG809Info ig809Info) throws BLException;


	/**
	 * ɾ������
	 * 
	 * @param eirfid ����
	 */
	public void deleteIG809Info(Integer eirfid) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param ig809Info �ʲ���ϵͼ�ļ���Ϣ
	 */
	public void deleteIG809Info(IG809Info ig809Info) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig809Info �������
	 * @return �ʲ���ϵͼ�ļ���Ϣ
	 */
	public IG809Info updateIG809Info(IG809Info ig809Info) throws BLException;
}
