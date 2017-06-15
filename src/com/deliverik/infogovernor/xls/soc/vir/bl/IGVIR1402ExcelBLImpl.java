/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.soc.vir.bl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.xls.soc.vir.dto.IGVIR1402ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源使用情况导出BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1402ExcelBLImpl extends ExcelBaseBLImpl implements IGVIR1402ExcelBL{

	public ExcelDTO initBody(ExcelDTO excelDTO) throws BLException {
		IGVIR1402ExcelDTO dto = (IGVIR1402ExcelDTO) excelDTO;
		dto.setStartRow(2);
		Map<Integer, List<Host>> map = dto.getHostMap();
		if(map != null){
			int i = 0;
			for(Iterator<Entry<Integer, List<Host>>> iter = map.entrySet().iterator();iter.hasNext();){
				Entry<Integer, List<Host>> next = iter.next();
				List<Host> list = next.getValue();
				for(Host host : list){
					addCell(0, i,host.getName());
					addCell(1, i,host.getCpuCores());
					addCell(2, i,host.getMemoryMB() + "MB");
					addCell(3, i,host.getCapacity() + "GB");
					addCell(4, i,host.getCpuUseRate());
					addCell(5, i,host.getMemoryUseRate());
					addCell(6, i,host.getDiskUseRate());
					addCell(7, i,host.getVm_num());
					i++;
				}
			}
		}
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO excelDTO) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO excelDTO) throws BLException {
		return null;
	}

}
