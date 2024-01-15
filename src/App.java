public class App {
    public static void main(String[] args) throws Exception {
        int[] listaNumeros = new int[] { 100, 110, 50, 80, 10, 11, 15, 8, 9 };

        mergeSort(listaNumeros, 0, listaNumeros.length - 1);

        for (int i = 0; i < listaNumeros.length; i++)
            System.out.println(listaNumeros[i]);
    }

    private static void merge(int arrayDesordenado[], int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int metadeEsquerda[] = new int[n1];
        int metadeDireita[] = new int[n2];

        for (int i = 0; i < n1; i++)
            metadeEsquerda[i] = arrayDesordenado[inicio + i];

        for (int i = 0; i < n2; i++)
            metadeDireita[i] = arrayDesordenado[meio + 1 + i];

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (metadeEsquerda[i] <= metadeDireita[j])
                arrayDesordenado[k] = metadeEsquerda[i++];
            else
                arrayDesordenado[k] = metadeDireita[j++];

            k++;
        }

        while (i < n1)
            arrayDesordenado[k++] = metadeEsquerda[i++];

        while (j < n2)
            arrayDesordenado[k++] = metadeDireita[j++];
    }

    private static void mergeSort(int arrayDesordenado[], int indiceInicial, int indiceFinal) {
        int metadeEsquerda = ((indiceInicial + indiceFinal) / 2);
        int metadeDireita = (indiceInicial + indiceFinal / 2) + 1;

        if (indiceInicial >= indiceFinal)
            return;

        mergeSort(arrayDesordenado, indiceInicial, metadeEsquerda);
        mergeSort(arrayDesordenado, metadeDireita, indiceFinal);
        merge(arrayDesordenado, indiceInicial, metadeEsquerda, indiceFinal);
    }
}