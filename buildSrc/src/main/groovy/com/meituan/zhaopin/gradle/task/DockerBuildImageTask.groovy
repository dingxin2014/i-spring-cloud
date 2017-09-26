package com.meituan.zhaopin.gradle.task

import com.meituan.zhaopin.gradle.AbstractTask
import com.meituan.zhaopin.gradle.PluginUtil
import org.gradle.api.tasks.TaskAction

class DockerBuildImageTask extends AbstractTask {

    @Override
    String name() {
        return "build"
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
        return 1
    }

    @Override
    @TaskAction
    void run() {
        def cmd_before = "cd ${project.projectDir}"
        def cmd = "docker build -t zhaopin/${project.name}:${project.version} -f src/main/docker/Dockerfile --build-arg JAR=${project.name} ."
        def cmd_after = "cd .."
        PluginUtil.executeCmd(project, cmd_before)
        PluginUtil.executeCmd(project, cmd)
        PluginUtil.executeCmd(project, cmd_after)
    }
}
