/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * Ԥ֧����ҵ���߼��ӿ�
 */
public interface AdvanCescostBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AdvanCescostSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param acid Ԥ֧����ID
	 * @return Ԥ֧����ID
	 */
	public AdvanCescost searchAdvanCescostByKey(Integer acid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��Ԥ֧������Ϣ
	 */
	public List<AdvanCescost> searchAdvanCescostAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanCescost> searchAdvanCescost(AdvanCescostSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param AdvanCescost ��¼����
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanCescost registAdvanCescost(AdvanCescost advanCescost) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param acid Ԥ֧����ID
	 * @throws BLException
	 */
	public void deleteAdvanCescost(Integer acid) throws BLException;

	/**
	 * �������
	 * 
	 * @param advanCescost �������
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanCescost updateAdvanCescost(AdvanCescost advanCescost) throws BLException;

}
