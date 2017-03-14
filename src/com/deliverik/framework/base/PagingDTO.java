package com.deliverik.framework.base;

import java.io.Serializable;

/**
 *
 */
@SuppressWarnings("serial")
public class PagingDTO implements Serializable {

	protected int fromCount;

	protected int pageDispCount;

	protected int totalCount;

	protected String actionPath;

	/**
	 *
	 * @param actionPath    
	 * @param fromCount     
	 * @param pageDispCount 
	 * @param totalCount   
	 */
	public PagingDTO(String actionPath, int fromCount, int pageDispCount, int totalCount) {
		super();
		this.actionPath=actionPath;
		this.fromCount = fromCount;
		this.pageDispCount = pageDispCount;
		this.totalCount = totalCount;
	}

	/**
	 * 
	 * @return from
	 */
	public int getFromCount() {
	    return fromCount;
	}

	/**
	 * 
	 * @return 
	 */
	public int getPageDispCount() {
	    return pageDispCount;
	}

	/**
	 * 
	 * @param pageDispCount 
	 */
	public void setPageDispCount(int pageDispCount) {
	    this.pageDispCount = pageDispCount;
	}

	/**
	 * 
	 * @return 
	 */
	public int getTotalCount() {
	    return totalCount;
	}

	/**
	 * 
	 * @return 
	 */
	public int getViewStartCount() {
	    return fromCount+1;
	}

	/**
	 * 
	 * @return 
	 */
	public int getViewCount() {
	    return fromCount + pageDispCount;
	}

	/**
	 * 
	 * @return 
	 */
	public int getTotalPage() {
		if(totalCount%pageDispCount == 0)
			return totalCount/pageDispCount;
		else
			return (totalCount/pageDispCount) + 1;
	}

	/**
	 * 
	 * @return 
	 */
	public String getNowDispCount(){

		if( getViewPage() == getTotalPage() ){
			// 
			return getViewStartCount() + " - " + getTotalCount();
		} else {
			// 
			return getViewStartCount() + " - " + (getViewStartCount() + getPageDispCount() -1 );
		}

	}

	/**
	 * 
	 * @return 
	 */
	public int getViewPage() {
		return (fromCount/pageDispCount) +1;
	}

	/**
	 * 
	 * @return 
	 */
	public String getActionPath() {
	    return actionPath;
	}

	/**
	 * 
	 * @param totalCount 
	 */
	public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;
	}

	/**
	 * 
	 * @param actionPath 
	 */
	public void setActionPath(String actionPath) {
	    this.actionPath = actionPath;
	}
	
	public void setFromCount(int fromCount) {
		this.fromCount = fromCount;
	}

}


