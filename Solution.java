package com.lukasz;

import java.util.List;

public class Solution {
    private List<String> lines;
    private Position currentPosition;
    private Direction direction;
    private String letters;
    private int steps;

    public Solution(List<String> lines) {
        this.lines = lines;

        start();
    }

    private void start() {

        int col = lines.get(0).indexOf('|');
        currentPosition = new Position(0, col);
        direction = new Direction(1, 0);

        while (true) {
            steps++;
            currentPosition.go(direction);

            char road = currentPosition.road();
            if(road == ' ') {
                letters = direction.getLetters();
                break;
            }

            direction.nextStep(road);
        }
    }

    public String getLetters() {
        return letters;
    }

    public int getSteps() {
        return steps;
    }

    class Position {
        private int row;
        private int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public char road() {
            String line = lines.get(row);
            return line.charAt(col);
        }

        public Position go(Direction direction) {
            row += direction.getRow();
            col += direction.getCol();

            return this;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    class Direction {
        private int row;
        private int col;
        private StringBuilder sb;

        public Direction(int row, int col) {
            this.row = row;
            this.col = col;
            this.sb = new StringBuilder();
        }

        public void nextStep(char road) {
            if(road > 54 && road < 91) {
                sb.append(road);
                return;
            }
            if(row == 1 || row == -1) {
                if(road == '+') {
                    this.row = 0;
                    char roadAtRight;
                    try {
                        roadAtRight = lines.get(currentPosition.getRow()).charAt(currentPosition.getCol() + 1);
                    }catch (IndexOutOfBoundsException e) {
                        roadAtRight = ' ';
                    }
                    if( roadAtRight == ' ') {
                        this.col = -1;
                    }else {
                        this.col = 1;
                    }
                    return;
                }
            }
            if(col == 1 || col == -1) {
                if(road == '+') {
                    this.col = 0;
                    char roadAtBottom;
                    try {
                        roadAtBottom = lines.get(currentPosition.getRow() + 1).charAt(currentPosition.getCol());
                    }catch (IndexOutOfBoundsException e) {
                        roadAtBottom = ' ';
                    }
                    if(roadAtBottom == ' ') {
                        this.row = -1;
                    }else {
                        this.row = 1;
                    }
                    return;
                }
            }
        }

        public String getLetters() {
            return sb.toString();
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
