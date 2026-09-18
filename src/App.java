public class App {
    public static void main(String[] args) throws Exception {
        Boolean ativo = false;
        
        String mensagemFalse = "não ta";

        
        for ( int i = 0; i<=5; i++) {
            System.out.print(mensagemFalse);
            if (i == 5) {
                ativo = true;
            }
        }
        if (ativo == true) {
            mensagem("ta ativo");
            ativo = false;
            System.out.print("voltou pra falso");
        }
    }

    static void mensagem(String msg) {
        String mensagemTrue = msg;
        System.out.print(mensagemTrue);
    }
}
