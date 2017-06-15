/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;

/**
 * @���� �������� BL
 */

public interface IGDBM13BL extends BaseBL {

    /** ����������Ϣ��ѯ
     * @param dto
     */
    public IGDBM13DTO searchWorkmanagerInfos(IGDBM13DTO dto) throws BLException;
    
    /**
     * ����������Ϣ
     */
    public IGDBM13DTO addWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
    /**
     * ���¹�����Ϣ
     */
    public IGDBM13DTO updateWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
	/**
	 * <p>
	 * Description: ������Ϣ�Ǽǳ�ʼ��
	 * </p>
	 */
	public IGDBM13DTO dispWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException;
	
	 /** ������Ϣ����
     * @param dto
     */
    public void copyWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
    /**
     * �༭������Ϣ
     */
    public IGDBM13DTO editWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
    /**
     * ���¹�����Ϣ
     */
    public IGDBM13DTO updateWorkmanager(IGDBM13DTO dto) throws BLException;
    
    /**
     * ���¹�����Ϣ״̬
     */
    public IGDBM13DTO updateWorkmanagerInfoRemind(IGDBM13DTO dto) throws BLException;
    
    /** ����������Ϣ������ѯ
     * @param dto
     */
    public IGDBM13DTO exportWorkmanagerInfos(IGDBM13DTO dto) throws BLException;
    
    /** ��ѯÿ�մ�������
     * @param dto
     */
    public IGDBM13DTO searchDealWorkmanagerInfos(IGDBM13DTO dto) throws BLException;
    
    //����ÿ�ղ�ѯ����������ʱ����
    public void insertEveryDayjob() throws BLException;
    
  //ɾ��ÿ�ղ�ѯ����������ʱ����
    public void delEveryDayjob() throws BLException;
	/**
	 * <p>
	 * Description: ������Ϣ�༭��ʼ��
	 * </p>
	 */
	public IGDBM13DTO editWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException;
}
