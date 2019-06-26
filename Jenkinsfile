
    final String build_name = 'PradyunManoj_gradlePipelineExample'
    final String ARTIFACTORY_SERVER_ID = 'cernerrepos-manyata-corp'
    final String ARTIFACTORY_URL = 'https://cernerrepos.net'

    pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    tools {
        jdk 'JAVA_HOME'
        gradle 'GRADLE_HOME'
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
                    id: "${ARTIFACTORY_SERVER_ID}",
                    url: "${ARTIFACTORY_URL}",
                    bypassProxy: true
                )

                rtGradleDeployer (
                    id: "GRADLE_DEPLOYER",
                    serverId: "${ARTIFACTORY_SERVER_ID}",
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

        stage('Execute Gradle') {
            steps {
                rtGradleRun (
                    deployerId: "GRADLE_DEPLOYER",
                    usesPlugin: true,
                    useWrapper: true,
                    buildFile: 'build.gradle',
                    tasks: 'clean build',
                    buildName: "${build_name}",
                    buildNumber: "${currentBuild.number}"
                )
            }
        }

        stage('Publish Build Info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "${ARTIFACTORY_SERVER_ID}",
                    buildName: "${build_name}",
                    buildNumber: "${currentBuild.number}"
                )
            }
        }
    }
}