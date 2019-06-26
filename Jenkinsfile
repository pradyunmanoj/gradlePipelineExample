
    final String build_name = 'PradyunManoj_gradlePipelineExample'

    pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    tools {
        jdk 'JAVA_HOME'
    }

    stages {
        stage('Initiation') {
            steps {
                script {
                    echo 'Update build name.'
                    currentBuild.displayName = "#${currentBuild.number}: $build_name"
                }
            }
        }

        stage('Artifactory Configuration') {
            steps {
                rtServer (
                    id: "ARTIFACTORY_SERVER",
                    url: "https://cernerrepos.net/"
                )

                rtGradleDeployer (
                    id: "GRADLE_DEPLOYER",
                    serverId: "ARTIFACTORY_SERVER",
                    repo: "maven-snapshot",
                    excludePatterns: ["*.war"],
                )

            }
        }

        stage('Config build Info') {
            steps {
                rtBuildInfo (
                    captureEnv: true,
                    buildName: "${build_name}",
                    buildNumber: "${currentBuild.number}"
                )
            }
        }


        stage('Publish Build Info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "ARTIFACTORY_SERVER",
                    buildName: "${build_name}",
                    buildNumber: "${currentBuild.number}"
                )
            }
        }
    }
}