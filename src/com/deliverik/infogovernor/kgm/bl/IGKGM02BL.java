/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;

/**
 * ����: ֪ʶ����ҵ���߼�BL�ӿ�
 * ����������֪ʶ����ҵ���߼�BL�ӿ�
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public interface IGKGM02BL extends BaseBL {

	
	/**
	 * ֪ʶ���ѯ(������)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowLedgeInfoAction(IGKGM03DTO dto) throws BLException; 
	
	/**
	 * ֪ʶ�Ǽ�
	 */
	public IGKGM03DTO insertAction(IGKGM03DTO dto) throws BLException;
	
	
	/**
	 * ֪ʶ����
	 */
	public IGKGM03DTO insertKnowledgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����(��ѯ)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�����֪ʶ״̬
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateKnowLedgeStatus(IGKGM03DTO dto) throws BLException ;
		
	/**
	 * ֪ʶ����ϸ��ѯ
	 * @param knid
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeDetailAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ֪ʶ���ֱ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeGradeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����(�޸�)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����(������ѯ)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ���¹���(������ѯ)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchUpdateKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ֪ʶ���ֵǼ�
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO registKnowledgeGradeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����(ɾ��)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO deleteKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ��ϸ��Ϣ��ѯ(������ѯ)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeDetailActionbyPK(IGKGM03DTO dto) throws BLException;
	/**
	 * ���ܣ���ѯ�Լ��ύ��֪ʶ
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchMyKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ���ѯ�Լ��ύ��֪ʶ
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowledgeNotCheckAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ����ҹؼ���
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowledgeKeyAction(IGKGM03DTO dto,CodeDetailBL codeDetailBL) throws BLException;
	
	/**
	 * ���ܣ���ѯ֪ʶ��ʷ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeHistory(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ��鿴֪ʶ���������̺ͷ��񹤵�
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeProcessByKnid(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�ҵ��ϵͳListȡ��
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getSystem_typeList(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����ҵ��ϵͳListȡ��
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����ҵ��ϵͳ��ʼ��ȡ��
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact_Disp(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ���������id������������
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchProcessRecordByKey(IGKGM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ѯ֪ʶ�����˽�ɫ
	 * </p>
	 * @return IGKGM03DTO
	 * @author leexuzhi@deliverik.com
	 */
	public IGKGM03DTO getRoleKnApproveRole(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�����֪ʶ״̬
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateOneKnowLedgeStatus(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ��������
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO exportKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����������ҵ��ϵͳ��ѯ
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public String searchKnowLedgeAppImpactAction(Integer knid, Integer knversion) throws BLException;
	
	/**
	 * ���ܣ�֪ʶ����
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO downKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * ֪ʶ��ϸҳ���ѯ
	 * @param dto
	 * @return ����ֵ0��ʾû��δ�����ġ�֪ʶ���¡����ݡ�1��ʾ�С�
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeNotCheckActionForKGMDis(IGKGM03DTO dto)throws BLException;
	
	/**
	 * ��ȡ֪ʶ�ύ����
	 * @param dto
	 * @return 
	 */
	public IGKGM03DTO getKnowledgeCount(IGKGM03DTO dto) throws BLException;

	/**
	 * 
	 * ֪ʶ����(��ѯ)
	 */
	public IGKGM02DTO searchProcessRecordLogAction(IGKGM02DTO dto) throws BLException;
	
	/**
	 * ֪ʶ��������ͳ��(��ѯ)
	 * @param dto
	 */
	public IGKGM02DTO searchStatisticalKnowledgeContribution(IGKGM02DTO dto) throws BLException;
	
	/**
	 * ��ѯҵ��ϵͳ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM02DTO searchBusinessSystem(IGKGM02DTO dto) throws BLException;
}
