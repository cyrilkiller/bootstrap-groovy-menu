<!DOCTYPE html>
<html>
	<head>
		<r:require modules="jquery"/>
	 	<r:require modules="bootstrap"/>
	 	
		<r:layoutResources />
	</head>	
	<body>
		<div style="width: 500px; padding: 15px;">
			<bootstrapmenu:dropdownmenu/>
		</div>
		${ welcome}
      
		<!-- Included Javascript files and other resources -->
		<r:layoutResources />	
	</body>
	
</html>