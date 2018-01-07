[QueryGroup="examples"] @collection [[
[QueryItem="finding_classe_processos"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?sigla_classe_processo
WHERE {
	?acordao rdf:type stf:Acordao.
	?acordao stf:temClasseProcesso ?classe_processo.
	?classe_processo stf:sigla ?sigla_classe_processo.
}

[QueryItem="finding_relatores_para_acordao"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?relator
WHERE {
	?acordao rdf:type stf:Acordao.
	?acordao stf:temClasseProcesso ?classe_processo.
	?classe_processo stf:sigla ?sigla_classe_processo.
	?acordao stf:temVoto ?voto.
	?voto stf:temRelator ?relator.
	
	FILTER(?sigla_classe_processo = "ADI"^^xsd:string)
}

[QueryItem="finding_relatores_acao_direta"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT ?acordao ?classificacao ?relator
#SELECT ?classificacao
WHERE {
	?acordao rdf:type stf:Acordao.
	?acordao stf:temClasseProcesso ?classe_processo.
	?classe_processo stf:sigla ?sigla_classe_processo.

	?acordao stf:temDecisao ?decisao.
	?decisao rdf:type stf:Decisao.
	?decisao stf:classificacao ?classificacao.

	?acordao stf:temVoto ?voto.
	?voto stf:temRelator ?relator.
	#?relator stf:nome ?nome_relator.	

	FILTER (?classificacao = "neg"^^xsd:string).
	FILTER(?sigla_classe_processo = "ADI"^^xsd:string).
	#FILTER (?nome_relator = "NELSON JOBIM"^^xsd:string).
}

[QueryItem="finding_based_on_subclass"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

SELECT ?a
WHERE {
	?a rdfs:subClassOf stf:ClasseProcesso.
}
]]

[QueryGroup="oficial"] @collection [[
[QueryItem="find_relator_provimento_sim_ADI"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?nome_relator ?acordao ?classificacao
WHERE {
	?acordao rdf:type stf:Acordao.
	?acordao stf:temClasseProcesso ?classe_processo.
	?classe_processo stf:sigla ?sigla_classe_processo.

	?acordao stf:temDecisao ?decisao.
	?decisao rdf:type stf:Decisao.
	?decisao stf:classificacao ?classificacao.

	?acordao stf:temVoto ?voto.
	?voto rdf:type stf:Voto.
	?voto stf:temRelator ?relator.
	?relator rdf:type stf:Relator.
	?relator stf:nome ?nome_relator.
	
	OPTIONAL {
		?voto stf:temRelatorParaAcordao ?relator_para_acordao.
	}	
	
	FILTER( !BOUND( ?relator_para_acordao ) ).
	FILTER ( ?classificacao = "pos"^^xsd:string ).
	FILTER( ?sigla_classe_processo = "ADI"^^xsd:string ).
}

[QueryItem="find_ministro_desafiados"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?ministro_desafiado ?acordao
WHERE {	
	?acordao rdf:type stf:Acordao.
	?acordao stf:temVoto ?voto.
	?voto rdf:type stf:Voto.

	?voto stf:temRelator ?relator.
	?relator rdf:type stf:Relator.
	?relator stf:nome ?ministro_desafiado.

	?voto stf:temRelatorParaAcordao ?relator_para_acordao.
	?relator_para_acordao rdf:type stf:RelatorParaAcordao.
}

[QueryItem="find_ministros_desafiadores"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?ministro_desafiador ?acordao 
WHERE {	
	?acordao rdf:type stf:Acordao.
	?acordao stf:temVoto ?voto.
	?voto rdf:type stf:Voto.

	?voto stf:temRelator ?relator.
	?relator rdf:type stf:Relator.

	?voto stf:temRelatorParaAcordao ?relator_para_acordao.
	?relator_para_acordao rdf:type stf:RelatorParaAcordao.
	?relator_para_acordao stf:nome ?ministro_desafiador.
}

[QueryItem="find_ministros_menos_desafiados"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?nome_relator ?acordao 
WHERE {
	?acordao rdf:type stf:Acordao.
	
	?acordao stf:temVoto ?voto.
	?voto rdf:type stf:Voto.
	?voto stf:temRelator ?relator.
	?relator rdf:type stf:Relator.
	?relator stf:nome ?nome_relator.
	
	OPTIONAL {
		?voto stf:temRelatorParaAcordao ?relator_para_acordao.
	}	
	
	FILTER( !BOUND( ?relator_para_acordao ) ).
}

[QueryItem="find_acordao_by_id"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT  distinct ?Relator  ?Relator_para_Acórdão ?Órgão_Julgador ?Publicação ?Ementa ?Decisão
WHERE {
	?acordao rdf:type stf:Acordao.
	?acordao stf:ementa ?Ementa.
	?acordao stf:identificador ?identificador.
	?acordao stf:publicacao ?Publicação.

	OPTIONAL {
		?acordao stf:temDecisao ?dec.
		?dec rdf:type stf:Decisao.
		?dec stf:descricao ?Decisão.
	}

	?acordao stf:temVoto ?voto.
	?voto stf:temRelator ?rel.
	?rel stf:nome ?Relator.

	OPTIONAL {
		?voto stf:temRelatorParaAcordao ?rel_para_acordao.
		?rel_para_acordao stf:nome ?Relator_para_Acórdão.
	}

	?acordao stf:temOrgaoJulgador ?orgao_jul.
	?orgao_jul stf:nome ?Órgão_Julgador.

	FILTER ( ?identificador = "AGR_RCL_20905"^^xsd:string ).
}

[QueryItem="find_decisoes_unanimes"]
PREFIX stf: <http://www.semanticweb.org/rabriol/ontologies/2017/0/ontoAcordaoSTF#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?acordao ?descricao
WHERE {	
	?acordao rdf:type stf:Acordao.
	?acordao stf:temDecisao ?decisao.
	?decisao rdf:type stf:Decisao.
	?decisao stf:unanime ?unanime.
	?decisao stf:descricao ?descricao.

	FILTER ( ?unanime = "sim"^^xsd:string ).
}
]]
