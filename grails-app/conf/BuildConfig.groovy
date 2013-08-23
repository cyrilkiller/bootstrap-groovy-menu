grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility
    repositories {
        grailsCentral()
		mavenLocal()
		mavenCentral()
    }
	
	
    dependencies {
		test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
		test "org.seleniumhq.selenium:selenium-support:2.31.0"
		test "org.seleniumhq.selenium:selenium-firefox-driver:2.31.0"
		test "org.gebish:geb-spock:0.9.0-RC-1"      
    }

    plugins {
		build(":tomcat:$grailsVersion",
		      ":rest-client-builder:1.0.3") {
			    export = false
		}
	  build ':release:2.2.1', ':rest-client-builder:1.0.3', {
	  excludes 'xml-apis', 'xmlParserAPIs'
		  export = false
	  }
	  test(":spock:0.7") {
		  exclude "spock-grails-support"
	  }
	  test ":geb:0.9.0-RC-1"
	  runtime ':jquery:1.8.3'
	  runtime ":resources:1.1.6"
	  compile ":lesscss-resources:1.3.1"
	 
    }
}
