package Application;

public class MapHandler {
    public static int[] porto1 = {-1,-1};
    public static int[] porto2 = {-1,-1};
    public static int[] porto3 = {-1,-1};
    public static int[] porto4 = {-1,-1};
    public static int[] porto5 = {-1,-1};
    public static int[] porto6 = {-1,-1};
    public static int[] porto7 = {-1,-1};
    public static int[] porto8 = {-1,-1};
    public static int[] porto9 = {-1,-1};

    public static int disttotal = 0;

    public static void assignPorto(int numeroPorto, int x, int y){
        if(numeroPorto == 1){porto1 = new int[]{x,y};}
        if(numeroPorto == 2){porto2 = new int[]{x,y};}
        if(numeroPorto == 3){porto3 = new int[]{x,y};}
        if(numeroPorto == 4){porto4 = new int[]{x,y};}
        if(numeroPorto == 5){porto5 = new int[]{x,y};}
        if(numeroPorto == 6){porto6 = new int[]{x,y};}
        if(numeroPorto == 7){porto7 = new int[]{x,y};}
        if(numeroPorto == 8){porto8 = new int[]{x,y};}
        if(numeroPorto == 9){porto9 = new int[]{x,y};}
    }

    public static int[] getPortoCoord(int numeroPorto){
        switch(numeroPorto){
            case 1: return porto1;
            case 2: return porto2;
            case 3: return porto3;
            case 4: return porto4;
            case 5: return porto5;
            case 6: return porto6;
            case 7: return porto7;
            case 8: return porto8;
            default: return porto9;
        }
    }

}
