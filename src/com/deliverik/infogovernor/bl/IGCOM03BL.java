package com.deliverik.infogovernor.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.FsLvVgTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCondImpl;
import com.deliverik.infogovernor.dto.IGCOM03DTO;

/**
 * ��ѯHELPҵ���߼��ӿ�
 *
 *
 */
public interface IGCOM03BL extends BaseBL {


	/**
	 * �ʲ���Ϣ��ѯ
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchEntityAction(IGCOM03DTO dto) throws BLException;

	/**
	 * �ʲ�����Ϣ��ѯ
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchEntityItemAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * ������ϸ��Ϣ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0303Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * ������ϸ��Ϣ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0328Action(IGCOM03DTO dto) throws BLException;

	/**
	 * ������ϸ��Ϣ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0304Action(IGCOM03DTO dto) throws BLException;

	/**
	 * ������ϸ��Ϣ��ѯ����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchCodeDetailAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ��ϵͼ
	 * </p>
	 * 
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	
	public IGCOM03DTO searchRelationAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ�ʲ�ģ������
	 * </p>
	 * 
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	
	public IGCOM03DTO searchEntityNameAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ�ʲ�ģ������
	 * </p>
	 * 
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	
	public IGCOM03DTO searchEntityNameActionSOC(IGCOM03DTO dto) throws BLException;
	
	/**
	 * �ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	public IGCOM03DTO initIGCOM0307Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0308Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCIM0147Action(IGCOM03DTO dto) throws BLException;
	
//	/**
//	 * ��ϵͼ�鿴��ϵ������ڻ�����
//	 *
//	 * @param dto IGCOM03DTO
//	 * @return IGCOM03DTO
//	 */
//	public IGCOM03DTO initIGCOM0303RelationAction(IGCOM03DTO dto) throws Exception;
	
	/**
	 * ���ݴ�����������ƻ�ȡ�����и�������ȫ��������ɵ������б�
	 * @param srbList
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<LabelValueBean> getParContentList(List<FsLvVgTB> srbList,String name) throws Exception;
	
	/** 
     *  �ʲ���ϵͼ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException 
	 */
	public IGCOM03DTO initIGCOM0314Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * Ӱ�����ͼ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException 
	 */
	public IGCOM03DTO initIGCOM0321Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * ������ͼ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException 
	 */
	public IGCOM03DTO initIGCOM0324Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ʾ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO showConfigAction(IGCOM03DTO dto) throws BLException ;
	
	/**
	 * �ʲ�����Ϣ��ѯ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItemByEiid(IGCOM03DTO dto) throws BLException;    
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0121Info> searchSnapshotRelation(IGCOM03DTO dto)throws BLException;
	
	/**
	 * ��ϵͼ�鿴��ϵ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0319RelationAction(IGCOM03DTO dto) throws Exception;
	
	/**
	 * ��ϵͼ�鿴��ϵ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0320RelationAction(IGCOM03DTO dto) throws Exception;
	
	/**
	 * ��ϵͼ�鿴��ϵ������ڻ�����
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0322RelationAction(IGCOM03DTO dto) throws Exception;
	/**
	 * ����Ӧ��XML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createAppXml(SOC0121SearchCond  cond)throws Exception;
	/**
	 * ����MetaXML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createMetaXml(SOC0121SearchCond  cond,String symid)throws Exception;
	
	/**
	 * ����MetaXML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createXml(SOC0121SearchCond  meta_diskcond,SOC0121SearchCond  storage_Dacond,SOC0121SearchCond host_facond,String strStorageEilabel)throws Exception;

	/**
	 * ����MetaXML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createDiskXml(SOC0121SearchCond  meta_diskcond,SOC0121SearchCond  host_Diskcond,SOC0121SearchCondImpl app_hostcond)throws Exception;
	/**
	 * �ʲ�����Ϣnew��ѯ
	 * 
	 * @param dto
	 *            IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItem0327Action(IGCOM03DTO dto) throws BLException;

	public IGCOM03DTO getEsyscodingList(IGCOM03DTO dto) throws BLException;

	public IGCOM03DTO searchSOC0118(IGCOM03DTO dto) throws BLException;

}
