insert into cliente(nome, email, senha, endereco_id)
	values('João', 'joao@email.com', '123456', (select id from Endereco limit 1));

insert into produto(nome_produto, descricao, preco, quantidade, url_foto, categoria_id)
	values('BRM54HBANA', 'Geladeira Brastemp com freeze control', 2499, 5, '',
		  (select id from categoria limit 1));

insert into produto(nome_produto, descricao, preco, quantidade, url_foto, categoria_id)
	values('RT46K6261S8', 'Geladeira Samsung 5 em 1 Inox', 2899, 3, '',
		  (select id from categoria limit 1));