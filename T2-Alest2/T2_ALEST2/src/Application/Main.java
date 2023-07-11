package Application;

public class Main {
    public static void main(String [] args){

        //inserir como parametro a string do caminho dos mapas teste e apague conforme queira demonstrar X numero de respostas

        int resposta = 0;
        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa30.txt");
        System.out.println("Total de combustivel gasto no mapa 30: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapateste-80.txt");
        System.out.println("Total de combustivel gasto no mapa 80: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa120.txt");
        System.out.println("Total de combustivel gasto no mapa 120: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa150.txt");
        System.out.println("Total de combustivel gasto no mapa 150: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa200.txt");
        System.out.println("Total de combustivel gasto no mapa 200: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa300.txt");
        System.out.println("Total de combustivel gasto no mapa 300: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa400.txt");
        System.out.println("Total de combustivel gasto no mapa 400: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa426.txt");
        System.out.println("Total de combustivel gasto no mapa 426: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa500.txt");
        System.out.println("Total de combustivel gasto no mapa 500: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa800.txt");
        System.out.println("Total de combustivel gasto no mapa 800: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa1000.txt");
        System.out.println("Total de combustivel gasto no mapa 1000: " + resposta);

        resposta = ShortestPathFinder.calculaCombustivel("T2_ALEST2/src/Application/Testes/mapa2000.txt");
        System.out.println("Total de combustivel gasto no mapa 2000: " + resposta);
    }
}