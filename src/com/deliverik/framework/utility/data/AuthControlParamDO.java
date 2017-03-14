package com.deliverik.framework.utility.data;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * 権限制御XML 制御パラメータデータオブジェクト<br>
 *
 * 画面項目制御機能を利用する際に必要な項目制御XMLの定義内容が<br>
 * 当オブジェクトにマッピングされます。<br>
 * 当オブジェクトは 権限、店舗状態、店舗種類の制御情報の<br>
 * 識別ID、値(定義値)を保有しています。 <br>
 * 当オブジェクトは１制御の定義（最小単位）毎に生成されます。<br>
 *
 * @author eicosha
 */
public class AuthControlParamDO {

	/** id */
	private String id;

	/** value */
	private String value;

	public AuthControlParamDO() {}

	/**
	 * toStringメソッド<BR>
	 * このインスタンスの全ての項目の値を書き出します。
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * idを取得します。
	 * @return id
	 */
	public String getId() {
	    return id;
	}

	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * valueを取得します。
	 * @return value
	 */
	public String getValue() {
	    return value;
	}

	/**
	 * valueを設定します。
	 * @param value value
	 */
	public void setValue(String value) {
	    this.value = value;
	}

}
