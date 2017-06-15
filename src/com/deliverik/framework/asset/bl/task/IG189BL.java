package com.deliverik.framework.asset.bl.task;


import java.util.List;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;


/**
 * <p>
 * �ʲ�ͳ��ҵ���߼�
 * </p>
 */
public interface IG189BL extends BaseBL{

	/**
	 * ���ݼ�����������ָ���ʲ�ģ���µ��ʲ�����б�
	 * @param cond ��������
	 * @return �ʲ�����б�
	 * @throws BLException
	 */
	public List<IG011Info> searchIG011InfoByEcatory(IG011SearchCond cond) throws BLException;
	
	/**
	 * �豸ͳ�Ʒ�������ƽ̨������
	 * 
	 * @param cond �豸ͳ�Ʒ�����Ϣ��������
	 * @return �豸ͳ�Ʒ������
	 * @throws BLException
	 */
	public List<IG011Info> searchIG011Info(IG011SearchCond cond) throws BLException;

	/**
	 * �豸ͳ�Ʒ�������������ȡ�ã�ƽ̨������
	 * 
	 * @param cond �豸ͳ�Ʒ�����Ϣ��������
	 * @return ����������
	 * @throws BLException
	 */
	public int getIG011InfoSearchCount(IG011SearchCond cond) throws BLException;
	
	/**
	 * �豸ʹ�÷ֲ����ͳ�Ʒ�������ƽ̨������
	 * 
	 * @param cond �豸ʹ�÷ֲ����ͳ�Ʒ�����Ϣ��������
	 * @return �豸ʹ�÷ֲ����ͳ�Ʒ������
	 * @throws BLException
	 */
	public List<IG445Info> searchIG445Info(IG445SearchCond cond) throws BLException;
	
	/**
	 * �豸ʹ�÷ֲ����ͳ�Ʒ�������������ȡ�ã�ƽ̨������
	 * @param cond �豸ʹ�÷ֲ����ͳ�Ʒ�����Ϣ��������
	 * @return �豸ʹ�÷ֲ����ͳ�Ʒ�������������
	 * @throws BLException
	 */
	public int getIG445InfoSearchCount(IG445SearchCond cond) throws BLException;
}
