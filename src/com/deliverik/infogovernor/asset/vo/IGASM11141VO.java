package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * 机柜平面图画面用ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11141VO extends BaseVO implements Serializable{
	
	/** 机柜信息 */
	protected SOC0603Info computerContainerVWInfo;
	
	protected List<SOC0602Info> computerDeviceVWInfoList;

	/** 设备信息 */
	protected List<IGASM11142VO> rowList;
	

	public List<IGASM11142VO> getRowList() {
		return rowList;
	}

	public void setRowList(List<IGASM11142VO> rowList) {
		this.rowList = rowList;
	}

	/**
	 * 构造函数
	 * @param computerContainerVWInfo　机柜信息
	 * @param computerDeviceVWInfoList　机柜所属设备信息
	 */
	public IGASM11141VO(SOC0603Info computerContainerVWInfo,
			List<SOC0602Info> computerDeviceVWInfoList) {
		this.computerContainerVWInfo = computerContainerVWInfo;
		this.computerDeviceVWInfoList = computerDeviceVWInfoList;
		
		//单元格行列表生成
		rowList = new ArrayList<IGASM11142VO>();
		
		//单元格总行数
		int rows = Integer.parseInt(computerContainerVWInfo.getU_total());
		
		//初期化
		for (int row=0;row<rows;row++ ) {
			IGASM11142VO vo = new  IGASM11142VO();
			vo.setRowNum(rows-row);
			rowList.add(vo);
		}
		
		//机柜设定
		for (SOC0602Info cinfo:computerDeviceVWInfoList) {
			//行宽
			int rowwidth = Integer.parseInt(cinfo.getU_width());
			
			//行号
			int rownum = rows - Integer.parseInt(cinfo.getU_value()) - rowwidth + 1;

			//机柜起始单元格所在行对象取得
			IGASM11142VO rowVO = rowList.get(rownum);
			
			//空格标识设置成FALSE
			rowVO.setSpace(false);
			//机柜信息设定
			rowVO.setEntityData(cinfo);
			
			//纵向宽在1行以上的情况
			if (rowwidth>1) {
				for(int j= 0;j<rowwidth-1;j++){
					//起始行一下的行取得
					IGASM11142VO rVO = rowList.get(rownum+j+1);
					rVO.setOneUnit(false);
					rVO.setSpace(false);
					rVO.setEntityData(cinfo);
				}
			}
		}
	}
	
	/**
	 * 机柜信息取得
	 * @return 机柜信息
	 */
	public SOC0603Info getComputerContainerVWInfo() {
		return computerContainerVWInfo;
	}

	public int getU_total() {
		return Integer.parseInt(computerContainerVWInfo.getU_total());
	}
}


