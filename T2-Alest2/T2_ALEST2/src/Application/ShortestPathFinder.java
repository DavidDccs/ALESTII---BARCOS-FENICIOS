package Application;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShortestPathFinder {
    public static int operations = 0;
    public static int vertices = 0;
    private static class Bloco  {
        int x; // coord x
        int y; // coord y
        int dist;  	//distancia
        ShortestPathFinder.Bloco prev;  //bloco pai -> de onde veio
        Bloco(int x, int y, int dist, ShortestPathFinder.Bloco prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }
    }

    public static boolean shortestPath(int[][] matrix, int[] start, int[] end, int iteration) {
        int sx = start[0], sy = start[1];
        int ex = end[0], ey = end[1];
        //caso o resultado inicial ou resultado final seja agua retorna falso
        if (matrix[sx][sy] == 0 || matrix[ex][ey] == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        //inicializa o mapa
        ShortestPathFinder.Bloco[][] mapa = new ShortestPathFinder.Bloco[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1 || matrix[i][j] == matrix[sx][sy] || matrix[i][j] == matrix[ex][ey]) {
                    mapa[i][j] = new ShortestPathFinder.Bloco(i, j, Integer.MAX_VALUE, null);
                }
            }
        }

        //breadth first search

        LinkedList<ShortestPathFinder.Bloco> queue = new LinkedList<>();
        ShortestPathFinder.Bloco inicio = mapa[sx][sy];
        inicio.dist = 0;
        queue.add(inicio);
        ShortestPathFinder.Bloco dest = null;
        ShortestPathFinder.Bloco aux;
        while ((aux = queue.poll()) != null) {
            //find destination
            if (aux.x == ex && aux.y == ey) {
                dest = aux;
                break;
            }

            // pra cima
            visit(mapa, queue, aux.x - 1, aux.y, aux);
            // pra baixo
            visit(mapa, queue, aux.x + 1, aux.y, aux);
            // esquerda
            visit(mapa, queue, aux.x, aux.y - 1, aux);
            // direita
            visit(mapa, queue, aux.x, aux.y + 1, aux);
        }

        //coloca o caminho total
        if (dest == null) {
            return false;
        } else {
            LinkedList<ShortestPathFinder.Bloco> caminhoTotal = new LinkedList<>();
            aux = dest;
            do {
                caminhoTotal.addFirst(aux);
            } while ((aux = aux.prev) != null);
            MapHandler.disttotal = MapHandler.disttotal + caminhoTotal.size()-1;
        }
        return true;
    }

    private static void visit(ShortestPathFinder.Bloco[][] mapa, LinkedList<ShortestPathFinder.Bloco> queue, int x, int y, ShortestPathFinder.Bloco parent) {
        //coordenada negativa impossivel ; caso seja maior que os limites do mapa
        if (x < 0 || x >= mapa.length || y < 0 || y >= mapa[0].length || mapa[x][y] == null) {
            return;
        }
        //aumenta conforme a distancia do bloco inicial
        int dist = parent.dist + 1;
        ShortestPathFinder.Bloco blocoVisitado = mapa[x][y];
        if (dist < blocoVisitado.dist) {
            blocoVisitado.dist = dist;
            blocoVisitado.prev = parent;
            queue.add(blocoVisitado);
        }
    }

    public static int calculaCombustivel(String mapaFile) {
        MapHandler.disttotal = 0;
        int[][] matrix = MatrixCreator.creator(mapaFile);
        int portoFinal=1;
        int portoAtual=1;
        ArrayList<Integer> portoQueNaoRola = new ArrayList<Integer>();
        for(int i = 1; i<9; i++) {
            if(portoQueNaoRola.contains(portoAtual)){ portoAtual = portoQueNaoRola.get(portoQueNaoRola.size()-1) +1;}
            int[] start = MapHandler.getPortoCoord(portoAtual);
            int[] end = MapHandler.getPortoCoord(i+1);
            if(shortestPath(matrix, start, end, i)){portoFinal= i+1; portoAtual = portoAtual + 1;} else {portoQueNaoRola.add(i+1);}
        }
        int[] start = MapHandler.getPortoCoord(portoFinal);
        int[] end = MapHandler.getPortoCoord(1);
        shortestPath(matrix, start, end, 11);
        return MapHandler.disttotal;
    }
}
