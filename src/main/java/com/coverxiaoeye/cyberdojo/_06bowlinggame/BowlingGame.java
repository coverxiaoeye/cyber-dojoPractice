package com.coverxiaoeye.cyberdojo._06bowlinggame;

public class BowlingGame {

    public static int score(String input) {
        if (input == null || "".equals(input)) return 0;
        // process input string
        String[] frames = processInputString(input);
        //calc scores
        int resultScore = 0;
        for (int i = 0; i < 10; i++) {
            int frameScore = 0;
            String frame = frames[i];
            if (frame.endsWith("X")) {
                int extraScore = getNextTwoBallScore(frames, i);
                //calc framescore
                frameScore = 10 + extraScore;
            } else if (frame.endsWith("/")) {
                int extraScore = getNextBallScore(frames, i);
                //calc framescore
                frameScore = 10 + extraScore;
            } else {
                frameScore = getBallScore(frames[i].substring(0, 1))
                        + getBallScore(frames[i].substring(1, 2));
            }
            resultScore = resultScore + frameScore;
        }
        return resultScore;
    }

    private static String[] processInputString(String input) {
        String[] inputs = input.split("\\|\\|");
        String[] originframes = inputs[0].split("\\|");
        String[] frames;
        if (inputs.length > 1) {
            // if have bonus ball,create array with 11 elements
            frames = new String[11];
            System.arraycopy(originframes, 0, frames, 0, originframes.length);
            frames[10] = inputs[1];
        } else {
            frames = originframes;
        }
        return frames;
    }
    //calc single ball score
    private static int getBallScore(String ball) {
        if ("X".equals(ball)) return 10;
        if ("-".equals(ball)) return 0;
        return Integer.parseInt(ball);
    }
    //calc the next two ball score
    private static int getNextTwoBallScore(String[] frames, int i) {
        //get the next two ball
        String ball1 = frames[i + 1].substring(0, 1);
        int len = frames[i + 1].length();
        String ball2 = "";
        if (len < 2) {
            ball2 = frames[i + 2].substring(0, 1);
        } else {
            ball2 = frames[i + 1].substring(1, 2);
        }
        if ("/".equals(ball2)) return 10;
        return getBallScore(ball1) + getBallScore(ball2);
    }
    //calc the next ball score
    private static int getNextBallScore(String[] frames, int i) {
        String nextball = frames[i + 1].substring(0, 1);
        return getBallScore(nextball);
    }
}
