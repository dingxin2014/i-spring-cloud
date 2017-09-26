package com.meituan.zhaopin.gradle.task

import com.meituan.zhaopin.gradle.AbstractTask
import com.meituan.zhaopin.gradle.PluginUtil
import org.gradle.api.tasks.TaskAction

class DockerPushTask extends AbstractTask {

    @Override
    String name() {
        return "push"
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
        return 10
    }

    @Override
    @TaskAction
    void run() {
        println('[Docker Push]')

        def imageName = project.name
        def imageTag = project.version
        def repository = project.docker_repository

        def pushCmd = "docker push ${repository}/meituan/zhaopin/${imageName}:${imageTag}"

        PluginUtil.executeCmd(project, pushCmd)
    }
}
