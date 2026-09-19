import java.util.Scanner;
import java.util.ArrayList; 

public class game {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Player> playersArray = new ArrayList<>(); 

        
        while (true) {

            System.out.println("===== GAME =====");
            System.out.println("1 - Criar player");
            System.out.println("2 - Listar players");
            System.out.println("3 - Ver player");
            System.out.println("4 - Sair");

            System.out.print("Escolha: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    Player player = new Player();
                    player.vida = 0;
            
                    System.out.print("Nome do player: ");
                    String nome = teclado.nextLine();
                    
                    player.nome = nome;

                    String playerEstado = "vivo";

                    if (player.vida == 0) {
                        playerEstado = "morto";
                    }
                    
                    if (!nome.isEmpty()) {
                        System.out.println("\nPlayer Criado!");
                        System.out.println(String.format("bem vindo, %s", player.nome));
                        System.out.println(String.format("STATS \n Vida: %d Estado: %s",player.vida, playerEstado));
                    }

                    playersArray.add(player);
                    System.out.println(playersArray);

                    Player playerAtual = playersArray.get(0);
                    System.out.println(playerAtual.nome);
                    

                    break;
            
                default:
                    teclado.close();
                    break;
            }
        }
    }
}