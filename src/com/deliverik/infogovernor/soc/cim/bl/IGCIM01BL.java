package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0104Form;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGCIM01BL extends BaseBL {


	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸��Ϣɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemAction(IGCIM01DTO dto) throws BLException;


	/**
	 * �豸������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305Action(IGCIM01DTO dto) throws BLException;

	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306Action(IGCIM01DTO dto) throws BLException;

	/**
	 * �豸��ϵɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationAction(IGCIM01DTO dto) throws BLException;

	/**
	 * �豸��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0307Action(IGCIM01DTO dto) throws BLException;


	/**
	 * �豸�·���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchNewAndReciveEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸�Ͻ���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchUsingEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸������Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchCanScrapEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸�·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸�����·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸�Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGCIM01DTO dto) throws BLException;
	/**
	 * �豸�Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGCIM01DTO dto) throws BLException;
	/**
	 * ��ѯָ��eiid�Ĵ��Ͻ��豸
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityPayByEiidAction(IGCIM01DTO dto) throws BLException;
	
	public IGCIM01DTO searchPreScrapEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	public IGCIM01DTO searchScrapEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	public IGCIM01DTO searchReceiveEntityItemAction(IGCIM01DTO dto) throws BLException;
	public void entityCancelPreScrapBatchAction(IGCIM01DTO dto) throws BLException;
	public void entityPreScrapAction(IGCIM01DTO dto) throws BLException;
	public void entityScrapBatchAction(IGCIM01DTO dto) throws BLException;
	public void entityScrapAction(IGCIM01DTO dto) throws BLException;
	public void entityPreScrapBatchAction(IGCIM01DTO dto) throws BLException;
	
	public void entityCancelPreScrapAction(IGCIM01DTO dto) throws BLException;
	/**
	 *�豸��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initEntityItem(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	��ȡ�豸������ϵ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchRelationListAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸�������ǼǱ༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0317Action(IGCIM01DTO dto) throws BLException;

	/**
	 * ��ȡ�豸������ֵ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemLableAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomain(IGCIM01DTO dto) throws BLException;
	
	/**
	 * ��ȡ��ʷ�汾����ʱ��
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<SOC0128Info> getVersionUpdateTime(String eiid)throws BLException;
	
	/**
	 * ��ʼ���ʲ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO initXMLInfo(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �鿴������Ϣָ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO readXMLNodeInfo(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �Ƚ�2���汾������ϢXML�е�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareXMLInfoByVersion(IGCIM01DTO dto) throws BLException;
	

	/**
	 * �豸������Ϣ�汾�Ƚϻ�����ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305ActionForXML(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸������ϵ������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306BelongAction(IGCIM01DTO dto) throws BLException ;
	
	/**
	 *	��ȡ�豸������ϵ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEiBelongRelationListAction(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * �豸������ϵ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemEiBelongRelationAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸������ϵɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEiBelongRelationAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0346Action(IGCIM01DTO dto) throws BLException ;
	
	
	/**
	 * �豸��ϵ��������ڻ�����(��ʾȫ��������EIΪ��)
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0149Action(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * ������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public IGCIM01DTO getContainTree0149Action(IGCIM01DTO dto) throws BLException;
	/**
	 * �豸������Ϣ�༭����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO editEntityItemAction(IGCIM01DTO dto) throws BLException,
	FileNotFoundException, IOException;
	/**
	 * �������IG�淶��XML�ļ��е�����
	 * @param filepath
	 * @param user
	 */
	public void insertIntoDBFromXMLFirst(IGCIM0104Form form,User user) throws BLException, FileNotFoundException, IOException;
	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGCIM0104Action(IGCIM01DTO dto) throws BLException;

	/**
	 *�豸��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO updateEntityItem(IGCIM01DTO dto)throws BLException;

	/**
	 * 
	 * @return 
	 */
	public IGCIM01DTO insertEntityItemRelationAction(IGCIM01DTO dto) throws BLException;

	/**
	 * 
	 * @return 
	 */
	public IGCIM01DTO updateEntityItemRelationAction(IGCIM01DTO dto);
	
	//add from igasm08bl
	//add from igasm08bl
	//add from igasm08bl
	
	/**
	 * Ӧ����Ϣ��ѯ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * Ӧ����Ϣ�ǼǴ���
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * Ӧ����Ϣɾ������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemActionApp(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ��������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0124Action(IGCIM01DTO dto) throws BLException;
	
	/**
	 * Ӧ��������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0148Action(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO editEntityItemActionApp(IGCIM01DTO dto) throws BLException,
	FileNotFoundException, IOException;
	
	public IGCIM01DTO editIGCIM0148ActionApp(IGCIM01DTO dto) throws BLException, FileNotFoundException, IOException;

	/**
	 * Ӧ��������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0125Action(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ��������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0126Action(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵɾ������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0127Action(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ�ǼǴ���
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ�������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO updateEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	��ȡӦ�ù�����ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchRelationListActionApp(IGCIM01DTO dto) throws BLException;
	

	/**
	 *Ӧ����Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGCIM01DTO initEntityItemApp(IGCIM01DTO dto) throws BLException;
	/**
	 *Ӧ����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGCIM01DTO updateEntityItemApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * ��ȡӦ�ñ�����ֵ
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemLableActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���Ӧ���ʲ������ɫ������
	 * 
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomainApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	��ȡFS������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchFSRelationListAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	����FS������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertFSRelationAction(IGCIM01DTO dto) throws BLException ;
	
	/**
	 *	ɾ��FS������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteFSRelationAction(IGCIM01DTO dto) throws BLException;

	/**
	 * ����Դ���ݰ汾��Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getRciVersionsAction(IGCIM01DTO dto) throws BLException;

	/**
	 * ��ǰ���°汾��Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCurrentNewCriVersionAction(IGCIM01DTO dto) throws BLException;

	/**
	 * ��ǰ�ɼ���Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoList(IGCIM01DTO dto) throws BLException;

	/**
	 * ��ʷ�汾��Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getHostoryVersions(IGCIM01DTO dto) throws BLException;

	/**
	 * ����Դ���ݶ�汾��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareVersionsAction(IGCIM01DTO dto) throws BLException;
	
	
	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGAIM0146Action(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * ������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public IGCIM01DTO getContainTree(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * ��ȡ��ǰĳ�������µ����вɼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoListByCommand(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * ������ϸ�ԱȽ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoListByCommand2(IGCIM01DTO dto) throws BLException;

	public IGCIM01DTO searchIGCIM0135Action(IGCIM01DTO dto)throws BLException;
	public IGCIM01DTO searchIGCIM0139Action(IGCIM01DTO dto) throws BLException ;
	public IGCIM01DTO searchIGCIM0140Action(IGCIM01DTO dto)throws BLException;

	public IGCIM01DTO searchIGCIM0136Action(IGCIM01DTO dto)throws BLException;

	public IGCIM01DTO initIGAIM0137Action(IGCIM01DTO dto)throws BLException;
	
	/**��ʼ����ѯָ��*/
	public IGCIM01DTO initIGCIM0155Action(IGCIM01DTO dto) throws BLException ;

	/**
	 * �������ˣ�Ӧ��ά����ϵ��
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO getBusinessTree(IGCIM01DTO dto) throws BLException;

	/**
	 * �������ˣ�Ӧ�ù�ϵ�Ǽǳ�ʼ��
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO initIGCIM0152Action(IGCIM01DTO dto) throws BLException;

	/**
	 *  �������ˣ�Ӧ�ù�ϵ�ǼǴ���
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp2(IGCIM01DTO dto) throws BLException;

	/**
	 * ��ϵ���Ͳ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO searchRelationType(IGCIM01DTO dto) throws BLException;
	
	/**
	 * ������־��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO searchSoc0153List(IGCIM01DTO dto)throws BLException;
	/**
	 * ��ѯ�����豸�˿�״̬
	 */
	public IGCIM01DTO searchIGCIM0911Action(IGCIM01DTO dto) throws BLException;
	
	
    /**
     *  �ʲ��Զ��屨��������
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO exportReport(IGCIM01DTO dto) throws BLException;
    
    /**
	 * ��ѯ������Ϣ
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO searchSoc0113Info(IGCIM01DTO dto);
	/**
     *  ��ȡresourceid
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getResid(IGCIM01DTO dto) throws BLException;

	public IGCIM01DTO searchSOC0118(IGCIM01DTO dto) throws BLException;
	
    /**
     *  ��ȡ�ʲ��������
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getProcessByEiid(IGCIM01DTO dto) throws BLException;
    
    /**
     *  ��ȡ�ʲ������¼
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getMaintainByEiid(IGCIM01DTO dto) throws BLException;
    
    public IGCIM01DTO searchSOC0118ByHost(IGCIM01DTO dto) throws BLException;
}
