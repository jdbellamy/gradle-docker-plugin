import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import com.spotify.docker.client.ProgressHandler
import com.spotify.docker.client.exceptions.DockerException
import com.spotify.docker.client.messages.ProgressMessage
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PushImageTask extends DefaultTask {
    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    ProgressHandler progressHandler = new ProgressHandler() {
        @Override
        public void progress(ProgressMessage message) throws DockerException {
            if (message.stream()) {
                print message.stream()
            }
        }
    }

    @TaskAction
    String dockerPush() {
        String imgName = project.docker.imgName ?: this.project.name
        docker.push("${project.docker.registry}/${imgName}", progressHandler)
    }
}
