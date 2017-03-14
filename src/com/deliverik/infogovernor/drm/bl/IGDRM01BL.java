package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;


/**
 * �����������ҵ���߼��ӿ�
 *
 *
 */
public interface IGDRM01BL extends BaseBL {
	/**
	 * ��ѯ�ڵ�״̬��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String getStautsInfo(IGDRM01DTO dto) throws BLException;
	/**
	 * ��ѯ�ڵ�״̬��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String getStautsFormLog(IGDRM01DTO dto) throws BLException;
	/**
	 * ��ʼ��ҳ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO initIgdrm0102Action(IGDRM01DTO dto)throws BLException;
	/**
	 * ��ѯ�����ʲ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchPlan(IGDRM01DTO dto)throws BLException;
	/**
	 * ��ѯ�ڵ�״̬��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getOrgInfo(IGDRM01DTO dto) throws BLException;
	/**
	 * ��ѯ״̬��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String getAttKey(IGDRM01DTO dto) throws BLException;
	/**
	 * ��ѯ��������״̬����XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateForm(IGDRM01DTO dto) throws BLException;


	/**
	 * ��ѯӦ���ƶ�ģ����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityTreeForIgdrm0105Action(IGDRM01DTO dto) throws BLException;

	/**
	 * ��ѯӦ���ƶȷ����б�
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityList(IGDRM01DTO dto) throws BLException;

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getScene(IGDRM01DTO dto) throws BLException;
	
	/**
	 * ��ѯ�����е�������ϸ��Ϣ
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO searchFlowDetail(IGDRM01DTO dto) throws BLException;
	
/**
	 * ���ݳ�����ѯ��������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchSenceStrategy(IGDRM01DTO dto) throws BLException;
	/**
	 * ��ѯҵ��ϵͳ
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO switchMaster(IGDRM01DTO dto) throws BLException;
	/**
	 * ��ѯ������������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSenceStrategy(IGDRM01DTO dto) throws BLException;

	/**
	 * ��ѯ������������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO saveSenceStrategy(IGDRM01DTO dto) throws BLException; 
	
	/**
	 * ɾ��������������
	 * @param rsid
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO delSenceStrategy(IGDRM01DTO dto) throws BLException;
	
	/**
	 * ��ѯ���������е�������ϸ��Ϣ
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO searchExportFlowDetail(IGDRM01DTO dto,Integer prid) throws BLException;
	
	/**
	 * ����������Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO exportSenceDetail(IGDRM01DTO dto,Integer prid) throws BLException; 
	
	/**
	 * ��ѯ������Ϣ�洢��form��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSceneByEiid(IGDRM01DTO dto) throws BLException;
}
