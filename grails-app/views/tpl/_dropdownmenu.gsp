<g:def var="menubaritems" value="${menus }" />
<bootstrapmenu:menubar>
	<g:each  var="item" in="${menubaritems}">
		<%-- Display home page --%>
		<g:if test="${item.name == 'home' && item.display}">
			<bootstrapmenu:menubaritem name="home">
				<a href="${resource(dir:'')}"><g:img uri="/images/menu/ic_menu_home.png" alt="Accueil" plugin="ogil-core" /></a>
			</bootstrapmenu:menubaritem>
		</g:if>
		<g:elseif test="${ item.display }">
			<bootstrapmenu:menubaritem name="${item.name}">
				<g:if test="${item.controller != null && item.action != null && item.template == null}">
					<g:link controller="${item.controller}" action="${item.action}" params="${item.params}">
						${message(code: item.message) }
					</g:link>
				</g:if>
				<g:elseif test="${item.display }" >
					<g:if test="${item.template }">
						<g:render template="/${item.template }" bean="${item}" var="item"></g:render>
					</g:if>
					<g:else>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							${message(code: item.message)}
							<g:if test="${item.useCaret}">
								<b class="caret"></b>
							</g:if>
						</a>
					</g:else>
				</g:elseif>
				<g:if test="${item.subMenuItems != null && item.subMenuItems.size() > 0 }">
					<bootstrapmenu:submenubar>
						<g:each in="${item.subMenuItems}" var="subItem">
							<g:if test="${subItem.controller != null && subItem.action != null && subItem.display}">
								<bootstrapmenu:menubaritem name="${ subItem.name }">
									<g:if test="${subItem.template }">
										<g:render  template="/${subItem.template }"  bean="${subItem}" var="item"></g:render>
									</g:if>
									<g:else>
										<g:link controller="${subItem.controller}" action="${subItem.action}" params="${subItem.params}" >
											${message(code: subItem.message) }
										</g:link>
									</g:else>
								</bootstrapmenu:menubaritem>
							</g:if>
						</g:each>
					</bootstrapmenu:submenubar>
				</g:if>
			</bootstrapmenu:menubaritem>
		</g:elseif>	
	</g:each>
</bootstrapmenu:menubar>