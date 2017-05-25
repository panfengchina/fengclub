<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="images/common/favicon_1.png" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="refresh" content="0;url=page/index.jsp " />
<title>中全网</title>
<script type="text/javascript">
	function drawCanvasImage(obj, width, callback) {

		var $canvas = $('<canvas></canvas>'), canvas = $canvas[0], context = canvas
				.getContext('2d');

		var img = new Image();

		img.onload = function() {
			if (width) {
				if (width > img.width) {
					var target_w = img.width;
					var target_h = img.height;
				} else {
					var target_w = width;
					var target_h = parseInt(target_w / img.width * img.height);
				}
			} else {
				var target_w = img.width;
				var target_h = img.height;
			}
			$canvas[0].width = target_w;
			$canvas[0].height = target_h;

			context.drawImage(img, 0, 0, target_w, target_h);

			_canvas = canvas.toDataURL();
			/*console.log(_canvas);*/
			callback(obj, _canvas);
		}
		img.src = getFullPath(obj);

	}

	function getFullPath(obj) {
		if (obj) {
			//ie 
			if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
				obj.select();
				return document.selection.createRange().text;
			}
			//firefox 
			else if (window.navigator.userAgent.indexOf("Firefox") >= 1
					|| $.browser.opera || $.browser.mozilla) {
				if (obj.files && window.URL.createObjectURL) {
					return window.URL.createObjectURL(obj.files[0]);
				}
				return obj.value;
			} else if ($.browser.safari) {
				if (window.webkitURL.createObjectURL && obj.files) {
					return window.webkitURL.createObjectURL(obj.files[0]);
				}
				return obj.value;
			}
			return obj.value;
		}
	}
	
	/******最完美解决 图片在图片框内按宽高比例自动缩放！！！***/  
    //Img:要放图片的img元素，onload时传参可用this  

    //maxHeight  :img元素的高度，像素（图片框 最大高度）  

    //maxWidth:img元素的宽度，像素（图片框 最大宽度）  
    function AutoSize(Img, maxWidth, maxHeight) {  
        var image = new Image();  
        //原图片原始地址（用于获取原图片的真实宽高，当<img>标签指定了宽、高时不受影响）  
        image.src = Img.src;    
        // 当图片比图片框小时不做任何改变   
        if (image.width < maxWidth&& image.height < maxHeight) {  
            Img.width = image.width;  
            Img.height = image.height;  
        }  
        else //原图片宽高比例 大于 图片框宽高比例,则以框的宽为标准缩放，反之以框的高为标准缩放  

    {  
        if (maxWidth/ maxHeight  <= image.width / image.height) //原图片宽高比例 大于 图片框宽高比例  
        {  
            Img.width = maxWidth;   //以框的宽度为标准  
            Img.height = maxWidth* (image.height / image.width);  
        }   
        else {   //原图片宽高比例 小于 图片框宽高比例  
            Img.width = maxHeight  * (image.width / image.height);  
            Img.height = maxHeight  ;   //以框的高度为标准  
        }  
    }  

}
</script>
</head>
<body>

</body>
</html>