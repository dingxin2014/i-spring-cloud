package com.meituan.zhaopin.gradle.task

import com.meituan.zhaopin.gradle.AbstractTask
import com.meituan.zhaopin.gradle.FileUtil
import org.gradle.api.tasks.TaskAction

class DockerfileMakeTask extends AbstractTask {

    @Override
    String name() {
        return "dockerfile"
    }

    @Override
    boolean isEnable() {
        return true
    }


    @Override
    String[] dependsOn() {
        return new String[0]
    }

    @Override
    int order() {
        return -10
    }

    @Override
    @TaskAction
    void run() {
        FileUtil.copy("Dockerfile", "${project.projectDir}/src/main/docker/Dockerfile")
    }
}
