import java.io.File;

public class bubbleSort{

public bubbleSort(File[] arquivos) {
    int n = arquivos.length;
    boolean trocou;

    for (int i = 0; i < n - 1; i++) {
        trocou = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (arquivos[j].getName().compareToIgnoreCase(arquivos[j + 1].getName()) > 0) {
                // Troca os arquivos de posição
                File temp = arquivos[j];
                arquivos[j] = arquivos[j + 1];
                arquivos[j + 1] = temp;
                trocou = true;
            }
        }
        // Se não houve troca, a lista já está ordenada
        if (!trocou) break;
    }
}
}