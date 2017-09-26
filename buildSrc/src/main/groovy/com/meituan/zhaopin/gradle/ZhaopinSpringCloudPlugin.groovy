package com.meituan.zhaopin.gradle

import com.meituan.zhaopin.gradle.task.DockerRepositoryLoginTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class ZhaopinSpringCloudPlugin implements Plugin<Project> {

    @Override
    void apply(Project rootProject) {
        println("ZhaopinSpringCloudPlugin execute")

        rootProject.extensions.create("docker", DockerExtension)

        def subProjects = rootProject.getChildProjects()
        subProjects.remove("zhaopin-build-src")

        rootProject.task("login", type: DockerRepositoryLoginTask)
    }

    private List<Task> loadTasks() {
        ServiceLoader<Task> serviceLoader = ServiceLoader.load(Task.class);
        List<Task> tasks = serviceLoader.sort(false, new Comparator<Task>() {
            @Override
            int compare(Task o1, Task o2) {
                return o1.order() - o2.order()
            }
        })
        return tasks
    }
}