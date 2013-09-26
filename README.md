bootstrap-groovy-menu
=====================

Build a menu with Bootstrap3 .

First checkout Bootstrap3
==========================

Get source here : [Bootstrap 3](http://getbootstrap.com/) 

Use resource plugin to use bootstrap files


Define the menu
=====================

Run `create-service MenuDefinitionService`

In MenuDefinitionService create an method called `loadMenuDefinition`

example


```groovy

class MenuDefinitionService  {

	static transactional = false

	static scope = "session"

	static proxy = true


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

```
You can define as many levels as you want !!!

Just define the message in `messages.properties`

like `page.two.demo=pageTwo`

Configuration of a item menu

`display` : if ``` true ``` item is visible else if ``` false ``` not.

`useCaret` : if if ```groovy true ``` on an head item menu, a curso is show for dropdown child.

`template` : name of the template,  if `template` is set the template is include in the menu item.

other attribute is controller, action, name, message ... 

Declare Service `MenuDefinitionService` as proxy in `resources.groovy`

```groovy
beans = {
	...
	menuDefinitionServiceProxy(org.springframework.aop.scope.ScopedProxyFactoryBean) {
		targetBeanName = 'menuDefinitionService'
		proxyTargetClass = true
	}
	...
}
```

Use taglib 
==============

```groovy

<bootstrapmenu:dropdownmenu/>

```
