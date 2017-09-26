package com.meituan.zhaopin.gradle

interface Task {

    /**
     * task name
     * @return
     */
    String name();

    /**
     * enable execute
     * @return
     */
    boolean isEnable();

    /**
     * depend task
     * @return
     */
    String[] dependsOn();

    /**
     * execute order
     * min value means high priority
     * @return
     */
    int order();

    /**
     * task content
     * @param project
     */
    void run();

}