/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ʒ�������ϸ��Ϣҵ���߼��ӿ�
 */
public interface GinoutstockdetailBL extends BaseBL {

	/**
	 * ������������
	 * 
	 * @param giodid ��Ʒ�������ϸ��ϢID
	 * @return ��Ʒ�������ϸ��ϢID
	 */
	public Ginoutstockdetail searchGinoutstockdetailByKey(Integer giodid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ�������ϸ��Ϣ
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetailAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count);
	public List<GinoutStockDetailVW> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count, String temp);
	/**
	 * ��¼����
	 * 
	 * @param Ginoutstockdetail ��¼����
	 * @return ��Ʒ�������ϸ��Ϣ
	 */
	public Ginoutstockdetail registGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param giodid ��Ʒ�������ϸ��ϢID
	 * @return
	 */
	public void deleteGinoutstockdetail(Integer giodid) throws BLException;

	/**
	 * �������
	 * 
	 * @param Ginoutstockdetail �������
	 * @return ��Ʒ�������ϸ��Ϣ
	 */
	public Ginoutstockdetail updateGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException;
	/**
	 * ʳ����Ʒ������ϸ
	 * 
	 * @param Ginoutstockdetail �������
	 * @return ��Ʒ�������ϸ��Ϣ
	 */
	
	public List<GoutDetailInfo> getGoutDetailInfo(GoutDetailSearchCond cond, int start, int count)throws BLException;
	


}
