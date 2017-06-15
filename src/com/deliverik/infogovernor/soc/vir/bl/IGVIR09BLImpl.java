package com.deliverik.infogovernor.soc.vir.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM05BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR09DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0901Form;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM05SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM06TB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 虚拟资源计费BL
 * @author wangxing
 * 2014.02.21
 */
public class IGVIR09BLImpl extends BaseBLImpl implements IGVIR09BL {

	
	static Log log = LogFactory.getLog(IGVIR09BLImpl.class);
	
	protected VIM05BL vim05BL;
	
	protected VIM06BL vim06BL;
	
	protected CodeDetailBL codeDetailBL;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public void setVim05BL(VIM05BL vim05BL) {
		this.vim05BL = vim05BL;
	}

	public void setVim06BL(VIM06BL vim06BL) {
		this.vim06BL = vim06BL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public IGVIR09DTO getConfigItemList(IGVIR09DTO dto) throws BLException {
		log.debug("========获取虚拟资源项处理开始========");
		
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.VMBILLINGCI_CCID.getCcid());
		List<CodeDetail> items = codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		dto.setConfigItemList(items);
		
		log.debug("========获取虚拟资源项处理结束========");
		return dto;
	}

	public IGVIR09DTO insertBillingStrategy(IGVIR09DTO dto) throws BLException {
		log.debug("========虚拟资源项计费策略添加处理开始========");
		
		IGVIR0901Form form = dto.getIgvir0901Form();
		VIM05TB strategy = new VIM05TB();
		strategy.setName(form.getStrategyName());
		strategy.setCreatetime(dateFormat.format(new Date()));
		VIM05Info info = vim05BL.registVim05(strategy);
		
		String[] values = form.getValues();
		for(int i=0;i<values.length;i++){
			VIM06TB strategyItem = new VIM06TB();
			Integer price = 0;
			if(StringUtils.isNotEmpty(values[i])) price = Integer.parseInt(values[i]);
			strategyItem.setPrice(price);
			strategyItem.setResourceitem(form.getConfigItemCids()[i]);
			strategyItem.setStrategyid(info.getId());
			vim06BL.registVim06(strategyItem);
		}
		log.debug("========虚拟资源项计费策略添加处理结束========");
		return null;
	}

	public IGVIR09DTO searchBillingStrategy(IGVIR09DTO dto) throws BLException {
		log.debug("========虚拟资源计费策略查询处理开始========");
		
		IGVIR0901Form form = dto.getIgvir0901Form();
		
		List<VIM05Info> results = new ArrayList<VIM05Info>();
		
		VIM05SearchCondImpl cond = new VIM05SearchCondImpl();
		
		cond.setStrategyName_eq(dto.getStrategyName_eq());
		
		int totalcount = vim05BL.getSearchCount(cond);
		
		PagingDTO pDto = dto.getPagingDto();
		
		List<VIM05Info> strategies = vim05BL.searchVim05(cond,pDto.getFromCount(),pDto.getPageDispCount());
		
		for(VIM05Info strategy:strategies){
			VIM06SearchCondImpl vim06Cond = new VIM06SearchCondImpl();
			vim06Cond.setStrategyid_eq(String.valueOf(strategy.getId()));
			List<VIM06Info> list = vim06BL.searchVim06(vim06Cond);
			VIM05TB bean = (VIM05TB)strategy;
			bean.setConfigItemList(list);
			results.add(bean);
		}
		
		pDto.setTotalCount(totalcount);
		
		dto.setStrategies(results);
		
		log.debug("========虚拟资源计费策略查询处理结束========");
		return dto;
	}

	public IGVIR09DTO getBillingStrategyByID(IGVIR09DTO dto) throws BLException {
		
		IGVIR0901Form form = dto.getIgvir0901Form();
		Integer id = form.getStrid();
		VIM05Info info = vim05BL.searchVim05ByPK(id);
		VIM05TB bean = (VIM05TB)info;
		
		VIM06SearchCondImpl vim06Cond = new VIM06SearchCondImpl();
		vim06Cond.setStrategyid_eq(String.valueOf(id));
		List<VIM06Info> list = vim06BL.searchVim06(vim06Cond);
		bean.setConfigItemList(list);
		dto.setStrategyEntity(bean);
		return dto;
	}

	public IGVIR09DTO updateBillingStrategy(IGVIR09DTO dto) throws BLException {
		
		IGVIR0901Form form = dto.getIgvir0901Form();
		Integer id = form.getStrid();
		VIM05Info info = vim05BL.searchVim05ByPK(id);
		VIM05TB bean = (VIM05TB)info;
		bean.setName(form.getStrategyName());
		vim05BL.updateVim05(bean);
		
		VIM06SearchCondImpl vim06Cond = new VIM06SearchCondImpl();
		vim06Cond.setStrategyid_eq(String.valueOf(id));
		List<VIM06Info> list = vim06BL.searchVim06(vim06Cond);
		for(VIM06Info vim06Info:list){
			vim06BL.deleteVim06(vim06Info);
		}
		
		String[] values = form.getValues();
		for(int i=0;i<values.length;i++){
			VIM06TB strategyItem = new VIM06TB();
			Integer price = 0;
			if(StringUtils.isNotEmpty(values[i])) price = Integer.parseInt(values[i]);
			strategyItem.setPrice(price);
			strategyItem.setResourceitem(form.getConfigItemCids()[i]);
			strategyItem.setStrategyid(info.getId());
			vim06BL.registVim06(strategyItem);
		}
		
		return dto;
	}

	public IGVIR09DTO deleteBillingStrategy(IGVIR09DTO dto) throws BLException {
		
		IGVIR0901Form form = dto.getIgvir0901Form();
		
		String[] delids = form.getDelids();
		
		for(String id:delids){
			
			vim05BL.deleteVim05ByPK(Integer.parseInt(id));
			
			VIM06SearchCondImpl vim06Cond = new VIM06SearchCondImpl();
			vim06Cond.setStrategyid_eq(String.valueOf(id));
			List<VIM06Info> list = vim06BL.searchVim06(vim06Cond);
			for(VIM06Info vim06Info:list){
				vim06BL.deleteVim06(vim06Info);
			}
		}
		
		return dto;
	}
	
}
