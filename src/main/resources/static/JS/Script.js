function pedirId(mensagem) {
            const id = prompt(mensagem);
            if (id === null || id.trim() === "") {
                alert("Operação cancelada. Nenhum ID informado.");
                return null;
            }
            if (isNaN(id)) {
                alert("Por favor, digite um número válido.");
                return null;
            }
            return id.trim();
        }

        function excluirProduto() {
            const id = pedirId("Digite o ID do produto que deseja excluir:");
            if (id) {
                if (confirm(`Tem certeza que deseja excluir o produto de ID ${id}?`)) {
                    window.location.href = `/produtos/excluir?id=${id}`;
                }
            }
        }

        function editarProduto() {
            const id = pedirId("Digite o ID do produto que deseja editar:");
            if (id) {
                window.location.href = `/produtos/editar?id=${id}`;
            }
        }

        function verDetalhes() {
            const id = pedirId("Digite o ID do produto para ver os detalhes:");
            if (id) {
                window.location.href = `/produtos/detalhes?id=${id}`;
            }
        }