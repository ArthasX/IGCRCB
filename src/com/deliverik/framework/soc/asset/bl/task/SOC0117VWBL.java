package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VW;

/**
 * <p>
 * �ʲ�ģ��ҵ���߼�
 * </p>
 */
public interface SOC0117VWBL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�ģ����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�ģ����Ϣ����ʵ��
	 */

	public SOC0117VW getEntityTBInstance();

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ����
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ����
	 */
	public int getEntitySearchCount(SOC0117VWSearchCond cond);

	/**
	 * �����ʲ�ģ����Ϣ����ȡ���ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ����Ϣ����
	 * @return �ʲ�ģ����Ϣ
	 */
	public SOC0117VWInfo searchEntityByKey(SOC0117VWPK pk) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	public List<SOC0117VWInfo> searchEntity(SOC0117VWSearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	public List<SOC0117VWInfo> searchEntity(SOC0117VWSearchCond cond, int start, int count);

	/**
	 * �����ʲ�ģ����Ϣ����
	 * 
	 * @param entity �ʲ�ģ����Ϣ
	 * @param pareid �ϼ��ʲ�ģ��ID��"0":�����ϼ��ʲ�ģ��Ϊ����㣩
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public SOC0117VWInfo registEntity(SOC0117VWInfo entity,String pareid) throws BLException;

	/**
	 * ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param entity �ʲ�ģ����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteEntity(SOC0117VWInfo entity) throws BLException;

	/**
	 * �����ʲ�ģ����Ϣ����ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param eid ɾ���ʲ�ģ����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityByKey(String eid) throws BLException;

	/**
	 * ����ʲ�ģ����Ϣ����
	 * 
	 * @param entity �ʲ�ģ����Ϣ
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public SOC0117VWInfo updateEntity(SOC0117VWInfo entity) throws BLException;
	
	/**
	 * �����ʲ�ģ��ID��ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ��ID
	 * @return �ϼ��ʲ�ģ����Ϣ�б�
	 * @throws BLException
	 */
	public List<SOC0117VWInfo> getParentNodes(String eid) throws BLException;
	
	/**
	 * �����ʲ�ģ����Ϣ������ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ��ƽ̨������
	 * 
	 * @param esyscoding �ʲ�ģ����Ϣ�����
	 * @return �ϼ��ʲ�ģ����Ϣ�б�
	 */
	public List<SOC0117VWInfo> getParentNodesByEsyscoding(String esyscoding);

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 *  (�����ʲ���Ϣ���������)
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @param orderType ��������б�����ʽ
	 * 		  "assetdomain" : �����ʲ���Ϣ�������������
	 * 
	 * @return �ʲ���Ϣ�б�
	 */
	public List<SOC0117VWInfo> searchEntity(SOC0117VWSearchCond cond, String orderType);
	/**
	 * ��ѯģ�����ʲ�����
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding);

	/**
	 *  ��ȡ�ɵ���һ���ʲ��б�
	 *
	 * @param cond ��ѯ����
	 */
	public List<SOC0117VWInfo> searchEntityForExport(SOC0117VWSearchCond socEntitySearchCond);
	/**
	 * ��ѯģ�����ʲ��������°�Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode);
}
