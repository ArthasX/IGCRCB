/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM11DTO;

/**
 * @���� ȫ��IP���˴���BL
 * @�������� 1.
 * @������¼��2012/11/07
 * @version 1.0
 */

public interface IGDBM11BL extends BaseBL {


    /** IP��Ϣ��ѯ
     * @param dto
     */
    public IGDBM11DTO searchIp_FilterInfo(IGDBM11DTO dto) throws BLException;

    /**
     * ����IP������Ϣ
     * @param dto
     */
    public IGDBM11DTO addIpFilterInfo(IGDBM11DTO dto) throws BLException;

    /**
     * ɾ��IP������Ϣ
     * @param dto
     */
    public IGDBM11DTO delIpFilterInfo(IGDBM11DTO dto) throws BLException;
    
    /**
     * ����ɾ��IP������Ϣ
     * @param dto
     */
    public IGDBM11DTO BatchdelIpFilterInfo(IGDBM11DTO dto) throws BLException;
}
