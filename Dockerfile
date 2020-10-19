script {
    docker.withTool('docker') {
        docker.build('my-app:latest', 'target/docker/stage')
    }
}
