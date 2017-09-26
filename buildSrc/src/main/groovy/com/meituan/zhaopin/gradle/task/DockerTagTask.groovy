package com.meituan.zhaopin.gradle.task

import com.meituan.zhaopin.gradle.AbstractTask
import com.meituan.zhaopin.gradle.PluginUtil
import org.gradle.api.tasks.TaskAction

class DockerTagTask extends AbstractTask {
    @Override
    String name() {
        return "tag"
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
        return 9
    }

    @Override
    @TaskAction
    void run() {
        println('[Docker Tag]')

        def imageName = project.name
        def imageTag = project.version
        def repository = project.docker_repository;

        def tagCmd = "docker tag zhaopin/${imageName}:${imageTag} ${repository}/meituan/zhaopin/${imageName}:${imageTag}"

        PluginUtil.executeCmd(project, tagCmd)
    }
}
