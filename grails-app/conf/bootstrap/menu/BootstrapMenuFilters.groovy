package bootstrap.menu

import org.apache.commons.lang.StringUtils;

/**
 * The boostrap menu filter 
 * @author cyril
 */
class BootstrapMenuFilters {

	/** The bootstrap menu service */
	def bootstrapMenuServiceProxy
	
	/** The menu definition service */
	def menuDefinitionServiceProxy

    def filters = {
        all(controller:'*', action:'*') {
            before = {
				session["activeMenuItem"] = null;
            }
            after = { Map model ->
				
				def controller
				def action
				
				if(actionName && controllerName){
					controller = StringUtils.lowerCase(controllerName)
					action = StringUtils.lowerCase(actionName)
					def menus = menuDefinitionServiceProxy.loadMenuDefinition()
					
					def active = bootstrapMenuServiceProxy.retrievesActiveMenuItem(menus, action, controller, params)
					
					if(active != null){
						session["activeMenuItem"] = active.name
					} 					
				}
            }
        }
    }
}
