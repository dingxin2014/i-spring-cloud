package com.meituan.zhaopin.gradle.task

import com.meituan.zhaopin.gradle.AbstractTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

class DockerRepositoryLoginTask extends AbstractTask {

    @Override
    String name() {
        return "login"
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
        return 0
    }

    @Override
    @TaskAction
    void run() {
        def username = project.docker.username;
        def password = project.docker.password;
        def repository = project.docker.repository

        def cmd = "docker login ${repository} -u ${username} -p ${password}"
        println("Executing: ${cmd}")

        def p = cmd.execute()
        p.waitFor()

        if (p.exitValue() != 0) {
            throw new GradleException("Command: '${cmd}' failed. Reason: '${stderr}'.")
        }
    }


}
