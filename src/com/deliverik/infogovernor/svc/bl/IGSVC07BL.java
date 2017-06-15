package com.deliverik.infogovernor.svc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.dto.IGSVC07DTO;

public interface IGSVC07BL extends BaseBL {
	public IGSVC06DTO findSummaryCountForOperation(IGSVC06DTO dto)
			throws BLException;

	public IGSVC07DTO findSummaryCountForOperationTask(IGSVC07DTO dto)
			throws BLException;

	public IGSVC07DTO findSummaryCountForPerson(IGSVC07DTO dto)
			throws BLException;

	public IGSVC07DTO getOperationById(IGSVC07DTO dto) throws BLException;

	public IGSVC07DTO findSummaryOfYear(IGSVC07DTO dto) throws BLException;

	public IGSVC07DTO findSummaryCountForPersonTask(IGSVC07DTO dto)
			throws BLException;
}
