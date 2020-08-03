public class PrincipalBanco {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessaBanco(pool, tx)).start();
        new Thread(new TarefaAcessaBancoProcedimento(pool, tx)).start();

        //deadlock gerado, um thread segura a chave pool enquanto outro aguarda ela
        // e o outro thread segura a chave tx enquanto o outro aguarda ela

//        Um thread impede a execução do outro, pois cada um possui a chave de um objeto que o outro precisa para continuar.
//        Temos um impasse e esse impasse é chamado de deadlock.

    }
}