import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class TagImageTask extends DefaultTask {

    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    String imgName

    String[] tags

    @TaskAction
    String dockerTag() {
        String name = (imgName ?: (project.docker.imgName ?: project.name))
        tags.each {
            docker.tag(name, it)
        }
    }
}
