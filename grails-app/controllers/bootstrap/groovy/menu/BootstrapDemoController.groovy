package bootstrap.groovy.menu

class BootstrapDemoController {

	
	def index(){
		[welcome: "Welcome to demo of bootstrap-groovy-menu"]
	}
	
    def pageOne() {
		render(view : "index", model: [welcome: "Welcome to demo of bootstrap-groovy-menu"])
	}
	
	def pageTwo() {
		render(view : "index", model: [welcome: "Welcome to demo of bootstrap-groovy-menu"])
	}
	
	def pageThreeOne() {
		render(view : "index", model: [welcome: "Welcome to demo of bootstrap-groovy-menu"])
	}
	
	def pageThreeTwo() {
		render(view : "index", model: [welcome: "Welcome to demo of bootstrap-groovy-menu"])
	}
	
	def search(){
		render(view : "index", model: [welcome: "Welcome to demo of bootstrap-groovy-menu !! you serach for me !!??"])
	}

	def createsomething(){
		render(view : "index", model: [welcome: "Welcome to demo of bootstrap-groovy-menu !! Create something !!??"])
	}
	
}
