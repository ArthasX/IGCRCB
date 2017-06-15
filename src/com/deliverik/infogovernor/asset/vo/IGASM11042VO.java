package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * 机房平面图画面用ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11042VO extends BaseVO implements Serializable{
	
	/** 机房信息 */
	protected List<IGASM11043VO> columnList;
	

	/**
	 * 构造函数
	 * @param computerRoomVWInfo　机房信息
	 * @param computerContainerVWInfoList　机房所属机柜信息
	 */
	public IGASM11042VO(int cols) {
		columnList = new ArrayList<IGASM11043VO>();
		
		for( int col=0;col<cols;col++ ) {
			IGASM11043VO vo = new IGASM11043VO();
			columnList.add(vo);
		}
	}


	public List<IGASM11043VO> getColumnList() {
		return columnList;
	}


	public void setColumnList(List<IGASM11043VO> columnList) {
		this.columnList = columnList;
	}
	
}


