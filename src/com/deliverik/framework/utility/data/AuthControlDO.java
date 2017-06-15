package com.deliverik.framework.utility.data;
import java.util.ArrayList;
import java.util.List;

/**
 * 項目制御機能XMLデータオブジェクト<br>
 *
 * 画面項目制御機能を利用する際に必要な項目制御XMLの定義内容が<br>
 * 当オブジェクトにマッピングされます。<br>
 * 当オブジェクトは 権限、店舗状態、店舗種類の制御情報を含みます。<br>
 * 当オブジェクトは 画面内の画面ブロックオブジェクトリストを保有しています。<br>
 * 画面を構成するオブジェクトの構成は以下の通りです。<br>
 * [画面]1-n[項目ブロック]1-n[項目]<br><br>
 * 当オブジェクトは１画面単位に生成されます。<br>
 *
 * @author eicosha
 */
public class AuthControlDO {

	/** 画面項目ID */
	private String gui_id;

	/** 制御権限 */
	private List<AuthControlParamDO> rolls;

	/** 店舗状態 */
	private List<AuthControlParamDO> status;

	/** 店舗の種類 */
	private List<AuthControlParamDO> type;

	/** 画面ブロック */
	private List<AuthControlGuiBlockDO> gui_blocks;

	/**
	 * 項目制御機能XMLデータオブジェクトコンストラクタ<br>
	 */
	public AuthControlDO() {
		gui_blocks = new ArrayList<AuthControlGuiBlockDO>();
		rolls = new ArrayList<AuthControlParamDO>();
		status = new ArrayList<AuthControlParamDO>();
		type = new ArrayList<AuthControlParamDO>();
	}


	/**
	 * 画面ブロックを追加します。<br>
	 *
	 * @param gui_block 画面ブロックオブジェクト
	 */
	public void addGui_block(AuthControlGuiBlockDO gui_block) {
		this.gui_blocks.add(gui_block);
	}

	/**
	 * 権限を追加します。<br>
	 *
	 * @param kengen 権限オブジェクト
	 */
	public void addKengen(AuthControlParamDO kengen) {
		this.rolls.add(kengen);
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
		for( int i=0; i<gui_blocks.size(); i++ ){
			buf.append( gui_blocks.get(i) ).append( newline );
		}
		return buf.toString();
	}

	/**
	 * 画面ブロックを取得します。
	 * @return 画面ブロック
	 */
	public List<AuthControlGuiBlockDO> getGui_blocks() {
		 return gui_blocks;
	}

	/**
	 * 画面項目IDを取得します。
	 * @return 画面項目ID
	 */
	public String getGui_id() {
		return gui_id;
	}

	/**
	 * 画面項目IDを設定します。
	 * @param gui_id 画面項目ID
	 */
	public void setGui_id(String gui_id) {
		this.gui_id = gui_id;
	}

	/**
	 * 制御権限を取得します。
	 * @return 制御権限
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
