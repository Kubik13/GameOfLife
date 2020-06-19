package life;

public class Generation {

    public static void next (Universe universe){
        int N = universe.getMap().length;
        String[][] nextMap = new String[N][N];
        for (int y = 0; y<N; y++){
            for (int x = 0; x<N; x++){
                if (universe.getMap()[y][x].equals("O")){
                    if (checkNeighbors(universe.getMap(),x,y) == 3) nextMap[y][x] = "O";
                    else if (checkNeighbors(universe.getMap(),x,y) == 2) nextMap[y][x] = "O";
                    else {
                        nextMap[y][x] = " ";
                        universe.decAlive();
                    }
                }
                else if (universe.getMap()[y][x].equals(" ")){
                    if (checkNeighbors(universe.getMap(),x,y) == 3) {
                        nextMap[y][x] = "O";
                        universe.incAlive();
                    }
                    else nextMap[y][x] = " ";
                }
            }
        }

        universe.setMap(nextMap);
    }

    private static int checkNeighbors(String[][] map, int x, int y){
        int neighbors = 0;
        int N = map.length;
        int xPlus,xMinus,yPlus,yMinus;
        
        if (x == N-1) {xPlus = 0; xMinus = x-1;}
        else if (x == 0) {xPlus = x+1; xMinus = N-1;}
        else {xPlus = x+1; xMinus = x-1;}

        if (y == N-1) {yPlus = 0; yMinus = y-1;}
        else if (y == 0) {yPlus = y+1; yMinus = N-1;}
        else {yPlus = y+1; yMinus = y-1;}
        
        
            if (map[y][xMinus].equals("O")) neighbors++;
            if (map[y][xPlus].equals("O")) neighbors++;
            if (map[yPlus][xMinus].equals("O")) neighbors++;
            if (map[yPlus][xPlus].equals("O")) neighbors++;
            if (map[yMinus][xMinus].equals("O")) neighbors++;
            if (map[yMinus][xPlus].equals("O")) neighbors++;
            if (map[yMinus][x].equals("O")) neighbors++;
            if (map[yPlus][x].equals("O")) neighbors++;

        return neighbors;
    }
}
