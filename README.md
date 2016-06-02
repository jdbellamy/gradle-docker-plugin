Docker Plugin
=============

A gradle plugin for managing docker images and containers

## Configuration

The `docker` closure is a plugin extension used to encapsulate general configuration for the various tasks.
It currently supports the following fields:
- __*imgName*__: a name for the image
- __*imgVersion*__: a tag version for the image
- __*registry*__: a registry to push images to
>>>>>>> 4124d09ecad3c85e08eb8ada2379d18331ba9ed6

```groovy
docker {
    registry = 'io.docker'
    imgName = 'myImage'
    imgVersion = '1.0.0-SNAPSHOT'
}
```

## Tasks

#### dockerBuild
Build an image from an existing Dockerfile or a provided `dockerfile` configuration
It currently supports a field, `dockerfilePath`, for providing the location of an existing dockerfile.

```groovy
dockerBuild {
    dockerfilePath = 'docker/.'
}
```

In liu of providing an existing Dockerfile, a `dockerfile` configuration can be provided.

```groovy
dockerfile {
    from(image:'alpine', version:'latest')
    maintainer('jdbellamy@me.com')
    add(source:"libs/${project.name}-${project.version}.jar", target:'app.jar')
    entrypoint(['/bin/sh'])
}
```

#### dockerPs
List containers

#### dockerPush
Push an image or a repository to a registry

#### dockerTag
Tag an image into a repository
