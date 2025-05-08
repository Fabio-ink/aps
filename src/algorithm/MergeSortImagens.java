import java.io.File;

public class MergeSortImagens {

    public static void main(String[] args) {
        File pasta = new File("/home/fluxyfp/Downloads/PastaTeste");

        File[] imagens = pasta.listFiles((dir, nome) ->
                nome.toLowerCase().endsWith(".jpg") || nome.toLowerCase().endsWith(".jpeg") || nome.toLowerCase().endsWith(".png")
        );

        if (imagens != null && imagens.length > 0) {
            long inicio = System.nanoTime();

            mergeSort(imagens, 0, imagens.length - 1);

            long fim = System.nanoTime();
            long duracaoMs = (fim - inicio) / 1_000_000;
            System.out.println("Tempo de ordenação (MergeSort): " + duracaoMs + " ms");

            for (File imagem : imagens) {
                System.out.println(imagem.getName());
            }
        } else {
            System.out.println("A pasta está vazia ou não existe.");
        }
    }

    // Implementação do Merge Sort
    public static void mergeSort(File[] arquivos, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(arquivos, inicio, meio);
            mergeSort(arquivos, meio + 1, fim);
            merge(arquivos, inicio, meio, fim);
        }
    }

    // Combinação de duas metades ordenadas
    public static void merge(File[] arquivos, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        File[] esquerda = new File[n1];
        File[] direita = new File[n2];

        for (int i = 0; i < n1; i++)
            esquerda[i] = arquivos[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = arquivos[meio + 1 + j];
        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i].getName().compareToIgnoreCase(direita[j].getName()) <= 0) {
                arquivos[k] = esquerda[i];
                i++;
            } else {
                arquivos[k] = direita[j];
                j++;
            }
            k++;
        }

        // Copia o que sobrou
        while (i < n1) {
            arquivos[k] = esquerda[i];
            i++;
            k++;
        }
        while (j < n2) {
            arquivos[k] = direita[j];
            j++;
            k++;
        }
    }
}
