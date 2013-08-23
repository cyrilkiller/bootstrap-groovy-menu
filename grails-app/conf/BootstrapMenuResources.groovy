
grails.resources.modules = {
	
	bootstrap {
		dependsOn   'jquery'
        resource url: [dir: 'js',  file: 'bootstrap.min.js']
		resource url: [dir: 'css', file: 'bootstrap.min.css']
    }
	
}