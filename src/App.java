public class App {
    public static void main(String[] args) throws Exception {
        Boolean ativo = false;
        
        String mensagemFalse = "não ta";

        for ( int i = 0; i<=5; i++) {
            System.out.println(mensagemFalse);
            if (i == 5) {
                ativo = true;
            }
        }
        if (ativo == true) {
            mensagem("ta ativo");
            ativo = retornafalse();
        }

        System.out.println(retornaconta(1, 2));
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
