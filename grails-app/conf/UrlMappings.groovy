class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: "BootstrapDemo", view:"/index")
		"500"(view:'/error')
	}
}
