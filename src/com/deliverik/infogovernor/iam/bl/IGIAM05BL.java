/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.iam.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.dto.IGIAM05DTO;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���˹���ҵ���߼��ӿ� 
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public interface IGIAM05BL extends BaseBL {

	public IGWKM01DTO getProcessRecords(IGWKM01DTO dto) throws BLException;
	public IGWKM01DTO getProcessTemplate(IGWKM01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ɾ�����̼�¼
	 * </p>
	 */
	public IGWKM01DTO delProcessRecord(IGWKM01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: �жϵ�ǰ�û��Ƿ������������Ȩ��
	 * </p>
	 * 
	 * @param userid String
	 * @return boolean
	 * @throws BLException
	 * @update 
	 */
	public boolean isApproveRole(String userid) throws BLException;
	
	/**
	 * ��ѯ��¼�û��Ƿ��ǹ���ʦ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isEngineerFlag(IGWKM01DTO dto);
	
	/**
	 * ��ѯ��¼�û��Ƿ��Ƿ���̨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isServiceDeskFlag(IGWKM01DTO dto);
	
	/**
	 * ��ѯ�ͻ������б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<LabelValueBean> getLstClient(IGWKM01DTO dto);
	
	/**
	 * ��ѯ����������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchIGWKM0106Action(IGWKM01DTO dto);
	
	/**
	 * ���̲�ѯJSPȡ��
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGWKM01DTO searchForwardJsp(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ��ȡ���̱������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getPivarQueryInfoAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ��ȡ���е�ǰ�����˵ı��¹���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getCurrentManagerAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ���ݲ˵���ʶ��ȡ�˵�����
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ����PDID��ȡ��ǰ���õ�����PDID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchPdid7BitAction(IGWKM01DTO dto)throws BLException;

	   /**
     * <p>
     * Description: ��ȡ������ʾ״̬������ťȨ�ޣ�
     * </p>
     * 
     * @param dto IGRAM01DTO
     * @return IGRAM01DTO
     * @throws BLException
     * @author
     * @update
     */
    public IGIAM01DTO searchProcessDef(IGIAM01DTO dto)throws BLException;
    /**
     * TODO
     * IGIAM05DTO
     * 20132013-10-31 
     * @param dto
     * @return
     */
    public IGIAM05DTO getProcessRecords(IGIAM05DTO dto)throws BLException;
    
    
    public IGIAM05DTO getProcessTemplate(IGIAM05DTO dto) throws BLException;
}
