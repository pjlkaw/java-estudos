import java.util.Scanner;
import java.util.ArrayList;

public class gameStyled {

    // ==================== CORES ====================

    static final String RESET = "\u001B[0m";

    static final String PRETO = "\u001B[30m";
    static final String VERMELHO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AMARELO = "\u001B[33m";
    static final String AZUL = "\u001B[34m";
    static final String ROXO = "\u001B[35m";
    static final String CIANO = "\u001B[36m";
    static final String BRANCO = "\u001B[37m";

    static final String NEGRITO = "\u001B[1m";

    // ==================== MAIN ====================

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Player> playersArray = new ArrayList<>();
        ArrayList<Monster> monstersArray = new ArrayList<>();

        // Player padrão
        Player playerPadrao = new Player();
        playerPadrao.nome = "kaw";
        playerPadrao.vida = 100;

        playersArray.add(playerPadrao);

        // Monstro padrão
        Monster monstroPadrao = new Monster();
        monstroPadrao.nome = "Esqueleto";
        monstroPadrao.vida = 50;

        monstersArray.add(monstroPadrao);


        while (true) {

            menu();

            System.out.print(CIANO + "  Escolha: " + RESET);

            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                // ==================== CRIAR PLAYER ====================

                case 1:

                    Player player = new Player();

                    player.vida = 100;

                    System.out.println();
                    System.out.println(CIANO + "╔══════════════════════════════════════╗" + RESET);
                    System.out.println(CIANO + "║" + RESET + NEGRITO
                            + "          CRIAR PLAYER  "
                            + RESET + CIANO + "              ║" + RESET);
                    System.out.println(CIANO + "╚══════════════════════════════════════╝" + RESET);

                    System.out.print("\n" + AMARELO + "  Nome: " + RESET);

                    String nome = teclado.nextLine();

                    player.nome = nome;

                    String playerEstado = "vivo";

                    if (player.vida == 0) {
                        playerEstado = "morto";
                    }

                    if (!nome.isEmpty()) {

                        System.out.println();

                        System.out.println(
                            VERDE + "  ✓ PLAYER CRIADO!" + RESET
                        );

                        System.out.println(
                            "  Bem-vindo, " + NEGRITO
                            + player.nome + RESET + "!"
                        );

                        System.out.println();
                        System.out.println(
                            CIANO + "  ─────── STATS ───────" + RESET
                        );

                        System.out.println(
                            "  Vida   : "
                            + VERDE + player.vida + " HP" + RESET
                        );

                        System.out.println(
                            "  Estado : "
                            + VERDE + playerEstado + RESET
                        );

                    } else {

                        System.out.println(
                            VERMELHO + "\n  ✗ Nome inválido!" + RESET
                        );
                    }

                    playersArray.add(player);

                    pausa(teclado);

                    break;


                // ==================== ÚLTIMO PLAYER ====================

                case 2:

                    int ultimoIndex = playersArray.size() - 1;

                    Player playerAtual = playersArray.get(ultimoIndex);

                    System.out.println();

                    System.out.println(
                        CIANO + "╔══════════════════════════════════════╗" + RESET
                    );

                    System.out.println(
                        CIANO + "║" + RESET + NEGRITO
                        + "         ÚLTIMO PLAYER  "
                        + RESET + CIANO + "              ║" + RESET
                    );

                    System.out.println(
                        CIANO + "╚══════════════════════════════════════╝" + RESET
                    );

                    System.out.println();

                    System.out.println(
                        "  Nome: "
                        + VERDE + playerAtual.nome + RESET
                    );

                    System.out.println(
                        "  Vida: "
                        + VERDE + playerAtual.vida + " HP" + RESET
                    );

                    pausa(teclado);

                    break;


                // ==================== LISTAR PLAYERS ====================

                case 3:

                    listaPlayers(playersArray);

                    pausa(teclado);

                    break;


                // ==================== CRIAR MONSTRO ====================

                case 4:

                    Monster monstro = new Monster();

                    System.out.println();

                    System.out.println(
                        VERMELHO + "╔══════════════════════════════════════╗" + RESET
                    );

                    System.out.println(
                        VERMELHO + "║" + RESET + NEGRITO
                        + "          CRIAR MONSTRO"
                        + RESET + VERMELHO + "               ║" + RESET
                    );

                    System.out.println(
                        VERMELHO + "╚══════════════════════════════════════╝" + RESET
                    );

                    System.out.print(
                        "\n" + AMARELO + "  Nome: " + RESET
                    );

                    monstro.nome = teclado.nextLine();

                    monstersArray.add(monstro);

                    String nomeMonstro =
                        monstersArray.get(monstersArray.size() - 1).nome;

                    int vidaMonstro =
                        monstersArray.get(monstersArray.size() - 1).vida;

                    System.out.println();

                    System.out.println(
                        VERMELHO + "  ⚔ MONSTRO APARECEU!" + RESET
                    );

                    System.out.println(
                        "  " + NEGRITO + nomeMonstro + RESET
                        + " - "
                        + VERMELHO + vidaMonstro + " HP" + RESET
                    );

                    System.out.println();
                    System.out.println(
                        VERMELHO + "  ───── ORDA DE MONSTROS ─────" + RESET
                    );

                    for (int i = 0; i < monstersArray.size(); i++) {

                        System.out.println(
                            String.format(
                                "  [%d] %-15s %d HP",
                                i + 1,
                                monstersArray.get(i).nome,
                                monstersArray.get(i).vida
                            )
                        );
                    }

                    pausa(teclado);

                    break;


                // ==================== COMBATE ====================

                case 5:

                    combateMenu(
                        teclado,
                        playersArray,
                        monstersArray
                    );

                    break;


                // ==================== SAIR ====================

                case 6:

                    System.out.println();

                    System.out.println(
                        CIANO + "  Até mais!" + RESET
                    );

                    teclado.close();

                    return;


                // ==================== OPÇÃO INVÁLIDA ====================

                default:

                    System.out.println(
                        VERMELHO
                        + "\n  ✗ Opção inválida!"
                        + RESET
                    );

                    pausa(teclado);

                    break;
            }
        }
    }


    // ============================================================
    // MENU
    // ============================================================

    public static void menu() {

        System.out.println();

        System.out.println(
            CIANO + "╔══════════════════════════════════════╗" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + NEGRITO
            + "                 GAME "
            + RESET + CIANO + "                ║" + RESET
        );

        System.out.println(
            CIANO + "╠══════════════════════════════════════╣" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + "  [1] Criar player                    "
            + CIANO + "║" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + "  [2] Ver último player criado        "
            + CIANO + "║" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + "  [3] Listar players                  "
            + CIANO + "║" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + "  [4] Criar monstro                   "
            + CIANO + "║" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + "  [5] COMBATE                         "
            + CIANO + "║" + RESET
        );

        System.out.println(
            CIANO + "╠══════════════════════════════════════╣" + RESET
        );

        System.out.println(
            CIANO + "║" + RESET + "  [6] Sair                            "
            + CIANO + "║" + RESET
        );

        System.out.println(
            CIANO + "╚══════════════════════════════════════╝" + RESET
        );
    }


    // ============================================================
    // MENU DE COMBATE
    // ============================================================

    public static void combateMenu(
        Scanner teclado,
        ArrayList<Player> playersArray,
        ArrayList<Monster> monstersArray
    ) {

        System.out.println();

        System.out.println(
            VERMELHO + "╔══════════════════════════════════════╗" + RESET
        );

        System.out.println(
            VERMELHO + "║" + RESET + NEGRITO
            + "                COMBATE"
            + RESET + VERMELHO + "               ║" + RESET
        );

        System.out.println(
            VERMELHO + "╚══════════════════════════════════════╝" + RESET
        );


        if (playersArray.isEmpty()) {

            System.out.println(
                VERMELHO
                + "\n  ✗ Nenhum player disponível!"
                + RESET
            );

            pausa(teclado);

            return;
        }


        if (monstersArray.isEmpty()) {

            System.out.println(
                AMARELO
                + "\n  Nenhum monstro pelas redondezas!"
                + RESET
            );

            pausa(teclado);

            return;
        }


        // ==================== ESCOLHER PLAYER ====================

        listaPlayers(playersArray);

        System.out.print(
            "\n" + CIANO + "  Escolha o player: " + RESET
        );

        Player playerEscolhido =
            playersArray.get(teclado.nextInt() - 1);


        // ==================== ESCOLHER ARMA ====================

        System.out.println();

        System.out.println(
            AMARELO + "  ⚔ ESCOLHA SUA ARMA" + RESET
        );

        System.out.println(
            AMARELO + "  ─────────────────────" + RESET
        );

        for (int i = 0; i < playerEscolhido.arma.length; i++) {

            System.out.println(
                String.format(
                    "  [%d] %s",
                    i + 1,
                    playerEscolhido.arma[i]
                )
            );
        }

        System.out.print(
            "\n" + CIANO + "  Escolha: " + RESET
        );

        int armaEscolha = teclado.nextInt();

        String playerArmaEscolhida =
            playerEscolhido.arma[armaEscolha - 1];


        System.out.println();

        System.out.println(
            VERDE + "  ✓ Arma equipada: "
            + playerArmaEscolhida
            + RESET
        );

        pausa(teclado);


        // ==================== BATALHA ====================

        while (!monstersArray.isEmpty()) {

            Monster monstroAtual = monstersArray.get(0);

            boolean playerVivo = combate(
                playerEscolhido,
                playerArmaEscolhida,
                monstroAtual,
                monstersArray
            );

            if (!playerVivo) {

                System.out.println();

                System.out.println(
                    VERMELHO + "╔══════════════════════════════════════╗"
                    + RESET
                );

                System.out.println(
                    VERMELHO + "║" + RESET + NEGRITO
                    + "             GAME OVER"
                    + RESET + VERMELHO + "                ║"
                    + RESET
                );

                System.out.println(
                    VERMELHO + "╚══════════════════════════════════════╝"
                    + RESET
                );

                break;
            }

            if (!monstersArray.isEmpty()) {

                System.out.println();

                System.out.println(
                    VERDE + "  ✓ Próximo inimigo!"
                    + RESET
                );

                pausa(teclado);
            }
        }

        if (monstersArray.isEmpty() && playerEscolhido.vida > 0) {

            System.out.println();

            System.out.println(
                VERDE + "╔══════════════════════════════════════╗"
                + RESET
            );

            System.out.println(
                VERDE + "║" + RESET + NEGRITO
                + "          TODOS DERROTADOS!"
                + RESET + VERDE + "             ║"
                + RESET
            );

            System.out.println(
                VERDE + "╚══════════════════════════════════════╝"
                + RESET
            );
        }

        pausa(teclado);
    }


    // ============================================================
    // COMBATE
    // ============================================================

    public static boolean combate(
        Player player,
        String playerArmaEscolhida,
        Monster monstro,
        ArrayList<Monster> monstersArray
    ) {

        System.out.println();

        System.out.println(
            ROXO + "╔══════════════════════════════════════╗"
            + RESET
        );

        System.out.println(
            ROXO + "║" + RESET + NEGRITO
            + "              BATALHA"
            + RESET + ROXO + "                 ║"
            + RESET
        );

        System.out.println(
            ROXO + "╚══════════════════════════════════════╝"
            + RESET
        );

        System.out.println();

        System.out.println(
            VERDE + "  " + player.nome
            + "  " + player.vida + " HP"
            + RESET
        );

        System.out.println(
            CIANO + "              VS"
            + RESET
        );

        System.out.println(
            VERMELHO + "  " + monstro.nome
            + "  " + monstro.vida + " HP"
            + RESET
        );

        System.out.println();

        int vidaAtualMonstro = monstro.vida;
        int danoMonstro = monstro.dano;
        int vidaAtualplayer = player.vida;
        int danoPlayer = player.dano;


        // ==================== DANO DA ARMA ====================

        if (playerArmaEscolhida.equals("Espada")) {

            danoPlayer = danoPlayer + 10;

        } else if (playerArmaEscolhida.equals("Maça")) {

            danoPlayer = danoPlayer + 20;

        } else {

            danoPlayer = danoPlayer + 15;
        }


        System.out.println(
            AMARELO + "  ⚔ Arma: "
            + playerArmaEscolhida
            + " | Dano: "
            + danoPlayer
            + RESET
        );


        // ==================== TURNOS ====================

        for (int i = 1; vidaAtualMonstro > 0; i++) {

            System.out.println();

            System.out.println(
                CIANO
                + "──────────── TURNO " + i + " ────────────"
                + RESET
            );


            // ==================== ATAQUE DO PLAYER ====================

            vidaAtualMonstro =
                vidaAtualMonstro - danoPlayer;

            System.out.println();

            System.out.println(
                VERDE + "  ⚔ "
                + player.nome
                + " atacou!"
                + RESET
            );

            System.out.println(
                "  Dano causado: "
                + AMARELO + danoPlayer + RESET
            );


            // ==================== MONSTRO MORRE ====================

            if (vidaAtualMonstro <= 0) {

                vidaAtualMonstro = 0;

                monstro.vida = 0;

                System.out.println();

                System.out.println(
                    VERDE + "  ✓ " + monstro.nome
                    + " foi derrotado!"
                    + RESET
                );

                System.out.println(
                    "  Vida: "
                    + VERMELHO + "0 HP" + RESET
                );


                // Remove o monstro da lista
                monstersArray.remove(monstro);


                // Cura do player
                vidaAtualplayer =
                    vidaAtualplayer + 10;

                player.vida =
                    vidaAtualplayer;

                System.out.println();

                System.out.println(
                    VERDE + "  ♥ " + player.nome
                    + " recuperou 10 HP!"
                    + RESET
                );

                System.out.println(
                    "  Vida atual: "
                    + VERDE + vidaAtualplayer
                    + " HP"
                    + RESET
                );

                return true;
            }


            // ==================== VIDA DO MONSTRO ====================

            System.out.println(
                "  " + monstro.nome
                + ": "
                + VERMELHO + vidaAtualMonstro
                + " HP"
                + RESET
            );


            // ==================== CONTRA-ATAQUE ====================

            vidaAtualplayer =
                vidaAtualplayer - danoMonstro;

            System.out.println();

            System.out.println(
                VERMELHO + "  ⚔ "
                + monstro.nome
                + " contra-atacou!"
                + RESET
            );

            System.out.println(
                "  Dano causado: "
                + AMARELO + danoMonstro + RESET
            );

            System.out.println(
                "  " + player.nome
                + ": "
                + VERDE + vidaAtualplayer
                + " HP"
                + RESET
            );


            // ==================== PLAYER MORRE ====================

            if (vidaAtualplayer <= 0) {

                vidaAtualplayer = 0;

                player.vida = 0;

                System.out.println();

                System.out.println(
                    VERMELHO + NEGRITO
                    + "  ☠ " + player.nome
                    + " morreu!"
                    + RESET
                );

                return false;
            }


            monstro.vida =
                vidaAtualMonstro;

            player.vida =
                vidaAtualplayer;
        }

        return true;
    }


    // ============================================================
    // LISTAR PLAYERS
    // ============================================================

    public static void listaPlayers(
        ArrayList<Player> lista
    ) {

        System.out.println();

        System.out.println(
            CIANO + "──────────── PLAYERS ────────────"
            + RESET
        );

        for (int i = 0; i < lista.size(); i++) {

            Player player = lista.get(i);

            System.out.println(
                String.format(
                    "  [%d] %-15s %d HP",
                    i + 1,
                    player.nome,
                    player.vida
                )
            );
        }

        System.out.println(
            CIANO + "────────────────────────────────"
            + RESET
        );
    }


    // ============================================================
    // PAUSA
    // ============================================================

    public static void pausa(Scanner teclado) {

        System.out.println();

        System.out.print(
            CIANO + "  Pressione ENTER para continuar..."
            + RESET
        );

        teclado.nextLine();
    }
}