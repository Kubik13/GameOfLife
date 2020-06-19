package life;

import java.util.Random;

public class Main {
    private static Universe universe;
    private static GameOfLife gol;
    private static boolean pause = false;
    private static int N;

    public static void setPause(boolean pause) {
        Main.pause = pause;
    }

    public static void main(String[] args) throws InterruptedException {
        int N = 50; // размер universe
        long seed = (new Random()).nextInt(100000);

        universe = new Universe(N,seed);
        gol = new GameOfLife();

        play();
    }

    public static void play() throws InterruptedException {
        int i =1;
        while (!pause){
            Generation.next(universe);
            gol.setUniverse(universe);
            gol.repaint();
            gol.aliveLabel.setText("   Alive: " + universe.getAlive());
            gol.generationLabel.setText("   Generation #" + i);
            Thread.sleep(100);
            i++;
        }
    }

    public static void reset(){
    }
}
