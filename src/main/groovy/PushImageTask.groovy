import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PushImageTask extends DefaultTask {
    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    String imgName = this.project.name


    @TaskAction
    String dockerPush() {
        docker.push(imgName)
    }
}
