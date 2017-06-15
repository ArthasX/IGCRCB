/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;
import com.deliverik.framework.base.BaseForm;

/**
 * 流程组定义查询画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0303Form extends BaseForm  {

	protected String pgdid;

	/** 名称 */
	protected String pgdname;

	/** 描述 */
	protected String pgddesc;

	/** 状态 */
	protected String pgdstatus;

	/** 流程图xml */
	protected String pgdxml;

	/** 创建时间 */
	protected String pgdcrtime;

	/** 序列号生成处理类 */
	protected String serialGenerator;

	/** 模板类型 */
	protected Integer ptid;
	
	/**单体流程定义ids*/
	protected String[] pdids;
	

	/**
	 * pgdid   取得
	 * @return pgdid pgdid
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * pgdid   设定
	 * @param pgdid pgdid
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * pgdname   取得
	 * @return pgdname pgdname
	 */
	public String getPgdname() {
		return pgdname;
	}

	/**
	 * pgdname   设定
	 * @param pgdname pgdname
	 */
	public void setPgdname(String pgdname) {
		this.pgdname = pgdname;
	}

	/**
	 * pgddesc   取得
	 * @return pgddesc pgddesc
	 */
	public String getPgddesc() {
		return pgddesc;
	}

	/**
	 * pgddesc   设定
	 * @param pgddesc pgddesc
	 */
	public void setPgddesc(String pgddesc) {
		this.pgddesc = pgddesc;
	}

	/**
	 * pgdstatus   取得
	 * @return pgdstatus pgdstatus
	 */
	public String getPgdstatus() {
		return pgdstatus;
	}

	/**
	 * pgdstatus   设定
	 * @param pgdstatus pgdstatus
	 */
	public void setPgdstatus(String pgdstatus) {
		this.pgdstatus = pgdstatus;
	}

	/**
	 * pgdxml   取得
	 * @return pgdxml pgdxml
	 */
	public String getPgdxml() {
		return pgdxml;
	}

	/**
	 * pgdxml   设定
	 * @param pgdxml pgdxml
	 */
	public void setPgdxml(String pgdxml) {
		this.pgdxml = pgdxml;
	}

	/**
	 * pgdcrtime   取得
	 * @return pgdcrtime pgdcrtime
	 */
	public String getPgdcrtime() {
		return pgdcrtime;
	}

	/**
	 * pgdcrtime   设定
	 * @param pgdcrtime pgdcrtime
	 */
	public void setPgdcrtime(String pgdcrtime) {
		this.pgdcrtime = pgdcrtime;
	}

	/**
	 * serialGenerator   取得
	 * @return serialGenerator serialGenerator
	 */
	public String getSerialGenerator() {
		return serialGenerator;
	}

	/**
	 * serialGenerator   设定
	 * @param serialGenerator serialGenerator
	 */
	public void setSerialGenerator(String serialGenerator) {
		this.serialGenerator = serialGenerator;
	}

	/**
	 * ptid   取得
	 * @return ptid ptid
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ptid   设定
	 * @param ptid ptid
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * pdids   取得
	 * @return pdids pdids
	 */
	public String[] getPdids() {
		return pdids;
	}

	/**
	 * pdids   设定
	 * @param pdids pdids
	 */
	public void setPdids(String[] pdids) {
		this.pdids = pdids;
	}

	
	
}
