<g:if test="${active == "active"}">
	<li class="${active}">${body}</li>
</g:if>
<g:else>
	<li>${body}</li>
</g:else>
