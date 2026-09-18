import java.util.Scanner;
public class game {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        while (true) {
    
            Player player = new Player();
            player.vida = 100;
    
            System.out.print("Nome do player: ");
            String nome = teclado.nextLine();
            
            player.nome = nome;
            
            if (!nome.isEmpty()) {
                System.out.println("\nPlayer Criado!");
                System.out.println(String.format("bem vindo, %s", player.nome));
                System.out.println(String.format("STATS \n Vida: %d Estado: %s",player.vida, player.nome));
            }
            
            if (nome.isEmpty()) {
                System.out.print("Cancelando.. ");
                break;
            }
        }


        teclado.close();
    }
}