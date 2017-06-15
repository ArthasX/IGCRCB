package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * ����ƽ��ͼ�����ã֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11042VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected List<IGASM11043VO> columnList;
	

	/**
	 * ���캯��
	 * @param computerRoomVWInfo��������Ϣ
	 * @param computerContainerVWInfoList����������������Ϣ
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


