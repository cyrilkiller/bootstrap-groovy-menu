package bootstrap.menu

class BootstrapMenuTagLib {

	static namespace = 'bootstrapmenu'
	
	def menuDefinitionServiceProxy
	
	def bootstrapMenuServiceProxy
	
	def dropdownmenu = {attrs,body ->
		def menus = menuDefinitionServiceProxy.loadMenuDefinition()
		out << render(plugin: 'bootstrap-groovy-menu', template: "/tpl/dropdownmenu", model: [menus: menus, body: body()])
	}
	
	/**
     * DropDown Bootstrap.
     * Rendering content of menubaritem tag
     */
    def menubar = { attrs, body ->
        out << render(plugin: 'bootstrap-groovy-menu', template: "/tpl/menubar", model: [ body: body()])
    }

    /**
     * Sub item of DropDown Bootstrap.
     * This tag must be nested within element menubaritem.
     */
    def submenubar = { attrs, body ->
        out << render(plugin: 'bootstrap-groovy-menu', template: "/tpl/submenubar", model: [body: body()])
    }

    /**
     * Menu Item
     */
    def menubaritem = { attrs, body ->
        def name = attrs.name
        def activeMenuItem = bootstrapMenuServiceProxy.getActiveMenuItem()
        def active = activeMenuItem.equals(name) ? "active" : ""
        out << render(plugin: 'bootstrap-groovy-menu', template: "/tpl/menubaritem", model: [active: active, body: body()])
    }

}
