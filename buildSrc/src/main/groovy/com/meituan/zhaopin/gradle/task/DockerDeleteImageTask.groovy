package com.meituan.zhaopin.gradle.task

import com.meituan.zhaopin.gradle.AbstractTask
import com.meituan.zhaopin.gradle.PluginUtil
import org.gradle.api.tasks.TaskAction

class DockerDeleteImageTask extends AbstractTask {


    @Override
    String name() {
        return "rmi"
    }

    @Override
    boolean isEnable() {
        return false
    }

    @Override
    String[] dependsOn() {
        return new String[0]
    }

    @Override
    int order() {
        return 99
    }

    @Override
    @TaskAction
    void run() {
        def cmd = "docker rmi zhaopin/${project.name}:${project.version}"
        PluginUtil.executeCmd(project, cmd)
        def cmd2 = "docker rmi ${project.docker_repository}/meituan/zhaopin/${project.name}:${project.version}"
        PluginUtil.executeCmd(project, cmd2)
    }
}
