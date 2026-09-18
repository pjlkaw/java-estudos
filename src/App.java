public class App {
    public static void main(String[] args) throws Exception {
        Boolean ativo = false;
        String mensagemFalse = "não ta";

        for ( int i = 0; i<=5; i++) {
            if (i % 2 == 0) {
                System.out.println(String.format("%s oi", mensagemFalse) );
            }
            if (i % 2 == 1) {
                System.out.println(String.format("%s tchau", mensagemFalse) );
            }

            if (i == 5) {
                ativo = true;
            }
        }
        if (ativo == true) {
            mensagem("ta ativo");
            ativo = retornafalse();
        }

        System.out.println(retornaconta(1, 2));

        // Execução de Classes
        int id = 1;
        String nome = "Pedro";
        int vida = 100;
        boolean vivo = true; 

        String statusUserTexto;

        Player user = criaPlayer(id, nome, vida, vivo);
        if (user.vivo) {
            statusUserTexto = "vivo";
        }
        else {
            statusUserTexto = "morto";
        }
        System.out.println(String.format("O nome do novo usuário é: %s e está %s", user.nome, statusUserTexto ));
    }

    // Funções
    static Player criaPlayer(int id, String nome, int vida, boolean vivo ) {
        Player user = new Player();
        user.id = id;
        user.nome = nome;
        user.vida = vida;
        if (vida == 0) {
            user.vivo = false;
        }
        else {
            user.vivo = true;
        }
        return user;
    }

    static void mensagem(String msg) {
        String mensagemTrue = msg;
        System.out.println(mensagemTrue);
    }

    static int retornaconta(int v1, int v2) {
        int conta = v1 + v2;
        return conta;
    }

    static boolean retornafalse() {
        System.out.println("voltou pra falso");
        return false;
    }
}
