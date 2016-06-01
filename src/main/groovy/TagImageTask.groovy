import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class TagImageTask extends DefaultTask {

    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    String imgName = this.project.name
    String[] tags = []
    String repo = ''

    @TaskAction
    String dockerTag() {
        tags.each {
            docker.tag(imgName, "$repo/$it")
        }
    }
}
