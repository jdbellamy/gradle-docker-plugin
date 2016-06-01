import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Paths

class BuildImageTask extends DefaultTask {
    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    String dockerfilePath = "${this.project.projectDir}/."
    String imgName = this.project.name
    String dockerfile = null

    @TaskAction
    String dockerBuild() {
        if (dockerfile) {
            new File("${project.buildDir.canonicalPath}/Dockerfile").text = dockerfile
            docker.build(Paths.get("${project.buildDir.path}/."), imgName)
        } else {
            docker.build(Paths.get(dockerfilePath), imgName)
        }
    }
}
