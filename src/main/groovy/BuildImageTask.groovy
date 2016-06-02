import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import com.spotify.docker.client.ProgressHandler
import com.spotify.docker.client.exceptions.DockerException
import com.spotify.docker.client.messages.ProgressMessage
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Paths

import static java.lang.String.*

class BuildImageTask extends DefaultTask {
    final DockerClient docker = DefaultDockerClient.fromEnv().build()

    String dockerfilePath = null

    ProgressHandler progressHandler = new ProgressHandler() {
        @Override
        public void progress(ProgressMessage message) throws DockerException {
            if (message.stream()) {
                print message.stream()
            }
        }
    }

    @TaskAction
    String dockerBuild() {
        String version = project.docker.imgVersion ?: (project.version ?: null)
        String registry = project.docker.registry ?: ''
        String imgName = project.docker.imgName ?: this.project.name
        if (dockerfilePath) {
            docker.build(Paths.get(dockerfilePath), imgName, progressHandler)
        } else {
            new File("${project.buildDir.canonicalPath}/Dockerfile").text = project.dockerfile.toString()
            docker.build(Paths.get("${project.buildDir.path}/."), imgName, progressHandler)
        }
        def repository = registry ? join('/', registry, imgName) : imgName
        //tag once with tagVersion as latest
        docker.tag(imgName, "$repository:latest")
        if (version) {
            docker.tag(imgName, "$repository:$version")
        }
    }
}
