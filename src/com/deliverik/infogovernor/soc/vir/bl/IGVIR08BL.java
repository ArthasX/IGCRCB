package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR08DTO;

/**
 * ����: ������Դͳ��
 * ��������: ������Դͳ��
 * ������¼: 2014/02/12
 * �޸ļ�¼:
 */
public interface IGVIR08BL extends BaseBL {
	/**
	 * ������Դͳ��(���û�)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByUser(IGVIR08DTO dto) throws BLException;
	/**
	 * ������Դͳ��(���û�)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03ByUser(IGVIR08DTO dto) throws BLException;
	/**
	 * ������Դͳ��(������)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03ByOrg(IGVIR08DTO dto) throws BLException;
	/**
	 * ������Դͳ��(������)
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR08DTO getVim03CountByOrg(IGVIR08DTO dto) throws BLException;
	/**
	 * ������Դͳ��
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03(IGVIR08DTO dto) throws BLException;
	/**
	 * ������Դͳ��(����Ŀ)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByProj(IGVIR08DTO dto) throws BLException;
}
