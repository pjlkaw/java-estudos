import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

import java.util.ArrayList; 

public class game {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Player> playersArray = new ArrayList<>(); 

        Player player = new Player();
        while (true) {
    
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
            
            if (nome.isEmpty()) {
                System.out.print("Cancelando.. ");
                break;
            }
        }

        teclado.close();
    }
}