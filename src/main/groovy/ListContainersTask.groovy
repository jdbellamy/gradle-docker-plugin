import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import static com.spotify.docker.client.DockerClient.ListContainersParam.allContainers

class ListContainersTask extends DefaultTask {
    final DockerClient docker = DefaultDockerClient.fromEnv().build();

    Boolean listAll = true

    @TaskAction
    String DockerPs() {
        if (listAll) {
            println docker.listContainers(allContainers())
        } else {
            println docker.listContainers()
        }
    }
}
