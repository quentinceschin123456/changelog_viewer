<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<style>
			html {
				background-image: url("<c:url value="wallpaper.jpg"/>");
			}
			.center {
				text-align: center;
				letter-spacing: 2em;
			}
			
			#main_image {
				display: block;
				margin-left: auto;
				margin-right: auto;
				max-width: 45%;
				/*max-width: 829px;*/
				/*max-height: 442px;*/
			}
			
		</style>
	</head>
	<body>
		<header>
			<div class=center>
				<img id="main_image" src="<c:url value="logo.png"/>"/>
				<h2>QACTA PROJECT</h2>
			</div>
		</header>
		TETS
	</body>
</html>