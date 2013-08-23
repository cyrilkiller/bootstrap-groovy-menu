<style>
.search_form{
	padding-top: 6px;
	padding-bottom: 6px; 
}
</style>
<g:form action="search" controller="BootstrapDemo" name="search_form" class="search_form">
	<input type="text" name="test" placeholder="${message(code: item.message)}" style="height: 38px; border-radius: 4px;border: 1px solid #cccccc;"/>
</g:form>