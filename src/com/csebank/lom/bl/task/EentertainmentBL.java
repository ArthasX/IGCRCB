/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ʳ�ýӴ���Ϣҵ���߼��ӿ�
 */
public interface EentertainmentBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EentertainmentSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param eeid ʳ�ýӴ�ID
	 * @return ʳ�ýӴ�ID
	 */
	public Eentertainment searchEentertainmentByKey(Integer eeid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�ýӴ���Ϣ
	 */
	public List<Eentertainment> searchEentertainmentAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eentertainment> searchEentertainment(EentertainmentSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Eentertainment ��¼����
	 * @return ʳ�ýӴ���Ϣ
	 */
	public Eentertainment registEentertainment(Eentertainment eentertainment) throws BLException;

	/**
	 * �������
	 * 
	 * @param Eentertainment �������
	 * @return ʳ�óɱ���Ϣ
	 */
	public Eentertainment updateEentertainment(Eentertainment eentertainment) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param Eentertainment ɾ������
	 * @return ʳ�ýӴ���Ϣ
	 */
	
	public void deleteEentertainment(Integer eeid) throws BLException;

}
