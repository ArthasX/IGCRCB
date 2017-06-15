/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ʒ��Ϣҵ���߼��ӿ�
 */
public interface GoodsBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GoodsSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rid �����ID
	 * @return �����ID
	 */
	public Goods searchGoodsByKey(Integer gid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<Goods> searchGoodsAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Goods> searchGoods(GoodsSearchCond cond, int start, int count);
	public List<Goods> searchGoods(String gcategory);
	/**
	 * ��¼����
	 * 
	 * @param Goods ��¼����
	 * @return ֵ��������Ϣ
	 */
	public Goods registGoods(Goods goods) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rid �����ID
	 * @throws BLException
	 */
	public void deleteGoods(Integer gid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ֵ��������Ϣ
	 */
	public Goods updateGoods(Goods goods) throws BLException;

}
