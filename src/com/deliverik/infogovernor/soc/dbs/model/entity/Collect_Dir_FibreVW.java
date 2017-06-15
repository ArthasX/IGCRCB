/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.model.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;

import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_FibreVWInfo;

/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
@javax.persistence.Entity
public class Collect_Dir_FibreVW implements Serializable, Cloneable,Collect_Dir_FibreVWInfo{

	private static final long serialVersionUID = 1L;
	
	
	protected String symtime;
	
	/**
	*  ϵͳʹ����
	*/
	protected BigDecimal sysBusy;

    /**
     * �豸
     * @return
     */
	@Id
	private String director_number;
	
	public String getSymtime() {
		return symtime;
	}
	public void setSymtime(String symtime) {
		this.symtime = symtime;
	}

	public String getDirector_number() {
		return director_number;
	}
	public void setDirector_number(String director_number) {
		this.director_number = director_number;
	}
	public BigDecimal getSysBusy() {
		return sysBusy;
	}
	public void setSysBusy(BigDecimal sysBusy) {
		this.sysBusy = sysBusy;
	}
}

