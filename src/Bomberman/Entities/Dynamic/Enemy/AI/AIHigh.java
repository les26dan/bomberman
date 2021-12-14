package Bomberman.Entities.Dynamic.Enemy.AI;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Box.Grass;
import Bomberman.Entities.Box.Item.Item;
import Bomberman.Entities.Box.Wall;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.Enemy.Doria;
import Bomberman.Entities.Dynamic.Enemy.Enemy;
import Bomberman.Entities.Dynamic.Enemy.Ovape;
import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.GameContainer;

import java.util.ArrayList;

public class AIHigh extends AI {
    private Bomber bomber;
    private Enemy enemy;
    private int chasingRadius;
    private GameContainer gameContainer;
    public AIHigh(GameContainer gameContainer, Enemy enemy, int chasingRadius) {
        this.bomber = gameContainer.getBomber();
        this.enemy = enemy;
        this.chasingRadius = chasingRadius;
        this.gameContainer = gameContainer;
    }

    @Override
    public int calculateDirection() {
        if (enemy.getSteps() <= 0) {
            enemy.setSteps(Game.BOX_SIZE * 1.0 / enemy.getSpeed());
            double _steps = enemy.getSteps();
            enemy.setRes((_steps - (int) _steps) / _steps);
        }
        int direction = 0;
        int posX = enemy.posX();
        int posY = enemy.posY();
        int[][] d = new int[35][35];
        boolean[][] visit = new boolean[35][35];
        pii[][] trace = new pii[35][35];
        d[posX][posY] = 0;
        visit[posX][posY] = true;
        int top = 0;
        int bot = 1;
        ArrayList<pii> queue = new ArrayList<>();
        queue.add(new pii(posX, posY));
        top++;
        while (bot <= top) {
            pii u = queue.get(bot-1);
            bot++;
            int curX = u.getFirst();
            int curY = u.getSecond();
            if (check(curX + 1, curY) && !visit[curX+1][curY]) {
                d[curX+1][curY] = d[curX][curY] + 1;
                visit[curX+1][curY] = true;
                trace[curX+1][curY] = new pii(1, 0);
                top++;
                queue.add(new pii(curX + 1, curY));
            }
            if (check(curX - 1, curY) && !visit[curX-1][curY]) {
                d[curX-1][curY] = d[curX][curY] + 1;
                visit[curX-1][curY] = true;
                trace[curX-1][curY] = new pii(-1, 0);
                top++;
                queue.add(new pii(curX - 1, curY));
            }
            if (check(curX, curY + 1) && !visit[curX][curY+1]) {
                d[curX][curY+1] = d[curX][curY] + 1;
                visit[curX][curY+1] = true;
                trace[curX][curY+1] = new pii(0, 1);
                top++;
                queue.add(new pii(curX, curY+1));
            }
            if (check(curX, curY - 1) && !visit[curX][curY-1]) {
                d[curX][curY-1] = d[curX][curY] + 1;
                visit[curX][curY-1] = true;
                trace[curX][curY-1] = new pii(0, -1);
                top++;
                queue.add(new pii(curX, curY-1));
            }
        }
        int bX = bomber.posX();
        int bY = bomber.posY();
        if(visit[bX][bY] && d[bX][bY] <= chasingRadius) {
            int tempX = bX;
            int tempY = bY;
            while (tempX != posX || tempY != posY)
            {
                pii u = trace[tempX][tempY];
                tempX -= u.getFirst();
                tempY -= u.getSecond();
                if (tempX  == posX && tempY  == posY)
                    direction =  calculate(u.getFirst(), u.getSecond());
            }
        } else {
            AI ai = new AILow(enemy);
            direction =  ai.calculateDirection();
        }
        return direction;
    }

    int calculate(int X, int Y) {
        int res = 0;
        if(X == 1) res = 1;
        else if(X == -1) res = 3;
        else if(Y == 1) res = 2;
        else if(Y == -1) res = 0;
        return res;
    }
    boolean check(int curX, int curY) {
        if (curX < 0 || curX > 30) return false;
        if (curY < 0 || curY > 12) return false;
        Entity curEntity =  gameContainer.getEntity(curX, curY, bomber);
        if(enemy instanceof Doria || enemy instanceof Ovape) {
            return !(curEntity instanceof Wall
            || curEntity instanceof Bomb);
        }
        return  curEntity instanceof Grass
                || curEntity instanceof Item
                || curEntity instanceof Enemy;
    }

    public void setChasingRadius(int chasingRadius) {
        this.chasingRadius = chasingRadius;
    }
}

class pii {
    private int first;
    private int second;

    public pii(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

}
