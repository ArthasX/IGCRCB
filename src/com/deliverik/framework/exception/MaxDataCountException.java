package com.deliverik.framework.exception;

/**
 * MAX件数オーバー例外クラス<br>
 *
 *
 * @author eicosha
 */
public class MaxDataCountException extends Exception {

	private static final long serialVersionUID = 1L;

	/** 検索結果件数 */
	protected int resultCount;

	/** MAX件数 */
	protected int maxCount;

	/**
	 * コンストラクタ
	 *
	 * @param resultCount 検索結果件数
	 * @param maxCount MAX件数
	 */
	public MaxDataCountException(int resultCount, int maxCount) {
		super();
		this.resultCount = resultCount;
		this.maxCount = maxCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public int getResultCount() {
		return resultCount;
	}

}
