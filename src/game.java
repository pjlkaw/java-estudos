import java.util.Scanner;
import java.util.ArrayList; 

public class game {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Player> playersArray = new ArrayList<>(); 
        ArrayList<Monster> monstersArray = new ArrayList<>(); 

        Player playerPadrao = new Player();
        playerPadrao.nome = "kaw";
        playerPadrao.vida = 100;
        playersArray.add(playerPadrao);
        Monster monstroPadrao = new Monster();
        monstroPadrao.nome = "Esqueleto";
        monstroPadrao.vida = 50;
        monstersArray.add(monstroPadrao);


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
                case 2:
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

                case 5:
                        System.out.println("\n========================================"); 
                        System.out.println(" COMBATE"); 
                        System.out.println("========================================");

                        if (playersArray.isEmpty()) {
                            System.out.println("Nenhum player disponível para combate!");
                            break;
                        } else if (monstersArray.isEmpty()) {
                            System.out.println("Nenhum mosntro pelas redondezas!");
                            break;
                        }
                        // Escolhe o Player
                        listaPlayers(playersArray);

                        System.out.print("Escolha o player para a batalha: ");
                        Player playerEscolhido = playersArray.get(
                            teclado.nextInt() - 1
                        );

                        // Escolhe arma
                        System.out.println("Escolha a arma do player: ");
                        for ( int i = 0; i<playerEscolhido.arma.length ; i++) {
                            System.out.println(String.format("%d - %s", i+1, playerEscolhido.arma[i]));
                        }
                        int armaEscolha = teclado.nextInt();
                        String playerArmaEscolhida = playerEscolhido.arma[armaEscolha-1];


                        while (!monstersArray.isEmpty()) {
                            Monster monstroAtual = monstersArray.get(0);
                            boolean playerVivo = combate(playerEscolhido, playerArmaEscolhida, monstroAtual, monstersArray);
                        
                            if (!playerVivo) {
                                System.out.println("Fim de Jogo para o Player");
                                break;
                            }
                        }
                    break;
                
                default:
                    teclado.close();
                    break;
            }
        }

    }

    public static boolean combate(Player player,String playerArmaEscolhida, Monster monstro, ArrayList<Monster> monstersArray) {
        System.out.println("----------------------------------------");
        System.out.println(String.format( "%s %d HP VS %s %d HP", player.nome, player.vida, monstro.nome, monstro.vida )); 
        System.out.println("----------------------------------------");

        int vidaAtualMonstro = monstro.vida;
        int danoMonstro = monstro.dano;
        int vidaAtualplayer = player.vida;
        int danoPlayer = player.dano;
        if(playerArmaEscolhida == "Espada"){
            danoPlayer = danoPlayer + 10;
        } else if (playerArmaEscolhida == "Maça") {
            danoPlayer = danoPlayer + 20;
        } else {
            danoPlayer = danoPlayer + 15;
        }
 

        for (int i = 1; vidaAtualMonstro > 0; i++) {
            System.out.println(String.format("\nTURNO %d", i));
            System.out.println("----------------------------------------");
            vidaAtualMonstro = vidaAtualMonstro - danoPlayer;

            if (vidaAtualMonstro <= 0) {
                // Ataque Monstro
                vidaAtualMonstro = 0;
                System.out.println(String.format("%s causou %d de dano!", player.nome, danoPlayer));
                System.out.println(String.format("\nVida atual do %s: %d (X_X)", monstro.nome, vidaAtualMonstro));
                monstro.vida = vidaAtualMonstro;
                // Elimina o monstro da memória
                monstersArray.remove(monstro);

                vidaAtualplayer = vidaAtualplayer + 10;
                player.vida = vidaAtualplayer;
                System.out.println(String.format("O player ganhou 10HP: %s - %d HP", player.nome, vidaAtualplayer));
                return true;
            }
            else {
                System.out.println(String.format("%s causou %d de dano!", player.nome, danoPlayer));
                System.out.println(String.format("\nVida atual do %s: %d", monstro.nome, vidaAtualMonstro));

                // Contra-ataque do Monstro
                vidaAtualplayer = vidaAtualplayer - danoMonstro;

                System.out.println(String.format("%s causou %d de dano!", monstro.nome, danoMonstro));
                System.out.println(String.format("\nVida atual do %s: %d", player.nome, vidaAtualplayer));

                if (vidaAtualplayer <= 0) {
                    vidaAtualplayer = 0;
                    player.vida = vidaAtualplayer;
                    System.out.println(String.format("%s morreu!", player.nome));

                    return false;
                }

                monstro.vida = vidaAtualMonstro;
                player.vida = vidaAtualplayer;

            }
        }
        return true;
    }
    
    public static void listaPlayers(ArrayList<Player> lista) {
        System.out.println("Players:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + 1);
            System.out.println(String.format(" - %s", lista.get(i).nome));
        }
    }
}