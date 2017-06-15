package com.deliverik.framework.utility.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 権限制御XML 画面項目データオブジェクト<br>
 *
 * 画面項目制御機能を利用する際に必要な項目制御XMLの定義内容が<br>
 * 当オブジェクトにマッピングされます。<br>
 * 当オブジェクトは 権限、店舗状態、店舗種類の制御情報を含みます。<br>
 * 画面を構成するオブジェクトの構成は以下の通りです。<br>
 * [画面]1-n[項目ブロック]1-n[項目]<br><br>
 * 当オブジェクトは１項目毎に生成されます。<br>
 *
 * @author eicosha
 */
public class AuthControlGuiItemDO {

	/** 画面項目ID */
	private String id;

	/** 制御権限 */
	private List<AuthControlParamDO> rolls;

	/** 店舗状態 */
	private List<AuthControlParamDO> status;

	/** 店舗の種類 */
	private List<AuthControlParamDO> type;

	/**
	 * 権限制御XML 画面項目データオブジェクトコンストラクタ<br>
	 */
	public AuthControlGuiItemDO() {
		rolls = new ArrayList<AuthControlParamDO>();
		status = new ArrayList<AuthControlParamDO>();
		type = new ArrayList<AuthControlParamDO>();
	}

	/**
	 * ロールを追加します。<br>
	 *
	 * @param roll ロールオブジェクト
	 */
	public void addRoll(AuthControlParamDO roll) {
		this.rolls.add(roll);
	}

	/**
	 * 店舗状態を追加します。<br>
	 *
	 * @param status 店舗状態オブジェクト
	 */
	public void addStatus(AuthControlParamDO status) {
		this.status.add(status);
	}

	/**
	 * 店舗種類を追加します。<br>
	 *
	 * @param type 店舗種類オブジェクト
	 */
	public void addType(AuthControlParamDO type) {
		this.type.add(type);
	}

	/**
	 * オブジェクトの内容文字列を追加します。<br>
	 *
	 * @return オブジェクトの内容文字列
	 */
	public String toString() {
		String newline = System.getProperty( "line.separator" );
		StringBuffer buf = new StringBuffer();

		buf.append( "--- Excases ---" ).append(newline);
		for(int i=0; i<rolls.size(); i++){
			buf.append( rolls.get(i) ).append(newline);
		}
		for( int i=0; i<status.size(); i++ ){
			buf.append( status.get(i) ).append(newline);
		}
		for( int i=0; i<type.size(); i++ ){
			buf.append( type.get(i) ).append(newline);
		}
		return buf.toString();
	}

	/**
	 * 画面項目IDを取得します。
	 * @return 画面項目ID
	 */
	public String getId() {
	    return id;
	}

	/**
	 * 画面項目IDを設定します。
	 * @param id 画面項目ID
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * 制御ロールを取得します。
	 * @return 制御ロール
	 */
	public List<AuthControlParamDO> getRolls() {
		 return rolls;
	}

	/**
	 * 店舗状態を取得します。
	 * @return 店舗状態
	 */
	public List<AuthControlParamDO> getStatus() {
		 return status;
	}

	/**
	 * 店舗の種類を取得します。
	 * @return 店舗の種類
	 */
	public List<AuthControlParamDO> getType() {
		 return type;
	}
}
