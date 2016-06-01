

import org.gradle.api.Project
import org.gradle.api.Plugin

class DockerPlugin implements Plugin<Project> {

    void apply(Project target) {
        target.task('dockerPs', type: ListContainersTask)
        target.task('dockerBuild', type: BuildImageTask)
        target.task('dockerTag', type: TagImageTask)
        target.task('dockerPush', type: PushImageTask)
    }
}
