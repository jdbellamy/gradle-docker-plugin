import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PushImageTask extends DefaultTask {
    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    @TaskAction
    String dockerPush() {
        String imgName = project.docker.imgName ?: this.project.name
        docker.push(imgName)
    }
}
