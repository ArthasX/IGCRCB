/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 代理工作查询条件实现
 */
public class IG463SearchCondImpl implements IG463SearchCond {
	
	/**授权人ID */
	protected String ppwauthorizeuserid;
	/**代理人id */
	protected String ppwproxyuserid ;
	/**代理人姓名 */
	protected String ppwproxyusername ;
	/**代理人处理时间 到*/
	protected String ppwoptiontime_t;
	/**代理人处理时间 从*/
	protected String ppwoptiontime_f;
	/**关闭标识 */
	protected String ppwcloseflag;
	/**流程id */
	protected Integer ppwprid;
	/**流程编号*/
	protected String ppwprserialnum;
	
	/**
	 * 代理人id取得
	 * 
	 * @return 代理人id
	 */
	public String getPpwproxyuserid() {
		return ppwproxyuserid;
	}
	/**
	 * 代理人id设定
	 *
	 * @param ppwproxyuserid 代理人id
	 */
	public void setPpwproxyuserid(String ppwproxyuserid) {
		this.ppwproxyuserid = ppwproxyuserid;
	}
	/**
	 * 流程id取得
	 * 
	 * @return 流程id
	 */
	public Integer getPpwprid() {
		return ppwprid;
	}
	/**
	 * 流程id设定
	 *
	 * @param ppwprid 流程id
	 */
	public void setPpwprid(Integer ppwprid) {
		this.ppwprid = ppwprid;
	}
	/**
	 * 授权人ID取得
	 * 
	 * @return 授权人ID
	 */
	public String getPpwauthorizeuserid() {
		return ppwauthorizeuserid;
	}
	/**
	 * 授权人ID设定
	 *
	 * @param ppwauthorizeuserid 授权人ID
	 */
	public void setPpwauthorizeuserid(String ppwauthorizeuserid) {
		this.ppwauthorizeuserid = ppwauthorizeuserid;
	}
	/**
	 * 代理人姓名取得
	 * 
	 * @return 代理人姓名
	 */
	public String getPpwproxyusername() {
		return ppwproxyusername;
	}
	/**
	 * 代理人姓名设定
	 *
	 * @param ppwproxyusername 代理人姓名
	 */
	public void setPpwproxyusername(String ppwproxyusername) {
		this.ppwproxyusername = ppwproxyusername;
	}
	/**
	 * 代理人处理时间 到取得
	 * 
	 * @return 代理人处理时间 到
	 */
	public String getPpwoptiontime_t() {
		return ppwoptiontime_t;
	}
	/**
	 * 代理人处理时间 到设定
	 *
	 * @param ppwoptiontime_t 代理人处理时间 到
	 */
	public void setPpwoptiontime_t(String ppwoptiontime_t) {
		this.ppwoptiontime_t = ppwoptiontime_t;
	}
	/**
	 * 代理人处理时间 从取得
	 * 
	 * @return 代理人处理时间 从
	 */
	public String getPpwoptiontime_f() {
		return ppwoptiontime_f;
	}
	/**
	 * 代理人处理时间 从设定
	 *
	 * @param ppwoptiontime_f 代理人处理时间 从
	 */
	public void setPpwoptiontime_f(String ppwoptiontime_f) {
		this.ppwoptiontime_f = ppwoptiontime_f;
	}
	/**
	 * 关闭标识取得
	 * 
	 * @return 关闭标识
	 */
	public String getPpwcloseflag() {
		return ppwcloseflag;
	}
	/**
	 * 关闭标识设定
	 *
	 * @param ppwcloseflag 关闭标识
	 */
	public void setPpwcloseflag(String ppwcloseflag) {
		this.ppwcloseflag = ppwcloseflag;
	}
	
	/**
	 * 流程编号取得
	 * 
	 * @return 流程编号
	 */
	public String getPpwprserialnum() {
		return ppwprserialnum;
	}
	
	/**
	 * 流程编号设定
	 *
	 * @param ppwprserialnum 流程编号
	 */
	public void setPpwprserialnum(String ppwprserialnum) {
		this.ppwprserialnum = ppwprserialnum;
	}
	
	
}
