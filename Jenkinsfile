pipeline {
    agent 
    {dockerfile true }

    stages {
        stage('Build') {
            steps {
                echo "Compiling..."
                sh "sbt compile"
            }
        }
        stage('Unit Test') {
            steps {
                echo "Testing..."
                sh "sbt test"
               // sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt coverageReport"
               // sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt scalastyle || true"
            }
        }
        stage('Docker Publish') {
            steps {
                // Generate Jenkinsfile and prepare the artifact files.
                sh "sbt docker:stage"

                // Run the Docker tool to build the image
                script {
                    docker.withTool('docker') {
                        docker.build('my-app:latest', 'target/docker/stage')
                    }
                }
            }
        }
    }
}
