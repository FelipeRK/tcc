	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <!-- Logo image (Buy Now) -->
	
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarColor01">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/FRK-Ecommerce/">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="category?categoryName=masculino">Masculino</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="category?categoryName=feminino">Feminino</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="category?categoryName=crianca">Crianças</a>
	      </li>
	    </ul>
	    <form id="searchForm" class="form-inline my-2 my-lg-0" onsubmit="submitSearch()">
	      <input name="searchKeyword" class="form-control mr-sm-2" type="text" placeholder="Busca por nome ou descrição">
	      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Buscar</button>
	    </form>
	    <!-- Carrinho -->
		<a class="nav-link" href="carrinho" style="color:#fff!important">Carrinho</a>
		<!-- User Login -->
		<c:if test="${ empty sessionScope.user }">
			<a class="nav-link" href="login-usuario" style="color:#fff!important">Entrar</a>
		</c:if>
		
		<!-- User Center -->
		<c:if test="${ not empty sessionScope.user }">
			<a class="nav-link" href="minha-conta" style="color:#fff!important">Minha Conta</a>
		</c:if>
		
		<!-- User Log out -->
		<c:if test="${ not empty sessionScope.user }">
			<a class="nav-link" href="sair" style="color:#fff!important">Sair</a>
		</c:if>
		
		<!-- Registration -->
		<c:if test="${ empty sessionScope.user }">
	  		<div>
			<a class="nav-link" href="cadastro" style="color:#fff!important">Cadastre-se</a>
		  	</div>
	  	</c:if>
	</nav>