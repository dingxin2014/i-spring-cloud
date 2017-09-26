package com.meituan.zhaopin.gradle

import org.gradle.api.GradleException

class PluginUtil {

    static void executeCmd(project, def cmd) {
        println("Executing: ${cmd}")

        def stdout = new StringBuffer()
        def stderr = new StringBuffer()

        def p = cmd.execute()
        p.consumeProcessOutput(stdout, stderr)
        p.waitFor()

        project.getLogger().error("$stderr")
        project.getLogger().info("$stdout")

        if (p.exitValue() != 0) {
            throw new GradleException("Command: '${cmd}' failed. Reason: '${stderr}'.")
        }
    }

    static List<String> dockerBuildParameter(project) {
        List<String> arguments = new ArrayList<>()

        def dockerRepository = project.docker.dockerRepository ?: ''
        if (!dockerRepository.empty && !dockerRepository.endsWith('/')) dockerRepository = dockerRepository + '/'
        def imageName = project.docker.imageName ?: project.getName()
        def imageVersion = project.docker.imageVersion ?: "latest"

        arguments.add('build')
        if (project.docker.tags == null) {
            arguments.add('-t')
            arguments.add("${dockerRepository}${imageName}:${imageVersion}")
        }
        project.docker.tags.each {
            arguments.add('-t')
            arguments.add("${dockerRepository}${imageName}:${it}")
        }

        project.docker.labels.each {
            arguments.add("--label=${it}")
        }

        project.docker.buildArgs.each {
            arguments.add("--build-arg=${it}")
        }

        if (project.docker.isolation == null) {
            arguments.add("--isolation=default")
        }
        else {
            arguments.add("--isolation=${project.docker.isolation}")
        }

        arguments.add("--force-rm=${project.docker.removeIntermediateContainers}")
        arguments.add("--no-cache=${project.docker.noCache}")
        arguments.add("--quiet=${project.docker.quiet}")
        arguments.add("--pull=${project.docker.pull}")

        arguments.add('-f')
        arguments.add(dockerFile(project).getAbsolutePath())
        arguments.add(project.projectDir.getAbsolutePath())

        return arguments
    }

}
