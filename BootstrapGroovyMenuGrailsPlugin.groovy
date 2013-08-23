import org.springframework.aop.scope.ScopedProxyFactoryBean;

class BootstrapGroovyMenuGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp",
	    "grails-app/views/index.gsp",
		"grails-app/views/bootstrapDemo/**",
		"grails-app/views/_inner.gsp",
		"grails-app/views/_searchform.gsp",
		"grails-app/controllers/bootstrap/**",
		"grails-app/services/bootstrap/menu/MenuDefinitionService.groovy",
		"grails-app/i18n/**",
		
    ]

    
    def title = "Bootstrap Groovy Menu Plugin" // Headline display name of the plugin
    def author = "cyrilkiller"
    def authorEmail = ""
    def description = '''\
Brief summary/description of the plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/bootstrap-groovy-menu"

	def license = 'APACHE'
	def issueManagement = [system: 'GITHUB', url: 'https://github.com/cyrilkiller/bootstrap-groovy-menu/issues']
	def scm = [url: 'https://github.com/cyrilkiller/bootstrap-groovy-menu']

  
    def doWithSpring = {

		bootstrapMenuServiceProxy(ScopedProxyFactoryBean) {
			targetBeanName = 'bootstrapMenuService'
			proxyTargetClass = true
		}
    }
}
