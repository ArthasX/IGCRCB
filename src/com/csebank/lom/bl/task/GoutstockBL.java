/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ʒ������Ϣҵ���߼��ӿ�
 */
public interface GoutstockBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GoutstockSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param goid ��Ʒ������ϢID
	 * @return ��Ʒ������ϢID
	 */
	public Goutstock searchGoutstockByKey(Integer goid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ�������ϸ��Ϣ
	 */
	public List<Goutstock> searchGoodsAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Goutstock> searchGoutstock(GoutstockSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Goutstock ��¼����
	 * @return ��Ʒ������Ϣ
	 */
	public Goutstock registGoutstock(Goutstock Goutstock) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param goid ��Ʒ������ϢID
	 * @return
	 */
	public void deleteGoutstock(Integer giodid) throws BLException;

	/**
	 * �������
	 * 
	 * @param Goutstock �������
	 * @return ��Ʒ������Ϣ
	 */
	public Goutstock updateGoods(Goutstock Goutstock) throws BLException;

	

}
