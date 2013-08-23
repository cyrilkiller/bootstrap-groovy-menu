package bootstrap.menu
import breadcrumbs.MenuItem



class MenuDefinitionService {

	static proxy = true
	static scope = "session"
    static transactional = false

	def loadMenuDefinition() {
		def menus = []
		
		menus << new MenuItem(name : "page-one", message:"page.one.demo", controller: "BootstrapDemo", action: "pageOne", display : true)
		menus << new MenuItem(name : "page-two", message:"page.two.demo", controller: "BootstrapDemo", action: "pageTwo", template: 'searchform', display : true)
		
		MenuItem menuThree = new MenuItem(name : "page-three", message:"page.three.demo", useCaret: true, display : true)
		menuThree <<  new MenuItem(name : "page-three-one", message:"page.three.one.demo", controller: "BootstrapDemo", action:"pageThreeOne", display : true)
		
		MenuItem menuThreeTwo = new MenuItem(name : "page-three-two", message:"page.three.two.demo", controller: "BootstrapDemo", action:"pageThreeTwo", display : true)
		menuThreeTwo << new MenuItem(name : "page-three-two", message:"page.three.two.one.demo", controller: "BootstrapDemo", action:"pageThreeTwoOne", display : true)
		menuThreeTwo << new MenuItem(name : "page-three-two", message:"page.three.two.two.demo", controller: "BootstrapDemo", action:"pageThreeTwoTwo", display : true)
		
		menuThree << menuThreeTwo	
		
		menus << menuThree
		
		MenuItem menuCreateSomething = new MenuItem(name : "page-something", message:"page.something.demo", useCaret: true, display : true)
		menuCreateSomething <<  new MenuItem(name : "page-createsomething", message:"page.create.something.demo", controller: "BootstrapDemo", action:"createsomething", template: 'inner', display: true)
		menus << menuCreateSomething
		menus
	}

}
