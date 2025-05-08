import java.io.File;
import java.util.Arrays;
import dotenv.config;

public class OrdenaImagens {
    public static void main(String[] args) {
        File pasta = new File(dotenv.get(path_file));

        File[] imagens = pasta.listFiles((dir, nome) ->
                nome.toLowerCase().endsWith(".jpg") || nome.toLowerCase().endsWith(".jpeg") || nome.toLowerCase().endsWith(".png")
        );


        if (imagens != null) {
            long inicio = System.nanoTime();

            Arrays.sort(imagens, (f1, f2) -> Long.compare(f1.length(), f2.length()));

            long fim = System.nanoTime();
            long duracaoMs = (fim - inicio) / 1_000_000;

            for (File imagem : imagens) {
                System.out.println(imagem.getName());
                System.out.println(imagem.length());
            }
            // Exibe resultado
            System.out.println("Tempo de ordenação: " + duracaoMs + " ms");
        } else {
            System.out.println("A pasta está vazia ou não existe.");

        }
    }
}