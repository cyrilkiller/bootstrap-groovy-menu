package bootstrap.menu

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.grails.web.util.WebUtils;

import breadcrumbs.MenuItem;

/**
 * Very simple Bootstrap Menu Service
 * @author cyril
 */
class BootstrapMenuService {

	static proxy = true
	static scope = 'session'
	static transactional = false
	/**
	 * Retrieves active menu item in session
	 * @return {@link String}
	 */
    def getActiveMenuItem() {
		def session = WebUtils.retrieveGrailsWebRequest().session
		return session["activeMenuItem"]
    }
	
	def retrievesActiveMenuItem(List<MenuItem> _menus, String _action, String _controller, Map<String, Object> _params){
		def path = []
		//MenuItem active = null
		if(_menus != null && _menus.size()> 0){
			{menus ->
				MenuItem active = null
				menus.each(){
					if((it.controller != null && StringUtils.lowerCase(it.controller).equals(_controller))
						&& it.action != null && StringUtils.lowerCase(it.action).equals(_action)){
						path << it
						active = it
					}else{
						if(active == null && it.subMenuItems != null && it.subMenuItems.size() > 0){
							MenuItem m = owner.call(it.subMenuItems)
							if( m != null){
								path << it
								active = it
							}
						}
					}
				}
				active
			}(_menus)
		}
		
		if(path.size() > 0){
			return path[path.size() - 1]
		}
		null
	}
}
