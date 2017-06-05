package com.coverxiaoeye.cyberdojo._19quiz;

import java.util.*;

public class MissileIntercept {
    private static final int END_OF_INPUT = -1;
    private static final String DELIMITER_OF_OUTPUT 
                            = System.getProperty("line.separator");
    private List<InterceptTask> interceptTasks = new ArrayList<>();

    public MissileIntercept(String input){
        try(Scanner scanner = new Scanner(input)) {
            initInterceptTasks(scanner);
        }
    }

    public static String getMinInterceptorNum(String input){
        if("".equals(input)) return "0";
        MissileIntercept missileIntercept 
                    = new MissileIntercept(input);
        missileIntercept.runInterceptTasks();
        return missileIntercept.gatherInterceptorNumOfTasks();
    }

    private void initInterceptTasks(Scanner scanner) {
        while(scanner.hasNextInt()) {
            int missileNum = scanner.nextInt();
            if(missileNum == END_OF_INPUT) break;
            checkValidity(missileNum);
            List<Integer> missiles = new LinkedList<>();
            for (int i = 0; i < missileNum; i++) {
                missiles.add(scanner.nextInt());
            }
            interceptTasks.add(new InterceptTask(missiles));
        }
    }

    private void runInterceptTasks(){
        for (InterceptTask task:interceptTasks){ 
            task.executeIntercept();
        }
    }

    private String gatherInterceptorNumOfTasks() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER_OF_OUTPUT);
        for (InterceptTask task:interceptTasks) 
            stringJoiner.add(String.valueOf(task.getInterceptorNum()));
        return stringJoiner.toString();
    }

    private static void checkValidity(int missileNum){
        if(missileNum<=0||missileNum>3000) 
            throw new IllegalArgumentException("input missile number is illegal!");
    }
}
