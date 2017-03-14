/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.dto.IGCIC02DTO;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ա�����ҵ���߼�ʵ��
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public interface IGCIC02BL extends BaseBL {

    /**
     * ��ѯ�ȶ�ִ�����
     * 
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO searchCompareProcessAction(IGCIC02DTO dto) throws BLException;
	
    /**
     * �ȶ�����鿴ҳ�� 
     * 
     * @param dto
     * @return
     */
    public IGCIC02DTO compareResultViewAction(IGCIC02DTO dto) throws BLException;
    
    /**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public IGCIC02DTO searchObjectCompareresult(IGCIC02DTO dto) throws BLException;
    
    /**
     * ȡ�ñȽ϶����ļ�·��
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getCompareObjectFilepath(IGCIC02DTO dto) throws BLException;
    
    /**
     * ִ�бȶ�����
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO executeCompareTask(IGCIC02DTO dto) throws BLException;
    /**
     * ��ȡ����ͼ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getTreeView(IGCIC02DTO dto) throws BLException ;
    
    /**
     * ��������ģ��id �ͶԱȹ���id ��ȡ�ԱȽ��
     * @param dto
     * @return
     * @throws BLException
     */
    public List<CompareresultVWInfo> getDetailByEentity(String eid,Integer cpid) throws BLException;
}
