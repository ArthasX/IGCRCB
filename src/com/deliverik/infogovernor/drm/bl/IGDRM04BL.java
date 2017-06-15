/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;

/**
 * Ӧ���ʲ�����BL
 * 
 * @author �Ž�
 *
 * 2015-2-12 ����11:02:20
 */

public interface IGDRM04BL extends BaseBL {


	/**
	 * ��ʼ��Ӧ���ʲ�����ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO init0401Action(IGDRM04DTO dto) throws BLException;
	/**
	 * Ӧ���ʲ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO regEmergencyResource(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException;
	
	/**
	 * Ӧ���ʲ���ݱ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO regEmergencyResourceShortcut(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException;
	
	/**
	 * ��ȡӦ���ʲ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getLabel(IGDRM04DTO dto)throws BLException;
	/**
	 * Ӧ���ʲ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO searchEmergencyResource(IGDRM04DTO dto)throws BLException;
	/**
	 * Ӧ���ʲ�������Ϣ�༭����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO editEntityItemAction(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException ;
	/**
	 * Ӧ���ʲ�������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGDRM04DTO initIGDRM0404Action(IGDRM04DTO dto) throws BLException ;
	/**
	 * Ӧ���ʲ�ɾ������
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGDRM04DTO deleteEntityItemAction(IGDRM04DTO dto) throws BLException;
	/**
	 * ��ȡӦ���ʲ��и�����ciid
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getArrId(IGDRM04DTO dto)throws BLException;
	
	
	
	//�ʲ�����

	/**
	 * �ʲ���Ϣ��ѯ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * �ʲ���Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertEntityAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * �ʲ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0412Action(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ���Ϣ���´���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateEntityAction(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationAction(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0414Action(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ���´���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateConfigurationAction(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ���ϸ��Ϣ���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0416Action(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ���Ϣɾ������
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteEntityAction(IGDRM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣɾ������
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteConfigurationAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �ʲ�����״̬�仯
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGDRM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �ʲ���������״̬�仯
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGDRM04DTO dto) throws BLException;
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchConfigurationCodeDetailBean(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO searchConfigurationCodeDetail(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO searchCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException;
	/**
	 * �ʲ��������ݵǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationCodeDetailAction(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO getCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO insertCfgCodeDetailAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * ��ѯ���������������񼰷����¼��һ�����ࣨ����EXCELģ��ʹ�ã�
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityActionForExportExcelModel(IGDRM04DTO dto) throws BLException;
	/**
	 * ����Excelģ��
	 * @throws Exception
	 */
	public IGDRM04DTO searchInfoForExportExcel(String esyscode) throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭������ڻ�����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws Exception
	 */
	public IGDRM04DTO initIGDRM0424Action(IGDRM04DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException 
	 */
	public IGDRM04DTO editIGDRM0424Action(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException;;

	/**
	 * ��ѯӦ����Դ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */

		public IGDRM04DTO searchEntityNameActionSOC(IGDRM04DTO dto) throws BLException;
		
		/**
		 * ��ȡӦ����Դ��ϸ��Ϣ
		 * 
		 * @param dto    IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO getEntityFullInfo(IGDRM04DTO dto) throws BLException;
		/**
		 * �ʲ�����Ϣ��ѯ
		 * 
		 * @param dto
		 *            IGDRM07DTO
		 * @return IGDRM07DTO
		 */
		public IGDRM04DTO searchEntityItem0406Action(IGDRM04DTO dto) throws BLException;
		
		/***
		 * ��ѯӦ����Դ�����б�
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGDRM04DTO searchConfigList(IGDRM04DTO dto) throws BLException;
		/**
		 * Ӧ����Դ�ʲ�������ѯ����
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO searchEntityItemAction(IGDRM04DTO dto) throws BLException ;
		/**
		 * Ӧ����Դ�ʲ���������
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO setRelationAction(IGDRM04DTO dto) throws BLException ;
		/**
		 * Ӧ����Դ�ʲ��������������ϵ
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO deleteSigleRelationAction(IGDRM04DTO dto) throws BLException;
		/**
		 * Ӧ����Դ�ʲ��������������ϵ
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO deleteRelationAction(IGDRM04DTO dto) throws BLException;
		/**
		 * ��ʼ����
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGDRM04DTO initNewNodeMap(IGDRM04DTO dto)throws BLException;
		/**
		 * Ӧ����Դ�޸Ķ�Ӧ�ʲ�ģ�ͣ����й��������޸ģ�
		 *
		 * @param erid
		 * @return boolean
		 */
		public boolean searchRelationAjaxAction(Integer erid) throws BLException;
		/**
		 * Ӧ����Դ�ʲ�������ѯ����(��ʼ��)
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO searchEntityDisp(IGDRM04DTO dto) throws BLException;
		/**
		 * Ӧ����Դ�Ǽ�������Ϣ�б�
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 * @throws IOException 
		 */
		public String getConfigList(IGDRM04DTO dto) throws BLException;
		/**
		 * �豸������Ϣ�༭������ڻ�����
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO initIGDRM0430Action(IGDRM04DTO dto) throws BLException ;
		
		/**
		 * ��ȡӦ����Դ��������ʾ����
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGDRM04DTO getTreeNodeNameCountAction(IGDRM04DTO dto) throws BLException;
}
