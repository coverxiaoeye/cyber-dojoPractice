package com.coverxiaoeye.cyberdojo._19quiz;

import java.util.*;
public class InterceptTask {
    private List<Integer> missiles = null;
    private int usedInterceptorNum = 0;
    private int currentInterceptorRange;

    public InterceptTask(List<Integer> missiles) {
        this.missiles = missiles;
    }

    public int getInterceptorNum(){
        return usedInterceptorNum;
    }

    public void executeIntercept(){
        while (!missiles.isEmpty()) {
            deployNewInterceptor();
            for (Iterator<Integer> iterator = missiles.iterator(); iterator.hasNext(); ) {
                int missileHeight = iterator.next();
                if (canIntercept(missileHeight)) {
                    iterator.remove();
                    currentInterceptorRange = missileHeight;
                }
            }
        }
    }

    private void deployNewInterceptor() {
        currentInterceptorRange = Integer.MAX_VALUE;
        usedInterceptorNum++;
    }

    private boolean canIntercept(int missileHeight) {
        return missileHeight <= currentInterceptorRange;
    }
}
