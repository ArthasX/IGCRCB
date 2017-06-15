/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
  * ����: ��Դ���������Ϣ��ҵ���߼��ӿ�
  * ��������: ��Դ���������Ϣ��ҵ���߼��ӿ�
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public interface VIM03BL extends BaseBL {

	/**
	 * ��Դ���������Ϣ��ʵ��ȡ��
	 *
	 * @return ��Դ���������Ϣ��ʵ��
	 */
	public VIM03TB getVim03TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM03Info> searchVim03();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM03Info searchVim03ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Vim03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM03Info registVim03(VIM03Info instance)
		throws BLException;
	
	/**
     * ������������
     * 
     * @param vim03InfoList
     * @throws BLException
     */
    public void  registVim03All(List<VIM03Info> vim03InfoList) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM03Info updateVim03(VIM03Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim03ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim03(VIM03Info instance)
		throws BLException;
	/**
	 * ��ȡ������ÿ������������
	 * @param sDate
	 * @return List<Object[]> Obj[0]>orgname;Obj[1]>Orgsyscoding;Obj[2]>count;Obj[3]>Month
	 */
	public List<Object[]> getOrgCountByMonth(String sDate) throws BLException;

	/**
     * ��ѯһ�������ڵ���Դ��������
     * 
     * @param sDate
     * @return
     */
    public List<Object[]> getOrgCount(String sDate) throws BLException;
    
    /**
     * ��������ȡ��
     *
     * @param cond ��������
     * @return ��������
     */
    public Integer  getVMCount4HostCountByCond(Vim03SearchCond cond) throws BLException;
    
    /**
     * ��ȡ����������ĸ���
     *
     * @param cond ��������
     * @return ��������б� 0:hostname 1:count
     */
    public List<Object[]> getVMCount4HostByCond(Vim03SearchCond cond, int start, int count) throws BLException;
}