package life;

import java.util.Random;

public class Universe {
    private String[][] map;
    private int N;
    private int alive = 0;

    public int getAlive() {
        return alive;
    }

    public void incAlive() {
        alive++;
    }

    public void decAlive() {
        alive--;
    }

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    public Universe(int N, long seed) {
        this.N = N;
        map = new String[N][N];
        Random rnd = new Random(seed);

        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (rnd.nextBoolean()) {
                    map[j][i] = "O";
                    alive++;
                }
                else map[j][i] = " ";
            }
        }
    }

    public void printMap(){
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                System.out.print(map[j][i]);
            }
            System.out.println();
        }
    }
}
