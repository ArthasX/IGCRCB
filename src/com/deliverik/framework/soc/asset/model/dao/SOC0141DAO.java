package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;

/**
 * �ʲ�����ͼDAO�ӿ�
 * 
 * @author 
 * �޸ļ�¼��2011/7/13 ����IBM�߼�ͼ��ʾ ������
 */
public interface SOC0141DAO extends BaseHibernateDAO<SOC0141VW> {
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0141VW> findByCond(final SOC0121SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0140VW> findDiskByCond(final SOC0121SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<String> findDaByCond(final SOC0121SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<String> findFaByCond(final SOC0121SearchCond cond,final String strStorageEilabel);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SOC0133VW> findSwitchZoneByCond(final SOC0121SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SOC0132VW> findSwitchPortByCond(final SOC0121SearchCond cond);	
    
    /**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0121TB> findSwitchRelationByCond(final SOC0121SearchCond cond1,final SOC0121SearchCond cond2);
	/**
	 * 
	 * @Description: [��ѯ IBM faport]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @param strStorageEilabel
	 * @return List<ShowEntityVW> faport���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMFaportByCond(final SOC0121SearchCond cond,final String strStorageEilabel);
	/**
	 * 
	 * @Description: [��ѯIBM DA SERIAL]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> disk serial���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMDiskSerialByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [��ѯIBM DISK PACK]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> disk pack���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMDiskPackByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [��ѯIBM FA]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> fa���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMFaByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [��ѯIBM DA LOC]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> daloc���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMDaLocByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [��ѯIBM DA PAIR]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> dapair���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMDaPairByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [��ѯIBM DA interface]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> interface���Ե���ʾ����
	 */
	public List<SOC0140VW> findIBMDaInterfaceByCond(final SOC0121SearchCond cond);
	
}
