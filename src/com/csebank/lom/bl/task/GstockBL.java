/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ʒ��Ϣҵ���߼��ӿ�
 */
public interface GstockBL extends BaseBL {
 
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GstockSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param gsid �����ID
	 * @return �����ID
	 */
	public Gstock searchGstockByKey(Integer gsid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ��Ϣ
	 */
	public List<Gstock> searchGstockAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Gstock> searchGstock(GstockSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Goods ��¼����
	 * @return ֵ��������Ϣ
	 */
	public Gstock registGstock(Gstock gStock) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rid �����ID
	 * @throws BLException
	 */
	public void deleteGstock(Integer gsid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ֵ��������Ϣ
	 */
	public Gstock updateGstock(Gstock gStock) throws BLException;

}
