package com.deliverik.infogovernor.wki.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dbm.bl.IGDBM13BLImpl;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.wki.bl.task.WorkinfoBL;
import com.deliverik.infogovernor.wki.dto.IGWKI01DTO;
import com.deliverik.infogovernor.wki.form.IGWKI0101Form;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCondImpl;

public class IGWKI01BLImpl extends BaseBLImpl implements IGWKI01BL {

	static Log log = LogFactory.getLog(IGWKI01BLImpl.class);

	public WorkinfoBL workinfoBL;

	public IGWKI01DTO searchWorkInfos(IGWKI01DTO dto) throws BLException {
		log.debug("======查询工作信息======");
		IGWKI0101Form form = dto.getIgwki0101Form();
		WorkinfoSearchCondImpl cond = new WorkinfoSearchCondImpl();
		copyProperties(cond, form);
		int totalCount = workinfoBL.getSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页Bean
		PagingDTO pDto = dto.getPagingDto();
		List<WorkinfoInfo> wkiList = workinfoBL.searchWorkinfo(cond,
				pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setWkiList(wkiList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	public IGWKI01DTO addWorkInfos(IGWKI01DTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public IGWKI01DTO updateWorkInfos(IGWKI01DTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setWorkinfoBL(WorkinfoBL workinfoBL) {
		this.workinfoBL = workinfoBL;
	}

}
