public class senha {
    public static void main(String[] args) {

        int senha = 9999;

        for (int a=0; a<10; a++) {
            for (int b =0; b<10; b++){
                for (int c = 0; c<10; c++){
                    for (int d = 0; d<10; d++){
                        if (senha == a*1000 + b*100 + c*10 + d){
                            System.out.println("Senha encontrada: " + a + b + c + d);
                        }
                    }
                }
            }
        }
    }
}
