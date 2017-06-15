/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;

/**
  * ����: ���չ�ϵ��ҵ���߼��ӿ�
  * ��������: ���չ�ϵ��ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼��2011/7/13 ����IBM�߼�ͼ��ʾ ������
  * �޸ļ�¼: 
  */
public interface SOC0121BL extends BaseBL {

	/**
	 * ���չ�ϵ��ʵ��ȡ��
	 *
	 * @return ���չ�ϵ��ʵ��
	 */
	public SOC0121TB getSnapshotRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0121Info> searchSnapshotRelation();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0121Info searchSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0121SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0121Info registSnapshotRelation(SOC0121Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0121Info updateSnapshotRelation(SOC0121Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSnapshotRelation(SOC0121Info instance)
		throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0141VW> searchSnapshotEntityVW(SOC0121SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0140VW> searchDiskFromSnapshotEntityVW(SOC0121SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchDaFromSnapshotEntityVW(SOC0121SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchFaFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SOC0133VW> searchSwitchZoneByCond(final SOC0121SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SOC0132VW> searchSwitchPortByCond(final SOC0121SearchCond cond);	
    
    /**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0121TB> searchSwitchRelationByCond(SOC0121SearchCond cond1,SOC0121SearchCond cond2);

	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯfaport]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @param strStorageEilabel
	 * @return List<ShowEntityVW>
	 */
	public List<SOC0140VW> searchIBMFaPortFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel);
	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯdiskserial����]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> ���ڸ�����ʾ��faport����
	 */
	public List<SOC0140VW> searchIBMDiskSerialFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯdiskpack����]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> ���ڸ�����ʾ��disk pack����
	 */
	public List<SOC0140VW> searchIBMDiskPackFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯfa����]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> ���ڸ�����ʾ��fa����
	 */
	public List<SOC0140VW> searchIBMFaFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯda loc����]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> ���ڸ�����ʾ��da loc����
	 */
	public List<SOC0140VW> searchIBMDaLocFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯda pair����]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> ���ڸ�����ʾ��da pair����
	 */
	public List<SOC0140VW> searchIBMDaPairFromSnapshotEntityVW(SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [ͨ��������ϵ��ѯda interface����]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> ���ڸ�����ʾ��da interface����
	 */
	public List<SOC0140VW> searchIBMDaInterfaceFromSnapshotEntityVW(SOC0121SearchCond cond);

	/**
	 * ��ͼ�����˹�ϵ
	 * @return
	 */
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation();
	
}