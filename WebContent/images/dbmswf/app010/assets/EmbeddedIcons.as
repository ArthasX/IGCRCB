package app010.assets{
	import app010.com.deliverik.flex.mode.ImageEx;
	
	import mx.controls.Image;
	
	import spark.components.BorderContainer;

	public class EmbeddedIcons {
	 	/**
		 * 加载图片
	 	 * */
	 	public static function generateImageEx(imgUrl:String):ImageEx {
	 		var imgEX:ImageEx = new ImageEx();
			imgEX.imgSrc = (imgUrl==''?'app010/assets/monitor/default.png':imgUrl);
			return imgEX;
	 	}
	}
}