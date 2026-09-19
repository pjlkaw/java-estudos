import java.util.Scanner;
import java.util.ArrayList; 

public class game {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Player> playersArray = new ArrayList<>(); 
        ArrayList<Monster> monstersArray = new ArrayList<>(); 

        while (true) {

            System.out.println("\n===== GAME =====");
            System.out.println("1 - Criar player");
            System.out.println("2 - Ver ultimo player criado");
            System.out.println("3 - Listar players");
            System.out.println("4 - Criar monstro");
            System.out.println("5 - COMBATE!!!");
            System.out.println("------");
            System.out.println("6 - sair\n");

            System.out.print("Escolha: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                // Adiciona Player
                case 1:
                    Player player = new Player();
                    player.vida = 100;
            
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

                    break;
                    // Exibe Player
                    case 2 :
                        System.out.println(playersArray);

                        int ultimoIndex = playersArray.size() - 1;

                        Player playerAtual = playersArray.get(ultimoIndex);
                        System.out.println(playerAtual.nome);

                    break;

                    // Listar Players
                    case 3:
                        listaPlayers(playersArray);
                    break;

                    // Criar Monstro
                    case 4:
                        Monster monstro = new Monster();
                        System.out.print("Nome do monstro: ");
                        monstro.nome = teclado.nextLine();

                        monstersArray.add(monstro);

                        String nomeMonstro = monstersArray.get(monstersArray.size() - 1).nome;
                        int vidaMonstro = monstersArray.get(monstersArray.size() - 1).vida;

                        System.out.println(String.format(
                            "Um monstro apareceu!\n%s - %dHP", nomeMonstro, vidaMonstro
                        ));

                        System.out.println("\nOrda de Monstros");
                        for ( int i = 0; i < monstersArray.size(); i++) {
                            System.out.println(String.format("[%d] %s - %d HP",i+1, monstersArray.get(i).nome, vidaMonstro));
                        }
                    break;

                    case 5 :
                        System.out.println("===== COMBATE =====");
                        if (playersArray.isEmpty()) {
                            System.out.println("Nenhum player disponível para combate!");
                            break;
                        } else if (monstersArray.isEmpty()) {
                            System.out.println("Nenhum mosntro pelas redondezas!");
                            break;
                        }
                        // Escolhe o Player
                        listaPlayers(playersArray);

                        System.out.print("Escolha o player para a batalha:");
                        Player playerEscolhido = playersArray.get(
                            teclado.nextInt() - 1
                        );
                        // Define o primeiro monstro do array
                        Monster monstroEscolhido = monstersArray.get(0); 

                        combate(playerEscolhido, monstroEscolhido);
                        

                    break;
                
                default:
                    teclado.close();
                    break;
            }
        }

    }

    public static void combate(Player player, Monster monstro) {
        System.out.println(String.format("HP - %d %s X %s %d - HP", player.vida, player.nome, monstro.nome, monstro.vida));
    }
    
    public static void listaPlayers(ArrayList<Player> lista) {
        System.out.println("Players:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + 1);
            System.out.println(String.format(" - %s", lista.get(i).nome));
        }
    }
}