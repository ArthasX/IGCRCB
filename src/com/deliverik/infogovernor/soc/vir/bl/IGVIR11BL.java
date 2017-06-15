package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR11DTO;

/**
 * ����: ������Դͳ��
 * ��������: ������Դͳ��
 * ������¼: 2014/02/12
 * �޸ļ�¼:
 */
public interface IGVIR11BL extends BaseBL {
	/**
	 * ������Դͳ��(���û�)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR11DTO getVim03CountByUser(IGVIR11DTO dto) throws BLException;
	/**
	 * ������Դͳ��(���û�)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR11DTO searchVim03ByUser(IGVIR11DTO dto) throws BLException;
	/**
	 * ������Դͳ��(������)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR11DTO searchVim03ByOrg(IGVIR11DTO dto) throws BLException;
	/**
	 * ������Դͳ��(������)
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR11DTO getVim03CountByOrg(IGVIR11DTO dto) throws BLException;
	/**
	 * ������Դͳ��
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR11DTO searchVim03(IGVIR11DTO dto) throws BLException;
	/**
	 * ������Դͳ��(����Ŀ)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR11DTO getVim03CountByProj(IGVIR11DTO dto) throws BLException;
}
